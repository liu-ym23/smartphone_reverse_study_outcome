package com.bytedance.ee.bear.bitable.statistic;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface m {
    void addFpsConsumer(String r1, h r2);

    void addNormalConsumer(String r1, j r2);

    void addNormalPoint(String r1, BitableStatisticEventModel$NormalPointModel r2);

    void addProcessConsumer(String r1, k r2);

    void addTraceExtra(String r1, String r2, Serializable r3);

    void appendTraceExtraIfNotExist(String r1, String r2, Serializable r3);

    c createDefaultFpsTrace(String r1, boolean r2, boolean r3, String r4);

    String createDefaultNormalTrace(String r1, String r2);

    c createFpsTrace(String r1);

    String createNormalTrace(String r1);

    g createProcessTrace(String r1);

    void removeAllConsumer(String r1);

    void removeFpsConsumer(String r1, h r2);

    void removeNormalConsumer(String r1, j r2);

    void removeProcessConsumer(String r1, k r2);

    void reportError(String r1, String r2, JSONObject r3);

    void setCommonParams(String r1, Serializable r2);

    void stopAllTrace();

    void stopTrace(String r1, Boolean r2);
}
