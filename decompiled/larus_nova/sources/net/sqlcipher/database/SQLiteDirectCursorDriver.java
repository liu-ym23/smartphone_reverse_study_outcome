package net.sqlcipher.database;

import net.sqlcipher.Cursor;

/* JADX INFO: loaded from: classes42.dex */
public class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private Cursor mCursor;
    private SQLiteDatabase mDatabase;
    private String mEditTable;
    private SQLiteQuery mQuery;
    private String mSql;

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorClosed() {
        this.mCursor = null;
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorDeactivated() {
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorRequeried(android.database.Cursor r100) {
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void setBindArguments(String[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        int r103 = r102 + 1;
        this.mQuery.bindString(r103, r100[r102]);
        r102 = r103;
        goto L3
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public Cursor query(SQLiteDatabase.CursorFactory r100, String[] r101) {
        int r102 = 0;
        SQLiteQuery r103 = new SQLiteQuery(this.mDatabase, this.mSql, 0, r101);
        if (r101 != null) goto L22;
        int r104 = 0;
    L6:
        if (r102 >= r104) goto L8;
        int r105 = r102 + 1;     // Catch: Throwable -> L16
        r103.bindString(r105, r101[r102]);     // Catch: Throwable -> L16
        r102 = r105;
        goto L6
    L8:
        if (r100 != null) goto L10;
        this.mCursor = new SQLiteCursor(this.mDatabase, this, this.mEditTable, r103);     // Catch: Throwable -> L16
    L11:
        this.mQuery = r103;     // Catch: Throwable -> L16
        return this.mCursor;
    L14:
        th = th;
        r103 = null;
    L17:
        if (r103 == null) goto L19;
        r103.close();
    L19:
        throw th;
    L16:
        th = th;
        goto L17
    L10:
        this.mCursor = r100.newCursor(this.mDatabase, this, this.mEditTable, r103);     // Catch: Throwable -> L16
        goto L11
    L22:
        r104 = r101.length;     // Catch: Throwable -> L16
        goto L6
    }

    public Cursor query(SQLiteDatabase.CursorFactory r100, Object[] r101) {
        SQLiteQuery r102 = new SQLiteQuery(this.mDatabase, this.mSql, 0, r101);
        r102.bindArguments(r101);     // Catch: Throwable -> L12
        if (r100 != null) goto L6;
        this.mCursor = new SQLiteCursor(this.mDatabase, this, this.mEditTable, r102);     // Catch: Throwable -> L12
    L7:
        this.mQuery = r102;     // Catch: Throwable -> L12
        return this.mCursor;
    L10:
        th = th;
        r102 = null;
    L13:
        if (r102 == null) goto L15;
        r102.close();
    L15:
        throw th;
    L6:
        this.mCursor = r100.newCursor(this.mDatabase, this, this.mEditTable, r102);     // Catch: Throwable -> L12
    L12:
        th = th;
        goto L13
    }

    public SQLiteDirectCursorDriver(SQLiteDatabase r100, String r101, String r102) {
        this.mDatabase = r100;
        this.mEditTable = r102;
        this.mSql = r101;
    }
}
