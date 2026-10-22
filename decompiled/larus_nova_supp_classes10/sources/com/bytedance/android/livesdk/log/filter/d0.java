package com.bytedance.android.livesdk.log.filter;

import com.bytedance.common.utility.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d0 extends a<am2.q> {
    public d0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r3, Object r4) {
        am2.q r5 = (am2.q) r4;
        super.u(r3, r5);
        if (r5 != null) goto L6;
        return;
    L6:
        if (StringUtils.isEmpty(r5.a) == true) goto L10;
        if (r3 == null) goto L10;
        String r0 = (String) r3.put("order", r5.a);
    L10:
        if (StringUtils.isEmpty(r5.c) == true) goto L14;
        if (r3 == null) goto L14;
        String r1 = (String) r3.put("first_request_page", r5.c);
    L14:
        if (StringUtils.isEmpty(r5.b) == true) goto L17;
        if (r3 == null) goto L17;
        String r2 = (String) r3.put("is_auto_play", r5.b);
    L17:
        int r6 = am2.q.g;
        am2.q.a.a(r5, r3);
    }
}
