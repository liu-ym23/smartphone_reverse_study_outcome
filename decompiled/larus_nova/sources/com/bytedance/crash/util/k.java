package com.bytedance.crash.util;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crash.jni.NativeBridge;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f203412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, String> f203413b = null;

    public k() {
    }

    static {
        f203413b = new HashMap();
    }

    public static k a() {
        if (f203412a != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f203412a != null) goto L9;
        f203412a = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f203412a;
    }

    public static JSONArray b(String r110) {
        JSONArray r100 = new JSONArray();
        HashSet r101 = new HashSet();
        String[] r102 = r110.split("\n");
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L54;
        String[] r105 = r102[r104].split("\\s+");
        String[] r106 = {"", ""};
        if (r105.length < 4) goto L28;
        int r107 = r105.length;
        int r111 = 0;
        String r112 = null;
    L8:
        if (r111 >= r107) goto L16;
        String r113 = r105[r111];
        if (r113.startsWith(HTTP.URL_DEFAULT) == false) goto L14;
        if (r113.endsWith(".so") == false) goto L14;
        r112 = r113;
    L14:
        r111 = r111 + 1;
        goto L8
    L16:
        if (TextUtils.isEmpty(r112) == true) goto L28;
        if (r112.endsWith(".so") == false) goto L28;
        if (r112.contains("/system/lib") == true) goto L28;
        int r108 = r112.lastIndexOf(47);
        if (r108 == (-1)) goto L28;
        int r109 = r108 + 1;
        String r114 = r112.substring(r109);
        if (r114.contains(".apk!") == false) goto L27;
        r114 = r114.substring(r114.indexOf(".apk!") + 5);
    L27:
        String r115 = r112.substring(0, r109) + r114;
        r106[0] = r114;
        r106[1] = r115;
    L29:
        if (r106 == null) goto L53;
        k r116 = a();
        String r117 = r106[1];
        r116.getClass();
        String r118 = f203413b.get(r117);
        if (TextUtils.isEmpty(r118) == false) goto L48;
        a().getClass();
        String r119 = NativeBridge.a(r117);     // Catch: Throwable -> L35
    L36:
        StringBuilder r120 = new StringBuilder();
        if (r119 != null) goto L58;
        r118 = r120.toString();
    L46:
        f203413b.put(r117, r118);
        goto L48
    L58:
        if (r119.length() >= 16) goto L42;
        r120.append(r119);     // Catch: Throwable -> L55
        goto L45
    L42:
        r120.append(r119.charAt(6));     // Catch: Throwable -> L55
        r120.append(r119.charAt(7));     // Catch: Throwable -> L55
        r120.append(r119.charAt(4));     // Catch: Throwable -> L55
        r120.append(r119.charAt(5));     // Catch: Throwable -> L55
        r120.append(r119.charAt(2));     // Catch: Throwable -> L55
        r120.append(r119.charAt(3));     // Catch: Throwable -> L55
        r120.append(r119.charAt(0));     // Catch: Throwable -> L55
        r120.append(r119.charAt(1));     // Catch: Throwable -> L55
        r120.append(r119.charAt(10));     // Catch: Throwable -> L55
        r120.append(r119.charAt(11));     // Catch: Throwable -> L55
        r120.append(r119.charAt(8));     // Catch: Throwable -> L55
        r120.append(r119.charAt(9));     // Catch: Throwable -> L55
        r120.append(r119.charAt(14));     // Catch: Throwable -> L55
        r120.append(r119.charAt(15));     // Catch: Throwable -> L55
        r120.append(r119.charAt(12));     // Catch: Throwable -> L55
        r120.append(r119.charAt(13));     // Catch: Throwable -> L55
        if (r119.length() < 32) goto L45;
        r120.append(r119, 16, 32);     // Catch: Throwable -> L55
        r120.append('0');     // Catch: Throwable -> L55
    L45:
        r118 = r120.toString().toUpperCase();
    L35:
        r119 = null;
    L48:
        if (TextUtils.isEmpty(r118) == true) goto L53;
        if (r101.contains(r106[0]) == true) goto L53;
        r101.add(r106[0]);
        JSONObject r121 = new JSONObject();
        j.h(r121, "lib_name", r106[0]);
        j.h(r121, "lib_uuid", r118);
        r100.put(r121);
    L53:
        r104 = r104 + 1;
    L28:
        r106 = null;
        goto L29
    L54:
        return r100;
    }
}
