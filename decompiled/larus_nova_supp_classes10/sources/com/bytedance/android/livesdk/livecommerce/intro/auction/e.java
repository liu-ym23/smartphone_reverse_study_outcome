package com.bytedance.android.livesdk.livecommerce.intro.auction;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.event.e1;
import com.bytedance.android.livesdk.livecommerce.room.coupon.CouponEventDispatcher;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.r;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements k {
    public final /* synthetic */ IntroAuctionPresenter a;

    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public e(IntroAuctionPresenter r1) {
        this.a = r1;
    }

    public final void onFirstScreen(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onLoadSuccess(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        CouponEventDispatcher.a("lynx entry load success");
        IntroAuctionViewModel r3 = this.a.f;
        if (r3 == null) goto L7;
        r r4 = r3.getCardCallback();
        if (r4 == null) goto L7;
        r4.a();
    L7:
        new e1().k();
    }

    public final void onRuntimeReady(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void g(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public final void onLoadFailed(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        boolean r4 = CouponEventDispatcher.a;
        CouponEventDispatcher.a("lynx entry load fail: " + r3);
        new e1(1, r3).k();
    }

    public final void onPageStart(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public final void s(View r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
        boolean r4 = CouponEventDispatcher.a;
        CouponEventDispatcher.a("lynx entry load error: " + r3);
        new e1(2, r3).k();
    }
}
