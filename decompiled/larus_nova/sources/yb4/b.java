package yb4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qb4.n;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f567093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f567094b;

    static {
        f567093a = new b();
    }

    public b() {
    }

    public static SQLiteDatabase a() {
        a r100 = f567094b;     // Catch: Exception -> L6
        if (r100 == null) goto L8;
        return r100.getWritableDatabase();
    L8:
        return null;
    L6:
        e = move-exception;
        int r101 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        goto L8
    }

    public final String b() {
        return query("settings");
    }

    private final int delete(int r100) {
        monitor-enter(this);
        int r101 = n.f532367a;     // Catch: Throwable -> L14
        SQLiteDatabase r102 = a();     // Catch: Throwable -> L14
        int r103 = 0;
        if (r102 != null) goto L19;
    L9:
        Integer r104 = null;
    L10:
        if (r104 == null) goto L12;
        r103 = r104.intValue();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r103;
    L19:
        r104 = Integer.valueOf(r102.delete("h5_storage", "id=?", new String[]{String.valueOf(r100)}));     // Catch: Exception -> L8 Throwable -> L14
    L8:
        int r105 = n.f532367a;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private final String query(String r110) {
        monitor-enter(this);
        int r100 = n.f532367a;     // Catch: Throwable -> L33
        SQLiteDatabase r101 = a();     // Catch: Throwable -> L33
        boolean r111 = true;
        Cursor r112 = null;
        String r113 = null;
        r113 = null;
        r113 = null;
        if (r101 != null) goto L46;
        Cursor r114 = null;
    L12:
        if (r114 != null) goto L44;
    L19:
        r111 = false;
    L20:
        if (r111 == false) goto L29;
        r113 = r114.getString(0);     // Catch: Throwable -> L16 Exception -> L18
    L16:
        th = move-exception;
        r112 = r114;
        th = th;
    L24:
        if (r112 != null) goto L42;
    L26:
        throw th;     // Catch: Throwable -> L33
    L42:
        r112.close();     // Catch: Throwable -> L37
    L27:
        if (r114 != null) goto L38;
    L31:
        monitor-exit(this);
        return r113;
    L38:
        r114.close();     // Catch: Throwable -> L36
    L29:
        if (r114 == null) goto L31;
    L44:
        if (r114.moveToFirst() != true) goto L19;
    L46:
        r114 = r101.query("h5_storage", new String[]{"content"}, "primary_key=?", new String[]{r110}, null, null, null, "1");     // Catch: Throwable -> L8 Exception -> L10
    L10:
        r114 = null;
    L8:
        th = th;
    L33:
        th = move-exception;
        throw th;
    }

    public final void c(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        int r101 = n.f532367a;     // Catch: Throwable -> L25
        ContentValues r102 = new ContentValues();     // Catch: Throwable -> L25
        r102.put("primary_key", "settings");     // Catch: Throwable -> L25
        r102.put("time_stamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L25
        r102.put("content", r100);     // Catch: Throwable -> L25
        SQLiteDatabase r103 = a();     // Catch: Throwable -> L25
        Long r104 = null;
        if (r103 != null) goto L30;
        Long r105 = null;
    L11:
        if (r105 != null) goto L32;
    L21:
        if (r105 == null) goto L23;
        r105.longValue();     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L32:
    L18:
        r104 = r105;
    L19:
        int r106 = n.f532367a;     // Catch: Throwable -> L25
    L20:
        r105 = r104;
        goto L21
    L14:
        if (r105.longValue() != 0) goto L21;
        if (r103 == null) goto L20;
        r104 = Long.valueOf(r103.insert("h5_storage", null, r102));     // Catch: Exception -> L18 Throwable -> L25
        goto L20
    L30:
        r105 = Long.valueOf(r103.update("h5_storage", r102, "primary_key=?", new String[]{"settings"}));     // Catch: Exception -> L29 Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public final long insert(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "content");
        monitor-enter(this);
        int r102 = n.f532367a;     // Catch: Throwable -> L16
        SQLiteDatabase r103 = a();     // Catch: Throwable -> L16
        Long r104 = null;
        if (r103 != null) goto L21;
    L10:
        if (r104 == null) goto L13;
        long r105 = r104.longValue();     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return r105;
    L13:
        r105 = -1;
        goto L14
    L21:
        ContentValues r106 = new ContentValues();     // Catch: Exception -> L9 Throwable -> L16
        r106.put("primary_key", r100);     // Catch: Exception -> L9 Throwable -> L16
        r106.put("time_stamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L9 Throwable -> L16
        r106.put("content", r101);     // Catch: Exception -> L9 Throwable -> L16
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L9 Throwable -> L16
        r104 = Long.valueOf(r103.insert("h5_storage", null, r106));     // Catch: Exception -> L9 Throwable -> L16
    L9:
        int r108 = n.f532367a;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }
}
