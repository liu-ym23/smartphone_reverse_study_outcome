package com.bytedance.crash.dumper;

import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
public final class k {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f203160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f203161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f203162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f203163d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f203164e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f203165f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f203166g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f203167h;

        public final JSONObject a() {
            if (this.f203160a == 0) goto L13;
            int r100 = this.f203162c;
            if (r100 == 2) goto L8;
            if (r100 == 4) goto L8;
            return null;
        L8:
            JSONObject r101 = new JSONObject();
            r101.put(ChameleonOpenTracker.ParamKey.COST, this.f203160a);     // Catch: JSONException -> L15
            r101.put("longMsgEnd", this.f203161b);     // Catch: JSONException -> L15
            if (this.f203162c != 4) goto L12;
            r101.put(RemoteMessageConst.Notification.WHEN, this.f203163d);     // Catch: JSONException -> L15
            r101.put("what", this.f203164e);     // Catch: JSONException -> L15
            r101.put(PickerReporterConstants.KEY.TARGET, this.f203165f);     // Catch: JSONException -> L15
            com.bytedance.crash.util.j.h(r101, this.f203166g, this.f203167h);     // Catch: JSONException -> L15
        L12:
            return r101;
        L13:
            return null;
        }

        public a() {
            this.f203160a = 0;
            this.f203161b = 0;
            this.f203162c = 0;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f203168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f203169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f203170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f203171d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f203172e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f203173f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f203174g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f203175h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f203176i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Map<String, Long> f203177j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f203178k;

        public final long a() {
            long r100 = this.f203178k;
            if (r100 != 0) goto L5;
            return 0;
        L5:
            long r101 = ((this.f203171d + this.f203170c) * 100) / r100;
            long r102 = (this.f203168a * 100) / r100;
            long r103 = (this.f203169b * 25) / r100;
            this.f203174g = r101;
            if (r101 > 30) goto L9;
            this.f203174g = r101 + r102;
        L9:
            if (r102 > 30) goto L12;
            this.f203174g += r103;
        L12:
            if (this.f203174g <= 500) goto L15;
            this.f203174g = 500;
        L15:
            return this.f203174g;
        }

        public final String b() {
            String r100 = this.f203175h;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Iterator r101 = ((HashMap) this.f203177j).entrySet().iterator();
        L7:
            if (r101.hasNext() == false) goto L12;
            Map.Entry r102 = (Map.Entry) r101.next();
            if (((Long) r102.getValue()).longValue() <= this.f203176i) goto L7;
            this.f203176i = ((Long) r102.getValue()).longValue();
            this.f203175h = (String) r102.getKey();
            goto L7
        L12:
            return this.f203175h;
        }

        public final JSONObject c() {
            if (this.f203173f != 0) goto L5;
            return null;
        L5:
            if (this.f203170c == 0) goto L15;
            JSONObject r100 = new JSONObject();
            r100.put("blockGcCost", this.f203168a);     // Catch: JSONException -> L12
            r100.put("blockGcCount", this.f203172e);     // Catch: JSONException -> L12
            r100.put("gcCount", this.f203173f);     // Catch: JSONException -> L12
            r100.put("gcCost", this.f203169b);     // Catch: JSONException -> L12
            r100.put("mainWaitCount", 0);     // Catch: JSONException -> L12
            r100.put("mainWait", this.f203170c);     // Catch: JSONException -> L12
            r100.put("mainPerformCount", 0);     // Catch: JSONException -> L12
            r100.put("mainPerform", this.f203171d);     // Catch: JSONException -> L12
            r100.put("blockGcCause", b());     // Catch: JSONException -> L12
            r100.put("blockGcCauseCost", this.f203176i);     // Catch: JSONException -> L12
            r100.put("gcScore", a());     // Catch: JSONException -> L12
        L9:
            return r100;
        L15:
            return null;
        }

        public b() {
            this.f203168a = 0;
            this.f203169b = 0;
            this.f203170c = 0;
            this.f203171d = 0;
            this.f203172e = 0;
            this.f203173f = 0;
            this.f203174g = 0;
            this.f203175h = null;
            this.f203176i = 0;
            this.f203177j = new HashMap();
            this.f203178k = 30000;
        }
    }

