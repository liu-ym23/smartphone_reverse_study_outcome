package com.bytedance.crash.dumper;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static void a(File r100) {
        com.bytedance.crash.monitor.a r101 = com.bytedance.crash.monitor.j.f203315a;
        if (r101 != null) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        Map<String, Object> r103 = r101.c();
        if (r103 == null) goto L23;
        Iterator<String> r104 = r103.keySet().iterator();     // Catch: Exception -> L27
    L9:
        if (r104.hasNext() == false) goto L14;
        String r105 = r104.next();     // Catch: Exception -> L27
        if (r103.get(r105) == null) goto L9;
        r102.put(r105, r103.get(r105));     // Catch: Exception -> L27
        goto L9
    L14:
        if (r103.containsKey("version_name") == false) goto L17;
        r102.put("crash_version_name", r103.get("version_name"));     // Catch: Exception -> L27
    L17:
        if (r103.containsKey("update_version_code") == false) goto L20;
        r102.put("crash_update_version_code", r103.get("update_version_code"));     // Catch: Exception -> L27
    L20:
        if (r103.containsKey("version_code") == false) goto L23;
        r102.put("crash_version_code", r103.get("version_code"));     // Catch: Exception -> L27
    L23:
        if (r102.length() > 0) goto L29;
        return;
    L29:
        com.bytedance.crash.util.h.h(new PolarisFileWrapper(r100, "common_params.json"), r102.toString(), false);     // Catch: Exception -> L28
        return;
    }
}
