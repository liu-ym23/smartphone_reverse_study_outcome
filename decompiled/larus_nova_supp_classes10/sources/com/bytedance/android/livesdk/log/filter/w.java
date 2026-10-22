package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w extends a<am2.l> {
    public w() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r7, Object r8) {
        am2.l r9 = (am2.l) r8;
        if (r9 == null) goto L27;
        long r0 = r9.a;
        if (r0 <= 0) goto L8;
        r7.put("channel_id", String.valueOf(r0));
    L8:
        String r1 = r9.b;
        if (r1 != null) goto L11;
    L13:
        r7.put("is_oncemore", String.valueOf(r9.g));
        int r2 = r9.c;
        if (r2 <= 0) goto L21;
        r7.put("pk_time", String.valueOf(r2));
        r7.put("connection_type", r9.d);
        r7.put("match_type", null);
        long r4 = r9.e;
        if (r4 <= 0) goto L19;
        r7.put("pk_id", String.valueOf(r4));
    L19:
        if (StringUtils.isEmpty(r9.f) == false) goto L22;
        r7.put("title", r9.f);
    L22:
        r7.put("request_page", null);
        r7.put("is_reinvite", String.valueOf(r9.h));
        if (TextUtils.isEmpty(r9.i) == true) goto L25;
        r7.put("request_id", r9.i);
    L25:
        r7.put("linkmic_timestamp", String.valueOf(System.currentTimeMillis()));
        return;
    L21:
        r7.put("connection_type", r9.d);
        goto L22
    L11:
        if (r1.isEmpty() == true) goto L13;
        r7.put("right_user_id", r9.b);
        goto L13
    }
}
