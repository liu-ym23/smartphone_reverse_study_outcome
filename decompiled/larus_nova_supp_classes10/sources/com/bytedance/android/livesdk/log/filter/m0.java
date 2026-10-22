package com.bytedance.android.livesdk.log.filter;

import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m0 extends a<PadLoggerData> {
    public m0() {
    }

    public static void J(Map<String, String> r3) {
        o r0 = com.bytedance.android.livesdk.log.u.l().c(PadLoggerData.class);
        if ((r0 instanceof m0) == false) goto L15;
        ((m0) r0).getClass();
        ce1.d r1 = ce1.e.a;
        String r2 = BDLocationException.ERROR_TIMEOUT;
        if (r1 == null) goto L7;
        String r4 = r1.a();
    L8:
        HashMap r5 = (HashMap) r3;
        r5.put("is_pad", r4);
        ce1.d r6 = ce1.e.a;
        if (r6 != null) goto L11;
    L13:
        r5.put("liveroom_orientation", r2);
        return;
    L11:
        if (r6.e() == false) goto L13;
        r2 = "1";
        goto L13
    L7:
        r4 = BDLocationException.ERROR_TIMEOUT;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r4) {
        super.a(r4);
        ce1.d r0 = ce1.e.a;
        String r1 = BDLocationException.ERROR_TIMEOUT;
        if (r0 != null) goto L5;
    L7:
        String r2 = BDLocationException.ERROR_TIMEOUT;
    L8:
        r4.put("liveroom_orientation", r2);
        ce1.d r3 = ce1.e.a;
        if (r3 == null) goto L11;
        r1 = r3.a();
    L11:
        r4.put("is_pad", r1);
        return;
    L5:
        if (r0.e() == false) goto L7;
        r2 = "1";
        goto L8
    }
}
