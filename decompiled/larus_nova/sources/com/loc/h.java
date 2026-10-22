package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import n4a.c4;
import n4a.e5;
import n4a.f5;
import n4a.i4;
import n4a.n;
import n4a.q0;
import n4a.r;
import n4a.s0;
import n4a.y;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class h {
    public static boolean A = false;
    public static String B = null;
    public static long C = 0;
    public static boolean D = false;
    public static int E = 0;
    public static int F = 0;
    public static boolean G = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f380067a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f380068b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f380069c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f380070d = 200;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f380071e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f380072f = 20;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f380073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile int f380074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f380075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f380076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f380077k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f380078l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static double f380079m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f380080n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f380081o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f380082p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f380083q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f380084r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f380085s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f380086t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f380087u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static long f380088v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f380089w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f380090x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f380091y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static int f380092z;

    public static class a implements i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f380093a;

        public a(Context r100) {
            this.f380093a = r100;
        }
    }

    static {
        new ArrayList();
        new ArrayList();
        f380075i = false;
        f380076j = true;
        f380077k = 300000;
        f380078l = false;
        f380079m = 0.618d;
        f380080n = true;
        f380081o = 80;
        f380082p = 5;
        f380083q = 3600000;
        f380084r = true;
        f380085s = false;
        f380086t = false;
        f380087u = true;
        f380088v = -1;
        f380089w = true;
        f380090x = 1;
        f380091y = false;
        f380092z = 5;
        A = false;
        B = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
        C = 0;
        D = false;
        E = 20480;
        F = 10800000;
        G = false;
    }

    public static void d(JSONObject r100, SharedPreferences.Editor r101) {
        JSONObject r102 = r100.optJSONObject("11G");     // Catch: Throwable -> L9
        if (r102 == null) goto L14;
        boolean r103 = i.o(r102.optString("able"), true);     // Catch: Throwable -> L9
        f380076j = r103;     // Catch: Throwable -> L9
        if (r103 == false) goto L7;
        f380077k = r102.optInt("c", 300) * 1000;     // Catch: Throwable -> L9
    L7:
        f380078l = i.o(r102.optString("fa"), false);     // Catch: Throwable -> L9
        f380079m = Math.min(1.0d, Math.max(0.2d, r102.optDouble("ms", 0.618d)));     // Catch: Throwable -> L9
        i4.i(r101, "ca", f380076j);     // Catch: Throwable -> L9
        i4.g(r101, "ct", f380077k);     // Catch: Throwable -> L9
        i4.i(r101, "11G_fa", f380078l);     // Catch: Throwable -> L9
        i4.h(r101, "11G_ms", String.valueOf(f380079m));     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadConfigDataCacheAble");
    }

    public static void h(JSONObject r100, SharedPreferences.Editor r101) {
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r100, "197");     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        boolean r103 = i.o(r102.optString("able"), false);     // Catch: Throwable -> L11
        i4.i(r101, "197a", r103);     // Catch: Throwable -> L11
        if (r103 == false) goto L9;
        i4.h(r101, "197dv", r102.optString(com.alipay.sdk.m.s.a.f25762t, ""));     // Catch: Throwable -> L11
        i4.h(r101, "197tv", r102.optString(CommonCmd.AIDL_PLATFORM_TYPE_TV, ""));     // Catch: Throwable -> L11
        return;
    L9:
        i4.h(r101, "197dv", "");     // Catch: Throwable -> L11
        i4.h(r101, "197tv", "");     // Catch: Throwable -> L11
        return;
    L13:
        return;
    }

    public static void i(JSONObject r100, SharedPreferences.Editor r101) {
        JSONObject r102 = r100.optJSONObject("13J");     // Catch: Throwable -> L9
        if (r102 == null) goto L14;
        boolean r103 = i.o(r102.optString("able"), true);     // Catch: Throwable -> L9
        f380080n = r103;     // Catch: Throwable -> L9
        if (r103 == false) goto L7;
        f380081o = r102.optInt("c", f380081o);     // Catch: Throwable -> L9
        f380082p = r102.optInt("t", f380082p);     // Catch: Throwable -> L9
    L7:
        i4.i(r101, "13J_able", f380080n);     // Catch: Throwable -> L9
        i4.f(r101, "13J_c", f380081o);     // Catch: Throwable -> L9
        i4.f(r101, "13J_t", f380082p);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadConfigDataGpsGeoAble");
    }

    public static void j(JSONObject r100, SharedPreferences.Editor r101) {
        JSONObject r102 = r100.optJSONObject("15O");     // Catch: Throwable -> L16
        if (r102 != null) goto L5;
        return;
    L5:
        if (i.o(r102.optString("able"), false) == false) goto L13;
        JSONArray r103 = r102.optJSONArray("fl");     // Catch: Throwable -> L16
        if (r103 != null) goto L9;
    L12:
        f380088v = r102.optInt(CJPayFingerprintSharedPrefUtils.KEY_IV, 30) * 1000;     // Catch: Throwable -> L16
    L14:
        i4.g(r101, "awsi", f380088v);     // Catch: Throwable -> L16
        return;
    L9:
        if (r103.length() <= 0) goto L12;
        if (r103.toString().contains(Build.MANUFACTURER) == true) goto L12;
    L13:
        f380088v = -1;     // Catch: Throwable -> L16
    }

    public static void k(JSONObject r100, SharedPreferences.Editor r101) {
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r100, "17Y");     // Catch: Throwable -> L11
        if (r102 == null) goto L14;
        i4.i(r101, "17ya", i.o(r102.optString("able"), false));     // Catch: Throwable -> L11
        boolean r103 = i.o(r102.optString("mup"), false);     // Catch: Throwable -> L11
        D = r103;     // Catch: Throwable -> L11
        i4.i(r101, "17ym", r103);     // Catch: Throwable -> L11
        int r104 = r102.optInt(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, 20);     // Catch: Throwable -> L11
        if (r104 <= 0) goto L7;
        i4.f(r101, "17yx", r104);     // Catch: Throwable -> L11
        E = r104 * 1024;     // Catch: Throwable -> L11
    L7:
        int r105 = r102.optInt("inv", 3);     // Catch: Throwable -> L11
        if (r105 <= 0) goto L15;
        i4.f(r101, "17yi", r105);     // Catch: Throwable -> L11
        F = ((r105 * 60) * 60) * 1000;     // Catch: Throwable -> L11
        return;
    L15:
        return;
    L14:
        return;
    }

    public static void l(JSONObject r100, SharedPreferences.Editor r101) {
        JSONObject r102 = r100.optJSONObject("15U");     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        boolean r103 = i.o(r102.optString("able"), true);     // Catch: Throwable -> L6
        int r104 = r102.optInt("yn", f380090x);     // Catch: Throwable -> L6
        C = r102.optLong("sysTime", C);     // Catch: Throwable -> L6
        i4.i(r101, "15ua", r103);     // Catch: Throwable -> L6
        i4.f(r101, "15un", r104);     // Catch: Throwable -> L6
        i4.g(r101, "15ust", C);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void m(JSONObject r100, SharedPreferences.Editor r101) {
        JSONObject r102 = r100.optJSONObject("17J");     // Catch: Throwable -> L14
        if (r102 == null) goto L17;
        boolean r103 = i.o(r102.optString("able"), false);     // Catch: Throwable -> L14
        f380091y = r103;     // Catch: Throwable -> L14
        i4.i(r101, "ok9", r103);     // Catch: Throwable -> L14
        if (r103 == false) goto L18;
        String r104 = r102.optString("auth");     // Catch: Throwable -> L14
        String r105 = r102.optString("ht");     // Catch: Throwable -> L14
        B = r105;     // Catch: Throwable -> L14
        i4.h(r101, "ok11", r105);     // Catch: Throwable -> L14
        i.o(r104, false);     // Catch: Throwable -> L14
        A = i.o(r102.optString(LocationInfoConst.NR), false);     // Catch: Throwable -> L14
        String r106 = r102.optString("tm");     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r106) == true) goto L19;
        int r107 = CastIntegerProtector.parseInt(r106);     // Catch: Throwable -> L14
        if (r107 > 0) goto L11;
        return;
    L11:
        if (r107 >= 20) goto L21;
        f380092z = r107;     // Catch: Throwable -> L14
        i4.f(r101, "ok10", r107);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public static void a(Context r100) {
        if (f380067a == false) goto L5;
        return;
    L5:
        f380067a = true;
        e5 r101 = c4.k();
        a r102 = new a(r100);
        int r103 = i.f380094a;
        monitor-enter(i.class);
        if (r100 == null) goto L46;
        if (r101 == null) goto L46;
    L40:
        th = move-exception;
        n.a(th, INotificationHitPoint.NoticeType.AT, "rglc");     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L11:
        if (i.f380096c != null) goto L13;
        i.f380096c = r100.getApplicationContext();     // Catch: Throwable -> L40
    L13:
        String r104 = r101.a();     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r104) == true) goto L46;
        i.j(r101);     // Catch: Throwable -> L40
        if (i.f380105l != null) goto L20;
        i.f380105l = new ConcurrentHashMap(8);     // Catch: Throwable -> L40
    L20:
        if (i.f380104k != null) goto L23;
        i.f380104k = new ConcurrentHashMap(8);     // Catch: Throwable -> L40
    L23:
        if (i.f380103j != null) goto L26;
        i.f380103j = new ConcurrentHashMap(8);     // Catch: Throwable -> L40
    L26:
        if (i.f380105l.containsKey(r104) == true) goto L46;
        i.e r105 = new i.e();     // Catch: Throwable -> L40
        r105.f380133a = r101;     // Catch: Throwable -> L40
        r105.f380134b = "11G;11K;13J;13S;15O;15U;17J;17Y;197;1A6";     // Catch: Throwable -> L40
        r105.f380135c = r102;     // Catch: Throwable -> L40
        i.f380105l.put(r104, r105);     // Catch: Throwable -> L40
        long r106 = 0;
        r106 = i.f380096c.getSharedPreferences("open_common", 0).getLong(r104, 0);     // Catch: Throwable -> L31
    L33:
        i.f380103j.put(r104, new i.h(Long.valueOf(r106), y.k(i.f380096c, "open_common", r104 + "lct-info")));     // Catch: Throwable -> L40
        Context r107 = i.f380096c;     // Catch: Throwable -> L40
        if (i.f380106m == true) goto L38;
        n4a.c.f517196b = y.i(r107, "a4", true);     // Catch: Throwable -> L48
        n4a.c.f517197c = y.i(r107, "a5", true);     // Catch: Throwable -> L48
        i.f380106m = true;     // Catch: Throwable -> L48
    L38:
        i.y(i.f380096c);     // Catch: Throwable -> L40
        goto L46
    L31:
        th = move-exception;
        r.f(th, "csp", "glv");     // Catch: Throwable -> L40
    L46:
        monitor-exit(i.class);
    }

    public static boolean e(long r100) {
        if (f380076j == true) goto L5;
        return false;
    L5:
        long r101 = System.currentTimeMillis() - r100;
        long r102 = f380077k;
        if (r102 >= 0) goto L8;
        return true;
    L8:
        if (r101 < r102) goto L13;
        return false;
    L13:
        return true;
    }

    public static void g(Context r100) {
        if (f380075i == false) goto L5;
        return;
    L5:
        f380075i = true;
        f380068b = i4.j(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, f380068b);     // Catch: Throwable -> L9
        e5 r101 = c4.k();     // Catch: Throwable -> L81
        r101.f517261c = f380068b ? 1 : 0;     // Catch: Throwable -> L81
        r.b(r100, r101);     // Catch: Throwable -> L81
    L11:
        int r102 = 0;
        f380069c = i4.a(r100, BytedCertConstant.LivenessInfoConfigKey.FRAME_NUM, f380069c);     // Catch: Throwable -> L20
        f380070d = i4.a(r100, "mpn", f380070d);     // Catch: Throwable -> L20
        f380071e = i4.j(r100, "igu", f380071e);     // Catch: Throwable -> L20
        f380072f = i4.a(r100, "ms", f380072f);     // Catch: Throwable -> L20
        f380074h = i4.a(r100, "rot", 0);     // Catch: Throwable -> L20
        int r103 = i4.a(r100, "pms", 0);     // Catch: Throwable -> L20
        f380073g = r103;     // Catch: Throwable -> L20
        q0.a(f380069c, f380071e, f380072f, r103);     // Catch: Throwable -> L20
        boolean r104 = f380071e;     // Catch: Throwable -> L20
        int r105 = f380073g;     // Catch: Throwable -> L20
        monitor-enter(s0.class);     // Catch: Throwable -> L20
        s0.f517656a = r104;     // Catch: Throwable -> L17
        s0.f517657b = Math.max(0, r105);     // Catch: Throwable -> L17
        monitor-exit(s0.class);     // Catch: Throwable -> L20
    L89:
        f380076j = i4.j(r100, "ca", f380076j);     // Catch: Throwable -> L24
        f380077k = i4.b(r100, "pref", "ct", f380077k);     // Catch: Throwable -> L24
        f380078l = i4.j(r100, "11G_fa", f380078l);     // Catch: Throwable -> L24
        double r106 = CastDoubleProtector.valueOf(i4.d(r100, "pref", "11G_ms", String.valueOf(f380079m))).doubleValue();     // Catch: Throwable -> L24
        f380079m = r106;     // Catch: Throwable -> L24
        f380079m = Math.max(0.2d, r106);     // Catch: Throwable -> L24
    L101:
        f380086t = i4.j(r100, "fr", f380086t);     // Catch: Throwable -> L28
    L91:
        f380087u = i4.j(r100, "asw", f380087u);     // Catch: Throwable -> L32
    L103:
        f380088v = i4.b(r100, "pref", "awsi", f380088v);     // Catch: Throwable -> L36
    L109:
        f380089w = i4.j(r100, "15ua", f380089w);     // Catch: Throwable -> L40
        f380090x = i4.a(r100, "15un", f380090x);     // Catch: Throwable -> L40
        C = i4.b(r100, "pref", "15ust", C);     // Catch: Throwable -> L40
    L85:
        f380091y = i4.j(r100, "ok9", f380091y);     // Catch: Throwable -> L44
        f380092z = i4.a(r100, "ok10", f380092z);     // Catch: Throwable -> L44
        B = i4.d(r100, "pref", "ok11", B);     // Catch: Throwable -> L44
    L99:
        i4.j(r100, "17ya", false);     // Catch: Throwable -> L48
        D = i4.j(r100, "17ym", false);     // Catch: Throwable -> L48
        F = ((i4.a(r100, "17yi", 2) * 60) * 60) * 1000;     // Catch: Throwable -> L48
        E = i4.a(r100, "17yx", 100) * 1024;     // Catch: Throwable -> L48
    L95:
        SystemClock.elapsedRealtime();     // Catch: Throwable -> L52
        f380083q = i4.b(r100, "pref", "13S_at", f380083q);     // Catch: Throwable -> L52
        f380084r = i4.j(r100, "13S_nla", f380084r);     // Catch: Throwable -> L52
        f380080n = i4.j(r100, "13J_able", f380080n);     // Catch: Throwable -> L52
        f380081o = i4.a(r100, "13J_c", f380081o);     // Catch: Throwable -> L52
        f380082p = i4.a(r100, "13J_t", f380082p);     // Catch: Throwable -> L52
    L54:
        int r107 = i.f380094a;
        if (r100 == null) goto L107;
        i.f380097d = y.i(r100, "a2", true);
    L107:
        String r108 = i4.d(r100, "pref", "13S_mlpl", null);     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r108) == true) goto L97;
        f380085s = f(r100, new JSONArray(f5.o(r108)));     // Catch: Throwable -> L62
    L97:
        boolean r109 = i4.j(r100, "197a", false);     // Catch: Throwable -> L74
        String r110 = i4.d(r100, "pref", "197dv", "");     // Catch: Throwable -> L74
        String r111 = i4.d(r100, "pref", "197tv", "");     // Catch: Throwable -> L74
        if (r109 == true) goto L67;
    L83:
        G = i4.j(r100, "1A6", G);     // Catch: Throwable -> L78
        return;
    L78:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadSdkEnableConfig p13");
        return;
    L67:
        if (c4.f517206a.equals(r110) == false) goto L83;
        String[] r112 = c4.f517207b;     // Catch: Throwable -> L74
        int r113 = r112.length;     // Catch: Throwable -> L74
    L69:
        if (r102 >= r113) goto L83;
        if (r112[r102].equals(r111) == false) goto L73;
        c4.f517206a = r111;     // Catch: Throwable -> L74
    L73:
        r102 = r102 + 1;
    L74:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p12");
    L62:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p11");
    L52:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p10");
    L48:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p9");
    L44:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p8");
    L40:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p7");
    L36:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p6");
    L32:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p5");
    L28:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p4");
    L24:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p3");
        goto L101
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p2");
    L9:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadLastAbleState p1");
        goto L11
    }

    public static void c(i.c r110, SharedPreferences.Editor r111) {
        i.c.a r112 = r110.f380126c;     // Catch: Throwable -> L23
        if (r112 == null) goto L22;
        boolean r100 = r112.f380127a;     // Catch: Throwable -> L23
        f380068b = r100;     // Catch: Throwable -> L23
        i4.i(r111, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, r100);     // Catch: Throwable -> L23
        JSONObject r113 = r112.f380128b;     // Catch: Throwable -> L23
        if (r113 == null) goto L14;
        f380069c = r113.optInt(BytedCertConstant.LivenessInfoConfigKey.FRAME_NUM, f380069c);     // Catch: Throwable -> L23
        int r101 = r113.optInt("mpn", f380070d);     // Catch: Throwable -> L23
        f380070d = r101;     // Catch: Throwable -> L23
        if (r101 <= 500) goto L11;
        f380070d = 500;     // Catch: Throwable -> L23
    L11:
        if (f380070d >= 30) goto L13;
        f380070d = 30;     // Catch: Throwable -> L23
    L13:
        f380071e = i.o(r113.optString("igu"), false);     // Catch: Throwable -> L23
        f380072f = r113.optInt("ms", f380072f);     // Catch: Throwable -> L23
        f380074h = r113.optInt("rot", 0);     // Catch: Throwable -> L23
        f380073g = r113.optInt("pms", 0);     // Catch: Throwable -> L23
    L14:
        q0.a(f380069c, f380071e, f380072f, f380073g);     // Catch: Throwable -> L23
        boolean r114 = f380071e;     // Catch: Throwable -> L23
        int r102 = f380073g;     // Catch: Throwable -> L23
        monitor-enter(s0.class);     // Catch: Throwable -> L23
        s0.f517656a = r114;     // Catch: Throwable -> L19
        s0.f517657b = Math.max(0, r102);     // Catch: Throwable -> L19
        monitor-exit(s0.class);     // Catch: Throwable -> L23
        i4.f(r111, BytedCertConstant.LivenessInfoConfigKey.FRAME_NUM, f380069c);     // Catch: Throwable -> L23
        i4.f(r111, "mpn", f380070d);     // Catch: Throwable -> L23
        i4.i(r111, "igu", f380071e);     // Catch: Throwable -> L23
        i4.f(r111, "ms", f380072f);     // Catch: Throwable -> L23
        i4.f(r111, "rot", f380074h);     // Catch: Throwable -> L23
        i4.f(r111, "pms", f380073g);     // Catch: Throwable -> L23
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L22:
        return;
    L23:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadConfigDataUploadException");
    }

    public static boolean f(Context r100, JSONArray r101) {
        if (r101.length() <= 0) goto L21;
        if (r100 == null) goto L21;
        int r102 = 0;
    L8:
        if (r102 >= r101.length()) goto L21;
        String r103 = JSONArrayProtectorUtils.getString(r101, r102);     // Catch: Throwable -> L22
        PackageInfo r104 = r100.getApplicationContext().getPackageManager().getPackageInfo(r103, 256);     // Catch: Throwable -> L13
    L15:
        if (r104 == null) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == true) goto L19;
        r102 = r102 + 1;
        goto L8
    L19:
        return true;
    L17:
        r105 = false;
    L13:
        r104 = null;
    L21:
        return false;
    }

    public static void b(Context r100, JSONObject r101, SharedPreferences.Editor r102) {
        JSONObject r103 = r101.optJSONObject("13S");     // Catch: Throwable -> L30
        if (r103 == null) goto L48;
        long r104 = (r103.optInt(INotificationHitPoint.NoticeType.AT, 123) * 60) * 1000;     // Catch: Throwable -> L7
        f380083q = r104;     // Catch: Throwable -> L7
        i4.g(r102, "13S_at", r104);     // Catch: Throwable -> L7
    L43:
        boolean r105 = i.o(r103.optString("re"), false);     // Catch: Throwable -> L12
        f380086t = r105;     // Catch: Throwable -> L12
        i4.i(r102, "fr", r105);     // Catch: Throwable -> L12
    L39:
        boolean r106 = i.o(r103.optString("nla"), true);     // Catch: Throwable -> L33
        f380084r = r106;     // Catch: Throwable -> L33
        i4.i(r102, "13S_nla", r106);     // Catch: Throwable -> L33
    L46:
        boolean r107 = i.o(r103.optString("asw"), true);     // Catch: Throwable -> L34
        f380087u = r107;     // Catch: Throwable -> L34
        i4.i(r102, "asw", r107);     // Catch: Throwable -> L34
    L45:
        JSONArray r108 = r103.optJSONArray("mlpl");     // Catch: Throwable -> L35
        if (r108 != null) goto L21;
    L24:
        f380085s = false;     // Catch: Throwable -> L35
        r102.remove("13S_mlpl");     // Catch: Throwable -> L27
        goto L50
    L49:
        return;
    L27:
        th = move-exception;
        c4.g(th, "SpUtil", "setPrefsLong");     // Catch: Throwable -> L35
        return;
    L21:
        if (r108.length() <= 0) goto L24;
        i4.h(r102, "13S_mlpl", f5.k(r108.toString()));     // Catch: Throwable -> L35
        f380085s = f(r100, r108);     // Catch: Throwable -> L35
        return;
    L50:
        return;
    L12:
        th = move-exception;
        c4.g(th, "AuthUtil", "checkReLocationAble");     // Catch: Throwable -> L30
    L7:
        th = move-exception;
        c4.g(th, "AuthUtil", "requestSdkAuthInterval");     // Catch: Throwable -> L30
        goto L43
    L48:
        return;
    L30:
        th = move-exception;
        c4.g(th, "AuthUtil", "loadConfigAbleStatus");
    }
}
