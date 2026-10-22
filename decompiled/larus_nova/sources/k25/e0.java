package k25;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.migration.Migration;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.OfflineCacheConfig;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.db.DBController;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.CipherException;
import com.ss.lark.android.encryption.exception.DecryptException;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes16.dex */
public final class e0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile e0 f501493e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f501494f = 5184000000L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static com.larksuite.framework.thread.p f501495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f501496h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f501497i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final o f501498j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final p f501499k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final q f501500l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final r f501501m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final u f501502n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final v f501503o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f501504p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final f f501505q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final g f501506r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final h f501507s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final i f501508t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final j f501509u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final l f501510v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f501511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e1 f501512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f501513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g0 f501514d;

    public class a extends Migration {
        public a() {
            super(10, 11);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            tt5.a.b("OfflineDataManager", "exe migration from 10 -> 11");
        }
    }

    public class b extends Migration {
        public b() {
            super(11, 12);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE file_model ADD COLUMN new_upload_key TEXT");
        }
    }

    public class c extends Migration {
        public c() {
            super(12, 13);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE at_object ADD COLUMN sub_type INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class d extends Migration {
        public d() {
            super(13, 14);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE `file_model` ADD COLUMN uri TEXT NOT NULL DEFAULT ''");
        }
    }

    public class e extends Migration {
        public e() {
            super(14, 15);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `bitable_file_model` (`_id` INTEGER NOT NULL, `name` TEXT NOT NULL, `token` TEXT NOT NULL, `doc_url` TEXT, `table_id` TEXT, `field_id` TEXT, `record_id` TEXT, `path` TEXT NOT NULL, `uri` TEXT NOT NULL DEFAULT '', `mime_type` TEXT, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `upload_task_key` TEXT, `upload_progress` INTEGER NOT NULL, `attachment_token` TEXT, `is_camera_only` INTEGER NOT NULL,  PRIMARY KEY(`_id`))");
        }
    }

    public class f extends Migration {
        public f() {
            super(15, 16);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ResourceData ADD COLUMN page INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE ResourceData ADD COLUMN total_page INTEGER NOT NULL DEFAULT 1");
            r100.execSQL("ALTER TABLE ResourceData ADD COLUMN batch_num TEXT");
        }
    }

    public class g extends Migration {
        public g() {
            super(16, 17);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ResourceData ADD COLUMN load_from TEXT");
        }
    }

    public class h extends Migration {
        public h() {
            super(17, 18);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE INDEX IF NOT EXISTS index_ResourceData_reskey_obj_token_page ON ResourceData(reskey, obj_token, page)");
        }
    }

    public class i extends Migration {
        public i() {
            super(18, 19);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE at_object ADD COLUMN iconInfo TEXT NOT NULL DEFAULT ''");
        }
    }

    public class j extends Migration {
        public j() {
            super(19, 20);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ResourceData ADD COLUMN category TEXT");
        }
    }

    public class k extends Migration {
        public k() {
            super(1, 2);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ResourceData ADD COLUMN url TEXT");
        }
    }

    public class l extends Migration {
        public l() {
            super(20, 21);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE at_object");
        }
    }

    public class m extends RoomDatabase.Callback {
        public m() {
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onCreate(SupportSQLiteDatabase r100) {
            super.onCreate(r100);
            tt5.a.b("OfflineDataManager", "onCreate: ");
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onOpen(SupportSQLiteDatabase r100) {
            super.onOpen(r100);
            tt5.a.b("OfflineDataManager", "onOpen: ");
        }
    }

    public class n implements Function<String, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f501515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e0 f501516b;

        @Override // io.reactivex.functions.Function
        public final Integer apply(String r210) throws Exception {
            String r100 = r210;
            long r101 = System.currentTimeMillis() - e0.f501494f;
            b1 r102 = (b1) this.f501516b.q().e();
            r102.getClass();
            RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE isNeedSync= ? and obj_token= ?", 2);
            r103.bindLong(1, 1);
            if (r100 != null) goto L5;
            r103.bindNull(2);
        L6:
            r102.f501476a.assertNotSuspendingTransaction();
            Cursor r104 = DBUtil.query(r102.f501476a, r103, false, null);
            int r110 = CursorUtil.getColumnIndexOrThrow(r104, "id");     // Catch: Throwable -> L59
            int r111 = CursorUtil.getColumnIndexOrThrow(r104, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L59
            int r112 = CursorUtil.getColumnIndexOrThrow(r104, ResourceData.KEY_RESOURCE_VALUE);     // Catch: Throwable -> L59
            int r113 = CursorUtil.getColumnIndexOrThrow(r104, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L59
            int r114 = CursorUtil.getColumnIndexOrThrow(r104, "update_time");     // Catch: Throwable -> L59
            int r115 = CursorUtil.getColumnIndexOrThrow(r104, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L59
            int r105 = CursorUtil.getColumnIndexOrThrow(r104, "isNeedSync");     // Catch: Throwable -> L59
            int r106 = CursorUtil.getColumnIndexOrThrow(r104, "config");     // Catch: Throwable -> L59
            int r107 = CursorUtil.getColumnIndexOrThrow(r104, "type");     // Catch: Throwable -> L59
            int r108 = CursorUtil.getColumnIndexOrThrow(r104, "token");     // Catch: Throwable -> L59
            int r109 = CursorUtil.getColumnIndexOrThrow(r104, "obj_token");     // Catch: Throwable -> L59
            int r116 = CursorUtil.getColumnIndexOrThrow(r104, "userToken");     // Catch: Throwable -> L59
            int r117 = CursorUtil.getColumnIndexOrThrow(r104, "tenantID");     // Catch: Throwable -> L59
            int r118 = CursorUtil.getColumnIndexOrThrow(r104, "url");     // Catch: Throwable -> L56
            RoomSQLiteQuery r119 = r103;
            int r120 = CursorUtil.getColumnIndexOrThrow(r104, ResourceData.KEY_SUBBLOCK_PRELOAD_STATUS);     // Catch: Throwable -> L54
            int r121 = CursorUtil.getColumnIndexOrThrow(r104, "page");     // Catch: Throwable -> L54
            int r122 = CursorUtil.getColumnIndexOrThrow(r104, ResourceData.KEY_TOTAL_PAGE);     // Catch: Throwable -> L54
            int r123 = CursorUtil.getColumnIndexOrThrow(r104, ResourceData.KEY_BATCH_NUM);     // Catch: Throwable -> L54
            int r124 = CursorUtil.getColumnIndexOrThrow(r104, ResourceData.KEY_LOAD_FROM);     // Catch: Throwable -> L54
            int r125 = CursorUtil.getColumnIndexOrThrow(r104, "category");     // Catch: Throwable -> L54
            if (r104.moveToFirst() == false) goto L26;
            m0 r126 = new m0();     // Catch: Throwable -> L54
            r126.f501540a = r104.getInt(r110);     // Catch: Throwable -> L54
            r126.f501541b = r104.getString(r111);     // Catch: Throwable -> L54
            r126.f501542c = r104.getString(r112);     // Catch: Throwable -> L54
            r126.f501543d = r104.getString(r113);     // Catch: Throwable -> L54
            if (r104.isNull(r114) == false) goto L15;
            Long r127 = null;
        L16:
            r126.f501544e = r127;     // Catch: Throwable -> L54
            if (r104.isNull(r115) == false) goto L19;
            Long r128 = null;
        L20:
            r126.f501545f = r128;     // Catch: Throwable -> L54
            if (r104.getInt(r105) == 0) goto L23;
            boolean r129 = true;
        L24:
            r126.f501546g = r129;     // Catch: Throwable -> L54
            r126.f501547h = r104.getString(r106);     // Catch: Throwable -> L54
            r126.f501548i = r104.getString(r107);     // Catch: Throwable -> L54
            r126.f501549j = r104.getString(r108);     // Catch: Throwable -> L54
            r126.f501550k = r104.getString(r109);     // Catch: Throwable -> L54
            r126.f501551l = r104.getString(r116);     // Catch: Throwable -> L54
            r126.f501552m = r104.getString(r117);     // Catch: Throwable -> L54
            r126.f501553n = r104.getString(r118);     // Catch: Throwable -> L54
            r126.f501554o = r104.getInt(r120);     // Catch: Throwable -> L54
            r126.f501555p = r104.getInt(r121);     // Catch: Throwable -> L54
            r126.f501556q = r104.getInt(r122);     // Catch: Throwable -> L54
            r126.f501557r = r104.getString(r123);     // Catch: Throwable -> L54
            r126.f501558s = r104.getString(r124);     // Catch: Throwable -> L54
            r126.f501559t = r104.getString(r125);     // Catch: Throwable -> L54
            m0 r130 = r126;
        L27:
            r104.close();
            r119.release();
            if (idb.f.a().isEnable("ccm.mobile.db_error_optimization") == false) goto L32;
            if (r130 == null) goto L32;
            return -1;
        L32:
            this.f501516b.f501511a.d(r100);
            this.f501516b.f501512b.d(r100, r101);
            ArrayList r131 = (ArrayList) this.f501516b.z(this.f501515a);
            if (r131.size() <= 0) goto L43;
            this.f501516b.e(this.f501515a);
            Iterator r132 = r131.iterator();
        L36:
            if (r132.hasNext() == false) goto L43;
            j25.q r133 = (j25.q) r132.next();
            if (TextUtils.isEmpty(r133.f497004d) == true) goto L36;
            Context r134 = this.f501516b.f501513c;
            VFSPath r135 = ay4.d.a().z(r133.f497004d);
            Map<String, String> r136 = FileUtils.f243139a;
            if (r135.getRealPath().contains(AppInfoUtils.b(r134)) == true) goto L41;
            tt5.a.k("FileUtils", "safeDeleteFile, not allow to delete user files");
            goto L36
        L41:
            FileUtils.m(r135);
        L43:
            b1 r137 = (b1) this.f501516b.q().e();
            r137.f501476a.assertNotSuspendingTransaction();
            SupportSQLiteStatement r138 = r137.f501480e.acquire();
            if (r100 != null) goto L46;
            r138.bindNull(1);
        L47:
            r138.bindLong(2, r101);
            r137.f501476a.beginTransaction();
            int r139 = r138.executeUpdateDelete();     // Catch: Throwable -> L51
            r137.f501476a.setTransactionSuccessful();     // Catch: Throwable -> L51
            r137.f501476a.endTransaction();
            r137.f501480e.release(r138);
            return Integer.valueOf(r139);
        L51:
            th = move-exception;
            r137.f501476a.endTransaction();
            r137.f501480e.release(r138);
            throw th;
        L46:
            r138.bindString(1, r100);
            goto L47
        L23:
            r129 = false;
            goto L24
        L19:
            r128 = Long.valueOf(r104.getLong(r115));     // Catch: Throwable -> L54
            goto L20
        L15:
            r127 = Long.valueOf(r104.getLong(r114));     // Catch: Throwable -> L54
            goto L16
        L26:
            r130 = null;
        L54:
            th = th;
        L61:
            r104.close();
            r119.release();
            throw th;
        L56:
            th = th;
        L58:
            r119 = r103;
        L59:
            th = th;
            goto L58
        L5:
            r103.bindString(2, r100);
            goto L6
        }

        public n(e0 r100, String r101) {
            this.f501516b = r100;
            this.f501515a = r101;
        }
    }

    public class o extends Migration {
        public o() {
            super(2, 3);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            tt5.a.b("OfflineDataManager", "migrate_2_3()...");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `file_model` (`name` TEXT NOT NULL, `token` TEXT NOT NULL, `doc_url` TEXT NOT NULL, `path` TEXT NOT NULL, `local_url` TEXT, `net_url` TEXT,  PRIMARY KEY(`name`, `token`))");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `at_object` (`id` TEXT NOT NULL, `cn_name` TEXT, `en_name` TEXT, `name` TEXT, `title` TEXT, `type` INTEGER NOT NULL, `token` TEXT, `content` TEXT, `edit_time` TEXT, `owner` TEXT, `desc` TEXT, `count` TEXT, `url` TEXT, `department` TEXT, `avatar_url` TEXT, PRIMARY KEY(`id`))");
        }
    }

    public class p extends Migration {
        public p() {
            super(3, 4);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE `at_object` ADD COLUMN isExternal INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class q extends Migration {
        public q() {
            super(4, 5);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
        }
    }

    public class r extends Migration {
        public r() {
            super(5, 6);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ResourceData ADD COLUMN resvalue_filepath TEXT");
        }
    }

    public class s extends Migration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f501517a;

        public s(e0 r100) {
            this.f501517a = r100;
            super(6, 7);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            this.f501517a.getClass();
            ArrayList r101 = (ArrayList) k25.d.b(r100);     // Catch: Exception -> L18
            if (r101.size() <= 0) goto L33;
            e1 r102 = new e1(new char[]{Typography.dollar, '5', '2', '*', 'y', Symlink.UNIX_ID, 'q'}, true);     // Catch: Exception -> L18
            ArrayList r103 = new ArrayList();     // Catch: Exception -> L18
            ArrayList r104 = new ArrayList();     // Catch: Exception -> L18
            Iterator r105 = r101.iterator();     // Catch: Exception -> L18
        L7:
            if (r105.hasNext() == false) goto L16;
            m0 r106 = (m0) r105.next();     // Catch: Exception -> L18
            if (r106 == null) goto L7;
            if (TextUtils.isEmpty(r106.f501542c) == false) goto L12;
            if (TextUtils.isEmpty(r106.f501543d) == true) goto L7;
            r104.add(r106);     // Catch: Exception -> L18
            goto L7
        L12:
            r102.g(r106);     // Catch: Exception -> L18
            r103.add(r106);     // Catch: Exception -> L18
            goto L7
        L16:
            k25.d.c(r100, r103);     // Catch: Exception -> L18
            k25.d.a(r100, r104);     // Catch: Exception -> L18
            return;
        L33:
            return;
        L18:
            e = move-exception;
            tt5.a.f("OfflineDataManager", e, false);
        }
    }

    public class t extends Migration {
        public t() {
            super(7, 8);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE file_model ADD COLUMN upload_key TEXT");
        }
    }

    public class u extends Migration {
        public u() {
            super(8, 9);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE ResourceData ADD COLUMN subblock_preload_status INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class v extends Migration {
        public v() {
            super(9, 10);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            tt5.a.b("OfflineDataManager", "exe migration from 9 -> 10");
            r100.execSQL("ALTER TABLE file_model ADD COLUMN file_modified_time INTEGER NOT NULL DEFAULT 0");
        }
    }

    public final synchronized OfflineDatabase q() {
        monitor-enter(this);
        OfflineDatabase r100 = (OfflineDatabase) DBController.a().r1("offlineData.db");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public static e0 m() {
        if (f501493e != null) goto L17;
        Application r100 = eu5.b.f474075a;
        if (f501493e != null) goto L17;
        monitor-enter(e0.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f501493e != null) goto L11;
        f501493e = new e0(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(e0.class);     // Catch: Throwable -> L13
    L17:
        return f501493e;
    }

    public static Executor r() {
        if (f501495g != null) goto L6;
        DocOpenConfig.a();
        int r100 = DocOpenConfig.f218553g.fetch_core_pool_size;
        int r101 = f501496h * 8;
        DocOpenConfig.a();
        int r102 = Math.max(r101, DocOpenConfig.f218553g.fetch_max_pool_size);
        DocOpenConfig.a();
        f501495g = new com.larksuite.framework.thread.p("BEAR_Offline_Data", r100, r102, DocOpenConfig.f218553g.fetch_keep_alive_time, new SynchronousQueue(), new com.larksuite.framework.thread.n("OfflineData", 1));
    L6:
        return f501495g;
    }

    public final void b() {
        List<c1> r100 = q().e().f();     // Catch: Exception -> L13
        if (hu5.a.d(r100) == false) goto L7;
        tt5.a.k("OfflineDataManager", "no dirty page data.");     // Catch: Exception -> L13
        return;
    L7:
        this.f501512b.a(r100);     // Catch: Exception -> L13
        int r101 = 0;
    L8:
        ArrayList r102 = (ArrayList) r100;     // Catch: Exception -> L13
        if (r101 >= r102.size()) goto L11;
        c1 r103 = (c1) ListProtector.get(r100, r101);     // Catch: Exception -> L13
        this.f501511a.c(r103.f501487c, r103.f501489e);     // Catch: Exception -> L13
        q().e().a(r103.f501487c, r103.f501489e, System.currentTimeMillis() - f501494f);     // Catch: Exception -> L13
        r101 = r101 + 1;     // Catch: Exception -> L13
        goto L8
    L11:
        iu5.d.a("OfflineDataManager", new Throwable("cleanDirtyPageData size: " + r102.size()));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        tt5.a.l("OfflineDataManager", "Failed to cleanDirtyPageData, ", e);
    }

    public final void c() {
        VFSPath r100 = du5.c.a(this.f501513c);
        if (r100 != null) goto L5;
    L17:
        tt5.a.h("OfflineDataManager", "Photo cache dir is not exist.");
        return;
    L5:
        if (r100.toFile().exists() == false) goto L17;
        long r101 = FileUtils.t(r100) - ((long) 800);     // Catch: Exception -> L14
        if (r101 <= 0) goto L22;
        List<VFSFile> r102 = FileUtils.q(r100);     // Catch: Exception -> L14
        int r103 = 0;
    L11:
        if (r103 >= r101) goto L23;
        FileUtils.m(((VFSFile) ListProtector.get(r102, r103)).getVfsPath());     // Catch: Exception -> L14
        r103 = r103 + 1;
        goto L11
    L23:
        return;
    L22:
        return;
    L14:
        e = move-exception;
        tt5.a.m("FileUtils", e);
    }

    public final void h() {
        Flowable.just("").observeOn(fo5.d.b()).subscribe(new a0(this));
    }

    static {
        f501496h = Runtime.getRuntime().availableProcessors();
        f501497i = new k();
        f501498j = new o();
        f501499k = new p();
        f501500l = new q();
        f501501m = new r();
        f501502n = new u();
        f501503o = new v();
        f501504p = new a();
        f501505q = new f();
        f501506r = new g();
        f501507s = new h();
        f501508t = new i();
        f501509u = new j();
        f501510v = new l();
    }

    public e0(Context r110) {
        Intrinsics.checkNotNullParameter("page_res_data_clean_flag", "name");
        Intrinsics.checkNotNullParameter(ay4.b.b("page_res_data_clean_flag", true, ay4.b.a("page_res_data_clean_flag")), "repo");
        new ArrayList();
        s r100 = new s(this);
        t r101 = new t();
        b r102 = new b();
        c r103 = new c();
        d r104 = new d();
        e r105 = new e();
        this.f501513c = r110;
        this.f501511a = new l0();
        f501494f = ((long) ((OfflineCacheConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig())).getCategoryDeleteTimeout()) * 1000;
        tt5.a.h("OfflineDataManager", "OfflineDataManager sCategoryDeleteTimeout: " + f501494f);
        m r106 = new m();
        DBController.a r107 = new DBController.a(r110);
        r107.f243099a = "offlineData.db";
        r107.f243100b = OfflineDatabase.class;
        r107.f243102d = r106;
        r107.a(new Migration[]{f501497i, f501498j, f501499k, f501500l, f501501m, r100, r101, f501502n, f501503o, f501504p, r102, r103, r104, r105, f501505q, f501506r, f501507s, f501508t, f501509u, f501510v});
        DBController.a().W3("offlineData.db", r107);
        if (this.f501514d != null) goto L5;
        this.f501514d = new g0(this, r110);
    L5:
        DBController.a().x7(this.f501514d);
        this.f501512b = new e1(DBController.a().getKey().toCharArray(), false);
        MemoryCallbackManager.getInstance().registerMemoryCallback(new f0(this));
        Flowable.just("").observeOn(fo5.d.b()).subscribe(new b0(this));
        final long r108 = System.currentTimeMillis() - f501494f;
        ((k25.a) LarkContext.spiByDwarf(k25.a.class)).m().observeOn(fo5.d.b()).map(new k25.e()).subscribe(new k25.g(this, r108), new k25.h());
    }

    public static String D(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return r100;
    L12:
        String r101 = CipherManager.g(r100);     // Catch: CipherException -> L9
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return r101;
    L8:
        return r100;
    L9:
        e = move-exception;
        tt5.a.e("OfflineDataManager", "replacePersistentFilePath... err happens : " + e.getErrorCode(), e, false);
        return r100;
    }

    public static void a(j25.q r100) {
        if (r100 == null) goto L39;
        boolean r101 = TextUtils.isEmpty(r100.f497004d);
        String r102 = r100.f497004d;
        String r103 = r100.f497005e;
        if (TextUtils.isEmpty(r102) == false) goto L7;
        r102 = r103;
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L38;
        Pair r104 = new Pair(Boolean.valueOf(r101), r102);
    L26:
        boolean r105 = ((Boolean) r104.first).booleanValue();
        String r106 = "";
        if (r105 == false) goto L29;
        String r107 = (String) r104.second;
    L30:
        r100.f497005e = r107;
        if (r105 == true) goto L34;
        r106 = (String) r104.second;
    L34:
        r100.f497004d = r106;
        return;
    L29:
        r107 = "";
        goto L30
    L38:
        if (r101 == false) goto L17;
        Uri r108 = UriProtector.parse(r102);     // Catch: DecryptException -> L24
        Application r109 = eu5.b.f474075a;     // Catch: DecryptException -> L24
        int r110 = CipherManager.f456788a;     // Catch: DecryptException -> L24
        Intrinsics.checkNotNullParameter(r108, "uri");     // Catch: DecryptException -> L24
        Uri r111 = CipherManager.b(r109, r108);     // Catch: DecryptException -> L15
        Pair r112 = new Pair(Boolean.TRUE, r111.toString());     // Catch: DecryptException -> L24
    L14:
        r104 = r112;
        goto L26
    L15:
        e = move-exception;
        throw e;     // Catch: DecryptException -> L24
    L17:
        PolarisFileWrapper r113 = CipherManager.e(ay4.d.a().i(r102), false);     // Catch: DecryptException -> L24
        if (TextUtils.isEmpty(r113.getAbsolutePath()) == true) goto L23;
        if (r113.exists() == false) goto L23;
        r112 = new Pair(Boolean.FALSE, r113.getAbsolutePath());     // Catch: DecryptException -> L24
    L23:
        r104 = new Pair(Boolean.FALSE, r102);     // Catch: DecryptException -> L24
    L24:
        e = move-exception;
        tt5.a.e("OfflineDataManager", "replaceTempDecryptFilePath... err happens : ", e, false);
        r104 = new Pair(Boolean.valueOf(r101), r102);
        goto L26
    }

    public static int p(List r100) {
        if (hu5.a.d(r100) == false) goto L5;
        return 0;
    L5:
        c1 r101 = (c1) ListProtector.get(r100, ((ArrayList) r100).size() - 1);
        if (r101 != null) goto L9;
        return 0;
    L9:
        return r101.f501490f;
    }

    public final void G(j25.q r100) {
        j25.p r101 = (j25.p) q().d();     // Catch: Exception -> L10
        r101.f496993a.assertNotSuspendingTransaction();     // Catch: Exception -> L10
        r101.f496993a.beginTransaction();     // Catch: Exception -> L10
        int r102 = r101.f496996d.handle(r100) + 0;     // Catch: Throwable -> L7
        r101.f496993a.setTransactionSuccessful();     // Catch: Throwable -> L7
        r101.f496993a.endTransaction();     // Catch: Exception -> L10
        tt5.a.h("OfflineDataManager", "updateFileModel rows " + r102);     // Catch: Exception -> L10
        return;
    L7:
        th = move-exception;
        r101.f496993a.endTransaction();     // Catch: Exception -> L10
        throw th;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        iu5.d.c(e);
    }

    public final int H(m0 r100) {
        n0 r101 = q().e();     // Catch: Exception -> L13
        m0 r102 = this.f501512b.f(r100, true);     // Catch: Exception -> L13
        b1 r103 = (b1) r101;     // Catch: Exception -> L13
        r103.f501476a.assertNotSuspendingTransaction();     // Catch: Exception -> L13
        r103.f501476a.beginTransaction();     // Catch: Exception -> L13
        int r104 = r103.f501478c.handle(r102) + 0;     // Catch: Throwable -> L10
        r103.f501476a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r103.f501476a.endTransaction();     // Catch: Exception -> L13
        if (r104 <= 0) goto L8;
        this.f501511a.b(r100.f501541b, r100.f501550k, r100);     // Catch: Exception -> L13
    L9:
        return r104;
    L8:
        tt5.a.k("OfflineDataManager", "Failed to update resource data and the result is " + r104);     // Catch: Exception -> L13
        goto L9
    L10:
        th = move-exception;
        r103.f501476a.endTransaction();     // Catch: Exception -> L13
        throw th;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    public final void I(m0 r100) {
        x25.f r101 = r100.f501560u;
        if (r101 != null) goto L5;
        return;
    L5:
        AtomicInteger r102 = r101.f562250a;
        if (r102 != null) goto L8;
        int r103 = 0;
    L9:
        r100.f501554o = r103;
        H(r100);
        return;
    L8:
        r103 = r102.get();
        goto L9
    }

    public final void e(String r100) {
        tt5.a.h("OfflineDataManager", "deleteFileModelByToken()... token = " + du5.b.g(r100));
        ((k25.a) LarkContext.spiByDwarf(k25.a.class)).a(Collections.singletonList(r100));
        ((j25.p) q().d()).c(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    public final void g(List r100) {
        tt5.a.h("OfflineDataManager", "deleteFileModelByTokenList()... tokens = " + du5.b.f(r100));
        ((k25.a) LarkContext.spiByDwarf(k25.a.class)).a(r100);     // Catch: Throwable -> L5
    L7:
        tt5.a.h("OfflineDataManager", "deleteFileModelByTokenList ret = " + ju5.c.a(r100, new i0(this), q()));
        return;
    L5:
        th = move-exception;
        tt5.a.e("OfflineDataManager", "clean comment draft by tokens error!", th, false);
        goto L7
    }

    public final void j(String r100) {
        tt5.a.b("OfflineDataManager", "OfflineDataManager.deleteResourceDataByDocToken: token = ");
        Flowable.just(r100).observeOn(fo5.d.b()).map(new n(this, r100)).subscribe(new y(), new z());
    }

    public final void k(List<String> r100) {
        tt5.a.b("OfflineDataManager", "OfflineDataManager.deleteResourceDataByDocTokenList");
        final long r101 = System.currentTimeMillis() - f501494f;
        Flowable.just(r100).observeOn(fo5.d.b()).map(new c0(this, r101)).subscribe(new d0(), new k25.f());
    }

    public final long t(j25.g r100) {
        j25.f r101 = (j25.f) q().c();     // Catch: Exception -> L9
        r101.f496972a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r101.f496972a.beginTransaction();     // Catch: Exception -> L9
        long r102 = r101.f496973b.insertAndReturnId(r100);     // Catch: Throwable -> L6
        r101.f496972a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r101.f496972a.endTransaction();     // Catch: Exception -> L9
        return r102;
    L6:
        th = move-exception;
        r101.f496972a.endTransaction();     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    public final long u(j25.q r100) {
        j25.p r101 = (j25.p) q().d();     // Catch: Exception -> L9
        r101.f496993a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r101.f496993a.beginTransaction();     // Catch: Exception -> L9
        long r102 = r101.f496995c.insertAndReturnId(r100);     // Catch: Throwable -> L6
        r101.f496993a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r101.f496993a.endTransaction();     // Catch: Exception -> L9
        return r102;
    L6:
        th = move-exception;
        r101.f496993a.endTransaction();     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    public final long[] v(List<j25.q> r100) {
        j25.p r101 = (j25.p) q().d();     // Catch: Exception -> L9
        r101.f496993a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r101.f496993a.beginTransaction();     // Catch: Exception -> L9
        long[] r102 = r101.f496994b.insertAndReturnIdsArray(r100);     // Catch: Throwable -> L6
        r101.f496993a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r101.f496993a.endTransaction();     // Catch: Exception -> L9
        return r102;
    L6:
        th = move-exception;
        r101.f496993a.endTransaction();     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        iu5.d.c(e);
        return new long[0];
    }

    public final Pair<Long, String> w(m0 r100) {
        m0 r101 = this.f501511a.b(r100.f501541b, r100.f501550k, r100);     // Catch: Exception -> L4
        r101.f501560u = new x25.f(r101.f501554o);     // Catch: Exception -> L4
        long r102 = q().e().d(this.f501512b.f(r100, true));     // Catch: Exception -> L4
        r101.f501540a = (int) r102;     // Catch: Exception -> L4
        return new Pair(Long.valueOf(r102), "");
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new Pair(-1L, e.getMessage());
    }

    public final j25.q x(String r100) {
        j25.q r101 = ((j25.p) q().d()).f(r100);     // Catch: Exception -> L4
        a(r101);     // Catch: Exception -> L4
        return r101;
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new j25.q();
    }

    public final j25.q y(String r100) {
        j25.h r101 = q().d();     // Catch: Exception -> L14
        String r102 = yu5.c.h(r100);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L7:
        String r103 = null;
    L9:
        if (TextUtils.isEmpty(r103) == true) goto L12;
        r100 = r103;
    L12:
        j25.q r104 = ((j25.p) r101).g(r100);     // Catch: Exception -> L14
        a(r104);     // Catch: Exception -> L14
        return r104;
    L5:
        if (UriProtector.parse(r102).getScheme() == null) goto L7;
        r103 = s45.p.a().s0(UriProtector.parse(r102).getPath());     // Catch: Exception -> L14
    L14:
        e = move-exception;
        iu5.d.c(e);
        return new j25.q();
    }

    public final List<j25.q> z(String r100) {
        List<j25.q> r101 = ((j25.p) q().d()).h(r100);     // Catch: Exception -> L10
        ArrayList r102 = (ArrayList) r101;     // Catch: Exception -> L10
        if (r102.isEmpty() == true) goto L9;
        Iterator r103 = r102.iterator();     // Catch: Exception -> L10
    L6:
        if (r103.hasNext() == false) goto L9;
        a((j25.q) r103.next());     // Catch: Exception -> L10
    L9:
        return r101;
    L10:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    public final List B(long r100, int r101) {
        ArrayList r102 = new ArrayList();
        Cursor r103 = q().getOpenHelper().getReadableDatabase().query("SELECT obj_token,resvalue_filepath,id,access_time FROM ResourceData WHERE access_time<= ? AND id > ? ORDER BY id ASC limit ?", new Object[]{Long.valueOf(r100), Integer.valueOf(r101), 999});
        int r104 = r103.getColumnIndexOrThrow("obj_token");     // Catch: Throwable -> L13
        int r105 = r103.getColumnIndexOrThrow(ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L13
        int r106 = r103.getColumnIndexOrThrow("id");     // Catch: Throwable -> L13
        int r107 = r103.getColumnIndexOrThrow(ResourceData.ACCESS_TIME);     // Catch: Throwable -> L13
    L4:
        if (r103.moveToNext() == false) goto L11;
        c1 r108 = new c1();     // Catch: Throwable -> L13
        r108.f501487c = r103.getString(r104);     // Catch: Throwable -> L13
        r108.f501485a = r103.getString(r105);     // Catch: Throwable -> L13
        r108.f501490f = r103.getInt(r106);     // Catch: Throwable -> L13
        if (r103.isNull(r107) == true) goto L9;
        r108.f501491g = Long.valueOf(r103.getLong(r107));     // Catch: Throwable -> L13
    L9:
        r102.add(r108);     // Catch: Throwable -> L13
        goto L4
    L11:
        r103.close();
        return r102;
    L13:
        th = move-exception;
        r103.close();
        throw th;
    }

    public final void f(String r100, String r101) {
        int r102 = ((j25.p) q().d()).d(r100, r101);     // Catch: Exception -> L4
    L6:
        tt5.a.h("OfflineDataManager", "deleteFileModelByTokenAndName token = " + du5.b.g(r100) + ", name =" + r101 + ", result = " + r102);
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
        r102 = -1;
        goto L6
    }

    public final int i(String r100, String r110) {
        this.f501511a.c(r100, r110);
        e1 r101 = this.f501512b;
        b1 r102 = (b1) q().e();
        r102.getClass();
        RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT id, resvalue_filepath FROM ResourceData WHERE obj_token=? and reskey= ?", 2);
        if (r100 != null) goto L5;
        r103.bindNull(1);
    L6:
        if (r110 != null) goto L8;
        r103.bindNull(2);
    L9:
        r102.f501476a.assertNotSuspendingTransaction();
        Cursor r104 = DBUtil.query(r102.f501476a, r103, false, null);
        int r105 = CursorUtil.getColumnIndexOrThrow(r104, "id");     // Catch: Throwable -> L17
        int r106 = CursorUtil.getColumnIndexOrThrow(r104, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L17
        ArrayList r107 = new ArrayList(r104.getCount());     // Catch: Throwable -> L17
    L12:
        if (r104.moveToNext() == false) goto L15;
        c1 r108 = new c1();     // Catch: Throwable -> L17
        r108.f501490f = r104.getInt(r105);     // Catch: Throwable -> L17
        r108.f501485a = r104.getString(r106);     // Catch: Throwable -> L17
        r107.add(r108);     // Catch: Throwable -> L17
        goto L12
    L15:
        r104.close();
        r103.release();
        r101.c(r107);
        return q().e().a(r100, r110, System.currentTimeMillis() - f501494f);
    L17:
        th = move-exception;
        r104.close();
        r103.release();
        throw th;
    L8:
        r103.bindString(2, r110);
        goto L9
    L5:
        r103.bindString(1, r100);
        goto L6
    }

    public final m0 n(String r100, String r101) {
        m0 r102 = this.f501511a.a(r100, r101, 0);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return new m0();
    }

    public final m0 s(String r100, String r101) {
        m0 r102 = this.f501511a.a(r100, r101, 0);     // Catch: Exception -> L13
        if (r102 != null) goto L5;
        m0 r103 = q().e().i(r101, r100, 0);     // Catch: Exception -> L13
        m0 r104 = this.f501512b.g(r103);     // Catch: Exception -> L13
        if (r104 != null) goto L17;
        return null;
    L17:
        return r104;
    L5:
        if (r102.f501560u != null) goto L7;
        r102.f501560u = new x25.f(r102.f501554o);     // Catch: Exception -> L13
    L7:
        return r102;
    L13:
        e = move-exception;
        iu5.d.c(e);
        return new m0();
    }

    public final m0 A(String r100, String r101, int r102) {
        m0 r103 = this.f501511a.a(r100, r101, r102);
        if (r103 == null) goto L12;
        return r103;
    L12:
        m0 r104 = q().e().i(r101, r100, r102);     // Catch: Exception -> L9
        m0 r105 = this.f501512b.g(r104);     // Catch: Exception -> L9
        if (r105 == null) goto L8;
        this.f501511a.b(r100, r101, r105);     // Catch: Exception -> L9
    L8:
        return r105;
    L9:
        e = move-exception;
        iu5.d.c(e);
        return new m0();
    }

    public final m0 C(String r100, String r101, int r102) {
        m0 r103 = this.f501511a.a(r101, r100, r102);
        if (r103 != null) goto L5;
    L14:
        m0 r104 = new m0();     // Catch: Exception -> L11
        f1 r105 = q().e().n(r101, r100, r102);     // Catch: Exception -> L11
        if (r105 == null) goto L10;
        r104.f501540a = r105.f501525a;     // Catch: Exception -> L11
        r104.f501554o = r105.f501526b;     // Catch: Exception -> L11
        r104.f501555p = r105.f501527c;     // Catch: Exception -> L11
        r104.f501556q = r105.f501528d;     // Catch: Exception -> L11
    L10:
        return r104;
    L11:
        e = move-exception;
        iu5.d.c(e);
        return new m0();
    L5:
        if (r103.f501540a <= 0) goto L14;
        return r103;
    }

    public final int F(long r100, String r101, Integer r102) {
        if (r102 != null) goto L5;
        int r103 = ((j25.f) q().c()).f(r100, r101);     // Catch: Exception -> L8
    L6:
        tt5.a.h("OfflineDataManager", "updateBitableFileProgressByPrimaryTaskKey rows " + r103);     // Catch: Exception -> L8
        return r103;
    L5:
        r103 = ((j25.f) q().c()).e(r100, r101, r102.intValue());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    public final int d(long r110, List r210, long r211) {
        HashSet r100 = new HashSet(r210);
        int r101 = 0;
        int r102 = 0;
    L3:
        List r103 = B(r110, r101);
        if (hu5.a.d(r103) == true) goto L45;
        int r104 = p(r103);
        if (r104 <= r101) goto L8;
        ArrayList r105 = new ArrayList();
        ArrayList r106 = (ArrayList) r103;
        Iterator r111 = r106.iterator();
    L11:
        if (r111.hasNext() == false) goto L17;
        c1 r112 = (c1) r111.next();
        if (r112 == null) goto L11;
        if (r100.contains(r112.f501487c) == true) goto L11;
        r105.add(r112);
        goto L11
    L17:
        tt5.a.h("OfflineDataManager", "cleanUpTimeMills deleteResourceDataList.size: " + r105.size());
        ArrayList r113 = new ArrayList();
        ArrayList r114 = new ArrayList();
        HashSet r115 = new HashSet();
        if (r105.size() <= 0) goto L41;
        Iterator r107 = r105.iterator();
    L21:
        if (r107.hasNext() == false) goto L33;
        c1 r116 = (c1) r107.next();
        String r117 = r116.f501487c;
        if (TextUtils.isEmpty(r117) == false) goto L25;
        r107 = r107;
    L32:
        r107 = r107;
        goto L21
    L25:
        if (r115.add(r117) == false) goto L29;
        r114.add(r117);
        this.f501511a.d(r117);
    L29:
        if (r116.f501491g.longValue() >= r211) goto L32;
        r113.add(r116);
        goto L32
    L33:
        tt5.a.h("OfflineDataManager", "cleanUpTimeMills tokenList.size: " + r114.size());
        tt5.a.h("OfflineDataManager", "cleanUpTimeMills filterDeleteResourceDataList.size: " + r113.size());
        if (r114.size() <= 0) goto L41;
        g(r114);
        ((k25.a) LarkContext.spiByDwarf(k25.a.class)).c(r114).subscribe(new k25.m(), new k25.n());     // Catch: Exception -> L38
    L38:
        e = move-exception;
        iu5.d.c(e);
    L41:
        if (r114.isEmpty() == true) goto L43;
        q().e().b(r114, r211);
    L43:
        this.f501512b.c(r113);
        r102 = r102 + r113.size();
        if (r106.size() < 999) goto L45;
        r101 = r104;
        goto L3
    L8:
        tt5.a.k("OfflineDataManager", "cleanUpTimeMills stop because cursor not moved, lastId: " + r101 + ", maxId: " + r104);
    L45:
        return r102;
    }

    public final long l(List r210, long r211, long r212) {
        HashSet r100 = new HashSet(r210);
        long r101 = 0;
        int r102 = 0;
    L3:
        List r103 = B(r211, r102);
        if (hu5.a.d(r103) == true) goto L44;
        int r110 = p(r103);
        if (r110 <= r102) goto L8;
        ArrayList r104 = new ArrayList();
        ArrayList r105 = (ArrayList) r103;
        Iterator r111 = r105.iterator();
    L11:
        if (r111.hasNext() == false) goto L17;
        c1 r112 = (c1) r111.next();
        if (r112 == null) goto L11;
        if (r100.contains(r112.f501487c) == true) goto L11;
        r104.add(r112);
        goto L11
    L17:
        tt5.a.h("OfflineDataManager", "deleteSyncDocument fetch deleteResourceDataList " + r104.size());
        ArrayList r113 = new ArrayList();
        if (r104.size() <= 0) goto L41;
        ArrayList r114 = new ArrayList();
        HashSet r115 = new HashSet();
        Iterator r106 = r104.iterator();
    L21:
        if (r106.hasNext() == false) goto L33;
        c1 r116 = (c1) r106.next();
        Iterator r213 = r106;
        String r107 = r116.f501487c;
        if (TextUtils.isEmpty(r107) == false) goto L25;
        r100 = r100;
    L32:
        r106 = r213;
        r100 = r100;
        goto L21
    L25:
        if (r115.add(r107) == false) goto L29;
        r114.add(r107);
        this.f501511a.d(r107);
    L29:
        if (r116.f501491g.longValue() >= r212) goto L32;
        r113.add(r116);
        goto L32
    L33:
        HashSet r117 = r100;
        if (r114.size() <= 0) goto L40;
        g(r114);
        ((k25.a) LarkContext.spiByDwarf(k25.a.class)).c(r114).subscribe(new k25.u(), new k25.v());     // Catch: Exception -> L38
    L38:
        e = move-exception;
        iu5.d.c(e);
    L40:
        tt5.a.h("OfflineDataManager", "deleteSyncDocument delete filemodel finished tokenList.size(): " + r114.size());
        q().e().b(r114, r212);
        this.f501512b.c(r113);
    L42:
        r101 = r101 + ((long) r113.size());
        if (r105.size() < 999) goto L44;
        r102 = r110;
        r100 = r117;
        goto L3
    L41:
        r117 = r100;
        goto L42
    L8:
        tt5.a.k("OfflineDataManager", "deleteSyncDocumentV2 stop because cursor not moved, lastId: " + r102 + ", maxId: " + r110);
    L44:
        tt5.a.h("OfflineDataManager", "deleteSyncDocument all task finished");
        return r101;
    }

    public final m0 o(AccountService$Account r100, String r101, String r102, Map r103) {
        return A(n35.a.b(r100, r102, r103), r101, 0);
    }

    public final void E(AccountService$Account r100, String r101, String r102, Map<String, String> r103, String r104) {
        if (r100 != null) goto L5;
        tt5.a.d("OfflineDataManager", "account is null");
        return;
    L5:
        String r105 = n35.a.b(r100, r102, r103);
        m0 r106 = new m0();
        r106.f501541b = r105;
        r106.f501550k = r101;
        r106.f501542c = r104;
        r106.f501558s = "native";
        this.f501511a.b(r105, r101, r106);
        q().e().d(r106);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        iu5.d.c(e);
    }
}
