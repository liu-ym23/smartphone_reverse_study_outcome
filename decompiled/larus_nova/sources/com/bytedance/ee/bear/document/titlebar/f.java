package com.bytedance.ee.bear.document.titlebar;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f222228a;

    public /* synthetic */ f(View r100) {
        this.f222228a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        tt5.a.b("ImmersiveWebContainerBehavior", "checkNeedMeasure, canScrollVertically = " + this.f222228a.canScrollVertically(-1));
    }
}
