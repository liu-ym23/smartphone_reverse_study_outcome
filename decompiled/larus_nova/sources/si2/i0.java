package si2;

import com.bytedance.android.livesdk.livecommerce.model.AuctionAtmosphere;

/* JADX INFO: loaded from: classes10.dex */
public final class i0 implements am3.c<AuctionAtmosphere> {
    public i0() {
    }

    public static AuctionAtmosphere a(am3.g r100) throws Exception {
        AuctionAtmosphere r101 = new AuctionAtmosphere();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.countDown = o0.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.digital = p0.a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final AuctionAtmosphere decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
