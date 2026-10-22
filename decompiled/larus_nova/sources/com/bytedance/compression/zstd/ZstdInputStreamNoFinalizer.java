package com.bytedance.compression.zstd;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes15.dex */
class ZstdInputStreamNoFinalizer extends FilterInputStream {
    private static final int srcBuffSize = 0;
    private final b bufferPool;
    private long dstPos;
    private boolean frameFinished;
    private boolean isClosed;
    private boolean isContinuous;
    private boolean needRead;

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    private final byte[] f203092src;
    private final ByteBuffer srcByteBuffer;
    private long srcPos;
    private long srcSize;
    private final long stream;

    private static native long createDStream();

    private native int decompressStream(long r100, byte[] r101, int r102, byte[] r103, int r104);

    private static native int freeDStream(long r100);

    private native int initDStream(long r100);

    public static native long recommendedDInSize();

    public static native long recommendedDOutSize();

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L14;
        if (this.needRead == true) goto L10;
        monitor-exit(this);
        return 1;
    L10:
        int r100 = ((FilterInputStream) this).in.available();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r100;
    L14:
        throw new IOException("Stream closed");     // Catch: Throwable -> L15
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.isClosed = true;     // Catch: Throwable -> L11
        this.bufferPool.getClass();     // Catch: Throwable -> L11
        freeDStream(this.stream);     // Catch: Throwable -> L11
        ((FilterInputStream) this).in.close();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized boolean getContinuous() {
        monitor-enter(this);
        boolean r100 = this.isContinuous;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        monitor-enter(this);
        byte[] r100 = new byte[1];     // Catch: Throwable -> L15
        int r101 = 0;
    L5:
        if (r101 != 0) goto L7;
        r101 = readInternal(r100, 0, 1);     // Catch: Throwable -> L15
        goto L5
    L7:
        if (r101 != 1) goto L12;
        int r102 = r100[0] & UByte.MAX_VALUE;
        monitor-exit(this);
        return r102;
    L12:
        monitor-exit(this);
        return -1;
    L15:
        th = move-exception;
        throw th;
    }

    static {
        vg4.a.b();
        srcBuffSize = (int) recommendedDInSize();
    }

    public ZstdInputStreamNoFinalizer(InputStream r100) throws IOException {
        this(r100, c.f203093a);
    }

