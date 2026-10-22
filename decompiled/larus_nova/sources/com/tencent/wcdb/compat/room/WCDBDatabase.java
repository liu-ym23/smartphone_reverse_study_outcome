package com.tencent.wcdb.compat.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.ec.core.event.a;
import com.tencent.wcdb.compat.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes40.dex */
public class WCDBDatabase implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = null;
    private static final String[] EMPTY_STRING_ARRAY = null;
    private static final String ROOM_UPDATE_TABLE_NAME = "room_table_modification_log";
    private final SQLiteDatabase mDelegate;

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return true;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final /* synthetic */ void execPerConnectionSQL(String r100, Object[] r101) {
        SupportSQLiteDatabase.CC.$default$execPerConnectionSQL(this, r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return SupportSQLiteDatabase.CC.$default$isExecPerConnectionSQLSupported(this);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return true;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean r100) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r100) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long r100) {
        return false;
    }

    static {
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        EMPTY_STRING_ARRAY = new String[0];
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.mDelegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.mDelegate.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.mDelegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        ArrayList r100 = new ArrayList();
        Cursor r101 = null;
        r101 = this.mDelegate.rawQuery("pragma database_list;", null);     // Catch: Throwable -> L10
    L5:
        if (r101.moveToNext() == false) goto L8;
        r100.add(new Pair(r101.getString(1), r101.getString(2)));     // Catch: Throwable -> L10
        goto L5
    L8:
        r101.close();
        return r100;
    L10:
        th = move-exception;
        if (r101 == null) goto L13;
        r101.close();
    L13:
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.mDelegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        Cursor r100 = this.mDelegate.rawQuery("PRAGMA integrity_check", null);
    L10:
        th = move-exception;
        if (r100 != null) goto L19;
    L16:
        throw th;
    L19:
        r100.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    L4:
        if (r100.moveToFirst() == false) goto L8;
        boolean r101 = TextUtils.equals(r100.getString(0).toLowerCase(), a.VALUE_CLICK_TYPE);     // Catch: Throwable -> L10
        r100.close();
        return r101;
    L8:
        r100.close();
        return true;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.mDelegate.setTransactionSuccessful();
    }

    public final SQLiteDatabase getInnerDatabase() {
        return this.mDelegate;
    }

    public WCDBDatabase(SQLiteDatabase r100) {
        this.mDelegate = r100;
    }

    private static boolean isEmpty(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener r100) {
        this.mDelegate.beginTransactionWithListener(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r100) {
        this.mDelegate.beginTransactionWithListenerNonExclusive(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r100) {
        return new WCDBStatement(this.mDelegate.compileStatement(r100));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r100) throws SQLException {
        this.mDelegate.execSQL(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r100) {
        if (r100 <= this.mDelegate.getVersion()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r100) {
        String r101 = r100.getSql();
        QueryInterceptorProgram r102 = new QueryInterceptorProgram();
        r100.bindTo(r102);
        Object[] r103 = r102.getBindArgs().toArray();
        if (TextUtils.isEmpty(r101) == true) goto L11;
        if (r101.contains(ROOM_UPDATE_TABLE_NAME) == false) goto L11;
        return this.mDelegate.rawQuery(r100.getSql(), r103, null);
    L9:
        throw new SQLiteException("Please use WCDB2 directly instead of Room");
    L11:
        return this.mDelegate.rawQuery(r100.getSql(), r103, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int r100) {
        this.mDelegate.setMaximumSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r100) {
        return this.mDelegate.setMaximumSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r100) {
        this.mDelegate.setPageSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r100) {
        this.mDelegate.setVersion(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r100) {
        return query(r100, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r100, Object[] r101) throws SQLException {
        this.mDelegate.execSQL(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r100, CancellationSignal r101) {
        QueryInterceptorProgram r102 = new QueryInterceptorProgram();
        r100.bindTo(r102);
        Object[] r103 = r102.getBindArgs().toArray();
        if (r101 == null) goto L8;
        final CancellationSignal r104 = new CancellationSignal();
        if (r101.isCanceled() == false) goto L7;
        r104.cancel();
    L7:
        r101.setOnCancelListener(new AnonymousClass1(this, r104));
    L10:
        return this.mDelegate.rawQuery(r100.getSql(), r103, r104);
    L8:
        r104 = null;
        goto L10
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r100, Object[] r101) {
        return this.mDelegate.rawQuery(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r100, String r101, Object[] r102) {
        StringBuilder r103 = new StringBuilder("DELETE FROM ");
        r103.append(r100);
        if (isEmpty(r101) == false) goto L5;
        String r104 = "";
    L6:
        r103.append(r104);
        SupportSQLiteStatement r105 = compileStatement(r103.toString());
        SimpleSQLiteQuery.bind(r105, r102);
        return r105.executeUpdateDelete();
    L5:
        r104 = " WHERE " + r101;
        goto L6
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String r100, int r101, ContentValues r102) throws SQLException {
        return this.mDelegate.insertWithOnConflict(r100, null, r102, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r100, int r101, ContentValues r102, String r110, Object[] r111) {
        if (r102 == null) goto L27;
        if (r102.size() == 0) goto L27;
        StringBuilder r103 = new StringBuilder(120);
        r103.append("UPDATE ");
        r103.append(CONFLICT_VALUES[r101]);
        r103.append(r100);
        r103.append(" SET ");
        int r104 = r102.size();
        if (r111 != null) goto L8;
        int r105 = r104;
    L9:
        Object[] r106 = new Object[r105];
        Iterator<String> r107 = r102.keySet().iterator();
        int r108 = 0;
    L11:
        if (r107.hasNext() == false) goto L17;
        String r109 = r107.next();
        if (r108 <= 0) goto L15;
        String r112 = ",";
    L16:
        r103.append(r112);
        r103.append(r109);
        r106[r108] = r102.get(r109);
        r103.append("=?");
        r108 = r108 + 1;
        goto L11
    L15:
        r112 = "";
        goto L16
    L17:
        if (r111 == null) goto L22;
        int r113 = r104;
    L19:
        if (r113 >= r105) goto L22;
        r106[r113] = r111[r113 - r104];
        r113 = r113 + 1;
    L22:
        if (isEmpty(r110) == true) goto L24;
        r103.append(" WHERE ");
        r103.append(r110);
    L24:
        SupportSQLiteStatement r114 = compileStatement(r103.toString());
        SimpleSQLiteQuery.bind(r114, r106);
        return r114.executeUpdateDelete();
    L8:
        r105 = r111.length + r104;
    L27:
        throw new IllegalArgumentException("Empty values");
    }
}
