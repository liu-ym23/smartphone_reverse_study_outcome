package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2BidInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class t0 implements am3.c<ECV2BidInfo> {
    public t0() {
    }

    public static ECV2BidInfo a(am3.g r100) throws Exception {
        ECV2BidInfo r101 = new ECV2BidInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.promotionId = am3.h.c(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2BidInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
