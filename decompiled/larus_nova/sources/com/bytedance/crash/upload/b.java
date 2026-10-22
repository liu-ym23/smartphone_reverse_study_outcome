package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.crash.util.p;
import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static void a(eh4.d r110) {
        JSONObject r100 = r110.f472653a;
        String r111 = r100.optString(FrescoMonitorConst.LOG_TYPE);
        if (TextUtils.isEmpty(r111) == false) goto L5;
        r111 = null;
    L5:
        String r101 = r100.optString("stack");
        String r102 = r100.optString("event_type");
        String r103 = r100.optString("java_data");
        String r104 = r100.optString("stack");
        if (r102.equals(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION) == false) goto L16;
        fh4.f r105 = com.bytedance.crash.monitor.j.c();
        r105.getClass();
        String r106 = r100.optString("message");
        if (TextUtils.isEmpty(r111) == false) goto L10;
        String r107 = "core_exception_monitor";
    L12:
        if (r105.d(r107, r106) == false) goto L14;
        p.e("reportJavaEnsure：isDrop:" + r107 + " " + r106);
        return;
    L14:
        r105.f(new fh4.g(r107, r101, null, r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION));
        return;
    L10:
        r107 = r111;
        goto L12
    L16:
        if (r102.equals("native_exception") == false) goto L28;
        fh4.f r108 = com.bytedance.crash.monitor.j.c();
        r108.getClass();
        if (TextUtils.isEmpty(r111) == false) goto L20;
        String r109 = "core_exception_monitor";
    L21:
        String r112 = r100.optString("message");
        if (r108.d(r109, r112) == false) goto L24;
        p.e("reportNativeEnsure：isDrop:" + r109 + " " + r112);
        return;
    L24:
        r108.f(new fh4.g(r109, r103, r104, r100, "native_exception"));
        return;
    L20:
        r109 = r111;
        goto L21
    }
}
