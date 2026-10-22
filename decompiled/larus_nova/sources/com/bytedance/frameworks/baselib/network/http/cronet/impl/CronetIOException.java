package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class CronetIOException extends TTNetExceptionStorage {
    private final int cronetInternalErrorCode;
    private CronetRequestExtraInfo cronetInternalExtraInfo;
    private int statusCode;

    public BaseHttpRequestInfo getRequestInfo() {
        return (BaseHttpRequestInfo) this.infoObj;
    }

    public String getRequestLog() {
        return getRequestInfo().requestLog;
    }

    public int getCronetInternalErrorCode() {
        return this.cronetInternalErrorCode;
    }

    public CronetRequestExtraInfo getCronetRequestExtraInfo() {
        return this.cronetInternalExtraInfo;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public CronetIOException(Exception r100, BaseHttpRequestInfo r110, int r111) {
        String r101 = r100.getMessage();
        if (r100.getCause() != null) goto L5;
        Throwable r102 = r100;
    L6:
        super(r101, r102);
        URL r103 = r110.url;
        if (r103 == null) goto L9;
        String r104 = r103.toString();
    L10:
        super.setInfo(false, true, r104, r110.traceCode, r110);
        this.cronetInternalErrorCode = r111;
        if ((r100 instanceof HttpResponseException) == false) goto L13;
        this.statusCode = ((HttpResponseException) r100).getStatusCode();
    L13:
        Object r105 = r110.metrics.networklib.misc.requestExtraInfo;
        if ((r105 instanceof CronetRequestExtraInfo) == false) goto L17;
        this.cronetInternalExtraInfo = (CronetRequestExtraInfo) r105;
        return;
    L17:
        return;
    L9:
        r104 = "";
        goto L10
    L5:
        r102 = r100.getCause();
        goto L6
    }
}
