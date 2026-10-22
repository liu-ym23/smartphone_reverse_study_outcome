package com.ss.android.cert.manager.utils.net;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.INetWork;
import com.ss.android.cert.manager.ablity.IRequestExtraInterceptor;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class BCNetworkUtils {
    private static final Map<String, String> businessFlowParams = null;
    private static final Map<String, String> generalParams = null;
    private final NetworkEventProcessor mEventProcessor;

    public interface NetworkEventProcessor {
        void onEvent(String r100, JSONObject r101);

        void onExceptionEvent(Throwable r100, int r101);

        void performanceEvent(String r100, CertResponse r101, Integer r102, JSONObject r103, String r104);
    }

    static {
        generalParams = new HashMap();
        businessFlowParams = new HashMap();
    }

    public static void clearBusinessFlowParams() {
        businessFlowParams.clear();
    }

    private static INetWork getNetwork() {
        return CertManager.getInstance().getNetWork();
    }

    public BCNetworkUtils(NetworkEventProcessor r100) {
        this.mEventProcessor = r100;
    }

    private static Map<String, String> appendExtra(Map<String, String> r100) {
        Collection<IRequestExtraInterceptor> r101 = CertManager.getInstance().getRequestExtraInterceptors();
        if (r101 != null) goto L5;
    L12:
        return r100;
    L5:
        if (r101.size() <= 0) goto L12;
        Iterator<IRequestExtraInterceptor> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        IRequestExtraInterceptor r103 = r102.next();
        if (r103 == null) goto L8;
        r100 = r103.intercept(r100);
        goto L8
    }

    public static CertResponse convertToBDResponse(String r100) {
        return new CertResponse(new BCResponse(r100));
    }

    private static String getDetailMessage(Throwable r100) {
        StringWriter r101 = new StringWriter();     // Catch: Exception -> L4
        PrintWriter r102 = new PrintWriter(r101, true);     // Catch: Exception -> L4
        r100.printStackTrace(r102);     // Catch: Exception -> L4
        r102.flush();     // Catch: Exception -> L4
        r101.flush();     // Catch: Exception -> L4
        return r101.toString();
    L4:
        return "";
    }

    private static String getUrlPath(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L12;
    L11:
        return r100;
    L12:
        URI r101 = new URI(r100);     // Catch: Exception -> L9
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r101.getPath()) == true) goto L7;
        r102.append(r101.getPath());     // Catch: Exception -> L9
    L7:
        return r102.toString();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static Map<String, String> processEnvHeaders(Map<String, String> r100) {
        if (UrlConstant.getEnvType() != UrlConstant.EnvType.PPE) goto L7;
        if (r100 != null) goto L6;
        r100 = new HashMap();
    L6:
        r100.put(ByteNetEnvHeaderName.PPE, "1");
        r100.put("x-tt-env", UrlConstant.getEnv());
    L10:
        return r100;
    L7:
        if (r100 != null) goto L9;
        r100 = new HashMap();
    L9:
        r100.put(ByteNetEnvHeaderName.BOE, "1");
        r100.put("x-tt-env", UrlConstant.getEnv());
        goto L10
    }

    public static void putGeneralParams(Map<String, String> r100) {
        if (r100 == null) goto L5;
        generalParams.putAll(r100);
        return;
    }

    private static Map<String, String> addGeneralParams(Map<String, String> r100, boolean r101) {
        if (r100 != null) goto L4;
        r100 = new HashMap();
    L4:
        Map<String, String> r102 = generalParams;
        if (r102.size() <= 0) goto L16;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L16;
        Map.Entry<String, String> r104 = r103.next();
        if (TextUtils.isEmpty(r104.getKey()) == true) goto L8;
        if (r100.containsKey(r104.getKey()) == true) goto L8;
        if (TextUtils.isEmpty(r104.getValue()) == true) goto L8;
        r100.put(r104.getKey(), r104.getValue());
    L16:
        Map<String, String> r105 = businessFlowParams;
        if (r105.size() <= 0) goto L28;
        Iterator<Map.Entry<String, String>> r106 = r105.entrySet().iterator();
    L20:
        if (r106.hasNext() == false) goto L28;
        Map.Entry<String, String> r107 = r106.next();
        if (TextUtils.isEmpty(r107.getKey()) == true) goto L20;
        if (r100.containsKey(r107.getKey()) == true) goto L20;
        if (TextUtils.isEmpty(r107.getValue()) == true) goto L20;
        r100.put(r107.getKey(), r107.getValue());
    L28:
        if (r101 == false) goto L30;
        r100 = appendExtra(r100);
    L30:
        r100.put("sdk_version", "4.7.7-rc.13");
        return r100;
    }

    public static void putBusinessFlowParam(String r100, String r101) {
        businessFlowParams.put(r100, r101);
    }

    public static void putGeneralParam(String r100, String r101) {
        generalParams.put(r100, r101);
    }

    public void onEvent(String r100, JSONObject r101) {
        NetworkEventProcessor r102 = this.mEventProcessor;
        if (r102 != null) goto L5;
        EventLogUtils.onEvent(r100, r101);
        return;
    L5:
        r102.onEvent(r100, r101);
    }

    public void onExceptionEvent(Throwable r100, int r101) {
        NetworkEventProcessor r102 = this.mEventProcessor;
        if (r102 != null) goto L5;
        EventLogUtils.onExceptionEvent(r100, r101);
        return;
    L5:
        r102.onExceptionEvent(r100, r101);
    }

    public CertResponse postMultiPart(String r100, Map<String, String> r101, Map<String, Pair<String, byte[]>> r102) {
        return postMultiPartWithUrl(UrlConstant.getBaseUrl() + r100, null, r101, r102);
    }

    public CertResponse postMultiPartWithUrl(String r100, Map<String, String> r101, Map<String, Pair<String, byte[]>> r102) {
        return postMultiPartWithUrl(r100, null, r101, r102);
    }

    private void netPerformanceEvent(CertResponse r100, long r101, String r110, String r111) {
        JSONObject r102 = new JSONObject();
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        long r103 = System.currentTimeMillis() - r101;
        NetworkEventProcessor r104 = this.mEventProcessor;
        if (r104 != null) goto L15;
        EventLogUtils.performanceEvent(EventConstant.Event.AUTH_SDK_NETWORK_REQUEST, r100, Integer.valueOf((int) r103), r102, r111);
        return;
    L15:
        r104.performanceEvent(EventConstant.Event.AUTH_SDK_NETWORK_REQUEST, r100, Integer.valueOf((int) r103), r102, r111);
        return;
    L4:
        if (TextUtils.isEmpty(r110) == true) goto L7;
        r102.put("url_path", getUrlPath(r110));     // Catch: Exception -> L10
    L7:
        if (TextUtils.isEmpty(r100.logId) == true) goto L12;
        r102.put("log_id", r100.logId);     // Catch: Exception -> L10
        goto L12
    }

    public CertResponse fetchGet(String r100, Map<String, String> r110, Map<String, String> r111, Map<String, Object> r112) {
        return fetchGetWithUrl(UrlConstant.getBaseUrl() + r100, true, r110, r111, r112);
    }

    public CertResponse fetchPost(String r100, Map<String, String> r110, Map<String, String> r111, Map<String, Object> r112) {
        return fetchPostWithUrl(UrlConstant.getBaseUrl() + r100, true, r110, r111, r112);
    }

    public CertResponse fetchPostBody(String r100, Map<String, String> r101, String r102, Map<String, Object> r103) {
        return fetchPostBodyWithUrl(UrlConstant.getBaseUrl() + r100, r101, r102, r103);
    }

    public CertResponse fetchPostBodyWithUrl(String r100, Map<String, String> r110, String r111, Map<String, Object> r112) {
        long r101 = System.currentTimeMillis();
        INetWork r102 = getNetwork();     // Catch: Exception -> L8
        if (r102 == null) goto L7;
        CertResponse r113 = convertToBDResponse(r102.executePost(r100, r110, r111, r112));     // Catch: Exception -> L8
        netPerformanceEvent(r113, r101, r100, null);     // Catch: Exception -> L8
        return r113;
    L7:
        throw new NullPointerException("network is null");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        int r114 = ErrorConstant.checkApiException(e);
        CertResponse r115 = new CertResponse(ErrorConstant.Client.ERROR_NETWORK_ERROR);
        onExceptionEvent(e, r114);
        netPerformanceEvent(r115, r101, r100, getDetailMessage(e));
        return r115;
    }

    public CertResponse postMultiPart(String r100, Map<String, String> r101, Map<String, String> r102, Map<String, Pair<String, byte[]>> r103) {
        return postMultiPartWithUrl(UrlConstant.getBaseUrl() + r100, r101, r102, r103);
    }

    public CertResponse postMultiPartWithUrl(String r110, Map<String, String> r111, Map<String, String> r112, Map<String, Pair<String, byte[]>> r113) {
        long r100 = System.currentTimeMillis();
        Map<String, String> r114 = addGeneralParams(r112, true);     // Catch: Exception -> L20
        INetWork r101 = getNetwork();     // Catch: Exception -> L20
        if (r101 == null) goto L19;
        Uri.Builder r102 = UriProtector.parse(r110).buildUpon();     // Catch: Exception -> L20
        Iterator<Map.Entry<String, String>> r103 = r114.entrySet().iterator();     // Catch: Exception -> L20
    L7:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<String, String> r104 = r103.next();     // Catch: Exception -> L20
        if (BytedCertConstant.CertKey.FACE_DETECT_INFO.equals(r104.getKey()) == true) goto L7;
        r102.appendQueryParameter(r104.getKey(), r104.getValue());     // Catch: Exception -> L20
        String[] r105 = BytedCertConstant.SENSITIVE_KEY_SETS;     // Catch: Exception -> L20
        int r106 = r105.length;     // Catch: Exception -> L20
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L7;
        if (r105[r107].equalsIgnoreCase(r104.getKey()) == false) goto L16;
        r103.remove();     // Catch: Exception -> L20
    L16:
        r107 = r107 + 1;     // Catch: Exception -> L20
        goto L12
    L17:
        CertResponse r115 = convertToBDResponse(r101.executePostFile(r102.build().toString(), r111, r114, r113));     // Catch: Exception -> L20
        netPerformanceEvent(r115, r100, r110, null);     // Catch: Exception -> L20
        return r115;
    L19:
        throw new NullPointerException("network is null");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        int r116 = ErrorConstant.checkApiException(e);
        CertResponse r117 = new CertResponse(ErrorConstant.Client.ERROR_NETWORK_ERROR);
        onExceptionEvent(e, r116);
        netPerformanceEvent(r117, r100, r110, getDetailMessage(e));
        return r117;
    }

    public CertResponse fetchGet(String r100, boolean r110, Map<String, String> r111, Map<String, String> r112, Map<String, Object> r113) {
        return fetchGetWithUrl(UrlConstant.getBaseUrl() + r100, r110, r111, r112, r113);
    }

    public CertResponse fetchGetWithUrl(String r100, boolean r110, Map<String, String> r111, Map<String, String> r112, Map<String, Object> r113) {
        long r101 = System.currentTimeMillis();
        Map<String, String> r114 = addGeneralParams(r112, r110);     // Catch: Exception -> L8
        INetWork r115 = getNetwork();     // Catch: Exception -> L8
        if (r115 == null) goto L7;
        CertResponse r116 = convertToBDResponse(r115.executeGet(r100, r111, r114, r113));     // Catch: Exception -> L8
        netPerformanceEvent(r116, r101, r100, null);     // Catch: Exception -> L8
        return r116;
    L7:
        throw new NullPointerException("network is null");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        int r117 = ErrorConstant.checkApiException(e);
        CertResponse r118 = new CertResponse(ErrorConstant.Client.ERROR_NETWORK_ERROR);
        r118.detailErrorMsg = getDetailMessage(e);
        onExceptionEvent(e, r117);
        netPerformanceEvent(r118, r101, r100, getDetailMessage(e));
        return r118;
    }

    public CertResponse fetchPost(String r100, boolean r110, Map<String, String> r111, Map<String, String> r112, Map<String, Object> r113) {
        return fetchPostWithUrl(UrlConstant.getBaseUrl() + r100, r110, r111, r112, r113);
    }

    public CertResponse fetchPostWithUrl(String r100, boolean r110, Map<String, String> r111, Map<String, String> r112, Map<String, Object> r113) {
        long r101 = System.currentTimeMillis();
        Map<String, String> r114 = addGeneralParams(r112, r110);     // Catch: Exception -> L12
        INetWork r115 = getNetwork();     // Catch: Exception -> L12
        if (r115 == null) goto L11;
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();     // Catch: Exception -> L12
        Iterator<Map.Entry<String, String>> r103 = r114.entrySet().iterator();     // Catch: Exception -> L12
    L7:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, String> r104 = r103.next();     // Catch: Exception -> L12
        r102.appendQueryParameter(r104.getKey(), r104.getValue());     // Catch: Exception -> L12
        goto L7
    L9:
        CertResponse r116 = convertToBDResponse(r115.executePost(r102.build().toString(), r111, r114, r113));     // Catch: Exception -> L12
        netPerformanceEvent(r116, r101, r100, null);     // Catch: Exception -> L12
        return r116;
    L11:
        throw new NullPointerException("network is null");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        int r117 = ErrorConstant.checkApiException(e);
        CertResponse r118 = new CertResponse(ErrorConstant.Client.ERROR_NETWORK_ERROR);
        onExceptionEvent(e, r117);
        netPerformanceEvent(r118, r101, r100, getDetailMessage(e));
        return r118;
    }
}
