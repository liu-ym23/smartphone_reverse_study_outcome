package com.bytedance.ee.bear.document.titlebar;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ View a;

    public /* synthetic */ f(View r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        tt5.a.b("ImmersiveWebContainerBehavior", "checkNeedMeasure, canScrollVertically = " + this.a.canScrollVertically(-1));
    }
}
