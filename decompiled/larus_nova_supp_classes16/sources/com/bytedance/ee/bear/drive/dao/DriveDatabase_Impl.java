package com.bytedance.ee.bear.drive.dao;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveDatabase_Impl extends DriveDatabase {
    public volatile b a;
    public volatile e b;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ DriveDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(DriveDatabase_Impl r1) {
            this.a = r1;
            super(10);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `t_drive_cache` (`cache_key` TEXT NOT NULL, `obj_token` TEXT, `src_ext` TEXT, `preview_ext` TEXT, `data_version` TEXT, `source_from` TEXT, `cache_source_from` TEXT, `file_path` TEXT, `partial_file_path` TEXT, `temp_file_path` TEXT, `file_size` INTEGER NOT NULL, `type` INTEGER NOT NULL, `last_access_time` INTEGER NOT NULL, `modification_time` INTEGER NOT NULL, `file_name` TEXT, `cache_uid` TEXT, `cache_tenant_id` TEXT, `preview_extra` TEXT, `is_use_partial_file` INTEGER NOT NULL, `cache_host` INTEGER NOT NULL, `sdk_app_id` TEXT, `sdk_extra` TEXT, `flags` INTEGER NOT NULL, `mime_type` TEXT, `risk_status` INTEGER NOT NULL, PRIMARY KEY(`cache_key`))");
            r2.execSQL("CREATE INDEX IF NOT EXISTS `index_t_drive_cache_last_access_time` ON `t_drive_cache` (`last_access_time`)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `drive_excel_sub_cache` (`sdk_app_id` TEXT NOT NULL, `obj_token` TEXT NOT NULL, `data_version` TEXT NOT NULL, `sub_id` TEXT NOT NULL, `json_data_file_path` TEXT NOT NULL, `json_data` TEXT NOT NULL, PRIMARY KEY(`sdk_app_id`, `obj_token`, `data_version`, `sub_id`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9c602a7b1f46a3bb1d398bbe1410c30b')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r4) {
            r4.execSQL("DROP TABLE IF EXISTS `t_drive_cache`");
            r4.execSQL("DROP TABLE IF EXISTS `drive_excel_sub_cache`");
            if (DriveDatabase_Impl.e(this.a) == null) goto L7;
            int r0 = DriveDatabase_Impl.f(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(DriveDatabase_Impl.h(this.a), r1)).onDestructiveMigration(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (DriveDatabase_Impl.i(this.a) == null) goto L7;
            int r0 = DriveDatabase_Impl.j(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(DriveDatabase_Impl.k(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            DriveDatabase_Impl.l(this.a, r4);
            this.a.internalInitInvalidationTracker(r4);
            if (DriveDatabase_Impl.m(this.a) == null) goto L7;
            int r0 = DriveDatabase_Impl.n(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(DriveDatabase_Impl.g(this.a), r1)).onOpen(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onPreMigrate(SupportSQLiteDatabase r1) {
            DBUtil.dropFtsSyncTriggers(r1);
        }

        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r26) {
            HashMap r1 = new HashMap(25);
            r1.put("cache_key", new TableInfo.Column("cache_key", "TEXT", true, 1, null, 1));
            r1.put("obj_token", new TableInfo.Column("obj_token", "TEXT", false, 0, null, 1));
            r1.put("src_ext", new TableInfo.Column("src_ext", "TEXT", false, 0, null, 1));
            r1.put("preview_ext", new TableInfo.Column("preview_ext", "TEXT", false, 0, null, 1));
            r1.put("data_version", new TableInfo.Column("data_version", "TEXT", false, 0, null, 1));
            r1.put("source_from", new TableInfo.Column("source_from", "TEXT", false, 0, null, 1));
            r1.put("cache_source_from", new TableInfo.Column("cache_source_from", "TEXT", false, 0, null, 1));
            r1.put("file_path", new TableInfo.Column("file_path", "TEXT", false, 0, null, 1));
            r1.put("partial_file_path", new TableInfo.Column("partial_file_path", "TEXT", false, 0, null, 1));
            r1.put("temp_file_path", new TableInfo.Column("temp_file_path", "TEXT", false, 0, null, 1));
            r1.put("file_size", new TableInfo.Column("file_size", "INTEGER", true, 0, null, 1));
            r1.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
            r1.put("last_access_time", new TableInfo.Column("last_access_time", "INTEGER", true, 0, null, 1));
            r1.put("modification_time", new TableInfo.Column("modification_time", "INTEGER", true, 0, null, 1));
            r1.put("file_name", new TableInfo.Column("file_name", "TEXT", false, 0, null, 1));
            r1.put("cache_uid", new TableInfo.Column("cache_uid", "TEXT", false, 0, null, 1));
            r1.put("cache_tenant_id", new TableInfo.Column("cache_tenant_id", "TEXT", false, 0, null, 1));
            r1.put("preview_extra", new TableInfo.Column("preview_extra", "TEXT", false, 0, null, 1));
            r1.put("is_use_partial_file", new TableInfo.Column("is_use_partial_file", "INTEGER", true, 0, null, 1));
            r1.put("cache_host", new TableInfo.Column("cache_host", "INTEGER", true, 0, null, 1));
            r1.put("sdk_app_id", new TableInfo.Column("sdk_app_id", "TEXT", false, 0, null, 1));
            r1.put("sdk_extra", new TableInfo.Column("sdk_extra", "TEXT", false, 0, null, 1));
            r1.put("flags", new TableInfo.Column("flags", "INTEGER", true, 0, null, 1));
            r1.put("mime_type", new TableInfo.Column("mime_type", "TEXT", false, 0, null, 1));
            r1.put("risk_status", new TableInfo.Column("risk_status", "INTEGER", true, 0, null, 1));
            HashSet r2 = new HashSet(0);
            HashSet r8 = new HashSet(1);
            r8.add(new TableInfo.Index("index_t_drive_cache_last_access_time", false, Arrays.asList(new String[]{"last_access_time"})));
            TableInfo r5 = new TableInfo("t_drive_cache", r1, r2, r8);
            TableInfo r3 = TableInfo.read(r26, "t_drive_cache");
            if (r5.equals(r3) == false) goto L5;
            HashMap r4 = new HashMap(6);
            r4.put("sdk_app_id", new TableInfo.Column("sdk_app_id", "TEXT", true, 1, null, 1));
            r4.put("obj_token", new TableInfo.Column("obj_token", "TEXT", true, 2, null, 1));
            r4.put("data_version", new TableInfo.Column("data_version", "TEXT", true, 3, null, 1));
            r4.put("sub_id", new TableInfo.Column("sub_id", "TEXT", true, 4, null, 1));
            r4.put("json_data_file_path", new TableInfo.Column("json_data_file_path", "TEXT", true, 0, null, 1));
            r4.put("json_data", new TableInfo.Column("json_data", "TEXT", true, 0, null, 1));
            TableInfo r6 = new TableInfo("drive_excel_sub_cache", r4, new HashSet(0), new HashSet(0));
            TableInfo r0 = TableInfo.read(r26, "drive_excel_sub_cache");
            if (r6.equals(r0) == true) goto L11;
            return new RoomOpenHelper.ValidationResult(false, "drive_excel_sub_cache(com.bytedance.ee.bear.drive.dao.model.ExcelSubCacheModel).\n Expected:\n" + r6 + "\n Found:\n" + r0);
        L11:
            return new RoomOpenHelper.ValidationResult(true, null);
        L5:
            return new RoomOpenHelper.ValidationResult(false, "t_drive_cache(com.bytedance.ee.bear.drive.dao.model.CacheModel).\n Expected:\n" + r5 + "\n Found:\n" + r3);
        }
    }

    @Override // com.bytedance.ee.bear.drive.dao.DriveDatabase
    public final com.bytedance.ee.bear.drive.dao.a c() {
        if (this.a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.a != null) goto L10;
        this.a = new b(this);     // Catch: Throwable -> L13
    L10:
        b r0 = this.a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.a;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_drive_cache`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `drive_excel_sub_cache`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"t_drive_cache", "drive_excel_sub_cache"});
    }

    @Override // com.bytedance.ee.bear.drive.dao.DriveDatabase
    public final d d() {
        if (this.b != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.b != null) goto L10;
        this.b = new e(this);     // Catch: Throwable -> L13
    L10:
        e r0 = this.b;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.b;
    }

    public DriveDatabase_Impl() {
    }

    public static /* synthetic */ List e(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List f(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List k(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List m(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List n(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "9c602a7b1f46a3bb1d398bbe1410c30b", "40291fb8e269e08e5de483bbddbf8ece");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public static /* synthetic */ void l(DriveDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
