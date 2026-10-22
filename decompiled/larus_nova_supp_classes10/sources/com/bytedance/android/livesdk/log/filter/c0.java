package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c0 extends a<am2.p> {
    public c0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r3, Object r4) {
        am2.p r5 = (am2.p) r4;
        super.u(r3, r5);
        if (r5 == null) goto L7;
        r3.put("duration", String.valueOf(r5.a));
        return;
    }
}
