package com.commonsware.cwac.saferoom;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes22.dex */
class Helper implements SupportSQLiteOpenHelper {
    private final boolean clearPassphrase;
    private final OpenHelper delegate;
    private final byte[] passphrase;

    public static class OpenHelper extends SQLiteOpenHelper {
        private volatile SupportSQLiteOpenHelper.Callback callback;
        private final Database[] dbRef;
        private volatile boolean migrated;

        @Override // net.sqlcipher.database.SQLiteOpenHelper
        public synchronized void close() {
            monitor-enter(this);
            super.close();     // Catch: Throwable -> L6
            this.dbRef[0] = null;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized Database getWrappedDb(SQLiteDatabase r100) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.dbRef[0] != null) goto L6;
            Database r101 = new Database(r100);     // Catch: Throwable -> L9
            this.dbRef[0] = r101;     // Catch: Throwable -> L9
        L6:
            Database r102 = this.dbRef[0];     // Catch: Throwable -> L9
            monitor-exit(this);
            return r102;
        }

        public synchronized SupportSQLiteDatabase getWritableSupportDatabase(byte[] r100) {
            monitor-enter(this);
            this.migrated = false;     // Catch: Throwable -> L12
            SQLiteDatabase r101 = super.getWritableDatabase(r100);     // Catch: Throwable -> L12
            if (this.migrated == false) goto L9;
            close();     // Catch: Throwable -> L12
            SupportSQLiteDatabase r102 = getWritableSupportDatabase(r100);     // Catch: Throwable -> L12
            monitor-exit(this);
            return r102;
        L9:
            Database r103 = getWrappedDb(r101);     // Catch: Throwable -> L12
            monitor-exit(this);
            return r103;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // net.sqlcipher.database.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase r100) {
            this.callback.onConfigure(getWrappedDb(r100));
        }

        @Override // net.sqlcipher.database.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r100) {
            this.callback.onCreate(getWrappedDb(r100));
        }

        @Override // net.sqlcipher.database.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r100) {
            if (this.migrated == true) goto L6;
            this.callback.onOpen(getWrappedDb(r100));
            return;
        }

        @Override // net.sqlcipher.database.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
            this.migrated = true;
            this.callback.onDowngrade(getWrappedDb(r100), r101, r102);
        }

        @Override // net.sqlcipher.database.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
            this.migrated = true;
            this.callback.onUpgrade(getWrappedDb(r100), r101, r102);
        }

        public OpenHelper(Context r100, String r101, final Database[] r110, final SupportSQLiteOpenHelper.Callback r111, final SafeHelperFactory.Options r112) {
            super(r100, r101, null, r111.version, new AnonymousClass1(r112), new AnonymousClass2(r110, r111));
            this.dbRef = r110;
            this.callback = r111;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        this.delegate.close();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized String getDatabaseName() {
        monitor-enter(this);
        String r100 = this.delegate.getDatabaseName();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        monitor-enter(this);
        SupportSQLiteDatabase r100 = this.delegate.getWritableSupportDatabase(this.passphrase);     // Catch: Throwable -> L16 SQLiteException -> L18
    L6:
        if (this.clearPassphrase == true) goto L8;
    L14:
        monitor-exit(this);
        return r100;
    L8:
        if (this.passphrase == null) goto L14;
        int r101 = 0;
    L10:
        byte[] r102 = this.passphrase;     // Catch: Throwable -> L16
        if (r101 >= r102.length) goto L14;
        r102[r101] = 0;     // Catch: Throwable -> L16
        r101 = r101 + 1;
    L18:
        e = move-exception;
        byte[] r103 = this.passphrase;     // Catch: Throwable -> L16
        if (r103 == null) goto L32;
        int r104 = r103.length;     // Catch: Throwable -> L16
        int r105 = 0;
        boolean r106 = true;
    L22:
        if (r105 >= r104) goto L29;
        byte r107 = r103[r105];     // Catch: Throwable -> L16
        if (r106 == false) goto L27;
        if (r107 != 0) goto L27;
        r106 = true;
    L28:
        r105 = r105 + 1;     // Catch: Throwable -> L16
    L27:
        r106 = false;
        goto L28
    L29:
        if (r106 == false) goto L32;
        throw new IllegalStateException("The passphrase appears to be cleared. This happens bydefault the first time you use the factory to open a database, so we can remove thecleartext passphrase from memory. If you close the database yourself, please use afresh SafeHelperFactory to reopen it. If something else (e.g., Room) closed thedatabase, and you cannot control that, use SafeHelperFactory.Options to opt out ofthe automatic password clearing step. See the project README for more information.");     // Catch: Throwable -> L16
    L32:
        throw e;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized void setWriteAheadLoggingEnabled(boolean r100) {
        monitor-enter(this);
        this.delegate.setWriteAheadLoggingEnabled(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private OpenHelper createDelegate(Context r100, String r101, SupportSQLiteOpenHelper.Callback r110, SafeHelperFactory.Options r111) {
        return new OpenHelper(r100, r101, new Database[1], r110, r111);
    }

    public Helper(Context r100, String r101, SupportSQLiteOpenHelper.Callback r102, byte[] r103, SafeHelperFactory.Options r104) {
        SQLiteDatabase.loadLibs(r100);
        this.clearPassphrase = r104.clearPassphrase;
        this.delegate = createDelegate(r100, r101, r102, r104);
        this.passphrase = r103;
    }
}
