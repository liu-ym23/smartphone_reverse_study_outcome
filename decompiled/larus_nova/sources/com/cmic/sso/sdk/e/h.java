package com.cmic.sso.sdk.e;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;

/* JADX INFO: loaded from: classes22.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f273493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f273494b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f273495c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f273496d = -1;

    private static boolean c() {
        if (TextUtils.isEmpty(f273493a) == true) goto L6;
        c.b("PhoneScripUtils", f273494b + " " + f273495c);
        return a(f273495c);
    L6:
        String r100 = k.b("phonescripcache", "");
        long r101 = k.a("phonescripstarttime", 0);
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L11:
        return false;
    L9:
        if (a(r101) == false) goto L11;
        return true;
    }

    public static long a() {
        long r100 = System.currentTimeMillis();
        if (TextUtils.isEmpty(f273493a) == true) goto L6;
        c.b("PhoneScripUtils", f273494b + " " + f273495c);
        long r101 = f273495c;
    L5:
        long r102 = (r101 - r100) - 10000;
    L11:
        return Math.max(r102 / 1000, 0);
    L6:
        String r103 = k.b("phonescripcache", "");
        r101 = k.a("phonescripstarttime", 0);
        if (TextUtils.isEmpty(r103) == false) goto L5;
        r102 = 0;
        goto L11
    }

    public static /* synthetic */ long b() {
        return f273495c;
    }

    public static boolean a(com.cmic.sso.sdk.a r100) {
        int r101 = a(r100.b("scripKey"));
        r100.a("imsiState", r101 + "");
        StringBuilder r102 = new StringBuilder("simState = ");
        r102.append(r101);
        c.b("PhoneScripUtils", r102.toString());
        if (r101 != 0) goto L6;
        return false;
    L6:
        if (f273496d != (-1)) goto L9;
        f273496d = k.a("phonescripversion", -1);
    L9:
        if (f273496d == 2) goto L12;
        a(true, false);
        b.a();
        c.b("PhoneScripUtils", "phoneScriptVersion change");
        return false;
    L12:
        if (r101 != 2) goto L16;
        a(true, false);
        return false;
    L16:
        return c();
    }

    public static String a(Context r100) {
        if (TextUtils.isEmpty(f273493a) == false) goto L11;
        String r101 = k.b("phonescripcache", "");
        if (TextUtils.isEmpty(r101) == false) goto L8;
        c.a("PhoneScripUtils", "null");
        return null;
    L8:
        f273495c = k.a("phonescripstarttime", 0);
        f273494b = k.b("pre_sim_key", "");
        f273496d = k.a("phonescripversion", -1);
        String r102 = b.b(r100, r101);
        f273493a = r102;
        return r102;
    L11:
        return f273493a;
    }

    private static boolean a(long r100) {
        long r101 = System.currentTimeMillis();
        c.b("PhoneScripUtils", r100 + "");
        c.b("PhoneScripUtils", r101 + "");
        if ((r100 - r101) <= 10000) goto L5;
        return true;
    L5:
        return false;
    }

    private static int a(String r100) {
        if (TextUtils.isEmpty(f273494b) == true) goto L5;
        String r101 = f273494b;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return 0;
    L11:
        if (r101.equals(r100) == false) goto L14;
        return 1;
    L14:
        return 2;
    L5:
        r101 = k.b("pre_sim_key", "");
        f273494b = r101;
        goto L7
    }

    public static void a(boolean r100, boolean r101) {
        k.a r102 = k.a();
        r102.a("phonescripstarttime");
        r102.a("phonescripcache");
        r102.a("pre_sim_key");
        r102.a("phonescripversion");
        if (r101 == false) goto L5;
        r102.a();
    L6:
        if (r100 == false) goto L9;
        f273493a = null;
        f273494b = null;
        f273495c = 0;
        f273496d = -1;
        return;
    L9:
        return;
    L5:
        r102.b();
        goto L6
    }

    public static /* synthetic */ void a(Context r100, String r101, long r102, String r103) {
        b(r100, r101, r102, r103);
    }

    private static void b(Context r100, String r101, long r102, String r103) {
        String r104 = b.a(r100, r101);
        if (TextUtils.isEmpty(r104) == true) goto L6;
        k.a r105 = k.a();
        r105.a("phonescripcache", r104);
        r105.a("phonescripstarttime", r102);
        r105.a("phonescripversion", 2);
        r105.a("pre_sim_key", r103);
        r105.b();
        return;
    }

    public static void a(final Context r100, final String r101, long r102, final String r103, String r104) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r103) == false) goto L7;
        return;
    L7:
        if (r102 <= 0) goto L18;
        c.b("PhoneScripUtils", "save phone scrip simKey = " + r103);
        f273493a = r101;
        long r105 = r102 * 1000;
        f273495c = System.currentTimeMillis() + r105;
        c.b("sLifeTime", f273495c + "");
        f273494b = r103;
        f273496d = 2;
        if (OnekeyLoginConstants.CU_KEY_OPERATOR.equals(r104) == true) goto L12;
        n.a(new AnonymousClass1(r100, r101, r103));
        return;
    L12:
        if (r105 <= 3600000) goto L14;
        f273495c = System.currentTimeMillis() + 3600000;
        return;
    L14:
        f273495c = System.currentTimeMillis() + r105;
        return;
    }
}
