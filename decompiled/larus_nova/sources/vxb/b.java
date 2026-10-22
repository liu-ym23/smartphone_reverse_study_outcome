package vxb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.ee.lark.infra.sandbox.context.BizType;
import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import com.bytedance.ee.lark.infra.sandbox.context.IBaseService;
import com.bytedance.ee.lark.plugin_annotation.bean.LKOpenApiBizDomain;
import com.larksuite.component.openplatform.plugins.config.LKOpenApiAccessConfig;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.tt.refer.common.base.AppType;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import l18.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public abstract class b implements IAppContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f557514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Activity f557515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f557516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f557517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f557518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile j18.b f557519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile LKOpenApiAccessConfig f557520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, IBaseService> f557521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Class, fs5.c> f557522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f557523j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f557524k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f557525l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f557526m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile fs5.b f557527n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile String f557528o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile OPTrace f557529p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public jz7.a f557530q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f557531r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f557532s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f557533t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Map<String, IAppContext> f557534u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f557535v;

    public abstract void c();

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final synchronized void destroy() {
        monitor-enter(this);
    L38:
        th = move-exception;
        throw th;
    L4:
        if (this.f557525l == false) goto L6;
    L35:
        Log.i("AppContextImpl", "this appContext is destroyed or destroying.");     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L6:
        if (this.f557526m == true) goto L35;
        this.f557526m = true;     // Catch: Throwable -> L38
        Iterator r100 = ((ConcurrentHashMap) this.f557534u).keySet().iterator();     // Catch: Throwable -> L38
    L10:
        if (r100.hasNext() == false) goto L14;
        IAppContext r101 = (IAppContext) ((ConcurrentHashMap) this.f557534u).get((String) r100.next());     // Catch: Throwable -> L38
        if (r101 == null) goto L10;
        r101.destroy();     // Catch: Throwable -> L38
        goto L10
    L14:
        ((ConcurrentHashMap) this.f557534u).clear();     // Catch: Throwable -> L38
        this.f557527n = null;     // Catch: Throwable -> L38
        d r102 = this.f557523j;     // Catch: Throwable -> L38
        if (r102 == null) goto L17;
        r102.a();     // Catch: Throwable -> L38
    L17:
        a r103 = this.f557524k;     // Catch: Throwable -> L38
        if (r103 == null) goto L20;
        r103.a();     // Catch: Throwable -> L38
    L20:
        this.f557516c = null;     // Catch: Throwable -> L38
        Map<String, IBaseService> r104 = this.f557521h;     // Catch: Throwable -> L38
        Map<AppType, yxb.a> r105 = zxb.a.f573906a;     // Catch: Throwable -> L38
        ConcurrentHashMap r106 = (ConcurrentHashMap) r104;     // Catch: Throwable -> L38
        if (r106.size() <= 0) goto L29;
        Iterator r107 = r106.values().iterator();     // Catch: Throwable -> L38
    L24:
        if (r107.hasNext() == false) goto L29;
        IBaseService r108 = (IBaseService) r107.next();     // Catch: Throwable -> L38
        if ((r108 instanceof yxb.c) == false) goto L28;
        ((yxb.c) r108).unregister();     // Catch: Throwable -> L38
    L28:
        r108.release();     // Catch: Throwable -> L38
    L29:
        this.f557515b = null;     // Catch: Throwable -> L38
        c();     // Catch: Throwable -> L38
        Log.i("AppContextImpl", "appContext destroyed: " + android.util.Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L38
        this.f557519f = null;     // Catch: Throwable -> L38
        jz7.a r109 = this.f557530q;     // Catch: Throwable -> L38
        if (r109 == null) goto L32;
        r109.e();     // Catch: Throwable -> L38
    L32:
        this.f557530q = null;     // Catch: Throwable -> L38
        ((ConcurrentHashMap) this.f557522i).clear();     // Catch: Throwable -> L38
        this.f557525l = true;     // Catch: Throwable -> L38
        monitor-exit(this);
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void startDestroy() {
        this.f557526m = true;
    }

    public final String toString() {
        monitor-enter(this);
        String r100 = b();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final String b() {
        StringBuilder r100 = new StringBuilder("AppContextWrapper{context=");
        r100.append(this.f557514a);
        r100.append(", currentActivity=");
        r100.append(this.f557515b);
        r100.append(", appId='");
        r100.append(this.f557516c);
        r100.append("', mAppIdentify='");
        r100.append(this.f557517d);
        r100.append("', mAppContainer=");
        r100.append(this.f557519f);
        r100.append(", mApiAccessConfig=");
        if (this.f557520g == null) goto L5;
        String r101 = this.f557520g.toString();
    L6:
        r100.append(r101);
        r100.append(", appServiceMap=");
        r100.append(this.f557521h);
        r100.append(", serviceManager=");
        r100.append(this.f557523j);
        r100.append(", iAppContextBundle=");
        r100.append(this.f557524k);
        r100.append(", isDestroyed=");
        r100.append(this.f557525l);
        r100.append(", isDestroying=");
        r100.append(this.f557526m);
        r100.append(", gadgetInteractiveProxy=");
        r100.append(this.f557527n);
        r100.append(", mTraceId='");
        r100.append(this.f557528o);
        r100.append("', mTraceSpan=");
        r100.append(this.f557529p);
        r100.append(i.f25855d);
        return r100.toString();
    L5:
        r101 = "";
        goto L6
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final LKOpenApiAccessConfig getApiAccessConfig() {
        if (this.f557520g != null) goto L6;
        LKOpenApiBizDomain r100 = LKOpenApiBizDomain.OPEN_PLATFORM;
        LKOpenApiAccessConfig r101 = new LKOpenApiAccessConfig(null);
        LKOpenApiAccessConfig.access$102(r101, r100);
        LKOpenApiAccessConfig.access$202(r101, true);
        LKOpenApiAccessConfig.access$302(r101, "");
        LKOpenApiAccessConfig.access$402(r101, null);
        this.f557520g = r101;
    L6:
        return this.f557520g;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final i18.c getBridgeContext() {
        j18.b r100 = this.f557519f;
        if (r100 != null) goto L5;
        Log.i("AppContextImpl", "use basePM.");
        r100 = this.f557530q;
    L5:
        if (r100 != null) goto L7;
        Log.e("AppContextImpl", "not set core node");
        return null;
    L7:
        return r100.getBridgeContext();
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final Activity getCurrentActivity() {
        if (this.f557515b != null) goto L6;
        Log.e("AppContextImpl", "currentActivity is null");
    L6:
        return this.f557515b;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final j18.b getCurrentNode() {
        j18.b r100 = this.f557519f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.f557530q;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void initTrace() {
        if (this.f557529p != null) goto L6;
        this.f557529p = gyb.a.a();
        this.f557528o = this.f557529p.getTracingID();
        return;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final boolean isEmbedContainer() {
        return TextUtils.equals(this.f557532s, "embed");
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final boolean isNewContainer() {
        if (this.f557531r == false) goto L5;
    L10:
        return true;
    L5:
        if (isEmbedContainer() == true) goto L10;
        if (isPanelContainer() == true) goto L10;
        return false;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final boolean isPanelContainer() {
        return TextUtils.equals(this.f557532s, "panel");
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final boolean isPanelOrEmbedContainer() {
        if (isPanelContainer() == false) goto L5;
    L8:
        return true;
    L5:
        if (isEmbedContainer() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void unRegisterOnResultAllPlugin() {
        j18.b r100 = getCurrentNode();
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final j18.b getAppContainer() {
        return this.f557519f;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final String getAppId() {
        return this.f557516c;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final String getAppIdentify() {
        return this.f557517d;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final Context getApplicationContext() {
        return this.f557514a;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final BizType getBizType() {
        return BizType.UNKNOWN;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final String getContainerType() {
        return this.f557532s;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final int getCurrentTheme() {
        return this.f557533t;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final jz7.a getDefaultPluginContainer() {
        return this.f557530q;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final <T> T getExtra() {
        return (T) this.f557518e;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final fs5.b getGadgetInteractiveProxy() {
        return this.f557527n;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final String getTraceId() {
        return this.f557528o;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final OPTrace getTracingSpan() {
        return this.f557529p;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final boolean isDestroyed() {
        return this.f557525l;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final boolean isDestroying() {
        return this.f557526m;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final boolean needClearTempDir() {
        return this.f557535v;
    }

    public b(Context r100) {
        this.f557521h = new ConcurrentHashMap();
        this.f557522i = new ConcurrentHashMap();
        this.f557523j = new d();
        this.f557524k = new a();
        this.f557525l = false;
        this.f557526m = false;
        this.f557533t = 0;
        this.f557534u = new ConcurrentHashMap();
        this.f557535v = true;
        this.f557514a = r100;
        initTrace();
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void bindAppContainer(j18.b r100) {
        this.f557519f = r100;
        if (this.f557519f == null) goto L6;
        this.f557531r = true;
        return;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final <T extends fs5.c> T findService(Class<T> r100) {
        return (T) ((ConcurrentHashMap) this.f557522i).get(r100);
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final <T extends IBaseService> T findServiceByInterface(Class<T> r100) {
        Map<String, IBaseService> r101 = this.f557521h;
        Map<AppType, yxb.a> r102 = zxb.a.f573906a;
        String r103 = r100.getCanonicalName();
        if (r103 == null) goto L39;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r101;
        T r105 = (T) r104.get(r103);
        Object r106 = null;
        if (r105 == null) goto L8;
    L25:
        if (r105 == null) goto L27;
        return r105;
    L27:
        d r107 = this.f557523j;
        if (r107 != null) goto L30;
        return null;
    L30:
        if (((ConcurrentHashMap) r107.f557537a).containsKey(r100) == true) goto L32;
        AppBrandLogger.e("ServiceManagerImpl", new Object[]{"service name is not register:".concat(r100.getName())});
    L34:
        return (T) r106;
    L32:
        r106 = ((ConcurrentHashMap) r107.f557537a).get(r100);
        goto L34
    L8:
        if (getAppType() != null) goto L10;
        AppBrandLogger.w("ModuleManager", new Object[]{"appContext.AppType is null"});
    L23:
        r105 = null;
        goto L25
    L10:
        monitor-enter(r100);
        r105 = (T) r104.get(r103);     // Catch: Throwable -> L35
        if (r105 != null) goto L24;
        yxb.a r108 = (yxb.a) ((ConcurrentHashMap) zxb.a.f573906a).get(getAppType());     // Catch: Throwable -> L35
        if (r108 == null) goto L22;
        r105 = (T) r108.a();
        if (r105 == null) goto L20;
        r104.put(r103, r105);     // Catch: Throwable -> L35
        monitor-exit(r100);     // Catch: Throwable -> L35
        goto L25
    L20:
        monitor-exit(r100);     // Catch: Throwable -> L35
        goto L23
    L22:
        monitor-exit(r100);     // Catch: Throwable -> L35
        goto L23
    L24:
        monitor-exit(r100);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    L39:
        throw new RuntimeException("getService fail : className is null");
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final <T> T getExtra(String r100) {
        a r101 = this.f557524k;
        if (((ConcurrentHashMap) r101.f557513a).containsKey(r100) == false) goto L7;
        T r102 = (T) ((ConcurrentHashMap) r101.f557513a).get(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return null;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void putExtras(fs5.a r100) {
        a r101 = this.f557524k;
        r101.getClass();
        monitor-enter(a.class);
        Map<String, Object> r102 = r101.f557513a;     // Catch: Throwable -> L7
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;     // Catch: Throwable -> L7
        r103.putAll(((a) r100).f557513a);     // Catch: Throwable -> L7
        monitor-exit(a.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void removeExtra(String r100) {
        a r101 = this.f557524k;
        if (((ConcurrentHashMap) r101.f557513a).containsKey(r100) == false) goto L6;
        ((ConcurrentHashMap) r101.f557513a).remove(r100);
        return;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public LKBasePluginResult sendEvent(LKEvent r110) {
        j18.b r100 = getCurrentNode();
        p18.b.a r101 = r110.f285500m.f527327b;
        boolean r102 = true;
        if ((r100 instanceof jz7.a) == true) goto L5;
    L8:
        if (r100 == null) goto L31;
        if ((r100 instanceof wxb.a) == true) goto L29;
        if (r101 == null) goto L14;
        r101.i("AppContextImpl", new Object[]{"bind appContext to LKEvent"});
    L15:
        hyb.a r103 = r110.c();
        if (r103 == null) goto L18;
        ((p18.b.a) r103).d("LKEvent", new Object[]{"setFindServiceContext"});
    L19:
        r110.f285495h = this;
        i18.c r104 = r100.getBridgeContext();
        if ((r104 instanceof e) == false) goto L29;
        if (r101 == null) goto L27;
        Object[] r105 = new Object[1];
        StringBuilder r106 = new StringBuilder("current activity:");
        if (getCurrentActivity() == null) goto L26;
        r102 = false;
    L26:
        r106.append(r102);
        r105[0] = r106.toString();
        r101.i("AppContextImpl", r105);
    L27:
        ((e) r104).a(getCurrentActivity());
        goto L29
    L18:
        Log.d("LKEvent", "setFindServiceContext");
        goto L19
    L14:
        Log.i("AppContextImpl", "bind appContext to LKEvent");
    L29:
        return r100.sendEvent(r110);
    L31:
        if (r101 == null) goto L33;
        r101.i("AppContextImpl", new Object[]{"core node is null"});
    L35:
        return LKBasePluginResult.f285519f;
    L33:
        Log.i("AppContextImpl", "core node is null");
        goto L35
    L5:
        if (r101 == null) goto L7;
        r101.i("AppContextImpl", new Object[]{"eventName:" + r110.f285488a + " use basePM"});
        goto L8
    L7:
        Log.i("AppContextImpl", "eventName:" + r110.f285488a + " use basePM");
        goto L8
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void setApiAccessConfig(LKOpenApiAccessConfig r100) {
        this.f557520g = r100;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void setAppId(String r100) {
        this.f557516c = r100;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void setAppIdentify(String r100) {
        this.f557517d = r100;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void setContainerType(String r100) {
        this.f557532s = r100;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void setCurrentActivity(Activity r100) {
        this.f557515b = r100;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void setCurrentTheme(int r100) {
        this.f557533t = r100;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void setDefaultPluginContainer(jz7.a r100) {
        this.f557530q = r100;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void setExtra(Object r100) {
        this.f557518e = r100;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void setGadgetInteractiveProxy(fs5.b r100) {
        this.f557527n = r100;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void setNeedClearTempDir(boolean r100) {
        this.f557535v = r100;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void setTracingSpan(OPTrace r100) {
        this.f557529p = r100;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void unRegisterOnResultPlugin(i18.d r100) {
        j18.b r101 = getCurrentNode();
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final LKBasePluginResult sendEvent(String r100) {
        return sendEvent(r100, null, null);
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void bindDependAppContext(String r100, IAppContext r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (((ConcurrentHashMap) this.f557534u).containsKey(r101.getAppId() + r100) == true) goto L8;
        ((ConcurrentHashMap) this.f557534u).put(r101.getAppId() + r100, r101);
        return;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final IAppContext getBoundDependAppContext(String r100, String r101) {
        return (IAppContext) ((ConcurrentHashMap) this.f557534u).get(r100 + r101);
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final <T> void putExtra(String r100, T r101) {
        a r102 = this.f557524k;
        r102.getClass();
        monitor-enter(a.class);
        ((ConcurrentHashMap) r102.f557513a).put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(a.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final <T extends IBaseService> boolean registerService(Class<T> r100, T r101) {
        boolean r102 = r101 instanceof c;
        if (r102 == false) goto L5;
        ((c) r101).f557536a = this;
    L5:
        d r103 = this.f557523j;
        if (r103 == null) goto L17;
        if (r102 == false) goto L16;
        AppBrandLogger.i("ServiceManagerImpl", new Object[]{"register service:".concat(r100.getName())});
        if (r100.getName().contains("com.ss.android.lark.openplatform.common.service.AppSingletonInstance") == false) goto L12;
        AppBrandLogger.e("falcon ", new Object[]{r100.getName() + " registerService success onAppRoute  mServices:" + r103});
    L12:
        if (((ConcurrentHashMap) r103.f557537a).put(r100, r101) != null) goto L18;
        return true;
    L18:
        return false;
    L16:
        throw new InvalidParameterException("register failed,need serviceImpl instance BaseService serviceName:".concat(r100.getName()));
    L17:
        return false;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void sendEvent(String r100, Bundle r101) {
        AppBrandLogger.i("AppContextImpl", new Object[]{"action: " + r100});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public void startActivityForResult(Intent r100, int r101) {
        j18.b r102 = this.f557519f;
        if ((r102 instanceof xxb.a) == false) goto L5;
        fs5.b r103 = ((xxb.a) r102).b();
    L6:
        if (r103 == null) goto L8;
    L15:
        if (r103 == null) goto L17;
        r103.startActivityForResult(r100, r101);
        return;
    L17:
        this.f557515b.startActivityForResult(r100, r101);
        return;
    L8:
        if ((this instanceof mjb.a) == true) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == true) goto L15;
        r103 = this.f557527n;
        goto L15
    L10:
        if (((mjb.a) this).a() == false) goto L12;
        r104 = true;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void unBindDependAppContext(String r100, IAppContext r101) {
        if (r101 == null) goto L5;
        ((ConcurrentHashMap) this.f557534u).remove(r101.getAppId() + r100);
        return;
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final void registerService(Class r100, fs5.c r101) {
        ((ConcurrentHashMap) this.f557522i).put(r100, r101);
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final LKBasePluginResult sendEvent(String r100, JSONObject r101) {
        return sendEvent(r100, r101, null);
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final LKBasePluginResult sendEvent(String r100, JSONObject r101, j18.c r102) {
        j18.b r103 = getCurrentNode();
        if (r103 == null) goto L10;
        LKEvent.b r104 = new LKEvent.b();
        r104.f285504a = r100;
        r104.f285505b = r101;
        r104.f285506c = r103.getContext();
        LKEvent r105 = new LKEvent(r104);
        if (r102 == null) goto L8;
        r105.f285494g = r102;
    L8:
        return sendEvent(r105);
    L10:
        return LKBasePluginResult.f285519f;
    }
}
