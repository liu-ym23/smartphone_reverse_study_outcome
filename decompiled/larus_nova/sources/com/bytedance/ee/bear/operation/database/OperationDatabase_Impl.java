package com.bytedance.ee.bear.operation.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import dl5.b;
import dl5.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class OperationDatabase_Impl extends OperationDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile d f236209a;

    public class a extends RoomOpenHelper.Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperationDatabase_Impl f236210a;

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPostMigrate(SupportSQLiteDatabase r100) {
        }

        public a(OperationDatabase_Impl r100) {
            this.f236210a = r100;
            super(1);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void createAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `OperationData` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `module_type` INTEGER NOT NULL, `module_token` TEXT, `operator_id` TEXT, `operation_name` TEXT, `operation_scene` INTEGER NOT NULL, `operation_time` INTEGER, `extra` TEXT, `uuid` TEXT)");
            r100.execSQL(RoomMasterTable.CREATE_QUERY);
            r100.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '078dca35c512155a339a6ebf498c8ea2')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void dropAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `OperationData`");
            if (OperationDatabase_Impl.d(this.f236210a) == null) goto L7;
            int r101 = OperationDatabase_Impl.e(this.f236210a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(OperationDatabase_Impl.g(this.f236210a), r102)).onDestructiveMigration(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onCreate(SupportSQLiteDatabase r100) {
            if (OperationDatabase_Impl.h(this.f236210a) == null) goto L7;
            int r101 = OperationDatabase_Impl.i(this.f236210a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(OperationDatabase_Impl.j(this.f236210a), r102)).onCreate(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onOpen(SupportSQLiteDatabase r100) {
            OperationDatabase_Impl.k(this.f236210a, r100);
            this.f236210a.internalInitInvalidationTracker(r100);
            if (OperationDatabase_Impl.l(this.f236210a) == null) goto L7;
            int r101 = OperationDatabase_Impl.m(this.f236210a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(OperationDatabase_Impl.f(this.f236210a), r102)).onOpen(r100);
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
            HashMap r100 = new HashMap(9);
            r100.put(DBDefinition.ID, new TableInfo.Column(DBDefinition.ID, "INTEGER", true, 1, null, 1));
            r100.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_TYPE, new TableInfo.Column(com.bytedance.android.ec.core.event.a.KEY_MODULE_TYPE, "INTEGER", true, 0, null, 1));
            r100.put("module_token", new TableInfo.Column("module_token", CardAdapter.TEXT, false, 0, null, 1));
            r100.put("operator_id", new TableInfo.Column("operator_id", CardAdapter.TEXT, false, 0, null, 1));
            r100.put("operation_name", new TableInfo.Column("operation_name", CardAdapter.TEXT, false, 0, null, 1));
            r100.put("operation_scene", new TableInfo.Column("operation_scene", "INTEGER", true, 0, null, 1));
            r100.put("operation_time", new TableInfo.Column("operation_time", "INTEGER", false, 0, null, 1));
            r100.put("extra", new TableInfo.Column("extra", CardAdapter.TEXT, false, 0, null, 1));
            r100.put(ST.UUID_DEVICE, new TableInfo.Column(ST.UUID_DEVICE, CardAdapter.TEXT, false, 0, null, 1));
            TableInfo r101 = new TableInfo("OperationData", r100, new HashSet(0), new HashSet(0));
            TableInfo r111 = TableInfo.read(r110, "OperationData");
            if (r101.equals(r111) == true) goto L7;
            return new RoomOpenHelper.ValidationResult(false, "OperationData(com.bytedance.ee.bear.operation.database.OperationData).\n Expected:\n" + r101 + "\n Found:\n" + r111);
        L7:
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // com.bytedance.ee.bear.operation.database.OperationDatabase
    public final b c() {
        if (this.f236209a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f236209a != null) goto L10;
        this.f236209a = new d(this);     // Catch: Throwable -> L13
    L10:
        d r100 = this.f236209a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r100;
    L5:
        return this.f236209a;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r100 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r100.execSQL("DELETE FROM `OperationData`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"OperationData"});
    }

    public OperationDatabase_Impl() {
    }

    public static /* synthetic */ List d(OperationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List e(OperationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List f(OperationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List g(OperationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List h(OperationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List i(OperationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List j(OperationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List l(OperationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List m(OperationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r100) {
        RoomOpenHelper r101 = new RoomOpenHelper(r100, new a(this), "078dca35c512155a339a6ebf498c8ea2", "fbeca3f7f9ada1656ba71b333d8b307b");
        SupportSQLiteOpenHelper.Configuration r102 = SupportSQLiteOpenHelper.Configuration.builder(r100.context).name(r100.name).callback(r101).build();
        return r100.sqliteOpenHelperFactory.create(r102);
    }

    public static /* synthetic */ void k(OperationDatabase_Impl r100, SupportSQLiteDatabase r101) {
        r100.mDatabase = r101;
    }
}
