package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r0 extends a<am2.d0> {
    public r0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r2, Object r3) {
        am2.d0 r4 = (am2.d0) r3;
        super.u(r2, r4);
        if (r4 == null) goto L7;
        r2.put("prompt", null);
        return;
    }
}
