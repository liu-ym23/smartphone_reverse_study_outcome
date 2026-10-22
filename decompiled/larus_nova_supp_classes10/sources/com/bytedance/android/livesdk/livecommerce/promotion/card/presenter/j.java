package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import android.view.ViewGroup;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j extends QPresenter {
    public w83.i e;
    public final Lazy<w83.i> f;

    public final void C() {
        w83.i r0 = this.e;
        if (r0 == null) goto L6;
        r0.d((ViewGroup) w().f());
        return;
    }

    public j(Lazy<? extends w83.i> r2) {
        Intrinsics.checkNotNullParameter(r2, "ligoViewManager");
        this.f = r2;
    }

    public final void A(QModel r5) {
        if (this.e != null) goto L5;
        this.e = (w83.i) this.f.getValue();
    L5:
        Boolean r1 = null;
        if ((r5 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.i) == true) goto L8;
        r5 = null;
    L8:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r6 = (com.bytedance.android.livesdk.livecommerce.promotion.card.i) r5;
        if (r6 == null) goto L38;
        IPromotionUIConfig.d r0 = r6.c.a(PromotionCardModuleName.TopModule);
        if (r0 == null) goto L14;
        r1 = r0.d();
    L14:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == true) goto L45;
        ECUIPromotion r2 = r6.a.a;
        int r7 = i.a[r6.b.ordinal()];
        if (r7 != 1) goto L19;
        ll.a r8 = r2.promotionHeader;
        if (r8 == null) goto L33;
        w().g(0);
        w83.i r3 = this.e;
        if (r3 == null) goto L41;
        ll.b r9 = w83.i.a.a(r3, (ViewGroup) w().f(), r8, false, 12);
        if (r9 == null) goto L42;
        Integer r10 = r9.a;
        if (r10 == null) goto L43;
        w().b(r10.intValue()).f().getLayoutParams().width = -1;
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L33:
        w83.i r11 = this.e;
        if (r11 == null) goto L36;
        r11.d((ViewGroup) w().f());
    L36:
        w().c();
        return;
    L19:
        if (r7 != 2) goto L46;
        w83.i r12 = this.e;
        if (r12 == null) goto L39;
        r12.d((ViewGroup) w().f());
        return;
    L39:
        return;
    L46:
        return;
    L45:
        return;
    }
}
