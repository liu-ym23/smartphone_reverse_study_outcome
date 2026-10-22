package com.bytedance.pitaya.api;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.bytedance.librarian.a;
import com.bytedance.pitaya.api.bean.PTYProxySetting;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.larus.utils.logger.FLogger;
import com.ss.android.common.applog.AppLog;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import e57.b;
import f57.c;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\b\u0010\u0013\u001a\u00020\u0012H\u0007J\b\u0010\u0014\u001a\u00020\u0006H\u0007J\b\u0010\u0015\u001a\u00020\u0006H\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007R\u001a\u0010\u0017\u001a\u00020\t8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/pitaya/api/PitayaProxy;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/pitaya/api/bean/PTYProxySetting;", "setting", "", "init", "isFeatureStoreProxyEnabled", "", "eventName", "extParams", "", "onAppLogEvent", "Lorg/json/JSONObject;", "Lcom/bytedance/pitaya/api/PTYApplogImplCallback;", "callback", "processApplogCache", "", "applogCacheSize", "loadProxySo", "loadProxySoImpl", "isValidEvent", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "initOnce", "Z", "mSetting", "Lcom/bytedance/pitaya/api/bean/PTYProxySetting;", "Lcom/bytedance/pitaya/api/PitayaApplogProxy;", "applogProxy", "Lcom/bytedance/pitaya/api/PitayaApplogProxy;", "isProxySoLoaded", "hasProxySoLoadFailed", "Lf57/c;", "eventVerify", "Lf57/c;", "getEventVerify", "()Lf57/c;", "setEventVerify", "(Lf57/c;)V", "<init>", "()V", "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public final class PitayaProxy implements ReflectionCall {
    public static final PitayaProxy INSTANCE = null;
    private static final String TAG = null;
    private static volatile PitayaApplogProxy applogProxy;
    private static volatile c eventVerify;
    private static volatile boolean hasProxySoLoadFailed;
    private static volatile boolean initOnce;
    private static volatile boolean isProxySoLoaded;
    private static volatile PTYProxySetting mSetting;

    private PitayaProxy() {
    }

    public static /* synthetic */ void a(String r100, String r101, String r102, long r103, long r104, boolean r105, String r106) {
        init$lambda$2(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static /* synthetic */ void b() {
        loadProxySo$lambda$3();
    }

    static {
        INSTANCE = new PitayaProxy();
        TAG = "PTY-Proxy";
    }

    @JvmStatic
    public static final int applogCacheSize() {
        PitayaApplogProxy r100 = applogProxy;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.cacheSize();
    }

    @JvmStatic
    public static final boolean isFeatureStoreProxyEnabled() {
        if (initOnce == true) goto L5;
        return false;
    L5:
        PTYProxySetting r100 = mSetting;
        if (r100 == null) goto L8;
        boolean r101 = r100.getFeatureStoreProxyEnabled();
    L9:
        if (r101 == true) goto L11;
        return false;
    L11:
        if (loadProxySo() == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        r101 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean loadProxySo() {
        if (isProxySoLoaded == false) goto L7;
        return true;
    L7:
        if (hasProxySoLoadFailed == false) goto L10;
        return false;
    L10:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L14;
        ThreadMethodProxy.start(new PthreadThreadV2(new b(), "i/PitayaProxy"));
        return false;
    L14:
        return loadProxySoImpl();
    }

    @JvmStatic
    public static final boolean loadProxySoImpl() {
        PitayaProxy r100 = INSTANCE;
        monitor-enter(r100);
    L10:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L15
        hasProxySoLoadFailed = true;     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    L6:
        if (isProxySoLoaded == true) goto L8;
        INVOKESTATIC_com_bytedance_pitaya_api_PitayaProxy_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("AndroidPitayaProxy");     // Catch: Throwable -> L10
        isProxySoLoaded = true;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);
        return true;
    }

    private static final void loadProxySo$lambda$3() {
        loadProxySoImpl();
    }

    public final c getEventVerify() {
        return eventVerify;
    }

    public final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_pitaya_api_PitayaProxy_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @JvmStatic
    public static final boolean isValidEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        c r101 = eventVerify;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isValidEvent(r100);
    }

    @JvmStatic
    public static final void processApplogCache(PTYApplogImplCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        PitayaApplogProxy r101 = applogProxy;
        if (r101 == null) goto L5;
        r101.storeCache(r100);
    L5:
        applogProxy = null;
    }

    public final void setEventVerify(c r100) {
        eventVerify = r100;
    }

    @JvmStatic
    public static final boolean init(Context r100, PTYProxySetting r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "setting");
        PitayaProxy r102 = INSTANCE;
        monitor-enter(r102);
    L35:
        th = move-exception;
        throw th;
    L5:
        if (initOnce == false) goto L10;
        monitor-exit(r102);
        return false;
    L10:
        initOnce = true;     // Catch: Throwable -> L35
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r102);
        g57.a r104 = g57.a.f480053a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        WeakReference<Context> r105 = g57.a.f480054b;
        if (r105 == null) goto L18;
        if (r105.get() == null) goto L18;
    L22:
        mSetting = r101;
        if (r101.getApplogProxyEnabled() == false) goto L34;
        applogProxy = new PitayaApplogProxy();
        PitayaApplogProxy r106 = applogProxy;
        if (r106 == null) goto L27;
        Boolean r107 = Boolean.valueOf(r106.init(r101));
    L29:
        if (Intrinsics.areEqual(r107, Boolean.FALSE) == false) goto L31;
        applogProxy = null;
        goto L34
    L31:
        eventVerify = applogProxy;
        if (r101.getProvideAppLog() == true) goto L34;
        AppLog.f408004g0.z(new e57.c());
        goto L34
    L27:
        r107 = null;
    L34:
        return true;
    L18:
        if ((r100 instanceof Application) == false) goto L20;
        WeakReference<Context> r108 = new WeakReference(((Application) r100).getBaseContext());
    L21:
        g57.a.f480054b = r108;
        goto L22
    L20:
        r108 = new WeakReference(r100);
        goto L21
    }

    @JvmStatic
    public static final void onAppLogEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        PitayaApplogProxy r102 = applogProxy;
        if (r102 == null) goto L6;
        r102.onEvent(r100, r101);
        return;
    }

    @JvmStatic
    public static final void onAppLogEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        PitayaApplogProxy r102 = applogProxy;
        if (r102 == null) goto L6;
        r102.onEvent(r100, r101);
        return;
    }

    private static final void init$lambda$2(String r100, String r101, String r102, long r103, long r104, boolean r105, String r106) {
        if (r101 == null) goto L7;
        PitayaApplogProxy r107 = applogProxy;
        if (r107 == null) goto L8;
        r107.onEvent(r101, r106);
        return;
    L8:
        return;
    }
}
