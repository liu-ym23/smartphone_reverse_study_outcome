package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class CouponEventDispatcher {
    public static boolean a;

    public static final class a implements j {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a.invoke(r2);
        }
    }

    public static void c() {
        if (a == false) goto L5;
        return;
    L5:
        a = true;
        b("ecom.coupon.moveToState", CouponEventDispatcher$registerSubscriber$1.INSTANCE);
        b("ecom.coupon.didApplyCoupon", CouponEventDispatcher$registerSubscriber$2.INSTANCE);
        b("ecom.coupon.registerTempShortTouch", CouponEventDispatcher$registerSubscriber$3.INSTANCE);
        b("ecom.coupon.changeTempWidth", CouponEventDispatcher$registerSubscriber$4.INSTANCE);
        b("ecom.coupon.showNormalState", CouponEventDispatcher$registerSubscriber$5.INSTANCE);
        b("ecom.coupon.short_touch_coupon_msg", CouponEventDispatcher$registerSubscriber$6.INSTANCE);
    }

    static {
    }

    public static void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "log");
        ECLiveEntranceMonitor.trace$default("loadCoupon " + r4, "ShortTouchLynxCoupon", false, 4, null);
    }

    public static void b(String r1, Function1 r2) {
        ECLiveHybridUtil.m(r1, new a(r2));
    }
}
