package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Pair;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExperimentalCronetEngine extends CronetEngine {
    public static final int CONNECTION_METRIC_UNKNOWN = -1;
    public static final int EFFECTIVE_CONNECTION_TYPE_2G = 3;
    public static final int EFFECTIVE_CONNECTION_TYPE_3G = 4;
    public static final int EFFECTIVE_CONNECTION_TYPE_4G = 5;
    public static final int EFFECTIVE_CONNECTION_TYPE_OFFLINE = 1;
    public static final int EFFECTIVE_CONNECTION_TYPE_SLOW_2G = 2;
    public static final int EFFECTIVE_CONNECTION_TYPE_UNKNOWN = 0;
    public static final int PACKET_LOSS_PROTOCOL_QUIC = 1;
    public static final int PACKET_LOSS_PROTOCOL_TCP = 0;
    public static final long UNBIND_NETWORK_HANDLE = -1;

    public static class Builder extends CronetEngine.Builder {
        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableSdch(boolean r100) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public ExperimentalCronetEngine build() {
            return this.mBuilderDelegate.build();
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableVerboseLog() {
            return enableVerboseLog();
        }

        public ICronetEngineBuilder getBuilderDelegate() {
            return this.mBuilderDelegate;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine build() {
            return build();
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableVerboseLog() {
            super.enableVerboseLog();
            return this;
        }

        public Builder(ICronetEngineBuilder r100) {
            super(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableBoeProxy(boolean r100) {
            return enableBoeProxy(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttp2(boolean r100) {
            return enableHttp2(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttpDns(boolean r100) {
            return enableHttpDns(r100);
        }

        public Builder enableNetworkQualityEstimator(boolean r100) {
            this.mBuilderDelegate.enableNetworkQualityEstimator(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r100) {
            return enablePublicKeyPinningBypassForLocalTrustAnchors(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableQuic(boolean r100) {
            return enableQuic(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableSdch(boolean r100) {
            return enableSdch(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableTncSecureMode(boolean r100) {
            return enableTncSecureMode(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder listenAppStateIndependently(boolean r100) {
            return listenAppStateIndependently(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setALogFuncAddr(long r100) {
            return setALogFuncAddr(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setAppInfoProvider(TTAppInfoProvider r100) {
            return setAppInfoProvider(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setAppMonitorProvider(TTMonitorProvider r100) {
            return setAppMonitorProvider(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setAppSecurityLevel(int r100) {
            return setAppSecurityLevel(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setBypassBOEJSON(String r100) {
            return setBypassBOEJSON(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setClientOpaqueData(Map r100) {
            return setClientOpaqueData(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setEventListener(TTEventListener r100) {
            return setEventListener(r100);
        }

        public Builder setExperimentalOptions(String r100) {
            this.mBuilderDelegate.setExperimentalOptions(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setGetDomainDefaultJSON(String r100) {
            return setGetDomainDefaultJSON(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setIsMainProcess(boolean r100) {
            return setIsMainProcess(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setLazyInitIPC(boolean r100) {
            return setLazyInitIPC(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setLibraryLoader(CronetEngine.Builder.LibraryLoader r100) {
            return setLibraryLoader(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setOpaqueData(ArrayList r100) {
            return setOpaqueData(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setOptInit(boolean r100) {
            return setOptInit(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setProcessName(String r100) {
            return setProcessName(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setProxyConfig(String r100) {
            return setProxyConfig(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r100) {
            return setSlaSamplingSetting(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setStoragePath(String r100) {
            return setStoragePath(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setStoreIdcRuleJSON(String r100) {
            return setStoreIdcRuleJSON(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r100) {
            return setTTAppInfoColdStartSubset(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setTTNetInitStart(long r100) {
            return setTTNetInitStart(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setTelemetryOptionFlags(int r100) {
            return setTelemetryOptionFlags(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r100) {
            return setThreadConfigCallbackImpl(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setThreadConfigInfoList(ArrayList r100) {
            return setThreadConfigInfoList(r100);
        }

        public Builder setThreadPriority(int r100) {
            this.mBuilderDelegate.setThreadPriority(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setUserAgent(String r100) {
            return setUserAgent(r100);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableBoeProxy(boolean r100) {
            super.enableBoeProxy(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttp2(boolean r100) {
            super.enableHttp2(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttpDns(boolean r100) {
            super.enableHttpDns(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r100) {
            super.enablePublicKeyPinningBypassForLocalTrustAnchors(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableQuic(boolean r100) {
            super.enableQuic(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableTncSecureMode(boolean r100) {
            super.enableTncSecureMode(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder listenAppStateIndependently(boolean r100) {
            super.listenAppStateIndependently(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setALogFuncAddr(long r100) {
            super.setALogFuncAddr(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setAppInfoProvider(TTAppInfoProvider r100) {
            super.setAppInfoProvider(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setAppMonitorProvider(TTMonitorProvider r100) {
            super.setAppMonitorProvider(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setAppSecurityLevel(int r100) {
            super.setAppSecurityLevel(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setBypassBOEJSON(String r100) {
            super.setBypassBOEJSON(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r100) {
            super.setClientOpaqueData(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setEventListener(TTEventListener r100) {
            super.setEventListener(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setGetDomainDefaultJSON(String r100) {
            super.setGetDomainDefaultJSON(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setIsMainProcess(boolean r100) {
            super.setIsMainProcess(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setLazyInitIPC(boolean r100) {
            super.setLazyInitIPC(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setLibraryLoader(CronetEngine.Builder.LibraryLoader r100) {
            super.setLibraryLoader(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setOpaqueData(ArrayList<byte[]> r100) {
            super.setOpaqueData(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setOptInit(boolean r100) {
            super.setOptInit(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setProcessName(String r100) {
            super.setProcessName(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setProxyConfig(String r100) {
            super.setProxyConfig(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r100) {
            super.setSlaSamplingSetting(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setStoragePath(String r100) {
            super.setStoragePath(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setStoreIdcRuleJSON(String r100) {
            super.setStoreIdcRuleJSON(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r100) {
            super.setTTAppInfoColdStartSubset(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setTTNetInitStart(long r100) {
            super.setTTNetInitStart(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setTelemetryOptionFlags(int r100) {
            super.setTelemetryOptionFlags(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r100) {
            super.setThreadConfigCallbackImpl(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r100) {
            super.setThreadConfigInfoList(r100);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setUserAgent(String r100) {
            super.setUserAgent(r100);
            return this;
        }

        public Builder(Context r100, boolean r101) {
            super(r100, r101);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttpCache(int r100, long r101) {
            return enableHttpCache(r100, r101);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setOptNqeInit(boolean r100, boolean r101) {
            return setOptNqeInit(r100, r101);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setStackInfo(boolean r100, String r101) {
            return setStackInfo(r100, r101);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttpCache(int r100, long r101) {
            super.enableHttpCache(r100, r101);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setOptNqeInit(boolean r100, boolean r101) {
            super.setOptNqeInit(r100, r101);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setStackInfo(boolean r100, String r101) {
            super.setStackInfo(r100, r101);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder addQuicHint(String r100, int r101, int r102) {
            return addQuicHint(r100, r101, r102);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder addQuicHint(String r100, int r101, int r102) {
            super.addQuicHint(r100, r101, r102);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder addPublicKeyPins(String r100, Set r101, boolean r102, Date r103) {
            return addPublicKeyPins(r100, r101, r102, r103);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder addPublicKeyPins(String r100, Set<byte[]> r101, boolean r102, Date r103) {
            super.addPublicKeyPins(r100, r101, r102, r103);
            return this;
        }
    }

    public void addClientOpaqueData(String[] r100, byte[] r101, byte[] r102, long r103, long r104) {
    }

    public void addRequestFinishedListener(RequestFinishedInfo.Listener r100) {
    }

    public void addRttListener(NetworkQualityRttListener r100) {
    }

    public void addSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r100) {
    }

    public void addThroughputListener(NetworkQualityThroughputListener r100) {
    }

    public void bindBigCore(int r100) {
    }

    public void bindLittleCore(int r100) {
    }

    public void bindToNetwork(long r100) {
    }

    public void clearClientOpaqueData() {
    }

    public void configureNetworkQualityEstimatorForTesting(boolean r100, boolean r101, boolean r102) {
    }

    public void enableTTBizHttpDns(boolean r100, String r101, String r102, String r103, boolean r104, String r105) {
    }

    public double getDownstreamPacketLossRate(int r100) {
        return -1.0d;
    }

    public double getDownstreamPacketLossRateVariance(int r100) {
        return -1.0d;
    }

    public int getDownstreamThroughputKbps() {
        return -1;
    }

    public int getEffectiveConnectionType() {
        return 0;
    }

    public int getEffectiveHttpRtt() {
        return -1;
    }

    public int getEffectiveRxThroughput() {
        return -1;
    }

    public int getEffectiveTransportRtt() {
        return -1;
    }

    public int getHttpRttMs() {
        return -1;
    }

    public int getNetworkQualityLevel() {
        return 0;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public List<Long> getOpaqueFuncAddress() {
        return null;
    }

    public int getTransportRttMs() {
        return -1;
    }

    public double getUpstreamPacketLossRate(int r100) {
        return -1.0d;
    }

    public double getUpstreamPacketLossRateVariance(int r100) {
        return -1.0d;
    }

    public abstract ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String r100, BidirectionalStream.Callback r101, Executor r102);

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public abstract ExperimentalUrlRequest.Builder newUrlRequestBuilder(String r100, UrlRequest.Callback r101, Executor r102);

    public void notifyTNCConfigUpdated(String r100, String r101, String r102, String r103, String r104, String r105) {
    }

    public void preconnectUrl(String r100, int r101, Map<String, String> r102) {
    }

    public void registerAppInfoProvider(TTAppInfoProvider r100) {
    }

    public void registerAppMonitorProvider(TTMonitorProvider r100) {
    }

    public void registerEventListener(TTEventListener r100) {
    }

    public void removeClientOpaqueData(String r100) {
    }

    public void removeRequestFinishedListener(RequestFinishedInfo.Listener r100) {
    }

    public void removeRttListener(NetworkQualityRttListener r100) {
    }

    public void removeThroughputListener(NetworkQualityThroughputListener r100) {
    }

    public void reportNetDiagnosisUserLog(String r100) {
    }

    public void resetCoreBind(int r100) {
    }

    public void runInBackGround(boolean r100) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setAlogFuncAddr(long r100) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setAppStartUpState(int r100) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setCookieInitCompleted() {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setHostResolverRules(String r100) {
    }

    public void setHttpDnsForTesting(boolean r100, boolean r101, boolean r102) {
    }

    public void setProxy(String r100) {
    }

    public void setRouteSelectionBestHost(String r100, String r101) {
    }

    public void setZstdFuncAddr(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112) {
    }

    public void startNetLogToDisk(String r100, boolean r101, int r102) {
    }

    public void startThrottle(String[] r100, int r101, long r102) {
    }

    public void stopThrottle(String[] r100, int r101) {
    }

    public void triggerGetDomain(boolean r100) {
    }

    public void tryStartNetDetect(String[] r100, int r101, int r102) {
    }

    public void ttDnsResolve(String r100, int r101, String r102, Map<String, String> r103) {
    }

    public Map<String, String> ttUrlDispatch(String r100, int r101, boolean r102) throws IOException {
        return null;
    }

    public void updateStoreRegionFromServer(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111) {
    }

    public Map<String, int[]> getGroupRttEstimates() {
        return new HashMap();
    }

    public ExperimentalCronetEngine() {
    }

    public URLConnection openConnection(URL r100, Proxy r101) throws IOException {
        return r100.openConnection(r101);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r100, UrlRequest.Callback r101, Executor r102) {
        return newUrlRequestBuilder(r100, r101, r102);
    }
}
