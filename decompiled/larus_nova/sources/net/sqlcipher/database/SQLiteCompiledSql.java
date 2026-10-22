package net.sqlcipher.database;

/* JADX INFO: loaded from: classes42.dex */
class SQLiteCompiledSql {
    private static final String TAG = "SQLiteCompiledSql";
    SQLiteDatabase mDatabase;
    private boolean mInUse;
    private String mSqlStmt;
    long nHandle;
    long nStatement;

    private final native void native_compile(String r100);

    private final native void native_finalize();

    public synchronized boolean acquire() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mInUse == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        this.mInUse = true;     // Catch: Throwable -> L14
        if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION == false) goto L12;
    L12:
        monitor-exit(this);
        return true;
    }

    public synchronized void release() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION == true) goto L6;
    L6:
        this.mInUse = false;     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    public void finalize() throws Throwable {
    L13:
        th = move-exception;
        super.finalize();
        throw th;
    L4:
        if (this.nStatement != 0) goto L8;
        super.finalize();
        return;
    L8:
        if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION == true) goto L10;
    L10:
        releaseSqlStatement();     // Catch: Throwable -> L13
        super.finalize();
    }

    public void releaseSqlStatement() {
        if (this.nStatement != 0) goto L5;
        return;
    L5:
        if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION == true) goto L7;
    L7:
        native_finalize();
        this.nStatement = 0;
    }

    public SQLiteCompiledSql(SQLiteDatabase r100, String r101) {
        this.nHandle = 0;
        this.nStatement = 0;
        this.mSqlStmt = null;
        this.mInUse = false;
        if (r100.isOpen() == false) goto L7;
        this.mDatabase = r100;
        this.mSqlStmt = r101;
        this.nHandle = r100.mNativeHandle;
        compile(r101, true);
        return;
    L7:
        throw new IllegalStateException("database " + r100.getPath() + " already closed");
    }

    private void compile(String r100, boolean r101) {
        if (this.mDatabase.isOpen() == false) goto L13;
        if (r101 == false) goto L11;
        this.mDatabase.lock();
        native_compile(r100);     // Catch: Throwable -> L8
        this.mDatabase.unlock();
        return;
    L8:
        th = move-exception;
        this.mDatabase.unlock();
        throw th;
    L11:
        return;
    L13:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
}
