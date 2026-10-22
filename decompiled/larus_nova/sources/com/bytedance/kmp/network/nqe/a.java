package com.bytedance.kmp.network.nqe;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    void a(EffectiveConnectionType r100);

    void onPacketLossComputed(int r100, double r101, double r102, double r103, double r104);

    void onRTTOrThroughputEstimatesComputed(int r100, int r101, int r102);
}
