package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends a<FollowLog> implements p {
    public h() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r3, Object r4) {
        FollowLog r5 = (FollowLog) r4;
        super.u(r3, r5);
        if (r5 == null) goto L31;
        int r0 = r5.d;
        if (r0 == (-1)) goto L9;
        r3.put("is_anchor", String.valueOf(r0));
    L9:
        if (TextUtils.isEmpty(r5.a) == true) goto L12;
        r3.put("request_page", r5.a);
    L12:
        if (TextUtils.isEmpty(r5.b) == true) goto L19;
        if (TextUtils.equals(r5.b, BDLocationException.ERROR_TIMEOUT) == true) goto L19;
        if (TextUtils.equals(r5.b, "-1") == true) goto L19;
        r3.put("to_user_id", r5.b);
    L19:
        if (TextUtils.isEmpty(null) == true) goto L22;
        r3.put(LocationMonitorConst.TYPE, null);
    L22:
        if (TextUtils.isEmpty(r5.c) == true) goto L24;
        r3.put("preview_source", r5.c);
    L24:
        String r1 = r5.f;
        if (r1 != null) goto L29;
        FollowLog.Scene r2 = r5.e;
        if (r2 == null) goto L29;
        r1 = r2.getFollowEntrancePage();
    L29:
        J(r3, r1, r5.g, r5.h);
        return;
    }

    public static void J(Map<String, String> r1, String r2, String r3, String r4) {
        p.a.getClass();
        if (r1 == null) goto L21;
        if (r2 == null) goto L10;
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r1.put("follow_entrance_page", r2);
    L10:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r1.put("follow_target", r3);
    L15:
        if (TextUtils.isEmpty(r4) == true) goto L20;
        if (r4 != null) goto L18;
        r4 = "";
    L18:
        r1.put("is_current_anchor", r4);
        return;
    L20:
        return;
    }
}
