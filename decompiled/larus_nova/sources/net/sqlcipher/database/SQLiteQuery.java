package net.sqlcipher.database;

import android.os.SystemClock;
import net.sqlcipher.CursorWindow;

/* JADX INFO: loaded from: classes42.dex */
public class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "Cursor";
    private String[] mBindArgs;
    private Object[] mObjectBindArgs;
    private int mOffsetIndex;

    private final native int native_column_count();

    private final native String native_column_name(int r100);

    private final native int native_fill_window(CursorWindow r100, int r101, int r102, int r103, int r104, int r105);

    public void requery() {
        String[] r100 = this.mBindArgs;
        if (r100 == null) goto L19;
        int r101 = r100.length;
        int r102 = 0;
        Object[] r103 = this.mObjectBindArgs;     // Catch: SQLiteMisuseException -> L12
        if (r103 == null) goto L8;
        bindArguments(r103);     // Catch: SQLiteMisuseException -> L12
        return;
    L8:
        int r104 = 0;
    L9:
        if (r104 >= r101) goto L24;
        int r105 = r104 + 1;     // Catch: SQLiteMisuseException -> L12
        super.bindString(r105, this.mBindArgs[r104]);     // Catch: SQLiteMisuseException -> L12
        r104 = r105;
        goto L9
    L24:
        return;
    L12:
        e = move-exception;
        StringBuilder r106 = new StringBuilder("mSql " + this.mSql);
    L15:
        if (r102 >= r101) goto L17;
        r106.append(" ");
        r106.append(this.mBindArgs[r102]);
        r102 = r102 + 1;
        goto L15
    L17:
        r106.append(" ");
        throw new IllegalStateException(r106.toString(), e);
    }

    public String toString() {
        return "SQLiteQuery: " + this.mSql;
    }

    public int columnCountLocked() {
        acquireReference();
        int r100 = native_column_count();     // Catch: Throwable -> L6
        releaseReference();
        return r100;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void bindArguments(Object[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 0) goto L45;
        int r101 = 0;
    L7:
        if (r101 >= r100.length) goto L46;
        Object r102 = r100[r101];
        if (r102 != null) goto L12;
        bindNull(r101 + 1);
    L34:
        r101 = r101 + 1;
        goto L7
    L12:
        if ((r102 instanceof Double) == false) goto L15;
        bindDouble(r101 + 1, ((Double) r102).doubleValue());
        goto L34
    L15:
        if ((r102 instanceof Float) == false) goto L18;
        bindDouble(r101 + 1, Double.valueOf(((Number) r102).floatValue()).doubleValue());
        goto L34
    L18:
        if ((r102 instanceof Long) == false) goto L21;
        bindLong(r101 + 1, ((Long) r102).longValue());
        goto L34
    L21:
        if ((r102 instanceof Integer) == false) goto L24;
        bindLong(r101 + 1, Long.valueOf(((Number) r102).intValue()).longValue());
        goto L34
    L24:
        if ((r102 instanceof Boolean) == false) goto L31;
        int r103 = r101 + 1;
        if (((Boolean) r102).booleanValue() == false) goto L28;
        long r104 = 1;
    L29:
        bindLong(r103, r104);
        goto L34
    L28:
        r104 = 0;
        goto L29
    L31:
        if ((r102 instanceof byte[]) == false) goto L33;
        bindBlob(r101 + 1, (byte[]) r102);
        goto L34
    L33:
        bindString(r101 + 1, r102.toString());
        goto L34
    L46:
        return;
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r100) {
        this.mBindArgs[r100 - 1] = null;
        if (this.mClosed == true) goto L6;
        super.bindNull(r100);
        return;
    }

    public String columnNameLocked(int r100) {
        acquireReference();
        String r101 = native_column_name(r100);     // Catch: Throwable -> L6
        releaseReference();
        return r101;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r100, double r101) {
        this.mBindArgs[r100 - 1] = Double.toString(r101);
        if (this.mClosed == true) goto L6;
        super.bindDouble(r100, r101);
        return;
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r100, long r101) {
        this.mBindArgs[r100 - 1] = Long.toString(r101);
        if (this.mClosed == true) goto L6;
        super.bindLong(r100, r101);
        return;
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r100, String r101) {
        this.mBindArgs[r100 - 1] = r101;
        if (this.mClosed == true) goto L6;
        super.bindString(r100, r101);
        return;
    }

    public int fillWindow(CursorWindow r100, int r110, int r111) {
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        acquireReference();     // Catch: Throwable -> L20
        r100.acquireReference();     // Catch: Throwable -> L10 SQLiteDatabaseCorruptException -> L12 IllegalStateException -> L17
        int r112 = native_fill_window(r100, r100.getStartPosition(), r100.getRequiredPosition(), this.mOffsetIndex, r110, r111);     // Catch: Throwable -> L10 SQLiteDatabaseCorruptException -> L12 IllegalStateException -> L17
        if (SQLiteDebug.DEBUG_SQL_STATEMENTS == false) goto L7;
    L7:
        r100.releaseReference();     // Catch: Throwable -> L20
        releaseReference();
        this.mDatabase.unlock();
        return r112;
    L10:
        th = move-exception;
        r100.releaseReference();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L17:
        r100.releaseReference();     // Catch: Throwable -> L20
        releaseReference();
        this.mDatabase.unlock();
        return 0;
    L12:
        e = move-exception;
        this.mDatabase.onCorruption();     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    L20:
        th = move-exception;
        releaseReference();
        this.mDatabase.unlock();
        throw th;
    }

    public SQLiteQuery(SQLiteDatabase r100, String r101, int r102, Object[] r103) {
        super(r100, r101);
        this.mOffsetIndex = r102;
        this.mObjectBindArgs = r103;
        if (r103 == null) goto L5;
        int r104 = r103.length;
    L6:
        this.mBindArgs = new String[r104];
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public SQLiteQuery(SQLiteDatabase r100, String r101, int r102, String[] r103) {
        super(r100, r101);
        this.mOffsetIndex = r102;
        this.mBindArgs = r103;
    }
}
