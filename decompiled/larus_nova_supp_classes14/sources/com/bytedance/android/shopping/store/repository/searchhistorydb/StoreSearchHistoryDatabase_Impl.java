package com.bytedance.android.shopping.store.repository.searchhistorydb;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tj3.b;
import tj3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class StoreSearchHistoryDatabase_Impl extends StoreSearchHistoryDatabase {
    public volatile f a;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ StoreSearchHistoryDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(StoreSearchHistoryDatabase_Impl r1) {
            this.a = r1;
            super(1);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `store_search_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` TEXT, `store_id` TEXT, `key_word` TEXT, `time_stamp` INTEGER)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9df35b2006b016f382caf1d1e77f8b66')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("DROP TABLE IF EXISTS `store_search_history`");
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (StoreSearchHistoryDatabase_Impl.d(this.a) == null) goto L7;
            int r0 = StoreSearchHistoryDatabase_Impl.e(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(StoreSearchHistoryDatabase_Impl.f(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            StoreSearchHistoryDatabase_Impl.g(this.a, r4);
            this.a.internalInitInvalidationTracker(r4);
            if (StoreSearchHistoryDatabase_Impl.h(this.a) == null) goto L7;
            int r0 = StoreSearchHistoryDatabase_Impl.i(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(StoreSearchHistoryDatabase_Impl.j(this.a), r1)).onOpen(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onPreMigrate(SupportSQLiteDatabase r1) {
            DBUtil.dropFtsSyncTriggers(r1);
        }

        public final void validateMigration(SupportSQLiteDatabase r7) {
            HashMap r0 = new HashMap(5);
            r0.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
            r0.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0));
            r0.put("store_id", new TableInfo.Column("store_id", "TEXT", false, 0));
            r0.put("key_word", new TableInfo.Column("key_word", "TEXT", false, 0));
            r0.put("time_stamp", new TableInfo.Column("time_stamp", "INTEGER", false, 0));
            TableInfo r3 = new TableInfo("store_search_history", r0, new HashSet(0), new HashSet(0));
            TableInfo r8 = TableInfo.read(r7, "store_search_history");
            if (r3.equals(r8) == false) goto L6;
            return;
        L6:
            throw new IllegalStateException("Migration didn't properly handle store_search_history(com.bytedance.android.shopping.store.repository.dto.StoreSearchHistoryDTO).\n Expected:\n" + r3 + "\n Found:\n" + r8);
        }
    }

    @Override // com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase
    public final b c() {
        if (this.a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.a != null) goto L10;
        this.a = new f(this);     // Catch: Throwable -> L13
    L10:
        f r0 = this.a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.a;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `store_search_history`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"store_search_history"});
    }

    public StoreSearchHistoryDatabase_Impl() {
    }

    public static /* synthetic */ List d(StoreSearchHistoryDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List e(StoreSearchHistoryDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List f(StoreSearchHistoryDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(StoreSearchHistoryDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(StoreSearchHistoryDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(StoreSearchHistoryDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "9df35b2006b016f382caf1d1e77f8b66", "5265a9d32fd0f41c97e0ec0028750874");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public static /* synthetic */ void g(StoreSearchHistoryDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
