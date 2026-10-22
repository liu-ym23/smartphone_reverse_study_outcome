package com.ss.videoarch.strategy.dataCenter.strategyData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class StrategySQLiteWrapper extends SQLiteOpenHelper {
    public static final String TABLE_CREATE = "create_time";
    public static final String TABLE_EXPAND = "expand_value";
    public static final String TABLE_UPDATE = "update_time";
    private static final String TAG = "StrategySQLiteWrapper";
    public static Context mContext = null;
    public static final String mDataBaseName = "StrategyData.db";
    private static final int mDataBaseVERSION = 1;
    public static volatile StrategySQLiteWrapper mInstance;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    public static StrategySQLiteWrapper getInstance() {
        return mInstance;
    }

    public StrategySQLiteWrapper(Context r100) {
        super(r100, mDataBaseName, null, 1);
    }

    public static void inst(Context r100) {
        if (mInstance != null) goto L6;
        mInstance = new StrategySQLiteWrapper(r100);
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r100) {
        r100.execSQL(NodeTableOperate.SQL_OF_NODE);
        r100.execSQL(ConfigTableOperate.SQL_OF_SWITCH);
        r100.execSQL(HistoryTableOperate.SQL_OF_HISTORY);
        r100.execSQL(HistoryTableOperate.TABLE_NAME_HISTORY_TRIGGER);
    }

    public static long insert(String r100, ContentValues r101) {
        if (mInstance == null) goto L6;
        return mInstance.getWritableDatabase().insert(r100, null, r101);
    L6:
        return -1;
    L11:
        return -1;
    }

    public static Cursor queryBySQL(String r100, String r101) {
        if (mInstance != null) goto L9;
    L8:
        return null;
    L9:
        return mInstance.getReadableDatabase().rawQuery(r101, null);
    L6:
        th = move-exception;
        th.getMessage();
        goto L8
    }

    public static int delete(String r100, String r101, String[] r102) {
        if (mInstance != null) goto L9;
        return 0;
    L9:
        return mInstance.getWritableDatabase().delete(r100, r101, r102);
    L11:
        return 0;
    }

    public static long getCount(String r100, String r101, String[] r102) {
        if (mInstance == null) goto L14;
        Cursor r103 = mInstance.getReadableDatabase().rawQuery("select count(DISTINCT " + r101 + ") from " + r100, null);     // Catch: Throwable -> L8
        if (r103 == null) goto L15;
        r103.moveToFirst();     // Catch: Throwable -> L8
        long r104 = r103.getLong(0);     // Catch: Throwable -> L8
        r103.close();     // Catch: Throwable -> L8
        return r104;
    L15:
        return -1;
    L8:
        th = move-exception;
        th.getMessage();
        return -1;
    L14:
        return -1;
    }

    public static long replaceAll(String r110, String[] r210, List<ContentValues> r211) {
        long r100 = -1;
        if (mInstance == null) goto L65;
        if (r210 != null) goto L6;
        return -1;
    L6:
        if (r210.length <= 0) goto L67;
        char r111 = 0;
        String r112 = "";
        int r101 = 0;
    L9:
        if (r101 >= r210.length) goto L14;
        String r102 = r210[r101];
        if (r101 == 0) goto L13;
        r112 = r112 + " and ";
    L13:
        r112 = r112 + r102 + "=?";
        r101 = r101 + 1;
        goto L9
    L14:
        SQLiteDatabase r113 = null;
        SQLiteDatabase r114 = mInstance.getWritableDatabase();     // Catch: Throwable -> L45
        r114.beginTransaction();     // Catch: Throwable -> L40
        String[] r115 = new String[r210.length];     // Catch: Throwable -> L40
        Iterator<ContentValues> r116 = r211.iterator();     // Catch: Throwable -> L40
        long r117 = -1;
    L47:
    L39:
        r113 = r114;
        r100 = r117;
        goto L41
    L19:
        if (r116.hasNext() == false) goto L36;
        ContentValues r103 = r116.next();     // Catch: Throwable -> L39
        if (r103 == null) goto L35;
        int r104 = 0;
    L24:
        if (r104 >= r210.length) goto L26;
        r115[r104] = String.valueOf(r103.get(r210[r104]));     // Catch: Throwable -> L39
        r104 = r104 + 1;     // Catch: Throwable -> L39
        goto L24
    L26:
        String[] r105 = new String[1];     // Catch: Throwable -> L39
        r105[r111] = r210[r111];     // Catch: Throwable -> L39
        Cursor r106 = r114.query(r110, r105, r112, r115, null, null, null);     // Catch: Throwable -> L39
        if (r106 == null) goto L35;
        if (r106.getCount() != 0) goto L32;
        r100 = r114.insert(r110, null, r103);     // Catch: Throwable -> L39
    L33:
        r106.close();     // Catch: Throwable -> L40
        r117 = r100;
        goto L35
    L32:
        r100 = r114.update(r110, r103, r112, r115);     // Catch: Throwable -> L39
    L35:
        r111 = 0;
        goto L47
    L36:
        r114.setTransactionSuccessful();     // Catch: Throwable -> L39
        r114.endTransaction();     // Catch: Throwable -> L44
    L68:
        return r117;
    L40:
        r113 = r114;
    L41:
        if (r113 == null) goto L69;
        r113.endTransaction();     // Catch: Throwable -> L46
        return r100;
    L70:
        return r100;
    L69:
        return r100;
    L67:
        return -1;
    L65:
        return -1;
    }

    public static int update(String r100, ContentValues r101, String r102, String[] r103) {
        SQLiteDatabase r104 = null;
        int r105 = -1;
    L9:
        if (r104 != null) goto L13;
    L11:
        return r105;
    L13:
        r104.endTransaction();     // Catch: Exception -> L12
        goto L11
    L4:
        if (mInstance == null) goto L6;
        r104 = mInstance.getWritableDatabase();     // Catch: Throwable -> L9
        r104.beginTransaction();     // Catch: Throwable -> L9
        r105 = r104.update(r100, r101, r102, r103);     // Catch: Throwable -> L9
        r104.setTransactionSuccessful();     // Catch: Throwable -> L9
    L6:
        if (r104 == null) goto L11;
        goto L11
    }

    public static long replace(String r110, String[] r111, ContentValues r112, String r113, String[] r114) {
        long r100 = -1;
    L13:
        e = move-exception;
        e.getMessage();
        e.printStackTrace();
        return r100;
    L4:
        if (mInstance == null) goto L18;
        SQLiteDatabase r101 = mInstance.getWritableDatabase();     // Catch: Exception -> L13
        Cursor r115 = r101.query(r110, r111, r113, r114, null, null, null);     // Catch: Exception -> L13
        if (r115 != null) goto L8;
        return -1;
    L8:
        if (r115.getCount() != 0) goto L10;
        long r116 = r101.insert(r110, null, r112);     // Catch: Exception -> L13
    L11:
        r100 = r116;
        r115.close();     // Catch: Exception -> L13
        return r100;
    L10:
        r116 = r101.update(r110, r112, r113, r114);     // Catch: Exception -> L13
        goto L11
    L18:
        return -1;
    }

    public static Cursor query(String r100, String[] r110, String r111, String[] r112, String r113, String r114, String r115) {
        if (mInstance == null) goto L12;
        return mInstance.getReadableDatabase().query(r100, r110, r111, r112, r113, r114, r115);
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    L12:
        return null;
    }
}
