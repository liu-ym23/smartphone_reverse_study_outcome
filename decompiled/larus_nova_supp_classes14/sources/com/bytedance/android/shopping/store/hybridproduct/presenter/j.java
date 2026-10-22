package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.store.hybridproduct.dto.ShopCouponResponseDTO;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ ECShopMemberCardPresenter a;
    public final /* synthetic */ sj3.d b;

    public j(ECShopMemberCardPresenter r1, sj3.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        ShopCouponResponseDTO r9 = (ShopCouponResponseDTO) r8;
        if (r9.getStatusCode() == 0) goto L5;
        ECToast.showToast$default(ECToast.INSTANCE, this.a.Y().c(), com.bytedance.android.shopping.extensions.k.k(r9.getMessage(), "网络错误"), null, 4, null);
        return;
    L5:
        dm.a.a("ECShopMemberCardPresenter").a("applyCoupon:" + r9.getStatusCode());
        Map<String, String> r0 = r9.getExtra();
        if (r0 == null) goto L8;
        String r1 = r0.get("special_error_info");
    L10:
        if (Intrinsics.areEqual(r1, "-1000012") == false) goto L15;
        ECShopMemberCardPresenter r10 = this.a;
        sj3.d r2 = this.b;
        if (r2 != null) goto L14;
        r10.getClass();
        return;
    L14:
        r10.e0(r2);
        return;
    L15:
        ECToast.showToast$default(ECToast.INSTANCE, this.a.Y().c(), "领券成功", null, 4, null);
        this.a.e0(this.b);
        List<dj3.a> r11 = r9.getCouponItemList();
        if (r11 == null) goto L34;
        Iterator<T> r12 = r11.iterator();
    L19:
        if (r12.hasNext() == false) goto L35;
        dj3.a r3 = (dj3.a) r12.next();
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L23
        r4.put("coupon_meta_id", r3.a());     // Catch: Exception -> L23
        r4.put("coupon_status", "already_get");     // Catch: Exception -> L23
        Unit r5 = Unit.INSTANCE;     // Catch: Exception -> L23
        ECLiveHybridUtil.o("ecom.shop.dynamic_popup.coupon_update", r4);     // Catch: Exception -> L23
        ECLiveHybridUtil.o("ecom.shop.dynamic_popup.remote_coupon_update", new JSONObject());     // Catch: Exception -> L23
    L23:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        goto L19
    L35:
        return;
    L34:
        return;
    L8:
        r1 = null;
        goto L10
    }
}
