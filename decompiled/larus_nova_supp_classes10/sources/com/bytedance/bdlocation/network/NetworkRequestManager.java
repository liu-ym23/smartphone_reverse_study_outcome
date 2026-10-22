package com.bytedance.bdlocation.network;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.request.RequestUtil;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class NetworkRequestManager {
    public NetworkRequestManager() {
    }

    private static String getBaseUrl() {
        String r0 = BDLocationConfig.getBaseUrl();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        Logger.e("需要初始化时设置业务自身域名:BDLocationConfig.setBaseUrl(\"xxxx\")");
        return "";
    }

    public static String get(String r8, Map<String, String> r9, int r10) {
    L10:
        e = move-exception;
        Logger.e("NetworkRequestManager get exception:" + e.getMessage());
        return "";
    L4:
        if (BDLocationConfig.getNetworkSignatureMode().isEmpty() == true) goto L8;
        if (r9 != null) goto L7;
        r9 = new LinkedHashMap();     // Catch: Exception -> L10
    L7:
        r9.put("loc_aqua_ab", BDLocationConfig.getNetworkSignatureMode());     // Catch: Exception -> L10
    L8:
        Logger.i("NetworkRequest get Path:" + r8);     // Catch: Exception -> L10
        String r11 = (String) ((INetworkApiInner) RetrofitUtils.createSsService(getBaseUrl(), INetworkApiInner.class)).doGet(true, -1, r8, r9, RequestUtil.headerList(null, r10), null).execute().body();     // Catch: Exception -> L10
        Logger.i("NetworkRequestManager post networkResponse:" + r11);     // Catch: Exception -> L10
        return r11;
    }

    public static String postJson(String r13, TypedString r14, Map<String, String> r15) {
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L15;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return "";
    L15:
        long r4 = System.currentTimeMillis();     // Catch: Exception -> L12
        Logger.i("NetworkRequest post Path:" + r13);     // Catch: Exception -> L12
        ICustomNetworkApi r6 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L12
        if (r6 == null) goto L9;
        String r16 = r6.doPostJson(getBaseUrl(), r13, r15, r14, RequestUtil.overseaHeaderList(null), true);     // Catch: Exception -> L12
    L10:
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r4) + "--networkResponse:" + r16);     // Catch: Exception -> L12
        return r16;
    L9:
        r16 = (String) ((INetworkApi) RetrofitUtils.createSsService(getBaseUrl(), INetworkApi.class)).postBody(-1, r13, r15, r14, RequestUtil.overseaHeaderList(null)).execute().body();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return "";
    }

    public static String post(String r15, Map<String, String> r16, Map<String, String> r17, int r18) {
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L24;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return "";
    L24:
    L21:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return "";
    L7:
        if (BDLocationConfig.getNetworkSignatureMode().isEmpty() == true) goto L12;
        if (r17 != null) goto L10;
        Map<String, String> r3 = new LinkedHashMap();     // Catch: Exception -> L21
    L11:
        r3.put("loc_aqua_ab", BDLocationConfig.getNetworkSignatureMode());     // Catch: Exception -> L21
        Map<String, String> r10 = r3;
    L13:
        long r5 = System.currentTimeMillis();     // Catch: Exception -> L21
        Logger.i("NetworkRequest post Path:" + r15);     // Catch: Exception -> L21
        ICustomNetworkApi r7 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L21
        if (r7 == null) goto L16;
        SsResponse<String> r0 = r7.doPost(getBaseUrl(), r15, r10, r16, RequestUtil.headerList(null, r18), true);     // Catch: Exception -> L21
    L17:
        if (r0 != null) goto L19;
        return "";
    L19:
        String r1 = (String) r0.body();     // Catch: Exception -> L21
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r5) + "--networkResponse:" + r1);     // Catch: Exception -> L21
        return r1;
    L16:
        r0 = ((INetworkApiInner) RetrofitUtils.createSsService(getBaseUrl(), INetworkApiInner.class)).doPost(-1, r15, r10, r16, RequestUtil.headerList(null, r18), null, true).execute();     // Catch: Exception -> L21
        goto L17
    L10:
        r3 = r17;
        goto L11
    L12:
        r10 = r17;
        goto L13
    }

    public static SsResponse<String> submitPost(String r20, Map<String, String> r21, Map<String, String> r22, int r23, String r24) {
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L25;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return null;
    L25:
        boolean r9 = LocationUtil.isBackground();     // Catch: Exception -> L22
        long r5 = SystemClock.elapsedRealtime();     // Catch: Exception -> L22
        if (BDLocationConfig.getNetworkSignatureMode().isEmpty() == true) goto L12;
        if (r22 != null) goto L10;
        Map<String, String> r3 = new LinkedHashMap();     // Catch: Exception -> L22
    L11:
        r3.put("loc_aqua_ab", BDLocationConfig.getNetworkSignatureMode());     // Catch: Exception -> L22
        Map<String, String> r13 = r3;
    L13:
        long r18 = System.currentTimeMillis();     // Catch: Exception -> L22
        Logger.i("NetworkRequest post Path:" + r20);     // Catch: Exception -> L22
        ICustomNetworkApi r10 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L22
        if (r10 == null) goto L16;
        SsResponse<String> r0 = r10.doPost(getBaseUrl(), r20, r13, r21, RequestUtil.headerList(null, r23), true);     // Catch: Exception -> L22
    L17:
        if (r0 != null) goto L20;
        LocationMonitor.doSubmitSource(SystemClock.elapsedRealtime() - r5, -2, "response is null", r9, r24);     // Catch: Exception -> L22
        return null;
    L20:
        LocationMonitor.doSubmitSource(SystemClock.elapsedRealtime() - r5, 0, "response is not null", r9, r24);     // Catch: Exception -> L22
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r18));     // Catch: Exception -> L22
        return r0;
    L16:
        r0 = ((INetworkApiInner) RetrofitUtils.createSsService(getBaseUrl(), INetworkApiInner.class)).doPost(-1, r20, r13, r21, RequestUtil.headerList(null, r23), null, true).execute();     // Catch: Exception -> L22
        goto L17
    L10:
        r3 = r22;
        goto L11
    L12:
        r13 = r22;
    L22:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return null;
    }
}
