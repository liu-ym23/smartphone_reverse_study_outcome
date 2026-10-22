package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v0 extends a<am2.e0> {
    public v0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r2, Object r3) {
        am2.e0 r4 = (am2.e0) r3;
        super.u(r2, r4);
        if (r4 == null) goto L7;
        r2.put("gift_type", null);
        r2.put("gift_id", null);
        r2.put("money", String.valueOf(0));
        r2.put("combo_cnt", "1");
        r2.put("group_cnt", "1");
        return;
    }
}
