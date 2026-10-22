package com.bytedance.ee.bear.drive.loader.download.platform.api;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes16.dex */
public class Sync {
    private static final String TAG = "DrivePlatform_Sync";
    private AtomicBoolean alreadyWakeUp;
    private Condition condition;
    private AtomicBoolean inWorking;
    private final Lock lock;
    private AtomicBoolean pullResult;
    private AtomicBoolean pushResult;

    public boolean pullOk() {
        return this.pullResult.get();
    }

    public boolean pushOk() {
        return this.pushResult.get();
    }

    public void setPullOk() {
        tt5.a.h(TAG, "sync tools, set pullOk.");
        this.pullResult.compareAndSet(false, true);
    }

    public void setPushOk() {
        tt5.a.h(TAG, "sync tools, set pushOk.");
        this.pushResult.compareAndSet(false, true);
    }

    public void startWorking() {
        tt5.a.h(TAG, "sync tools, set start working.");
        this.inWorking.compareAndSet(false, true);
    }

    public boolean stopWorking() {
        boolean r100 = this.inWorking.get();
        if (r100 == false) goto L5;
        tt5.a.h(TAG, "sync tools, set stop working.");
        this.inWorking.compareAndSet(true, false);
        wakeUp();
    L5:
        return r100;
    }

    public void waiting() {
        this.lock.lock();
        tt5.a.h(TAG, "sync tools, thread id: " + ThreadMethodProxy.currentThread().getId() + " enter lock waiting queue.");     // Catch: Throwable -> L5 InterruptedException -> L7
        this.condition.await();     // Catch: Throwable -> L5 InterruptedException -> L7
    L9:
        this.lock.unlock();
        return;
    L7:
        e = move-exception;
        tt5.a.d(TAG, "sync tools, enter lock waiting queue failed, throwable:" + e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void wakeUp() {
        if (this.alreadyWakeUp.get() == false) goto L6;
        tt5.a.h(TAG, "sync tools, has already wake up before.");
        return;
    L6:
        tt5.a.h(TAG, "sync tools, wake up all thread.");
        this.alreadyWakeUp.compareAndSet(false, true);
        this.lock.lock();
        tt5.a.h(TAG, "sync tools, signal all thread.");     // Catch: Throwable -> L9 Exception -> L11
        this.condition.signalAll();     // Catch: Throwable -> L9 Exception -> L11
    L8:
        this.lock.unlock();
        return;
    L9:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L11:
        e = move-exception;
        tt5.a.d(TAG, "sync tools, signal all failed, throwable: " + e);     // Catch: Throwable -> L9
        goto L8
    }

    public Sync() {
        ReentrantLock r100 = new ReentrantLock();
        this.lock = r100;
        this.condition = r100.newCondition();
        this.pushResult = new AtomicBoolean(false);
        this.pullResult = new AtomicBoolean(false);
        this.inWorking = new AtomicBoolean(false);
        this.alreadyWakeUp = new AtomicBoolean(false);
    }
}
