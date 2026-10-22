package com.ss.ugc.effectplatform.preload;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import bytekn.foundation.logger.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f457434b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f457435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f457436d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f457437a;

    public static final class a {
        public a() {
        }

        public static b a(Object r100) {
            if (b.f457435c != null) goto L19;
            if (r100 == null) goto L19;
            if ((r100 instanceof Context) == false) goto L19;
            Object r101 = b.f457434b;
            monitor-enter(r101);
        L15:
            th = move-exception;
            throw th;
        L10:
            if (b.f457435c != null) goto L12;
            b.f457435c = new b(r100);     // Catch: Throwable -> L15
        L12:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L15
            monitor-exit(r101);
        L19:
            return b.f457435c;
        }
    }

    static {
        f457436d = new a();
        f457434b = new Object();
    }

    public final void b() {
        SQLiteDatabase r100 = this.f457437a;
        if (r100 == null) goto L26;
        r100.beginTransaction();
        SQLiteDatabase r101 = this.f457437a;     // Catch: Throwable -> L14 Exception -> L16
        if (r101 == null) goto L8;
        r101.delete("preload_table", null, null);     // Catch: Throwable -> L14 Exception -> L16
    L8:
        SQLiteDatabase r102 = this.f457437a;     // Catch: Throwable -> L14 Exception -> L16
        if (r102 == null) goto L11;
        r102.setTransactionSuccessful();     // Catch: Throwable -> L14 Exception -> L16
    L11:
        SQLiteDatabase r103 = this.f457437a;
        if (r103 == null) goto L21;
    L13:
        r103.endTransaction();
        return;
    L21:
        return;
    L14:
        th = move-exception;
        SQLiteDatabase r104 = this.f457437a;
        if (r104 == null) goto L25;
        r104.endTransaction();
    L25:
        throw th;
    L16:
        e = move-exception;
        Logger.INSTANCE.e("JKL", "[预加载][数据库][删除表-失败]", e);     // Catch: Throwable -> L14
        r103 = this.f457437a;
        if (r103 != null) goto L13;
        return;
    }

    public final List<c> f() {
        ArrayList r100 = new ArrayList();
        SQLiteDatabase r101 = this.f457437a;     // Catch: Exception -> L15
        if (r101 == null) goto L14;
        Cursor r102 = r101.rawQuery("select * from preload_table", null);     // Catch: Exception -> L15
        if (r102 == null) goto L14;
        if (r102.moveToFirst() == true) goto L10;
    L12:
        r102.close();     // Catch: Exception -> L15
    L17:
        return r100;
    L10:
        if (r102.isAfterLast() == true) goto L12;
        r100.add(new c(r102.getString(0), r102.getString(1), r102.getString(2), r102.getString(3), r102.getLong(4), r102.getString(5)));     // Catch: Exception -> L15
        r102.moveToNext();     // Catch: Exception -> L15
    L14:
        return r100;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public b(Object r100) {
        this.f457437a = new com.ss.ugc.effectplatform.preload.a(((Context) r100).getApplicationContext()).getReadableDatabase();
    }

    private final void insert(c r100) {
        SQLiteDatabase r101 = this.f457437a;     // Catch: Throwable -> L17 Exception -> L19
        if (r101 == null) goto L14;
        r101.beginTransaction();     // Catch: Throwable -> L17 Exception -> L19
        ContentValues r102 = new ContentValues();     // Catch: Throwable -> L17 Exception -> L19
        r102.put("file_name", r100.f457440a);     // Catch: Throwable -> L17 Exception -> L19
        r102.put("resource_key", r100.f457441b);     // Catch: Throwable -> L17 Exception -> L19
        r102.put("uri", r100.f457442c);     // Catch: Throwable -> L17 Exception -> L19
        r102.put("res_name", r100.f457443d);     // Catch: Throwable -> L17 Exception -> L19
        r102.put("last_access_time", Long.valueOf(r100.f457444e));     // Catch: Throwable -> L17 Exception -> L19
        r102.put("busi_key_list", r100.f457445f);     // Catch: Throwable -> L17 Exception -> L19
        SQLiteDatabase r103 = this.f457437a;     // Catch: Throwable -> L17 Exception -> L19
        if (r103 == null) goto L8;
        r103.insert("preload_table", null, r102);     // Catch: Throwable -> L17 Exception -> L19
    L8:
        Logger.INSTANCE.d("JKL", "[预加载][数据库][插入成功][" + r100 + ']');     // Catch: Throwable -> L17 Exception -> L19
        SQLiteDatabase r104 = this.f457437a;     // Catch: Throwable -> L17 Exception -> L19
        if (r104 == null) goto L11;
        r104.setTransactionSuccessful();     // Catch: Throwable -> L17 Exception -> L19
    L11:
        SQLiteDatabase r105 = this.f457437a;
        if (r105 == null) goto L24;
    L13:
        r105.endTransaction();
        return;
    L24:
        return;
    L14:
        if (r101 == null) goto L31;
        r101.endTransaction();
        return;
    L31:
        return;
    L17:
        th = move-exception;
        SQLiteDatabase r106 = this.f457437a;
        if (r106 == null) goto L28;
        r106.endTransaction();
    L28:
        throw th;
    L19:
        e = move-exception;
        Logger.INSTANCE.e("JKL", "[预加载][数据库][插入失败][" + r100 + ']', e);     // Catch: Throwable -> L17
        r105 = this.f457437a;
        if (r105 != null) goto L13;
    }

    public final boolean a(String r100) {
        SQLiteDatabase r101 = this.f457437a;
        boolean r102 = false;
        if (r101 == null) goto L14;
        Cursor r103 = r101.rawQuery("select * from preload_table where file_name=?", new String[]{r100});
        if (r103 == null) goto L14;
        r103.moveToFirst();
    L8:
        if (r103.isAfterLast() == true) goto L13;
        if (Intrinsics.areEqual(r103.getString(0), r100) == true) goto L11;
        r103.moveToNext();
        goto L8
    L11:
        r102 = true;
    L13:
        r103.close();
    L14:
        return r102;
    }

    public final void c(String r100) {
        SQLiteDatabase r101 = this.f457437a;
        if (r101 == null) goto L28;
        r101.beginTransaction();
    L18:
        e = move-exception;
        Logger.INSTANCE.e("JKL", "[预加载][数据库][删除-失败][" + r100 + ']', e);     // Catch: Throwable -> L16
        SQLiteDatabase r102 = this.f457437a;
        if (r102 == null) goto L33;
    L15:
        r102.endTransaction();
        return;
    L33:
        return;
    L16:
        th = move-exception;
        SQLiteDatabase r103 = this.f457437a;
        if (r103 == null) goto L27;
        r103.endTransaction();
    L27:
        throw th;
    L6:
        if (a(r100) == false) goto L10;
        SQLiteDatabase r104 = this.f457437a;     // Catch: Throwable -> L16 Exception -> L18
        if (r104 == null) goto L10;
        r104.delete("preload_table", "file_name=?", new String[]{r100});     // Catch: Throwable -> L16 Exception -> L18
    L10:
        SQLiteDatabase r105 = this.f457437a;     // Catch: Throwable -> L16 Exception -> L18
        if (r105 == null) goto L13;
        r105.setTransactionSuccessful();     // Catch: Throwable -> L16 Exception -> L18
    L13:
        r102 = this.f457437a;
        if (r102 != null) goto L15;
        return;
    }

    public final void d(c r110) {
        String r100 = r110.f457440a;
        LinkedHashSet r101 = new LinkedHashSet();
        SQLiteDatabase r102 = this.f457437a;     // Catch: Exception -> L18
        if (r102 == null) goto L16;
        Cursor r103 = r102.rawQuery("select * from preload_table where file_name=?", new String[]{r100});     // Catch: Exception -> L18
        if (r103 == null) goto L16;
        if (r103.moveToFirst() == true) goto L10;
    L15:
        r103.close();     // Catch: Exception -> L18
    L20:
        Object[] r104 = r101.toArray(new String[0]);
        if (r104 == null) goto L68;
        String[] r105 = (String[]) r104;
    L24:
        if (r105.length != 0) goto L26;
        boolean r106 = true;
    L28:
        if ((!r106) == true) goto L30;
        insert(r110);
        return;
    L30:
        if (ArraysKt.contains(r105, r110.f457445f) == false) goto L32;
        Logger.INSTANCE.d("JKL", "[预加载][数据库][数据已存在][场景" + r110.f457445f + "已存在][" + r110.f457440a + "][无操作]");
        return;
    L32:
        Logger.INSTANCE.w("JKL", "[预加载][数据库][数据已存在][场景" + r110.f457445f + "不存在][" + r110.f457440a + "][更新数据]");
        ArrayList r107 = new ArrayList();
        CollectionsKt.addAll(r107, r105);
        r107.add(r110.f457445f);
        c.a r108 = c.f457439h;
        Object[] r109 = r107.toArray(new String[0]);
        if (r109 == null) goto L64;
        String[] r111 = (String[]) r109;
        r108.getClass();
        int r112 = r111.length;
        String r113 = "";
        int r114 = 0;
    L35:
        if (r114 >= r112) goto L40;
        r113 = r113 + r111[r114];
        if (r114 >= (r111.length - 1)) goto L39;
        r113 = r113 + c.f457438g;
    L39:
        r114 = r114 + 1;
        goto L35
    L40:
        SQLiteDatabase r115 = this.f457437a;
        if (r115 == null) goto L79;
        r115.beginTransaction();
        ContentValues r116 = new ContentValues();     // Catch: Throwable -> L52 Exception -> L54
        r116.put("last_access_time", Long.valueOf(r110.f457444e));     // Catch: Throwable -> L52 Exception -> L54
        r116.put("busi_key_list", r113);     // Catch: Throwable -> L52 Exception -> L54
        SQLiteDatabase r117 = this.f457437a;     // Catch: Throwable -> L52 Exception -> L54
        if (r117 == null) goto L46;
        r117.update("preload_table", r116, "file_name=?", new String[]{r110.f457440a});     // Catch: Throwable -> L52 Exception -> L54
    L46:
        SQLiteDatabase r118 = this.f457437a;     // Catch: Throwable -> L52 Exception -> L54
        if (r118 == null) goto L49;
        r118.setTransactionSuccessful();     // Catch: Throwable -> L52 Exception -> L54
    L49:
        SQLiteDatabase r119 = this.f457437a;
        if (r119 == null) goto L80;
    L58:
        r119.endTransaction();
        return;
    L80:
        return;
    L54:
        e = move-exception;
        Logger.INSTANCE.e("JKL", "[预加载][数据库][更新数据失败]", e);     // Catch: Throwable -> L52
        r119 = this.f457437a;
        if (r119 != null) goto L58;
        return;
    L52:
        th = move-exception;
        SQLiteDatabase r120 = this.f457437a;
        if (r120 == null) goto L62;
        r120.endTransaction();
    L62:
        throw th;
    L79:
        return;
    L64:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L26:
        r106 = false;
        goto L28
    L68:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L10:
        if (r103.isAfterLast() == true) goto L15;
        String r121 = r103.getString(5);     // Catch: Exception -> L18
        c.f457439h.getClass();     // Catch: Exception -> L18
        String[] r122 = c.a.a(r121);     // Catch: Exception -> L18
        int r123 = r122.length;     // Catch: Exception -> L18
        int r124 = 0;
    L12:
        if (r124 >= r123) goto L14;
        r101.add(r122[r124]);     // Catch: Exception -> L18
        r124 = r124 + 1;     // Catch: Exception -> L18
        goto L12
    L14:
        r103.moveToNext();     // Catch: Exception -> L18
    L16:
        r105 = new String[0];     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public final c e(String r110) {
        c r100 = null;
        SQLiteDatabase r101 = this.f457437a;     // Catch: Exception -> L15
        if (r101 == null) goto L14;
        Cursor r111 = r101.rawQuery("select * from preload_table where file_name=?", new String[]{r110});     // Catch: Exception -> L15
        if (r111 == null) goto L14;
        if (r111.moveToFirst() == true) goto L10;
    L12:
        r111.close();     // Catch: Exception -> L15
    L17:
        return r100;
    L10:
        if (r111.isAfterLast() == true) goto L12;
        r100 = new c(r111.getString(0), r111.getString(1), r111.getString(2), r111.getString(3), r111.getLong(4), r111.getString(5));     // Catch: Exception -> L15
    L14:
        return null;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
