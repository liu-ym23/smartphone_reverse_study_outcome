package com.bytedance.mira;

import android.text.TextUtils;
import com.bytedance.mira.core.ComponentProtectManager;
import com.bytedance.mira.log.IMiraEventReport;
import f6.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MiraParam {
    private IInternalIgnore internalIgnoreImpl;
    private boolean mCheckMatchHostAbi;
    private boolean mCheckSignature;
    private boolean mClassLoaderHook;
    private ComponentProtectManager.IComponentProtect mComponentProtect;
    private boolean mDebug;
    private boolean mEnable;
    private boolean mEnableArrayIndexExceptionFix;
    private boolean mEnableClassDefOpt;
    private boolean mEnableCrc32Opt;
    private boolean mEnableDeleteNative;
    private boolean mEnableDeleteUndeclaredPlugin;
    private boolean mEnableDiffStorageOpt;
    private boolean mEnableDrawableAccessReport;
    private boolean mEnableForceClearBuildProduct;
    private boolean mEnableInstallProcessOpt;
    private boolean mEnableLoadProcessOpt;
    private boolean mEnableModifyRes;
    private boolean mEnableNativeClassLoaderOpt;
    private boolean mEnableOptCreateContextImpl;
    private boolean mEnableOptCreateLoadedApk;
    private boolean mEnableOptFindClassDispatch;
    private boolean mEnableOptIntent;
    private boolean mEnableOptMakeApplication;
    private boolean mEnableOptNeedLoadPluginCheck;
    private boolean mEnableOptRecovery;
    private boolean mEnableOptResourcesArch;
    private boolean mEnableReleaseBuildOpt;
    private boolean mEnableSameToHostSplitPath;
    private Map<String, List<String>> mEnableSkipCheckPermission;
    private boolean mEnableSoArchUpdate;
    private boolean mEnableSpecifiedCert;
    private IMiraEventReport mEventReport;
    private boolean mFastDex2Oat;
    private int mInstallThreads;
    private boolean mKeepExpiredPluginUntilInstallNew;
    private Map<String, String> mLoadPluginClass;
    private long mLoadPluginWaitTimeOut;
    private int mLogLevel;
    private boolean mOpenMiraOpt;
    private boolean mOpenResFix;
    private Map<String, String> mRedirectClassMap;
    private boolean mRegisterProviderInHost;
    private d mResourceIdVisitor;
    private boolean mShareRes;
    private Set<String> mSkipWhenPluginInstallDex2OatWhitePluginPackageNames;
    private List<String> mSupportPluginProcNames;
    private boolean mWithFastFindOpt;
    private Set<String> mWithHookActivityViewRootImplCallback;
    private boolean mWithImageOpt;
    private Set<String> mWithOptPluginPackageNames;
    private Set<String> mWithoutHookActivityRes;

    /* JADX INFO: renamed from: com.bytedance.mira.MiraParam$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes21.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private IInternalIgnore internalIgnoreImpl;
        private boolean mCheckMatchHostAbi;
        private boolean mCheckSignature;
        private boolean mClassLoaderHook;
        private ComponentProtectManager.IComponentProtect mComponentProtect;
        private boolean mDebug;
        private boolean mEnable;
        private boolean mEnableArrayIndexExceptionFix;
        private boolean mEnableClassDefOpt;
        private boolean mEnableCrc32Opt;
        private boolean mEnableDeleteNative;
        private boolean mEnableDeleteUndeclaredPlugin;
        private boolean mEnableDiffStorageOpt;
        private boolean mEnableDrawableAccessReport;
        private boolean mEnableForceClearBuildProduct;
        private boolean mEnableInstallProcessOpt;
        private boolean mEnableLoadProcessOpt;
        private boolean mEnableModifyRes;
        private boolean mEnableNativeClassLoaderOpt;
        private boolean mEnableOptCreateContextImpl;
        private boolean mEnableOptCreateLoadedApk;
        private boolean mEnableOptFindClassDispatch;
        private boolean mEnableOptIntent;
        private boolean mEnableOptMakeApplication;
        private boolean mEnableOptNeedLoadPluginCheck;
        private boolean mEnableOptRecovery;
        private boolean mEnableOptResourcesArch;
        private boolean mEnableReleaseBuildOpt;
        private boolean mEnableSameToHostSplitPath;
        private Map<String, List<String>> mEnableSkipCheckPermission;
        private boolean mEnableSoArchUpdate;
        private boolean mEnableSpecifiedCert;
        private IMiraEventReport mEventReport;
        private boolean mFastDex2Oat;
        private int mInstallThreads;
        private boolean mKeepExpiredPluginUntilInstallNew;
        private Map<String, String> mLoadPluginClass;
        private long mLoadPluginWaitTimeOut;
        private int mLogLevel;
        private boolean mOpenMiraOpt;
        private boolean mOpenResFix;
        private Map<String, String> mRedirectClassMap;
        private boolean mRegisterProviderInHost;
        private d mResourceIdVisitor;
        private boolean mShareRes;
        private Set<String> mSkipWhenPluginInstallDex2OatWhitePluginPackageNames;
        private List<String> mSupportPluginProcNames;
        private boolean mWithFastFindOpt;
        private Set<String> mWithHookActivityViewRootImplCallback;
        private boolean mWithImageOpt;
        private Set<String> mWithOptPluginPackageNames;
        private Set<String> mWithoutHookActivityRes;

        public Builder setResourceIdVisitor(d r100) {
            return this;
        }

        public Builder withCustomHook(boolean r100) {
            return this;
        }

        public Builder withSupportStandalonePlugin(boolean r100) {
            return this;
        }

        public MiraParam build() {
            MiraParam r100 = new MiraParam(null);
            MiraParam.access$102(r100, this.mEnable);
            MiraParam.access$202(r100, this.mDebug);
            MiraParam.access$302(r100, this.mLogLevel);
            MiraParam.access$402(r100, this.mShareRes);
            MiraParam.access$502(r100, this.mClassLoaderHook);
            MiraParam.access$602(r100, this.mRegisterProviderInHost);
            MiraParam.access$702(r100, this.mFastDex2Oat);
            MiraParam.access$802(r100, this.mEnableDeleteUndeclaredPlugin);
            MiraParam.access$902(r100, this.mCheckMatchHostAbi);
            MiraParam.access$1002(r100, this.mCheckSignature);
            MiraParam.access$1102(r100, this.mInstallThreads);
            MiraParam.access$1202(r100, this.mLoadPluginWaitTimeOut);
            MiraParam.access$1302(r100, this.mWithoutHookActivityRes);
            MiraParam.access$1402(r100, this.mSupportPluginProcNames);
            MiraParam.access$1502(r100, this.mRedirectClassMap);
            MiraParam.access$1602(r100, this.mEnableSpecifiedCert);
            MiraParam.access$1702(r100, this.mEnableDeleteNative);
            MiraParam.access$1802(r100, this.mLoadPluginClass);
            MiraParam.access$1902(r100, this.mKeepExpiredPluginUntilInstallNew);
            MiraParam.access$2002(r100, this.mOpenMiraOpt);
            MiraParam.access$2102(r100, this.mWithHookActivityViewRootImplCallback);
            MiraParam.access$2202(r100, this.mOpenResFix);
            MiraParam.access$2302(r100, this.mWithImageOpt);
            MiraParam.access$2402(r100, this.mWithFastFindOpt);
            MiraParam.access$2502(r100, this.mWithOptPluginPackageNames);
            MiraParam.access$2602(r100, this.mEnableForceClearBuildProduct);
            MiraParam.access$2702(r100, null);
            MiraParam.access$2802(r100, this.internalIgnoreImpl);
            MiraParam.access$2902(r100, this.mSkipWhenPluginInstallDex2OatWhitePluginPackageNames);
            MiraParam.access$3002(r100, this.mEnableDrawableAccessReport);
            MiraParam.access$3102(r100, this.mEnableArrayIndexExceptionFix);
            MiraParam.access$3202(r100, this.mEnableOptIntent);
            MiraParam.access$3302(r100, this.mEnableOptMakeApplication);
            MiraParam.access$3402(r100, this.mEnableOptCreateContextImpl);
            MiraParam.access$3502(r100, this.mEnableOptCreateLoadedApk);
            MiraParam.access$3602(r100, this.mEnableNativeClassLoaderOpt);
            MiraParam.access$3702(r100, this.mEnableReleaseBuildOpt);
            MiraParam.access$3802(r100, this.mEnableDiffStorageOpt);
            MiraParam.access$3902(r100, this.mEnableOptRecovery);
            MiraParam.access$4002(r100, this.mEnableOptResourcesArch);
            MiraParam.access$4102(r100, this.mEnableInstallProcessOpt);
            MiraParam.access$4202(r100, this.mEnableLoadProcessOpt);
            MiraParam.access$4302(r100, this.mEnableSkipCheckPermission);
            MiraParam.access$4402(r100, this.mEventReport);
            MiraParam.access$4502(r100, this.mEnableSameToHostSplitPath);
            MiraParam.access$4602(r100, this.mEnableClassDefOpt);
            MiraParam.access$4702(r100, this.mComponentProtect);
            MiraParam.access$4802(r100, this.mEnableOptNeedLoadPluginCheck);
            MiraParam.access$4902(r100, this.mEnableCrc32Opt);
            MiraParam.access$5002(r100, this.mEnableModifyRes);
            MiraParam.access$5102(r100, this.mEnableOptFindClassDispatch);
            MiraParam.access$5202(r100, this.mEnableSoArchUpdate);
            return r100;
        }

        public Builder() {
            this.mEnable = true;
            this.mDebug = false;
            this.mShareRes = true;
            this.mClassLoaderHook = true;
            this.mCheckMatchHostAbi = true;
            this.mCheckSignature = true;
            this.mEnableDrawableAccessReport = false;
            this.mEnableArrayIndexExceptionFix = false;
            this.mInstallThreads = 4;
            this.mLoadPluginWaitTimeOut = 10000;
            this.mSupportPluginProcNames = Collections.emptyList();
            this.mLogLevel = 4;
            this.mKeepExpiredPluginUntilInstallNew = false;
            this.mEnableForceClearBuildProduct = false;
            this.internalIgnoreImpl = null;
            this.mEnableOptIntent = false;
            this.mEnableOptMakeApplication = false;
            this.mEnableOptCreateContextImpl = false;
            this.mEnableOptCreateLoadedApk = false;
            this.mEnableNativeClassLoaderOpt = false;
            this.mEnableReleaseBuildOpt = false;
            this.mEnableDiffStorageOpt = false;
            this.mEnableOptResourcesArch = false;
            this.mEnableSkipCheckPermission = Collections.emptyMap();
            this.mEnableOptRecovery = false;
            this.mEnableInstallProcessOpt = false;
            this.mEnableLoadProcessOpt = false;
            this.mEventReport = null;
            this.mEnableSameToHostSplitPath = false;
            this.mEnableModifyRes = false;
        }

        public Builder openMiraOpt(boolean r100) {
            this.mOpenMiraOpt = r100;
            return this;
        }

        public Builder setupInternalIgnoreImpl(IInternalIgnore r100) {
            this.internalIgnoreImpl = r100;
            return this;
        }

        public Builder setupResFix(boolean r100) {
            this.mOpenResFix = r100;
            return this;
        }

        public Builder skipWhenPluginInstallDex2OatWhitePluginPackageNames(Set<String> r100) {
            this.mSkipWhenPluginInstallDex2OatWhitePluginPackageNames = r100;
            return this;
        }

        public Builder withCheckMatchHostAbiByInstall(boolean r100) {
            this.mCheckMatchHostAbi = r100;
            return this;
        }

        public Builder withCheckSignatureByInstall(boolean r100) {
            this.mCheckSignature = r100;
            return this;
        }

        public Builder withClassLoaderHook(boolean r100) {
            this.mClassLoaderHook = r100;
            return this;
        }

        public Builder withComponentProtect(ComponentProtectManager.IComponentProtect r100) {
            this.mComponentProtect = r100;
            return this;
        }

        public Builder withDebug(boolean r100) {
            this.mDebug = r100;
            return this;
        }

        public Builder withEnable(boolean r100) {
            this.mEnable = r100;
            return this;
        }

        public Builder withEnableArrayIndexExceptionFix(boolean r100) {
            this.mEnableArrayIndexExceptionFix = r100;
            return this;
        }

        public Builder withEnableClassDefOpt(boolean r100) {
            this.mEnableClassDefOpt = r100;
            return this;
        }

        public Builder withEnableDeleteNative(boolean r100) {
            this.mEnableDeleteNative = r100;
            return this;
        }

        public Builder withEnableDeleteUndeclaredPlugin(boolean r100) {
            this.mEnableDeleteUndeclaredPlugin = r100;
            return this;
        }

        public Builder withEnableDiffStorageOpt(boolean r100) {
            this.mEnableDiffStorageOpt = r100;
            return this;
        }

        public Builder withEnableDrawableAccessReport(boolean r100) {
            this.mEnableDrawableAccessReport = r100;
            return this;
        }

        public Builder withEnableInstallProcessOpt(boolean r100) {
            this.mEnableInstallProcessOpt = r100;
            return this;
        }

        public Builder withEnableLoadProcessOpt(boolean r100) {
            this.mEnableLoadProcessOpt = r100;
            return this;
        }

        public Builder withEnableModifyRes(boolean r100) {
            this.mEnableModifyRes = r100;
            return this;
        }

        public Builder withEnableNativeClassLoaderOpt(boolean r100) {
            this.mEnableNativeClassLoaderOpt = r100;
            return this;
        }

        public Builder withEnableOptCrc32(boolean r100) {
            this.mEnableCrc32Opt = r100;
            return this;
        }

        public Builder withEnableOptCreateContextImpl(boolean r100) {
            this.mEnableOptCreateContextImpl = r100;
            return this;
        }

        public Builder withEnableOptCreateLoadedApk(boolean r100) {
            this.mEnableOptCreateLoadedApk = r100;
            return this;
        }

        public Builder withEnableOptFindClassDispatch(boolean r100) {
            this.mEnableOptFindClassDispatch = r100;
            return this;
        }

        public Builder withEnableOptIntent(boolean r100) {
            this.mEnableOptIntent = r100;
            return this;
        }

        public Builder withEnableOptMakeApplication(boolean r100) {
            this.mEnableOptMakeApplication = r100;
            return this;
        }

        public Builder withEnableOptNeedLoadPluginCheck(boolean r100) {
            this.mEnableOptNeedLoadPluginCheck = r100;
            return this;
        }

        public Builder withEnableOptRecovery(boolean r100) {
            this.mEnableOptRecovery = r100;
            return this;
        }

        public Builder withEnableOptResourcesArch(boolean r100) {
            this.mEnableOptResourcesArch = r100;
            return this;
        }

        public Builder withEnableReleaseBuildOpt(boolean r100) {
            this.mEnableReleaseBuildOpt = r100;
            return this;
        }

        public Builder withEnableSameToHostSplitPath(boolean r100) {
            this.mEnableSameToHostSplitPath = r100;
            return this;
        }

        public Builder withEnableSkipCheckPermission(Map<String, List<String>> r100) {
            this.mEnableSkipCheckPermission = r100;
            return this;
        }

        public Builder withEnableSoArchUpdate(boolean r100) {
            this.mEnableSoArchUpdate = r100;
            return this;
        }

        public Builder withEnableSpecifiedCert(boolean r100) {
            this.mEnableSpecifiedCert = r100;
            return this;
        }

        public Builder withFastDex2Oat(boolean r100) {
            this.mFastDex2Oat = r100;
            return this;
        }

        public Builder withFastFindOpt(boolean r100) {
            this.mWithFastFindOpt = r100;
            return this;
        }

        public Builder withForceClear(boolean r100) {
            this.mEnableForceClearBuildProduct = r100;
            return this;
        }

        public Builder withHookActivityViewRootImplCallback(Set<String> r100) {
            this.mWithHookActivityViewRootImplCallback = r100;
            return this;
        }

        public Builder withImageOpt(boolean r100) {
            this.mWithImageOpt = r100;
            return this;
        }

        public Builder withInstallThreads(int r100) {
            this.mInstallThreads = r100;
            return this;
        }

        public Builder withKeepExpiredPluginUntilInstallNew(boolean r100) {
            this.mKeepExpiredPluginUntilInstallNew = r100;
            return this;
        }

        public Builder withLoadPluginClassSet(Map<String, String> r100) {
            this.mLoadPluginClass = r100;
            return this;
        }

        public Builder withLoadPluginWaitTimeOut(long r100) {
            this.mLoadPluginWaitTimeOut = r100;
            return this;
        }

        public Builder withLogLevel(int r100) {
            this.mLogLevel = r100;
            return this;
        }

        public Builder withOptPluginPackageNames(Set<String> r100) {
            this.mWithOptPluginPackageNames = r100;
            return this;
        }

        public Builder withRegisterProviderInHost(boolean r100) {
            this.mRegisterProviderInHost = r100;
            return this;
        }

        public Builder withSetEventReport(IMiraEventReport r100) {
            this.mEventReport = r100;
            return this;
        }

        public Builder withShareRes(boolean r100) {
            this.mShareRes = r100;
            return this;
        }

        public Builder withSupportPluginProcName(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L6;
            return this;
        L6:
            if (this.mSupportPluginProcNames.isEmpty() == false) goto L8;
            this.mSupportPluginProcNames = new ArrayList(2);
        L8:
            this.mSupportPluginProcNames.add(r100);
            return this;
        }

        public Builder withSupportRedirectClassMapWhenClassNotFound(Map<String, String> r100) {
            this.mRedirectClassMap = r100;
            return this;
        }

        public Builder withoutHookHostActivityRes(Set<String> r100) {
            this.mWithoutHookActivityRes = r100;
            return this;
        }
    }

    public d getResourceIdVisitor() {
        return null;
    }

    public String toString() {
        return "MiraParam{mEnable=" + this.mEnable + ", mDebug=" + this.mDebug + ", mLogLevel=" + this.mLogLevel + ", mShareRes=" + this.mShareRes + ", mRegisterProviderInHost=" + this.mRegisterProviderInHost + ", mSupportPluginProcNames=" + this.mSupportPluginProcNames + ", mLoadPluginWaitTimeOut=" + this.mLoadPluginWaitTimeOut + ", mClassLoaderHook=" + this.mClassLoaderHook + ", mFastDex2Oat=" + this.mFastDex2Oat + ", mRedirectClassMap=" + this.mRedirectClassMap + ", mWithoutHookActivityRes=" + this.mWithoutHookActivityRes + ", mInstallThreads=" + this.mInstallThreads + ", mEnableDeleteUndeclaredPlugin=" + this.mEnableDeleteUndeclaredPlugin + ", mLoadPluginClass=" + this.mLoadPluginClass + ", mCheckMatchHostAbi=" + this.mCheckMatchHostAbi + ", mEnableSpecifiedCert=" + this.mEnableSpecifiedCert + ", mEnableDeleteNative=" + this.mEnableDeleteNative + ", mCheckMatchHostAbi=" + this.mCheckMatchHostAbi + ", mKeepExpiredPluginUntilInstallNew=" + this.mKeepExpiredPluginUntilInstallNew + ", mWithHookActivityViewRootImplCallback=" + this.mWithHookActivityViewRootImplCallback + ", mOpenResFix=" + this.mOpenResFix + ", mWithImageOpt=" + this.mWithImageOpt + ", mWithFastFindOpt=" + this.mWithFastFindOpt + ", mWithOptPluginPackageNames=" + this.mWithOptPluginPackageNames + ", mEnableForceClearBuildProduct=" + this.mEnableForceClearBuildProduct + ", mEnableDrawableAccessReport=" + this.mEnableDrawableAccessReport + ", mEnableArrayIndexExceptionFix=" + this.mEnableArrayIndexExceptionFix + ", mEnableDeleteNative=" + this.mEnableDeleteNative + ", mEnableOptIntent=" + this.mEnableOptIntent + ", mEnableOptMakeApplication=" + this.mEnableOptMakeApplication + ", mEnableOptCreateContextImpl=" + this.mEnableOptCreateContextImpl + ", mEnableOptCreateLoadedApk=" + this.mEnableOptCreateLoadedApk + ", mEnableNativeClassLoaderOpt=" + this.mEnableNativeClassLoaderOpt + ", mEnableReleaseBuildOpt=" + this.mEnableReleaseBuildOpt + ", mEnableDiffStorageOpt=" + this.mEnableDiffStorageOpt + ", mEnableOptRecovery=" + this.mEnableOptRecovery + ", mEnableOptResourcesArch=" + this.mEnableOptResourcesArch + ", mEnableInstallProcessOpt=" + this.mEnableInstallProcessOpt + ", mEnableLoadProcessOpt=" + this.mEnableLoadProcessOpt + ", mEnableSkipCheckPermission=" + this.mEnableSkipCheckPermission + ", mEventReport=" + this.mEventReport + ", mEnableSameToHostSplitPath=" + this.mEnableSameToHostSplitPath + ", mEnableClassDefOpt=" + this.mEnableClassDefOpt + ", mComponentProtect=" + this.mComponentProtect + ", mEnableOptNeedLoadPluginCheck=" + this.mEnableOptNeedLoadPluginCheck + ", mEnableCrc32Opt=" + this.mEnableCrc32Opt + ", mEnableModifyRes=" + this.mEnableModifyRes + ", mEnableOptFindClassDispatch=" + this.mEnableOptFindClassDispatch + ", mEnableSoArchUpdate=" + this.mEnableSoArchUpdate + '}';
    }

    private MiraParam() {
        this.mInstallThreads = 4;
    }

    public boolean checkMatchHostAbi() {
        return this.mCheckMatchHostAbi;
    }

    public boolean checkSignature() {
        return this.mCheckSignature;
    }

    public boolean classLoaderHook() {
        return this.mClassLoaderHook;
    }

    public boolean enableDeleteNative() {
        return this.mEnableDeleteNative;
    }

    public boolean enableDeleteUndeclaredPlugin() {
        return this.mEnableDeleteUndeclaredPlugin;
    }

    public boolean enableNativeClassLoaderOpt() {
        return this.mEnableNativeClassLoaderOpt;
    }

    public boolean enableOptInstallProcess() {
        return this.mEnableInstallProcessOpt;
    }

    public boolean enableOptIntent() {
        return this.mEnableOptIntent;
    }

    public boolean enableOptLoadProcess() {
        return this.mEnableLoadProcessOpt;
    }

    public boolean enableOptMakeApplication() {
        return this.mEnableOptMakeApplication;
    }

    public boolean enableOptRecovery() {
        return this.mEnableOptRecovery;
    }

    public boolean enableOptResourcesArch() {
        return this.mEnableOptResourcesArch;
    }

    public boolean enableReleaseBuildOpt() {
        return this.mEnableReleaseBuildOpt;
    }

    public boolean enableSameToHostSplitPath() {
        return this.mEnableSameToHostSplitPath;
    }

    public Map<String, List<String>> enableSkipCheckPermission() {
        return this.mEnableSkipCheckPermission;
    }

    public boolean enableSpecifiedCert() {
        return this.mEnableSpecifiedCert;
    }

    public boolean fastDex2Oat() {
        return this.mFastDex2Oat;
    }

    public ComponentProtectManager.IComponentProtect getComponentProtect() {
        return this.mComponentProtect;
    }

    public IMiraEventReport getEventReport() {
        return this.mEventReport;
    }

    public int getInstallThreads() {
        return this.mInstallThreads;
    }

    public Map<String, String> getLoadPluginClass() {
        return this.mLoadPluginClass;
    }

    public long getLoadPluginWaitTimeOut() {
        return this.mLoadPluginWaitTimeOut;
    }

    public int getLogLevel() {
        return this.mLogLevel;
    }

    public Map<String, String> getRedirectClassMap() {
        return this.mRedirectClassMap;
    }

    public List<String> getSupportPluginProcNames() {
        return this.mSupportPluginProcNames;
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public boolean isEnableArrayIndexExceptionFix() {
        return this.mEnableArrayIndexExceptionFix;
    }

    public boolean isEnableClassDefOpt() {
        return this.mEnableClassDefOpt;
    }

    public boolean isEnableDiffStorageOpt() {
        return this.mEnableDiffStorageOpt;
    }

    public boolean isEnableDrawableAccessReport() {
        return this.mEnableDrawableAccessReport;
    }

    public boolean isEnableModifyRes() {
        return this.mEnableModifyRes;
    }

    public boolean isEnableOptCrc32() {
        return this.mEnableCrc32Opt;
    }

    public boolean isEnableOptCreateContextImpl() {
        return this.mEnableOptCreateContextImpl;
    }

    public boolean isEnableOptCreateLoadedApk() {
        return this.mEnableOptCreateLoadedApk;
    }

    public boolean isEnableOptFindClassDispatch() {
        return this.mEnableOptFindClassDispatch;
    }

    public boolean isEnableOptNeedLoadPluginCheck() {
        return this.mEnableOptNeedLoadPluginCheck;
    }

    public boolean isEnableSoArchUpdate() {
        return this.mEnableSoArchUpdate;
    }

    public boolean isOpenMiraOpt() {
        return this.mOpenMiraOpt;
    }

    public boolean isOpenResFix() {
        return this.mOpenResFix;
    }

    public boolean keepExpiredPluginUntilInstallNew() {
        return this.mKeepExpiredPluginUntilInstallNew;
    }

    public boolean shareRes() {
        return this.mShareRes;
    }

    public boolean supportRegisterProviderInHost() {
        return this.mRegisterProviderInHost;
    }

    public boolean withFastFindOpt() {
        return this.mWithFastFindOpt;
    }

    public boolean withForceClear() {
        return this.mEnableForceClearBuildProduct;
    }

    public Set<String> withHookActivityViewRootImplCallback() {
        return this.mWithHookActivityViewRootImplCallback;
    }

    public boolean withImageOpt() {
        return this.mWithImageOpt;
    }

    public Set<String> withOptPlugins() {
        return this.mWithOptPluginPackageNames;
    }

    public Set<String> withoutHookActivityRes() {
        return this.mWithoutHookActivityRes;
    }

    public /* synthetic */ MiraParam(AnonymousClass1 r100) {
        this();
    }

    public boolean isIgnore(String r100) {
        IInternalIgnore r101 = this.internalIgnoreImpl;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.ignore(r100);
    }

    public boolean isInOptPlugins(String r100) {
        Set<String> r101 = this.mWithOptPluginPackageNames;
        if (r101 != null) goto L5;
        return true;
    L5:
        if (r101.isEmpty() == false) goto L8;
        return true;
    L8:
        return this.mWithOptPluginPackageNames.contains(r100);
    }

    public boolean isInSkipWhenPluginInstallDex2Oat(String r100) {
        Set<String> r101 = this.mSkipWhenPluginInstallDex2OatWhitePluginPackageNames;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.isEmpty() == false) goto L8;
        return false;
    L8:
        return this.mSkipWhenPluginInstallDex2OatWhitePluginPackageNames.contains(r100);
    }

    public void setupResFix(boolean r100) {
        this.mOpenResFix = r100;
    }

    public static /* synthetic */ boolean access$1002(MiraParam r100, boolean r101) {
        r100.mCheckSignature = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(MiraParam r100, boolean r101) {
        r100.mEnable = r101;
        return r101;
    }

    public static /* synthetic */ int access$1102(MiraParam r100, int r101) {
        r100.mInstallThreads = r101;
        return r101;
    }

    public static /* synthetic */ long access$1202(MiraParam r100, long r101) {
        r100.mLoadPluginWaitTimeOut = r101;
        return r101;
    }

    public static /* synthetic */ Set access$1302(MiraParam r100, Set r101) {
        r100.mWithoutHookActivityRes = r101;
        return r101;
    }

    public static /* synthetic */ List access$1402(MiraParam r100, List r101) {
        r100.mSupportPluginProcNames = r101;
        return r101;
    }

    public static /* synthetic */ Map access$1502(MiraParam r100, Map r101) {
        r100.mRedirectClassMap = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1602(MiraParam r100, boolean r101) {
        r100.mEnableSpecifiedCert = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1702(MiraParam r100, boolean r101) {
        r100.mEnableDeleteNative = r101;
        return r101;
    }

    public static /* synthetic */ Map access$1802(MiraParam r100, Map r101) {
        r100.mLoadPluginClass = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1902(MiraParam r100, boolean r101) {
        r100.mKeepExpiredPluginUntilInstallNew = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2002(MiraParam r100, boolean r101) {
        r100.mOpenMiraOpt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(MiraParam r100, boolean r101) {
        r100.mDebug = r101;
        return r101;
    }

    public static /* synthetic */ Set access$2102(MiraParam r100, Set r101) {
        r100.mWithHookActivityViewRootImplCallback = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2202(MiraParam r100, boolean r101) {
        r100.mOpenResFix = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2302(MiraParam r100, boolean r101) {
        r100.mWithImageOpt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2402(MiraParam r100, boolean r101) {
        r100.mWithFastFindOpt = r101;
        return r101;
    }

    public static /* synthetic */ Set access$2502(MiraParam r100, Set r101) {
        r100.mWithOptPluginPackageNames = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2602(MiraParam r100, boolean r101) {
        r100.mEnableForceClearBuildProduct = r101;
        return r101;
    }

    public static /* synthetic */ d access$2702(MiraParam r100, d r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ IInternalIgnore access$2802(MiraParam r100, IInternalIgnore r101) {
        r100.internalIgnoreImpl = r101;
        return r101;
    }

    public static /* synthetic */ Set access$2902(MiraParam r100, Set r101) {
        r100.mSkipWhenPluginInstallDex2OatWhitePluginPackageNames = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3002(MiraParam r100, boolean r101) {
        r100.mEnableDrawableAccessReport = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(MiraParam r100, int r101) {
        r100.mLogLevel = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3102(MiraParam r100, boolean r101) {
        r100.mEnableArrayIndexExceptionFix = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3202(MiraParam r100, boolean r101) {
        r100.mEnableOptIntent = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3302(MiraParam r100, boolean r101) {
        r100.mEnableOptMakeApplication = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3402(MiraParam r100, boolean r101) {
        r100.mEnableOptCreateContextImpl = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3502(MiraParam r100, boolean r101) {
        r100.mEnableOptCreateLoadedApk = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3602(MiraParam r100, boolean r101) {
        r100.mEnableNativeClassLoaderOpt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3702(MiraParam r100, boolean r101) {
        r100.mEnableReleaseBuildOpt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3802(MiraParam r100, boolean r101) {
        r100.mEnableDiffStorageOpt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3902(MiraParam r100, boolean r101) {
        r100.mEnableOptRecovery = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4002(MiraParam r100, boolean r101) {
        r100.mEnableOptResourcesArch = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(MiraParam r100, boolean r101) {
        r100.mShareRes = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4102(MiraParam r100, boolean r101) {
        r100.mEnableInstallProcessOpt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4202(MiraParam r100, boolean r101) {
        r100.mEnableLoadProcessOpt = r101;
        return r101;
    }

    public static /* synthetic */ Map access$4302(MiraParam r100, Map r101) {
        r100.mEnableSkipCheckPermission = r101;
        return r101;
    }

    public static /* synthetic */ IMiraEventReport access$4402(MiraParam r100, IMiraEventReport r101) {
        r100.mEventReport = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4502(MiraParam r100, boolean r101) {
        r100.mEnableSameToHostSplitPath = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4602(MiraParam r100, boolean r101) {
        r100.mEnableClassDefOpt = r101;
        return r101;
    }

    public static /* synthetic */ ComponentProtectManager.IComponentProtect access$4702(MiraParam r100, ComponentProtectManager.IComponentProtect r101) {
        r100.mComponentProtect = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4802(MiraParam r100, boolean r101) {
        r100.mEnableOptNeedLoadPluginCheck = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4902(MiraParam r100, boolean r101) {
        r100.mEnableCrc32Opt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$5002(MiraParam r100, boolean r101) {
        r100.mEnableModifyRes = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(MiraParam r100, boolean r101) {
        r100.mClassLoaderHook = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$5102(MiraParam r100, boolean r101) {
        r100.mEnableOptFindClassDispatch = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$5202(MiraParam r100, boolean r101) {
        r100.mEnableSoArchUpdate = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$602(MiraParam r100, boolean r101) {
        r100.mRegisterProviderInHost = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$702(MiraParam r100, boolean r101) {
        r100.mFastDex2Oat = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$802(MiraParam r100, boolean r101) {
        r100.mEnableDeleteUndeclaredPlugin = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$902(MiraParam r100, boolean r101) {
        r100.mCheckMatchHostAbi = r101;
        return r101;
    }
}