    public synchronized ZstdInputStreamNoFinalizer setContinuous(boolean r100) {
        monitor-enter(this);
        this.isContinuous = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ZstdInputStreamNoFinalizer setDict(ZstdDictDecompress r100) throws IOException {
        monitor-enter(this);
        r100.acquireSharedLock();     // Catch: Throwable -> L15
        long r101 = ZstdDecompress.loadFastDictDecompress(this.stream, r100);     // Catch: Throwable -> L12
        if (Zstd.isError(r101) == true) goto L11;
        r100.releaseSharedLock();     // Catch: Throwable -> L15
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r101));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r100.releaseSharedLock();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long r100) throws IOException {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L28;
        if (r100 > 0) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        int r101 = (int) recommendedDOutSize();     // Catch: Throwable -> L29
        if (r101 <= r100) goto L12;
        r101 = (int) r100;     // Catch: Throwable -> L29
    L12:
        ((c) this.bufferPool).getClass();     // Catch: Throwable -> L29
        byte[] r102 = Zstd.extractArray(ByteBuffer.allocate(r101));     // Catch: Throwable -> L24
        long r103 = r100;
    L15:
        if (r103 <= 0) goto L20;
        int r104 = read(r102, 0, (int) Math.min(r101, r103));     // Catch: Throwable -> L24
        if (r104 < 0) goto L20;
        r103 = r103 - ((long) r104);
        goto L15
    L20:
        this.bufferPool.getClass();     // Catch: Throwable -> L29
        long r105 = r100 - r103;
        monitor-exit(this);
        return r105;
    L24:
        th = move-exception;
        this.bufferPool.getClass();     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L28:
        throw new IOException("Stream closed");     // Catch: Throwable -> L29
    }

    public synchronized ZstdInputStreamNoFinalizer setDict(byte[] r100) throws IOException {
        monitor-enter(this);
        long r101 = ZstdDecompress.loadDictDecompress(this.stream, r100, r100.length);     // Catch: Throwable -> L10
        if (Zstd.isError(r101) == true) goto L9;
        monitor-exit(this);
        return this;
    L9:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r101));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ZstdInputStreamNoFinalizer(InputStream r100, b r101) throws IOException {
        super(r100);
        this.dstPos = 0;
        this.srcPos = 0;
        this.srcSize = 0;
        this.needRead = true;
        this.isContinuous = false;
        this.frameFinished = true;
        this.isClosed = false;
        this.bufferPool = r101;
        int r102 = srcBuffSize;
        ((c) r101).getClass();
        ByteBuffer r103 = ByteBuffer.allocate(r102);
        this.srcByteBuffer = r103;
        if (r103 == null) goto L13;
        this.f203092src = Zstd.extractArray(r103);
        monitor-enter(this);
        long r104 = createDStream();     // Catch: Throwable -> L9
        this.stream = r104;     // Catch: Throwable -> L9
        initDStream(r104);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IOException("Cannot get ByteBuffer of size " + r102 + " from the BufferPool");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r100, int r101, int r102) throws IOException {
        monitor-enter(this);
        if (r101 < 0) goto L18;
    L19:
        th = move-exception;
        throw th;
    L7:
        if (r102 > (r100.length - r101)) goto L18;
        int r103 = 0;
        if (r102 != 0) goto L12;
        monitor-exit(this);
        return 0;
    L12:
        if (r103 != 0) goto L15;
        r103 = readInternal(r100, r101, r102);     // Catch: Throwable -> L19
        goto L12
    L15:
        monitor-exit(this);
        return r103;
    L18:
        throw new IndexOutOfBoundsException("Requested length " + r102 + " from offset " + r101 + " in buffer of size " + r100.length);     // Catch: Throwable -> L19
    }

    public int readInternal(byte[] r210, int r211, int r212) throws IOException {
        if (this.isClosed == true) goto L53;
        if (r211 < 0) goto L51;
        if (r212 > (r210.length - r211)) goto L51;
        int r100 = r211 + r212;
        long r110 = r211;
        this.dstPos = r110;
        long r101 = -1;
    L8:
        long r102 = this.dstPos;
        long r111 = r100;
        if (r102 >= r111) goto L49;
        if (r101 >= r102) goto L49;
        boolean r112 = false;
        if (this.needRead == true) goto L15;
    L33:
        long r103 = this.dstPos;
        int r104 = decompressStream(this.stream, r210, r100, this.f203092src, (int) this.srcSize);
        long r105 = r104;
        if (Zstd.isError(r105) == true) goto L47;
        if (r104 == 0) goto L37;
        if (this.dstPos >= r111) goto L45;
        r112 = true;
    L45:
        this.needRead = r112;
        r101 = r103;
        goto L8
    L37:
        this.frameFinished = true;
        if (this.srcPos != this.srcSize) goto L40;
        r112 = true;
    L40:
        this.needRead = r112;
        return (int) (this.dstPos - r110);
    L47:
        throw new IOException("Decompression error: " + Zstd.getErrorName(r105));
    L15:
        if (((FilterInputStream) this).in.available() <= 0) goto L17;
    L18:
        long r106 = ((FilterInputStream) this).in.read(this.f203092src, 0, srcBuffSize);
        this.srcSize = r106;
        this.srcPos = 0;
        if (r106 < 0) goto L20;
        this.frameFinished = false;
        goto L33
    L20:
        this.srcSize = 0;
        if (this.frameFinished == false) goto L24;
        return -1;
    L24:
        if (this.isContinuous == false) goto L31;
        long r107 = (int) (this.dstPos - r110);
        this.srcSize = r107;
        if (r107 > 0) goto L28;
        return -1;
    L28:
        return (int) r107;
    L31:
        throw new IOException("Read error or truncated source");
    L17:
        if (this.dstPos != r110) goto L33;
    L49:
        return (int) (r102 - r110);
    L51:
        throw new IndexOutOfBoundsException("Requested length " + r212 + " from offset " + r211 + " in buffer of size " + r210.length);
    L53:
        throw new IOException("Stream closed");
    }
}
