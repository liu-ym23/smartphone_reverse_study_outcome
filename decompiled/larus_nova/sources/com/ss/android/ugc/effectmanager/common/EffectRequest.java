package com.ss.android.ugc.effectmanager.common;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class EffectRequest {
    public static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private long contentLength;
    private String errorMsg;
    protected boolean isCancel;
    private String logId;
    private Map<String, Object> mBodyParams;
    private String mContentType;
    private Map<String, String> mHeaders;
    String mHttpMethod;
    private Map<String, String> mResponseHeaders;
    private String mUrl;
    private boolean mUseCommonParams;

    public void cancel() {
        this.isCancel = true;
    }

    public String getParamsEncoding() {
        return "UTF-8";
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.mContentType;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public String getHttpMethod() {
        return this.mHttpMethod;
    }

    public String getLogId() {
        return this.logId;
    }

    public Map<String, Object> getParams() {
        return this.mBodyParams;
    }

    public Map<String, String> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isCanceled() {
        return this.isCancel;
    }

    public boolean isUseCommonParams() {
        return this.mUseCommonParams;
    }

    public void setBodyParams(Map<String, Object> r100) {
        this.mBodyParams = r100;
    }

    public void setContentLength(long r100) {
        this.contentLength = r100;
    }

    public void setContentType(String r100) {
        this.mContentType = r100;
    }

    public void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public void setHeaders(Map<String, String> r100) {
        this.mHeaders = r100;
    }

    public void setLogId(String r100) {
        this.logId = r100;
    }

    public void setResponseHeaders(Map<String, String> r100) {
        this.mResponseHeaders = r100;
    }

    public void setUseCommonParams(boolean r100) {
        this.mUseCommonParams = r100;
    }

    public EffectRequest(String r100, String r101) {
        this.isCancel = false;
        this.mUrl = "";
        this.mUseCommonParams = true;
        this.mHttpMethod = "GET";
        this.mHeaders = new HashMap();
        this.mResponseHeaders = new HashMap();
        this.mBodyParams = new HashMap();
        this.mContentType = "application/x-www-form-urlencoded";
        this.mHttpMethod = r100;
        this.mUrl = r101;
        this.mUseCommonParams = true;
    }

    public EffectRequest(String r100, String r101, boolean r102) {
        this.isCancel = false;
        this.mUrl = "";
        this.mUseCommonParams = true;
        this.mHttpMethod = "GET";
        this.mHeaders = new HashMap();
        this.mResponseHeaders = new HashMap();
        this.mBodyParams = new HashMap();
        this.mContentType = "application/x-www-form-urlencoded";
        this.mHttpMethod = r100;
        this.mUrl = r101;
        this.mUseCommonParams = r102;
    }
}
