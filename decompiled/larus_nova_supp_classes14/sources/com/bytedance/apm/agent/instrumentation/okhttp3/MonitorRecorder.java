package com.bytedance.apm.agent.instrumentation.okhttp3;

import com.bytedance.apm.agent.instrumentation.transaction.TransactionData;
import com.bytedance.apm.agent.instrumentation.transaction.TxState;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.d;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.k;
import org.json.JSONObject;
import ps3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class MonitorRecorder {
    private static final String TAG = "MonitorRecorder";

    public MonitorRecorder() {
    }

    public static void reportExceptionMonitor(TxState r0, Exception r1) {
    }

    public static void recordRequest(Request r2, TxState r3) {
        if (r2 == null) goto L20;
        if (r3 == null) goto L24;
        r3.addAssistData("NetworkLib", "OkHttp3");
        r3.setUrl(r2.url().toString());
        r3.setMethod(r2.method());
        r3.setStartTime(System.currentTimeMillis());
        r3.setCarrier("");
        r3.setWanType("");
        FormBody r4 = r2.body();
        if (r4 == null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return;
    L11:
        if ((r4 instanceof FormBody) == false) goto L14;
        r3.setBytesSent(r4.contentLength());
        return;
    L14:
        if ((r4 instanceof k) == false) goto L23;
        r3.setBytesSent(r4.contentLength());     // Catch: IOException -> L17
        return;
    L25:
        return;
    L23:
        return;
    L8:
        r0 = false;
        goto L9
    L24:
        return;
    }

    public static void recordResponse(Response r2, TxState r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L11;
        r3.setStatusCode(r2.code());
        if (r2.body() == null) goto L10;
        r3.setBytesReceived(r2.body().contentLength());
        return;
    L10:
        return;
    L11:
        return;
    }

    public static void reportMonitorData(TxState r13, String r14) {
        if (r13 != null) goto L4;
        return;
    L4:
        TransactionData r0 = r13.end();
        if (d.j() == false) goto L16;
        b.a(new String[]{"auto plugin, reportMonitorData: " + r0.toString()});
    L16:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L13
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L13
        r2.put("sent_bytes", r0.getBytesSent());     // Catch: Exception -> L13
        r2.put("received_bytes", r0.getBytesReceived());     // Catch: Exception -> L13
        r1.put("response", r2);     // Catch: Exception -> L13
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L13
        r12.put("request_log", r1);     // Catch: Exception -> L13
        r12.put("net_consume_type", r14);     // Catch: Exception -> L13
        long r4 = r0.getTotalTime();     // Catch: Exception -> L13
        if (r13.getStartTime() != 0) goto L10;
        long r15 = r0.getRequestStart();     // Catch: Exception -> L13
    L11:
        MonitorTool.monitorSLA(r4, r15, r0.getUrl(), "", "", r0.getStatusCode(), r12);     // Catch: Exception -> L13
        return;
    L10:
        r15 = r13.getStartTime();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public static void reportMonitorData(TxState r0, Response r1) {
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        reportMonitorData(r0, "okhttp");
        return;
    L8:
        return;
    }
}
