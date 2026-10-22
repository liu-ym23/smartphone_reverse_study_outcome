package com.bytedance.android.livesdk.log.filter;

import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e0 extends a<am2.r> {
    public e0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r3, Object r4) {
        am2.r r5 = (am2.r) r4;
        super.u(r3, r5);
        if (r5 == null) goto L14;
        r3.put("windows_type", String.valueOf(r5.a));
        r3.put("initial_page", r5.b);
        r3.put("trigger_scene", r5.c);
        if ("content".equals(r5.b) == true) goto L8;
        return;
    L8:
        if (r5.d == false) goto L10;
        String r6 = "1";
    L11:
        r3.put("is_auto_play", r6);
        return;
    L10:
        r6 = BDLocationException.ERROR_TIMEOUT;
        goto L11
    }
}
