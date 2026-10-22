package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class LynxCacheDatabase_Impl extends LynxCacheDatabase {
    public volatile h a;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ LynxCacheDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(LynxCacheDatabase_Impl r1) {
            this.a = r1;
            super(1);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `lynx_cache_model` (`business` TEXT NOT NULL, `key` TEXT NOT NULL, `value` TEXT, `access_time` INTEGER, PRIMARY KEY(`business`, `key`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '90659e4b6368e85f5328c9d4cb0e1cfa')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r4) {
            r4.execSQL("DROP TABLE IF EXISTS `lynx_cache_model`");
            if (LynxCacheDatabase_Impl.d(this.a) == null) goto L7;
            int r0 = LynxCacheDatabase_Impl.e(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(LynxCacheDatabase_Impl.g(this.a), r1)).onDestructiveMigration(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (LynxCacheDatabase_Impl.h(this.a) == null) goto L7;
            int r0 = LynxCacheDatabase_Impl.i(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(LynxCacheDatabase_Impl.j(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            LynxCacheDatabase_Impl.k(this.a, r4);
            this.a.internalInitInvalidationTracker(r4);
            if (LynxCacheDatabase_Impl.l(this.a) == null) goto L7;
            int r0 = LynxCacheDatabase_Impl.m(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(LynxCacheDatabase_Impl.f(this.a), r1)).onOpen(r4);
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
            r0.put("business", new TableInfo.Column("business", CardAdapter.TEXT, true, 1, null, 1));
            r0.put("key", new TableInfo.Column("key", CardAdapter.TEXT, true, 2, null, 1));
            r0.put("value", new TableInfo.Column("value", CardAdapter.TEXT, false, 0, null, 1));
            r0.put(ResourceData.ACCESS_TIME, new TableInfo.Column(ResourceData.ACCESS_TIME, "INTEGER", false, 0, null, 1));
            TableInfo r4 = new TableInfo("lynx_cache_model", r0, new HashSet(0), new HashSet(0));
            TableInfo r12 = TableInfo.read(r11, "lynx_cache_model");
            if (r4.equals(r12) == true) goto L7;
            return new RoomOpenHelper.ValidationResult(false, "lynx_cache_model(com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.LynxCacheModel).\n Expected:\n" + r4 + "\n Found:\n" + r12);
        L7:
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.LynxCacheDatabase
    public final d c() {
        if (this.a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.a != null) goto L10;
        this.a = new h(this);     // Catch: Throwable -> L13
    L10:
        h r0 = this.a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.a;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `lynx_cache_model`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"lynx_cache_model"});
    }

    public LynxCacheDatabase_Impl() {
    }

    public static /* synthetic */ List d(LynxCacheDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List e(LynxCacheDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List f(LynxCacheDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(LynxCacheDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(LynxCacheDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(LynxCacheDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(LynxCacheDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List l(LynxCacheDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List m(LynxCacheDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "90659e4b6368e85f5328c9d4cb0e1cfa", "7efcc2973448d88f75b4410bac180109");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public static /* synthetic */ void k(LynxCacheDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
