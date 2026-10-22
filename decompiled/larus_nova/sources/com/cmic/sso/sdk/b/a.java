package com.cmic.sso.sdk.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.SubscriptionManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.m;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f06.b;
import f06.d;

/* JADX INFO: loaded from: classes22.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f273346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f273347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C3820a f273348c;

    /* JADX INFO: renamed from: com.cmic.sso.sdk.b.a$a, reason: collision with other inner class name */
    public static class C3820a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f273349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f273350b;

        public C3820a() {
            this.f273349a = -1;
            this.f273350b = -1;
        }

        public int a() {
            return this.f273350b;
        }

        public static /* synthetic */ int a(C3820a r100) {
            return r100.f273350b;
        }

        public static /* synthetic */ int b(C3820a r100) {
            return r100.f273349a;
        }

        public static /* synthetic */ int a(C3820a r100, int r101) {
            r100.f273349a = r101;
            return r101;
        }

        public static /* synthetic */ int b(C3820a r100, int r101) {
            r100.f273350b = r101;
            return r101;
        }
    }

    public static a a() {
        if (f273346a != null) goto L6;
        f273346a = new a();
    L6:
        return f273346a;
    }

    public C3820a b() {
        C3820a r100 = this.f273348c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new C3820a();
    }

    private a() {
        this.f273348c = null;
    }

    private void a(Context r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 22) goto L28;
        SubscriptionManager r102 = SubscriptionManager.from(r100.getApplicationContext());
        if (r102 == null) goto L36;
    L12:
        c.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
    L32:
        Object r103 = r102.getClass().getMethod("getDefaultDataSubId", new Class[0]).invoke(r102, new Object[0]);     // Catch: Exception -> L20
        if ((r103 instanceof Integer) == false) goto L17;
    L18:
        C3820a.b(this.f273348c, ((Integer) r103).intValue());     // Catch: Exception -> L20
        c.b("UMCTelephonyManagement", "android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = " + C3820a.a(this.f273348c));     // Catch: Exception -> L20
        return;
    L17:
        if ((r103 instanceof Long) == true) goto L18;
    L30:
        Object r104 = r102.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(r102, new Object[0]);     // Catch: Exception -> L27
        if ((r104 instanceof Integer) == false) goto L24;
    L25:
        C3820a.b(this.f273348c, ((Integer) r104).intValue());     // Catch: Exception -> L27
        c.b("UMCTelephonyManagement", "反射getDefaultDataSubscriptionId适配成功: dataSubId = " + C3820a.a(this.f273348c));     // Catch: Exception -> L27
        return;
    L24:
        if ((r104 instanceof Long) == true) goto L25;
        return;
    L27:
        c.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
        return;
    L20:
        c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
        goto L30
    L7:
        if (C3820a.b(this.f273348c) != (-1)) goto L32;
        if (r101 < 24) goto L32;
        C3820a.b(this.f273348c, SubscriptionManager.getDefaultDataSubscriptionId());     // Catch: Exception -> L12
        c.b("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = " + C3820a.a(this.f273348c));     // Catch: Exception -> L12
        return;
    L36:
        return;
    L28:
        C3820a.a(this.f273348c, -1);
    }

    private void b(Context r110) {
        c.b("UMCTelephonyManagement", "readSimInfoDbStart");
        Uri r100 = UriProtector.parse("content://telephony/siminfo");
        ContentResolver r101 = r110.getContentResolver();
        Cursor r111 = null;
        r111 = com_cmic_sso_sdk_b_a_android_content_ContentResolver_query(r101, r100, new String[]{DBDefinition.ID, "sim_id"}, "sim_id>=?", new String[]{"0"}, null);     // Catch: Exception -> L20 Throwable -> L25
        if (r111 == null) goto L18;
    L5:
        if (r111.moveToNext() == false) goto L18;
        int r102 = r111.getInt(r111.getColumnIndex("sim_id"));     // Catch: Exception -> L20 Throwable -> L25
        int r103 = r111.getInt(r111.getColumnIndex(DBDefinition.ID));     // Catch: Exception -> L20 Throwable -> L25
        if (C3820a.b(this.f273348c) != (-1)) goto L15;
        if (C3820a.a(this.f273348c) == (-1)) goto L15;
        if (C3820a.a(this.f273348c) != r103) goto L15;
        C3820a.a(this.f273348c, r102);     // Catch: Exception -> L20 Throwable -> L25
        c.b("UMCTelephonyManagement", "通过读取sim db获取数据流量卡的卡槽值：" + r102);     // Catch: Exception -> L20 Throwable -> L25
    L15:
        if (C3820a.b(this.f273348c) != r102) goto L5;
        C3820a.b(this.f273348c, r103);     // Catch: Exception -> L20 Throwable -> L25
        goto L5
    L18:
        if (r111 != null) goto L22;
    L23:
        c.b("UMCTelephonyManagement", "readSimInfoDbEnd");
        return;
    L22:
        r111.close();
    L25:
        th = move-exception;
        if (r111 == null) goto L28;
        r111.close();
    L28:
        throw th;
    L20:
        c.a("UMCTelephonyManagement", "readSimInfoDb error");     // Catch: Throwable -> L25
        if (r111 == null) goto L23;
        goto L22
    }

    public void a(Context r100, boolean r101) {
        long r102 = System.currentTimeMillis() - f273347b;
        if (r102 < 5000) goto L5;
    L7:
        this.f273348c = new C3820a();
        if (r101 == true) goto L10;
        return;
    L10:
        a(r100);
        if (m.e() == true) goto L15;
        if (m.f() == true) goto L15;
    L29:
        f273347b = System.currentTimeMillis();
        return;
    L15:
        if (m.d() == false) goto L29;
        c.b("UMCTelephonyManagement", "华为手机兼容性处理");
        if (C3820a.a(this.f273348c) == 0) goto L21;
        if (C3820a.a(this.f273348c) == 1) goto L21;
    L25:
        if (C3820a.b(this.f273348c) == (-1)) goto L27;
    L28:
        b(r100);
        goto L29
    L27:
        if (C3820a.a(this.f273348c) == (-1)) goto L29;
    L21:
        if (C3820a.b(this.f273348c) != (-1)) goto L23;
        C3820a r103 = this.f273348c;
        C3820a.a(r103, C3820a.a(r103));
    L23:
        C3820a.b(this.f273348c, -1);
        goto L25
    L5:
        if (r102 <= 0) goto L7;
    }

    private static Cursor com_cmic_sso_sdk_b_a_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
