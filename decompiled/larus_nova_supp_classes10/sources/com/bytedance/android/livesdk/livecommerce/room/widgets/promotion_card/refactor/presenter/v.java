package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPopExtendInfo;
import com.bytedance.android.ec.model.response.ExtendInfoTopContent;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v extends p {

    public static final class a<T> implements Observer {
        public final /* synthetic */ ExplainCardViewModel a;
        public final /* synthetic */ v b;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c c;

        public a(ExplainCardViewModel r1, v r2, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r10) {
            pk2.d r11 = (pk2.d) r10;
            if (r11.b != 2) goto L42;
            v r0 = this.b;
            ECPopExtendInfo r12 = r11.a;
            if (r12 == null) goto L9;
            ExtendInfoTopContent r13 = r12.getTopContent();
            if (r13 == null) goto L9;
            List<com.bytedance.android.ec.model.live.b> r14 = r13.getContent();
        L11:
            if (r14 == null) goto L15;
            r0.getClass();
            if ((!r14.isEmpty()) != true) goto L15;
            boolean r3 = true;
        L16:
            View r4 = r0.w().b(2131377629).f();
            int r5 = 8;
            if (r3 == false) goto L19;
            int r6 = 8;
        L20:
            r4.setVisibility(r6);
            ECCustomizedElementView r1 = (ECCustomizedElementView) r0.w().b(2131365443).f();
            if (r3 == false) goto L23;
            r5 = 0;
        L23:
            r1.setVisibility(r5);
            if (r3 == false) goto L28;
            if (r14 != null) goto L27;
            r14 = CollectionsKt.emptyList();
        L27:
            r1.b(r14, true);
        L28:
            ECDraweeView r7 = this.b.w().b(2131370429).f();
            ECUIPromotion r15 = (ECUIPromotion) this.a.getPromotionState().a();
            if (r15 == null) goto L41;
            h0.e(r7, r15.getImageUrl(), new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_view"), null, null, 120);
            if (r15.getStatus() != 1) goto L33;
        L40:
            this.b.w().b(2131392181).c();
            goto L41
        L33:
            if (r15.getStatus() == 7000) goto L40;
            if (r15.getStatus() == 8000) goto L40;
            if (r15.getStatus() == 9000) goto L40;
            this.b.w().b(2131392181).g(0);
        L41:
            this.b.y().postDelayed(new u(this), 300);
            return;
        L19:
            r6 = 0;
        L15:
            r3 = false;
        L9:
            r14 = null;
            goto L11
        L42:
            this.b.w().f().setBackgroundColor(0);
            this.b.w().g(4);
        }
    }

    public v() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L6;
        r0.getCardExtendInfoState().b(r5.getLifecycleOwner(), new a(r0, this, r5));
        return;
    }
}
