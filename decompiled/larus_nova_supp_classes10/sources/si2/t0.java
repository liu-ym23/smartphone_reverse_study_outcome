package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2BidInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t0 implements am3.c<ECV2BidInfo> {
    public t0() {
    }

    public static ECV2BidInfo a(am3.g r5) throws Exception {
        ECV2BidInfo r0 = new ECV2BidInfo();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.promotionId = am3.h.c(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
