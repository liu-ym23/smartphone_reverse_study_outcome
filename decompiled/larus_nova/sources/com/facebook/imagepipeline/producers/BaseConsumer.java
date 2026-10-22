package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseConsumer<T> implements Consumer<T> {
    private boolean mIsFinished;

    public static boolean isLast(int r100) {
        if ((r100 & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static int simpleStatusForIsLast(boolean r100) {
        return r100 ? 1 : 0;
    }

    public static boolean statusHasAnyFlag(int r100, int r101) {
        if ((r100 & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean statusHasFlag(int r100, int r101) {
        if ((r100 & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static int turnOffStatusFlag(int r100, int r101) {
        return r100 & (~r101);
    }

    public static int turnOnStatusFlag(int r100, int r101) {
        return r100 | r101;
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onCancellation() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsFinished == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.mIsFinished = true;     // Catch: Throwable -> L15
        onCancellationImpl();     // Catch: Exception -> L11 Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        onUnhandledException(e);     // Catch: Throwable -> L15
        goto L13
    }

    public abstract void onCancellationImpl();

    public abstract void onFailureImpl(Throwable r100);

    public abstract void onNewResultImpl(T r100, int r101);

    public void onProgressUpdateImpl(float r100) {
    }

    public BaseConsumer() {
        this.mIsFinished = false;
    }

    public static boolean isNotLast(int r100) {
        return !isLast(r100);
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onFailure(Throwable r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsFinished == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.mIsFinished = true;     // Catch: Throwable -> L15
        onFailureImpl(r100);     // Catch: Exception -> L11 Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        onUnhandledException(e);     // Catch: Throwable -> L15
        goto L13
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onProgressUpdate(float r100) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsFinished == false) goto L17;
        monitor-exit(this);
        return;
    L17:
        onProgressUpdateImpl(r100);     // Catch: Exception -> L9 Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L9:
        e = move-exception;
        onUnhandledException(e);     // Catch: Throwable -> L13
        goto L11
    }

    public void onUnhandledException(Exception r100) {
        FLog.wtf(getClass(), "unhandled exception", r100);
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onNewResult(@Nullable T r100, int r101) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsFinished == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mIsFinished = isLast(r101);     // Catch: Throwable -> L14
        onNewResultImpl(r100, r101);     // Catch: Exception -> L10 Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        onUnhandledException(e);     // Catch: Throwable -> L14
        goto L12
    }
}
