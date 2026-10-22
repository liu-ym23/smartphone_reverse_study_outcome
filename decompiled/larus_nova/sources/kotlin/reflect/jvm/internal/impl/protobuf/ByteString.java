package kotlin.reflect.jvm.internal.impl.protobuf;

import androidx.collection.SieveCacheKt;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ByteString implements Iterable<Byte> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ByteString EMPTY = null;

    /* JADX INFO: loaded from: classes42.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
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

    public ByteString() {
    }

    public abstract void copyToInternal(byte[] r100, int r101, int r102, int r103);

    public abstract int getTreeDepth();

    public abstract boolean isBalanced();

    public abstract boolean isValidUtf8();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Iterable
    public abstract Iterator<Byte> iterator();

    public abstract CodedInputStream newCodedInput();

    public abstract int partialHash(int r100, int r101, int r102);

    public abstract int partialIsValidUtf8(int r100, int r101, int r102);

    public abstract int peekCachedHashCode();

    public abstract int size();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public abstract String toString(String r100) throws UnsupportedEncodingException;

    public abstract void writeToInternal(OutputStream r100, int r101, int r102) throws IOException;

    static {
        EMPTY = new LiteralByteString(new byte[0]);
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public String toStringUtf8() {
        return toString("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator();
    }

    public byte[] toByteArray() {
        int r100 = size();
        if (r100 == 0) goto L5;
        byte[] r101 = new byte[r100];
        copyToInternal(r101, 0, 0, r100);
        return r101;
    L5:
        return Internal.EMPTY_BYTE_ARRAY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    public static ByteString copyFrom(Iterable<ByteString> r100) {
        if ((r100 instanceof Collection) == true) goto L8;
        ?? r101 = new ArrayList();
        Iterator<ByteString> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        r101.add(r102.next());
    L10:
        if (r101.isEmpty() == false) goto L13;
        return EMPTY;
    L13:
        return balancedConcat(r101.iterator(), r101.size());
    L8:
        r101 = (Collection) r100;
        goto L10
    }

    public static ByteString copyFromUtf8(String r100) {
        return new LiteralByteString(r100.getBytes("UTF-8"));
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public ByteString concat(ByteString r100) {
        int r101 = size();
        int r102 = r100.size();
        if ((((long) r101) + ((long) r102)) < SieveCacheKt.NodeLinkMask) goto L5;
        StringBuilder r103 = new StringBuilder(53);
        r103.append("ByteString would be too long: ");
        r103.append(r101);
        r103.append(Marker.ANY_NON_NULL_MARKER);
        r103.append(r102);
        throw new IllegalArgumentException(r103.toString());
    L5:
        return RopeByteString.concatenate(this, r100);
    }

    public static ByteString copyFrom(byte[] r100) {
        return copyFrom(r100, 0, r100.length);
    }

    private static ByteString balancedConcat(Iterator<ByteString> r100, int r101) {
        if (r101 == 1) goto L7;
        int r102 = r101 >>> 1;
        return balancedConcat(r100, r102).concat(balancedConcat(r100, r101 - r102));
    L7:
        return r100.next();
    }

    public static ByteString copyFrom(byte[] r100, int r101, int r102) {
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, r101, r103, 0, r102);
        return new LiteralByteString(r103);
    }

    public void writeTo(OutputStream r100, int r101, int r102) throws IOException {
        if (r101 < 0) goto L13;
        if (r102 < 0) goto L11;
        int r103 = r101 + r102;
        if (r103 > size()) goto L9;
        if (r102 <= 0) goto L15;
        writeToInternal(r100, r101, r102);
        return;
    L15:
        return;
    L9:
        StringBuilder r104 = new StringBuilder(39);
        r104.append("Source end offset exceeded: ");
        r104.append(r103);
        throw new IndexOutOfBoundsException(r104.toString());
    L11:
        StringBuilder r105 = new StringBuilder(23);
        r105.append("Length < 0: ");
        r105.append(r102);
        throw new IndexOutOfBoundsException(r105.toString());
    L13:
        StringBuilder r106 = new StringBuilder(30);
        r106.append("Source offset < 0: ");
        r106.append(r101);
        throw new IndexOutOfBoundsException(r106.toString());
    }

    public void copyTo(byte[] r100, int r101, int r102, int r103) {
        if (r101 < 0) goto L21;
        if (r102 < 0) goto L19;
        if (r103 < 0) goto L17;
        int r104 = r101 + r103;
        if (r104 > size()) goto L15;
        int r105 = r102 + r103;
        if (r105 > r100.length) goto L13;
        if (r103 <= 0) goto L23;
        copyToInternal(r100, r101, r102, r103);
        return;
    L23:
        return;
    L13:
        StringBuilder r106 = new StringBuilder(34);
        r106.append("Target end offset < 0: ");
        r106.append(r105);
        throw new IndexOutOfBoundsException(r106.toString());
    L15:
        StringBuilder r107 = new StringBuilder(34);
        r107.append("Source end offset < 0: ");
        r107.append(r104);
        throw new IndexOutOfBoundsException(r107.toString());
    L17:
        StringBuilder r108 = new StringBuilder(23);
        r108.append("Length < 0: ");
        r108.append(r103);
        throw new IndexOutOfBoundsException(r108.toString());
    L19:
        StringBuilder r109 = new StringBuilder(30);
        r109.append("Target offset < 0: ");
        r109.append(r102);
        throw new IndexOutOfBoundsException(r109.toString());
    L21:
        StringBuilder r110 = new StringBuilder(30);
        r110.append("Source offset < 0: ");
        r110.append(r101);
        throw new IndexOutOfBoundsException(r110.toString());
    }
}
