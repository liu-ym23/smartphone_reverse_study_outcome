package kotlin.reflect.jvm.internal.impl.protobuf;

import androidx.collection.SieveCacheKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
class RopeByteString extends ByteString {
    private static final int[] minLengthByDepth = null;
    private int hash;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.RopeByteString$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static class Balancer {
        private final Stack<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new Stack();
        }

        public /* synthetic */ Balancer(AnonymousClass1 r100) {
            this();
        }

        private void doBalance(ByteString r100) {
            if (r100.isBalanced() == false) goto L6;
            insert(r100);
            return;
        L6:
            if ((r100 instanceof RopeByteString) == false) goto L9;
            RopeByteString r101 = (RopeByteString) r100;
            doBalance(RopeByteString.access$400(r101));
            doBalance(RopeByteString.access$500(r101));
            return;
        L9:
            String r102 = String.valueOf(r100.getClass());
            StringBuilder r103 = new StringBuilder(r102.length() + 49);
            r103.append("Has a new type of ByteString been created? Found ");
            r103.append(r102);
            throw new IllegalArgumentException(r103.toString());
        }

        private int getDepthBinForLength(int r100) {
            int r101 = Arrays.binarySearch(RopeByteString.access$600(), r100);
            if (r101 < 0) goto L5;
            return r101;
        L5:
            return (-(r101 + 1)) - 1;
        }

        private void insert(ByteString r100) {
            int r101 = getDepthBinForLength(r100.size());
            int r102 = RopeByteString.access$600()[r101 + 1];
            if (this.prefixesStack.isEmpty() == false) goto L5;
        L20:
            this.prefixesStack.push(r100);
            return;
        L5:
            if (this.prefixesStack.peek().size() >= r102) goto L20;
            int r103 = RopeByteString.access$600()[r101];
            ByteString r104 = this.prefixesStack.pop();
        L8:
            AnonymousClass1 r105 = null;
            if (this.prefixesStack.isEmpty() == true) goto L13;
            if (this.prefixesStack.peek().size() >= r103) goto L13;
            r104 = new RopeByteString(this.prefixesStack.pop(), r104, r105);
        L13:
            RopeByteString r106 = new RopeByteString(r104, r100, r105);
        L15:
            if (this.prefixesStack.isEmpty() == true) goto L19;
            int r107 = getDepthBinForLength(r106.size());
            int r108 = RopeByteString.access$600()[r107 + 1];
            if (this.prefixesStack.peek().size() >= r108) goto L19;
            r106 = new RopeByteString(this.prefixesStack.pop(), r106, r105);
        L19:
            this.prefixesStack.push(r106);
        }

        private ByteString balance(ByteString r100, ByteString r101) {
            doBalance(r100);
            doBalance(r101);
            ByteString r102 = this.prefixesStack.pop();
        L4:
            if (this.prefixesStack.isEmpty() == true) goto L6;
            r102 = new RopeByteString(this.prefixesStack.pop(), r102, null);
            goto L4
        L6:
            return r102;
        }

