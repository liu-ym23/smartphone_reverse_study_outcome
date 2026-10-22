package lfc;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class n implements kfc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f509108b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f509109a;

    static {
        f509108b = new String[]{DBDefinition.ID, "class"};
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.sec.android.app.launcher", "com.sec.android.app.twlauncher"});
    }

    public n() {
        this.f509109a = new d();
    }

    public static void c(ContentResolver r110, Uri r111, ContentValues r210) throws RedBadgerException {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L20;
        Uri r108 = (Uri) r107.f474983b;
        return;
    L20:
        r110.insert(r111, r210);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static ContentValues f(ComponentName r100, int r101, boolean r102) {
        ContentValues r103 = new ContentValues();
        if (r102 == false) goto L5;
        r103.put("package", r100.getPackageName());
        r103.put("class", r100.getClassName());
    L5:
        r103.put("badgecount", Integer.valueOf(r101));
        return r103;
    }

    @Override // kfc.a
    public final void a(Context r110, ComponentName r111, int r112) throws RedBadgerException {
        if (r110 == null) goto L38;
        if (r111 != null) goto L6;
        return;
    L6:
        if (r112 >= 0) goto L9;
        r112 = 0;
    L9:
        if (this.f509109a != null) goto L11;
    L13:
        Uri r100 = UriProtector.parse("content://com.sec.badge/apps?notify=true");
        ContentResolver r113 = r110.getContentResolver();
        Cursor r101 = null;
        r101 = d(r113, r100, f509108b, new String[]{r111.getPackageName()});     // Catch: Throwable -> L29
        if (r101 == null) goto L24;
        String r102 = r111.getClassName();     // Catch: Throwable -> L29
        boolean r103 = false;
    L18:
        if (r101.moveToNext() == false) goto L22;
        int r104 = r101.getInt(0);     // Catch: Throwable -> L29
        e(r113, r100, f(r111, r112, false), new String[]{String.valueOf(r104)});     // Catch: Throwable -> L29
        if (r102.equals(r101.getString(r101.getColumnIndex("class"))) == false) goto L18;
        r103 = true;
        goto L18
    L22:
        if (r103 == true) goto L24;
        c(r113, r100, f(r111, r112, true));     // Catch: Throwable -> L29
    L24:
        if (r101 != null) goto L26;
        return;
    L26:
        if (r101.isClosed() == true) goto L50;
        r101.close();
        return;
    L50:
        return;
    L29:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L32
        throw new RedBadgerException(th.getMessage());     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        if (r101 != null) goto L35;
    L37:
        throw th;
    L35:
        if (r101.isClosed() == true) goto L37;
        r101.close();
        goto L37
    L11:
        if (nfc.a.a(r110, new Intent("android.intent.action.BADGE_COUNT_UPDATE")) == false) goto L13;
        this.f509109a.a(r110, r111, r112);
        return;
    }

    public static Cursor d(ContentResolver r110, Uri r111, String[] r112, String[] r113) throws RedBadgerException {
        f06.c r114 = new f06.c();
        Object[] r115 = {r111, r112, "package=?", r113, null};
        f06.b r116 = new f06.b();
        f06.d r100 = r114.b(240004, "android/content/ContentResolver", "query", r110, r115, "android.database.Cursor", r116);
        if (r100.f474982a == false) goto L6;
        r114.a(240004, "android/content/ContentResolver", "query", r110, r115, null, r116, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, r112, "package=?", r113, null);
        r114.a(240004, "android/content/ContentResolver", "query", r110, r115, r101, r116, true);
        return r101;
    }

    public static void e(ContentResolver r210, Uri r211, ContentValues r212, String[] r213) throws RedBadgerException {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, r212, "_id=?", r213};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240018);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r112 = r111.length;
        int r113 = 0;
    L8:
        if (r113 >= r112) goto L15;
        f06.a r104 = r111[r113];
        int r114 = r113;
        int r214 = r112;
        f06.a[] r215 = r111;
        f06.d r105 = r104.preInvoke(240018, "android/content/ContentResolver", "update", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r105.f474982a == true) goto L17;
        r100.add(r104);     // Catch: Exception -> L22
    L17:
        if (r105.f474982a == false) goto L20;
        ((Integer) r105.f474983b).intValue();
        return;
    L20:
        r210.update(r211, r212, "_id=?", r213);
        return;
    L14:
        r113 = r114 + 1;
        r112 = r214;
        r111 = r215;
        goto L8
    L15:
        r105 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
