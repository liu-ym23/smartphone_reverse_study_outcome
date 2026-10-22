package com.ss.android.socialbase.downloader.segment;

/* JADX INFO: loaded from: classes38.dex */
class BufferQueue implements IInput, IOutput, IBufferPool {
    private static final int MIN_BUFFER_COUNT = 64;
    private static final int MIN_BUFFER_SIZE = 8192;
    private int bufferCount;
    private final int bufferSize;
    private volatile boolean closed;
    private final int maxBufferCount;
    private Buffer rHead;
    private final Object rLock;
    private Buffer rSafe;
    private Buffer rTail;
    private Buffer wHead;
    private final Object wLock;
    private Buffer wTail;

    public void close() {
        this.closed = true;
        Object r100 = this.wLock;
        monitor-enter(r100);
        this.wLock.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        Object r101 = this.rLock;
        monitor-enter(r101);
        this.rLock.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IBufferPool
    public Buffer obtain() throws StreamClosedException, InterruptedException {
        Object r100 = this.wLock;
        monitor-enter(r100);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.closed == true) goto L27;
        Buffer r101 = this.wHead;     // Catch: Throwable -> L28
        if (r101 != null) goto L20;
        int r102 = this.bufferCount;     // Catch: Throwable -> L28
        if (r102 >= this.maxBufferCount) goto L13;
        this.bufferCount = r102 + 1;     // Catch: Throwable -> L28
        Buffer r103 = new Buffer(this.bufferSize);     // Catch: Throwable -> L28
        monitor-exit(r100);     // Catch: Throwable -> L28
        return r103;
    L13:
        this.wLock.wait();     // Catch: Throwable -> L28
        if (this.closed == true) goto L19;
        r101 = this.wHead;     // Catch: Throwable -> L28
        if (r101 == null) goto L13;
    L19:
        throw new StreamClosedException("obtain");     // Catch: Throwable -> L28
    L20:
        this.wHead = r101.next;     // Catch: Throwable -> L28
        if (r101 != this.wTail) goto L23;
        this.wTail = null;     // Catch: Throwable -> L28
    L23:
        r101.next = null;     // Catch: Throwable -> L28
        monitor-exit(r100);     // Catch: Throwable -> L28
        return r101;
    L27:
        throw new StreamClosedException("obtain");     // Catch: Throwable -> L28
    }

    @Override // com.ss.android.socialbase.downloader.segment.IInput
    public Buffer read() throws StreamClosedException, InterruptedException {
        Buffer r100 = this.rSafe;
        if (r100 == null) goto L6;
        this.rSafe = r100.next;
        r100.next = null;
        return r100;
    L6:
        Object r101 = this.rLock;
        monitor-enter(r101);
        Buffer r102 = this.rHead;     // Catch: Throwable -> L18
    L9:
        if (r102 != null) goto L15;
        if (this.closed == true) goto L14;
        this.rLock.wait();     // Catch: Throwable -> L18
        r102 = this.rHead;     // Catch: Throwable -> L18
        goto L9
    L14:
        throw new StreamClosedException("read");     // Catch: Throwable -> L18
    L15:
        this.rSafe = r102.next;     // Catch: Throwable -> L18
        this.rTail = null;     // Catch: Throwable -> L18
        this.rHead = null;     // Catch: Throwable -> L18
        r102.next = null;     // Catch: Throwable -> L18
        monitor-exit(r101);     // Catch: Throwable -> L18
        return r102;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IBufferPool
    public void recycle(Buffer r100) {
        Object r101 = this.wLock;
        monitor-enter(r101);
        Buffer r102 = this.wTail;     // Catch: Throwable -> L11
        if (r102 != null) goto L7;
        this.wTail = r100;     // Catch: Throwable -> L11
        this.wHead = r100;     // Catch: Throwable -> L11
    L8:
        this.wLock.notify();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L7:
        r102.next = r100;     // Catch: Throwable -> L11
        this.wTail = r100;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(Buffer r100) {
        Object r101 = this.rLock;
        monitor-enter(r101);
        Buffer r102 = this.rTail;     // Catch: Throwable -> L10
        if (r102 != null) goto L7;
        this.rTail = r100;     // Catch: Throwable -> L10
        this.rHead = r100;     // Catch: Throwable -> L10
        this.rLock.notify();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L7:
        r102.next = r100;     // Catch: Throwable -> L10
        this.rTail = r100;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public BufferQueue(int r100, int r101) {
        this.wLock = new Object();
        this.rLock = new Object();
        if (r100 >= 64) goto L6;
        r100 = 64;
    L6:
        if (r101 >= 8192) goto L8;
        r101 = 8192;
    L8:
        this.maxBufferCount = r100;
        this.bufferSize = r101;
    }
}