        public static /* synthetic */ ByteString access$100(Balancer r100, ByteString r101, ByteString r102) {
            return r100.balance(r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static class PieceIterator implements Iterator<LiteralByteString> {
        private final Stack<RopeByteString> breadCrumbs;
        private LiteralByteString next;

        private LiteralByteString getNextNonEmptyLeaf() {
        L3:
            if (this.breadCrumbs.isEmpty() == true) goto L4;
            LiteralByteString r100 = getLeafByLeft(RopeByteString.access$500(this.breadCrumbs.pop()));
            if (r100.isEmpty() == true) goto L3;
            return r100;
        L4:
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public LiteralByteString next2() {
            LiteralByteString r100 = this.next;
            if (r100 == null) goto L7;
            this.next = getNextNonEmptyLeaf();
            return r100;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ LiteralByteString next() {
            return next2();
        }

        private PieceIterator(ByteString r100) {
            this.breadCrumbs = new Stack();
            this.next = getLeafByLeft(r100);
        }

        private LiteralByteString getLeafByLeft(ByteString r100) {
        L3:
            if ((r100 instanceof RopeByteString) == false) goto L6;
            RopeByteString r101 = (RopeByteString) r100;
            this.breadCrumbs.push(r101);
            r100 = RopeByteString.access$400(r101);
            goto L3
        L6:
            return (LiteralByteString) r100;
        }

        public /* synthetic */ PieceIterator(ByteString r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public class RopeByteIterator implements ByteString.ByteIterator {
        private ByteString.ByteIterator bytes;
        int bytesRemaining;
        private final PieceIterator pieces;
        final /* synthetic */ RopeByteString this$0;

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.bytesRemaining <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Type inference failed for: r0v8, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            if (this.bytes.hasNext() == true) goto L5;
            this.bytes = this.pieces.next2().iterator();
        L5:
            this.bytesRemaining--;
            return this.bytes.nextByte();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        private RopeByteIterator(RopeByteString r100) {
            this.this$0 = r100;
            PieceIterator r101 = new PieceIterator(r100, null);
            this.pieces = r101;
            this.bytes = r101.next2().iterator();
            this.bytesRemaining = r100.size();
        }

        public /* synthetic */ RopeByteIterator(RopeByteString r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public class RopeInputStream extends InputStream {
        private LiteralByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;
        final /* synthetic */ RopeByteString this$0;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            monitor-enter(this);
            initialize();     // Catch: Throwable -> L6
            readSkipInternal(null, 0, this.mark);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece == null) goto L11;
            int r100 = this.currentPieceIndex;
            int r101 = this.currentPieceSize;
            if (r100 != r101) goto L12;
            this.currentPieceOffsetInRope += r101;
            this.currentPieceIndex = 0;
            if (this.pieceIterator.hasNext() == false) goto L9;
            LiteralByteString r102 = this.pieceIterator.next2();
            this.currentPiece = r102;
            this.currentPieceSize = r102.size();
            return;
        L9:
            this.currentPiece = null;
            this.currentPieceSize = 0;
            return;
        L12:
            return;
        }

        private void initialize() {
            PieceIterator r100 = new PieceIterator(this.this$0, null);
            this.pieceIterator = r100;
            LiteralByteString r101 = r100.next2();
            this.currentPiece = r101;
            this.currentPieceSize = r101.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            int r100 = this.currentPieceOffsetInRope + this.currentPieceIndex;
            return this.this$0.size() - r100;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            LiteralByteString r100 = this.currentPiece;
            if (r100 != null) goto L6;
            return -1;
        L6:
            int r101 = this.currentPieceIndex;
            this.currentPieceIndex = r101 + 1;
            return r100.byteAt(r101) & UByte.MAX_VALUE;
        }

        public RopeInputStream(RopeByteString r100) {
            this.this$0 = r100;
            initialize();
        }

        @Override // java.io.InputStream
        public void mark(int r100) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        @Override // java.io.InputStream
        public long skip(long r100) {
            if (r100 < 0) goto L10;
            if (r100 <= SieveCacheKt.NodeLinkMask) goto L8;
            r100 = 2147483647L;
        L8:
            return readSkipInternal(null, 0, (int) r100);
        L10:
            throw new IndexOutOfBoundsException();
        }

        private int readSkipInternal(byte[] r100, int r101, int r102) {
            int r103 = r102;
        L3:
            if (r103 <= 0) goto L14;
            advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) goto L6;
            int r104 = Math.min(this.currentPieceSize - this.currentPieceIndex, r103);
            if (r100 == null) goto L12;
            this.currentPiece.copyTo(r100, this.currentPieceIndex, r101, r104);
            r101 = r101 + r104;
        L12:
            this.currentPieceIndex += r104;
            r103 = r103 - r104;
            goto L3
        L6:
            if (r103 != r102) goto L14;
            return -1;
        L14:
            return r102 - r103;
        }

        @Override // java.io.InputStream
        public int read(byte[] r100, int r101, int r102) {
            if (r100 == null) goto L12;
            if (r101 < 0) goto L10;
            if (r102 < 0) goto L10;
            if (r102 > (r100.length - r101)) goto L10;
            return readSkipInternal(r100, r101, r102);
        L10:
            throw new IndexOutOfBoundsException();
        L12:
            throw null;
        }
    }

    static {
        ArrayList r100 = new ArrayList();
        int r101 = 1;
        int r102 = 1;
    L3:
        if (r101 <= 0) goto L5;
        r100.add(Integer.valueOf(r101));
        int r103 = r102 + r101;
        r102 = r101;
        r101 = r103;
        goto L3
    L5:
        r100.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[r100.size()];
        int r104 = 0;
    L6:
        int[] r105 = minLengthByDepth;
        if (r104 >= r105.length) goto L9;
        r105[r104] = ((Integer) ListProtector.get(r100, r104)).intValue();
        r104 = r104 + 1;
        goto L6
    }

    public int hashCode() {
        int r100 = this.hash;
        if (r100 != 0) goto L8;
        int r101 = this.totalLength;
        r100 = partialHash(r101, 0, r101);
        if (r100 != 0) goto L7;
        r100 = 1;
    L7:
        this.hash = r100;
    L8:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isBalanced() {
        if (this.totalLength < minLengthByDepth[this.treeDepth]) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int r100 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString r101 = this.right;
        if (r101.partialIsValidUtf8(r100, 0, r101.size()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Byte> iterator2() {
        return new RopeByteIterator(this, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new RopeInputStream(this));
    }

    public static /* synthetic */ int[] access$600() {
        return minLengthByDepth;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator2();
    }

    public static /* synthetic */ ByteString access$400(RopeByteString r100) {
        return r100.left;
    }

    public static /* synthetic */ ByteString access$500(RopeByteString r100) {
        return r100.right;
    }

    private boolean equalsFragments(ByteString r110) {
        AnonymousClass1 r100 = null;
        PieceIterator r101 = new PieceIterator(this, r100);
        LiteralByteString r102 = r101.next();
        PieceIterator r103 = new PieceIterator(r110, r100);
        LiteralByteString r111 = r103.next();
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L3:
        int r107 = r102.size() - r104;
        int r108 = r111.size() - r105;
        int r109 = Math.min(r107, r108);
        if (r104 != 0) goto L6;
        boolean r112 = r102.equalsRange(r111, r105, r109);
    L7:
        if (r112 == false) goto L8;
        r106 = r106 + r109;
        int r113 = this.totalLength;
        if (r106 >= r113) goto L11;
        if (r109 != r107) goto L18;
        r102 = r101.next();
        r104 = 0;
    L19:
        if (r109 == r108) goto L20;
        r105 = r105 + r109;
        goto L3
    L20:
        r111 = r103.next();
        r105 = 0;
        goto L3
    L18:
        r104 = r104 + r109;
        goto L19
    L11:
        if (r106 != r113) goto L15;
        return true;
    L15:
        throw new IllegalStateException();
    L8:
        return false;
    L6:
        r112 = r111.equalsRange(r102, r104, r109);
        goto L7
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString r101 = (ByteString) r100;
        if (this.totalLength == r101.size()) goto L12;
        return false;
    L12:
        if (this.totalLength != 0) goto L15;
        return true;
    L15:
        if (this.hash == 0) goto L22;
        int r102 = r101.peekCachedHashCode();
        if (r102 == 0) goto L22;
        if (this.hash == r102) goto L22;
        return false;
    L22:
        return equalsFragments(r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String r100) throws UnsupportedEncodingException {
        return new String(toByteArray(), r100);
    }

    private RopeByteString(ByteString r100, ByteString r101) {
        this.hash = 0;
        this.left = r100;
        this.right = r101;
        int r102 = r100.size();
        this.leftLength = r102;
        this.totalLength = r102 + r101.size();
        this.treeDepth = Math.max(r100.getTreeDepth(), r101.getTreeDepth()) + 1;
    }

    public static ByteString concatenate(ByteString r100, ByteString r101) {
        AnonymousClass1 r102 = null;
        if ((r100 instanceof RopeByteString) == false) goto L5;
        RopeByteString r103 = (RopeByteString) r100;
    L7:
        if (r101.size() != 0) goto L10;
        return r100;
    L10:
        if (r100.size() == 0) goto L30;
        int r104 = r100.size() + r101.size();
        if (r104 < 128) goto L31;
        if (r103 != null) goto L17;
    L19:
        if (r103 == null) goto L26;
        if (r103.left.getTreeDepth() <= r103.right.getTreeDepth()) goto L26;
        if (r103.getTreeDepth() <= r101.getTreeDepth()) goto L26;
        r101 = new RopeByteString(r103.left, new RopeByteString(r103.right, r101));
    L26:
        if (r104 < minLengthByDepth[Math.max(r100.getTreeDepth(), r101.getTreeDepth()) + 1]) goto L29;
        return new RopeByteString(r100, r101);
    L29:
        return Balancer.access$100(new Balancer(r102), r100, r101);
    L17:
        if ((r103.right.size() + r101.size()) >= 128) goto L19;
        r101 = new RopeByteString(r103.left, concatenateBytes(r103.right, r101));
        goto L30
    L31:
        return concatenateBytes(r100, r101);
    L30:
        return r101;
    L5:
        r103 = null;
        goto L7
    }

    private static LiteralByteString concatenateBytes(ByteString r100, ByteString r101) {
        int r102 = r100.size();
        int r103 = r101.size();
        byte[] r104 = new byte[r102 + r103];
        r100.copyTo(r104, 0, 0, r102);
        r101.copyTo(r104, 0, r102, r103);
        return new LiteralByteString(r104);
    }

    public /* synthetic */ RopeByteString(ByteString r100, ByteString r101, AnonymousClass1 r102) {
        this(r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialHash(int r100, int r101, int r102) {
        int r103 = r101 + r102;
        int r104 = this.leftLength;
        if (r103 <= r104) goto L5;
        if (r101 >= r104) goto L8;
        int r105 = r104 - r101;
        int r106 = this.left.partialHash(r100, r101, r105);
        return this.right.partialHash(r106, 0, r102 - r105);
    L8:
        return this.right.partialHash(r100, r101 - r104, r102);
    L5:
        return this.left.partialHash(r100, r101, r102);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialIsValidUtf8(int r100, int r101, int r102) {
        int r103 = r101 + r102;
        int r104 = this.leftLength;
        if (r103 <= r104) goto L5;
        if (r101 >= r104) goto L8;
        int r105 = r104 - r101;
        int r106 = this.left.partialIsValidUtf8(r100, r101, r105);
        return this.right.partialIsValidUtf8(r106, 0, r102 - r105);
    L8:
        return this.right.partialIsValidUtf8(r100, r101 - r104, r102);
    L5:
        return this.left.partialIsValidUtf8(r100, r101, r102);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void writeToInternal(OutputStream r100, int r101, int r102) throws IOException {
        int r103 = r101 + r102;
        int r104 = this.leftLength;
        if (r103 > r104) goto L5;
        this.left.writeToInternal(r100, r101, r102);
        return;
    L5:
        if (r101 < r104) goto L7;
        this.right.writeToInternal(r100, r101 - r104, r102);
        return;
    L7:
        int r105 = r104 - r101;
        this.left.writeToInternal(r100, r101, r105);
        this.right.writeToInternal(r100, 0, r102 - r105);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] r100, int r101, int r102, int r103) {
        int r104 = r101 + r103;
        int r105 = this.leftLength;
        if (r104 > r105) goto L5;
        this.left.copyToInternal(r100, r101, r102, r103);
        return;
    L5:
        if (r101 < r105) goto L7;
        this.right.copyToInternal(r100, r101 - r105, r102, r103);
        return;
    L7:
        int r106 = r105 - r101;
        this.left.copyToInternal(r100, r101, r102, r106);
        this.right.copyToInternal(r100, 0, r102 + r106, r103 - r106);
    }
}
