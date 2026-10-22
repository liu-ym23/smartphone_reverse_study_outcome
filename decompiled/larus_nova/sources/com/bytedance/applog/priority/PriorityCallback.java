package com.bytedance.applog.priority;

import kotlin.Pair;

/* JADX INFO: loaded from: classes6.dex */
public interface PriorityCallback {

    /* JADX INFO: renamed from: com.bytedance.applog.priority.PriorityCallback$-CC, reason: invalid class name */
    /* JADX INFO: loaded from: classes14.dex */
    public final /* synthetic */ class CC {
        public static Object $default$getOpaquePayloadJson(PriorityCallback r100) {
            return null;
        }
    }

    boolean allowIsolateReport(String r100, String r101);

    PriorityHttpResponse doHttpPost(String r100, byte[] r101, Pair<String, String> r102);

    String getHeaderJson();

    Object getOpaquePayloadJson();

    boolean isMonitorEnabled();

    boolean isNetworkAvailable();

    boolean isStageEnabled();

    String isolateKey();

    void monitorError(String r100, String r101);

    void monitorIncreaseStats(String r100, int r101);

    void monitorLatency(int r100, int r101, int r102);

    void monitorStage(String r100, String r101, int r102, int r103, String r104, String r105, long r106);

    void printLog(int r100, String r101);
}
