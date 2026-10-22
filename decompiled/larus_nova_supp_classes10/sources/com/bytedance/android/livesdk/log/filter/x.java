package com.bytedance.android.livesdk.log.filter;

import com.bytedance.common.utility.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x extends a<am2.m> {
    public x() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r6, Object r7) {
        am2.m r8 = (am2.m) r7;
        super.u(r6, r8);
        if (r8 == null) goto L43;
        long r0 = r8.b;
        if (r0 <= 0) goto L8;
        r6.put("invitee_id", String.valueOf(r0));
    L8:
        long r1 = r8.a;
        if (r1 <= 0) goto L12;
        r6.put("inviter_id", String.valueOf(r1));
    L12:
        if (StringUtils.isEmpty(null) == true) goto L15;
        r6.put("match_type", null);
    L15:
        if (StringUtils.isEmpty(r8.c) == true) goto L18;
        r6.put("end_type", r8.c);
    L18:
        if (StringUtils.isEmpty(r8.d) == true) goto L21;
        r6.put("connection_time", r8.d);
    L21:
        if (StringUtils.isEmpty(r8.e) == true) goto L24;
        r6.put("invitee_list", r8.e);
    L24:
        if (StringUtils.isEmpty(r8.f) == true) goto L26;
        r6.put("is_rematch", r8.f);
    L26:
        int r2 = r8.i;
        if (r2 == 0) goto L30;
        r6.put("pk_time", String.valueOf(r2));
    L30:
        if (StringUtils.isEmpty(r8.getType()) == true) goto L40;
        r6.put("connection_type", r8.getType());
        if (r8.getType().equals("pk") == true) goto L34;
        return;
    L34:
        if (StringUtils.isEmpty(r8.h) == true) goto L36;
        r6.put("title", r8.h);
    L36:
        int r9 = r8.i;
        if (r9 <= 0) goto L42;
        r6.put("pk_time", String.valueOf(r9));
        return;
    L42:
        return;
    L40:
        return;
    }
}
