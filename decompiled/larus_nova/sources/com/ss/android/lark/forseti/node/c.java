package com.ss.android.lark.forseti.node;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForsetiNode f424521a;

    public c(ForsetiNode r100) {
        this.f424521a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewParent r100 = this.f424521a.f424502h.getParent();     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.ViewGroup");     // Catch: Throwable -> L4
        ((ViewGroup) r100).removeView(this.f424521a.f424502h);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
