package com.ttnet.org.chromium.base.natives;

import J.N;

/* JADX INFO: loaded from: classes5.dex */
public class GEN_JNI {
    public static final boolean REQUIRE_MOCK = false;
    public static final boolean TESTING_ENABLED = false;

    public GEN_JNI() {
    }

    public static String[] com_ttnet_org_chromium_base_CommandLine_getSwitchesFlattened() {
        return N.MahsXrQs();
    }

    public static int com_ttnet_org_chromium_base_CpuFeatures_getCoreCount() {
        return N.Mcaj_8qf();
    }

    public static long com_ttnet_org_chromium_base_CpuFeatures_getCpuFeatures() {
        return N.M1UV95tj();
    }

    public static boolean com_ttnet_org_chromium_base_FeatureList_isInitialized() {
        return N.Md1lGM43();
    }

    public static boolean com_ttnet_org_chromium_base_TraceEvent_viewHierarchyDumpEnabled() {
        return N.MpI7Xy5x();
    }

    public static int com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_percentageOfResidentNativeLibraryCode() {
        return N.MA6QAXj_();
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_createHistogramSnapshotForTesting() {
        return N.M_034fMZ_ForTesting();
    }

    public static boolean com_ttnet_org_chromium_net_TTAppSecurityManager_isTTPRestrictionEnabled() {
        return N.Mhd7DRFo();
    }

    public static boolean com_ttnet_org_chromium_net_TTAppSecurityManager_isUserPrivacyRestrictionEnabled() {
        return N.MaSRwBiO();
    }

    public static String com_ttnet_org_chromium_net_impl_CronetLibraryLoader_getCronetVersion() {
        return N.MVlvYo_c();
    }

    public static byte[] com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getHistogramDeltas() {
        return N.MdOiNSC0();
    }

    public static long[] com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getOpaqueFuncAddress() {
        return N.MlOQJZ8w();
    }

    public static void com_ttnet_org_chromium_base_FieldTrialList_logActiveTrials() {
        N.M2n_z3BB();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onBatteryChargingChanged() {
        N.MxETr4iO();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onInstantResume() {
        N.MELAwTDU();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onInstantSuspend() {
        N.MolcG1Wq();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onResume() {
        N.MyS7kauI();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onSuspend() {
        N.MBffe1lF();
    }

    public static void com_ttnet_org_chromium_base_SysUtils_logPageFaultCountToTracing() {
        N.Mm3sCch3();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_initViewHierarchyDump() {
        N.MgOuiubc();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_registerEnabledObserver() {
        N.M8F7L$JR();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_stopATrace() {
        N.MTnadCLu();
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryLoader_registerNonMainDexJni() {
        N.MU8nwPRG();
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_forkAndPrefetchNativeLibrary() {
        N.MVIMN27T();
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_periodicallyCollectResidency() {
        N.MtuV2SWL();
    }

    public static void com_ttnet_org_chromium_net_X509Util_notifyKeyChainChanged() {
        N.MzV1TXLS();
    }

    public static void com_ttnet_org_chromium_net_impl_CronetLibraryLoader_createNetworkChangeNotifierOnInitThread() {
        N.MhrJ$_b0();
    }

    public static void com_ttnet_org_chromium_net_impl_CronetLibraryLoader_cronetInitOnInitThread() {
        N.MyweRqSS();
    }

    public static void com_ttnet_org_chromium_base_ApplicationStatus_onApplicationStateChange(int r100) {
        N.M$lotPPc(r100);
    }

    public static boolean com_ttnet_org_chromium_base_BaseFeatureList_isEnabled(String r100) {
        return N.Mtllg_IO(r100);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitch(String r100) {
        N.MawtMrJF(r100);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitchesAndArguments(String[] r100) {
        N.MjOVh1Zv(r100);
    }

    public static String com_ttnet_org_chromium_base_CommandLine_getSwitchValue(String r100) {
        return N.MaCXZYAa(r100);
    }

    public static boolean com_ttnet_org_chromium_base_CommandLine_hasSwitch(String r100) {
        return N.MhlgTxh2(r100);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_init(String[] r100) {
        N.MZSU27YP(r100);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_removeSwitch(String r100) {
        N.MP5WQt3J(r100);
    }

    public static boolean com_ttnet_org_chromium_base_Features_isEnabled(long r100) {
        return N.MoITUwC2(r100);
    }

    public static String com_ttnet_org_chromium_base_FieldTrialList_findFullName(String r100) {
        return N.MfcktC_e(r100);
    }

    public static boolean com_ttnet_org_chromium_base_FieldTrialList_trialExists(String r100) {
        return N.MBEGQVWX(r100);
    }

    public static String com_ttnet_org_chromium_base_FileUtils_getAbsoluteFilePath(String r100) {
        return N.MKMoqNq6(r100);
    }

    public static void com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaStackTrace(String r100) {
        N.MuvJZ5jK(r100);
    }

    public static void com_ttnet_org_chromium_base_JavaHandlerThread_onLooperStopped(long r100) {
        N.MSKUcgE4(r100);
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onAppInBackgroundChanged(boolean r100) {
        N.M$Y37M6J(r100);
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onThermalStatusChanged(int r100) {
        N.MuSEGQ9M(r100);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_beginToplevel(String r100) {
        N.MljCyOuh(r100);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_endToplevel(String r100) {
        N.M6R6NWXS(r100);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_setupATraceStartupTrace(String r100) {
        N.M8MvK2gp(r100);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_startATrace(String r100) {
        N.MiUfkLIq(r100);
    }

    public static boolean com_ttnet_org_chromium_base_library_1loader_LibraryLoader_libraryLoaded(int r100) {
        return N.MnwWsRxg(r100);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_addActionCallbackForTesting(Object r100) {
        return N.MDoBOCZO_ForTesting(r100);
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_destroyHistogramSnapshotForTesting(long r100) {
        N.Me95ZC6G_ForTesting(r100);
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_removeActionCallbackForTesting(long r100) {
        N.MYkUp9vo_ForTesting(r100);
    }

    public static String com_ttnet_org_chromium_base_metrics_StatisticsRecorderAndroid_toJson(int r100) {
        return N.M5gAmtvn(r100);
    }

    public static boolean com_ttnet_org_chromium_base_task_TaskRunnerImpl_belongsToCurrentThread(long r100) {
        return N.Mz$BG_4y(r100);
    }

    public static void com_ttnet_org_chromium_base_task_TaskRunnerImpl_destroy(long r100) {
        N.Mvd960xb(r100);
    }

    public static String com_ttnet_org_chromium_net_GURLUtils_getOrigin(String r100) {
        return N.McGsvqvj(r100);
    }

    public static void com_ttnet_org_chromium_net_NetworkActiveNotifier_notifyOfDefaultNetworkActive(long r100) {
        N.M5aI8A5Z(r100);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetFrontierClient_createFrontierClientAdapter(Object r100) {
        return N.MagNlhNv(r100);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createAdapterForTesting(Object r100) {
        return N.M3b_yKC0_ForTesting(r100);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_destroy(long r100) {
        N.Mx3T_YwB(r100);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextAdapter(long r100) {
        return N.MuixiOYs(r100);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initALogFuncAddr(long r100) {
        N.MjS9m1YQ(r100);
    }

    public static int com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setMinLogLevel(int r100) {
        return N.MyyJ5zsH(r100);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitchWithValue(String r100, String r101) {
        N.MIZelAXD(r100, r101);
    }

    public static boolean com_ttnet_org_chromium_base_FieldTrialList_createFieldTrial(String r100, String r101) {
        return N.MzhBrODy(r100, r101);
    }

    public static String com_ttnet_org_chromium_base_FieldTrialList_getVariationParameter(String r100, String r101) {
        return N.Msd5Ns7Y(r100, r101);
    }

    public static boolean com_ttnet_org_chromium_base_ImportantFileWriterAndroid_writeFileAtomically(String r100, byte[] r101) {
        return N.M1jycjxU(r100, r101);
    }

    public static void com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaException(boolean r100, Throwable r101) {
        N.M9gfm$zh(r100, r101);
    }

    public static void com_ttnet_org_chromium_base_JavaHandlerThread_initializeThread(long r100, long r101) {
        N.M3RaWo13(r100, r101);
    }

    public static void com_ttnet_org_chromium_base_PathService_override(int r100, String r101) {
        N.MvMFfChw(r100, r101);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_begin(String r100, String r101) {
        N.MajVTFsV(r100, r101);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_end(String r100, String r101) {
        N.M5yUVmrW(r100, r101);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_finishAsync(String r100, long r101) {
        N.MjXrJVoa(r100, r101);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_instant(String r100, String r101) {
        N.Mz5qii_R(r100, r101);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_instantAndroidIPC(String r100, long r101) {
        N.MMXoiNW_(r100, r101);
    }

    public static long com_ttnet_org_chromium_base_TraceEvent_startActivityDump(String r100, long r101) {
        return N.MgxFMA1H(r100, r101);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_startAsync(String r100, long r101) {
        N.MKlPFTpb(r100, r101);
    }

    public static int com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramTotalCountForTesting(String r100, long r101) {
        return N.M7NlTYxi_ForTesting(r100, r101);
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordUserAction(String r100, long r101) {
        N.MxViw_go(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_AndroidNetworkLibrary_onCellularAlwaysUp(boolean r100, int r101) {
        N.MeYG7FqD(r100, r101);
    }

    public static boolean com_ttnet_org_chromium_net_HttpUtil_isAllowedHeader(String r100, String r101) {
        return N.MsTaj7yX(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChanged(long r100, Object r101) {
        N.MKwsFZ4t(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_sendRequestHeaders(long r100, Object r101) {
        N.MhETl_ev(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_destroy(long r100, Object r101) {
        N.MKRYs$fc(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onRewindSucceeded(long r100, Object r101) {
        N.M3Tck9nA(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_clearClientOpaqueData(long r100, Object r101) {
        N.MK0SE_Ub(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_destroy(long r100, Object r101) {
        N.MG$DT18r(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initRequestContextOnInitThread(long r100, Object r101) {
        N.Mdu$OLLN(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setCookieInitCompleted(long r100, Object r101) {
        N.MaSOyuXL(r100, r101);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_skipLogging(long r100, Object r101) {
        return N.MLLAskZ0(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopNetLog(long r100, Object r101) {
        N.ML5dVOOG(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_abortWhenUploadException(long r100, Object r101) {
        N.MzKjGz9N(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_appTimeout(long r100, Object r101) {
        N.M3xsE8SK(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_followDeferredRedirect(long r100, Object r101) {
        N.MhCyx70S(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_removeRequestCookieHeader(long r100, Object r101) {
        N.MjbEhTZs(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_start(long r100, Object r101) {
        N.Mv2a151P(r100, r101);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_createWebsocketConnectionAdapter(Object r100, long r101) {
        return N.MRAGjNeT(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_destroy(long r100, Object r101) {
        N.MCzpxGQD(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_stop(long r100, Object r101) {
        N.M14GZgiH(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_destroy(long r100, Object r101) {
        N.M6$xRvea(r100, r101);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_start(long r100, Object r101) {
        N.MLiR9ZbW(r100, r101);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncBeginEvent(String r100, long r101, long r102) {
        N.M88o6Bs3(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncEndEvent(String r100, long r101, long r102) {
        N.MohIB14s(r100, r101, r102);
    }

    public static boolean com_ttnet_org_chromium_base_Features_getFieldTrialParamByFeatureAsBoolean(long r100, String r101, boolean r102) {
        return N.MiTw3O_J(r100, r101, r102);
    }

    public static int com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramValueCountForTesting(String r100, int r101, long r102) {
        return N.MkFXHbyW_ForTesting(r100, r101, r102);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(String r100, long r101, boolean r102) {
        return N.MYPj82kt(r100, r101, r102);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(String r100, long r101, int r102) {
        return N.MV$7$UuP(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionCostChanged(long r100, Object r101, int r102) {
        N.MZnuk2LK(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyMaxBandwidthChanged(long r100, Object r101, int r102) {
        N.MqNJnYjG(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkSoonToDisconnect(long r100, Object r101, long r102) {
        N.MssT8yD3(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyPurgeActiveNetworkList(long r100, Object r101, long[] r102) {
        N.Mvng38R0(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_TTSocketAccelerate_OnCheckSystemAvailableResult(long r100, Object r101, int r102) {
        N.MXvQH$ie(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_destroy(long r100, Object r101, boolean r102) {
        N.My0p82p4(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_addServiceId(long r100, Object r101, int r102) {
        N.Msf3H5kQ(r100, r101, r102);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetFrontierClient_isServiceReady(long r100, Object r101, int r102) {
        return N.My_P9YPg(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_reportAppStateChange(long r100, Object r101, boolean r102) {
        N.MlH8$Rpg(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_unregisterService(long r100, Object r101, int r102) {
        N.M4rPfgYd(r100, r101, r102);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_attachUploadDataToRequest(Object r100, long r101, long r102) {
        return N.M89UGLMC(r100, r101, r102);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createUploadDataStreamForTesting(Object r100, long r101, long r102) {
        return N.MKATyFlf_ForTesting(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addSamplingSetting(long r100, Object r101, Object r102) {
        N.MKYzOUkj(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideRTTObservations(long r100, Object r101, boolean r102) {
        N.Mk1UqBGq(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideThroughputObservations(long r100, Object r101, boolean r102) {
        N.MHUcn7PP(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_removeClientOpaqueData(long r100, Object r101, String r102) {
        N.Mcfn2q8$(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_reportNetDiagnosisUserLog(long r100, Object r101, String r102) {
        N.MPONMQm_(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_runInBackGround(long r100, Object r101, boolean r102) {
        N.MWOUQ7KG(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAlogFuncAddr(long r100, Object r101, long r102) {
        N.Me3xdZoU(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAppStartUpState(long r100, Object r101, int r102) {
        N.MksRT8QX(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setHostResolverRules(long r100, Object r101, String r102) {
        N.MlH1XMiR(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setProxy(long r100, Object r101, String r102) {
        N.Mj4Pi_Pa(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_triggerTNCRequestByUser(long r100, Object r101, boolean r102) {
        N.MN8yyQkr(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_destroy(long r100, Object r101, boolean r102) {
        N.MIb9tt7_(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_getStatus(long r100, Object r101, Object r102) {
        N.MmSvKAJE(r100, r101, r102);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_setHttpMethod(long r100, Object r101, String r102) {
        return N.MfdvbiJC(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTimeout(long r100, Object r101, int r102) {
        N.MaFGwSbC(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTypeFlags(long r100, Object r101, int r102) {
        N.MC7pScOk(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setThrottleNetSpeed(long r100, Object r101, long r102) {
        N.ML2WrLQ6(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addUrl(long r100, Object r101, String r102) {
        N.MgN9hn8A(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendBinary(long r100, Object r101, Object r102) {
        N.MRfZ_7V_(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendText(long r100, Object r101, String r102) {
        N.MRnDfpSi(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithWSChannel(long r100, Object r101, boolean r102) {
        N.MVrBbeuj(r100, r101, r102);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyBeginEvent(String r100, long r101, int r102, long r103) {
        N.MCawLSFP(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyEndEvent(String r100, long r101, int r102, long r103) {
        N.MvvW3g4w(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelBeginEvent(String r100, long r101, int r102, long r103) {
        N.MjWH5Jmd(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelEndEvent(String r100, long r101, int r102, long r103) {
        N.MoB6dYvZ(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_base_task_TaskRunnerImpl_postDelayedTask(long r100, Object r101, long r102, String r103) {
        N.MJ_h_2p2(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_HttpNegotiateAuthenticator_setResult(long r100, Object r101, int r102, String r103) {
        N.MsAf1sYp(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionTypeChanged(long r100, Object r101, int r102, long r103) {
        N.MjJzrRFH(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkDisconnect(long r100, Object r101, boolean r102, long r103) {
        N.Ms7JLaGI(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_TTSocketAccelerate_OnNotifyAccelerateResult(long r100, Object r101, int r102, int r103) {
        N.MOfWrYJI(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_addHeader(long r100, Object r101, String r102, String r103) {
        N.MwZrRAIG(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onReadSucceeded(long r100, Object r101, int r102, boolean r103) {
        N.MYsxiVBk(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addQuicHint(long r100, String r101, int r102, int r103) {
        N.M6WZ7Wt0(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setClientOpaqueData(long r100, String[] r101, byte[] r102, byte[] r103) {
        N.MTZ7mkhc(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setRouteSelectionBestHost(long r100, Object r101, String r102, String r103) {
        N.MhbNiNFL(r100, r101, r102, r103);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToFile(long r100, Object r101, String r102, boolean r103) {
        return N.Mt89JXhb(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopThrottle(long r100, Object r101, String[] r102, int r103) {
        N.MohL$06P(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestCookieHeader(long r100, Object r101, String r102, String r103) {
        N.M2jrbUOP(r100, r101, r102, r103);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestHeader(long r100, Object r101, String r102, String r103) {
        return N.MtJFji5x(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setAuthCredentials(long r100, Object r101, String r102, String r103) {
        N.Mor7A21H(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addGetParam(long r100, Object r101, String r102, String r103) {
        N.Mzisx1kZ(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addHeader(long r100, Object r101, String r102, String r103) {
        N.MKmGe$35(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_doExtraCommand(long r100, Object r101, String r102, String r103) {
        N.MDZjmtTn(r100, r101, r102, r103);
    }

    public static void com_ttnet_org_chromium_base_jank_1tracker_JankMetricUMARecorder_recordJankMetrics(String r100, long[] r101, long[] r102, long[] r103, int r104) {
        N.Mw$h3q2i(r100, r101, r102, r103, r104);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkConnect(long r100, Object r101, long r102, boolean r103, int r104) {
        N.MZ5e75rQ(r100, r101, r102, r103, r104);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_readData(long r100, Object r101, Object r102, int r103, int r104) {
        return N.M21CWxxV(r100, r101, r102, r103, r104);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_sendMessage(long r100, Object r101, int r102, String[] r103, Object r104) {
        N.MKYiSehZ(r100, r101, r102, r103, r104);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addPkp(long r100, String r101, byte[][] r102, boolean r103, long r104) {
        N.Mkx3KULb(r100, r101, r102, r103, r104);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_configureNetworkQualityEstimatorForTesting(long r100, Object r101, boolean r102, boolean r103, boolean r104) {
        N.MNAF9eXw_ForTesting(r100, r101, r102, r103, r104);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_controlHttpDNSConfig(long r100, Object r101, boolean r102, boolean r103, boolean r104) {
        N.MHps7uOC(r100, r101, r102, r103, r104);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_preconnectUrl(long r100, Object r101, String r102, int r103, String r104) {
        N.MBtj30QU(r100, r101, r102, r103, r104);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToDisk(long r100, Object r101, String r102, boolean r103, int r104) {
        N.MuR7zLrb(r100, r101, r102, r103, r104);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startThrottle(long r100, Object r101, String[] r102, int r103, long r104) {
        N.MiGn0DCY(r100, r101, r102, r103, r104);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_tryStartNetDetect(long r100, Object r101, String[] r102, int r103, int r104) {
        N.MA5SsGAv(r100, r101, r102, r103, r104);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttUrlDispatch(long r100, Object r101, Object r102, String r103, boolean r104) {
        N.MRTGlzo1(r100, r101, r102, r103, r104);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_readData(long r100, Object r101, Object r102, int r103, int r104) {
        return N.MJbYA4in(r100, r101, r102, r103, r104);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setSocketTimeout(long r100, Object r101, int r102, int r103, int r104) {
        N.M4C6WZaz(r100, r101, r102, r103, r104);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(String r100, long r101, int r102, int r103, int r104, int r105) {
        return N.M45N7QIN(r100, r101, r102, r103, r104, r105);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(String r100, long r101, int r102, int r103, int r104, int r105) {
        return N.Mx1k0LvC(r100, r101, r102, r103, r104, r105);
    }

    public static long com_ttnet_org_chromium_base_task_TaskRunnerImpl_init(int r100, int r101, boolean r102, boolean r103, byte r104, byte[] r105) {
        return N.MLtH82Um(r100, r101, r102, r103, r104, r105);
    }

    public static void com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChangedTo(long r100, Object r101, String r102, int r103, String r104, String[] r105) {
        N.MtXZ30qk(r100, r101, r102, r103, r104, r105);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_writevData(long r100, Object r101, Object[] r102, int[] r103, int[] r104, boolean r105) {
        return N.MYRRygif(r100, r101, r102, r103, r104, r105);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttDnsResolve(long r100, Object r101, String r102, int r103, String r104, String r105) {
        N.MH0muaR3(r100, r101, r102, r103, r104, r105);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_addViewDump(int r100, int r101, boolean r102, boolean r103, String r104, String r105, long r106) {
        N.MxGy3cn_(r100, r101, r102, r103, r104, r105, r106);
    }

    public static int com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_start(long r100, Object r101, String r102, int r103, String r104, String[] r105, boolean r106) {
        return N.MycrIbGr(r100, r101, r102, r103, r104, r105, r106);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_registerService(long r100, Object r101, String[] r102, Object r103, int r104, int r105, boolean r106) {
        N.MKu8Zh_d(r100, r101, r102, r103, r104, r105, r106);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addClientOpaqueData(long r100, Object r101, String[] r102, byte[] r103, byte[] r104, long r105, long r106) {
        N.MWb1lJ5e(r100, r101, r102, r103, r104, r105, r106);
    }

    public static long com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_createRequestAdapter(Object r100, long r101, int r102, String[] r103, int r104, int r105, int r106) {
        return N.MPJAsrFC(r100, r101, r102, r103, r104, r105, r106);
    }

    public static void com_ttnet_org_chromium_base_task_PostTask_postDelayedTask(int r100, boolean r101, boolean r102, byte r103, byte[] r104, Object r105, long r106, String r107) {
        N.Mwr17eXX(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_createBidirectionalStream(Object r100, long r101, boolean r102, boolean r103, int r104, boolean r105, int r106, long r107) {
        return N.MSnVviPU(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_enableTTBizHttpDns(long r100, Object r101, boolean r102, String r103, String r104, String r105, boolean r106, String r107) {
        N.M2ni33Tk(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_parseTNCConfigFromSystemHTTPRequest(long r100, Object r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        N.MU6k4d25(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setZstdFuncAddr(long r100, Object r101, long r102, long r103, long r104, long r105, long r110, long r111, long r112, long r113) {
        N.MIs1FVFz(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithFrontier(long r100, Object r101, int r102, String r103, long r104, int r105, long r106, String r110, int r111, String r112, boolean r113) {
        N.MWq0tMul(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_updateStoreRegionFromServer(long r100, Object r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, String r113) {
        N.MqjX8qD1(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequest_createRequestAdapter(Object r100, long r101, String r102, int r103, int r104, boolean r105, boolean r106, boolean r107, int r108, boolean r110, int r111, int r112, long r113) {
        return N.MnXVOzVo(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextConfig(String r100, String r101, boolean r102, String r103, boolean r104, boolean r105, boolean r106, int r107, long r108, String r110, long r111, boolean r112, boolean r113, int r114) {
        return N.Mmo_MQVE(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_configParams(long r100, Object r101, int r102, int r103, String r104, int r105, String r106, String r107, String r108, String r110, int r111, int r112, int r113, boolean r114, String r115, String r116) {
        N.Mhk1t9AY(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setTTNetInitConfig(long r100, int r101, boolean r102, boolean r103, String r104, String r105, String r106, boolean r107, String r108, String r110, byte[][] r111, Object[] r112, boolean r113, boolean r114, boolean r115, String r116, Object r117, long r118, boolean r210, boolean r211, boolean r212, Object r213, boolean r214, String r215, int r216) {
        N.MawZO189(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216);
    }
}
