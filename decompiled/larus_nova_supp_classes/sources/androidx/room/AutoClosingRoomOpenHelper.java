package androidx.room;

import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final AutoCloser mAutoCloser;
    private final AutoClosingSupportSQLiteDatabase mAutoClosingDb;
    private final SupportSQLiteOpenHelper mDelegateOpenHelper;

    public void close() {
        this.mAutoClosingDb.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        SneakyThrow.reThrow(e);
    }

    public String getDatabaseName() {
        return this.mDelegateOpenHelper.getDatabaseName();
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    public AutoCloser getAutoCloser() {
        return this.mAutoCloser;
    }

    public SupportSQLiteDatabase getAutoClosingDb() {
        return this.mAutoClosingDb;
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegateOpenHelper;
    }

    public void setWriteAheadLoggingEnabled(boolean r2) {
        this.mDelegateOpenHelper.setWriteAheadLoggingEnabled(r2);
    }

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper r1, AutoCloser r2) {
        this.mDelegateOpenHelper = r1;
        this.mAutoCloser = r2;
        r2.init(r1);
        this.mAutoClosingDb = new AutoClosingSupportSQLiteDatabase(r2);
    }
}
