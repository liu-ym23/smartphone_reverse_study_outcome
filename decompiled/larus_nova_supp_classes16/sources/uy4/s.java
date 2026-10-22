package uy4;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.a0;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.bytedance.ee.bear.doc.resupdate.f0;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoConfig;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.utils.CarUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s implements com.bytedance.ee.bear.doc.resupdate.i {
    public static final byte[] g = null;
    public static boolean h;
    public Context a;
    public String b;
    public GeckoClient c;
    public final AtomicBoolean d;
    public wy4.a e;
    public final Map<String, List<a0>> f;

    public static class a {
        public static final s a = null;

        static {
            a = new s();
        }
    }

    static {
        g = new byte[0];
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void c(Context r1) {
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void a() {
        k(EChannel.DOCS_CHANNEL);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void g() {
        if (h == false) goto L6;
        tt5.a.h("LocalResUpdateServiceImpl", "checkResourceIsValid but hasCheckMd5 = true");
        return;
    L6:
        h = true;
        Flowable.just("").observeOn(fo5.d.b()).map(new l(this)).subscribe(new m(), new n());
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final boolean hasInit() {
        return this.d.get();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void i() {
        Flowable.just("").observeOn(fo5.d.a()).map(new c(this)).subscribe(new g(this), new h());
    }

    public final e0 o() {
        if (this.e != null) goto L5;
        this.e = new wy4.a(this.a);
    L5:
        wy4.a r0 = this.e;
        com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a[] r1 = r0.a;
        int r2 = r1.length;
        boolean r3 = false;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L18;
        com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a r6 = r1[r4];
        if (r6.d() == true) goto L10;
        r4 = r4 + 1;
        goto L7
    L10:
        e0 r5 = r6.b();
        String r7 = r5.b;
        if (r7 != null) goto L13;
    L14:
        r3 = true;
    L15:
        if (r3 == false) goto L22;
        tt5.a.k("DocsResourceProvider", "resource.version is NullOrEmpty");
        return r0.b.b();
    L22:
        return r5;
    L13:
        if (r7.length() != 0) goto L15;
    L18:
        tt5.a.d("DocsResourceProvider", "getResource, no interceptor match");
        return new e0();
    }

    public final boolean p() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.full_pkg_included") == false) goto L5;
    L8:
        return true;
    L5:
        if (d0.l(EChannel.DOCS_FULLPKG_CHANNEL.toString()) == true) goto L8;
        return false;
    }

    public final void q() {
        if (this.c == null) goto L5;
        tt5.a.h("LocalResUpdateServiceImpl", "initGecko(): mGeckoClient has ready");
        return;
    L5:
        if (r() == false) goto L10;
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        List<String> r1 = EChannel.getChannelList(!r0.g("ccm.mobile.full_pkg_included"));
        if (r0.i("spacekit.res.use_grayscale_package", false) == true) goto L9;
        r1.remove(EChannel.DOCS_GRAY_CHANNEL.toString());
    L9:
        l(r1, false);
        return;
    L10:
        tt5.a.d("LocalResUpdateServiceImpl", "initGecko failed");
    }

    public final boolean r() {
        if (this.c == null) goto L7;
        tt5.a.k("LocalResUpdateServiceImpl", "initGeckoClient, client is already init");
        return false;
    L7:
        if (((com.bytedance.ee.bear.doc.resupdate.h) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.h.class)).isEnable("ccm.ka.gurd_fix_enable") == true) goto L10;
        tt5.a.k("LocalResUpdateServiceImpl", "initGeckoClient, feature switch close!");
        return false;
    L10:
        String r0 = ((com.bytedance.ee.bear.doc.resupdate.h) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.h.class)).getDeviceId();
        this.b = r0;
        if (TextUtils.isEmpty(r0) == false) goto L14;
        tt5.a.d("LocalResUpdateServiceImpl", "initGeckoClient, deviceId is Empty!");
        return false;
    L14:
        String r1 = ((com.bytedance.ee.bear.doc.resupdate.h) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.h.class)).d();
        if (TextUtils.isEmpty(r1) == false) goto L18;
        tt5.a.d("LocalResUpdateServiceImpl", "initGeckoClient, host is empty!");
        return false;
    L18:
        int r3 = ((com.bytedance.ee.bear.doc.resupdate.h) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.h.class)).getAppId();
        String r4 = ((com.bytedance.ee.bear.doc.resupdate.h) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.h.class)).b(this.a);
        tt5.a.h("LocalResUpdateServiceImpl", "initGeckoClient, deviceId = " + this.b + ", host = " + r1 + ", appId = " + r3 + ", accessKey = " + r4);
        com.bytedance.geckox.b r2 = com.bytedance.geckox.b.a.a;
        boolean r5 = ((com.bytedance.ee.bear.doc.resupdate.h) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.h.class)).isBoe();
        int r6 = uy4.a.a;
        GeckoConfig.Builder r7 = new GeckoConfig.Builder(this.a).accessKey(new String[]{r4}).allLocalAccessKeys(new String[]{r4}).appId((long) r3).host(r1).appVersion(ApkUtil.getAppVersionName(this.a)).deviceId(this.b);
        int r8 = com.bytedance.ee.bear.doc.resupdate.c.a;
        GeckoConfig.Builder r9 = r7.resRootDir(com.bytedance.ee.bear.doc.resupdate.c.b(this.a)).netStack(new bkb.e(r5)).needServerMonitor(false).statisticMonitor(new k());
        if (DevicePerfManager.b.a.e.h == true) goto L21;
    L23:
        String[] r10 = CarUtils.a;
        this.c = GeckoClient.create(r9.build());
        GeckoLogger.enable();
        GeckoLogger.addLogger(new o());
        return true;
    L21:
        if (idb.f.a().isEnable("ccm.mobile.gecko_mmap_enable") == true) goto L23;
        r9.useMMap(false);
        goto L23
    }

    public s() {
        this.d = new AtomicBoolean(false);
        this.f = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final e0 getResource() {
        return o();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final boolean j() {
        return p();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void b(l35.c r2) {
        e(EChannel.DOCS_CHANNEL, r2);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void h(f0 r2) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.full_pkg_included") == false) goto L6;
        tt5.a.h("LocalResUpdateServiceImpl", "downloadFullRes ignore, full pkg included");
        return;
    L6:
        if (p() == false) goto L8;
        tt5.a.h("LocalResUpdateServiceImpl", "downloadFullRes, already has full res");
        return;
    L8:
        tt5.a.h("LocalResUpdateServiceImpl", "downloadFullRes, start download full res");
        k(EChannel.DOCS_FULLPKG_CHANNEL);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void init(Context r11) {
        if (this.d.get() == false) goto L6;
        tt5.a.h("LocalResUpdateServiceImpl", "has init, ignore");
        return;
    L6:
        tt5.a.h("LocalResUpdateServiceImpl", "init start");
        long r2 = System.currentTimeMillis();
        Context r12 = r11.getApplicationContext();
        this.a = r12;
        CountDownLatch r0 = vy4.a.a;
        Intrinsics.checkNotNullParameter(r12, "context");
        ml5.b r1 = new ml5.b("app_version");
        String r4 = ApkUtil.getAppVersionName(r12);
        String r5 = (String) r1.a("app_version_name", "");
        tt5.a.h("AppVersionHelper", "isUpgrade... savedVersion = " + r5 + ", versionName = " + r4);
        if (TextUtils.isEmpty(r5) == false) goto L9;
    L11:
        boolean r6 = false;
    L13:
        if (TextUtils.isEmpty(r4) == true) goto L15;
        r1.b("app_version_name", r4);
    L15:
        tt5.a.h("ResCleanUtils", "cleanResource(): versionName = " + r4 + ",upgrade = " + r6);
        if (r6 == true) goto L33;
        CpuCallbackManager.a().b(new vy4.d(r12));
    L31:
        q();     // Catch: Exception -> L27
    L29:
        this.d.set(true);
        Flowable.timer(15, TimeUnit.SECONDS).subscribe(new b(this), new f());
        tt5.a.h("LocalResUpdateServiceImpl", "init finish, cost time = " + (System.currentTimeMillis() - r2) + ", thread = " + ThreadMethodProxy.currentThread().getName());
        return;
    L27:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "init gecko failed", e, false);
        goto L29
    L33:
        vy4.a.a(r12);     // Catch: Throwable -> L19
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new vy4.b(r12), vy4.c.a);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CountDownLatch r3 = vy4.a.a;
        if (r3 == null) goto L23;
        r3.countDown();
    L23:
        tt5.a.e("ResCleanUtils", "cleanResource failed ", th, false);
        goto L31
    L9:
        if (TextUtils.equals(r5, r4) == true) goto L11;
        r6 = true;
        goto L13
    }

    public final void k(EChannel r5) {
        if (this.d.get() == true) goto L6;
        tt5.a.k("LocalResUpdateServiceImpl", "checkUpdate, gecko hasn't init, ignore");
        return;
    L6:
        EChannel r0 = EChannel.DOCS_FULLPKG_CHANNEL;
        if (r5 == r0) goto L9;
    L12:
        ArrayList r1 = new ArrayList();
        r1.add(r5.toString());
        if (r5 == r0) goto L15;
        boolean r6 = true;
    L16:
        l(r1, r6);
        return;
    L15:
        r6 = false;
        goto L16
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.full_pkg_included") == false) goto L12;
        tt5.a.h("LocalResUpdateServiceImpl", "checkUpdate ignore, full pkg included");
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void d(EChannel r2, a0 r3) {
        Map<String, List<a0>> r0 = this.f;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        List r4 = (List) r1.get(r2.toString());
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L9;
        r4.remove(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void e(EChannel r3, a0 r4) {
        Map<String, List<a0>> r0 = this.f;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        List r2 = (List) r1.get(r3.toString());
        if (r2 != null) goto L6;
        r2 = new CopyOnWriteArrayList();
        Map<String, List<a0>> r5 = this.f;
        ConcurrentHashMap r6 = (ConcurrentHashMap) r5;
        r6.put(r3.toString(), r2);
    L6:
        if (r2.contains(r4) == true) goto L9;
        r2.add(r4);
        return;
    }

    public final void l(final List<String> r3, final boolean r4) {
        tt5.a.h("LocalResUpdateServiceImpl", "executeCheckUpdate: channels = " + r3 + ", slimVersion = 1.0.24.6732");
        Flowable.just("").observeOn(fo5.d.a()).subscribe(new i(this, r3, r4), new j());
    }

    public final VFSFile n(String r4, long r5) throws IOException {
        String r0 = ((com.bytedance.ee.bear.doc.resupdate.h) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.h.class)).b(this.a);
        com.ss.android.lark.vfs.h r1 = ay4.d.a();
        int r2 = com.bytedance.ee.bear.doc.resupdate.c.a;
        VFSPath r6 = r1.z(ResLoadUtils.getChannelPath(com.bytedance.ee.bear.doc.resupdate.c.b(this.a), r0, r4, r5));
        if (r6 == null) goto L17;
        VFSFile r7 = r6.toFile();
        if (r7.exists() == false) goto L15;
        VFSFile[] r8 = r7.listFiles();
        if (r8 == null) goto L13;
        if (r8.length <= 0) goto L13;
        tt5.a.h("LocalResUpdateServiceImpl", "getGeckoDirResource: " + r8[0].getPath());
        return r8[0];
    L13:
        throw new IOException("getGeckoDirResource()... resFolder is not exist");
    L15:
        throw new IOException("getGeckoDirResource()...channel -> " + r4 + " channelFile not exists, file -> " + r7);
    L17:
        throw new IOException("getGeckoDirResource()...channel -> " + r4 + " path is null");
    }

    public final void m(List r6, yy4.b r7, boolean r8) {
        String r0 = ((com.bytedance.ee.bear.doc.resupdate.h) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.h.class)).b(this.a);
        HashMap r1 = new HashMap();
        HashMap r2 = new HashMap();
        r2.put("slim_res_version", "1.0.24.6732");
        r1.put(r0, r2);
        OptionCheckUpdateParams r9 = new OptionCheckUpdateParams().setCustomParam(r1).setListener(r7).setEnableThrottle(r8);
        GeckoClient r10 = this.c;
        HashMap r3 = new HashMap();
        ArrayList r4 = new ArrayList();
        Iterator r11 = r6.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r4.add(new CheckRequestBodyModel.TargetChannel((String) r11.next()));
        goto L4
    L6:
        r3.put(r0, r4);
        r10.checkUpdateMulti(BottomPopupData.Default, r3, r9);
    }

    public final void s(String r6, String r7, VFSFile r8) throws Exception {
        VFSFile r0 = d0.j(r6);
        VFSFile r1 = ay4.d.a().D(r0, r7 + "_temp");
        StringBuilder r2 = new StringBuilder("transferToSD tempFile = ");
        r2.append(r1);
        tt5.a.b("LocalResUpdateServiceImpl", r2.toString());
        if (r1.exists() == false) goto L6;
        FileUtils.p(r1.getVfsPath());
        tt5.a.h("LocalResUpdateServiceImpl", "transferToSD(): delete exists tempFile = " + r7);
    L6:
        if (r1.mkdir() == false) goto L23;
        FileUtils.g(r8.getVfsPath(), ay4.d.a().H(r1, r8.getName()));
        if (r1.renameTo(ay4.d.a().D(r0, r7)) == false) goto L21;
        com.bytedance.ee.bear.doc.resupdate.a r9 = new com.bytedance.ee.bear.doc.resupdate.a(r7, r6);
        VFSPath r3 = ay4.d.a().D(r0, r7).getVfsPath();
        if (r9.b(r3.subPath("eesz")) == false) goto L18;
        tt5.a.h("LocalResUpdateServiceImpl", "transferToSD(): success");
        List r10 = (List) ((ConcurrentHashMap) this.f).get(r6);
        if (r10 == null) goto L17;
        Iterator r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L25;
        a0 r4 = (a0) r11.next();
        tt5.a.h("LocalResUpdateServiceImpl", "notifyResourceReady,channel = " + r6 + ", versionName = " + r7);
        r4.a(r7);
        goto L15
    L25:
        return;
    L17:
        return;
    L18:
        FileUtils.p(r3);
        throw new IOException("transferToSD(): checkResourceIsValid failed");
    L21:
        throw new IOException("transferToSD(): rename folder failed");
    L23:
        throw new IOException("transferToSD(): tempFile mkdir failed");
    }
}
