package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile i f462053d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f462054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f462055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f462056c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ExecutorService f462057e;

    private i() {
        this.f462055b = "cuPreGetToken";
        this.f462056c = "checkOk";
        this.f462057e = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ount/kernel/i"));
    }

    public static /* synthetic */ Context a(i r100) {
        return r100.f462054a;
    }

    public static i a() {
        if (f462053d != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f462053d != null) goto L9;
        f462053d = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f462053d;
    }

    public static String a(int r100) {
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L17;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L17;
        if (r100 == 24) goto L17;
        if (r100 == 25) goto L17;
        return "";
    L17:
        return "Type".concat(String.valueOf(r100));
    }

    public static String a(int r100, int r101, String r102, int r103, int r104, int r105, String r106) {
        return ai.a(r100, r101, r102, r103, r104, r105, r106);
    }

    private static void a(int r100, h r101, String r102) {
        aj.c("type:" + r100 + "\nmsg:" + r102);
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L7
        r103.put("resultCode", 1);     // Catch: Exception -> L7
        r103.put("resultMsg", r102);     // Catch: Exception -> L7
        r103.put(OnekeyLoginConstants.CU_KEY_RESULT_DATA, "");     // Catch: Exception -> L7
        r103.put(OnekeyLoginConstants.CU_KEY_SEQ, g());     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        r101.onResult(r103.toString());     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        aj.a(e);
    }

    public static void a(boolean r100) {
        aj.a(r100);
    }

    public static boolean a(Context r100) {
        a();
        k.b(r100);
        return k.a(r100);
    }

    public static String b() {
        return ac.d();
    }

    public static boolean b(int r100) {
        if (1 != r100) goto L5;
        ac.b(true);
        ac.a(true);
        ac.c(false);
    L6:
        return true;
    L5:
        ac.b(false);
        ac.a(false);
        ac.c(true);
        goto L6
    }

    public static boolean b(Context r100) {
        int r101 = al.b(r100);
        if (r101 == 0) goto L8;
        if (r101 == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public static /* synthetic */ int c(int r100) {
        return Math.abs(new Random().nextInt() % r100);
    }

    public static void c(Context r100) {
        j.a(r100);
    }

    public static boolean c() {
        return ac.a();
    }

    public static boolean c(String r100) {
        if (d(r100) == false) goto L6;
        ac.f461955g = r100;
        return true;
    L6:
        ac.f461955g = ak.f461993e;
        return false;
    }

    public static String d() {
        if (an.a(ac.f461955g).booleanValue() == false) goto L6;
        ac.f461955g = ak.f461993e;
    L6:
        return ac.f461955g;
    }

    private static boolean d(String r100) {
        if (r100.equalsIgnoreCase(ak.f461994f) == false) goto L5;
        return true;
    L5:
        if (r100.equalsIgnoreCase(ak.f461995g) == false) goto L7;
        return true;
    L7:
        if (r100.equalsIgnoreCase(ak.f461993e) == false) goto L9;
        return true;
    L9:
        if (r100.equalsIgnoreCase(ak.f461996h) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public static String e() {
        return ak.f461997i;
    }

    public static void f() {
        af.a().b();
    }

    public static String g() {
        return "seqEmpty" + System.currentTimeMillis() + "-" + UUID.randomUUID().toString().substring(0, 6);
    }

    public final String a(String r100) {
        if (this.f462054a != null) goto L97;
        return "sdk 未初始化, context 为空";
    L97:
        String r101 = r100.toLowerCase();     // Catch: Exception -> L94
        switch(r101.hashCode()) {
            case -1705644026: goto L52;
            case -1411271163: goto L49;
            case -1077289829: goto L46;
            case -903629273: goto L43;
            case -202146594: goto L40;
            case -197617279: goto L37;
            case 107902: goto L34;
            case 113945: goto L31;
            case 3528965: goto L28;
            case 93029116: goto L25;
            case 667683678: goto L22;
            case 781805572: goto L19;
            case 909712337: goto L16;
            case 1183900800: goto L13;
            case 1285324646: goto L10;
            default: goto L54;
        };     // Catch: Exception -> L94
    L54:
        byte r102 = -1;
    L56:
        switch(r102) {
            case 0: goto L91;
            case 1: goto L91;
            case 2: goto L89;
            case 3: goto L86;
            case 4: goto L86;
            case 5: goto L86;
            case 6: goto L82;
            case 7: goto L73;
            case 8: goto L71;
            case 9: goto L69;
            case 10: goto L67;
            case 11: goto L65;
            case 12: goto L63;
            case 13: goto L61;
            case 14: goto L59;
            default: goto L93;
        };
    L86:
        Context r103 = this.f462054a;     // Catch: Exception -> L94
        return al.a(r103, r103.getPackageName(), r100.toLowerCase());
    L93:
        throw new Exception("no info");     // Catch: Exception -> L94
    L59:
        return al.a(3);
    L61:
        return ae.a();
    L63:
        return al.a(2);
    L65:
        return al.a(1);
    L67:
        return al.a(0);
    L69:
        return ac.e();
    L71:
        return ac.d();
    L73:
        if (ac.f461949a == true) goto L75;
        return "sdk 未初始化支持国密";
    L75:
        if (Security.getProvider("BC") == null) goto L78;
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L94
        r104.append(Security.getProvider("BC").getVersion());     // Catch: Exception -> L94
        return r104.toString();
    L78:
        return "Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) is null";
    L82:
        if (ac.f461949a == false) goto L85;
        Context r105 = this.f462054a;     // Catch: Exception -> L94
        return al.a(r105, r105.getPackageName());
    L85:
        return "sdk 未初始化支持国密";
    L89:
        return this.f462054a.getApplicationContext().getPackageName();
    L91:
        return ak.c();
    L10:
        if (r101.equals("bcproviderversion") == false) goto L54;
        r102 = 7;
        goto L56
    L13:
        if (r101.equals("debuginfoall") == false) goto L54;
        r102 = 11;
        goto L56
    L16:
        if (r101.equals("packagename") == false) goto L54;
        r102 = 2;
        goto L56
    L19:
        if (r101.equals("deviceinfo") == false) goto L54;
        r102 = HTTP.CR;
        goto L56
    L22:
        if (r101.equals("sdkversion") == false) goto L54;
        r102 = 8;
        goto L56
    L25:
        if (r101.equals("appid") == false) goto L54;
        r102 = 1;
        goto L56
    L28:
        if (r101.equals("sha1") == false) goto L54;
        r102 = 4;
        goto L56
    L31:
        if (r101.equals("sm3") == false) goto L54;
        r102 = 6;
        goto L56
    L34:
        if (r101.equals("md5") == false) goto L54;
        r102 = 3;
        goto L56
    L37:
        if (r101.equals("debuginfo") == false) goto L54;
        r102 = 10;
        goto L56
    L40:
        if (r101.equals("debuginforesult") == false) goto L54;
        r102 = 12;
        goto L56
    L43:
        if (r101.equals("sha256") == false) goto L54;
        r102 = 5;
        goto L56
    L46:
        if (r101.equals("debuginfocosttime") == false) goto L54;
        r102 = 14;
        goto L56
    L49:
        if (r101.equals("apikey") == false) goto L54;
        r102 = 0;
        goto L56
    L52:
        if (r101.equals("testversion") == false) goto L54;
        r102 = 9;
    L94:
        e = move-exception;
        return "no info:" + e.toString();
    }

    public final void a(Context r100, int r101) {
        j.b(r100, a(r101), this.f462055b + this.f462056c);
    }

    public final boolean a(Context r100, int r101, String r102, String r103) {
        if (r102.equals(this.f462055b) == true) goto L5;
        return false;
    L5:
        return j.a(r100, a(r101), r102 + this.f462056c, r103);
    }

    public final boolean a(Context r100, String r101, String r102, boolean r103) {
        al.b();
        al.e("cuPreGetToken");
        al.c();
        if (r100 != null) goto L42;
    L33:
        aj.c("初始化参数不能为空");     // Catch: Exception -> L35
        return false;
    L42:
    L35:
        e = move-exception;
        aj.a(e);
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L33;
        if (TextUtils.isEmpty(r102) == true) goto L33;
        if (TextUtils.isEmpty(ak.c()) == true) goto L13;
        aj.c("不可重复初始化");     // Catch: Exception -> L35
        return false;
    L13:
        ac.f461951c = true;     // Catch: Exception -> L35
        ac.f461949a = r103;     // Catch: Exception -> L35
        ac.f461952d = true;     // Catch: Exception -> L35
        if (ac.f461949a == false) goto L16;
        aj.a(" MyApplication.enableGuoMi  ");     // Catch: Exception -> L35
    L16:
        this.f462054a = r100.getApplicationContext();     // Catch: Exception -> L35
        ak.c(r101);     // Catch: Exception -> L35
        ak.f(al.c(this.f462054a));     // Catch: Exception -> L35
        Context r104 = this.f462054a;     // Catch: Exception -> L35
        String r105 = am.a(r104, "auth02");     // Catch: Exception -> L35
        if (TextUtils.isEmpty(r105) == false) goto L23;
        r105 = al.b(UUID.randomUUID().toString().replace("-", "") + System.currentTimeMillis());     // Catch: Exception -> L35
        SharedPreferences.Editor r106 = r104.getSharedPreferences("cu_auth", 0).edit();     // Catch: Exception -> L21
        r106.putString("auth02", r105);     // Catch: Exception -> L21
        r106.commit();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        aj.a(e);     // Catch: Exception -> L35
    L23:
        ak.g(r105);     // Catch: Exception -> L35
        ak.e();     // Catch: Exception -> L35
        c(new String(o.b("bXN2Ni53b3Ntcy5jbg==")));     // Catch: Exception -> L35
        aa.f461944a = false;     // Catch: Exception -> L35
        aa.f461945b = false;     // Catch: Exception -> L35
        if (ac.b() == true) goto L38;
    L31:
        aj.a(ae.a());     // Catch: Exception -> L35
        ak.h(Build.BRAND);     // Catch: Exception -> L35
        return true;
    L38:
        List<d> r107 = am.b(this.f462054a, "DNSCache");     // Catch: Exception -> L29
        ak.f462003o = r107;     // Catch: Exception -> L29
        if (r107.isEmpty() == false) goto L30;
        ak.a(this.f462054a, d());     // Catch: Exception -> L29
    L30:
        this.f462057e.submit(new AnonymousClass1(this));     // Catch: Exception -> L35
    L29:
        ak.f462003o = new ArrayList();     // Catch: Exception -> L35
        goto L30
    }

    public final boolean a(String r100, int r101, int r102, h r103) {
        if (this.f462054a != null) goto L5;
    L11:
        a(r102, r103, "sdk未初始化");
        return false;
    L5:
        if (TextUtils.isEmpty(ak.c()) == true) goto L11;
        if (TextUtils.isEmpty(ak.d()) == true) goto L11;
        al.b();
        al.e(r100);
        al.c();
        ak.c(r101);
        return true;
    }

    public final void b(String r100) {
        ai.a(this.f462054a, r100);
    }
}
