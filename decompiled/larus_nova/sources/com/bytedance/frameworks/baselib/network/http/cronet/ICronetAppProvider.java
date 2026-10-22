package com.bytedance.frameworks.baselib.network.http.cronet;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ICronetAppProvider {
    void doLoadLibrary(String r100);

    String getAbClient();

    String getAbFeature();

    String getAbFlag();

    List<String> getAbSdkVersion();

    String getAbVersion();

    String getAbi();

    String getAppId();

    TTNetAppInfoSubset getAppInfoSubset();

    String getAppInitialRegionInfo();

    String getAppName();

    long getAppStartTime();

    String getBypassBOEJSON();

    String getCarrierRegion();

    String getChannel();

    String getCityName();

    Map<String[], Pair<byte[], byte[]>> getClientOpaqueData();

    String getCronetSoPath();

    String getDPI();

    String getDeviceBrand();

    String getDeviceId();

    String getDeviceModel();

    String getDevicePlatform();

    String getDeviceType();

    String getGetDomainDefaultJSON();

    Map<String, String> getGetDomainDependHostMap();

    String getHttpDnsRequestFlags();

    String getIId();

    String getIsDropFirstTnc();

    String getLanguage();

    boolean getLazyInitCronetIPC();

    String getManifestVersionCode();

    String getNetAccessType();

    String getNetworkOperator();

    String getOSApi();

    String getOSVersion();

    ArrayList<byte[]> getOpaqueData();

    String getOpenUdid();

    boolean getOptInit();

    boolean getOptNqeDefault();

    boolean getOptNqePersist();

    int getProcessFlag();

    Map<String, Pair<Integer, Integer>> getQuicHint();

    String getRegion();

    String getResolution();

    String getRticket();

    String getSdkAppId();

    String getSdkVersion();

    String getSimOperator();

    String getSsmix();

    String getStoreIdc();

    String getStoreIdcRuleJSON();

    String getSysRegion();

    String getTNCRequestFlags();

    Map<String, String> getTNCRequestHeader();

    Map<String, String> getTNCRequestQuery();

    String getUUID();

    String getUpdateVersionCode();

    String getUserId();

    String getVersionCode();

    String getVersionName();

    int getWifiFrequency();

    int getWifiRssi();

    boolean isBOEProxyEnabled();

    boolean isEnableBrotli();

    boolean isEnableHttp2();

    boolean isEnableQuic();

    boolean needCustomLoadLibrary();

    Map<String, String> onCallToAddSecurityFactor(String r100, Map<String, String> r101);

    void onClientIPChanged(String r100);

    void onColdStartFinish();

    void onCronetBootSucceed();

    void onDropReasonChanged(boolean r100, List<Integer> r101);

    void onEffectiveConnectionTypeChanged(int r100);

    void onEffectiveConnectionTypeChangedOnIOThread(int r100);

    void onMappingRequestStatus(String r100, int r101);

    void onMultiNetworkStateChanged(int r100, int r101);

    void onNetworkQualityLevelChanged(int r100);

    void onNetworkQualityLevelChangedOnIOThread(int r100);

    void onNetworkQualityRttAndThroughputNotified(int r100, int r101, int r102);

    void onNetworkQualityRttAndThroughputNotifiedOnIOThread(int r100, int r101, int r102);

    void onPacketLossComputed(int r100, double r101, double r102, double r103, double r104);

    void onPacketLossComputedOnIOThread(int r100, double r101, double r102, double r103, double r104);

    void onPublicIPsChanged(List<String> r100, List<String> r101);

    void onRTTOrThroughputEstimatesComputed(int r100, int r101, int r102);

    void onRTTOrThroughputEstimatesComputedOnIOThread(int r100, int r101, int r102);

    void onServerConfigABTestChanged(String r100);

    void onServerConfigEtagChanged(String r100);

    void onServerConfigUpdated(String r100);

    void onStoreIdcChanged(String r100, String r101, String r102, String r103, String r104, String r105);

    void onTNCUpdateFailed(ArrayList<String> r100, String r101);

    void onTTDnsResolveResult(String r100, String r101, int r102, int r103, int r104, List<String> r105, String r106);

    void onTTNetDetectInfoChanged(String r100);

    void onTncRequestSucceeded(boolean r100, boolean r101, int r102);

    void onUserSpecifiedNetworkEnabled(boolean r100);

    void onWiFiToCellStateChanged(int r100, int r101);

    void sendAppMonitorEvent(String r100, String r101);
}
