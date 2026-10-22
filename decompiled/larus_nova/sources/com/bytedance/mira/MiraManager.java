package com.bytedance.mira;

import android.app.Application;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import com.bytedance.mira.core.MiraResourcesManager;
import com.bytedance.mira.factory.LoadedApkFactory;
import com.bytedance.mira.factory.NativeClassLoaderManager;
import com.bytedance.mira.helper.ActivityThreadHelper;
import com.bytedance.mira.helper.AppStateHelper;
import com.bytedance.mira.helper.ClassLoaderHelper;
import com.bytedance.mira.helper.MiraThreadPoolHelper;
import com.bytedance.mira.helper.ProcessHelper;
import com.bytedance.mira.hook.MiraHookManager;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mira.oat.BackgroundDexOatService;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mira.plugin.trip.opt.Turbo;
import com.bytedance.mira.util.ClassUtil;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.NeedLoadPluginUtil;
import com.bytedance.mira.util.OSUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class MiraManager {
    private static final String TAG = "MiraManager";
    private static volatile MiraManager sInstance;
    private boolean mAppOnCreatedEnd;
    private MiraHandlerMsgInterceptor mHandlerMsgInterceptor;
    private boolean mInit;
    private boolean mInitPre;
    private MiraInstrumentationCallback mInstrumentationCallback;
    private MiraErrorReporter mMiraErrorReporter;
    private MiraParam mMiraParam;
    private MiraParamPre mMiraParamPre;
    private List<MiraPluginBeforeLoadListener> mPluginEventBeforeLoadListeners;
    private List<MiraPluginEventListener> mPluginEventListeners;
    private List<MiraPluginLifeListener> mPluginLifeListeners;
    private List<MiraProxyReceiverCallback> mRegisterReceiverCallbacks;
    private boolean mStart;
    private List<MiraProxyActivityCallback> mStartActivityCallbacks;

    public synchronized boolean isInit() {
        monitor-enter(this);
        boolean r100 = this.mInit;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    private void disableApiWarningShownForAndroidP() {
        FieldUtils.writeField(ActivityThreadHelper.currentActivityThread(), "mHiddenApiWarningShown", Boolean.TRUE);     // Catch: Exception -> L5
        MiraLogger.w(MiraLogger.TAG_INIT, "MiraManager disableApiWarningShownForAndroidP, true");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
    }

    public static MiraManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(MiraManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new MiraManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MiraManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void removeNotExistProvider() {
        List<ProviderInfo> r100 = ActivityThreadHelper.getProviders();     // Catch: Exception -> L15
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.size() <= 0) goto L26;
        Iterator<ProviderInfo> r101 = r100.iterator();     // Catch: Exception -> L15
    L9:
        if (r101.hasNext() == false) goto L13;
        ProviderInfo r102 = r101.next();     // Catch: Exception -> L15
        if (ClassUtil.isExist(r102.name) == true) goto L9;
        MiraLogger.w(MiraLogger.TAG_INIT, "MiraManager ContentProvider not exist: " + r102.name);     // Catch: Exception -> L15
        r101.remove();     // Catch: Exception -> L15
        goto L9
    L13:
        MiraLogger.i(MiraLogger.TAG_INIT, "MiraManager protectProviders, size = " + r100.size());     // Catch: Exception -> L15
        return;
    L26:
        return;
    L15:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "MiraManager protectProviders failed.", e);
    }

    public synchronized void startHook() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mStart == false) goto L7;
    L17:
        monitor-exit(this);
        return;
    L7:
        if (this.mMiraParam.isEnable() == false) goto L17;
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L19
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == false) goto L12;
    L13:
        MiraLogger.i(MiraLogger.TAG_INIT, "MiraManager start hook in process : " + ProcessHelper.getCurrentProcessName(Mira.getAppContext()));     // Catch: Throwable -> L19
        MiraHookManager.getInstance().installNeedHook();     // Catch: Throwable -> L19
        MiraMonitor.sTimeStart = System.currentTimeMillis() - r100;     // Catch: Throwable -> L19
    L14:
        this.mStart = true;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L12:
        if (ProcessHelper.isPluginProcess(Mira.getAppContext()) == false) goto L14;
        goto L13
    }

    private MiraManager() {
        this.mRegisterReceiverCallbacks = Collections.emptyList();
        this.mStartActivityCallbacks = Collections.emptyList();
        this.mPluginEventListeners = Collections.emptyList();
        this.mPluginLifeListeners = Collections.emptyList();
        this.mPluginEventBeforeLoadListeners = Collections.emptyList();
    }

    public MiraHandlerMsgInterceptor getHandlerMsgInterceptor() {
        return this.mHandlerMsgInterceptor;
    }

    public MiraInstrumentationCallback getInstrumentationCallback() {
        return this.mInstrumentationCallback;
    }

    public MiraErrorReporter getMiraErrorReporter() {
        return this.mMiraErrorReporter;
    }

    public List<MiraProxyActivityCallback> getMiraProxyActivityCallback() {
        return this.mStartActivityCallbacks;
    }

    public List<MiraProxyReceiverCallback> getMiraProxyReceiverCallback() {
        return this.mRegisterReceiverCallbacks;
    }

    public MiraParam getParam() {
        return this.mMiraParam;
    }

    public MiraParamPre getParamPre() {
        return this.mMiraParamPre;
    }

    public List<MiraPluginBeforeLoadListener> getPluginEventBeforeLoadListeners() {
        return this.mPluginEventBeforeLoadListeners;
    }

    public List<MiraPluginEventListener> getPluginEventListeners() {
        return this.mPluginEventListeners;
    }

    public List<MiraPluginLifeListener> getPluginLifeListeners() {
        return this.mPluginLifeListeners;
    }

    public boolean isAppOnCreatedEnd() {
        return this.mAppOnCreatedEnd;
    }

    private void asyncNewMiraResourcesInstall(final Context r100) {
        MiraThreadPoolHelper.sMiraFastExecutor.execute(new AnonymousClass1(this, r100));
    }

    public synchronized void initPre(MiraParamPre r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mInitPre == false) goto L9;
        MiraLogger.w(MiraLogger.TAG_INIT, "MiraManager mira init pre has been inited!");     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        this.mMiraParamPre = r100;     // Catch: Throwable -> L12
        MiraLogger.i(MiraLogger.TAG_INIT, "MiraManager init pre, miraParamPre = " + r100);     // Catch: Throwable -> L12
        this.mInitPre = true;     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public void registerMiraProxyActivityCallback(MiraProxyActivityCallback r100) {
        if (this.mStartActivityCallbacks.isEmpty() == false) goto L5;
        this.mStartActivityCallbacks = new CopyOnWriteArrayList();
    L5:
        this.mStartActivityCallbacks.add(r100);
    }

    public void registerMiraProxyReceiverCallback(MiraProxyReceiverCallback r100) {
        if (this.mRegisterReceiverCallbacks.isEmpty() == false) goto L5;
        this.mRegisterReceiverCallbacks = new CopyOnWriteArrayList();
    L5:
        this.mRegisterReceiverCallbacks.add(r100);
    }

    public void registerPluginEventBeforeLoadListener(MiraPluginBeforeLoadListener r100) {
        if (this.mPluginEventBeforeLoadListeners.isEmpty() == false) goto L5;
        this.mPluginEventBeforeLoadListeners = new CopyOnWriteArrayList();
    L5:
        this.mPluginEventBeforeLoadListeners.add(r100);
    }

    public void registerPluginEventListener(MiraPluginEventListener r100) {
        if (this.mPluginEventListeners.isEmpty() == false) goto L5;
        this.mPluginEventListeners = new CopyOnWriteArrayList();
    L5:
        this.mPluginEventListeners.add(r100);
    }

    public void registerPluginLifeListener(MiraPluginLifeListener r100) {
        if (this.mPluginLifeListeners.isEmpty() == false) goto L5;
        this.mPluginLifeListeners = new CopyOnWriteArrayList();
    L5:
        this.mPluginLifeListeners.add(r100);
    }

    public void setAppOnCreatedEnd(boolean r100) {
        this.mAppOnCreatedEnd = r100;
    }

    public void setHandlerMsgInterceptor(MiraHandlerMsgInterceptor r100) {
        this.mHandlerMsgInterceptor = r100;
    }

    public void setInstrumentationCallback(MiraInstrumentationCallback r100) {
        this.mInstrumentationCallback = r100;
    }

    public void setMiraErrorReporter(MiraErrorReporter r100) {
        this.mMiraErrorReporter = r100;
    }

    public void setStarted(boolean r100) {
        this.mStart = r100;
    }

    public void unregisterMiraProxyActivityCallback(MiraProxyActivityCallback r100) {
        List<MiraProxyActivityCallback> r101 = this.mStartActivityCallbacks;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(r100) == false) goto L9;
        this.mStartActivityCallbacks.remove(r100);
        return;
    }

    public void unregisterMiraProxyReceiverCallback(MiraProxyReceiverCallback r100) {
        List<MiraProxyReceiverCallback> r101 = this.mRegisterReceiverCallbacks;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(r100) == false) goto L9;
        this.mRegisterReceiverCallbacks.remove(r100);
        return;
    }

    public void unregisterPluginEventBeforeLoadListener(MiraPluginBeforeLoadListener r100) {
        List<MiraPluginBeforeLoadListener> r101 = this.mPluginEventBeforeLoadListeners;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(r100) == false) goto L9;
        this.mPluginEventBeforeLoadListeners.remove(r100);
        return;
    }

    public void unregisterPluginEventListener(MiraPluginEventListener r100) {
        List<MiraPluginEventListener> r101 = this.mPluginEventListeners;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(r100) == false) goto L9;
        this.mPluginEventListeners.remove(r100);
        return;
    }

    public void unregisterPluginLifeListener(MiraPluginLifeListener r100) {
        List<MiraPluginLifeListener> r101 = this.mPluginLifeListeners;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(r100) == false) goto L9;
        this.mPluginLifeListeners.remove(r100);
        return;
    }

    public synchronized void init(Application r100, MiraParam r110) {
        monitor-enter(this);
    L80:
        th = move-exception;
        throw th;
    L5:
        if (this.mInit == false) goto L9;
        MiraLogger.w(MiraLogger.TAG_INIT, "MiraManager mira has been inited!");     // Catch: Throwable -> L80
        monitor-exit(this);
        return;
    L9:
        if (r110 != null) goto L11;
        int r101 = 4;
    L12:
        MiraLogger.setLogLevel(r101);     // Catch: Throwable -> L80
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L80
        if (r100 == null) goto L79;
        if (r110 != null) goto L16;
        r110 = new MiraParam.Builder().build();     // Catch: Throwable -> L80
        MiraLogger.i(MiraLogger.TAG_INIT, "MiraManager init, use default MiraParam");     // Catch: Throwable -> L80
    L16:
        this.mMiraParam = r110;     // Catch: Throwable -> L80
        MiraLogger.setDebug(r110.isDebug());     // Catch: Throwable -> L80
        MiraLogger.i(MiraLogger.TAG_INIT, "MiraManager init, context = " + r100 + ", miraParam = " + r110);     // Catch: Throwable -> L80
        boolean r103 = LoadedApkFactory.expansionMaps();     // Catch: Throwable -> L80
        StringBuilder r104 = new StringBuilder("MiraManager expand, loaded apk maps size result=");     // Catch: Throwable -> L80
        r104.append(r103);     // Catch: Throwable -> L80
        MiraLogger.i(MiraLogger.TAG_INIT, r104.toString());     // Catch: Throwable -> L80
        if (this.mMiraParam.getSupportPluginProcNames().size() <= 0) goto L20;
        MiraLogger.i(MiraLogger.TAG_INIT, "MiraManager addPluginProcNames");     // Catch: Throwable -> L80
        ProcessHelper.addPluginProcNames(r110.getSupportPluginProcNames());     // Catch: Throwable -> L80
    L20:
        if (this.mMiraParam.fastDex2Oat() == false) goto L25;
        if (ProcessHelper.isMainProcess(r100) == false) goto L25;
        MiraLogger.i(MiraLogger.TAG_INIT, "MiraManager initFastDex2Oat");     // Catch: Throwable -> L80
        r100.registerActivityLifecycleCallbacks(AppStateHelper.getsInstance());     // Catch: Throwable -> L80
        BackgroundDexOatService.getInstance().install(6);     // Catch: Throwable -> L80
    L25:
        if (this.mMiraParam.isEnable() == false) goto L75;
        boolean r105 = false;
        if (ProcessHelper.isMainProcess(r100) == false) goto L29;
    L32:
        boolean r111 = true;
    L33:
        if (r111 == false) goto L71;
        MiraLogger.i(MiraLogger.TAG_INIT, "MiraManager init process : " + ProcessHelper.getCurrentProcessName(r100));     // Catch: Throwable -> L80
        if (OSUtil.isAndroidPHigher() == false) goto L38;
        disableApiWarningShownForAndroidP();     // Catch: Throwable -> L80
    L38:
        if (this.mMiraParam.shareRes() == false) goto L43;
        if (this.mMiraParam.enableOptResourcesArch() == true) goto L43;
        MiraResourcesManager.replaceApplicationRes(r100);     // Catch: Throwable -> L80
    L43:
        if (this.mMiraParam.classLoaderHook() == false) goto L46;
        MiraHookManager.getInstance().installMiraClassLoader();     // Catch: Throwable -> L80
    L46:
        if (this.mMiraParam.enableNativeClassLoaderOpt() == true) goto L48;
    L52:
        NeedLoadPluginUtil.initConfig(this.mMiraParam.isEnableOptNeedLoadPluginCheck());     // Catch: Throwable -> L80
        if (this.mMiraParam.isEnableOptFindClassDispatch() == true) goto L55;
    L57:
        PluginManager.getInstance().initPlugins();     // Catch: Throwable -> L80
        if (this.mMiraParam.isEnableOptCrc32() == false) goto L60;
    L63:
        r105 = true;
    L64:
        if (r105 == false) goto L67;
        Turbo.init(new Turbo.ConfigBuilder().build());     // Catch: Throwable -> L80
    L67:
        if (this.mMiraParam.shareRes() == false) goto L73;
        if (this.mMiraParam.enableOptResourcesArch() == false) goto L73;
        asyncNewMiraResourcesInstall(r100);     // Catch: Throwable -> L80
    L73:
        if (this.mMiraParam.supportRegisterProviderInHost() == false) goto L75;
        removeNotExistProvider();     // Catch: Throwable -> L80
        goto L75
    L60:
        if (this.mMiraParam.isEnableClassDefOpt() == false) goto L64;
        if (ProcessHelper.isMainProcess(r100) == false) goto L64;
    L55:
        if (this.mMiraParam.isOpenMiraOpt() == false) goto L57;
        MiraLogger.i(MiraLogger.TAG_INIT, "MiraManager isEnableOptFindClassDispatch");     // Catch: Throwable -> L80
        ClassLoaderHelper.inject(true, this.mMiraParam.getRedirectClassMap());     // Catch: Throwable -> L80
        goto L57
    L48:
        if (Build.VERSION.SDK_INT < 23) goto L52;
        if (this.mMiraParam.isOpenMiraOpt() == false) goto L52;
        MiraLogger.i(MiraLogger.TAG_INIT, "MiraManager enableNativeClassLoaderOpt");     // Catch: Throwable -> L80
        NativeClassLoaderManager.init();     // Catch: Throwable -> L80
        goto L52
    L71:
        MiraLogger.i(MiraLogger.TAG_INIT, "MiraManager can not init process : " + ProcessHelper.getCurrentProcessName(r100));     // Catch: Throwable -> L80
        goto L73
    L29:
        if (ProcessHelper.isPluginProcess(r100) == true) goto L32;
        r111 = false;
    L75:
        MiraMonitor.sTimeInit = System.currentTimeMillis() - r102;     // Catch: Throwable -> L80
        MiraThreadPoolHelper.sSingleThreadPool.schedule(new MiraMonitor(), 30, TimeUnit.SECONDS);     // Catch: Throwable -> L80
        this.mInit = true;     // Catch: Throwable -> L80
        monitor-exit(this);
        return;
    L79:
        throw new IllegalArgumentException("context must be not null !!!");     // Catch: Throwable -> L80
    L11:
        r101 = r110.getLogLevel();     // Catch: Throwable -> L80
        goto L12
    }
}
