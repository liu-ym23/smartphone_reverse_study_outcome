package com.bytedance.android.livesdk.livecommerce.saascoupon;

import com.bytedance.android.ec.sdk.helper.r;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ SaasCouponService a;

    public b(SaasCouponService r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        boolean r4 = r.a.isLogin();
        if (this.a.g() == true) goto L17;
        if (r4 == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(this.a.c.c, "room_qcpx_coupon_popup") == true) goto L8;
    L9:
        Disposable r5 = this.a.u;
        if (r5 == null) goto L12;
        r5.dispose();
    L12:
        SaasCouponService r6 = this.a;
        r6.u = null;
        r6.d.removeCallbacks((Runnable) r6.q.getValue());
        SaasCouponService r7 = this.a;
        Runnable r0 = r7.s;
        if (r0 == null) goto L15;
        r7.d.removeCallbacks(r0);
    L15:
        this.a.e(false, false);
        return;
    L8:
        if (this.a.i == false) goto L9;
        return;
    }
}
