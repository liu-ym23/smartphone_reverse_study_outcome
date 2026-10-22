package com.xiaomi.push;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes41.dex */
class ap implements ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f463142a = "content://com.vivo.vms.IdProvider/IdentifierId/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f463143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f463144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f463145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f463146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f463147f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f247a;

    static {
        f463143b = f463142a + "OAID";
        f463144c = f463142a + "VAID_";
        f463145d = f463142a + "AAID_";
        f463146e = f463142a + com.alipay.sdk.m.p0.b.f25686h;
        f463147f = com.alipay.sdk.m.p0.c.f25694c;
    }

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a */
    public boolean mo8805a() {
        return "1".equals(p.a(f463147f, "0"));
    }

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a */
    public String mo8804a() {
        return a(f463143b);
    }

    public ap(Context r100) {
        this.f247a = r100;
    }

    private String a(String r110) {
        String r100 = null;
        Cursor r111 = com_xiaomi_push_ap_android_content_ContentResolver_query(this.f247a.getContentResolver(), Uri.parse(r110), null, null, null, null);     // Catch: Throwable -> L14 Exception -> L19
        if (r111 != null) goto L25;
    L12:
        if (r111 == null) goto L22;
    L13:
        r111.close();
    L22:
        return r100;
    L25:
    L9:
        Throwable th10 = th;
    L16:
        if (r111 == null) goto L18;
        r111.close();
    L18:
        throw th10;
    L6:
        if (r111.moveToNext() == false) goto L12;
        r100 = r111.getString(r111.getColumnIndex("value"));     // Catch: Throwable -> L9 Exception -> L11
    L20:
        if (r111 == null) goto L22;
    L19:
        r111 = null;
    L14:
        th = move-exception;
        th10 = th;
        r111 = null;
        goto L16
    }

    public static boolean a(Context r100) {
        ProviderInfo r101 = r100.getPackageManager().resolveContentProvider(UriProtector.parse(f463142a).getAuthority(), 128);     // Catch: Exception -> L13
        if (r101 == null) goto L12;
        if ((r101.applicationInfo.flags & 1) == 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return true;
    L9:
        r102 = false;
    L12:
        return false;
    }

    private static Cursor com_xiaomi_push_ap_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
