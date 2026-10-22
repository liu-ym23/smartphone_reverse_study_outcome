package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
class LiteralByteString extends ByteString {
    protected final byte[] bytes;
    private int hash;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes42.dex */
    public class LiteralByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;
        final /* synthetic */ LiteralByteString this$0;

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.position >= this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            byte[] r100 = this.this$0.bytes;     // Catch: ArrayIndexOutOfBoundsException -> L4
            int r101 = this.position;     // Catch: ArrayIndexOutOfBoundsException -> L4
            this.position = r101 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
            return r100[r101];
        L4:
            e = move-exception;
            throw new NoSuchElementException(e.getMessage());
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

        private LiteralByteIterator(LiteralByteString r100) {
            this.this$0 = r100;
            this.position = 0;
            this.limit = r100.size();
        }

        public /* synthetic */ LiteralByteIterator(LiteralByteString r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public int getOffsetIntoBytes() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int getTreeDepth() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isBalanced() {
        return true;
    }

    public int hashCode() {
        int r100 = this.hash;
        if (r100 != 0) goto L8;
        int r101 = size();
        r100 = partialHash(r101, 0, r101);
        if (r100 != 0) goto L7;
        r100 = 1;
    L7:
        this.hash = r100;
    L8:
        return r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new LiteralByteIterator(this, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytes.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int r100 = getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, r100, size() + r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int peekCachedHashCode() {
        return this.hash;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator();
    }

    public LiteralByteString(byte[] r100) {
        this.hash = 0;
        this.bytes = r100;
    }

    public byte byteAt(int r100) {
        return this.bytes[r100];
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ByteString) == true) goto L9;
        return false;
    L9:
        if (size() == ((ByteString) r100).size()) goto L12;
        return false;
    L12:
        if (size() != 0) goto L15;
        return true;
    L15:
        if ((r100 instanceof LiteralByteString) == false) goto L19;
        return equalsRange((LiteralByteString) r100, 0, size());
    L19:
        if ((r100 instanceof RopeByteString) == true) goto L21;
        String r101 = String.valueOf(r100.getClass());
        StringBuilder r102 = new StringBuilder(r101.length() + 49);
        r102.append("Has a new type of ByteString been created? Found ");
        r102.append(r101);
        throw new IllegalArgumentException(r102.toString());
    L21:
        return r100.equals(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String r100) throws UnsupportedEncodingException {
        return new String(this.bytes, getOffsetIntoBytes(), size(), r100);
    }

    public boolean equalsRange(LiteralByteString r100, int r101, int r102) {
        if (r102 <= r100.size()) goto L5;
        int r103 = size();
        StringBuilder r104 = new StringBuilder(40);
        r104.append("Length too large: ");
        r104.append(r102);
        r104.append(r103);
        throw new IllegalArgumentException(r104.toString());
    L5:
        if ((r101 + r102) > r100.size()) goto L15;
        byte[] r105 = this.bytes;
        byte[] r106 = r100.bytes;
        int r107 = getOffsetIntoBytes() + r102;
        int r108 = getOffsetIntoBytes();
        int r109 = r100.getOffsetIntoBytes() + r101;
    L7:
        if (r108 >= r107) goto L13;
        if (r105[r108] != r106[r109]) goto L10;
        r108 = r108 + 1;
        r109 = r109 + 1;
        goto L7
    L10:
        return false;
    L13:
        return true;
    L15:
        int r110 = r100.size();
        StringBuilder r111 = new StringBuilder(59);
        r111.append("Ran off end of other: ");
        r111.append(r101);
        r111.append(", ");
        r111.append(r102);
        r111.append(", ");
        r111.append(r110);
        throw new IllegalArgumentException(r111.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialHash(int r100, int r101, int r102) {
        return hashCode(r100, this.bytes, getOffsetIntoBytes() + r101, r102);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialIsValidUtf8(int r100, int r101, int r102) {
        int r103 = getOffsetIntoBytes() + r101;
        return Utf8.partialIsValidUtf8(r100, this.bytes, r103, r102 + r103);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void writeToInternal(OutputStream r100, int r101, int r102) throws IOException {
        r100.write(this.bytes, getOffsetIntoBytes() + r101, r102);
    }

    public static int hashCode(int r100, byte[] r101, int r102, int r103) {
        int r104 = r102;
    L4:
        if (r104 >= (r102 + r103)) goto L6;
        r100 = (r100 * 31) + r101[r104];
        r104 = r104 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] r100, int r101, int r102, int r103) {
        System.arraycopy(this.bytes, r101, r100, r102, r103);
    }
}
