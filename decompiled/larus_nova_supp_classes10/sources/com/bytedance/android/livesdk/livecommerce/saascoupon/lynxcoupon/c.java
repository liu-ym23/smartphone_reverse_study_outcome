package com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.common.api.card.ExternalCardStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements k {
    public final /* synthetic */ String a;
    public final /* synthetic */ a b;
    public final /* synthetic */ ViewGroup c;

    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public final void onFirstScreen(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onLoadSuccess(View r11) {
        Intrinsics.checkNotNullParameter(r11, "lynxView");
        Intrinsics.checkNotNullParameter(r11, "lynxView");
        dm.a.a("LynxCardController").i("[load][ExternalCard] load lynx success, schema: " + this.a);
        final a r0 = this.b;
        ViewGroup r1 = this.c;
        r0.getClass();
        r0.e = ExternalCardStatus.ANIM_SHOWING;
        Long r2 = r0.j.c();
        if (r2 == null) goto L5;
        long r3 = r2.longValue();
    L6:
        final long r4 = r3 / 1000;
        if (r4 > 0) goto L9;
        r0.e = ExternalCardStatus.FINISHED;
        return;
    L9:
        r1.addView(r0.d);
        r0.d.setAlpha(0.0f);
        r0.d.requestLayout();
        FrameLayout r5 = r0.d;
        final Function0<Unit> r6 = new LynxCardController$displayCard$1(r0, r4);
        final Function0<Unit> r7 = new LynxCardController$displayCard$2(r0);
        dm.a.a("LynxCardController").i("[anim][ExternalCard] showCardAnim");
        r0.l.a(r5, new LynxCardController$showCardAnim$1(r0), new LynxCardController$showCardAnim$2(r6), new LynxCardController$showCardAnim$3(r0, r7), null);
        return;
    L5:
        r3 = 10000;
        goto L6
    }

    public final void onRuntimeReady(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void g(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public final void onLoadFailed(View r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "lynxView");
        Intrinsics.checkNotNullParameter(r4, "lynxView");
        dm.a.a("LynxCardController").w("[load][ExternalCard] load lynx failed, schema: " + this.a + ", errMsg: " + r5, null);
        this.c.removeView(r4);
    }

    public final void onPageStart(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public c(String r1, a r2, ViewGroup r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void s(View r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
    }
}
