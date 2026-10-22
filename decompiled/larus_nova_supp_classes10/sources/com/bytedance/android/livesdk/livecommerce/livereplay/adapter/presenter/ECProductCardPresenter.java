package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter;

import cf.j;
import cf.r;
import cj2.c;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module.f;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.b;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECProductCardPresenter extends QPresenter implements j {
    public r e;
    public b f;
    public final Lazy g;
    public final f h;
    public final ni2.b i;

    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "promotionId");
    }

    public final void C() {
        r r0 = this.e;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("promotionItem");
    L6:
        r0.onViewRecycled();
    L7:
        b r1 = this.f;
        if (r1 == null) goto L13;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L11:
        r1.release();
        return;
    }

    public final void A(QModel r6) {
        if (this.f == null) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L13;
        b r1 = this.h.l;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L11:
        this.f = r1;
    L13:
        if ((r6 instanceof ni2.a) == true) goto L15;
        r6 = null;
    L15:
        final ni2.a r7 = (ni2.a) r6;
        if (r7 != null) goto L19;
        return;
    L19:
        if (r7.j != null) goto L21;
        return;
    L21:
        b r2 = this.f;
        if (r2 != null) goto L24;
    L33:
        int r3 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
        if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(this.i.h) == false) goto L37;
        c r4 = cj2.a.a;
        cj2.a.d("1", r7.g, r7.f, this.i.d.f(Integer.valueOf(r7.j.getIronIndex())), BtmSDK.INSTANCE.getPageId(PageFinder.via(y())));
        return;
    L37:
        return;
    L24:
        if (r2 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L26:
        r2.w2(new com.bytedance.android.livesdk.livecommerce.promotion.card.j(r2.getUIConfig()).a(PromotionCardModuleName.ImageAreaIndex, new ECProductCardPresenter$onBind$3(r7)).a);
        b r5 = this.f;
        if (r5 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L29:
        com.bytedance.android.ec.common.api.jump.model.b r8 = (com.bytedance.android.ec.common.api.jump.model.a) ((Function0) this.g.getValue()).invoke();
        if (r8 != null) goto L32;
        r8 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L32:
        b.a.b(r5, r8.buildParams(Reflection.getOrCreateKotlinClass(g.class), new g.a(r7.j)));
        goto L33
    L5:
        r0 = false;
        goto L7
    }

    public final void e(ql.a r3) {
        Intrinsics.checkNotNullParameter(r3, "promotion");
        int r4 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
        QContext r5 = u();
        ni2.b r0 = this.i;
        AbsECScrollProductCardBaseVideModel r6 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a(r5, r0.h, r0.j);
        if (r6 == null) goto L6;
        r6.clickProductCard();
        return;
    }

    public ECProductCardPresenter(f r2, ni2.b r3) {
        Intrinsics.checkNotNullParameter(r2, "uiModule");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.h = r2;
        this.i = r3;
        this.g = LazyKt.lazy(new ECProductCardPresenter$absParams$2(this));
    }

    public final void c(String r1, int r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "promotionId");
        Intrinsics.checkNotNullParameter(r1, "promotionId");
    }
}