    public static String a(long r100) {
        com.bytedance.crash.util.q r101 = new com.bytedance.crash.util.q("ms");
        r101.c(new Long[]{0L, 1000L, 2000L, 3000L, 5000L, 7000L, 10000L});
        return r101.a(r100);
    }

    public static String b(int r100) {
        com.bytedance.crash.util.q r101 = new com.bytedance.crash.util.q("");
        r101.c(new Long[]{0L, 1L, 5L, 10L, 20L});
        return r101.a(r100);
    }

    public static float f(String r100) {
        if (r100 != null) goto L5;
    L53:
        return 0.0f;
    L5:
        if (r100.length() < 2) goto L53;
        byte r101 = 0;
        int r102 = 0;
    L9:
        if (r102 >= r100.length()) goto L16;
        if (Character.isDigit(r100.charAt(r102)) == true) goto L15;
        if (r100.charAt(r102) == '.') goto L15;
    L17:
        if (r102 != (-1)) goto L55;
        return 0.0f;
    L55:
        String r103 = r100.substring(0, r102);     // Catch: Throwable -> L54
        String r104 = r100.substring(r102);     // Catch: Throwable -> L54
        float r105 = CastFloatProtector.parseFloat(r103);     // Catch: Throwable -> L54
        int r106 = r104.hashCode();     // Catch: Throwable -> L54
        if (r106 == 115) goto L38;
        if (r106 == 3494) goto L35;
        if (r106 == 3525) goto L32;
        if (r106 == 3742) goto L29;
    L40:
        r101 = -1;
    L41:
        if (r101 == 0) goto L52;
        if (r101 == 1) goto L50;
        if (r101 == 2) goto L60;
        if (r101 == 3) goto L48;
        return 0.0f;
    L48:
        return r105 * 1000.0f;
    L60:
        return r105;
    L50:
        return r105 / 1000.0f;
    L52:
        return r105 / 1000000.0f;
    L29:
        if (r104.equals(EnvConst$GEO.US) == false) goto L40;
        r101 = 1;
        goto L41
    L32:
        if (r104.equals("ns") == false) goto L40;
    L35:
        if (r104.equals("ms") == false) goto L40;
        r101 = 2;
        goto L41
    L38:
        if (r104.equals("s") == false) goto L40;
        r101 = 3;
    L15:
        r102 = r102 + 1;
        goto L9
    L16:
        r102 = -1;
        goto L17
    }

    public static long g(String r110) {
        if (r110 != null) goto L4;
        return -1;
    L4:
        if (r110.isEmpty() == true) goto L59;
        boolean r100 = r110.startsWith("-");
        if (r100 == false) goto L9;
    L10:
        r110 = r110.substring(1);
    L11:
        Matcher r111 = PatternProtector.compile("(\\d+)([dhms]+)").matcher(r110);
        long r101 = 0;
    L13:
        if (r111.find() == false) goto L44;
        long r102 = CastLongProtector.parseLong(r111.group(1));
        byte r103 = 2;
        String r104 = r111.group(2);
        r104.getClass();
        switch(r104.hashCode()) {
            case 100: goto L33;
            case 104: goto L29;
            case 109: goto L26;
            case 115: goto L22;
            case 3494: goto L18;
            default: goto L16;
        };
    L16:
        r103 = -1;
    L36:
        switch(r103) {
            case 0: goto L41;
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L43;
            default: goto L13;
        };
    L38:
        long r105 = 1000;
    L42:
        r102 = r102 * r105;
        goto L43
    L39:
        r105 = 60000;
        goto L42
    L40:
        r105 = 3600000;
        goto L42
    L41:
        r105 = 86400000;
    L43:
        r101 = r101 + r102;
        goto L13
    L18:
        if (r104.equals("ms") == false) goto L16;
        r103 = 4;
        goto L36
    L22:
        if (r104.equals("s") == false) goto L16;
        r103 = 3;
        goto L36
    L26:
        if (r104.equals("m") == true) goto L36;
    L29:
        if (r104.equals("h") == false) goto L16;
        r103 = 1;
        goto L36
    L33:
        if (r104.equals("d") == false) goto L16;
        r103 = 0;
        goto L36
    L44:
        if (r100 == true) goto L46;
        return r101;
    L46:
        return -r101;
    L9:
        if (r110.startsWith(Marker.ANY_NON_NULL_MARKER) == false) goto L11;
    L59:
        return -1;
    }

