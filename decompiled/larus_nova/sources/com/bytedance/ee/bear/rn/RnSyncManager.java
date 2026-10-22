package com.bytedance.ee.bear.rn;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.jsbridge.Message;
import com.bytedance.ee.bear.lark.dependency.a0;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$DataSource;
import com.bytedance.ee.bear.rn.middleground.business.base.BaseProtocol;
import com.bytedance.ee.bear.rn.middleground.business.base.BaseSDK;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.debug.HeaderAppendHelper;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class RnSyncManager implements wl5.a {
    public static final b A = null;
    public static final RnSyncManager$connectStateObserve$1 B = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RnSyncManager f236496a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ml5.b f236497b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f236498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f236499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static VFSPath f236500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f236501f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f236502g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Application f236503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static AccountService$Account f236504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static wl5.f f236505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static tb5.p f236506k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static ub5.a f236507l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static tl5.l f236508m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static tl5.l f236509n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static tl5.h f236510o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static b0 f236511p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static NetService f236512q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static xl5.a f236513r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f236514s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final CopyOnWriteArrayList<vl5.a> f236515t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final CopyOnWriteArrayList<com.bytedance.ee.bear.contract.n.c> f236516u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f236517v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static t f236518w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Lazy f236519x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Lazy f236520y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final RnSyncManager$appVisibleObserve$1 f236521z = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f236522a = null;

        static {
            f236522a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RnSyncManager.f236498c = true;     // Catch: Throwable -> L7
            Application r100 = RnSyncManager.f236503h;     // Catch: Throwable -> L7
            if (r100 == null) goto L10;
            r100.sendBroadcast(new Intent(r100.getPackageName() + ".RELOAD_APP_ACTION"));     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f236523a = null;

        static {
            f236523a = new b();
        }

        public b() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            boolean r101 = ((Boolean) r100).booleanValue();
            tt5.a.h("RnSyncManager", "dozeMonitor: isDoze=" + r101);
            int r102 = 1;
            if (r101 != true) goto L5;
            r102 = 0;
        L5:
            BaseSDK.f(r102);
        }
    }

    public static final class c implements com.bytedance.ee.bear.contract.n.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f236524a = null;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<T> f236525a = null;

            static {
                f236525a = new a();
            }

            public a() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                tt5.a.h("RnSyncManager", "domainCharacteristicConfig result = " + ((String) r100));
                RnSyncManager r101 = RnSyncManager.f236496a;
                RnSyncManager.j();
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b<T> f236526a = null;

            static {
                f236526a = new b();
            }

            public b() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                tt5.a.d("RnSyncManager", "domainCharacteristicConfig error = " + ((Throwable) r100));
            }
        }

        static {
            f236524a = new c();
        }

        public c() {
        }

        @Override // com.bytedance.ee.bear.contract.n.d
        public final void a(String r100) {
        L7:
            e = move-exception;
            tt5.a.d("RnSyncManager", "initSessionAndCallback error:" + e);
            return;
        L4:
            if (Intrinsics.areEqual(JSON.parseObject(r100).getString("action"), "fetchDomainConfig") == false) goto L12;
            tt5.a.h("RnSyncManager", "onReceiveData()...action = fetchDomainConfig");     // Catch: Exception -> L7
            ((s45.c) org.koin.java.a.c(s45.c.class, null, null, 6)).ka().subscribe(a.f236525a, b.f236526a);     // Catch: Exception -> L7
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VFSPath f236527a;

        public d(VFSPath r100) {
            this.f236527a = r100;
        }

        public final void a() {
            RnSyncManager r100 = RnSyncManager.f236496a;
            String r101 = ay4.d.a().r(this.f236527a, false).getAbsolutePath();
            tt5.a.h("RnSyncManager", "openSessionInternal");
            RnSyncManager.f236505j = new wl5.f(RnSyncManager.f236503h, (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), r101, RnSyncManager.b().toJSONString(), new r());
            t r102 = RnSyncManager.f236518w;
            if (r102 == null) goto L5;
            ((a0) LarkContext.spiByDwarf(a0.class)).k8(r102);
        L5:
            RnSyncManager.f236518w = null;
            t r103 = new t();
            ((a0) LarkContext.spiByDwarf(a0.class)).wd(r103);
            RnSyncManager.f236518w = r103;
            wl5.f r104 = RnSyncManager.f236505j;
            if (r104 == null) goto L15;
            Set<wl5.a> r105 = r104.f560203c;
            monitor-enter(r105);
            ((HashSet) r104.f560203c).add(r100);     // Catch: Throwable -> L12
            monitor-exit(r105);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L15:
            wl5.f r106 = RnSyncManager.f236505j;
            if (r106 == null) goto L24;
            tt5.a.h("JSModelService-Docs", "JSModelService hashcode: " + r106.hashCode() + "->start");
            r106.f560202b.f524426a.c(r106);
            onb.g r107 = r106.f560202b.f524426a;
            r107.getClass();
            if (Looper.myLooper() != Looper.getMainLooper()) goto L20;
            r107.d();
            return;
        L20:
            r107.f524412e.post(new onb.e(r107));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public RnSyncManager() {
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.bytedance.ee.bear.rn.RnSyncManager$appVisibleObserve$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.bytedance.ee.bear.rn.RnSyncManager$connectStateObserve$1] */
    static {
        f236496a = new RnSyncManager();
        f236497b = new ml5.b("debug_config");
        f236501f = new AtomicBoolean(false);
        f236502g = new AtomicBoolean(false);
        f236515t = new CopyOnWriteArrayList();
        f236516u = new CopyOnWriteArrayList();
        f236519x = LazyKt.lazy(RnSyncManager$initExecutor$2.INSTANCE);
        f236520y = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, RnSyncManager$mDocRnImpl$2.INSTANCE);
        f236521z = new RnSyncManager$appVisibleObserve$1();
        A = b.f236523a;
        B = new RnSyncManager$connectStateObserve$1();
    }

    public static JSONObject b() {
        JSONObject r100 = new JSONObject();
        b0 r101 = null;
        r100.put("scm", ((a4) org.koin.java.a.c(a4.class, null, null, 6)).d());
        b0 r102 = f236511p;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r102 = null;
    L5:
        r102.c();
        r100.put("sdk", "7.75.0-alpha1");
        b0 r103 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
        com.bytedance.ee.bear.lark.dependency.b r104 = (com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6);
        r100.put("apiPrefix", "https://" + s45.p.f540584u + '/' + s45.p.a().u9());
        i0 r105 = (i0) org.koin.java.a.c(i0.class, null, null, 6);
        String r106 = ou5.b.a(r105.c().getCountry(), r105.a());
        String r107 = r103.l();
        List<String> r108 = r103.q();
        r100.put("persistentConnectionURL", r107);
        r100.put("persistentConnectionURLList", r108);
        r100.put("persistentConnectionKey", ((b0) org.koin.java.a.c(b0.class, null, null, 6)).x());
        r100.put("language", r106);
        String r109 = PreferenceManager.getDefaultSharedPreferences(eu5.b.f474075a).getString("env_tt_feature", null);
        if (r109 != null) goto L8;
        r109 = "";
    L8:
        r100.put("x-tt-env", r109);
        String r110 = ((s45.c) org.koin.java.a.c(s45.c.class, null, null, 6)).getString("domain_characteristic_config", SliceInitService.DEFAULT_SWITCH);
        r100.put("domainCharacteristicConfig", r110);
        r100.put("isOversea", Integer.valueOf(!r104.isFeishuBrand() ? 1 : 0));
        b0 r111 = f236511p;
        if (r111 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r111 = null;
    L11:
        r100.put("doc-biz", r111.getPlatform());
        b0 r112 = f236511p;
        if (r112 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
    L15:
        r100.put(BaseHttpRequestInfo.KEY_USER_AGENT, r101.h());
        Lazy r113 = HeaderAppendHelper.f243122a;
        if (((Boolean) new ml5.b("debug_config").a("header_append_params_enable_rn", Boolean.TRUE)).booleanValue() == false) goto L23;
        LinkedHashMap r114 = new LinkedHashMap();
        HeaderAppendHelper.a(r114);
        if ((!r114.isEmpty()) == false) goto L23;
        Iterator r115 = r114.entrySet().iterator();
    L21:
        if (r115.hasNext() == false) goto L23;
        Map.Entry r116 = (Map.Entry) r115.next();
        r100.put(r116.getKey(), r116.getValue());
    L23:
        tt5.a.h("RnSyncManager", "sendAppInfo:lan = " + r106 + ", mainPersistentConnectionDomain = " + r107 + ", domainCharacteristicConfig = " + r110);
        if (r108 == null) goto L29;
        tt5.a.h("RnSyncManager", "sendAppInfo: allAvailableConnectionDomain size = " + r108.size());
        Iterator<T> r117 = r108.iterator();
    L27:
        if (r117.hasNext() == false) goto L29;
        tt5.a.b("RnSyncManager", "sendAppInfo: allAvailableConnectionDomain = " + ((String) r117.next()));
    L29:
        return r100;
    L14:
        r101 = r112;
        goto L15
    }

    public static VFSPath c() {
        tt5.a.h("RnSyncManager", "getBaseBundlePath: subPath:index.vmsdk.jsbundle");
        VFSPath r100 = f236500e;
        if (r100 == null) goto L7;
        VFSPath r101 = r100.subPath(DocFeed$Value$DataSource.RN);
        if (r101 == null) goto L7;
        VFSPath r102 = r101.subPath("index.vmsdk.jsbundle");
    L8:
        if (r102 == null) goto L12;
        boolean r103 = true;
        if (com.suite.lark.component.storage.ext.b.b(r102) != true) goto L12;
    L13:
        if (r103 == true) goto L15;
        return null;
    L15:
        return r102;
    L12:
        r103 = false;
    L7:
        r102 = null;
        goto L8
    }

    public static void i() {
        tt5.a.h("RnSyncManager", " reload=============");
        tt5.a.h("RN FE", "rn reload=============");
        if (f236501f.get() == false) goto L5;
        tt5.a.h("RnSyncManager", "closeSession");
        ((ExecutorService) f236519x.getValue()).execute(m.f236562a);
        e();
        return;
    L5:
        tt5.a.h("RnSyncManager", "reload initSessionAndCallback");
        d();
    }

    public static void j() {
        tt5.a.h("RnSyncManager", "sendAppInfo() called");
        JSONObject r100 = new JSONObject();
        r100.put(WikiFolderPushPlugin.OPT, "appInfo");
        r100.put(ContainerPosition.BODY, b());
        Lazy r101 = HeaderAppendHelper.f243122a;
        if (((Boolean) new ml5.b("debug_config").a("header_append_params_enable_rn", Boolean.TRUE)).booleanValue() == false) goto L10;
        LinkedHashMap r102 = new LinkedHashMap();
        HeaderAppendHelper.a(r102);
        if ((!r102.isEmpty()) == false) goto L10;
        Iterator r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        r100.put(r104.getKey(), r104.getValue());
    L10:
        n(r100.toJSONString());
    }

    public static void m() {
        JSONObject r100 = new JSONObject();
        r100.put(WikiFolderPushPlugin.OPT, "headers");
        JSONObject r101 = new JSONObject();
        b0 r102 = f236511p;
        NetService r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r102 = null;
    L5:
        r101.put("version_code", String.valueOf(r102.getVersionCode()));
        b0 r104 = f236511p;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r104 = null;
    L8:
        r101.put("version_name", r104.getVersionName());
        b0 r105 = f236511p;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r105 = null;
    L11:
        r101.put("package_name", r105.getPackageName());
        b0 r106 = f236511p;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r106 = null;
    L14:
        r101.put("platform", r106.getPlatform());
        r101.put("os", "Android");
        r101.put("os_version", Build.VERSION.RELEASE);
        b0 r107 = f236511p;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r107 = null;
    L17:
        r101.put("User-Agent", r107.h());
        b0 r108 = f236511p;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r108 = null;
    L20:
        r101.put("deviceId", r108.getDeviceId());
        NetService r109 = f236512q;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mNetService");
        r109 = null;
    L24:
        if (r109.getEnv() == 2) goto L31;
        NetService r110 = f236512q;
        if (r110 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mNetService");
    L30:
        if (r103.getEnv() == 5) goto L31;
    L34:
        r100.put(ContainerPosition.BODY, r101);
        n(r100.toJSONString());
        return;
    L28:
        r103 = r110;
    L31:
        String r111 = (String) new ml5.b("debug_config").a("http_request_id", "");
        if (TextUtils.isEmpty(r111) == true) goto L34;
        r101.put("sidecar", r111);
        goto L34
    }

    public static void o() {
        tt5.a.h("RnSyncManager", "sendUserInfo");
        AccountService$Account r100 = f236504i;
        if (r100 == null) goto L40;
        Intrinsics.checkNotNull(r100);
        if (r100.hasLogin() == false) goto L41;
        tt5.a.h("RnSyncManager", "sendUserInfo account != null");
        JSONObject r101 = new JSONObject();
        r101.put(WikiFolderPushPlugin.OPT, "userInfo");
        JSONObject r102 = new JSONObject();
        AccountService$Account r103 = f236504i;
        NetService r104 = null;
        if (r103 == null) goto L9;
        String r105 = r103.uid;
    L10:
        r102.put("id", r105);
        AccountService$Account r106 = f236504i;
        if (r106 == null) goto L13;
        String r107 = r106.uid;
    L14:
        r102.put("suid", r107);
        AccountService$Account r108 = f236504i;
        if (r108 == null) goto L17;
        String r109 = r108.tenantId;
    L18:
        r102.put("tenantId", r109);
        AccountService$Account r110 = f236504i;
        if (r110 == null) goto L21;
        String r111 = r110.avatarUrl;
    L22:
        r102.put("avatarUrl", r111);
        AccountService$Account r112 = f236504i;
        if (r112 == null) goto L25;
        String r113 = r112.userName;
    L26:
        r102.put("userName", r113);
        AccountService$Account r114 = f236504i;
        if (r114 == null) goto L29;
        String r115 = r114.domain;
    L30:
        r102.put("domain", r115);
        NetService r116 = f236512q;
        if (r116 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mNetService");
    L35:
        if (r104.w6() == false) goto L37;
        String r117 = "staging";
    L38:
        r102.put("host", r117);
        r101.put(ContainerPosition.BODY, r102);
        n(r101.toJSONString());
        return;
    L37:
        r117 = "publish";
        goto L38
    L33:
        r104 = r116;
        goto L35
    L29:
        r115 = null;
        goto L30
    L25:
        r113 = null;
        goto L26
    L21:
        r111 = null;
        goto L22
    L17:
        r109 = null;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L41:
        return;
    }

    public static void p() {
        BaseProtocol.OperationWhiteList r100 = new BaseProtocol.OperationWhiteList();
        b0 r101 = f236511p;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r101 = null;
    L5:
        r100.setBody(new BaseProtocol.Body.OperationWhiteList(r101.v()));
        String r102 = r100.getJsonString();
        new Message().f227152c = r102;
        wl5.f r103 = f236505j;
        if (r103 == null) goto L13;
        vl5.b r104 = new vl5.b();
        Intrinsics.checkNotNullParameter(r102, "message");
        r104.f555678c = r102;
        onb.k r105 = r103.f560202b;
        r105.getClass();
        onb.i r106 = new onb.i(r105, r104);
        if (r106.f524421a.f524426a.f524409b.get() != 3) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L13;
        r106.f524421a.f524429d.submit(new onb.h(r106));
        goto L13
    L10:
        r107 = false;
    L13:
        tt5.a.h("RnSyncManager", "sendWhiteListOperation, sendDocRequestSync=" + r102);
    }

    @Override // wl5.a
    public final void a() {
        tt5.a.h("RnSyncManager", "connect status============= connected");
        long r100 = System.currentTimeMillis() - f236499d;
        tt5.a.h("RnSyncManager", "reportInit() called with: costTime = " + r100);
        HashMap r101 = new HashMap();
        r101.put(HiAnalyticsConstant.BI_KEY_COST_TIME, String.valueOf(r100));
        int r102 = unb.a.f550884a;
        r101.put("runtime", "vmsdk");
        xl5.a r103 = null;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).v("dev_performance_rnbundle_load", r101);
        m();
        o();
        j();
        p();
        BaseSDK.e(com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().getType());
        if (DevEnvUtil.isDebugMode(f236503h) == false) goto L7;
        Object r104 = f236497b.a("rn_debug", Boolean.FALSE);
        Intrinsics.checkNotNull(r104);
        if (((Boolean) r104).booleanValue() == false) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L10;
    L12:
        f236517v = true;
        Iterator<com.bytedance.ee.bear.contract.n.c> r106 = f236516u.iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        r106.next().a();
        goto L14
    L16:
        xl5.a r107 = f236513r;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mKeepAliveService");
    L20:
        r103.c();
        return;
    L19:
        r103 = r107;
        goto L20
    L10:
        if (f236498c == true) goto L12;
        com.bytedance.ee.util.ui.m.a(a.f236522a);
    L7:
        r105 = false;
        goto L8
    }

    @Override // wl5.a
    public final void disconnect() {
        tt5.a.h("RnSyncManager", "connect status=============disconnect");
        f236517v = false;
        Iterator<com.bytedance.ee.bear.contract.n.c> r100 = f236516u.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().disconnect();
        goto L4
    }

    public static void d() {
        if (e() == false) goto L6;
        f236501f.set(true);
        f236502g.set(false);
        xl5.a r100 = new xl5.a();
        f236513r = r100;
        f(r100);
        f(c.f236524a);
        com.bytedance.ee.util.ui.m.a(q.f236630a);
        return;
    }

    public static boolean e() {
        VFSPath r100 = c();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        StringBuilder r102 = new StringBuilder("openSession: path ");
        if (r100 == null) goto L11;
        String r103 = r100.getRealPath();
    L12:
        r102.append(r103);
        r102.append(" exist=");
        r102.append(r101);
        tt5.a.h("RnSyncManager", r102.toString());
        if (r100 == null) goto L18;
        if (r101 == false) goto L18;
        ((ExecutorService) f236519x.getValue()).execute(new d(r100));
        return true;
    L18:
        return false;
    L11:
        r103 = null;
        goto L12
    L5:
        if (com.suite.lark.component.storage.ext.b.b(r100) != true) goto L7;
        r101 = true;
        goto L8
    }

    public static void f(final com.bytedance.ee.bear.contract.n.d r100) {
        Intrinsics.checkNotNullParameter(r100, "iSendDataCallback");
        Flowable<String> r101 = yl5.b.b(new RnSyncManager$registSendDataCallback$1(r100));
        if (r101 == null) goto L6;
        r101.subscribe();
        return;
    }

    public static void h(vl5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        CopyOnWriteArrayList<vl5.a> r101 = f236515t;
        if (r101.contains(r100) == true) goto L6;
        tt5.a.h("RnSyncManager", "registerJSDocObserver, observer: " + r100.hashCode() + ", result: " + r101.add(r100));
        return;
    }

    @JvmStatic
    public static final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        wl5.f r101 = f236505j;
        if (r101 == null) goto L6;
        r101.c(new vl5.b(), r100, -1).subscribe();
        return;
    }

    public static void n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Message r101 = new Message();
        r101.f227152c = r100;
        wl5.f r102 = f236505j;
        if (r102 == null) goto L11;
        String r103 = r101.b();
        vl5.e r104 = new vl5.e();
        Intrinsics.checkNotNullParameter(r103, "message");
        r104.f555678c = r103;
        onb.k r105 = r102.f560202b;
        r105.getClass();
        onb.i r106 = new onb.i(r105, r104);
        if (r106.f524421a.f524426a.f524409b.get() != 3) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == false) goto L12;
        r106.f524421a.f524429d.submit(new onb.h(r106));
        return;
    L12:
        return;
    L7:
        r107 = false;
        goto L8
    }

    public static void q(vl5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.h("RnSyncManager", "unregisterJSDocObserver, observer: " + r100.hashCode() + ", result: " + f236515t.remove(r100));
    }

    public static void g(String r100, tb5.i r101) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        if (TextUtils.isEmpty(r100) == true) goto L13;
        if (r101 == null) goto L16;
        s r102 = new s(r101);
        tb5.p r103 = f236506k;
        if (r103 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r100) == true) goto L11;
        ((ConcurrentHashMap) r103.f545263b).put(r100, r102);
        return;
    L11:
        com.ss.android.lark.officesdk.utils.di.j.d(r103.f545262a, new IllegalArgumentException());
        return;
    L16:
        return;
    }

    public static Flowable l(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "requestId");
        wl5.f r102 = f236505j;
        if (r102 == null) goto L15;
        vl5.b r103 = new vl5.b();
        if (r101 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        r103.f555675d = "";
    L17:
        return r102.c(r103, r100, -1);
    L13:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.String");
        r103.f555675d = r101;
        goto L17
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r104 = false;
        goto L11
    L15:
        return null;
    }
}
