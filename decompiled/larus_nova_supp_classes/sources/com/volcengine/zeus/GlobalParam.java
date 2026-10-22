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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
        PluginGroundProvider r0 = this.mPluginGroundProvider;
        if (r0 == null) goto L5;
        return r0;
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
        this.mStartActivityFallback = com.volcengine.zeus.activity.c.a.a;
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

    public boolean canUseInstallStateSnapshot(String r1) {
        if (enableUseInstallStateSnapshot() == true) goto L6;
        return false;
    L6:
        return true;
    }

    public Map<String, String> getCustomTag(String r2) {
        return this.mCustomTag.get(r2);
    }

    public String getSignature(String r2) {
        return this.mSignature.get(r2);
    }

    public boolean isAutoInstallInternal(String r2) {
        Boolean r3 = this.mAutoInstallInternal.get(r2);
        if (r3 != null) goto L7;
        return true;
    L7:
        return r3.booleanValue();
    }

    public void postBgDexOptByInit(boolean r1) {
        ensureInit();
        this.mPostBgDexOptByInit = this.mPostBgDexOptByInit;
    }

    public void setAutoFetch(boolean r1) {
        ensureInit();
        this.mAutoFetch = r1;
    }

    public void setCheckHostProtocolVersion(boolean r1) {
        ensureInit();
        this.mCheckHostProtocolVersion = r1;
    }

    public void setCheckMatchHostAbi(boolean r1) {
        this.mCheckMatchHostAbi = r1;
    }

    public void setCheckPermission(boolean r1) {
        this.mCheckPermission = r1;
    }

    public void setCloseFlipped(boolean r1) {
        ensureInit();
        this.mCloseFlipped = r1;
    }

    public void setDebug(boolean r1) {
        ensureInit();
        this.mDebug = r1;
    }

    public void setDexOptDelayTime(long r1) {
        ensureInit();
        this.mDexOptDelayTime = r1;
    }

    public void setDid(String r1) {
        this.mDid = r1;
    }

    public void setDownloadDir(File r1) {
        ensureInit();
        this.mDownloadDir = r1;
    }

    public void setDownloadPolicy(DownloadPolicy r1) {
        ensureInit();
        this.mDownloadPolicy = r1;
    }

    public void setDownloaderProvider(IDownloaderProvider r1) {
        ensureInit();
        this.mDownloaderProvider = r1;
    }

    public void setEnableClassLoaderOpt(boolean r1) {
        ensureInit();
        this.mEnableClassLoaderOpt = r1;
    }

    public void setEnableCreateInstallStateSnapshot(boolean r3) {
        ensureInit();
        this.mEnableCreateInstallStateSnapshot = r3;
        ZeusLogger.i(ZeusLogger.TAG_INIT, "GlobalParam setEnableCreateInstallStateSnapshot. enable=" + r3);
    }

    public void setEnableHostQueryPluginProcessPid(boolean r1) {
        ensureInit();
        this.mEnableHostQueryPluginProcessPid = r1;
    }

    public void setEnableSubProcessInstallStateSnapshot(boolean r3) {
        ensureInit();
        this.mEnableCreateInstallStateSnapshot = r3;
        this.mEnableUseInstallStateSnapshot = r3;
        ZeusLogger.i(ZeusLogger.TAG_INIT, "GlobalParam setEnableSubProcessInstallStateSnapshot. enable=" + r3 + " createSnapshot=" + this.mEnableCreateInstallStateSnapshot + " useSnapshot=" + this.mEnableUseInstallStateSnapshot);
    }

    public void setEnableUseInstallStateSnapshot(boolean r3) {
        ensureInit();
        this.mEnableUseInstallStateSnapshot = r3;
        ZeusLogger.i(ZeusLogger.TAG_INIT, "GlobalParam setEnableUseInstallStateSnapshot. enable=" + r3);
    }

    public void setFastDex2oat(boolean r1) {
        this.mFastDex2oat = r1;
    }

    public void setHostUrl(String r1) {
        ensureInit();
        this.mHostUrl = r1;
    }

    public void setIgnoreWebViewRes(boolean r1) {
        ensureInit();
        this.mIgnoreWebViewRes = r1;
    }

    public void setInstallStateSnapshotPrecondition(b r3) {
        ensureInit();
        StringBuilder r0 = new StringBuilder("GlobalParam setInstallStateSnapshotPrecondition. hasPrecondition=");
        if (r3 == null) goto L5;
        boolean r4 = true;
    L6:
        r0.append(r4);
        ZeusLogger.i(ZeusLogger.TAG_INIT, r0.toString());
        return;
    L5:
        r4 = false;
        goto L6
    }

    public void setInstallThreads(int r1) {
        ensureInit();
        this.mInstallThreads = r1;
    }

    public void setLogger(IZeusLogger r1) {
        ensureInit();
        this.mLogger = r1;
    }

    public void setMigrationHandlerFactory(PluginMigrationHandlerFactory r1) {
        ensureInit();
        this.mMigrationHandlerFactory = r1;
    }

    public void setPluginGroundProvider(PluginGroundProvider r1) {
        ensureInit();
        this.mPluginGroundProvider = r1;
    }

    public void setReporter(IZeusReporter r1) {
        ensureInit();
        this.mReporter = r1;
    }

    public void setStartActivityFallback(com.volcengine.zeus.activity.c r1) {
        ensureInit();
        if (r1 != null) goto L6;
        r1 = com.volcengine.zeus.activity.c.a.a;
    L6:
        this.mStartActivityFallback = r1;
    }

    public boolean unInstallPluginWhenHostChange(String r2) {
        Boolean r3 = this.unInstallPluginWhenHostChange.get(r2);
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.booleanValue();
    }

    public void addRequestHeader(String r2, String r3) {
        ensureInit();
        this.mRequestHeader.put(r2, r3);
    }

    public void setAutoInstallInternal(String r2, boolean r3) {
        ensureInit();
        this.mAutoInstallInternal.put(r2, Boolean.valueOf(r3));
    }

    public void setCustomTag(String r2, Map<String, String> r3) {
        this.mCustomTag.put(r2, r3);
    }

    public void setSignature(String r2, String r3) {
        ensureInit();
        this.mSignature.put(r2, r3);
    }

    public void setUnInstallPluginWhenHostChange(String r2, boolean r3) {
        ensureInit();
        this.unInstallPluginWhenHostChange.put(r2, Boolean.valueOf(r3));
    }
}
