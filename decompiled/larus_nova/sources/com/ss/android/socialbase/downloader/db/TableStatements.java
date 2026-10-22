package com.ss.android.socialbase.downloader.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.utils.SqlUtils;

/* JADX INFO: loaded from: classes5.dex */
public class TableStatements {
    private final String[] allColumns;
    private final SQLiteDatabase database;
    private SQLiteStatement deleteStatement;
    private SQLiteStatement insertOrReplaceStatement;
    private SQLiteStatement insertStatement;
    private final String[] pkColumns;
    private final String tableName;
    private SQLiteStatement updateStatement;

    public SQLiteStatement getDeleteStatement() {
        if (this.deleteStatement != null) goto L17;
        String r100 = SqlUtils.createSqlDelete(this.tableName, this.pkColumns);
        SQLiteStatement r101 = this.database.compileStatement(r100);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.deleteStatement != null) goto L9;
        this.deleteStatement = r101;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.deleteStatement == r101) goto L17;
        r101.close();
    L17:
        return this.deleteStatement;
    }

    public SQLiteStatement getInsertOrReplaceStatement() {
        if (this.insertOrReplaceStatement != null) goto L17;
        String r100 = SqlUtils.createSqlInsertOrReplace(this.tableName, this.allColumns, this.pkColumns);
        SQLiteStatement r101 = this.database.compileStatement(r100);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.insertOrReplaceStatement != null) goto L9;
        this.insertOrReplaceStatement = r101;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.insertOrReplaceStatement == r101) goto L17;
        r101.close();
    L17:
        return this.insertOrReplaceStatement;
    }

    public SQLiteStatement getInsertStatement() {
        if (this.insertStatement != null) goto L17;
        String r100 = SqlUtils.createSqlInsert("INSERT INTO ", this.tableName, this.allColumns);
        SQLiteStatement r101 = this.database.compileStatement(r100);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.insertStatement != null) goto L9;
        this.insertStatement = r101;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.insertStatement == r101) goto L17;
        r101.close();
    L17:
        return this.insertStatement;
    }

    public SQLiteStatement getUpdateStatement() {
        if (this.updateStatement != null) goto L17;
        String r100 = SqlUtils.createSqlUpdate(this.tableName, this.allColumns, this.pkColumns);
        SQLiteStatement r101 = this.database.compileStatement(r100);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.updateStatement != null) goto L9;
        this.updateStatement = r101;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.updateStatement == r101) goto L17;
        r101.close();
    L17:
        return this.updateStatement;
    }

    public TableStatements(SQLiteDatabase r100, String r101, String[] r102, String[] r103) {
        this.database = r100;
        this.tableName = r101;
        this.allColumns = r102;
        this.pkColumns = r103;
    }
}
