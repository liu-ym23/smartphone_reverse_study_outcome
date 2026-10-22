package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.ttvideoengine.net.DNSParser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class TTNetDetectInfo {
    public int actions;
    public String appVersion;
    public String clientIp;
    public List<TTNetDetectInfoBase> details;
    public int failCount;
    public String localDnsServer;
    public String nettype;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    public String f244726os;
    public String osVersion;
    public int rank;
    public int source;
    public int succCount;
    public long timestamp;

    public static class TTNetDetectHttpDnsInfo extends TTNetDetectInfoBase {
        public int cost;
        public int error;
        public String host;
        public List<String> ips;

        public TTNetDetectHttpDnsInfo() {
            this.ips = new ArrayList();
        }

        public static TTNetDetectHttpDnsInfo fromJson(JSONObject r100) {
            TTNetDetectHttpDnsInfo r101 = new TTNetDetectHttpDnsInfo();     // Catch: Throwable -> L18
            r101.host = JSONObjectProtectorUtils.getString(r100, "host");     // Catch: Throwable -> L18
            r101.error = JSONObjectProtectorUtils.getInt(r100, "error");     // Catch: Throwable -> L18
            r101.cost = JSONObjectProtectorUtils.getInt(r100, ChameleonOpenTracker.ParamKey.COST);     // Catch: Throwable -> L18
            JSONArray r102 = r100.optJSONArray("ips");     // Catch: Throwable -> L18
            if (r102 != null) goto L5;
        L17:
            return r101;
        L5:
            if (r102.length() <= 0) goto L17;
            int r103 = 0;
        L8:
            if (r103 >= r102.length()) goto L17;
            if (r102.get(r103) == null) goto L16;
            if ((r102.get(r103) instanceof String) == false) goto L16;
            String r104 = (String) r102.get(r103);     // Catch: Throwable -> L18
            if (TextUtils.isEmpty(r104) == true) goto L16;
            r101.ips.add(r104);     // Catch: Throwable -> L18
        L16:
            r103 = r103 + 1;
        L18:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public static class TTNetDetectHttpGetInfo extends TTNetDetectInfoBase {
        public int cached;
        public int dnsCost;
        public int errorCode;
        public int httpCode;

        /* JADX INFO: renamed from: ip, reason: collision with root package name */
        public String f244727ip;
        public int port;
        public int recvBytes;
        public int recvCost;
        public int sendCost;
        public int sockReused;
        public int sslCost;
        public int tcpCost;
        public int timeout;
        public int totalCost;
        public String url;
        public int waitCost;

        public TTNetDetectHttpGetInfo() {
        }

        public static TTNetDetectHttpGetInfo fromJson(JSONObject r100) {
            TTNetDetectHttpGetInfo r101 = new TTNetDetectHttpGetInfo();     // Catch: Throwable -> L4
            r101.url = JSONObjectProtectorUtils.getString(r100, "url");     // Catch: Throwable -> L4
            r101.httpCode = JSONObjectProtectorUtils.getInt(r100, "httpcode");     // Catch: Throwable -> L4
            r101.errorCode = JSONObjectProtectorUtils.getInt(r100, "error");     // Catch: Throwable -> L4
            r101.timeout = JSONObjectProtectorUtils.getInt(r100, "timeout");     // Catch: Throwable -> L4
            r101.f244727ip = JSONObjectProtectorUtils.getString(r100, "addr");     // Catch: Throwable -> L4
            r101.port = JSONObjectProtectorUtils.getInt(r100, "port");     // Catch: Throwable -> L4
            r101.cached = JSONObjectProtectorUtils.getInt(r100, "cached");     // Catch: Throwable -> L4
            r101.sockReused = JSONObjectProtectorUtils.getInt(r100, "sock_reused");     // Catch: Throwable -> L4
            r101.totalCost = JSONObjectProtectorUtils.getInt(r100, "totalcost");     // Catch: Throwable -> L4
            r101.dnsCost = JSONObjectProtectorUtils.getInt(r100, "dnscost");     // Catch: Throwable -> L4
            r101.tcpCost = JSONObjectProtectorUtils.getInt(r100, "tcpcost");     // Catch: Throwable -> L4
            r101.sslCost = JSONObjectProtectorUtils.getInt(r100, "sslcost");     // Catch: Throwable -> L4
            r101.sendCost = JSONObjectProtectorUtils.getInt(r100, "sendcost");     // Catch: Throwable -> L4
            r101.waitCost = JSONObjectProtectorUtils.getInt(r100, "waitcost");     // Catch: Throwable -> L4
            r101.recvCost = JSONObjectProtectorUtils.getInt(r100, "recvcost");     // Catch: Throwable -> L4
            r101.recvBytes = JSONObjectProtectorUtils.getInt(r100, "recvd_bytes");     // Catch: Throwable -> L4
            return r101;
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public static class TTNetDetectInfoBase {
        public TTNetDetectInfoBase() {
        }
    }

    public static class TTNetDetectLocalDnsInfo extends TTNetDetectInfoBase {
        public int cost;
        public int error;
        public String host;
        public List<String> ips;

        public TTNetDetectLocalDnsInfo() {
            this.ips = new ArrayList();
        }

        public static TTNetDetectLocalDnsInfo fromJson(JSONObject r100) {
            TTNetDetectLocalDnsInfo r101 = new TTNetDetectLocalDnsInfo();     // Catch: Throwable -> L18
            r101.host = JSONObjectProtectorUtils.getString(r100, "host");     // Catch: Throwable -> L18
            r101.error = JSONObjectProtectorUtils.getInt(r100, "error");     // Catch: Throwable -> L18
            r101.cost = JSONObjectProtectorUtils.getInt(r100, ChameleonOpenTracker.ParamKey.COST);     // Catch: Throwable -> L18
            JSONArray r102 = r100.optJSONArray("ips");     // Catch: Throwable -> L18
            if (r102 != null) goto L5;
        L17:
            return r101;
        L5:
            if (r102.length() <= 0) goto L17;
            int r103 = 0;
        L8:
            if (r103 >= r102.length()) goto L17;
            if (r102.get(r103) == null) goto L16;
            if ((r102.get(r103) instanceof String) == false) goto L16;
            String r104 = (String) r102.get(r103);     // Catch: Throwable -> L18
            if (TextUtils.isEmpty(r104) == true) goto L16;
            r101.ips.add(r104);     // Catch: Throwable -> L18
        L16:
            r103 = r103 + 1;
        L18:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public static class TTNetDetectPingInfo extends TTNetDetectInfoBase {
        public int avgCost;
        public int error;
        public String host;

        /* JADX INFO: renamed from: ip, reason: collision with root package name */
        public String f244728ip;
        public int pingTimes;
        public int succTimes;

        public TTNetDetectPingInfo() {
        }

        public static TTNetDetectPingInfo fromJson(JSONObject r100) {
            TTNetDetectPingInfo r101 = new TTNetDetectPingInfo();     // Catch: Throwable -> L4
            r101.host = JSONObjectProtectorUtils.getString(r100, "host");     // Catch: Throwable -> L4
            r101.f244728ip = JSONObjectProtectorUtils.getString(r100, DNSParser.DNS_RESULT_IP);     // Catch: Throwable -> L4
            r101.error = JSONObjectProtectorUtils.getInt(r100, "error");     // Catch: Throwable -> L4
            r101.pingTimes = JSONObjectProtectorUtils.getInt(r100, "ping_times");     // Catch: Throwable -> L4
            r101.succTimes = JSONObjectProtectorUtils.getInt(r100, "succ_times");     // Catch: Throwable -> L4
            r101.avgCost = JSONObjectProtectorUtils.getInt(r100, "avg_cost");     // Catch: Throwable -> L4
            return r101;
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public static class TTNetDetectTracerouteInfo extends TTNetDetectInfoBase {
        public List<TracerouteHopInfo> details;
        public int error;
        public String host;

        /* JADX INFO: renamed from: ip, reason: collision with root package name */
        public String f244729ip;
        public int tryHops;

        public TTNetDetectTracerouteInfo() {
            this.details = new ArrayList();
        }

        public static TTNetDetectTracerouteInfo fromJson(JSONObject r100) {
            TTNetDetectTracerouteInfo r101 = new TTNetDetectTracerouteInfo();     // Catch: Throwable -> L14
            r101.host = JSONObjectProtectorUtils.getString(r100, "host");     // Catch: Throwable -> L14
            r101.f244729ip = JSONObjectProtectorUtils.getString(r100, DNSParser.DNS_RESULT_IP);     // Catch: Throwable -> L14
            r101.error = JSONObjectProtectorUtils.getInt(r100, "error");     // Catch: Throwable -> L14
            r101.tryHops = JSONObjectProtectorUtils.getInt(r100, "hops");     // Catch: Throwable -> L14
            JSONArray r102 = r100.optJSONArray("detail");     // Catch: Throwable -> L14
            if (r102 != null) goto L5;
        L13:
            return r101;
        L5:
            if (r102.length() <= 0) goto L13;
            int r103 = 0;
        L8:
            if (r103 >= r102.length()) goto L13;
            TracerouteHopInfo r104 = TracerouteHopInfo.fromJson((JSONObject) r102.get(r103));     // Catch: Throwable -> L14
            if (r104 == null) goto L12;
            r101.details.add(r104);     // Catch: Throwable -> L14
        L12:
            r103 = r103 + 1;
        L14:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public static class TracerouteHopInfo {
        public int cost;

        /* JADX INFO: renamed from: ip, reason: collision with root package name */
        public String f244730ip;
        public int replyHops;
        public int sendHops;

        public TracerouteHopInfo() {
        }

        public static TracerouteHopInfo fromJson(JSONObject r100) {
            TracerouteHopInfo r101 = new TracerouteHopInfo();     // Catch: Throwable -> L4
            r101.f244730ip = JSONObjectProtectorUtils.getString(r100, DNSParser.DNS_RESULT_IP);     // Catch: Throwable -> L4
            r101.sendHops = JSONObjectProtectorUtils.getInt(r100, "sendhops");     // Catch: Throwable -> L4
            r101.replyHops = JSONObjectProtectorUtils.getInt(r100, "replyhops");     // Catch: Throwable -> L4
            r101.cost = JSONObjectProtectorUtils.getInt(r100, ChameleonOpenTracker.ParamKey.COST);     // Catch: Throwable -> L4
            return r101;
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public TTNetDetectInfo() {
        this.details = new ArrayList();
    }
}
