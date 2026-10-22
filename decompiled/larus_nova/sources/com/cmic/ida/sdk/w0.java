package com.cmic.ida.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.SubscriptionManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;

/* JADX INFO: loaded from: classes22.dex */
public class w0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static w0 f273261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f273262c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f273263a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f273264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f273265b;

        public a() {
            this.f273264a = -1;
            this.f273265b = -1;
        }

        public int a() {
            return this.f273265b;
        }

        public static /* synthetic */ int a(a r100) {
            return r100.f273265b;
        }

        public static /* synthetic */ int b(a r100) {
            return r100.f273264a;
        }

        public static /* synthetic */ int a(a r100, int r101) {
            r100.f273265b = r101;
            return r101;
        }

        public static /* synthetic */ int b(a r100, int r101) {
            r100.f273264a = r101;
            return r101;
        }
    }

    public static w0 a() {
        if (f273261b != null) goto L6;
        f273261b = new w0();
    L6:
        return f273261b;
    }

    public a b() {
        a r100 = this.f273263a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new a();
    }

    private w0() {
        this.f273263a = null;
    }

    private void a(Context r100) {
        u.b("UMCTelephonyManagement", "readDefaultDataSubId");
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 22) goto L28;
        SubscriptionManager r102 = SubscriptionManager.from(r100.getApplicationContext());
        if (r102 == null) goto L36;
    L12:
        u.b("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
    L32:
        Object r103 = r102.getClass().getMethod("getDefaultDataSubId", new Class[0]).invoke(r102, new Object[0]);     // Catch: Exception -> L20
        if ((r103 instanceof Integer) == false) goto L17;
    L18:
        a.a(this.f273263a, ((Integer) r103).intValue());     // Catch: Exception -> L20
        u.a("UMCTelephonyManagement", "android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = " + a.a(this.f273263a));     // Catch: Exception -> L20
        return;
    L17:
        if ((r103 instanceof Long) == true) goto L18;
    L30:
        Object r104 = r102.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(r102, new Object[0]);     // Catch: Exception -> L27
        if ((r104 instanceof Integer) == false) goto L24;
    L25:
        a.a(this.f273263a, ((Integer) r104).intValue());     // Catch: Exception -> L27
        u.a("UMCTelephonyManagement", "反射getDefaultDataSubscriptionId适配成功: dataSubId = " + a.a(this.f273263a));     // Catch: Exception -> L27
        return;
    L24:
        if ((r104 instanceof Long) == true) goto L25;
        return;
    L27:
        u.b("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
        return;
    L20:
        u.b("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
        goto L30
    L7:
        if (a.b(this.f273263a) != (-1)) goto L32;
        if (r101 < 24) goto L32;
        a.a(this.f273263a, SubscriptionManager.getDefaultDataSubscriptionId());     // Catch: Exception -> L12
        u.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = " + a.a(this.f273263a));     // Catch: Exception -> L12
        return;
    L36:
        return;
    L28:
        a.b(this.f273263a, -1);
    }

    private void b(Context r110) {
        u.a("UMCTelephonyManagement", "readSimInfoDbStart");
        Uri r100 = UriProtector.parse("content://telephony/siminfo");
        ContentResolver r101 = r110.getContentResolver();
        Cursor r111 = null;
        r111 = com_cmic_ida_sdk_w0_android_content_ContentResolver_query(r101, r100, new String[]{DBDefinition.ID, "sim_id"}, "sim_id>=?", new String[]{"0"}, null);     // Catch: Exception -> L20 Throwable -> L25
        if (r111 == null) goto L18;
    L5:
        if (r111.moveToNext() == false) goto L18;
        int r102 = r111.getInt(r111.getColumnIndex("sim_id"));     // Catch: Exception -> L20 Throwable -> L25
        int r103 = r111.getInt(r111.getColumnIndex(DBDefinition.ID));     // Catch: Exception -> L20 Throwable -> L25
        if (a.b(this.f273263a) != (-1)) goto L15;
        if (a.a(this.f273263a) == (-1)) goto L15;
        if (a.a(this.f273263a) != r103) goto L15;
        a.b(this.f273263a, r102);     // Catch: Exception -> L20 Throwable -> L25
        u.a("UMCTelephonyManagement", "通过读取sim db获取数据流量卡的卡槽值：" + r102);     // Catch: Exception -> L20 Throwable -> L25
    L15:
        if (a.b(this.f273263a) != r102) goto L5;
        a.a(this.f273263a, r103);     // Catch: Exception -> L20 Throwable -> L25
        goto L5
    L18:
        if (r111 != null) goto L22;
    L23:
        u.a("UMCTelephonyManagement", "readSimInfoDbEnd");
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
        u.b("UMCTelephonyManagement", "readSimInfoDb error");     // Catch: Throwable -> L25
        if (r111 == null) goto L23;
        goto L22
    }

    public void a(Context r100, boolean r101) {
        u.a("UMCTelephonyManagement", "updateTelephonyInfo");
        long r102 = System.currentTimeMillis() - f273262c;
        if (r102 < 5000) goto L5;
    L7:
        this.f273263a = new a();
        if (r101 == true) goto L10;
        return;
    L10:
        a(r100);
        if (p0.d() == true) goto L13;
    L27:
        f273262c = System.currentTimeMillis();
        return;
    L13:
        if (p0.e() == false) goto L27;
        u.a("UMCTelephonyManagement", "华为手机兼容性处理");
        if (a.a(this.f273263a) == 0) goto L19;
        if (a.a(this.f273263a) == 1) goto L19;
    L23:
        if (a.b(this.f273263a) == (-1)) goto L25;
    L26:
        b(r100);
        goto L27
    L25:
        if (a.a(this.f273263a) == (-1)) goto L27;
    L19:
        if (a.b(this.f273263a) != (-1)) goto L21;
        a r103 = this.f273263a;
        a.b(r103, a.a(r103));
    L21:
        a.a(this.f273263a, -1);
        goto L23
    L5:
        if (r102 <= 0) goto L7;
    }

    private static Cursor com_cmic_ida_sdk_w0_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
