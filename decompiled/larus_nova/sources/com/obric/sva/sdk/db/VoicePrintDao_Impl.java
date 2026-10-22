package com.obric.sva.sdk.db;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class VoicePrintDao_Impl implements VoicePrintDao {
    private final RoomDatabase __db;
    private final SharedSQLiteStatement __preparedStmtOfClear;

    @Override // com.obric.sva.sdk.db.VoicePrintDao
    public void clear() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r100 = this.__preparedStmtOfClear.acquire();
        this.__db.beginTransaction();
        r100.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfClear.release(r100);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfClear.release(r100);
        throw th;
    }

    @Override // com.obric.sva.sdk.db.VoicePrintDao
    public List<SvaVoicePrintControl> getVoicePrintInfos() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM `sva_voice_print`", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.__db, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L30
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, InvRouter.VERSION_ID);     // Catch: Throwable -> L30
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, ST.UUID_DEVICE);     // Catch: Throwable -> L30
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "audio_engine_version");     // Catch: Throwable -> L30
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "state");     // Catch: Throwable -> L30
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "misc");     // Catch: Throwable -> L30
        ArrayList r110 = new ArrayList(r101.getCount());     // Catch: Throwable -> L30
    L4:
        if (r101.moveToNext() == false) goto L28;
        if (r101.isNull(r102) == false) goto L9;
        Long r111 = null;
    L11:
        if (r101.isNull(r103) == false) goto L13;
        String r112 = null;
    L15:
        if (r101.isNull(r104) == false) goto L17;
        String r113 = null;
    L19:
        if (r101.isNull(r105) == false) goto L21;
        String r114 = null;
    L22:
        int r115 = r101.getInt(r106);     // Catch: Throwable -> L30
        if (r101.isNull(r107) == false) goto L25;
        String r116 = null;
    L26:
        r110.add(new SvaVoicePrintControl(r111, r112, r113, r114, r115, r116));     // Catch: Throwable -> L30
        goto L4
    L25:
        r116 = r101.getString(r107);     // Catch: Throwable -> L30
        goto L26
    L21:
        r114 = r101.getString(r105);     // Catch: Throwable -> L30
        goto L22
    L17:
        r113 = r101.getString(r104);     // Catch: Throwable -> L30
        goto L19
    L13:
        r112 = r101.getString(r103);     // Catch: Throwable -> L30
        goto L15
    L9:
        r111 = Long.valueOf(r101.getLong(r102));     // Catch: Throwable -> L30
        goto L11
    L28:
        r101.close();
        r100.release();
        return r110;
    L30:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public VoicePrintDao_Impl(final RoomDatabase r100) {
        this.__db = r100;
        this.__preparedStmtOfClear = new AnonymousClass1(this, r100);
    }

    @Override // com.obric.sva.sdk.db.VoicePrintDao
    public List<SvaVoicePrintControl> getVoicePrintInfo(String r210) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM `sva_voice_print` WHERE `uuid` = ? ", 1);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.__db, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L34
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, InvRouter.VERSION_ID);     // Catch: Throwable -> L34
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, ST.UUID_DEVICE);     // Catch: Throwable -> L34
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "audio_engine_version");     // Catch: Throwable -> L34
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "state");     // Catch: Throwable -> L34
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "misc");     // Catch: Throwable -> L34
        ArrayList r110 = new ArrayList(r101.getCount());     // Catch: Throwable -> L34
    L8:
        if (r101.moveToNext() == false) goto L32;
        if (r101.isNull(r102) == false) goto L13;
        Long r111 = null;
    L15:
        if (r101.isNull(r103) == false) goto L17;
        String r112 = null;
    L19:
        if (r101.isNull(r104) == false) goto L21;
        String r113 = null;
    L23:
        if (r101.isNull(r105) == false) goto L25;
        String r114 = null;
    L26:
        int r115 = r101.getInt(r106);     // Catch: Throwable -> L34
        if (r101.isNull(r107) == false) goto L29;
        String r116 = null;
    L30:
        r110.add(new SvaVoicePrintControl(r111, r112, r113, r114, r115, r116));     // Catch: Throwable -> L34
        goto L8
    L29:
        r116 = r101.getString(r107);     // Catch: Throwable -> L34
        goto L30
    L25:
        r114 = r101.getString(r105);     // Catch: Throwable -> L34
        goto L26
    L21:
        r113 = r101.getString(r104);     // Catch: Throwable -> L34
        goto L23
    L17:
        r112 = r101.getString(r103);     // Catch: Throwable -> L34
        goto L19
    L13:
        r111 = Long.valueOf(r101.getLong(r102));     // Catch: Throwable -> L34
        goto L15
    L32:
        r101.close();
        r100.release();
        return r110;
    L34:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    L5:
        r100.bindString(1, r210);
        goto L6
    }
}
