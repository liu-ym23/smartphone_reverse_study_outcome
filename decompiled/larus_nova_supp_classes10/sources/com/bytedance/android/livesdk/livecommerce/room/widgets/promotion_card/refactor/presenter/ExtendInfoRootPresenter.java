package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPopExtendInfo;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExtendInfoRootPresenter extends p {
    public ECUIPromotion g;
    public Runnable h;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ExtendInfoRootPresenter a;

        public a(ExtendInfoRootPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            ECUIPromotion r6 = (ECUIPromotion) r5;
            ExplainCardViewModel r0 = this.a.e;
            String r1 = null;
            if (r0 == null) goto L21;
            QLiveData<pk2.d> r2 = r0.getCardExtendInfoState();
            if (r2 == null) goto L21;
            pk2.d r3 = (pk2.d) r2.a();
            if (r3 == null) goto L21;
            if (r3.b != 2) goto L21;
            if (r6 == null) goto L12;
            String r4 = r6.getPromotionId();
        L13:
            if (r4 == null) goto L21;
            String r7 = r6.getPromotionId();
            ECUIPromotion r8 = this.a.g;
            if (r8 == null) goto L17;
            String r9 = r8.getPromotionId();
        L19:
            if (Intrinsics.areEqual(r7, r9) == false) goto L21;
            return;
        L17:
            r9 = null;
            goto L19
        L12:
            r4 = null;
        L21:
            if (r6 == null) goto L23;
            ECPopExtendInfo r10 = r6.extendInfo;
        L24:
            if (r10 != null) goto L34;
            ExtendInfoRootPresenter r11 = this.a;
            Runnable r12 = r11.h;
            if (r12 == null) goto L28;
            r11.w().f().removeCallbacks(r12);
        L28:
            ExplainCardViewModel r13 = this.a.e;
            if (r13 == null) goto L33;
            QLiveData<pk2.d> r14 = r13.getCardExtendInfoState();
            if (r14 == null) goto L33;
            r14.e(new pk2.d(0, 3));
        L33:
            this.a.u().d().q(rk2.i.class, 8);
        L45:
            this.a.g = r6;
            return;
        L34:
            String r15 = r6.getPromotionId();
            ECUIPromotion r16 = this.a.g;
            if (r16 == null) goto L38;
            r1 = r16.getPromotionId();
        L38:
            if ((!Intrinsics.areEqual(r15, r1)) == false) goto L45;
            ExplainCardViewModel r17 = this.a.e;
            if (r17 == null) goto L44;
            QLiveData<pk2.d> r18 = r17.getCardExtendInfoState();
            if (r18 == null) goto L44;
            r18.e(new pk2.d(1, 1));
        L44:
            ExtendInfoRootPresenter r19 = this.a;
            r19.h = new t(this, r6);
            r19.w().f().postDelayed(this.a.h, r6.extendInfo.getDelay());
            goto L45
        L23:
            r10 = null;
            goto L24
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void C() {
        clearDisposable();
        this.g = null;
    }

    public ExtendInfoRootPresenter() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L7;
        QLiveData<ECUIPromotion> r1 = r0.getPromotionState();
        if (r1 == null) goto L7;
        r1.b(r5.getLifecycleOwner(), new a(this));
    L7:
        com.bytedance.android.ec.core.widget.f.c(w().f(), null, "bind_key_live_cart_card", new ExtendInfoRootPresenter$bind$2(this), 1);
    }
}
