package com.bytedance.android.livesdk.livecommerce.dynamic.compose.router;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements ILivePromotionCardContainerHandler {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final il2.a b(d r1) {
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final void f(ECUIPromotion r2) {
        Intrinsics.checkNotNullParameter(r2, "promotion");
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

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler
    public final Map<String, Object> e(ILivePromotionCardContainerHandler.ContainerPriority r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r2, "key");
        return null;
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
    public final void k(ql.a r2) {
        Intrinsics.checkNotNullParameter(r2, "promotion");
        Intrinsics.checkNotNullParameter(r2, "promotion");
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
