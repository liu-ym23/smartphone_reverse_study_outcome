package si2;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d2 implements am3.c<b0> {
    public d2() {
    }

    public final Object decode(am3.g r6) throws Exception {
        b0 r0 = new b0();
        r0.listRoomStatsData = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L18;
        if (r3 != 1) goto L8;
        r0.msgType = r6.i();
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.authorOrderLimitInfo = com.bytedance.android.livesdk.livecommerce.model.f.a(r6);
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.listRoomStatsData.add(r0.a(r6));
        goto L3
    L12:
        if (r3 != 4) goto L13;
        r0.flashPopupInfo = e1.a(r6);
        goto L3
    L13:
        am3.h.e(r6);
        goto L3
    L18:
        r6.d(r1);
        return r0;
    }
}
