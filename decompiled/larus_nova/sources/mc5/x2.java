package mc5;

import android.app.Application;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.bear.list.cache.BearDatabase;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.cache.migration.Migration40_41;
import com.bytedance.ee.bear.list.cache.migration.Migration41_42;
import com.bytedance.ee.bear.list.cache.migration.Migration42_43;
import com.bytedance.ee.bear.list.cache.migration.Migration43_44;
import com.bytedance.ee.bear.list.cache.migration.Migration44_45;
import com.bytedance.ee.bear.list.cache.migration.Migration46_47;
import com.bytedance.ee.bear.list.cache.migration.Migration47_48;
import com.bytedance.ee.bear.list.cache.migration.Migration48_49;
import com.bytedance.ee.bear.list.cache.migration.Migration49_50;
import com.bytedance.ee.bear.list.cache.migration.Migration50_51;
import com.bytedance.ee.bear.list.cache.migration.Migration51_52;
import com.bytedance.ee.bear.list.cache.migration.Migration52_53;
import com.bytedance.ee.bear.list.cache.migration.Migration53_54;
import com.bytedance.ee.bear.list.cache.migration.Migration54_55;
import com.bytedance.ee.bear.list.cache.migration.Migration55_56;
import com.bytedance.ee.bear.list.cache.migration.Migration56_57;
import com.bytedance.ee.bear.list.cache.migration.Migration57_58;
import com.bytedance.ee.bear.list.cache.migration.Migration58_59;
import com.bytedance.ee.bear.list.cache.migration.Migration59_60;
import com.bytedance.ee.bear.list.cache.migration.Migration60_61;
import com.bytedance.ee.bear.list.cache.migration.Migration61_62;
import com.bytedance.ee.bear.list.cache.migration.Migration62_63;
import com.bytedance.ee.bear.list.cache.migration.Migration63_64;
import com.bytedance.ee.bear.list.cache.migration.Migration64_65;
import com.bytedance.ee.bear.list.cache.migration.Migration65_66;
import com.bytedance.ee.bear.list.cache.migration.Migration66To67;
import com.bytedance.ee.bear.list.cache.migration.Migration67To68;
import com.bytedance.ee.bear.list.cache.migration.Migration68To69;
import com.bytedance.ee.bear.list.cache.migration.Migration69To70;
import com.bytedance.ee.bear.list.cache.migration.Migration70To71;
import com.bytedance.ee.bear.list.cache.migration.Migration71To72;
import com.bytedance.ee.bear.list.cache.migration.Migration72To73;
import com.bytedance.ee.bear.list.cache.migration.Migration73To74;
import com.bytedance.ee.bear.list.cache.migration.Migration74To75;
import com.bytedance.ee.bear.list.cache.migration.Migration75To76;
import com.bytedance.ee.bear.list.cache.migration.Migration76To77;
import com.bytedance.ee.util.db.DBController;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.ee.util.livedata.WorkerLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes18.dex */
@UserScope
public final class x2 implements mc5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.util.db.a f513224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t45.c f513225b;

    public class a extends Migration {
        public a() {
            super(10, 11);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN share_time TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN open_time TEXT");
        }
    }

    public class a0 extends Migration {
        public a0() {
            super(34, 35);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_visited INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_hidden INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class b extends Migration {
        public b() {
            super(11, 12);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE OfflineOperateDoc ADD COLUMN offline_create INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class b0 extends Migration {
        public b0() {
            super(35, 36);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN thumbnail_url TEXT");
            r100.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN thumbnail_secret TEXT");
            r100.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN thumbnail_nonce TEXT");
            r100.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE MineDoc ADD COLUMN thumbnail_url TEXT");
            r100.execSQL("ALTER TABLE MineDoc ADD COLUMN thumbnail_secret TEXT");
            r100.execSQL("ALTER TABLE MineDoc ADD COLUMN thumbnail_nonce TEXT");
            r100.execSQL("ALTER TABLE MineDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN thumbnail_url TEXT");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN thumbnail_secret TEXT");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN thumbnail_nonce TEXT");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN thumbnail_url TEXT");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN thumbnail_secret TEXT");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN thumbnail_nonce TEXT");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN thumbnail_url TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN thumbnail_secret TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN thumbnail_nonce TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN thumbnail_url TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN thumbnail_secret TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN thumbnail_nonce TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN thumbnail_url TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN thumbnail_secret TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN thumbnail_nonce TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class c extends Migration {
        public c() {
            super(12, 13);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN filepath TEXT");
        }
    }

    public class c0 extends Migration {
        public c0() {
            super(36, 37);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `ManualOfflineDocNew` (`obj_token` TEXT NOT NULL, `userid` TEXT, `name` TEXT, `size` TEXT, `type` INTEGER NOT NULL DEFAULT 2, `subType` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL DEFAULT 0, `is_external` INTEGER NOT NULL DEFAULT 0, `url` TEXT, `add_time` TEXT, `edit_time` TEXT, `copiable` INTEGER NOT NULL DEFAULT 0, `is_info_complete` INTEGER NOT NULL DEFAULT 0, `owner_id` TEXT, `create_tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `open_time` TEXT, `create_time` TEXT, `fake_token` TEXT, `is_star` INTEGER NOT NULL DEFAULT 0, `is_top` INTEGER NOT NULL DEFAULT 0, `extra` TEXT, `thumbnail` TEXT, `thumbnail_url` TEXT, `thumbnail_secret` TEXT, `thumbnail_nonce` TEXT, `thumbnail_type` INTEGER NOT NULL DEFAULT 0, `is_backend_save` INTEGER NOT NULL DEFAULT 0, `is_need_wifi_download` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`obj_token`))");     // Catch: Exception -> L5
            r100.execSQL("insert into ManualOfflineDocNew select * from ManualOfflineDoc");     // Catch: Exception -> L5
            r100.execSQL("drop table ManualOfflineDoc");     // Catch: Exception -> L5
            r100.execSQL("alter table ManualOfflineDocNew rename to ManualOfflineDoc");     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            iu5.d.a("UserDatabaseManager", e);
            r100.execSQL("drop table ManualOfflineDoc");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `ManualOfflineDoc` (`obj_token` TEXT NOT NULL, `userid` TEXT, `name` TEXT, `size` TEXT, `type` INTEGER NOT NULL DEFAULT 2, `subType` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL DEFAULT 0, `is_external` INTEGER NOT NULL DEFAULT 0, `url` TEXT, `add_time` TEXT, `edit_time` TEXT, `copiable` INTEGER NOT NULL DEFAULT 0, `is_info_complete` INTEGER NOT NULL DEFAULT 0, `owner_id` TEXT, `create_tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `open_time` TEXT, `create_time` TEXT, `fake_token` TEXT, `is_star` INTEGER NOT NULL DEFAULT 0, `is_top` INTEGER NOT NULL DEFAULT 0, `extra` TEXT, `thumbnail` TEXT, `thumbnail_url` TEXT, `thumbnail_secret` TEXT, `thumbnail_nonce` TEXT, `thumbnail_type` INTEGER NOT NULL DEFAULT 0, `is_backend_save` INTEGER NOT NULL DEFAULT 0, `is_need_wifi_download` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`obj_token`))");
        }
    }

    public class d extends Migration {
        public d() {
            super(13, 14);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN url TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN url TEXT");
        }
    }

    public class d0 extends Migration {
        public d0() {
            super(37, 38);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN document_icon_key TEXT");
            r100.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r100.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN document_icon_fsunit TEXT");
            r100.execSQL("ALTER TABLE MineDoc ADD COLUMN document_icon_key TEXT");
            r100.execSQL("ALTER TABLE MineDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r100.execSQL("ALTER TABLE MineDoc ADD COLUMN document_icon_fsunit TEXT");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN document_icon_key TEXT");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN document_icon_fsunit TEXT");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN document_icon_key TEXT");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN document_icon_fsunit TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN document_icon_key TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN document_icon_fsunit TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN document_icon_key TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN document_icon_fsunit TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN document_icon_key TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN document_icon_fsunit TEXT");
        }
    }

    public class e extends Migration {
        public e() {
            super(14, 15);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN offline_create INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class e0 extends Migration {
        public e0() {
            super(38, 39);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN create_time TEXT");
        }
    }

    public class f extends Migration {
        public f() {
            super(15, 16);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN subtype TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN subtype TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN subtype TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN subtype TEXT");
            r100.execSQL("ALTER TABLE OfflineOperateDoc ADD COLUMN subtype TEXT");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN subtype TEXT");
        }
    }

    public class f0 extends Migration {
        public f0() {
            super(39, 40);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE MineDoc ADD COLUMN is_external INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class g extends Migration {
        public g() {
            super(16, 17);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `FolderSortStrategy` (`obj_token` TEXT PRIMARY KEY NOT NULL, `strategy` INTEGER NOT NULL, `update_time` TEXT)");
            r100.execSQL("ALTER TABLE OfflineOperateDoc ADD COLUMN create_time TEXT");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN create_time TEXT");
        }
    }

    public class g0 extends Migration {
        public g0() {
            super(3, 4);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("update PersonalDoc set filepath='' where filepath='/'");
            r100.execSQL("update RecentDoc set filepath='' where filepath='/'");
            r100.execSQL("update ShareDoc set filepath='' where filepath='/'");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `OfflineOperateDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fakeToken` TEXT, `groups` INTEGER NOT NULL, `operator` INTEGER NOT NULL, `userid` TEXT, `needSync` INTEGER NOT NULL, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT)");
        }
    }

    public class h extends Migration {
        public h() {
            super(17, 18);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN extra TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN extra TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN extra TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN extra TEXT");
            r100.execSQL("ALTER TABLE OfflineOperateDoc ADD COLUMN extra TEXT");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN extra TEXT");
        }
    }

    public class h0 extends Migration {
        public h0() {
            super(2, 3);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `PersonalDoc`");
            r100.execSQL("DROP TABLE IF EXISTS `RecentDoc`");
            r100.execSQL("DROP TABLE IF EXISTS `ShareDoc`");
            r100.execSQL("DROP TABLE IF EXISTS `TrashDoc`");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `PersonalDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT)");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `RecentDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT)");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `ShareDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT)");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `TrashDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `expire_time` TEXT, `obj_token` TEXT, `url` TEXT)");
        }
    }

    public class i extends Migration {
        public i() {
            super(18, 19);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `OfflineOperateDoc_New` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fakeToken` TEXT, `groups` INTEGER NOT NULL, `operator` INTEGER NOT NULL, `userid` TEXT, `needSync` INTEGER NOT NULL, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT, `create_time` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `subtype` TEXT, `offline_create` INTEGER NOT NULL DEFAULT 0, `extra` TEXT)");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `PersonalDoc_New` (`token` TEXT PRIMARY KEY NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT, `create_time` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, `space_id` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0, `is_star` INTEGER NOT NULL DEFAULT 0, `is_pine` INTEGER NOT NULL DEFAULT 0, `subtype` TEXT, `extra` TEXT)");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `RecentDoc_New` (`obj_token` TEXT PRIMARY KEY NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, `is_external` INTEGER NOT NULL DEFAULT 0, `is_star` INTEGER NOT NULL DEFAULT 0, `is_pine` INTEGER NOT NULL DEFAULT 0, `open_time` TEXT, `subtype` TEXT, `offline_create` INTEGER NOT NULL DEFAULT 0, `extra` TEXT)");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `ShareDoc_New` (`token` TEXT PRIMARY KEY NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, `space_id` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0, `is_star` INTEGER NOT NULL DEFAULT 0, `is_pine` INTEGER NOT NULL DEFAULT 0, `share_time` TEXT, `subtype` TEXT, `extra` TEXT)");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `TrashDoc_New` (`token` TEXT PRIMARY KEY NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `expire_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, `space_id` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0)");
            r100.execSQL("INSERT INTO OfflineOperateDoc_New(id, fakeToken, groups, operator, userid, needSync, filepath, name, token, type, owner_id, create_time, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, subtype, offline_create, extra) SELECT id, fakeToken, groups, operator, userid, needSync, filepath, name, token, type, create_uid, create_time, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, subtype, offline_create, extra FROM OfflineOperateDoc");
            r100.execSQL("INSERT INTO PersonalDoc_New(token, userid, filepath, name, type, owner_id, create_time, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, fake_token, needSync, space_id, is_external, is_star, is_pine, subtype, extra) SELECT token, userid, filepath, name, type, create_uid, create_time, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, fake_token, needSync, space_id, is_external, is_star, is_pine, subtype, extra FROM PersonalDoc");
            r100.execSQL("INSERT INTO RecentDoc_New(obj_token, userid, filepath, name, type, owner_id, creator_cn_name, creator_en_name, edit_uid, edit_time, url, fake_token, needSync, is_external, is_star, is_pine, open_time, subtype, offline_create, extra) SELECT obj_token, userid, filepath, name, type, create_uid, creator_cn_name, creator_en_name, edit_uid, edit_time, url, fake_token, needSync, is_external, is_star, is_pine, open_time, subtype, offline_create, extra FROM RecentDoc");
            r100.execSQL("INSERT INTO ShareDoc_New(token, userid, filepath, name, type, owner_id, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, fake_token, needSync, space_id, is_external, is_star, is_pine, share_time, subtype, extra) SELECT token, userid, filepath, name, type, create_uid, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, fake_token, needSync, space_id, is_external, is_star, is_pine, share_time, subtype, extra FROM ShareDoc");
            r100.execSQL("INSERT INTO TrashDoc_New(token, userid, filepath, name, type, owner_id, creator_cn_name, creator_en_name, edit_uid, edit_time, expire_time, obj_token, url, fake_token, needSync, space_id, is_external) SELECT token, userid, filepath, name, type, create_uid, creator_cn_name, creator_en_name, edit_uid, edit_time, expire_time, obj_token, url, fake_token, needSync, space_id, is_external FROM TrashDoc");
            r100.execSQL("DROP TABLE IF EXISTS 'OfflineOperateDoc'");
            r100.execSQL("DROP TABLE IF EXISTS 'PersonalDoc'");
            r100.execSQL("DROP TABLE IF EXISTS 'RecentDoc'");
            r100.execSQL("DROP TABLE IF EXISTS 'ShareDoc'");
            r100.execSQL("DROP TABLE IF EXISTS 'TrashDoc'");
            r100.execSQL("ALTER TABLE OfflineOperateDoc_New RENAME TO OfflineOperateDoc");
            r100.execSQL("ALTER TABLE PersonalDoc_New RENAME TO PersonalDoc");
            r100.execSQL("ALTER TABLE RecentDoc_New RENAME TO RecentDoc");
            r100.execSQL("ALTER TABLE ShareDoc_New RENAME TO ShareDoc");
            r100.execSQL("ALTER TABLE TrashDoc_New RENAME TO TrashDoc");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN tenant_id TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN owner_id TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN create_tenant_id TEXT");
        }
    }

    public class i0 extends WorkerLiveData<List<u1>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f513226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x2 f513227c;

        @Override // com.bytedance.ee.util.livedata.WorkerLiveData
        public final LiveData<List<u1>> a() {
            mc5.n r100 = this.f513227c.a().c();
            d1 r101 = (d1) r100;
            return r101.n(this.f513226b);
        }

        public i0(x2 r100, int r101) {
            this.f513227c = r100;
            this.f513226b = r101;
        }
    }

    public class j extends Migration {
        public j() {
            super(19, 20);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN icon_url TEXT");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN icon_key TEXT");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN icon_nonce TEXT");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN icon_encrypted_type INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN icon_url TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN icon_key TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN icon_nonce TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN icon_encrypted_type INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN icon_url TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN icon_key TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN icon_nonce TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN icon_encrypted_type INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN icon_url TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN icon_key TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN icon_nonce TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN icon_encrypted_type INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class j0 extends WorkerLiveData<List<u1>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x2 f513228b;

        @Override // com.bytedance.ee.util.livedata.WorkerLiveData
        public final LiveData<List<u1>> a() {
            mc5.n r100 = this.f513228b.a().c();
            int r101 = sbb.e.f541295f.f541317b;
            d1 r102 = (d1) r100;
            r102.getClass();
            RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? AND DMI.type != ?", 2);
            r103.bindLong(1, 4);
            r103.bindLong(2, r101);
            return r102.f513025a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new n1(r102, r103));
        }

        public j0(x2 r100) {
            this.f513228b = r100;
        }
    }

    public class k extends RoomDatabase.Callback {
        public k() {
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onCreate(SupportSQLiteDatabase r100) {
            super.onCreate(r100);
            tt5.a.b("UserDatabaseManager", "onCreate: ");
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onOpen(SupportSQLiteDatabase r100) {
            super.onOpen(r100);
            tt5.a.b("UserDatabaseManager", "onOpen: ");
        }
    }

    public class k0 extends Migration {
        public k0() {
            super(4, 5);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `PersonalDoc`");
            r100.execSQL("DROP TABLE IF EXISTS `RecentDoc`");
            r100.execSQL("DROP TABLE IF EXISTS `ShareDoc`");
            r100.execSQL("DROP TABLE IF EXISTS `TrashDoc`");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `PersonalDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, PRIMARY KEY(`token`))");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `RecentDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, PRIMARY KEY(`token`))");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `ShareDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, PRIMARY KEY(`token`))");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `TrashDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `expire_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, PRIMARY KEY(`token`))");
        }
    }

    public class l extends Migration {
        public l() {
            super(20, 21);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN is_share_root INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_share_root INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN is_share_root INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class l0 extends Migration {
        public l0() {
            super(5, 6);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN space_id TEXT");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN link_token TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN space_id TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN link_token TEXT");
            r100.execSQL("ALTER TABLE TrashDoc ADD COLUMN space_id TEXT");
            r100.execSQL("ALTER TABLE TrashDoc ADD COLUMN link_token TEXT");
        }
    }

    public class m extends Migration {
        public m() {
            super(21, 22);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `RecentPull` (`time_range` TEXT NOT NULL PRIMARY KEY, `smaller_time` TEXT, `bigger_time` TEXT, `last_label` TEXT, `uid` TEXT)");
        }
    }

    public class m0 extends Migration {
        public m0() {
            super(6, 7);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `RecentDoc`");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `RecentDoc` (`userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT NOT NULL, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, PRIMARY KEY(`obj_token`))");
        }
    }

    public class n extends Migration {
        public n() {
            super(22, 23);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `MineDoc` (`obj_token` TEXT PRIMARY KEY NOT NULL,`user_id` TEXT,`owner_id` TEXT,`filepath` TEXT,`name` TEXT,`type` INTEGER NOT NULL DEFAULT 2,`create_tenant_id` TEXT,`create_time` TEXT,`creator_cn_name` TEXT,`creator_en_name` TEXT,`edit_uid` TEXT,`edit_time` TEXT,`url` TEXT,`thumbnail` TEXT,`fake_token` TEXT,`needSync` INTEGER NOT NULL DEFAULT 0,`is_stared` INTEGER NOT NULL DEFAULT 0,`subtype` TEXT,`parent` TEXT,`extra` TEXT,`icon` TEXT,`icon_key` TEXT,`icon_nonce` TEXT,`icon_encrypted_type` INTEGER NOT NULL DEFAULT 0)");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN thumbnail TEXT");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN thumbnail TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN thumbnail TEXT");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN thumbnail TEXT");
            r100.execSQL("ALTER TABLE FolderSortStrategy ADD COLUMN type INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE FolderSortStrategy ADD COLUMN file_type TEXT");
            r100.execSQL("ALTER TABLE FolderSortStrategy ADD COLUMN forbidden_file_type TEXT");
            r100.execSQL("ALTER TABLE FolderSortStrategy ADD COLUMN is_asc INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("UPDATE FolderSortStrategy SET strategy = 5, is_asc = 1 WHERE strategy = 1");
            r100.execSQL("UPDATE FolderSortStrategy SET strategy = 5, is_asc = 0 WHERE strategy = 2");
            r100.execSQL("UPDATE FolderSortStrategy SET strategy = 4, is_asc = 1 WHERE strategy = 3");
            r100.execSQL("UPDATE FolderSortStrategy SET strategy = 4, is_asc = 0 WHERE strategy = 4");
            r100.execSQL("UPDATE FolderSortStrategy SET strategy = 3, is_asc = 1 WHERE strategy = 5");
            r100.execSQL("UPDATE FolderSortStrategy SET strategy = 3, is_asc = 0 WHERE strategy = 6");
            r100.execSQL("UPDATE FolderSortStrategy SET strategy = 0, is_asc = 1 WHERE strategy = 7");
            r100.execSQL("UPDATE FolderSortStrategy SET strategy = 0, is_asc = 0 WHERE strategy = 8");
        }
    }

    public class n0 extends Migration {
        public n0() {
            super(7, 8);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `StatusDoc` (`doc_token` TEXT NOT NULL, `doc_type` INTEGER NOT NULL, `doc_sync_status` INTEGER NOT NULL, `doc_cache_status` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, PRIMARY KEY(`doc_token`,`doc_type`))");
            r100.execSQL("CREATE INDEX IF NOT EXISTS index_doc_token ON StatusDoc(`doc_token`)");
        }
    }

    public class o extends Migration {
        public o() {
            super(23, 24);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN is_top INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class o0 extends Migration {
        public o0() {
            super(8, 9);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN is_external INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_external INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN is_external INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE TrashDoc ADD COLUMN is_external INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class p extends Migration {
        public p() {
            super(24, 25);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DELETE FROM RecentDoc");
        }
    }

    public class p0 extends Migration {
        public p0() {
            super(9, 10);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `PinedDoc` (`uuid` TEXT NOT NULL PRIMARY KEY, `userid` TEXT, `token` TEXT, `name` TEXT, `type` TEXT, `pin_time` TEXT, `is_pined` INTEGER NOT NULL DEFAULT 0, `edit_uid` TEXT, `edit_time` TEXT, `owner_id` TEXT, `space_id` TEXT, `share_root` INTEGER NOT NULL DEFAULT 0, `is_stared` INTEGER NOT NULL DEFAULT 0, `imgUrl` TEXT, `imgTypes` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0)");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `StarDoc` (`uuid` TEXT NOT NULL PRIMARY KEY, `token` TEXT, `userid` TEXT, `name` TEXT, `type` INTEGER NOT NULL DEFAULT 0, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `space_id` TEXT, `star_time` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0)");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN is_star INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN is_pine  INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_star INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_pine  INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN is_star INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN is_pine  INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class q extends Migration {
        public q() {
            super(25, 26);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE MineDoc ADD COLUMN offline_create INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class r extends Migration {
        public r() {
            super(26, 27);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DELETE FROM RecentDoc");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN create_time TEXT");
            r100.execSQL("DELETE FROM RecentPull");
        }
    }

    public class s extends Migration {
        public s() {
            super(27, 28);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DELETE FROM RecentDoc");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN my_edit_time TEXT");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN activity_time TEXT");
            r100.execSQL("ALTER TABLE FolderSortStrategy ADD COLUMN user_id TEXT");
            r100.execSQL("DELETE FROM RecentPull");
        }
    }

    public class t extends Migration {
        public t() {
            super(28, 29);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `PinedDoc`");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `PinedDoc` (`obj_token` TEXT NOT NULL PRIMARY KEY, `user_id` TEXT, `name` TEXT, `type` INTEGER NOT NULL DEFAULT 2, `pin_time` TEXT, `is_pined` INTEGER NOT NULL DEFAULT 0, `edit_uid` TEXT, `edit_time` TEXT, `owner_id` TEXT, `creator_en_name` TEXT, `creator_cn_name` TEXT, `create_time` TEXT, `tenant_id` TEXT, `space_id` TEXT, `share_root` INTEGER NOT NULL DEFAULT 0, `is_stared` INTEGER NOT NULL DEFAULT 0, `thumbnail` TEXT, `url` TEXT, `subtype` TEXT, `extra` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0)");
        }
    }

    public class u extends Migration {
        public u() {
            super(29, 30);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DELETE FROM RecentDoc");
            r100.execSQL("ALTER TABLE MineDoc ADD COLUMN is_pin INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE MineDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE RecentDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class v extends Migration {
        public v() {
            super(1, 2);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `TrashDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `expire_time` TEXT, `obj_token` TEXT, `url` TEXT)");
        }
    }

    public class w extends Migration {
        public w() {
            super(30, 31);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `RecentDoc`");
            r100.execSQL("DROP TABLE IF EXISTS `MineDoc`");
            r100.execSQL("DROP TABLE IF EXISTS `PersonalDoc`");
            r100.execSQL("DROP TABLE IF EXISTS `ShareDoc`");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `PersonalDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT, `create_time` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `space_id` TEXT, `is_share_root` INTEGER NOT NULL, `is_external` INTEGER NOT NULL, `is_star` INTEGER NOT NULL, `is_pine` INTEGER NOT NULL, `subtype` TEXT, `extra` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL, `thumbnail` TEXT, `copiable` INTEGER NOT NULL, PRIMARY KEY(`token`))");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `RecentDoc` (`obj_token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `url` TEXT, `fake_token` TEXT, `is_external` INTEGER NOT NULL, `is_star` INTEGER NOT NULL, `is_pine` INTEGER NOT NULL, `open_time` TEXT, `subtype` TEXT, `extra` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL, `thumbnail` TEXT, `create_time` TEXT, `my_edit_time` TEXT, `activity_time` TEXT, `copiable` INTEGER NOT NULL, PRIMARY KEY(`obj_token`))");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `ShareDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `space_id` TEXT, `is_share_root` INTEGER NOT NULL, `is_external` INTEGER NOT NULL, `is_star` INTEGER NOT NULL, `is_pine` INTEGER NOT NULL, `share_time` TEXT, `subtype` TEXT, `extra` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL, `thumbnail` TEXT, `copiable` INTEGER NOT NULL, PRIMARY KEY(`token`))");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `MineDoc` (`obj_token` TEXT NOT NULL, `user_id` TEXT, `owner_id` TEXT, `filepath` TEXT, `name` TEXT, `type` INTEGER NOT NULL, `create_tenant_id` TEXT, `create_time` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `url` TEXT, `thumbnail` TEXT, `fake_token` TEXT, `is_stared` INTEGER NOT NULL, `is_pin` INTEGER NOT NULL, `subtype` TEXT, `parent` TEXT, `extra` TEXT, `icon` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL, `copiable` INTEGER NOT NULL, PRIMARY KEY(`obj_token`))");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `ManualOfflineDoc` (`obj_token` TEXT NOT NULL, `userid` TEXT NOT NULL, `name` TEXT, `size` TEXT, `type` INTEGER NOT NULL DEFAULT 2, `subType` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL DEFAULT 0, `is_external` INTEGER NOT NULL DEFAULT 0, `url` TEXT, `add_time` TEXT, `edit_time` TEXT, `copiable` INTEGER NOT NULL DEFAULT 0, `is_info_complete` INTEGER NOT NULL DEFAULT 0, `owner_id` TEXT, `create_tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `open_time` TEXT, `create_time` TEXT, `fake_token` TEXT, `is_star` INTEGER NOT NULL DEFAULT 0, `is_top` INTEGER NOT NULL DEFAULT 0, `extra` TEXT, `thumbnail` TEXT, `is_backend_save` INTEGER NOT NULL DEFAULT 0, `is_need_wifi_download` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`obj_token`,`userid`))");
        }
    }

    public class x extends Migration {
        public x() {
            super(31, 32);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN share_version INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE ShareDoc ADD COLUMN permission INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN share_version INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE PersonalDoc ADD COLUMN permission INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN share_version INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE StarDoc ADD COLUMN permission INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN share_version INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE PinedDoc ADD COLUMN permission INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class y extends Migration {
        public y() {
            super(32, 33);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `RecentWiki`");
            r100.execSQL("DROP TABLE IF EXISTS `WikiSpace`");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `RecentWiki` (`wiki_id` TEXT NOT NULL PRIMARY KEY, `userid` TEXT, `wiki_token` TEXT, `space_id` TEXT, `open_time` TEXT,`open_count` TEXT,`title` TEXT,`owner_id` TEXT,`creator_cn_name` TEXT,`creator_en_name` TEXT,`edit_uid` TEXT,`edit_time` TEXT,`url` TEXT,`obj_type` INTEGER NOT NULL DEFAULT 0, `obj_token` TEXT)");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `WikiSpace` (`space_id` TEXT NOT NULL PRIMARY KEY, `user_id` TEXT, `space_name` TEXT, `space_icon` TEXT, `attr` INTEGER NOT NULL DEFAULT 0, `description` TEXT,`is_star` INTEGER NOT NULL DEFAULT 0, `browse_time` TEXT,`wiki_token` TEXT,`obj_type` INTEGER NOT NULL DEFAULT 0, `obj_token` TEXT)");
        }
    }

    public class z extends Migration {
        public z() {
            super(33, 34);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE WikiSpace ADD COLUMN origin TEXT");
            r100.execSQL("ALTER TABLE WikiSpace ADD COLUMN thumbnail TEXT");
            r100.execSQL("ALTER TABLE WikiSpace ADD COLUMN cover_key TEXT");
            r100.execSQL("ALTER TABLE WikiSpace ADD COLUMN is_graph_dark INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE WikiSpace ADD COLUMN color_value TEXT");
        }
    }

    public final synchronized BearDatabase a() {
        monitor-enter(this);
        BearDatabase r100 = (BearDatabase) this.f513224a.r1("bear.db");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // mc5.j
    public final LiveData Fb() {
        long r100 = System.currentTimeMillis();
        tt5.a.h("UserDatabaseManager", "loadRecentDocsLimitLiveData()...start, listType = 1, limit = 20, thread = " + ThreadMethodProxy.currentThread().getName());
        BearDatabase r101 = a();     // Catch: Exception -> L5
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L5
        d1 r103 = (d1) r101.c();     // Catch: Exception -> L5
        r103.getClass();     // Catch: Exception -> L5
        RoomSQLiteQuery r104 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? ORDER BY CAST(LT.open_time_recent AS INTEGER) DESC, LT.obj_token ASC LIMIT ?", 2);     // Catch: Exception -> L5
        r104.bindLong(1, 1);     // Catch: Exception -> L5
        r104.bindLong(2, 20);     // Catch: Exception -> L5
        LiveData r105 = r103.f513025a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new j1(r103, r104));     // Catch: Exception -> L5
        long r106 = System.currentTimeMillis();     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "loadRecentDocsLimitLiveData()...liveData created, listType = 1, limit = 20, getDbCost = " + (r102 - r100) + ", createLiveDataCost = " + (r106 - r102) + ", totalCost = " + (r106 - r100) + ", liveDataHash = " + System.identityHashCode(r105) + ", thread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Exception -> L5
        return r105;
    L5:
        e = move-exception;
        tt5.a.e("UserDatabaseManager", "loadRecentDocsLimitLiveData()...failed, listType = 1, limit = 20, cost = " + (System.currentTimeMillis() - r100), e, false);
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final LiveData Od() {
        long r100 = System.currentTimeMillis();
        tt5.a.h("UserDatabaseManager", "loadStarDocsLimitLiveData()...start, listType = 6, limit = 20, thread = " + ThreadMethodProxy.currentThread().getName());
        BearDatabase r101 = a();     // Catch: Exception -> L5
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L5
        d1 r103 = (d1) r101.c();     // Catch: Exception -> L5
        r103.getClass();     // Catch: Exception -> L5
        RoomSQLiteQuery r104 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? ORDER BY CAST(LT.star_time_star AS INTEGER) DESC, LT.obj_token ASC LIMIT ?", 2);     // Catch: Exception -> L5
        r104.bindLong(1, 6);     // Catch: Exception -> L5
        r104.bindLong(2, 20);     // Catch: Exception -> L5
        LiveData r105 = r103.f513025a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new l1(r103, r104));     // Catch: Exception -> L5
        long r106 = System.currentTimeMillis();     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "loadStarDocsLimitLiveData()...liveData created, listType = 6, limit = 20, getDbCost = " + (r102 - r100) + ", createLiveDataCost = " + (r106 - r102) + ", totalCost = " + (r106 - r100) + ", liveDataHash = " + System.identityHashCode(r105) + ", thread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Exception -> L5
        return r105;
    L5:
        e = move-exception;
        tt5.a.e("UserDatabaseManager", "loadStarDocsLimitLiveData()...failed, listType = 6, limit = 20, cost = " + (System.currentTimeMillis() - r100), e, false);
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final LiveData Rd() {
        long r100 = System.currentTimeMillis();
        tt5.a.h("UserDatabaseManager", "loadPersonalDocsOfFolderLimitLiveData()...start, listType = 3, path = , limit = 20, thread = " + ThreadMethodProxy.currentThread().getName());
        BearDatabase r101 = a();     // Catch: Exception -> L5
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L5
        LiveData r103 = ((d1) r101.c()).A();     // Catch: Exception -> L5
        long r104 = System.currentTimeMillis();     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "loadPersonalDocsOfFolderLimitLiveData()...liveData created, listType = 3, path = , limit = 20, getDbCost = " + (r102 - r100) + ", createLiveDataCost = " + (r104 - r102) + ", totalCost = " + (r104 - r100) + ", liveDataHash = " + System.identityHashCode(r103) + ", thread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Exception -> L5
        return r103;
    L5:
        e = move-exception;
        tt5.a.e("UserDatabaseManager", "loadPersonalDocsOfFolderLimitLiveData()...failed, listType = 3, path = , limit = 20, cost = " + (System.currentTimeMillis() - r100), e, false);
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final LiveData T9() {
        return new z2(this);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final LiveData<List<u1>> bc() {
        return new j0(this);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final LiveData h4() {
        long r100 = System.currentTimeMillis();
        tt5.a.h("UserDatabaseManager", "loadSharedDocsLimitLiveData()...start, listType = 10, limit = 20, thread = " + ThreadMethodProxy.currentThread().getName());
        BearDatabase r101 = a();     // Catch: Exception -> L5
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L5
        d1 r103 = (d1) r101.c();     // Catch: Exception -> L5
        r103.getClass();     // Catch: Exception -> L5
        RoomSQLiteQuery r104 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? ORDER BY LT.share_time_share DESC, LT.obj_token ASC LIMIT ?", 2);     // Catch: Exception -> L5
        r104.bindLong(1, 10);     // Catch: Exception -> L5
        r104.bindLong(2, 20);     // Catch: Exception -> L5
        LiveData r105 = r103.f513025a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new k1(r103, r104));     // Catch: Exception -> L5
        long r106 = System.currentTimeMillis();     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "loadSharedDocsLimitLiveData()...liveData created, listType = 10, limit = 20, getDbCost = " + (r102 - r100) + ", createLiveDataCost = " + (r106 - r102) + ", totalCost = " + (r106 - r100) + ", liveDataHash = " + System.identityHashCode(r105) + ", thread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Exception -> L5
        return r105;
    L5:
        e = move-exception;
        tt5.a.e("UserDatabaseManager", "loadSharedDocsLimitLiveData()...failed, listType = 10, limit = 20, cost = " + (System.currentTimeMillis() - r100), e, false);
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final List<u1> A1() {
        List<u1> r100 = ((d1) a().c()).q();     // Catch: Exception -> L14
        if (hu5.a.d(r100) == true) goto L13;
        Iterator r101 = ((ArrayList) r100).iterator();     // Catch: Exception -> L14
    L6:
        if (r101.hasNext() == false) goto L13;
        u1 r102 = (u1) r101.next();     // Catch: Exception -> L14
        if (x1.a(r102.K) == false) goto L10;
        r102.K = 7;     // Catch: Exception -> L14
        goto L6
    L10:
        r102.K = 5;     // Catch: Exception -> L14
    L13:
        return r100;
    L14:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final List<b3> A7() {
        return ((j3) a().e()).b();
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final List<u1> D9() {
        return ((d1) a().c()).p();
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final List E3() {
        return ((d1) a().c()).H();
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final LiveData<List<u1>> G7() {
        mc5.n r100 = a().c();     // Catch: Exception -> L4
        int r101 = sbb.e.f541295f.f541317b;     // Catch: Exception -> L4
        d1 r102 = (d1) r100;     // Catch: Exception -> L4
        r102.getClass();     // Catch: Exception -> L4
        RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? AND DMI.type = ?", 2);     // Catch: Exception -> L4
        r103.bindLong(1, 4);     // Catch: Exception -> L4
        r103.bindLong(2, r101);     // Catch: Exception -> L4
        return r102.f513025a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new m1(r102, r103));
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final LiveData<List<u1>> I6() {
        return ((d1) a().c()).n(2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final List Nc() {
        return ((d1) a().c()).q();
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final void T7() {
        ((d1) a().c()).L();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final List bb() {
        return ((d1) a().c()).r();
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final List<mc5.a> e4() {
        return ((d1) a().c()).C();
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final List ed() {
        return ((d1) a().c()).K();
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final List<mc5.a> n2() {
        return ((d1) a().c()).D();
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final List A6(int r100) {
        return ((d1) a().c()).E(r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final int Ab(final String r100) {
        a().runInTransaction(new e2(this, r100));     // Catch: Exception -> L4
        return -1;
    L4:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final void B3(String r100) {
        t5(r100, 2);
    }

    @Override // mc5.j
    public final void D3(FolderSortStrategy r100) {
        mc5.i r101 = (mc5.i) a().d();     // Catch: Exception -> L9
        r101.f513077a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r101.f513077a.beginTransaction();     // Catch: Exception -> L9
        long r102 = r101.f513078b.insertAndReturnId(r100);     // Catch: Throwable -> L6
        r101.f513077a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r101.f513077a.endTransaction();     // Catch: Exception -> L9
        tt5.a.b("UserDatabaseManager", "insertSortStrategy()...: ret=" + r102);     // Catch: Exception -> L9
        return;
    L6:
        th = move-exception;
        r101.f513077a.endTransaction();     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final String F(String r100) {
        mc5.b r101 = P9(r100);     // Catch: Exception -> L8
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.f512889b;
    L8:
        e = move-exception;
        iu5.d.c(e);
        return null;
    }

    @Override // mc5.j
    public final int Ga(String r100) {
        int r101 = ((d1) a().c()).m(r100);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "deleteTtsPlaybackBeanByToken()...ret = " + r101);     // Catch: Exception -> L5
        return r101;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final long Ie(mc5.b r510) {
    L16:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    L4:
        if (r510.f512898f0 == false) goto L6;
        int r100 = ((d1) a().c()).a0(r510.f512887a, r510.getType(), r510.f512902j, r510.f512892c0, r510.f512904l, r510.f512905m, r510.f512907o, r510.f512908p, r510.f512909q, r510.f512910r, r510.f512911s, r510.f512914v, r510.f512915w, r510.K, r510.L, r510.M, r510.N, r510.Q, r510.R, r510.S, r510.T, r510.Y, r510.Z, r510.f512888a0, r510.f512894d0, r510.f512896e0);     // Catch: Exception -> L16
    L7:
        long r101 = r100;
        if (r101 > 0) goto L15;
        d1 r102 = (d1) a().c();     // Catch: Exception -> L16
        r102.f513025a.assertNotSuspendingTransaction();     // Catch: Exception -> L16
        r102.f513025a.beginTransaction();     // Catch: Exception -> L16
        long r103 = r102.f513026b.insertAndReturnId(r510);     // Catch: Throwable -> L12
        r102.f513025a.setTransactionSuccessful();     // Catch: Throwable -> L12
        r102.f513025a.endTransaction();     // Catch: Exception -> L16
        return r103;
    L12:
        th = move-exception;
        r102.f513025a.endTransaction();     // Catch: Exception -> L16
        throw th;     // Catch: Exception -> L16
    L15:
        return r101;
    L6:
        r100 = ((d1) a().c()).O(r510.f512887a, r510.f512889b, r510.getType(), r510.f512892c0, r510.f512893d, r510.f512895e, r510.f512897f, r510.f512899g, r510.f512900h, r510.f512901i, r510.f512902j, r510.f512903k, r510.f512904l, r510.f512905m, r510.f512907o, r510.f512908p, r510.f512909q, r510.f512910r, r510.f512911s, r510.f512912t, r510.f512913u, r510.f512914v, r510.f512915w, r510.f512916x, r510.f512917y, r510.f512918z, r510.A, r510.B, r510.C, r510.D, r510.F, r510.H, r510.f512886J, r510.K, r510.L, r510.M, r510.N, r510.Q, r510.R, r510.S, r510.f512906n, r510.T, r510.U, r510.V, r510.W, r510.X, r510.Y, r510.Z, r510.P, r510.f512888a0, r510.f512894d0, r510.f512896e0);     // Catch: Exception -> L16
        goto L7
    }

    @Override // mc5.j
    public final LiveData<List<u1>> J3(String r100) {
        d1 r101 = (d1) a().c();     // Catch: Exception -> L8
        r101.getClass();     // Catch: Exception -> L8
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? AND LT.file_path= ?", 2);     // Catch: Exception -> L8
        r102.bindLong(1, 3);     // Catch: Exception -> L8
        if (r100 != null) goto L5;
        r102.bindNull(2);     // Catch: Exception -> L8
    L6:
        return r101.f513025a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new h1(r101, r102));
    L5:
        r102.bindString(2, r100);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final void L1(String r100) {
        tt5.a.b("UserDatabaseManager", "delete: ret=" + ((d1) a().c()).h(r100));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final List<b3> M7(int r100) {
        return ((j3) a().e()).c(r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final LiveData<List<u1>> N5(boolean r100) {
        mc5.n r101 = a().c();     // Catch: Exception -> L4
        d1 r102 = (d1) r101;     // Catch: Exception -> L4
        return r102.z(12, sbb.e.f541295f.f541317b, r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final mc5.b P9(String r100) {
        return ((d1) a().c()).y(r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return null;
    }

    @Override // mc5.j
    public final LiveData<List<u1>> Rc(String r100) {
        mc5.n r101 = a().c();     // Catch: Exception -> L4
        d1 r102 = (d1) r101;     // Catch: Exception -> L4
        return r102.B(r100, String.valueOf(sbb.e.f541295f.f541317b));
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final List<String> V4(long r100) {
        return ((d1) a().c()).F(r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final void V9(String r100) {
        ((d1) a().c()).W(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final long Ve(so5.a r100) {
        d1 r101 = (d1) a().c();     // Catch: Exception -> L10
        r101.f513025a.assertNotSuspendingTransaction();     // Catch: Exception -> L10
        r101.f513025a.beginTransaction();     // Catch: Exception -> L10
        long r102 = r101.f513031g.insertAndReturnId(r100);     // Catch: Throwable -> L7
        r101.f513025a.setTransactionSuccessful();     // Catch: Throwable -> L7
        r101.f513025a.endTransaction();     // Catch: Exception -> L10
        tt5.a.h("UserDatabaseManager", "insertOrReplaceTtsPlaybackBean()...ret = " + r102);     // Catch: Exception -> L10
        return r102;
    L7:
        th = move-exception;
        r101.f513025a.endTransaction();     // Catch: Exception -> L10
        throw th;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final so5.a Y7(String r100) {
        return ((d1) a().c()).J(r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return null;
    }

    @Override // mc5.j
    public final LiveData<List<u1>> ae(int r100) {
        mc5.n r101 = a().c();     // Catch: Exception -> L4
        d1 r102 = (d1) r101;     // Catch: Exception -> L4
        return r102.z(r100, sbb.e.f541295f.f541317b, false);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    public final long[] b(List<mc5.b> r100) {
        if (r100 == null) goto L5;
        long[] r101 = new long[r100.size()];     // Catch: Exception -> L12
        int r102 = 0;
    L8:
        if (r102 >= r100.size()) goto L11;
        r101[r102] = Ie((mc5.b) ListProtector.get(r100, r102));     // Catch: Exception -> L12
        r102 = r102 + 1;
        goto L8
    L11:
        return r101;
    L12:
        e = move-exception;
        iu5.d.c(e);
        return new long[0];
    L5:
        return new long[0];
    }

    @Override // mc5.j
    public final int c(List<String> r100) {
        tt5.a.h("UserDatabaseManager", "delCachedStatus(List<String> doc_tokens)");
        if (hu5.a.d(r100) == false) goto L10;
        return -1;
    L10:
        return ((d1) a().c()).M(r100, 0);
    L7:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final LiveData<List<u1>> c7(int r100) {
        return new i0(this, r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final int gb(String r100) {
        return ((d1) a().c()).e0(r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final String i(String r100) {
        return ((d1) a().c()).G(r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return null;
    }

    @Override // mc5.j
    public final int l(List<String> r100) {
        tt5.a.h("UserDatabaseManager", "saveCachedStatus(List<String> objTokens)");
        Iterator<String> r101 = r100.iterator();     // Catch: Exception -> L17
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L13;
        String r103 = r101.next();     // Catch: Exception -> L17
        mc5.n r104 = a().c();     // Catch: Exception -> L17
        mc5.a r105 = new mc5.a();     // Catch: Exception -> L17
        r105.f512880a = r103;     // Catch: Exception -> L17
        r105.f512881b = 2;     // Catch: Exception -> L17
        d1 r106 = (d1) r104;     // Catch: Exception -> L17
        mc5.a r107 = r106.I(r103);     // Catch: Exception -> L17
        if (r107 == null) goto L11;
        r105.f512883d = r107.f512883d;     // Catch: Exception -> L17
        r105.f512882c = r107.f512882c;     // Catch: Exception -> L17
        r105.f512884e = r107.f512884e;     // Catch: Exception -> L17
    L11:
        if (r106.s(r105) > 0) goto L4;
        r102 = true;
        goto L4
    L13:
        if (r102 == true) goto L27;
        return 1;
    L27:
        return -1;
    L17:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final FolderSortStrategy m1(String r100) {
        return ((mc5.i) a().d()).b(r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new FolderSortStrategy();
    }

    @Override // mc5.j
    public final void nb(int r100) {
        ((d1) a().c()).g(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int r7(List<String> r100) {
        int r101 = 0;
        if (hu5.a.d(r100) == false) goto L5;
        return 0;
    L5:
        Iterator<String> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Ab(r102.next());
        r101 = r101 + 1;
        goto L7
    L9:
        return r101;
    }

    @Override // mc5.j
    public final b3 rc(String r100) {
        return ((j3) a().e()).d(r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return null;
    }

    @Override // mc5.j
    public final void s1(final List<b3> r100) {
        a().runInTransaction(new y1(this, r100));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int td(String r100) {
        d1 r101 = (d1) a().c();
        r101.getClass();
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT doc_cache_status FROM CacheStatus WHERE obj_token =?", 1);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        r101.f513025a.assertNotSuspendingTransaction();
        int r103 = 0;
        Cursor r104 = DBUtil.query(r101.f513025a, r102, false, null);
    L12:
        th = move-exception;
        r104.close();
        r102.release();
        throw th;
    L8:
        if (r104.moveToFirst() == false) goto L10;
        r103 = r104.getInt(0);     // Catch: Throwable -> L12
    L10:
        r104.close();
        r102.release();
        return r103;
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // mc5.j
    public final void x6(String r100) {
        tt5.a.b("UserDatabaseManager", "delete: ret=" + ((d1) a().c()).d(r100));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int y8(final String r100) {
        a().runInTransaction(new l2(this, r100));     // Catch: Exception -> L4
        return -1;
    L4:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final int z7(String r100) {
        int r101 = ((j3) a().e()).a(r100);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "deleteWikiSpaceByObjToken()...ret = " + r101);     // Catch: Exception -> L5
        return r101;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final LiveData zd(String r100) {
        return new y2(this, r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [mc5.j2] */
    @Inject
    public x2(com.bytedance.ee.util.db.a r410, t45.c r411) {
        this.f513224a = r410;
        this.f513225b = r411;
        Application r100 = eu5.b.a();
        k r101 = new k();
        v r102 = new v();
        g0 r103 = new g0();
        k0 r104 = new k0();
        l0 r105 = new l0();
        m0 r106 = new m0();
        n0 r107 = new n0();
        o0 r110 = new o0();
        p0 r111 = new p0();
        a r112 = new a();
        b r113 = new b();
        c r114 = new c();
        d r115 = new d();
        e r116 = new e();
        f r117 = new f();
        g r118 = new g();
        h r119 = new h();
        i r210 = new i();
        j r211 = new j();
        l r212 = new l();
        m r213 = new m();
        n r214 = new n();
        o r215 = new o();
        p r216 = new p();
        q r217 = new q();
        r r218 = new r();
        s r219 = new s();
        t r310 = new t();
        u r311 = new u();
        w r312 = new w();
        x r313 = new x();
        y r314 = new y();
        z r315 = new z();
        a0 r316 = new a0();
        b0 r317 = new b0();
        c0 r318 = new c0();
        d0 r319 = new d0();
        e0 r412 = new e0();
        f0 r413 = new f0();
        DBController.a r108 = new DBController.a(r100);
        r108.f243099a = "bear.db";
        r108.f243100b = BearDatabase.class;
        r108.f243102d = r101;
        r108.a(new Migration[]{r102});
        r108.a(new Migration[]{new h0()});
        r108.a(new Migration[]{r103});
        r108.a(new Migration[]{r104});
        r108.a(new Migration[]{r105});
        r108.a(new Migration[]{r106});
        r108.a(new Migration[]{r107});
        r108.a(new Migration[]{r110});
        r108.a(new Migration[]{r111});
        r108.a(new Migration[]{r112});
        r108.a(new Migration[]{r113});
        r108.a(new Migration[]{r114});
        r108.a(new Migration[]{r115});
        r108.a(new Migration[]{r116});
        r108.a(new Migration[]{r117});
        r108.a(new Migration[]{r118});
        r108.a(new Migration[]{r119});
        r108.a(new Migration[]{r210});
        r108.a(new Migration[]{r211});
        r108.a(new Migration[]{r212});
        r108.a(new Migration[]{r213});
        r108.a(new Migration[]{r214});
        r108.a(new Migration[]{r215});
        r108.a(new Migration[]{r216});
        r108.a(new Migration[]{r217});
        r108.a(new Migration[]{r218});
        r108.a(new Migration[]{r219});
        r108.a(new Migration[]{r310});
        r108.a(new Migration[]{r311});
        r108.a(new Migration[]{r312});
        r108.a(new Migration[]{r313});
        r108.a(new Migration[]{r314});
        r108.a(new Migration[]{r315});
        r108.a(new Migration[]{r316});
        r108.a(new Migration[]{r317});
        r108.a(new Migration[]{r318});
        r108.a(new Migration[]{r319});
        r108.a(new Migration[]{r412});
        r108.a(new Migration[]{r413});
        r108.a(new Migration[]{new Migration40_41()});
        r108.a(new Migration[]{new Migration41_42()});
        r108.a(new Migration[]{new Migration42_43()});
        r108.a(new Migration[]{new Migration43_44()});
        r108.a(new Migration[]{new Migration44_45()});
        r108.a(new Migration[]{new Migration46_47()});
        r108.a(new Migration[]{new Migration47_48()});
        r108.a(new Migration[]{new Migration48_49()});
        r108.a(new Migration[]{new Migration49_50()});
        r108.a(new Migration[]{new Migration50_51()});
        r108.a(new Migration[]{new Migration51_52()});
        r108.a(new Migration[]{new Migration52_53()});
        r108.a(new Migration[]{new Migration53_54()});
        r108.a(new Migration[]{new Migration54_55()});
        r108.a(new Migration[]{new Migration55_56()});
        r108.a(new Migration[]{new Migration56_57()});
        r108.a(new Migration[]{new Migration57_58()});
        r108.a(new Migration[]{new Migration58_59()});
        r108.a(new Migration[]{new Migration59_60()});
        r108.a(new Migration[]{new Migration60_61()});
        r108.a(new Migration[]{new Migration61_62()});
        r108.a(new Migration[]{new Migration62_63()});
        r108.a(new Migration[]{new Migration63_64()});
        r108.a(new Migration[]{new Migration64_65()});
        r108.a(new Migration[]{new Migration65_66()});
        r108.a(new Migration[]{new Migration66To67()});
        r108.a(new Migration[]{new Migration67To68()});
        r108.a(new Migration[]{new Migration68To69()});
        r108.a(new Migration[]{new Migration69To70()});
        r108.a(new Migration[]{new Migration70To71()});
        r108.a(new Migration[]{new Migration71To72()});
        r108.a(new Migration[]{new Migration72To73(new j2(this))});
        r108.a(new Migration[]{new Migration73To74()});
        r108.a(new Migration[]{new Migration74To75()});
        r108.a(new Migration[]{new Migration75To76()});
        r108.a(new Migration[]{new Migration76To77()});
        r410.W3("bear.db", r108);
        long r109 = FileUtils.y(r100.getDatabasePath(r410.Aa(r100, "bear.db")).getAbsolutePath()) / 1024;
        tt5.a.h("UserDatabaseManager", " checkAndReduceDb   dbSize = " + r109);
        if (r109 <= 1048576) goto L6;
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new z1(this), new a2());
        return;
    }

    @Override // mc5.j
    public final void D8(String r100, String r101) {
        tt5.a.h("UserDatabaseManager", "updateDocSize()...ret = " + ((d1) a().c()).S(r100, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void E5(String r100, boolean r101) {
        tt5.a.h("UserDatabaseManager", "updateDocPined()...ret = " + ((d1) a().c()).Q(r100, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void K1(String r100, String r101) {
        tt5.a.h("UserDatabaseManager", "updateWikiSpaceTitle()...ret = " + ((j3) a().e()).g(r100, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int L6(String r100, String r101) {
        int r102 = -1;
        r102 = ((d1) a().c()).h0(r100, r101);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateWikiTokenAndExtra: ret=" + r102);     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r102;
    }

    @Override // mc5.j
    public final void O4(String r100, boolean r101) {
        tt5.a.h("UserDatabaseManager", "updateDocStar()...ret = " + ((d1) a().c()).T(r100, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final List<mc5.d> R9(int r100, FolderSortStrategy r110) {
        if (r110 == null) goto L4;
        mc5.n r101 = a().c();     // Catch: Exception -> L7
        d1 r102 = (d1) r101;     // Catch: Exception -> L7
        return r102.o(r100, r110.getType(), r110.f227682c, r110.f227684e, r110.f227685f, r110.f227680a);
    L4:
        return new ArrayList();
    L7:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final void S1(String r100, int r101) {
        tt5.a.h("UserDatabaseManager", "updateOwnerType()...ret = " + ((d1) a().c()).Z(r100, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int We(final int r100, List<String> r101) {
        int r102 = ju5.c.a(r101, new o2(this, r100), a());
        tt5.a.h("UserDatabaseManager", "deleteRecentDocNotInObjTokenList: ret=" + r102);
        return r102;
    }

    @Override // mc5.j
    public final int Y8(String r100, String r101) {
        int r102 = 0;
        d1 r103 = (d1) a().c();     // Catch: Exception -> L10
        if (hu5.a.d(r103.w(r101)) == false) goto L7;
        int r104 = r103.N(r100, r101);     // Catch: Exception -> L10
    L6:
        r102 = r104;
        tt5.a.h("UserDatabaseManager", "updateCacheStatusObjToken: ret=" + r102);     // Catch: Exception -> L10
    L12:
        return r102;
    L7:
        r103.a(r100);     // Catch: Exception -> L10
        ArrayList r105 = new ArrayList();     // Catch: Exception -> L10
        r105.add(r101);     // Catch: Exception -> L10
        r104 = r103.M(r105, 2);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        iu5.d.c(e);
        goto L12
    }

    @Override // mc5.j
    public final void Z6(String r100, String r101) {
        tt5.a.h("UserDatabaseManager", "updateTitle: ret=" + ((d1) a().c()).c0(r100, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int a2(int r100, String r101) {
        int r102 = -1;
        r102 = ((d1) a().c()).b(r100, r101);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "deleteListDocRecordByObjToken()...ret = " + r102);     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r102;
    }

    @Override // mc5.j
    public final long a3(final mc5.b r100, final v1 r101) {
        return ((Integer) a().runInTransaction(new k2(this, r100, r101))).intValue();
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final void db(String r100, String r101) {
        tt5.a.b("UserDatabaseManager", "updateListTypes: ret=" + ((d1) a().c()).V(r100, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int j7(int r100, List<String> r101) {
        int r102 = 0;
        r102 = ((d1) a().c()).c(r100, r101);     // Catch: Exception -> L5
        tt5.a.b("UserDatabaseManager", "delete: ret=" + r102);     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r102;
    }

    @Override // mc5.j
    public final void k(final String r100, final int r101) {
        tt5.a.h("UserDatabaseManager", "setCacheDownloadStatus token: ");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Flowable.just(r100).observeOn(fo5.d.b()).subscribe(new c2(this, r100, r101), new d2());
    }

    @Override // mc5.j
    public final int oe(String r100, boolean r101) {
        int r102 = ((j3) a().e()).e(r100, r101);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateWikiSpaceStar()...ret = " + r102);     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final long p6(final mc5.b r100, final v1 r101) {
        return ((Integer) a().runInTransaction(new p2(this, r100, r101))).intValue();
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final int q2(String r100, boolean r101) {
        int r102 = ((j3) a().e()).f(r100, r101);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateWikiSpaceStar()...ret = " + r102);     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final void q9(String r100, boolean r101) {
        tt5.a.h("UserDatabaseManager", "updateDocSubscribed()...ret = " + ((d1) a().c()).U(r100, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void s4(String r100, String r101) {
        tt5.a.h("UserDatabaseManager", "updateWikiTitleByObjToken()...ret = " + ((d1) a().c()).g0(r100, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void s6(String r100, String r101) {
        tt5.a.h("UserDatabaseManager", "updateShortcutTitle: ret=" + ((d1) a().c()).b0(r100, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void t5(final String r100, final int r101) {
        tt5.a.h("UserDatabaseManager", "saveDocCachedStatus token: ");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Flowable.just(r100).observeOn(fo5.d.b()).subscribe(new m2(this, r100, r101), new n2());
    }

    @Override // mc5.j
    public final void v4(final List<mc5.b> r100, final List<v1> r101) {
        a().runInTransaction(new r2(this, r100, r101));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final u1 z3(int r100, String r101) {
        return ((d1) a().c()).x(r101, r100);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new u1();
    }

    @Override // mc5.j
    public final void G4(String r100, String r101, int r102) {
        tt5.a.h("UserDatabaseManager", "updateDocSecurity()...ret = " + ((d1) a().c()).R(r100, r101, r102));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int Kd(String r100, String r101, String r102) {
        int r103 = -1;
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L5
        r104.add(1);     // Catch: Exception -> L5
        r104.add(5);     // Catch: Exception -> L5
        r104.add(6);     // Catch: Exception -> L5
        r103 = ((d1) a().c()).Y(r100, r101, r102, r104);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateObjTokenAndToken: ret=" + r103 + " ret2 is " + ((d1) a().c()).X(r100, r101, r104));     // Catch: Exception -> L5
        return r103;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r103;
    }

    @Override // mc5.j
    public final int Y4(String r100, String r101, String r102) {
        int r103 = 0;
        r103 = ((d1) a().c()).P(r100, r101, r102);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateRecentDoc: ret=" + r103);     // Catch: Exception -> L5
        return r103;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r103;
    }

    @Override // mc5.j
    public final void da(final String r100, final int r101, final int r102) {
        tt5.a.h("UserDatabaseManager", "saveStatusManualoffline objToken: " + du5.b.i(r100) + "   type: " + r101 + "   statusManualoffline: " + r102);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Flowable.just(r100).observeOn(fo5.d.b()).subscribe(new h2(this, r100, r101, r102), new i2());
    }

    @Override // mc5.j
    public final void dc(final int r100, final List<mc5.b> r101, final List<v1> r102) {
        a().runInTransaction(new q2(this, r100, r101, r102));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void w5(final List<mc5.b> r100, final List<v1> r101, final boolean r102) {
        a().runInTransaction(new g2(this, r102, r100, r101));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void x9(final List<mc5.b> r100, final List<v1> r101, final int r102) {
        a().runInTransaction(new b2(this, r102, r100, r101));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void R1(final List r100, final List r110, final List r111, final FolderSortStrategy r112) {
        a().runInTransaction(new v2(this, r100, r110, r112, r111));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int Yc(String r100, String r101, String r102, String r103) {
        ((d1) a().c()).d0(r100, r101, r103, r102);     // Catch: Exception -> L4
        tt5.a.h("UserDatabaseManager", "updateDocTitleAndEditTime()...ret = 0");     // Catch: Exception -> L4
        return 0;
    L4:
        e = move-exception;
        iu5.d.c(e);
        return 0;
    }

    @Override // mc5.j
    public final void b9(final int r100, final String r110, final List<mc5.b> r111, final List<v1> r112) {
        a().runInTransaction(new s2(this, r100, r110, r111, r112));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void A3(final List<mc5.b> r110, final List<v1> r111, final List<mc5.c> r112, final int r113, final FolderSortStrategy r114) {
        a().runInTransaction(new f2(this, r113, r110, r111, r114, r112));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void p8(final List<mc5.b> r110, final List<v1> r111, final List<mc5.c> r112, final int r113, final FolderSortStrategy r114) {
        a().runInTransaction(new w2(this, r113, r110, r111, r114, r112));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int ya(String r110, String r111, String r112, String r113, String r114, int r115, String r116) {
        int r100 = 0;
        r100 = ((d1) a().c()).f0(r110, r111, r112, r113, r114, r115, r116);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateWikiDocMetaObj: ret=" + r100);     // Catch: Exception -> L5
        return r100;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r100;
    }
}
