package com.ttnet.org.chromium.net;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ICronetEngineBuilder {
    public ICronetEngineBuilder() {
    }

    public abstract ICronetEngineBuilder addPublicKeyPins(String r100, Set<byte[]> r101, boolean r102, Date r103);

    public abstract ICronetEngineBuilder addQuicHint(String r100, int r101, int r102);

    public abstract ExperimentalCronetEngine build();

    public abstract ICronetEngineBuilder enableBoeProxy(boolean r100);

    public ICronetEngineBuilder enableBrotli(boolean r100) {
        return this;
    }

    public abstract ICronetEngineBuilder enableHttp2(boolean r100);

    public abstract ICronetEngineBuilder enableHttpCache(int r100, long r101);

    public abstract ICronetEngineBuilder enableHttpDns(boolean r100);

    public ICronetEngineBuilder enableNetworkQualityEstimator(boolean r100) {
        return this;
    }

    public abstract ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r100);

    public abstract ICronetEngineBuilder enableQuic(boolean r100);

    public abstract ICronetEngineBuilder enableSdch(boolean r100);

    public abstract ICronetEngineBuilder enableTncSecureMode(boolean r100);

    public abstract ICronetEngineBuilder enableVerboseLog();

    public abstract String getDefaultUserAgent();

    public abstract ICronetEngineBuilder listenAppStateIndependently(boolean r100);

    public abstract ICronetEngineBuilder setALogFuncAddr(long r100);

    public abstract ICronetEngineBuilder setAppInfoProvider(TTAppInfoProvider r100);

    public abstract ICronetEngineBuilder setAppMonitorProvider(TTMonitorProvider r100);

    public abstract ICronetEngineBuilder setAppSecurityLevel(int r100);

    public abstract ICronetEngineBuilder setBypassBOEJSON(String r100);

    public abstract ICronetEngineBuilder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r100);

    public abstract ICronetEngineBuilder setCronetSoPath(String r100);

    public abstract ICronetEngineBuilder setEventListener(TTEventListener r100);

    public abstract ICronetEngineBuilder setExperimentalOptions(String r100);

    public abstract ICronetEngineBuilder setGetDomainDefaultJSON(String r100);

    public abstract ICronetEngineBuilder setIsMainProcess(boolean r100);

    public abstract ICronetEngineBuilder setLazyInitIPC(boolean r100);

    public abstract ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r100);

    public abstract ICronetEngineBuilder setOpaqueData(ArrayList<byte[]> r100);

    public abstract ICronetEngineBuilder setOptInit(boolean r100);

    public abstract ICronetEngineBuilder setOptNqeInit(boolean r100, boolean r101);

    public abstract ICronetEngineBuilder setProcessName(String r100);

    public abstract ICronetEngineBuilder setProxyConfig(String r100);

    public abstract ICronetEngineBuilder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r100);

    public abstract ICronetEngineBuilder setStackInfo(boolean r100, String r101);

    public abstract ICronetEngineBuilder setStoragePath(String r100);

    public abstract ICronetEngineBuilder setStoreIdcRuleJSON(String r100);

    public abstract ICronetEngineBuilder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r100);

    public abstract ICronetEngineBuilder setTTNetInitStart(long r100);

    public abstract ICronetEngineBuilder setTelemetryOptionFlags(int r100);

    public abstract ICronetEngineBuilder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r100);

    public abstract ICronetEngineBuilder setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r100);

    public ICronetEngineBuilder setThreadPriority(int r100) {
        return this;
    }

    public abstract ICronetEngineBuilder setUserAgent(String r100);
}
