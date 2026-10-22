package com.bytedance.mira.plugin;

import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.MiraPluginLifeListener;
import com.bytedance.mira.core.KVManager;
import com.bytedance.mira.core.MetaManager;
import com.bytedance.mira.event.PluginEventManager;
import com.bytedance.mira.helper.NativeLibHelper;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.helper.ProcessHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.modifyres.AndroidUtils;
import com.bytedance.mira.modifyres.ApkModifyUtils;
import com.bytedance.mira.pm.packageinfo.PackageInfoUtils;
import com.bytedance.mira.util.EncryptUtils;
import com.bytedance.mira.util.FileUtils;
import com.bytedance.mira.util.IOUtils;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Plugin implements Parcelable {
    public static final Parcelable.Creator<Plugin> CREATOR = null;
    public static final int LIFE_ACTIVE = 8;
    public static final int LIFE_INSTALLED = 4;
    public static final int LIFE_INSTALLING = 2;
    public static final int LIFE_INSTALL_FAILED = 3;
    public static final int LIFE_PENDING = 1;
    public static final int LIFE_RESOLVED = 7;
    public static final int LIFE_RESOLVE_FAILED = 6;
    public static final int LIFE_RESOLVING = 5;
    private static final String TAG = "Plugin";
    public static final int TYPE_INTERNAL = 1;
    AtomicInteger failedCount;
    final Object initializeLock;
    AtomicBoolean installInternalStatus;
    final Object installLock;
    AtomicInteger installingCount;
    public String mClassToVerify;
    public boolean mDisabledInDebug;
    public boolean mEnableDeleteNativeEntry;
    public boolean mEnableSoLink;
    public JSONObject mExtraData;
    public List<String> mExtraPackages;
    private Handler mHandler;
    private volatile boolean mInitialized;
    public boolean mInternalAsSo;
    public String mInternalPluginMD5;
    public int mInternalPluginVersion;
    public volatile int mLifeCycle;
    public boolean mLoadAsHostClass;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public boolean mMultiDex;
    private String mPackageDir;
    public String mPackageName;
    public int mPluginType;
    public int mReinstallIfRomUpdate;
    public String mReleaseBuild;
    public String mRouterModuleName;
    public String mRouterRegExp;
    public boolean mShareRes;
    public String mSoLinkConfig;
    public int mVersionCode;
    final Object waitLock;

    /* JADX INFO: loaded from: classes21.dex */
    public interface IInternalPluginReleaseListener {
        void onFail(Exception r100);

        void onProgress(long r100, long r101);

        void onStart();

        void onSuccess(File r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isHostModule() {
        return false;
    }

    static {
        CREATOR = new AnonymousClass7();
    }

    private File getDownloadPluginApkFile() {
        return new PolarisFileWrapper(PluginDirHelper.getInternalReleaseDir(), this.mPackageName + ".apk");
    }

    private void onPluginInitStart() {
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin onPluginInitStart pkg=" + this.mPackageName);
        List<MiraPluginLifeListener> r100 = MiraManager.getInstance().getPluginLifeListeners();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() <= 0) goto L12;
        Iterator<MiraPluginLifeListener> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        r101.next().onPluginInitStart(this);
        goto L8
    L13:
        return;
    }

    public int getInstalledMaxVersion() {
        if (TextUtils.isEmpty(this.mPackageDir) == false) goto L5;
        this.mPackageDir = PluginDirHelper.getPackageDir(this.mPackageName);
    L5:
        File[] r100 = new PolarisFileWrapper(this.mPackageDir).listFiles(new AnonymousClass3(this));
        int r101 = -1;
        if (r100 != null) goto L8;
    L19:
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPackageName + ", maxVer=" + r101);
        return r101;
    L8:
        if (r100.length <= 0) goto L19;
        int r102 = r100.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L19;
        int r104 = CastIntegerProtector.parseInt(r100[r103].getName().split("-")[1]);
        if (r104 <= r101) goto L18;
        if (MetaManager.getInst().isPluginInstalled(this.mPackageName, r104) == false) goto L18;
        if (new PolarisFileWrapper(PluginDirHelper.getSourceFile(this.mPackageName, r104)).exists() == false) goto L18;
        r101 = r104;
    L18:
        r103 = r103 + 1;
        goto L10
    }

    public String getInstalledMaxVersionFile() {
        if (this.mInitialized == true) goto L5;
        init();
    L5:
        int r100 = getInstalledMaxVersion();
        if (r100 > 0) goto L8;
        return "";
    L8:
        return PluginDirHelper.getSourceFile(this.mPackageName, r100);
    }

    public String getInstalledMaxVersionMd5() {
        if (this.mInitialized == true) goto L6;
        init();
    L6:
        if (getInstalledMaxVersion() > 0) goto L8;
        return "";
    L8:
        return MetaManager.getInst().getInstalledPluginMd5(this.mPackageName);
    }

    public String getNativeLibraryDir() {
        int r100 = this.mVersionCode;
        if (r100 <= 0) goto L7;
        return PluginDirHelper.getNativeLibraryDir(this.mPackageName, r100);
    L7:
        return PluginDirHelper.getPackageDir(this.mPackageName);
    }

    public String getPackageVersionDir() {
        int r100 = this.mVersionCode;
        if (r100 <= 0) goto L7;
        return PluginDirHelper.getPackageVersionDir(this.mPackageName, r100);
    L7:
        return PluginDirHelper.getPackageDir(this.mPackageName);
    }

    public String getSourceFile() {
        if (this.mInitialized == true) goto L6;
        init();
    L6:
        return PluginDirHelper.getSourceFile(this.mPackageName, this.mVersionCode);
    }

    public int hashCode() {
        String r100 = this.mPackageName;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((((r101 * 31) + this.mVersionCode) * 31) + (this.mLoadAsHostClass ? 1 : 0)) * 31) + (this.mDisabledInDebug ? 1 : 0)) * 31) + (this.mEnableSoLink ? 1 : 0);
    L5:
        r101 = 0;
        goto L7
    }

    public void init() {
        if (this.mInitialized == false) goto L5;
        return;
    L5:
        Object r100 = this.initializeLock;
        monitor-enter(r100);
    L58:
        th = move-exception;
        throw th;
    L8:
        if (this.mInitialized == false) goto L11;
        monitor-exit(r100);     // Catch: Throwable -> L58
        return;
    L11:
        onPluginInitStart();     // Catch: Throwable -> L58
        int r101 = PluginManager.getInstance().getHostUpdateVerCode();     // Catch: Throwable -> L58
        if (KVManager.getInst().hasRomUpdateFlag(this.mPackageName) == false) goto L14;
        boolean r102 = KVManager.getInst().isRomUpdate(this.mPackageName);     // Catch: Throwable -> L58
    L16:
        if (KVManager.getInst().hasHostUpdateFlag(this.mPackageName) == false) goto L18;
        KVManager.getInst().isHostUpdate(this.mPackageName, r101);     // Catch: Throwable -> L58
    L20:
        if (KVManager.getInst().hasHostAbiUpdate(this.mPackageName) == false) goto L22;
        boolean r103 = KVManager.getInst().isHostAbiUpdate(this.mPackageName);     // Catch: Throwable -> L58
    L24:
        if (KVManager.getInst().hasHostUpdateFlag(this.mPackageName) == false) goto L26;
        boolean r104 = KVManager.getInst().isHostDowngrade(this.mPackageName, r101);     // Catch: Throwable -> L58
    L27:
        deleteIfHostDowngradeWithInternalPlugin(r104);     // Catch: Throwable -> L58
        deleteIfRomUpdate(r102);     // Catch: Throwable -> L58
        deleteIfNeeded();     // Catch: Throwable -> L58
        int[] r105 = getCanUsedVersions(r101, r103);     // Catch: Throwable -> L58
        boolean r106 = false;
        int r107 = r105[0];     // Catch: Throwable -> L58
        int r108 = r105[1];     // Catch: Throwable -> L58
        if (r107 < 0) goto L30;
        boolean r109 = true;
    L31:
        if (r109 == false) goto L34;
        updateVersionLifeCycle(r107, 4);     // Catch: Throwable -> L58
    L40:
        if (r107 < 0) goto L42;
        boolean r110 = true;
    L43:
        if (r108 < 0) goto L46;
        r106 = true;
    L46:
        if (MiraManager.getInstance().getParam().keepExpiredPluginUntilInstallNew() == false) goto L51;
        if (r110 == false) goto L49;
        clearBackup();     // Catch: Throwable -> L58
    L52:
        deleteOtherExpiredVer(r107);     // Catch: Throwable -> L58
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin loadPlugins result=" + this);     // Catch: Throwable -> L58
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == false) goto L55;
        KVManager.getInst().setRomUpdate(this.mPackageName);     // Catch: Throwable -> L58
        KVManager.getInst().setHostUpdated(this.mPackageName, r101);     // Catch: Throwable -> L58
        KVManager.getInst().setHostAbiUpdated(this.mPackageName);     // Catch: Throwable -> L58
        KVManager.getInst().setHostIdentity(this.mPackageName, AndroidUtils.getHostIdentity(Mira.getAppContext()));     // Catch: Throwable -> L58
    L55:
        this.mInitialized = true;     // Catch: Throwable -> L58
        monitor-exit(r100);     // Catch: Throwable -> L58
        return;
    L49:
        if (r106 == false) goto L52;
        clearBackup();     // Catch: Throwable -> L58
        moveToBackup(r108);     // Catch: Throwable -> L58
        goto L52
    L51:
        clearBackup();     // Catch: Throwable -> L58
        goto L52
    L42:
        r110 = false;
        goto L43
    L34:
        if (enableInstallInternalPlugin() == false) goto L40;
        if (enableSkipInstallInternalPluginWhenPluginInit() == true) goto L40;
        if (installInternalPlugin(null) == false) goto L40;
        r107 = this.mVersionCode;     // Catch: Throwable -> L58
        r108 = r107;
        goto L40
    L30:
        r109 = false;
        goto L31
    L26:
        r104 = MetaManager.getInst().isHostDowngrade(r101);     // Catch: Throwable -> L58
        goto L27
    L22:
        r103 = MetaManager.getInst().isHostAbiUpdate();     // Catch: Throwable -> L58
        goto L24
    L18:
        MetaManager.getInst().isHostUpdate(r101);     // Catch: Throwable -> L58
        goto L20
    L14:
        r102 = MetaManager.getInst().isRomUpdate();     // Catch: Throwable -> L58
        goto L16
    }

    public boolean isActive() {
        if (this.mLifeCycle != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInstalled() {
        if (this.mLifeCycle < 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInstalling() {
        if (this.mLifeCycle >= 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInternalPlugin() {
        if (this.mPluginType != 1) goto L5;
        return true;
    L5:
        if (this.mInternalAsSo == false) goto L7;
        return true;
    L7:
        if (TextUtils.isEmpty(this.mInternalPluginMD5) == false) goto L9;
    L11:
        return false;
    L9:
        if (this.mInternalPluginVersion <= 0) goto L11;
        return true;
    }

    public boolean isResolved() {
        if (this.mLifeCycle < 7) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isResolvedExactly() {
        if (this.mLifeCycle != 7) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUninstalled() {
        if (this.mLifeCycle >= 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUnresolved() {
        if (this.mLifeCycle != 4) goto L5;
    L8:
        return true;
    L5:
        if (this.mLifeCycle == 6) goto L8;
        return false;
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(this.mPackageName) == false) goto L7;
        MiraLogger.e(MiraLogger.TAG, "Plugin isValid missing mPackageName.");
        return false;
    L7:
        if (this.mPluginType != 1) goto L17;
        if (this.mInternalPluginVersion > 0) goto L13;
        MiraLogger.e(MiraLogger.TAG, "Plugin isValid[" + this.mPackageName + "] missing internalPluginVersion.");
        return false;
    L13:
        if (TextUtils.isEmpty(this.mInternalPluginMD5) == false) goto L17;
        MiraLogger.e(MiraLogger.TAG, "Plugin isValid[" + this.mPackageName + "] missing internalPluginMD5.");
        return false;
    L17:
        if (this.mInternalPluginVersion <= 0) goto L23;
        if (TextUtils.isEmpty(this.mInternalPluginMD5) == false) goto L23;
        MiraLogger.e(MiraLogger.TAG, "Plugin isValid[" + this.mPackageName + "], mInternalPluginVersion = " + this.mInternalPluginVersion + " && mInternalPluginMD5 == " + this.mInternalPluginMD5 + ".");
        return false;
    L23:
        if (this.mInternalPluginVersion <= 0) goto L25;
    L28:
        return true;
    L25:
        if (TextUtils.isEmpty(this.mInternalPluginMD5) == true) goto L28;
        MiraLogger.e(MiraLogger.TAG, "Plugin isValid[" + this.mPackageName + "], mInternalPluginVersion = " + this.mInternalPluginVersion + " && mInternalPluginMD5 == " + this.mInternalPluginMD5 + ".");
        return false;
    }

    public Plugin() {
        this.mVersionCode = -1;
        this.mShareRes = true;
        this.mExtraPackages = new ArrayList();
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mLifeCycle = 1;
        this.installingCount = new AtomicInteger(0);
        this.failedCount = new AtomicInteger(0);
        this.waitLock = new Object();
        this.installLock = new Object();
        this.initializeLock = new Object();
        this.installInternalStatus = new AtomicBoolean(false);
    }

    private void clearBackup() {
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == true) goto L5;
        return;
    L5:
        MetaManager.getInst().setBackupPluginMd5(this.mPackageName, "");
        FileUtils.deleteDir(PluginDirHelper.getBackupDir(this.mPackageName));
    }

    private void deleteIfNeeded() {
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == true) goto L5;
        return;
    L5:
        if (MetaManager.getInst().hasDeletedFlag(this.mPackageName) == false) goto L9;
        MetaManager.getInst().clearDeletedFlag(this.mPackageName);
        deleteInstalledPlugin(MetaManager.getInst().getDeleteReason(this.mPackageName));
        MiraLogger.w(MiraLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPackageName);
        return;
    }

    private boolean enableSkipInstallInternalPluginWhenPluginInit() {
        return MiraManager.getInstance().getParam().isIgnore(this.mPackageName);
    }

    private String getReleaseBuild() {
        MiraParam r100 = MiraManager.getInstance().getParam();     // Catch: Throwable -> L10
        if (r100 == null) goto L9;
        if (r100.enableReleaseBuildOpt() == false) goto L9;
        return this.mPackageName + "_" + getInstalledMd5Extend();
    L9:
        return PackageInfoUtils.getPackageInfo(new PolarisFileWrapper(PluginDirHelper.getSourceFile(this.mPackageName, this.mVersionCode)), 128).applicationInfo.metaData.getString("sld_release_build", "empty");
    L10:
        th = move-exception;
        return String.valueOf(th);
    }

    private File releaseCopyFile() {
        String r100 = "plugins/" + this.mPackageName + ".jar";     // Catch: Exception -> L6
        File r101 = getDownloadPluginApkFile();     // Catch: Exception -> L6
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin releaseCopyFile " + r100 + " --> " + r101.getAbsolutePath());     // Catch: Exception -> L6
        IOUtils.copyStream(Mira.getAppContext().getAssets().open(r100), new PolarisFileOutputStreamWrapper(r101));     // Catch: Exception -> L6
        if (r101.exists() == false) goto L8;
        return r101;
    L8:
        MiraLogger.w(MiraLogger.TAG_INIT, "Plugin releaseCopyFile not exist. " + this.mPackageName);
        return null;
    L6:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "Plugin releaseCopyFile failed. " + this.mPackageName, e);
        goto L8
    }

    public void clearOffline() {
        MetaManager.getInst().clearOfflineFlag(this.mPackageName);
    }

    public boolean enableInstallInternalPlugin() {
        if (isInternalPlugin() == true) goto L5;
    L9:
        return false;
    L5:
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == false) goto L9;
        if (MetaManager.getInst().hasInternalOfflineFlag(this.mPackageName) == true) goto L9;
        return true;
    }

    public int getHostCompatMaxVer() {
        return MetaManager.getInst().getHostCompatibleMaxVersion(this.mPackageName, this.mVersionCode);
    }

    public int getHostCompatMinVer() {
        return MetaManager.getInst().getHostCompatibleMinVersion(this.mPackageName, this.mVersionCode);
    }

    public String getInstalledMd5() {
        return MetaManager.getInst().getInstalledPluginMd5(this.mPackageName);
    }

    public String getInstalledMd5Extend() {
        return MetaManager.getInst().getInstalledPluginMd5Extend(this.mPackageName, this.mVersionCode);
    }

    public boolean isOffline() {
        return MetaManager.getInst().hasOfflineFlag(this.mPackageName);
    }

    public void markOffline() {
        MetaManager.getInst().markOfflineFlag(this.mPackageName);
    }

    public void markOfflineWithVersion() {
        MetaManager.getInst().markOfflineFlag(this.mPackageName, this.mVersionCode);
    }

    public void removeInternalCopyFile() {
        FileUtils.deleteFile(getDownloadPluginApkFile());     // Catch: Exception -> L5
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin removeInternalCopyFile successful");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "Plugin removeInternalCopyFile failed. " + this.mPackageName, e);
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPackageName + ", ver=" + this.mVersionCode + ", type=" + this.mPluginType + ", life=" + this.mLifeCycle + ", address=" + super.toString() + '}';
    }

    public final Object getInstallLock() {
        return this.installLock;
    }

    public Plugin(JSONObject r100) throws JSONException {
        this.mVersionCode = -1;
        this.mShareRes = true;
        this.mExtraPackages = new ArrayList();
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mLifeCycle = 1;
        this.installingCount = new AtomicInteger(0);
        this.failedCount = new AtomicInteger(0);
        this.waitLock = new Object();
        this.installLock = new Object();
        this.initializeLock = new Object();
        this.installInternalStatus = new AtomicBoolean(false);
        this.mPackageName = r100.optString("packageName");
        this.mPluginType = r100.optInt("pluginType");
        this.mShareRes = r100.optBoolean("shareRes", true);
        this.mClassToVerify = r100.optString("classToVerify");
        this.mInternalPluginMD5 = r100.optString("internalPluginMD5");
        this.mInternalPluginVersion = r100.optInt("internalPluginVersion", 0);
        this.mRouterModuleName = r100.optString("routerModuleName");
        this.mRouterRegExp = r100.optString("routerRegExp");
        this.mMinVersionCode = r100.optInt("minVersionCode", 0);
        this.mMaxVersionCode = r100.optInt("maxVersionCode", Integer.MAX_VALUE);
        this.mLoadAsHostClass = r100.optBoolean("loadAsHostClass", false);
        this.mDisabledInDebug = r100.optBoolean("disabledInDebug", false);
        this.mInternalAsSo = r100.optBoolean("internalAsSo", false);
        this.mReinstallIfRomUpdate = r100.optInt("reinstallIfRomUpdate", 0);
        this.mEnableDeleteNativeEntry = r100.optBoolean("enableDeleteNativeEntry", false);
        JSONArray r101 = r100.optJSONArray("extraPackages");
        if (r101 == null) goto L8;
        int r102 = 0;
    L6:
        if (r102 >= r101.length()) goto L8;
        this.mExtraPackages.add(JSONArrayProtectorUtils.getString(r101, r102));
        r102 = r102 + 1;
    L8:
        JSONObject r103 = r100.optJSONObject(ControlRule.KEY_EXTRA_DATA);
        if (r103 == null) goto L11;
        this.mExtraData = r103;
    L11:
        this.mEnableSoLink = r100.optBoolean("enableSoLink", false);
        this.mSoLinkConfig = r100.optString("soLinkConfig");
    }

    private void deleteIfHostDowngradeWithInternalPlugin(boolean r100) {
        MiraParam r101 = MiraManager.getInstance().getParam();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.enableOptRecovery() == true) goto L8;
        return;
    L8:
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == true) goto L10;
        return;
    L10:
        if (isInternalPlugin() == false) goto L16;
        if (r100 == false) goto L17;
        deleteInstalledPlugin(PluginEventManager.OtherStatusCode.HOST_DOWNGRADE);
        MiraLogger.w(MiraLogger.TAG_INIT, "Plugin deleteIfHostDowngradeWithInternalPlugin, pkg=" + this.mPackageName);
        return;
    L17:
        return;
    }

    private void deleteIfRomUpdate(boolean r100) {
        if (this.mReinstallIfRomUpdate == 0) goto L29;
        if (r100 == true) goto L6;
        return;
    L6:
        if (OSUtil.isAndroidL_M() == true) goto L8;
        return;
    L8:
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == false) goto L32;
        int r101 = getInstalledMaxVersion();
        if (this.mReinstallIfRomUpdate != 1) goto L21;
        if (r101 < 0) goto L21;
        if (r101 < this.mMinVersionCode) goto L21;
        if (r101 > this.mMaxVersionCode) goto L21;
        String r102 = PluginDirHelper.getSourceFile(this.mPackageName, r101);
        String r103 = PluginDirHelper.getDownloadDir() + HTTP.URL_DEFAULT + this.mPackageName + System.currentTimeMillis() + ".apk";     // Catch: Exception -> L19
        IOUtils.copyFile(r102, r103);     // Catch: Exception -> L19
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin deleteIfRomUpdate, copy source to installDir, source=" + r102 + ", dest=" + r103);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "Plugin deleteIfRomUpdate, copy source to installDir failed.", e);
    L21:
        int r104 = this.mReinstallIfRomUpdate;
        if (r104 != 1) goto L24;
    L25:
        deleteInstalledPlugin(PluginEventManager.OtherStatusCode.UPDATE_ROM);
        MiraLogger.w(MiraLogger.TAG_INIT, "Plugin deleteIfRomUpdate, pkg=" + this.mPackageName);
        return;
    L24:
        if (r104 == 2) goto L25;
        return;
    L32:
        return;
    }

    private void deleteInstalledPlugin(final int r100) {
        if (TextUtils.isEmpty(this.mPackageDir) == false) goto L5;
        this.mPackageDir = PluginDirHelper.getPackageDir(this.mPackageName);
    L5:
        new PolarisFileWrapper(this.mPackageDir).listFiles(new AnonymousClass4(this, r100));
        FileUtils.deleteDir(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int r100) {
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mPackageDir) == false) goto L7;
        this.mPackageDir = PluginDirHelper.getPackageDir(this.mPackageName);
    L7:
        final String r101 = PluginDirHelper.VERSION_PREFIX + r100;
        new PolarisFileWrapper(this.mPackageDir).listFiles(new AnonymousClass5(this, r101));
    }

    private int modifyResIfNeed(int r100) {
        String r101 = AndroidUtils.getHostIdentity(Mira.getAppContext());
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L8:
        MiraLogger.d(MiraLogger.TAG_INIT, "modifyRes by init. " + this.mPackageName + " " + r100);
        StringBuilder r102 = new StringBuilder();
        int r103 = new ApkModifyUtils().modifyRes(new PolarisFileWrapper(PluginDirHelper.getSourceFile(this.mPackageName, r100)), true, r102);
        if (r103 != 100) goto L11;
        return r100;
    L11:
        if (r103 == 200) goto L16;
        MiraLogger.w(MiraLogger.TAG_INIT, " modifyRes by init failed. " + r102);
        return 0;
    L16:
        return r100;
    L5:
        if (TextUtils.equals(KVManager.getInst().getHostIdentity(this.mPackageName), r101) == false) goto L8;
        return r100;
    }

    private void moveToBackup(int r100) {
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == true) goto L6;
        return;
    L6:
        if (MetaManager.getInst().isPluginInstalled(this.mPackageName, r100) == true) goto L8;
        return;
    L8:
        String r101 = PluginDirHelper.getSourceFile(this.mPackageName, r100);
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L11;
        return;
    L11:
        String r103 = MetaManager.getInst().getInstalledPluginMd5Extend(this.mPackageName, r100);
        if (TextUtils.isEmpty(r103) == false) goto L14;
        r103 = MetaManager.getInst().getInstalledPluginMd5(this.mPackageName);
    L14:
        MetaManager.getInst().setBackupPluginMd5(this.mPackageName, r103);
        String r104 = PluginDirHelper.getBackupFile(this.mPackageName);
        if (safeRename(r102, new PolarisFileWrapper(r104)) == false) goto L17;
        FileUtils.deleteDir(PluginDirHelper.getPackageVersionDir(this.mPackageName, r100));
        MetaManager.getInst().markPluginInstalled(this.mPackageName, r100, false);
        MetaManager.getInst().setInstalledPluginMd5Extend(this.mPackageName, r100, "");
        return;
    L17:
        safeCopy(r101, r104);
    }

    private void onInternalPluginReleaseStart(IInternalPluginReleaseListener r100) {
        if (r100 == null) goto L5;
        r100.onStart();
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L29:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L29;
        Plugin r101 = (Plugin) r100;
        if (this.mVersionCode == r101.mVersionCode) goto L14;
        return false;
    L14:
        if (this.mLoadAsHostClass == r101.mLoadAsHostClass) goto L17;
        return false;
    L17:
        if (this.mDisabledInDebug == r101.mDisabledInDebug) goto L20;
        return false;
    L20:
        if (this.mEnableSoLink == r101.mEnableSoLink) goto L22;
        return false;
    L22:
        String r102 = this.mPackageName;
        String r103 = r101.mPackageName;
        if (r102 != null) goto L30;
        if (r103 == null) goto L31;
        return false;
    L31:
        return true;
    L30:
        return r102.equals(r103);
    }

    public boolean installInternalPlugin(IInternalPluginReleaseListener r100) {
        if (isInstalled() == false) goto L6;
        return true;
    L6:
        if (this.installInternalStatus.compareAndSet(false, true) == true) goto L21;
        return false;
    L21:
        onInternalPluginReleaseStart(r100);     // Catch: Throwable -> L18
        File r101 = releaseCopyFile();     // Catch: Throwable -> L18
        if (r101 == null) goto L15;
        onInternalPluginReleaseSuccess(r100, r101);     // Catch: Throwable -> L18
        boolean r102 = install(r101, null, true);     // Catch: Throwable -> L18
        if (r102 == false) goto L13;
        MetaManager.getInst().setupInternalPluginVersion(this.mPackageName, this.mVersionCode);     // Catch: Throwable -> L18
    L13:
        this.installInternalStatus.set(false);
        return r102;
    L15:
        onInternalPluginReleaseFailed(r100, new IOException("release apk failed, pkg=" + this.mPackageName));     // Catch: Throwable -> L18
        this.installInternalStatus.set(false);
        return false;
    L18:
        th = move-exception;
        this.installInternalStatus.set(false);
        throw th;
    }

    public boolean isVersionInstalled(int r100) {
        return MetaManager.getInst().isPluginInstalled(this.mPackageName, r100);
    }

    public <T> T optExtraData(String r100) {
        JSONObject r101 = this.mExtraData;
        if (r101 != null) goto L5;
        return null;
    L5:
        T r102 = (T) r101.opt(r100);
        if (r102 != null) goto L9;
        return null;
    L9:
        return r102;
    }

    public void reuseExistVersion(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        if (r100 >= this.mMinVersionCode) goto L6;
        return;
    L6:
        if (r100 > this.mMaxVersionCode) goto L18;
        int r101 = PluginManager.getInstance().getHostUpdateVerCode();
        if (r101 == (-1)) goto L19;
        int r102 = MetaManager.getInst().getHostCompatibleMinVersion(this.mPackageName, r100);
        int r103 = MetaManager.getInst().getHostCompatibleMaxVersion(this.mPackageName, r100);
        if (r101 < r102) goto L20;
        if (r101 <= r103) goto L13;
        return;
    L13:
        if (this.mLifeCycle > 4) goto L22;
        updateVersionLifeCycle(r100, 4);
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPackageName + ", maxVer=" + r100);
        postPluginInstalled(this.mPackageName, true);
        return;
    L22:
        return;
    L20:
        return;
    L19:
        return;
    }

    public void setHandler(Handler r100) {
        this.mHandler = r100;
    }

    public Plugin(Parcel r100) {
        this.mVersionCode = -1;
        boolean r101 = true;
        this.mShareRes = true;
        this.mExtraPackages = new ArrayList();
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mLifeCycle = 1;
        this.installingCount = new AtomicInteger(0);
        this.failedCount = new AtomicInteger(0);
        this.waitLock = new Object();
        this.installLock = new Object();
        this.initializeLock = new Object();
        this.installInternalStatus = new AtomicBoolean(false);
        this.mPackageName = r100.readString();
        this.mReleaseBuild = r100.readString();
        this.mVersionCode = r100.readInt();
        this.mPluginType = r100.readInt();
        this.mExtraPackages = r100.createStringArrayList();
        this.mMinVersionCode = r100.readInt();
        this.mMaxVersionCode = r100.readInt();
        this.mInternalPluginMD5 = r100.readString();
        this.mInternalPluginVersion = r100.readInt();
        this.mLifeCycle = r100.readInt();
        this.mRouterModuleName = r100.readString();
        this.mRouterRegExp = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.mInternalAsSo = r102;
        this.mReinstallIfRomUpdate = r100.readInt();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.mLoadAsHostClass = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.mDisabledInDebug = r104;
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.mEnableDeleteNativeEntry = r105;
        String r106 = r100.readString();     // Catch: Exception -> L25
        if (r106 != null) goto L22;
        JSONObject r107 = null;
    L23:
        this.mExtraData = r107;     // Catch: Exception -> L25
    L27:
        if (r100.readByte() != 0) goto L30;
        r101 = false;
    L30:
        this.mEnableSoLink = r101;
        this.mSoLinkConfig = r100.readString();
        return;
    L22:
        r107 = new JSONObject(r106);     // Catch: Exception -> L25
    L25:
        this.mExtraData = null;
        goto L27
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public Plugin(String r100, int r101) {
        this.mVersionCode = -1;
        this.mShareRes = true;
        this.mExtraPackages = new ArrayList();
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mLifeCycle = 1;
        this.installingCount = new AtomicInteger(0);
        this.failedCount = new AtomicInteger(0);
        this.waitLock = new Object();
        this.installLock = new Object();
        this.initializeLock = new Object();
        this.installInternalStatus = new AtomicBoolean(false);
        this.mPackageName = r100;
        this.mVersionCode = r101;
    }

    private boolean checkVersion(int r110, int r111) {
        boolean r100 = false;
        if (r110 >= 0) goto L5;
    L18:
        boolean r101 = false;
    L19:
        if (r101 == true) goto L21;
    L29:
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin checkVersion, hostUpdateCode=" + r111);
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin checkVersion, pkg=" + this.mPackageName + ", ver=" + r110 + ", valid=" + r101);
        return r101;
    L21:
        if (r111 == (-1)) goto L29;
        int r102 = MetaManager.getInst().getHostCompatibleMinVersion(this.mPackageName, r110);
        int r103 = MetaManager.getInst().getHostCompatibleMaxVersion(this.mPackageName, r110);
        if (r111 < r102) goto L27;
        if (r111 > r103) goto L27;
        r100 = r101;
    L28:
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin checkVersion, hostCompatMinVer=" + r102 + ", hostCompatMaxVer=" + r103);
        r101 = r100;
    L27:
        MiraLogger.w(MiraLogger.TAG_INIT, TAG + String.format(" checkVersion plugin[%s, ver=%s] is not compatible with host[update_ver_code=%s], hostCompatibleVer=[%s,%s]", new Object[]{this.mPackageName, Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r102), Integer.valueOf(r103)}));
        goto L28
    L5:
        if (r110 < this.mMinVersionCode) goto L18;
        if (r110 > this.mMaxVersionCode) goto L18;
        if (isInternalPlugin() == false) goto L17;
        int r104 = this.mInternalPluginVersion;
        if (r110 >= r104) goto L13;
        MiraLogger.w(MiraLogger.TAG_INIT, TAG + String.format(" checkVersion %s installed ver miss match, maxVer=%s , mInternalPluginVer=%s", new Object[]{this.mPackageName, Integer.valueOf(r110), Integer.valueOf(this.mInternalPluginVersion)}));
        goto L18
    L13:
        if (r110 != r104) goto L17;
        String r105 = MetaManager.getInst().getInstalledPluginMd5(this.mPackageName);
        if (this.mInternalPluginMD5.equalsIgnoreCase(r105) == true) goto L17;
        MiraLogger.w(MiraLogger.TAG_INIT, TAG + String.format(" checkVersion %s installed md5 miss match, md5=%s , mInternalPluginMD5=%s", new Object[]{this.mPackageName, r105, this.mInternalPluginMD5}));
    L17:
        r101 = true;
        goto L19
    }

    private int[] getCanUsedVersions(int r110, boolean r111) {
        if (TextUtils.isEmpty(this.mPackageDir) == false) goto L5;
        this.mPackageDir = PluginDirHelper.getPackageDir(this.mPackageName);
    L5:
        File[] r100 = new PolarisFileWrapper(this.mPackageDir).listFiles(new AnonymousClass1(this));
        if (r100 == null) goto L8;
        int r101 = r100.length;
        PluginFile[] r102 = new PluginFile[r101];
        int r103 = 0;
    L10:
        int r104 = -1;
        if (r103 >= r100.length) goto L15;
        File r105 = r100[r103];
        r104 = CastIntegerProtector.parseInt(r105.getName().split("-")[1]);     // Catch: Throwable -> L37
    L14:
        PluginFile r106 = new PluginFile();
        r106.originFile = r105;
        r106.version = r104;
        r102[r103] = r106;
        r103 = r103 + 1;
        goto L10
    L15:
        Arrays.sort(r102, new AnonymousClass2(this));
        int r107 = r101 - 1;
        int r108 = -1;
    L16:
        if (r107 < 0) goto L33;
        int r109 = r102[r107].version;
        if (MetaManager.getInst().isPluginInstalled(this.mPackageName, r109) == false) goto L31;
        if (new PolarisFileWrapper(PluginDirHelper.getSourceFile(this.mPackageName, r109)).exists() == false) goto L31;
        boolean r112 = checkAbi(r109, r110, r111);
        if (r112 == false) goto L27;
        if (r108 != (-1)) goto L27;
        r108 = r109;
    L27:
        boolean r113 = checkVersion(r109, r110);
        if (r112 == false) goto L31;
        if (r113 == false) goto L31;
        r104 = r109;
    L31:
        r107 = r107 - 1;
    L33:
        if (MiraManager.getInstance().getParam().isEnableModifyRes() == false) goto L35;
        r104 = modifyResIfNeed(r104);
    L35:
        int[] r114 = {r104, r108};
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin getCanUsedVersions, pkg=" + this.mPackageName + ", ver=" + Arrays.toString(r114));
        return r114;
    L8:
        return new int[]{-1, -1};
    }

    private void onInternalPluginReleaseFailed(IInternalPluginReleaseListener r100, Exception r101) {
        if (r100 == null) goto L5;
        r100.onFail(r101);
        return;
    }

    private void onInternalPluginReleaseSuccess(IInternalPluginReleaseListener r100, File r101) {
        if (r100 == null) goto L5;
        r100.onSuccess(r101);
        return;
    }

    private void onPluginInstallStart(File r100, PackageInfo r101) {
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin onPluginInitStart pkg=" + this.mPackageName);
        List<MiraPluginLifeListener> r102 = MiraManager.getInstance().getPluginLifeListeners();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.size() <= 0) goto L12;
        Iterator<MiraPluginLifeListener> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        r103.next().onPluginInstallStart(this, r100, r101);
        goto L8
    L13:
        return;
    }

    private void postPluginInstalled(final String r100, final boolean r101) {
        this.mHandler.post(new AnonymousClass6(this, r100, r101));
    }

    private boolean safeCopy(String r100, String r101) {
        IOUtils.copyFile(r100, r101);     // Catch: Throwable -> L6
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin safeCopy pkg=" + this.mPackageName + " success~");     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin safeCopy pkg=" + this.mPackageName + " error=" + th.toString());
        return false;
    }

    private boolean safeRename(File r100, File r101) {
        boolean r102 = r100.renameTo(r101);     // Catch: Throwable -> L5
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin safeRename pkg=" + this.mPackageName + " success~");     // Catch: Throwable -> L5
        return r102;
    L5:
        th = move-exception;
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin safeRename pkg=" + this.mPackageName + " error=" + th.toString());
        return false;
    }

    private void updateVersionLifeCycle(int r100, int r101) {
        this.mVersionCode = r100;
        this.mLifeCycle = r101;
        this.mReleaseBuild = getReleaseBuild();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.mPackageName);
        r100.writeString(this.mReleaseBuild);
        r100.writeInt(this.mVersionCode);
        r100.writeInt(this.mPluginType);
        r100.writeStringList(this.mExtraPackages);
        r100.writeInt(this.mMinVersionCode);
        r100.writeInt(this.mMaxVersionCode);
        r100.writeString(this.mInternalPluginMD5);
        r100.writeInt(this.mInternalPluginVersion);
        r100.writeInt(this.mLifeCycle);
        r100.writeString(this.mRouterModuleName);
        r100.writeString(this.mRouterRegExp);
        r100.writeByte(this.mInternalAsSo ? 1 : 0);
        r100.writeInt(this.mReinstallIfRomUpdate);
        r100.writeByte(this.mLoadAsHostClass ? 1 : 0);
        r100.writeByte(this.mDisabledInDebug ? 1 : 0);
        r100.writeByte(this.mEnableDeleteNativeEntry ? 1 : 0);
        JSONObject r102 = this.mExtraData;
        if (r102 != null) goto L5;
        String r103 = null;
    L6:
        r100.writeString(r103);
        r100.writeByte(this.mEnableSoLink ? 1 : 0);
        r100.writeString(this.mSoLinkConfig);
        return;
    L5:
        r103 = r102.toString();
        goto L6
    }

    private boolean checkAbi(int r100, int r101, boolean r102) {
        boolean r103 = true;
        if (r102 == true) goto L5;
    L7:
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin checkAbi, pkg=" + this.mPackageName + ", ver=" + this.mVersionCode + ", valid=" + r103);
        return r103;
    L5:
        if (NativeLibHelper.isPluginApkMatchHostAbi(new PolarisFileWrapper(PluginDirHelper.getSourceFile(this.mPackageName, r100))) == true) goto L7;
        MiraLogger.w(MiraLogger.TAG_INIT, TAG + String.format("checkAbi plugin[%s, ver=%s] not match hostAbi", new Object[]{this.mPackageName, Integer.valueOf(r100), Integer.valueOf(r101)}));
        r103 = false;
        goto L7
    }

    private boolean checkValid(File r110, String r111, int r112) {
        if (TextUtils.equals(this.mPackageName, r111) == true) goto L7;
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin checkValid " + r111 + " package name not match !!!");
        return false;
    L7:
        if (r112 >= this.mMinVersionCode) goto L9;
    L42:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin checkValid " + r111 + " " + String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", new Object[]{Integer.valueOf(r112), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode)}));
        return false;
    L9:
        if (r112 > this.mMaxVersionCode) goto L42;
        int r100 = PluginManager.getInstance().getHostUpdateVerCode();
        if (r100 == (-1)) goto L19;
        int r101 = MetaManager.getInst().getHostCompatibleMinVersion(r111, r112);
        int r102 = MetaManager.getInst().getHostCompatibleMaxVersion(r111, r112);
        if (r100 < r101) goto L16;
        if (r100 <= r102) goto L19;
    L16:
        MiraLogger.w(MiraLogger.TAG_INSTALL, TAG + String.format(" checkVersion plugin[%s, ver=%s] is not compatible with host[update_ver_code=%s], hostCompatibleVer=[%s,%s]", new Object[]{r111, Integer.valueOf(r112), Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102)}));
        PluginEventManager.getInstance().notifyPluginErrorEvent(PluginEventManager.InstallStatusCode.INSTALL_CHECK_HOST_COMPAT_FAILED, r111, r112, null, System.currentTimeMillis());
        return false;
    L19:
        if (r112 < this.mVersionCode) goto L21;
    L28:
        if (r110 != null) goto L30;
    L40:
        MiraLogger.e(MiraLogger.TAG_INSTALL, "Plugin checkValid " + r111 + " pluginApk not exist.");
        return false;
    L30:
        if (r110.exists() == false) goto L40;
        if (r112 == this.mVersionCode) goto L35;
    L38:
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin checkValid " + r111 + ":" + r112 + " true");
        return true;
    L35:
        if (MetaManager.getInst().getInstalledPluginMd5(r111).equals(EncryptUtils.encryptMD5File2String(r110)) == false) goto L38;
        MiraLogger.e(MiraLogger.TAG_INSTALL, "Plugin checkValid " + r111 + " pluginApk with the same md5 has already installed.");
        return false;
    L21:
        if (this.mLifeCycle != 4) goto L23;
    L26:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin checkValid " + r111 + String.format(" pluginApk ver[%s] lower than installed plugin[%s].", new Object[]{Integer.valueOf(r112), Integer.valueOf(this.mVersionCode)}));
        return false;
    L23:
        if (this.mLifeCycle == 7) goto L26;
        if (this.mLifeCycle != 8) goto L28;
        goto L26
    }

    public boolean install(File r210, PackageInfo r211, boolean r212) {
        String r100 = "Plugin LIFE_ACTIVE, valid next restart ";
        boolean r110 = false;
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin install from local file " + r210 + ", " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L94
        if (r211 == null) goto L104;
        PackageInfo r111 = r211;
    L7:
        if (r111 != null) goto L10;
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin read local file package info failed !!!");     // Catch: Throwable -> L97
        return false;
    L10:
        boolean r112 = r210.exists();     // Catch: Throwable -> L94
        onPluginInstallStart(r210, r111);     // Catch: Throwable -> L94
        if (r112 == true) goto L13;
    L16:
        String r113 = r111.packageName;     // Catch: Throwable -> L94
        int r114 = r111.versionCode;     // Catch: Throwable -> L94
        this.installingCount.incrementAndGet();     // Catch: Throwable -> L94
        Object r115 = this.installLock;     // Catch: Throwable -> L94
        monitor-enter(r115);     // Catch: Throwable -> L94
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=" + this);     // Catch: Throwable -> L87
        boolean r101 = checkValid(r210, r113, r114);     // Catch: Throwable -> L87
        if (r101 == true) goto L113;
        String r116 = "Plugin delete file by failedCount > 0 ";
        r100 = "Plugin LIFE_ACTIVE, valid next restart ";
        boolean r117 = false;
    L106:
        monitor-enter(this);     // Catch: Throwable -> L85
        if (r101 == false) goto L71;
        MiraLogger.i(MiraLogger.TAG_INSTALL, "this is: " + toString());     // Catch: Throwable -> L82
        if (this.mLifeCycle == 8) goto L70;
        if (r117 == false) goto L63;
        updateVersionLifeCycle(r114, 4);     // Catch: Throwable -> L82
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin INSTALLED " + r113 + ":" + r114);     // Catch: Throwable -> L82
        postPluginInstalled(this.mPackageName, r117);     // Catch: Throwable -> L82
    L72:
        this.installingCount.decrementAndGet();     // Catch: Throwable -> L82
        Object r102 = this.waitLock;     // Catch: Throwable -> L82
        monitor-enter(r102);     // Catch: Throwable -> L82
        this.waitLock.notifyAll();     // Catch: Throwable -> L79
        monitor-exit(r102);     // Catch: Throwable -> L79
        monitor-exit(this);     // Catch: Throwable -> L82
        monitor-exit(r115);     // Catch: Throwable -> L85
        return r117;
    L79:
        th = move-exception;
        throw th;     // Catch: Throwable -> L82
    L63:
        this.mLifeCycle = 3;     // Catch: Throwable -> L82
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + r113 + ":" + r114);     // Catch: Throwable -> L82
        postPluginInstalled(this.mPackageName, r117);     // Catch: Throwable -> L82
        int r103 = this.failedCount.getAndIncrement();     // Catch: Throwable -> L82
        if (r103 != 0) goto L68;
        if (r212 == false) goto L68;
        install(r210, r111, false);     // Catch: Throwable -> L82
    L68:
        if (r103 <= 0) goto L72;
        FileUtils.deleteFile(r210);     // Catch: Throwable -> L82
        MiraLogger.w(MiraLogger.TAG_INSTALL, r116 + r113 + ":" + r114);     // Catch: Throwable -> L82
        goto L72
    L70:
        MiraLogger.w(MiraLogger.TAG_INSTALL, r100 + r113 + ":" + r114);     // Catch: Throwable -> L82
        goto L72
    L71:
        FileUtils.deleteFile(r210);     // Catch: Throwable -> L82
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin deleting invalid " + r113 + ":" + r114);     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        throw th;     // Catch: Throwable -> L85
    L85:
        th = th;
    L98:
        monitor-exit(r115);     // Catch: Throwable -> L92
        throw th;     // Catch: Throwable -> L97
    L92:
        th = th;
        goto L98
    L113:
        boolean r118 = PluginInstaller.install(r210, r113, r114, this.mClassToVerify);     // Catch: Throwable -> L54
        if (r118 == true) goto L111;
        r116 = "Plugin delete file by failedCount > 0 ";
        boolean r213 = r118;
    L53:
        r117 = r213;
        goto L106
    L111:
        String r119 = PluginDirHelper.getSourceFile(this.mPackageName, r114);     // Catch: Throwable -> L49
        r213 = r118;
        String r120 = EncryptUtils.encryptMD5File2String(r119);     // Catch: Throwable -> L47
        MiraParam r121 = MiraManager.getInstance().getParam();     // Catch: Throwable -> L47
        if (r121 != null) goto L27;
    L30:
        boolean r122 = true;
    L31:
        if (r122 == false) goto L33;
        String r104 = EncryptUtils.getFileSHA256(new PolarisFileWrapper(r119));     // Catch: Throwable -> L47
    L35:
        if (OSUtil.isAndroidMOrHigher() == false) goto L42;
        if (r121 == null) goto L42;
        if (r121.enableDeleteNative() == false) goto L42;
        r116 = "Plugin delete file by failedCount > 0 ";
        if (this.mEnableDeleteNativeEntry == false) goto L43;
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin delete native lib, " + this.mPackageName + ":" + r114);     // Catch: Throwable -> L47
        NativeLibHelper.deleteZipEntry(new PolarisFileWrapper(r119));     // Catch: Throwable -> L47
    L43:
        if (r122 == false) goto L45;
        MetaManager.getInst().setInstalledPluginSha256(this.mPackageName, r104);     // Catch: Throwable -> L47
    L45:
        MetaManager.getInst().setInstalledPluginMd5(this.mPackageName, r120);     // Catch: Throwable -> L47
        MetaManager.getInst().setInstalledPluginMd5Extend(this.mPackageName, r114, r120);     // Catch: Throwable -> L47
        MetaManager.getInst().markPluginInstalled(this.mPackageName, r114, true);     // Catch: Throwable -> L47
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPackageName + ":" + r114 + " md5=" + r120);     // Catch: Throwable -> L47
        FileUtils.deleteFile(r210);     // Catch: Throwable -> L47
    L42:
        r116 = "Plugin delete file by failedCount > 0 ";
        goto L43
    L33:
        r104 = null;
        goto L35
    L27:
        if (r121.enableOptInstallProcess() == false) goto L30;
        r122 = false;
    L47:
        th = th;
    L49:
        th = th;
        r213 = r118;
    L54:
        th = th;
    L87:
        th = th;
        goto L98
    L13:
        if (r210.exists() == true) goto L16;
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin onPluginInstallStart end, apkFile not exists after callback" + this);     // Catch: Throwable -> L97
        return false;
    L104:
        r111 = PackageInfoUtils.getPackageInfo(r210);     // Catch: Throwable -> L97
    L95:
        MiraLogger.e(MiraLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!");
        return r110;
    L94:
        r110 = false;
        goto L95
    }

    public void setHostCompatVersion(int r100, int r101, int r102) {
        MetaManager.getInst().setHostCompatibleVersion(this.mPackageName, r100, r101, r102);
    }

    private boolean checkVersionValid(int r110, int r111, boolean r112, boolean r113) {
        boolean r100 = false;
        if (r110 >= 0) goto L5;
    L18:
        boolean r101 = false;
    L19:
        if (r101 == true) goto L21;
    L26:
        if (r101 == false) goto L31;
        if (r113 == false) goto L31;
        if (NativeLibHelper.isPluginApkMatchHostAbi(new PolarisFileWrapper(PluginDirHelper.getSourceFile(this.mPackageName, r110))) == true) goto L31;
        MiraLogger.w(MiraLogger.TAG_INIT, TAG + String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", new Object[]{this.mPackageName, Integer.valueOf(r110), Integer.valueOf(r111)}));
    L32:
        MiraLogger.i(MiraLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPackageName + ", ver=" + this.mVersionCode + ", valid=" + r100);
        return r100;
    L31:
        r100 = r101;
        goto L32
    L21:
        if (r111 == (-1)) goto L26;
        int r102 = MetaManager.getInst().getHostCompatibleMinVersion(this.mPackageName, r110);
        int r103 = MetaManager.getInst().getHostCompatibleMaxVersion(this.mPackageName, r110);
        if (r111 < r102) goto L25;
        if (r111 <= r103) goto L26;
    L25:
        MiraLogger.w(MiraLogger.TAG_INIT, TAG + String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with host[update_ver_code=%s], hostCompatibleVer=[%s,%s]", new Object[]{this.mPackageName, Integer.valueOf(this.mVersionCode), Integer.valueOf(r111), Integer.valueOf(r102), Integer.valueOf(r103)}));
        r101 = false;
        goto L26
    L5:
        if (r110 < this.mMinVersionCode) goto L18;
        if (r110 > this.mMaxVersionCode) goto L18;
        if (isInternalPlugin() == false) goto L17;
        int r104 = this.mInternalPluginVersion;
        if (r110 >= r104) goto L13;
        MiraLogger.w(MiraLogger.TAG_INIT, TAG + String.format(" checkVersionValid %s installed ver miss match, maxVer=%s , mInternalPluginVer=%s", new Object[]{this.mPackageName, Integer.valueOf(r110), Integer.valueOf(this.mInternalPluginVersion)}));
        goto L18
    L13:
        if (r110 != r104) goto L17;
        String r105 = MetaManager.getInst().getInstalledPluginMd5(this.mPackageName);
        if (this.mInternalPluginMD5.equalsIgnoreCase(r105) == true) goto L17;
        MiraLogger.w(MiraLogger.TAG_INIT, TAG + String.format(" checkVersionValid %s installed md5 miss match, md5=%s , mInternalPluginMD5=%s", new Object[]{this.mPackageName, r105, this.mInternalPluginMD5}));
    L17:
        r101 = true;
        goto L19
    }

    private boolean checkValidCompat(File r110, File r111, String r112, String r113, int r210) {
        if (TextUtils.equals(this.mPackageName, r113) == true) goto L7;
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin checkValidCompat " + r113 + " package name not match !!!");
        return false;
    L7:
        if (r210 >= this.mMinVersionCode) goto L9;
    L45:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin checkValidCompat " + r113 + " " + String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", new Object[]{Integer.valueOf(r210), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode)}));
        return false;
    L9:
        if (r210 > this.mMaxVersionCode) goto L45;
        int r100 = PluginManager.getInstance().getHostUpdateVerCode();
        if (r100 == (-1)) goto L19;
        int r114 = MetaManager.getInst().getHostCompatibleMinVersion(r113, r210);
        int r115 = MetaManager.getInst().getHostCompatibleMaxVersion(r113, r210);
        if (r100 < r114) goto L16;
        if (r100 <= r115) goto L19;
    L16:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin checkValidCompat " + String.format(" checkVersion plugin[%s, ver=%s] is not compatible with host[update_ver_code=%s], hostCompatibleVer=[%s,%s]", new Object[]{r113, Integer.valueOf(r210), Integer.valueOf(r100), Integer.valueOf(r114), Integer.valueOf(r115)}));
        PluginEventManager.getInstance().notifyPluginErrorEvent(PluginEventManager.InstallStatusCode.INSTALL_CHECK_HOST_COMPAT_FAILED, r113, r210, null, System.currentTimeMillis());
        return false;
    L19:
        if (r210 < this.mVersionCode) goto L21;
    L28:
        if (r110 != null) goto L30;
    L43:
        MiraLogger.e(MiraLogger.TAG_INSTALL, "Plugin checkValidCompat " + r113 + " pluginApk or soDirFile not exist.");
        return false;
    L30:
        if (r110.exists() == false) goto L43;
        if (r111 == null) goto L43;
        if (r111.exists() == false) goto L43;
        if (r210 == this.mVersionCode) goto L38;
    L41:
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin checkValidCompat " + r113 + ":" + r210 + " true");
        return true;
    L38:
        if (MetaManager.getInst().getInstalledPluginMd5(r113).equals(r112) == false) goto L41;
        MiraLogger.e(MiraLogger.TAG_INSTALL, "Plugin checkValidCompat " + r113 + " pluginApk with the same md5 has already installed.");
        return false;
    L21:
        if (this.mLifeCycle != 4) goto L23;
    L26:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin checkValidCompat " + r113 + String.format(" pluginApk ver[%s] lower than installed plugin[%s].", new Object[]{Integer.valueOf(r210), Integer.valueOf(this.mVersionCode)}));
        return false;
    L23:
        if (this.mLifeCycle == 7) goto L26;
        if (this.mLifeCycle != 8) goto L28;
        goto L26
    }

    public boolean installCompat(File r210, File r211, String r212, PackageInfo r213, boolean r214) {
        boolean r100 = false;
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin install from local file " + r210 + ", " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L65
        if (r213 == null) goto L77;
        PackageInfo r101 = r213;
    L7:
        if (r101 != null) goto L10;
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin read local file package info failed !!!");     // Catch: Throwable -> L68
        return false;
    L10:
        boolean r102 = r210.exists();     // Catch: Throwable -> L65
        onPluginInstallStart(r210, r101);     // Catch: Throwable -> L65
        if (r102 == true) goto L13;
    L16:
        String r103 = r101.packageName;     // Catch: Throwable -> L65
        int r104 = r101.versionCode;     // Catch: Throwable -> L65
        this.installingCount.incrementAndGet();     // Catch: Throwable -> L65
        Object r105 = this.installLock;     // Catch: Throwable -> L65
        monitor-enter(r105);     // Catch: Throwable -> L65
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=" + this);     // Catch: Throwable -> L57
        Object r110 = r105;
        PackageInfo r111 = r101;
        boolean r106 = checkValidCompat(r210, r211, r212, r103, r104);     // Catch: Throwable -> L55
        if (r106 == true) goto L72;
        int r107 = r104;
        r100 = false;
    L28:
        monitor-enter(this);     // Catch: Throwable -> L63
        if (r106 == false) goto L41;
        MiraLogger.i(MiraLogger.TAG_INSTALL, "this is: " + toString());     // Catch: Throwable -> L52
        if (this.mLifeCycle == 8) goto L40;
        if (r100 == false) goto L34;
        updateVersionLifeCycle(r107, 4);     // Catch: Throwable -> L52
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin INSTALLED " + r103 + ":" + r107);     // Catch: Throwable -> L52
        postPluginInstalled(this.mPackageName, r100);     // Catch: Throwable -> L52
    L42:
        this.installingCount.decrementAndGet();     // Catch: Throwable -> L52
        Object r108 = this.waitLock;     // Catch: Throwable -> L52
        monitor-enter(r108);     // Catch: Throwable -> L52
        this.waitLock.notifyAll();     // Catch: Throwable -> L49
        monitor-exit(r108);     // Catch: Throwable -> L49
        monitor-exit(this);     // Catch: Throwable -> L52
        monitor-exit(r110);     // Catch: Throwable -> L63
    L67:
        return r100;
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L34:
        this.mLifeCycle = 3;     // Catch: Throwable -> L52
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + r103 + ":" + r107);     // Catch: Throwable -> L52
        postPluginInstalled(this.mPackageName, r100);     // Catch: Throwable -> L52
        int r109 = this.failedCount.getAndIncrement();     // Catch: Throwable -> L52
        if (r109 != 0) goto L38;
        if (r214 == false) goto L38;
        install(r210, r111, false);     // Catch: Throwable -> L52
    L38:
        if (r109 <= 0) goto L42;
        FileUtils.deleteFile(r210);     // Catch: Throwable -> L52
        FileUtils.deleteFile(r211);     // Catch: Throwable -> L52
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + r103 + ":" + r107);     // Catch: Throwable -> L52
        goto L42
    L40:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin LIFE_ACTIVE, valid next restart " + r103 + ":" + r107);     // Catch: Throwable -> L52
        goto L42
    L41:
        FileUtils.deleteFile(r210);     // Catch: Throwable -> L52
        FileUtils.deleteFile(r211);     // Catch: Throwable -> L52
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin deleting invalid " + r103 + ":" + r107);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63
    L72:
        r107 = r104;
        r100 = PluginInstaller.installCompat(r210, r211, r103, r107, this.mClassToVerify);     // Catch: Throwable -> L25
        if (r100 == false) goto L28;
        MetaManager.getInst().setInstalledPluginMd5(this.mPackageName, r212);     // Catch: Throwable -> L63
        MetaManager.getInst().setInstalledPluginMd5Extend(this.mPackageName, r107, r212);     // Catch: Throwable -> L63
        MetaManager.getInst().markPluginInstalled(this.mPackageName, r107, true);     // Catch: Throwable -> L63
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPackageName + ":" + r107 + " md5=" + r212);     // Catch: Throwable -> L63
        FileUtils.deleteFile(r210);     // Catch: Throwable -> L63
        FileUtils.deleteFile(r211);     // Catch: Throwable -> L63
    L25:
        th = th;
    L61:
        monitor-exit(r110);     // Catch: Throwable -> L63
        throw th;     // Catch: Throwable -> L68
    L55:
        th = th;
    L57:
        th = th;
        r110 = r105;
    L63:
        th = th;
        goto L61
    L13:
        if (r210.exists() == true) goto L16;
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin onPluginInstallStart end, apkFile not exists after callback" + this);     // Catch: Throwable -> L68
        return false;
    L77:
        r101 = PackageInfoUtils.getPackageInfo(r210);     // Catch: Throwable -> L68
    L66:
        MiraLogger.e(MiraLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!");
    L65:
        r100 = false;
        goto L66
    }
}
