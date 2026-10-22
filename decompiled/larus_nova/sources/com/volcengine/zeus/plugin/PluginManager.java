package com.volcengine.zeus.plugin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusPluginStateListener;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import mqc.r;
import mqc.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PluginManager {
    private static final String TAG = "PluginManager";
    private static volatile PluginManager sInstance;
    private volatile boolean hasInstallFromDownloadDir;
    private ExecutorService mInstallThreadPool;
    private volatile boolean mIsParsePluginConfig;
    private volatile Map<String, Plugin> mPlugins;
    private final f pluginLoader;

    private synchronized void parsePluginConfig() {
        monitor-enter(this);
    L42:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsParsePluginConfig == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        ZeusLogger.v(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");     // Catch: Throwable -> L42
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L42
        Bundle r101 = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;     // Catch: Exception -> L38 Throwable -> L42
        Iterator<String> r102 = r101.keySet().iterator();     // Catch: Throwable -> L42
    L11:
        if (r102.hasNext() == false) goto L50;
        String r103 = r102.next();     // Catch: Throwable -> L42
        String r104 = com.volcengine.zeus.g.f462704a;     // Catch: Throwable -> L42
        if (r104.startsWith("PANGLE_") == true) goto L15;
        if (r103.startsWith(r104) == false) goto L11;
        r100.add(r101.getString(r103));     // Catch: Throwable -> L42
        goto L11
    L15:
        if (r103.startsWith(r104) == true) goto L18;
        if (r103.startsWith("ZEUS_PLUGIN_") == false) goto L11;
    L18:
        r100.add(r101.getString(r103));     // Catch: Throwable -> L42
        goto L11
    L50:
        ConcurrentHashMap r105 = new ConcurrentHashMap();     // Catch: Exception -> L33 Throwable -> L42
        Iterator r106 = r100.iterator();     // Catch: Exception -> L33 Throwable -> L42
    L25:
        if (r106.hasNext() == false) goto L31;
        String r107 = (String) r106.next();     // Catch: Exception -> L33 Throwable -> L42
        Plugin r108 = new Plugin(new JSONObject(r107));     // Catch: JSONException -> L29 Exception -> L33 Throwable -> L42
        r105.put(r108.mPkgName, r108);     // Catch: JSONException -> L29 Exception -> L33 Throwable -> L42
        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManagerparsePluginsJson. find " + r108.mPkgName);     // Catch: JSONException -> L29 Exception -> L33 Throwable -> L42
    L29:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + r107.trim(), e);     // Catch: Exception -> L33 Throwable -> L42
        goto L25
    L31:
        this.mPlugins = r105;     // Catch: Exception -> L33 Throwable -> L42
        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");     // Catch: Exception -> L33 Throwable -> L42
    L35:
        this.mIsParsePluginConfig = true;     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L33:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e);     // Catch: Throwable -> L42
        goto L35
    L38:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e);     // Catch: Throwable -> L42
    }

    public Map<String, Plugin> getAllPlugins() {
        return getAllPlugins(true);
    }

    public void reinstallFromDownloadDir() {
        this.hasInstallFromDownloadDir = false;
        installFromDownloadDir(false);
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

    public ExecutorService getInstallThreadPool() {
        if (this.mInstallThreadPool != null) goto L6;
        int r100 = GlobalParam.getInstance().getInstallThreads();
        Executor r101 = dqc.e.f469735a;
        this.mInstallThreadPool = PThreadExecutorsUtils.newFixedThreadPool(r100, new dqc.f());
    L6:
        return this.mInstallThreadPool;
    }

    private PluginManager() {
        this.mPlugins = new ConcurrentHashMap();
        this.pluginLoader = new f();
    }

    private void ensurePluginFileExist(Plugin r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isInstalled() == true) goto L6;
        return;
    L6:
        if (new PolarisFileWrapper(dqc.c.h(r100.mPkgName, r100.getVersion(), false)).exists() == true) goto L11;
        unInstallPackage(r100.mPkgName);
        return;
    }

    public boolean checkPluginInstalled(String r100) {
        Plugin r101 = getPlugin(r100);
        ensurePluginFileExist(r101);
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + r100 + " = " + r102);
        return r102;
    L5:
        if (r101.isInstalled() == false) goto L7;
        r102 = true;
        goto L8
    }

    public Map<String, Plugin> getAllPlugins(boolean r100) {
        if (this.mIsParsePluginConfig == true) goto L5;
        parsePluginConfig();
    L5:
        HashMap r101 = new HashMap(this.mPlugins);
        if (r100 == false) goto L11;
        Iterator r102 = r101.values().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        ((Plugin) r102.next()).init();
    L11:
        return r101;
    }

    public Plugin getPlugin(String r100) {
        return getPlugin(r100, true);
    }

    public synchronized void installFromDownloadDir(boolean r100) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.hasInstallFromDownloadDir == false) goto L9;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginManager zeus has been installFromDownloadDir!");     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L9:
        if (dqc.d.d(Zeus.getAppApplication()) == false) goto L11;
        dqc.e.b(new k(r100));     // Catch: Throwable -> L14
    L11:
        this.hasInstallFromDownloadDir = true;     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public boolean isLoaded(String r100) {
        Plugin r101 = getPlugin(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isLoaded() == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.volcengine.zeus.plugin.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean loadPlugin(String r310) {
        ?? r100 = this.pluginLoader;
        r100.getClass();
        ConcurrentHashMap r101 = (ConcurrentHashMap) f.f462783b;
        Object r102 = r101.get(r310);
        if (r102 != null) goto L8;
        r102 = new Object();
        Object r103 = r101.putIfAbsent(r310, r102);
        if (r103 == null) goto L8;
        Object r110 = r103;
    L9:
        monitor-enter(r110);
    L83:
        th = move-exception;
        throw th;
    L11:
        if (GlobalParam.getInstance().isDebug() == false) goto L21;
        String r104 = dqc.c.g();     // Catch: Throwable -> L83
        if (r104 == null) goto L21;
        File[] r105 = new PolarisFileWrapper(r104).listFiles(new e());     // Catch: Throwable -> L83
        if (r105 == null) goto L21;
        if (r105.length <= 0) goto L21;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "loadPlugin, reject due to a not empty pushDir ".concat(r104));     // Catch: Throwable -> L83
        monitor-exit(r110);     // Catch: Throwable -> L83
        return false;
    L21:
        Plugin r111 = getInstance().getPlugin(r310);     // Catch: Throwable -> L83
        if (r111 != null) goto L27;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = " + r310);     // Catch: Throwable -> L83
        monitor-exit(r110);     // Catch: Throwable -> L83
        return false;
    L27:
        if (r111.isInstalled() == true) goto L32;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, " + r310);     // Catch: Throwable -> L83
        monitor-exit(r110);     // Catch: Throwable -> L83
        return false;
    L32:
        if (r111.isLoaded() == false) goto L35;
        monitor-exit(r110);     // Catch: Throwable -> L83
    L97:
        return true;
    L35:
        f.f462782a.d(2000, 0, r111.mPkgName, r111.getVersion(), null);     // Catch: Throwable -> L83
        fqc.a r106 = new fqc.a(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:" + r310);     // Catch: Throwable -> L83
        ?? r112 = "load_start";
        ?? r113 = 40000(0x9c40, float:5.6052E-41);
        f.g("load_start", 40000, r111.mPkgName, r111.getVersion(), -1, null);     // Catch: Throwable -> L83
        ZeusPluginStateListener.postStateChange(r310, 8, new Object[0]);     // Catch: Throwable -> L83
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L83
        JSONObject r210 = new JSONObject();     // Catch: Throwable -> L83
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L83
    L62:
        th = move-exception;
        r111._isPluginLoading = false;     // Catch: Throwable -> L83
        throw th;     // Catch: Throwable -> L83
    L64:
        e = e;
        r112 = r108;
        r113 = r107;
        fqc.a r211 = r106;
    L66:
        boolean r109 = false;
    L67:
        ?? r114 = r113;
        r114.append("loadPluginInternal recursive loadPlugin detected;");     // Catch: Throwable -> L62
        ?? r115 = r112;
        r115.append(e.getMessage());     // Catch: Throwable -> L62
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + r310 + "] ", e);     // Catch: Throwable -> L62
        r111._isPluginLoading = false;     // Catch: Throwable -> L83
        boolean r116 = false;
        ?? r117 = r114;
        ?? r118 = r115;
    L69:
        fqc.a r119 = r211;
        r119.a(String.format("loadPluginInternal:loadResult=%s,makeComponentResult=%s", new Object[]{Boolean.valueOf(r109), Boolean.valueOf(r116)}));     // Catch: Throwable -> L83
        if (r109 == false) goto L73;
        if (r116 == false) goto L73;
        r111.setLoaded(true);     // Catch: Throwable -> L83
        f.g("load_finish", 41000, r111.mPkgName, r111.getVersion(), System.currentTimeMillis() - r119.f478479d, r117.toString());     // Catch: Throwable -> L83
        ZeusPluginStateListener.postStateChange(r310, 9, new Object[0]);     // Catch: Throwable -> L83
        f.f462782a.d(2100, 0, r111.mPkgName, r111.getVersion(), null);     // Catch: Throwable -> L83
        r.b(r111.mPkgName, r111.getVersion(), "load_plugin", "success", 0, "");     // Catch: Throwable -> L83
        r.a(r111.mPkgName, Integer.valueOf(r111.getVersion()), "load_plugin", System.currentTimeMillis() - r119.f478479d, r210);     // Catch: Throwable -> L83
    L74:
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, " + r111);     // Catch: Throwable -> L83
        if (r111.isLoaded() == false) goto L79;
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + r111.mPkgName);     // Catch: Throwable -> L83
        monitor-exit(r110);     // Catch: Throwable -> L83
        goto L97
    L79:
        monitor-exit(r110);     // Catch: Throwable -> L83
        return false;
    L73:
        r117.append("plugin:");     // Catch: Throwable -> L83
        r117.append(r111.mPkgName);     // Catch: Throwable -> L83
        r117.append(" versionCode:");     // Catch: Throwable -> L83
        r117.append(r111.getVersion());     // Catch: Throwable -> L83
        r117.append("load failed;");     // Catch: Throwable -> L83
        f.g("load_finish", 42000, r111.mPkgName, r111.getVersion(), -1, r117.toString());     // Catch: Throwable -> L83
        ZeusPluginStateListener.postStateChange(r310, 10, new Object[]{r117.toString()});     // Catch: Throwable -> L83
        f.f462782a.d(2100, -1, r111.mPkgName, r111.getVersion(), null);     // Catch: Throwable -> L83
        r.b(r111.mPkgName, r111.getVersion(), "load_plugin", "fail", 0, r118.toString());     // Catch: Throwable -> L83
        goto L74
    L91:
        if (r111._isPluginLoading == true) goto L59;
        r111._isPluginLoading = true;     // Catch: Throwable -> L62 RecursiveLoadPluginException -> L64
        r112 = r108;
        r113 = r107;
        r211 = r106;
        r109 = r100.d(r310, r111, r107, r210, r112);     // Catch: RecursiveLoadPluginException -> L60 Throwable -> L62
        Runnable r120 = (Runnable) ((ConcurrentHashMap) f.f462784c).remove(r310);     // Catch: RecursiveLoadPluginException -> L55 Throwable -> L62
        if (r109 == false) goto L52;
        if (r120 == null) goto L52;
        r120.run();     // Catch: RuntimeException -> L46 Throwable -> L62
        r116 = true;
    L53:
        r111._isPluginLoading = false;     // Catch: Throwable -> L83
        r118 = r112;
        r117 = r113;
    L46:
        e = move-exception;
        RuntimeException r121 = e;
        Throwable r122 = r121.getCause();     // Catch: RecursiveLoadPluginException -> L55 Throwable -> L62
        RuntimeException r123 = r121;
        if (r122 == null) goto L51;
        r123 = r121.getCause();     // Catch: RecursiveLoadPluginException -> L55 Throwable -> L62
    L51:
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, makeComponentTask run, e = " + r123, r123);     // Catch: RecursiveLoadPluginException -> L55 Throwable -> L62
    L52:
        r116 = false;
    L55:
        e = e;
        goto L67
    L59:
        throw new RecursiveLoadPluginException("load plugin during loading plugin!");     // Catch: RecursiveLoadPluginException -> L60 Throwable -> L62
    L60:
        e = e;
    L8:
        r110 = r102;
        goto L9
    }

    public boolean tryLoadPluginFromInstallStateSnapshot(String r100) {
        Plugin r101 = getPlugin(r100, false);
        if (r101 != null) goto L7;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginManager tryLoadPluginFromInstallStateSnapshot, plugin == null, pkg = " + r100);
        return false;
    L7:
        if (r101.isLoaded() == false) goto L11;
        return true;
    L11:
        if (r101.tryUpdateInstallStateFromSnapshotOnly() == true) goto L15;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginManager tryLoadPluginFromInstallStateSnapshot, snapshot unavailable, pkg = " + r100);
        return false;
    L15:
        return loadPlugin(r100);
    }

    public void unInstallPackage(String r100) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, " + r100);
        Plugin r101 = getPlugin(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (GlobalParam.getInstance().enableCreateInstallStateSnapshot() == false) goto L7;
        d.d(r100, r101.getApiVersionCode());
    L8:
        SharedPreferences.Editor r102 = t.c().f514970a.edit();
        r102.putBoolean("UNINSTALL__" + r100, true);
        r102.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=" + r100);
        return;
    L7:
        d.a(r100);
        goto L8
    }

    public Plugin getPlugin(String r100, boolean r101) {
        if (Zeus.hasInit() == true) goto L14;
        if ((Zeus.getAppApplication().getApplicationInfo().flags & 2) == 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L14;
        throw new RuntimeException("Please init Zeus first!");
    L8:
        r102 = false;
    L14:
        if (TextUtils.isEmpty(r100) == false) goto L18;
        return null;
    L18:
        if (this.mIsParsePluginConfig == true) goto L20;
        parsePluginConfig();
    L20:
        Plugin r103 = this.mPlugins.get(r100);
        if (r101 == false) goto L24;
        if (r103 == null) goto L24;
        r103.init();
    L24:
        return r103;
    }

    public void tryOfflineInternalPlugin(String r100, int r101) {
        Plugin r102 = getPlugin(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getInternalVersionCode() != r101) goto L9;
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager offlineInternalPlugin, pkgName:" + r100 + " pluginVer:" + r101 + " apiVer:" + r102.getApiVersionCode());
        t r103 = t.c();
        int r104 = r102.getApiVersionCode();
        SharedPreferences.Editor r105 = r103.f514970a.edit();
        StringBuilder r106 = new StringBuilder("OFFLINE_INTERNAL_");
        r106.append(r100);
        r105.putInt(r106.toString(), r104);
        r105.apply();
        return;
    }

    public void asyncInstall(String r100, File r101, String r102) {
        asyncInstall(r100, r101, null, r102);
    }

    public void setAllowDownloadPlugin(String r100, int r101, boolean r102) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager setAllowDownloadPlugin, " + r100 + " " + r101 + " " + r102);
        if (getPlugin(r100) == null) goto L10;
        boolean r103 = !r102;
        SharedPreferences.Editor r104 = t.c().f514970a.edit();
        String r105 = "DISABLE_DOWNLOAD_" + r100 + "_" + r101;
        if (r103 == false) goto L7;
        r104.putInt(r105, 0);
    L8:
        r104.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + r100 + " version=" + r101 + " disable=" + r103);
        return;
    L7:
        r104.remove(r105);
        goto L8
    }

    public boolean syncInstall(String r100, File r101, String r102) {
        return syncInstall(r100, r101, null, r102);
    }

    public void asyncInstall(String r100, File r101, String r102, String r103) {
        if (r101 == null) goto L5;
        getInstallThreadPool().execute(new c(r100, r101, r102, r103));
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=" + r101 + " source=" + r103);
        return;
    L5:
        ZeusPluginStateListener.postStateChange(r100, 7, new Object[]{"asyncInstall apk is null !"});
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
    }

    public boolean syncInstall(String r100, File r101, String r102, String r103) {
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=" + r101 + " identity=" + r102 + " source=" + r103);
        return new c(r100, r101, r102, r103).a();
    }
}
