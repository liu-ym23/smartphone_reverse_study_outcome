package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.ICronetEngineBuilder;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class NativeCronetEngineBuilderImpl extends CronetEngineBuilderImpl {
    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public ExperimentalCronetEngine build() {
        if (getUserAgent() != null) goto L5;
        setUserAgent(getDefaultUserAgent());
    L5:
        CronetUrlRequestContext r100 = new CronetUrlRequestContext(this);
        this.mMockCertVerifier = 0;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableVerboseLog() {
        return super.enableVerboseLog();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBoeProxy(boolean r100) {
        return super.enableBoeProxy(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBrotli(boolean r100) {
        return super.enableBrotli(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttp2(boolean r100) {
        return super.enableHttp2(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpDns(boolean r100) {
        return super.enableHttpDns(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableNetworkQualityEstimator(boolean r100) {
        return super.enableNetworkQualityEstimator(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r100) {
        return super.enablePublicKeyPinningBypassForLocalTrustAnchors(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableQuic(boolean r100) {
        return super.enableQuic(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableSdch(boolean r100) {
        return super.enableSdch(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableTncSecureMode(boolean r100) {
        return super.enableTncSecureMode(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder listenAppStateIndependently(boolean r100) {
        return super.listenAppStateIndependently(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setALogFuncAddr(long r100) {
        return super.setALogFuncAddr(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppInfoProvider(TTAppInfoProvider r100) {
        return super.setAppInfoProvider(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppMonitorProvider(TTMonitorProvider r100) {
        return super.setAppMonitorProvider(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppSecurityLevel(int r100) {
        return super.setAppSecurityLevel(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setBypassBOEJSON(String r100) {
        return super.setBypassBOEJSON(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setClientOpaqueData(Map r100) {
        return super.setClientOpaqueData(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setEventListener(TTEventListener r100) {
        return super.setEventListener(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setExperimentalOptions(String r100) {
        return super.setExperimentalOptions(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setGetDomainDefaultJSON(String r100) {
        return super.setGetDomainDefaultJSON(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setIsMainProcess(boolean r100) {
        return super.setIsMainProcess(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLazyInitIPC(boolean r100) {
        return super.setLazyInitIPC(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r100) {
        return super.setLibraryLoader(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOpaqueData(ArrayList r100) {
        return super.setOpaqueData(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOptInit(boolean r100) {
        return super.setOptInit(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setProcessName(String r100) {
        return super.setProcessName(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setProxyConfig(String r100) {
        return super.setProxyConfig(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r100) {
        return super.setSlaSamplingSetting(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoragePath(String r100) {
        return super.setStoragePath(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoreIdcRuleJSON(String r100) {
        return super.setStoreIdcRuleJSON(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r100) {
        return super.setTTAppInfoColdStartSubset(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTTNetInitStart(long r100) {
        return super.setTTNetInitStart(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTelemetryOptionFlags(int r100) {
        return super.setTelemetryOptionFlags(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r100) {
        return super.setThreadConfigCallbackImpl(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadConfigInfoList(ArrayList r100) {
        return super.setThreadConfigInfoList(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadPriority(int r100) {
        return super.setThreadPriority(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setUserAgent(String r100) {
        return super.setUserAgent(r100);
    }

    public NativeCronetEngineBuilderImpl(Context r100, boolean r101) {
        super(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpCache(int r100, long r101) {
        return super.enableHttpCache(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOptNqeInit(boolean r100, boolean r101) {
        return super.setOptNqeInit(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStackInfo(boolean r100, String r101) {
        return super.setStackInfo(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addQuicHint(String r100, int r101, int r102) {
        return super.addQuicHint(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addPublicKeyPins(String r100, Set r101, boolean r102, Date r103) {
        return super.addPublicKeyPins(r100, r101, r102, r103);
    }
}
