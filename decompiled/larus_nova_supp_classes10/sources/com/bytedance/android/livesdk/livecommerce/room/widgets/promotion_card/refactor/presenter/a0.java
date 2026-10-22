package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0 extends p {

    public static final class a<T> implements Observer {
        public final /* synthetic */ a0 a;

        public a(a0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            ECUIPromotion r11 = (ECUIPromotion) r10;
            if (r11 != null) goto L5;
        L22:
            this.a.u().d().q(rk2.l.class, 8);
            return;
        L5:
            if (r11.isAuction() == true) goto L22;
            if (r11.isAuctionV2() == true) goto L22;
            this.a.u().d().q(rk2.l.class, 0);
            final a0 r12 = this.a;
            final Query r0 = r12.w().b(2131370506);
            final Query r2 = r12.w().b(2131377583);
            final Query r3 = r12.w().b(2131375993);
            final Function3<View, Query, Query, Unit> r4 = new PromotionCardPresenter$resetClickListener$clickListener$1(r12);
            com.bytedance.android.ec.core.widget.f.c(r0.f(), null, "bind_key_live_cart_card", new PromotionCardPresenter$resetClickListener$1(r4, r0, r3), 1);
            Lazy r13 = ECSettingKeys.a;
            int r14 = com.bytedance.android.ec.core.opt.ab.p.a;
            Object r5 = Boolean.FALSE;
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L13
            jj4.b r9 = jj4.b.b;     // Catch: Throwable -> L13
            Object r15 = jj4.a.a("ecom_live_explain_card_click_area_extend", Boolean.class, r5, false);     // Catch: Throwable -> L13
            if (r15 != null) goto L20;
            Intrinsics.throwNpe();     // Catch: Throwable -> L13
        L20:
            if (((Boolean) r15).booleanValue() == false) goto L26;
            com.bytedance.android.ec.core.widget.f.c(r2.f(), null, "bind_key_live_cart_card", new PromotionCardPresenter$resetClickListener$2(r4, r2, r3), 1);
            return;
        L26:
            return;
        L13:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            Object r16 = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(r16) == true) goto L18;
            r5 = r16;
        L18:
            r15 = r5;
            goto L20
        }
    }

    public a0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L8;
        QLiveData<ECUIPromotion> r1 = r0.getPromotionState();
        if (r1 == null) goto L9;
        r1.b(r3.getLifecycleOwner(), new a(this));
        return;
    L9:
        return;
    }
}
