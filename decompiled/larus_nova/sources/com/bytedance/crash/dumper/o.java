package com.bytedance.crash.dumper;

import com.bytedance.crash.m0;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static void a(File r100) {
        com.bytedance.crash.monitor.a r101 = com.bytedance.crash.monitor.j.f203315a;
        if (r101 != null) goto L5;
        return;
    L5:
        dh4.f r102 = new dh4.f(r100.getAbsolutePath() + "/sdk_info.json");
        r102.j();
        ConcurrentHashMap<Integer, String> r103 = r101.f203291c.f203239b;
        boolean r104 = true;
        if (r103 != null) goto L8;
    L18:
        boolean r105 = true;
    L19:
        m0 r106 = r101.f203291c;
        r106.getClass();
        JSONObject r107 = new JSONObject(r106.f203240c);
        if (r107.length() <= 0) goto L35;
        if (r105 == true) goto L23;
        r102.i();
    L23:
        r102.h("inner_sdk");
        r102.j();
        Iterator<String> r108 = r107.keys();
    L25:
        if (r108.hasNext() == false) goto L34;
        String r109 = r108.next();
        String r110 = JSONObjectProtectorUtils.getString(r107, r109);     // Catch: JSONException -> L33
        if (r104 == false) goto L30;
        r104 = false;
    L31:
        r102.h(r109);     // Catch: JSONException -> L33
        r102.l(r110);     // Catch: JSONException -> L33
        goto L25
    L30:
        r102.i();     // Catch: JSONException -> L33
        goto L31
    L34:
        r102.k();
    L35:
        r102.k();
        r102.g();
        return;
    L8:
        if (r103.size() <= 0) goto L18;
        r102.h("sdk_info");
        r102.j();
        Iterator<Integer> r111 = r103.keySet().iterator();
        r105 = true;
    L11:
        if (r111.hasNext() == false) goto L17;
        Integer r112 = r111.next();
        if (r105 == false) goto L15;
        r105 = false;
    L16:
        r102.h(String.valueOf(r112));
        r102.l(String.valueOf(r103.get(r112)));
        goto L11
    L15:
        r102.i();
        goto L16
    L17:
        r102.k();
        goto L19
    }

    public static void b(JSONObject r100) {
        com.bytedance.crash.monitor.a r101 = com.bytedance.crash.monitor.j.f203315a;
        if (r101 != null) goto L5;
        return;
    L5:
        ConcurrentHashMap<Integer, String> r102 = r101.f203291c.f203239b;
        JSONObject r103 = new JSONObject();
        if (r102 != null) goto L24;
    L14:
        m0 r104 = r101.f203291c;
        r104.getClass();
        JSONObject r105 = new JSONObject(r104.f203240c);
        if (com.bytedance.crash.util.j.g(r103) == true) goto L19;
        r100.put("sdk_info", r103);     // Catch: Throwable -> L23
    L19:
        if (com.bytedance.crash.util.j.g(r105) == true) goto L30;
        r100.put("inner_sdk", r105);     // Catch: Throwable -> L23
        return;
    L30:
        return;
    L31:
        return;
    L24:
        if (r102.size() <= 0) goto L14;
        Iterator<Integer> r106 = r102.keySet().iterator();     // Catch: Throwable -> L22
    L11:
        if (r106.hasNext() == false) goto L14;
        Integer r107 = r106.next();     // Catch: Throwable -> L22
        r103.put(String.valueOf(r107), r102.get(r107));     // Catch: Throwable -> L22
        goto L11
    }
}
