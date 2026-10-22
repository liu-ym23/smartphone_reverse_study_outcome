package xh8;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements SupportSQLiteDatabase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f563890b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f563891c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f563892a;

    public class a implements SQLiteDatabase.CursorFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SupportSQLiteQuery f563893a;

        public a(SupportSQLiteQuery r100) {
            this.f563893a = r100;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public final Cursor newCursor(SQLiteDatabase r100, SQLiteCursorDriver r101, String r102, SQLiteQuery r103) {
            this.f563893a.bindTo(new g(r103));
            return new SQLiteCursor(r101, r102, r103);
        }
    }

    public class b implements SQLiteDatabase.CursorFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SupportSQLiteQuery f563894a;

        public b(SupportSQLiteQuery r100) {
            this.f563894a = r100;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public final Cursor newCursor(SQLiteDatabase r100, SQLiteCursorDriver r101, String r102, SQLiteQuery r103) {
            this.f563894a.bindTo(new g(r103));
            return new SQLiteCursor(r101, r102, r103);
        }
    }

    static {
        f563890b = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        f563891c = new String[0];
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransaction() {
        this.f563892a.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransactionNonExclusive() {
        this.f563892a.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f563892a.close();     // Catch: SQLiteException -> L4
        return;
    L4:
        e = move-exception;
        e.a(e, "close");
        FLogger.f375446a.e("FlowSQLiteDatabase", "close err", e);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void disableWriteAheadLogging() {
        SupportSQLiteCompat.Api16Impl.disableWriteAheadLogging(this.f563892a);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean enableWriteAheadLogging() {
        return this.f563892a.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void endTransaction() {
        this.f563892a.endTransaction();     // Catch: SQLiteException -> L4
        return;
    L4:
        e = move-exception;
        e.a(e, "endTransaction");
        FLogger.f375446a.e("FlowSQLiteDatabase", "endTransaction err", e);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final List<Pair<String, String>> getAttachedDbs() {
        return this.f563892a.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long getMaximumSize() {
        return this.f563892a.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long getPageSize() {
        return this.f563892a.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final String getPath() {
        return this.f563892a.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int getVersion() {
        return this.f563892a.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean inTransaction() {
        return this.f563892a.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isDatabaseIntegrityOk() {
        return this.f563892a.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isDbLockedByCurrentThread() {
        return this.f563892a.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isExecPerConnectionSQLSupported() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isOpen() {
        return this.f563892a.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isReadOnly() {
        return this.f563892a.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isWriteAheadLoggingEnabled() {
        return SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.f563892a);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setTransactionSuccessful() {
        this.f563892a.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean yieldIfContendedSafely() {
        return this.f563892a.yieldIfContendedSafely();
    }

    public d(SQLiteDatabase r100) {
        this.f563892a = r100;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransactionWithListener(SQLiteTransactionListener r100) {
        this.f563892a.beginTransactionWithListener(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r100) {
        this.f563892a.beginTransactionWithListenerNonExclusive(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final SupportSQLiteStatement compileStatement(String r100) {
        return new h(this.f563892a.compileStatement(r100));
    L4:
        th = move-exception;
        e.a(th, "compileStatement");
        FLogger.f375446a.e("FlowSQLiteDatabase", "compileStatement err", th);
        return new xh8.b();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void execSQL(String r100) throws SQLException {
        this.f563892a.execSQL(r100);     // Catch: SQLiteException -> L4
        return;
    L4:
        e = move-exception;
        e.a(e, "execSQL1");
        FLogger.f375446a.e("FlowSQLiteDatabase", "execSQL1 err", e);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean needUpgrade(int r100) {
        return this.f563892a.needUpgrade(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r100) {
        return this.f563892a.rawQueryWithFactory(new a(r100), r100.getSql(), f563891c, null);
    L4:
        e = move-exception;
        e.a(e, "query1");
        FLogger.f375446a.e("FlowSQLiteDatabase", "query1 err", e);
        return new xh8.a();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setForeignKeyConstraintsEnabled(boolean r100) {
        SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.f563892a, r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setLocale(Locale r100) {
        this.f563892a.setLocale(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setMaxSqlCacheSize(int r100) {
        this.f563892a.setMaxSqlCacheSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long setMaximumSize(long r100) {
        return this.f563892a.setMaximumSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setPageSize(long r100) {
        this.f563892a.setPageSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setVersion(int r100) {
        this.f563892a.setVersion(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean yieldIfContendedSafely(long r100) {
        return this.f563892a.yieldIfContendedSafely(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r100) {
        return query(new SimpleSQLiteQuery(r100));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void execPerConnectionSQL(String r100, Object[] r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 30) goto L7;
        this.f563892a.execPerConnectionSQL(r100, r101);
        return;
    L7:
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + r102);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void execSQL(String r100, Object[] r101) throws SQLException {
        this.f563892a.execSQL(r100, r101);     // Catch: SQLiteException -> L4
        return;
    L4:
        e = move-exception;
        e.a(e, "execSQL2");
        FLogger.f375446a.e("FlowSQLiteDatabase", "execSQL2 err", e);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r100, CancellationSignal r101) {
        return SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(this.f563892a, r100.getSql(), f563891c, null, r101, new b(r100));
    L4:
        e = move-exception;
        e.a(e, "query2");
        FLogger.f375446a.e("FlowSQLiteDatabase", "query2 err", e);
        return new xh8.a();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r100, Object[] r101) {
        return query(new SimpleSQLiteQuery(r100, r101));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r100, String r101, Object[] r102) {
        StringBuilder r103 = new StringBuilder("DELETE FROM ");     // Catch: SQLiteException -> L9
        r103.append(r100);     // Catch: SQLiteException -> L9
        if (TextUtils.isEmpty(r101) == false) goto L6;
        String r104 = "";
    L7:
        r103.append(r104);     // Catch: SQLiteException -> L9
        SupportSQLiteStatement r105 = compileStatement(r103.toString());     // Catch: SQLiteException -> L9
        SimpleSQLiteQuery.bind(r105, r102);     // Catch: SQLiteException -> L9
        return r105.executeUpdateDelete();
    L6:
        r104 = " WHERE " + r101;     // Catch: SQLiteException -> L9
    L9:
        e = move-exception;
        e.a(e, "delete");
        FLogger.f375446a.e("FlowSQLiteDatabase", "delete err", e);
        return 0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String r100, int r101, ContentValues r102) throws SQLException {
        return this.f563892a.insertWithOnConflict(r100, null, r102, r101);
    L4:
        e = move-exception;
        e.a(e, "insert");
        FLogger.f375446a.e("FlowSQLiteDatabase", "insert err", e);
        return 0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r100, int r101, ContentValues r110, String r111, Object[] r112) {
        if (r110 == null) goto L28;
    L29:
        e = move-exception;
        e.a(e, "update");
        FLogger.f375446a.e("FlowSQLiteDatabase", "update err", e);
        return 0;
    L5:
        if (r110.size() == 0) goto L28;
        StringBuilder r102 = new StringBuilder(120);     // Catch: SQLiteException -> L29
        r102.append("UPDATE ");     // Catch: SQLiteException -> L29
        r102.append(f563890b[r101]);     // Catch: SQLiteException -> L29
        r102.append(r100);     // Catch: SQLiteException -> L29
        r102.append(" SET ");     // Catch: SQLiteException -> L29
        int r103 = r110.size();     // Catch: SQLiteException -> L29
        if (r112 != null) goto L9;
        int r104 = r103;
    L10:
        Object[] r105 = new Object[r104];     // Catch: SQLiteException -> L29
        Iterator<String> r106 = r110.keySet().iterator();     // Catch: SQLiteException -> L29
        int r107 = 0;
    L12:
        if (r106.hasNext() == false) goto L18;
        String r108 = r106.next();     // Catch: SQLiteException -> L29
        if (r107 <= 0) goto L16;
        String r109 = ",";
    L17:
        r102.append(r109);     // Catch: SQLiteException -> L29
        r102.append(r108);     // Catch: SQLiteException -> L29
        r105[r107] = r110.get(r108);     // Catch: SQLiteException -> L29
        r102.append("=?");     // Catch: SQLiteException -> L29
        r107 = r107 + 1;     // Catch: SQLiteException -> L29
        goto L12
    L16:
        r109 = "";
        goto L17
    L18:
        if (r112 == null) goto L23;
        int r113 = r103;
    L20:
        if (r113 >= r104) goto L23;
        r105[r113] = r112[r113 - r103];     // Catch: SQLiteException -> L29
        r113 = r113 + 1;     // Catch: SQLiteException -> L29
    L23:
        if (TextUtils.isEmpty(r111) == true) goto L25;
        r102.append(" WHERE ");     // Catch: SQLiteException -> L29
        r102.append(r111);     // Catch: SQLiteException -> L29
    L25:
        SupportSQLiteStatement r114 = compileStatement(r102.toString());     // Catch: SQLiteException -> L29
        SimpleSQLiteQuery.bind(r114, r105);     // Catch: SQLiteException -> L29
        return r114.executeUpdateDelete();
    L9:
        r104 = r112.length + r103;     // Catch: SQLiteException -> L29
    L28:
        throw new IllegalArgumentException("Empty values");     // Catch: SQLiteException -> L29
    }
}
