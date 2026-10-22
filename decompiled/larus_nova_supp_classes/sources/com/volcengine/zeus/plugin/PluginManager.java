package com.volcengine.zeus.plugin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusPluginStateListener;
import com.volcengine.zeus.g;
import com.volcengine.zeus.log.ZeusLogger;
import dqc.c;
import dqc.d;
import dqc.e;
import fqc.a;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L42
        Bundle r1 = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;     // Catch: Exception -> L38 Throwable -> L42
        Iterator<String> r2 = r1.keySet().iterator();     // Catch: Throwable -> L42
    L11:
        if (r2.hasNext() == false) goto L50;
        String r3 = r2.next();     // Catch: Throwable -> L42
        String r4 = g.a;     // Catch: Throwable -> L42
        if (r4.startsWith("PANGLE_") == true) goto L15;
        if (r3.startsWith(r4) == false) goto L11;
        r0.add(r1.getString(r3));     // Catch: Throwable -> L42
        goto L11
    L15:
        if (r3.startsWith(r4) == true) goto L18;
        if (r3.startsWith("ZEUS_PLUGIN_") == false) goto L11;
    L18:
        r0.add(r1.getString(r3));     // Catch: Throwable -> L42
        goto L11
    L50:
        ConcurrentHashMap r5 = new ConcurrentHashMap();     // Catch: Exception -> L33 Throwable -> L42
        Iterator r6 = r0.iterator();     // Catch: Exception -> L33 Throwable -> L42
    L25:
        if (r6.hasNext() == false) goto L31;
        String r7 = (String) r6.next();     // Catch: Exception -> L33 Throwable -> L42
        Plugin r8 = new Plugin(new JSONObject(r7));     // Catch: JSONException -> L29 Exception -> L33 Throwable -> L42
        r5.put(r8.mPkgName, r8);     // Catch: JSONException -> L29 Exception -> L33 Throwable -> L42
        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManagerparsePluginsJson. find " + r8.mPkgName);     // Catch: JSONException -> L29 Exception -> L33 Throwable -> L42
    L29:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + r7.trim(), e);     // Catch: Exception -> L33 Throwable -> L42
        goto L25
    L31:
        this.mPlugins = r5;     // Catch: Exception -> L33 Throwable -> L42
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
        int r0 = GlobalParam.getInstance().getInstallThreads();
        Executor r1 = e.a;
        this.mInstallThreadPool = PThreadExecutorsUtils.newFixedThreadPool(r0, new dqc.f());
    L6:
        return this.mInstallThreadPool;
    }

    private PluginManager() {
        this.mPlugins = new ConcurrentHashMap();
        this.pluginLoader = new f();
    }

    private void ensurePluginFileExist(Plugin r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isInstalled() == true) goto L6;
        return;
    L6:
        if (new PolarisFileWrapper(c.h(r4.mPkgName, r4.getVersion(), false)).exists() == true) goto L11;
        unInstallPackage(r4.mPkgName);
        return;
    }

    public boolean checkPluginInstalled(String r4) {
        Plugin r0 = getPlugin(r4);
        ensurePluginFileExist(r0);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + r4 + " = " + r1);
        return r1;
    L5:
        if (r0.isInstalled() == false) goto L7;
        r1 = true;
        goto L8
    }

    public Map<String, Plugin> getAllPlugins(boolean r3) {
        if (this.mIsParsePluginConfig == true) goto L5;
        parsePluginConfig();
    L5:
        HashMap r0 = new HashMap(this.mPlugins);
        if (r3 == false) goto L11;
        Iterator r4 = r0.values().iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        ((Plugin) r4.next()).init();
    L11:
        return r0;
    }

    public Plugin getPlugin(String r2) {
        return getPlugin(r2, true);
    }

    public synchronized void installFromDownloadDir(boolean r2) {
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
        if (d.d(Zeus.getAppApplication()) == false) goto L11;
        e.b(new k(r2));     // Catch: Throwable -> L14
    L11:
        this.hasInstallFromDownloadDir = true;     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public boolean isLoaded(String r1) {
        Plugin r2 = getPlugin(r1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.isLoaded() == false) goto L7;
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
    public boolean loadPlugin(String r35) {
        ?? r2 = this.pluginLoader;
        r2.getClass();
        ConcurrentHashMap r6 = (ConcurrentHashMap) f.b;
        Object r7 = r6.get(r35);
        if (r7 != null) goto L8;
        r7 = new Object();
        Object r8 = r6.putIfAbsent(r35, r7);
        if (r8 == null) goto L8;
        Object r13 = r8;
    L9:
        monitor-enter(r13);
    L83:
        th = move-exception;
        throw th;
    L11:
        if (GlobalParam.getInstance().isDebug() == false) goto L21;
        String r9 = c.g();     // Catch: Throwable -> L83
        if (r9 == null) goto L21;
        File[] r10 = new PolarisFileWrapper(r9).listFiles(new e());     // Catch: Throwable -> L83
        if (r10 == null) goto L21;
        if (r10.length <= 0) goto L21;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "loadPlugin, reject due to a not empty pushDir ".concat(r9));     // Catch: Throwable -> L83
        monitor-exit(r13);     // Catch: Throwable -> L83
        return false;
    L21:
        Plugin r15 = getInstance().getPlugin(r35);     // Catch: Throwable -> L83
        if (r15 != null) goto L27;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = " + r35);     // Catch: Throwable -> L83
        monitor-exit(r13);     // Catch: Throwable -> L83
        return false;
    L27:
        if (r15.isInstalled() == true) goto L32;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, " + r35);     // Catch: Throwable -> L83
        monitor-exit(r13);     // Catch: Throwable -> L83
        return false;
    L32:
        if (r15.isLoaded() == false) goto L35;
        monitor-exit(r13);     // Catch: Throwable -> L83
    L97:
        return true;
    L35:
        f.a.d(2000, 0, r15.mPkgName, r15.getVersion(), null);     // Catch: Throwable -> L83
        a r11 = new a(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:" + r35);     // Catch: Throwable -> L83
        ?? r16 = "load_start";
        ?? r17 = 40000(0x9c40, float:5.6052E-41);
        f.g("load_start", 40000, r15.mPkgName, r15.getVersion(), -1, null);     // Catch: Throwable -> L83
        ZeusPluginStateListener.postStateChange(r35, 8, new Object[0]);     // Catch: Throwable -> L83
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L83
        JSONObject r21 = new JSONObject();     // Catch: Throwable -> L83
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L83
    L62:
        th = move-exception;
        r15._isPluginLoading = false;     // Catch: Throwable -> L83
        throw th;     // Catch: Throwable -> L83
    L64:
        e = e;
        r16 = r4;
        r17 = r5;
        a r23 = r11;
    L66:
        boolean r3 = false;
    L67:
        ?? r12 = r17;
        r12.append("loadPluginInternal recursive loadPlugin detected;");     // Catch: Throwable -> L62
        ?? r14 = r16;
        r14.append(e.getMessage());     // Catch: Throwable -> L62
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + r35 + "] ", e);     // Catch: Throwable -> L62
        r15._isPluginLoading = false;     // Catch: Throwable -> L83
        boolean r18 = false;
        ?? r19 = r12;
        ?? r20 = r14;
    L69:
        a r22 = r23;
        r22.a(String.format("loadPluginInternal:loadResult=%s,makeComponentResult=%s", new Object[]{Boolean.valueOf(r3), Boolean.valueOf(r18)}));     // Catch: Throwable -> L83
        if (r3 == false) goto L73;
        if (r18 == false) goto L73;
        r15.setLoaded(true);     // Catch: Throwable -> L83
        f.g("load_finish", 41000, r15.mPkgName, r15.getVersion(), System.currentTimeMillis() - r22.d, r19.toString());     // Catch: Throwable -> L83
        ZeusPluginStateListener.postStateChange(r35, 9, new Object[0]);     // Catch: Throwable -> L83
        f.a.d(2100, 0, r15.mPkgName, r15.getVersion(), null);     // Catch: Throwable -> L83
        r.b(r15.mPkgName, r15.getVersion(), "load_plugin", "success", 0, XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L83
        r.a(r15.mPkgName, Integer.valueOf(r15.getVersion()), "load_plugin", System.currentTimeMillis() - r22.d, r21);     // Catch: Throwable -> L83
    L74:
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, " + r15);     // Catch: Throwable -> L83
        if (r15.isLoaded() == false) goto L79;
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + r15.mPkgName);     // Catch: Throwable -> L83
        monitor-exit(r13);     // Catch: Throwable -> L83
        goto L97
    L79:
        monitor-exit(r13);     // Catch: Throwable -> L83
        return false;
    L73:
        r19.append("plugin:");     // Catch: Throwable -> L83
        r19.append(r15.mPkgName);     // Catch: Throwable -> L83
        r19.append(" versionCode:");     // Catch: Throwable -> L83
        r19.append(r15.getVersion());     // Catch: Throwable -> L83
        r19.append("load failed;");     // Catch: Throwable -> L83
        f.g("load_finish", 42000, r15.mPkgName, r15.getVersion(), -1, r19.toString());     // Catch: Throwable -> L83
        ZeusPluginStateListener.postStateChange(r35, 10, new Object[]{r19.toString()});     // Catch: Throwable -> L83
        f.a.d(2100, -1, r15.mPkgName, r15.getVersion(), null);     // Catch: Throwable -> L83
        r.b(r15.mPkgName, r15.getVersion(), "load_plugin", "fail", 0, r20.toString());     // Catch: Throwable -> L83
        goto L74
    L91:
        if (r15._isPluginLoading == true) goto L59;
        r15._isPluginLoading = true;     // Catch: Throwable -> L62 RecursiveLoadPluginException -> L64
        r16 = r4;
        r17 = r5;
        r23 = r11;
        r3 = r2.d(r35, r15, r5, r21, r16);     // Catch: RecursiveLoadPluginException -> L60 Throwable -> L62
        Runnable r0 = (Runnable) ((ConcurrentHashMap) f.c).remove(r35);     // Catch: RecursiveLoadPluginException -> L55 Throwable -> L62
        if (r3 == false) goto L52;
        if (r0 == null) goto L52;
        r0.run();     // Catch: RuntimeException -> L46 Throwable -> L62
        r18 = true;
    L53:
        r15._isPluginLoading = false;     // Catch: Throwable -> L83
        r20 = r16;
        r19 = r17;
    L46:
        e = move-exception;
        RuntimeException r24 = e;
        Throwable r1 = r24.getCause();     // Catch: RecursiveLoadPluginException -> L55 Throwable -> L62
        RuntimeException r25 = r24;
        if (r1 == null) goto L51;
        r25 = r24.getCause();     // Catch: RecursiveLoadPluginException -> L55 Throwable -> L62
    L51:
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, makeComponentTask run, e = " + r25, r25);     // Catch: RecursiveLoadPluginException -> L55 Throwable -> L62
    L52:
        r18 = false;
    L55:
        e = e;
        goto L67
    L59:
        throw new RecursiveLoadPluginException("load plugin during loading plugin!");     // Catch: RecursiveLoadPluginException -> L60 Throwable -> L62
    L60:
        e = e;
    L8:
        r13 = r7;
        goto L9
    }

    public boolean tryLoadPluginFromInstallStateSnapshot(String r5) {
        Plugin r1 = getPlugin(r5, false);
        if (r1 != null) goto L7;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginManager tryLoadPluginFromInstallStateSnapshot, plugin == null, pkg = " + r5);
        return false;
    L7:
        if (r1.isLoaded() == false) goto L11;
        return true;
    L11:
        if (r1.tryUpdateInstallStateFromSnapshotOnly() == true) goto L15;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginManager tryLoadPluginFromInstallStateSnapshot, snapshot unavailable, pkg = " + r5);
        return false;
    L15:
        return loadPlugin(r5);
    }

    public void unInstallPackage(String r4) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, " + r4);
        Plugin r0 = getPlugin(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        if (GlobalParam.getInstance().enableCreateInstallStateSnapshot() == false) goto L7;
        d.d(r4, r0.getApiVersionCode());
    L8:
        SharedPreferences.Editor r1 = t.c().a.edit();
        r1.putBoolean("UNINSTALL__" + r4, true);
        r1.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=" + r4);
        return;
    L7:
        d.a(r4);
        goto L8
    }

    public Plugin getPlugin(String r2, boolean r3) {
        if (Zeus.hasInit() == true) goto L14;
        if ((Zeus.getAppApplication().getApplicationInfo().flags & 2) == 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L14;
        throw new RuntimeException("Please init Zeus first!");
    L8:
        r0 = false;
    L14:
        if (TextUtils.isEmpty(r2) == false) goto L18;
        return null;
    L18:
        if (this.mIsParsePluginConfig == true) goto L20;
        parsePluginConfig();
    L20:
        Plugin r4 = this.mPlugins.get(r2);
        if (r3 == false) goto L24;
        if (r4 == null) goto L24;
        r4.init();
    L24:
        return r4;
    }

    public void tryOfflineInternalPlugin(String r4, int r5) {
        Plugin r0 = getPlugin(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getInternalVersionCode() != r5) goto L9;
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager offlineInternalPlugin, pkgName:" + r4 + " pluginVer:" + r5 + " apiVer:" + r0.getApiVersionCode());
        t r6 = t.c();
        int r1 = r0.getApiVersionCode();
        SharedPreferences.Editor r7 = r6.a.edit();
        StringBuilder r2 = new StringBuilder("OFFLINE_INTERNAL_");
        r2.append(r4);
        r7.putInt(r2.toString(), r1);
        r7.apply();
        return;
    }

    public void asyncInstall(String r2, File r3, String r4) {
        asyncInstall(r2, r3, null, r4);
    }

    public void setAllowDownloadPlugin(String r4, int r5, boolean r6) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager setAllowDownloadPlugin, " + r4 + " " + r5 + " " + r6);
        if (getPlugin(r4) == null) goto L10;
        boolean r7 = !r6;
        SharedPreferences.Editor r0 = t.c().a.edit();
        String r1 = "DISABLE_DOWNLOAD_" + r4 + "_" + r5;
        if (r7 == false) goto L7;
        r0.putInt(r1, 0);
    L8:
        r0.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + r4 + " version=" + r5 + " disable=" + r7);
        return;
    L7:
        r0.remove(r1);
        goto L8
    }

    public boolean syncInstall(String r2, File r3, String r4) {
        return syncInstall(r2, r3, null, r4);
    }

    public void asyncInstall(String r3, File r4, String r5, String r6) {
        if (r4 == null) goto L5;
        getInstallThreadPool().execute(new c(r3, r4, r5, r6));
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=" + r4 + " source=" + r6);
        return;
    L5:
        ZeusPluginStateListener.postStateChange(r3, 7, new Object[]{"asyncInstall apk is null !"});
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
    }

    public boolean syncInstall(String r3, File r4, String r5, String r6) {
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=" + r4 + " identity=" + r5 + " source=" + r6);
        return new c(r3, r4, r5, r6).a();
    }
}
