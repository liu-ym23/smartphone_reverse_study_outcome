package com.bytedance.sdk.open.aweme.commonbase.net;

import android.content.Context;
import com.bytedance.sdk.open.aweme.common.constants.OpenConstants;
import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenException;
import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor;
import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.c;
import com.bytedance.sdk.open.aweme.commonbase.net.mime.FormUrlEncodedRequestBody;
import com.bytedance.sdk.open.aweme.commonbase.net.mime.JsonRequestBody;
import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;
import com.bytedance.sdk.open.aweme.core.net.OpenNetHeaders;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class OpenNetworkManager {
    private static volatile OpenNetworkManager INSTANCE;
    private static volatile Map<String, OpenInterceptor> sInterceptorAndDecoratorMap;
    private static volatile CopyOnWriteArrayList<OpenInterceptor> sInterceptors;
    private Context mContext;

    static {
        sInterceptors = new CopyOnWriteArrayList();
        sInterceptorAndDecoratorMap = new ConcurrentHashMap();
    }

    private OpenNetworkManager(Context r100) {
        this.mContext = r100.getApplicationContext();
    }

    public static synchronized void addInterceptor(OpenInterceptor r100) {
        monitor-enter(OpenNetworkManager.class);
        if (r100 != null) goto L15;
        monitor-exit(OpenNetworkManager.class);
        return;
    L15:
        String r101 = r100.getClass().getName();     // Catch: Throwable -> L12
        if (sInterceptorAndDecoratorMap.containsKey(r101) == true) goto L10;
        sInterceptors.add(r100);     // Catch: Throwable -> L12
        sInterceptorAndDecoratorMap.put(r101, r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(OpenNetworkManager.class);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private OpenHostResponse getResponseWithInterceptorChain(OpenHostRequest r110) {
        LinkedList r100 = new LinkedList();     // Catch: Exception -> L8
        if (sInterceptors == null) goto L6;
        r100.addAll(sInterceptors);     // Catch: Exception -> L8
    L6:
        r100.add(new com.bytedance.sdk.open.aweme.commonbase.net.interceptor.b());     // Catch: Exception -> L8
        r100.add(new com.bytedance.sdk.open.aweme.commonbase.net.interceptor.a());     // Catch: Exception -> L8
        return new c(r100, 0, r110).proceed(r110);
    L8:
        e = move-exception;
        if ((e instanceof OpenException) == false) goto L12;
        OpenException r101 = (OpenException) e;
        OpenHostResponse r102 = new OpenHostResponse(r101.getErrCode(), r101.getErrMsg(), r110.getUrl(), OpenNetHeaders.empty, null, e);
    L13:
        LogUtils.e("", new Object[]{e});
        return r102;
    L12:
        r102 = new OpenHostResponse(-1, e.getMessage(), r110.getUrl(), OpenNetHeaders.empty, null, e);
        goto L13
    }

    private OpenHostRequest handleOpenRequest(OpenHostRequest r100) {
        if (DouYinSdkContext.inst().isBoe() == true) goto L5;
        return r100;
    L5:
        if (r100.getUrl() != null) goto L7;
        return r100;
    L7:
        if (r100.getUrl().startsWith(OpenConstants.OPEN_DOMAIN) == false) goto L11;
        String r101 = r100.getUrl().replaceFirst(OpenConstants.OPEN_DOMAIN, OpenConstants.BOE_OPEN_DOMAIN);
        OpenHostRequest.Builder r102 = new OpenHostRequest.Builder(r100);
    L15:
        return r102.url(r101).build();
    L11:
        if (r100.getUrl().startsWith(OpenConstants.CLIENT_DOMAIN) == false) goto L16;
        r101 = r100.getUrl().replaceFirst(OpenConstants.CLIENT_DOMAIN, OpenConstants.BOE_CLIENT_DOMAIN);
        r102 = new OpenHostRequest.Builder(r100);
        goto L15
    L16:
        return r100;
    }

    public static OpenNetworkManager with(Context r100) {
        if (INSTANCE != null) goto L15;
        monitor-enter(OpenNetworkManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new OpenNetworkManager(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(OpenNetworkManager.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    public OpenHostResponse execute(OpenHostRequest r100) {
        return getResponseWithInterceptorChain(handleOpenRequest(r100));
    }

    public OpenHostResponse get(String r100) {
        return execute(new OpenHostRequest.Builder(r100).get().build());
    }

    public OpenHostResponse get(String r100, Map<String, String> r101) {
        return execute(new OpenHostRequest.Builder(r100).get().setHeaders(r101).build());
    }

    public OpenHostResponse get(String r100, Map<String, String> r101, long r102) {
        return execute(new OpenHostRequest.Builder(r100).get().setHeaders(r101).build());
    }

    public IOpenHostNetCall newCall(OpenHostRequest r100) {
        OpenHostRequest r101 = handleOpenRequest(r100);
        OpenNetworkService r102 = (OpenNetworkService) OpenServiceManager.getInst().getService(OpenNetworkService.class);
        if (r102 != null) goto L6;
        r102 = new a();
    L6:
        return r102.newCall(r101);
    }

    public OpenHostResponse postJson(String r100, JSONObject r101) {
        return execute(new OpenHostRequest.Builder(r100).post(new JsonRequestBody(r101)).build());
    }

    public OpenHostResponse postJson(String r100, JSONObject r101, Map<String, String> r102) {
        return execute(new OpenHostRequest.Builder(r100).post(new JsonRequestBody(r101)).setHeaders(r102).build());
    }

    public OpenHostResponse postJson(String r100, JSONObject r101, Map<String, String> r102, long r103) {
        return execute(new OpenHostRequest.Builder(r100).post(new JsonRequestBody(r101)).setHeaders(r102).connectTimeOut(r103).readTimeOut(r103).writeTimeOut(r103).build());
    }

    public OpenHostResponse postUrlEncode(String r100, Map<String, String> r101, Map<String, String> r102) {
        FormUrlEncodedRequestBody r103 = new FormUrlEncodedRequestBody();
        if (r102 == null) goto L6;
        r103.addFields(r102);
    L6:
        return execute(new OpenHostRequest.Builder(r100).post(r103).setHeaders(r101).build());
    }

    public OpenHostResponse postUrlEncode(String r100, Map<String, String> r101, Map<String, String> r102, boolean r103) {
        FormUrlEncodedRequestBody r104 = new FormUrlEncodedRequestBody();
        if (r102 == null) goto L6;
        r104.addFields(r102);
    L6:
        return execute(new OpenHostRequest.Builder(r100).post(r104).setHeaders(r101).addHostCommonParams(r103).build());
    }
}
