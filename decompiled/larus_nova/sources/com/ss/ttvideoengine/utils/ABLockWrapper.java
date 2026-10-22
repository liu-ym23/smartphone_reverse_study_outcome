package com.ss.ttvideoengine.utils;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes35.dex */
public class ABLockWrapper extends ABLock {
    private ABLock mCurrentLock;
    private ABLock mLastLock;

    @Override // com.ss.ttvideoengine.utils.ABLock
    public int getType() {
        return this.mCurrentLock.getType();
    }

    public ABLockWrapper(int r100) {
        super(r100);
        this.mCurrentLock = ABLock.create(r100);
        this.mLastLock = ABLock.create(ABLock.LOCK_IMPL_VOID);
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public void lock(int r100) {
        this.mCurrentLock.lock(r100);
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public boolean tryLock(int r100) {
        return this.mCurrentLock.tryLock(r100);
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public void unlock(int r100) {
        this.mCurrentLock.unlock(r100);     // Catch: IllegalMonitorStateException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        this.mLastLock.unlock(r100);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public void updateLockType(int r100) {
        if (this.mCurrentLock.getType() == r100) goto L6;
        this.mLastLock = this.mCurrentLock;
        this.mCurrentLock = ABLock.create(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.utils.ABLock
    public boolean tryLock(int r100, long r101, TimeUnit r102) throws InterruptedException {
        return this.mCurrentLock.tryLock(r100, r101, r102);
    }
}
