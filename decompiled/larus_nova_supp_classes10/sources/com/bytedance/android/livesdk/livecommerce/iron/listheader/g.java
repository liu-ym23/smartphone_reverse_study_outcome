package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ gi2.a c;
    public final /* synthetic */ Map d;

    public g(boolean r1, String r2, gi2.a r3, Map r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        if (this.a == false) goto L8;
        String r4 = "livesdk_click_" + this.b;
        com.bytedance.android.ec.common.api.jump.model.b r5 = this.c;
        if (r5 != null) goto L7;
        r5 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        v r0 = new v(r4, r5);
        r0.c("click_area", "live_list");
        r0.d(this.d);
        r0.i(null);
        return;
    L8:
        String r6 = "livesdk_show_" + this.b;
        com.bytedance.android.ec.common.api.jump.model.b r7 = this.c;
        if (r7 != null) goto L11;
        r7 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L11:
        v r1 = new v(r6, r7);
        r1.c("click_area", "live_list");
        r1.d(this.d);
        r1.i(null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
