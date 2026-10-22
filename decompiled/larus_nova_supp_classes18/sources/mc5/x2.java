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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@UserScope
public final class x2 implements mc5.j {
    public final com.bytedance.ee.util.db.a a;
    public final t45.c b;

    public class a extends Migration {
        public a() {
            super(10, 11);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN share_time TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN open_time TEXT");
        }
    }

    public class a0 extends Migration {
        public a0() {
            super(34, 35);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_visited INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_hidden INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class b extends Migration {
        public b() {
            super(11, 12);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE OfflineOperateDoc ADD COLUMN offline_create INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class b0 extends Migration {
        public b0() {
            super(35, 36);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN thumbnail_url TEXT");
            r2.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN thumbnail_secret TEXT");
            r2.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN thumbnail_nonce TEXT");
            r2.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE MineDoc ADD COLUMN thumbnail_url TEXT");
            r2.execSQL("ALTER TABLE MineDoc ADD COLUMN thumbnail_secret TEXT");
            r2.execSQL("ALTER TABLE MineDoc ADD COLUMN thumbnail_nonce TEXT");
            r2.execSQL("ALTER TABLE MineDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN thumbnail_url TEXT");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN thumbnail_secret TEXT");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN thumbnail_nonce TEXT");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN thumbnail_url TEXT");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN thumbnail_secret TEXT");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN thumbnail_nonce TEXT");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN thumbnail_url TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN thumbnail_secret TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN thumbnail_nonce TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN thumbnail_url TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN thumbnail_secret TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN thumbnail_nonce TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN thumbnail_url TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN thumbnail_secret TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN thumbnail_nonce TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN thumbnail_type INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class c extends Migration {
        public c() {
            super(12, 13);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN filepath TEXT");
        }
    }

    public class c0 extends Migration {
        public c0() {
            super(36, 37);
        }

        public final void migrate(SupportSQLiteDatabase r4) {
            r4.execSQL("CREATE TABLE IF NOT EXISTS `ManualOfflineDocNew` (`obj_token` TEXT NOT NULL, `userid` TEXT, `name` TEXT, `size` TEXT, `type` INTEGER NOT NULL DEFAULT 2, `subType` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL DEFAULT 0, `is_external` INTEGER NOT NULL DEFAULT 0, `url` TEXT, `add_time` TEXT, `edit_time` TEXT, `copiable` INTEGER NOT NULL DEFAULT 0, `is_info_complete` INTEGER NOT NULL DEFAULT 0, `owner_id` TEXT, `create_tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `open_time` TEXT, `create_time` TEXT, `fake_token` TEXT, `is_star` INTEGER NOT NULL DEFAULT 0, `is_top` INTEGER NOT NULL DEFAULT 0, `extra` TEXT, `thumbnail` TEXT, `thumbnail_url` TEXT, `thumbnail_secret` TEXT, `thumbnail_nonce` TEXT, `thumbnail_type` INTEGER NOT NULL DEFAULT 0, `is_backend_save` INTEGER NOT NULL DEFAULT 0, `is_need_wifi_download` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`obj_token`))");     // Catch: Exception -> L5
            r4.execSQL("insert into ManualOfflineDocNew select * from ManualOfflineDoc");     // Catch: Exception -> L5
            r4.execSQL("drop table ManualOfflineDoc");     // Catch: Exception -> L5
            r4.execSQL("alter table ManualOfflineDocNew rename to ManualOfflineDoc");     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            iu5.d.a("UserDatabaseManager", e);
            r4.execSQL("drop table ManualOfflineDoc");
            r4.execSQL("CREATE TABLE IF NOT EXISTS `ManualOfflineDoc` (`obj_token` TEXT NOT NULL, `userid` TEXT, `name` TEXT, `size` TEXT, `type` INTEGER NOT NULL DEFAULT 2, `subType` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL DEFAULT 0, `is_external` INTEGER NOT NULL DEFAULT 0, `url` TEXT, `add_time` TEXT, `edit_time` TEXT, `copiable` INTEGER NOT NULL DEFAULT 0, `is_info_complete` INTEGER NOT NULL DEFAULT 0, `owner_id` TEXT, `create_tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `open_time` TEXT, `create_time` TEXT, `fake_token` TEXT, `is_star` INTEGER NOT NULL DEFAULT 0, `is_top` INTEGER NOT NULL DEFAULT 0, `extra` TEXT, `thumbnail` TEXT, `thumbnail_url` TEXT, `thumbnail_secret` TEXT, `thumbnail_nonce` TEXT, `thumbnail_type` INTEGER NOT NULL DEFAULT 0, `is_backend_save` INTEGER NOT NULL DEFAULT 0, `is_need_wifi_download` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`obj_token`))");
        }
    }

    public class d extends Migration {
        public d() {
            super(13, 14);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN url TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN url TEXT");
        }
    }

    public class d0 extends Migration {
        public d0() {
            super(37, 38);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN document_icon_key TEXT");
            r2.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r2.execSQL("ALTER TABLE ManualOfflineDoc ADD COLUMN document_icon_fsunit TEXT");
            r2.execSQL("ALTER TABLE MineDoc ADD COLUMN document_icon_key TEXT");
            r2.execSQL("ALTER TABLE MineDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r2.execSQL("ALTER TABLE MineDoc ADD COLUMN document_icon_fsunit TEXT");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN document_icon_key TEXT");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN document_icon_fsunit TEXT");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN document_icon_key TEXT");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN document_icon_fsunit TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN document_icon_key TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN document_icon_fsunit TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN document_icon_key TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN document_icon_fsunit TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN document_icon_key TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN document_icon_type INTEGER NOT NULL DEFAULT -1");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN document_icon_fsunit TEXT");
        }
    }

