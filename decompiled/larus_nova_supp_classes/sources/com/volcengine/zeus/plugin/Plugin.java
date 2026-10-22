package com.volcengine.zeus.plugin;

import android.R;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.IPackageManager;
import com.volcengine.zeus.PluginClassLoader;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusApplication;
import com.volcengine.zeus.g;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.servermanager.ServerManagerHelper;
import com.volcengine.zeus.util.kv.KVHolder;
import com.volcengine.zeus.util.kv.KVStorage;
import com.volcengine.zeus.wrapper.PluginApplicationWrapper;
import dqc.c;
import dqc.d;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import mqc.b;
import mqc.i;
import mqc.j;
import mqc.n;
import mqc.p;
import mqc.r;
import mqc.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    boolean _isPluginLoading;
    final Object initializeLock;
    final Object installLock;
    private final KVHolder<Boolean> loadedState;
    private final Set<String> mAllPluginProcesses;
    private int mAllowInstallVersion;
    private int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public final boolean mEnableSoNamespaceLink;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    private volatile boolean mInitialized;
    private String mInternalMetaPath;
    private String mInternalPath;
    private transient String mInternalPluginIdentity;
    private int mInternalVersionCode;
    public boolean mIsSupportLibIso;
    private volatile int mLifeCycle;
    public int mMaxVersionCode;
    private final PluginMigrationHandler mMigrationHandler;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private String mPackageDir;
    public String mPkgName;
    private final String mPluginProcess;
    public final boolean mReInstallInternalPluginByMd5;
    public Resources mResources;
    public String mSignature;
    public final Set<String> mSoNamespaceLinkAllowSet;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    private int mVersionCode;
    public HashMap<String, ActivityInfo> pluginActivities;
    public HashMap<String, ProviderInfo> pluginProvider;
    public HashMap<String, ActivityInfo> pluginReceiver;
    public HashMap<String, ServiceInfo> pluginServices;
    public String response;

    public static final class e {
        public final boolean a;
        public final boolean b;
        public final String c;
        public final String d;
        public final long e;
        public final int f;

        public e(boolean r1, boolean r2, String r3, String r4, long r5, int r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir) == false) goto L5;
        this.mPackageDir = c.a(new String[]{this.mPkgName});
    L5:
        new PolarisFileWrapper(this.mPackageDir).listFiles(new c(this));
        i.e(new PolarisFileWrapper(this.mPackageDir));
    }

    private void setupInternalPlugin() {
        boolean r5 = true;
        int r7 = 0;
        if (t.c().a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", new Object[]{this.mPkgName}), -1) == this.mApiVersionCode) goto L6;
        r5 = false;
    L6:
        if (r5 == false) goto L8;
        return;
    L8:
        StringBuilder r1 = new StringBuilder("zeus_l/");
        String r2 = g.a;
        r1.append(this.mPkgName);
        r1.append(".json");
        this.mInternalMetaPath = r1.toString();
        if (TextUtils.isEmpty(this.mInternalPath) == false) goto L11;
    L26:
        String[] r3 = Zeus.getAppApplication().getAssets().list("zeus_p");     // Catch: IOException -> L23
        int r4 = r3.length;     // Catch: IOException -> L23
    L14:
        if (r7 >= r4) goto L32;
        String r6 = r3[r7];     // Catch: IOException -> L23
        if (r6.startsWith(this.mPkgName + "_") == false) goto L22;
        n.a.getClass();     // Catch: IOException -> L23
        n.a r8 = n.a(r6);     // Catch: IOException -> L23
        if (r8 == null) goto L22;
        StringBuilder r9 = new StringBuilder();     // Catch: IOException -> L23
        String r10 = g.a;     // Catch: IOException -> L23
        r9.append("zeus_p");     // Catch: IOException -> L23
        r9.append("/");     // Catch: IOException -> L23
        r9.append(r6);     // Catch: IOException -> L23
        this.mInternalPath = r9.toString();     // Catch: IOException -> L23
        this.mInternalVersionCode = r8.b;     // Catch: IOException -> L23
        return;
    L22:
        r7 = r7 + 1;
        goto L14
    L32:
        return;
    L23:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e);
        return;
    L11:
        if (this.mInternalVersionCode == (-1)) goto L26;
    }

    private void updateInstallStateFromMainProcess() {
    L30:
        th = move-exception;
        StringBuilder r1 = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
        Zeus.getAppApplication();
        r1.append(d.c());
        ZeusLogger.w(ZeusLogger.TAG_PPM, r1.toString(), th);
        return;
    L4:
        if (d.d(Zeus.getAppApplication()) == false) goto L6;
        return;
    L6:
        if (this.mLifeCycle >= 2) goto L38;
        e r2 = tryUpdateInstallStateFromSnapshot(true);     // Catch: Throwable -> L30
        if (r2.a == false) goto L10;
        return;
    L10:
        long r3 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L30
        int r5 = 0;
        IPackageManager r6 = ServerManagerHelper.getPackageManager();     // Catch: Throwable -> L26
        if (r6 != null) goto L15;
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "updateInstallStateFromMainProcess error. packageManager is null. pkg=" + this.mPkgName);     // Catch: Throwable -> L26
        String r13 = "package_manager_null";
        int r4 = 0;
    L25:
        reportInstallStateRoute("ipc", r2.c, r4, r2.e, SystemClock.elapsedRealtime() - r3, 0, 0, 0, r2.d, r13, 0, r2.f);     // Catch: Throwable -> L30
        return;
    L15:
        if (r6.isPluginInstalled(this.mPkgName) == false) goto L21;
        r5 = r6.getInstalledVersion(this.mPkgName);     // Catch: Throwable -> L26
        updateToInstalled(r5);     // Catch: Throwable -> L19
        String r0 = "installed";
    L22:
        r13 = r0;
        r4 = r5;
    L19:
        th = th;
        int r7 = r5;
    L28:
        reportInstallStateRoute("ipc", r2.c, r7, r2.e, SystemClock.elapsedRealtime() - r3, 0, 0, 0, r2.d, "exception", 0, r2.f);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L21:
        r0 = "not_installed";
    L26:
        th = th;
        r7 = 0;
        goto L28
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir) == false) goto L5;
        this.mPackageDir = c.a(new String[]{this.mPkgName});
    L5:
        File[] r0 = new PolarisFileWrapper(this.mPackageDir).listFiles(new b());
        int r4 = -1;
        if (r0 != null) goto L8;
    L21:
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + r4);
        return r4;
    L8:
        if (r0.length <= 0) goto L21;
        int r5 = r0.length;
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L21;
        String r7 = r0[r6].getName().split("-")[1];
        int r8 = CastIntegerProtector.parseInt(r7);
        Lazy r9 = PluginProtocolVersionChecker.a;
        if (PluginProtocolVersionChecker.a(this.mPkgName, r7) == true) goto L14;
        ZeusLogger.w(ZeusLogger.TAG_INIT, String.format("ignore not compatible plugin %s[%s]", new Object[]{this.mPkgName, r7}));
    L20:
        r6 = r6 + 1;
        goto L10
    L14:
        if (r8 <= r4) goto L20;
        if (t.c().h(this.mPkgName, r8) == false) goto L20;
        if (new PolarisFileWrapper(c.h(this.mPkgName, r8, false)).exists() == false) goto L20;
        r4 = r8;
        goto L20
    }

    public String getInternalPluginIdentity() {
        String r0 = this.mInternalPluginIdentity;
        if (r0 == null) goto L37;
        return r0;
    L37:
        InputStream r1 = Zeus.getAppApplication().getAssets().open(this.mInternalMetaPath);     // Catch: JSONException -> L25 Throwable -> L27
        byte[] r2 = new byte[r1.available()];     // Catch: Throwable -> L16
        int r3 = r1.read(r2);     // Catch: Throwable -> L16
        if (r3 <= 0) goto L10;
        String r4 = new String(r2, 0, r3, StandardCharsets.UTF_8);     // Catch: Throwable -> L16
    L11:
        String r5 = new JSONObject(r4).optString("checksum", XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r5) == true) goto L14;
        this.mInternalPluginIdentity = r5;     // Catch: Throwable -> L16
    L14:
        r1.close();     // Catch: JSONException -> L25 Throwable -> L27
    L30:
        return this.mInternalPluginIdentity;
    L10:
        r4 = XmlPullParser.NO_NAMESPACE;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        if (r1 != null) goto L35;
    L24:
        throw th;     // Catch: JSONException -> L25 Throwable -> L27
    L35:
        r1.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: JSONException -> L25 Throwable -> L27
    L27:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Failed to read internal plugin meta file: " + this.mInternalMetaPath, e);
        goto L30
    }

    public String getNativeLibraryDir() {
        int r0 = this.mVersionCode;
        if (r0 <= 0) goto L7;
        return c.e(this.mPkgName, r0, false);
    L7:
        return c.a(new String[]{this.mPkgName});
    }

    public void init() {
        if (this.mInitialized == false) goto L5;
        return;
    L5:
        Object r1 = this.initializeLock;
        monitor-enter(r1);
    L28:
        th = move-exception;
        throw th;
    L8:
        if (this.mInitialized == false) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L28
        return;
    L12:
        if (d.d(Zeus.getAppApplication()) == false) goto L30;
        boolean r2 = GlobalParam.getInstance().enableCreateInstallStateSnapshot();     // Catch: Throwable -> L28
        t r4 = t.c();     // Catch: Throwable -> L28
        String r5 = this.mPkgName;     // Catch: Throwable -> L28
        int r6 = 0;
        if ((!TextUtils.isEmpty(r4.a.getString("HOST_ABI_" + r5, XmlPullParser.NO_NAMESPACE))) == false) goto L16;
        boolean r7 = t.c().g(this.mPkgName);     // Catch: Throwable -> L28
    L17:
        deleteIfNeeded();     // Catch: Throwable -> L28
        if (r2 == false) goto L20;
        d.g(this.mPkgName, this.mApiVersionCode, "reconcile_pending", "reconcile_start");     // Catch: Throwable -> L28
    L20:
        int r8 = getInstalledMaxVer();     // Catch: Throwable -> L28
        if (checkVersionValid(r8, this.mApiVersionCode, r7) == false) goto L23;
        r6 = modifyResIfNeed(r8);     // Catch: Throwable -> L28
        updateToInstalled(r6);     // Catch: Throwable -> L28
    L23:
        deleteOtherExpiredVer(r6);     // Catch: Throwable -> L28
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=" + this);     // Catch: Throwable -> L28
        t.c().n(this.mPkgName);     // Catch: Throwable -> L28
        t.c().k(this.mPkgName);     // Catch: Throwable -> L28
        t.c().l(this.mPkgName, b.a(Zeus.getAppApplication()));     // Catch: Throwable -> L28
        t.c().m(this.mPkgName, this.mApiVersionCode);     // Catch: Throwable -> L28
        if (r2 == false) goto L31;
        if (r6 <= 0) goto L27;
        d.f(this.mPkgName, r6, this.mApiVersionCode);     // Catch: Throwable -> L28
        goto L31
    L27:
        d.g(this.mPkgName, this.mApiVersionCode, "not_installed", "reconcile_no_valid_version");     // Catch: Throwable -> L28
    L31:
        this.mInitialized = true;     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        if (shouldInstallInternalPlugin(true) == false) goto L40;
        installInternalPlugin(true);
        return;
    L40:
        return;
    L16:
        r7 = false;
        goto L17
    L30:
        updateInstallStateFromMainProcess();     // Catch: Throwable -> L28
        goto L31
    }

    public boolean isLoaded() {
        return this.loadedState.get().booleanValue();
    }

    public boolean isLoadedInAnyProcess() {
        if (this.mAllPluginProcesses.isEmpty() == true) goto L5;
        Iterator<String> r0 = this.mAllPluginProcesses.iterator();
        boolean r4 = false;
    L8:
        if (r0.hasNext() == false) goto L10;
        r4 = r4 | KVStorage.INSTANCE.dynamicKV(r0.next()).getBoolean(String.format("zeus_plugin_%s_loaded", new Object[]{this.mPkgName}), false);
        goto L8
    L10:
        return r4;
    L5:
        return KVStorage.INSTANCE.mainDynamicKV().getBoolean(String.format("zeus_plugin_%s_loaded", new Object[]{this.mPkgName}), false);
    }

    public void reset() {
        Object r0 = this.initializeLock;
        monitor-enter(r0);
        this.mInitialized = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }

    public boolean tryUpdateInstallStateFromSnapshotOnly() {
    L13:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "tryUpdateInstallStateFromSnapshotOnly failed. pkg=" + this.mPkgName, th);
        return false;
    L4:
        if (this.mLifeCycle < 2) goto L8;
        return true;
    L8:
        if (d.d(Zeus.getAppApplication()) == false) goto L12;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "InstallStateSnapshotOnly skipped. main process. pkg=" + this.mPkgName);     // Catch: Throwable -> L13
        return false;
    L12:
        return tryUpdateInstallStateFromSnapshot(false).b;
    }

    private void deleteIfNeeded() {
        if (d.d(Zeus.getAppApplication()) == true) goto L5;
        return;
    L5:
        boolean r0 = GlobalParam.getInstance().enableCreateInstallStateSnapshot();
        String r1 = this.mPkgName;
        if (TextUtils.isEmpty(r1) == false) goto L44;
    L23:
        boolean r6 = false;
    L24:
        t r2 = t.c();
        String r3 = this.mPkgName;
        boolean r4 = r2.a.getBoolean("UNINSTALL__" + r3, false);
        if (r6 == true) goto L27;
        if (r4 == true) goto L27;
        return;
    L27:
        if (r0 == false) goto L29;
        d.d(this.mPkgName, this.mApiVersionCode);
    L29:
        deleteInstalledPlugin();
        if (r0 == false) goto L32;
        d.g(this.mPkgName, this.mApiVersionCode, "not_installed", "uninstall_completed");
    L33:
        String r5 = this.mPkgName;
        if (TextUtils.isEmpty(r5) == false) goto L42;
    L40:
        t r7 = t.c();
        String r8 = this.mPkgName;
        SharedPreferences.Editor r9 = r7.a.edit();
        r9.remove("UNINSTALL__" + r8);
        r9.apply();
        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
        return;
    L42:
        KVStorage.INSTANCE.staticKV().erase(d.c(r5));     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot clear pending uninstall state failed. " + r5, th);
        goto L40
    L32:
        d.a(this.mPkgName);
        goto L33
    L44:
        KVStorage r10 = KVStorage.INSTANCE;     // Catch: Throwable -> L21
        r6 = true;
        if (r10.staticKV().getBoolean(d.c(r1), false) == true) goto L24;
        String r11 = r10.staticKV().getString(d.b(r1), XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r11) == true) goto L23;
        JSONObject r12 = new JSONObject(r11);     // Catch: Throwable -> L21
        if (r12.optInt("schema") != 1) goto L23;
        if (TextUtils.equals(r1, r12.optString("packageName")) == false) goto L23;
        if (TextUtils.equals("pending_uninstall", r12.optString("state")) == false) goto L23;
    L21:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot read pending uninstall state failed. " + r1, th);
        goto L23
    }

    private boolean shouldReinstallSameVersionInternalPlugin() {
        return shouldReinstallSameVersionInternalPlugin(getInternalPluginIdentity());
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        if (this.mLifeCycle < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public Set<String> getAllPluginProcesses() {
        return this.mAllPluginProcesses;
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public String getInternalPath() {
        return this.mInternalPath;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public PluginMigrationHandler getMigrationHandler() {
        return this.mMigrationHandler;
    }

    public String getPluginProcess() {
        return this.mPluginProcess;
    }

    public Plugin(JSONObject r2) throws JSONException {
        this(r2, Boolean.FALSE);
    }

    public static /* synthetic */ String access$100(Plugin r0) {
        return r0.mInternalPath;
    }

    private void deleteOtherExpiredVer(int r4) {
        if (d.d(Zeus.getAppApplication()) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mPackageDir) == false) goto L7;
        this.mPackageDir = c.a(new String[]{this.mPkgName});
    L7:
        new PolarisFileWrapper(this.mPackageDir).listFiles(new d(this, "version-" + r4));
    }

    private boolean isAllowInstall(int r4) {
        int r0 = this.mAllowInstallVersion;
        if (r0 != (-1)) goto L5;
        return true;
    L5:
        if (r4 >= r0) goto L9;
        return false;
    L9:
        return true;
    }

    private boolean isInternalPluginInstallPreCheckPassed(boolean r15) {
        if (ZeusLogger.isDebug() == false) goto L41;
        Lazy r0 = PluginProtocolVersionChecker.a;
        if (PluginProtocolVersionChecker.a(this.mPkgName, String.valueOf(this.mInternalVersionCode)) == true) goto L41;
        String r16 = (String) PluginProtocolVersionChecker.a.getValue();
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin installInternalPlugin stopped by protocol mismatch. pkgName=" + this.mPkgName + ", internalVersionCode=" + this.mInternalVersionCode + ", hostProtocolVersion=" + r16);
        String r1 = this.mPkgName;
        int r4 = this.mInternalVersionCode;
        ConcurrentHashMap r5 = b.a;
        Intrinsics.checkNotNullParameter(r1, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r16, "hostProtocolVersion");
        Application r6 = Zeus.getAppApplication();
        if (r6 != null) goto L9;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier notifyMismatch skipped because app context is null");
    L40:
        return false;
    L9:
        long r7 = System.currentTimeMillis();
        ConcurrentHashMap r8 = b.a;
        Long r9 = (Long) r8.get(r1);
        if (r9 != null) goto L12;
    L14:
        r8.put(r1, Long.valueOf(r7));
        p.b(new a(r6, r1));
    L52:
        b.a(r6);     // Catch: Throwable -> L38
        String r10 = "https://bytedance.larkoffice.com/wiki/N3qiwrgjTicZ5pkQiBWc4VjAnAz#share-CLELdheNpoLKe0xXbTzc3BJCnRf";
        r10 = "https://applink.feishu.cn/client/docs/open?url=" + URLEncoder.encode("https://bytedance.larkoffice.com/wiki/N3qiwrgjTicZ5pkQiBWc4VjAnAz#share-CLELdheNpoLKe0xXbTzc3BJCnRf", "UTF-8");     // Catch: Throwable -> L19
    L21:
        Intent r11 = new Intent("android.intent.action.VIEW", UriProtector.parse(r10));     // Catch: Throwable -> L38
        r11.addFlags(268435456);     // Catch: Throwable -> L38
        int r12 = r1.hashCode();     // Catch: Throwable -> L38
        if (Build.VERSION.SDK_INT < 23) goto L24;
        int r13 = 67108864;
    L25:
        PendingIntent r14 = PendingIntent.getActivity(r6, r12, r11, r13 | 134217728);     // Catch: Throwable -> L38
        String r17 = "插件 " + r1 + " 内置版本 " + r4 + " 与宿主协议版本 " + r16 + " 不兼容，点击查看处理文档";     // Catch: Throwable -> L38
        NotificationCompat.Builder r18 = new NotificationCompat.Builder(r6, "zeus_internal_plugin_protocol_mismatch");     // Catch: Throwable -> L38
        ApplicationInfo r19 = r6.getApplicationInfo();     // Catch: Throwable -> L38
        if (r19 == null) goto L28;
        int r20 = r19.icon;     // Catch: Throwable -> L38
    L29:
        if (r20 != 0) goto L32;
        r20 = R.drawable.stat_sys_warning;
    L32:
        Notification r110 = r18.setSmallIcon(r20).setContentTitle("内置插件版本不兼容").setContentText(r17).setStyle(new NotificationCompat.BigTextStyle().bigText(r17)).setContentIntent(r14).setOngoing(true).setAutoCancel(false).setPriority(1).setCategory("err").setOnlyAlertOnce(true).build();     // Catch: Throwable -> L38
        r110.flags |= 32;     // Catch: Throwable -> L38
        NotificationManagerCompat r2 = NotificationManagerCompat.from(r6);     // Catch: Throwable -> L38
        int r21 = r1.hashCode();     // Catch: Throwable -> L38
        if (r21 != Integer.MIN_VALUE) goto L35;
        int r22 = 0;
    L36:
        r2.notify(r22 + 1509949440, r110);     // Catch: Throwable -> L38
        b.c(r6, r1);     // Catch: Throwable -> L38
        goto L40
    L35:
        r22 = Math.abs(r21);     // Catch: Throwable -> L38
        goto L36
    L28:
        r20 = 0;
        goto L29
    L24:
        r13 = 0;
        goto L25
    L19:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier build applink failed, fallback to raw doc url", th);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier show notification failed. pluginPkgName=" + r1, th);
        goto L40
    L12:
        if ((r7 - r9.longValue()) >= 5000) goto L14;
    L41:
        if (r15 == false) goto L46;
        if (GlobalParam.getInstance().isAutoInstallInternal(this.mPkgName) == true) goto L46;
        return false;
    L46:
        if (d.d(Zeus.getAppApplication()) == true) goto L48;
    L51:
        return false;
    L48:
        if (TextUtils.isEmpty(this.mInternalPath) == true) goto L51;
        return true;
    }

    private int modifyResIfNeed(int r6) {
        String r0 = b.a(Zeus.getAppApplication());
        if (TextUtils.isEmpty(r0) == true) goto L9;
        if (TextUtils.equals(t.c().b(this.mPkgName), r0) == false) goto L9;
        return r6;
    L9:
        if (this.mUnInstallPluginWhenHostChange == false) goto L11;
    L20:
        ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + r6);
        return 0;
    L11:
        if (GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName) == true) goto L20;
        ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + r6);
        int r1 = kqc.e.a(new PolarisFileWrapper(c.h(this.mPkgName, r6, false)), true, new StringBuilder(), new kqc.c());
        if (r1 != 100) goto L16;
    L19:
        return r6;
    L16:
        if (r1 == 200) goto L19;
        return 0;
    }

    private boolean shouldReinstallSameVersionInternalPlugin(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L7;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Stop installing the same version plugin with empty identity");
        return false;
    L7:
        if (TextUtils.equals(r5, mqc.d.a(this.mPkgName)) == false) goto L10;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Stop installing the same version plugin with same identity " + r5);
        return false;
    L10:
        return true;
    }

    private e tryUpdateInstallStateFromSnapshot(boolean r44) {
        boolean r0 = GlobalParam.getInstance().enableUseInstallStateSnapshot();
        boolean r1 = GlobalParam.getInstance().canUseInstallStateSnapshot(this.mPkgName);
        if (r0 == false) goto L5;
        String r2 = "snapshot_precondition_rejected";
    L7:
        if (GlobalParam.getInstance().getReporter() != null) goto L9;
        int r17 = -1;
    L11:
        if (r1 == false) goto L131;
        long r3 = SystemClock.elapsedRealtime();
        String r12 = this.mPkgName;
        int r4 = this.mApiVersionCode;
        int r13 = this.mMinVersionCode;
        int r15 = this.mMaxVersionCode;
        if (TextUtils.isEmpty(r12) == false) goto L138;
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginInstallStateSnapshot read skipped, empty packageName.");
        d.a r5 = new d.a(0, "miss", "empty_package_name", 0);
        String r6 = ZeusLogger.TAG_LOAD;
    L118:
        long r18 = SystemClock.elapsedRealtime() - r3;
        int r7 = r5.a;
        String r14 = r5.b;
        String r16 = r5.c;
        if (r7 <= 0) goto L123;
        updateToInstalled(r7);
        ZeusLogger.i(r6, "InstallStateSnapshotIPC saved. oldPath=IPackageManager newPath=Snapshot pkg=" + this.mPkgName + " version=" + r7);
        reportInstallStateRoute("snapshot", r14, r7, r18, 0, 1, 1, 1, r16, null, r5.d, r17);
        return new e(true, true, r14, r16, r18, r17);
    L123:
        if (r7 != (-1)) goto L126;
        ZeusLogger.i(r6, "InstallStateSnapshotIPC saved. oldPath=IPackageManager newPath=Snapshot pkg=" + this.mPkgName + " state=not_installed");
        reportInstallStateRoute("snapshot", r14, 0, r18, 0, 1, 1, 0, r16, null, r5.d, r17);
        return new e(true, false, r14, r16, r18, r17);
    L126:
        StringBuilder r8 = new StringBuilder("InstallStateSnapshot ");
        if (r44 == false) goto L129;
        String r9 = "fallback. path=IPackageManager";
    L130:
        r8.append(r9);
        r8.append(" reason=");
        r8.append(r16);
        r8.append(" pkg=");
        r8.append(this.mPkgName);
        ZeusLogger.i(r6, r8.toString());
        String r10 = r16;
        long r11 = r18;
        String r19 = r14;
    L137:
        return new e(false, false, r19, r10, r11, r17);
    L129:
        r9 = "miss. noIpcFallback";
        goto L130
    L138:
        KVStorage r33 = KVStorage.INSTANCE;     // Catch: Throwable -> L115
        String r34 = ZeusLogger.TAG_LOAD;
    L108:
        th = th;
    L117:
        r6 = r34;
        ZeusLogger.w(r6, "PluginInstallStateSnapshot read installed snapshot failed. " + r12, th);
        r5 = new d.a(0, "miss", "read_exception", 0);
        goto L118
    L18:
        if (r33.staticKV().getBoolean(d.c(r12), false) == false) goto L20;
        r5 = d.e(r12, "uninstall_pending", "uninstall pending");     // Catch: Throwable -> L108
    L114:
        r6 = r34;
        goto L118
    L20:
        String r20 = r33.staticKV().getString(d.b(r12), XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r20) == false) goto L23;
        r5 = d.e(r12, "empty_snapshot", "empty snapshot");     // Catch: Throwable -> L108
        goto L114
    L23:
        JSONObject r110 = new JSONObject(r20);     // Catch: Throwable -> L108
        if (r110.optInt("schema") == 1) goto L27;
        r5 = d.e(r12, "schema_mismatch", "schema mismatch. snapshot=" + r110.optInt("schema") + " expected=1");     // Catch: Throwable -> L108
        goto L114
    L27:
        if (TextUtils.equals(r12, r110.optString("packageName")) == true) goto L30;
        r5 = d.e(r12, "package_name_mismatch", "packageName mismatch. snapshot=" + r110.optString("packageName"));     // Catch: Throwable -> L108
        goto L114
    L30:
        if (r110.has("apiVersion") == true) goto L32;
    L113:
        r5 = d.e(r12, "api_version_mismatch", "apiVersion mismatch. snapshot=" + r110.optInt("apiVersion", 0) + " expected=" + r4);     // Catch: Throwable -> L108
        goto L114
    L32:
        if (r110.optInt("apiVersion", 0) != r4) goto L113;
        if (TextUtils.equals(r110.optString("hostAbi"), Zeus.getHostAbi()) == true) goto L38;
        r5 = d.e(r12, "host_abi_mismatch", "hostAbi mismatch. snapshot=" + r110.optString("hostAbi") + " current=" + Zeus.getHostAbi());     // Catch: Throwable -> L108
        goto L114
    L38:
        String r21 = b.a(Zeus.getAppApplication());     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r21) == false) goto L42;
    L112:
        r5 = d.e(r12, "host_identity_mismatch", "hostIdentity mismatch. snapshot=" + r110.optString("hostIdentity") + " current=" + r21);     // Catch: Throwable -> L108
        goto L114
    L42:
        if (TextUtils.equals(r110.optString("hostIdentity"), r21) == false) goto L112;
        String r22 = r110.optString("state");     // Catch: Throwable -> L108
        if (TextUtils.equals("not_installed", r22) == false) goto L52;
        if (r110.optBoolean("installed", true) == false) goto L50;
        r5 = d.e(r12, "not_installed_flag_invalid", "not-installed state with installed flag true");     // Catch: Throwable -> L108
        goto L114
    L50:
        r5 = new d.a(-1, "not_installed", r110.optString("reason"), r110.optLong("updateTime", 0));     // Catch: Throwable -> L108
        goto L114
    L52:
        if (TextUtils.equals("installed", r22) == true) goto L65;
        if (TextUtils.equals("pending_uninstall", r22) == false) goto L57;
        String r23 = "state_pending_uninstall";
    L63:
        r5 = d.e(r12, r23, "state unavailable. state=" + r22 + " reason=" + r110.optString("reason"));     // Catch: Throwable -> L108
        goto L114
    L57:
        if (TextUtils.equals("reconcile_pending", r22) == false) goto L60;
        r23 = "state_reconcile_pending";
        goto L63
    L60:
        if (TextUtils.equals("install_pending", r22) == false) goto L62;
        r23 = "state_install_pending";
        goto L63
    L62:
        r23 = "state_unknown";
        goto L63
    L65:
        if (r110.optBoolean("installed") == true) goto L67;
        r5 = d.e(r12, "installed_flag_false", "installed flag false");     // Catch: Throwable -> L108
        goto L114
    L67:
        int r24 = r110.optInt("version", 0);     // Catch: Throwable -> L108
        if (r24 <= 0) goto L110;
        if (r24 < r13) goto L110;
        int r25 = r15;
        if (r24 > r25) goto L111;
        Lazy r26 = PluginProtocolVersionChecker.a;     // Catch: Throwable -> L108
        if (PluginProtocolVersionChecker.a(r12, String.valueOf(r24)) == true) goto L76;
        r5 = d.e(r12, "protocol_version_mismatch", "protocol version mismatch. version=" + r24);     // Catch: Throwable -> L108
        goto L114
    L76:
        String r28 = c.f(r12, r24, false);     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r28) == false) goto L79;
        PolarisFileWrapper r29 = null;
    L80:
        if (r29 != null) goto L82;
    L103:
        StringBuilder r30 = new StringBuilder("source apk not exists. version=");     // Catch: Throwable -> L108
        r30.append(r24);     // Catch: Throwable -> L108
        r30.append(" path=");     // Catch: Throwable -> L108
        if (r29 != null) goto L106;
        String r31 = "null";
    L107:
        r30.append(r31);     // Catch: Throwable -> L108
        r5 = d.e(r12, "source_apk_missing", r30.toString());     // Catch: Throwable -> L108
        goto L114
    L106:
        r31 = r29.getAbsolutePath();     // Catch: Throwable -> L108
        goto L107
    L82:
        if (r29.exists() == false) goto L103;
        String r32 = r110.optString("apkPath");     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r32) == false) goto L87;
    L102:
        r5 = d.e(r12, "apk_path_mismatch", "apk path mismatch. snapshot=" + r32 + " current=" + r29.getAbsolutePath());     // Catch: Throwable -> L108
        goto L114
    L87:
        if (TextUtils.equals(r32, r29.getAbsolutePath()) == false) goto L102;
        long r35 = r110.optLong("apkLength", -1);     // Catch: Throwable -> L108
        if (r35 > 0) goto L92;
    L101:
        r5 = d.e(r12, "apk_length_mismatch", "apk length mismatch. snapshot=" + r35 + " current=" + r29.length());     // Catch: Throwable -> L108
        goto L114
    L92:
        if (r35 != r29.length()) goto L101;
        long r36 = r110.optLong("apkLastModified", -1);     // Catch: Throwable -> L108
        if (r36 > 0) goto L97;
    L100:
        r5 = d.e(r12, "apk_last_modified_mismatch", "apk lastModified mismatch. snapshot=" + r36 + " current=" + r29.lastModified());     // Catch: Throwable -> L108
        goto L114
    L97:
        if (r36 != r29.lastModified()) goto L100;
        r5 = new d.a(r24, "installed", "snapshot_valid", r110.optLong("updateTime", 0));     // Catch: Throwable -> L108
        goto L114
    L79:
        r29 = new PolarisFileWrapper(new PolarisFileWrapper(r28, "apk"), "base-1.apk");     // Catch: Throwable -> L108
    L111:
        r5 = d.e(r12, "version_invalid", "version invalid. snapshot=" + r24 + " min=" + r13 + " max=" + r25);     // Catch: Throwable -> L108
    L110:
        r25 = r15;
    L115:
        th = th;
        r34 = ZeusLogger.TAG_LOAD;
        goto L117
    L131:
        StringBuilder r37 = new StringBuilder("InstallStateSnapshot ");
        if (r44 == false) goto L134;
        String r38 = "fallback. path=IPackageManager";
    L135:
        r37.append(r38);
        r37.append(" reason=");
        r37.append(r2);
        r37.append(" pkg=");
        r37.append(this.mPkgName);
        r37.append(" useSnapshotEnabled=");
        r37.append(r0);
        r37.append(" snapshotAllowed=");
        r37.append(r1);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r37.toString());
        r10 = r2;
        r11 = 0;
        r19 = "not_allowed";
        goto L137
    L134:
        r38 = "miss. noIpcFallback";
        goto L135
    L9:
        r17 = ServerManagerHelper.getMainProcessAliveState();
        goto L11
    L5:
        r2 = "snapshot_disabled";
        goto L7
    }

    private void updateToInstalled(int r1) {
        this.mVersionCode = r1;
        this.mLifeCycle = 2;
    }

    public void injectResponse(String r1) {
        this.response = r1;
    }

    public synchronized void installInternalPlugin(boolean r2) {
        monitor-enter(this);
        installInternalPlugin(r2, true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isVersionInstalled(int r3) {
        return t.c().h(this.mPkgName, r3);
    }

    public void setAllowInstallVersion(int r1) {
        this.mAllowInstallVersion = r1;
    }

    public void setLoaded(boolean r2) {
        this.loadedState.set(Boolean.valueOf(r2));
    }

    public synchronized boolean shouldInstallInternalPlugin(boolean r4) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        boolean r0 = false;
        if (isInternalPluginInstallPreCheckPassed(r4) == true) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.mReInstallInternalPluginByMd5 == false) goto L14;
        if (getVersion() <= this.mInternalVersionCode) goto L15;
    L16:
        monitor-exit(this);
        return r0;
    L15:
        r0 = true;
        goto L16
    L14:
        if (getVersion() >= this.mInternalVersionCode) goto L16;
        goto L15
    }

    public Plugin(JSONObject r10, Boolean r11) throws JSONException {
        this.pluginActivities = new HashMap();
        this.pluginServices = new HashMap();
        this.pluginReceiver = new HashMap();
        this.pluginProvider = new HashMap();
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mLifeCycle = 1;
        this.mSoNamespaceLinkAllowSet = new HashSet();
        this.installLock = new Object();
        this.initializeLock = new Object();
        this.mAllowInstallVersion = -1;
        this.mAllPluginProcesses = new HashSet();
        this._isPluginLoading = false;
        this.mPkgName = JSONObjectProtectorUtils.getString(r10, "packageName");
        this.mMigrationHandler = GlobalParam.getInstance().getMigrationHandlerFactory().create(this.mPkgName);
        this.mPluginProcess = r10.optString("pluginProcess", XmlPullParser.NO_NAMESPACE);
        JSONArray r4 = r10.optJSONArray("allPluginProcesses");
        if (r4 == null) goto L8;
        int r6 = 0;
    L6:
        if (r6 >= r4.length()) goto L8;
        this.mAllPluginProcesses.add((String) r4.get(r6));
        r6 = r6 + 1;
    L8:
        this.mMinVersionCode = r10.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = r10.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = JSONObjectProtectorUtils.getInt(r10, "apiVersionCode");
        String r1 = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = r1;
        if (TextUtils.isEmpty(r1) == false) goto L11;
        this.mSignature = r10.optString("signature", XmlPullParser.NO_NAMESPACE);
    L11:
        this.mIsSupportLibIso = r10.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = r10.optString("internalPath", XmlPullParser.NO_NAMESPACE);
        this.mInternalVersionCode = r10.optInt("internalVersionCode", -1);
        this.mAppKey = r10.optString("appKey", XmlPullParser.NO_NAMESPACE);
        this.mAppSecretKey = r10.optString("appSecretKey", XmlPullParser.NO_NAMESPACE);
        this.mOpenLoadClassOpt = r10.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = r10.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = r10.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = r10.optBoolean("reInstallInternalPluginByMd5", true);
        this.mEnableSoNamespaceLink = r10.optBoolean("enableSoNamespaceLink", false);
        JSONArray r12 = r10.optJSONArray("soNamespaceLinkAllowList");
        if (r12 == null) goto L20;
        int r0 = 0;
    L15:
        if (r0 >= r12.length()) goto L20;
        String r2 = r12.optString(r0);
        if (TextUtils.isEmpty(r2) == true) goto L19;
        this.mSoNamespaceLinkAllowSet.add(r2);
    L19:
        r0 = r0 + 1;
    L20:
        this.loadedState = KVHolder.ofBoolean(KVStorage.INSTANCE.dynamicKV(), String.format("zeus_plugin_%s_loaded", new Object[]{this.mPkgName}), false);
        if (r11.booleanValue() == true) goto L23;
        setupInternalPlugin();
    L23:
        j.f.b();
    }

    public static /* synthetic */ boolean access$000(Plugin r0, String r1) {
        return r0.shouldReinstallSameVersionInternalPlugin(r1);
    }

    public synchronized void installInternalPlugin(boolean r2, boolean r3) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (shouldInstallInternalPlugin(r2) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (getVersion() != this.mInternalVersionCode) goto L10;
        boolean r4 = true;
    L11:
        a r0 = new a(this, r4, r3);     // Catch: Throwable -> L17
        if (r3 == false) goto L14;
        dqc.e.b(r0);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L14:
        r0.run();     // Catch: Throwable -> L17
        goto L15
    L10:
        r4 = false;
        goto L11
    }

    public void setupInternalPluginParams(String r3, int r4) {
        ZeusLogger.i(TAG, "setupInternalPluginParams: internalPath = " + r3 + ", internalVersionCode = " + r4);
        this.mInternalPath = r3;
        this.mInternalVersionCode = r4;
    }

    public synchronized boolean shouldInstallInternalPlugin(boolean r4, boolean r5) {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        boolean r0 = false;
        if (isInternalPluginInstallPreCheckPassed(r4) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        int r6 = getVersion();     // Catch: Throwable -> L25
        int r1 = this.mInternalVersionCode;     // Catch: Throwable -> L25
        if (r6 >= r1) goto L13;
        monitor-exit(this);
        return true;
    L13:
        if (r6 <= r1) goto L15;
    L23:
        monitor-exit(this);
        return false;
    L15:
        if (this.mReInstallInternalPluginByMd5 == false) goto L23;
        if (r5 == false) goto L21;
        if (shouldReinstallSameVersionInternalPlugin() == false) goto L21;
        r0 = true;
    L21:
        monitor-exit(this);
        return r0;
    }

    private boolean checkValid(File r7, String r8, int r9) {
        if (TextUtils.equals(this.mPkgName, r8) == true) goto L6;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r8 + " package name not match !!!");
        return false;
    L6:
        Lazy r0 = PluginProtocolVersionChecker.a;
        if (PluginProtocolVersionChecker.a(r8, String.valueOf(r9)) == true) goto L11;
        ZeusLogger.w(TAG, "PluginProtocolVersionChecker check failed. pkgName:" + r8 + " versionCode:" + r9 + ", hostProtocolVersion:" + ((String) PluginProtocolVersionChecker.a.getValue()));
        return false;
    L11:
        if (r9 >= this.mMinVersionCode) goto L13;
    L35:
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r8 + " " + String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", new Object[]{Integer.valueOf(r9), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode)}));
        return false;
    L13:
        if (r9 > this.mMaxVersionCode) goto L35;
        if (r9 < this.mVersionCode) goto L18;
    L21:
        if (r7 != null) goto L23;
    L33:
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r8 + " pluginApk not exist.");
        return false;
    L23:
        if (r7.exists() == false) goto L33;
        if (r9 == this.mVersionCode) goto L28;
    L31:
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r8 + ":" + r9 + " true");
        return true;
    L28:
        if (this.mReInstallInternalPluginByMd5 == true) goto L31;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r8 + " pluginApk has same version code");
        return false;
    L18:
        if (isInstalled() == false) goto L21;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r8 + String.format(" pluginApk ver[%s] lower than installed plugin[%s].", new Object[]{Integer.valueOf(r9), Integer.valueOf(this.mVersionCode)}));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v9, types: [int] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v16, types: [int] */
    /* JADX WARN: Type inference failed for: r11v19, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.bytedance.security.android.aopcheck.PolarisZipFileWrapper, java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v6 */
    private boolean checkVersionValid(int r17, int r18, boolean r19) {
        int r3 = t.c().d(this.mPkgName);
        ?? r4 = 3;
        r4 = 3;
        r4 = 3;
        boolean r9 = false;
        if (r3 <= r18) goto L6;
        ZeusLogger.w(ZeusLogger.TAG_INIT, TAG + String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", new Object[]{this.mPkgName, Integer.valueOf(r3), Integer.valueOf(r18)}));
        return false;
    L6:
        if (r17 >= 0) goto L8;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L23;
        ?? r10 = -1;
        if (r18 == (-1)) goto L23;
        t r11 = t.c();
        String r12 = this.mPkgName;
        r10 = r11.a.getInt("API_MIN_" + r12 + "_" + r17, 0);
        t r13 = t.c();
        String r14 = this.mPkgName;
        ?? r15 = 2147483647(0x7fffffff, float:NaN);
        ?? r16 = r13.a.getInt("API_MAX_" + r14 + "_" + r17, Integer.MAX_VALUE);
        if (r16 == 0) goto L20;
        r15 = r16;
    L20:
        if (r18 < r10) goto L22;
        if (r18 <= r15) goto L23;
    L22:
        r16 = Integer.valueOf(this.mVersionCode);
        r4 = Integer.valueOf(r15);
        ZeusLogger.w(ZeusLogger.TAG_INIT, TAG + String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", new Object[]{this.mPkgName, r16, Integer.valueOf(r18), Integer.valueOf(r10), r4}));
        r5 = false;
    L23:
        if (r5 == false) goto L62;
        if (r19 == false) goto L62;
        PolarisFileWrapper r0 = new PolarisFileWrapper(c.h(this.mPkgName, r17, false));
        String r6 = dqc.b.a;
        r4 = "NativeLibHelper hasNativeLib, close sourceApkZipFile error!";
        r10 = ZeusLogger.TAG_SO;
        ?? r110 = 0;
        r110 = 0;
        ?? r111 = 0;
        ?? r112 = new PolarisZipFileWrapper(r0);     // Catch: Throwable -> L45 IOException -> L47
        Enumeration<? extends ZipEntry> r1 = r112.entries();     // Catch: Throwable -> L41 IOException -> L43
        Pattern r113 = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");     // Catch: Throwable -> L41 IOException -> L43
    L29:
        if (r1.hasMoreElements() == false) goto L39;
        ZipEntry r114 = r1.nextElement();     // Catch: Throwable -> L41 IOException -> L43
        if (r114.isDirectory() == true) goto L29;
        if (r113.matcher(r114.getName()).matches() == false) goto L29;
        r112.close();     // Catch: IOException -> L37
    L38:
        boolean r2 = true;
        r16 = r113;
    L54:
        if (r2 == false) goto L62;
        ZeusLogger.w(ZeusLogger.TAG_INIT, TAG + String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", new Object[]{this.mPkgName, Integer.valueOf(r17)}));
        r4 = r4;
        r10 = r10;
        r111 = r16;
    L63:
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + r9);
        return r9;
    L37:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
        goto L38
    L39:
        r112.close();     // Catch: IOException -> L52
        r110 = r113;
    L70:
    L53:
        r2 = false;
        r16 = r110;
    L43:
        e = e;
        r110 = r112;
    L48:
        ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);     // Catch: Throwable -> L45
        if (r110 == 0) goto L53;
        r110.close();     // Catch: IOException -> L52
        r110 = r110;
    L41:
        th = th;
    L57:
        if (r112 != 0) goto L73;
    L61:
        throw th;
    L73:
        r112.close();     // Catch: IOException -> L60
    L60:
        ZeusLogger.w(r10, r4);
    L45:
        th = th;
        r112 = r111;
    L47:
        e = e;
    L52:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
    L62:
        r9 = r5;
        r4 = r4;
        r10 = r10;
        r111 = r16;
        goto L63
    L8:
        if (r17 < this.mMinVersionCode) goto L12;
        if (r17 > this.mMaxVersionCode) goto L12;
        r5 = true;
        goto L13
    }

    private void restoreInstallStateSnapshot(boolean r5, int r6, String r7) {
        PolarisFileWrapper r0 = null;
        if (r6 <= 0) goto L5;
        String r1 = c.f(this.mPkgName, r6, false);
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L10;
        r0 = new PolarisFileWrapper(new PolarisFileWrapper(r1, "apk"), "base-1.apk");
    L10:
        if (r5 == false) goto L15;
        if (r0 == null) goto L15;
        if (r0.exists() == false) goto L15;
        d.f(this.mPkgName, r6, this.mApiVersionCode);
        return;
    L15:
        d.g(this.mPkgName, this.mApiVersionCode, "not_installed", r7);
        return;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.volcengine.zeus.plugin.Plugin, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v5 */
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
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String install(File r23, hqc.e r24, String r25) {
        String r3 = "Plugin migration for ";
        String r4 = "Plugin trigger migration for ";
        String r5 = "Plugin delete file.";
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + r23 + ", " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L130
        String r13 = r24.a;     // Catch: Throwable -> L130
        int r14 = r24.b;     // Catch: Throwable -> L130
        String r12 = "Pkg:" + r13 + ",Ver:" + r14;     // Catch: Throwable -> L130
        Object r15 = this.installLock;     // Catch: Throwable -> L130
        monitor-enter(r15);     // Catch: Throwable -> L130
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=" + this);     // Catch: Throwable -> L120
        int r10 = this.mVersionCode;     // Catch: Throwable -> L120
        int r26 = r10;
        if (this.mLifeCycle < 2) goto L10;
        boolean r11 = true;
    L171:
        boolean r18 = checkValid(r23, r13, r14);     // Catch: Throwable -> L114
        if (r18 == true) goto L153;
        r5 = "Plugin delete file.";
        boolean r19 = r11;
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L112
        r0.append(r12);     // Catch: Throwable -> L112
        r3 = " checkValid failed";
        r0.append(" checkValid failed");     // Catch: Throwable -> L112
        String r16 = r0.toString();     // Catch: Throwable -> L112
        boolean r6 = false;
        ?? r7 = r4;
    L155:
        monitor-enter(this);     // Catch: Throwable -> L109
        if (r18 == true) goto L63;
        i.e(r23);     // Catch: Throwable -> L101
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid. " + r16);     // Catch: Throwable -> L101
    L80:
        r14 = 0;
    L169:
        monitor-exit(this);     // Catch: Throwable -> L98
        if (r6 == false) goto L96;
        if (r14 != 0) goto L96;
        if (TextUtils.isEmpty(r16) == false) goto L90;
        String r1 = "install_deferred";
    L92:
        restoreInstallStateSnapshot(r19, r26 == true ? 1 : 0, r1);     // Catch: Throwable -> L105
        goto L96
    L90:
        r1 = "install_failed";
    L93:
        th = th;
        r3 = r26 == true ? 1 : 0;
        r7 = r19;
    L111:
        boolean r17 = r6;
        int r2 = r14;
        ?? r110 = r3;
        ?? r8 = r7;
    L165:
        monitor-exit(r15);     // Catch: Throwable -> L128
        throw th;     // Catch: Throwable -> L126
    L126:
        th = th;
        boolean r21 = r17;
        int r111 = r2;
        ?? r9 = r110;
        boolean r112 = r21;
        ?? r20 = r8;
    L132:
        r16 = th.getMessage();
        if (r112 == false) goto L136;
        if (r111 != 0) goto L136;
        restoreInstallStateSnapshot(r20, r9, "install_exception");
    L136:
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th);
    L137:
        return r16;
    L128:
        th = th;
    L96:
        monitor-exit(r15);     // Catch: Throwable -> L105
    L98:
        th = th;
    L151:
        monitor-exit(this);     // Catch: Throwable -> L107
        throw th;     // Catch: Throwable -> L105
    L107:
        th = th;
        goto L151
    L63:
        if (TextUtils.isEmpty(r16) == true) goto L65;
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + r13 + ":" + r14);     // Catch: Throwable -> L101
        i.e(r23);     // Catch: Throwable -> L101
        StringBuilder r22 = new StringBuilder(r5);     // Catch: Throwable -> L101
        r22.append(r16);     // Catch: Throwable -> L101
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, r22.toString());     // Catch: Throwable -> L101
        goto L80
    L65:
        if (isLoaded() == false) goto L67;
    L77:
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, " + r12 + " valid next restart. lifeCycle:" + this.mLifeCycle + " isAllowInstall:" + isAllowInstall(r14));     // Catch: Throwable -> L101
        goto L80
    L67:
        if (isAllowInstall(r14) == false) goto L77;
        updateToInstalled(r14);     // Catch: Throwable -> L101
        if (GlobalParam.getInstance().enableCreateInstallStateSnapshot() == false) goto L72;
        d.f(this.mPkgName, r14, this.mApiVersionCode);     // Catch: Throwable -> L101
        int r113 = 1;
    L161:
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + r13 + ":" + r14);     // Catch: Throwable -> L75
        r14 = r113;
    L75:
        th = th;
        goto L151
    L72:
        r113 = 0;
    L101:
        th = th;
    L105:
        th = th;
    L109:
        th = th;
        r3 = r26 == true ? 1 : 0;
        r7 = r19;
        r14 = 0;
    L112:
        th = th;
    L56:
        boolean r28 = r19;
    L116:
        boolean r29 = r28;
    L117:
        r2 = 0;
        boolean r30 = r29;
        int r114 = r26;
    L123:
        r17 = false;
        r8 = r30;
        r110 = r114;
        goto L165
    L153:
        if (GlobalParam.getInstance().enableCreateInstallStateSnapshot() == true) goto L149;
        r19 = r11;
        r6 = false;
    L147:
        Throwable r31 = PluginInstaller.c(r23, r13, r14, r25);     // Catch: Throwable -> L52
        if (r31 != null) goto L28;
        r16 = null;
    L29:
        if (r31 != null) goto L51;
        t.c().j(this.mPkgName, r14, true);     // Catch: Throwable -> L52
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + r14);     // Catch: Throwable -> L52
        if (isLoadedInAnyProcess() == true) goto L33;
    L45:
        i.e(r23);     // Catch: Throwable -> L52
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin trigger migration for " + this.mPkgName);     // Catch: Throwable -> L52
        PluginMigrationHandler r32 = this.mMigrationHandler;     // Catch: Exception -> L48 Throwable -> L52
        String r33 = this.mPkgName;     // Catch: Exception -> L48 Throwable -> L52
        r32.onInstallFinished(r33);     // Catch: Exception -> L48 Throwable -> L52
        r7 = r33;
    L48:
        e = move-exception;
        String r34 = ZeusLogger.TAG_INSTALL;
        r3 = "Plugin migration for " + this.mPkgName + " exception";     // Catch: Throwable -> L52
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, r3, e);     // Catch: Throwable -> L52
        r7 = r34;
        goto L155
    L33:
        if (TextUtils.isEmpty(getPluginProcess()) == true) goto L45;
        Set r35 = i.a;     // Catch: Throwable -> L52
        String r36 = this.mPkgName;     // Catch: Throwable -> L52
        if (r36 != null) goto L37;
    L40:
        boolean r37 = true;
    L41:
        if (r37 == true) goto L44;
        p.b(new g(r36));     // Catch: Throwable -> L52
    L44:
        i.b();     // Catch: Throwable -> L52
        goto L45
    L37:
        if (r36.length() == 0) goto L40;
        r37 = false;
        goto L41
    L51:
        r7 = r4;
        goto L155
    L28:
        r16 = r12 + " install internal error:" + r31.getMessage();     // Catch: Throwable -> L52
    L52:
        th = th;
        r17 = r6;
        r2 = 0;
        r8 = r19;
        r110 = r26 == true ? 1 : 0;
        goto L165
    L149:
        r19 = r11;
        d.g(this.mPkgName, this.mApiVersionCode, "install_pending", "install_start_" + r14);     // Catch: Throwable -> L19
        r6 = true;
    L19:
        th = th;
    L23:
        r29 = r19;
    L21:
        th = th;
        r19 = r11;
    L54:
        th = th;
        r19 = r11;
    L114:
        th = th;
        r28 = r11;
        goto L116
    L10:
        r11 = false;
    L118:
        th = th;
        int r115 = r10;
    L122:
        r114 = r115;
        r2 = 0;
        r30 = false;
    L120:
        th = th;
        r115 = 0;
    L130:
        th = th;
        r9 = 0;
        r20 = 0;
        r112 = false;
        r111 = 0;
        goto L132
    }

    public void setApiCompatVersion(int r5, int r6, int r7) {
        t r0 = t.c();
        String r1 = this.mPkgName;
        SharedPreferences.Editor r2 = r0.a.edit();
        r2.putInt("API_MIN_" + r1 + "_" + r5, r6);
        r2.putInt("API_MAX_" + r1 + "_" + r5, r7);
        r2.apply();
    }

    private void reportInstallStateRoute(String r14, String r15, int r16, long r17, long r19, int r21, int r22, int r23, String r24, String r25, long r26, int r28) {
        String r9 = this.mPkgName;
        boolean r10 = r.a;
        Intrinsics.checkNotNullParameter(r9, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r14, "route");
        Intrinsics.checkNotNullParameter(r15, "snapshotResult");
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L22
        r11.put("plugin_id", r9);     // Catch: Exception -> L22
        if (r16 <= 0) goto L6;
        r11.put("plugin_version_code", r16);     // Catch: Exception -> L22
    L6:
        r11.put("route", r14);     // Catch: Exception -> L22
        r11.put("snapshot_result", r15);     // Catch: Exception -> L22
        r11.put("snapshot_cost", r17);     // Catch: Exception -> L22
        r11.put("ipc_cost", r19);     // Catch: Exception -> L22
        r11.put("skip_get_package_manager", r21);     // Catch: Exception -> L22
        r11.put("skip_is_plugin_installed", r22);     // Catch: Exception -> L22
        r11.put("skip_get_installed_version", r23);     // Catch: Exception -> L22
        r11.put("saved_ipc_call_count", r22 + r23);     // Catch: Exception -> L22
        r11.put("main_process_alive", r28);     // Catch: Exception -> L22
        if (Intrinsics.areEqual(r14, "snapshot") == false) goto L10;
        if (r28 != 0) goto L10;
        int r0 = 1;
    L11:
        r11.put("main_process_start_avoided_likely", r0);     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r24) == true) goto L15;
        r11.put("reason", r24);     // Catch: Exception -> L22
    L15:
        if (TextUtils.isEmpty(r25) == true) goto L18;
        r11.put("ipc_result", r25);     // Catch: Exception -> L22
    L18:
        if (r26 <= 0) goto L20;
        r11.put("snapshot_update_time", r26);     // Catch: Exception -> L22
    L20:
        fqc.b.c("obric_zeus_install_state_route", r11);     // Catch: Exception -> L22
        return;
    L10:
        r0 = 0;
    L22:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_REPORTER, "report install state route failed", e);
    }
}
