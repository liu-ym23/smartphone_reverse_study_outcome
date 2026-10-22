package com.bytedance.ttnet.diagnosis;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class TTNetDiagnosisService {
    public static final int ACCELERATE_TARGET = 2;
    public static final int ACTION_FORCE_CELLULAR = 1;
    public static final int ACTION_FORCE_DEFAULT = 3;
    public static final int ACTION_FORCE_WIFI = 2;
    public static final int ACTION_UNSPECIFIED = 0;
    public static final int DIAGNOSE_TARGET = 3;
    public static final int DIAGNOSE_V2_TARGET = 4;
    public static final int DNS_RESOLVE_TARGET = 0;
    public static final int NET_DETECT_ALL = -1;
    public static final int NET_DETECT_FULL_DNS = 128;
    public static final int NET_DETECT_HTTP_GET = 1;
    public static final int NET_DETECT_HTTP_ISP = 4096;
    public static final int NET_DETECT_ICMP_PING = 2;
    public static final int NET_DETECT_LOCAL_DNS = 8;
    public static final int NET_DETECT_TCP_CONNECT = 256;
    public static final int NET_DETECT_TCP_ECHO = 512;
    public static final int NET_DETECT_TCP_PERF = 2048;
    public static final int NET_DETECT_TRACEROUTE = 4;
    public static final int NET_DETECT_UDP_PERF = 1024;
    public static final int NET_DETECT_UDP_PING = 64;
    public static final int RACE_TARGETS = 1;
    public static final int RAW_DETECT_TARGETS = 5;
    private static final Map<Integer, String> sTypeStringMap = null;

    public TTNetDiagnosisService() {
    }

    static {
        HashMap r100 = new HashMap();
        sTypeStringMap = r100;
        r100.put(0, "DNS_RESOLVE_TARGET");
        r100.put(1, "RACE_TARGETS");
        r100.put(2, "ACCELERATE_TARGET");
        r100.put(3, "DIAGNOSE_TARGET");
        r100.put(4, "DIAGNOSE_V2_TARGET");
        r100.put(5, "RAW_DETECT_TARGETS");
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Exception {
        if (HttpClient.isCronetClientEnable() == false) goto L7;
        return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    private static boolean isOneTargetRequestType(int r100) {
        if (r100 == 0) goto L18;
        if (r100 != 1) goto L6;
        return false;
    L6:
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L18;
        if (r100 == 4) goto L18;
        if (r100 != 5) goto L15;
        return false;
    L15:
        throw new IllegalArgumentException("Illegal request type: " + r100);
    L18:
        return true;
    }

    public static void reportUserLog(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L17;
        SsCronetHttpClient r101 = getCronetHttpClient();     // Catch: Exception -> L10
        if (r101 == null) goto L16;
        r101.reportNetDiagnosisUserLog(r100);     // Catch: Exception -> L10
        return;
    L16:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private static String requestTypeToString(int r100) {
        return sTypeStringMap.get(Integer.valueOf(r100));
    }

    private static boolean isValidNetDetect(int r100, long r101) {
        if (r100 != 0) goto L5;
        return true;
    L5:
        if (r100 == 1) goto L28;
        if (r100 == 2) goto L19;
        if (r100 != 3) goto L11;
    L17:
        return true;
    L11:
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L28;
        throw new IllegalArgumentException("Illegal request type: " + r100);
    L19:
        if (r101 != 1) goto L21;
    L26:
        return true;
    L21:
        if (r101 == 2) goto L26;
        if (r101 == 64) goto L26;
        return false;
    L28:
        if (((-1) & r101) != 0) goto L30;
    L32:
        return false;
    L30:
        if ((r101 & 0) != 0) goto L32;
        return true;
    }

    public static IDiagnosisRequest createRequest(int r100, List<String> r101, int r102, int r110) throws Exception {
        if (isOneTargetRequestType(r100) == true) goto L17;
        if (isValidNetDetect(r100, r102) == false) goto L15;
        if (r100 == 1) goto L13;
        if (r100 == 5) goto L13;
        return null;
    L13:
        return new TTNetDiagnosisRequest(r100, r101, r102, 0, r110);
    L15:
        throw new IllegalArgumentException("Illegal netDetectType: " + r102);
    L17:
        throw new IllegalArgumentException("Type " + requestTypeToString(r100) + " of request should be created with only one target.");
    }

    public static IDiagnosisRequest createRequest(int r100, String r101, int r102, int r103) throws Exception {
        return createRequest(r100, r101, r102, 0, r103);
    }

    public static IDiagnosisRequest createRequest(int r100, String r101, int r102, int r103, int r110) throws Exception {
        if (isOneTargetRequestType(r100) == false) goto L20;
        if (isValidNetDetect(r100, r102) == false) goto L18;
        if (r100 != 0) goto L8;
    L15:
        ArrayList r104 = new ArrayList();
        r104.add(r101);
        return new TTNetDiagnosisRequest(r100, r104, r102, r103, r110);
    L8:
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L15;
        return null;
    L18:
        throw new IllegalArgumentException("Illegal netDetectType: " + r102);
    L20:
        throw new IllegalArgumentException("Type " + requestTypeToString(r100) + " of request should be created with multiple targets.");
    }
}
