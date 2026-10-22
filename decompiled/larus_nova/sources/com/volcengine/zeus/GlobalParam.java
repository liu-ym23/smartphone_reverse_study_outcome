package com.volcengine.zeus;

import com.volcengine.zeus.download.DefaultDownloadPolicy;
import com.volcengine.zeus.download.DownloadPolicy;
import com.volcengine.zeus.download.IDownloaderProvider;
import com.volcengine.zeus.log.IZeusLogger;
import com.volcengine.zeus.log.IZeusReporter;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.DefaultPluginMigrationHandlerFactory;
import com.volcengine.zeus.plugin.PluginMigrationHandlerFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GlobalParam {
    private static GlobalParam mInstance;
    private boolean hasInit;
    private boolean mAutoFetch;
    private Map<String, Boolean> mAutoInstallInternal;
    private boolean mCheckHostProtocolVersion;
    private boolean mCheckMatchHostAbi;
    private boolean mCheckPermission;
    private boolean mCloseFlipped;
    private final Map<String, Map<String, String>> mCustomTag;
    private boolean mDebug;
    private long mDexOptDelayTime;
    private String mDid;
    private File mDownloadDir;
    private DownloadPolicy mDownloadPolicy;
    private IDownloaderProvider mDownloaderProvider;
    private boolean mEnableClassLoaderOpt;
    private boolean mEnableCreateInstallStateSnapshot;
    private boolean mEnableHostQueryPluginProcessPid;
    private boolean mEnableUseInstallStateSnapshot;
    private boolean mFastDex2oat;
    private String mHostUrl;
    private boolean mIgnoreWebViewRes;
    private b mInstallStateSnapshotPrecondition;
    private int mInstallThreads;
    private IZeusLogger mLogger;
    private PluginMigrationHandlerFactory mMigrationHandlerFactory;
    private PluginGroundProvider mPluginGroundProvider;
    private boolean mPostBgDexOptByInit;
    private IZeusReporter mReporter;
    private Map<String, String> mRequestHeader;
    private Map<String, String> mSignature;
    private com.volcengine.zeus.activity.c mStartActivityFallback;
    private Map<String, Boolean> unInstallPluginWhenHostChange;

    /* JADX INFO: loaded from: classes41.dex */
    public class a extends PluginGroundProvider {
        @Override // com.volcengine.zeus.PluginGroundProvider
        public final boolean isForeground(String r100) {
            return true;
        }

        public a() {
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface b {
    }

    public void init() {
        this.hasInit = true;
    }

    private void ensureInit() {
        if (this.hasInit == true) goto L6;
        return;
    L6:
        throw new RuntimeException();
    }

    public static GlobalParam getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(GlobalParam.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new GlobalParam();     // Catch: Throwable -> L11
    L9:
        monitor-exit(GlobalParam.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public boolean enableSubProcessInstallStateSnapshot() {
        if (this.mEnableCreateInstallStateSnapshot == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mEnableUseInstallStateSnapshot == false) goto L7;
        return true;
    }

    public boolean enableUseInstallStateSnapshot() {
        if (this.mEnableCreateInstallStateSnapshot == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mEnableUseInstallStateSnapshot == false) goto L7;
        return true;
    }

    public DownloadPolicy getDownloadPolicy() {
        if (this.mDownloadPolicy != null) goto L6;
        this.mDownloadPolicy = new DefaultDownloadPolicy();
    L6:
        return this.mDownloadPolicy;
    }

    public PluginMigrationHandlerFactory getMigrationHandlerFactory() {
        if (this.mMigrationHandlerFactory != null) goto L6;
        this.mMigrationHandlerFactory = new DefaultPluginMigrationHandlerFactory();
    L6:
        return this.mMigrationHandlerFactory;
    }

    public PluginGroundProvider getPluginGroundProvider() {
        PluginGroundProvider r100 = this.mPluginGroundProvider;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new a();
    }

    public GlobalParam() {
        this.hasInit = false;
        this.mDebug = true;
        this.mInstallThreads = 4;
        this.mCheckMatchHostAbi = true;
        this.mCheckHostProtocolVersion = false;
        this.mRequestHeader = new HashMap();
        this.unInstallPluginWhenHostChange = new HashMap();
        this.mCustomTag = new HashMap();
        this.mSignature = new HashMap();
        this.mAutoInstallInternal = new HashMap();
        this.mDexOptDelayTime = 15000;
        this.mPostBgDexOptByInit = true;
        this.mAutoFetch = true;
        this.mStartActivityFallback = com.volcengine.zeus.activity.c.a.f462664a;
        this.mIgnoreWebViewRes = false;
        this.mEnableCreateInstallStateSnapshot = false;
        this.mEnableUseInstallStateSnapshot = false;
        this.mEnableHostQueryPluginProcessPid = false;
    }

    public boolean autoFetch() {
        return this.mAutoFetch;
    }

    public boolean checkHostProtocolVersion() {
        return this.mCheckHostProtocolVersion;
    }

    public boolean checkMatchHostAbi() {
        return this.mCheckMatchHostAbi;
    }

    public boolean checkPermission() {
        return this.mCheckPermission;
    }

    public boolean enableClassLoaderOpt() {
        return this.mEnableClassLoaderOpt;
    }

    public boolean enableCreateInstallStateSnapshot() {
        return this.mEnableCreateInstallStateSnapshot;
    }

    public boolean enableHostQueryPluginProcessPid() {
        return this.mEnableHostQueryPluginProcessPid;
    }

    public long getDexOptDelayTime() {
        return this.mDexOptDelayTime;
    }

    public String getDid() {
        return this.mDid;
    }

    public File getDownloadDir() {
        return this.mDownloadDir;
    }

    public IDownloaderProvider getDownloaderProvider() {
        return this.mDownloaderProvider;
    }

    public String getHostUrl() {
        return this.mHostUrl;
    }

    public int getInstallThreads() {
        return this.mInstallThreads;
    }

    public IZeusLogger getLogger() {
        return this.mLogger;
    }

    public IZeusReporter getReporter() {
        return this.mReporter;
    }

    public Map<String, String> getRequestHeader() {
        return this.mRequestHeader;
    }

    public com.volcengine.zeus.activity.c getStartActivityFallback() {
        return this.mStartActivityFallback;
    }

    public boolean isCloseFlipped() {
        return this.mCloseFlipped;
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public boolean isFastDex2oat() {
        return this.mFastDex2oat;
    }

    public boolean isIgnoreWebViewRes() {
        return this.mIgnoreWebViewRes;
    }

    public boolean isPostBgDexOptByInit() {
        return this.mPostBgDexOptByInit;
    }

    public boolean canUseInstallStateSnapshot(String r100) {
        if (enableUseInstallStateSnapshot() == true) goto L6;
        return false;
    L6:
        return true;
    }

    public Map<String, String> getCustomTag(String r100) {
        return this.mCustomTag.get(r100);
    }

    public String getSignature(String r100) {
        return this.mSignature.get(r100);
    }

    public boolean isAutoInstallInternal(String r100) {
        Boolean r101 = this.mAutoInstallInternal.get(r100);
        if (r101 != null) goto L7;
        return true;
    L7:
        return r101.booleanValue();
    }

    public void postBgDexOptByInit(boolean r100) {
        ensureInit();
        this.mPostBgDexOptByInit = this.mPostBgDexOptByInit;
    }

    public void setAutoFetch(boolean r100) {
        ensureInit();
        this.mAutoFetch = r100;
    }

    public void setCheckHostProtocolVersion(boolean r100) {
        ensureInit();
        this.mCheckHostProtocolVersion = r100;
    }

    public void setCheckMatchHostAbi(boolean r100) {
        this.mCheckMatchHostAbi = r100;
    }

    public void setCheckPermission(boolean r100) {
        this.mCheckPermission = r100;
    }

    public void setCloseFlipped(boolean r100) {
        ensureInit();
        this.mCloseFlipped = r100;
    }

    public void setDebug(boolean r100) {
        ensureInit();
        this.mDebug = r100;
    }

    public void setDexOptDelayTime(long r100) {
        ensureInit();
        this.mDexOptDelayTime = r100;
    }

    public void setDid(String r100) {
        this.mDid = r100;
    }

    public void setDownloadDir(File r100) {
        ensureInit();
        this.mDownloadDir = r100;
    }

    public void setDownloadPolicy(DownloadPolicy r100) {
        ensureInit();
        this.mDownloadPolicy = r100;
    }

    public void setDownloaderProvider(IDownloaderProvider r100) {
        ensureInit();
        this.mDownloaderProvider = r100;
    }

    public void setEnableClassLoaderOpt(boolean r100) {
        ensureInit();
        this.mEnableClassLoaderOpt = r100;
    }

    public void setEnableCreateInstallStateSnapshot(boolean r100) {
        ensureInit();
        this.mEnableCreateInstallStateSnapshot = r100;
        ZeusLogger.i(ZeusLogger.TAG_INIT, "GlobalParam setEnableCreateInstallStateSnapshot. enable=" + r100);
    }

    public void setEnableHostQueryPluginProcessPid(boolean r100) {
        ensureInit();
        this.mEnableHostQueryPluginProcessPid = r100;
    }

    public void setEnableSubProcessInstallStateSnapshot(boolean r100) {
        ensureInit();
        this.mEnableCreateInstallStateSnapshot = r100;
        this.mEnableUseInstallStateSnapshot = r100;
        ZeusLogger.i(ZeusLogger.TAG_INIT, "GlobalParam setEnableSubProcessInstallStateSnapshot. enable=" + r100 + " createSnapshot=" + this.mEnableCreateInstallStateSnapshot + " useSnapshot=" + this.mEnableUseInstallStateSnapshot);
    }

    public void setEnableUseInstallStateSnapshot(boolean r100) {
        ensureInit();
        this.mEnableUseInstallStateSnapshot = r100;
        ZeusLogger.i(ZeusLogger.TAG_INIT, "GlobalParam setEnableUseInstallStateSnapshot. enable=" + r100);
    }

    public void setFastDex2oat(boolean r100) {
        this.mFastDex2oat = r100;
    }

    public void setHostUrl(String r100) {
        ensureInit();
        this.mHostUrl = r100;
    }

    public void setIgnoreWebViewRes(boolean r100) {
        ensureInit();
        this.mIgnoreWebViewRes = r100;
    }

    public void setInstallStateSnapshotPrecondition(b r100) {
        ensureInit();
        StringBuilder r101 = new StringBuilder("GlobalParam setInstallStateSnapshotPrecondition. hasPrecondition=");
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        ZeusLogger.i(ZeusLogger.TAG_INIT, r101.toString());
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void setInstallThreads(int r100) {
        ensureInit();
        this.mInstallThreads = r100;
    }

    public void setLogger(IZeusLogger r100) {
        ensureInit();
        this.mLogger = r100;
    }

    public void setMigrationHandlerFactory(PluginMigrationHandlerFactory r100) {
        ensureInit();
        this.mMigrationHandlerFactory = r100;
    }

    public void setPluginGroundProvider(PluginGroundProvider r100) {
        ensureInit();
        this.mPluginGroundProvider = r100;
    }

    public void setReporter(IZeusReporter r100) {
        ensureInit();
        this.mReporter = r100;
    }

    public void setStartActivityFallback(com.volcengine.zeus.activity.c r100) {
        ensureInit();
        if (r100 != null) goto L6;
        r100 = com.volcengine.zeus.activity.c.a.f462664a;
    L6:
        this.mStartActivityFallback = r100;
    }

    public boolean unInstallPluginWhenHostChange(String r100) {
        Boolean r101 = this.unInstallPluginWhenHostChange.get(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.booleanValue();
    }

    public void addRequestHeader(String r100, String r101) {
        ensureInit();
        this.mRequestHeader.put(r100, r101);
    }

    public void setAutoInstallInternal(String r100, boolean r101) {
        ensureInit();
        this.mAutoInstallInternal.put(r100, Boolean.valueOf(r101));
    }

    public void setCustomTag(String r100, Map<String, String> r101) {
        this.mCustomTag.put(r100, r101);
    }

    public void setSignature(String r100, String r101) {
        ensureInit();
        this.mSignature.put(r100, r101);
    }

    public void setUnInstallPluginWhenHostChange(String r100, boolean r101) {
        ensureInit();
        this.unInstallPluginWhenHostChange.put(r100, Boolean.valueOf(r101));
    }
}
