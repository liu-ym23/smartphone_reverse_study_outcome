package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends a<am2.a> {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r2, Object r3) {
        am2.a r4 = (am2.a) r3;
        super.u(r2, r4);
        if (r4 == null) goto L7;
        r2.put("action_type", null);
        return;
    }
}
