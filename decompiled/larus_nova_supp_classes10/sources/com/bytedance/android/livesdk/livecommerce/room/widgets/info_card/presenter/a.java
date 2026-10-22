package com.bytedance.android.livesdk.livecommerce.room.widgets.info_card.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ti.k;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends QPresenter implements k {
    public l e;
    public final LiveRoomParams f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.info_card.presenter.a$a, reason: collision with other inner class name */
    public static final class C0110a {
    }

    static {
    }

    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public final void C() {
        ((ViewGroup) w().f()).removeAllViews();
        l r0 = this.e;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.e = null;
    }

    public a(LiveRoomParams r1) {
        this.f = r1;
    }

    public final void A(QModel r14) {
        dm.a.a("ECLiveInfoCardPresenter").a("load");
        String r2 = ECLiveABUtils.INSTANCE.getEC_LIVE_INFO_CARD_SCHEMA();
        LiveRoomParams r0 = this.f;
        if (r0 == null) goto L5;
        Map r3 = r0.generaInitialData();
    L7:
        if (r2.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        dm.a.a("ECLiveInfoCardPresenter").b("lynx schema is empty", null);
        return;
    L13:
        if (this.e == null) goto L15;
        dm.a.a("ECLiveInfoCardPresenter").a("lynxView has init");
        return;
    L15:
        l r15 = ECLiveHybridUtil.b(u().c(), r2, r3, (ViewGroup) w().f(), this, null, null, false, null, null, false, 4064);
        UtilityKotlinExtentionsKt.h(r15, ECLiveInfoCardPresenter$initLynxView$1.INSTANCE);
        this.e = r15;
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public final void onFirstScreen(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onLoadSuccess(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        dm.a.a("ECLiveInfoCardPresenter").a("load Lynx onLoadSuccess");
        if (w().d() == true) goto L6;
        w().g(0);
        return;
    }

    public final void onRuntimeReady(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void g(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public final void onLoadFailed(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        dm.a.a("ECLiveInfoCardPresenter").b("load Lynx onLoadFailed " + r4, null);
        w().c();
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
