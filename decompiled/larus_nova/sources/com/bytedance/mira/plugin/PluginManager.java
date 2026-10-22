package com.bytedance.mira.plugin;

import android.content.pm.ComponentInfo;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParamPre;
import com.bytedance.mira.core.MetaManager;
import com.bytedance.mira.helper.MiraThreadPoolHelper;
import com.bytedance.mira.helper.ProcessHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.IOUtils;
import com.bytedance.mira.util.ManifestUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class PluginManager {
    private static final String TAG = "PluginManager";
    static final long TIMEOUT_LOAD_PLUGIN_MAIN = 3000;
    public static final long TIMEOUT_LOAD_PLUGIN_MAIN_LAUNCH = 10000;
    static final long TIMEOUT_LOAD_PLUGIN_NOT_MAIN = 300000;
    private static volatile PluginManager sInstance;
    private Handler mHandler;
    private volatile boolean mInitialized;
    private ExecutorService mInstallThreadPool;
    private PluginLoader mPluginLoader;
    private volatile Map<String, Plugin> mPlugins;
    private int mUpdateVersionCode;

    private synchronized void parsePluginConfig() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mInitialized == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Map<String, Plugin> r100 = parsePluginConfigLock();     // Catch: Throwable -> L14
        if (r100 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        this.mPlugins = r100;     // Catch: Throwable -> L14
        this.mInitialized = true;     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public boolean isPluginAsHostModule(String r100) {
        return false;
    }

    public static PluginManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(PluginManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new PluginManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PluginManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public List<Plugin> listPluginConfigs() {
        if (this.mInitialized == true) goto L6;
        parsePluginConfig();
    L6:
        return new ArrayList(this.mPlugins.values());
    }

    public List<Plugin> listPlugins() {
        if (this.mInitialized == true) goto L5;
        parsePluginConfig();
    L5:
        Iterator<Plugin> r100 = this.mPlugins.values().iterator();
    L7:
        if (r100.hasNext() == false) goto L10;
        r100.next().init();
        goto L7
    L10:
        return new ArrayList(this.mPlugins.values());
    }

    private PluginManager() {
        this.mUpdateVersionCode = -1;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mPluginLoader = new PluginLoader(this.mHandler);
        MiraParamPre r100 = MiraManager.getInstance().getParamPre();
        if (r100 != null) goto L5;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L12;
        this.mUpdateVersionCode = r100.getHostSupport().getUpdateVersionCode();
        return;
    L12:
        Object r102 = ManifestUtils.get(Mira.getAppContext(), "UPDATE_VERSION_CODE");
        if (r102 == null) goto L17;
        this.mUpdateVersionCode = ((Integer) r102).intValue();
        return;
    L17:
        return;
    L5:
        if (r100.isEnableInitProcessOpt() == false) goto L9;
        if (r100.getHostSupport() == null) goto L9;
        r101 = true;
        goto L10
    }

    public void delayDeleteUnablePlugins() {
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == true) goto L5;
        return;
    L5:
        if (MiraManager.getInstance().getParam().enableDeleteUndeclaredPlugin() == false) goto L9;
        MiraThreadPoolHelper.sSingleThreadPool.schedule(new PluginDeleteRunnable(), 120, TimeUnit.SECONDS);
        MiraLogger.i(MiraLogger.TAG_INIT, "PluginManager schedule delete plugin after 120s");
        return;
    }

    public void initPlugins() {
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == true) goto L5;
        return;
    L5:
        if (this.mInstallThreadPool != null) goto L7;
        this.mInstallThreadPool = MiraThreadPoolHelper.createInstallThreadPool(MiraManager.getInstance().getParam().getInstallThreads());
    L7:
        MiraThreadPoolHelper.sMiraFastExecutor.execute(new PluginScanRunnable());
    }

    public Map<String, Plugin> parsePluginConfigLock() {
        InputStream r100 = Mira.getAppContext().getAssets().open("plugins.json");     // Catch: Exception -> L19
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L19
        IOUtils.copyStream(r100, r101);     // Catch: Exception -> L19
        String r102 = r101.toString();     // Catch: Exception -> L19
        MiraLogger.v(MiraLogger.TAG_INIT, "PluginManager parsePluginsJson, read plugins.json, content=...");     // Catch: Exception -> L19
        ConcurrentHashMap r103 = new ConcurrentHashMap();
        JSONArray r104 = new JSONArray(r102);     // Catch: Exception -> L16
        int r105 = 0;
    L7:
        if (r105 >= r104.length()) goto L14;
        JSONObject r106 = r104.optJSONObject(r105);     // Catch: Exception -> L16
        if (r106 == null) goto L13;
        Plugin r107 = new Plugin(r106);     // Catch: Exception -> L16
        r107.setHandler(this.mHandler);     // Catch: Exception -> L16
        if (r107.isValid() == false) goto L13;
        r103.put(r107.mPackageName, r107);     // Catch: Exception -> L16
    L13:
        r105 = r105 + 1;     // Catch: Exception -> L16
        goto L7
    L14:
        MiraLogger.i(MiraLogger.TAG_INIT, "PluginManager parsePluginsJson, plugins=[" + r103.size() + "]");     // Catch: Exception -> L16
    L18:
        return r103;
    L16:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e);
    L19:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "PluginManager parsePluginsJson read plugins.json failed.", e);
        return null;
    }

    public int getHostUpdateVerCode() {
        return this.mUpdateVersionCode;
    }

    public Handler getMainHandler() {
        return this.mHandler;
    }

    public void asyncInstall(File r100) {
        if (r100 == null) goto L8;
        ExecutorService r101 = this.mInstallThreadPool;
        if (r101 == null) goto L7;
        r101.execute(new PluginInstallRunnable(r100));
    L7:
        MiraLogger.i(MiraLogger.TAG_INSTALL, "PluginManager asyncInstall, file=" + r100);
        return;
    L8:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
    }

    public void delete(String r100) {
        if (getPlugin(r100) == null) goto L6;
        MetaManager.getInst().markDeletedFlag(r100);
        MiraLogger.w(MiraLogger.TAG_INSTALL, "PluginManager mark deleted : " + r100);
        return;
    }

    public Plugin getPlugin(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.mInitialized == true) goto L8;
        parsePluginConfig();
    L8:
        Plugin r101 = this.mPlugins.get(r100);
        if (r101 == null) goto L12;
        r101.init();
        return r101;
    L12:
        return null;
    }

    public void install(File r100) {
        asyncInstall(r100);
    }

    public boolean isInternalPlugin(String r100) {
        Plugin r101 = getPlugin(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isInternalPlugin();
    }

    public boolean isLoaded(String r100) {
        Plugin r101 = getPlugin(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.mLifeCycle != 8) goto L7;
        return true;
    }

    public boolean isPluginPackage(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.mInitialized == true) goto L9;
        parsePluginConfig();
    L9:
        return this.mPlugins.containsKey(r100);
    }

    public boolean loadPlugin(String r100) {
        return this.mPluginLoader.loadPlugin(r100);
    }

    public boolean preload(String r100) {
        return this.mPluginLoader.loadPlugin(r100);
    }

    public void preloadByClassName(String r100) {
        this.mPluginLoader.loadPluginsByClassName(r100);
    }

    public boolean syncInstall(File r100) {
        if (r100 == null) goto L6;
        MiraLogger.i(MiraLogger.TAG_INSTALL, "PluginManager syncInstall file=" + r100);
        return PluginInstallRunnable.install(r100, false);
    L6:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "PluginManager syncInstall apk is null !");
        return false;
    }

    public boolean loadPlugin(String r100, ComponentInfo r101) {
        return this.mPluginLoader.loadPlugin(r100, r101);
    }

    public void asyncInstallCompat(File r100, File r101, String r102) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L9;
        ExecutorService r103 = this.mInstallThreadPool;
        if (r103 == null) goto L8;
        r103.execute(new PluginInstallCompatRunnable(r100, r101, r102));
    L8:
        MiraLogger.i(MiraLogger.TAG_INSTALL, "PluginManager asyncInstallCompat, file=" + r100 + ", soDirPath=" + r101);
        return;
    L9:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "PluginManager asyncInstallCompat apk or soDirPath is null !");
    }

    public boolean syncInstallCompat(File r100, File r101, String r102) {
        if (r100 == null) goto L6;
        MiraLogger.i(MiraLogger.TAG_INSTALL, "PluginManager syncInstallCompat file=" + r100 + ", soDirPath=" + r101);
        return PluginInstallCompatRunnable.install(r100, r101, r102, false);
    L6:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "PluginManager syncInstallCompat apk is null !");
        return false;
    }
}
