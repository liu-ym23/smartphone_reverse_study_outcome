package com.vivo.push.util;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class f {
    public static boolean a(long r100, long r101) {
        t.d("ClientReportUtil", "report message: " + r100 + ", reportType: " + r101);
        com.vivo.push.b.y r102 = new com.vivo.push.b.y(r101);
        HashMap<String, String> r103 = new HashMap();
        r103.put(com.heytap.mcssdk.constant.b.f276353c, String.valueOf(r100));
        String r104 = com.vivo.push.restructure.a.a().e().a();
        if (TextUtils.isEmpty(r104) == true) goto L5;
        r103.put("remoteAppId", r104);
    L5:
        r102.a(r103);
        com.vivo.push.m.a().a(r102);
        return true;
    }

    public static boolean a(long r100, HashMap<String, String> r101) {
        if (r101 != null) goto L5;
        t.a("ClientReportUtil", "reportParams is null");
        return false;
    L5:
        com.vivo.push.b.y r102 = new com.vivo.push.b.y(r100);
        r102.a(r101);
        r102.e();
        com.vivo.push.m.a().a(r102);
        return true;
    }
}
