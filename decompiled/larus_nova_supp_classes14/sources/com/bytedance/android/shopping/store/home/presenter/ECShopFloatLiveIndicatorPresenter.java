package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.base.widget.round.RoundFrameLayout;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopFloatLiveIndicatorPresenter extends ECShopAbsFloatPresenter {
    public final Lazy k;

    public static final class a implements z3 {
        public final /* synthetic */ ECShopFloatLiveIndicatorPresenter a;

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void a() {
            Object r0 = this.a.y().getParent();
            if ((r0 instanceof View) == true) goto L5;
            r0 = null;
        L5:
            View r1 = (View) r0;
            if (r1 == null) goto L8;
            r1.setVisibility(0);
        L8:
            int r2 = com.bytedance.android.shopping.store.home.d0.a;
            StoreV3LiveRoomVO r3 = com.bytedance.android.shopping.store.home.d0.b(this.a.S());
            ECStoreViewModel r4 = this.a.S();
            Pair<String, String>[] r5 = new Pair[5];
            r5[0] = TuplesKt.to("enter_from_merge", "store_page");
            r5[1] = TuplesKt.to("enter_method", "brand_shop_mini_window");
            if (r3 == null) goto L12;
            String r6 = r3.getRoomId();
            if (r6 == null) goto L12;
        L13:
            r5[2] = TuplesKt.to("room_id", r6);
            r5[3] = TuplesKt.to("pass_through_log_data", this.a.S().getPassThroughLogData());
            r5[4] = TuplesKt.to("btm_id", "a1.b6269.c4706.d3124");
            r4.doEventAction("livesdk_live_show", r5);
            return;
        L12:
            r6 = "";
            goto L13
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void onClick() {
            final ECShopFloatLiveIndicatorPresenter r0 = this.a;
            r0.getClass();
            int r1 = com.bytedance.android.shopping.store.home.d0.a;
            StoreV3LiveRoomVO r2 = com.bytedance.android.shopping.store.home.d0.b(r0.S());
            if (r2 == null) goto L27;
            com.bytedance.android.shopping.store.utils.c0 r3 = com.bytedance.android.shopping.store.utils.c0.a;
            String r4 = r2.getEnterUrl();
            boolean r5 = r0.S().getStoreParam().isEcShare();
            String r6 = r0.S().getStoreParam().getShareContent();
            String r7 = r0.S().getStoreParam().getShareObject();
            String r8 = r0.S().getStoreParam().getSearchParams();
            String r9 = r0.S().getPassThroughLogData();
            String r10 = (String) r0.S().getStoreParam().getPassThroughParam("pass_through_api");
            QContext r11 = r0.u();
            FragmentActivity r12 = com.bytedance.android.ec.core.utils.l0.c(r11.c());
            if ((r12 instanceof FragmentActivity) == true) goto L8;
            r12 = null;
        L8:
            if (r12 != null) goto L10;
            r12 = r11.a();
        L10:
            String r13 = com.bytedance.android.shopping.store.utils.c0.b(r3, r4, "brand_shop_mini_window", r5, r6, r7, r8, r9, r10, r12);
            if (r13 != null) goto L13;
        L16:
            boolean r14 = true;
        L17:
            if (r14 == true) goto L28;
            int r15 = gj3.a.a;
            ECStoreViewModel r16 = r0.S();
            Intrinsics.checkNotNullParameter(r16, "viewModel");
            int r17 = com.bytedance.android.ec.store.utils.h.a;
            com.bytedance.android.ec.store.utils.h.d(r16.getEntranceInfoJsonObject(), "otherclick", "live_room", r16.getAdParams(), "shop_window_ad");
            if (gj3.a.a(r0.S(), r13, new ECShopFloatLiveIndicatorPresenter$openLiveRoom$1(r0)) == true) goto L29;
            Activity r18 = com.bytedance.android.ec.core.utils.l0.b(r0.u().c());
            if (r18 == null) goto L26;
            com.bytedance.android.ec.sdk.helper.p r19 = com.bytedance.android.ec.sdk.helper.p.a;
            int r20 = com.bytedance.android.ec.store.utils.b.a;
            PageFinder r21 = PageFinder.via(r0.e);
            BcmParams r22 = new BcmParams();
            r22.put("bst_group_type", "live");
            Unit r23 = Unit.INSTANCE;
            r19.d(com.bytedance.android.ec.store.utils.b.b(r13, "c4706.d3124", r21, r22), r18);
            return;
        L26:
            return;
        L29:
            return;
        L28:
            return;
        L13:
            if (StringsKt.isBlank(r13) == true) goto L16;
            r14 = false;
            goto L17
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void onHidden() {
            Object r0 = this.a.y().getParent();
            if ((r0 instanceof View) == true) goto L5;
            r0 = null;
        L5:
            View r1 = (View) r0;
            if (r1 == null) goto L9;
            r1.setVisibility(8);
            return;
        }

        public a(ECShopFloatLiveIndicatorPresenter r1) {
            this.a = r1;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopFloatLiveIndicatorPresenter a;

        public b(ECShopFloatLiveIndicatorPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Float r2 = (Float) r1;
            this.a.Q();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopFloatLiveIndicatorPresenter a;

        public c(ECShopFloatLiveIndicatorPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (this.a.S().isBrandShopUpgrade() == false) goto L12;
            Drawable r5 = ((RoundFrameLayout) this.a.w().b(2131370927).f()).getBackground();
            if ((r5 instanceof BackgroundDrawable) == true) goto L7;
            r5 = null;
        L7:
            BackgroundDrawable r6 = (BackgroundDrawable) r5;
            if (r6 == null) goto L10;
            r6.setBgColor((int) 4294901820L);
            r6.invalidate();
        L10:
            this.a.w().b(2131370925).c();
            SimpleDraweeView r7 = this.a.w().b(2131370926).f();
            r7.setVisibility(0);
            r7.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri("https://lf3-static.bytednsdoc.com/obj/eden-cn/wvoz_j_tvjl/ljhwZthlaukjlkulzlp/brand/ec_shop_live_indicator_icon.webp").build());
            return;
        }
    }

    public final ECStoreViewModel S() {
        return (ECStoreViewModel) this.k.getValue();
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final z3 E() {
        return new a(this);
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final boolean D() {
        if (com.bytedance.android.shopping.extensions.k.d((Float) S().getUpglideFactor().getValue()) >= 0.95f) goto L5;
    L18:
        return false;
    L5:
        if (S().couldLive() == true) goto L7;
    L8:
        com.bytedance.android.shopping.store.home.entity.n r0 = (com.bytedance.android.shopping.store.home.entity.n) S().getHeaderArea().getValue();
        if (r0 != null) goto L11;
    L12:
        com.bytedance.android.shopping.store.home.entity.n r1 = (com.bytedance.android.shopping.store.home.entity.n) S().getHeaderArea().getValue();
        if (r1 == null) goto L15;
        im.v r2 = r1.p;
    L16:
        if (r2 == null) goto L18;
        return true;
    L15:
        r2 = null;
        goto L16
    L11:
        if (r0.b() != true) goto L12;
        return true;
    L7:
        if (S().canShowLiveIcon() == false) goto L8;
        return true;
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final a4 F() {
        ECStoreViewModel r0 = S();
        Intrinsics.checkNotNullParameter(r0, "viewModel");
        return new com.bytedance.android.shopping.store.home.presenter.b(r0);
    }

    public ECShopFloatLiveIndicatorPresenter(Fragment r1) {
        super(r1);
        this.k = LazyKt.lazy(new ECShopFloatLiveIndicatorPresenter$viewModel$2(this));
    }

    public final void A(QModel r4) {
        LottieAnimationView r5 = w().b(2131370925).f();
        r5.setAnimation("ec_shop_live_indicator_icon.json");
        r5.playAnimation();
        this.h = Boolean.TRUE;
        y().setOnClickListener(new d(this));
        K();
        S().getUpglideFactor().a(ECQuickUtilKt.a(u()), new b(this), false);
        S().isBrandShop().a(ECQuickUtilKt.a(u()), new c(this), false);
    }
}
