package kta;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class r implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f506123a = null;

    public static class a extends pta.e<Boolean> {
        public a() {
        }

        @Override // pta.e
        public final Boolean a(Object[] r100) {
            return Boolean.valueOf("1".equals(r.c()));
        }
    }

    static {
        f506123a = new a();
    }

    public static String c() {
        return SystemProperties.get(com.alipay.sdk.m.p0.c.f25694c, "0");
    L8:
        return "0";
    }

    public r() {
    }

    @Override // kta.o
    public final boolean a(Context r100) {
        return f506123a.b(new Object[0]).booleanValue();
    }

    @Override // kta.o
    public final o.a getOaid(Context r100) {
        o.a r101 = new o.a();
        r101.f506112a = query(r100, 0, null);
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
        Cursor r104 = null;
        if (r101 != 0) goto L5;
        Uri r105 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
    L12:
        if (r105 != null) goto L50;
    L42:
        return r103;
    L50:
        Cursor r106 = b(r100.getContentResolver(), r105);     // Catch: Throwable -> L26 Exception -> L28
        if (r106 != null) goto L47;
    L21:
        if (r106 == null) goto L42;
    L43:
        r106.close();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L47:
    L19:
        Exception e100 = e;
    L30:
        e100.printStackTrace();     // Catch: Throwable -> L34
        if (r106 == null) goto L42;
    L34:
        th = move-exception;
        r104 = r106;
        th = th;
    L36:
        if (r104 != null) goto L45;
    L41:
        throw th;
    L45:
        r104.close();     // Catch: Exception -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L41
    L16:
        if (r106.moveToNext() == false) goto L21;
        r103 = r106.getString(r106.getColumnIndex("value"));     // Catch: Exception -> L19 Throwable -> L34
        goto L21
    L28:
        e = move-exception;
        e100 = e;
        r106 = null;
    L26:
        th = th;
        goto L36
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
