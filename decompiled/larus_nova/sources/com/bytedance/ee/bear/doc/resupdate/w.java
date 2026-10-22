package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeWatch;
import com.bytedance.ee.bear.doc.resupdate.download.v2.RustDownloader;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$DownloadPriority;
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
import com.larus.nova.R;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
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

/* JADX INFO: loaded from: classes16.dex */
public final class w implements i {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte[] f218031p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f218032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, a0> f218033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f218034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f218035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Long> f218036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f218037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f218038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f218039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f218040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f218041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public GeckoClient f218042k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Queue<f0> f218043l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f218044m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ee.bear.contract.j f218045n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final cz4.b f218046o;

    public class a extends cz4.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GrayPackageConfig f218047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f218048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ w f218049e;

        @Override // cz4.c
        public final void onFinished() {
            this.f466046b = SystemClock.uptimeMillis();
            tt5.a.h("LocalResUpdateServiceImpl", "download gray res finish, hasDownload: true");     // Catch: Exception -> L5
            Context r100 = this.f218049e.f218038g;     // Catch: Exception -> L5
            VFSPath r101 = d0.c().getVfsPath().subPath(this.f218047c.getVersion());     // Catch: Exception -> L5
            Context r102 = this.f218049e.f218038g;     // Catch: Exception -> L5
            VFSPath r103 = d0.d(this.f218048d).getVfsPath();     // Catch: Exception -> L5
            w.l(this.f218049e, this.f218047c.getVersion(), r101, r103, false);     // Catch: Exception -> L5
            this.f218049e.v(this.f218048d, this.f218047c.getVersion());     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            tt5.a.e("LocalResUpdateServiceImpl", "download gray res finish", e, false);
        }

        @Override // cz4.c
        public final void onStart() {
            this.f466045a = SystemClock.uptimeMillis();
            tt5.a.h("LocalResUpdateServiceImpl", "download gray res start");
        }

        @Override // cz4.c
        public final void a(RustDownloader.RustDownloadException r100) {
            this.f466046b = SystemClock.uptimeMillis();
            tt5.a.e("LocalResUpdateServiceImpl", "download gray res fail", r100, false);
        }

