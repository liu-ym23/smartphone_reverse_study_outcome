package qh4;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.h;
import com.bytedance.crash.util.p;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends oh4.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f532965h;

    /* JADX INFO: renamed from: qh4.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes3.dex */
    public static class C7329a extends oh4.b.AbstractC7056b {
        public static String l(String r100) {
            int r101 = r100.indexOf("==/lib/");
            int r102 = r100.indexOf(".so");
            if (r101 >= 0) goto L5;
            return "null";
        L5:
            if (r102 >= 0) goto L8;
            return "null";
        L8:
            return r100.substring(r101, r102).substring(7);
        }

        public C7329a(com.bytedance.crash.monitor.a r100, PolarisFileWrapper r101) {
            super(r100, r101);
        }

        @Override // oh4.b.AbstractC7056b
        public final void h(Map<String, String> r100, oh4.b.c r101) {
            super.h(r100, r101);
            if (r101.f523286b.isEmpty() == true) goto L5;
            String r102 = "true";
        L6:
            HashMap r103 = (HashMap) r100;
            r103.put("has_gwp_asan", r102);
            r103.put("gwp_asan_app", i.getContext().getPackageName());
            return;
        L5:
            r102 = "false";
            goto L6
        }

        @Override // oh4.b.AbstractC7056b
        public final boolean i(File r110, oh4.b.c r111) {
            String r100 = "Invalid Free";
            PolarisFileWrapper r101 = new PolarisFileWrapper(r110, "tombstone.txt");
            if (r101.exists() == true) goto L149;
            return false;
        L149:
            JSONArray r102 = h.f(r101.getAbsolutePath());     // Catch: Throwable -> L144 IOException -> L146
            if (r102 != null) goto L9;
            p.c("parseReport  native stack is null");     // Catch: Throwable -> L144 IOException -> L146
            return false;
        L9:
            int r103 = oh4.b.AbstractC7056b.b(r102, 0, "pid:");     // Catch: Throwable -> L144 IOException -> L146
            if (r103 >= 0) goto L13;
            p.c("parseReport  pid index err");     // Catch: Throwable -> L144 IOException -> L146
            return false;
        L13:
            String[] r112 = r102.optString(r103, null).trim().split("\\s");     // Catch: Throwable -> L144 IOException -> L146
            int r113 = 0;
        L15:
            if (r113 >= r112.length) goto L26;
            String r114 = r112[r113];     // Catch: Throwable -> L144 IOException -> L146
            if ("pid:".equals(r114) == false) goto L20;
            String r115 = r112[r113 + 1];     // Catch: Throwable -> L144 IOException -> L146
            r111.f523289e = Long.decode(r115.substring(0, r115.length() - 1)).intValue();     // Catch: Throwable -> L144 IOException -> L146
        L25:
            r113 = r113 + 1;     // Catch: Throwable -> L144 IOException -> L146
            goto L15
        L20:
            if ("tid:".equals(r114) == false) goto L23;
            String r116 = r112[r113 + 1];     // Catch: Throwable -> L144 IOException -> L146
            r111.f523290f = Long.decode(r116.substring(0, r116.length() - 1)).intValue();     // Catch: Throwable -> L144 IOException -> L146
            goto L25
        L23:
            if ("name:".equals(r114) == false) goto L25;
            String r117 = r112[r113 + 1];     // Catch: Throwable -> L144 IOException -> L146
            r111.f523287c = r117.substring(0, r117.length() - 1);     // Catch: Throwable -> L144 IOException -> L146
            goto L25
        L26:
            String r104 = r112[r112.length - 2];     // Catch: Throwable -> L144 IOException -> L146
            StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L144 IOException -> L146
            int r106 = oh4.b.AbstractC7056b.b(r102, r103 + 1, "Signal ");     // Catch: Throwable -> L144 IOException -> L146
            if (r106 >= 0) goto L30;
            p.c("parseReport  signal index err");     // Catch: Throwable -> L144 IOException -> L146
            return false;
        L30:
            r105.append(r102.optString(r106, null));     // Catch: Throwable -> L144 IOException -> L146
            r105.append('\n');     // Catch: Throwable -> L144 IOException -> L146
            int r107 = oh4.b.AbstractC7056b.b(r102, r106 + 1, "GWP-ASan message:");     // Catch: Throwable -> L144 IOException -> L146
            if (r107 >= 0) goto L34;
            p.c("parseReport abort msg index err");     // Catch: Throwable -> L144 IOException -> L146
            return false;
        L34:
            String r108 = r102.optString(r107, null).replace("GWP-ASan message:", "abort message:");     // Catch: Throwable -> L144 IOException -> L146
            r105.append(r108);     // Catch: Throwable -> L144 IOException -> L146
            r105.append('\n');     // Catch: Throwable -> L144 IOException -> L146
            if (r108.contains("Use After Free") == false) goto L39;
            r100 = "Use After Free";
        L51:
            int r109 = oh4.b.AbstractC7056b.b(r102, r107 + 1, "backtrace:");     // Catch: Throwable -> L144 IOException -> L146
            if (r109 >= 0) goto L55;
            p.c("parseReport backtrace index err");     // Catch: Throwable -> L144 IOException -> L146
            return false;
        L55:
            String r118 = "    #00";
            int r119 = r109 + 1;
            String r120 = "None";
            String r121 = "None";
        L59:
            if (r119 >= r102.length()) goto L85;
            String r122 = r102.optString(r119, null);     // Catch: Throwable -> L144 IOException -> L146
            if (r122.startsWith("    #") == false) goto L85;
            r105.append(r122.trim());     // Catch: Throwable -> L144 IOException -> L146
            r105.append('\n');     // Catch: Throwable -> L144 IOException -> L146
            if ("Double Free".equals(r100) == false) goto L67;
            r118 = "    #03";
        L67:
            if (r122.endsWith("libc.so") == true) goto L78;
            if (r122.endsWith("libc++_shared.so") == true) goto L78;
            if (r122.startsWith(r118) == false) goto L84;
            String[] r123 = l(r122).trim().split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L144 IOException -> L146
            if (r123 == null) goto L84;
            if (r123.length <= 1) goto L84;
            String r124 = r123[1];     // Catch: Throwable -> L144 IOException -> L146
            r121 = r124.substring(r124.lastIndexOf(47) + 1);     // Catch: Throwable -> L144 IOException -> L146
        L84:
            r119 = r119 + 1;     // Catch: Throwable -> L144 IOException -> L146
        L78:
            if (r122.startsWith("    #01") == false) goto L84;
            String[] r125 = l(r122).trim().split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L144 IOException -> L146
            if (r125 == null) goto L84;
            if (r125.length <= 1) goto L84;
            String r126 = r125[1];     // Catch: Throwable -> L144 IOException -> L146
            r121 = r126.substring(r126.lastIndexOf(47) + 1);     // Catch: Throwable -> L144 IOException -> L146
        L85:
            r111.f523286b = r105.toString();     // Catch: Throwable -> L144 IOException -> L146
            int r127 = oh4.b.AbstractC7056b.b(r102, r119, "deallocated by thread") + 1;     // Catch: Throwable -> L144 IOException -> L146
            String r128 = "None";
        L88:
            if (r127 >= r102.length()) goto L108;
            String r129 = r102.optString(r127, null);     // Catch: Throwable -> L144 IOException -> L146
            if (r129.startsWith("    #01") == true) goto L95;
            if (r129.startsWith("    #02") == true) goto L95;
        L107:
            r127 = r127 + 1;     // Catch: Throwable -> L144 IOException -> L146
        L95:
            if (r129.endsWith("libnpth_xasan.so") == true) goto L107;
            if (r129.endsWith("libc++_shared.so") == true) goto L107;
            String[] r130 = l(r129).trim().split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L144 IOException -> L146
            if (r130 == null) goto L107;
            if (r130.length <= 1) goto L107;
            String r131 = r130[1];     // Catch: Throwable -> L144 IOException -> L146
            r128 = r131.substring(r131.lastIndexOf(47) + 1);     // Catch: Throwable -> L144 IOException -> L146
            if (r128.length() < 1) goto L107;
            if (r128.isEmpty() == true) goto L107;
        L108:
            int r132 = oh4.b.AbstractC7056b.b(r102, r127, "allocated by thread") + 1;     // Catch: Throwable -> L144 IOException -> L146
        L110:
            if (r132 >= r102.length()) goto L129;
            String r133 = r102.optString(r132, null);     // Catch: Throwable -> L144 IOException -> L146
            if (r133.startsWith("    #01") == true) goto L116;
            if (r133.startsWith("    #02") == true) goto L116;
        L128:
            r132 = r132 + 1;     // Catch: Throwable -> L144 IOException -> L146
        L116:
            if (r133.endsWith("libnpth_xasan.so") == true) goto L128;
            if (r133.endsWith("libc++_shared.so") == true) goto L128;
            String[] r134 = l(r133).trim().split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L144 IOException -> L146
            if (r134 == null) goto L128;
            if (r134.length <= 1) goto L128;
            String r135 = r134[1];     // Catch: Throwable -> L144 IOException -> L146
            r120 = r135.substring(r135.lastIndexOf(47) + 1);     // Catch: Throwable -> L144 IOException -> L146
            if (r120.length() < 1) goto L128;
            if (r120.isEmpty() == true) goto L128;
        L129:
            int r136 = oh4.b.AbstractC7056b.b(r102, r132, "build id:");     // Catch: Throwable -> L144 IOException -> L146
            if (r136 <= 0) goto L141;
            int r137 = r136 + 1;     // Catch: Throwable -> L144 IOException -> L146
        L133:
            if (r137 >= r102.length()) goto L141;
            String r138 = r102.optString(r137, null);     // Catch: Throwable -> L144 IOException -> L146
            if (r138.startsWith("    /") == false) goto L140;
            String[] r139 = r138.trim().split("\\s");     // Catch: Throwable -> L144 IOException -> L146
            if (r139.length < 3) goto L140;
            String r140 = r139[0];     // Catch: Throwable -> L144 IOException -> L146
            r111.f523291g.put(new JSONObject().put("lib_name", r140.substring(r140.lastIndexOf(47) + 1)).put("lib_uuid", oh4.b.AbstractC7056b.a(r139[r139.length - 1].substring(0, r139[r139.length - 1].length() - 1))));     // Catch: Throwable -> L144 IOException -> L146
        L140:
            r137 = r137 + 1;     // Catch: Throwable -> L144 IOException -> L146
        L141:
            ((HashMap) r111.f523292h).put("gwp_asan_type", r100);     // Catch: Throwable -> L144 IOException -> L146
            ((HashMap) r111.f523292h).put("gwp_asan_fatal_lib", r121);     // Catch: Throwable -> L144 IOException -> L146
            ((HashMap) r111.f523292h).put("gwp_asan_deallocated_lib", r128);     // Catch: Throwable -> L144 IOException -> L146
            ((HashMap) r111.f523292h).put("gwp_asan_allocated_lib", r120);     // Catch: Throwable -> L144 IOException -> L146
            return true;
        L39:
            if (r108.contains("Double Free") == false) goto L42;
            r100 = "Double Free";
            goto L51
        L42:
            if (r108.contains("Buffer Overflow") == false) goto L45;
            r100 = "Buffer Overflow";
            goto L51
        L45:
            if (r108.contains("Buffer Underflow") == false) goto L48;
            r100 = "Buffer Underflow";
            goto L51
        L48:
            if (r108.contains("Invalid Free") == true) goto L51;
            r100 = "Unknown";
        L144:
            e = move-exception;
            p.c("parseReport :" + e);
            return false;
        }
    }

    @Override // oh4.b
    public final void a() {
    }

    public static a e() {
        if (f532965h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f532965h != null) goto L9;
        f532965h = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f532965h;
    }

    @Override // oh4.b
    public final boolean b() {
        return NativeBridge.G();
    }

    public a() {
    }
}
