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
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.IPackageManager;
import com.volcengine.zeus.PluginClassLoader;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusApplication;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.servermanager.ServerManagerHelper;
import com.volcengine.zeus.util.kv.KVHolder;
import com.volcengine.zeus.util.kv.KVStorage;
import com.volcengine.zeus.wrapper.PluginApplicationWrapper;
import java.io.File;
import java.io.FileFilter;
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
import mqc.n;
import mqc.p;
import mqc.r;
import mqc.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: loaded from: classes41.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f462743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f462744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Plugin f462745c;

        public final void a() {
            Plugin r100 = this.f462745c;     // Catch: Throwable -> L24
            if (r100.mReInstallInternalPluginByMd5 == false) goto L6;
            String r101 = r100.getInternalPluginIdentity();     // Catch: Throwable -> L24
        L8:
            if (this.f462743a == true) goto L10;
        L12:
            Application r102 = Zeus.getAppApplication();     // Catch: Throwable -> L24
            if (dqc.c.f469732c != null) goto L15;
            File r103 = r102.getFilesDir();     // Catch: Throwable -> L24
            String r104 = com.volcengine.zeus.g.f462704a;     // Catch: Throwable -> L24
            dqc.c.f469732c = new PolarisFileWrapper(r103, ".zeus_i");     // Catch: Throwable -> L24
        L15:
            PolarisFileWrapper r105 = new PolarisFileWrapper(dqc.c.b(dqc.c.f469732c), this.f462745c.mPkgName + ".apk");     // Catch: Throwable -> L24
            ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.access$100(this.f462745c) + " --> " + r105.getAbsolutePath());     // Catch: Throwable -> L24
            mqc.i.d(Zeus.getAppApplication().getAssets().open(Plugin.access$100(this.f462745c)), new PolarisFileOutputStreamWrapper(r105));     // Catch: Throwable -> L24
            if (r105.exists() == true) goto L19;
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + r105.getAbsolutePath() + " is not exists.");     // Catch: Throwable -> L24
            return;
        L19:
            if (this.f462744b == false) goto L21;
            PluginManager.getInstance().asyncInstall(this.f462745c.mPkgName, r105, r101, "internal");     // Catch: Throwable -> L24
            return;
        L21:
            PluginManager.getInstance().syncInstall(this.f462745c.mPkgName, r105, r101, "internal");     // Catch: Throwable -> L24
            return;
        L10:
            if (Plugin.access$000(this.f462745c, r101) == true) goto L12;
            return;
        L6:
            r101 = null;
        L24:
            th = move-exception;
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + th.getMessage());
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

        public a(Plugin r100, boolean r101, boolean r102) {
            this.f462745c = r100;
            this.f462743a = r101;
            this.f462744b = r102;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public class b implements FileFilter {
        public b() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r100) {
            if (r100 != null) goto L4;
        L6:
            return false;
        L4:
            if (r100.getName().matches("^version-(\\d+)$") == false) goto L6;
            return true;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class c implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Plugin f462746a;

        public c(Plugin r100) {
            this.f462746a = r100;
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r100) {
            if (r100.getName().matches("^version-(\\d+)$") == false) goto L5;
            int r101 = CastIntegerProtector.parseInt(r100.getName().split("-")[1]);
            t.c().j(this.f462746a.mPkgName, r101, false);
        L5:
            return false;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public class d implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f462747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Plugin f462748b;

        @Override // java.io.FileFilter
        public final boolean accept(File r100) {
            if (r100 != null) goto L5;
        L13:
            return false;
        L5:
            if (r100.getName().startsWith("preversion-") == true) goto L13;
            if (this.f462747a.equals(r100.getName()) == true) goto L13;
            if ("data".equals(r100.getName()) == true) goto L13;
            mqc.i.e(new PolarisFileWrapper(r100.getAbsolutePath()));
            ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + r100.getAbsolutePath());
            if (r100.getName().matches("^version-(\\d+)$") == false) goto L13;
            t.c().j(this.f462748b.mPkgName, CastIntegerProtector.parseInt(r100.getName().split("-")[1]), false);
            goto L13
        }

        public d(Plugin r100, String r101) {
            this.f462748b = r100;
            this.f462747a = r101;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f462749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f462750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f462751c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f462752d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f462753e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f462754f;

        public e(boolean r100, boolean r101, String r102, String r103, long r104, int r105) {
            this.f462749a = r100;
            this.f462750b = r101;
            this.f462751c = r102;
            this.f462752d = r103;
            this.f462753e = r104;
            this.f462754f = r105;
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir) == false) goto L5;
        this.mPackageDir = dqc.c.a(new String[]{this.mPkgName});
    L5:
        new PolarisFileWrapper(this.mPackageDir).listFiles(new c(this));
        mqc.i.e(new PolarisFileWrapper(this.mPackageDir));
    }

    private void setupInternalPlugin() {
        boolean r100 = true;
        int r101 = 0;
        if (t.c().f514970a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", new Object[]{this.mPkgName}), -1) == this.mApiVersionCode) goto L6;
        r100 = false;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        StringBuilder r102 = new StringBuilder("zeus_l/");
        String r103 = com.volcengine.zeus.g.f462704a;
        r102.append(this.mPkgName);
        r102.append(InvRouter.FLOW_SUFFIX);
        this.mInternalMetaPath = r102.toString();
        if (TextUtils.isEmpty(this.mInternalPath) == false) goto L11;
    L26:
        String[] r104 = Zeus.getAppApplication().getAssets().list("zeus_p");     // Catch: IOException -> L23
        int r105 = r104.length;     // Catch: IOException -> L23
    L14:
        if (r101 >= r105) goto L32;
        String r106 = r104[r101];     // Catch: IOException -> L23
        if (r106.startsWith(this.mPkgName + "_") == false) goto L22;
        n.f514959a.getClass();     // Catch: IOException -> L23
        n.a r107 = n.a(r106);     // Catch: IOException -> L23
        if (r107 == null) goto L22;
        StringBuilder r108 = new StringBuilder();     // Catch: IOException -> L23
        String r109 = com.volcengine.zeus.g.f462704a;     // Catch: IOException -> L23
        r108.append("zeus_p");     // Catch: IOException -> L23
        r108.append(HTTP.URL_DEFAULT);     // Catch: IOException -> L23
        r108.append(r106);     // Catch: IOException -> L23
        this.mInternalPath = r108.toString();     // Catch: IOException -> L23
        this.mInternalVersionCode = r107.f514961b;     // Catch: IOException -> L23
        return;
    L22:
        r101 = r101 + 1;
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
        StringBuilder r100 = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
        Zeus.getAppApplication();
        r100.append(dqc.d.c());
        ZeusLogger.w(ZeusLogger.TAG_PPM, r100.toString(), th);
        return;
    L4:
        if (dqc.d.d(Zeus.getAppApplication()) == false) goto L6;
        return;
    L6:
        if (this.mLifeCycle >= 2) goto L38;
        e r101 = tryUpdateInstallStateFromSnapshot(true);     // Catch: Throwable -> L30
        if (r101.f462749a == false) goto L10;
        return;
    L10:
        long r102 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L30
        int r103 = 0;
        IPackageManager r104 = ServerManagerHelper.getPackageManager();     // Catch: Throwable -> L26
        if (r104 != null) goto L15;
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "updateInstallStateFromMainProcess error. packageManager is null. pkg=" + this.mPkgName);     // Catch: Throwable -> L26
        String r110 = "package_manager_null";
        int r105 = 0;
    L25:
        reportInstallStateRoute("ipc", r101.f462751c, r105, r101.f462753e, SystemClock.elapsedRealtime() - r102, 0, 0, 0, r101.f462752d, r110, 0, r101.f462754f);     // Catch: Throwable -> L30
        return;
    L15:
        if (r104.isPluginInstalled(this.mPkgName) == false) goto L21;
        r103 = r104.getInstalledVersion(this.mPkgName);     // Catch: Throwable -> L26
        updateToInstalled(r103);     // Catch: Throwable -> L19
        String r106 = "installed";
    L22:
        r110 = r106;
        r105 = r103;
    L19:
        th = th;
        int r107 = r103;
    L28:
        reportInstallStateRoute("ipc", r101.f462751c, r107, r101.f462753e, SystemClock.elapsedRealtime() - r102, 0, 0, 0, r101.f462752d, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, 0, r101.f462754f);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L21:
        r106 = "not_installed";
    L26:
        th = th;
        r107 = 0;
        goto L28
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir) == false) goto L5;
        this.mPackageDir = dqc.c.a(new String[]{this.mPkgName});
    L5:
        File[] r100 = new PolarisFileWrapper(this.mPackageDir).listFiles(new b());
        int r101 = -1;
        if (r100 != null) goto L8;
    L21:
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + r101);
        return r101;
    L8:
        if (r100.length <= 0) goto L21;
        int r102 = r100.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L21;
        String r104 = r100[r103].getName().split("-")[1];
        int r105 = CastIntegerProtector.parseInt(r104);
        Lazy r106 = PluginProtocolVersionChecker.f462770a;
        if (PluginProtocolVersionChecker.a(this.mPkgName, r104) == true) goto L14;
        ZeusLogger.w(ZeusLogger.TAG_INIT, String.format("ignore not compatible plugin %s[%s]", new Object[]{this.mPkgName, r104}));
    L20:
        r103 = r103 + 1;
        goto L10
    L14:
        if (r105 <= r101) goto L20;
        if (t.c().h(this.mPkgName, r105) == false) goto L20;
        if (new PolarisFileWrapper(dqc.c.h(this.mPkgName, r105, false)).exists() == false) goto L20;
        r101 = r105;
        goto L20
    }

    public String getInternalPluginIdentity() {
        String r100 = this.mInternalPluginIdentity;
        if (r100 == null) goto L37;
        return r100;
    L37:
        InputStream r101 = Zeus.getAppApplication().getAssets().open(this.mInternalMetaPath);     // Catch: JSONException -> L25 Throwable -> L27
        byte[] r102 = new byte[r101.available()];     // Catch: Throwable -> L16
        int r103 = r101.read(r102);     // Catch: Throwable -> L16
        if (r103 <= 0) goto L10;
        String r104 = new String(r102, 0, r103, StandardCharsets.UTF_8);     // Catch: Throwable -> L16
    L11:
        String r105 = new JSONObject(r104).optString("checksum", "");     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r105) == true) goto L14;
        this.mInternalPluginIdentity = r105;     // Catch: Throwable -> L16
    L14:
        r101.close();     // Catch: JSONException -> L25 Throwable -> L27
    L30:
        return this.mInternalPluginIdentity;
    L10:
        r104 = "";
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        if (r101 != null) goto L35;
    L24:
        throw th;     // Catch: JSONException -> L25 Throwable -> L27
    L35:
        r101.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: JSONException -> L25 Throwable -> L27
    L27:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Failed to read internal plugin meta file: " + this.mInternalMetaPath, e);
        goto L30
    }

    public String getNativeLibraryDir() {
        int r100 = this.mVersionCode;
        if (r100 <= 0) goto L7;
        return dqc.c.e(this.mPkgName, r100, false);
    L7:
        return dqc.c.a(new String[]{this.mPkgName});
    }

    public void init() {
        if (this.mInitialized == false) goto L5;
        return;
    L5:
        Object r100 = this.initializeLock;
        monitor-enter(r100);
    L28:
        th = move-exception;
        throw th;
    L8:
        if (this.mInitialized == false) goto L12;
        monitor-exit(r100);     // Catch: Throwable -> L28
        return;
    L12:
        if (dqc.d.d(Zeus.getAppApplication()) == false) goto L30;
        boolean r101 = GlobalParam.getInstance().enableCreateInstallStateSnapshot();     // Catch: Throwable -> L28
        t r102 = t.c();     // Catch: Throwable -> L28
        String r103 = this.mPkgName;     // Catch: Throwable -> L28
        int r104 = 0;
        if ((!TextUtils.isEmpty(r102.f514970a.getString("HOST_ABI_" + r103, ""))) == false) goto L16;
        boolean r105 = t.c().g(this.mPkgName);     // Catch: Throwable -> L28
    L17:
        deleteIfNeeded();     // Catch: Throwable -> L28
        if (r101 == false) goto L20;
        com.volcengine.zeus.plugin.d.g(this.mPkgName, this.mApiVersionCode, "reconcile_pending", "reconcile_start");     // Catch: Throwable -> L28
    L20:
        int r106 = getInstalledMaxVer();     // Catch: Throwable -> L28
        if (checkVersionValid(r106, this.mApiVersionCode, r105) == false) goto L23;
        r104 = modifyResIfNeed(r106);     // Catch: Throwable -> L28
        updateToInstalled(r104);     // Catch: Throwable -> L28
    L23:
        deleteOtherExpiredVer(r104);     // Catch: Throwable -> L28
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=" + this);     // Catch: Throwable -> L28
        t.c().n(this.mPkgName);     // Catch: Throwable -> L28
        t.c().k(this.mPkgName);     // Catch: Throwable -> L28
        t.c().l(this.mPkgName, mqc.b.a(Zeus.getAppApplication()));     // Catch: Throwable -> L28
        t.c().m(this.mPkgName, this.mApiVersionCode);     // Catch: Throwable -> L28
        if (r101 == false) goto L31;
        if (r104 <= 0) goto L27;
        com.volcengine.zeus.plugin.d.f(this.mPkgName, r104, this.mApiVersionCode);     // Catch: Throwable -> L28
        goto L31
    L27:
        com.volcengine.zeus.plugin.d.g(this.mPkgName, this.mApiVersionCode, "not_installed", "reconcile_no_valid_version");     // Catch: Throwable -> L28
    L31:
        this.mInitialized = true;     // Catch: Throwable -> L28
        monitor-exit(r100);     // Catch: Throwable -> L28
        if (shouldInstallInternalPlugin(true) == false) goto L40;
        installInternalPlugin(true);
        return;
    L40:
        return;
    L16:
        r105 = false;
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
        Iterator<String> r100 = this.mAllPluginProcesses.iterator();
        boolean r101 = false;
    L8:
        if (r100.hasNext() == false) goto L10;
        r101 = r101 | KVStorage.INSTANCE.dynamicKV(r100.next()).getBoolean(String.format("zeus_plugin_%s_loaded", new Object[]{this.mPkgName}), false);
        goto L8
    L10:
        return r101;
    L5:
        return KVStorage.INSTANCE.mainDynamicKV().getBoolean(String.format("zeus_plugin_%s_loaded", new Object[]{this.mPkgName}), false);
    }

    public void reset() {
        Object r100 = this.initializeLock;
        monitor-enter(r100);
        this.mInitialized = false;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
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
        if (dqc.d.d(Zeus.getAppApplication()) == false) goto L12;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "InstallStateSnapshotOnly skipped. main process. pkg=" + this.mPkgName);     // Catch: Throwable -> L13
        return false;
    L12:
        return tryUpdateInstallStateFromSnapshot(false).f462750b;
    }

    private void deleteIfNeeded() {
        if (dqc.d.d(Zeus.getAppApplication()) == true) goto L5;
        return;
    L5:
        boolean r100 = GlobalParam.getInstance().enableCreateInstallStateSnapshot();
        String r101 = this.mPkgName;
        if (TextUtils.isEmpty(r101) == false) goto L44;
    L23:
        boolean r102 = false;
    L24:
        t r103 = t.c();
        String r104 = this.mPkgName;
        boolean r105 = r103.f514970a.getBoolean("UNINSTALL__" + r104, false);
        if (r102 == true) goto L27;
        if (r105 == true) goto L27;
        return;
    L27:
        if (r100 == false) goto L29;
        com.volcengine.zeus.plugin.d.d(this.mPkgName, this.mApiVersionCode);
    L29:
        deleteInstalledPlugin();
        if (r100 == false) goto L32;
        com.volcengine.zeus.plugin.d.g(this.mPkgName, this.mApiVersionCode, "not_installed", "uninstall_completed");
    L33:
        String r106 = this.mPkgName;
        if (TextUtils.isEmpty(r106) == false) goto L42;
    L40:
        t r107 = t.c();
        String r108 = this.mPkgName;
        SharedPreferences.Editor r109 = r107.f514970a.edit();
        r109.remove("UNINSTALL__" + r108);
        r109.apply();
        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
        return;
    L42:
        KVStorage.INSTANCE.staticKV().erase(com.volcengine.zeus.plugin.d.c(r106));     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot clear pending uninstall state failed. " + r106, th);
        goto L40
    L32:
        com.volcengine.zeus.plugin.d.a(this.mPkgName);
        goto L33
    L44:
        KVStorage r110 = KVStorage.INSTANCE;     // Catch: Throwable -> L21
        r102 = true;
        if (r110.staticKV().getBoolean(com.volcengine.zeus.plugin.d.c(r101), false) == true) goto L24;
        String r111 = r110.staticKV().getString(com.volcengine.zeus.plugin.d.b(r101), "");     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r111) == true) goto L23;
        JSONObject r112 = new JSONObject(r111);     // Catch: Throwable -> L21
        if (r112.optInt("schema") != 1) goto L23;
        if (TextUtils.equals(r101, r112.optString("packageName")) == false) goto L23;
        if (TextUtils.equals("pending_uninstall", r112.optString("state")) == false) goto L23;
    L21:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot read pending uninstall state failed. " + r101, th);
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

    public Plugin(JSONObject r100) throws JSONException {
        this(r100, Boolean.FALSE);
    }

    public static /* synthetic */ String access$100(Plugin r100) {
        return r100.mInternalPath;
    }

    private void deleteOtherExpiredVer(int r100) {
        if (dqc.d.d(Zeus.getAppApplication()) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mPackageDir) == false) goto L7;
        this.mPackageDir = dqc.c.a(new String[]{this.mPkgName});
    L7:
        new PolarisFileWrapper(this.mPackageDir).listFiles(new d(this, PluginDirHelper.VERSION_PREFIX + r100));
    }

    private boolean isAllowInstall(int r100) {
        int r101 = this.mAllowInstallVersion;
        if (r101 != (-1)) goto L5;
        return true;
    L5:
        if (r100 >= r101) goto L9;
        return false;
    L9:
        return true;
    }

    private boolean isInternalPluginInstallPreCheckPassed(boolean r110) {
        if (ZeusLogger.isDebug() == false) goto L41;
        Lazy r100 = PluginProtocolVersionChecker.f462770a;
        if (PluginProtocolVersionChecker.a(this.mPkgName, String.valueOf(this.mInternalVersionCode)) == true) goto L41;
        String r111 = (String) PluginProtocolVersionChecker.f462770a.getValue();
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin installInternalPlugin stopped by protocol mismatch. pkgName=" + this.mPkgName + ", internalVersionCode=" + this.mInternalVersionCode + ", hostProtocolVersion=" + r111);
        String r101 = this.mPkgName;
        int r102 = this.mInternalVersionCode;
        ConcurrentHashMap<String, Long> r103 = com.volcengine.zeus.plugin.b.f462773a;
        Intrinsics.checkNotNullParameter(r101, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r111, "hostProtocolVersion");
        Application r104 = Zeus.getAppApplication();
        if (r104 != null) goto L9;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier notifyMismatch skipped because app context is null");
    L40:
        return false;
    L9:
        long r105 = System.currentTimeMillis();
        ConcurrentHashMap<String, Long> r106 = com.volcengine.zeus.plugin.b.f462773a;
        Long r107 = r106.get(r101);
        if (r107 != null) goto L12;
    L14:
        r106.put(r101, Long.valueOf(r105));
        p.b(new com.volcengine.zeus.plugin.a(r104, r101));
    L52:
        com.volcengine.zeus.plugin.b.a(r104);     // Catch: Throwable -> L38
        String r108 = "https://bytedance.larkoffice.com/wiki/N3qiwrgjTicZ5pkQiBWc4VjAnAz#share-CLELdheNpoLKe0xXbTzc3BJCnRf";
        r108 = "https://applink.feishu.cn/client/docs/open?url=" + URLEncoder.encode("https://bytedance.larkoffice.com/wiki/N3qiwrgjTicZ5pkQiBWc4VjAnAz#share-CLELdheNpoLKe0xXbTzc3BJCnRf", "UTF-8");     // Catch: Throwable -> L19
    L21:
        Intent r109 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r108));     // Catch: Throwable -> L38
        r109.addFlags(268435456);     // Catch: Throwable -> L38
        int r112 = r101.hashCode();     // Catch: Throwable -> L38
        if (Build.VERSION.SDK_INT < 23) goto L24;
        int r113 = 67108864;
    L25:
        PendingIntent r114 = PendingIntent.getActivity(r104, r112, r109, r113 | AMapEngineUtils.HALF_MAX_P20_WIDTH);     // Catch: Throwable -> L38
        String r115 = "插件 " + r101 + " 内置版本 " + r102 + " 与宿主协议版本 " + r111 + " 不兼容，点击查看处理文档";     // Catch: Throwable -> L38
        NotificationCompat.Builder r116 = new NotificationCompat.Builder(r104, "zeus_internal_plugin_protocol_mismatch");     // Catch: Throwable -> L38
        ApplicationInfo r117 = r104.getApplicationInfo();     // Catch: Throwable -> L38
        if (r117 == null) goto L28;
        int r118 = r117.icon;     // Catch: Throwable -> L38
    L29:
        if (r118 != 0) goto L32;
        r118 = R.drawable.stat_sys_warning;
    L32:
        Notification r119 = r116.setSmallIcon(r118).setContentTitle("内置插件版本不兼容").setContentText(r115).setStyle(new NotificationCompat.BigTextStyle().bigText(r115)).setContentIntent(r114).setOngoing(true).setAutoCancel(false).setPriority(1).setCategory("err").setOnlyAlertOnce(true).build();     // Catch: Throwable -> L38
        r119.flags |= 32;     // Catch: Throwable -> L38
        NotificationManagerCompat r120 = NotificationManagerCompat.from(r104);     // Catch: Throwable -> L38
        int r121 = r101.hashCode();     // Catch: Throwable -> L38
        if (r121 != Integer.MIN_VALUE) goto L35;
        int r122 = 0;
    L36:
        r120.notify(r122 + 1509949440, r119);     // Catch: Throwable -> L38
        com.volcengine.zeus.plugin.b.c(r104, r101);     // Catch: Throwable -> L38
        goto L40
    L35:
        r122 = Math.abs(r121);     // Catch: Throwable -> L38
        goto L36
    L28:
        r118 = 0;
        goto L29
    L24:
        r113 = 0;
        goto L25
    L19:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier build applink failed, fallback to raw doc url", th);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier show notification failed. pluginPkgName=" + r101, th);
        goto L40
    L12:
        if ((r105 - r107.longValue()) >= 5000) goto L14;
    L41:
        if (r110 == false) goto L46;
        if (GlobalParam.getInstance().isAutoInstallInternal(this.mPkgName) == true) goto L46;
        return false;
    L46:
        if (dqc.d.d(Zeus.getAppApplication()) == true) goto L48;
    L51:
        return false;
    L48:
        if (TextUtils.isEmpty(this.mInternalPath) == true) goto L51;
        return true;
    }

    private int modifyResIfNeed(int r100) {
        String r101 = mqc.b.a(Zeus.getAppApplication());
        if (TextUtils.isEmpty(r101) == true) goto L9;
        if (TextUtils.equals(t.c().b(this.mPkgName), r101) == false) goto L9;
        return r100;
    L9:
        if (this.mUnInstallPluginWhenHostChange == false) goto L11;
    L20:
        ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + r100);
        return 0;
    L11:
        if (GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName) == true) goto L20;
        ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + r100);
        int r102 = kqc.e.a(new PolarisFileWrapper(dqc.c.h(this.mPkgName, r100, false)), true, new StringBuilder(), new kqc.c());
        if (r102 != 100) goto L16;
    L19:
        return r100;
    L16:
        if (r102 == 200) goto L19;
        return 0;
    }

    private boolean shouldReinstallSameVersionInternalPlugin(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Stop installing the same version plugin with empty identity");
        return false;
    L7:
        if (TextUtils.equals(r100, mqc.d.a(this.mPkgName)) == false) goto L10;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Stop installing the same version plugin with same identity " + r100);
        return false;
    L10:
        return true;
    }

    private e tryUpdateInstallStateFromSnapshot(boolean r410) {
        boolean r100 = GlobalParam.getInstance().enableUseInstallStateSnapshot();
        boolean r101 = GlobalParam.getInstance().canUseInstallStateSnapshot(this.mPkgName);
        if (r100 == false) goto L5;
        String r102 = "snapshot_precondition_rejected";
    L7:
        if (GlobalParam.getInstance().getReporter() != null) goto L9;
        int r110 = -1;
    L11:
        if (r101 == false) goto L131;
        long r103 = SystemClock.elapsedRealtime();
        String r111 = this.mPkgName;
        int r104 = this.mApiVersionCode;
        int r112 = this.mMinVersionCode;
        int r113 = this.mMaxVersionCode;
        if (TextUtils.isEmpty(r111) == false) goto L138;
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginInstallStateSnapshot read skipped, empty packageName.");
        com.volcengine.zeus.plugin.d.a r105 = new com.volcengine.zeus.plugin.d.a(0, "miss", "empty_package_name", 0);
        String r106 = ZeusLogger.TAG_LOAD;
    L118:
        long r114 = SystemClock.elapsedRealtime() - r103;
        int r107 = r105.f462778a;
        String r115 = r105.f462779b;
        String r116 = r105.f462780c;
        if (r107 <= 0) goto L123;
        updateToInstalled(r107);
        ZeusLogger.i(r106, "InstallStateSnapshotIPC saved. oldPath=IPackageManager newPath=Snapshot pkg=" + this.mPkgName + " version=" + r107);
        reportInstallStateRoute("snapshot", r115, r107, r114, 0, 1, 1, 1, r116, null, r105.f462781d, r110);
        return new e(true, true, r115, r116, r114, r110);
    L123:
        if (r107 != (-1)) goto L126;
        ZeusLogger.i(r106, "InstallStateSnapshotIPC saved. oldPath=IPackageManager newPath=Snapshot pkg=" + this.mPkgName + " state=not_installed");
        reportInstallStateRoute("snapshot", r115, 0, r114, 0, 1, 1, 0, r116, null, r105.f462781d, r110);
        return new e(true, false, r115, r116, r114, r110);
    L126:
        StringBuilder r108 = new StringBuilder("InstallStateSnapshot ");
        if (r410 == false) goto L129;
        String r109 = "fallback. path=IPackageManager";
    L130:
        r108.append(r109);
        r108.append(" reason=");
        r108.append(r116);
        r108.append(" pkg=");
        r108.append(this.mPkgName);
        ZeusLogger.i(r106, r108.toString());
        String r117 = r116;
        long r118 = r114;
        String r119 = r115;
    L137:
        return new e(false, false, r119, r117, r118, r110);
    L129:
        r109 = "miss. noIpcFallback";
        goto L130
    L138:
        KVStorage r310 = KVStorage.INSTANCE;     // Catch: Throwable -> L115
        String r311 = ZeusLogger.TAG_LOAD;
    L108:
        th = th;
    L117:
        r106 = r311;
        ZeusLogger.w(r106, "PluginInstallStateSnapshot read installed snapshot failed. " + r111, th);
        r105 = new com.volcengine.zeus.plugin.d.a(0, "miss", "read_exception", 0);
        goto L118
    L18:
        if (r310.staticKV().getBoolean(com.volcengine.zeus.plugin.d.c(r111), false) == false) goto L20;
        r105 = com.volcengine.zeus.plugin.d.e(r111, "uninstall_pending", "uninstall pending");     // Catch: Throwable -> L108
    L114:
        r106 = r311;
        goto L118
    L20:
        String r120 = r310.staticKV().getString(com.volcengine.zeus.plugin.d.b(r111), "");     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r120) == false) goto L23;
        r105 = com.volcengine.zeus.plugin.d.e(r111, "empty_snapshot", "empty snapshot");     // Catch: Throwable -> L108
        goto L114
    L23:
        JSONObject r121 = new JSONObject(r120);     // Catch: Throwable -> L108
        if (r121.optInt("schema") == 1) goto L27;
        r105 = com.volcengine.zeus.plugin.d.e(r111, "schema_mismatch", "schema mismatch. snapshot=" + r121.optInt("schema") + " expected=1");     // Catch: Throwable -> L108
        goto L114
    L27:
        if (TextUtils.equals(r111, r121.optString("packageName")) == true) goto L30;
        r105 = com.volcengine.zeus.plugin.d.e(r111, "package_name_mismatch", "packageName mismatch. snapshot=" + r121.optString("packageName"));     // Catch: Throwable -> L108
        goto L114
    L30:
        if (r121.has(com.alipay.sdk.m.l.c.f25508m) == true) goto L32;
    L113:
        r105 = com.volcengine.zeus.plugin.d.e(r111, "api_version_mismatch", "apiVersion mismatch. snapshot=" + r121.optInt(com.alipay.sdk.m.l.c.f25508m, 0) + " expected=" + r104);     // Catch: Throwable -> L108
        goto L114
    L32:
        if (r121.optInt(com.alipay.sdk.m.l.c.f25508m, 0) != r104) goto L113;
        if (TextUtils.equals(r121.optString("hostAbi"), Zeus.getHostAbi()) == true) goto L38;
        r105 = com.volcengine.zeus.plugin.d.e(r111, "host_abi_mismatch", "hostAbi mismatch. snapshot=" + r121.optString("hostAbi") + " current=" + Zeus.getHostAbi());     // Catch: Throwable -> L108
        goto L114
    L38:
        String r122 = mqc.b.a(Zeus.getAppApplication());     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r122) == false) goto L42;
    L112:
        r105 = com.volcengine.zeus.plugin.d.e(r111, "host_identity_mismatch", "hostIdentity mismatch. snapshot=" + r121.optString("hostIdentity") + " current=" + r122);     // Catch: Throwable -> L108
        goto L114
    L42:
        if (TextUtils.equals(r121.optString("hostIdentity"), r122) == false) goto L112;
        String r123 = r121.optString("state");     // Catch: Throwable -> L108
        if (TextUtils.equals("not_installed", r123) == false) goto L52;
        if (r121.optBoolean("installed", true) == false) goto L50;
        r105 = com.volcengine.zeus.plugin.d.e(r111, "not_installed_flag_invalid", "not-installed state with installed flag true");     // Catch: Throwable -> L108
        goto L114
    L50:
        r105 = new com.volcengine.zeus.plugin.d.a(-1, "not_installed", r121.optString("reason"), r121.optLong(UserInfo.UPDATE_TIME, 0));     // Catch: Throwable -> L108
        goto L114
    L52:
        if (TextUtils.equals("installed", r123) == true) goto L65;
        if (TextUtils.equals("pending_uninstall", r123) == false) goto L57;
        String r124 = "state_pending_uninstall";
    L63:
        r105 = com.volcengine.zeus.plugin.d.e(r111, r124, "state unavailable. state=" + r123 + " reason=" + r121.optString("reason"));     // Catch: Throwable -> L108
        goto L114
    L57:
        if (TextUtils.equals("reconcile_pending", r123) == false) goto L60;
        r124 = "state_reconcile_pending";
        goto L63
    L60:
        if (TextUtils.equals("install_pending", r123) == false) goto L62;
        r124 = "state_install_pending";
        goto L63
    L62:
        r124 = "state_unknown";
        goto L63
    L65:
        if (r121.optBoolean("installed") == true) goto L67;
        r105 = com.volcengine.zeus.plugin.d.e(r111, "installed_flag_false", "installed flag false");     // Catch: Throwable -> L108
        goto L114
    L67:
        int r125 = r121.optInt("version", 0);     // Catch: Throwable -> L108
        if (r125 <= 0) goto L110;
        if (r125 < r112) goto L110;
        int r126 = r113;
        if (r125 > r126) goto L111;
        Lazy r127 = PluginProtocolVersionChecker.f462770a;     // Catch: Throwable -> L108
        if (PluginProtocolVersionChecker.a(r111, String.valueOf(r125)) == true) goto L76;
        r105 = com.volcengine.zeus.plugin.d.e(r111, "protocol_version_mismatch", "protocol version mismatch. version=" + r125);     // Catch: Throwable -> L108
        goto L114
    L76:
        String r128 = dqc.c.f(r111, r125, false);     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r128) == false) goto L79;
        PolarisFileWrapper r129 = null;
    L80:
        if (r129 != null) goto L82;
    L103:
        StringBuilder r130 = new StringBuilder("source apk not exists. version=");     // Catch: Throwable -> L108
        r130.append(r125);     // Catch: Throwable -> L108
        r130.append(" path=");     // Catch: Throwable -> L108
        if (r129 != null) goto L106;
        String r131 = "null";
    L107:
        r130.append(r131);     // Catch: Throwable -> L108
        r105 = com.volcengine.zeus.plugin.d.e(r111, "source_apk_missing", r130.toString());     // Catch: Throwable -> L108
        goto L114
    L106:
        r131 = r129.getAbsolutePath();     // Catch: Throwable -> L108
        goto L107
    L82:
        if (r129.exists() == false) goto L103;
        String r132 = r121.optString("apkPath");     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r132) == false) goto L87;
    L102:
        r105 = com.volcengine.zeus.plugin.d.e(r111, "apk_path_mismatch", "apk path mismatch. snapshot=" + r132 + " current=" + r129.getAbsolutePath());     // Catch: Throwable -> L108
        goto L114
    L87:
        if (TextUtils.equals(r132, r129.getAbsolutePath()) == false) goto L102;
        long r133 = r121.optLong("apkLength", -1);     // Catch: Throwable -> L108
        if (r133 > 0) goto L92;
    L101:
        r105 = com.volcengine.zeus.plugin.d.e(r111, "apk_length_mismatch", "apk length mismatch. snapshot=" + r133 + " current=" + r129.length());     // Catch: Throwable -> L108
        goto L114
    L92:
        if (r133 != r129.length()) goto L101;
        long r134 = r121.optLong("apkLastModified", -1);     // Catch: Throwable -> L108
        if (r134 > 0) goto L97;
    L100:
        r105 = com.volcengine.zeus.plugin.d.e(r111, "apk_last_modified_mismatch", "apk lastModified mismatch. snapshot=" + r134 + " current=" + r129.lastModified());     // Catch: Throwable -> L108
        goto L114
    L97:
        if (r134 != r129.lastModified()) goto L100;
        r105 = new com.volcengine.zeus.plugin.d.a(r125, "installed", "snapshot_valid", r121.optLong(UserInfo.UPDATE_TIME, 0));     // Catch: Throwable -> L108
        goto L114
    L79:
        r129 = new PolarisFileWrapper(new PolarisFileWrapper(r128, "apk"), "base-1.apk");     // Catch: Throwable -> L108
    L111:
        r105 = com.volcengine.zeus.plugin.d.e(r111, "version_invalid", "version invalid. snapshot=" + r125 + " min=" + r112 + " max=" + r126);     // Catch: Throwable -> L108
    L110:
        r126 = r113;
    L115:
        th = th;
        r311 = ZeusLogger.TAG_LOAD;
        goto L117
    L131:
        StringBuilder r135 = new StringBuilder("InstallStateSnapshot ");
        if (r410 == false) goto L134;
        String r136 = "fallback. path=IPackageManager";
    L135:
        r135.append(r136);
        r135.append(" reason=");
        r135.append(r102);
        r135.append(" pkg=");
        r135.append(this.mPkgName);
        r135.append(" useSnapshotEnabled=");
        r135.append(r100);
        r135.append(" snapshotAllowed=");
        r135.append(r101);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r135.toString());
        r117 = r102;
        r118 = 0;
        r119 = "not_allowed";
        goto L137
    L134:
        r136 = "miss. noIpcFallback";
        goto L135
    L9:
        r110 = ServerManagerHelper.getMainProcessAliveState();
        goto L11
    L5:
        r102 = "snapshot_disabled";
        goto L7
    }

    private void updateToInstalled(int r100) {
        this.mVersionCode = r100;
        this.mLifeCycle = 2;
    }

    public void injectResponse(String r100) {
        this.response = r100;
    }

    public synchronized void installInternalPlugin(boolean r100) {
        monitor-enter(this);
        installInternalPlugin(r100, true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isVersionInstalled(int r100) {
        return t.c().h(this.mPkgName, r100);
    }

    public void setAllowInstallVersion(int r100) {
        this.mAllowInstallVersion = r100;
    }

    public void setLoaded(boolean r100) {
        this.loadedState.set(Boolean.valueOf(r100));
    }

    public synchronized boolean shouldInstallInternalPlugin(boolean r100) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        boolean r101 = false;
        if (isInternalPluginInstallPreCheckPassed(r100) == true) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.mReInstallInternalPluginByMd5 == false) goto L14;
        if (getVersion() <= this.mInternalVersionCode) goto L15;
    L16:
        monitor-exit(this);
        return r101;
    L15:
        r101 = true;
        goto L16
    L14:
        if (getVersion() >= this.mInternalVersionCode) goto L16;
        goto L15
    }

    public Plugin(JSONObject r110, Boolean r111) throws JSONException {
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
        this.mPkgName = JSONObjectProtectorUtils.getString(r110, "packageName");
        this.mMigrationHandler = GlobalParam.getInstance().getMigrationHandlerFactory().create(this.mPkgName);
        this.mPluginProcess = r110.optString("pluginProcess", "");
        JSONArray r100 = r110.optJSONArray("allPluginProcesses");
        if (r100 == null) goto L8;
        int r101 = 0;
    L6:
        if (r101 >= r100.length()) goto L8;
        this.mAllPluginProcesses.add((String) r100.get(r101));
        r101 = r101 + 1;
    L8:
        this.mMinVersionCode = r110.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = r110.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = JSONObjectProtectorUtils.getInt(r110, "apiVersionCode");
        String r102 = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = r102;
        if (TextUtils.isEmpty(r102) == false) goto L11;
        this.mSignature = r110.optString("signature", "");
    L11:
        this.mIsSupportLibIso = r110.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = r110.optString("internalPath", "");
        this.mInternalVersionCode = r110.optInt("internalVersionCode", -1);
        this.mAppKey = r110.optString(com.heytap.mcssdk.constant.b.f276376z, "");
        this.mAppSecretKey = r110.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = r110.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = r110.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = r110.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = r110.optBoolean("reInstallInternalPluginByMd5", true);
        this.mEnableSoNamespaceLink = r110.optBoolean("enableSoNamespaceLink", false);
        JSONArray r112 = r110.optJSONArray("soNamespaceLinkAllowList");
        if (r112 == null) goto L20;
        int r103 = 0;
    L15:
        if (r103 >= r112.length()) goto L20;
        String r104 = r112.optString(r103);
        if (TextUtils.isEmpty(r104) == true) goto L19;
        this.mSoNamespaceLinkAllowSet.add(r104);
    L19:
        r103 = r103 + 1;
    L20:
        this.loadedState = KVHolder.ofBoolean(KVStorage.INSTANCE.dynamicKV(), String.format("zeus_plugin_%s_loaded", new Object[]{this.mPkgName}), false);
        if (r111.booleanValue() == true) goto L23;
        setupInternalPlugin();
    L23:
        mqc.j.f514957f.b();
    }

    public static /* synthetic */ boolean access$000(Plugin r100, String r101) {
        return r100.shouldReinstallSameVersionInternalPlugin(r101);
    }

    public synchronized void installInternalPlugin(boolean r100, boolean r101) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (shouldInstallInternalPlugin(r100) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (getVersion() != this.mInternalVersionCode) goto L10;
        boolean r102 = true;
    L11:
        a r103 = new a(this, r102, r101);     // Catch: Throwable -> L17
        if (r101 == false) goto L14;
        dqc.e.b(r103);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L14:
        r103.run();     // Catch: Throwable -> L17
        goto L15
    L10:
        r102 = false;
        goto L11
    }

    public void setupInternalPluginParams(String r100, int r101) {
        ZeusLogger.i(TAG, "setupInternalPluginParams: internalPath = " + r100 + ", internalVersionCode = " + r101);
        this.mInternalPath = r100;
        this.mInternalVersionCode = r101;
    }

    public synchronized boolean shouldInstallInternalPlugin(boolean r100, boolean r101) {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        boolean r102 = false;
        if (isInternalPluginInstallPreCheckPassed(r100) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        int r103 = getVersion();     // Catch: Throwable -> L25
        int r104 = this.mInternalVersionCode;     // Catch: Throwable -> L25
        if (r103 >= r104) goto L13;
        monitor-exit(this);
        return true;
    L13:
        if (r103 <= r104) goto L15;
    L23:
        monitor-exit(this);
        return false;
    L15:
        if (this.mReInstallInternalPluginByMd5 == false) goto L23;
        if (r101 == false) goto L21;
        if (shouldReinstallSameVersionInternalPlugin() == false) goto L21;
        r102 = true;
    L21:
        monitor-exit(this);
        return r102;
    }

    private boolean checkValid(File r100, String r101, int r102) {
        if (TextUtils.equals(this.mPkgName, r101) == true) goto L6;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r101 + " package name not match !!!");
        return false;
    L6:
        Lazy r103 = PluginProtocolVersionChecker.f462770a;
        if (PluginProtocolVersionChecker.a(r101, String.valueOf(r102)) == true) goto L11;
        ZeusLogger.w(TAG, "PluginProtocolVersionChecker check failed. pkgName:" + r101 + " versionCode:" + r102 + ", hostProtocolVersion:" + ((String) PluginProtocolVersionChecker.f462770a.getValue()));
        return false;
    L11:
        if (r102 >= this.mMinVersionCode) goto L13;
    L35:
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r101 + " " + String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", new Object[]{Integer.valueOf(r102), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode)}));
        return false;
    L13:
        if (r102 > this.mMaxVersionCode) goto L35;
        if (r102 < this.mVersionCode) goto L18;
    L21:
        if (r100 != null) goto L23;
    L33:
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r101 + " pluginApk not exist.");
        return false;
    L23:
        if (r100.exists() == false) goto L33;
        if (r102 == this.mVersionCode) goto L28;
    L31:
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r101 + ":" + r102 + " true");
        return true;
    L28:
        if (this.mReInstallInternalPluginByMd5 == true) goto L31;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r101 + " pluginApk has same version code");
        return false;
    L18:
        if (isInstalled() == false) goto L21;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + r101 + String.format(" pluginApk ver[%s] lower than installed plugin[%s].", new Object[]{Integer.valueOf(r102), Integer.valueOf(this.mVersionCode)}));
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
    private boolean checkVersionValid(int r110, int r111, boolean r112) {
        int r100 = t.c().d(this.mPkgName);
        ?? r101 = 3;
        r101 = 3;
        r101 = 3;
        boolean r102 = false;
        if (r100 <= r111) goto L6;
        ZeusLogger.w(ZeusLogger.TAG_INIT, TAG + String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", new Object[]{this.mPkgName, Integer.valueOf(r100), Integer.valueOf(r111)}));
        return false;
    L6:
        if (r110 >= 0) goto L8;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L23;
        ?? r113 = -1;
        if (r111 == (-1)) goto L23;
        t r114 = t.c();
        String r115 = this.mPkgName;
        r113 = r114.f514970a.getInt("API_MIN_" + r115 + "_" + r110, 0);
        t r116 = t.c();
        String r117 = this.mPkgName;
        ?? r118 = 2147483647(0x7fffffff, float:NaN);
        ?? r119 = r116.f514970a.getInt("API_MAX_" + r117 + "_" + r110, Integer.MAX_VALUE);
        if (r119 == 0) goto L20;
        r118 = r119;
    L20:
        if (r111 < r113) goto L22;
        if (r111 <= r118) goto L23;
    L22:
        r119 = Integer.valueOf(this.mVersionCode);
        r101 = Integer.valueOf(r118);
        ZeusLogger.w(ZeusLogger.TAG_INIT, TAG + String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", new Object[]{this.mPkgName, r119, Integer.valueOf(r111), Integer.valueOf(r113), r101}));
        r103 = false;
    L23:
        if (r103 == false) goto L62;
        if (r112 == false) goto L62;
        PolarisFileWrapper r104 = new PolarisFileWrapper(dqc.c.h(this.mPkgName, r110, false));
        String r105 = dqc.b.f469728a;
        r101 = "NativeLibHelper hasNativeLib, close sourceApkZipFile error!";
        r113 = ZeusLogger.TAG_SO;
        ?? r120 = 0;
        r120 = 0;
        ?? r121 = 0;
        ?? r122 = new PolarisZipFileWrapper(r104);     // Catch: Throwable -> L45 IOException -> L47
        Enumeration<? extends ZipEntry> r106 = r122.entries();     // Catch: Throwable -> L41 IOException -> L43
        Pattern r123 = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");     // Catch: Throwable -> L41 IOException -> L43
    L29:
        if (r106.hasMoreElements() == false) goto L39;
        ZipEntry r124 = r106.nextElement();     // Catch: Throwable -> L41 IOException -> L43
        if (r124.isDirectory() == true) goto L29;
        if (r123.matcher(r124.getName()).matches() == false) goto L29;
        r122.close();     // Catch: IOException -> L37
    L38:
        boolean r107 = true;
        r119 = r123;
    L54:
        if (r107 == false) goto L62;
        ZeusLogger.w(ZeusLogger.TAG_INIT, TAG + String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", new Object[]{this.mPkgName, Integer.valueOf(r110)}));
        r101 = r101;
        r113 = r113;
        r121 = r119;
    L63:
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + r102);
        return r102;
    L37:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
        goto L38
    L39:
        r122.close();     // Catch: IOException -> L52
        r120 = r123;
    L70:
    L53:
        r107 = false;
        r119 = r120;
    L43:
        e = e;
        r120 = r122;
    L48:
        ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);     // Catch: Throwable -> L45
        if (r120 == 0) goto L53;
        r120.close();     // Catch: IOException -> L52
        r120 = r120;
    L41:
        th = th;
    L57:
        if (r122 != 0) goto L73;
    L61:
        throw th;
    L73:
        r122.close();     // Catch: IOException -> L60
    L60:
        ZeusLogger.w(r113, r101);
    L45:
        th = th;
        r122 = r121;
    L47:
        e = e;
    L52:
        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
    L62:
        r102 = r103;
        r101 = r101;
        r113 = r113;
        r121 = r119;
        goto L63
    L8:
        if (r110 < this.mMinVersionCode) goto L12;
        if (r110 > this.mMaxVersionCode) goto L12;
        r103 = true;
        goto L13
    }

    private void restoreInstallStateSnapshot(boolean r100, int r101, String r102) {
        PolarisFileWrapper r103 = null;
        if (r101 <= 0) goto L5;
        String r104 = dqc.c.f(this.mPkgName, r101, false);
    L7:
        if (TextUtils.isEmpty(r104) == true) goto L10;
        r103 = new PolarisFileWrapper(new PolarisFileWrapper(r104, "apk"), "base-1.apk");
    L10:
        if (r100 == false) goto L15;
        if (r103 == null) goto L15;
        if (r103.exists() == false) goto L15;
        com.volcengine.zeus.plugin.d.f(this.mPkgName, r101, this.mApiVersionCode);
        return;
    L15:
        com.volcengine.zeus.plugin.d.g(this.mPkgName, this.mApiVersionCode, "not_installed", r102);
        return;
    L5:
        r104 = null;
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
    public String install(File r210, hqc.e r211, String r212) {
        String r100 = "Plugin migration for ";
        String r101 = "Plugin trigger migration for ";
        String r102 = "Plugin delete file.";
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + r210 + ", " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L130
        String r110 = r211.f486846a;     // Catch: Throwable -> L130
        int r111 = r211.f486847b;     // Catch: Throwable -> L130
        String r112 = "Pkg:" + r110 + ",Ver:" + r111;     // Catch: Throwable -> L130
        Object r113 = this.installLock;     // Catch: Throwable -> L130
        monitor-enter(r113);     // Catch: Throwable -> L130
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=" + this);     // Catch: Throwable -> L120
        int r114 = this.mVersionCode;     // Catch: Throwable -> L120
        int r213 = r114;
        if (this.mLifeCycle < 2) goto L10;
        boolean r115 = true;
    L171:
        boolean r116 = checkValid(r210, r110, r111);     // Catch: Throwable -> L114
        if (r116 == true) goto L153;
        r102 = "Plugin delete file.";
        boolean r117 = r115;
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L112
        r103.append(r112);     // Catch: Throwable -> L112
        r100 = " checkValid failed";
        r103.append(" checkValid failed");     // Catch: Throwable -> L112
        String r118 = r103.toString();     // Catch: Throwable -> L112
        boolean r104 = false;
        ?? r105 = r101;
    L155:
        monitor-enter(this);     // Catch: Throwable -> L109
        if (r116 == true) goto L63;
        mqc.i.e(r210);     // Catch: Throwable -> L101
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid. " + r118);     // Catch: Throwable -> L101
    L80:
        r111 = 0;
    L169:
        monitor-exit(this);     // Catch: Throwable -> L98
        if (r104 == false) goto L96;
        if (r111 != 0) goto L96;
        if (TextUtils.isEmpty(r118) == false) goto L90;
        String r106 = "install_deferred";
    L92:
        restoreInstallStateSnapshot(r117, r213 == true ? 1 : 0, r106);     // Catch: Throwable -> L105
        goto L96
    L90:
        r106 = EventConstants.Label.INSTALL_FAILED;
    L93:
        th = th;
        r100 = r213 == true ? 1 : 0;
        r105 = r117;
    L111:
        boolean r119 = r104;
        int r107 = r111;
        ?? r120 = r100;
        ?? r108 = r105;
    L165:
        monitor-exit(r113);     // Catch: Throwable -> L128
        throw th;     // Catch: Throwable -> L126
    L126:
        th = th;
        boolean r214 = r119;
        int r121 = r107;
        ?? r109 = r120;
        boolean r122 = r214;
        ?? r123 = r108;
    L132:
        r118 = th.getMessage();
        if (r122 == false) goto L136;
        if (r121 != 0) goto L136;
        restoreInstallStateSnapshot(r123, r109, "install_exception");
    L136:
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th);
    L137:
        return r118;
    L128:
        th = th;
    L96:
        monitor-exit(r113);     // Catch: Throwable -> L105
    L98:
        th = th;
    L151:
        monitor-exit(this);     // Catch: Throwable -> L107
        throw th;     // Catch: Throwable -> L105
    L107:
        th = th;
        goto L151
    L63:
        if (TextUtils.isEmpty(r118) == true) goto L65;
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + r110 + ":" + r111);     // Catch: Throwable -> L101
        mqc.i.e(r210);     // Catch: Throwable -> L101
        StringBuilder r124 = new StringBuilder(r102);     // Catch: Throwable -> L101
        r124.append(r118);     // Catch: Throwable -> L101
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, r124.toString());     // Catch: Throwable -> L101
        goto L80
    L65:
        if (isLoaded() == false) goto L67;
    L77:
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, " + r112 + " valid next restart. lifeCycle:" + this.mLifeCycle + " isAllowInstall:" + isAllowInstall(r111));     // Catch: Throwable -> L101
        goto L80
    L67:
        if (isAllowInstall(r111) == false) goto L77;
        updateToInstalled(r111);     // Catch: Throwable -> L101
        if (GlobalParam.getInstance().enableCreateInstallStateSnapshot() == false) goto L72;
        com.volcengine.zeus.plugin.d.f(this.mPkgName, r111, this.mApiVersionCode);     // Catch: Throwable -> L101
        int r125 = 1;
    L161:
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + r110 + ":" + r111);     // Catch: Throwable -> L75
        r111 = r125;
    L75:
        th = th;
        goto L151
    L72:
        r125 = 0;
    L101:
        th = th;
    L105:
        th = th;
    L109:
        th = th;
        r100 = r213 == true ? 1 : 0;
        r105 = r117;
        r111 = 0;
    L112:
        th = th;
    L56:
        boolean r126 = r117;
    L116:
        boolean r127 = r126;
    L117:
        r107 = 0;
        boolean r128 = r127;
        int r129 = r213;
    L123:
        r119 = false;
        r108 = r128;
        r120 = r129;
        goto L165
    L153:
        if (GlobalParam.getInstance().enableCreateInstallStateSnapshot() == true) goto L149;
        r117 = r115;
        r104 = false;
    L147:
        Throwable r130 = PluginInstaller.c(r210, r110, r111, r212);     // Catch: Throwable -> L52
        if (r130 != null) goto L28;
        r118 = null;
    L29:
        if (r130 != null) goto L51;
        t.c().j(this.mPkgName, r111, true);     // Catch: Throwable -> L52
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + r111);     // Catch: Throwable -> L52
        if (isLoadedInAnyProcess() == true) goto L33;
    L45:
        mqc.i.e(r210);     // Catch: Throwable -> L52
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin trigger migration for " + this.mPkgName);     // Catch: Throwable -> L52
        PluginMigrationHandler r131 = this.mMigrationHandler;     // Catch: Exception -> L48 Throwable -> L52
        String r132 = this.mPkgName;     // Catch: Exception -> L48 Throwable -> L52
        r131.onInstallFinished(r132);     // Catch: Exception -> L48 Throwable -> L52
        r105 = r132;
    L48:
        e = move-exception;
        String r133 = ZeusLogger.TAG_INSTALL;
        r100 = "Plugin migration for " + this.mPkgName + " exception";     // Catch: Throwable -> L52
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, r100, e);     // Catch: Throwable -> L52
        r105 = r133;
        goto L155
    L33:
        if (TextUtils.isEmpty(getPluginProcess()) == true) goto L45;
        Set<String> r134 = i.f462809a;     // Catch: Throwable -> L52
        String r135 = this.mPkgName;     // Catch: Throwable -> L52
        if (r135 != null) goto L37;
    L40:
        boolean r136 = true;
    L41:
        if (r136 == true) goto L44;
        p.b(new g(r135));     // Catch: Throwable -> L52
    L44:
        i.b();     // Catch: Throwable -> L52
        goto L45
    L37:
        if (r135.length() == 0) goto L40;
        r136 = false;
        goto L41
    L51:
        r105 = r101;
        goto L155
    L28:
        r118 = r112 + " install internal error:" + r130.getMessage();     // Catch: Throwable -> L52
    L52:
        th = th;
        r119 = r104;
        r107 = 0;
        r108 = r117;
        r120 = r213 == true ? 1 : 0;
        goto L165
    L149:
        r117 = r115;
        com.volcengine.zeus.plugin.d.g(this.mPkgName, this.mApiVersionCode, "install_pending", "install_start_" + r111);     // Catch: Throwable -> L19
        r104 = true;
    L19:
        th = th;
    L23:
        r127 = r117;
    L21:
        th = th;
        r117 = r115;
    L54:
        th = th;
        r117 = r115;
    L114:
        th = th;
        r126 = r115;
        goto L116
    L10:
        r115 = false;
    L118:
        th = th;
        int r137 = r114;
    L122:
        r129 = r137;
        r107 = 0;
        r128 = false;
    L120:
        th = th;
        r137 = 0;
    L130:
        th = th;
        r109 = 0;
        r123 = 0;
        r122 = false;
        r121 = 0;
        goto L132
    }

    public void setApiCompatVersion(int r100, int r101, int r102) {
        t r103 = t.c();
        String r104 = this.mPkgName;
        SharedPreferences.Editor r105 = r103.f514970a.edit();
        r105.putInt("API_MIN_" + r104 + "_" + r100, r101);
        r105.putInt("API_MAX_" + r104 + "_" + r100, r102);
        r105.apply();
    }

    private void reportInstallStateRoute(String r110, String r111, int r112, long r113, long r114, int r210, int r211, int r212, String r213, String r214, long r215, int r216) {
        String r100 = this.mPkgName;
        boolean r115 = r.f514968a;
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r110, CloudControlInf.ROUTE);
        Intrinsics.checkNotNullParameter(r111, "snapshotResult");
        JSONObject r116 = new JSONObject();     // Catch: Exception -> L22
        r116.put("plugin_id", r100);     // Catch: Exception -> L22
        if (r112 <= 0) goto L6;
        r116.put("plugin_version_code", r112);     // Catch: Exception -> L22
    L6:
        r116.put(CloudControlInf.ROUTE, r110);     // Catch: Exception -> L22
        r116.put("snapshot_result", r111);     // Catch: Exception -> L22
        r116.put("snapshot_cost", r113);     // Catch: Exception -> L22
        r116.put("ipc_cost", r114);     // Catch: Exception -> L22
        r116.put("skip_get_package_manager", r210);     // Catch: Exception -> L22
        r116.put("skip_is_plugin_installed", r211);     // Catch: Exception -> L22
        r116.put("skip_get_installed_version", r212);     // Catch: Exception -> L22
        r116.put("saved_ipc_call_count", r211 + r212);     // Catch: Exception -> L22
        r116.put("main_process_alive", r216);     // Catch: Exception -> L22
        if (Intrinsics.areEqual(r110, "snapshot") == false) goto L10;
        if (r216 != 0) goto L10;
        int r101 = 1;
    L11:
        r116.put("main_process_start_avoided_likely", r101);     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r213) == true) goto L15;
        r116.put("reason", r213);     // Catch: Exception -> L22
    L15:
        if (TextUtils.isEmpty(r214) == true) goto L18;
        r116.put("ipc_result", r214);     // Catch: Exception -> L22
    L18:
        if (r215 <= 0) goto L20;
        r116.put("snapshot_update_time", r215);     // Catch: Exception -> L22
    L20:
        fqc.b.c("obric_zeus_install_state_route", r116);     // Catch: Exception -> L22
        return;
    L10:
        r101 = 0;
    L22:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_REPORTER, "report install state route failed", e);
    }
}
