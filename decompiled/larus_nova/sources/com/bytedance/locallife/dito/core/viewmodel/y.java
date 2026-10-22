package com.bytedance.locallife.dito.core.viewmodel;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.ObservableEmitter;

/* JADX INFO: loaded from: classes21.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter<Object> f258141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f258142b;

    public y(ObservableEmitter<Object> r100, Throwable r101) {
        this.f258141a = r100;
        this.f258142b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f258141a.onError(this.f258142b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
