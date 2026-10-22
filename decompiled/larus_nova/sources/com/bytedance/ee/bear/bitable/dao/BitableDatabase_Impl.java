package com.bytedance.ee.bear.bitable.dao;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import as4.b;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import zr4.c;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableDatabase_Impl extends BitableDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile b f210618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c f210619b;

    public class a extends RoomOpenHelper.Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableDatabase_Impl f210620a;

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPostMigrate(SupportSQLiteDatabase r100) {
        }

        public a(BitableDatabase_Impl r100) {
            this.f210620a = r100;
            super(5);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void createAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `BitableResourceData` (`base_token` TEXT NOT NULL, `block_id` TEXT NOT NULL, `res_key` TEXT NOT NULL, `obj_token` TEXT NOT NULL, `view_id` TEXT NOT NULL, `res_value` TEXT, `rev1` INTEGER NOT NULL, `rev2` INTEGER NOT NULL, `extra` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `delete_strategy` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`base_token`, `res_key`, `block_id`, `obj_token`))");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `BitableBlockData` (`base_token` TEXT NOT NULL, `block_id` TEXT NOT NULL, `block_type` INTEGER NOT NULL, `name` TEXT NOT NULL, `obj_token` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`base_token`, `block_id`))");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `BitableFirstBlockData` (`base_token` TEXT NOT NULL, `block_id` TEXT NOT NULL, `view_id` TEXT NOT NULL, `timestamp` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`base_token`))");
            r100.execSQL(RoomMasterTable.CREATE_QUERY);
            r100.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '53273439dc6ea32bd8e44f57c162ce28')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void dropAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `BitableResourceData`");
            r100.execSQL("DROP TABLE IF EXISTS `BitableBlockData`");
            r100.execSQL("DROP TABLE IF EXISTS `BitableFirstBlockData`");
            if (BitableDatabase_Impl.e(this.f210620a) == null) goto L7;
            int r101 = BitableDatabase_Impl.f(this.f210620a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BitableDatabase_Impl.h(this.f210620a), r102)).onDestructiveMigration(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onCreate(SupportSQLiteDatabase r100) {
            if (BitableDatabase_Impl.i(this.f210620a) == null) goto L7;
            int r101 = BitableDatabase_Impl.j(this.f210620a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BitableDatabase_Impl.k(this.f210620a), r102)).onCreate(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onOpen(SupportSQLiteDatabase r100) {
            BitableDatabase_Impl.l(this.f210620a, r100);
            this.f210620a.internalInitInvalidationTracker(r100);
            if (BitableDatabase_Impl.m(this.f210620a) == null) goto L7;
            int r101 = BitableDatabase_Impl.n(this.f210620a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BitableDatabase_Impl.g(this.f210620a), r102)).onOpen(r100);
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
        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r210) {
            HashMap r100 = new HashMap(11);
            r100.put(BitableResourceData.KEY_BASE_TOKEN, new TableInfo.Column(BitableResourceData.KEY_BASE_TOKEN, CardAdapter.TEXT, true, 1, null, 1));
            r100.put(BitableResourceData.KEY_BLOCK_ID, new TableInfo.Column(BitableResourceData.KEY_BLOCK_ID, CardAdapter.TEXT, true, 3, null, 1));
            r100.put(BitableResourceData.KEY_RES_KEY, new TableInfo.Column(BitableResourceData.KEY_RES_KEY, CardAdapter.TEXT, true, 2, null, 1));
            r100.put("obj_token", new TableInfo.Column("obj_token", CardAdapter.TEXT, true, 4, null, 1));
            r100.put(BitableResourceData.KEY_VIEW_ID, new TableInfo.Column(BitableResourceData.KEY_VIEW_ID, CardAdapter.TEXT, true, 0, null, 1));
            r100.put(BitableResourceData.KEY_RESOURCE_VALUE, new TableInfo.Column(BitableResourceData.KEY_RESOURCE_VALUE, CardAdapter.TEXT, false, 0, null, 1));
            r100.put(BitableResourceData.KEY_REV_1, new TableInfo.Column(BitableResourceData.KEY_REV_1, "INTEGER", true, 0, null, 1));
            r100.put(BitableResourceData.KEY_REV_2, new TableInfo.Column(BitableResourceData.KEY_REV_2, "INTEGER", true, 0, null, 1));
            r100.put("extra", new TableInfo.Column("extra", CardAdapter.TEXT, true, 0, null, 1));
            r100.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
            r100.put(BitableResourceData.KEY_DELETE_STRATEGY, new TableInfo.Column(BitableResourceData.KEY_DELETE_STRATEGY, "INTEGER", true, 0, "0", 1));
            TableInfo r110 = new TableInfo(BitableResourceData.TABLE_NAME, r100, new HashSet(0), new HashSet(0));
            TableInfo r101 = TableInfo.read(r210, BitableResourceData.TABLE_NAME);
            if (r110.equals(r101) == false) goto L5;
            HashMap r102 = new HashMap(6);
            r102.put(BitableResourceData.KEY_BASE_TOKEN, new TableInfo.Column(BitableResourceData.KEY_BASE_TOKEN, CardAdapter.TEXT, true, 1, null, 1));
            r102.put(BitableResourceData.KEY_BLOCK_ID, new TableInfo.Column(BitableResourceData.KEY_BLOCK_ID, CardAdapter.TEXT, true, 2, null, 1));
            r102.put("block_type", new TableInfo.Column("block_type", "INTEGER", true, 0, null, 1));
            r102.put("name", new TableInfo.Column("name", CardAdapter.TEXT, true, 0, null, 1));
            r102.put("obj_token", new TableInfo.Column("obj_token", CardAdapter.TEXT, true, 0, null, 1));
            r102.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
            TableInfo r111 = new TableInfo("BitableBlockData", r102, new HashSet(0), new HashSet(0));
            TableInfo r103 = TableInfo.read(r210, "BitableBlockData");
            if (r111.equals(r103) == false) goto L9;
            HashMap r104 = new HashMap(4);
            r104.put(BitableResourceData.KEY_BASE_TOKEN, new TableInfo.Column(BitableResourceData.KEY_BASE_TOKEN, CardAdapter.TEXT, true, 1, null, 1));
            r104.put(BitableResourceData.KEY_BLOCK_ID, new TableInfo.Column(BitableResourceData.KEY_BLOCK_ID, CardAdapter.TEXT, true, 0, null, 1));
            r104.put(BitableResourceData.KEY_VIEW_ID, new TableInfo.Column(BitableResourceData.KEY_VIEW_ID, CardAdapter.TEXT, true, 0, null, 1));
            r104.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, "0", 1));
            TableInfo r105 = new TableInfo("BitableFirstBlockData", r104, new HashSet(0), new HashSet(0));
            TableInfo r106 = TableInfo.read(r210, "BitableFirstBlockData");
            if (r105.equals(r106) == true) goto L15;
            return new RoomOpenHelper.ValidationResult(false, "BitableFirstBlockData(com.bytedance.ee.bear.bitable.dao.blockinfo.BitableFirstBlockData).\n Expected:\n" + r105 + "\n Found:\n" + r106);
        L15:
            return new RoomOpenHelper.ValidationResult(true, null);
        L9:
            return new RoomOpenHelper.ValidationResult(false, "BitableBlockData(com.bytedance.ee.bear.bitable.dao.blockinfo.BitableBlockData).\n Expected:\n" + r111 + "\n Found:\n" + r103);
        L5:
            return new RoomOpenHelper.ValidationResult(false, "BitableResourceData(com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData).\n Expected:\n" + r110 + "\n Found:\n" + r101);
        }
    }

    @Override // com.bytedance.ee.bear.bitable.dao.BitableDatabase
    public final zr4.b c() {
        if (this.f210619b != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f210619b != null) goto L10;
        this.f210619b = new c(this);     // Catch: Throwable -> L13
    L10:
        c r100 = this.f210619b;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r100;
    L5:
        return this.f210619b;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r100 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r100.execSQL("DELETE FROM `BitableResourceData`");     // Catch: Throwable -> L8
        r100.execSQL("DELETE FROM `BitableBlockData`");     // Catch: Throwable -> L8
        r100.execSQL("DELETE FROM `BitableFirstBlockData`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{BitableResourceData.TABLE_NAME, "BitableBlockData", "BitableFirstBlockData"});
    }

    @Override // com.bytedance.ee.bear.bitable.dao.BitableDatabase
    public final as4.a d() {
        if (this.f210618a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f210618a != null) goto L10;
        this.f210618a = new b(this);     // Catch: Throwable -> L13
    L10:
        b r100 = this.f210618a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r100;
    L5:
        return this.f210618a;
    }

    public BitableDatabase_Impl() {
    }

    public static /* synthetic */ List e(BitableDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List f(BitableDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List g(BitableDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List h(BitableDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List i(BitableDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List j(BitableDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List k(BitableDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List m(BitableDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List n(BitableDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r100) {
        RoomOpenHelper r101 = new RoomOpenHelper(r100, new a(this), "53273439dc6ea32bd8e44f57c162ce28", "9373da07904c651a976f4deadf0f8515");
        SupportSQLiteOpenHelper.Configuration r102 = SupportSQLiteOpenHelper.Configuration.builder(r100.context).name(r100.name).callback(r101).build();
        return r100.sqliteOpenHelperFactory.create(r102);
    }

    public static /* synthetic */ void l(BitableDatabase_Impl r100, SupportSQLiteDatabase r101) {
        r100.mDatabase = r101;
    }
}
