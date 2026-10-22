package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class LynxCacheDatabase_Impl extends LynxCacheDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile h f229936a;

    public class a extends RoomOpenHelper.Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxCacheDatabase_Impl f229937a;

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPostMigrate(SupportSQLiteDatabase r100) {
        }

        public a(LynxCacheDatabase_Impl r100) {
            this.f229937a = r100;
            super(1);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void createAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `lynx_cache_model` (`business` TEXT NOT NULL, `key` TEXT NOT NULL, `value` TEXT, `access_time` INTEGER, PRIMARY KEY(`business`, `key`))");
            r100.execSQL(RoomMasterTable.CREATE_QUERY);
            r100.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '90659e4b6368e85f5328c9d4cb0e1cfa')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void dropAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `lynx_cache_model`");
            if (LynxCacheDatabase_Impl.d(this.f229937a) == null) goto L7;
            int r101 = LynxCacheDatabase_Impl.e(this.f229937a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(LynxCacheDatabase_Impl.g(this.f229937a), r102)).onDestructiveMigration(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onCreate(SupportSQLiteDatabase r100) {
            if (LynxCacheDatabase_Impl.h(this.f229937a) == null) goto L7;
            int r101 = LynxCacheDatabase_Impl.i(this.f229937a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(LynxCacheDatabase_Impl.j(this.f229937a), r102)).onCreate(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onOpen(SupportSQLiteDatabase r100) {
            LynxCacheDatabase_Impl.k(this.f229937a, r100);
            this.f229937a.internalInitInvalidationTracker(r100);
            if (LynxCacheDatabase_Impl.l(this.f229937a) == null) goto L7;
            int r101 = LynxCacheDatabase_Impl.m(this.f229937a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(LynxCacheDatabase_Impl.f(this.f229937a), r102)).onOpen(r100);
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
            r100.put("business", new TableInfo.Column("business", CardAdapter.TEXT, true, 1, null, 1));
            r100.put("key", new TableInfo.Column("key", CardAdapter.TEXT, true, 2, null, 1));
            r100.put("value", new TableInfo.Column("value", CardAdapter.TEXT, false, 0, null, 1));
            r100.put(ResourceData.ACCESS_TIME, new TableInfo.Column(ResourceData.ACCESS_TIME, "INTEGER", false, 0, null, 1));
            TableInfo r101 = new TableInfo("lynx_cache_model", r100, new HashSet(0), new HashSet(0));
            TableInfo r111 = TableInfo.read(r110, "lynx_cache_model");
            if (r101.equals(r111) == true) goto L7;
            return new RoomOpenHelper.ValidationResult(false, "lynx_cache_model(com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.LynxCacheModel).\n Expected:\n" + r101 + "\n Found:\n" + r111);
        L7:
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.LynxCacheDatabase
    public final d c() {
        if (this.f229936a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f229936a != null) goto L10;
        this.f229936a = new h(this);     // Catch: Throwable -> L13
    L10:
        h r100 = this.f229936a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r100;
    L5:
        return this.f229936a;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r100 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r100.execSQL("DELETE FROM `lynx_cache_model`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"lynx_cache_model"});
    }

    public LynxCacheDatabase_Impl() {
    }

    public static /* synthetic */ List d(LynxCacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List e(LynxCacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List f(LynxCacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List g(LynxCacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List h(LynxCacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List i(LynxCacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List j(LynxCacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List l(LynxCacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List m(LynxCacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r100) {
        RoomOpenHelper r101 = new RoomOpenHelper(r100, new a(this), "90659e4b6368e85f5328c9d4cb0e1cfa", "7efcc2973448d88f75b4410bac180109");
        SupportSQLiteOpenHelper.Configuration r102 = SupportSQLiteOpenHelper.Configuration.builder(r100.context).name(r100.name).callback(r101).build();
        return r100.sqliteOpenHelperFactory.create(r102);
    }

    public static /* synthetic */ void k(LynxCacheDatabase_Impl r100, SupportSQLiteDatabase r101) {
        r100.mDatabase = r101;
    }
}
