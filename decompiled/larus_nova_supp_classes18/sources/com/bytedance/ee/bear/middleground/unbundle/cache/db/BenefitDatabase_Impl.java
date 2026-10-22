package com.bytedance.ee.bear.middleground.unbundle.cache.db;

import aj5.b;
import aj5.e;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BenefitDatabase_Impl extends BenefitDatabase {
    public volatile e a;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ BenefitDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(BenefitDatabase_Impl r1) {
            this.a = r1;
            super(1);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `BenefitData` (`cache_key` TEXT NOT NULL, `owner_id` TEXT, `source_benefit` TEXT, `update_time` INTEGER, PRIMARY KEY(`cache_key`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '86d3f0949c0bfd94ed77563bc19c1dd5')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r4) {
            r4.execSQL("DROP TABLE IF EXISTS `BenefitData`");
            if (BenefitDatabase_Impl.d(this.a) == null) goto L7;
            int r0 = BenefitDatabase_Impl.e(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BenefitDatabase_Impl.g(this.a), r1)).onDestructiveMigration(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (BenefitDatabase_Impl.h(this.a) == null) goto L7;
            int r0 = BenefitDatabase_Impl.i(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BenefitDatabase_Impl.j(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            BenefitDatabase_Impl.k(this.a, r4);
            this.a.internalInitInvalidationTracker(r4);
            if (BenefitDatabase_Impl.l(this.a) == null) goto L7;
            int r0 = BenefitDatabase_Impl.m(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BenefitDatabase_Impl.f(this.a), r1)).onOpen(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onPreMigrate(SupportSQLiteDatabase r1) {
            DBUtil.dropFtsSyncTriggers(r1);
        }

        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r11) {
            HashMap r0 = new HashMap(4);
            r0.put("cache_key", new TableInfo.Column("cache_key", CardAdapter.TEXT, true, 1, null, 1));
            r0.put("owner_id", new TableInfo.Column("owner_id", CardAdapter.TEXT, false, 0, null, 1));
            r0.put("source_benefit", new TableInfo.Column("source_benefit", CardAdapter.TEXT, false, 0, null, 1));
            r0.put("update_time", new TableInfo.Column("update_time", "INTEGER", false, 0, null, 1));
            TableInfo r4 = new TableInfo("BenefitData", r0, new HashSet(0), new HashSet(0));
            TableInfo r12 = TableInfo.read(r11, "BenefitData");
            if (r4.equals(r12) == true) goto L7;
            return new RoomOpenHelper.ValidationResult(false, "BenefitData(com.bytedance.ee.bear.middleground.unbundle.cache.db.BenefitData).\n Expected:\n" + r4 + "\n Found:\n" + r12);
        L7:
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // com.bytedance.ee.bear.middleground.unbundle.cache.db.BenefitDatabase
    public final b c() {
        if (this.a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.a != null) goto L10;
        this.a = new e(this);     // Catch: Throwable -> L13
    L10:
        e r0 = this.a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.a;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `BenefitData`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L15;
        r2.execSQL("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L12;
        r2.execSQL("VACUUM");
    L12:
        throw th;
    }

    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"BenefitData"});
    }

    public BenefitDatabase_Impl() {
    }

    public static /* synthetic */ List d(BenefitDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List e(BenefitDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List f(BenefitDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(BenefitDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(BenefitDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(BenefitDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(BenefitDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List l(BenefitDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List m(BenefitDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "86d3f0949c0bfd94ed77563bc19c1dd5", "dbb0bd9123ced1692cbee564c2870433");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public static /* synthetic */ void k(BenefitDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
