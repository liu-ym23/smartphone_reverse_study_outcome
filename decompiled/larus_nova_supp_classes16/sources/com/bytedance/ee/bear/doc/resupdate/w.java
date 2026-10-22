package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.doc.resupdate.download.v2.RustDownloader;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.drive.v1.DownloadNormalRequest;
import com.bytedance.lark.pb.space.drive.v1.DownloadRequest;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipInputStream;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w implements i {
    public static final byte[] p = null;
    public final CompositeDisposable a;
    public final ConcurrentHashMap<String, a0> b;
    public final List<String> c;
    public final Map<String, String> d;
    public final Map<String, Long> e;
    public final Map<String, String> f;
    public Context g;
    public String h;
    public String i;
    public long j;
    public GeckoClient k;
    public final Queue<f0> l;
    public final AtomicBoolean m;
    public com.bytedance.ee.bear.contract.j n;
    public final cz4.b o;

    public class a extends cz4.a {
        public final /* synthetic */ GrayPackageConfig c;
        public final /* synthetic */ String d;
        public final /* synthetic */ w e;

        @Override // cz4.c
        public final void onFinished() {
            this.b = SystemClock.uptimeMillis();
            tt5.a.h("LocalResUpdateServiceImpl", "download gray res finish, hasDownload: true");     // Catch: Exception -> L5
            Context r2 = this.e.g;     // Catch: Exception -> L5
            VFSPath r3 = d0.c().getVfsPath().subPath(this.c.getVersion());     // Catch: Exception -> L5
            Context r4 = this.e.g;     // Catch: Exception -> L5
            VFSPath r5 = d0.d(this.d).getVfsPath();     // Catch: Exception -> L5
            w.l(this.e, this.c.getVersion(), r3, r5, false);     // Catch: Exception -> L5
            this.e.v(this.d, this.c.getVersion());     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            tt5.a.e("LocalResUpdateServiceImpl", "download gray res finish", e, false);
        }

        @Override // cz4.c
        public final void onStart() {
            this.a = SystemClock.uptimeMillis();
            tt5.a.h("LocalResUpdateServiceImpl", "download gray res start");
        }

        @Override // cz4.c
        public final void a(RustDownloader.RustDownloadException r4) {
            this.b = SystemClock.uptimeMillis();
            tt5.a.e("LocalResUpdateServiceImpl", "download gray res fail", r4, false);
        }

        public a(w r1, GrayPackageConfig r2, String r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public class b implements Consumer<Boolean> {
        public final /* synthetic */ cz4.d a;
        public final /* synthetic */ w b;

        public final void accept(Object r7) throws Exception {
            Boolean r8 = (Boolean) r7;
            if (this.b.j() == false) goto L5;
            tt5.a.h("LocalResUpdateServiceImpl", "accept(): already has full res");
            return;
        L5:
            g0 r9 = h0.a.a.c(this.b.g);
            tt5.a.b("LocalResUpdateServiceImpl", "accept(): revision = " + r9);
            w r0 = this.b;
            String r1 = r9.f;
            r0.getClass();
            String r2 = r1 + OfflineDoc.DASH_DELIMITER + eu5.g.h() + ".zip";
            if (((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).isChinaMainlandGeo() == true) goto L8;
            String r3 = r9.e;
        L9:
            cz4.b r4 = this.b.o;
            String r5 = d0.c().getAbsolutePath();
            z r6 = new z(this, r2, r9);
            r4.getClass();
            tt5.a.h("DownloadImpl", "download: url = " + r3);
            RustDownloader r10 = r4.a;
            r10.getClass();
            String r11 = (String) SdkSender.syncSend(Command.SUITE_DRIVE_DOWNLOAD_NORMAL, new DownloadNormalRequest.Builder().local_path(r5.concat(File.separator).concat(r2)).remote_url(r3).priority(Integer.valueOf(DrivePriority.DownloadPriority.PREVIEW.getPriority())).with_slice(Boolean.TRUE).api_type(DownloadRequest.ApiType.DRIVE), new dz4.a());
            tt5.a.h("DriveDownloader", "onStart, uniqueKey = " + r11);
            r6.onStart();
            ((ConcurrentHashMap) r10.a).put(r11, r6);
            return;
        L8:
            r3 = r9.d;
            goto L9
        }

        public b(w r1, cz4.d r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c implements Consumer<Throwable> {
        public final /* synthetic */ cz4.d a;
        public final /* synthetic */ w b;

        public final void accept(Object r4) throws Exception {
            tt5.a.e("LocalResUpdateServiceImpl", "downloadFullRes(): failed", (Throwable) r4, false);
            w.k(this.b, this.a);
        }

        public c(w r1, cz4.d r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d extends com.bytedance.ee.bear.doc.resupdate.d {
        public final /* synthetic */ w a;

        public d(w r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.doc.resupdate.d
        public final void onActivateSuccess(UpdatePackage r5) {
            super.onActivateSuccess(r5);
            final w r0 = this.a;
            final String r6 = r5.getChannel();
            r0.getClass();
            tt5.a.d("LocalResUpdateServiceImpl", "applyGeckoResource()");
            if (TextUtils.isEmpty(r6) == false) goto L5;
        L8:
            tt5.a.k("LocalResUpdateServiceImpl", "applyGeckoResource(): invalid channel");
            return;
        L5:
            if (((ArrayList) r0.c).contains(r6) == false) goto L8;
            Disposable r7 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new l(r0, r6), new m(r0, r6));
            r0.a.add(r7);
        }
    }

    public static class e {
        public static final w a = null;

        static {
            a = new w();
        }
    }

    static {
        p = new byte[0];
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void d(EChannel r1, a0 r2) {
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void e(EChannel r1, a0 r2) {
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void g() {
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final e0 getResource() {
        if (((HashMap) this.d).containsKey("DOC_CHANNEL") == true) goto L6;
        tt5.a.k("LocalResUpdateServiceImpl", "getResource() null: channel = DOC_CHANNEL");
        return new e0();
    L6:
        String r0 = (String) ((HashMap) this.d).get("DOC_CHANNEL");
        com.bytedance.ee.bear.doc.resupdate.b r1 = new com.bytedance.ee.bear.doc.resupdate.b();
        VFSFile r4 = d0.j("specific");     // Catch: IOException -> L29
        if (r4.list().length <= 0) goto L11;
        tt5.a.h("LocalResUpdateServiceImpl", "getResource, use specific");     // Catch: IOException -> L29
        return s(r4, r4.listFiles()[0].getName(), r0, r1);
    L11:
        com.bytedance.ee.bear.appsetting.c r5 = com.bytedance.ee.bear.appsetting.c.a.a;     // Catch: IOException -> L29
        boolean r6 = r5.i("spacekit.res.use_grayscale_package", false);     // Catch: IOException -> L29
        GrayPackageConfig r7 = (GrayPackageConfig) r5.c("grayscale_package_config", GrayPackageConfig.class, new GrayPackageConfig());     // Catch: IOException -> L29
        if (r6 == true) goto L14;
    L16:
        boolean r8 = false;
    L17:
        VFSFile r9 = d0.d(r0);     // Catch: IOException -> L29
        if (r8 == true) goto L20;
    L23:
        String r10 = d0.e(this.g, r0, false);     // Catch: IOException -> L29
        if (TextUtils.isEmpty(r10) == false) goto L27;
        tt5.a.h("LocalResUpdateServiceImpl", "getResource, use asset");     // Catch: IOException -> L29
        return q(r1);
    L27:
        tt5.a.h("LocalResUpdateServiceImpl", "getResource, use space_res");     // Catch: IOException -> L29
        return s(d0.j(r0), r10, r0, r1);
    L20:
        if (r9.list().length <= 0) goto L23;
        tt5.a.h("LocalResUpdateServiceImpl", "getResource, use gray");     // Catch: IOException -> L29
        return s(r9, r9.listFiles()[0].getName(), r0, r1);
    L14:
        if (TextUtils.isEmpty(r7.getVersion()) == true) goto L16;
        r8 = true;
    L29:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "getResourceRootDir: failed return defaultResource", e, false);
        return q(r1);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final boolean hasInit() {
        return this.m.get();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final boolean j() {
        return d0.l(this.g.getString(2131895998));
    }

    public final void n() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r1 = r0.i("spacekit.res.use_grayscale_package", false);
        GrayPackageConfig r2 = (GrayPackageConfig) r0.c("grayscale_package_config", GrayPackageConfig.class, new GrayPackageConfig());
        boolean r3 = true;
        if (r1 == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        tt5.a.h("LocalResUpdateServiceImpl", "checkGrayResource, useGray = " + r4);
        String r5 = this.g.getString(2131895998);
        if (r4 == false) goto L38;
        File[] r6 = d0.d(r5).listFiles();     // Catch: IOException -> L36
        if (r6 != null) goto L13;
    L21:
        boolean r8 = false;
    L22:
        if (r8 == true) goto L33;
        File[] r7 = d0.j(r5).listFiles();     // Catch: IOException -> L36
        if (r7 == null) goto L33;
        if (r7.length <= 0) goto L33;
        int r9 = r7.length;     // Catch: IOException -> L36
        int r10 = 0;
    L28:
        if (r10 >= r9) goto L33;
        File r11 = r7[r10];     // Catch: IOException -> L36
        if (r11.getName().contains(r2.getVersion()) == true) goto L31;
        r10 = r10 + 1;     // Catch: IOException -> L36
        goto L28
    L31:
        tt5.a.h("LocalResUpdateServiceImpl", "checkGrayResource, resource already exist in space_res");     // Catch: IOException -> L36
        VFSPath r12 = ay4.d.a().H(d0.d(r5), r11.getName() + "_temp");     // Catch: IOException -> L36
        FileUtils.g(r11.getVfsPath(), r12);     // Catch: IOException -> L36
        r12.toFile().renameTo(ay4.d.a().D(d0.d(r5), r11.getName()));     // Catch: IOException -> L36
        v(r5, r2.getVersion());     // Catch: IOException -> L36
    L34:
        if (r3 == true) goto L55;
        cz4.b r13 = this.o;     // Catch: IOException -> L36
        String r14 = r2.getUrl();     // Catch: IOException -> L36
        String r16 = d0.c().getAbsolutePath();     // Catch: IOException -> L36
        String r17 = r2.getVersion();     // Catch: IOException -> L36
        a r18 = new a(this, r2, r5);     // Catch: IOException -> L36
        r13.getClass();     // Catch: IOException -> L36
        tt5.a.h("DownloadImpl", "download: url = " + r14);     // Catch: IOException -> L36
        RustDownloader r19 = r13.a;     // Catch: IOException -> L36
        r19.getClass();     // Catch: IOException -> L36
        String r20 = (String) SdkSender.syncSend(Command.SUITE_DRIVE_DOWNLOAD_NORMAL, new DownloadNormalRequest.Builder().local_path(r16.concat(File.separator).concat(r17)).remote_url(r14).priority(Integer.valueOf(DrivePriority.DownloadPriority.PREVIEW.getPriority())).with_slice(Boolean.TRUE).api_type(DownloadRequest.ApiType.DRIVE), new dz4.a());     // Catch: IOException -> L36
        tt5.a.h("DriveDownloader", "onStart, uniqueKey = " + r20);     // Catch: IOException -> L36
        r18.onStart();     // Catch: IOException -> L36
        ((ConcurrentHashMap) r19.a).put(r20, r18);     // Catch: IOException -> L36
        return;
    L55:
        return;
    L33:
        r3 = r8;
        goto L34
    L13:
        if (r6.length <= 0) goto L21;
        int r21 = r6.length;     // Catch: IOException -> L36
        int r22 = 0;
        r8 = false;
    L15:
        if (r22 >= r21) goto L22;
        File r23 = r6[r22];     // Catch: IOException -> L36
        if (r23.getName().contains(r2.getVersion()) == false) goto L19;
        tt5.a.h("LocalResUpdateServiceImpl", "checkGrayResource, resource already exist in gray");     // Catch: IOException -> L36
        r8 = true;
    L20:
        r22 = r22 + 1;     // Catch: IOException -> L36
        goto L15
    L19:
        FileUtils.m(r23.getVfsPath());     // Catch: IOException -> L36
        goto L20
    L38:
        VFSFile[] r24 = d0.d(r5).listFiles();     // Catch: IOException -> L36
        if (r24 != null) goto L41;
        return;
    L41:
        if (r24.length <= 0) goto L58;
        int r26 = r24.length;     // Catch: IOException -> L36
        int r27 = 0;
    L43:
        if (r27 >= r26) goto L59;
        FileUtils.m(r24[r27].getVfsPath());     // Catch: IOException -> L36
        r27 = r27 + 1;
        goto L43
    L59:
        return;
    L58:
        return;
    L36:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "checkGrayResource fail", e, false);
        return;
    L5:
        if (TextUtils.isEmpty(r2.getVersion()) == true) goto L7;
        r4 = true;
        goto L8
    }

    public final void t() {
        if (this.k == null) goto L10;
        tt5.a.h("LocalResUpdateServiceImpl", "initGecko(): mGeckoClient has ready");
        return;
    L10:
        u();     // Catch: GeckoInitException -> L6
        n();     // Catch: GeckoInitException -> L6
        p(this.c);     // Catch: GeckoInitException -> L6
        return;
    L6:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "initGecko(): fail", e, false);
    }

    public final void u() throws GeckoInitException {
        if (this.k == null) goto L5;
        return;
    L5:
        String r0 = ((h) org.koin.java.a.a(h.class)).getDeviceId();
        this.h = r0;
        if (TextUtils.isEmpty(r0) == true) goto L14;
        if (TextUtils.isEmpty(((h) org.koin.java.a.a(h.class)).d()) == true) goto L12;
        GeckoConfig.Builder r1 = new GeckoConfig.Builder(this.g).accessKey(new String[]{this.i}).allLocalAccessKeys(new String[]{this.i}).appId(((h) org.koin.java.a.a(h.class)).getAppId()).host(((h) org.koin.java.a.a(h.class)).d()).appVersion(ApkUtil.getAppVersionName(this.g)).deviceId(this.h);
        int r2 = com.bytedance.ee.bear.doc.resupdate.c.a;
        this.k = GeckoClient.create(r1.resRootDir(com.bytedance.ee.bear.doc.resupdate.c.b(this.g)).needServerMonitor(false).statisticMonitor(new n()).build());
        GeckoLogger.enable();
        GeckoLogger.addLogger(new x());
        tt5.a.h("LocalResUpdateServiceImpl", "initGecko() finish: deviceId = " + this.h);
        return;
    L12:
        throw new GeckoInitException("gecko domain is invalid");
    L14:
        throw new GeckoInitException("deviceId is Empty!!!");
    }

    public w() {
        this.a = new CompositeDisposable();
        this.b = new ConcurrentHashMap();
        this.c = new ArrayList();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.j = 300000;
        this.l = new ConcurrentLinkedQueue();
        this.m = new AtomicBoolean(false);
        this.o = new cz4.b();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void a() {
        if (eu5.g.j() == true) goto L6;
        return;
    L6:
        if (this.m.get() == true) goto L9;
        tt5.a.k("LocalResUpdateServiceImpl", "checkUpdate, gecko hasn't init, ignore");
        return;
    L9:
        String r0 = (String) ((HashMap) this.d).get("DOC_CHANNEL");
        if (((HashMap) this.e).get(r0) == null) goto L12;
        long r2 = ((Long) ((HashMap) this.e).get(r0)).longValue();
    L14:
        if ((SystemClock.uptimeMillis() - r2) >= this.j) goto L16;
        tt5.a.h("LocalResUpdateServiceImpl", "checkUpdate，check update too frequently, ignore");
        return;
    L16:
        Map<String, Long> r1 = this.e;
        HashMap r3 = (HashMap) r1;
        r3.put(r0, Long.valueOf(SystemClock.uptimeMillis()));
        ArrayList r4 = new ArrayList();
        r4.add(r0);
        p(r4);
        return;
    L12:
        r2 = 0;
        goto L14
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void i() {
        if (eu5.g.j() == true) goto L5;
        return;
    L5:
        Disposable r0 = Flowable.just("").observeOn(fo5.d.a()).map(new k(this)).subscribe(new s(this), new t());
        this.a.add(r0);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void b(l35.c r4) {
        if (eu5.g.j() == true) goto L5;
        return;
    L5:
        if (((HashMap) this.d).containsKey("DOC_CHANNEL") == false) goto L10;
        this.b.put((String) ((HashMap) this.d).get("DOC_CHANNEL"), r4);
        return;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void c(Context r11) {
        if (eu5.g.j() == true) goto L5;
        return;
    L5:
        ml5.b r1 = new ml5.b("app_version");
        String r2 = ApkUtil.getAppVersionName(r11);
        String r4 = (String) r1.a("app_version_name", "");
        tt5.a.h("AppVersionHelper", "isUpgrade... savedVersion = " + r4 + ", versionName = " + r2);
        if (TextUtils.isEmpty(r4) == false) goto L8;
    L10:
        boolean r5 = false;
    L11:
        tt5.a.h("LocalResUpdateServiceImpl", "cleanResource(): versionName = " + r2 + ",upgrade = " + r5);
        if (r5 == true) goto L26;
        d0.e(r11, r11.getString(2131895998), true);
        return;
    L26:
        VFSFile r12 = d0.j(null);     // Catch: IOException -> L22
        final VFSFile r6 = ay4.d.a().i(r12.getAbsolutePath() + OfflineDoc.DASH_DELIMITER + System.currentTimeMillis());     // Catch: IOException -> L22
        if (r12.renameTo(r6) == false) goto L17;
        tt5.a.b("LocalResUpdateServiceImpl", "cleanResource root dir " + r6);     // Catch: IOException -> L22
        this.a.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new y(this, r6), new o(r6)));     // Catch: IOException -> L22
    L19:
        if (TextUtils.isEmpty(r2) == true) goto L28;
        r1.b("app_version_name", r2);     // Catch: IOException -> L22
        return;
    L28:
        return;
    L17:
        tt5.a.k("LocalResUpdateServiceImpl", "cleanResource: rename res root dir failed ");     // Catch: IOException -> L22
    L22:
        e = move-exception;
        tt5.a.i("LocalResUpdateServiceImpl", "cleanResource() dir failed ", e);
        return;
    L8:
        if (TextUtils.equals(r4, r2) == true) goto L10;
        r5 = true;
        goto L11
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void h(f0 r4) {
        if ((r4 instanceof cz4.d) == true) goto L5;
        r4 = new cz4.d(r4);
    L5:
        cz4.d r5 = (cz4.d) r4;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.full_pkg_included") == false) goto L9;
        tt5.a.h("LocalResUpdateServiceImpl", "downloadFullRes ignore, full pkg included");
        r5.onReady();
        return;
    L9:
        tt5.a.h("LocalResUpdateServiceImpl", "downloadFullRes, retryCount = " + r5.b);
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.c()).subscribe(new b(this, r5), new c(this, r5));
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void init(Context r6) {
        if (this.m.get() == false) goto L6;
        tt5.a.h("LocalResUpdateServiceImpl", "has init ");
        return;
    L6:
        this.g = r6.getApplicationContext();
        tt5.a.h("LocalResUpdateServiceImpl", "initConfig(): ");
        com.ss.android.lark.storage.a r0 = ay4.b.a;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter("privatizationConfig", "name");
        ay4.b.b("privatizationConfig", true, ay4.b.a("privatizationConfig"));
        this.i = com.bytedance.ee.bear.doc.resupdate.c.a(r6, false);
        this.j = ((h) org.koin.java.a.a(h.class)).c();
        String r7 = this.g.getString(2131895998);
        ((ArrayList) this.c).add(r7);
        ((HashMap) this.f).put(r7, "eesz");
        ((HashMap) this.d).put("DOC_CHANNEL", r7);
        this.n = com.bytedance.ee.bear.contract.j.a.a;
        com.bytedance.ee.util.ui.m.d(new j(this));
        if (((h) org.koin.java.a.a(h.class)).isEnable("ccm.ka.gurd_fix_enable") == true) goto L11;
        tt5.a.h("LocalResUpdateServiceImpl", "feature switch close");
        return;
    L11:
        if (eu5.g.j() == false) goto L13;
        Disposable r8 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).delay(5, TimeUnit.SECONDS).subscribe(new v(this));
        this.a.add(r8);
    L13:
        this.m.set(true);
        tt5.a.h("LocalResUpdateServiceImpl", "init(): ");
    }

    public final void o(String r4) {
        int r0 = com.bytedance.ee.bear.doc.resupdate.c.a;     // Catch: IOException -> L4
        FileUtils.p(com.bytedance.ee.bear.doc.resupdate.c.b(this.g).getVfsPath().subPath(this.i).subPath(r4));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "clearGeckoRecordByChannel() failed ", e, false);
    }

    public final void p(List<String> r6) {
        tt5.a.h("LocalResUpdateServiceImpl", "checkUpdate(): " + r6);
        com.bytedance.ee.bear.contract.j r0 = this.n;
        if (r0 == null) goto L9;
        if (r0.getNetworkState().a() == true) goto L9;
        tt5.a.h("LocalResUpdateServiceImpl", "checkUpdate(): channel stop cause isn't connected");
        return;
    L9:
        if (this.k != null) goto L12;
        tt5.a.d("LocalResUpdateServiceImpl", "checkUpdate(): GeckoClient == null");
        return;
    L12:
        String r1 = this.i;
        HashMap r2 = new HashMap();
        ArrayList r3 = new ArrayList();
        Iterator r7 = ((ArrayList) r6).iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        r3.add(new CheckRequestBodyModel.TargetChannel((String) r7.next()));
        goto L14
    L16:
        r2.put(r1, r3);
        this.k.checkUpdateMulti(r2, new d(this));
    }

    public final e0 q(com.bytedance.ee.bear.doc.resupdate.e r4) {
        VFSPath r0 = r4.a(this.g);
        if (r0 != null) goto L5;
        r0 = r4.a(this.g);
    L5:
        String r5 = d0.f(r0);
        return new e0(r0.toFile(), r5, null);
    }

    public final VFSPath r(String r4) throws IOException {
        if (((HashMap) this.f).containsKey(r4) == false) goto L20;
        int r0 = com.bytedance.ee.bear.doc.resupdate.c.a;
        String r1 = ResLoadUtils.getChannelPath(com.bytedance.ee.bear.doc.resupdate.c.b(this.g), this.i, r4);
        if (r1 == null) goto L18;
        VFSFile r2 = ay4.d.a().i(r1);
        if (r2.exists() == false) goto L16;
        VFSPath r5 = ay4.d.a().H(r2, (String) ((HashMap) this.f).get(r4));
        tt5.a.h("LocalResUpdateServiceImpl", "getGeckoDirResource: " + r5.toFile().getPath());
        if (r5.toFile().exists() == false) goto L14;
        if (r5.toFile().isDirectory() == false) goto L14;
        return r5;
    L14:
        throw new IOException("getGeckoDirResource()... resFolder is not exist or not is directory");
    L16:
        throw new IOException("getGeckoDirResource()...channel ->" + r4 + " channelFile not exists()");
    L18:
        throw new IOException("getGeckoDirResource()...channel ->" + r4 + " path is null");
    L20:
        throw new IOException("getGeckoDirResource()...channel ->" + r4 + "not found template dir");
    }

    public static void k(final w r5, final cz4.d r6) {
        r5.getClass();
        int r0 = r6.b;
        if (r0 != 3) goto L5;
        r6.onFail();
        return;
    L5:
        Flowable.timer((int) (Math.pow(2.0d, r0) * 30.0d), TimeUnit.SECONDS).subscribe(new p(r5, r6), new q());
        r6.b = r0 + 1;
    }

    public final void v(String r2, String r3) {
        a0 r4 = this.b.get(r2);
        if (r4 == null) goto L5;
        r4.a(r3);
        return;
    L5:
        tt5.a.d("LocalResUpdateServiceImpl", "transferToSD(): cancel cause updateListener is null");
    }

    public final void w(String r7, String r8) throws Exception {
        VFSPath r0 = r(r7);
        VFSFile r1 = d0.j(r7);
        VFSFile r2 = ay4.d.a().D(r1, r8 + "_temp");
        StringBuilder r3 = new StringBuilder("transferToSD tempFile = ");
        r3.append(r2);
        tt5.a.b("LocalResUpdateServiceImpl", r3.toString());
        if (r2.exists() == false) goto L6;
        FileUtils.p(r2.getVfsPath());
        tt5.a.h("LocalResUpdateServiceImpl", "transferToSD(): delete exists tempFile = " + r8);
    L6:
        if (r2.mkdir() == false) goto L14;
        FileUtils.g(r0, ay4.d.a().H(r2, (String) ((HashMap) this.f).get(r7)));
        if (r2.renameTo(ay4.d.a().D(r1, r8)) == false) goto L12;
        tt5.a.h("LocalResUpdateServiceImpl", "transferToSD(): success");
        v(r7, r8);
        return;
    L12:
        throw new IOException("transferToSD(): rename folder failed");
    L14:
        throw new IOException("transferToSD(): tempFile mkdir failed");
    }

    public final e0 s(VFSFile r6, String r7, String r8, com.bytedance.ee.bear.doc.resupdate.e r9) throws IOException {
        VFSPath r10 = r6.getVfsPath().subPath(r7);
        VFSPath r0 = r10.subPath(r9.b());
        tt5.a.b("LocalResUpdateServiceImpl", "getResourceInternal, res = " + r0);
        boolean r1 = new com.bytedance.ee.bear.doc.resupdate.a(r7, r8).b(r0);
        tt5.a.h("LocalResUpdateServiceImpl", "getResourceInternal, md5 check completion = " + r1);
        if (r1 == true) goto L5;
        o(r8);
        FileUtils.m(r10);
    L5:
        if (r1 == false) goto L8;
        return new e0(r0.toFile(), r7, null);
    L8:
        return q(r9);
    }

    public static void l(w r3, String r4, VFSPath r5, VFSPath r6, boolean r7) throws Exception {
        r3.getClass();
        if (r5.toFile().exists() == false) goto L31;
        ZipInputStream r0 = new ZipInputStream(r5.toFile().newInputStream());
        String r8 = r3.g.getString(2131895998);
        if (r7 == false) goto L7;
        r8 = EChannel.DOCS_FULLPKG_CHANNEL.toString();
    L7:
        com.bytedance.ee.util.io.f.a(r0, r6.getRealPath());
        com.bytedance.ee.bear.doc.resupdate.a r9 = new com.bytedance.ee.bear.doc.resupdate.a(r4, r8);
        VFSPath r10 = r6.subPath(r8);
        if (r9.b(r10.subPath("eesz")) == true) goto L36;
        FileUtils.p(r10);     // Catch: IOException -> L26
    L29:
        throw new IOException("zip is not compelete");
    L26:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "deleteFile():failed", e, false);
        goto L29
    L36:
        FileUtils.p(r5);     // Catch: IOException -> L11
    L13:
        File r11 = r6.subPath(r4).toFile();
        if (r11.exists() == false) goto L20;
        FileUtils.p(r10);     // Catch: IOException -> L17
        return;
    L17:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "deleteFile():failed", e, false);
        return;
    L20:
        if (r10.toFile().renameTo(r11) == false) goto L23;
        return;
    L23:
        throw new IOException("rename failed!!!");
    L11:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "deleteFile():failed", e, false);
        goto L13
    L31:
        throw new IOException("zip is not exist");
    }

    public static void m(w r5, long r6, boolean r8, String r9, int r10) {
        r5.getClass();
        JSONObject r2 = new JSONObject();
        r2.put("duration_ms", r6);     // Catch: JSONException -> L12
        r2.put("is_success", r8);     // Catch: JSONException -> L12
        r2.put("errorMsg", r9);     // Catch: JSONException -> L12
        r2.put("retry_count", r10);     // Catch: JSONException -> L12
        if (r10 >= 3) goto L6;
        boolean r7 = true;
    L7:
        r2.put("can_retry", String.valueOf(r7));     // Catch: JSONException -> L12
        r2.put("downloader", "rust");     // Catch: JSONException -> L12
        com.bytedance.ee.bear.contract.j r11 = r5.n;     // Catch: JSONException -> L12
        if (r11 == null) goto L10;
        r2.put("doc_network_status", r11.getNetworkState().getType());     // Catch: JSONException -> L12
    L10:
        tt5.a.b("LocalResUpdateServiceImpl", "trackDownloadEvent, params = " + r2);     // Catch: JSONException -> L12
    L14:
        ((h) org.koin.java.a.a(h.class)).a("docs_dev_fullPackage_download_duration", r2);
        return;
    L6:
        r7 = false;
    L12:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "trackDownloadEvent failed", e, false);
        goto L14
    }
}
