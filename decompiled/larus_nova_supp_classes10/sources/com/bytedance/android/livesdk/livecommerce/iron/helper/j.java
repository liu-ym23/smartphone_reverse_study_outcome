package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ PromotionJumpDispatcher a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ il2.a d;
    public final /* synthetic */ Function0 e;

    public j(PromotionJumpDispatcher r1, String r2, Context r3, il2.a r4, Function0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r12) {
        Throwable r13 = (Throwable) r12;
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(this.b, MetricNames.API_DURATION);
        String r1 = th.a.g(this.c, 2131894402);
        PromotionJumpDispatcher.z(this.a, this.c, r1);
        il2.a r3 = this.d;
        if (r3 == null) goto L5;
        il2.a.C0145a.a(r3, "req_apply_coupon_fail", null, false, r13.getMessage(), null, null, 48);
    L5:
        this.e.invoke();
        com.bytedance.android.ec.core.monitor.c.d(this.b);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
