package com.tencent.wcdb.compat.room;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.tencent.wcdb.compat.SQLiteCipherSpec;
import com.tencent.wcdb.compat.SQLiteDatabase;
import com.tencent.wcdb.compat.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes40.dex */
class WCDBOpenHelper implements SupportSQLiteOpenHelper {
    private final OpenHelper mDelegate;

    public static class OpenHelper extends SQLiteOpenHelper {
        boolean mAsyncCheckpoint;
        final SupportSQLiteOpenHelper.Callback mCallback;
        final WCDBDatabase[] mDbRef;

        @Override // com.tencent.wcdb.compat.SQLiteOpenHelper
        public synchronized void close() {
            monitor-enter(this);
            super.close();     // Catch: Throwable -> L6
            this.mDbRef[0] = null;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public SupportSQLiteDatabase getReadableSupportDatabase() {
            return getWrappedDb(super.getWritableDatabase());
        }

        public SupportSQLiteDatabase getWritableSupportDatabase() {
            return getWrappedDb(super.getWritableDatabase());
        }

        public WCDBDatabase getWrappedDb(SQLiteDatabase r100) {
            if (this.mDbRef[0] != null) goto L6;
            WCDBDatabase r101 = new WCDBDatabase(r100);
            this.mDbRef[0] = r101;
        L6:
            return this.mDbRef[0];
        }

        @Override // com.tencent.wcdb.compat.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase r100) {
            this.mCallback.onConfigure(getWrappedDb(r100));
        }

        @Override // com.tencent.wcdb.compat.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r100) {
            this.mCallback.onCreate(getWrappedDb(r100));
        }

        @Override // com.tencent.wcdb.compat.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r100) {
            this.mCallback.onOpen(getWrappedDb(r100));
        }

        @Override // com.tencent.wcdb.compat.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
            this.mCallback.onDowngrade(getWrappedDb(r100), r101, r102);
        }

        @Override // com.tencent.wcdb.compat.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
            this.mCallback.onUpgrade(getWrappedDb(r100), r101, r102);
        }

        public OpenHelper(Context r100, String r101, final WCDBDatabase[] r110, byte[] r111, SQLiteCipherSpec r112, final SupportSQLiteOpenHelper.Callback r113) {
            super(r100, r101, r111, r112, r113.version, new AnonymousClass1(r110, r113));
            this.mCallback = r113;
            this.mDbRef = r110;
            this.mAsyncCheckpoint = false;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r100) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return this.mDelegate.getReadableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return this.mDelegate.getWritableSupportDatabase();
    }

    public void setAsyncCheckpointEnabled(boolean r100) {
        this.mDelegate.mAsyncCheckpoint = r100;
    }

    public WCDBOpenHelper(Context r100, String r101, byte[] r102, SQLiteCipherSpec r103, SupportSQLiteOpenHelper.Callback r104) {
        this.mDelegate = createDelegate(r100, r101, r102, r103, r104);
    }

    private OpenHelper createDelegate(Context r100, String r110, byte[] r111, SQLiteCipherSpec r112, SupportSQLiteOpenHelper.Callback r113) {
        return new OpenHelper(r100, r110, new WCDBDatabase[1], r111, r112, r113);
    }
}
