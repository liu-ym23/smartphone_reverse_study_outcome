package net.sqlcipher.database;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* JADX INFO: loaded from: classes42.dex */
public class SupportFactory implements SupportSQLiteOpenHelper.Factory {
    private final boolean clearPassphrase;
    private final SQLiteDatabaseHook hook;
    private final byte[] passphrase;

    public SupportFactory(byte[] r100) {
        this(r100, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r100) {
        return new SupportHelper(r100, this.passphrase, this.hook, this.clearPassphrase);
    }

    public SupportFactory(byte[] r100, SQLiteDatabaseHook r101) {
        this(r100, r101, true);
    }

    public SupportFactory(byte[] r100, SQLiteDatabaseHook r101, boolean r102) {
        this.passphrase = r100;
        this.hook = r101;
        this.clearPassphrase = r102;
    }
}
