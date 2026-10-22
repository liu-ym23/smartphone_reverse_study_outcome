package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends a<am2.b> {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r6, Object r7) {
        am2.b r8 = (am2.b) r7;
        super.u(r6, r8);
        if (r8 == null) goto L13;
        r6.put("channel_id", String.valueOf(r8.c));
        long r0 = r8.d;
        if (r0 <= 0) goto L8;
        r6.put("invitee_id", String.valueOf(r0));
    L8:
        r6.put("invitee_list", r8.e);
        r6.put("connection_type", r8.a);
        r6.put("is_oncemore", String.valueOf(r8.b));
        r6.put("anchor_connect_status", String.valueOf(r8.f));
        if (TextUtils.isEmpty(r8.g) == true) goto L11;
        r6.put("request_id", r8.g);
    L11:
        r6.put("inviter_id", String.valueOf(r8.h));
        r6.put("linkmic_timestamp", String.valueOf(System.currentTimeMillis()));
        r6.put("right_user_id", String.valueOf(r8.d));
        r6.put("to_user_id", String.valueOf(r8.d));
        r6.put("is_rematch", String.valueOf(r8.i));
        r6.put("match_time", String.valueOf(r8.j));
        return;
    }
}
