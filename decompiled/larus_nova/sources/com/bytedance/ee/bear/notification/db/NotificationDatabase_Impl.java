package com.bytedance.ee.bear.notification.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import ck5.b;
import ck5.h;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class NotificationDatabase_Impl extends NotificationDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile h f235109a;

    public class a extends RoomOpenHelper.Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationDatabase_Impl f235110a;

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPostMigrate(SupportSQLiteDatabase r100) {
        }

        public a(NotificationDatabase_Impl r100) {
            this.f235110a = r100;
            super(2);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void createAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `Notification` (`id` TEXT NOT NULL, `start_time` INTEGER NOT NULL, `end_time` INTEGER NOT NULL, `content` TEXT, `product` TEXT, `close` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            r100.execSQL(RoomMasterTable.CREATE_QUERY);
            r100.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '66519bdaf2c8a261f21cc46b74f2a193')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void dropAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `Notification`");
            if (NotificationDatabase_Impl.d(this.f235110a) == null) goto L7;
            int r101 = NotificationDatabase_Impl.e(this.f235110a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(NotificationDatabase_Impl.g(this.f235110a), r102)).onDestructiveMigration(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onCreate(SupportSQLiteDatabase r100) {
            if (NotificationDatabase_Impl.h(this.f235110a) == null) goto L7;
            int r101 = NotificationDatabase_Impl.i(this.f235110a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(NotificationDatabase_Impl.j(this.f235110a), r102)).onCreate(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onOpen(SupportSQLiteDatabase r100) {
            NotificationDatabase_Impl.k(this.f235110a, r100);
            this.f235110a.internalInitInvalidationTracker(r100);
            if (NotificationDatabase_Impl.l(this.f235110a) == null) goto L7;
            int r101 = NotificationDatabase_Impl.m(this.f235110a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(NotificationDatabase_Impl.f(this.f235110a), r102)).onOpen(r100);
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
            HashMap r100 = new HashMap(6);
            r100.put("id", new TableInfo.Column("id", CardAdapter.TEXT, true, 1, null, 1));
            r100.put(ILoadStallMonitor.START_TIME, new TableInfo.Column(ILoadStallMonitor.START_TIME, "INTEGER", true, 0, null, 1));
            r100.put("end_time", new TableInfo.Column("end_time", "INTEGER", true, 0, null, 1));
            r100.put("content", new TableInfo.Column("content", CardAdapter.TEXT, false, 0, null, 1));
            r100.put("product", new TableInfo.Column("product", CardAdapter.TEXT, false, 0, null, 1));
            r100.put("close", new TableInfo.Column("close", "INTEGER", true, 0, null, 1));
            TableInfo r101 = new TableInfo("Notification", r100, new HashSet(0), new HashSet(0));
            TableInfo r111 = TableInfo.read(r110, "Notification");
            if (r101.equals(r111) == true) goto L7;
            return new RoomOpenHelper.ValidationResult(false, "Notification(com.bytedance.ee.bear.notification.bean.Notification).\n Expected:\n" + r101 + "\n Found:\n" + r111);
        L7:
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // com.bytedance.ee.bear.notification.db.NotificationDatabase
    public final b c() {
        if (this.f235109a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f235109a != null) goto L10;
        this.f235109a = new h(this);     // Catch: Throwable -> L13
    L10:
        h r100 = this.f235109a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r100;
    L5:
        return this.f235109a;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r100 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r100.execSQL("DELETE FROM `Notification`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"Notification"});
    }

    public NotificationDatabase_Impl() {
    }

    public static /* synthetic */ List d(NotificationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List e(NotificationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List f(NotificationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List g(NotificationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List h(NotificationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List i(NotificationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List j(NotificationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List l(NotificationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List m(NotificationDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r100) {
        RoomOpenHelper r101 = new RoomOpenHelper(r100, new a(this), "66519bdaf2c8a261f21cc46b74f2a193", "77411312c8afe5cb1f571a9288c6f395");
        SupportSQLiteOpenHelper.Configuration r102 = SupportSQLiteOpenHelper.Configuration.builder(r100.context).name(r100.name).callback(r101).build();
        return r100.sqliteOpenHelperFactory.create(r102);
    }

    public static /* synthetic */ void k(NotificationDatabase_Impl r100, SupportSQLiteDatabase r101) {
        r100.mDatabase = r101;
    }
}
