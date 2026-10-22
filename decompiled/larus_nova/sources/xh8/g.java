package xh8;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: loaded from: classes25.dex */
public class g implements SupportSQLiteProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteProgram f563907a;

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void clearBindings() {
        this.f563907a.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f563907a.close();
    }

    public g(SQLiteProgram r100) {
        this.f563907a = r100;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int r100) {
        this.f563907a.bindNull(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int r100, byte[] r101) {
        this.f563907a.bindBlob(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int r100, double r101) {
        this.f563907a.bindDouble(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int r100, long r101) {
        this.f563907a.bindLong(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(int r100, String r101) {
        this.f563907a.bindString(r100, r101);
    }
}
