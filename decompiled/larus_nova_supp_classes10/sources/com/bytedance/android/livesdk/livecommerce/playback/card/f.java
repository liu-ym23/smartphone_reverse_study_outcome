package com.bytedance.android.livesdk.livecommerce.playback.card;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import cf.l;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.playback.card.widget.ViewWrapper;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.UIUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements ILivePromotionCardContainerHandler {
    public final /* synthetic */ ExplainPlaybackCardPresenter a;
    public final /* synthetic */ l b;

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final il2.a b(com.bytedance.android.btm.api.model.d r1) {
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final boolean i(ql.a r1, int r2, boolean r3) {
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final Object l() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void m() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final com.bytedance.android.livesdk.livecommerce.largemode.b o() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void d() {
        ExplainPlaybackCardPresenter r0 = this.a;
        if (r0.o == false) goto L5;
        r0.t = true;
        ExplainPlaybackCardPresenter.d0(r0, false);
        cj2.c r1 = cj2.a.a;
        HashMap r2 = new HashMap();
        r2.put("ecom_entrance_form", "replay_popup_card");
        r2.put("card_status", "1");
        cj2.a.a("livesdk_replay_popup_card_recover", r2, null, null);
        return;
    L5:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r0.h, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r0.h, "translationY", new float[]{UIUtils.dip2Px(r0.Y().c(), 12.0f)});
        ViewParent r10 = r0.a0().getParent();
        if ((r10 instanceof ViewGroup) == true) goto L8;
        r10 = null;
    L8:
        ViewGroup r11 = (ViewGroup) r10;
        if (r11 == null) goto L12;
        View r12 = r11.findViewById(2131367496);
        if (r12 == null) goto L12;
    L13:
        ObjectAnimator r9 = ObjectAnimator.ofInt(new ViewWrapper(r12), "height", new int[]{(int) UIUtils.dip2Px(r0.Y().c(), 164.0f), (int) UIUtils.dip2Px(r0.Y().c(), 52.0f)});
        AnimatorSet r13 = new AnimatorSet();
        r13.playTogether(new Animator[]{r3, r8, r9});
        r13.setDuration(200);
        r13.start();
        r13.addListener(new e(r0));
        cj2.c r4 = cj2.a.a;
        HashMap r5 = new HashMap();
        r5.put("ecom_entrance_form", "replay_popup_card");
        cj2.a.a("livesdk_replay_popup_card_close", r5, null, null);
        return;
    L12:
        r12 = new View(r0.Y().c());
        goto L13
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.d g() {
        return com.bytedance.android.livesdk.livecommerce.promotion.card.a.a;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final Map<String, Object> e(ILivePromotionCardContainerHandler.ContainerPriority r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r2, "key");
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void f(ECUIPromotion r2) {
        Intrinsics.checkNotNullParameter(r2, "promotion");
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r3 = this.a.p;
        if (r3 == null) goto L8;
        com.bytedance.android.ec.common.api.jump.model.g r0 = r3.Y0();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.livecommerce.promotion.card.b.a.b(r3, r0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final boolean h(Decision r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (a.a[r4.ordinal()] == 1) goto L6;
        Intrinsics.checkNotNullParameter(r4, "key");
        return false;
    L6:
        return this.a.o;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void j(String r4) {
        Intrinsics.checkNotNullParameter(r4, "productId");
        Intrinsics.checkNotNullParameter("operation_start_time", "event");
        Intrinsics.checkNotNullParameter(r4, "productId");
        Intrinsics.checkNotNullParameter("operation_start_time", "event");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void k(ql.a r2) {
        Intrinsics.checkNotNullParameter(r2, "promotion");
        Intrinsics.checkNotNullParameter(r2, "promotion");
    }

    public f(ExplainPlaybackCardPresenter r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final boolean p(View r3, ql.a r4) {
        Intrinsics.checkNotNullParameter(r3, "cartView");
        Intrinsics.checkNotNullParameter(r4, "promotion");
        Intrinsics.checkNotNullParameter(r3, "cartView");
        Intrinsics.checkNotNullParameter(r4, "promotion");
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void c(String r1, int r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "promotionId");
        Intrinsics.checkNotNullParameter(r1, "promotionId");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    @Deprecated(message = "临时兼容，二期改为动态可配")
    public final <T> T n(ILivePromotionCardContainerHandler.Scene r2, KClass<T> r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TYPE);
        return null;
    }
}
