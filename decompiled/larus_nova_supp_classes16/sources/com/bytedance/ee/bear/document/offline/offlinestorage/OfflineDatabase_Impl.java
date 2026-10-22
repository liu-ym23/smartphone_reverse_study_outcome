package com.bytedance.ee.bear.document.offline.offlinestorage;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import j25.f;
import j25.h;
import j25.p;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import k25.b1;
import k25.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfflineDatabase_Impl extends OfflineDatabase {
    public volatile b1 a;
    public volatile p b;
    public volatile f c;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ OfflineDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(OfflineDatabase_Impl r1) {
            this.a = r1;
            super(21);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `ResourceData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `reskey` TEXT, `resvalue` TEXT, `resvalue_filepath` TEXT, `update_time` INTEGER, `access_time` INTEGER, `isNeedSync` INTEGER NOT NULL, `config` TEXT, `type` TEXT, `token` TEXT, `obj_token` TEXT, `userToken` TEXT, `tenantID` TEXT, `url` TEXT, `subblock_preload_status` INTEGER NOT NULL, `page` INTEGER NOT NULL, `total_page` INTEGER NOT NULL, `batch_num` TEXT, `load_from` TEXT, `category` TEXT)");
            r2.execSQL("CREATE INDEX IF NOT EXISTS `index_ResourceData_reskey_obj_token_page` ON `ResourceData` (`reskey`, `obj_token`, `page`)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `file_model` (`name` TEXT NOT NULL, `token` TEXT NOT NULL, `doc_url` TEXT NOT NULL, `path` TEXT NOT NULL, `uri` TEXT NOT NULL, `local_url` TEXT, `net_url` TEXT, `file_modified_time` INTEGER NOT NULL, `new_upload_key` TEXT, `upload_key` TEXT, PRIMARY KEY(`name`, `token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `bitable_file_model` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `token` TEXT NOT NULL, `doc_url` TEXT, `table_id` TEXT, `field_id` TEXT, `record_id` TEXT, `path` TEXT NOT NULL, `uri` TEXT NOT NULL, `mime_type` TEXT, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `upload_task_key` TEXT, `upload_progress` INTEGER NOT NULL, `attachment_token` TEXT, `is_camera_only` INTEGER NOT NULL)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f42359ea16bf7df56224fd43396bc126')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r4) {
            r4.execSQL("DROP TABLE IF EXISTS `ResourceData`");
            r4.execSQL("DROP TABLE IF EXISTS `file_model`");
            r4.execSQL("DROP TABLE IF EXISTS `bitable_file_model`");
            if (OfflineDatabase_Impl.f(this.a) == null) goto L7;
            int r0 = OfflineDatabase_Impl.g(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(OfflineDatabase_Impl.i(this.a), r1)).onDestructiveMigration(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (OfflineDatabase_Impl.j(this.a) == null) goto L7;
            int r0 = OfflineDatabase_Impl.k(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(OfflineDatabase_Impl.l(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            OfflineDatabase_Impl.m(this.a, r4);
            this.a.internalInitInvalidationTracker(r4);
            if (OfflineDatabase_Impl.n(this.a) == null) goto L7;
            int r0 = OfflineDatabase_Impl.o(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(OfflineDatabase_Impl.h(this.a), r1)).onOpen(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onPreMigrate(SupportSQLiteDatabase r1) {
            DBUtil.dropFtsSyncTriggers(r1);
        }

        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r27) {
            HashMap r1 = new HashMap(20);
            r1.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            r1.put("reskey", new TableInfo.Column("reskey", "TEXT", false, 0, null, 1));
            r1.put("resvalue", new TableInfo.Column("resvalue", "TEXT", false, 0, null, 1));
            r1.put("resvalue_filepath", new TableInfo.Column("resvalue_filepath", "TEXT", false, 0, null, 1));
            r1.put("update_time", new TableInfo.Column("update_time", "INTEGER", false, 0, null, 1));
            r1.put("access_time", new TableInfo.Column("access_time", "INTEGER", false, 0, null, 1));
            r1.put("isNeedSync", new TableInfo.Column("isNeedSync", "INTEGER", true, 0, null, 1));
            r1.put("config", new TableInfo.Column("config", "TEXT", false, 0, null, 1));
            r1.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, 1));
            r1.put("token", new TableInfo.Column("token", "TEXT", false, 0, null, 1));
            r1.put("obj_token", new TableInfo.Column("obj_token", "TEXT", false, 0, null, 1));
            r1.put("userToken", new TableInfo.Column("userToken", "TEXT", false, 0, null, 1));
            r1.put("tenantID", new TableInfo.Column("tenantID", "TEXT", false, 0, null, 1));
            r1.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, 1));
            r1.put("subblock_preload_status", new TableInfo.Column("subblock_preload_status", "INTEGER", true, 0, null, 1));
            r1.put("page", new TableInfo.Column("page", "INTEGER", true, 0, null, 1));
            r1.put("total_page", new TableInfo.Column("total_page", "INTEGER", true, 0, null, 1));
            r1.put("batch_num", new TableInfo.Column("batch_num", "TEXT", false, 0, null, 1));
            r1.put("load_from", new TableInfo.Column("load_from", "TEXT", false, 0, null, 1));
            r1.put("category", new TableInfo.Column("category", "TEXT", false, 0, null, 1));
            HashSet r2 = new HashSet(0);
            HashSet r8 = new HashSet(1);
            r8.add(new TableInfo.Index("index_ResourceData_reskey_obj_token_page", false, Arrays.asList(new String[]{"reskey", "obj_token", "page"})));
            TableInfo r3 = new TableInfo("ResourceData", r1, r2, r8);
            TableInfo r4 = TableInfo.read(r27, "ResourceData");
            if (r3.equals(r4) == false) goto L5;
            HashMap r5 = new HashMap(10);
            r5.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
            r5.put("token", new TableInfo.Column("token", "TEXT", true, 2, null, 1));
            r5.put("doc_url", new TableInfo.Column("doc_url", "TEXT", true, 0, null, 1));
            r5.put("path", new TableInfo.Column("path", "TEXT", true, 0, null, 1));
            r5.put("uri", new TableInfo.Column("uri", "TEXT", true, 0, null, 1));
            r5.put("local_url", new TableInfo.Column("local_url", "TEXT", false, 0, null, 1));
            r5.put("net_url", new TableInfo.Column("net_url", "TEXT", false, 0, null, 1));
            r5.put("file_modified_time", new TableInfo.Column("file_modified_time", "INTEGER", true, 0, null, 1));
            r5.put("new_upload_key", new TableInfo.Column("new_upload_key", "TEXT", false, 0, null, 1));
            r5.put("upload_key", new TableInfo.Column("upload_key", "TEXT", false, 0, null, 1));
            TableInfo r12 = new TableInfo("file_model", r5, new HashSet(0), new HashSet(0));
            TableInfo r6 = TableInfo.read(r27, "file_model");
            if (r12.equals(r6) == false) goto L9;
            HashMap r7 = new HashMap(16);
            r7.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
            r7.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
            r7.put("token", new TableInfo.Column("token", "TEXT", true, 0, null, 1));
            r7.put("doc_url", new TableInfo.Column("doc_url", "TEXT", false, 0, null, 1));
            r7.put("table_id", new TableInfo.Column("table_id", "TEXT", false, 0, null, 1));
            r7.put("field_id", new TableInfo.Column("field_id", "TEXT", false, 0, null, 1));
            r7.put("record_id", new TableInfo.Column("record_id", "TEXT", false, 0, null, 1));
            r7.put("path", new TableInfo.Column("path", "TEXT", true, 0, null, 1));
            r7.put("uri", new TableInfo.Column("uri", "TEXT", true, 0, null, 1));
            r7.put("mime_type", new TableInfo.Column("mime_type", "TEXT", false, 0, null, 1));
            r7.put("width", new TableInfo.Column("width", "INTEGER", true, 0, null, 1));
            r7.put("height", new TableInfo.Column("height", "INTEGER", true, 0, null, 1));
            r7.put("upload_task_key", new TableInfo.Column("upload_task_key", "TEXT", false, 0, null, 1));
            r7.put("upload_progress", new TableInfo.Column("upload_progress", "INTEGER", true, 0, null, 1));
            r7.put("attachment_token", new TableInfo.Column("attachment_token", "TEXT", false, 0, null, 1));
            r7.put("is_camera_only", new TableInfo.Column("is_camera_only", "INTEGER", true, 0, null, 1));
            TableInfo r9 = new TableInfo("bitable_file_model", r7, new HashSet(0), new HashSet(0));
            TableInfo r0 = TableInfo.read(r27, "bitable_file_model");
            if (r9.equals(r0) == true) goto L15;
            return new RoomOpenHelper.ValidationResult(false, "bitable_file_model(com.bytedance.ee.bear.document.offline.file.db.BitableFileModel).\n Expected:\n" + r9 + "\n Found:\n" + r0);
        L15:
            return new RoomOpenHelper.ValidationResult(true, null);
        L9:
            return new RoomOpenHelper.ValidationResult(false, "file_model(com.bytedance.ee.bear.document.offline.file.db.FileModel).\n Expected:\n" + r12 + "\n Found:\n" + r6);
        L5:
            return new RoomOpenHelper.ValidationResult(false, "ResourceData(com.bytedance.ee.bear.document.offline.offlinestorage.ResourceData).\n Expected:\n" + r3 + "\n Found:\n" + r4);
        }
    }

    @Override // com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase
    public final j25.a c() {
        if (this.c != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.c != null) goto L10;
        this.c = new f(this);     // Catch: Throwable -> L13
    L10:
        f r0 = this.c;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.c;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ResourceData`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `file_model`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `bitable_file_model`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"ResourceData", "file_model", "bitable_file_model"});
    }

    @Override // com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase
    public final h d() {
        if (this.b != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.b != null) goto L10;
        this.b = new p(this);     // Catch: Throwable -> L13
    L10:
        p r0 = this.b;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.b;
    }

    @Override // com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase
    public final n0 e() {
        if (this.a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.a != null) goto L10;
        this.a = new b1(this);     // Catch: Throwable -> L13
    L10:
        b1 r0 = this.a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.a;
    }

    public OfflineDatabase_Impl() {
    }

    public static /* synthetic */ List f(OfflineDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(OfflineDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(OfflineDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(OfflineDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(OfflineDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List k(OfflineDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List l(OfflineDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List n(OfflineDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List o(OfflineDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "f42359ea16bf7df56224fd43396bc126", "d0fbef0578fc15358dc6dbdcdd88abc7");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public static /* synthetic */ void m(OfflineDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
