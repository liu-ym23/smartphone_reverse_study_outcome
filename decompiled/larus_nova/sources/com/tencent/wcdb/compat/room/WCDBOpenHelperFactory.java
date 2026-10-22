package com.tencent.wcdb.compat.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.tencent.wcdb.compat.SQLiteCipherSpec;

/* JADX INFO: loaded from: classes40.dex */
public class WCDBOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private boolean mAsyncCheckpoint;
    private SQLiteCipherSpec mCipherSpec;
    private byte[] mPassphrase;
    private boolean mWALMode;

    public WCDBOpenHelperFactory() {
    }

    public WCDBOpenHelperFactory asyncCheckpointEnabled(boolean r100) {
        this.mAsyncCheckpoint = r100;
        return this;
    }

    public WCDBOpenHelperFactory cipherSpec(SQLiteCipherSpec r100) {
        this.mCipherSpec = r100;
        return this;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r100) {
        WCDBOpenHelper r101 = new WCDBOpenHelper(r100.context, r100.name, this.mPassphrase, this.mCipherSpec, r100.callback);
        r101.setWriteAheadLoggingEnabled(this.mWALMode);
        r101.setAsyncCheckpointEnabled(this.mAsyncCheckpoint);
        return r101;
    }

    public WCDBOpenHelperFactory passphrase(byte[] r100) {
        this.mPassphrase = r100;
        return this;
    }

    public WCDBOpenHelperFactory writeAheadLoggingEnabled(boolean r100) {
        this.mWALMode = r100;
        return this;
    }
}
