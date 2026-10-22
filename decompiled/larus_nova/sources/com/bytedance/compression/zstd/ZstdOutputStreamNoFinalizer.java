package com.bytedance.compression.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes15.dex */
class ZstdOutputStreamNoFinalizer extends FilterOutputStream {
    private static final int dstSize = 0;
    private final b bufferPool;
    private boolean closeFrameOnFlush;
    private final byte[] dst;
    private final ByteBuffer dstByteBuffer;
    private long dstPos;
    private boolean frameClosed;
    private boolean isClosed;
    private long srcPos;
    private final long stream;

    private native int compressStream(long r100, byte[] r101, int r102, byte[] r103, int r104);

    private static native long createCStream();

    private native int endStream(long r100, byte[] r101, int r102);

    private native int flushStream(long r100, byte[] r101, int r102);

    private static native int freeCStream(long r100);

    public static native long recommendedCOutSize();

    private native int resetCStream(long r100);

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        close(true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void closeWithoutClosingParentStream() throws IOException {
        monitor-enter(this);
        close(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L26;
        if (this.frameClosed == false) goto L8;
    L23:
        monitor-exit(this);
        return;
    L8:
        if (this.closeFrameOnFlush == false) goto L16;
    L9:
        int r100 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L27
        long r101 = r100;
        if (Zstd.isError(r101) == true) goto L15;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L27
        if (r100 > 0) goto L9;
        this.frameClosed = true;     // Catch: Throwable -> L27
    L20:
        ((FilterOutputStream) this).out.flush();     // Catch: Throwable -> L27
        goto L23
    L15:
        throw new IOException("Compression error: " + Zstd.getErrorName(r101));     // Catch: Throwable -> L27
    L16:
        int r102 = flushStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L27
        long r103 = r102;
        if (Zstd.isError(r103) == true) goto L22;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L27
        if (r102 > 0) goto L16;
    L22:
        throw new IOException("Compression error: " + Zstd.getErrorName(r103));     // Catch: Throwable -> L27
    L26:
        throw new IOException("Stream closed");     // Catch: Throwable -> L27
    }

    static {
        vg4.a.b();
        dstSize = (int) recommendedCOutSize();
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r100) throws IOException {
        this(r100, c.f203093a);
    }

    private void close(boolean r100) throws IOException {
        if (this.isClosed == false) goto L22;
        return;
    L22:
    L19:
        th = move-exception;
        this.isClosed = true;
        this.bufferPool.getClass();
        freeCStream(this.stream);
        throw th;
    L7:
        if (this.frameClosed == true) goto L15;
    L8:
        int r101 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L19
        long r102 = r101;
        if (Zstd.isError(r102) == true) goto L14;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L19
        if (r101 > 0) goto L8;
    L14:
        throw new IOException("Compression error: " + Zstd.getErrorName(r102));     // Catch: Throwable -> L19
    L15:
        if (r100 == false) goto L17;
        ((FilterOutputStream) this).out.close();     // Catch: Throwable -> L19
    L17:
        this.isClosed = true;
        this.bufferPool.getClass();
        freeCStream(this.stream);
    }

    public synchronized ZstdOutputStreamNoFinalizer setChecksum(boolean r100) throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r101 = ZstdCompress.setCompressionChecksums(this.stream, r100);     // Catch: Throwable -> L14
        if (Zstd.isError(r101) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r101));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    public synchronized ZstdOutputStreamNoFinalizer setCloseFrameOnFlush(boolean r100) throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L9;
        this.closeFrameOnFlush = r100;     // Catch: Throwable -> L10
        monitor-exit(this);
        return this;
    L9:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L10
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(byte[] r100) throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r101 = ZstdCompress.loadDictCompress(this.stream, r100, r100.length);     // Catch: Throwable -> L14
        if (Zstd.isError(r101) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r101));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    public synchronized ZstdOutputStreamNoFinalizer setLevel(int r100) throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r101 = ZstdCompress.setCompressionLevel(this.stream, r100);     // Catch: Throwable -> L14
        if (Zstd.isError(r101) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r101));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    public synchronized ZstdOutputStreamNoFinalizer setLong(int r100) throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r101 = ZstdCompress.setCompressionLong(this.stream, r100);     // Catch: Throwable -> L14
        if (Zstd.isError(r101) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r101));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    public synchronized ZstdOutputStreamNoFinalizer setWorkers(int r100) throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r101 = ZstdCompress.setCompressionWorkers(this.stream, r100);     // Catch: Throwable -> L14
        if (Zstd.isError(r101) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r101));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r100) throws IOException {
        write(new byte[]{(byte) r100}, 0, 1);
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(ZstdDictCompress r100) throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L13;
        long r101 = ZstdCompress.loadFastDictCompress(this.stream, r100);     // Catch: Throwable -> L14
        if (Zstd.isError(r101) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r101));     // Catch: Throwable -> L14
    L13:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L14
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r100, b r101) throws IOException {
        super(r100);
        this.srcPos = 0;
        this.dstPos = 0;
        this.isClosed = false;
        this.closeFrameOnFlush = false;
        this.frameClosed = true;
        this.stream = createCStream();
        this.bufferPool = r101;
        int r102 = dstSize;
        ((c) r101).getClass();
        ByteBuffer r103 = ByteBuffer.allocate(r102);
        this.dstByteBuffer = r103;
        if (r103 == null) goto L7;
        this.dst = Zstd.extractArray(r103);
        return;
    L7:
        throw new IOException("Cannot get ByteBuffer of size " + r102 + " from the BufferPool");
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r100, int r101) throws IOException {
        this(r100, c.f203093a);
        ZstdCompress.setCompressionLevel(this.stream, r101);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r100, b r101, int r102) throws IOException {
        this(r100, r101);
        ZstdCompress.setCompressionLevel(this.stream, r102);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] r110, int r111, int r112) throws IOException {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.isClosed == true) goto L26;
        if (this.frameClosed == false) goto L13;
        long r100 = resetCStream(this.stream);     // Catch: Throwable -> L27
        if (Zstd.isError(r100) == true) goto L12;
        this.frameClosed = false;     // Catch: Throwable -> L27
        goto L13
    L12:
        throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName(r100));     // Catch: Throwable -> L27
    L13:
        int r113 = r112 + r111;     // Catch: Throwable -> L27
        this.srcPos = r111;     // Catch: Throwable -> L27
    L15:
        if (this.srcPos >= r113) goto L23;
        long r101 = compressStream(this.stream, this.dst, dstSize, r110, r113);     // Catch: Throwable -> L27
        if (Zstd.isError(r101) == true) goto L22;
        long r102 = this.dstPos;     // Catch: Throwable -> L27
        if (r102 <= 0) goto L15;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) r102);     // Catch: Throwable -> L27
        goto L15
    L22:
        throw new IOException("Compression error: " + Zstd.getErrorName(r101));     // Catch: Throwable -> L27
    L23:
        monitor-exit(this);
        return;
    L26:
        throw new IOException("Stream closed");     // Catch: Throwable -> L27
    }
}
