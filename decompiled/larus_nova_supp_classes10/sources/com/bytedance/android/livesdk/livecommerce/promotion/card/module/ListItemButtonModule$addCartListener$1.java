package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.v;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.i;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ListItemButtonModule$addCartListener$1 implements cf.a {
    public final /* synthetic */ ListItemButtonModule a;

    public final jf.e a() {
        return null;
    }

    public final boolean c() {
        return true;
    }

    public final void onFailed() {
    }

    public ListItemButtonModule$addCartListener$1(ListItemButtonModule r1) {
        this.a = r1;
    }

    public final void b(int r1, String r2, String r3, String r4, Integer r5, String r6, String r7, Integer r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "addType");
        i r10 = this.a.b;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        ql.a r11 = r10.a.a;
        boolean r12 = false;
        if (r11 == null) goto L10;
        v r13 = ((ECUIPromotion) r11).stepperInfo;
        if (r13 == null) goto L10;
        int r14 = r13.b();
    L12:
        if (Intrinsics.areEqual(r9, "stepper_add") == false) goto L14;
    L15:
        if (r8 == null) goto L21;
        v r15 = ((ECUIPromotion) r11).stepperInfo;
        if (r15 == null) goto L19;
        r15.d(r8.intValue());
    L19:
        this.a.h(r11);
    L21:
        if (Intrinsics.areEqual(r9, "stepper_sub") == false) goto L24;
        return;
    L24:
        if (this.a.f.getVisibility() != 0) goto L26;
        r12 = true;
    L26:
        if (r12 == false) goto L30;
        if (r14 <= 0) goto L29;
        ECDraweeView r16 = this.a.h;
    L31:
        LivePromotionCardArgs r17 = this.a.c;
        if (r17 == null) goto L39;
        ILivePromotionCardContainerHandler r18 = r17.b;
        if (r18 == null) goto L39;
        if (r18.p(r16, r11) != true) goto L39;
        dm.a.a("LiveAddCart").i("ListItemButtonModule addCartSuccessForAnim == true");
        return;
    L39:
        LivePromotionCardArgs r19 = this.a.c;
        if (r19 == null) goto L44;
        ILivePromotionCardContainerHandler r20 = r19.b;
        if (r20 == null) goto L44;
        r20.m();
    L44:
        dm.a.a("LiveAddCart").i("ListItemButtonModule is show toast = " + Intrinsics.areEqual(r9, "normal_add"));
        if (Intrinsics.areEqual(r9, "normal_add") == false) goto L48;
        ECToast.showToast$default(ECToast.INSTANCE, this.a.getContext(), th.a.g(this.a.getContext(), 2131913777), null, 4, null);
        return;
    L48:
        return;
    L29:
        r16 = this.a.i;
        goto L31
    L30:
        r16 = this.a.d;
        goto L31
    L14:
        if (Intrinsics.areEqual(r9, "stepper_sub") == false) goto L21;
    L10:
        r14 = 0;
        goto L12
    }
}
