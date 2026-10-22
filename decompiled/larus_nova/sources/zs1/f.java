package zs1;

import com.bytedance.android.livesdk.coupon.balancecoupon.CouponSubType;
import com.bytedance.android.livesdk.coupon.balancecoupon.CouponType;

/* JADX INFO: loaded from: classes8.dex */
public final class f {
    public static final boolean a(com.bytedance.android.livesdk.coupon.balancecoupon.model.a r100) {
        if (r100 == null) goto L26;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r101 = r100.d();
        if (r101 == null) goto L26;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r102 = r101.b();
        if (r102 == null) goto L26;
        if (r102.c() != CouponType.CouponType_Platform.getValue()) goto L26;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r103 = r100.d();
        if (r103 == null) goto L17;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r104 = r103.b();
        if (r104 == null) goto L17;
        if (r104.b() != CouponSubType.CouponSubType_FullAmount.getValue()) goto L17;
        return true;
    L17:
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r105 = r100.d();
        if (r105 == null) goto L26;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r106 = r105.b();
        if (r106 == null) goto L26;
        if (r106.b() != CouponSubType.CouponSubType_Amount.getValue()) goto L26;
        return true;
    L26:
        return false;
    }
}