    public class e extends Migration {
        public e() {
            super(14, 15);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN offline_create INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class e0 extends Migration {
        public e0() {
            super(38, 39);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN create_time TEXT");
        }
    }

    public class f extends Migration {
        public f() {
            super(15, 16);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN subtype TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN subtype TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN subtype TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN subtype TEXT");
            r2.execSQL("ALTER TABLE OfflineOperateDoc ADD COLUMN subtype TEXT");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN subtype TEXT");
        }
    }

    public class f0 extends Migration {
        public f0() {
            super(39, 40);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE MineDoc ADD COLUMN is_external INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class g extends Migration {
        public g() {
            super(16, 17);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `FolderSortStrategy` (`obj_token` TEXT PRIMARY KEY NOT NULL, `strategy` INTEGER NOT NULL, `update_time` TEXT)");
            r2.execSQL("ALTER TABLE OfflineOperateDoc ADD COLUMN create_time TEXT");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN create_time TEXT");
        }
    }

    public class g0 extends Migration {
        public g0() {
            super(3, 4);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("update PersonalDoc set filepath='' where filepath='/'");
            r2.execSQL("update RecentDoc set filepath='' where filepath='/'");
            r2.execSQL("update ShareDoc set filepath='' where filepath='/'");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `OfflineOperateDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fakeToken` TEXT, `groups` INTEGER NOT NULL, `operator` INTEGER NOT NULL, `userid` TEXT, `needSync` INTEGER NOT NULL, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT)");
        }
    }

    public class h extends Migration {
        public h() {
            super(17, 18);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN extra TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN extra TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN extra TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN extra TEXT");
            r2.execSQL("ALTER TABLE OfflineOperateDoc ADD COLUMN extra TEXT");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN extra TEXT");
        }
    }

    public class h0 extends Migration {
        public h0() {
            super(2, 3);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DROP TABLE IF EXISTS `PersonalDoc`");
            r2.execSQL("DROP TABLE IF EXISTS `RecentDoc`");
            r2.execSQL("DROP TABLE IF EXISTS `ShareDoc`");
            r2.execSQL("DROP TABLE IF EXISTS `TrashDoc`");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `PersonalDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `RecentDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `ShareDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `TrashDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `expire_time` TEXT, `obj_token` TEXT, `url` TEXT)");
        }
    }

    public class i extends Migration {
        public i() {
            super(18, 19);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `OfflineOperateDoc_New` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fakeToken` TEXT, `groups` INTEGER NOT NULL, `operator` INTEGER NOT NULL, `userid` TEXT, `needSync` INTEGER NOT NULL, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT, `create_time` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `subtype` TEXT, `offline_create` INTEGER NOT NULL DEFAULT 0, `extra` TEXT)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `PersonalDoc_New` (`token` TEXT PRIMARY KEY NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT, `create_time` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, `space_id` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0, `is_star` INTEGER NOT NULL DEFAULT 0, `is_pine` INTEGER NOT NULL DEFAULT 0, `subtype` TEXT, `extra` TEXT)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `RecentDoc_New` (`obj_token` TEXT PRIMARY KEY NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, `is_external` INTEGER NOT NULL DEFAULT 0, `is_star` INTEGER NOT NULL DEFAULT 0, `is_pine` INTEGER NOT NULL DEFAULT 0, `open_time` TEXT, `subtype` TEXT, `offline_create` INTEGER NOT NULL DEFAULT 0, `extra` TEXT)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `ShareDoc_New` (`token` TEXT PRIMARY KEY NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, `space_id` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0, `is_star` INTEGER NOT NULL DEFAULT 0, `is_pine` INTEGER NOT NULL DEFAULT 0, `share_time` TEXT, `subtype` TEXT, `extra` TEXT)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `TrashDoc_New` (`token` TEXT PRIMARY KEY NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `expire_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, `space_id` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0)");
            r2.execSQL("INSERT INTO OfflineOperateDoc_New(id, fakeToken, groups, operator, userid, needSync, filepath, name, token, type, owner_id, create_time, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, subtype, offline_create, extra) SELECT id, fakeToken, groups, operator, userid, needSync, filepath, name, token, type, create_uid, create_time, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, subtype, offline_create, extra FROM OfflineOperateDoc");
            r2.execSQL("INSERT INTO PersonalDoc_New(token, userid, filepath, name, type, owner_id, create_time, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, fake_token, needSync, space_id, is_external, is_star, is_pine, subtype, extra) SELECT token, userid, filepath, name, type, create_uid, create_time, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, fake_token, needSync, space_id, is_external, is_star, is_pine, subtype, extra FROM PersonalDoc");
            r2.execSQL("INSERT INTO RecentDoc_New(obj_token, userid, filepath, name, type, owner_id, creator_cn_name, creator_en_name, edit_uid, edit_time, url, fake_token, needSync, is_external, is_star, is_pine, open_time, subtype, offline_create, extra) SELECT obj_token, userid, filepath, name, type, create_uid, creator_cn_name, creator_en_name, edit_uid, edit_time, url, fake_token, needSync, is_external, is_star, is_pine, open_time, subtype, offline_create, extra FROM RecentDoc");
            r2.execSQL("INSERT INTO ShareDoc_New(token, userid, filepath, name, type, owner_id, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, fake_token, needSync, space_id, is_external, is_star, is_pine, share_time, subtype, extra) SELECT token, userid, filepath, name, type, create_uid, creator_cn_name, creator_en_name, edit_uid, edit_time, obj_token, url, fake_token, needSync, space_id, is_external, is_star, is_pine, share_time, subtype, extra FROM ShareDoc");
            r2.execSQL("INSERT INTO TrashDoc_New(token, userid, filepath, name, type, owner_id, creator_cn_name, creator_en_name, edit_uid, edit_time, expire_time, obj_token, url, fake_token, needSync, space_id, is_external) SELECT token, userid, filepath, name, type, create_uid, creator_cn_name, creator_en_name, edit_uid, edit_time, expire_time, obj_token, url, fake_token, needSync, space_id, is_external FROM TrashDoc");
            r2.execSQL("DROP TABLE IF EXISTS 'OfflineOperateDoc'");
            r2.execSQL("DROP TABLE IF EXISTS 'PersonalDoc'");
            r2.execSQL("DROP TABLE IF EXISTS 'RecentDoc'");
            r2.execSQL("DROP TABLE IF EXISTS 'ShareDoc'");
            r2.execSQL("DROP TABLE IF EXISTS 'TrashDoc'");
            r2.execSQL("ALTER TABLE OfflineOperateDoc_New RENAME TO OfflineOperateDoc");
            r2.execSQL("ALTER TABLE PersonalDoc_New RENAME TO PersonalDoc");
            r2.execSQL("ALTER TABLE RecentDoc_New RENAME TO RecentDoc");
            r2.execSQL("ALTER TABLE ShareDoc_New RENAME TO ShareDoc");
            r2.execSQL("ALTER TABLE TrashDoc_New RENAME TO TrashDoc");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN tenant_id TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN owner_id TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN create_tenant_id TEXT");
        }
    }

    public class i0 extends WorkerLiveData<List<u1>> {
        public final /* synthetic */ int b;
        public final /* synthetic */ x2 c;

        public final LiveData<List<u1>> a() {
            mc5.n r0 = this.c.a().c();
            d1 r1 = (d1) r0;
            return r1.n(this.b);
        }

        public i0(x2 r1, int r2) {
            this.c = r1;
            this.b = r2;
        }
    }

    public class j extends Migration {
        public j() {
            super(19, 20);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN icon_url TEXT");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN icon_key TEXT");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN icon_nonce TEXT");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN icon_encrypted_type INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN icon_url TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN icon_key TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN icon_nonce TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN icon_encrypted_type INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN icon_url TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN icon_key TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN icon_nonce TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN icon_encrypted_type INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN icon_url TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN icon_key TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN icon_nonce TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN icon_encrypted_type INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class j0 extends WorkerLiveData<List<u1>> {
        public final /* synthetic */ x2 b;

        public final LiveData<List<u1>> a() {
            mc5.n r0 = this.b.a().c();
            int r1 = sbb.e.f.b;
            d1 r2 = (d1) r0;
            r2.getClass();
            RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? AND DMI.type != ?", 2);
            r3.bindLong(1, 4);
            r3.bindLong(2, r1);
            return r2.a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new n1(r2, r3));
        }

        public j0(x2 r1) {
            this.b = r1;
        }
    }

    public class k extends RoomDatabase.Callback {
        public k() {
        }

        public final void onCreate(SupportSQLiteDatabase r2) {
            super.onCreate(r2);
            tt5.a.b("UserDatabaseManager", "onCreate: ");
        }

        public final void onOpen(SupportSQLiteDatabase r2) {
            super.onOpen(r2);
            tt5.a.b("UserDatabaseManager", "onOpen: ");
        }
    }

    public class k0 extends Migration {
        public k0() {
            super(4, 5);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DROP TABLE IF EXISTS `PersonalDoc`");
            r2.execSQL("DROP TABLE IF EXISTS `RecentDoc`");
            r2.execSQL("DROP TABLE IF EXISTS `ShareDoc`");
            r2.execSQL("DROP TABLE IF EXISTS `TrashDoc`");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `PersonalDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, PRIMARY KEY(`token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `RecentDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, PRIMARY KEY(`token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `ShareDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, PRIMARY KEY(`token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `TrashDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `expire_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, PRIMARY KEY(`token`))");
        }
    }

