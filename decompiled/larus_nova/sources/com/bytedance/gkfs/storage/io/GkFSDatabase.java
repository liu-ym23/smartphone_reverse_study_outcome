package com.bytedance.gkfs.storage.io;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.LruCache;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import faceverify.w;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes19.dex */
public final class GkFSDatabase extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f245341a = null;

    public static final class a extends LruCache<com.bytedance.gkfs.io.c, Long> {
        public a() {
            super(1000);
        }

        @Override // android.util.LruCache
        public final /* bridge */ /* synthetic */ int sizeOf(com.bytedance.gkfs.io.c r100, Long r101) {
            return 1;
        }
    }

    public static final class b {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    static {
        f245341a = new a();
    }

    public GkFSDatabase(Context r100) {
        super(r100, "gkfs.db", null, 1);
    }

    public final void a(com.bytedance.gkfs.io.c r100) {
        f245341a.remove(r100);
        getWritableDatabase().delete("chunk_ids", "hash = ?", new String[]{r100.f245192a});
    }

    public final void b(String r100) {
        getWritableDatabase().delete("chunk_refs", "ref = ?", new String[]{r100});
    }

    public final String c(com.bytedance.gkfs.io.c r110) {
        a r100 = f245341a;
        Long r101 = r100.get(r110);
        if (r101 != null) goto L5;
        boolean r111 = true;
        Cursor r102 = getReadableDatabase().query("chunk_ids", new String[]{"id"}, "hash = ?", new String[]{r110.f245192a}, null, null, null);
        if (r102 == null) goto L22;
        Cursor r103 = r102;
        Cursor r104 = r103;     // Catch: Throwable -> L17
        if (r104.moveToFirst() == false) goto L13;
        Long r105 = Long.valueOf(r104.getLong(r104.getColumnIndex("id")));     // Catch: Throwable -> L17
    L14:
        CloseableKt.closeFinally(r103, null);
        if (r105 == null) goto L22;
        long r106 = r105.longValue();
    L23:
        Long r107 = Long.valueOf(r106);
        if (r107.longValue() != (-1)) goto L27;
        r111 = false;
    L27:
        if (r111 == true) goto L30;
        r107 = null;
    L30:
        if (r107 == null) goto L37;
        r100.put(r110, Long.valueOf(r107.longValue()));
        return String.valueOf(r107.longValue());
    L37:
        return null;
    L13:
        r105 = null;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L22:
        ContentValues r108 = new ContentValues();
        r108.put(w.BLOB_ELEM_IMAGE_HASHCODE, r110.f245192a);
        r106 = getWritableDatabase().insert("chunk_ids", null, r108);
        goto L23
    L5:
        return String.valueOf(r101.longValue());
    }

    public final String d(String r110) {
        boolean r100 = true;
        Cursor r101 = getReadableDatabase().query("chunk_refs", new String[]{"id"}, "ref = ?", new String[]{r110}, null, null, null);
        if (r101 == null) goto L18;
        Cursor r102 = r101;
        Cursor r103 = r102;     // Catch: Throwable -> L13
        if (r103.moveToFirst() == false) goto L9;
        Long r104 = Long.valueOf(r103.getLong(r103.getColumnIndex("id")));     // Catch: Throwable -> L13
    L10:
        CloseableKt.closeFinally(r102, null);
        if (r104 == null) goto L18;
        long r105 = r104.longValue();
    L19:
        Long r111 = Long.valueOf(r105);
        if (r111.longValue() != (-1)) goto L23;
        r100 = false;
    L23:
        if (r100 == true) goto L26;
        r111 = null;
    L26:
        if (r111 != null) goto L28;
        return null;
    L28:
        return String.valueOf(r111.longValue());
    L9:
        r104 = null;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    L18:
        ContentValues r106 = new ContentValues();
        r106.put(TemplateNodeType.REF, r110);
        r105 = getWritableDatabase().insert("chunk_refs", null, r106);
        goto L19
    }

    public final Map<Long, String> e(long... r110) throws IllegalArgumentException {
        ArraysKt.joinToString$default(r110, ",", null, null, 0, null, GkFSDatabase$getRefsValue$1.INSTANCE, 30, null);
        SQLiteDatabase r111 = getReadableDatabase();
        String[] r112 = {"id", TemplateNodeType.REF};
        String r113 = "id IN (" + ArraysKt.joinToString$default(r110, ",", null, null, 0, null, GkFSDatabase$getRefsValue$result$1.INSTANCE, 30, null) + ')';
        int r100 = r110.length;
        String[] r101 = new String[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = String.valueOf(r110[r102]);
        r102 = r102 + 1;
        goto L3
    L5:
        Cursor r103 = r111.query("chunk_refs", r112, r113, r101, null, null, null);
        LinkedHashMap r104 = null;
        if (r103 == null) goto L20;
        Cursor r105 = r103;
        Cursor r106 = r105;     // Catch: Throwable -> L14
        int r107 = r106.getColumnIndexOrThrow("id");     // Catch: Throwable -> L14
        int r108 = r106.getColumnIndexOrThrow(TemplateNodeType.REF);     // Catch: Throwable -> L14
        LinkedHashMap r109 = new LinkedHashMap();     // Catch: Throwable -> L14
    L10:
        if (r106.moveToNext() == false) goto L13;
        r109.put(Long.valueOf(r106.getLong(r107)), r106.getString(r108));     // Catch: Throwable -> L14
        goto L10
    L13:
        CloseableKt.closeFinally(r105, null);
        r104 = r109;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    L20:
        if (r104 == null) goto L23;
        return r104;
    L23:
        return MapsKt.emptyMap();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        if (r100 == null) goto L4;
        r100.execSQL("CREATE TABLE IF NOT EXISTS chunk_refs (id INTEGER PRIMARY KEY AUTOINCREMENT, ref TEXT NOT NULL UNIQUE)");
    L4:
        if (r100 == null) goto L7;
        r100.execSQL("CREATE TABLE IF NOT EXISTS chunk_ids (id INTEGER PRIMARY KEY AUTOINCREMENT, hash TEXT NOT NULL UNIQUE)");
        return;
    }
}
