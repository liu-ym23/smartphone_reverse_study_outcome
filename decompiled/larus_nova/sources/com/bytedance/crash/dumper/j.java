package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements yh4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICommonParams f203159a;

    public j(ICommonParams r100) {
        this.f203159a = r100;
    }

    public final void a(File r100) {
        b(r100);     // Catch: Throwable -> L11
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "bytest.json");     // Catch: Throwable -> L11
        if (c.f203152f == true) goto L14;
        c.f203152f = true;     // Catch: Throwable -> L11
        String r102 = c.b().f203154b;
        if (r102 == null) goto L15;
        com.bytedance.crash.util.h.h(r101, r102, false);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void b(File r100) {
        List<String> r101 = this.f203159a.getPatchInfo();     // Catch: Throwable -> L20
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = new PolarisFileWrapper(r100, "patch_info.json").getAbsolutePath();     // Catch: Throwable -> L20
        dh4.a r103 = new dh4.b(r102);     // Catch: Throwable -> L8
    L9:
        r103.a('[');     // Catch: Throwable -> L20
        Iterator<String> r104 = r101.iterator();     // Catch: Throwable -> L20
        boolean r105 = false;
    L11:
        if (r104.hasNext() == false) goto L18;
        String r106 = r104.next();     // Catch: Throwable -> L20
        if (r105 == false) goto L15;
        r103.a(',');     // Catch: Throwable -> L20
    L15:
        if (r106 == null) goto L17;
        r103.d(r106);     // Catch: Throwable -> L20
    L17:
        r105 = true;
        goto L11
    L18:
        r103.a(']');     // Catch: Throwable -> L20
        r103.f();     // Catch: Throwable -> L20
        return;
    L8:
        r103 = new dh4.c(r102);     // Catch: Throwable -> L20
    }

    public final JSONObject c(CrashType r100) {
        if (r100 != CrashType.ENSURE) goto L20;
        JSONObject r101 = new JSONObject();
        ICommonParams r102 = this.f203159a;     // Catch: Throwable -> L22
        if (r102 == null) goto L18;
        List<String> r103 = r102.getPatchInfo();     // Catch: Throwable -> L22
        if (r103 == null) goto L18;
        if (r103.isEmpty() == true) goto L18;
        JSONArray r104 = new JSONArray();     // Catch: Throwable -> L22
        Iterator<String> r105 = r103.iterator();     // Catch: Throwable -> L22
    L15:
        if (r105.hasNext() == false) goto L17;
        r104.put(r105.next());     // Catch: Throwable -> L22
        goto L15
    L17:
        r101.put("patch_info", r104);     // Catch: Throwable -> L22
    L18:
        JSONObject r106 = new JSONObject();
        c.a(r106);
        com.bytedance.crash.util.j.h(r101, "filters", r106);
        return r101;
    L20:
        return null;
    }

    public final void d(JSONObject r100, JSONObject r101, File r102) {
        String r103 = com.bytedance.crash.util.g.f(new PolarisFileWrapper(r102, "patch_info.json"));     // Catch: Exception -> L6
        if (r103 == null) goto L8;
        com.bytedance.crash.util.j.h(r100, "patch_info", new JSONArray(r103));     // Catch: Exception -> L6
    L8:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102, "bytest.json");
        if (r104.isFile() == false) goto L28;
        if (r104.exists() == false) goto L28;
        JSONObject r105 = new JSONObject(com.bytedance.crash.util.h.c(r104));     // Catch: Exception -> L34
        JSONObject r106 = r105.optJSONObject("slardar_filter");     // Catch: Exception -> L34
        JSONObject r107 = r100.optJSONObject("filters");     // Catch: Exception -> L34
        if (r107 != null) goto L18;
        r107 = new JSONObject();     // Catch: Exception -> L34
        r100.put("filters", r107);     // Catch: Exception -> L34
    L18:
        if (r106 != null) goto L20;
    L26:
        r107.put("coredump_bytest", false);     // Catch: Exception -> L34
    L29:
        JSONObject r108 = r100.optJSONObject("header");
        if (r108 != null) goto L32;
        c.c(r105, r101);
        return;
    L32:
        c.c(r105, r108);
        return;
    L20:
        if (r106.length() == 0) goto L26;
        if ("true".equals(r106.optString("core_dump_switch")) == false) goto L25;
        r107.put("coredump_bytest", true);     // Catch: Exception -> L34
    L25:
        com.bytedance.crash.util.j.d(r107, r106);     // Catch: Exception -> L34
    L28:
        r105 = null;
    L6:
        e = move-exception;
        com.bytedance.crash.util.p.d(e);
        goto L8
    }
}
