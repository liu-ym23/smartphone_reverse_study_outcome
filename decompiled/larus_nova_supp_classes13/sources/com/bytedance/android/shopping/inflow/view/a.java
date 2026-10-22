package com.bytedance.android.shopping.inflow.view;

import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ InFlowActivityLayout a;

    public a(InFlowActivityLayout r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if ((this.a.getContext() instanceof LifecycleOwner) == false) goto L12;
        LifecycleOwner r0 = this.a.getContext();     // Catch: Throwable -> L9
        if (r0 == null) goto L8;
        r0.getLifecycle().addObserver(this.a);     // Catch: Throwable -> L9
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");     // Catch: Throwable -> L9
    }
}
