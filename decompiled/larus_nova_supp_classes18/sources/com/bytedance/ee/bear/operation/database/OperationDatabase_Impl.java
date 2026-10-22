package com.bytedance.ee.bear.operation.database;

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
import dl5.b;
import dl5.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OperationDatabase_Impl extends OperationDatabase {
    public volatile d a;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ OperationDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(OperationDatabase_Impl r1) {
            this.a = r1;
            super(1);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `OperationData` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `module_type` INTEGER NOT NULL, `module_token` TEXT, `operator_id` TEXT, `operation_name` TEXT, `operation_scene` INTEGER NOT NULL, `operation_time` INTEGER, `extra` TEXT, `uuid` TEXT)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '078dca35c512155a339a6ebf498c8ea2')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r4) {
            r4.execSQL("DROP TABLE IF EXISTS `OperationData`");
            if (OperationDatabase_Impl.d(this.a) == null) goto L7;
            int r0 = OperationDatabase_Impl.e(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(OperationDatabase_Impl.g(this.a), r1)).onDestructiveMigration(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (OperationDatabase_Impl.h(this.a) == null) goto L7;
            int r0 = OperationDatabase_Impl.i(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(OperationDatabase_Impl.j(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            OperationDatabase_Impl.k(this.a, r4);
            this.a.internalInitInvalidationTracker(r4);
            if (OperationDatabase_Impl.l(this.a) == null) goto L7;
            int r0 = OperationDatabase_Impl.m(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(OperationDatabase_Impl.f(this.a), r1)).onOpen(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onPreMigrate(SupportSQLiteDatabase r1) {
            DBUtil.dropFtsSyncTriggers(r1);
        }

        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r11) {
            HashMap r0 = new HashMap(9);
            r0.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
            r0.put("module_type", new TableInfo.Column("module_type", "INTEGER", true, 0, null, 1));
            r0.put("module_token", new TableInfo.Column("module_token", CardAdapter.TEXT, false, 0, null, 1));
            r0.put("operator_id", new TableInfo.Column("operator_id", CardAdapter.TEXT, false, 0, null, 1));
            r0.put("operation_name", new TableInfo.Column("operation_name", CardAdapter.TEXT, false, 0, null, 1));
            r0.put("operation_scene", new TableInfo.Column("operation_scene", "INTEGER", true, 0, null, 1));
            r0.put("operation_time", new TableInfo.Column("operation_time", "INTEGER", false, 0, null, 1));
            r0.put("extra", new TableInfo.Column("extra", CardAdapter.TEXT, false, 0, null, 1));
            r0.put("uuid", new TableInfo.Column("uuid", CardAdapter.TEXT, false, 0, null, 1));
            TableInfo r4 = new TableInfo("OperationData", r0, new HashSet(0), new HashSet(0));
            TableInfo r12 = TableInfo.read(r11, "OperationData");
            if (r4.equals(r12) == true) goto L7;
            return new RoomOpenHelper.ValidationResult(false, "OperationData(com.bytedance.ee.bear.operation.database.OperationData).\n Expected:\n" + r4 + "\n Found:\n" + r12);
        L7:
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // com.bytedance.ee.bear.operation.database.OperationDatabase
    public final b c() {
        if (this.a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.a != null) goto L10;
        this.a = new d(this);     // Catch: Throwable -> L13
    L10:
        d r0 = this.a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.a;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `OperationData`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"OperationData"});
    }

    public OperationDatabase_Impl() {
    }

    public static /* synthetic */ List d(OperationDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List e(OperationDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List f(OperationDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(OperationDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(OperationDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(OperationDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(OperationDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List l(OperationDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List m(OperationDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "078dca35c512155a339a6ebf498c8ea2", "fbeca3f7f9ada1656ba71b333d8b307b");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public static /* synthetic */ void k(OperationDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
