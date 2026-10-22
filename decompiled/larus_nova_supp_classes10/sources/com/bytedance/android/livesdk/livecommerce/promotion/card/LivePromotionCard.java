package com.bytedance.android.livesdk.livecommerce.promotion.card;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemRootModule;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.utils.LiveBstReport;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionCard implements b, ViewTreeObserver.OnPreDrawListener {
    public final LivePromotionCardArgs a;
    public final QUIManager b;
    public com.bytedance.android.ec.common.api.jump.model.e c;
    public boolean d;
    public k e;
    public final Map<PromotionCardModuleName, Integer> f;
    public final Rect g;

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final com.bytedance.android.ec.common.api.jump.model.g Y0() {
        com.bytedance.android.ec.common.api.jump.model.e r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final Map<PromotionCardModuleName, IPromotionUIConfig.d> getUIConfig() {
        return this.e.a;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View r0 = this.b.p();
        if (r0.getGlobalVisibleRect(this.g) == true) goto L5;
        return true;
    L5:
        if (r0.isShown() == true) goto L7;
        return true;
    L7:
        if (this.d == false) goto L18;
        final com.bytedance.android.ec.common.api.jump.model.g r1 = Y0();
        if (r1 == null) goto L19;
        final ql.a r2 = r1.a;
        il.a r3 = this.a.e;
        String r4 = r2.getUniTag();
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        r3.c("livesdk_show_product", r4, new LivePromotionCard$onPreDraw$$inlined$also$lambda$1(r1, r2, this));
        return true;
    L19:
        return true;
    L18:
        return true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final void release() {
        com.bytedance.android.ec.common.api.jump.model.e r0 = this.c;
        if (r0 == null) goto L5;
        this.b.c(ListItemRootModule.class, new i(r0, UpdateType.VIEW_RECYCLED, this.e));
    L5:
        this.a.f.clearDisposable();
        this.b.p().getViewTreeObserver().removeOnPreDrawListener(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final View F0(PromotionCardModuleName r2) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Integer r3 = (Integer) ((LinkedHashMap) this.f).get(r2);
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
        if (r4 != 0) goto L9;
        return this.b.p();
    L9:
        return this.b.p().findViewById(r4);
    L11:
        return this.b.p();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final void w2(Map<PromotionCardModuleName, IPromotionUIConfig.d> r6) {
        Intrinsics.checkNotNullParameter(r6, "config");
        k r0 = new k(r6);
        this.e = r0;
        com.bytedance.android.ec.common.api.jump.model.e r7 = this.c;
        if (r7 == null) goto L6;
        this.b.c(ListItemRootModule.class, new i(r7, UpdateType.UPDATE_ALL, r0));
        return;
    }

    public LivePromotionCard(ViewGroup r7, g r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "argument");
        LivePromotionCardArgs r0 = new LivePromotionCardArgs(r8);
        this.a = r0;
        QUIManager r9 = new QUIManager();
        this.b = r9;
        this.e = (k) IPromotionUIConfig.a.getValue();
        int r1 = UIConfigHelper.a;
        Pair[] r2 = {TuplesKt.to(PromotionCardModuleName.Title, 2131391606), TuplesKt.to(PromotionCardModuleName.ImageAreaModule, 2131377867), TuplesKt.to(PromotionCardModuleName.InfoAreaModule, 2131378719), TuplesKt.to(PromotionCardModuleName.PriceAreaModule, 2131367779), TuplesKt.to(PromotionCardModuleName.ButtonAreaModule, 2131377852), TuplesKt.to(PromotionCardModuleName.BottomModule, 2131377851), TuplesKt.to(PromotionCardModuleName.TopModule, 2131372875), TuplesKt.to(PromotionCardModuleName.CloseModule, 2131376518), TuplesKt.to(PromotionCardModuleName.AddCartModule, 2131374918), TuplesKt.to(PromotionCardModuleName.BuyModule, 2131390705), TuplesKt.to(PromotionCardModuleName.CardModule, 2131375664)};
        Intrinsics.checkNotNullParameter(r2, "moduleIdPair");
        LinkedHashMap r3 = new LinkedHashMap();
        MapsKt.putAll(r3, r2);
        r3.put(PromotionCardModuleName.Parent, 0);
        this.f = r3;
        ShoppingAsyncInflater.a r4 = ShoppingAsyncInflater.e;
        Context r5 = r7.getContext();
        r4.getClass();
        r9.l(new ListItemRootModule(ShoppingAsyncInflater.a.a(r5).aU(2131564744, r7, false), r0, r3, new AnonymousClass1(this)), r7.getContext(), true);
        r9.p().getViewTreeObserver().addOnPreDrawListener(this);
        this.g = new Rect();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final void A1(com.bytedance.android.ec.common.api.jump.model.g r10, UpdateType r11) {
        Intrinsics.checkNotNullParameter(r10, "promotionParams");
        Intrinsics.checkNotNullParameter(r11, "updateType");
        com.bytedance.android.ec.common.api.jump.model.e r0 = this.c;
        String r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.ec.common.api.jump.model.g r2 = r0.b;
    L7:
        if ((!Intrinsics.areEqual(r2, r10)) == true) goto L14;
        com.bytedance.android.ec.common.api.jump.model.e r3 = this.c;
        if (r3 == null) goto L11;
        ECUIPromotion r4 = r3.a;
    L13:
        if ((!Intrinsics.areEqual(r4, r10.a)) == true) goto L14;
    L20:
        final com.bytedance.android.ec.common.api.jump.model.e r8 = this.c;
        if (r8 == null) goto L42;
        this.d = true;
        this.b.c(ListItemRootModule.class, new i(r8, r11, this.e));
        if (r11 == UpdateType.UPDATE_EXPOSE) goto L43;
        final ECUIPromotion r7 = r8.a;
        g.a r12 = this.a.a;
        if (r12 == null) goto L27;
        r1 = r12.a(LivePromotionCard$bindNewBst$promotionBtm$1.INSTANCE, r7.getIronIndex());
    L27:
        if (r1 != null) goto L29;
        final String r6 = "";
    L30:
        final com.bytedance.android.bst.api.e r13 = new com.bytedance.android.bst.api.e(this.b.p());
        r13.a = r6;
        if (r7.isLottery() == false) goto L33;
        String r14 = "livesdk_unrec_show_product";
    L34:
        r13.b = r14;
        if (r7.isLottery() == false) goto L37;
        String r15 = "live_shopping_lottery";
    L38:
        r13.d = r15;
        r13.c = r7.getUniTag();
        r13.e = 2131370502;
        r13.f = new LiveBstReport(new LivePromotionCard$bindNewBst$$inlined$apply$lambda$1(this, r6, r7, r8), new LivePromotionCard$bindNewBst$$inlined$apply$lambda$2(r13, this, r6, r7, r8));
        com.bytedance.android.bst.api.f r16 = com.bytedance.android.bst.api.f.b;
        com.bytedance.android.bst.api.d r17 = BtmUtilsKt.h(r13);
        r16.getClass();
        com.bytedance.android.bst.api.f.a(r17);
        return;
    L37:
        r15 = "live_shopping";
        goto L38
    L33:
        r14 = "livesdk_show_product";
        goto L34
    L29:
        r6 = r1;
        goto L30
    L43:
        return;
    L42:
        return;
    L11:
        r4 = null;
    L14:
        int r5 = com.bytedance.android.ec.common.api.jump.model.e.c;
        Intrinsics.checkNotNullParameter(r10, "params");
        com.bytedance.android.ec.common.api.jump.model.b r9 = r10.getParent();
        if (r9 != null) goto L17;
        r9 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L17:
        KClass r18 = Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.e.class);
        ECUIPromotion r19 = r10.a;
        if (r19 == null) goto L41;
        this.c = r9.buildParams(r18, new com.bytedance.android.ec.common.api.jump.model.e.b(r19, r10));
        goto L20
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    L5:
        r2 = null;
        goto L7
    }
}
