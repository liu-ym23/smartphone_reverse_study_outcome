package com.cmic.ida.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;

/* JADX INFO: loaded from: classes22.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f273109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f273110b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f273111c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f273112d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f273113e = -1;

    public class a extends q0.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f273114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f273115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f273116d;

        @Override // com.cmic.ida.sdk.q0.a
        public void a() {
            u.a("PhoneScripUtils", "start save scrip to sp in sub thread");
            f0.a(this.f273114b, this.f273115c, f0.a(), this.f273116d);
        }

        public a(Context r100, String r101, String r102) {
            this.f273114b = r100;
            this.f273115c = r101;
            this.f273116d = r102;
        }
    }

    private static boolean b() {
        if (TextUtils.isEmpty(f273109a) == true) goto L6;
        u.a("PhoneScripUtils", f273110b + " " + f273112d);
        return a(f273112d);
    L6:
        String r100 = n0.a("phonescripcache", "");
        long r101 = n0.a("phonescripstarttime", 0);
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L11:
        return false;
    L9:
        if (a(r101) == false) goto L11;
        return true;
    }

    public static /* synthetic */ long a() {
        return f273112d;
    }

    public static boolean a(g r100) {
        int r101 = a(r100.b("scripKey"));
        r100.b("imsiState", r101 + "");
        StringBuilder r102 = new StringBuilder("simState = ");
        r102.append(r101);
        u.a("PhoneScripUtils", r102.toString());
        if (r101 != 0) goto L6;
        return false;
    L6:
        if (f273113e != (-1)) goto L9;
        f273113e = n0.a("phonescripversion", -1);
    L9:
        if (f273113e == 1) goto L13;
        a(true, false);
        q.a();
        u.a("PhoneScripUtils", "phoneScriptVersion change");
        return false;
    L13:
        if (r101 != 2) goto L17;
        a(true, false);
        return false;
    L17:
        return b();
    }

    public static int b(String r100) {
        u.b("PhoneScripUtils", " getUuidPreSimState currentSimKey" + r100);
        u.b("PhoneScripUtils", "sUuidSimKey " + f273111c);
        if (TextUtils.isEmpty(f273111c) == true) goto L5;
        String r101 = f273111c;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return 0;
    L11:
        if (r101.equals(r100) == false) goto L14;
        return 1;
    L14:
        return 2;
    L5:
        r101 = n0.a("uuid_pre_sim_key", "");
        u.b("PhoneScripUtils", "getUuidPreSimState oldSimKey" + r101);
        f273111c = r101;
        goto L7
    }

    public static void c(String r100) {
        f273111c = r100;
        u.b("doRealTransmitRequest", "save uuidPreSimKey " + r100);
        n0.b("uuid_pre_sim_key", r100);
    }

    public static int a(String r100) {
        u.b("PhoneScripUtils", "getPreSimState currentSimKey" + r100);
        u.b("PhoneScripUtils", "sSimKey" + f273110b);
        if (TextUtils.isEmpty(f273110b) == true) goto L5;
        String r101 = f273110b;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return 0;
    L11:
        if (r101.equals(r100) == false) goto L14;
        return 1;
    L14:
        return 2;
    L5:
        r101 = n0.a("pre_sim_key", "");
        u.b("PhoneScripUtils", "getPreSimState oldSimKey" + r101);
        f273110b = r101;
        goto L7
    }

    private static boolean a(long r100) {
        long r101 = System.currentTimeMillis();
        u.a("PhoneScripUtils", r100 + "");
        u.a("PhoneScripUtils", r101 + "");
        StringBuilder r102 = new StringBuilder();
        long r103 = r100 - r101;
        r102.append(r103);
        r102.append("");
        u.a("PhoneScripUtils", r102.toString());
        if (r103 <= 60000) goto L5;
        return true;
    L5:
        return false;
    }

    public static String a(Context r100) {
        if (TextUtils.isEmpty(f273109a) == false) goto L11;
        String r101 = n0.a("phonescripcache", "");
        if (TextUtils.isEmpty(r101) == false) goto L8;
        u.b("PhoneScripUtils", "null");
        return null;
    L8:
        f273112d = n0.a("phonescripstarttime", 0);
        f273110b = n0.a("pre_sim_key", "");
        f273113e = n0.a("phonescripversion", -1);
        String r102 = q.a(r100, r101);
        f273109a = r102;
        return r102;
    L11:
        return f273109a;
    }

    public static void a(boolean r100, boolean r101) {
        u.b("PhoneScripUtils", "deletePhoneScrip");
        n0.a r102 = n0.a();
        r102.a("phonescripstarttime");
        r102.a("phonescripcache");
        r102.a("securityphonecache");
        r102.a("pre_sim_key");
        r102.a("phonescripversion");
        if (r101 == false) goto L5;
        r102.a();
    L6:
        if (r100 == false) goto L9;
        f273109a = null;
        f273110b = null;
        f273112d = 0;
        f273113e = -1;
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
        String r104 = q.b(r100, r101);
        if (TextUtils.isEmpty(r104) == true) goto L6;
        n0.a r105 = n0.a();
        r105.a("phonescripcache", r104);
        r105.a("phonescripstarttime", r102);
        r105.a("phonescripversion", 1);
        r105.a("pre_sim_key", r103);
        r105.b();
        return;
    }

    public static void a(Context r100, String r101, long r102, String r110, String r111) {
        u.a("PhoneScripUtils", "savePhoneScrip");
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r110) == false) goto L7;
        return;
    L7:
        if (r102 <= 0) goto L18;
        u.a("PhoneScripUtils", "save phone scrip simKey = " + r110);
        f273109a = r101;
        long r103 = 1000 * r102;
        f273112d = r103;
        u.a("lifeTime", r102 + "");
        u.a("sLifeTime", f273112d + "");
        f273110b = r110;
        f273113e = 1;
        if (OnekeyLoginConstants.CU_KEY_OPERATOR.equals(r111) == true) goto L12;
        q0.a(new a(r100, r101, r110));
        return;
    L12:
        if ((r103 - System.currentTimeMillis()) <= 3600000) goto L14;
        u.a("PhoneScripUtils", "缓存只存内存");
        f273112d = System.currentTimeMillis() + 3600000;
        return;
    L14:
        f273112d = r103;
        return;
    }
}
