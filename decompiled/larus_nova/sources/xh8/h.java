package xh8;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes25.dex */
public final class h extends g implements SupportSQLiteStatement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SQLiteStatement f563908b;

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final void execute() {
        this.f563908b.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long executeInsert() {
        return this.f563908b.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final int executeUpdateDelete() {
        return this.f563908b.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long simpleQueryForLong() {
        return this.f563908b.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final String simpleQueryForString() {
        return this.f563908b.simpleQueryForString();
    }

    public h(SQLiteStatement r100) {
        super(r100);
        this.f563908b = r100;
    }
}
