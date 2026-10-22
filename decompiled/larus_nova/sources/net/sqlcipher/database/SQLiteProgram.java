package net.sqlcipher.database;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
public abstract class SQLiteProgram extends SQLiteClosable implements SupportSQLiteProgram {
    private static final String TAG = "SQLiteProgram";
    boolean mClosed;
    private SQLiteCompiledSql mCompiledSql;
    protected SQLiteDatabase mDatabase;
    final String mSql;
    protected long nHandle;
    protected long nStatement;

    private final native void native_clear_bindings();

    public void compile(String r100, boolean r101) {
    }

    public final native void native_bind_blob(int r100, byte[] r101);

    public final native void native_bind_double(int r100, double r101);

    public final native void native_bind_long(int r100, long r101);

    public final native void native_bind_null(int r100);

    public final native void native_bind_string(int r100, String r101);

    public final native void native_compile(String r100);

    public final native void native_finalize();

    private void releaseCompiledSqlIfNotInCache() {
        if (this.mCompiledSql != null) goto L5;
        return;
    L5:
        Map<String, SQLiteCompiledSql> r100 = this.mDatabase.mCompiledQueries;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.mDatabase.mCompiledQueries.containsValue(this.mCompiledSql) == true) goto L10;
        this.mCompiledSql.releaseSqlStatement();     // Catch: Throwable -> L13
        this.mCompiledSql = null;     // Catch: Throwable -> L13
        this.nStatement = 0;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L10:
        this.mCompiledSql.release();     // Catch: Throwable -> L13
        goto L11
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        if (this.mClosed == true) goto L16;
        if (this.mDatabase.isOpen() == false) goto L14;
        acquireReference();
        native_clear_bindings();     // Catch: Throwable -> L10
        releaseReference();
        return;
    L10:
        th = move-exception;
        releaseReference();
        throw th;
    L14:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    L16:
        throw new IllegalStateException("program already closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.mClosed == false) goto L6;
        return;
    L6:
        if (this.mDatabase.isOpen() == true) goto L8;
        return;
    L8:
        this.mDatabase.lock();
        releaseReference();     // Catch: Throwable -> L12
        this.mDatabase.unlock();
        this.mClosed = true;
        return;
    L12:
        th = move-exception;
        this.mDatabase.unlock();
        throw th;
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    public void onAllReferencesReleased() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
        this.mDatabase.removeSQLiteClosable(this);
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    public void onAllReferencesReleasedFromContainer() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
    }

    public String getSqlString() {
        return this.mSql;
    }

    public final long getUniqueId() {
        return this.nStatement;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r100) {
        if (this.mClosed == true) goto L16;
        if (this.mDatabase.isOpen() == false) goto L14;
        acquireReference();
        native_bind_null(r100);     // Catch: Throwable -> L10
        releaseReference();
        return;
    L10:
        th = move-exception;
        releaseReference();
        throw th;
    L14:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    L16:
        throw new IllegalStateException("program already closed");
    }

    public SQLiteProgram(SQLiteDatabase r100, String r101) {
        this.nHandle = 0;
        this.nStatement = 0;
        this.mClosed = false;
        this.mDatabase = r100;
        String r102 = r101.trim();
        this.mSql = r102;
        r100.acquireReference();
        r100.addSQLiteClosable(this);
        this.nHandle = r100.mNativeHandle;
        if (r102.length() < 6) goto L6;
        r102 = r102.substring(0, 6);
    L6:
        if (r102.equalsIgnoreCase("INSERT") == false) goto L8;
    L17:
        SQLiteCompiledSql r103 = r100.getCompiledStatementForSql(r101);
        this.mCompiledSql = r103;
        if (r103 != null) goto L23;
        SQLiteCompiledSql r104 = new SQLiteCompiledSql(r100, r101);
        this.mCompiledSql = r104;
        r104.acquire();
        r100.addToCompiledQueries(r101, this.mCompiledSql);
        if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION == false) goto L27;
        long r105 = this.mCompiledSql.nStatement;
    L27:
        this.nStatement = this.mCompiledSql.nStatement;
        return;
    L23:
        if (r103.acquire() == true) goto L27;
        long r106 = this.mCompiledSql.nStatement;
        this.mCompiledSql = new SQLiteCompiledSql(r100, r101);
        if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION == false) goto L27;
        goto L27
    L8:
        if (r102.equalsIgnoreCase("UPDATE") == true) goto L17;
        if (r102.equalsIgnoreCase("REPLAC") == true) goto L17;
        if (r102.equalsIgnoreCase("DELETE") == true) goto L17;
        if (r102.equalsIgnoreCase("SELECT") == true) goto L17;
        SQLiteCompiledSql r107 = new SQLiteCompiledSql(r100, r101);
        this.mCompiledSql = r107;
        this.nStatement = r107.nStatement;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r100, byte[] r101) {
        if (r101 == null) goto L19;
        if (this.mClosed == true) goto L17;
        if (this.mDatabase.isOpen() == false) goto L15;
        acquireReference();
        native_bind_blob(r100, r101);     // Catch: Throwable -> L11
        releaseReference();
        return;
    L11:
        th = move-exception;
        releaseReference();
        throw th;
    L15:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    L17:
        throw new IllegalStateException("program already closed");
    L19:
        throw new IllegalArgumentException("the bind value at index " + r100 + " is null");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r100, double r101) {
        if (this.mClosed == true) goto L16;
        if (this.mDatabase.isOpen() == false) goto L14;
        acquireReference();
        native_bind_double(r100, r101);     // Catch: Throwable -> L10
        releaseReference();
        return;
    L10:
        th = move-exception;
        releaseReference();
        throw th;
    L14:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    L16:
        throw new IllegalStateException("program already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r100, long r101) {
        if (this.mClosed == true) goto L16;
        if (this.mDatabase.isOpen() == false) goto L14;
        acquireReference();
        native_bind_long(r100, r101);     // Catch: Throwable -> L10
        releaseReference();
        return;
    L10:
        th = move-exception;
        releaseReference();
        throw th;
    L14:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    L16:
        throw new IllegalStateException("program already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r100, String r101) {
        if (r101 == null) goto L19;
        if (this.mClosed == true) goto L17;
        if (this.mDatabase.isOpen() == false) goto L15;
        acquireReference();
        native_bind_string(r100, r101);     // Catch: Throwable -> L11
        releaseReference();
        return;
    L11:
        th = move-exception;
        releaseReference();
        throw th;
    L15:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    L17:
        throw new IllegalStateException("program already closed");
    L19:
        throw new IllegalArgumentException("the bind value at index " + r100 + " is null");
    }
}
