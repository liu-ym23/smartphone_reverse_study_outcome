package si2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class d2 implements am3.c<b0> {
    public d2() {
    }

    @Override // am3.c
    public final b0 decode(am3.g r100) throws Exception {
        b0 r101 = new b0();
        r101.listRoomStatsData = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.msgType = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.authorOrderLimitInfo = com.bytedance.android.livesdk.livecommerce.model.f.a(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.listRoomStatsData.add(r0.a(r100));
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.flashPopupInfo = e1.a(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }
}
