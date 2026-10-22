package com.bytedance.ee.bear.bitable.statistic;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public interface m {
    void addFpsConsumer(String r100, h r101);

    void addNormalConsumer(String r100, j r101);

    void addNormalPoint(String r100, BitableStatisticEventModel$NormalPointModel r101);

    void addProcessConsumer(String r100, k r101);

    void addTraceExtra(String r100, String r101, Serializable r102);

    void appendTraceExtraIfNotExist(String r100, String r101, Serializable r102);

    c createDefaultFpsTrace(String r100, boolean r101, boolean r102, String r103);

    String createDefaultNormalTrace(String r100, String r101);

    c createFpsTrace(String r100);

    String createNormalTrace(String r100);

    g createProcessTrace(String r100);

    void removeAllConsumer(String r100);

    void removeFpsConsumer(String r100, h r101);

    void removeNormalConsumer(String r100, j r101);

    void removeProcessConsumer(String r100, k r101);

    void reportError(String r100, String r101, JSONObject r102);

    void setCommonParams(String r100, Serializable r101);

    void stopAllTrace();

    void stopTrace(String r100, Boolean r101);
}
