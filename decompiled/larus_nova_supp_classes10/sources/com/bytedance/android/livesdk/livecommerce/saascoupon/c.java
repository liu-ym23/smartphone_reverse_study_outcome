package com.bytedance.android.livesdk.livecommerce.saascoupon;

import bl2.g;
import com.larus.apm.impl.protector.RunnableProtector;
import el2.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Runnable {
    public final /* synthetic */ el.b a;
    public final /* synthetic */ SaasCouponService.b b;
    public final /* synthetic */ bl2.b c;

    public c(el.b r1, SaasCouponService.b r2, bl2.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        SaasCouponService r0 = this.b.a;
        el.b r1 = this.a;
        g r2 = r0.c;
        k r3 = r0.a;
        if (r3 == null) goto L14;
        if (r0.l != null) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L14;
        r3.a(new e(r3, r0, r2, r1));
        goto L14
    L7:
        r4 = false;
    L14:
        if (Intrinsics.areEqual(this.c.b(), Boolean.TRUE) == false) goto L19;
        String r5 = this.c.f();
        if (r5 == null) goto L20;
        SaasCouponService.c(this.b.a, r5);
        return;
    L20:
        return;
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
