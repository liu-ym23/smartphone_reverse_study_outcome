package com.facebook.common.executors;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public abstract class StatefulRunnable<T> implements Runnable {
    protected static final int STATE_CANCELLED = 2;
    protected static final int STATE_CREATED = 0;
    protected static final int STATE_FAILED = 4;
    protected static final int STATE_FINISHED = 3;
    protected static final int STATE_STARTED = 1;
    protected final AtomicInteger mState;

    public void disposeResult(T r100) {
    }

    public abstract T getResult() throws Exception;

    public void onCancellation() {
    }

    public void onFailure(Exception r100) {
    }

    public void onSuccess(T r100) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        com_facebook_common_executors_StatefulRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void cancel() {
        if (this.mState.compareAndSet(0, 2) == false) goto L6;
        onCancellation();
        return;
    }

    public final void com_facebook_common_executors_StatefulRunnable__run$___twin___() {
        if (this.mState.compareAndSet(0, 1) == true) goto L18;
        return;
    L18:
        T r100 = getResult();     // Catch: Exception -> L13
        this.mState.set(3);
        onSuccess(r100);     // Catch: Throwable -> L10
        disposeResult(r100);
        return;
    L10:
        th = move-exception;
        disposeResult(r100);
        throw th;
    L13:
        e = move-exception;
        this.mState.set(4);
        onFailure(e);
    }

    public StatefulRunnable() {
        this.mState = new AtomicInteger(0);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_facebook_common_executors_StatefulRunnable_com_larus_apm_impl_protector_RunnableLancet_run(StatefulRunnable r100) {
        r100.com_facebook_common_executors_StatefulRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
