package com.ss.ttvideoengine.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes35.dex */
public abstract class ABLock {
    public static int LOCK_IMPL_NORMAL = 0;
    public static int LOCK_IMPL_READ_WRITE = 2;
    public static int LOCK_IMPL_VOID = 1;
    private static final String TAG = "ABLock";
    public static int TYPE_READ = 1;
    public static int TYPE_VOID = 0;
    public static int TYPE_WRITE = 2;
    private final int mImplType;

    public static class NormalLock extends ABLock {
        private ReentrantLock mLock;

        public NormalLock(int r100) {
            super(r100);
            this.mLock = new ReentrantLock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void lock(int r100) {
            this.mLock.lock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r100) {
            return this.mLock.tryLock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void unlock(int r100) {
            this.mLock.unlock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r100, long r101, TimeUnit r102) throws InterruptedException {
            return this.mLock.tryLock(r101, r102);
        }
    }

    public static class OptimizedLock extends ABLock {
        private final ReentrantReadWriteLock.ReadLock mReadLock;
        private final ReentrantReadWriteLock.WriteLock mWriteLock;

        public OptimizedLock(int r100) {
            super(r100);
            ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
            this.mReadLock = r101.readLock();
            this.mWriteLock = r101.writeLock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void lock(int r100) {
            if (r100 != ABLock.TYPE_READ) goto L6;
            this.mReadLock.lock();
            return;
        L6:
            if (r100 != ABLock.TYPE_WRITE) goto L10;
            this.mWriteLock.lock();
            return;
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r100) {
            if (r100 != ABLock.TYPE_READ) goto L7;
            return this.mReadLock.tryLock();
        L7:
            if (r100 == ABLock.TYPE_WRITE) goto L9;
            return true;
        L9:
            return this.mWriteLock.tryLock();
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void unlock(int r100) {
            if (r100 != ABLock.TYPE_READ) goto L6;
            this.mReadLock.unlock();
            return;
        L6:
            if (r100 != ABLock.TYPE_WRITE) goto L10;
            this.mWriteLock.unlock();
            return;
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r100, long r101, TimeUnit r102) throws InterruptedException {
            if (r100 != ABLock.TYPE_READ) goto L7;
            return this.mReadLock.tryLock(r101, r102);
        L7:
            if (r100 == ABLock.TYPE_WRITE) goto L9;
            return true;
        L9:
            return this.mWriteLock.tryLock(r101, r102);
        }
    }

    public static class VoidLock extends ABLock {
        @Override // com.ss.ttvideoengine.utils.ABLock
        public void lock(int r100) {
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r100) {
            return true;
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public boolean tryLock(int r100, long r101, TimeUnit r102) throws InterruptedException {
            return true;
        }

        @Override // com.ss.ttvideoengine.utils.ABLock
        public void unlock(int r100) {
        }

        public VoidLock(int r100) {
            super(r100);
        }
    }

    public abstract void lock(int r100);

    public abstract boolean tryLock(int r100);

    public abstract boolean tryLock(int r100, long r101, TimeUnit r102) throws InterruptedException;

    public abstract void unlock(int r100);

    public void lock() {
        lock(TYPE_VOID);
    }

    public void unlock() {
        unlock(TYPE_VOID);
    }

    public int getType() {
        return this.mImplType;
    }

    public ABLock(int r100) {
        this.mImplType = r100;
    }

    public static ABLock create(int r100) {
        TTVideoEngineLog.i(TAG, "create ABLock type: " + r100);
        int r101 = LOCK_IMPL_NORMAL;
        if (r100 != r101) goto L7;
        return new NormalLock(r100);
    L7:
        if (r100 != LOCK_IMPL_VOID) goto L11;
        return new VoidLock(r100);
    L11:
        if (r100 != LOCK_IMPL_READ_WRITE) goto L15;
        return new OptimizedLock(r100);
    L15:
        return new NormalLock(r101);
    }
}
