package com.ss.ttm.player;

import com.obric.sva.sdk.controller.Global;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ttm.utils.AVLogger;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes40.dex */
public final class DirectBufferPool {
    private static final int S_FAIL = -1;
    private static final int S_OK = 0;
    private static final String TAG = "DirectBufferPool";
    private static volatile DirectBufferPool instance;
    private Queue<DirectBufferUnion> bufferPool;
    private AtomicInteger bufferPoolSizeLimit;
    private int mCheckIntervalMs;

    public static /* synthetic */ void a(DirectBufferPool r100) {
        r100.checkExpireThreadPeriod();
    }

    private void checkExpireThreadPeriod() {
        LinkedBlockingQueue r100 = new LinkedBlockingQueue();
        long r101 = System.currentTimeMillis();
        monitor-enter(DirectBufferUnion.class);
    L20:
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.bufferPool.isEmpty() == true) goto L9;
        if ((r101 - this.bufferPool.peek().freeTimePoint) <= this.mCheckIntervalMs) goto L9;
        r100.offer(this.bufferPool.peek());     // Catch: Throwable -> L17
        this.bufferPool.poll();     // Catch: Throwable -> L17
    L9:
        monitor-exit(DirectBufferUnion.class);     // Catch: Throwable -> L17
        AVLogger.InfoTrackLife(TAG, this, "exist direct buffer after check expire:" + this.bufferPool.size() + ", clean size:" + r100.size());
    L12:
        if (r100.isEmpty() == true) goto L16;
        ByteBuffer r102 = ((DirectBufferUnion) r100.poll()).buffer;
        if (r102 == null) goto L12;
        clean(r102);
        goto L12
    }

    public static DirectBufferPool getInstance() {
        if (instance != null) goto L15;
        monitor-enter(DirectBufferPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new DirectBufferPool();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DirectBufferPool.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private DirectBufferPool() {
        this.mCheckIntervalMs = 30000;
        this.bufferPoolSizeLimit = new AtomicInteger(2);
        this.bufferPool = new LinkedBlockingQueue();
        setDirectBufferPoolSize(TTPlayerConfiger.getValue(84, 2));
        boolean r100 = false;
        if (TTPlayerConfiger.getValue(85, 0) == 0) goto L5;
        r100 = true;
    L5:
        int r101 = TTPlayerConfiger.getValue(86, 30000);
        this.mCheckIntervalMs = r101;
        if (r100 == false) goto L9;
        if (r101 <= 0) goto L9;
        ScheduledExecutorService r102 = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory(TAG));
        Runnable r103 = new d(this);
        int r104 = this.mCheckIntervalMs;
        r102.scheduleWithFixedDelay(r103, r104, r104, TimeUnit.MILLISECONDS);
    L9:
        AVLogger.InfoTrackLife(TAG, this, "create direct buffer pool, needCheckExpire:" + r100 + ", mCheckIntervalMs:" + this.mCheckIntervalMs);
    }

    public void clean(ByteBuffer r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        AVLogger.InfoTrackLife(TAG, this, "start clean direct buffer");
        if (r100.isDirect() == false) goto L14;
        Method r101 = r100.getClass().getMethod("cleaner", new Class[0]);     // Catch: Exception -> L11
        r101.setAccessible(true);     // Catch: Exception -> L11
        Object r102 = r101.invoke(r100, new Object[0]);     // Catch: Exception -> L11
        if (r102 == null) goto L15;
        r102.getClass().getMethod(Global.RECORDING_TYPE_CLEAN, new Class[0]).invoke(r102, new Object[0]);     // Catch: Exception -> L11
        return;
    L15:
        return;
    L14:
        return;
    }

    public ByteBuffer getReuseDirectBuffer(int r100) {
        if (this.bufferPool.isEmpty() == false) goto L6;
        AVLogger.InfoTrackLife(TAG, this, "pool is empty, find match direct buffer fail");
        return null;
    L6:
        monitor-enter(this);
        Iterator<DirectBufferUnion> r101 = this.bufferPool.iterator();     // Catch: Throwable -> L24
        DirectBufferUnion r102 = null;
    L9:
        if (r101.hasNext() == false) goto L17;
        DirectBufferUnion r103 = r101.next();     // Catch: Throwable -> L24
        int r104 = r103.size;     // Catch: Throwable -> L24
        if (r104 == r100) goto L12;
        if (r104 <= r100) goto L9;
        r102 = r103;
        goto L9
    L12:
        this.bufferPool.remove(r103);     // Catch: Throwable -> L24
        AVLogger.InfoTrackLife(TAG, this, "find best-match direct buffer, after pool size:" + this.bufferPool.size());     // Catch: Throwable -> L24
        ByteBuffer r105 = r103.buffer;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return r105;
    L17:
        if (r102 == null) goto L21;
        this.bufferPool.remove(r102);     // Catch: Throwable -> L24
        AVLogger.InfoTrackLife(TAG, this, "find size not-match direct buffer, after pool size:" + this.bufferPool.size());     // Catch: Throwable -> L24
        ByteBuffer r106 = r102.buffer;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return r106;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L24
        AVLogger.InfoTrackLife(TAG, this, "find match direct buffer fail, pool size:" + this.bufferPool.size());
        return null;
    L24:
        th = move-exception;
        throw th;
    }

    public int pushDirectBufferBack(ByteBuffer r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.capacity();
        r100.clear();
        monitor-enter(this);
        Iterator<DirectBufferUnion> r102 = this.bufferPool.iterator();     // Catch: Throwable -> L29
    L9:
        if (r102.hasNext() == false) goto L16;
        if (r102.next().size != r101) goto L9;
        clean(r100);     // Catch: Throwable -> L29
        AVLogger.InfoTrackLife(TAG, this, "pool has similarity direct buffer, size:" + this.bufferPool.size());     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        return -1;
    L16:
        DirectBufferUnion r103 = new DirectBufferUnion(r100, r101);     // Catch: Throwable -> L29
        if (this.bufferPool.size() < this.bufferPoolSizeLimit.get()) goto L19;
        DirectBufferUnion r104 = this.bufferPool.poll();     // Catch: Throwable -> L29
        if (r104 == null) goto L25;
        clean(r104.buffer);     // Catch: Throwable -> L29
    L25:
        if (this.bufferPool.offer(r103) == false) goto L27;
        r103.resetFreeTimePoint();     // Catch: Throwable -> L29
        AVLogger.InfoTrackLife(TAG, this, "push direct buffer after poll success, size:" + this.bufferPool.size());     // Catch: Throwable -> L29
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return 0;
    L19:
        if (this.bufferPool.offer(r103) == false) goto L27;
        r103.resetFreeTimePoint();     // Catch: Throwable -> L29
        AVLogger.InfoTrackLife(TAG, this, "push direct buffer success, size:" + this.bufferPool.size());     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public void setDirectBufferPoolSize(int r100) {
        AVLogger.InfoTrackLife(TAG, this, "set direct buffer pool size:" + r100);
        this.bufferPoolSizeLimit.set(r100);
    }
}
