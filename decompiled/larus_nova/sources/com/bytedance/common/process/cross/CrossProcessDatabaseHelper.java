package com.bytedance.common.process.cross;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.common.model.MethodCallRecord;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.utility.Logger;
import com.bytedance.push.utils.f;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import s67.b;

/* JADX INFO: loaded from: classes15.dex */
public class CrossProcessDatabaseHelper {
    static final String[] METHOD_RECORD_COLS = null;
    private static final Object mLock = null;
    private static CrossProcessDatabaseHelper sInstance;
    private SQLiteDatabase mDb;
    private ProcessEnum mProcessEnum;

    public static class OpenHelper extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE method_call_record ( _id TEXT PRIMARY KEY, origin_process_name TEXT, target_process_name TEXT, method_name TEXT, args TEXT )");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Logger.e("DatabaseHelper", "create db exception " + th);
        }

        public OpenHelper(Context r100, String r101) {
            super(r100, r101, null, 1);
        }
    }

    static {
        METHOD_RECORD_COLS = new String[]{DBDefinition.ID, "origin_process_name", "target_process_name", "method_name", "args"};
        mLock = new Object();
    }

    private String getDbName() {
        return this.mProcessEnum.processSuffix.substring(1) + "_cross_process_event.db";
    }

    private CrossProcessDatabaseHelper(Context r100) {
        ProcessEnum r101 = ToolUtils.getCurProcess(r100);
        this.mProcessEnum = r101;
        if (r101 != ProcessEnum.UNKNOWN) goto L10;
        return;
    L10:
        this.mDb = new OpenHelper(r100, getDbName()).getWritableDatabase();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        f.e("DatabaseHelper", "error when open database:" + th.getMessage());
        b.a(th, "error when init com.bytedance.common.process.cross.CrossProcessDatabaseHelper.CrossProcessDatabaseHelper");
    }

    public static CrossProcessDatabaseHelper getInstance(Context r100) {
        if (sInstance != null) goto L15;
        Object r101 = mLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CrossProcessDatabaseHelper(r100.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static void safeCloseCursor(Cursor r100) {
        if (r100 == null) goto L10;
        if (r100.isClosed() == true) goto L11;
        r100.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public synchronized boolean deleteRecord(String r100) {
        monitor-enter(this);
        SQLiteDatabase r101 = this.mDb;     // Catch: Throwable -> L19
        boolean r102 = false;
        if (r101 != null) goto L6;
    L16:
        Logger.w("DatabaseHelper", "db not establish and open");     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L6:
        if (r101.isOpen() == false) goto L16;
        if (this.mDb.delete("method_call_record", "_id = ?", new String[]{r100}) <= 0) goto L12;
        r102 = true;
    L12:
        monitor-exit(this);
        return r102;
    L15:
        return true;
    L19:
        th = move-exception;
        throw th;
    }

    public synchronized long insertMethodRecord(MethodCallRecord r100) {
        monitor-enter(this);
        SQLiteDatabase r101 = this.mDb;     // Catch: Throwable -> L15
        if (r101 != null) goto L6;
    L11:
        Logger.w("DatabaseHelper", "db not establish and open");     // Catch: Throwable -> L15
        monitor-exit(this);
        return -1;
    L6:
        if (r101.isOpen() == false) goto L11;
        ContentValues r102 = new ContentValues();     // Catch: Throwable -> L15
        r102.put(DBDefinition.ID, Long.valueOf(ToolUtils.currentTimeMillis()));     // Catch: Throwable -> L15
        r102.put("origin_process_name", r100.getOriginProcessSuffix());     // Catch: Throwable -> L15
        r102.put("target_process_name", r100.getTargetProcessSuffix());     // Catch: Throwable -> L15
        r102.put("method_name", r100.getMethodName());     // Catch: Throwable -> L15
        r102.put("args", r100.getArgs());     // Catch: Throwable -> L15
        long r103 = this.mDb.insert("method_call_record", null, r102);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r103;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized List<MethodCallRecord> getNextBatchRecords(ProcessEnum r110, ProcessEnum r111) {
        monitor-enter(this);
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L26
        SQLiteDatabase r101 = this.mDb;     // Catch: Throwable -> L26
        Cursor r102 = null;
        if (r101 != null) goto L6;
    L23:
        Logger.w("DatabaseHelper", "db not establish and open");     // Catch: Throwable -> L26
        monitor-exit(this);
        return null;
    L6:
        if (r101.isOpen() == false) goto L23;
        r102 = this.mDb.query("method_call_record", METHOD_RECORD_COLS, "origin_process_name=? AND target_process_name=?", new String[]{r110.processSuffix, r111.processSuffix}, null, null, null, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);     // Catch: Throwable -> L15
    L10:
        if (r102.moveToNext() == false) goto L13;
        r100.add(new MethodCallRecord(r102.getString(1), r102.getString(2), r102.getString(3), r102.getString(4), r102.getString(0)));     // Catch: Throwable -> L15
    L13:
        safeCloseCursor(r102);     // Catch: Throwable -> L26
        monitor-exit(this);
        return r100;
    L15:
        th = move-exception;
        r100 = new ArrayList();     // Catch: Throwable -> L20
        f.d("error when query database:" + th.getMessage());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        safeCloseCursor(r102);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }
}
