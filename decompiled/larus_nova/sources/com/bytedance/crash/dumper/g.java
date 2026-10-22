package com.bytedance.crash.dumper;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crash.i0;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.m0;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class g {
    public static void a(File r100) {
        com.bytedance.crash.monitor.a r101 = com.bytedance.crash.monitor.j.f203315a;
        if (r101 != null) goto L6;
        return;
    L6:
        if (new PolarisFileWrapper(r100.getAbsolutePath() + "/tags.txt").exists() == false) goto L8;
        return;
    L8:
        m0 r102 = r101.f203291c;
        if (r102.f203254q == false) goto L12;
        NativeBridge.n(new PolarisFileWrapper(r100.getAbsolutePath() + "/tags.txt").getAbsolutePath());
        return;
    L12:
        Map<String, String> r103 = i0.f203227a;
        if (NativeBridge.H() == true) goto L15;
    L17:
        Map r104 = r102.f203238a;
    L19:
        if (r104.size() == 0) goto L33;
        dh4.f r105 = new dh4.f(r100.getAbsolutePath() + "/filters.json");
        r105.j();
        r105.h("filters");
        r105.j();
        Iterator r106 = r104.entrySet().iterator();
        boolean r107 = true;
    L22:
        if (r106.hasNext() == false) goto L28;
        Map.Entry r108 = (Map.Entry) r106.next();
        if (r107 == false) goto L26;
        r107 = false;
    L27:
        r105.h((String) r108.getKey());
        r105.l((String) r108.getValue());
        goto L22
    L26:
        r105.i();
        goto L27
    L28:
        r105.k();
        r105.k();
        r105.g();
        return;
    L33:
        return;
    L15:
        if (r102.f203254q == false) goto L17;
        r104 = NativeBridge.z();
        goto L19
    }

    public static void b(File r100) {
        com.bytedance.crash.monitor.a r101 = com.bytedance.crash.monitor.j.f203315a;
        if (r101 != null) goto L5;
        return;
    L5:
        m0 r102 = r101.f203291c;
        r102.getClass();
        HashMap r103 = new HashMap();
        Iterator r104 = ((ConcurrentHashMap) r102.f203251n).keySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L22;
        String r105 = (String) r104.next();
        JSONArray r106 = new JSONArray();
        LinkedList r107 = (LinkedList) ((ConcurrentHashMap) r102.f203251n).get(r105);
        if (r107 == null) goto L20;
        monitor-enter(r107);
        Iterator r108 = r107.iterator();     // Catch: Throwable -> L17
    L13:
        if (r108.hasNext() == false) goto L15;
        r106.put((String) r108.next());     // Catch: Throwable -> L17
        goto L13
    L15:
        monitor-exit(r107);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L20:
        r103.put(r105, r106);
        goto L7
    L22:
        if (r103.isEmpty() == false) goto L31;
        return;
    L31:
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L30
        Iterator r110 = r103.entrySet().iterator();     // Catch: Throwable -> L30
    L26:
        if (r110.hasNext() == false) goto L28;
        Map.Entry r111 = (Map.Entry) r110.next();     // Catch: Throwable -> L30
        r109.put((String) r111.getKey(), r111.getValue());     // Catch: Throwable -> L30
        goto L26
    L28:
        com.bytedance.crash.util.h.i(new PolarisFileWrapper(r100.getAbsolutePath() + HTTP.URL_DEFAULT + "custom_crash_reason" + InvRouter.FLOW_SUFFIX), r109);     // Catch: Throwable -> L30
        return;
    }
}
