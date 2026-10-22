package xh8;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;

/* JADX INFO: loaded from: classes25.dex */
public final class b implements SupportSQLiteStatement {
    public b() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int r100, byte[] r101) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int r100, double r101) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int r100, long r101) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int r100) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(int r100, String r101) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void clearBindings() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final void execute() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long executeInsert() {
        return 0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final int executeUpdateDelete() {
        return 0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long simpleQueryForLong() {
        return 0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final String simpleQueryForString() {
        return null;
    }
}
