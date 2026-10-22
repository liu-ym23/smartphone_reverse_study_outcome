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
import com.bytedance.ee.bear.contract.AccountService;
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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.debug.HeaderAppendHelper;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class RnSyncManager implements wl5.a {
    public static final b A = null;
    public static final RnSyncManager$connectStateObserve$1 B = null;
    public static final RnSyncManager a = null;
    public static final ml5.b b = null;
    public static boolean c;
    public static long d;
    public static VFSPath e;
    public static final AtomicBoolean f = null;
    public static final AtomicBoolean g = null;
    public static Application h;
    public static AccountService.Account i;
    public static wl5.f j;
    public static tb5.p k;
    public static ub5.a l;
    public static tl5.l m;
    public static tl5.l n;
    public static tl5.h o;
    public static b0 p;
    public static NetService q;
    public static xl5.a r;
    public static String s;
    public static final CopyOnWriteArrayList<vl5.a> t = null;
    public static final CopyOnWriteArrayList<com.bytedance.ee.bear.contract.n.c> u = null;
    public static boolean v;
    public static t w;
    public static final Lazy x = null;
    public static final Lazy y = null;
    public static final RnSyncManager$appVisibleObserve$1 z = null;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RnSyncManager.c = true;     // Catch: Throwable -> L7
            Application r0 = RnSyncManager.h;     // Catch: Throwable -> L7
            if (r0 == null) goto L10;
            r0.sendBroadcast(new Intent(r0.getPackageName() + ".RELOAD_APP_ACTION"));     // Catch: Throwable -> L7
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
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void onChanged(Object r3) {
            boolean r4 = ((Boolean) r3).booleanValue();
            tt5.a.h("RnSyncManager", "dozeMonitor: isDoze=" + r4);
            int r0 = 1;
            if (r4 != true) goto L5;
            r0 = 0;
        L5:
            BaseSDK.f(r0);
        }
    }

    public static final class c implements com.bytedance.ee.bear.contract.n.d {
        public static final c a = null;

        public static final class a<T> implements Consumer {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final void accept(Object r3) {
                tt5.a.h("RnSyncManager", "domainCharacteristicConfig result = " + ((String) r3));
                RnSyncManager r4 = RnSyncManager.a;
                RnSyncManager.j();
            }
        }

        public static final class b<T> implements Consumer {
            public static final b<T> a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final void accept(Object r3) {
                tt5.a.d("RnSyncManager", "domainCharacteristicConfig error = " + ((Throwable) r3));
            }
        }

        static {
            a = new c();
        }

        public c() {
        }

        public final void a(String r4) {
        L7:
            e = move-exception;
            tt5.a.d("RnSyncManager", "initSessionAndCallback error:" + e);
            return;
        L4:
            if (Intrinsics.areEqual(JSON.parseObject(r4).getString("action"), "fetchDomainConfig") == false) goto L12;
            tt5.a.h("RnSyncManager", "onReceiveData()...action = fetchDomainConfig");     // Catch: Exception -> L7
            ((s45.c) org.koin.java.a.c(s45.c.class, null, null, 6)).ka().subscribe(a.a, b.a);     // Catch: Exception -> L7
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ VFSPath a;

        public d(VFSPath r1) {
            this.a = r1;
        }

        public final void a() {
            RnSyncManager r0 = RnSyncManager.a;
            String r5 = ay4.d.a().r(this.a, false).getAbsolutePath();
            tt5.a.h("RnSyncManager", "openSessionInternal");
            RnSyncManager.j = new wl5.f(RnSyncManager.h, (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), r5, RnSyncManager.b().toJSONString(), new r());
            t r1 = RnSyncManager.w;
            if (r1 == null) goto L5;
            ((a0) LarkContext.spiByDwarf(a0.class)).k8(r1);
        L5:
            RnSyncManager.w = null;
            t r2 = new t();
            ((a0) LarkContext.spiByDwarf(a0.class)).wd(r2);
            RnSyncManager.w = r2;
            wl5.f r3 = RnSyncManager.j;
            if (r3 == null) goto L15;
            Set<wl5.a> r4 = r3.c;
            monitor-enter(r4);
            ((HashSet) r3.c).add(r0);     // Catch: Throwable -> L12
            monitor-exit(r4);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L15:
            wl5.f r6 = RnSyncManager.j;
            if (r6 == null) goto L24;
            tt5.a.h("JSModelService-Docs", "JSModelService hashcode: " + r6.hashCode() + "->start");
            r6.b.a.c(r6);
            onb.g r7 = r6.b.a;
            r7.getClass();
            if (Looper.myLooper() != Looper.getMainLooper()) goto L20;
            r7.d();
            return;
        L20:
            r7.e.post(new onb.e(r7));
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
        a = new RnSyncManager();
        b = new ml5.b("debug_config");
        f = new AtomicBoolean(false);
        g = new AtomicBoolean(false);
        t = new CopyOnWriteArrayList();
        u = new CopyOnWriteArrayList();
        x = LazyKt.lazy(RnSyncManager$initExecutor$2.INSTANCE);
        y = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, RnSyncManager$mDocRnImpl$2.INSTANCE);
        z = new RnSyncManager$appVisibleObserve$1();
        A = b.a;
        B = new RnSyncManager$connectStateObserve$1();
    }

    public static JSONObject b() {
        JSONObject r0 = new JSONObject();
        b0 r2 = null;
        r0.put("scm", ((a4) org.koin.java.a.c(a4.class, null, null, 6)).d());
        b0 r1 = p;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r1 = null;
    L5:
        r1.c();
        r0.put("sdk", "7.75.0-alpha1");
        b0 r3 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
        com.bytedance.ee.bear.lark.dependency.b r5 = (com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6);
        r0.put("apiPrefix", "https://" + s45.p.u + '/' + s45.p.a().u9());
        i0 r6 = (i0) org.koin.java.a.c(i0.class, null, null, 6);
        String r7 = ou5.b.a(r6.c().getCountry(), r6.a());
        String r8 = r3.l();
        List r4 = r3.q();
        r0.put("persistentConnectionURL", r8);
        r0.put("persistentConnectionURLList", r4);
        r0.put("persistentConnectionKey", ((b0) org.koin.java.a.c(b0.class, null, null, 6)).x());
        r0.put("language", r7);
        String r9 = PreferenceManager.getDefaultSharedPreferences(eu5.b.a).getString("env_tt_feature", null);
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        r0.put("x-tt-env", r9);
        String r10 = ((s45.c) org.koin.java.a.c(s45.c.class, null, null, 6)).getString("domain_characteristic_config", "{}");
        r0.put("domainCharacteristicConfig", r10);
        r0.put("isOversea", Integer.valueOf(!r5.isFeishuBrand() ? 1 : 0));
        b0 r11 = p;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r11 = null;
    L11:
        r0.put("doc-biz", r11.getPlatform());
        b0 r12 = p;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
    L15:
        r0.put("ua", r2.h());
        Lazy r13 = HeaderAppendHelper.a;
        if (((Boolean) new ml5.b("debug_config").a("header_append_params_enable_rn", Boolean.TRUE)).booleanValue() == false) goto L23;
        LinkedHashMap r14 = new LinkedHashMap();
        HeaderAppendHelper.a(r14);
        if ((!r14.isEmpty()) == false) goto L23;
        Iterator r15 = r14.entrySet().iterator();
    L21:
        if (r15.hasNext() == false) goto L23;
        Map.Entry r16 = (Map.Entry) r15.next();
        r0.put(r16.getKey(), r16.getValue());
    L23:
        tt5.a.h("RnSyncManager", "sendAppInfo:lan = " + r7 + ", mainPersistentConnectionDomain = " + r8 + ", domainCharacteristicConfig = " + r10);
        if (r4 == null) goto L29;
        tt5.a.h("RnSyncManager", "sendAppInfo: allAvailableConnectionDomain size = " + r4.size());
        Iterator r17 = r4.iterator();
    L27:
        if (r17.hasNext() == false) goto L29;
        tt5.a.b("RnSyncManager", "sendAppInfo: allAvailableConnectionDomain = " + ((String) r17.next()));
    L29:
        return r0;
    L14:
        r2 = r12;
        goto L15
    }

    public static VFSPath c() {
        tt5.a.h("RnSyncManager", "getBaseBundlePath: subPath:index.vmsdk.jsbundle");
        VFSPath r0 = e;
        if (r0 == null) goto L7;
        VFSPath r1 = r0.subPath(DocFeed$Value$DataSource.RN);
        if (r1 == null) goto L7;
        VFSPath r2 = r1.subPath("index.vmsdk.jsbundle");
    L8:
        if (r2 == null) goto L12;
        boolean r3 = true;
        if (com.suite.lark.component.storage.ext.b.b(r2) != true) goto L12;
    L13:
        if (r3 == true) goto L15;
        return null;
    L15:
        return r2;
    L12:
        r3 = false;
    L7:
        r2 = null;
        goto L8
    }

    public static void i() {
        tt5.a.h("RnSyncManager", " reload=============");
        tt5.a.h("RN FE", "rn reload=============");
        if (f.get() == false) goto L5;
        tt5.a.h("RnSyncManager", "closeSession");
        ((ExecutorService) x.getValue()).execute(m.a);
        e();
        return;
    L5:
        tt5.a.h("RnSyncManager", "reload initSessionAndCallback");
        d();
    }

    public static void j() {
        tt5.a.h("RnSyncManager", "sendAppInfo() called");
        JSONObject r0 = new JSONObject();
        r0.put(WikiFolderPushPlugin.OPT, "appInfo");
        r0.put("body", b());
        Lazy r1 = HeaderAppendHelper.a;
        if (((Boolean) new ml5.b("debug_config").a("header_append_params_enable_rn", Boolean.TRUE)).booleanValue() == false) goto L10;
        LinkedHashMap r2 = new LinkedHashMap();
        HeaderAppendHelper.a(r2);
        if ((!r2.isEmpty()) == false) goto L10;
        Iterator r3 = r2.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) r3.next();
        r0.put(r4.getKey(), r4.getValue());
    L10:
        n(r0.toJSONString());
    }

    public static void m() {
        JSONObject r0 = new JSONObject();
        r0.put(WikiFolderPushPlugin.OPT, "headers");
        JSONObject r1 = new JSONObject();
        b0 r2 = p;
        NetService r4 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r2 = null;
    L5:
        r1.put("version_code", String.valueOf(r2.getVersionCode()));
        b0 r3 = p;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r3 = null;
    L8:
        r1.put("version_name", r3.getVersionName());
        b0 r5 = p;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r5 = null;
    L11:
        r1.put("package_name", r5.getPackageName());
        b0 r6 = p;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r6 = null;
    L14:
        r1.put("platform", r6.getPlatform());
        r1.put("os", "Android");
        r1.put("os_version", Build.VERSION.RELEASE);
        b0 r7 = p;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r7 = null;
    L17:
        r1.put("User-Agent", r7.h());
        b0 r8 = p;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r8 = null;
    L20:
        r1.put("deviceId", r8.getDeviceId());
        NetService r9 = q;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mNetService");
        r9 = null;
    L24:
        if (r9.getEnv() == 2) goto L31;
        NetService r10 = q;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mNetService");
    L30:
        if (r4.getEnv() == 5) goto L31;
    L34:
        r0.put("body", r1);
        n(r0.toJSONString());
        return;
    L28:
        r4 = r10;
    L31:
        String r11 = (String) new ml5.b("debug_config").a("http_request_id", "");
        if (TextUtils.isEmpty(r11) == true) goto L34;
        r1.put("sidecar", r11);
        goto L34
    }

    public static void o() {
        tt5.a.h("RnSyncManager", "sendUserInfo");
        AccountService.Account r1 = i;
        if (r1 == null) goto L40;
        Intrinsics.checkNotNull(r1);
        if (r1.hasLogin() == false) goto L41;
        tt5.a.h("RnSyncManager", "sendUserInfo account != null");
        JSONObject r0 = new JSONObject();
        r0.put(WikiFolderPushPlugin.OPT, "userInfo");
        JSONObject r2 = new JSONObject();
        AccountService.Account r3 = i;
        NetService r4 = null;
        if (r3 == null) goto L9;
        String r5 = r3.uid;
    L10:
        r2.put(ResourceData.KEY_ID, r5);
        AccountService.Account r6 = i;
        if (r6 == null) goto L13;
        String r7 = r6.uid;
    L14:
        r2.put("suid", r7);
        AccountService.Account r8 = i;
        if (r8 == null) goto L17;
        String r9 = r8.tenantId;
    L18:
        r2.put("tenantId", r9);
        AccountService.Account r10 = i;
        if (r10 == null) goto L21;
        String r11 = r10.avatarUrl;
    L22:
        r2.put("avatarUrl", r11);
        AccountService.Account r12 = i;
        if (r12 == null) goto L25;
        String r13 = r12.userName;
    L26:
        r2.put("userName", r13);
        AccountService.Account r14 = i;
        if (r14 == null) goto L29;
        String r15 = r14.domain;
    L30:
        r2.put("domain", r15);
        NetService r16 = q;
        if (r16 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mNetService");
    L35:
        if (r4.w6() == false) goto L37;
        String r17 = "staging";
    L38:
        r2.put("host", r17);
        r0.put("body", r2);
        n(r0.toJSONString());
        return;
    L37:
        r17 = "publish";
        goto L38
    L33:
        r4 = r16;
        goto L35
    L29:
        r15 = null;
        goto L30
    L25:
        r13 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L41:
        return;
    }

    public static void p() {
        BaseProtocol.OperationWhiteList r0 = new BaseProtocol.OperationWhiteList();
        b0 r2 = p;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInfoProvideService");
        r2 = null;
    L5:
        r0.setBody(new BaseProtocol.Body.OperationWhiteList(r2.v()));
        String r1 = r0.getJsonString();
        new Message().c = r1;
        wl5.f r3 = j;
        if (r3 == null) goto L13;
        vl5.b r4 = new vl5.b();
        Intrinsics.checkNotNullParameter(r1, "message");
        r4.c = r1;
        onb.k r5 = r3.b;
        r5.getClass();
        onb.i r6 = new onb.i(r5, r4);
        if (r6.a.a.b.get() != 3) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L13;
        r6.a.d.submit(new onb.h(r6));
        goto L13
    L10:
        r7 = false;
    L13:
        tt5.a.h("RnSyncManager", "sendWhiteListOperation, sendDocRequestSync=" + r1);
    }

    @Override // wl5.a
    public final void a() {
        tt5.a.h("RnSyncManager", "connect status============= connected");
        long r1 = System.currentTimeMillis() - d;
        tt5.a.h("RnSyncManager", "reportInit() called with: costTime = " + r1);
        HashMap r0 = new HashMap();
        r0.put("cost_time", String.valueOf(r1));
        int r2 = unb.a.a;
        r0.put("runtime", "vmsdk");
        xl5.a r3 = null;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).v("dev_performance_rnbundle_load", r0);
        m();
        o();
        j();
        p();
        BaseSDK.e(com.bytedance.ee.bear.contract.j.a.a.getNetworkState().getType());
        if (DevEnvUtil.isDebugMode(h) == false) goto L7;
        Object r4 = b.a("rn_debug", Boolean.FALSE);
        Intrinsics.checkNotNull(r4);
        if (((Boolean) r4).booleanValue() == false) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L10;
    L12:
        v = true;
        Iterator<com.bytedance.ee.bear.contract.n.c> r6 = u.iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        r6.next().a();
        goto L14
    L16:
        xl5.a r7 = r;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mKeepAliveService");
    L20:
        r3.c();
        return;
    L19:
        r3 = r7;
        goto L20
    L10:
        if (c == true) goto L12;
        com.bytedance.ee.util.ui.m.a(a.a);
    L7:
        r5 = false;
        goto L8
    }

    @Override // wl5.a
    public final void disconnect() {
        tt5.a.h("RnSyncManager", "connect status=============disconnect");
        v = false;
        Iterator<com.bytedance.ee.bear.contract.n.c> r0 = u.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().disconnect();
        goto L4
    }

    public static void d() {
        if (e() == false) goto L6;
        f.set(true);
        g.set(false);
        xl5.a r0 = new xl5.a();
        r = r0;
        f(r0);
        f(c.a);
        com.bytedance.ee.util.ui.m.a(q.a);
        return;
    }

    public static boolean e() {
        VFSPath r0 = c();
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        StringBuilder r4 = new StringBuilder("openSession: path ");
        if (r0 == null) goto L11;
        String r5 = r0.getRealPath();
    L12:
        r4.append(r5);
        r4.append(" exist=");
        r4.append(r3);
        tt5.a.h("RnSyncManager", r4.toString());
        if (r0 == null) goto L18;
        if (r3 == false) goto L18;
        ((ExecutorService) x.getValue()).execute(new d(r0));
        return true;
    L18:
        return false;
    L11:
        r5 = null;
        goto L12
    L5:
        if (com.suite.lark.component.storage.ext.b.b(r0) != true) goto L7;
        r3 = true;
        goto L8
    }

    public static void f(final com.bytedance.ee.bear.contract.n.d r1) {
        Intrinsics.checkNotNullParameter(r1, "iSendDataCallback");
        Flowable<String> r2 = yl5.b.b(new RnSyncManager$registSendDataCallback$1(r1));
        if (r2 == null) goto L6;
        r2.subscribe();
        return;
    }

    public static void h(vl5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        CopyOnWriteArrayList<vl5.a> r0 = t;
        if (r0.contains(r3) == true) goto L6;
        tt5.a.h("RnSyncManager", "registerJSDocObserver, observer: " + r3.hashCode() + ", result: " + r0.add(r3));
        return;
    }

    @JvmStatic
    public static final void k(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        wl5.f r0 = j;
        if (r0 == null) goto L6;
        r0.c(new vl5.b(), r4, -1).subscribe();
        return;
    }

    public static void n(String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Message r1 = new Message();
        r1.c = r3;
        wl5.f r4 = j;
        if (r4 == null) goto L11;
        String r2 = r1.b();
        vl5.e r5 = new vl5.e();
        Intrinsics.checkNotNullParameter(r2, "message");
        r5.c = r2;
        onb.k r6 = r4.b;
        r6.getClass();
        onb.i r0 = new onb.i(r6, r5);
        if (r0.a.a.b.get() != 3) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L12;
        r0.a.d.submit(new onb.h(r0));
        return;
    L12:
        return;
    L7:
        r7 = false;
        goto L8
    }

    public static void q(vl5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        tt5.a.h("RnSyncManager", "unregisterJSDocObserver, observer: " + r3.hashCode() + ", result: " + t.remove(r3));
    }

    public static void g(String r2, tb5.i r3) {
        Intrinsics.checkNotNullParameter(r2, "handlerName");
        if (TextUtils.isEmpty(r2) == true) goto L13;
        if (r3 == null) goto L16;
        s r0 = new s(r3);
        tb5.p r4 = k;
        if (r4 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        ((ConcurrentHashMap) r4.b).put(r2, r0);
        return;
    L11:
        com.ss.android.lark.officesdk.utils.di.j.d(r4.a, new IllegalArgumentException());
        return;
    L16:
        return;
    }

    public static Flowable l(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "requestId");
        wl5.f r0 = j;
        if (r0 == null) goto L15;
        vl5.b r1 = new vl5.b();
        if (r5 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        r1.d = "";
    L17:
        return r0.c(r1, r4, -1);
    L13:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.String");
        r1.d = r5;
        goto L17
    L7:
        if (StringsKt.isBlank(r5) == true) goto L10;
        r2 = false;
        goto L11
    L15:
        return null;
    }
}
