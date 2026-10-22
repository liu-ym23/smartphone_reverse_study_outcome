package si2;

import com.bytedance.android.livesdk.livecommerce.model.AuctionUser;

/* JADX INFO: loaded from: classes10.dex */
public final class l0 implements am3.c<AuctionUser> {
    public l0() {
    }

    public static AuctionUser a(am3.g r100) throws Exception {
        AuctionUser r101 = new AuctionUser();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.isSelf = am3.h.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.name = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.profile = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final AuctionUser decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