        public a(w r100, GrayPackageConfig r101, String r102) {
            this.f218049e = r100;
            this.f218047c = r101;
            this.f218048d = r102;
        }
    }

    public class b implements Consumer<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cz4.d f218050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f218051b;

        @Override // io.reactivex.functions.Consumer
        public final void accept(Boolean r100) throws Exception {
            if (this.f218051b.j() == false) goto L5;
            tt5.a.h("LocalResUpdateServiceImpl", "accept(): already has full res");
            return;
        L5:
            g0 r101 = h0.a.f218018a.c(this.f218051b.f218038g);
            tt5.a.b("LocalResUpdateServiceImpl", "accept(): revision = " + r101);
            w r102 = this.f218051b;
            String r103 = r101.f218015f;
            r102.getClass();
            String r104 = r103 + "_" + eu5.g.h() + ".zip";
            if (((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).isChinaMainlandGeo() == true) goto L8;
            String r105 = r101.f218014e;
        L9:
            cz4.b r106 = this.f218051b.f218046o;
            String r107 = d0.c().getAbsolutePath();
            z r108 = new z(this, r104, r101);
            r106.getClass();
            tt5.a.h("DownloadImpl", "download: url = " + r105);
            RustDownloader r109 = r106.f466047a;
            r109.getClass();
            String r110 = (String) SdkSender.syncSend(Command.SUITE_DRIVE_DOWNLOAD_NORMAL, new DownloadNormalRequest.Builder().local_path(r107.concat(File.separator).concat(r104)).remote_url(r105).priority(Integer.valueOf(DrivePriority$DownloadPriority.PREVIEW.getPriority())).with_slice(Boolean.TRUE).api_type(DownloadRequest.ApiType.DRIVE), new dz4.a());
            tt5.a.h("DriveDownloader", "onStart, uniqueKey = " + r110);
            r108.onStart();
            ((ConcurrentHashMap) r109.f218005a).put(r110, r108);
            return;
        L8:
            r105 = r101.f218013d;
            goto L9
        }

        public b(w r100, cz4.d r101) {
            this.f218051b = r100;
            this.f218050a = r101;
        }
    }

    public class c implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cz4.d f218052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f218053b;

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            tt5.a.e("LocalResUpdateServiceImpl", "downloadFullRes(): failed", r100, false);
            w.k(this.f218053b, this.f218052a);
        }

        public c(w r100, cz4.d r101) {
            this.f218053b = r100;
            this.f218052a = r101;
        }
    }

    public class d extends com.bytedance.ee.bear.doc.resupdate.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f218054a;

        public d(w r100) {
            this.f218054a = r100;
        }

        @Override // com.bytedance.ee.bear.doc.resupdate.d, com.bytedance.geckox.listener.GeckoUpdateListener
        public final void onActivateSuccess(UpdatePackage r100) {
            super.onActivateSuccess(r100);
            final w r101 = this.f218054a;
            final String r102 = r100.getChannel();
            r101.getClass();
            tt5.a.d("LocalResUpdateServiceImpl", "applyGeckoResource()");
            if (TextUtils.isEmpty(r102) == false) goto L5;
        L8:
            tt5.a.k("LocalResUpdateServiceImpl", "applyGeckoResource(): invalid channel");
            return;
        L5:
            if (((ArrayList) r101.f218034c).contains(r102) == false) goto L8;
            Disposable r103 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new l(r101, r102), new m(r101, r102));
            r101.f218032a.add(r103);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f218055a = null;

        static {
            f218055a = new w();
        }
    }

    static {
        f218031p = new byte[0];
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void d(EChannel r100, a0 r101) {
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void e(EChannel r100, a0 r101) {
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void g() {
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final e0 getResource() {
        if (((HashMap) this.f218035d).containsKey("DOC_CHANNEL") == true) goto L6;
        tt5.a.k("LocalResUpdateServiceImpl", "getResource() null: channel = DOC_CHANNEL");
        return new e0();
    L6:
        String r100 = (String) ((HashMap) this.f218035d).get("DOC_CHANNEL");
        com.bytedance.ee.bear.doc.resupdate.b r101 = new com.bytedance.ee.bear.doc.resupdate.b();
        VFSFile r102 = d0.j(ModifiedTimeWatch.WATCH_TYPE_SPECIFIC);     // Catch: IOException -> L29
        if (r102.list().length <= 0) goto L11;
        tt5.a.h("LocalResUpdateServiceImpl", "getResource, use specific");     // Catch: IOException -> L29
        return s(r102, r102.listFiles()[0].getName(), r100, r101);
    L11:
        com.bytedance.ee.bear.appsetting.c r103 = com.bytedance.ee.bear.appsetting.c.a.f206237a;     // Catch: IOException -> L29
        boolean r104 = r103.i("spacekit.res.use_grayscale_package", false);     // Catch: IOException -> L29
        GrayPackageConfig r105 = (GrayPackageConfig) r103.c("grayscale_package_config", GrayPackageConfig.class, new GrayPackageConfig());     // Catch: IOException -> L29
        if (r104 == true) goto L14;
    L16:
        boolean r106 = false;
    L17:
        VFSFile r107 = d0.d(r100);     // Catch: IOException -> L29
        if (r106 == true) goto L20;
    L23:
        String r108 = d0.e(this.f218038g, r100, false);     // Catch: IOException -> L29
        if (TextUtils.isEmpty(r108) == false) goto L27;
        tt5.a.h("LocalResUpdateServiceImpl", "getResource, use asset");     // Catch: IOException -> L29
        return q(r101);
    L27:
        tt5.a.h("LocalResUpdateServiceImpl", "getResource, use space_res");     // Catch: IOException -> L29
        return s(d0.j(r100), r108, r100, r101);
    L20:
        if (r107.list().length <= 0) goto L23;
        tt5.a.h("LocalResUpdateServiceImpl", "getResource, use gray");     // Catch: IOException -> L29
        return s(r107, r107.listFiles()[0].getName(), r100, r101);
    L14:
        if (TextUtils.isEmpty(r105.getVersion()) == true) goto L16;
        r106 = true;
    L29:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "getResourceRootDir: failed return defaultResource", e, false);
        return q(r101);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final boolean hasInit() {
        return this.f218044m.get();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final boolean j() {
        return d0.l(this.f218038g.getString(R.string.config_gecko_channel));
    }

    public final void n() {
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        boolean r101 = r100.i("spacekit.res.use_grayscale_package", false);
        GrayPackageConfig r102 = (GrayPackageConfig) r100.c("grayscale_package_config", GrayPackageConfig.class, new GrayPackageConfig());
        boolean r103 = true;
        if (r101 == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        tt5.a.h("LocalResUpdateServiceImpl", "checkGrayResource, useGray = " + r104);
        String r105 = this.f218038g.getString(R.string.config_gecko_channel);
        if (r104 == false) goto L38;
        VFSFile[] r106 = d0.d(r105).listFiles();     // Catch: IOException -> L36
        if (r106 != null) goto L13;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == true) goto L33;
        VFSFile[] r108 = d0.j(r105).listFiles();     // Catch: IOException -> L36
        if (r108 == null) goto L33;
        if (r108.length <= 0) goto L33;
        int r109 = r108.length;     // Catch: IOException -> L36
        int r110 = 0;
    L28:
        if (r110 >= r109) goto L33;
        VFSFile r111 = r108[r110];     // Catch: IOException -> L36
        if (r111.getName().contains(r102.getVersion()) == true) goto L31;
        r110 = r110 + 1;     // Catch: IOException -> L36
        goto L28
    L31:
        tt5.a.h("LocalResUpdateServiceImpl", "checkGrayResource, resource already exist in space_res");     // Catch: IOException -> L36
        VFSPath r112 = ay4.d.a().H(d0.d(r105), r111.getName() + ChameleonResConstants.TEMP_SUFFIX);     // Catch: IOException -> L36
        FileUtils.g(r111.getVfsPath(), r112);     // Catch: IOException -> L36
        r112.toFile().renameTo(ay4.d.a().D(d0.d(r105), r111.getName()));     // Catch: IOException -> L36
        v(r105, r102.getVersion());     // Catch: IOException -> L36
    L34:
        if (r103 == true) goto L55;
        cz4.b r113 = this.f218046o;     // Catch: IOException -> L36
        String r114 = r102.getUrl();     // Catch: IOException -> L36
        String r115 = d0.c().getAbsolutePath();     // Catch: IOException -> L36
        String r116 = r102.getVersion();     // Catch: IOException -> L36
        a r117 = new a(this, r102, r105);     // Catch: IOException -> L36
        r113.getClass();     // Catch: IOException -> L36
        tt5.a.h("DownloadImpl", "download: url = " + r114);     // Catch: IOException -> L36
        RustDownloader r118 = r113.f466047a;     // Catch: IOException -> L36
        r118.getClass();     // Catch: IOException -> L36
        String r119 = (String) SdkSender.syncSend(Command.SUITE_DRIVE_DOWNLOAD_NORMAL, new DownloadNormalRequest.Builder().local_path(r115.concat(File.separator).concat(r116)).remote_url(r114).priority(Integer.valueOf(DrivePriority$DownloadPriority.PREVIEW.getPriority())).with_slice(Boolean.TRUE).api_type(DownloadRequest.ApiType.DRIVE), new dz4.a());     // Catch: IOException -> L36
        tt5.a.h("DriveDownloader", "onStart, uniqueKey = " + r119);     // Catch: IOException -> L36
        r117.onStart();     // Catch: IOException -> L36
        ((ConcurrentHashMap) r118.f218005a).put(r119, r117);     // Catch: IOException -> L36
        return;
    L55:
        return;
    L33:
        r103 = r107;
        goto L34
    L13:
        if (r106.length <= 0) goto L21;
        int r120 = r106.length;     // Catch: IOException -> L36
        int r121 = 0;
        r107 = false;
    L15:
        if (r121 >= r120) goto L22;
        VFSFile r122 = r106[r121];     // Catch: IOException -> L36
        if (r122.getName().contains(r102.getVersion()) == false) goto L19;
        tt5.a.h("LocalResUpdateServiceImpl", "checkGrayResource, resource already exist in gray");     // Catch: IOException -> L36
        r107 = true;
    L20:
        r121 = r121 + 1;     // Catch: IOException -> L36
        goto L15
    L19:
        FileUtils.m(r122.getVfsPath());     // Catch: IOException -> L36
        goto L20
    L38:
        VFSFile[] r123 = d0.d(r105).listFiles();     // Catch: IOException -> L36
        if (r123 != null) goto L41;
        return;
    L41:
        if (r123.length <= 0) goto L58;
        int r124 = r123.length;     // Catch: IOException -> L36
        int r125 = 0;
    L43:
        if (r125 >= r124) goto L59;
        FileUtils.m(r123[r125].getVfsPath());     // Catch: IOException -> L36
        r125 = r125 + 1;
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
        if (TextUtils.isEmpty(r102.getVersion()) == true) goto L7;
        r104 = true;
        goto L8
    }

    public final void t() {
        if (this.f218042k == null) goto L10;
        tt5.a.h("LocalResUpdateServiceImpl", "initGecko(): mGeckoClient has ready");
        return;
    L10:
        u();     // Catch: GeckoInitException -> L6
        n();     // Catch: GeckoInitException -> L6
        p(this.f218034c);     // Catch: GeckoInitException -> L6
        return;
    L6:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "initGecko(): fail", e, false);
    }

    public final void u() throws GeckoInitException {
        if (this.f218042k == null) goto L5;
        return;
    L5:
        String r100 = ((h) org.koin.java.a.a(h.class)).getDeviceId();
        this.f218039h = r100;
        if (TextUtils.isEmpty(r100) == true) goto L14;
        if (TextUtils.isEmpty(((h) org.koin.java.a.a(h.class)).d()) == true) goto L12;
        GeckoConfig.Builder r101 = new GeckoConfig.Builder(this.f218038g).accessKey(new String[]{this.f218040i}).allLocalAccessKeys(new String[]{this.f218040i}).appId(((h) org.koin.java.a.a(h.class)).getAppId()).host(((h) org.koin.java.a.a(h.class)).d()).appVersion(ApkUtil.getAppVersionName(this.f218038g)).deviceId(this.f218039h);
        int r102 = com.bytedance.ee.bear.doc.resupdate.c.f218003a;
        this.f218042k = GeckoClient.create(r101.resRootDir(com.bytedance.ee.bear.doc.resupdate.c.b(this.f218038g)).needServerMonitor(false).statisticMonitor(new n()).build());
        GeckoLogger.enable();
        GeckoLogger.addLogger(new x());
        tt5.a.h("LocalResUpdateServiceImpl", "initGecko() finish: deviceId = " + this.f218039h);
        return;
    L12:
        throw new GeckoInitException("gecko domain is invalid");
    L14:
        throw new GeckoInitException("deviceId is Empty!!!");
    }

    public w() {
        this.f218032a = new CompositeDisposable();
        this.f218033b = new ConcurrentHashMap();
        this.f218034c = new ArrayList();
        this.f218035d = new HashMap();
        this.f218036e = new HashMap();
        this.f218037f = new HashMap();
        this.f218041j = 300000;
        this.f218043l = new ConcurrentLinkedQueue();
        this.f218044m = new AtomicBoolean(false);
        this.f218046o = new cz4.b();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void a() {
        if (eu5.g.j() == true) goto L6;
        return;
    L6:
        if (this.f218044m.get() == true) goto L9;
        tt5.a.k("LocalResUpdateServiceImpl", "checkUpdate, gecko hasn't init, ignore");
        return;
    L9:
        String r100 = (String) ((HashMap) this.f218035d).get("DOC_CHANNEL");
        if (((HashMap) this.f218036e).get(r100) == null) goto L12;
        long r101 = ((Long) ((HashMap) this.f218036e).get(r100)).longValue();
    L14:
        if ((SystemClock.uptimeMillis() - r101) >= this.f218041j) goto L16;
        tt5.a.h("LocalResUpdateServiceImpl", "checkUpdate，check update too frequently, ignore");
        return;
    L16:
        Map<String, Long> r102 = this.f218036e;
        HashMap r103 = (HashMap) r102;
        r103.put(r100, Long.valueOf(SystemClock.uptimeMillis()));
        ArrayList r104 = new ArrayList();
        r104.add(r100);
        p(r104);
        return;
    L12:
        r101 = 0;
        goto L14
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void i() {
        if (eu5.g.j() == true) goto L5;
        return;
    L5:
        Disposable r100 = Flowable.just("").observeOn(fo5.d.a()).map(new k(this)).subscribe(new s(this), new t());
        this.f218032a.add(r100);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void b(l35.c r100) {
        if (eu5.g.j() == true) goto L5;
        return;
    L5:
        if (((HashMap) this.f218035d).containsKey("DOC_CHANNEL") == false) goto L10;
        this.f218033b.put((String) ((HashMap) this.f218035d).get("DOC_CHANNEL"), r100);
        return;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void c(Context r110) {
        if (eu5.g.j() == true) goto L5;
        return;
    L5:
        ml5.b r100 = new ml5.b("app_version");
        String r101 = ApkUtil.getAppVersionName(r110);
        String r102 = (String) r100.a("app_version_name", "");
        tt5.a.h("AppVersionHelper", "isUpgrade... savedVersion = " + r102 + ", versionName = " + r101);
        if (TextUtils.isEmpty(r102) == false) goto L8;
    L10:
        boolean r103 = false;
    L11:
        tt5.a.h("LocalResUpdateServiceImpl", "cleanResource(): versionName = " + r101 + ",upgrade = " + r103);
        if (r103 == true) goto L26;
        d0.e(r110, r110.getString(R.string.config_gecko_channel), true);
        return;
    L26:
        VFSFile r111 = d0.j(null);     // Catch: IOException -> L22
        final VFSFile r104 = ay4.d.a().i(r111.getAbsolutePath() + "_" + System.currentTimeMillis());     // Catch: IOException -> L22
        if (r111.renameTo(r104) == false) goto L17;
        tt5.a.b("LocalResUpdateServiceImpl", "cleanResource root dir " + r104);     // Catch: IOException -> L22
        this.f218032a.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new y(this, r104), new o(r104)));     // Catch: IOException -> L22
    L19:
        if (TextUtils.isEmpty(r101) == true) goto L28;
        r100.b("app_version_name", r101);     // Catch: IOException -> L22
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
        if (TextUtils.equals(r102, r101) == true) goto L10;
        r103 = true;
        goto L11
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void h(f0 r100) {
        if ((r100 instanceof cz4.d) == true) goto L5;
        r100 = new cz4.d(r100);
    L5:
        cz4.d r101 = (cz4.d) r100;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.full_pkg_included") == false) goto L9;
        tt5.a.h("LocalResUpdateServiceImpl", "downloadFullRes ignore, full pkg included");
        r101.onReady();
        return;
    L9:
        tt5.a.h("LocalResUpdateServiceImpl", "downloadFullRes, retryCount = " + r101.f466049b);
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.c()).subscribe(new b(this, r101), new c(this, r101));
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void init(Context r100) {
        if (this.f218044m.get() == false) goto L6;
        tt5.a.h("LocalResUpdateServiceImpl", "has init ");
        return;
    L6:
        this.f218038g = r100.getApplicationContext();
        tt5.a.h("LocalResUpdateServiceImpl", "initConfig(): ");
        com.ss.android.lark.storage.a r101 = ay4.b.f16748a;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter("privatizationConfig", "name");
        ay4.b.b("privatizationConfig", true, ay4.b.a("privatizationConfig"));
        this.f218040i = com.bytedance.ee.bear.doc.resupdate.c.a(r100, false);
        this.f218041j = ((h) org.koin.java.a.a(h.class)).c();
        String r102 = this.f218038g.getString(R.string.config_gecko_channel);
        ((ArrayList) this.f218034c).add(r102);
        ((HashMap) this.f218037f).put(r102, "eesz");
        ((HashMap) this.f218035d).put("DOC_CHANNEL", r102);
        this.f218045n = com.bytedance.ee.bear.contract.j.a.f217090a;
        com.bytedance.ee.util.ui.m.d(new j(this));
        if (((h) org.koin.java.a.a(h.class)).isEnable("ccm.ka.gurd_fix_enable") == true) goto L11;
        tt5.a.h("LocalResUpdateServiceImpl", "feature switch close");
        return;
    L11:
        if (eu5.g.j() == false) goto L13;
        Disposable r103 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).delay(5, TimeUnit.SECONDS).subscribe(new v(this));
        this.f218032a.add(r103);
    L13:
        this.f218044m.set(true);
        tt5.a.h("LocalResUpdateServiceImpl", "init(): ");
    }

    public final void o(String r100) {
        int r101 = com.bytedance.ee.bear.doc.resupdate.c.f218003a;     // Catch: IOException -> L4
        FileUtils.p(com.bytedance.ee.bear.doc.resupdate.c.b(this.f218038g).getVfsPath().subPath(this.f218040i).subPath(r100));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "clearGeckoRecordByChannel() failed ", e, false);
    }

    public final void p(List<String> r100) {
        tt5.a.h("LocalResUpdateServiceImpl", "checkUpdate(): " + r100);
        com.bytedance.ee.bear.contract.j r101 = this.f218045n;
        if (r101 == null) goto L9;
        if (r101.getNetworkState().a() == true) goto L9;
        tt5.a.h("LocalResUpdateServiceImpl", "checkUpdate(): channel stop cause isn't connected");
        return;
    L9:
        if (this.f218042k != null) goto L12;
        tt5.a.d("LocalResUpdateServiceImpl", "checkUpdate(): GeckoClient == null");
        return;
    L12:
        String r102 = this.f218040i;
        HashMap r103 = new HashMap();
        ArrayList r104 = new ArrayList();
        Iterator r105 = ((ArrayList) r100).iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        r104.add(new CheckRequestBodyModel.TargetChannel((String) r105.next()));
        goto L14
    L16:
        r103.put(r102, r104);
        this.f218042k.checkUpdateMulti(r103, new d(this));
    }

    public final e0 q(com.bytedance.ee.bear.doc.resupdate.e r100) {
        VFSPath r101 = r100.a(this.f218038g);
        if (r101 != null) goto L5;
        r101 = r100.a(this.f218038g);
    L5:
        String r102 = d0.f(r101);
        return new e0(r101.toFile(), r102, null);
    }

    public final VFSPath r(String r100) throws IOException {
        if (((HashMap) this.f218037f).containsKey(r100) == false) goto L20;
        int r101 = com.bytedance.ee.bear.doc.resupdate.c.f218003a;
        String r102 = ResLoadUtils.getChannelPath(com.bytedance.ee.bear.doc.resupdate.c.b(this.f218038g), this.f218040i, r100);
        if (r102 == null) goto L18;
        VFSFile r103 = ay4.d.a().i(r102);
        if (r103.exists() == false) goto L16;
        VFSPath r104 = ay4.d.a().H(r103, (String) ((HashMap) this.f218037f).get(r100));
        tt5.a.h("LocalResUpdateServiceImpl", "getGeckoDirResource: " + r104.toFile().getPath());
        if (r104.toFile().exists() == false) goto L14;
        if (r104.toFile().isDirectory() == false) goto L14;
        return r104;
    L14:
        throw new IOException("getGeckoDirResource()... resFolder is not exist or not is directory");
    L16:
        throw new IOException("getGeckoDirResource()...channel ->" + r100 + " channelFile not exists()");
    L18:
        throw new IOException("getGeckoDirResource()...channel ->" + r100 + " path is null");
    L20:
        throw new IOException("getGeckoDirResource()...channel ->" + r100 + "not found template dir");
    }

    public static void k(final w r100, final cz4.d r101) {
        r100.getClass();
        int r102 = r101.f466049b;
        if (r102 != 3) goto L5;
        r101.onFail();
        return;
    L5:
        Flowable.timer((int) (Math.pow(2.0d, r102) * 30.0d), TimeUnit.SECONDS).subscribe(new p(r100, r101), new q());
        r101.f466049b = r102 + 1;
    }

    public final void v(String r100, String r101) {
        a0 r102 = this.f218033b.get(r100);
        if (r102 == null) goto L5;
        r102.a(r101);
        return;
    L5:
        tt5.a.d("LocalResUpdateServiceImpl", "transferToSD(): cancel cause updateListener is null");
    }

    public final void w(String r100, String r101) throws Exception {
        VFSPath r102 = r(r100);
        VFSFile r103 = d0.j(r100);
        VFSFile r104 = ay4.d.a().D(r103, r101 + ChameleonResConstants.TEMP_SUFFIX);
        StringBuilder r105 = new StringBuilder("transferToSD tempFile = ");
        r105.append(r104);
        tt5.a.b("LocalResUpdateServiceImpl", r105.toString());
        if (r104.exists() == false) goto L6;
        FileUtils.p(r104.getVfsPath());
        tt5.a.h("LocalResUpdateServiceImpl", "transferToSD(): delete exists tempFile = " + r101);
    L6:
        if (r104.mkdir() == false) goto L14;
        FileUtils.g(r102, ay4.d.a().H(r104, (String) ((HashMap) this.f218037f).get(r100)));
        if (r104.renameTo(ay4.d.a().D(r103, r101)) == false) goto L12;
        tt5.a.h("LocalResUpdateServiceImpl", "transferToSD(): success");
        v(r100, r101);
        return;
    L12:
        throw new IOException("transferToSD(): rename folder failed");
    L14:
        throw new IOException("transferToSD(): tempFile mkdir failed");
    }

    public final e0 s(VFSFile r100, String r101, String r102, com.bytedance.ee.bear.doc.resupdate.e r103) throws IOException {
        VFSPath r104 = r100.getVfsPath().subPath(r101);
        VFSPath r105 = r104.subPath(r103.b());
        tt5.a.b("LocalResUpdateServiceImpl", "getResourceInternal, res = " + r105);
        boolean r106 = new com.bytedance.ee.bear.doc.resupdate.a(r101, r102).b(r105);
        tt5.a.h("LocalResUpdateServiceImpl", "getResourceInternal, md5 check completion = " + r106);
        if (r106 == true) goto L5;
        o(r102);
        FileUtils.m(r104);
    L5:
        if (r106 == false) goto L8;
        return new e0(r105.toFile(), r101, null);
    L8:
        return q(r103);
    }

    public static void l(w r100, String r101, VFSPath r102, VFSPath r103, boolean r104) throws Exception {
        r100.getClass();
        if (r102.toFile().exists() == false) goto L31;
        ZipInputStream r105 = new ZipInputStream(r102.toFile().newInputStream());
        String r106 = r100.f218038g.getString(R.string.config_gecko_channel);
        if (r104 == false) goto L7;
        r106 = EChannel.DOCS_FULLPKG_CHANNEL.toString();
    L7:
        com.bytedance.ee.util.io.f.a(r105, r103.getRealPath());
        com.bytedance.ee.bear.doc.resupdate.a r107 = new com.bytedance.ee.bear.doc.resupdate.a(r101, r106);
        VFSPath r108 = r103.subPath(r106);
        if (r107.b(r108.subPath("eesz")) == true) goto L36;
        FileUtils.p(r108);     // Catch: IOException -> L26
    L29:
        throw new IOException("zip is not compelete");
    L26:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "deleteFile():failed", e, false);
        goto L29
    L36:
        FileUtils.p(r102);     // Catch: IOException -> L11
    L13:
        VFSFile r109 = r103.subPath(r101).toFile();
        if (r109.exists() == false) goto L20;
        FileUtils.p(r108);     // Catch: IOException -> L17
        return;
    L17:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "deleteFile():failed", e, false);
        return;
    L20:
        if (r108.toFile().renameTo(r109) == false) goto L23;
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

    public static void m(w r100, long r101, boolean r102, String r103, int r110) {
        r100.getClass();
        JSONObject r104 = new JSONObject();
        r104.put("duration_ms", r101);     // Catch: JSONException -> L12
        r104.put("is_success", r102);     // Catch: JSONException -> L12
        r104.put("errorMsg", r103);     // Catch: JSONException -> L12
        r104.put("retry_count", r110);     // Catch: JSONException -> L12
        if (r110 >= 3) goto L6;
        boolean r105 = true;
    L7:
        r104.put("can_retry", String.valueOf(r105));     // Catch: JSONException -> L12
        r104.put(DBDefinition.DOWNLOAD_TABLE_NAME, "rust");     // Catch: JSONException -> L12
        com.bytedance.ee.bear.contract.j r106 = r100.f218045n;     // Catch: JSONException -> L12
        if (r106 == null) goto L10;
        r104.put("doc_network_status", r106.getNetworkState().getType());     // Catch: JSONException -> L12
    L10:
        tt5.a.b("LocalResUpdateServiceImpl", "trackDownloadEvent, params = " + r104);     // Catch: JSONException -> L12
    L14:
        ((h) org.koin.java.a.a(h.class)).a("docs_dev_fullPackage_download_duration", r104);
        return;
    L6:
        r105 = false;
    L12:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "trackDownloadEvent failed", e, false);
        goto L14
    }
}
