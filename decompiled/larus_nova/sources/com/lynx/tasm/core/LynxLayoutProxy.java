package com.lynx.tasm.core;

import com.lynx.tasm.base.LLog;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes32.dex */
public class LynxLayoutProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f383245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReadWriteLock f383246b;

    private native long nativeCreate(long r100);

    private native void nativeRelease(long r100);

    private native void nativeRunOnLayoutThread(long r100, Runnable r101);

    public void a() {
        ((ReentrantReadWriteLock) this.f383246b).writeLock().lock();
        if (this.f383245a == 0) goto L5;
        LLog.i("LynxLayoutProxy", "LynxLayoutProxy will be destroyed");
        nativeRelease(this.f383245a);
        this.f383245a = 0;
    L5:
        ((ReentrantReadWriteLock) this.f383246b).writeLock().unlock();
    }

    public LynxLayoutProxy(long r100) {
        this.f383246b = new ReentrantReadWriteLock();
        b(r100);
        LLog.i("LynxLayoutProxy", "LynxLayoutProxy is created");
    }

    public void b(long r100) {
        this.f383245a = nativeCreate(r100);
    }

    public void c(Runnable r100) {
        ((ReentrantReadWriteLock) this.f383246b).readLock().lock();
        if (this.f383245a == 0) goto L5;
        LLog.i("LynxLayoutProxy", "runOnLayoutThread is invoked");
        nativeRunOnLayoutThread(this.f383245a, r100);
    L5:
        ((ReentrantReadWriteLock) this.f383246b).readLock().unlock();
    }
}
