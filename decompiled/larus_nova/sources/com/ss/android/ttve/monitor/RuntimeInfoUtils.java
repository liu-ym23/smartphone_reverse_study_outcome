package com.ss.android.ttve.monitor;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ttvecamera.BuildConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class RuntimeInfoUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f449915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f449916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f449917c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f449918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f449919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f449920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f449921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f449922h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f449923i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f449924j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f449925k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f449926l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f449927m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f449928n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f449929o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f449930p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f449931q;

    public RuntimeInfoUtils() {
    }

    static {
        f449917c = new AnonymousClass1();
    }

    public static Map<String, String> b() {
        HashMap r100 = new HashMap();
        r100.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, f449918d);
        r100.put("cpu", f449919e);
        r100.put("cpu_freq", f449920f);
        r100.put("cpu_core", f449921g);
        r100.put("memory", f449922h);
        r100.put("storage", f449923i);
        r100.put("external_storage", f449924j);
        r100.put("screen_width", f449925k);
        r100.put("screen_height", f449926l);
        r100.put("os_sdk_int", f449927m);
        r100.put("appid", f449928n);
        r100.put("abi", f449929o);
        r100.put("brand", f449930p);
        if (f449916b == true) goto L5;
        f449931q = BuildConfig.AAR_VERSION_NAME;
        f449916b = true;
    L5:
        r100.put("ve_version", f449931q);
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.FileReader] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.FileReader] */
    /* JADX WARN: Type inference failed for: r6v13, types: [com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper, java.io.FileReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static void a(Context r110) {
        f449918d = Build.MODEL;
        BufferedReader r100 = null;
        ?? r101 = 0;
        r101 = 0;
        InputStream r102 = null;
        r100 = null;
        if (TextUtils.isEmpty(e.f449934a) == true) goto L171;
        String r103 = e.f449934a;
    L33:
        f449919e = r103;
        InputStream r104 = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();     // Catch: Throwable -> L48 IOException -> L50
    L156:
        byte[] r105 = new byte[24];     // Catch: IOException -> L46 Throwable -> L134
        String r106 = "";
    L39:
        if (r104.read(r105) == (-1)) goto L158;
        r106 = r106 + new String(r105);     // Catch: IOException -> L46 Throwable -> L134
        goto L39
    L158:
        r104.close();     // Catch: IOException -> L44
        ?? r107 = r106;
    L60:
        f449920f = r107.trim();
        int r108 = new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(new d()).length;     // Catch: Exception -> L63
    L65:
        f449921g = String.valueOf(r108);
        int r109 = 0;
        r107 = new PolarisFileReaderWrapper("/proc/meminfo");     // Catch: Throwable -> L87 IOException -> L89
    L178:
        BufferedReader r111 = new BufferedReader(r107, 8192);     // Catch: Throwable -> L83 IOException -> L85
        String[] r112 = r111.readLine().split("\\s+");     // Catch: IOException -> L81 Throwable -> L121
        int r113 = r112.length;     // Catch: IOException -> L81 Throwable -> L121
        int r114 = 0;
    L69:
        if (r114 >= r113) goto L71;
        String r115 = r112[r114];     // Catch: IOException -> L81 Throwable -> L121
        r114 = r114 + 1;     // Catch: IOException -> L81 Throwable -> L121
        goto L69
    L71:
        long r116 = Integer.valueOf(r112[1]).intValue();     // Catch: IOException -> L81 Throwable -> L121
        r111.close();     // Catch: IOException -> L75
    L147:
        r107.close();     // Catch: IOException -> L79
    L103:
        f449922h = String.valueOf(r116 / 1024);
        f449923i = "0";
        f449924j = "0";
        f449927m = String.valueOf(Build.VERSION.SDK_INT);
        if (r110 != null) goto L106;
        int r117 = 0;
    L107:
        f449925k = String.valueOf(r117);
        if (r110 != null) goto L110;
        int r118 = 0;
    L111:
        f449926l = String.valueOf(r118);
        f449928n = r110.getPackageName();
        StringBuilder r119 = new StringBuilder();
        String[] r120 = Build.SUPPORTED_ABIS;
        if (r120 != null) goto L114;
    L119:
        f449929o = r119.toString();
        f449930p = Build.BRAND;
        return;
    L114:
        if (r109 >= r120.length) goto L119;
        r119.append(r120[r109]);
        if (r109 == (r120.length - 1)) goto L118;
        r119.append(",");
    L118:
        r109 = r109 + 1;
        goto L114
    L110:
        Display r121 = ((WindowManager) r110.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        Point r122 = new Point();
        r121.getRealSize(r122);
        r118 = r122.y;
        goto L111
    L106:
        WindowManager r123 = (WindowManager) r110.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r124 = new DisplayMetrics();
        r123.getDefaultDisplay().getMetrics(r124);
        r117 = r124.widthPixels;
    L79:
        e = move-exception;
        e.printStackTrace();
    L75:
        e = move-exception;
        e.printStackTrace();
    L81:
        IOException e100 = e;
    L91:
        e100.printStackTrace();     // Catch: Throwable -> L121
        if (r111 != null) goto L163;
    L97:
        if (r107 != 0) goto L167;
    L102:
        r116 = 0;
        goto L103
    L167:
        r107.close();     // Catch: IOException -> L100
    L100:
        e = move-exception;
        e.printStackTrace();
        goto L102
    L163:
        r111.close();     // Catch: IOException -> L95
    L95:
        e = move-exception;
        e.printStackTrace();
        goto L97
    L85:
        e = move-exception;
        e100 = e;
        r111 = null;
    L83:
        th = th;
    L123:
        if (r101 != 0) goto L150;
    L128:
        if (r107 == 0) goto L190;
        r107.close();     // Catch: IOException -> L131
        throw th;
    L131:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L190:
        throw th;
    L150:
        r101.close();     // Catch: IOException -> L126
    L126:
        e = move-exception;
        e.printStackTrace();
    L121:
        th = th;
        r101 = "/proc/meminfo";
    L89:
        e = move-exception;
        r107 = 0;
        e100 = e;
        r111 = null;
    L87:
        th = th;
        r107 = 0;
    L63:
        e = move-exception;
        e.printStackTrace();
        r108 = 1;
    L44:
        e = e;
    L58:
        e.printStackTrace();
        r107 = r106;
    L46:
        IOException e101 = e;
    L52:
        e101.printStackTrace();     // Catch: Throwable -> L134
        if (r104 != null) goto L165;
    L59:
        r107 = "0";
        goto L60
    L165:
        r104.close();     // Catch: IOException -> L56
    L56:
        e = e;
        r106 = "0";
    L134:
        th = th;
        r102 = r104;
    L136:
        if (r102 != null) goto L154;
    L141:
        throw th;
    L154:
        r102.close();     // Catch: IOException -> L139
    L139:
        e = move-exception;
        e.printStackTrace();
    L50:
        e = move-exception;
        e101 = e;
        r104 = null;
    L48:
        th = th;
        goto L136
    L171:
        PolarisFileReaderWrapper r125 = new PolarisFileReaderWrapper("/proc/cpuinfo");     // Catch: Throwable -> L27 IOException -> L31
    L173:
        BufferedReader r126 = new BufferedReader(r125);     // Catch: Throwable -> L24 IOException -> L26
        String r127 = r126.readLine();     // Catch: Throwable -> L22 IOException -> L142
    L8:
        if (r127 == null) goto L18;
        if (r127.startsWith("Hardware") == false) goto L16;
        if (r127.contains(":") == false) goto L16;
        String r128 = r127.substring(r127.indexOf(":") + 1);     // Catch: Throwable -> L22 IOException -> L142
        if (TextUtils.isEmpty(r128) == true) goto L16;
        e.f449934a = r128.trim();     // Catch: Throwable -> L22 IOException -> L142
    L16:
        r127 = r126.readLine();     // Catch: Throwable -> L22 IOException -> L142
    L18:
        if (TextUtils.isEmpty(e.f449934a) == false) goto L20;
        e.f449934a = e.c();     // Catch: Throwable -> L22 IOException -> L142
    L20:
        r103 = e.f449934a;     // Catch: Throwable -> L22 IOException -> L142
        e.b(r126);
        e.b(r125);
        goto L33
    L22:
        th = th;
        r100 = r126;
    L29:
        e.b(r100);
        e.b(r125);
        throw th;
    L32:
        e.b(r126);
        e.b(r125);
        r103 = null;
        goto L33
    L26:
        r126 = null;
    L24:
        th = th;
    L31:
        r125 = null;
        r126 = null;
    L27:
        th = th;
        r125 = null;
        goto L29
    }
}
