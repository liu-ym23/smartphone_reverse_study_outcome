package e84;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f471340a = null;

    public static class a extends i84.r<Boolean> {
        public a() {
        }

        @Override // i84.r
        public final Boolean a(Object[] r100) {
            return Boolean.valueOf("1".equals(q.c()));
        }
    }

    @Override // e84.m
    public final String getName() {
        return "Vivo";
    }

    static {
        f471340a = new a();
    }

    public static String c() {
        return SystemProperties.get(com.alipay.sdk.m.p0.c.f25694c, "0");
    L8:
        return "0";
    }

    public q() {
    }

    @Override // e84.m
    public final boolean a(Context r100) {
        return f471340a.b(new Object[0]).booleanValue();
    }

    @Override // e84.m
    public final m.a getOaid(Context r100) {
        m.a r101 = new m.a();
        r101.f471323a = query(r100, 0, null);
        return r101;
    }

    public static Cursor b(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, null, null};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
        return (Cursor) r113.f474983b;
    L6:
        Cursor r114 = r110.query(r111, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
        return r114;
    }

    private static String query(Context r100, int r101, String r102) {
        String r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        Cursor r104 = null;
        if (r101 != 0) goto L5;
        Uri r105 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
    L12:
        if (r105 != null) goto L55;
    L45:
        return r103;
    L55:
        Cursor r106 = b(r100.getContentResolver(), r105);     // Catch: Throwable -> L26 Exception -> L28
        if (r106 != null) goto L46;
    L21:
        if (r106 == null) goto L45;
        r106.close();     // Catch: Exception -> L24
    L24:
        e = e;
        e.printStackTrace();
        StringBuilder r107 = new StringBuilder("OaidVivo#query close cursor exception.");
    L36:
        r107.append(e);
        com.bytedance.bdinstall.t.a(r107.toString());
        goto L45
    L46:
    L19:
        Exception e100 = e;
    L30:
        e100.printStackTrace();     // Catch: Throwable -> L37
        com.bytedance.bdinstall.t.a("OaidVivo#query" + e100);     // Catch: Throwable -> L37
        if (r106 == null) goto L45;
        r106.close();     // Catch: Exception -> L34
    L34:
        e = e;
        e.printStackTrace();
        r107 = new StringBuilder("OaidVivo#query close cursor exception.");
    L37:
        th = move-exception;
        r104 = r106;
        th = th;
    L39:
        if (r104 != null) goto L50;
    L44:
        throw th;
    L50:
        r104.close();     // Catch: Exception -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.bdinstall.t.a("OaidVivo#query close cursor exception." + e);
        goto L44
    L16:
        if (r106.moveToNext() == false) goto L21;
        r103 = r106.getString(r106.getColumnIndex("value"));     // Catch: Exception -> L19 Throwable -> L37
        goto L21
    L28:
        e = move-exception;
        e100 = e;
        r106 = null;
    L26:
        th = th;
        goto L39
    L5:
        if (r101 != 1) goto L7;
        r105 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + r102);
        goto L12
    L7:
        if (r101 == 2) goto L9;
        r105 = null;
        goto L12
    L9:
        r105 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + r102);
        goto L12
    }
}
