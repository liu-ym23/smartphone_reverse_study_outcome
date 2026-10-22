package com.bytedance.ttnet.cronet;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.sdk.m.k.b;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetAppInfoSubset;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.ttnet.AbsOptionalTTNetDepend;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.AppConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsCronetDependAdapter implements ICronetDepend, ICronetAppProvider {
    private static final int MAX_ABSDK_VERSION_LENGTH = 5;
    private static final String TAG = "AbsCronetDependAdapter";

    public void doLoadLibrary(String r100) {
    }

    public String getAbClient() {
        return "";
    }

    public String getAbFeature() {
        return "";
    }

    public String getAbFlag() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public List<String> getAbSdkVersion() {
        return null;
    }

    public String getAbVersion() {
        return "";
    }

    public String getAppId() {
        return "-1";
    }

    public String getAppInitialRegionInfo() {
        return "";
    }

    public String getAppName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public long getAppStartTime() {
        return -1;
    }

    public String getBypassBOEJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCarrierRegion() {
        return "";
    }

    public String getChannel() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCityName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        return null;
    }

    public String getDeviceId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDevicePlatform() {
        return "android";
    }

    public String getGetDomainDefaultJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getHttpDnsRequestFlags() {
        return "0";
    }

    public String getIId() {
        return "";
    }

    public String getIsDropFirstTnc() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getLanguage() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getLazyInitCronetIPC() {
        return false;
    }

    public String getManifestVersionCode() {
        return "-1";
    }

    public ArrayList<byte[]> getOpaqueData() {
        return null;
    }

    public String getOpenUdid() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptInit() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptNqeDefault() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptNqePersist() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, Pair<Integer, Integer>> getQuicHint() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRegion() {
        return "";
    }

    public String getSdkAppId() {
        return "";
    }

    public String getSdkVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public String getSsCookieKey() {
        return CronetHttpURLConnection.SS_COOKIE;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSsmix() {
        return BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdc() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdcRuleJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSysRegion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getTNCRequestFlags() {
        return "0";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestHeader() {
        return null;
    }

    public String getUUID() {
        return "";
    }

    public String getUpdateVersionCode() {
        return "-1";
    }

    public String getUserId() {
        return "";
    }

    public String getVersionCode() {
        return "-1";
    }

    public String getVersionName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isBOEProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableBrotli() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableHttp2() {
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableQuic() {
        return false;
    }

    public boolean needCustomLoadLibrary() {
        return false;
    }

    public void onCronetMappingRequestStatus(String r100, int r101) {
    }

    public void onEffectiveConnectionTypeChanged(int r100) {
    }

    public void onNQEEffectiveConnectionTypeChanged(int r100) {
    }

    public void onNQEPacketLossComputed(int r100, double r101, double r102, double r103, double r104) {
    }

    public void onNQERTTOrThroughputComputed(int r100, int r101, int r102) {
    }

    public void onNetworkQualityLevelChanged(int r100) {
    }

    public void onNetworkQualityRttAndThroughputNotified(int r100, int r101, int r102) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPacketLossComputed(int r100, double r101, double r102, double r103, double r104) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onRTTOrThroughputEstimatesComputed(int r100, int r101, int r102) {
    }

    public void onTTNetDetectResult(String r100) {
    }

    public void onTTNetworkStateChanged(int r100) {
    }

    public void onWiFiToCellStateChangedForApp(int r100, int r101) {
    }

    public void sendAppMonitorEvent(String r100, String r101) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r100) {
    }

    public final void tryStartTTNetDetect(List<String> r100, int r101, int r102) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbi() {
        return Build.SUPPORTED_ABIS[0];
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public TTNetAppInfoSubset getAppInfoSubset() {
        TTNetAppInfoSubset r100 = new TTNetAppInfoSubset();
        List<String> r101 = getAbSdkVersion();
        String r102 = "";
        if (r101 == null) goto L13;
        Iterator<String> r103 = r101.iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L13;
        String r105 = r103.next();
        r104 = r104 + 1;
        if (r104 > 5) goto L13;
        if (TextUtils.isEmpty(r105) == true) goto L6;
        r102 = r102 + r105 + ",";
    L13:
        r100.mAbSdkVersion = r102;
        String[] r106 = TTNetInit.getTTNetDepend().getConfigServers();
        if (r106 != null) goto L16;
    L24:
        Map<String, String> r107 = TTNetInit.getTTNetDepend().getTTNetServiceDomainMap();
        String r108 = r107.get("httpdns");
        if (r108 != null) goto L27;
    L29:
        String r109 = r107.get("boe");
        if (r109 != null) goto L32;
    L34:
        String r110 = r107.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY);
        if (r110 != null) goto L37;
    L39:
        r100.mInitRegion = getAppInitialRegionInfo();
        return r100;
    L37:
        if (TextUtils.isEmpty(r110) == true) goto L39;
        r100.mDomainBoeHttps = r110;
        goto L39
    L32:
        if (TextUtils.isEmpty(r109) == true) goto L34;
        r100.mDomainBoe = r109;
        goto L34
    L27:
        if (TextUtils.isEmpty(r108) == true) goto L29;
        r100.mDomainHttpDns = r108;
        goto L29
    L16:
        if (r106.length <= 0) goto L19;
        r100.mHostFirst = r106[0];
    L19:
        if (r106.length <= 1) goto L22;
        r100.mHostSecond = r106[1];
    L22:
        if (r106.length <= 2) goto L24;
        r100.mHostThird = r106[2];
        goto L24
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getGetDomainDependHostMap() {
        LinkedHashMap r100 = new LinkedHashMap();
        String[] r101 = TTNetInit.getTTNetDepend().getConfigServers();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L13:
        Map<String, String> r103 = TTNetInit.getTTNetDepend().getTTNetServiceDomainMap();
        if (TextUtils.isEmpty(r103.get("httpdns")) == false) goto L16;
    L19:
        r102 = true;
    L20:
        if (r102 == true) goto L24;
        r100.putAll(r103);
        return r100;
    L24:
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L16:
        if (TextUtils.isEmpty(r103.get("boe")) == false) goto L20;
        if (TextUtils.isEmpty(r103.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY)) == false) goto L20;
    L5:
        if (r101.length <= 0) goto L8;
        r100.put(SoloKtvContext.SOLO_PAGE_FIRST, r101[0]);
    L8:
        if (r101.length <= 1) goto L11;
        r100.put("second", r101[1]);
    L11:
        if (r101.length <= 2) goto L13;
        r100.put(b.f25414o, r101[2]);
        goto L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSApi() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSVersion() {
        String r100 = Build.VERSION.RELEASE;     // Catch: Exception -> L8
        if (r100 != null) goto L5;
        return r100;
    L5:
        if (r100.length() <= 10) goto L13;
        return r100.substring(0, 10);
    L13:
        return r100;
    L8:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final int getProcessFlag() {
        return i.f244792a.get();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCronetSoPath() {
        return AppConfig.getInstance(TTNetInit.getTTNetDepend().getContext()).getCronetSoPath();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDPI() {
        int r100 = UIUtils.getDpi(TTNetInit.getTTNetDepend().getContext());
        if (r100 > 0) goto L5;
        return "";
    L5:
        return String.valueOf(r100);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetAccessType() {
        return NetworkUtils.getNetworkAccessType(TTNetInit.getTTNetDepend().getContext());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetworkOperator() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return "";
    L7:
        return TTNetInit.getSystemApiSandbox().getNetworkOperator();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getResolution() {
        String r100 = UIUtils.getScreenResolution(TTNetInit.getTTNetDepend().getContext());
        if (StringUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRticket() {
        return String.valueOf(System.currentTimeMillis());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSimOperator() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return "";
    L7:
        return TTNetInit.getSystemApiSandbox().getSimOperator();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestQuery() {
        Object r100 = TTNetInit.getTTNetDepend();
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof AbsOptionalTTNetDepend) == true) goto L7;
        return null;
    L7:
        return ((AbsOptionalTTNetDepend) r100).getTNCExtraParam();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public int getWifiFrequency() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return 0;
    L7:
        return TTNetInit.getSystemApiSandbox().getWifiFrequency();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public int getWifiRssi() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return 0;
    L7:
        return TTNetInit.getSystemApiSandbox().getWifiRssi();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        return Logger.debug();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onColdStartFinish() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onColdStartFinish");
    L5:
        new AnonymousClass15(this).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onCronetBootSucceed() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onCronetBootSucceed... ");
    L5:
        new AnonymousClass21(this).start();
    }

    public AbsCronetDependAdapter() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceBrand() {
        return Build.BRAND;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceType() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onClientIPChanged(final String r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onClientIPChanged");
    L5:
        new AnonymousClass16(this, r100).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onEffectiveConnectionTypeChangedOnIOThread(final int r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onEffectiveConnectionTypeChangedOnIOThread type = " + r100);
    L5:
        new AnonymousClass7(this, r100).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onNetworkQualityLevelChangedOnIOThread(final int r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onNetworkQualityLevelChangedOnIOThread nql: " + r100);
    L5:
        new AnonymousClass13(this, r100).start();
    }

    public void onServerConfigABTestChanged(final String r100) {
        new AnonymousClass2(this, r100).start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigEtagChanged(final String r100) {
        new AnonymousClass1(this, r100).start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigUpdated(final String r100) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "config = " + r100);     // Catch: Throwable -> L8
    L6:
        new AnonymousClass3(this, r100).start();     // Catch: Throwable -> L8
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTNetDetectInfoChanged(final String r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onTTNetDetectInfoChanged result = " + r100);
    L5:
        new AnonymousClass5(this, r100).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onUserSpecifiedNetworkEnabled(final boolean r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onUserSpecifiedNetworkEnabled enable = " + r100);
    L5:
        new AnonymousClass12(this, r100).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void loggerD(String r100, String r101) {
        Logger.d(r100, r101);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> onCallToAddSecurityFactor(String r100, Map<String, String> r101) {
        HashMap r102 = new HashMap();
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        Map.Entry<String, String> r104 = r103.next();
        ArrayList r105 = new ArrayList();
        r105.add(r104.getValue());
        r102.put(r104.getKey(), r105);
        goto L4
    L7:
        return NetworkParams.tryAddSecurityFactor(r100, r102);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onDropReasonChanged(final boolean r100, final List<Integer> r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onDropReasonChanged");
    L5:
        new AnonymousClass19(this, r100, r101).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onMappingRequestStatus(final String r100, final int r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onMappingRequestStatus key = " + r100 + " status: " + r101);
    L5:
        new AnonymousClass6(this, r100, r101).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onMultiNetworkStateChanged(final int r100, final int r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onMultiNetStateChanged prev state = " + r100 + ", curr state = " + r101);
    L5:
        new AnonymousClass11(this, r100, r101).start();
    }

    public void onPublicIPsChanged(final List<String> r100, final List<String> r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onPublicIPsChanged");
    L5:
        new AnonymousClass17(this, r100, r101).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTNCUpdateFailed(final ArrayList<String> r100, final String r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onTNCUpdateFailed");
    L5:
        new AnonymousClass20(this, r100, r101).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onWiFiToCellStateChanged(final int r100, final int r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onWiFiToCellStateChanged prev state = " + r100 + ", curr state = " + r101);
    L5:
        new AnonymousClass10(this, r100, r101).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityRttAndThroughputNotifiedOnIOThread(final int r100, final int r101, final int r102) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onNetworkQualityRttAndThroughputNotifiedOnIOThread, effectiveHrttMs: " + r100 + ", effectiveTrttMs: " + r101 + ", effectiveRxThroughputKbps: " + r102);
    L5:
        new AnonymousClass14(this, r100, r101, r102).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onRTTOrThroughputEstimatesComputedOnIOThread(final int r100, final int r101, final int r102) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onRTTOrThroughputEstimatesComputedOnIOThread httpRtt = " + r100 + ", transportRttMs = " + r101 + ",downstreamThroughputKbps = " + r102);
    L5:
        new AnonymousClass8(this, r100, r101, r102).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onTncRequestSucceeded(final boolean r100, final boolean r101, final int r102) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "stackOptEnabled = " + r100);     // Catch: Throwable -> L8
    L6:
        new AnonymousClass22(this, r100, r101, r102).start();     // Catch: Throwable -> L8
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onPacketLossComputedOnIOThread(final int r110, final double r111, final double r112, final double r113, final double r210) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onPacketLossComputed protocol = " + r110 + ", upstreamLossRate = " + r111 + ", upstreamLossRateVariance = " + r112 + ", downstreamLossRate = " + r113 + ", downstreamLossRateVariance = " + r210);
    L6:
        new AnonymousClass9(this, r110, r111, r112, r113, r210).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onStoreIdcChanged(final String r110, final String r111, final String r112, final String r113, final String r114, final String r115) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onStoreIdcChanged");
    L5:
        new AnonymousClass18(this, r110, r111, r112, r113, r114, r115).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTDnsResolveResult(final String r110, final String r111, final int r112, final int r113, final int r114, final List<String> r115, final String r116) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onTTDnsResolveResult uuid = " + r110 + " host = " + r111);
    L6:
        new AnonymousClass4(this, r110, r111, r112, r113, r114, r115, r116).start();
    }
}
