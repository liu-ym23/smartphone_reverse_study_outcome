package com.commonsware.cwac.saferoom;

import androidx.sqlite.db.SupportSQLiteStatement;
import net.sqlcipher.database.SQLiteStatement;

/* JADX INFO: loaded from: classes22.dex */
class Statement extends Program implements SupportSQLiteStatement {
    private final SQLiteStatement safeStatement;

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.safeStatement.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        return this.safeStatement.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        return this.safeStatement.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        return this.safeStatement.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        return this.safeStatement.simpleQueryForString();
    }

    public Statement(SQLiteStatement r100) {
        super(r100);
        this.safeStatement = r100;
    }
}
