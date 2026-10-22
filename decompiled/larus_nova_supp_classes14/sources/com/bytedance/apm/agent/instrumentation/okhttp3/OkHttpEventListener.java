package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.text.TextUtils;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.d;
import com.bytedance.apm.util.m;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.i;
import okhttp3.j;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class OkHttpEventListener extends i {
    public static final String X_TT_CONTENT_ENCODING = "x-tt-content-encoding";
    public static final String X_TT_TRACE_HOST = "x-tt-trace-host";
    public static final String X_TT_TRACE_ID = "x-tt-trace-id";
    public static final String X_TT_TRACE_TAG = "x-tt-trace-tag";
    private static String sIgnoreMonitorLabel;
    private long connectStartTime;
    private long dnsStartTime;
    private boolean needToDeal;
    private OkHttpRecord okHttpRecord;
    public i originListener;
    private long requestBodyEndTime;
    private JSONObject requestHeader;
    private long requestHeadersEndTime;
    private long requestHeadersStartTime;
    private long responseBodyStartTime;
    private JSONObject responseHeader;
    private long responseHeadersStartTime;
    private long secureConnectStartTime;
    private String url;

    private void record() {
        if (this.needToDeal == true) goto L5;
        return;
    L5:
        OkHttpRecord r0 = this.okHttpRecord;
        if (r0 != null) goto L8;
        return;
    L8:
        OkHttpRecord.TimeRequest r1 = r0.timeRequest;
        r1.duration = System.currentTimeMillis() - this.okHttpRecord.timeRequest.start_time;
        JSONObject r2 = new JSONObject(this.okHttpRecord.toString());     // Catch: JSONException -> L19
        r2.put("timing_totalSendBytes", this.okHttpRecord.recordResponse.sent_bytes);     // Catch: JSONException -> L19
        r2.put("timing_totalReceivedBytes", this.okHttpRecord.recordResponse.received_bytes);     // Catch: JSONException -> L19
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L19
        r12.put("request_log", r2);     // Catch: JSONException -> L19
        r12.put("net_consume_type", "okhttp");     // Catch: JSONException -> L19
        JSONObject r3 = this.requestHeader;     // Catch: JSONException -> L19
        String r4 = "";
        if (r3 == null) goto L13;
        String r5 = r3.toString();     // Catch: JSONException -> L19
    L14:
        r12.put("requestHeader", r5);     // Catch: JSONException -> L19
        JSONObject r6 = this.responseHeader;     // Catch: JSONException -> L19
        if (r6 == null) goto L17;
        r4 = r6.toString();     // Catch: JSONException -> L19
    L17:
        r12.put("responseHeader", r4);     // Catch: JSONException -> L19
        OkHttpRecord r7 = this.okHttpRecord;     // Catch: JSONException -> L19
        OkHttpRecord.TimeRequest r8 = r7.timeRequest;     // Catch: JSONException -> L19
        MonitorTool.monitorSLA(r8.duration, r8.start_time, this.url, r7.socketInfo.remote, "", r7.recordResponse.code, r12);     // Catch: JSONException -> L19
        return;
    L13:
        r5 = "";
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public OkHttpEventListener(i r2) {
        this.needToDeal = true;
        this.originListener = r2;
        this.okHttpRecord = new OkHttpRecord();
    }

    private void dealSpecialHeader(Response r11) {
        Iterator r12 = r11.headers("server-timing").iterator();
    L4:
        if (r12.hasNext() == false) goto L80;
        String r0 = (String) r12.next();
        if (TextUtils.isEmpty(r0) == true) goto L7;
        this.okHttpRecord.headerRequest.serverTimings.add(r0);
        String[] r1 = r0.split(",");
        int r2 = r1.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L4;
        String r4 = r1[r3];
        if (TextUtils.isEmpty(r4) == false) goto L14;
    L79:
        r3 = r3 + 1;
        goto L9
    L14:
        if (r4.contains(";") == false) goto L79;
        String[] r5 = r4.split(";");
        if (r5.length < 2) goto L79;
        String r6 = r5[0].replace(" ", "");
        boolean r9 = true;
        String r7 = r5[1].replace(" ", "");
        if (TextUtils.isEmpty(r6) == true) goto L79;
        r6.getClass();
        byte r8 = -1;
        switch(r6.hashCode()) {
            case -1008619738: goto L35;
            case -138105374: goto L31;
            case 3108285: goto L27;
            case 100355670: goto L23;
            default: goto L39;
        };
    L23:
        if (r6.equals("inner") == false) goto L39;
        r8 = 3;
        goto L39
    L27:
        if (r6.equals("edge") == false) goto L39;
        r8 = 2;
        goto L39
    L31:
        if (r6.equals("cdn-cache") == false) goto L39;
        r8 = 1;
        goto L39
    L35:
        if (r6.equals("origin") == false) goto L39;
        r8 = 0;
    L39:
        switch(r8) {
            case 0: goto L71;
            case 1: goto L60;
            case 2: goto L51;
            case 3: goto L42;
            default: goto L79;
        };
    L42:
        if (TextUtils.isEmpty(r7) == true) goto L79;
        String[] r10 = r7.split("=");
        if (r10.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r13 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r10[1]) == true) goto L48;
        int r14 = CastIntegerProtector.parseInt(r10[1]);
    L49:
        r13.inner = r14;
        goto L79
    L48:
        r14 = 0;
        goto L49
    L51:
        if (TextUtils.isEmpty(r7) == true) goto L79;
        String[] r15 = r7.split("=");
        if (r15.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r16 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r15[1]) == true) goto L57;
        int r17 = CastIntegerProtector.parseInt(r15[1]);
    L58:
        r16.edge = r17;
        goto L79
    L57:
        r17 = 0;
        goto L58
    L60:
        if (TextUtils.isEmpty(r7) == true) goto L79;
        String[] r18 = r7.split("=");
        if (r18.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r19 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r18[1]) == false) goto L66;
    L68:
        r9 = false;
    L69:
        r19.cdn_hit_cache = r9;
        goto L79
    L66:
        if (r18[1].equalsIgnoreCase("hit") == false) goto L68;
    L71:
        if (TextUtils.isEmpty(r7) == true) goto L79;
        String[] r20 = r7.split("=");
        if (r20.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r21 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r20[1]) == true) goto L77;
        int r22 = CastIntegerProtector.parseInt(r20[1]);
    L78:
        r21.origin = r22;
        goto L79
    L77:
        r22 = 0;
        goto L78
    L7:
        return;
    L80:
        OkHttpRecord.DetailedDuration r110 = this.okHttpRecord.timeDetailedDuration;
        int r23 = r110.ttfb - r110.edge;
        int r24 = r110.origin;
        int r25 = r23 - r24;
        if (r25 <= 0) goto L83;
        r110.rtt = r25;
    L83:
        int r26 = r24 - r110.inner;
        if (r26 <= 0) goto L92;
        r110.origin = r26;
        return;
    }

    private JSONObject getHeaders(Headers r5) {
        JSONObject r0 = new JSONObject();
        if (r5 != null) goto L18;
    L15:
        return r0;
    L18:
        Iterator r1 = r5.names().iterator();     // Catch: Exception -> L13
    L5:
        if (r1.hasNext() == false) goto L15;
        String r2 = (String) r1.next();     // Catch: Exception -> L13
        r0.put(r2, r5.get(r2));     // Catch: JSONException -> L10 Exception -> L13
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static void setIgnoreMonitorLabel(String r0) {
        sIgnoreMonitorLabel = r0;
    }

    public void callEnd(Call r2) {
        super.callEnd(r2);
        i r0 = this.originListener;
        if (r0 == null) goto L5;
        r0.callEnd(r2);
    L5:
        record();
    }

    public void callStart(Call r3) {
        super.callStart(r3);
        i r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.callStart(r3);
    L6:
        if (this.needToDeal == false) goto L9;
        OkHttpRecord.TimeRequest r4 = this.okHttpRecord.timeRequest;
        r4.start_time = System.currentTimeMillis();
        return;
    }

    public void requestBodyStart(Call r2) {
        super.requestBodyStart(r2);
        i r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.requestBodyStart(r2);
        return;
    }

    public void requestHeadersStart(Call r4) {
        super.requestHeadersStart(r4);
        if (this.needToDeal == false) goto L5;
        long r0 = System.currentTimeMillis();
        this.requestHeadersStartTime = r0;
        this.okHttpRecord.timeRequest.request_sent_time = r0;
    L5:
        i r1 = this.originListener;
        if (r1 == null) goto L9;
        r1.requestHeadersStart(r4);
        return;
    }

    public void responseBodyStart(Call r3) {
        super.responseBodyStart(r3);
        if (this.needToDeal == false) goto L5;
        this.responseBodyStartTime = System.currentTimeMillis();
    L5:
        i r0 = this.originListener;
        if (r0 == null) goto L9;
        r0.responseBodyStart(r3);
        return;
    }

    public void responseHeadersStart(Call r6) {
        super.responseHeadersStart(r6);
        if (this.needToDeal == false) goto L9;
        this.responseHeadersStartTime = System.currentTimeMillis();
        if (this.requestBodyEndTime == 0) goto L7;
        long r0 = System.currentTimeMillis();
        long r2 = this.requestBodyEndTime;
    L8:
        long r1 = r0 - r2;
        OkHttpRecord r3 = this.okHttpRecord;
        int r4 = (int) r1;
        r3.timeDetailedDuration.ttfb = r4;
        OkHttpRecord.TimeRequest r5 = r3.timeRequest;
        r5.response_recv_time = System.currentTimeMillis();
        goto L9
    L7:
        r0 = System.currentTimeMillis();
        r2 = this.requestHeadersEndTime;
    L9:
        i r7 = this.originListener;
        if (r7 == null) goto L13;
        r7.responseHeadersStart(r6);
        return;
    }

    public void secureConnectStart(Call r6) {
        super.secureConnectStart(r6);
        if (this.needToDeal == false) goto L5;
        OkHttpRecord.DetailedDuration r0 = this.okHttpRecord.timeDetailedDuration;
        r0.tcp = (int) (System.currentTimeMillis() - this.connectStartTime);
        this.secureConnectStartTime = System.currentTimeMillis();
    L5:
        i r1 = this.originListener;
        if (r1 == null) goto L9;
        r1.secureConnectStart(r6);
        return;
    }

    public void callFailed(Call r2, IOException r3) {
        super.callFailed(r2, r3);
        i r0 = this.originListener;
        if (r0 == null) goto L5;
        r0.callFailed(r2, r3);
    L5:
        record();
    }

    public void connectionAcquired(Call r4, Connection r5) {
        super.connectionAcquired(r4, r5);
        i r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.connectionAcquired(r4, r5);
    L6:
        if (this.needToDeal == true) goto L8;
        return;
    L8:
        if (this.dnsStartTime != 0) goto L10;
        this.okHttpRecord.socketInfo.socketReused = true;
        return;
    L10:
        this.okHttpRecord.socketInfo.socketReused = false;
    }

    public void connectionReleased(Call r2, Connection r3) {
        super.connectionReleased(r2, r3);
        i r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.connectionReleased(r2, r3);
        return;
    }

    public void dnsStart(Call r3, String r4) {
        super.dnsStart(r3, r4);
        if (this.needToDeal == false) goto L5;
        this.dnsStartTime = System.currentTimeMillis();
    L5:
        i r0 = this.originListener;
        if (r0 == null) goto L9;
        r0.dnsStart(r3, r4);
        return;
    }

    public void requestBodyEnd(Call r6, long r7) {
        super.requestBodyEnd(r6, r7);
        if (this.needToDeal == false) goto L5;
        this.requestBodyEndTime = System.currentTimeMillis();
        this.okHttpRecord.timeDetailedDuration.send = (int) (System.currentTimeMillis() - this.requestHeadersStartTime);
    L5:
        i r0 = this.originListener;
        if (r0 == null) goto L9;
        r0.requestBodyEnd(r6, r7);
    L9:
        if (this.needToDeal == false) goto L12;
        this.okHttpRecord.recordResponse.sent_bytes += r7;
        return;
    }

    public void requestHeadersEnd(Call r6, Request r7) {
        super.requestHeadersEnd(r6, r7);
        if (this.needToDeal == false) goto L5;
        this.requestHeadersEndTime = System.currentTimeMillis();
        this.okHttpRecord.timeDetailedDuration.send = (int) (System.currentTimeMillis() - this.requestHeadersStartTime);
    L5:
        i r0 = this.originListener;
        if (r0 == null) goto L8;
        r0.requestHeadersEnd(r6, r7);
    L8:
        String r8 = r7.header("User-Agent");
        String r1 = sIgnoreMonitorLabel;
        if (r1 == null) goto L15;
        if (r8 == null) goto L15;
        if (r8.contains(r1) == false) goto L15;
        this.needToDeal = false;
    L15:
        if (this.needToDeal == false) goto L18;
        this.okHttpRecord.recordResponse.sent_bytes += r7.headers().byteCount();
        this.url = r7.url().toString();
        this.requestHeader = getHeaders(r7.headers());
        return;
    }

    public void responseBodyEnd(Call r4, long r5) {
        super.responseBodyEnd(r4, r5);
        i r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.responseBodyEnd(r4, r5);
    L6:
        if (this.needToDeal == false) goto L9;
        OkHttpRecord r6 = this.okHttpRecord;
        r6.recordResponse.received_bytes += r5;
        r6.timeDetailedDuration.body_recv = (int) (System.currentTimeMillis() - this.responseBodyStartTime);
        return;
    }

    public void responseHeadersEnd(Call r5, Response r6) {
        super.responseHeadersEnd(r5, r6);
        i r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.responseHeadersEnd(r5, r6);
    L6:
        if (this.needToDeal == false) goto L14;
        this.okHttpRecord.timeDetailedDuration.header_recv = (int) (System.currentTimeMillis() - this.responseHeadersStartTime);
        this.okHttpRecord.recordResponse.code = r6.code();
        this.okHttpRecord.recordResponse.received_bytes += r6.headers().byteCount();
        this.okHttpRecord.recordResponse.network_accessed = m.b(d.getContext());
        this.okHttpRecord.headerRequest.x_tt_trace_id = r6.header(X_TT_TRACE_ID, "");
        this.okHttpRecord.headerRequest.x_tt_trace_host = r6.header(X_TT_TRACE_HOST, "");
        this.okHttpRecord.headerRequest.x_tt_trace_tag = r6.header(X_TT_TRACE_TAG, "");
        this.okHttpRecord.headerRequest.x_tt_content_encoding = r6.header(X_TT_CONTENT_ENCODING, "");
        dealSpecialHeader(r6);     // Catch: Exception -> L11
    L9:
        this.responseHeader = getHeaders(r6.headers());
        return;
    }

    public void secureConnectEnd(Call r6, j r7) {
        super.secureConnectEnd(r6, r7);
        if (this.needToDeal == false) goto L5;
        OkHttpRecord.DetailedDuration r0 = this.okHttpRecord.timeDetailedDuration;
        r0.ssl = (int) (System.currentTimeMillis() - this.secureConnectStartTime);
    L5:
        i r1 = this.originListener;
        if (r1 == null) goto L9;
        r1.secureConnectEnd(r6, r7);
        return;
    }

    public void connectStart(Call r3, InetSocketAddress r4, Proxy r5) {
        super.connectStart(r3, r4, r5);
        if (this.needToDeal == false) goto L5;
        this.connectStartTime = System.currentTimeMillis();
    L5:
        i r0 = this.originListener;
        if (r0 == null) goto L9;
        r0.connectStart(r3, r4, r5);
        return;
    }

    public void dnsEnd(Call r5, String r6, List<InetAddress> r7) {
        super.dnsEnd(r5, r6, r7);
        i r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.dnsEnd(r5, r6, r7);
    L6:
        if (this.needToDeal == false) goto L15;
        OkHttpRecord.DetailedDuration r8 = this.okHttpRecord.timeDetailedDuration;
        r8.dns = (int) (System.currentTimeMillis() - this.dnsStartTime);
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.size() <= 0) goto L18;
        Iterator<InetAddress> r9 = r7.iterator();
    L13:
        if (r9.hasNext() == false) goto L19;
        InetAddress r10 = r9.next();
        OkHttpRecord.DnsInfo r11 = new OkHttpRecord.DnsInfo();
        r11.address = r10.getHostAddress();
        this.okHttpRecord.addressList.add(r11);
        goto L13
    L19:
        return;
    L18:
        return;
    }

    public void connectEnd(Call r2, InetSocketAddress r3, Proxy r4, Protocol r5) {
        super.connectEnd(r2, r3, r4, r5);
        i r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.connectEnd(r2, r3, r4, r5);
    L6:
        if (this.needToDeal == false) goto L17;
        OkHttpRecord.RecordResponse r6 = this.okHttpRecord.recordResponse;
        if (r4.address() == null) goto L10;
        boolean r7 = true;
    L11:
        r6.via_Proxy = r7;
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.getAddress() == null) goto L19;
        this.okHttpRecord.socketInfo.remote = r3.getAddress().getHostAddress() + ":" + r3.getPort();
        this.okHttpRecord.socketInfo.host = r3.getAddress().getHostAddress();
        this.okHttpRecord.socketInfo.port = r3.getPort() + "";
        return;
    L19:
        return;
    L10:
        r7 = false;
        goto L11
    }

    public void connectFailed(Call r7, InetSocketAddress r8, Proxy r9, Protocol r10, IOException r11) {
        super.connectFailed(r7, r8, r9, r10, r11);
        i r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.connectFailed(r7, r8, r9, r10, r11);
        return;
    }
}