    public static void i(JSONObject r210) {
        JSONArray r100 = r210.optJSONArray("logcat");
        JSONObject r101 = r210.optJSONObject("filters");
        long r110 = r210.optLong("crash_time");
        int r111 = r210.optInt("pid");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length() == 0) goto L96;
        if (r101 == null) goto L97;
        b r112 = new b();
        a r113 = new a();
        int r114 = 1;
        int r102 = r100.length() - 1;
    L10:
        if (r102 <= 0) goto L59;
        String r103 = JSONArrayProtectorUtils.getString(r100, r102);     // Catch: Exception -> L54
        if (TextUtils.isEmpty(r103) == false) goto L15;
    L13:
        int r211 = r102;
    L14:
        a r115 = r113;
        int r212 = r111;
        b r213 = r112;
        long r116 = r110;
    L58:
        r102 = r211 - 1;
        r113 = r115;
        r100 = r100;
        r110 = r116;
        r111 = r212;
        r112 = r213;
        r114 = 1;
        goto L10
    L15:
        long r117 = c(r110, r103);     // Catch: Exception -> L54
        String r104 = r103.substring(19);     // Catch: Exception -> L54
        if (r104.contains("ANR_LOG") == false) goto L19;
        int r105 = 0;
    L25:
        if (r105 == (-1)) goto L13;
        Matcher r106 = PatternProtector.compile("(\\d+)\\s+(\\d+) \\S\\s+[\\s\\S]*:([\\s\\S]*)").matcher(r104);     // Catch: Exception -> L54
        if (r106.find() == false) goto L13;
        String r107 = r106.group(r114);     // Catch: Exception -> L54
        String r108 = r106.group(2);     // Catch: Exception -> L54
        String r214 = r106.group(3);     // Catch: Exception -> L54
        if (r107 == null) goto L32;
        long r215 = CastLongProtector.parseLong(r107);     // Catch: Exception -> L54
    L33:
        if (r108 != null) goto L35;
        long r109 = 0;
        long r118 = 0;
    L38:
        if (r215 == r109) goto L13;
        if (r111 != r215) goto L13;
        if (r214 == null) goto L13;
        if (r105 != 0) goto L49;
        r211 = r102;
        d(r113, r110, r117, r214);     // Catch: Exception -> L47
    L47:
        e = e;
    L56:
        r115 = r113;
        r212 = r111;
        r213 = r112;
        r116 = r110;
    L57:
        new RuntimeException(e);
        goto L58
    L49:
        r211 = r102;
        r100 = r100;
        r115 = r113;
        long r119 = r215;
        r212 = r111;
        r213 = r112;
        long r120 = r118;
        r116 = r110;
        e(r112, r110, r105, r117, r119, r120, r214);     // Catch: Exception -> L52
    L52:
        e = e;
        goto L57
    L35:
        r118 = CastLongProtector.parseLong(r108);     // Catch: Exception -> L54
        r109 = 0;
        goto L38
    L32:
        r215 = 0;
        goto L33
    L19:
        if (r104.contains("GC freed") == false) goto L22;
        r105 = 1;
        goto L25
    L22:
        if (r104.contains("WaitForGcToComplete blocked") == false) goto L24;
        r105 = 2;
        goto L25
    L24:
        r105 = -1;
    L54:
        e = e;
        r211 = r102;
        goto L56
    L59:
        a r121 = r113;
        b r216 = r112;
        long r122 = 0;
        com.bytedance.crash.util.j.h(r210, "logcat_gc_info", r216.c());     // Catch: Throwable -> L82
        String r123 = r216.f203175h;     // Catch: Throwable -> L82
        if (r123 == null) goto L67;
        r101.put("logcat_gc_cause", r123);     // Catch: Throwable -> L82
        r101.put("logcat_gc_cause_cost", a(r216.f203176i));     // Catch: Throwable -> L82
        r101.put("logcat_gc_count_range", b(r216.f203172e));     // Catch: Throwable -> L82
        r101.put("logcat_gc_total_cost_range", a(r216.f203168a));     // Catch: Throwable -> L82
        int r124 = r216.f203172e;     // Catch: Throwable -> L82
        if (r124 == 0) goto L66;
        r122 = r216.f203168a / ((long) r124);     // Catch: Throwable -> L82
    L66:
        r101.put("logcat_gc_avg_cost_range", a(r122));     // Catch: Throwable -> L82
    L67:
        com.bytedance.crash.util.j.h(r210, "logcat_anr_info", r121.a());     // Catch: Throwable -> L82
        int r125 = r121.f203162c;     // Catch: Throwable -> L82
        if (r125 == 0) goto L79;
        if (r125 == 1) goto L78;
        if (r125 == 2) goto L77;
        if (r125 != 3) goto L73;
        String r126 = "dropped";
    L80:
        com.bytedance.crash.util.j.h(r101, "anr_log_tag", r126);     // Catch: Throwable -> L82
        return;
    L73:
        if (r125 == 4) goto L75;
        r126 = "wrong";
        goto L80
    L75:
        r126 = "parsed_msg";
        goto L80
    L77:
        r126 = "parsed_log";
        goto L80
    L78:
        r126 = "found";
        goto L80
    L79:
        r126 = "none";
    L98:
        return;
    L97:
        return;
    }

    public static long c(long r100, String r101) {
        String r102 = r101.substring(0, 18);     // Catch: Throwable -> L5
        Date r103 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(String.format("%tY", new Object[]{new Date(r100)}) + "-" + r102);     // Catch: Throwable -> L5
    L6:
        if (r103 != null) goto L12;
        return -1;
    L12:
        return r103.getTime();
    L5:
        r103 = null;
        goto L6
    }

    public static void h(JSONObject r100, File r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, "logcat.txt");
        if (r102.exists() == true) goto L5;
    L48:
        NativeBridge.l(r101.getAbsolutePath(), false);     // Catch: Throwable -> L43
    L9:
        r102 = new PolarisFileWrapper(r101, "logcat.txt");
        if (r102.exists() == true) goto L12;
        return;
    L12:
        if (r102.isDirectory() == true) goto L60;
    L14:
        int r103 = (int) r102.length();
        JSONArray r104 = new JSONArray();
        BufferedReader r105 = new BufferedReader(new PolarisFileReaderWrapper(r102));     // Catch: Throwable -> L25
    L44:
        String r106 = r105.readLine();     // Catch: Throwable -> L23
        if (r106 != null) goto L19;
    L56:
        r105.close();     // Catch: IOException -> L31
    L33:
        if (r104.length() == 0) goto L58;
        r100.put("logcat", r104);     // Catch: JSONException -> L41
        return;
    L59:
        return;
    L58:
        return;
    L19:
        if (r103 >= 524288) goto L22;
        r104.put(r106);     // Catch: Throwable -> L23
    L22:
        r103 = r103 - (r106.length() + 1);
    L23:
        th = th;
    L52:
        com.bytedance.crash.util.p.d(th);     // Catch: Throwable -> L36
        if (r105 == null) goto L33;
    L36:
        th = move-exception;
        if (r105 != null) goto L54;
    L39:
        throw th;
    L54:
        r105.close();     // Catch: IOException -> L42
    L25:
        th = th;
        r105 = null;
        goto L52
    L60:
        return;
    L5:
        if (r102.isDirectory() == true) goto L48;
        if (r102.length() >= 50) goto L14;
        goto L14
    }

    public static void d(a r100, long r110, long r111, String r112) {
        if (r112.contains("Blocked msg") == true) goto L6;
        return;
    L6:
        if (1 <= r100.f203162c) goto L47;
        r100.f203162c = 1;
    L47:
        Matcher r113 = PatternProtector.compile(".*?Blocked msg = (\\{.*?\\}) , cost\\s+=\\s+(\\d+)\\s+ms").matcher(r112);     // Catch: Throwable -> L44
        if (r113.find() == true) goto L11;
        return;
    L11:
        if (2 <= r100.f203162c) goto L13;
        r100.f203162c = 2;     // Catch: Throwable -> L44
    L13:
        String r101 = r113.group(1);     // Catch: Throwable -> L44
        long r102 = CastIntegerProtector.parseInt(r113.group(2));     // Catch: Throwable -> L44
        long r103 = r110 - 20000;     // Catch: Throwable -> L44
        long r114 = r110 - 10000;     // Catch: Throwable -> L44
        if (r111 < r103) goto L27;
        long r104 = r100.f203160a;     // Catch: Throwable -> L44
        if (r104 > 0) goto L22;
        if (r102 < 2000) goto L27;
    L26:
        boolean r115 = false;
    L29:
        if (r115 == true) goto L31;
        r100.f203161b = r111;     // Catch: Throwable -> L44
        r100.f203160a = r102;     // Catch: Throwable -> L44
        long r116 = -1;
        r100.f203163d = -1;     // Catch: Throwable -> L44
        r100.f203164e = -1;     // Catch: Throwable -> L44
        r100.f203165f = null;     // Catch: Throwable -> L44
        r100.f203166g = null;     // Catch: Throwable -> L44
        r100.f203167h = null;     // Catch: Throwable -> L44
        if (r101 == null) goto L41;
        Matcher r117 = PatternProtector.compile(".*?when=(\\S+)\\s+what=(\\d+)\\s+target=(\\S+)\\s+(.*?)=(.*?)\\}$").matcher(r101);     // Catch: Throwable -> L44
        if (r117.find() == false) goto L41;
        r116 = g(r117.group(1));     // Catch: Throwable -> L44
        int r118 = CastIntegerProtector.parseInt(r117.group(2));     // Catch: Throwable -> L44
        String r119 = r117.group(3);     // Catch: Throwable -> L44
        String r105 = r117.group(4);     // Catch: Throwable -> L44
        String r120 = r117.group(5);     // Catch: Throwable -> L44
        if (4 <= r100.f203162c) goto L42;
        r100.f203162c = 4;     // Catch: Throwable -> L44
    L42:
        r100.f203163d = r116;     // Catch: Throwable -> L44
        r100.f203164e = r118;     // Catch: Throwable -> L44
        r100.f203165f = r119;     // Catch: Throwable -> L44
        r100.f203166g = r105;     // Catch: Throwable -> L44
        r100.f203167h = r120;     // Catch: Throwable -> L44
        return;
    L41:
        r119 = null;
        r120 = null;
        r105 = null;
        r118 = -1;
        goto L42
    L31:
        if (3 <= r100.f203162c) goto L48;
        r100.f203162c = 3;     // Catch: Throwable -> L44
        return;
    L48:
        return;
    L22:
        if (r102 <= r104) goto L27;
        if (r111 >= r114) goto L26;
    L27:
        r115 = true;
    L44:
        th = move-exception;
        ch4.c.b("parseAnrLogException", th);
    }

    public static void e(b r100, long r101, int r102, long r103, long r104, long r110, String r111) {
        if (r103 <= (5000 + r101)) goto L5;
        return;
    L5:
        if (r103 >= (r101 - 30000)) goto L8;
        return;
    L8:
        if (r102 != 1) goto L17;
        r100.f203173f++;
        Matcher r105 = PatternProtector.compile("(\\S+)\\s+.*?GC freed.*?paused \\S+ total (\\S+)").matcher(r111);
        if (r105.find() == false) goto L29;
        String r106 = r105.group(1);
        float r107 = f(r105.group(2));
        r100.f203169b = (long) (r100.f203169b + r107);
        if ("Background".equals(r106) == true) goto L15;
        r100.f203168a = (long) (r100.f203168a + r107);
        r100.f203172e++;
    L15:
        if (r104 != r110) goto L30;
        r100.f203171d = (long) (r100.f203171d + r107);
        return;
    L30:
        return;
    L29:
        return;
    L17:
        if (r102 != 2) goto L32;
        Matcher r108 = PatternProtector.compile("WaitForGcToComplete blocked \\S+ on (\\S+) for (\\S+)").matcher(r111);
        if (r108.find() == false) goto L33;
        String r109 = r108.group(1);
        long r112 = (long) f(r108.group(2));
        Long r113 = (Long) ((HashMap) r100.f203177j).get(r109);
        if (r113 != null) goto L23;
        ((HashMap) r100.f203177j).put(r109, Long.valueOf(r112));
    L25:
        if (r104 != r110) goto L34;
        r100.f203170c = (r100.f203170c + 1) + r112;
        return;
    L34:
        return;
    L23:
        ((HashMap) r100.f203177j).put(r109, Long.valueOf(r113.longValue() + r112));
        goto L25
    L33:
        return;
    }
}
