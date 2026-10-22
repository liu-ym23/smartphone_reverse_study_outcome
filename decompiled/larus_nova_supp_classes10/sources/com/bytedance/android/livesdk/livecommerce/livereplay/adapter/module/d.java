package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module;

import android.content.Context;
import android.view.View;
import cf.j;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements ILivePromotionCardContainerHandler {
    public final /* synthetic */ f a;

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final il2.a b(com.bytedance.android.btm.api.model.d r1) {
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void d() {
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
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.d g() {
        return com.bytedance.android.livesdk.livecommerce.promotion.card.a.a;
    }

    public d(f r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final Map<String, Object> e(ILivePromotionCardContainerHandler.ContainerPriority r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r2, "key");
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void f(ECUIPromotion r4) {
        Intrinsics.checkNotNullParameter(r4, "promotion");
        Iterator r0 = ((ArrayList) this.a.m).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((j) r0.next()).j(r4.getPromotionId());
        goto L4
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final boolean h(Decision r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r2, "key");
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void j(String r4) {
        Intrinsics.checkNotNullParameter(r4, "productId");
        Intrinsics.checkNotNullParameter("operation_start_time", "event");
        Intrinsics.checkNotNullParameter(r4, "productId");
        Intrinsics.checkNotNullParameter("operation_start_time", "event");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void k(ql.a r13) {
        Intrinsics.checkNotNullParameter(r13, "promotion");
        Iterator r0 = ((ArrayList) this.a.m).iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        j r1 = (j) r0.next();
        cj2.c r2 = cj2.a.a;
        Map r3 = r13.getEventParams();
        int r4 = r13.getIronIndex();
        f r5 = this.a;
        String r6 = r5.n.h;
        View r7 = ((QUIModule) r5).g;
        if (r7 == null) goto L17;
        if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(r6) == false) goto L17;
        if (r3 == null) goto L12;
        String r8 = (String) r3.get("is_replay_default_product");
    L13:
        if (r3 == null) goto L15;
        String r9 = (String) r3.get("replay_type");
    L16:
        cj2.a.b("click_blank", "1", r8, r9, "a1.b3390.c8362.d30754_i" + r4, BtmSDK.INSTANCE.getPageId(PageFinder.via(r7)));
        goto L17
    L15:
        r9 = null;
        goto L16
    L12:
        r8 = null;
    L17:
        r1.e(r13);
        goto L4
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
