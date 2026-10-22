package com.google.protobuf;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = null;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final ByteArrayCopier byteArrayCopier = null;
    private int hash;

    public static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        public /* synthetic */ ArraysByteArrayCopier(AnonymousClass1 r100) {
            this();
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] r100, int r101, int r102) {
            return Arrays.copyOfRange(r100, r101, r102 + r101);
        }
    }

    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        public Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        private void readObject(ObjectInputStream r100) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte byteAt(int r100) {
            ByteString.checkIndex(r100, size());
            return this.bytes[this.bytesOffset + r100];
        }

        public BoundedByteString(byte[] r100, int r101, int r102) {
            super(r100);
            ByteString.checkRange(r101, r101 + r102, r100.length);
            this.bytesOffset = r101;
            this.bytesLength = r102;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public void copyToInternal(byte[] r100, int r101, int r102, int r103) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + r101, r100, r102, r103);
        }
    }

    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] r100, int r101, int r102);
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    public static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }

        private CodedBuilder(int r100) {
            byte[] r101 = new byte[r100];
            this.buffer = r101;
            this.output = CodedOutputStream.newInstance(r101);
        }

        public /* synthetic */ CodedBuilder(int r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static abstract class LeafByteString extends ByteString {
        public abstract boolean equalsRange(ByteString r100, int r101, int r102);

        @Override // com.google.protobuf.ByteString
        public final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isBalanced() {
            return true;
        }

        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }

        public LeafByteString() {
        }
    }

    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        public int getOffsetIntoBytes() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int r100 = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, r100, size() + r100);
        }

        public LiteralByteString(byte[] r100) {
            this.bytes = r100;
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int r100) {
            return this.bytes[r100];
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer r100) {
            r100.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
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

        @Override // com.google.protobuf.ByteString
        public final String toStringInternal(Charset r100) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), r100);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(ByteOutput r100) throws IOException {
            r100.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(OutputStream r100) throws IOException {
            r100.write(toByteArray());
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int r100, int r101) {
            int r102 = ByteString.checkRange(r100, r101, size());
            if (r102 != 0) goto L7;
            return ByteString.EMPTY;
        L7:
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + r100, r102);
        }

        @Override // com.google.protobuf.ByteString.LeafByteString
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

        @Override // com.google.protobuf.ByteString
        public final int partialHash(int r100, int r101, int r102) {
            return Internal.partialHash(r100, this.bytes, getOffsetIntoBytes() + r101, r102);
        }

        @Override // com.google.protobuf.ByteString
        public final int partialIsValidUtf8(int r100, int r101, int r102) {
            int r103 = getOffsetIntoBytes() + r101;
            return Utf8.partialIsValidUtf8(r100, this.bytes, r103, r102 + r103);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeToInternal(OutputStream r100, int r101, int r102) throws IOException {
            r100.write(this.bytes, getOffsetIntoBytes() + r101, r102);
        }

        @Override // com.google.protobuf.ByteString
        public void copyToInternal(byte[] r100, int r101, int r102, int r103) {
            System.arraycopy(this.bytes, r101, r100, r102, r103);
        }
    }

    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = null;
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        static {
            EMPTY_BYTE_ARRAY = new byte[0];
        }

        public synchronized void reset() {
            monitor-enter(this);
            this.flushedBuffers.clear();     // Catch: Throwable -> L6
            this.flushedBuffersTotalBytes = 0;     // Catch: Throwable -> L6
            this.bufferPos = 0;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized int size() {
            monitor-enter(this);
            int r100 = this.flushedBuffersTotalBytes + this.bufferPos;
            monitor-exit(this);
            return r100;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized ByteString toByteString() {
            monitor-enter(this);
            flushLastBuffer();     // Catch: Throwable -> L6
            ByteString r100 = ByteString.copyFrom(this.flushedBuffers);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        private void flushLastBuffer() {
            int r100 = this.bufferPos;
            byte[] r101 = this.buffer;
            if (r100 >= r101.length) goto L6;
            if (r100 <= 0) goto L7;
            this.flushedBuffers.add(new LiteralByteString(copyArray(r101, r100)));
        L7:
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
            return;
        L6:
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.buffer = EMPTY_BYTE_ARRAY;
            goto L7
        }

        public Output(int r100) {
            if (r100 < 0) goto L7;
            this.initialCapacity = r100;
            this.flushedBuffers = new ArrayList();
            this.buffer = new byte[r100];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private void flushFullBuffer(int r100) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int r101 = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = r101;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(r100, r101 >>> 1))];
            this.bufferPos = 0;
        }

        @Override // java.io.OutputStream
        public synchronized void write(int r100) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.bufferPos != this.buffer.length) goto L6;
            flushFullBuffer(1);     // Catch: Throwable -> L9
        L6:
            byte[] r101 = this.buffer;     // Catch: Throwable -> L9
            int r102 = this.bufferPos;     // Catch: Throwable -> L9
            this.bufferPos = r102 + 1;     // Catch: Throwable -> L9
            r101[r102] = (byte) r100;     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        public void writeTo(OutputStream r100) throws IOException {
            monitor-enter(this);
            ArrayList<ByteString> r101 = this.flushedBuffers;     // Catch: Throwable -> L10
            ByteString[] r102 = (ByteString[]) r101.toArray(new ByteString[r101.size()]);     // Catch: Throwable -> L10
            byte[] r103 = this.buffer;     // Catch: Throwable -> L10
            int r104 = this.bufferPos;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            int r105 = r102.length;
            int r106 = 0;
        L6:
            if (r106 >= r105) goto L8;
            r102[r106].writeTo(r100);
            r106 = r106 + 1;
            goto L6
        L8:
            r100.write(copyArray(r103, r104));
            return;
        L10:
            th = move-exception;
            throw th;
        }

        private byte[] copyArray(byte[] r100, int r101) {
            byte[] r102 = new byte[r101];
            System.arraycopy(r100, 0, r102, 0, Math.min(r100.length, r101));
            return r102;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] r100, int r101, int r102) {
            monitor-enter(this);
            byte[] r103 = this.buffer;     // Catch: Throwable -> L9
            int r104 = r103.length;     // Catch: Throwable -> L9
            int r105 = this.bufferPos;     // Catch: Throwable -> L9
            if (r102 > (r104 - r105)) goto L6;
            System.arraycopy(r100, r101, r103, r105, r102);     // Catch: Throwable -> L9
            this.bufferPos += r102;     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L6:
            int r106 = r103.length - r105;     // Catch: Throwable -> L9
            System.arraycopy(r100, r101, r103, r105, r106);     // Catch: Throwable -> L9
            int r107 = r102 - r106;     // Catch: Throwable -> L9
            flushFullBuffer(r107);     // Catch: Throwable -> L9
            System.arraycopy(r100, r101 + r106, this.buffer, 0, r107);     // Catch: Throwable -> L9
            this.bufferPos = r107;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        public /* synthetic */ SystemByteArrayCopier(AnonymousClass1 r100) {
            this();
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] r100, int r101, int r102) {
            byte[] r103 = new byte[r102];
            System.arraycopy(r100, r101, r103, 0, r102);
            return r103;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int r100);

    public abstract void copyTo(ByteBuffer r100);

    public abstract void copyToInternal(byte[] r100, int r101, int r102, int r103);

    public abstract boolean equals(Object r100);

    public abstract int getTreeDepth();

    public abstract boolean isBalanced();

    public abstract boolean isValidUtf8();

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int r100, int r101, int r102);

    public abstract int partialIsValidUtf8(int r100, int r101, int r102);

    public abstract int size();

    public abstract ByteString substring(int r100, int r101);

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public abstract String toStringInternal(Charset r100);

    public abstract void writeTo(ByteOutput r100) throws IOException;

    public abstract void writeTo(OutputStream r100) throws IOException;

    public abstract void writeToInternal(OutputStream r100, int r101, int r102) throws IOException;

    static {
        EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
        INVOKESTATIC_com_google_protobuf_ByteString_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.Context");     // Catch: ClassNotFoundException -> L5
        boolean r100 = true;
    L6:
        AnonymousClass1 r101 = null;
        if (r100 == false) goto L9;
        ByteArrayCopier r102 = new SystemByteArrayCopier(r101);
    L10:
        byteArrayCopier = r102;
        return;
    L9:
        r102 = new ArraysByteArrayCopier(r101);
    L5:
        r100 = false;
        goto L6
    }

    public static Output newOutput() {
        return new Output(128);
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
    public final Iterator<Byte> iterator() {
        return new AnonymousClass1(this);
    }

    public final String toStringUtf8() {
        return toString(Internal.UTF_8);
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
        return Internal.EMPTY_BYTE_ARRAY;
    }

    public final int peekCachedHashCode() {
        return this.hash;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_google_protobuf_ByteString_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
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
        return balancedConcat(r100.iterator(), r102);
    L8:
        r102 = ((Collection) r100).size();
        goto L9
    }

    public static ByteString copyFromUtf8(String r100) {
        return new LiteralByteString(r100.getBytes(Internal.UTF_8));
    }

    public static CodedBuilder newCodedBuilder(int r100) {
        return new CodedBuilder(r100, null);
    }

    public static Output newOutput(int r100) {
        return new Output(r100);
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

    private static ByteString balancedConcat(Iterator<ByteString> r100, int r101) {
        if (r101 < 1) goto L9;
        if (r101 == 1) goto L10;
        int r102 = r101 >>> 1;
        return balancedConcat(r100, r102).concat(balancedConcat(r100, r101 - r102));
    L10:
        return r100.next();
    L9:
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(r101)}));
    }

    public static void checkIndex(int r100, int r101) {
        if (((r101 - (r100 + 1)) | r100) >= 0) goto L9;
        if (r100 >= 0) goto L8;
        throw new ArrayIndexOutOfBoundsException("Index < 0: " + r100);
    L8:
        throw new ArrayIndexOutOfBoundsException("Index > length: " + r100 + ", " + r101);
    }

    public static ByteString copyFrom(ByteBuffer r100, int r101) {
        byte[] r102 = new byte[r101];
        r100.get(r102);
        return new LiteralByteString(r102);
    }

    private static ByteString readChunk(InputStream r100, int r101) throws IOException {
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L8;
        int r104 = r100.read(r102, r103, r101 - r103);
        if (r104 == (-1)) goto L8;
        r103 = r103 + r104;
    L8:
        if (r103 != 0) goto L12;
        return null;
    L12:
        return copyFrom(r102, 0, r103);
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
        return new LiteralByteString(byteArrayCopier.copyFrom(r100, r101, r102));
    }

    public static ByteString readFrom(InputStream r100, int r101, int r102) throws IOException {
        ArrayList r103 = new ArrayList();
    L3:
        ByteString r104 = readChunk(r100, r101);
        if (r104 == null) goto L6;
        r103.add(r104);
        r101 = Math.min(r101 * 2, r102);
        goto L3
    L6:
        return copyFrom(r103);
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
