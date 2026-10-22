package com.bytedance.ee.util.db;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import ju5.d;
import ju5.g;

/* JADX INFO: loaded from: classes19.dex */
public final class KeyValueDatabase_Impl extends KeyValueDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile g f243106a;

    public class a extends RoomOpenHelper.Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KeyValueDatabase_Impl f243107a;

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPostMigrate(SupportSQLiteDatabase r100) {
        }

        public a(KeyValueDatabase_Impl r100) {
            this.f243107a = r100;
            super(1);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void createAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `key_value_model` (`key` TEXT NOT NULL, `value` TEXT, PRIMARY KEY(`key`))");
            r100.execSQL(RoomMasterTable.CREATE_QUERY);
            r100.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '06b304a6a53ebec229b882249c8292a5')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void dropAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `key_value_model`");
            if (KeyValueDatabase_Impl.d(this.f243107a) == null) goto L7;
            int r101 = KeyValueDatabase_Impl.e(this.f243107a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(KeyValueDatabase_Impl.g(this.f243107a), r102)).onDestructiveMigration(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onCreate(SupportSQLiteDatabase r100) {
            if (KeyValueDatabase_Impl.h(this.f243107a) == null) goto L7;
            int r101 = KeyValueDatabase_Impl.i(this.f243107a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(KeyValueDatabase_Impl.j(this.f243107a), r102)).onCreate(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onOpen(SupportSQLiteDatabase r100) {
            KeyValueDatabase_Impl.k(this.f243107a, r100);
            this.f243107a.internalInitInvalidationTracker(r100);
            if (KeyValueDatabase_Impl.l(this.f243107a) == null) goto L7;
            int r101 = KeyValueDatabase_Impl.m(this.f243107a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(KeyValueDatabase_Impl.f(this.f243107a), r102)).onOpen(r100);
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
            HashMap r100 = new HashMap(2);
            r100.put("key", new TableInfo.Column("key", CardAdapter.TEXT, true, 1, null, 1));
            r100.put("value", new TableInfo.Column("value", CardAdapter.TEXT, false, 0, null, 1));
            TableInfo r101 = new TableInfo("key_value_model", r100, new HashSet(0), new HashSet(0));
            TableInfo r111 = TableInfo.read(r110, "key_value_model");
            if (r101.equals(r111) == true) goto L7;
            return new RoomOpenHelper.ValidationResult(false, "key_value_model(com.bytedance.ee.util.db.KeyValueModel).\n Expected:\n" + r101 + "\n Found:\n" + r111);
        L7:
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // com.bytedance.ee.util.db.KeyValueDatabase
    public final d c() {
        if (this.f243106a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f243106a != null) goto L10;
        this.f243106a = new g(this);     // Catch: Throwable -> L13
    L10:
        g r100 = this.f243106a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r100;
    L5:
        return this.f243106a;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r100 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r100.execSQL("DELETE FROM `key_value_model`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"key_value_model"});
    }

    public KeyValueDatabase_Impl() {
    }

    public static /* synthetic */ List d(KeyValueDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List e(KeyValueDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List f(KeyValueDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List g(KeyValueDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List h(KeyValueDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List i(KeyValueDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List j(KeyValueDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List l(KeyValueDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List m(KeyValueDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r100) {
        RoomOpenHelper r101 = new RoomOpenHelper(r100, new a(this), "06b304a6a53ebec229b882249c8292a5", "46a0183d47a89038d6cacedb2e6492b7");
        SupportSQLiteOpenHelper.Configuration r102 = SupportSQLiteOpenHelper.Configuration.builder(r100.context).name(r100.name).callback(r101).build();
        return r100.sqliteOpenHelperFactory.create(r102);
    }

    public static /* synthetic */ void k(KeyValueDatabase_Impl r100, SupportSQLiteDatabase r101) {
        r100.mDatabase = r101;
    }
}
