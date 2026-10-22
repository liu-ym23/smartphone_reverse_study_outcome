package com.commonsware.cwac.saferoom;

import androidx.sqlite.db.SupportSQLiteProgram;
import net.sqlcipher.database.SQLiteProgram;

/* JADX INFO: loaded from: classes22.dex */
class Program implements SupportSQLiteProgram {
    private final SQLiteProgram delegate;

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public Program(SQLiteProgram r100) {
        this.delegate = r100;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r100) {
        this.delegate.bindNull(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r100, byte[] r101) {
        this.delegate.bindBlob(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r100, double r101) {
        this.delegate.bindDouble(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r100, long r101) {
        this.delegate.bindLong(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r100, String r101) {
        this.delegate.bindString(r100, r101);
    }
}
