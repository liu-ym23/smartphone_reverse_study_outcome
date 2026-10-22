package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.livesdk.livecommerce.network.response.ECApplyCouponResponse;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ PromotionJumpDispatcher a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ il2.a d;
    public final /* synthetic */ Function0 e;

    public i(PromotionJumpDispatcher r1, String r2, Context r3, il2.a r4, Function0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r11) {
        ECApplyCouponResponse r12 = (ECApplyCouponResponse) r11;
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(this.b, MetricNames.API_DURATION);
        String r1 = null;
        if (r12 == null) goto L5;
        String r2 = ((com.bytedance.android.ec.model.g) r12).statusMessage;
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (r12 == null) goto L11;
        r1 = ((com.bytedance.android.ec.model.g) r12).statusMessage;
    L11:
        PromotionJumpDispatcher.z(this.a, this.c, r1);
        il2.a r3 = this.d;
        if (r3 == null) goto L14;
        il2.a.C0145a.a(r3, "req_apply_coupon_success", null, false, null, null, null, 62);
    L14:
        this.e.invoke();
        com.bytedance.android.ec.core.monitor.c.d(this.b);
        return;
    L10:
        r1 = th.a.g(this.c, 2131894402);
        goto L11
    L5:
        r2 = null;
        goto L7
    }
}
