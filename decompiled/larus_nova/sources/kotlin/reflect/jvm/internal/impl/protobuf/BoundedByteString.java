package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes42.dex */
class BoundedByteString extends LiteralByteString {
    private final int bytesLength;
    private final int bytesOffset;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.BoundedByteString$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class BoundedByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;
        final /* synthetic */ BoundedByteString this$0;

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.position >= this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            int r100 = this.position;
            if (r100 >= this.limit) goto L7;
            byte[] r101 = this.this$0.bytes;
            this.position = r100 + 1;
            return r101[r100];
        L7:
            throw new NoSuchElementException();
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

        private BoundedByteIterator(BoundedByteString r100) {
            this.this$0 = r100;
            int r101 = r100.getOffsetIntoBytes();
            this.position = r101;
            this.limit = r101 + r100.size();
        }

        public /* synthetic */ BoundedByteIterator(BoundedByteString r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Byte> iterator2() {
        return new BoundedByteIterator(this, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    public int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytesLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator2();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    public byte byteAt(int r100) {
        if (r100 >= 0) goto L4;
        StringBuilder r101 = new StringBuilder(28);
        r101.append("Index too small: ");
        r101.append(r100);
        throw new ArrayIndexOutOfBoundsException(r101.toString());
    L4:
        if (r100 < size()) goto L6;
        int r102 = size();
        StringBuilder r103 = new StringBuilder(41);
        r103.append("Index too large: ");
        r103.append(r100);
        r103.append(", ");
        r103.append(r102);
        throw new ArrayIndexOutOfBoundsException(r103.toString());
    L6:
        return this.bytes[this.bytesOffset + r100];
    }

    public BoundedByteString(byte[] r100, int r101, int r102) {
        super(r100);
        if (r101 < 0) goto L13;
        if (r102 >= 0) goto L6;
        StringBuilder r103 = new StringBuilder(29);
        r103.append("Length too small: ");
        r103.append(r101);
        throw new IllegalArgumentException(r103.toString());
    L6:
        if ((((long) r101) + ((long) r102)) > r100.length) goto L9;
        this.bytesOffset = r101;
        this.bytesLength = r102;
        return;
    L9:
        StringBuilder r104 = new StringBuilder(48);
        r104.append("Offset+Length too large: ");
        r104.append(r101);
        r104.append(Marker.ANY_NON_NULL_MARKER);
        r104.append(r102);
        throw new IllegalArgumentException(r104.toString());
    L13:
        StringBuilder r105 = new StringBuilder(29);
        r105.append("Offset too small: ");
        r105.append(r101);
        throw new IllegalArgumentException(r105.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] r100, int r101, int r102, int r103) {
        System.arraycopy(this.bytes, getOffsetIntoBytes() + r101, r100, r102, r103);
    }
}
