package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.NotQuitThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/UnifiedHandlerThread;", "", "()V", "handlerThread", "Landroid/os/HandlerThread;", "ensureThread", "getLooper", "Landroid/os/Looper;", "isCurrentThread", "", "UnifiedThread", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class UnifiedHandlerThread {
    public static final UnifiedHandlerThread INSTANCE = null;
    private static volatile HandlerThread handlerThread;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/UnifiedHandlerThread$UnifiedThread;", "Landroid/os/HandlerThread;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/NotQuitThread;", "name", "", "(Ljava/lang/String;)V", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class UnifiedThread extends HandlerThread implements NotQuitThread {
        public UnifiedThread(String r100) {
            super(r100);
        }
    }

    static {
        INSTANCE = new UnifiedHandlerThread();
    }

    private UnifiedHandlerThread() {
    }

    private final HandlerThread ensureThread() {
        HandlerThread r100 = handlerThread;
        if (r100 == null) goto L5;
        return r100;
    L5:
        monitor-enter(this);
        HandlerThread r101 = handlerThread;     // Catch: Throwable -> L16
        if (r101 == null) goto L10;
        monitor-exit(this);
        return r101;
    L10:
        UnifiedThread r102 = new UnifiedThread("UnifiedHandlerThread");     // Catch: Throwable -> L16
        r102.start();     // Catch: Throwable -> L16
        handlerThread = r102;     // Catch: Throwable -> L16
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        HandlerThread r104 = handlerThread;
        if (r104 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        return r104;
    L16:
        th = move-exception;
        throw th;
    }

    public final Looper getLooper() {
        return ensureThread().getLooper();
    }

    public final boolean isCurrentThread() {
        return Intrinsics.areEqual(Thread.currentThread(), handlerThread);
    }
}
