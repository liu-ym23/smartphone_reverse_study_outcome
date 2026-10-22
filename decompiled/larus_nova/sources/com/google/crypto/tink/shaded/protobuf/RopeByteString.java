package com.google.crypto.tink.shaded.protobuf;

import androidx.collection.SieveCacheKt;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
final class RopeByteString extends ByteString {
    static final int[] minLengthByDepth = null;
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    public class a extends ByteString.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f275834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteString.f f275835b;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f275835b == null) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5, types: [com.google.crypto.tink.shaded.protobuf.ByteString$f] */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.f
        public final byte nextByte() {
            ByteString.f r100 = this.f275835b;
            if (r100 == null) goto L13;
            byte r101 = r100.nextByte();
            if (this.f275835b.hasNext() == false) goto L7;
        L11:
            return r101;
        L7:
            if (this.f275834a.hasNext() == false) goto L9;
            ?? r102 = this.f275834a.a().iterator();
        L10:
            this.f275835b = r102;
            goto L11
        L9:
            r102 = 0;
            goto L10
        L13:
            throw new NoSuchElementException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [com.google.crypto.tink.shaded.protobuf.ByteString$f] */
        /* JADX WARN: Type inference failed for: r2v6 */
        public a(RopeByteString r100) {
            c r101 = new c(r100);
            this.f275834a = r101;
            if (r101.hasNext() == false) goto L5;
            ?? r102 = r101.a().iterator();
        L6:
            this.f275835b = r102;
            return;
        L5:
            r102 = 0;
            goto L6
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque<ByteString> f275836a;

        public b() {
            this.f275836a = new ArrayDeque();
        }

        private void insert(ByteString r100) {
            int r101 = Arrays.binarySearch(RopeByteString.minLengthByDepth, r100.size());
            if (r101 >= 0) goto L5;
            r101 = (-(r101 + 1)) - 1;
        L5:
            int r102 = RopeByteString.minLength(r101 + 1);
            if (this.f275836a.isEmpty() == false) goto L8;
        L26:
            this.f275836a.push(r100);
            return;
        L8:
            if (this.f275836a.peek().size() >= r102) goto L26;
            int r103 = RopeByteString.minLength(r101);
            ByteString r104 = this.f275836a.pop();
        L11:
            a r105 = null;
            if (this.f275836a.isEmpty() == true) goto L16;
            if (this.f275836a.peek().size() >= r103) goto L16;
            r104 = new RopeByteString(this.f275836a.pop(), r104, r105);
        L16:
            RopeByteString r106 = new RopeByteString(r104, r100, r105);
        L18:
            if (this.f275836a.isEmpty() == true) goto L25;
            int r107 = Arrays.binarySearch(RopeByteString.minLengthByDepth, r106.size());
            if (r107 >= 0) goto L23;
            r107 = (-(r107 + 1)) - 1;
        L23:
            if (this.f275836a.peek().size() >= RopeByteString.minLength(r107 + 1)) goto L25;
            r106 = new RopeByteString(this.f275836a.pop(), r106, r105);
        L25:
            this.f275836a.push(r106);
        }

        public final void a(ByteString r100) {
            if (r100.isBalanced() == false) goto L6;
            insert(r100);
            return;
        L6:
            if ((r100 instanceof RopeByteString) == false) goto L10;
            RopeByteString r101 = (RopeByteString) r100;
            a(RopeByteString.access$400(r101));
            a(RopeByteString.access$500(r101));
            return;
        L10:
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + r100.getClass());
        }
    }

    public static final class c implements Iterator<ByteString.LeafByteString> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque<RopeByteString> f275837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteString.LeafByteString f275838b;

        public final ByteString.LeafByteString a() {
            ByteString.LeafByteString r100 = this.f275838b;
            if (r100 == null) goto L20;
        L4:
            ArrayDeque<RopeByteString> r101 = this.f275837a;
            if (r101 == null) goto L16;
            if (r101.isEmpty() == true) goto L16;
            ByteString r102 = RopeByteString.access$500(this.f275837a.pop());
        L11:
            if ((r102 instanceof RopeByteString) == false) goto L13;
            RopeByteString r103 = (RopeByteString) r102;
            this.f275837a.push(r103);
            r102 = RopeByteString.access$400(r103);
            goto L11
        L13:
            ByteString.LeafByteString r104 = (ByteString.LeafByteString) r102;
            if (r104.isEmpty() == true) goto L4;
        L17:
            this.f275838b = r104;
            return r100;
        L16:
            r104 = null;
            goto L17
        L20:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f275838b == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ ByteString.LeafByteString next() {
            return a();
        }

        public c(ByteString r100) {
            if ((r100 instanceof RopeByteString) == false) goto L9;
            RopeByteString r101 = (RopeByteString) r100;
            ArrayDeque<RopeByteString> r102 = new ArrayDeque(r101.getTreeDepth());
            this.f275837a = r102;
            r102.push(r101);
            ByteString r103 = RopeByteString.access$400(r101);
        L6:
            if ((r103 instanceof RopeByteString) == false) goto L8;
            RopeByteString r104 = (RopeByteString) r103;
            this.f275837a.push(r104);
            r103 = RopeByteString.access$400(r104);
            goto L6
        L8:
            this.f275838b = (ByteString.LeafByteString) r103;
            return;
        L9:
            this.f275837a = null;
            this.f275838b = (ByteString.LeafByteString) r100;
        }
    }

    public class d extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f275839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteString.LeafByteString f275840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f275841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f275842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f275843e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f275844f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ RopeByteString f275845g;

        @Override // java.io.InputStream
        public final boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public final synchronized void reset() {
            monitor-enter(this);
            c r100 = new c(this.f275845g);     // Catch: Throwable -> L6
            this.f275839a = r100;     // Catch: Throwable -> L6
            ByteString.LeafByteString r101 = r100.a();     // Catch: Throwable -> L6
            this.f275840b = r101;     // Catch: Throwable -> L6
            this.f275841c = r101.size();     // Catch: Throwable -> L6
            this.f275842d = 0;     // Catch: Throwable -> L6
            this.f275843e = 0;     // Catch: Throwable -> L6
            b(null, 0, this.f275844f);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final void a() {
            if (this.f275840b == null) goto L11;
            int r100 = this.f275842d;
            int r101 = this.f275841c;
            if (r100 != r101) goto L12;
            this.f275843e += r101;
            this.f275842d = 0;
            if (this.f275839a.hasNext() == false) goto L9;
            ByteString.LeafByteString r102 = this.f275839a.a();
            this.f275840b = r102;
            this.f275841c = r102.size();
            return;
        L9:
            this.f275840b = null;
            this.f275841c = 0;
            return;
        L12:
            return;
        }

        @Override // java.io.InputStream
        public final int available() throws IOException {
            int r100 = this.f275843e + this.f275842d;
            return this.f275845g.size() - r100;
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            a();
            ByteString.LeafByteString r100 = this.f275840b;
            if (r100 != null) goto L6;
            return -1;
        L6:
            int r101 = this.f275842d;
            this.f275842d = r101 + 1;
            return r100.byteAt(r101) & UByte.MAX_VALUE;
        }

        public d(RopeByteString r100) {
            this.f275845g = r100;
            c r101 = new c(r100);
            this.f275839a = r101;
            ByteString.LeafByteString r102 = r101.a();
            this.f275840b = r102;
            this.f275841c = r102.size();
            this.f275842d = 0;
            this.f275843e = 0;
        }

        @Override // java.io.InputStream
        public final void mark(int r100) {
            this.f275844f = this.f275843e + this.f275842d;
        }

        @Override // java.io.InputStream
        public final long skip(long r100) {
            if (r100 < 0) goto L10;
            if (r100 <= SieveCacheKt.NodeLinkMask) goto L8;
            r100 = 2147483647L;
        L8:
            return b(null, 0, (int) r100);
        L10:
            throw new IndexOutOfBoundsException();
        }

        public final int b(byte[] r100, int r101, int r102) {
            int r103 = r102;
        L3:
            if (r103 <= 0) goto L12;
            a();
            if (this.f275840b == null) goto L12;
            int r104 = Math.min(this.f275841c - this.f275842d, r103);
            if (r100 == null) goto L10;
            this.f275840b.copyTo(r100, this.f275842d, r101, r104);
            r101 = r101 + r104;
        L10:
            this.f275842d += r104;
            r103 = r103 - r104;
        L12:
            return r102 - r103;
        }

        @Override // java.io.InputStream
        public final int read(byte[] r100, int r101, int r102) {
            r100.getClass();
            if (r101 < 0) goto L15;
            if (r102 < 0) goto L15;
            if (r102 > (r100.length - r101)) goto L15;
            int r103 = b(r100, r101, r102);
            if (r103 != 0) goto L16;
            if (r102 > 0) goto L12;
            int r104 = this.f275843e + this.f275842d;
            if ((this.f275845g.size() - r104) == 0) goto L12;
            return r103;
        L12:
            return -1;
        L16:
            return r103;
        L15:
            throw new IndexOutOfBoundsException();
        }
    }

    static {
        minLengthByDepth = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList r100 = new ArrayList();
        ArrayDeque r101 = new ArrayDeque(getTreeDepth());
        r101.push(this);
        ByteString r102 = access$400(this);
    L4:
        if ((r102 instanceof RopeByteString) == false) goto L6;
        RopeByteString r103 = (RopeByteString) r102;
        r101.push(r103);
        r102 = access$400(r103);
        goto L4
    L6:
        ByteString.LeafByteString r104 = (ByteString.LeafByteString) r102;
    L7:
        if (r104 == null) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L24;
        if (r104 == null) goto L23;
    L13:
        if (r101.isEmpty() == true) goto L14;
        ByteString r106 = access$500((RopeByteString) r101.pop());
    L17:
        if ((r106 instanceof RopeByteString) == false) goto L19;
        RopeByteString r107 = (RopeByteString) r106;
        r101.push(r107);
        r106 = access$400(r107);
        goto L17
    L19:
        ByteString.LeafByteString r108 = (ByteString.LeafByteString) r106;
        if (r108.isEmpty() == true) goto L13;
    L21:
        r100.add(r104.asReadOnlyByteBuffer());
        r104 = r108;
        goto L7
    L14:
        r108 = null;
        goto L21
    L23:
        throw new NoSuchElementException();
    L24:
        return r100;
    L9:
        r105 = false;
        goto L10
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean isBalanced() {
        if (this.totalLength < minLength(this.treeDepth)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean isValidUtf8() {
        int r100 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString r101 = this.right;
        if (r101.partialIsValidUtf8(r100, 0, r101.size()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new a(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public InputStream newInput() {
        return new d(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public com.google.crypto.tink.shaded.protobuf.d newCodedInput() {
        List<ByteBuffer> r100 = asReadOnlyByteBufferList();
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r101.hasNext() == false) goto L13;
        ByteBuffer r104 = (ByteBuffer) r101.next();
        r103 = r103 + r104.remaining();
        if (r104.hasArray() == true) goto L7;
        if (r104.isDirect() == true) goto L10;
        r102 = r102 | 4;
        goto L4
    L10:
        r102 = r102 | 2;
        goto L4
    L7:
        r102 = r102 | 1;
        goto L4
    L13:
        if (r102 != 2) goto L16;
        return new com.google.crypto.tink.shaded.protobuf.d.b(r100, r103);
    L16:
        return new com.google.crypto.tink.shaded.protobuf.d.c(new f(r100));
    }

    public Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    public static /* synthetic */ ByteString access$400(RopeByteString r100) {
        return r100.left;
    }

    public static /* synthetic */ ByteString access$500(RopeByteString r100) {
        return r100.right;
    }

    public static int minLength(int r100) {
        int[] r101 = minLengthByDepth;
        if (r100 < r101.length) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return r101[r100];
    }

    private void readObject(ObjectInputStream r100) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte byteAt(int r100) {
        ByteString.checkIndex(r100, this.totalLength);
        return internalByteAt(r100);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void copyTo(ByteBuffer r100) {
        this.left.copyTo(r100);
        this.right.copyTo(r100);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean equals(Object r110) {
        if (r110 != this) goto L6;
        return true;
    L6:
        if ((r110 instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString r111 = (ByteString) r110;
        if (this.totalLength == r111.size()) goto L12;
        return false;
    L12:
        if (this.totalLength != 0) goto L14;
        return true;
    L14:
        int r100 = peekCachedHashCode();
        int r101 = r111.peekCachedHashCode();
        if (r100 == 0) goto L19;
        if (r101 == 0) goto L19;
        if (r100 == r101) goto L19;
        return false;
    L19:
        c r102 = new c(this);
        ByteString.LeafByteString r103 = r102.a();
        c r104 = new c(r111);
        ByteString.LeafByteString r112 = r104.a();
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L20:
        int r108 = r103.size() - r105;
        int r109 = r112.size() - r106;
        int r113 = Math.min(r108, r109);
        if (r105 != 0) goto L23;
        boolean r114 = r103.equalsRange(r112, r106, r113);
    L24:
        if (r114 == false) goto L25;
        r107 = r107 + r113;
        int r115 = this.totalLength;
        if (r107 >= r115) goto L28;
        if (r113 != r108) goto L34;
        r105 = 0;
        r103 = r102.a();
    L35:
        if (r113 == r109) goto L36;
        r106 = r106 + r113;
        goto L20
    L36:
        r112 = r104.a();
        r106 = 0;
        goto L20
    L34:
        r105 = r105 + r113;
        r103 = r103;
        goto L35
    L28:
        if (r107 != r115) goto L31;
        return true;
    L31:
        throw new IllegalStateException();
    L25:
        return false;
    L23:
        r114 = r112.equalsRange(r103, r105, r113);
        goto L24
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte internalByteAt(int r100) {
        int r101 = this.leftLength;
        if (r100 >= r101) goto L7;
        return this.left.internalByteAt(r100);
    L7:
        return this.right.internalByteAt(r100 - r101);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public String toStringInternal(Charset r100) {
        return new String(toByteArray(), r100);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void writeTo(com.google.crypto.tink.shaded.protobuf.c r100) throws IOException {
        this.left.writeTo(r100);
        this.right.writeTo(r100);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void writeToReverse(com.google.crypto.tink.shaded.protobuf.c r100) throws IOException {
        this.right.writeToReverse(r100);
        this.left.writeToReverse(r100);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void writeTo(OutputStream r100) throws IOException {
        this.left.writeTo(r100);
        this.right.writeTo(r100);
    }

    public RopeByteString(ByteString r100, ByteString r101) {
        this.left = r100;
        this.right = r101;
        int r102 = r100.size();
        this.leftLength = r102;
        this.totalLength = r102 + r101.size();
        this.treeDepth = Math.max(r100.getTreeDepth(), r101.getTreeDepth()) + 1;
    }

    public static ByteString concatenate(ByteString r100, ByteString r101) {
        if (r101.size() != 0) goto L6;
        return r100;
    L6:
        if (r100.size() != 0) goto L8;
        return r101;
    L8:
        int r102 = r100.size() + r101.size();
        if (r102 >= 128) goto L13;
        int r103 = r100.size();
        int r104 = r101.size();
        byte[] r105 = new byte[r103 + r104];
        r100.copyTo(r105, 0, 0, r103);
        r101.copyTo(r105, 0, r103, r104);
        return ByteString.wrap(r105);
    L13:
        if ((r100 instanceof RopeByteString) == false) goto L25;
        RopeByteString r106 = (RopeByteString) r100;
        if ((r106.right.size() + r101.size()) >= 128) goto L19;
        ByteString r107 = r106.right;
        int r108 = r107.size();
        int r109 = r101.size();
        byte[] r110 = new byte[r108 + r109];
        r107.copyTo(r110, 0, 0, r108);
        r101.copyTo(r110, 0, r108, r109);
        ByteString r111 = ByteString.wrap(r110);
        return new RopeByteString(r106.left, r111);
    L19:
        if (r106.left.getTreeDepth() <= r106.right.getTreeDepth()) goto L25;
        if (r106.getTreeDepth() <= r101.getTreeDepth()) goto L25;
        RopeByteString r112 = new RopeByteString(r106.right, r101);
        return new RopeByteString(r106.left, r112);
    L25:
        if (r102 >= minLength(Math.max(r100.getTreeDepth(), r101.getTreeDepth()) + 1)) goto L27;
        b r113 = new b();
        r113.a(r100);
        r113.a(r101);
        ByteString r114 = r113.f275836a.pop();
    L30:
        if (r113.f275836a.isEmpty() == true) goto L32;
        r114 = new RopeByteString(r113.f275836a.pop(), r114, null);
        goto L30
    L32:
        return r114;
    L27:
        return new RopeByteString(r100, r101);
    }

    public static RopeByteString newInstanceForTest(ByteString r100, ByteString r101) {
        return new RopeByteString(r100, r101);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteString substring(int r100, int r101) {
        int r102 = ByteString.checkRange(r100, r101, this.totalLength);
        if (r102 != 0) goto L7;
        return ByteString.EMPTY;
    L7:
        if (r102 != this.totalLength) goto L9;
        return this;
    L9:
        int r103 = this.leftLength;
        if (r101 <= r103) goto L12;
        if (r100 < r103) goto L17;
        return this.right.substring(r100 - r103, r101 - r103);
    L17:
        return new RopeByteString(this.left.substring(r100), this.right.substring(0, r101 - this.leftLength));
    L12:
        return this.left.substring(r100, r101);
    }

    public /* synthetic */ RopeByteString(ByteString r100, ByteString r101, a r102) {
        this(r100, r101);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
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

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
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

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
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

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
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
