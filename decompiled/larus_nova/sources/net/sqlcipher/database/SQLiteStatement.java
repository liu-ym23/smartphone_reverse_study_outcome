package net.sqlcipher.database;

import android.os.SystemClock;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes42.dex */
public class SQLiteStatement extends SQLiteProgram implements SupportSQLiteStatement {
    private final native long native_1x1_long();

    private final native String native_1x1_string();

    private final native void native_execute();

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        if (this.mDatabase.isOpen() == false) goto L12;
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        acquireReference();
        native_execute();     // Catch: Throwable -> L8
        releaseReference();
        this.mDatabase.unlock();
        return;
    L8:
        th = move-exception;
        releaseReference();
        this.mDatabase.unlock();
        throw th;
    L12:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        if (this.mDatabase.isOpen() == false) goto L16;
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        acquireReference();
        native_execute();     // Catch: Throwable -> L12
        if (this.mDatabase.lastChangeCount() <= 0) goto L9;
        long r100 = this.mDatabase.lastInsertRow();     // Catch: Throwable -> L12
    L10:
        releaseReference();
        this.mDatabase.unlock();
        return r100;
    L9:
        r100 = -1;
    L12:
        th = move-exception;
        releaseReference();
        this.mDatabase.unlock();
        throw th;
    L16:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        if (this.mDatabase.isOpen() == false) goto L12;
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        acquireReference();
        native_execute();     // Catch: Throwable -> L8
        int r100 = this.mDatabase.lastChangeCount();     // Catch: Throwable -> L8
        releaseReference();
        this.mDatabase.unlock();
        return r100;
    L8:
        th = move-exception;
        releaseReference();
        this.mDatabase.unlock();
        throw th;
    L12:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        if (this.mDatabase.isOpen() == false) goto L12;
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        acquireReference();
        long r100 = native_1x1_long();     // Catch: Throwable -> L8
        releaseReference();
        this.mDatabase.unlock();
        return r100;
    L8:
        th = move-exception;
        releaseReference();
        this.mDatabase.unlock();
        throw th;
    L12:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        if (this.mDatabase.isOpen() == false) goto L12;
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        acquireReference();
        String r100 = native_1x1_string();     // Catch: Throwable -> L8
        releaseReference();
        this.mDatabase.unlock();
        return r100;
    L8:
        th = move-exception;
        releaseReference();
        this.mDatabase.unlock();
        throw th;
    L12:
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    public SQLiteStatement(SQLiteDatabase r100, String r101) {
        super(r100, r101);
    }
}
