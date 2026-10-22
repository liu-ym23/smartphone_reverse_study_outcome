package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends a<am2.c> {
    public d() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r2, Object r3) {
        am2.c r4 = (am2.c) r3;
        super.u(r2, r4);
        if (r4 == null) goto L12;
        String r5 = r4.a;
        if (r5 == null) goto L10;
        if (r2 == null) goto L11;
        String r6 = (String) r2.put("click_user_position", r5);
        return;
    L11:
        return;
    L10:
        return;
    }
}
