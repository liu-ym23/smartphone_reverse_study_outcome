package net.sqlcipher.database;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* JADX INFO: loaded from: classes42.dex */
public class SupportHelper implements SupportSQLiteOpenHelper {
    private final boolean clearPassphrase;
    private byte[] passphrase;
    private SQLiteOpenHelper standardHelper;

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        SQLiteDatabase r100 = this.standardHelper.getWritableDatabase(this.passphrase);     // Catch: SQLiteException -> L13
        if (this.clearPassphrase == true) goto L7;
    L12:
        return r100;
    L7:
        if (this.passphrase == null) goto L12;
        int r101 = 0;
    L9:
        byte[] r102 = this.passphrase;
        if (r101 >= r102.length) goto L12;
        r102[r101] = 0;
        r101 = r101 + 1;
    L13:
        e = move-exception;
        byte[] r103 = this.passphrase;
        if (r103 == null) goto L27;
        int r104 = r103.length;
        int r105 = 0;
        boolean r106 = true;
    L17:
        if (r105 >= r104) goto L24;
        byte r107 = r103[r105];
        if (r106 == false) goto L22;
        if (r107 != 0) goto L22;
        r106 = true;
    L23:
        r105 = r105 + 1;
    L22:
        r106 = false;
        goto L23
    L24:
        if (r106 == false) goto L27;
        throw new IllegalStateException("The passphrase appears to be cleared. This happens by default the first time you use the factory to open a database, so we can remove the cleartext passphrase from memory. If you close the database yourself, please use a fresh SupportFactory to reopen it. If something else (e.g., Room) closed the database, and you cannot control that, use SupportFactory boolean constructor option to opt out of the automatic password clearing step. See the project README for more information.", e);
    L27:
        throw e;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.standardHelper.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.standardHelper.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r100) {
        this.standardHelper.setWriteAheadLoggingEnabled(r100);
    }

    public SupportHelper(final SupportSQLiteOpenHelper.Configuration r110, byte[] r111, final SQLiteDatabaseHook r112, boolean r113) {
        SQLiteDatabase.loadLibs(r110.context);
        this.passphrase = r111;
        this.clearPassphrase = r113;
        final Context r100 = r110.context;
        final String r101 = r110.name;
        final SQLiteDatabase.CursorFactory r102 = null;
        final int r103 = r110.callback.version;
        this.standardHelper = new AnonymousClass1(this, r100, r101, r102, r103, r112, r110);
    }
}
