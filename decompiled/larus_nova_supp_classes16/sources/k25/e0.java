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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e0 {
    public static volatile e0 e = null;
    public static long f = 5184000000L;
    public static com.larksuite.framework.thread.p g;
    public static final int h = 0;
    public static final k i = null;
    public static final o j = null;
    public static final p k = null;
    public static final q l = null;
    public static final r m = null;
    public static final u n = null;
    public static final v o = null;
    public static final a p = null;
    public static final f q = null;
    public static final g r = null;
    public static final h s = null;
    public static final i t = null;
    public static final j u = null;
    public static final l v = null;
    public final l0 a;
    public e1 b;
    public final Context c;
    public g0 d;

    public class a extends Migration {
        public a() {
            super(10, 11);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            tt5.a.b("OfflineDataManager", "exe migration from 10 -> 11");
        }
    }

    public class b extends Migration {
        public b() {
            super(11, 12);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE file_model ADD COLUMN new_upload_key TEXT");
        }
    }

    public class c extends Migration {
        public c() {
            super(12, 13);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE at_object ADD COLUMN sub_type INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class d extends Migration {
        public d() {
            super(13, 14);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE `file_model` ADD COLUMN uri TEXT NOT NULL DEFAULT ''");
        }
    }

    public class e extends Migration {
        public e() {
            super(14, 15);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `bitable_file_model` (`_id` INTEGER NOT NULL, `name` TEXT NOT NULL, `token` TEXT NOT NULL, `doc_url` TEXT, `table_id` TEXT, `field_id` TEXT, `record_id` TEXT, `path` TEXT NOT NULL, `uri` TEXT NOT NULL DEFAULT '', `mime_type` TEXT, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `upload_task_key` TEXT, `upload_progress` INTEGER NOT NULL, `attachment_token` TEXT, `is_camera_only` INTEGER NOT NULL,  PRIMARY KEY(`_id`))");
        }
    }

    public class f extends Migration {
        public f() {
            super(15, 16);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ResourceData ADD COLUMN page INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE ResourceData ADD COLUMN total_page INTEGER NOT NULL DEFAULT 1");
            r2.execSQL("ALTER TABLE ResourceData ADD COLUMN batch_num TEXT");
        }
    }

    public class g extends Migration {
        public g() {
            super(16, 17);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ResourceData ADD COLUMN load_from TEXT");
        }
    }

    public class h extends Migration {
        public h() {
            super(17, 18);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE INDEX IF NOT EXISTS index_ResourceData_reskey_obj_token_page ON ResourceData(reskey, obj_token, page)");
        }
    }

    public class i extends Migration {
        public i() {
            super(18, 19);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE at_object ADD COLUMN iconInfo TEXT NOT NULL DEFAULT ''");
        }
    }

    public class j extends Migration {
        public j() {
            super(19, 20);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ResourceData ADD COLUMN category TEXT");
        }
    }

    public class k extends Migration {
        public k() {
            super(1, 2);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ResourceData ADD COLUMN url TEXT");
        }
    }

    public class l extends Migration {
        public l() {
            super(20, 21);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DROP TABLE at_object");
        }
    }

    public class m extends RoomDatabase.Callback {
        public m() {
        }

        public final void onCreate(SupportSQLiteDatabase r2) {
            super.onCreate(r2);
            tt5.a.b("OfflineDataManager", "onCreate: ");
        }

        public final void onOpen(SupportSQLiteDatabase r2) {
            super.onOpen(r2);
            tt5.a.b("OfflineDataManager", "onOpen: ");
        }
    }

    public class n implements Function<String, Integer> {
        public final /* synthetic */ String a;
        public final /* synthetic */ e0 b;

        public final Object apply(Object r27) throws Exception {
            String r0 = (String) r27;
            long r2 = System.currentTimeMillis() - e0.f;
            b1 r4 = (b1) this.b.q().e();
            r4.getClass();
            RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE isNeedSync= ? and obj_token= ?", 2);
            r5.bindLong(1, 1);
            if (r0 != null) goto L5;
            r5.bindNull(2);
        L6:
            r4.a.assertNotSuspendingTransaction();
            Cursor r6 = DBUtil.query(r4.a, r5, false, null);
            int r10 = CursorUtil.getColumnIndexOrThrow(r6, "id");     // Catch: Throwable -> L59
            int r11 = CursorUtil.getColumnIndexOrThrow(r6, "reskey");     // Catch: Throwable -> L59
            int r12 = CursorUtil.getColumnIndexOrThrow(r6, "resvalue");     // Catch: Throwable -> L59
            int r13 = CursorUtil.getColumnIndexOrThrow(r6, "resvalue_filepath");     // Catch: Throwable -> L59
            int r14 = CursorUtil.getColumnIndexOrThrow(r6, "update_time");     // Catch: Throwable -> L59
            int r16 = CursorUtil.getColumnIndexOrThrow(r6, "access_time");     // Catch: Throwable -> L59
            int r8 = CursorUtil.getColumnIndexOrThrow(r6, "isNeedSync");     // Catch: Throwable -> L59
            int r9 = CursorUtil.getColumnIndexOrThrow(r6, "config");     // Catch: Throwable -> L59
            int r7 = CursorUtil.getColumnIndexOrThrow(r6, "type");     // Catch: Throwable -> L59
            int r17 = CursorUtil.getColumnIndexOrThrow(r6, "token");     // Catch: Throwable -> L59
            int r3 = CursorUtil.getColumnIndexOrThrow(r6, "obj_token");     // Catch: Throwable -> L59
            int r18 = CursorUtil.getColumnIndexOrThrow(r6, "userToken");     // Catch: Throwable -> L59
            int r1 = CursorUtil.getColumnIndexOrThrow(r6, "tenantID");     // Catch: Throwable -> L59
            int r19 = CursorUtil.getColumnIndexOrThrow(r6, "url");     // Catch: Throwable -> L56
            RoomSQLiteQuery r110 = r5;
            int r20 = CursorUtil.getColumnIndexOrThrow(r6, "subblock_preload_status");     // Catch: Throwable -> L54
            int r21 = CursorUtil.getColumnIndexOrThrow(r6, "page");     // Catch: Throwable -> L54
            int r22 = CursorUtil.getColumnIndexOrThrow(r6, "total_page");     // Catch: Throwable -> L54
            int r23 = CursorUtil.getColumnIndexOrThrow(r6, "batch_num");     // Catch: Throwable -> L54
            int r24 = CursorUtil.getColumnIndexOrThrow(r6, "load_from");     // Catch: Throwable -> L54
            int r26 = CursorUtil.getColumnIndexOrThrow(r6, "category");     // Catch: Throwable -> L54
            if (r6.moveToFirst() == false) goto L26;
            m0 r28 = new m0();     // Catch: Throwable -> L54
            r28.a = r6.getInt(r10);     // Catch: Throwable -> L54
            r28.b = r6.getString(r11);     // Catch: Throwable -> L54
            r28.c = r6.getString(r12);     // Catch: Throwable -> L54
            r28.d = r6.getString(r13);     // Catch: Throwable -> L54
            if (r6.isNull(r14) == false) goto L15;
            Long r111 = null;
        L16:
            r28.e = r111;     // Catch: Throwable -> L54
            if (r6.isNull(r16) == false) goto L19;
            Long r112 = null;
        L20:
            r28.f = r112;     // Catch: Throwable -> L54
            if (r6.getInt(r8) == 0) goto L23;
            boolean r29 = true;
        L24:
            r28.g = r29;     // Catch: Throwable -> L54
            r28.h = r6.getString(r9);     // Catch: Throwable -> L54
            r28.i = r6.getString(r7);     // Catch: Throwable -> L54
            r28.j = r6.getString(r17);     // Catch: Throwable -> L54
            r28.k = r6.getString(r3);     // Catch: Throwable -> L54
            r28.l = r6.getString(r18);     // Catch: Throwable -> L54
            r28.m = r6.getString(r1);     // Catch: Throwable -> L54
            r28.n = r6.getString(r19);     // Catch: Throwable -> L54
            r28.o = r6.getInt(r20);     // Catch: Throwable -> L54
            r28.p = r6.getInt(r21);     // Catch: Throwable -> L54
            r28.q = r6.getInt(r22);     // Catch: Throwable -> L54
            r28.r = r6.getString(r23);     // Catch: Throwable -> L54
            r28.s = r6.getString(r24);     // Catch: Throwable -> L54
            r28.t = r6.getString(r26);     // Catch: Throwable -> L54
            m0 r30 = r28;
        L27:
            r6.close();
            r110.release();
            if (idb.f.a().isEnable("ccm.mobile.db_error_optimization") == false) goto L32;
            if (r30 == null) goto L32;
            return -1;
        L32:
            this.b.a.d(r0);
            this.b.b.d(r0, r2);
            ArrayList r31 = (ArrayList) this.b.z(this.a);
            if (r31.size() <= 0) goto L43;
            this.b.e(this.a);
            Iterator r32 = r31.iterator();
        L36:
            if (r32.hasNext() == false) goto L43;
            j25.q r33 = (j25.q) r32.next();
            if (TextUtils.isEmpty(r33.d) == true) goto L36;
            Context r34 = this.b.c;
            VFSPath r36 = ay4.d.a().z(r33.d);
            Map r37 = FileUtils.a;
            if (r36.getRealPath().contains(AppInfoUtils.b(r34)) == true) goto L41;
            tt5.a.k("FileUtils", "safeDeleteFile, not allow to delete user files");
            goto L36
        L41:
            FileUtils.m(r36);
        L43:
            b1 r38 = (b1) this.b.q().e();
            r38.a.assertNotSuspendingTransaction();
            SupportSQLiteStatement r39 = r38.e.acquire();
            if (r0 != null) goto L46;
            r39.bindNull(1);
        L47:
            r39.bindLong(2, r2);
            r38.a.beginTransaction();
            int r40 = r39.executeUpdateDelete();     // Catch: Throwable -> L51
            r38.a.setTransactionSuccessful();     // Catch: Throwable -> L51
            r38.a.endTransaction();
            r38.e.release(r39);
            return Integer.valueOf(r40);
        L51:
            th = move-exception;
            r38.a.endTransaction();
            r38.e.release(r39);
            throw th;
        L46:
            r39.bindString(1, r0);
            goto L47
        L23:
            r29 = false;
            goto L24
        L19:
            r112 = Long.valueOf(r6.getLong(r16));     // Catch: Throwable -> L54
            goto L20
        L15:
            r111 = Long.valueOf(r6.getLong(r14));     // Catch: Throwable -> L54
            goto L16
        L26:
            r30 = null;
        L54:
            th = th;
        L61:
            r6.close();
            r110.release();
            throw th;
        L56:
            th = th;
        L58:
            r110 = r5;
        L59:
            th = th;
            goto L58
        L5:
            r5.bindString(2, r0);
            goto L6
        }

        public n(e0 r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class o extends Migration {
        public o() {
            super(2, 3);
        }

        public final void migrate(SupportSQLiteDatabase r3) {
            tt5.a.b("OfflineDataManager", "migrate_2_3()...");
            r3.execSQL("CREATE TABLE IF NOT EXISTS `file_model` (`name` TEXT NOT NULL, `token` TEXT NOT NULL, `doc_url` TEXT NOT NULL, `path` TEXT NOT NULL, `local_url` TEXT, `net_url` TEXT,  PRIMARY KEY(`name`, `token`))");
            r3.execSQL("CREATE TABLE IF NOT EXISTS `at_object` (`id` TEXT NOT NULL, `cn_name` TEXT, `en_name` TEXT, `name` TEXT, `title` TEXT, `type` INTEGER NOT NULL, `token` TEXT, `content` TEXT, `edit_time` TEXT, `owner` TEXT, `desc` TEXT, `count` TEXT, `url` TEXT, `department` TEXT, `avatar_url` TEXT, PRIMARY KEY(`id`))");
        }
    }

    public class p extends Migration {
        public p() {
            super(3, 4);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE `at_object` ADD COLUMN isExternal INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class q extends Migration {
        public q() {
            super(4, 5);
        }

        public final void migrate(SupportSQLiteDatabase r1) {
        }
    }

    public class r extends Migration {
        public r() {
            super(5, 6);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ResourceData ADD COLUMN resvalue_filepath TEXT");
        }
    }

    public class s extends Migration {
        public final /* synthetic */ e0 a;

        public s(e0 r2) {
            this.a = r2;
            super(6, 7);
        }

        public final void migrate(SupportSQLiteDatabase r8) {
            this.a.getClass();
            ArrayList r1 = (ArrayList) k25.d.b(r8);     // Catch: Exception -> L18
            if (r1.size() <= 0) goto L33;
            e1 r2 = new e1(new char[]{'$', '5', '2', '*', 'y', Symlink.UNIX_ID, 'q'}, true);     // Catch: Exception -> L18
            ArrayList r3 = new ArrayList();     // Catch: Exception -> L18
            ArrayList r4 = new ArrayList();     // Catch: Exception -> L18
            Iterator r5 = r1.iterator();     // Catch: Exception -> L18
        L7:
            if (r5.hasNext() == false) goto L16;
            m0 r6 = (m0) r5.next();     // Catch: Exception -> L18
            if (r6 == null) goto L7;
            if (TextUtils.isEmpty(r6.c) == false) goto L12;
            if (TextUtils.isEmpty(r6.d) == true) goto L7;
            r4.add(r6);     // Catch: Exception -> L18
            goto L7
        L12:
            r2.g(r6);     // Catch: Exception -> L18
            r3.add(r6);     // Catch: Exception -> L18
            goto L7
        L16:
            k25.d.c(r8, r3);     // Catch: Exception -> L18
            k25.d.a(r8, r4);     // Catch: Exception -> L18
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

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE file_model ADD COLUMN upload_key TEXT");
        }
    }

    public class u extends Migration {
        public u() {
            super(8, 9);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE ResourceData ADD COLUMN subblock_preload_status INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class v extends Migration {
        public v() {
            super(9, 10);
        }

        public final void migrate(SupportSQLiteDatabase r3) {
            tt5.a.b("OfflineDataManager", "exe migration from 9 -> 10");
            r3.execSQL("ALTER TABLE file_model ADD COLUMN file_modified_time INTEGER NOT NULL DEFAULT 0");
        }
    }

    public final synchronized OfflineDatabase q() {
        monitor-enter(this);
        OfflineDatabase r0 = (OfflineDatabase) DBController.a().r1("offlineData.db");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static e0 m() {
        if (e != null) goto L17;
        Application r0 = eu5.b.a;
        if (e != null) goto L17;
        monitor-enter(e0.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (e != null) goto L11;
        e = new e0(r0);     // Catch: Throwable -> L13
    L11:
        monitor-exit(e0.class);     // Catch: Throwable -> L13
    L17:
        return e;
    }

    public static Executor r() {
        if (g != null) goto L6;
        DocOpenConfig.a();
        int r3 = DocOpenConfig.g.fetch_core_pool_size;
        int r1 = h * 8;
        DocOpenConfig.a();
        int r4 = Math.max(r1, DocOpenConfig.g.fetch_max_pool_size);
        DocOpenConfig.a();
        g = new com.larksuite.framework.thread.p("BEAR_Offline_Data", r3, r4, DocOpenConfig.g.fetch_keep_alive_time, new SynchronousQueue(), new com.larksuite.framework.thread.n("OfflineData", 1));
    L6:
        return g;
    }

    public final void b() {
        List<c1> r1 = q().e().f();     // Catch: Exception -> L13
        if (hu5.a.d(r1) == false) goto L7;
        tt5.a.k("OfflineDataManager", "no dirty page data.");     // Catch: Exception -> L13
        return;
    L7:
        this.b.a(r1);     // Catch: Exception -> L13
        int r2 = 0;
    L8:
        ArrayList r3 = (ArrayList) r1;     // Catch: Exception -> L13
        if (r2 >= r3.size()) goto L11;
        c1 r4 = (c1) ListProtector.get(r1, r2);     // Catch: Exception -> L13
        this.a.c(r4.c, r4.e);     // Catch: Exception -> L13
        q().e().a(r4.c, r4.e, System.currentTimeMillis() - f);     // Catch: Exception -> L13
        r2 = r2 + 1;     // Catch: Exception -> L13
        goto L8
    L11:
        iu5.d.a("OfflineDataManager", new Throwable("cleanDirtyPageData size: " + r3.size()));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        tt5.a.l("OfflineDataManager", "Failed to cleanDirtyPageData, ", e);
    }

    public final void c() {
        VFSPath r0 = du5.c.a(this.c);
        if (r0 != null) goto L5;
    L17:
        tt5.a.h("OfflineDataManager", "Photo cache dir is not exist.");
        return;
    L5:
        if (r0.toFile().exists() == false) goto L17;
        long r1 = FileUtils.t(r0) - ((long) 800);     // Catch: Exception -> L14
        if (r1 <= 0) goto L22;
        List r2 = FileUtils.q(r0);     // Catch: Exception -> L14
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L23;
        FileUtils.m(((VFSFile) ListProtector.get(r2, r3)).getVfsPath());     // Catch: Exception -> L14
        r3 = r3 + 1;
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
        h = Runtime.getRuntime().availableProcessors();
        i = new k();
        j = new o();
        k = new p();
        l = new q();
        m = new r();
        n = new u();
        o = new v();
        p = new a();
        q = new f();
        r = new g();
        s = new h();
        t = new i();
        u = new j();
        v = new l();
    }

    public e0(Context r13) {
        Intrinsics.checkNotNullParameter("page_res_data_clean_flag", "name");
        Intrinsics.checkNotNullParameter(ay4.b.b("page_res_data_clean_flag", true, ay4.b.a("page_res_data_clean_flag")), "repo");
        new ArrayList();
        s r0 = new s(this);
        t r1 = new t();
        b r3 = new b();
        c r4 = new c();
        d r5 = new d();
        e r6 = new e();
        this.c = r13;
        this.a = new l0();
        f = ((long) ((OfflineCacheConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig())).getCategoryDeleteTimeout()) * 1000;
        tt5.a.h("OfflineDataManager", "OfflineDataManager sCategoryDeleteTimeout: " + f);
        m r7 = new m();
        DBController.a r8 = new DBController.a(r13);
        r8.a = "offlineData.db";
        r8.b = OfflineDatabase.class;
        r8.d = r7;
        r8.a(new Migration[]{i, j, k, l, m, r0, r1, n, o, p, r3, r4, r5, r6, q, r, s, t, u, v});
        DBController.a().W3("offlineData.db", r8);
        if (this.d != null) goto L5;
        this.d = new g0(this, r13);
    L5:
        DBController.a().x7(this.d);
        this.b = new e1(DBController.a().getKey().toCharArray(), false);
        MemoryCallbackManager.getInstance().registerMemoryCallback(new f0(this));
        Flowable.just("").observeOn(fo5.d.b()).subscribe(new b0(this));
        final long r2 = System.currentTimeMillis() - f;
        ((k25.a) LarkContext.spiByDwarf(k25.a.class)).m().observeOn(fo5.d.b()).map(new k25.e()).subscribe(new k25.g(this, r2), new k25.h());
    }

    public static String D(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L12;
        return r4;
    L12:
        String r0 = CipherManager.g(r4);     // Catch: CipherException -> L9
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        return r4;
    L9:
        e = move-exception;
        tt5.a.e("OfflineDataManager", "replacePersistentFilePath... err happens : " + e.getErrorCode(), e, false);
        return r4;
    }

    public static void a(j25.q r6) {
        if (r6 == null) goto L39;
        boolean r0 = TextUtils.isEmpty(r6.d);
        String r1 = r6.d;
        String r2 = r6.e;
        if (TextUtils.isEmpty(r1) == false) goto L7;
        r1 = r2;
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L38;
        Pair r3 = new Pair(Boolean.valueOf(r0), r1);
    L26:
        boolean r4 = ((Boolean) r3.first).booleanValue();
        String r5 = "";
        if (r4 == false) goto L29;
        String r7 = (String) r3.second;
    L30:
        r6.e = r7;
        if (r4 == true) goto L34;
        r5 = (String) r3.second;
    L34:
        r6.d = r5;
        return;
    L29:
        r7 = "";
        goto L30
    L38:
        if (r0 == false) goto L17;
        Uri r8 = UriProtector.parse(r1);     // Catch: DecryptException -> L24
        Application r9 = eu5.b.a;     // Catch: DecryptException -> L24
        int r10 = CipherManager.a;     // Catch: DecryptException -> L24
        Intrinsics.checkNotNullParameter(r8, "uri");     // Catch: DecryptException -> L24
        Uri r11 = CipherManager.b(r9, r8);     // Catch: DecryptException -> L15
        Pair r12 = new Pair(Boolean.TRUE, r11.toString());     // Catch: DecryptException -> L24
    L14:
        r3 = r12;
        goto L26
    L15:
        e = move-exception;
        throw e;     // Catch: DecryptException -> L24
    L17:
        PolarisFileWrapper r13 = CipherManager.e(ay4.d.a().i(r1), false);     // Catch: DecryptException -> L24
        if (TextUtils.isEmpty(r13.getAbsolutePath()) == true) goto L23;
        if (r13.exists() == false) goto L23;
        r12 = new Pair(Boolean.FALSE, r13.getAbsolutePath());     // Catch: DecryptException -> L24
    L23:
        r3 = new Pair(Boolean.FALSE, r1);     // Catch: DecryptException -> L24
    L24:
        e = move-exception;
        tt5.a.e("OfflineDataManager", "replaceTempDecryptFilePath... err happens : ", e, false);
        r3 = new Pair(Boolean.valueOf(r0), r1);
        goto L26
    }

    public static int p(List r2) {
        if (hu5.a.d(r2) == false) goto L5;
        return 0;
    L5:
        c1 r3 = (c1) ListProtector.get(r2, ((ArrayList) r2).size() - 1);
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.f;
    }

    public final void G(j25.q r4) {
        j25.p r1 = (j25.p) q().d();     // Catch: Exception -> L10
        r1.a.assertNotSuspendingTransaction();     // Catch: Exception -> L10
        r1.a.beginTransaction();     // Catch: Exception -> L10
        int r5 = r1.d.handle(r4) + 0;     // Catch: Throwable -> L7
        r1.a.setTransactionSuccessful();     // Catch: Throwable -> L7
        r1.a.endTransaction();     // Catch: Exception -> L10
        tt5.a.h("OfflineDataManager", "updateFileModel rows " + r5);     // Catch: Exception -> L10
        return;
    L7:
        th = move-exception;
        r1.a.endTransaction();     // Catch: Exception -> L10
        throw th;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        iu5.d.c(e);
    }

    public final int H(m0 r5) {
        n0 r1 = q().e();     // Catch: Exception -> L13
        m0 r2 = this.b.f(r5, true);     // Catch: Exception -> L13
        b1 r3 = (b1) r1;     // Catch: Exception -> L13
        r3.a.assertNotSuspendingTransaction();     // Catch: Exception -> L13
        r3.a.beginTransaction();     // Catch: Exception -> L13
        int r4 = r3.c.handle(r2) + 0;     // Catch: Throwable -> L10
        r3.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r3.a.endTransaction();     // Catch: Exception -> L13
        if (r4 <= 0) goto L8;
        this.a.b(r5.b, r5.k, r5);     // Catch: Exception -> L13
    L9:
        return r4;
    L8:
        tt5.a.k("OfflineDataManager", "Failed to update resource data and the result is " + r4);     // Catch: Exception -> L13
        goto L9
    L10:
        th = move-exception;
        r3.a.endTransaction();     // Catch: Exception -> L13
        throw th;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    public final void I(m0 r2) {
        x25.f r0 = r2.u;
        if (r0 != null) goto L5;
        return;
    L5:
        AtomicInteger r1 = r0.a;
        if (r1 != null) goto L8;
        int r3 = 0;
    L9:
        r2.o = r3;
        H(r2);
        return;
    L8:
        r3 = r1.get();
        goto L9
    }

    public final void e(String r3) {
        tt5.a.h("OfflineDataManager", "deleteFileModelByToken()... token = " + du5.b.g(r3));
        ((k25.a) LarkContext.spiByDwarf(k25.a.class)).a(Collections.singletonList(r3));
        ((j25.p) q().d()).c(r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }

    public final void g(List r5) {
        tt5.a.h("OfflineDataManager", "deleteFileModelByTokenList()... tokens = " + du5.b.f(r5));
        ((k25.a) LarkContext.spiByDwarf(k25.a.class)).a(r5);     // Catch: Throwable -> L5
    L7:
        tt5.a.h("OfflineDataManager", "deleteFileModelByTokenList ret = " + ju5.c.a(r5, new i0(this), q()));
        return;
    L5:
        th = move-exception;
        tt5.a.e("OfflineDataManager", "clean comment draft by tokens error!", th, false);
        goto L7
    }

    public final void j(String r3) {
        tt5.a.b("OfflineDataManager", "OfflineDataManager.deleteResourceDataByDocToken: token = ");
        Flowable.just(r3).observeOn(fo5.d.b()).map(new n(this, r3)).subscribe(new y(), new z());
    }

    public final void k(List<String> r5) {
        tt5.a.b("OfflineDataManager", "OfflineDataManager.deleteResourceDataByDocTokenList");
        final long r0 = System.currentTimeMillis() - f;
        Flowable.just(r5).observeOn(fo5.d.b()).map(new c0(this, r0)).subscribe(new d0(), new k25.f());
    }

    public final long t(j25.g r4) {
        j25.f r0 = (j25.f) q().c();     // Catch: Exception -> L9
        r0.a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r0.a.beginTransaction();     // Catch: Exception -> L9
        long r1 = r0.b.insertAndReturnId(r4);     // Catch: Throwable -> L6
        r0.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r0.a.endTransaction();     // Catch: Exception -> L9
        return r1;
    L6:
        th = move-exception;
        r0.a.endTransaction();     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    public final long u(j25.q r4) {
        j25.p r0 = (j25.p) q().d();     // Catch: Exception -> L9
        r0.a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r0.a.beginTransaction();     // Catch: Exception -> L9
        long r1 = r0.c.insertAndReturnId(r4);     // Catch: Throwable -> L6
        r0.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r0.a.endTransaction();     // Catch: Exception -> L9
        return r1;
    L6:
        th = move-exception;
        r0.a.endTransaction();     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    public final long[] v(List<j25.q> r3) {
        j25.p r0 = (j25.p) q().d();     // Catch: Exception -> L9
        r0.a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r0.a.beginTransaction();     // Catch: Exception -> L9
        long[] r4 = r0.b.insertAndReturnIdsArray(r3);     // Catch: Throwable -> L6
        r0.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r0.a.endTransaction();     // Catch: Exception -> L9
        return r4;
    L6:
        th = move-exception;
        r0.a.endTransaction();     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        iu5.d.c(e);
        return new long[0];
    }

    public final Pair<Long, String> w(m0 r5) {
        m0 r0 = this.a.b(r5.b, r5.k, r5);     // Catch: Exception -> L4
        r0.u = new x25.f(r0.o);     // Catch: Exception -> L4
        long r1 = q().e().d(this.b.f(r5, true));     // Catch: Exception -> L4
        r0.a = (int) r1;     // Catch: Exception -> L4
        return new Pair(Long.valueOf(r1), "");
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new Pair(-1L, e.getMessage());
    }

    public final j25.q x(String r2) {
        j25.q r3 = ((j25.p) q().d()).f(r2);     // Catch: Exception -> L4
        a(r3);     // Catch: Exception -> L4
        return r3;
    L4:
        e = move-exception;
        iu5.d.c(e);
        return new j25.q();
    }

    public final j25.q y(String r4) {
        j25.h r0 = q().d();     // Catch: Exception -> L14
        String r1 = yu5.c.h(r4);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        String r2 = null;
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L12;
        r4 = r2;
    L12:
        j25.q r5 = ((j25.p) r0).g(r4);     // Catch: Exception -> L14
        a(r5);     // Catch: Exception -> L14
        return r5;
    L5:
        if (UriProtector.parse(r1).getScheme() == null) goto L7;
        r2 = s45.p.a().s0(UriProtector.parse(r1).getPath());     // Catch: Exception -> L14
    L14:
        e = move-exception;
        iu5.d.c(e);
        return new j25.q();
    }

    public final List<j25.q> z(String r3) {
        List<j25.q> r4 = ((j25.p) q().d()).h(r3);     // Catch: Exception -> L10
        ArrayList r0 = (ArrayList) r4;     // Catch: Exception -> L10
        if (r0.isEmpty() == true) goto L9;
        Iterator r1 = r0.iterator();     // Catch: Exception -> L10
    L6:
        if (r1.hasNext() == false) goto L9;
        a((j25.q) r1.next());     // Catch: Exception -> L10
    L9:
        return r4;
    L10:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    public final List B(long r7, int r9) {
        ArrayList r0 = new ArrayList();
        Cursor r8 = q().getOpenHelper().getReadableDatabase().query("SELECT obj_token,resvalue_filepath,id,access_time FROM ResourceData WHERE access_time<= ? AND id > ? ORDER BY id ASC limit ?", new Object[]{Long.valueOf(r7), Integer.valueOf(r9), 999});
        int r10 = r8.getColumnIndexOrThrow("obj_token");     // Catch: Throwable -> L13
        int r11 = r8.getColumnIndexOrThrow("resvalue_filepath");     // Catch: Throwable -> L13
        int r1 = r8.getColumnIndexOrThrow("id");     // Catch: Throwable -> L13
        int r2 = r8.getColumnIndexOrThrow("access_time");     // Catch: Throwable -> L13
    L4:
        if (r8.moveToNext() == false) goto L11;
        c1 r3 = new c1();     // Catch: Throwable -> L13
        r3.c = r8.getString(r10);     // Catch: Throwable -> L13
        r3.a = r8.getString(r11);     // Catch: Throwable -> L13
        r3.f = r8.getInt(r1);     // Catch: Throwable -> L13
        if (r8.isNull(r2) == true) goto L9;
        r3.g = Long.valueOf(r8.getLong(r2));     // Catch: Throwable -> L13
    L9:
        r0.add(r3);     // Catch: Throwable -> L13
        goto L4
    L11:
        r8.close();
        return r0;
    L13:
        th = move-exception;
        r8.close();
        throw th;
    }

    public final void f(String r4, String r5) {
        int r0 = ((j25.p) q().d()).d(r4, r5);     // Catch: Exception -> L4
    L6:
        tt5.a.h("OfflineDataManager", "deleteFileModelByTokenAndName token = " + du5.b.g(r4) + ", name =" + r5 + ", result = " + r0);
        return;
    L4:
        e = move-exception;
        iu5.d.c(e);
        r0 = -1;
        goto L6
    }

    public final int i(String r9, String r10) {
        this.a.c(r9, r10);
        e1 r0 = this.b;
        b1 r1 = (b1) q().e();
        r1.getClass();
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT id, resvalue_filepath FROM ResourceData WHERE obj_token=? and reskey= ?", 2);
        if (r9 != null) goto L5;
        r2.bindNull(1);
    L6:
        if (r10 != null) goto L8;
        r2.bindNull(2);
    L9:
        r1.a.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(r1.a, r2, false, null);
        int r4 = CursorUtil.getColumnIndexOrThrow(r3, "id");     // Catch: Throwable -> L17
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "resvalue_filepath");     // Catch: Throwable -> L17
        ArrayList r6 = new ArrayList(r3.getCount());     // Catch: Throwable -> L17
    L12:
        if (r3.moveToNext() == false) goto L15;
        c1 r7 = new c1();     // Catch: Throwable -> L17
        r7.f = r3.getInt(r4);     // Catch: Throwable -> L17
        r7.a = r3.getString(r5);     // Catch: Throwable -> L17
        r6.add(r7);     // Catch: Throwable -> L17
        goto L12
    L15:
        r3.close();
        r2.release();
        r0.c(r6);
        return q().e().a(r9, r10, System.currentTimeMillis() - f);
    L17:
        th = move-exception;
        r3.close();
        r2.release();
        throw th;
    L8:
        r2.bindString(2, r10);
        goto L9
    L5:
        r2.bindString(1, r9);
        goto L6
    }

    public final m0 n(String r3, String r4) {
        m0 r5 = this.a.a(r3, r4, 0);
        if (r5 == null) goto L6;
        return r5;
    L6:
        return new m0();
    }

    public final m0 s(String r3, String r4) {
        m0 r0 = this.a.a(r3, r4, 0);     // Catch: Exception -> L13
        if (r0 != null) goto L5;
        m0 r5 = q().e().i(r4, r3, 0);     // Catch: Exception -> L13
        m0 r6 = this.b.g(r5);     // Catch: Exception -> L13
        if (r6 != null) goto L17;
        return null;
    L17:
        return r6;
    L5:
        if (r0.u != null) goto L7;
        r0.u = new x25.f(r0.o);     // Catch: Exception -> L13
    L7:
        return r0;
    L13:
        e = move-exception;
        iu5.d.c(e);
        return new m0();
    }

    public final m0 A(String r2, String r3, int r4) {
        m0 r0 = this.a.a(r2, r3, r4);
        if (r0 == null) goto L12;
        return r0;
    L12:
        m0 r5 = q().e().i(r3, r2, r4);     // Catch: Exception -> L9
        m0 r6 = this.b.g(r5);     // Catch: Exception -> L9
        if (r6 == null) goto L8;
        this.a.b(r2, r3, r6);     // Catch: Exception -> L9
    L8:
        return r6;
    L9:
        e = move-exception;
        iu5.d.c(e);
        return new m0();
    }

    public final m0 C(String r3, String r4, int r5) {
        m0 r0 = this.a.a(r4, r3, r5);
        if (r0 != null) goto L5;
    L14:
        m0 r1 = new m0();     // Catch: Exception -> L11
        f1 r6 = q().e().n(r4, r3, r5);     // Catch: Exception -> L11
        if (r6 == null) goto L10;
        r1.a = r6.a;     // Catch: Exception -> L11
        r1.o = r6.b;     // Catch: Exception -> L11
        r1.p = r6.c;     // Catch: Exception -> L11
        r1.q = r6.d;     // Catch: Exception -> L11
    L10:
        return r1;
    L11:
        e = move-exception;
        iu5.d.c(e);
        return new m0();
    L5:
        if (r0.a <= 0) goto L14;
        return r0;
    }

    public final int F(long r3, String r5, Integer r6) {
        if (r6 != null) goto L5;
        int r4 = ((j25.f) q().c()).f(r3, r5);     // Catch: Exception -> L8
    L6:
        tt5.a.h("OfflineDataManager", "updateBitableFileProgressByPrimaryTaskKey rows " + r4);     // Catch: Exception -> L8
        return r4;
    L5:
        r4 = ((j25.f) q().c()).e(r3, r5, r6.intValue());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        iu5.d.c(e);
        return -1;
    }

    public final int d(long r18, List r20, long r21) {
        HashSet r4 = new HashSet(r20);
        int r0 = 0;
        int r5 = 0;
    L3:
        List r8 = B(r18, r0);
        if (hu5.a.d(r8) == true) goto L45;
        int r9 = p(r8);
        if (r9 <= r0) goto L8;
        ArrayList r1 = new ArrayList();
        ArrayList r10 = (ArrayList) r8;
        Iterator r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L17;
        c1 r12 = (c1) r11.next();
        if (r12 == null) goto L11;
        if (r4.contains(r12.c) == true) goto L11;
        r1.add(r12);
        goto L11
    L17:
        tt5.a.h("OfflineDataManager", "cleanUpTimeMills deleteResourceDataList.size: " + r1.size());
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        HashSet r16 = new HashSet();
        if (r1.size() <= 0) goto L41;
        Iterator r2 = r1.iterator();
    L21:
        if (r2.hasNext() == false) goto L33;
        c1 r17 = (c1) r2.next();
        String r19 = r17.c;
        if (TextUtils.isEmpty(r19) == false) goto L25;
        r2 = r2;
    L32:
        r2 = r2;
        goto L21
    L25:
        if (r16.add(r19) == false) goto L29;
        r14.add(r19);
        this.a.d(r19);
    L29:
        if (r17.g.longValue() >= r21) goto L32;
        r13.add(r17);
        goto L32
    L33:
        tt5.a.h("OfflineDataManager", "cleanUpTimeMills tokenList.size: " + r14.size());
        tt5.a.h("OfflineDataManager", "cleanUpTimeMills filterDeleteResourceDataList.size: " + r13.size());
        if (r14.size() <= 0) goto L41;
        g(r14);
        ((k25.a) LarkContext.spiByDwarf(k25.a.class)).c(r14).subscribe(new k25.m(), new k25.n());     // Catch: Exception -> L38
    L38:
        e = move-exception;
        iu5.d.c(e);
    L41:
        if (r14.isEmpty() == true) goto L43;
        q().e().b(r14, r21);
    L43:
        this.b.c(r13);
        r5 = r5 + r13.size();
        if (r10.size() < 999) goto L45;
        r0 = r9;
        goto L3
    L8:
        tt5.a.k("OfflineDataManager", "cleanUpTimeMills stop because cursor not moved, lastId: " + r0 + ", maxId: " + r9);
    L45:
        return r5;
    }

    public final long l(List r20, long r21, long r23) {
        HashSet r4 = new HashSet(r20);
        long r5 = 0;
        int r0 = 0;
    L3:
        List r9 = B(r21, r0);
        if (hu5.a.d(r9) == true) goto L44;
        int r10 = p(r9);
        if (r10 <= r0) goto L8;
        ArrayList r1 = new ArrayList();
        ArrayList r11 = (ArrayList) r9;
        Iterator r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L17;
        c1 r13 = (c1) r12.next();
        if (r13 == null) goto L11;
        if (r4.contains(r13.c) == true) goto L11;
        r1.add(r13);
        goto L11
    L17:
        tt5.a.h("OfflineDataManager", "deleteSyncDocument fetch deleteResourceDataList " + r1.size());
        ArrayList r14 = new ArrayList();
        if (r1.size() <= 0) goto L41;
        ArrayList r16 = new ArrayList();
        HashSet r17 = new HashSet();
        Iterator r2 = r1.iterator();
    L21:
        if (r2.hasNext() == false) goto L33;
        c1 r18 = (c1) r2.next();
        Iterator r22 = r2;
        String r3 = r18.c;
        if (TextUtils.isEmpty(r3) == false) goto L25;
        r4 = r4;
    L32:
        r2 = r22;
        r4 = r4;
        goto L21
    L25:
        if (r17.add(r3) == false) goto L29;
        r16.add(r3);
        this.a.d(r3);
    L29:
        if (r18.g.longValue() >= r23) goto L32;
        r14.add(r18);
        goto L32
    L33:
        HashSet r19 = r4;
        if (r16.size() <= 0) goto L40;
        g(r16);
        ((k25.a) LarkContext.spiByDwarf(k25.a.class)).c(r16).subscribe(new k25.u(), new k25.v());     // Catch: Exception -> L38
    L38:
        e = move-exception;
        iu5.d.c(e);
    L40:
        tt5.a.h("OfflineDataManager", "deleteSyncDocument delete filemodel finished tokenList.size(): " + r16.size());
        q().e().b(r16, r23);
        this.b.c(r14);
    L42:
        r5 = r5 + ((long) r14.size());
        if (r11.size() < 999) goto L44;
        r0 = r10;
        r4 = r19;
        goto L3
    L41:
        r19 = r4;
        goto L42
    L8:
        tt5.a.k("OfflineDataManager", "deleteSyncDocumentV2 stop because cursor not moved, lastId: " + r0 + ", maxId: " + r10);
    L44:
        tt5.a.h("OfflineDataManager", "deleteSyncDocument all task finished");
        return r5;
    }

    public final m0 o(AccountService$Account r2, String r3, String r4, Map r5) {
        return A(n35.a.b(r2, r4, r5), r3, 0);
    }

    public final void E(AccountService$Account r1, String r2, String r3, Map<String, String> r4, String r5) {
        if (r1 != null) goto L5;
        tt5.a.d("OfflineDataManager", "account is null");
        return;
    L5:
        String r6 = n35.a.b(r1, r3, r4);
        m0 r7 = new m0();
        r7.b = r6;
        r7.k = r2;
        r7.c = r5;
        r7.s = "native";
        this.a.b(r6, r2, r7);
        q().e().d(r7);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        iu5.d.c(e);
    }
}