    public class l extends Migration {
        public l() {
            super(20, 21);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN is_share_root INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_share_root INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN is_share_root INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class l0 extends Migration {
        public l0() {
            super(5, 6);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN space_id TEXT");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN link_token TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN space_id TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN link_token TEXT");
            r2.execSQL("ALTER TABLE TrashDoc ADD COLUMN space_id TEXT");
            r2.execSQL("ALTER TABLE TrashDoc ADD COLUMN link_token TEXT");
        }
    }

    public class m extends Migration {
        public m() {
            super(21, 22);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `RecentPull` (`time_range` TEXT NOT NULL PRIMARY KEY, `smaller_time` TEXT, `bigger_time` TEXT, `last_label` TEXT, `uid` TEXT)");
        }
    }

    public class m0 extends Migration {
        public m0() {
            super(6, 7);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DROP TABLE IF EXISTS `RecentDoc`");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `RecentDoc` (`userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `create_uid` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT NOT NULL, `url` TEXT, `fake_token` TEXT, `needSync` INTEGER NOT NULL, PRIMARY KEY(`obj_token`))");
        }
    }

    public class n extends Migration {
        public n() {
            super(22, 23);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `MineDoc` (`obj_token` TEXT PRIMARY KEY NOT NULL,`user_id` TEXT,`owner_id` TEXT,`filepath` TEXT,`name` TEXT,`type` INTEGER NOT NULL DEFAULT 2,`create_tenant_id` TEXT,`create_time` TEXT,`creator_cn_name` TEXT,`creator_en_name` TEXT,`edit_uid` TEXT,`edit_time` TEXT,`url` TEXT,`thumbnail` TEXT,`fake_token` TEXT,`needSync` INTEGER NOT NULL DEFAULT 0,`is_stared` INTEGER NOT NULL DEFAULT 0,`subtype` TEXT,`parent` TEXT,`extra` TEXT,`icon` TEXT,`icon_key` TEXT,`icon_nonce` TEXT,`icon_encrypted_type` INTEGER NOT NULL DEFAULT 0)");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN thumbnail TEXT");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN thumbnail TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN thumbnail TEXT");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN thumbnail TEXT");
            r2.execSQL("ALTER TABLE FolderSortStrategy ADD COLUMN type INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE FolderSortStrategy ADD COLUMN file_type TEXT");
            r2.execSQL("ALTER TABLE FolderSortStrategy ADD COLUMN forbidden_file_type TEXT");
            r2.execSQL("ALTER TABLE FolderSortStrategy ADD COLUMN is_asc INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("UPDATE FolderSortStrategy SET strategy = 5, is_asc = 1 WHERE strategy = 1");
            r2.execSQL("UPDATE FolderSortStrategy SET strategy = 5, is_asc = 0 WHERE strategy = 2");
            r2.execSQL("UPDATE FolderSortStrategy SET strategy = 4, is_asc = 1 WHERE strategy = 3");
            r2.execSQL("UPDATE FolderSortStrategy SET strategy = 4, is_asc = 0 WHERE strategy = 4");
            r2.execSQL("UPDATE FolderSortStrategy SET strategy = 3, is_asc = 1 WHERE strategy = 5");
            r2.execSQL("UPDATE FolderSortStrategy SET strategy = 3, is_asc = 0 WHERE strategy = 6");
            r2.execSQL("UPDATE FolderSortStrategy SET strategy = 0, is_asc = 1 WHERE strategy = 7");
            r2.execSQL("UPDATE FolderSortStrategy SET strategy = 0, is_asc = 0 WHERE strategy = 8");
        }
    }

    public class n0 extends Migration {
        public n0() {
            super(7, 8);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `StatusDoc` (`doc_token` TEXT NOT NULL, `doc_type` INTEGER NOT NULL, `doc_sync_status` INTEGER NOT NULL, `doc_cache_status` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, PRIMARY KEY(`doc_token`,`doc_type`))");
            r2.execSQL("CREATE INDEX IF NOT EXISTS index_doc_token ON StatusDoc(`doc_token`)");
        }
    }

    public class o extends Migration {
        public o() {
            super(23, 24);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN is_top INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class o0 extends Migration {
        public o0() {
            super(8, 9);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN is_external INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_external INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN is_external INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE TrashDoc ADD COLUMN is_external INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class p extends Migration {
        public p() {
            super(24, 25);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DELETE FROM RecentDoc");
        }
    }

    public class p0 extends Migration {
        public p0() {
            super(9, 10);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `PinedDoc` (`uuid` TEXT NOT NULL PRIMARY KEY, `userid` TEXT, `token` TEXT, `name` TEXT, `type` TEXT, `pin_time` TEXT, `is_pined` INTEGER NOT NULL DEFAULT 0, `edit_uid` TEXT, `edit_time` TEXT, `owner_id` TEXT, `space_id` TEXT, `share_root` INTEGER NOT NULL DEFAULT 0, `is_stared` INTEGER NOT NULL DEFAULT 0, `imgUrl` TEXT, `imgTypes` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `StarDoc` (`uuid` TEXT NOT NULL PRIMARY KEY, `token` TEXT, `userid` TEXT, `name` TEXT, `type` INTEGER NOT NULL DEFAULT 0, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `space_id` TEXT, `star_time` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0)");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN is_star INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN is_pine  INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_star INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN is_pine  INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN is_star INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN is_pine  INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class q extends Migration {
        public q() {
            super(25, 26);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE MineDoc ADD COLUMN offline_create INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class r extends Migration {
        public r() {
            super(26, 27);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DELETE FROM RecentDoc");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN create_time TEXT");
            r2.execSQL("DELETE FROM RecentPull");
        }
    }

    public class s extends Migration {
        public s() {
            super(27, 28);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DELETE FROM RecentDoc");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN my_edit_time TEXT");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN activity_time TEXT");
            r2.execSQL("ALTER TABLE FolderSortStrategy ADD COLUMN user_id TEXT");
            r2.execSQL("DELETE FROM RecentPull");
        }
    }

    public class t extends Migration {
        public t() {
            super(28, 29);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DROP TABLE IF EXISTS `PinedDoc`");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `PinedDoc` (`obj_token` TEXT NOT NULL PRIMARY KEY, `user_id` TEXT, `name` TEXT, `type` INTEGER NOT NULL DEFAULT 2, `pin_time` TEXT, `is_pined` INTEGER NOT NULL DEFAULT 0, `edit_uid` TEXT, `edit_time` TEXT, `owner_id` TEXT, `creator_en_name` TEXT, `creator_cn_name` TEXT, `create_time` TEXT, `tenant_id` TEXT, `space_id` TEXT, `share_root` INTEGER NOT NULL DEFAULT 0, `is_stared` INTEGER NOT NULL DEFAULT 0, `thumbnail` TEXT, `url` TEXT, `subtype` TEXT, `extra` TEXT, `is_external` INTEGER NOT NULL DEFAULT 0)");
        }
    }

    public class u extends Migration {
        public u() {
            super(29, 30);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DELETE FROM RecentDoc");
            r2.execSQL("ALTER TABLE MineDoc ADD COLUMN is_pin INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE MineDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE RecentDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN copiable INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class v extends Migration {
        public v() {
            super(1, 2);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `TrashDoc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `token` TEXT, `type` TEXT, `create_uid` TEXT, `creator_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `expire_time` TEXT, `obj_token` TEXT, `url` TEXT)");
        }
    }

    public class w extends Migration {
        public w() {
            super(30, 31);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DROP TABLE IF EXISTS `RecentDoc`");
            r2.execSQL("DROP TABLE IF EXISTS `MineDoc`");
            r2.execSQL("DROP TABLE IF EXISTS `PersonalDoc`");
            r2.execSQL("DROP TABLE IF EXISTS `ShareDoc`");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `PersonalDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT, `create_time` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `space_id` TEXT, `is_share_root` INTEGER NOT NULL, `is_external` INTEGER NOT NULL, `is_star` INTEGER NOT NULL, `is_pine` INTEGER NOT NULL, `subtype` TEXT, `extra` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL, `thumbnail` TEXT, `copiable` INTEGER NOT NULL, PRIMARY KEY(`token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `RecentDoc` (`obj_token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `url` TEXT, `fake_token` TEXT, `is_external` INTEGER NOT NULL, `is_star` INTEGER NOT NULL, `is_pine` INTEGER NOT NULL, `open_time` TEXT, `subtype` TEXT, `extra` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL, `thumbnail` TEXT, `create_time` TEXT, `my_edit_time` TEXT, `activity_time` TEXT, `copiable` INTEGER NOT NULL, PRIMARY KEY(`obj_token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `ShareDoc` (`token` TEXT NOT NULL, `userid` TEXT, `filepath` TEXT, `name` TEXT, `type` TEXT, `owner_id` TEXT, `tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `obj_token` TEXT, `url` TEXT, `fake_token` TEXT, `space_id` TEXT, `is_share_root` INTEGER NOT NULL, `is_external` INTEGER NOT NULL, `is_star` INTEGER NOT NULL, `is_pine` INTEGER NOT NULL, `share_time` TEXT, `subtype` TEXT, `extra` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL, `thumbnail` TEXT, `copiable` INTEGER NOT NULL, PRIMARY KEY(`token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `MineDoc` (`obj_token` TEXT NOT NULL, `user_id` TEXT, `owner_id` TEXT, `filepath` TEXT, `name` TEXT, `type` INTEGER NOT NULL, `create_tenant_id` TEXT, `create_time` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `url` TEXT, `thumbnail` TEXT, `fake_token` TEXT, `is_stared` INTEGER NOT NULL, `is_pin` INTEGER NOT NULL, `subtype` TEXT, `parent` TEXT, `extra` TEXT, `icon` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL, `copiable` INTEGER NOT NULL, PRIMARY KEY(`obj_token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `ManualOfflineDoc` (`obj_token` TEXT NOT NULL, `userid` TEXT NOT NULL, `name` TEXT, `size` TEXT, `type` INTEGER NOT NULL DEFAULT 2, `subType` TEXT, `icon_url` TEXT, `icon_key` TEXT, `icon_nonce` TEXT, `icon_encrypted_type` INTEGER NOT NULL DEFAULT 0, `is_external` INTEGER NOT NULL DEFAULT 0, `url` TEXT, `add_time` TEXT, `edit_time` TEXT, `copiable` INTEGER NOT NULL DEFAULT 0, `is_info_complete` INTEGER NOT NULL DEFAULT 0, `owner_id` TEXT, `create_tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `open_time` TEXT, `create_time` TEXT, `fake_token` TEXT, `is_star` INTEGER NOT NULL DEFAULT 0, `is_top` INTEGER NOT NULL DEFAULT 0, `extra` TEXT, `thumbnail` TEXT, `is_backend_save` INTEGER NOT NULL DEFAULT 0, `is_need_wifi_download` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`obj_token`,`userid`))");
        }
    }

    public class x extends Migration {
        public x() {
            super(31, 32);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN share_version INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE ShareDoc ADD COLUMN permission INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN share_version INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE PersonalDoc ADD COLUMN permission INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN share_version INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE StarDoc ADD COLUMN permission INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN share_version INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE PinedDoc ADD COLUMN permission INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class y extends Migration {
        public y() {
            super(32, 33);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DROP TABLE IF EXISTS `RecentWiki`");
            r2.execSQL("DROP TABLE IF EXISTS `WikiSpace`");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `RecentWiki` (`wiki_id` TEXT NOT NULL PRIMARY KEY, `userid` TEXT, `wiki_token` TEXT, `space_id` TEXT, `open_time` TEXT,`open_count` TEXT,`title` TEXT,`owner_id` TEXT,`creator_cn_name` TEXT,`creator_en_name` TEXT,`edit_uid` TEXT,`edit_time` TEXT,`url` TEXT,`obj_type` INTEGER NOT NULL DEFAULT 0, `obj_token` TEXT)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `WikiSpace` (`space_id` TEXT NOT NULL PRIMARY KEY, `user_id` TEXT, `space_name` TEXT, `space_icon` TEXT, `attr` INTEGER NOT NULL DEFAULT 0, `description` TEXT,`is_star` INTEGER NOT NULL DEFAULT 0, `browse_time` TEXT,`wiki_token` TEXT,`obj_type` INTEGER NOT NULL DEFAULT 0, `obj_token` TEXT)");
        }
    }

    public class z extends Migration {
        public z() {
            super(33, 34);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE WikiSpace ADD COLUMN origin TEXT");
            r2.execSQL("ALTER TABLE WikiSpace ADD COLUMN thumbnail TEXT");
            r2.execSQL("ALTER TABLE WikiSpace ADD COLUMN cover_key TEXT");
            r2.execSQL("ALTER TABLE WikiSpace ADD COLUMN is_graph_dark INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE WikiSpace ADD COLUMN color_value TEXT");
        }
    }

    public final synchronized BearDatabase a() {
        monitor-enter(this);
        BearDatabase r0 = (BearDatabase) this.a.r1("bear.db");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // mc5.j
    public final LiveData Fb() {
        long r1 = System.currentTimeMillis();
        tt5.a.h("UserDatabaseManager", "loadRecentDocsLimitLiveData()...start, listType = 1, limit = 20, thread = " + ThreadMethodProxy.currentThread().getName());
        BearDatabase r6 = a();     // Catch: Exception -> L5
        long r7 = System.currentTimeMillis();     // Catch: Exception -> L5
        d1 r8 = (d1) r6.c();     // Catch: Exception -> L5
        r8.getClass();     // Catch: Exception -> L5
        RoomSQLiteQuery r9 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? ORDER BY CAST(LT.open_time_recent AS INTEGER) DESC, LT.obj_token ASC LIMIT ?", 2);     // Catch: Exception -> L5
        r9.bindLong(1, 1);     // Catch: Exception -> L5
        r9.bindLong(2, 20);     // Catch: Exception -> L5
        LiveData r10 = r8.a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new j1(r8, r9));     // Catch: Exception -> L5
        long r11 = System.currentTimeMillis();     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "loadRecentDocsLimitLiveData()...liveData created, listType = 1, limit = 20, getDbCost = " + (r7 - r1) + ", createLiveDataCost = " + (r11 - r7) + ", totalCost = " + (r11 - r1) + ", liveDataHash = " + System.identityHashCode(r10) + ", thread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Exception -> L5
        return r10;
    L5:
        e = move-exception;
        tt5.a.e("UserDatabaseManager", "loadRecentDocsLimitLiveData()...failed, listType = 1, limit = 20, cost = " + (System.currentTimeMillis() - r1), e, false);
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final LiveData Od() {
        long r1 = System.currentTimeMillis();
        tt5.a.h("UserDatabaseManager", "loadStarDocsLimitLiveData()...start, listType = 6, limit = 20, thread = " + ThreadMethodProxy.currentThread().getName());
        BearDatabase r6 = a();     // Catch: Exception -> L5
        long r7 = System.currentTimeMillis();     // Catch: Exception -> L5
        d1 r8 = (d1) r6.c();     // Catch: Exception -> L5
        r8.getClass();     // Catch: Exception -> L5
        RoomSQLiteQuery r9 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? ORDER BY CAST(LT.star_time_star AS INTEGER) DESC, LT.obj_token ASC LIMIT ?", 2);     // Catch: Exception -> L5
        r9.bindLong(1, 6);     // Catch: Exception -> L5
        r9.bindLong(2, 20);     // Catch: Exception -> L5
        LiveData r10 = r8.a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new l1(r8, r9));     // Catch: Exception -> L5
        long r11 = System.currentTimeMillis();     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "loadStarDocsLimitLiveData()...liveData created, listType = 6, limit = 20, getDbCost = " + (r7 - r1) + ", createLiveDataCost = " + (r11 - r7) + ", totalCost = " + (r11 - r1) + ", liveDataHash = " + System.identityHashCode(r10) + ", thread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Exception -> L5
        return r10;
    L5:
        e = move-exception;
        tt5.a.e("UserDatabaseManager", "loadStarDocsLimitLiveData()...failed, listType = 6, limit = 20, cost = " + (System.currentTimeMillis() - r1), e, false);
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final LiveData Rd() {
        long r1 = System.currentTimeMillis();
        tt5.a.h("UserDatabaseManager", "loadPersonalDocsOfFolderLimitLiveData()...start, listType = 3, path = , limit = 20, thread = " + ThreadMethodProxy.currentThread().getName());
        BearDatabase r3 = a();     // Catch: Exception -> L5
        long r6 = System.currentTimeMillis();     // Catch: Exception -> L5
        LiveData r4 = ((d1) r3.c()).A();     // Catch: Exception -> L5
        long r8 = System.currentTimeMillis();     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "loadPersonalDocsOfFolderLimitLiveData()...liveData created, listType = 3, path = , limit = 20, getDbCost = " + (r6 - r1) + ", createLiveDataCost = " + (r8 - r6) + ", totalCost = " + (r8 - r1) + ", liveDataHash = " + System.identityHashCode(r4) + ", thread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Exception -> L5
        return r4;
    L5:
        e = move-exception;
        tt5.a.e("UserDatabaseManager", "loadPersonalDocsOfFolderLimitLiveData()...failed, listType = 3, path = , limit = 20, cost = " + (System.currentTimeMillis() - r1), e, false);
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
        long r1 = System.currentTimeMillis();
        tt5.a.h("UserDatabaseManager", "loadSharedDocsLimitLiveData()...start, listType = 10, limit = 20, thread = " + ThreadMethodProxy.currentThread().getName());
        BearDatabase r6 = a();     // Catch: Exception -> L5
        long r7 = System.currentTimeMillis();     // Catch: Exception -> L5
        d1 r8 = (d1) r6.c();     // Catch: Exception -> L5
        r8.getClass();     // Catch: Exception -> L5
        RoomSQLiteQuery r9 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? ORDER BY LT.share_time_share DESC, LT.obj_token ASC LIMIT ?", 2);     // Catch: Exception -> L5
        r9.bindLong(1, 10);     // Catch: Exception -> L5
        r9.bindLong(2, 20);     // Catch: Exception -> L5
        LiveData r10 = r8.a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new k1(r8, r9));     // Catch: Exception -> L5
        long r11 = System.currentTimeMillis();     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "loadSharedDocsLimitLiveData()...liveData created, listType = 10, limit = 20, getDbCost = " + (r7 - r1) + ", createLiveDataCost = " + (r11 - r7) + ", totalCost = " + (r11 - r1) + ", liveDataHash = " + System.identityHashCode(r10) + ", thread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Exception -> L5
        return r10;
    L5:
        e = move-exception;
        tt5.a.e("UserDatabaseManager", "loadSharedDocsLimitLiveData()...failed, listType = 10, limit = 20, cost = " + (System.currentTimeMillis() - r1), e, false);
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final List<u1> A1() {
        List<u1> r0 = ((d1) a().c()).q();     // Catch: Exception -> L14
        if (hu5.a.d(r0) == true) goto L13;
        Iterator r1 = ((ArrayList) r0).iterator();     // Catch: Exception -> L14
    L6:
        if (r1.hasNext() == false) goto L13;
        u1 r2 = (u1) r1.next();     // Catch: Exception -> L14
        if (x1.a(r2.K) == false) goto L10;
        r2.K = 7;     // Catch: Exception -> L14
        goto L6
    L10:
        r2.K = 5;     // Catch: Exception -> L14
    L13:
        return r0;
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
        mc5.n r0 = a().c();     // Catch: Exception -> L4
        int r1 = sbb.e.f.b;     // Catch: Exception -> L4
        d1 r2 = (d1) r0;     // Catch: Exception -> L4
        r2.getClass();     // Catch: Exception -> L4
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? AND DMI.type = ?", 2);     // Catch: Exception -> L4
        r3.bindLong(1, 4);     // Catch: Exception -> L4
        r3.bindLong(2, r1);     // Catch: Exception -> L4
        return r2.a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new m1(r2, r3));
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
    public final List A6(int r2) {
        return ((d1) a().c()).E(r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final int Ab(final String r3) {
        a().runInTransaction(new e2(this, r3));     // Catch: Exception -> L4
        return -1;
    L4:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final void B3(String r2) {
        t5(r2, 2);
    }

    @Override // mc5.j
    public final void D3(FolderSortStrategy r5) {
        mc5.i r1 = (mc5.i) a().d();     // Catch: Exception -> L9
        r1.a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r1.a.beginTransaction();     // Catch: Exception -> L9
        long r2 = r1.b.insertAndReturnId(r5);     // Catch: Throwable -> L6
        r1.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r1.a.endTransaction();     // Catch: Exception -> L9
        tt5.a.b("UserDatabaseManager", "insertSortStrategy()...: ret=" + r2);     // Catch: Exception -> L9
        return;
    L6:
        th = move-exception;
        r1.a.endTransaction();     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final String F(String r2) {
        mc5.b r3 = P9(r2);     // Catch: Exception -> L8
        if (r3 != null) goto L6;
        return null;
    L6:
        return r3.b;
    L8:
        e = move-exception;
        iu5.d.c(e);
        return null;
    }

    @Override // mc5.j
    public final int Ga(String r4) {
        int r5 = ((d1) a().c()).m(r4);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "deleteTtsPlaybackBeanByToken()...ret = " + r5);     // Catch: Exception -> L5
        return r5;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final long Ie(mc5.b r58) {
    L16:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    L4:
        if (r58.f0 == false) goto L6;
        int r1 = ((d1) a().c()).a0(r58.a, r58.getType(), r58.j, r58.c0, r58.l, r58.m, r58.o, r58.p, r58.q, r58.r, r58.s, r58.v, r58.w, r58.K, r58.L, r58.M, r58.N, r58.Q, r58.R, r58.S, r58.T, r58.Y, r58.Z, r58.a0, r58.d0, r58.e0);     // Catch: Exception -> L16
    L7:
        long r2 = r1;
        if (r2 > 0) goto L15;
        d1 r3 = (d1) a().c();     // Catch: Exception -> L16
        r3.a.assertNotSuspendingTransaction();     // Catch: Exception -> L16
        r3.a.beginTransaction();     // Catch: Exception -> L16
        long r4 = r3.b.insertAndReturnId(r58);     // Catch: Throwable -> L12
        r3.a.setTransactionSuccessful();     // Catch: Throwable -> L12
        r3.a.endTransaction();     // Catch: Exception -> L16
        return r4;
    L12:
        th = move-exception;
        r3.a.endTransaction();     // Catch: Exception -> L16
        throw th;     // Catch: Exception -> L16
    L15:
        return r2;
    L6:
        r1 = ((d1) a().c()).O(r58.a, r58.b, r58.getType(), r58.c0, r58.d, r58.e, r58.f, r58.g, r58.h, r58.i, r58.j, r58.k, r58.l, r58.m, r58.o, r58.p, r58.q, r58.r, r58.s, r58.t, r58.u, r58.v, r58.w, r58.x, r58.y, r58.z, r58.A, r58.B, r58.C, r58.D, r58.F, r58.H, r58.J, r58.K, r58.L, r58.M, r58.N, r58.Q, r58.R, r58.S, r58.n, r58.T, r58.U, r58.V, r58.W, r58.X, r58.Y, r58.Z, r58.P, r58.a0, r58.d0, r58.e0);     // Catch: Exception -> L16
        goto L7
    }

    @Override // mc5.j
    public final LiveData<List<u1>> J3(String r7) {
        d1 r0 = (d1) a().c();     // Catch: Exception -> L8
        r0.getClass();     // Catch: Exception -> L8
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? AND LT.file_path= ?", 2);     // Catch: Exception -> L8
        r1.bindLong(1, 3);     // Catch: Exception -> L8
        if (r7 != null) goto L5;
        r1.bindNull(2);     // Catch: Exception -> L8
    L6:
        return r0.a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new h1(r0, r1));
    L5:
        r1.bindString(2, r7);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final void L1(String r4) {
        tt5.a.b("UserDatabaseManager", "delete: ret=" + ((d1) a().c()).h(r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final List<b3> M7(int r2) {
        return ((j3) a().e()).c(r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final LiveData<List<u1>> N5(boolean r4) {
        mc5.n r0 = a().c();     // Catch: Exception -> L4
        d1 r1 = (d1) r0;     // Catch: Exception -> L4
        return r1.z(12, sbb.e.f.b, r4);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final mc5.b P9(String r2) {
        return ((d1) a().c()).y(r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return null;
    }

    @Override // mc5.j
    public final LiveData<List<u1>> Rc(String r3) {
        mc5.n r0 = a().c();     // Catch: Exception -> L4
        d1 r1 = (d1) r0;     // Catch: Exception -> L4
        return r1.B(r3, String.valueOf(sbb.e.f.b));
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final List<String> V4(long r2) {
        return ((d1) a().c()).F(r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final void V9(String r2) {
        ((d1) a().c()).W(r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final long Ve(so5.a r5) {
        d1 r1 = (d1) a().c();     // Catch: Exception -> L10
        r1.a.assertNotSuspendingTransaction();     // Catch: Exception -> L10
        r1.a.beginTransaction();     // Catch: Exception -> L10
        long r2 = r1.g.insertAndReturnId(r5);     // Catch: Throwable -> L7
        r1.a.setTransactionSuccessful();     // Catch: Throwable -> L7
        r1.a.endTransaction();     // Catch: Exception -> L10
        tt5.a.h("UserDatabaseManager", "insertOrReplaceTtsPlaybackBean()...ret = " + r2);     // Catch: Exception -> L10
        return r2;
    L7:
        th = move-exception;
        r1.a.endTransaction();     // Catch: Exception -> L10
        throw th;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final so5.a Y7(String r2) {
        return ((d1) a().c()).J(r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return null;
    }

    @Override // mc5.j
    public final LiveData<List<u1>> ae(int r4) {
        mc5.n r0 = a().c();     // Catch: Exception -> L4
        d1 r1 = (d1) r0;     // Catch: Exception -> L4
        return r1.z(r4, sbb.e.f.b, false);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    public final long[] b(List<mc5.b> r6) {
        if (r6 == null) goto L5;
        long[] r1 = new long[r6.size()];     // Catch: Exception -> L12
        int r2 = 0;
    L8:
        if (r2 >= r6.size()) goto L11;
        r1[r2] = Ie((mc5.b) ListProtector.get(r6, r2));     // Catch: Exception -> L12
        r2 = r2 + 1;
        goto L8
    L11:
        return r1;
    L12:
        e = move-exception;
        iu5.d.c(e);
        return new long[0];
    L5:
        return new long[0];
    }

    @Override // mc5.j
    public final int c(List<String> r4) {
        tt5.a.h("UserDatabaseManager", "delCachedStatus(List<String> doc_tokens)");
        if (hu5.a.d(r4) == false) goto L10;
        return -1;
    L10:
        return ((d1) a().c()).M(r4, 0);
    L7:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final LiveData<List<u1>> c7(int r2) {
        return new i0(this, r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    @Override // mc5.j
    public final int gb(String r2) {
        return ((d1) a().c()).e0(r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final String i(String r2) {
        return ((d1) a().c()).G(r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return null;
    }

    @Override // mc5.j
    public final int l(List<String> r9) {
        tt5.a.h("UserDatabaseManager", "saveCachedStatus(List<String> objTokens)");
        Iterator<String> r10 = r9.iterator();     // Catch: Exception -> L17
        boolean r1 = false;
    L4:
        if (r10.hasNext() == false) goto L13;
        String r2 = r10.next();     // Catch: Exception -> L17
        mc5.n r4 = a().c();     // Catch: Exception -> L17
        mc5.a r5 = new mc5.a();     // Catch: Exception -> L17
        r5.a = r2;     // Catch: Exception -> L17
        r5.b = 2;     // Catch: Exception -> L17
        d1 r6 = (d1) r4;     // Catch: Exception -> L17
        mc5.a r3 = r6.I(r2);     // Catch: Exception -> L17
        if (r3 == null) goto L11;
        r5.d = r3.d;     // Catch: Exception -> L17
        r5.c = r3.c;     // Catch: Exception -> L17
        r5.e = r3.e;     // Catch: Exception -> L17
    L11:
        if (r6.s(r5) > 0) goto L4;
        r1 = true;
        goto L4
    L13:
        if (r1 == true) goto L27;
        return 1;
    L27:
        return -1;
    L17:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final FolderSortStrategy m1(String r2) {
        return ((mc5.i) a().d()).b(r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new FolderSortStrategy();
    }

    @Override // mc5.j
    public final void nb(int r2) {
        ((d1) a().c()).g(r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int r7(List<String> r3) {
        int r1 = 0;
        if (hu5.a.d(r3) == false) goto L5;
        return 0;
    L5:
        Iterator<String> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        Ab(r4.next());
        r1 = r1 + 1;
        goto L7
    L9:
        return r1;
    }

    @Override // mc5.j
    public final b3 rc(String r2) {
        return ((j3) a().e()).d(r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return null;
    }

    @Override // mc5.j
    public final void s1(final List<b3> r3) {
        a().runInTransaction(new y1(this, r3));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int td(String r4) {
        d1 r0 = (d1) a().c();
        r0.getClass();
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT doc_cache_status FROM CacheStatus WHERE obj_token =?", 1);
        if (r4 != null) goto L5;
        r1.bindNull(1);
    L6:
        r0.a.assertNotSuspendingTransaction();
        int r2 = 0;
        Cursor r5 = DBUtil.query(r0.a, r1, false, null);
    L12:
        th = move-exception;
        r5.close();
        r1.release();
        throw th;
    L8:
        if (r5.moveToFirst() == false) goto L10;
        r2 = r5.getInt(0);     // Catch: Throwable -> L12
    L10:
        r5.close();
        r1.release();
        return r2;
    L5:
        r1.bindString(1, r4);
        goto L6
    }

    @Override // mc5.j
    public final void x6(String r4) {
        tt5.a.b("UserDatabaseManager", "delete: ret=" + ((d1) a().c()).d(r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int y8(final String r3) {
        a().runInTransaction(new l2(this, r3));     // Catch: Exception -> L4
        return -1;
    L4:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final int z7(String r4) {
        int r5 = ((j3) a().e()).a(r4);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "deleteWikiSpaceByObjToken()...ret = " + r5);     // Catch: Exception -> L5
        return r5;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final LiveData zd(String r2) {
        return new y2(this, r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new MediatorLiveData();
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [mc5.j2] */
    @Inject
    public x2(com.bytedance.ee.util.db.a r45, t45.c r46) {
        this.a = r45;
        this.b = r46;
        Application r2 = eu5.b.a();
        k r3 = new k();
        v r4 = new v();
        g0 r5 = new g0();
        k0 r6 = new k0();
        l0 r7 = new l0();
        m0 r8 = new m0();
        n0 r9 = new n0();
        o0 r10 = new o0();
        p0 r11 = new p0();
        a r12 = new a();
        b r13 = new b();
        c r14 = new c();
        d r15 = new d();
        e r16 = new e();
        f r17 = new f();
        g r18 = new g();
        h r19 = new h();
        i r20 = new i();
        j r21 = new j();
        l r22 = new l();
        m r23 = new m();
        n r24 = new n();
        o r25 = new o();
        p r26 = new p();
        q r27 = new q();
        r r28 = new r();
        s r29 = new s();
        t r30 = new t();
        u r31 = new u();
        w r32 = new w();
        x r33 = new x();
        y r34 = new y();
        z r35 = new z();
        a0 r36 = new a0();
        b0 r37 = new b0();
        c0 r38 = new c0();
        d0 r39 = new d0();
        e0 r40 = new e0();
        f0 r41 = new f0();
        DBController.a r1 = new DBController.a(r2);
        r1.a = "bear.db";
        r1.b = BearDatabase.class;
        r1.d = r3;
        r1.a(new Migration[]{r4});
        r1.a(new Migration[]{new h0()});
        r1.a(new Migration[]{r5});
        r1.a(new Migration[]{r6});
        r1.a(new Migration[]{r7});
        r1.a(new Migration[]{r8});
        r1.a(new Migration[]{r9});
        r1.a(new Migration[]{r10});
        r1.a(new Migration[]{r11});
        r1.a(new Migration[]{r12});
        r1.a(new Migration[]{r13});
        r1.a(new Migration[]{r14});
        r1.a(new Migration[]{r15});
        r1.a(new Migration[]{r16});
        r1.a(new Migration[]{r17});
        r1.a(new Migration[]{r18});
        r1.a(new Migration[]{r19});
        r1.a(new Migration[]{r20});
        r1.a(new Migration[]{r21});
        r1.a(new Migration[]{r22});
        r1.a(new Migration[]{r23});
        r1.a(new Migration[]{r24});
        r1.a(new Migration[]{r25});
        r1.a(new Migration[]{r26});
        r1.a(new Migration[]{r27});
        r1.a(new Migration[]{r28});
        r1.a(new Migration[]{r29});
        r1.a(new Migration[]{r30});
        r1.a(new Migration[]{r31});
        r1.a(new Migration[]{r32});
        r1.a(new Migration[]{r33});
        r1.a(new Migration[]{r34});
        r1.a(new Migration[]{r35});
        r1.a(new Migration[]{r36});
        r1.a(new Migration[]{r37});
        r1.a(new Migration[]{r38});
        r1.a(new Migration[]{r39});
        r1.a(new Migration[]{r40});
        r1.a(new Migration[]{r41});
        r1.a(new Migration[]{new Migration40_41()});
        r1.a(new Migration[]{new Migration41_42()});
        r1.a(new Migration[]{new Migration42_43()});
        r1.a(new Migration[]{new Migration43_44()});
        r1.a(new Migration[]{new Migration44_45()});
        r1.a(new Migration[]{new Migration46_47()});
        r1.a(new Migration[]{new Migration47_48()});
        r1.a(new Migration[]{new Migration48_49()});
        r1.a(new Migration[]{new Migration49_50()});
        r1.a(new Migration[]{new Migration50_51()});
        r1.a(new Migration[]{new Migration51_52()});
        r1.a(new Migration[]{new Migration52_53()});
        r1.a(new Migration[]{new Migration53_54()});
        r1.a(new Migration[]{new Migration54_55()});
        r1.a(new Migration[]{new Migration55_56()});
        r1.a(new Migration[]{new Migration56_57()});
        r1.a(new Migration[]{new Migration57_58()});
        r1.a(new Migration[]{new Migration58_59()});
        r1.a(new Migration[]{new Migration59_60()});
        r1.a(new Migration[]{new Migration60_61()});
        r1.a(new Migration[]{new Migration61_62()});
        r1.a(new Migration[]{new Migration62_63()});
        r1.a(new Migration[]{new Migration63_64()});
        r1.a(new Migration[]{new Migration64_65()});
        r1.a(new Migration[]{new Migration65_66()});
        r1.a(new Migration[]{new Migration66To67()});
        r1.a(new Migration[]{new Migration67To68()});
        r1.a(new Migration[]{new Migration68To69()});
        r1.a(new Migration[]{new Migration69To70()});
        r1.a(new Migration[]{new Migration70To71()});
        r1.a(new Migration[]{new Migration71To72()});
        r1.a(new Migration[]{new Migration72To73(new j2(this))});
        r1.a(new Migration[]{new Migration73To74()});
        r1.a(new Migration[]{new Migration74To75()});
        r1.a(new Migration[]{new Migration75To76()});
        r1.a(new Migration[]{new Migration76To77()});
        r45.W3("bear.db", r1);
        long r42 = FileUtils.y(r2.getDatabasePath(r45.Aa(r2, "bear.db")).getAbsolutePath()) / 1024;
        tt5.a.h("UserDatabaseManager", " checkAndReduceDb   dbSize = " + r42);
        if (r42 <= 1048576) goto L6;
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new z1(this), new a2());
        return;
    }

    @Override // mc5.j
    public final void D8(String r3, String r4) {
        tt5.a.h("UserDatabaseManager", "updateDocSize()...ret = " + ((d1) a().c()).S(r3, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void E5(String r3, boolean r4) {
        tt5.a.h("UserDatabaseManager", "updateDocPined()...ret = " + ((d1) a().c()).Q(r3, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void K1(String r3, String r4) {
        tt5.a.h("UserDatabaseManager", "updateWikiSpaceTitle()...ret = " + ((j3) a().e()).g(r3, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int L6(String r4, String r5) {
        int r1 = -1;
        r1 = ((d1) a().c()).h0(r4, r5);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateWikiTokenAndExtra: ret=" + r1);     // Catch: Exception -> L5
        return r1;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r1;
    }

    @Override // mc5.j
    public final void O4(String r3, boolean r4) {
        tt5.a.h("UserDatabaseManager", "updateDocStar()...ret = " + ((d1) a().c()).T(r3, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final List<mc5.d> R9(int r9, FolderSortStrategy r10) {
        if (r10 == null) goto L4;
        mc5.n r0 = a().c();     // Catch: Exception -> L7
        d1 r1 = (d1) r0;     // Catch: Exception -> L7
        return r1.o(r9, r10.getType(), r10.c, r10.e, r10.f, r10.a);
    L4:
        return new ArrayList();
    L7:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // mc5.j
    public final void S1(String r3, int r4) {
        tt5.a.h("UserDatabaseManager", "updateOwnerType()...ret = " + ((d1) a().c()).Z(r3, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int We(final int r2, List<String> r3) {
        int r4 = ju5.c.a(r3, new o2(this, r2), a());
        tt5.a.h("UserDatabaseManager", "deleteRecentDocNotInObjTokenList: ret=" + r4);
        return r4;
    }

    @Override // mc5.j
    public final int Y8(String r5, String r6) {
        int r1 = 0;
        d1 r2 = (d1) a().c();     // Catch: Exception -> L10
        if (hu5.a.d(r2.w(r6)) == false) goto L7;
        int r7 = r2.N(r5, r6);     // Catch: Exception -> L10
    L6:
        r1 = r7;
        tt5.a.h("UserDatabaseManager", "updateCacheStatusObjToken: ret=" + r1);     // Catch: Exception -> L10
    L12:
        return r1;
    L7:
        r2.a(r5);     // Catch: Exception -> L10
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L10
        r8.add(r6);     // Catch: Exception -> L10
        r7 = r2.M(r8, 2);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        iu5.d.c(e);
        goto L12
    }

    @Override // mc5.j
    public final void Z6(String r3, String r4) {
        tt5.a.h("UserDatabaseManager", "updateTitle: ret=" + ((d1) a().c()).c0(r3, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int a2(int r4, String r5) {
        int r1 = -1;
        r1 = ((d1) a().c()).b(r4, r5);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "deleteListDocRecordByObjToken()...ret = " + r1);     // Catch: Exception -> L5
        return r1;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r1;
    }

    @Override // mc5.j
    public final long a3(final mc5.b r3, final v1 r4) {
        return ((Integer) a().runInTransaction(new k2(this, r3, r4))).intValue();
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final void db(String r3, String r4) {
        tt5.a.b("UserDatabaseManager", "updateListTypes: ret=" + ((d1) a().c()).V(r3, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int j7(int r4, List<String> r5) {
        int r1 = 0;
        r1 = ((d1) a().c()).c(r4, r5);     // Catch: Exception -> L5
        tt5.a.b("UserDatabaseManager", "delete: ret=" + r1);     // Catch: Exception -> L5
        return r1;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r1;
    }

    @Override // mc5.j
    public final void k(final String r3, final int r4) {
        tt5.a.h("UserDatabaseManager", "setCacheDownloadStatus token: ");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new c2(this, r3, r4), new d2());
    }

    @Override // mc5.j
    public final int oe(String r3, boolean r4) {
        int r5 = ((j3) a().e()).e(r3, r4);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateWikiSpaceStar()...ret = " + r5);     // Catch: Exception -> L5
        return r5;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final long p6(final mc5.b r3, final v1 r4) {
        return ((Integer) a().runInTransaction(new p2(this, r3, r4))).intValue();
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final int q2(String r3, boolean r4) {
        int r5 = ((j3) a().e()).f(r3, r4);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateWikiSpaceStar()...ret = " + r5);     // Catch: Exception -> L5
        return r5;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    @Override // mc5.j
    public final void q9(String r3, boolean r4) {
        tt5.a.h("UserDatabaseManager", "updateDocSubscribed()...ret = " + ((d1) a().c()).U(r3, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void s4(String r3, String r4) {
        tt5.a.h("UserDatabaseManager", "updateWikiTitleByObjToken()...ret = " + ((d1) a().c()).g0(r3, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void s6(String r3, String r4) {
        tt5.a.h("UserDatabaseManager", "updateShortcutTitle: ret=" + ((d1) a().c()).b0(r3, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void t5(final String r3, final int r4) {
        tt5.a.h("UserDatabaseManager", "saveDocCachedStatus token: ");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new m2(this, r3, r4), new n2());
    }

    @Override // mc5.j
    public final void v4(final List<mc5.b> r3, final List<v1> r4) {
        a().runInTransaction(new r2(this, r3, r4));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final u1 z3(int r2, String r3) {
        return ((d1) a().c()).x(r3, r2);
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new u1();
    }

    @Override // mc5.j
    public final void G4(String r3, String r4, int r5) {
        tt5.a.h("UserDatabaseManager", "updateDocSecurity()...ret = " + ((d1) a().c()).R(r3, r4, r5));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int Kd(String r5, String r6, String r7) {
        int r1 = -1;
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L5
        r2.add(1);     // Catch: Exception -> L5
        r2.add(5);     // Catch: Exception -> L5
        r2.add(6);     // Catch: Exception -> L5
        r1 = ((d1) a().c()).Y(r5, r6, r7, r2);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateObjTokenAndToken: ret=" + r1 + " ret2 is " + ((d1) a().c()).X(r5, r6, r2));     // Catch: Exception -> L5
        return r1;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r1;
    }

    @Override // mc5.j
    public final int Y4(String r4, String r5, String r6) {
        int r1 = 0;
        r1 = ((d1) a().c()).P(r4, r5, r6);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateRecentDoc: ret=" + r1);     // Catch: Exception -> L5
        return r1;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r1;
    }

    @Override // mc5.j
    public final void da(final String r3, final int r4, final int r5) {
        tt5.a.h("UserDatabaseManager", "saveStatusManualoffline objToken: " + du5.b.i(r3) + "   type: " + r4 + "   statusManualoffline: " + r5);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new h2(this, r3, r4, r5), new i2());
    }

    @Override // mc5.j
    public final void dc(final int r3, final List<mc5.b> r4, final List<v1> r5) {
        a().runInTransaction(new q2(this, r3, r4, r5));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void w5(final List<mc5.b> r3, final List<v1> r4, final boolean r5) {
        a().runInTransaction(new g2(this, r5, r3, r4));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void x9(final List<mc5.b> r3, final List<v1> r4, final int r5) {
        a().runInTransaction(new b2(this, r5, r3, r4));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void R1(final List r9, final List r10, final List r11, final FolderSortStrategy r12) {
        a().runInTransaction(new v2(this, r9, r10, r12, r11));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int Yc(String r2, String r3, String r4, String r5) {
        ((d1) a().c()).d0(r2, r3, r5, r4);     // Catch: Exception -> L4
        tt5.a.h("UserDatabaseManager", "updateDocTitleAndEditTime()...ret = 0");     // Catch: Exception -> L4
        return 0;
    L4:
        e = move-exception;
        iu5.d.c(e);
        return 0;
    }

    @Override // mc5.j
    public final void b9(final int r9, final String r10, final List<mc5.b> r11, final List<v1> r12) {
        a().runInTransaction(new s2(this, r9, r10, r11, r12));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void A3(final List<mc5.b> r10, final List<v1> r11, final List<mc5.c> r12, final int r13, final FolderSortStrategy r14) {
        a().runInTransaction(new f2(this, r13, r10, r11, r14, r12));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final void p8(final List<mc5.b> r10, final List<v1> r11, final List<mc5.c> r12, final int r13, final FolderSortStrategy r14) {
        a().runInTransaction(new w2(this, r13, r10, r11, r14, r12));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // mc5.j
    public final int ya(String r12, String r13, String r14, String r15, String r16, int r17, String r18) {
        int r1 = 0;
        r1 = ((d1) a().c()).f0(r12, r13, r14, r15, r16, r17, r18);     // Catch: Exception -> L5
        tt5.a.h("UserDatabaseManager", "updateWikiDocMetaObj: ret=" + r1);     // Catch: Exception -> L5
        return r1;
    L5:
        e = move-exception;
        iu5.d.c(e);
        return r1;
    }
}
