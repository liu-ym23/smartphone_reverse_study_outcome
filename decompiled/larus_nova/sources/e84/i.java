package e84;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f471309a;

    public class a extends i84.r<Boolean> {
        public a() {
        }

        @Override // i84.r
        public final Boolean a(Object[] r100) {
            boolean r101 = false;
            PackageManager r102 = ((Context) r100[0]).getPackageManager();     // Catch: Exception -> L12
            if (r102 == null) goto L11;
            if (r102.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) goto L8;
            r101 = true;
        L8:
            return Boolean.valueOf(r101);
        L11:
            return Boolean.FALSE;
        }
    }

    @Override // e84.m
    public final String getName() {
        return "Meizu";
    }

    public i() {
        this.f471309a = new a();
    }

    @Override // e84.m
    public final boolean a(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return this.f471309a.b(new Object[]{r100}).booleanValue();
    }

    @Override // e84.m
    public final m.a getOaid(Context r100) {
        Cursor r101 = b(r100.getContentResolver(), UriProtector.parse("content://com.meizu.flyme.openidsdk/"), new String[]{"oaid"});     // Catch: Throwable -> L20
        if (r101 != null) goto L30;
        if (r101 == null) goto L7;
        r101.close();
    L7:
        return null;
    L30:
        m.a r102 = new m.a();     // Catch: Throwable -> L18
        if (r101.isClosed() == true) goto L14;
        r101.moveToFirst();     // Catch: Throwable -> L18
        int r103 = r101.getColumnIndex("value");     // Catch: Throwable -> L18
        if (r103 < 0) goto L14;
        String r104 = r101.getString(r103);     // Catch: Throwable -> L18
    L15:
        r102.f471323a = r104;     // Catch: Throwable -> L18
        r101.close();
        return r102;
    L14:
        r104 = null;
    L18:
        Throwable th10 = th;
    L34:
        th10.printStackTrace();     // Catch: Throwable -> L26
        if (r101 == null) goto L25;
        r101.close();
    L25:
        return null;
    L26:
        th = move-exception;
        if (r101 == null) goto L29;
        r101.close();
    L29:
        throw th;
    L20:
        th = move-exception;
        th10 = th;
        r101 = null;
        goto L34
    }

    public static Cursor b(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, r112, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, null, null, r112, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }
}
