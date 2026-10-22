package com.ttnet.org.chromium.net;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TTEventListener {
    public TTEventListener() {
    }

    public abstract Map<String, String> onCallToAddSecurityFactor(String r100, Map<String, String> r101);

    public abstract void onClientIPChanged(String r100);

    public abstract void onColdStartFinish();

    public abstract void onContextInitCompleted(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, long r214, long r310);

    public abstract void onCronetBootSucceed();

    public abstract void onDropReasonChanged(boolean r100, List<Integer> r101);

    public abstract void onEffectiveConnectionTypeChanged(int r100);

    public abstract void onMultiNetworkStateChanged(int r100, int r101);

    public abstract void onNetworkQualityLevelChanged(int r100);

    public abstract void onNetworkQualityRttAndThroughputNotified(int r100, int r101, int r102);

    public abstract void onNetworkQualityTypeChangedV3(int r100);

    public abstract void onPacketLossComputed(int r100, double r101, double r102, double r103, double r104);

    public abstract void onPublicIPsChanged(List<String> r100, List<String> r101);

    public abstract void onRTTOrThroughputEstimatesComputed(int r100, int r101, int r102);

    public abstract String onRequestInterceptorJava(String r100, Map<String, String> r101);

    public abstract String onRequestInterceptorToStart(String r100, Map<String, String> r101, List<String> r102);

    public abstract String onResponseInterceptorToStart(String r100, Map<String, List<String>> r101, int r102);

    public abstract void onServerConfigUpdated(String r100, String r101, String r102);

    public abstract void onStoreIdcChanged(String r100, String r101, String r102, String r103, String r104, String r105);

    public abstract void onTLBDecompressFail();

    public abstract void onTNCUpdateFailed(String[] r100, String r101);

    public abstract void onTTDnsResolveResult(String r100, String r101, int r102, int r103, int r104, List<String> r105, String r106);

    public abstract void onTTNetDetectInfoChanged(String r100);

    public abstract void onTncRequestSucceeded(boolean r100, boolean r101, int r102);

    public abstract void onUserSpecifiedNetworkEnabled(boolean r100);

    public abstract void onWiFiToCellStateChanged(int r100, int r101);
}
