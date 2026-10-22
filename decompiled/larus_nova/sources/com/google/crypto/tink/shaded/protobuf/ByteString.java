package com.google.crypto.tink.shaded.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.UByte;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes23.dex */
@CheckReturnValue
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = null;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f275799a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f275800b = null;
    private static final long serialVersionUID = 1;
    private int hash;

    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        public Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        private void readObject(ObjectInputStream r100) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public byte byteAt(int r100) {
            ByteString.checkIndex(r100, size());
            return this.bytes[this.bytesOffset + r100];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public byte internalByteAt(int r100) {
            return this.bytes[this.bytesOffset + r100];
        }

        public BoundedByteString(byte[] r100, int r101, int r102) {
            super(r100);
            ByteString.checkRange(r101, r101 + r102, r100.length);
            this.bytesOffset = r101;
            this.bytesLength = r102;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public void copyToInternal(byte[] r100, int r101, int r102, int r103) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + r101, r100, r102, r103);
        }
    }

    public static abstract class LeafByteString extends ByteString {
        private static final long serialVersionUID = 1;

        public abstract boolean equalsRange(ByteString r100, int r101, int r102);

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean isBalanced() {
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }

        public LeafByteString() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public void writeToReverse(com.google.crypto.tink.shaded.protobuf.c r100) throws IOException {
            writeTo(r100);
        }
    }

    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        public int getOffsetIntoBytes() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final com.google.crypto.tink.shaded.protobuf.d newCodedInput() {
            return com.google.crypto.tink.shaded.protobuf.d.a(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean isValidUtf8() {
            int r100 = getOffsetIntoBytes();
            byte[] r101 = this.bytes;
            int r102 = size() + r100;
            if (Utf8.f275849a.e(0, r101, r100, r102) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        public LiteralByteString(byte[] r100) {
            if (r100 == null) goto L7;
            this.bytes = r100;
            return;
        L7:
            throw null;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public byte byteAt(int r100) {
            return this.bytes[r100];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final void copyTo(ByteBuffer r100) {
            r100.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean equals(Object r100) {
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
            if ((r100 instanceof LiteralByteString) == false) goto L24;
            LiteralByteString r101 = (LiteralByteString) r100;
            int r102 = peekCachedHashCode();
            int r103 = r101.peekCachedHashCode();
            if (r102 == 0) goto L22;
            if (r103 == 0) goto L22;
            if (r102 == r103) goto L22;
            return false;
        L22:
            return equalsRange(r101, 0, size());
        L24:
            return r100.equals(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public byte internalByteAt(int r100) {
            return this.bytes[r100];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final String toStringInternal(Charset r100) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), r100);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final void writeTo(com.google.crypto.tink.shaded.protobuf.c r100) throws IOException {
            r100.b(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final void writeTo(OutputStream r100) throws IOException {
            r100.write(toByteArray());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final ByteString substring(int r100, int r101) {
            int r102 = ByteString.checkRange(r100, r101, size());
            if (r102 != 0) goto L7;
            return ByteString.EMPTY;
        L7:
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + r100, r102);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
        public final boolean equalsRange(ByteString r100, int r101, int r102) {
            if (r102 > r100.size()) goto L21;
            int r103 = r101 + r102;
            if (r103 > r100.size()) goto L19;
            if ((r100 instanceof LiteralByteString) == false) goto L17;
            LiteralByteString r104 = (LiteralByteString) r100;
            byte[] r105 = this.bytes;
            byte[] r106 = r104.bytes;
            int r107 = getOffsetIntoBytes() + r102;
            int r108 = getOffsetIntoBytes();
            int r109 = r104.getOffsetIntoBytes() + r101;
        L9:
            if (r108 >= r107) goto L14;
            if (r105[r108] != r106[r109]) goto L12;
            r108 = r108 + 1;
            r109 = r109 + 1;
            goto L9
        L12:
            return false;
        L14:
            return true;
        L17:
            return r100.substring(r101, r103).equals(substring(0, r102));
        L19:
            throw new IllegalArgumentException("Ran off end of other: " + r101 + ", " + r102 + ", " + r100.size());
        L21:
            throw new IllegalArgumentException("Length too large: " + r102 + size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final int partialHash(int r100, int r101, int r102) {
            byte[] r103 = this.bytes;
            int r104 = getOffsetIntoBytes() + r101;
            Charset r105 = com.google.crypto.tink.shaded.protobuf.e.f275885a;
            int r106 = r104;
        L4:
            if (r106 >= (r104 + r102)) goto L6;
            r100 = (r100 * 31) + r103[r106];
            r106 = r106 + 1;
            goto L4
        L6:
            return r100;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final int partialIsValidUtf8(int r100, int r101, int r102) {
            int r103 = getOffsetIntoBytes() + r101;
            Utf8.b r104 = Utf8.f275849a;
            return r104.e(r100, this.bytes, r103, r102 + r103);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final void writeToInternal(OutputStream r100, int r101, int r102) throws IOException {
            r100.write(this.bytes, getOffsetIntoBytes() + r101, r102);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public void copyToInternal(byte[] r100, int r101, int r102, int r103) {
            System.arraycopy(this.bytes, r101, r100, r102, r103);
        }
    }

    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f275801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f275802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ByteString f275803c;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f275801a >= this.f275802b) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.f
        public final byte nextByte() {
            int r100 = this.f275801a;
            if (r100 >= this.f275802b) goto L7;
            this.f275801a = r100 + 1;
            return this.f275803c.internalByteAt(r100);
        L7:
            throw new NoSuchElementException();
        }

        public a(ByteString r100) {
            this.f275803c = r100;
            this.f275801a = 0;
            this.f275802b = r100.size();
        }
    }

    public class b implements Comparator<ByteString> {
        public b() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.crypto.tink.shaded.protobuf.ByteString$f, java.util.Iterator] */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.crypto.tink.shaded.protobuf.ByteString$f, java.util.Iterator] */
        @Override // java.util.Comparator
        public final int compare(ByteString r100, ByteString r101) {
            ByteString r102 = r100;
            ByteString r103 = r101;
            ?? r104 = r102.iterator();
            ?? r105 = r103.iterator();
        L4:
            if (r104.hasNext() == false) goto L11;
            if (r105.hasNext() == false) goto L11;
            int r106 = Integer.valueOf(ByteString.access$200(r104.nextByte())).compareTo(Integer.valueOf(ByteString.access$200(r105.nextByte())));
            if (r106 == 0) goto L4;
            return r106;
        L11:
            return Integer.valueOf(r102.size()).compareTo(Integer.valueOf(r103.size()));
        }
    }

    public static abstract class c implements f {
        public c() {
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public static final class d implements e {
        public d() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.e
        public final byte[] copyFrom(byte[] r100, int r101, int r102) {
            return Arrays.copyOfRange(r100, r101, r102 + r101);
        }
    }

    public interface e {
        byte[] copyFrom(byte[] r100, int r101, int r102);
    }

    public interface f extends Iterator<Byte> {
        byte nextByte();
    }

    public static final class g {
        public g(int r100) {
            int r101 = CodedOutputStream.f275809a;
            new CodedOutputStream.a(new byte[r100], r100);
        }
    }

    public static final class h extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f275804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<ByteString> f275805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f275806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f275807d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f275808e;

        public final String toString() {
            Object[] r100 = new Object[2];
            r100[0] = Integer.toHexString(System.identityHashCode(this));
            monitor-enter(this);
            int r101 = this.f275806c + this.f275808e;
            monitor-exit(this);
            r100[1] = Integer.valueOf(r101);
            return String.format("<ByteString.Output@%s size=%d>", r100);
        L9:
            th = move-exception;
            throw th;
        }

        public h(int r100) {
            if (r100 < 0) goto L7;
            this.f275804a = r100;
            this.f275805b = new ArrayList();
            this.f275807d = new byte[r100];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        public final void a(int r100) {
            this.f275805b.add(new LiteralByteString(this.f275807d));
            int r101 = this.f275806c + this.f275807d.length;
            this.f275806c = r101;
            this.f275807d = new byte[Math.max(this.f275804a, Math.max(r100, r101 >>> 1))];
            this.f275808e = 0;
        }

        @Override // java.io.OutputStream
        public final synchronized void write(int r100) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.f275808e != this.f275807d.length) goto L6;
            a(1);     // Catch: Throwable -> L9
        L6:
            byte[] r101 = this.f275807d;     // Catch: Throwable -> L9
            int r102 = this.f275808e;     // Catch: Throwable -> L9
            this.f275808e = r102 + 1;     // Catch: Throwable -> L9
            r101[r102] = (byte) r100;     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        @Override // java.io.OutputStream
        public final synchronized void write(byte[] r100, int r101, int r102) {
            monitor-enter(this);
            byte[] r103 = this.f275807d;     // Catch: Throwable -> L9
            int r104 = r103.length;     // Catch: Throwable -> L9
            int r105 = this.f275808e;     // Catch: Throwable -> L9
            if (r102 > (r104 - r105)) goto L6;
            System.arraycopy(r100, r101, r103, r105, r102);     // Catch: Throwable -> L9
            this.f275808e += r102;     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L6:
            int r106 = r103.length - r105;     // Catch: Throwable -> L9
            System.arraycopy(r100, r101, r103, r105, r106);     // Catch: Throwable -> L9
            int r107 = r102 - r106;     // Catch: Throwable -> L9
            a(r107);     // Catch: Throwable -> L9
            System.arraycopy(r100, r101 + r106, this.f275807d, 0, r107);     // Catch: Throwable -> L9
            this.f275808e = r107;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static final class i implements e {
        public i() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.e
        public final byte[] copyFrom(byte[] r100, int r101, int r102) {
            byte[] r103 = new byte[r102];
            System.arraycopy(r100, r101, r103, 0, r102);
            return r103;
        }
    }

    public static int access$200(byte r100) {
        return r100 & UByte.MAX_VALUE;
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int r100);

    public abstract void copyTo(ByteBuffer r100);

    public abstract void copyToInternal(byte[] r100, int r101, int r102, int r103);

    public abstract boolean equals(Object r100);

    public abstract int getTreeDepth();

    public abstract byte internalByteAt(int r100);

    public abstract boolean isBalanced();

    public abstract boolean isValidUtf8();

    public abstract com.google.crypto.tink.shaded.protobuf.d newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int r100, int r101, int r102);

    public abstract int partialIsValidUtf8(int r100, int r101, int r102);

    public abstract int size();

    public abstract ByteString substring(int r100, int r101);

    public abstract String toStringInternal(Charset r100);

    public abstract void writeTo(com.google.crypto.tink.shaded.protobuf.c r100) throws IOException;

    public abstract void writeTo(OutputStream r100) throws IOException;

    public abstract void writeToInternal(OutputStream r100, int r101, int r102) throws IOException;

    public abstract void writeToReverse(com.google.crypto.tink.shaded.protobuf.c r100) throws IOException;

    static {
        EMPTY = new LiteralByteString(com.google.crypto.tink.shaded.protobuf.e.f275886b);
        if (com.google.crypto.tink.shaded.protobuf.a.b() == false) goto L5;
        e r100 = new i();
    L6:
        f275799a = r100;
        f275800b = new b();
        return;
    L5:
        r100 = new d();
        goto L6
    }

    public static h newOutput() {
        return new h(128);
    }

    public final int hashCode() {
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

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new a(this);
    }

    public final String toString() {
        Locale r100 = Locale.ROOT;
        Object[] r101 = new Object[3];
        r101[0] = Integer.toHexString(System.identityHashCode(this));
        r101[1] = Integer.valueOf(size());
        if (size() > 50) goto L5;
        String r102 = com.google.crypto.tink.shaded.protobuf.h.a(this);
    L6:
        r101[2] = r102;
        return String.format(r100, "<ByteString@%s size=%d contents=\"%s\">", r101);
    L5:
        r102 = com.google.crypto.tink.shaded.protobuf.h.a(substring(0, 47)) + "...";
        goto L6
    }

    public final String toStringUtf8() {
        return toString(com.google.crypto.tink.shaded.protobuf.e.f275885a);
    }

    public ByteString() {
        this.hash = 0;
    }

    public final boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final byte[] toByteArray() {
        int r100 = size();
        if (r100 == 0) goto L5;
        byte[] r101 = new byte[r100];
        copyToInternal(r101, 0, 0, r100);
        return r101;
    L5:
        return com.google.crypto.tink.shaded.protobuf.e.f275886b;
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return f275800b;
    }

    public final int peekCachedHashCode() {
        return this.hash;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    public static ByteString copyFrom(Iterable<ByteString> r100) {
        if ((r100 instanceof Collection) == true) goto L8;
        Iterator<ByteString> r101 = r100.iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L9;
        r101.next();
        r102 = r102 + 1;
    L9:
        if (r102 != 0) goto L13;
        return EMPTY;
    L13:
        return a(r100.iterator(), r102);
    L8:
        r102 = ((Collection) r100).size();
        goto L9
    }

    public static ByteString copyFromUtf8(String r100) {
        return new LiteralByteString(r100.getBytes(com.google.crypto.tink.shaded.protobuf.e.f275885a));
    }

    public static ByteString fromHex(String r100) {
        if ((r100.length() % 2) != 0) goto L10;
        int r101 = r100.length() / 2;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L5:
        if (r103 >= r101) goto L8;
        int r104 = r103 * 2;
        r102[r103] = (byte) (c(r100, r104 + 1) | (c(r100, r104) << 4));
        r103 = r103 + 1;
        goto L5
    L8:
        return new LiteralByteString(r102);
    L10:
        throw new NumberFormatException("Invalid hexString " + r100 + " of length " + r100.length() + " must be even.");
    }

    public static g newCodedBuilder(int r100) {
        return new g(r100);
    }

    public static h newOutput(int r100) {
        return new h(r100);
    }

    public static ByteString readFrom(InputStream r100) throws IOException {
        return readFrom(r100, 256, 8192);
    }

    public static ByteString wrap(ByteBuffer r100) {
        if (r100.hasArray() == false) goto L7;
        int r101 = r100.arrayOffset();
        return wrap(r100.array(), r101 + r100.position(), r100.remaining());
    L7:
        return new NioByteString(r100);
    }

    public final ByteString concat(ByteString r100) {
        if ((Integer.MAX_VALUE - size()) < r100.size()) goto L7;
        return RopeByteString.concatenate(this, r100);
    L7:
        throw new IllegalArgumentException("ByteString would be too long: " + size() + Marker.ANY_NON_NULL_MARKER + r100.size());
    }

    public final boolean endsWith(ByteString r100) {
        if (size() >= r100.size()) goto L5;
    L7:
        return false;
    L5:
        if (substring(size() - r100.size()).equals(r100) == false) goto L7;
        return true;
    }

    public final boolean startsWith(ByteString r100) {
        if (size() >= r100.size()) goto L5;
        return false;
    L5:
        if (substring(0, r100.size()).equals(r100) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final ByteString substring(int r100) {
        return substring(r100, size());
    }

    public final String toString(String r100) throws UnsupportedEncodingException {
        return toString(Charset.forName(r100));
    L4:
        e = move-exception;
        UnsupportedEncodingException r101 = new UnsupportedEncodingException(r100);
        r101.initCause(e);
        throw r101;
    }

    public static ByteString copyFrom(ByteBuffer r100) {
        return copyFrom(r100, r100.remaining());
    }

    public static ByteString wrap(byte[] r100) {
        return new LiteralByteString(r100);
    }

    public final String toString(Charset r100) {
        if (size() != 0) goto L6;
        return "";
    L6:
        return toStringInternal(r100);
    }

    public static ByteString copyFrom(byte[] r100) {
        return copyFrom(r100, 0, r100.length);
    }

    public static ByteString a(Iterator<ByteString> r100, int r101) {
        if (r101 < 1) goto L9;
        if (r101 == 1) goto L10;
        int r102 = r101 >>> 1;
        return a(r100, r102).concat(a(r100, r101 - r102));
    L10:
        return r100.next();
    L9:
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(r101)}));
    }

    public static int c(String r100, int r101) {
        char r102 = r100.charAt(r101);
        if (r102 >= '0') goto L5;
    L7:
        char r103 = 'A';
        if (r102 >= 'A') goto L10;
    L12:
        r103 = 'a';
        if (r102 >= 'a') goto L15;
    L17:
        int r104 = -1;
    L18:
        if (r104 == (-1)) goto L21;
        return r104;
    L21:
        throw new NumberFormatException("Invalid hexString " + r100 + " must only contain [0-9a-fA-F] but contained " + r100.charAt(r101) + " at index " + r101);
    L15:
        if (r102 > 'f') goto L17;
    L16:
        r104 = (r102 - r103) + 10;
        goto L18
    L10:
        if (r102 > 'F') goto L12;
    L5:
        if (r102 > '9') goto L7;
        r104 = r102 - '0';
        goto L18
    }

    public static void checkIndex(int r100, int r101) {
        if (((r101 - (r100 + 1)) | r100) >= 0) goto L9;
        if (r100 >= 0) goto L8;
        throw new ArrayIndexOutOfBoundsException("Index < 0: " + r100);
    L8:
        throw new ArrayIndexOutOfBoundsException("Index > length: " + r100 + ", " + r101);
    }

    public static ByteString copyFrom(ByteBuffer r100, int r101) {
        checkRange(0, r101, r100.remaining());
        byte[] r102 = new byte[r101];
        r100.get(r102);
        return new LiteralByteString(r102);
    }

    public static ByteString readFrom(InputStream r100, int r101) throws IOException {
        return readFrom(r100, r101, r101);
    }

    public void copyTo(byte[] r100, int r101) {
        copyTo(r100, 0, r101, size());
    }

    public static ByteString copyFrom(String r100, String r101) throws UnsupportedEncodingException {
        return new LiteralByteString(r100.getBytes(r101));
    }

    public static ByteString copyFrom(String r100, Charset r101) {
        return new LiteralByteString(r100.getBytes(r101));
    }

    public static int checkRange(int r100, int r101, int r102) {
        int r103 = r101 - r100;
        if ((((r100 | r101) | r103) | (r102 - r101)) >= 0) goto L12;
        if (r100 < 0) goto L11;
        if (r101 >= r100) goto L9;
        throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + r100 + ", " + r101);
    L9:
        throw new IndexOutOfBoundsException("End index: " + r101 + " >= " + r102);
    L11:
        throw new IndexOutOfBoundsException("Beginning index: " + r100 + " < 0");
    L12:
        return r103;
    }

    public static ByteString copyFrom(byte[] r100, int r101, int r102) {
        checkRange(r101, r101 + r102, r100.length);
        return new LiteralByteString(f275799a.copyFrom(r100, r101, r102));
    }

    public static ByteString readFrom(InputStream r100, int r101, int r102) throws IOException {
        ArrayList r103 = new ArrayList();
    L3:
        byte[] r104 = new byte[r101];
        int r105 = 0;
    L4:
        if (r105 >= r101) goto L9;
        int r106 = r100.read(r104, r105, r101 - r105);
        if (r106 == (-1)) goto L9;
        r105 = r105 + r106;
    L9:
        if (r105 != 0) goto L11;
        ByteString r107 = null;
    L12:
        if (r107 == null) goto L14;
        r103.add(r107);
        r101 = Math.min(r101 * 2, r102);
        goto L3
    L14:
        return copyFrom(r103);
    L11:
        r107 = copyFrom(r104, 0, r105);
        goto L12
    }

    public static ByteString wrap(byte[] r100, int r101, int r102) {
        return new BoundedByteString(r100, r101, r102);
    }

    public final void writeTo(OutputStream r100, int r101, int r102) throws IOException {
        checkRange(r101, r101 + r102, size());
        if (r102 <= 0) goto L6;
        writeToInternal(r100, r101, r102);
        return;
    }

    public final void copyTo(byte[] r100, int r101, int r102, int r103) {
        checkRange(r101, r101 + r103, size());
        checkRange(r102, r102 + r103, r100.length);
        if (r103 <= 0) goto L6;
        copyToInternal(r100, r101, r102, r103);
        return;
    }
}
