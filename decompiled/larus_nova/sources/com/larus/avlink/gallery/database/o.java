package com.larus.avlink.gallery.database;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes25.dex */
public final class o implements Callable<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomSQLiteQuery f292491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f292492b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public i call() throws Exception {
        o r100 = this;
        Cursor r101 = DBUtil.query(r100.f292492b.f292473a, r100.f292491a, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L45
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "file_path");     // Catch: Throwable -> L45
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "file_name");     // Catch: Throwable -> L45
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "file_size");     // Catch: Throwable -> L45
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "sn");     // Catch: Throwable -> L45
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "image_uuid");     // Catch: Throwable -> L45
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);     // Catch: Throwable -> L45
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "width");     // Catch: Throwable -> L45
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "height");     // Catch: Throwable -> L45
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "duration");     // Catch: Throwable -> L45
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "create_time");     // Catch: Throwable -> L45
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "modify_time");     // Catch: Throwable -> L45
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "download_time");     // Catch: Throwable -> L45
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "geo_location_info");     // Catch: Throwable -> L45
        int r116 = CursorUtil.getColumnIndexOrThrow(r101, "source_type");     // Catch: Throwable -> L43
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "processing_status");     // Catch: Throwable -> L43
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "is_synced");     // Catch: Throwable -> L43
        if (r101.moveToFirst() == true) goto L7;
        i r119 = null;
    L41:
        r101.close();
        this.f292491a.release();
        return r119;
    L7:
        if (r101.isNull(r102) == false) goto L9;
        String r120 = null;
    L11:
        if (r101.isNull(r103) == false) goto L13;
        String r210 = null;
    L15:
        if (r101.isNull(r104) == false) goto L17;
        String r211 = null;
    L18:
        long r212 = r101.getLong(r105);     // Catch: Throwable -> L43
        if (r101.isNull(r106) == false) goto L21;
        String r213 = null;
    L22:
        long r214 = r101.getLong(r107);     // Catch: Throwable -> L43
        if (r101.isNull(r110) == false) goto L25;
        String r215 = null;
    L26:
        int r216 = r101.getInt(r111);     // Catch: Throwable -> L43
        int r217 = r101.getInt(r112);     // Catch: Throwable -> L43
        long r310 = r101.getLong(r113);     // Catch: Throwable -> L43
        long r311 = r101.getLong(r114);     // Catch: Throwable -> L43
        long r312 = r101.getLong(r115);     // Catch: Throwable -> L43
        long r313 = r101.getLong(r108);     // Catch: Throwable -> L43
        if (r101.isNull(r109) == false) goto L29;
        String r314 = null;
    L31:
        if (r101.isNull(r16) == false) goto L33;
        String r315 = null;
    L34:
        int r410 = r101.getInt(r117);     // Catch: Throwable -> L43
        if (r101.getInt(r118) == 0) goto L37;
        boolean r411 = true;
    L38:
        r119 = new i(r120, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r410, r411);     // Catch: Throwable -> L43
        goto L41
    L37:
        r411 = false;
        goto L38
    L33:
        r315 = r101.getString(r116);     // Catch: Throwable -> L43
        goto L34
    L29:
        r314 = r101.getString(r109);     // Catch: Throwable -> L43
        goto L31
    L25:
        r215 = r101.getString(r110);     // Catch: Throwable -> L43
        goto L26
    L21:
        r213 = r101.getString(r106);     // Catch: Throwable -> L43
        goto L22
    L17:
        r211 = r101.getString(r104);     // Catch: Throwable -> L43
        goto L18
    L13:
        r210 = r101.getString(r103);     // Catch: Throwable -> L43
        goto L15
    L9:
        r120 = r101.getString(r102);     // Catch: Throwable -> L43
    L43:
        th = th;
        r100 = this;
    L46:
        r101.close();
        r100.f292491a.release();
        throw th;
    L45:
        th = th;
        goto L46
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ i call() throws Exception {
        return call();
    }

    public o(k r100, RoomSQLiteQuery r101) {
        this.f292492b = r100;
        this.f292491a = r101;
    }
}
