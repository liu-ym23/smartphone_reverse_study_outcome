package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;

/* JADX INFO: loaded from: classes5.dex */
class CronetUrlRequestContextJni implements CronetUrlRequestContext.Natives {
    public static final JniStaticTestMocker<CronetUrlRequestContext.Natives> TEST_HOOKS = null;
    private static CronetUrlRequestContext.Natives testInstance;

    public CronetUrlRequestContextJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static CronetUrlRequestContext.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetUrlRequestContext.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUrlRequestContextJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public byte[] getHistogramDeltas() {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getHistogramDeltas();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long[] getOpaqueFuncAddress() {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getOpaqueFuncAddress();
    }

    public static /* synthetic */ CronetUrlRequestContext.Natives access$002(CronetUrlRequestContext.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long createRequestContextAdapter(long r100) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextAdapter(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void initALogFuncAddr(long r100) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initALogFuncAddr(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public int setMinLogLevel(int r100) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setMinLogLevel(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void clearClientOpaqueData(long r100, CronetUrlRequestContext r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_clearClientOpaqueData(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void destroy(long r100, CronetUrlRequestContext r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_destroy(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void initRequestContextOnInitThread(long r100, CronetUrlRequestContext r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initRequestContextOnInitThread(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setCookieInitCompleted(long r100, CronetUrlRequestContext r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setCookieInitCompleted(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public boolean skipLogging(long r100, CronetUrlRequestContext r101) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_skipLogging(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void stopNetLog(long r100, CronetUrlRequestContext r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopNetLog(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addSamplingSetting(long r100, CronetUrlRequestContext r101, TTSamplingSettingProvider.TTSlaSamplingSetting r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addSamplingSetting(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void provideRTTObservations(long r100, CronetUrlRequestContext r101, boolean r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideRTTObservations(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void provideThroughputObservations(long r100, CronetUrlRequestContext r101, boolean r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideThroughputObservations(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void removeClientOpaqueData(long r100, CronetUrlRequestContext r101, String r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_removeClientOpaqueData(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void reportNetDiagnosisUserLog(long r100, CronetUrlRequestContext r101, String r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_reportNetDiagnosisUserLog(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void runInBackGround(long r100, CronetUrlRequestContext r101, boolean r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_runInBackGround(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setAlogFuncAddr(long r100, CronetUrlRequestContext r101, long r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAlogFuncAddr(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setAppStartUpState(long r100, CronetUrlRequestContext r101, int r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAppStartUpState(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setHostResolverRules(long r100, CronetUrlRequestContext r101, String r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setHostResolverRules(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setProxy(long r100, CronetUrlRequestContext r101, String r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setProxy(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void triggerTNCRequestByUser(long r100, CronetUrlRequestContext r101, boolean r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_triggerTNCRequestByUser(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addQuicHint(long r100, String r101, int r102, int r103) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addQuicHint(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setClientOpaqueData(long r100, String[] r101, byte[] r102, byte[] r103) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setClientOpaqueData(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setRouteSelectionBestHost(long r100, CronetUrlRequestContext r101, String r102, String r103) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setRouteSelectionBestHost(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public boolean startNetLogToFile(long r100, CronetUrlRequestContext r101, String r102, boolean r103) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToFile(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void stopThrottle(long r100, CronetUrlRequestContext r101, String[] r102, int r103) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopThrottle(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addPkp(long r100, String r101, byte[][] r102, boolean r103, long r104) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addPkp(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void configureNetworkQualityEstimatorForTesting(long r100, CronetUrlRequestContext r101, boolean r102, boolean r103, boolean r104) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_configureNetworkQualityEstimatorForTesting(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void controlHttpDNSConfig(long r100, CronetUrlRequestContext r101, boolean r102, boolean r103, boolean r104) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_controlHttpDNSConfig(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void preconnectUrl(long r100, CronetUrlRequestContext r101, String r102, int r103, String r104) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_preconnectUrl(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void startNetLogToDisk(long r100, CronetUrlRequestContext r101, String r102, boolean r103, int r104) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToDisk(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void startThrottle(long r100, CronetUrlRequestContext r101, String[] r102, int r103, long r104) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startThrottle(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void tryStartNetDetect(long r100, CronetUrlRequestContext r101, String[] r102, int r103, int r104) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_tryStartNetDetect(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void ttUrlDispatch(long r100, CronetUrlRequestContext r101, URLDispatch r102, String r103, boolean r104) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttUrlDispatch(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void ttDnsResolve(long r100, CronetUrlRequestContext r101, String r102, int r103, String r104, String r105) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttDnsResolve(r100, r101, r102, r103, r104, r105);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addClientOpaqueData(long r100, CronetUrlRequestContext r101, String[] r102, byte[] r103, byte[] r104, long r105, long r106) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addClientOpaqueData(r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void enableTTBizHttpDns(long r100, CronetUrlRequestContext r101, boolean r102, String r103, String r104, String r105, boolean r106, String r107) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_enableTTBizHttpDns(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void parseTNCConfigFromSystemHTTPRequest(long r100, CronetUrlRequestContext r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_parseTNCConfigFromSystemHTTPRequest(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setZstdFuncAddr(long r100, CronetUrlRequestContext r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setZstdFuncAddr(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void updateStoreRegionFromServer(long r100, CronetUrlRequestContext r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113, String r114) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_updateStoreRegionFromServer(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long createRequestContextConfig(String r100, String r101, boolean r102, String r103, boolean r104, boolean r105, boolean r106, int r110, long r111, String r112, long r113, boolean r114, boolean r115, int r116) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextConfig(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setTTNetInitConfig(long r100, int r101, boolean r102, boolean r103, String r104, String r105, String r106, boolean r107, String r110, String r111, byte[][] r112, TTThreadConfigInfoProvider.ThreadConfigInfo[] r113, boolean r114, boolean r115, boolean r116, String r117, TTAppInfoProvider.AppInfo r118, long r119, boolean r210, boolean r211, boolean r212, TTSamplingSettingProvider.TTSlaSamplingSetting r213, boolean r214, String r215, int r216) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setTTNetInitConfig(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216);
    }
}
