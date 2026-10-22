package com.obric.sva.sdk.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public final class SvaSdkDatabase_Impl extends SvaSdkDatabase {
    private volatile VoicePrintDao _voicePrintDao;

    @Override // com.obric.sva.sdk.db.SvaSdkDatabase
    public VoicePrintDao VoicePrintDao() {
        if (this._voicePrintDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._voicePrintDao != null) goto L10;
        this._voicePrintDao = new VoicePrintDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        VoicePrintDao r100 = this._voicePrintDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r100;
    L5:
        return this._voicePrintDao;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r100 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r100.execSQL("DELETE FROM `sva_voice_print`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r100.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r100.inTransaction() == true) goto L15;
        r100.execSQL("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r100.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r100.inTransaction() == true) goto L12;
        r100.execSQL("VACUUM");
    L12:
        throw th;
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"sva_voice_print"});
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r100 = new HashMap();
        r100.put(VoicePrintDao.class, VoicePrintDao_Impl.getRequiredConverters());
        return r100;
    }

    public SvaSdkDatabase_Impl() {
    }

    public static /* synthetic */ List access$000(SvaSdkDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List access$100(SvaSdkDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List access$1000(SvaSdkDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List access$200(SvaSdkDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List access$300(SvaSdkDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List access$400(SvaSdkDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List access$500(SvaSdkDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List access$800(SvaSdkDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List access$900(SvaSdkDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r100) {
        final int r101 = 2;
        RoomOpenHelper r102 = new RoomOpenHelper(r100, new AnonymousClass1(this, r101), "5997d8a19b2ff40e61fb8918aaebb981", "4cb388f15698c2ba5bba887f1741a7c7");
        SupportSQLiteOpenHelper.Configuration r103 = SupportSQLiteOpenHelper.Configuration.builder(r100.context).name(r100.name).callback(r102).build();
        return r100.sqliteOpenHelperFactory.create(r103);
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r100) {
        return Arrays.asList(new Migration[0]);
    }

    public static /* synthetic */ SupportSQLiteDatabase access$602(SvaSdkDatabase_Impl r100, SupportSQLiteDatabase r101) {
        r100.mDatabase = r101;
        return r101;
    }

    public static /* synthetic */ void access$700(SvaSdkDatabase_Impl r100, SupportSQLiteDatabase r101) {
        r100.internalInitInvalidationTracker(r101);
    }
}
