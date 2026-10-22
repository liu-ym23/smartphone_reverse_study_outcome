package com.bytedance.ee.bear.bitable.itemview.util;

import android.animation.AnimatorSet;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f214285a;

    public g(AnimatorSet r100) {
        this.f214285a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f214285a.start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
