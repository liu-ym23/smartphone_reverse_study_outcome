package com.bytedance.ee.bear.middleground.unbundle.cache.db;

import aj5.b;
import aj5.e;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class BenefitDatabase_Impl extends BenefitDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile e f234412a;

    public class a extends RoomOpenHelper.Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BenefitDatabase_Impl f234413a;

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPostMigrate(SupportSQLiteDatabase r100) {
        }

        public a(BenefitDatabase_Impl r100) {
            this.f234413a = r100;
            super(1);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void createAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `BenefitData` (`cache_key` TEXT NOT NULL, `owner_id` TEXT, `source_benefit` TEXT, `update_time` INTEGER, PRIMARY KEY(`cache_key`))");
            r100.execSQL(RoomMasterTable.CREATE_QUERY);
            r100.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '86d3f0949c0bfd94ed77563bc19c1dd5')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void dropAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `BenefitData`");
            if (BenefitDatabase_Impl.d(this.f234413a) == null) goto L7;
            int r101 = BenefitDatabase_Impl.e(this.f234413a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BenefitDatabase_Impl.g(this.f234413a), r102)).onDestructiveMigration(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onCreate(SupportSQLiteDatabase r100) {
            if (BenefitDatabase_Impl.h(this.f234413a) == null) goto L7;
            int r101 = BenefitDatabase_Impl.i(this.f234413a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BenefitDatabase_Impl.j(this.f234413a), r102)).onCreate(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onOpen(SupportSQLiteDatabase r100) {
            BenefitDatabase_Impl.k(this.f234413a, r100);
            this.f234413a.internalInitInvalidationTracker(r100);
            if (BenefitDatabase_Impl.l(this.f234413a) == null) goto L7;
            int r101 = BenefitDatabase_Impl.m(this.f234413a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BenefitDatabase_Impl.f(this.f234413a), r102)).onOpen(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPreMigrate(SupportSQLiteDatabase r100) {
            DBUtil.dropFtsSyncTriggers(r100);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r110) {
            HashMap r100 = new HashMap(4);
            r100.put("cache_key", new TableInfo.Column("cache_key", CardAdapter.TEXT, true, 1, null, 1));
            r100.put("owner_id", new TableInfo.Column("owner_id", CardAdapter.TEXT, false, 0, null, 1));
            r100.put("source_benefit", new TableInfo.Column("source_benefit", CardAdapter.TEXT, false, 0, null, 1));
            r100.put("update_time", new TableInfo.Column("update_time", "INTEGER", false, 0, null, 1));
            TableInfo r101 = new TableInfo("BenefitData", r100, new HashSet(0), new HashSet(0));
            TableInfo r111 = TableInfo.read(r110, "BenefitData");
            if (r101.equals(r111) == true) goto L7;
            return new RoomOpenHelper.ValidationResult(false, "BenefitData(com.bytedance.ee.bear.middleground.unbundle.cache.db.BenefitData).\n Expected:\n" + r101 + "\n Found:\n" + r111);
        L7:
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // com.bytedance.ee.bear.middleground.unbundle.cache.db.BenefitDatabase
    public final b c() {
        if (this.f234412a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f234412a != null) goto L10;
        this.f234412a = new e(this);     // Catch: Throwable -> L13
    L10:
        e r100 = this.f234412a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r100;
    L5:
        return this.f234412a;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r100 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r100.execSQL("DELETE FROM `BenefitData`");     // Catch: Throwable -> L8
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
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"BenefitData"});
    }

    public BenefitDatabase_Impl() {
    }

    public static /* synthetic */ List d(BenefitDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List e(BenefitDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List f(BenefitDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List g(BenefitDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List h(BenefitDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List i(BenefitDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List j(BenefitDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List l(BenefitDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List m(BenefitDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r100) {
        RoomOpenHelper r101 = new RoomOpenHelper(r100, new a(this), "86d3f0949c0bfd94ed77563bc19c1dd5", "dbb0bd9123ced1692cbee564c2870433");
        SupportSQLiteOpenHelper.Configuration r102 = SupportSQLiteOpenHelper.Configuration.builder(r100.context).name(r100.name).callback(r101).build();
        return r100.sqliteOpenHelperFactory.create(r102);
    }

    public static /* synthetic */ void k(BenefitDatabase_Impl r100, SupportSQLiteDatabase r101) {
        r100.mDatabase = r101;
    }
}
