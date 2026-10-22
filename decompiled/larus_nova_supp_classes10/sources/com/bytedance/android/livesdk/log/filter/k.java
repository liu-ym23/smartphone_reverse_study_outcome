package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k extends a<am2.h> {
    public k() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r2, Object r3) {
        am2.h r4 = (am2.h) r3;
        super.u(r2, r4);
        if (r4 == null) goto L7;
        r2.put("status", null);
        return;
    }
}
