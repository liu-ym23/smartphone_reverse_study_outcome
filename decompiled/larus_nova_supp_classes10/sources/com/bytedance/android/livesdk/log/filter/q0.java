package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q0 extends a<am2.c0> {
    public q0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r3, Object r4) {
        am2.c0 r5 = (am2.c0) r4;
        super.u(r3, r5);
        if (r5 == null) goto L11;
        am2.l r6 = r5.a;
        if (r6 == null) goto L12;
        if (r3 == null) goto L8;
        String r0 = (String) r3.put("pk_id", String.valueOf(r6.e));
    L8:
        if (r3 == null) goto L13;
        String r7 = (String) r3.put("connection_type", r6.d);
        return;
    L13:
        return;
    L12:
        return;
    }
}
