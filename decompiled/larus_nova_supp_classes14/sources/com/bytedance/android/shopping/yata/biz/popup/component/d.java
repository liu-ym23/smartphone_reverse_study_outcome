package com.bytedance.android.shopping.yata.biz.popup.component;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements k {
    public final /* synthetic */ e a;

    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public d(e r1) {
        this.a = r1;
    }

    public final void onFirstScreen(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onLoadSuccess(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onRuntimeReady(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void g(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public final void onLoadFailed(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        hl3.a r3 = this.a.e;
        if (r3 == null) goto L6;
        r3.dismiss();
        return;
    }

    public final void onPageStart(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public final void s(View r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
    }
}
