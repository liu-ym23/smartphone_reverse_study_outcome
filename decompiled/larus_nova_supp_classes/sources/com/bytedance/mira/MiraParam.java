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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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

        public Builder setResourceIdVisitor(d r1) {
            return this;
        }

        public Builder withCustomHook(boolean r1) {
            return this;
        }

        public Builder withSupportStandalonePlugin(boolean r1) {
            return this;
        }

        public MiraParam build() {
            MiraParam r0 = new MiraParam(null);
            MiraParam.access$102(r0, this.mEnable);
            MiraParam.access$202(r0, this.mDebug);
            MiraParam.access$302(r0, this.mLogLevel);
            MiraParam.access$402(r0, this.mShareRes);
            MiraParam.access$502(r0, this.mClassLoaderHook);
            MiraParam.access$602(r0, this.mRegisterProviderInHost);
            MiraParam.access$702(r0, this.mFastDex2Oat);
            MiraParam.access$802(r0, this.mEnableDeleteUndeclaredPlugin);
            MiraParam.access$902(r0, this.mCheckMatchHostAbi);
            MiraParam.access$1002(r0, this.mCheckSignature);
            MiraParam.access$1102(r0, this.mInstallThreads);
            MiraParam.access$1202(r0, this.mLoadPluginWaitTimeOut);
            MiraParam.access$1302(r0, this.mWithoutHookActivityRes);
            MiraParam.access$1402(r0, this.mSupportPluginProcNames);
            MiraParam.access$1502(r0, this.mRedirectClassMap);
            MiraParam.access$1602(r0, this.mEnableSpecifiedCert);
            MiraParam.access$1702(r0, this.mEnableDeleteNative);
            MiraParam.access$1802(r0, this.mLoadPluginClass);
            MiraParam.access$1902(r0, this.mKeepExpiredPluginUntilInstallNew);
            MiraParam.access$2002(r0, this.mOpenMiraOpt);
            MiraParam.access$2102(r0, this.mWithHookActivityViewRootImplCallback);
            MiraParam.access$2202(r0, this.mOpenResFix);
            MiraParam.access$2302(r0, this.mWithImageOpt);
            MiraParam.access$2402(r0, this.mWithFastFindOpt);
            MiraParam.access$2502(r0, this.mWithOptPluginPackageNames);
            MiraParam.access$2602(r0, this.mEnableForceClearBuildProduct);
            MiraParam.access$2702(r0, null);
            MiraParam.access$2802(r0, this.internalIgnoreImpl);
            MiraParam.access$2902(r0, this.mSkipWhenPluginInstallDex2OatWhitePluginPackageNames);
            MiraParam.access$3002(r0, this.mEnableDrawableAccessReport);
            MiraParam.access$3102(r0, this.mEnableArrayIndexExceptionFix);
            MiraParam.access$3202(r0, this.mEnableOptIntent);
            MiraParam.access$3302(r0, this.mEnableOptMakeApplication);
            MiraParam.access$3402(r0, this.mEnableOptCreateContextImpl);
            MiraParam.access$3502(r0, this.mEnableOptCreateLoadedApk);
            MiraParam.access$3602(r0, this.mEnableNativeClassLoaderOpt);
            MiraParam.access$3702(r0, this.mEnableReleaseBuildOpt);
            MiraParam.access$3802(r0, this.mEnableDiffStorageOpt);
            MiraParam.access$3902(r0, this.mEnableOptRecovery);
            MiraParam.access$4002(r0, this.mEnableOptResourcesArch);
            MiraParam.access$4102(r0, this.mEnableInstallProcessOpt);
            MiraParam.access$4202(r0, this.mEnableLoadProcessOpt);
            MiraParam.access$4302(r0, this.mEnableSkipCheckPermission);
            MiraParam.access$4402(r0, this.mEventReport);
            MiraParam.access$4502(r0, this.mEnableSameToHostSplitPath);
            MiraParam.access$4602(r0, this.mEnableClassDefOpt);
            MiraParam.access$4702(r0, this.mComponentProtect);
            MiraParam.access$4802(r0, this.mEnableOptNeedLoadPluginCheck);
            MiraParam.access$4902(r0, this.mEnableCrc32Opt);
            MiraParam.access$5002(r0, this.mEnableModifyRes);
            MiraParam.access$5102(r0, this.mEnableOptFindClassDispatch);
            MiraParam.access$5202(r0, this.mEnableSoArchUpdate);
            return r0;
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

        public Builder openMiraOpt(boolean r1) {
            this.mOpenMiraOpt = r1;
            return this;
        }

        public Builder setupInternalIgnoreImpl(IInternalIgnore r1) {
            this.internalIgnoreImpl = r1;
            return this;
        }

        public Builder setupResFix(boolean r1) {
            this.mOpenResFix = r1;
            return this;
        }

        public Builder skipWhenPluginInstallDex2OatWhitePluginPackageNames(Set<String> r1) {
            this.mSkipWhenPluginInstallDex2OatWhitePluginPackageNames = r1;
            return this;
        }

        public Builder withCheckMatchHostAbiByInstall(boolean r1) {
            this.mCheckMatchHostAbi = r1;
            return this;
        }

        public Builder withCheckSignatureByInstall(boolean r1) {
            this.mCheckSignature = r1;
            return this;
        }

        public Builder withClassLoaderHook(boolean r1) {
            this.mClassLoaderHook = r1;
            return this;
        }

        public Builder withComponentProtect(ComponentProtectManager.IComponentProtect r1) {
            this.mComponentProtect = r1;
            return this;
        }

        public Builder withDebug(boolean r1) {
            this.mDebug = r1;
            return this;
        }

        public Builder withEnable(boolean r1) {
            this.mEnable = r1;
            return this;
        }

        public Builder withEnableArrayIndexExceptionFix(boolean r1) {
            this.mEnableArrayIndexExceptionFix = r1;
            return this;
        }

        public Builder withEnableClassDefOpt(boolean r1) {
            this.mEnableClassDefOpt = r1;
            return this;
        }

        public Builder withEnableDeleteNative(boolean r1) {
            this.mEnableDeleteNative = r1;
            return this;
        }

        public Builder withEnableDeleteUndeclaredPlugin(boolean r1) {
            this.mEnableDeleteUndeclaredPlugin = r1;
            return this;
        }

        public Builder withEnableDiffStorageOpt(boolean r1) {
            this.mEnableDiffStorageOpt = r1;
            return this;
        }

        public Builder withEnableDrawableAccessReport(boolean r1) {
            this.mEnableDrawableAccessReport = r1;
            return this;
        }

        public Builder withEnableInstallProcessOpt(boolean r1) {
            this.mEnableInstallProcessOpt = r1;
            return this;
        }

        public Builder withEnableLoadProcessOpt(boolean r1) {
            this.mEnableLoadProcessOpt = r1;
            return this;
        }

        public Builder withEnableModifyRes(boolean r1) {
            this.mEnableModifyRes = r1;
            return this;
        }

        public Builder withEnableNativeClassLoaderOpt(boolean r1) {
            this.mEnableNativeClassLoaderOpt = r1;
            return this;
        }

        public Builder withEnableOptCrc32(boolean r1) {
            this.mEnableCrc32Opt = r1;
            return this;
        }

        public Builder withEnableOptCreateContextImpl(boolean r1) {
            this.mEnableOptCreateContextImpl = r1;
            return this;
        }

        public Builder withEnableOptCreateLoadedApk(boolean r1) {
            this.mEnableOptCreateLoadedApk = r1;
            return this;
        }

        public Builder withEnableOptFindClassDispatch(boolean r1) {
            this.mEnableOptFindClassDispatch = r1;
            return this;
        }

        public Builder withEnableOptIntent(boolean r1) {
            this.mEnableOptIntent = r1;
            return this;
        }

        public Builder withEnableOptMakeApplication(boolean r1) {
            this.mEnableOptMakeApplication = r1;
            return this;
        }

        public Builder withEnableOptNeedLoadPluginCheck(boolean r1) {
            this.mEnableOptNeedLoadPluginCheck = r1;
            return this;
        }

        public Builder withEnableOptRecovery(boolean r1) {
            this.mEnableOptRecovery = r1;
            return this;
        }

        public Builder withEnableOptResourcesArch(boolean r1) {
            this.mEnableOptResourcesArch = r1;
            return this;
        }

        public Builder withEnableReleaseBuildOpt(boolean r1) {
            this.mEnableReleaseBuildOpt = r1;
            return this;
        }

        public Builder withEnableSameToHostSplitPath(boolean r1) {
            this.mEnableSameToHostSplitPath = r1;
            return this;
        }

        public Builder withEnableSkipCheckPermission(Map<String, List<String>> r1) {
            this.mEnableSkipCheckPermission = r1;
            return this;
        }

        public Builder withEnableSoArchUpdate(boolean r1) {
            this.mEnableSoArchUpdate = r1;
            return this;
        }

        public Builder withEnableSpecifiedCert(boolean r1) {
            this.mEnableSpecifiedCert = r1;
            return this;
        }

        public Builder withFastDex2Oat(boolean r1) {
            this.mFastDex2Oat = r1;
            return this;
        }

        public Builder withFastFindOpt(boolean r1) {
            this.mWithFastFindOpt = r1;
            return this;
        }

        public Builder withForceClear(boolean r1) {
            this.mEnableForceClearBuildProduct = r1;
            return this;
        }

        public Builder withHookActivityViewRootImplCallback(Set<String> r1) {
            this.mWithHookActivityViewRootImplCallback = r1;
            return this;
        }

        public Builder withImageOpt(boolean r1) {
            this.mWithImageOpt = r1;
            return this;
        }

        public Builder withInstallThreads(int r1) {
            this.mInstallThreads = r1;
            return this;
        }

        public Builder withKeepExpiredPluginUntilInstallNew(boolean r1) {
            this.mKeepExpiredPluginUntilInstallNew = r1;
            return this;
        }

        public Builder withLoadPluginClassSet(Map<String, String> r1) {
            this.mLoadPluginClass = r1;
            return this;
        }

        public Builder withLoadPluginWaitTimeOut(long r1) {
            this.mLoadPluginWaitTimeOut = r1;
            return this;
        }

        public Builder withLogLevel(int r1) {
            this.mLogLevel = r1;
            return this;
        }

        public Builder withOptPluginPackageNames(Set<String> r1) {
            this.mWithOptPluginPackageNames = r1;
            return this;
        }

        public Builder withRegisterProviderInHost(boolean r1) {
            this.mRegisterProviderInHost = r1;
            return this;
        }

        public Builder withSetEventReport(IMiraEventReport r1) {
            this.mEventReport = r1;
            return this;
        }

        public Builder withShareRes(boolean r1) {
            this.mShareRes = r1;
            return this;
        }

        public Builder withSupportPluginProcName(String r3) {
            if (TextUtils.isEmpty(r3) == false) goto L6;
            return this;
        L6:
            if (this.mSupportPluginProcNames.isEmpty() == false) goto L8;
            this.mSupportPluginProcNames = new ArrayList(2);
        L8:
            this.mSupportPluginProcNames.add(r3);
            return this;
        }

        public Builder withSupportRedirectClassMapWhenClassNotFound(Map<String, String> r1) {
            this.mRedirectClassMap = r1;
            return this;
        }

        public Builder withoutHookHostActivityRes(Set<String> r1) {
            this.mWithoutHookActivityRes = r1;
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

    public /* synthetic */ MiraParam(1 r1) {
        this();
    }

    public boolean isIgnore(String r2) {
        IInternalIgnore r0 = this.internalIgnoreImpl;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.ignore(r2);
    }

    public boolean isInOptPlugins(String r2) {
        Set<String> r0 = this.mWithOptPluginPackageNames;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return true;
    L8:
        return this.mWithOptPluginPackageNames.contains(r2);
    }

    public boolean isInSkipWhenPluginInstallDex2Oat(String r2) {
        Set<String> r0 = this.mSkipWhenPluginInstallDex2OatWhitePluginPackageNames;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return false;
    L8:
        return this.mSkipWhenPluginInstallDex2OatWhitePluginPackageNames.contains(r2);
    }

    public void setupResFix(boolean r1) {
        this.mOpenResFix = r1;
    }

    public static /* synthetic */ boolean access$1002(MiraParam r0, boolean r1) {
        r0.mCheckSignature = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$102(MiraParam r0, boolean r1) {
        r0.mEnable = r1;
        return r1;
    }

    public static /* synthetic */ int access$1102(MiraParam r0, int r1) {
        r0.mInstallThreads = r1;
        return r1;
    }

    public static /* synthetic */ long access$1202(MiraParam r0, long r1) {
        r0.mLoadPluginWaitTimeOut = r1;
        return r1;
    }

    public static /* synthetic */ Set access$1302(MiraParam r0, Set r1) {
        r0.mWithoutHookActivityRes = r1;
        return r1;
    }

    public static /* synthetic */ List access$1402(MiraParam r0, List r1) {
        r0.mSupportPluginProcNames = r1;
        return r1;
    }

    public static /* synthetic */ Map access$1502(MiraParam r0, Map r1) {
        r0.mRedirectClassMap = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1602(MiraParam r0, boolean r1) {
        r0.mEnableSpecifiedCert = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1702(MiraParam r0, boolean r1) {
        r0.mEnableDeleteNative = r1;
        return r1;
    }

    public static /* synthetic */ Map access$1802(MiraParam r0, Map r1) {
        r0.mLoadPluginClass = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1902(MiraParam r0, boolean r1) {
        r0.mKeepExpiredPluginUntilInstallNew = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2002(MiraParam r0, boolean r1) {
        r0.mOpenMiraOpt = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$202(MiraParam r0, boolean r1) {
        r0.mDebug = r1;
        return r1;
    }

    public static /* synthetic */ Set access$2102(MiraParam r0, Set r1) {
        r0.mWithHookActivityViewRootImplCallback = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2202(MiraParam r0, boolean r1) {
        r0.mOpenResFix = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2302(MiraParam r0, boolean r1) {
        r0.mWithImageOpt = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2402(MiraParam r0, boolean r1) {
        r0.mWithFastFindOpt = r1;
        return r1;
    }

    public static /* synthetic */ Set access$2502(MiraParam r0, Set r1) {
        r0.mWithOptPluginPackageNames = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2602(MiraParam r0, boolean r1) {
        r0.mEnableForceClearBuildProduct = r1;
        return r1;
    }

    public static /* synthetic */ d access$2702(MiraParam r0, d r1) {
        r0.getClass();
        return r1;
    }

    public static /* synthetic */ IInternalIgnore access$2802(MiraParam r0, IInternalIgnore r1) {
        r0.internalIgnoreImpl = r1;
        return r1;
    }

    public static /* synthetic */ Set access$2902(MiraParam r0, Set r1) {
        r0.mSkipWhenPluginInstallDex2OatWhitePluginPackageNames = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3002(MiraParam r0, boolean r1) {
        r0.mEnableDrawableAccessReport = r1;
        return r1;
    }

    public static /* synthetic */ int access$302(MiraParam r0, int r1) {
        r0.mLogLevel = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3102(MiraParam r0, boolean r1) {
        r0.mEnableArrayIndexExceptionFix = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3202(MiraParam r0, boolean r1) {
        r0.mEnableOptIntent = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3302(MiraParam r0, boolean r1) {
        r0.mEnableOptMakeApplication = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3402(MiraParam r0, boolean r1) {
        r0.mEnableOptCreateContextImpl = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3502(MiraParam r0, boolean r1) {
        r0.mEnableOptCreateLoadedApk = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3602(MiraParam r0, boolean r1) {
        r0.mEnableNativeClassLoaderOpt = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3702(MiraParam r0, boolean r1) {
        r0.mEnableReleaseBuildOpt = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3802(MiraParam r0, boolean r1) {
        r0.mEnableDiffStorageOpt = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3902(MiraParam r0, boolean r1) {
        r0.mEnableOptRecovery = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$4002(MiraParam r0, boolean r1) {
        r0.mEnableOptResourcesArch = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$402(MiraParam r0, boolean r1) {
        r0.mShareRes = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$4102(MiraParam r0, boolean r1) {
        r0.mEnableInstallProcessOpt = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$4202(MiraParam r0, boolean r1) {
        r0.mEnableLoadProcessOpt = r1;
        return r1;
    }

    public static /* synthetic */ Map access$4302(MiraParam r0, Map r1) {
        r0.mEnableSkipCheckPermission = r1;
        return r1;
    }

    public static /* synthetic */ IMiraEventReport access$4402(MiraParam r0, IMiraEventReport r1) {
        r0.mEventReport = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$4502(MiraParam r0, boolean r1) {
        r0.mEnableSameToHostSplitPath = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$4602(MiraParam r0, boolean r1) {
        r0.mEnableClassDefOpt = r1;
        return r1;
    }

    public static /* synthetic */ ComponentProtectManager.IComponentProtect access$4702(MiraParam r0, ComponentProtectManager.IComponentProtect r1) {
        r0.mComponentProtect = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$4802(MiraParam r0, boolean r1) {
        r0.mEnableOptNeedLoadPluginCheck = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$4902(MiraParam r0, boolean r1) {
        r0.mEnableCrc32Opt = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$5002(MiraParam r0, boolean r1) {
        r0.mEnableModifyRes = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$502(MiraParam r0, boolean r1) {
        r0.mClassLoaderHook = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$5102(MiraParam r0, boolean r1) {
        r0.mEnableOptFindClassDispatch = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$5202(MiraParam r0, boolean r1) {
        r0.mEnableSoArchUpdate = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$602(MiraParam r0, boolean r1) {
        r0.mRegisterProviderInHost = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$702(MiraParam r0, boolean r1) {
        r0.mFastDex2Oat = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$802(MiraParam r0, boolean r1) {
        r0.mEnableDeleteUndeclaredPlugin = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$902(MiraParam r0, boolean r1) {
        r0.mCheckMatchHostAbi = r1;
        return r1;
    }
}
