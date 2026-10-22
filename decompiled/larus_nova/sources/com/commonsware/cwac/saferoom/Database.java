package com.commonsware.cwac.saferoom;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes22.dex */
class Database implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = null;
    private final SQLiteDatabase safeDb;

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final /* synthetic */ void execPerConnectionSQL(String r100, Object[] r101) {
        SupportSQLiteDatabase.CC.$default$execPerConnectionSQL(this, r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return SupportSQLiteDatabase.CC.$default$isExecPerConnectionSQLSupported(this);
    }

    static {
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.safeDb.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.safeDb.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.safeDb.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        this.safeDb.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.safeDb.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.safeDb.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.safeDb.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.safeDb.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.safeDb.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.safeDb.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.safeDb.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        if (this.safeDb.isOpen() == false) goto L7;
        return this.safeDb.inTransaction();
    L7:
        throw new IllegalStateException("You should not be doing this on a closed database");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.safeDb.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        if (this.safeDb.isOpen() == false) goto L7;
        return this.safeDb.isDbLockedByCurrentThread();
    L7:
        throw new IllegalStateException("You should not be doing this on a closed database");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.safeDb.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.safeDb.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return this.safeDb.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.safeDb.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        if (this.safeDb.isOpen() == false) goto L7;
        return this.safeDb.yieldIfContendedSafely();
    L7:
        throw new IllegalStateException("You should not be doing this on a closed database");
    }

    public Database(SQLiteDatabase r100) {
        this.safeDb = r100;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(final SQLiteTransactionListener r100) {
        this.safeDb.beginTransactionWithListener(new AnonymousClass1(this, r100));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(final SQLiteTransactionListener r100) {
        this.safeDb.beginTransactionWithListenerNonExclusive(new AnonymousClass2(this, r100));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r100) {
        return new Statement(this.safeDb.compileStatement(r100));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r100) throws SQLException {
        this.safeDb.execSQL(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r100) {
        return this.safeDb.needUpgrade(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r100) {
        return query(new SimpleSQLiteQuery(r100));
    }

    public void rekey(Editable r100) {
        char[] r101 = new char[r100.length()];
        r100.getChars(0, r100.length(), r101, 0);
        rekey(r101);     // Catch: Throwable -> L6
        r100.clear();
        return;
    L6:
        th = move-exception;
        r100.clear();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean r100) {
        this.safeDb.setForeignKeyConstraintsEnabled(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r100) {
        this.safeDb.setLocale(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int r100) {
        this.safeDb.setMaxSqlCacheSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r100) {
        return this.safeDb.setMaximumSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r100) {
        this.safeDb.setPageSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r100) {
        this.safeDb.setVersion(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long r100) {
        if (this.safeDb.isOpen() == false) goto L7;
        return this.safeDb.yieldIfContendedSafely(r100);
    L7:
        throw new IllegalStateException("You should not be doing this on a closed database");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r100) {
        return query(r100, null);
    }

    public void rekey(char[] r100) {
        this.safeDb.changePassword(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r100, Object[] r101) throws SQLException {
        this.safeDb.execSQL(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r100, CancellationSignal r101) {
        BindingsRecorder r102 = new BindingsRecorder();
        r100.bindTo(r102);
        return this.safeDb.rawQueryWithFactory(new AnonymousClass3(this, r100), r100.getSql(), r102.getBindings(), null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r100, Object[] r101) {
        return query(new SimpleSQLiteQuery(r100, r101));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r100, String r101, Object[] r102) {
        StringBuilder r103 = new StringBuilder("DELETE FROM ");
        r103.append(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        String r104 = "";
    L6:
        r103.append(r104);
        SupportSQLiteStatement r105 = compileStatement(r103.toString());
        SimpleSQLiteQuery.bind(r105, r102);     // Catch: Throwable -> L13
        int r106 = r105.executeUpdateDelete();     // Catch: Throwable -> L13
        r105.close();     // Catch: Exception -> L10
        return r106;
    L10:
        e = move-exception;
        throw new RuntimeException("Exception attempting to close statement", e);
    L13:
        th = move-exception;
        r105.close();     // Catch: Exception -> L16
        throw th;
    L16:
        e = move-exception;
        throw new RuntimeException("Exception attempting to close statement", e);
    L5:
        r104 = " WHERE " + r101;
        goto L6
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String r100, int r101, ContentValues r102) {
        return this.safeDb.insertWithOnConflict(r100, null, r102, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r100, int r101, ContentValues r110, String r111, Object[] r112) {
        if (r110 == null) goto L39;
        if (r110.size() == 0) goto L39;
        StringBuilder r102 = new StringBuilder(120);
        r102.append("UPDATE ");
        r102.append(CONFLICT_VALUES[r101]);
        r102.append(r100);
        r102.append(" SET ");
        int r103 = r110.size();
        if (r112 != null) goto L9;
        int r104 = r103;
    L10:
        Object[] r105 = new Object[r104];
        Iterator<String> r106 = r110.keySet().iterator();
        int r107 = 0;
    L12:
        if (r106.hasNext() == false) goto L18;
        String r108 = r106.next();
        if (r107 <= 0) goto L16;
        String r109 = ",";
    L17:
        r102.append(r109);
        r102.append(r108);
        r105[r107] = r110.get(r108);
        r102.append("=?");
        r107 = r107 + 1;
        goto L12
    L16:
        r109 = "";
        goto L17
    L18:
        if (r112 == null) goto L23;
        int r113 = r103;
    L20:
        if (r113 >= r104) goto L23;
        r105[r113] = r112[r113 - r103];
        r113 = r113 + 1;
    L23:
        if (TextUtils.isEmpty(r111) == true) goto L25;
        r102.append(" WHERE ");
        r102.append(r111);
    L25:
        SupportSQLiteStatement r114 = compileStatement(r102.toString());
        SimpleSQLiteQuery.bind(r114, r105);     // Catch: Throwable -> L32
        int r115 = r114.executeUpdateDelete();     // Catch: Throwable -> L32
        r114.close();     // Catch: Exception -> L29
        return r115;
    L29:
        e = move-exception;
        throw new RuntimeException("Exception attempting to close statement", e);
    L32:
        th = move-exception;
        r114.close();     // Catch: Exception -> L35
        throw th;
    L35:
        e = move-exception;
        throw new RuntimeException("Exception attempting to close statement", e);
    L9:
        r104 = r112.length + r103;
    L39:
        throw new IllegalArgumentException("Empty values");
    }
}
