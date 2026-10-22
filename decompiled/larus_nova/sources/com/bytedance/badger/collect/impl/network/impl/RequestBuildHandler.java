package com.bytedance.badger.collect.impl.network.impl;

import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.model.TTRequest;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.network.interfaces.IChainHandler;
import com.bytedance.badger.collect.impl.utils.KLog;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public class RequestBuildHandler implements IChainHandler {
    public RequestBuildHandler() {
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public final /* synthetic */ long getRetryDelay(int r100) {
        return IChainHandler.CC.$default$getRetryDelay(this, r100);
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public final /* synthetic */ boolean shouldRetry(TTResponse r100, int r101) {
        return IChainHandler.CC.$default$shouldRetry(this, r100, r101);
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public TTResponse handle(IChainHandler.IChain r100) throws Exception {
        TTRequest r101 = r100.getRequest();
        r101.setBaseUrl(appendParamsToUrl(r101.getBaseUrl(), r101.getQueryParams()));
        if (BadgerCollectApi.commonConfig == null) goto L8;
        if (BadgerCollectApi.commonConfig.getRequestHeaderTag() == null) goto L8;
        r101.getHeaders().putAll(BadgerCollectApi.commonConfig.getRequestHeaderTag());     // Catch: Throwable -> L10
    L8:
        KLog.d(Constants.TAGS.NETWORK, "RequestBuildHandler# build a request - " + r101);
        return r100.process(r101);
    }

    public String appendParamsToUrl(String r100, Map<String, String> r101) throws UnsupportedEncodingException {
        if (r101 != null) goto L4;
        return r100;
    L4:
        if (r101.isEmpty() == true) goto L17;
        StringBuilder r102 = new StringBuilder(r100);
        String r103 = "?";
        if (r100.contains("?") == false) goto L9;
        r103 = "&";
    L9:
        r102.append(r103);
        Iterator<Map.Entry<String, String>> r104 = r101.entrySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        Map.Entry<String, String> r105 = r104.next();
        String r106 = URLEncoder.encode(r105.getKey(), "UTF-8");
        String r107 = URLEncoder.encode(r105.getValue(), "UTF-8");
        r102.append(r106);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r107);
        r102.append("&");
        goto L11
    L13:
        r102.deleteCharAt(r102.length() - 1);
        return r102.toString();
    L17:
        return r100;
    }
}
