package com.ss.android.lark.security.compliance.infra.storage.lru;

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
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import x4c.e;

/* JADX INFO: loaded from: classes38.dex */
public final class CacheDatabase_Impl extends CacheDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile e f440475a;

    public class a extends RoomOpenHelper.Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CacheDatabase_Impl f440476a;

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPostMigrate(SupportSQLiteDatabase r100) {
        }

        public a(CacheDatabase_Impl r100) {
            this.f440476a = r100;
            super(1);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void createAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `lru_cache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `key` TEXT NOT NULL, `value` TEXT NOT NULL, `lastAccessTime` INTEGER NOT NULL)");
            r100.execSQL("CREATE INDEX IF NOT EXISTS `lastAccessTimeIdx` ON `lru_cache` (`lastAccessTime`)");
            r100.execSQL(RoomMasterTable.CREATE_QUERY);
            r100.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'afcc113adfb4eb83ef097b5778a3ea4e')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void dropAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `lru_cache`");
            if (CacheDatabase_Impl.d(this.f440476a) == null) goto L7;
            int r101 = CacheDatabase_Impl.e(this.f440476a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(CacheDatabase_Impl.g(this.f440476a), r102)).onDestructiveMigration(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onCreate(SupportSQLiteDatabase r100) {
            if (CacheDatabase_Impl.h(this.f440476a) == null) goto L7;
            int r101 = CacheDatabase_Impl.i(this.f440476a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(CacheDatabase_Impl.j(this.f440476a), r102)).onCreate(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onOpen(SupportSQLiteDatabase r100) {
            CacheDatabase_Impl.k(this.f440476a, r100);
            this.f440476a.internalInitInvalidationTracker(r100);
            if (CacheDatabase_Impl.l(this.f440476a) == null) goto L7;
            int r101 = CacheDatabase_Impl.m(this.f440476a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(CacheDatabase_Impl.f(this.f440476a), r102)).onOpen(r100);
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
            r100.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            r100.put("key", new TableInfo.Column("key", CardAdapter.TEXT, true, 0, null, 1));
            r100.put("value", new TableInfo.Column("value", CardAdapter.TEXT, true, 0, null, 1));
            r100.put("lastAccessTime", new TableInfo.Column("lastAccessTime", "INTEGER", true, 0, null, 1));
            HashSet r101 = new HashSet(0);
            HashSet r102 = new HashSet(1);
            r102.add(new TableInfo.Index("lastAccessTimeIdx", false, Arrays.asList(new String[]{"lastAccessTime"})));
            TableInfo r103 = new TableInfo(MonitorConstants.InfoType.LRU_CACHE, r100, r101, r102);
            TableInfo r111 = TableInfo.read(r110, MonitorConstants.InfoType.LRU_CACHE);
            if (r103.equals(r111) == true) goto L7;
            return new RoomOpenHelper.ValidationResult(false, "lru_cache(com.ss.android.lark.security.compliance.infra.storage.lru.CacheEntry).\n Expected:\n" + r103 + "\n Found:\n" + r111);
        L7:
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // com.ss.android.lark.security.compliance.infra.storage.lru.CacheDatabase
    public final x4c.a c() {
        if (this.f440475a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f440475a != null) goto L10;
        this.f440475a = new e(this);     // Catch: Throwable -> L13
    L10:
        e r100 = this.f440475a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r100;
    L5:
        return this.f440475a;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r100 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r100.execSQL("DELETE FROM `lru_cache`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{MonitorConstants.InfoType.LRU_CACHE});
    }

    public CacheDatabase_Impl() {
    }

    public static /* synthetic */ List d(CacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List e(CacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List f(CacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List g(CacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List h(CacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List i(CacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List j(CacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List l(CacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List m(CacheDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r100) {
        RoomOpenHelper r101 = new RoomOpenHelper(r100, new a(this), "afcc113adfb4eb83ef097b5778a3ea4e", "54ee6106428b63eb29b4f330011a8a13");
        SupportSQLiteOpenHelper.Configuration r102 = SupportSQLiteOpenHelper.Configuration.builder(r100.context).name(r100.name).callback(r101).build();
        return r100.sqliteOpenHelperFactory.create(r102);
    }

    public static /* synthetic */ void k(CacheDatabase_Impl r100, SupportSQLiteDatabase r101) {
        r100.mDatabase = r101;
    }
}
