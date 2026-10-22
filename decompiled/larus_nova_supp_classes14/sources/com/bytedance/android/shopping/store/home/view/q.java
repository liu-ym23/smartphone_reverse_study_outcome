package com.bytedance.android.shopping.store.home.view;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements Runnable {
    public final /* synthetic */ p a;
    public final /* synthetic */ Function0 b;

    public q(p r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p r0 = this.a;     // Catch: Throwable -> L12
        ViewParent r1 = r0.getParent();     // Catch: Throwable -> L12
        if ((r1 instanceof ViewGroup) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup r2 = (ViewGroup) r1;     // Catch: Throwable -> L12
        if (r2 == null) goto L8;
        r2.removeView(r0);     // Catch: Throwable -> L12
    L8:
        Function0 r3 = this.b;     // Catch: Throwable -> L12
        if (r3 == null) goto L15;
        Unit r4 = (Unit) r3.invoke();     // Catch: Throwable -> L12
        return;
    L15:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
