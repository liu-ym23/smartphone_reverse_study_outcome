package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import com.ss.android.ugc.bytex.pthread.base.convergence.helper.SystemUtils;

/* JADX INFO: loaded from: classes40.dex */
public class DispatchHandlerThread extends HandlerThread {
    private static boolean checkOnly;
    private Handler mHandler;
    private Looper mLooper;
    private int mPriority;
    private int mTid;

    public DispatchHandlerThread(String r100) {
        super(r100);
        this.mTid = -1;
        this.mPriority = 0;
        checkOnly();
    }

    public DispatchHandlerThread(String r100, int r101) {
        super(r100, r101);
        this.mTid = -1;
        this.mPriority = r101;
        checkOnly();
    }

    private static void checkOnly() {
        if (checkOnly == true) goto L7;
        checkOnly = true;
        return;
    L7:
        throw new IllegalStateException("DispatchHandlerThread only create one");
    }

    private static void loop(MessageQueue r100) {
        Binder.clearCallingIdentity();
        Binder.clearCallingIdentity();
    L4:
        if (loopOnce(r100) == true) goto L4;
    }

    private static boolean loopOnce(MessageQueue r100) {
        Message r101 = SystemUtils.nextMessage(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        Object r102 = r101.getTarget().getLooper().getThread();
        if ((r102 instanceof ReuseableHandlerThread) == false) goto L9;
        Dispatcher.dispatchMessage((ReuseableHandlerThread) r102, r101);
        return true;
    L9:
        long r103 = SystemUtils.threadLocalWorkSourceSetUid(SystemUtils.getMessageWorkSourceUid(r101));
        r101.getTarget().dispatchMessage(r101);
        SystemUtils.threadLocalWorkSourceRestore(r103);
        Binder.clearCallingIdentity();
        SystemUtils.messageRecycleUnchecked(r101);
        return true;
    }

    @Override // android.os.HandlerThread
    public Looper getLooper() {
        if (isAlive() == true) goto L6;
        return null;
    L6:
        monitor-enter(this);
        boolean r100 = false;
    L23:
    L20:
        th = move-exception;
        throw th;
    L9:
        if (isAlive() == false) goto L15;
        if (this.mLooper != null) goto L15;
        wait();     // Catch: InterruptedException -> L14 Throwable -> L20
    L14:
        r100 = true;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L20
        if (r100 == false) goto L19;
        Thread.currentThread().interrupt();
    L19:
        return this.mLooper;
    }

    public Handler getThreadHandler() {
        if (this.mHandler != null) goto L6;
        this.mHandler = new Handler(getLooper());
    L6:
        return this.mHandler;
    }

    @Override // android.os.HandlerThread
    public int getThreadId() {
        return this.mTid;
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        return true;
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        return true;
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        this.mTid = Process.myTid();
        SystemUtils.prepareUnquitAllowedLooper();
        monitor-enter(this);
        Looper r100 = Looper.myLooper();     // Catch: Throwable -> L8
        this.mLooper = r100;     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        Process.setThreadPriority(this.mPriority);
        onLooperPrepared();
        loop(SystemUtils.getLooperMessageQueue(r100));
        this.mTid = -1;
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
