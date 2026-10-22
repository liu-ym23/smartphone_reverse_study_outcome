package com.ttnet.org.chromium.net.urlconnection;

import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes41.dex */
public final class Segment {
    private static int sSize = 32768;
    private static boolean sSizeInited;
    private static final ReentrantReadWriteLock sSizeLock = null;

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    private ByteBuffer f461942bb;
    private boolean bufferFlipped;
    Segment next;
    Segment prev;

    static {
        sSizeLock = new ReentrantReadWriteLock();
    }

    public static int getSize() {
        ReentrantReadWriteLock r100 = sSizeLock;
        r100.readLock().lock();
        sSizeInited = true;     // Catch: Throwable -> L6
        int r101 = sSize;     // Catch: Throwable -> L6
        r100.readLock().unlock();
        return r101;
    L6:
        th = move-exception;
        sSizeLock.readLock().unlock();
        throw th;
    }

    public void completeRead() {
        this.f461942bb.flip();
        this.bufferFlipped = true;
    }

    public ByteBuffer getInnerBuffer() {
        if (this.f461942bb != null) goto L6;
        this.f461942bb = ByteBuffer.allocateDirect(getSize());
    L6:
        return this.f461942bb;
    }

    public boolean isWritable() {
        if (this.bufferFlipped == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f461942bb.hasRemaining() == false) goto L7;
        return true;
    }

    public Segment pop() {
        Segment r100 = this.next;
        if (r100 == this) goto L5;
        Segment r101 = r100;
    L6:
        Segment r102 = this.prev;
        r102.next = r100;
        this.next.prev = r102;
        this.next = null;
        this.prev = null;
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public Segment release() {
        this.f461942bb.clear();
        this.bufferFlipped = false;
        Segment r100 = pop();
        if (SegmentPool.recycle(this) == true) goto L5;
        this.f461942bb = null;
    L5:
        return r100;
    }

    public Segment() {
        this.bufferFlipped = false;
        getInnerBuffer();
    }

    public static void setSize(int r100) {
        if (sSizeInited == false) goto L5;
        return;
    L5:
        ReentrantReadWriteLock r101 = sSizeLock;
        r101.writeLock().lock();
    L11:
        th = move-exception;
        sSizeLock.writeLock().unlock();
        throw th;
    L7:
        if (sSizeInited == true) goto L9;
        sSizeInited = true;     // Catch: Throwable -> L11
        sSize = r100;     // Catch: Throwable -> L11
    L9:
        r101.writeLock().unlock();
    }

    public Segment push(Segment r100) {
        r100.prev = this;
        r100.next = this.next;
        this.next.prev = r100;
        this.next = r100;
        return r100;
    }

    public int getInnerBufferTo(byte[] r100, int r101, int r102) {
        if (this.bufferFlipped == true) goto L6;
        return -1;
    L6:
        int r103 = Math.min(this.f461942bb.remaining(), r102);
        this.f461942bb.get(r100, r101, r103);
        return r103;
    }
}
