package com.bytedance.android.shopping.store.hybridproduct.module;

import com.bytedance.android.shopping.store.hybridproduct.dto.ShopCouponResponseDTO;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ ECShopMiddleCouponFilterPresenter a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function0 c;

    public j(ECShopMiddleCouponFilterPresenter r1, Function1 r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        ShopCouponResponseDTO r9 = (ShopCouponResponseDTO) r8;
        if (r9.getStatusCode() == 0) goto L7;
        String r10 = com.bytedance.android.shopping.extensions.k.k(r9.getMessage(), "网络错误");
        ECToast.showToast$default(ECToast.INSTANCE, this.a.u().c(), r10, null, 4, null);
        Function1 r0 = this.b;
        if (r0 == null) goto L12;
        Unit r11 = (Unit) r0.invoke(new IllegalStateException(r10));
        return;
    L12:
        return;
    L7:
        Function0 r1 = this.c;
        if (r1 == null) goto L10;
        Unit r2 = (Unit) r1.invoke();
    L10:
        dm.a.a("ECShopMemberCardPresenter").a("applyCoupon:" + r9.getStatusCode());
    }
}
