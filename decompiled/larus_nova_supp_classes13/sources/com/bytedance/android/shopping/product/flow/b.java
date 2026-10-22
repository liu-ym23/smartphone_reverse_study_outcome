package com.bytedance.android.shopping.product.flow;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardBuyButton;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Observer<PromotionPackResponse> {
    public final /* synthetic */ ECBaseProductFlowCard a;
    public final /* synthetic */ String b;

    public final void onComplete() {
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onNext(Object r7) {
        PromotionPackResponse r8 = (PromotionPackResponse) r7;
        Intrinsics.checkNotNullParameter(r8, "resp");
        ECBaseProductFlowCard r0 = this.a;
        String r1 = this.b;
        Intrinsics.checkNotNullParameter(r8, "$this$getPromotion");
        ActivityVO r3 = null;
        if (r8.isValid() == false) goto L18;
        List r2 = r8.getPromotions();
        Intrinsics.checkNotNull(r2);
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        PromotionProductBaseStruct r6 = ((PromotionProductStruct) r5).getBaseInfo();
        if (r6 == null) goto L10;
        String r9 = r6.getPromotionId();
    L12:
        if (Intrinsics.areEqual(r9, r1) == false) goto L6;
    L15:
        PromotionProductStruct r10 = (PromotionProductStruct) r5;
        if (r10 != null) goto L19;
        List r11 = r8.getPromotions();
        Intrinsics.checkNotNull(r11);
        r10 = (PromotionProductStruct) ListProtector.get(r11, 0);
    L19:
        if (r10 == null) goto L29;
        r0.k = r10;
        ProductFlowCardBuyButton r12 = this.a.getBuyButton();
        PromotionProductStruct r13 = this.a.k;
        if (r13 == null) goto L24;
        r3 = f53.a.c(r13);
    L24:
        r12.setDepositPresaleAppointmentButtonText(r3);
        return;
    L29:
        return;
    L10:
        r9 = null;
        goto L12
    L14:
        r5 = null;
        goto L15
    L18:
        r10 = null;
        goto L19
    }

    public b(ECBaseProductFlowCard r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
