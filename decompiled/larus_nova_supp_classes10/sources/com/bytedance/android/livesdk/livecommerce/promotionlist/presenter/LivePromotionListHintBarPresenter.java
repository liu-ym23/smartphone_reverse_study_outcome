package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECPromotionListHintBannerView;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ExplainingPromotionBar;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListHintBarPresenter extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.a {
    public ECPromotionListHintBannerView j;
    public final Lazy k;

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void c0() {
        super.c0();
        if (this.g == false) goto L8;
        ECPromotionListHintBannerView r0 = this.j;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("hintBannerView");
    L7:
        r0.f.e();
        r0.g.e();
        r0.c.setVisibility(8);
        ExplainingPromotionBar r1 = r0.d;
        r1.removeCallbacks(r1.c);
        r1.setVisibility(8);
    L8:
        s0.e(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void e0() {
        View r0 = a0();
        if (r0 == null) goto L21;
        ECPromotionListHintBannerView r1 = (ECPromotionListHintBannerView) r0;
        this.j = r1;
        r1.setRoomId(d0().getParams().getRoomId());
        ECPromotionListHintBannerView r2 = this.j;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("hintBannerView");
    L7:
        RoomContextController r3 = d0().getRoomContextController();
        if (r3 == null) goto L12;
        RealRoomController r4 = r3.A();
        if (r4 == null) goto L12;
        PromotionListController r5 = r4.r;
    L13:
        r2.setPromotionListController(r5);
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.i0.class), new LivePromotionListHintBarPresenter$observeData$1(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.i.class), new LivePromotionListHintBarPresenter$observeData$2(this));
        final mj2.a r6 = ECLiveABUtils.INSTANCE.getECOM_LIVE_PROMOTION_LIST_HINT_HAR_OPT_CONFIG();
        if (r6.b() == false) goto L16;
    L18:
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListHintBarPresenter$observeData$5.INSTANCE, new LivePromotionListHintBarPresenter$observeData$6(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.e.class), new LivePromotionListHintBarPresenter$observeData$7(this, r6));
        s0.c(this);
        return;
    L16:
        if (r6.a() == 1) goto L18;
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListHintBarPresenter$observeData$3.INSTANCE, new LivePromotionListHintBarPresenter$observeData$4(this));
    L12:
        r5 = null;
        goto L13
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.iron.ui.ECPromotionListHintBannerView");
    }

    public static final /* synthetic */ ECPromotionListHintBannerView h0(LivePromotionListHintBarPresenter r1) {
        ECPromotionListHintBannerView r2 = r1.j;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hintBannerView");
    L5:
        return r2;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAddToShopCartSuccess(hl.b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        d0().withState(new AnonymousClass1(this));
    }

    public LivePromotionListHintBarPresenter(Fragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3);
        this.k = LazyKt.lazy(new LivePromotionListHintBarPresenter$promotionListEventActionImplV2$2(this));
    }
}
