package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j extends a<am2.g> {
    public j() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r3, Object r4) {
        am2.g r5 = (am2.g) r4;
        super.u(r3, r5);
        if (r5 == null) goto L7;
        r3.put("gesture_id", String.valueOf(0));
        return;
    }
}
