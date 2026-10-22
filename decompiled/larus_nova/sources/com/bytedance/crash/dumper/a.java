package com.bytedance.crash.dumper;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static void a(File r100) {
        com.bytedance.crash.monitor.a r101 = com.bytedance.crash.monitor.j.f203315a;
        if (r101 != null) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        if (r101.i() == 0) goto L13;
        if (TextUtils.isEmpty(r101.j()) == true) goto L13;
        r102.put("version_code", r101.i());     // Catch: Throwable -> L11
        r102.put("update_version_code", r101.f());     // Catch: Throwable -> L11
        r102.put("version_name", r101.j());     // Catch: Throwable -> L11
        r102.put("app_version", r101.j());     // Catch: Throwable -> L11
        r102.put("manifest_version_code", r101.m());     // Catch: Throwable -> L11
    L13:
        if (r102.length() > 0) goto L18;
        return;
    L18:
        com.bytedance.crash.util.h.h(new PolarisFileWrapper(r100, "version.json"), r102.toString(), false);     // Catch: Exception -> L17
        return;
    }
}
