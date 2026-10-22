package com.bytedance.ugc.glue.http;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class UGCRequest<T> {
    public static final int CODE_EXCEPTION = -1;
    public static final int CODE_NOT_FOUND = 404;
    public static final int CODE_SUCESS = 200;
    public static final int CODE_UNKNOWN = 0;
    public static String HOST = "";
    public static String SCHEME = "https";
    public static boolean USE_GET_METHOD;
    private UGCCallback<T> callback;
    private UGCCallbackWithHeader<T> callbackWithHeader;
    private final HashMap<String, String> getParams;
    protected String host;
    protected JSONObject jsonParams;
    private final HashMap<String, String> params;
    protected String scheme;
    protected String url;
    protected boolean useGetMethod;

    public UGCRequest() {
        this.getParams = new HashMap();
        this.params = new HashMap();
        this.jsonParams = null;
        this.scheme = SCHEME;
        this.host = HOST;
        this.useGetMethod = USE_GET_METHOD;
    }

    public UGCCallback<T> getCallback() {
        return this.callback;
    }

    public UGCCallbackWithHeader<T> getCallbackWithHeader() {
        return this.callbackWithHeader;
    }

    public HashMap<String, String> getGetParams() {
        return this.getParams;
    }

    public String getHost() {
        return this.host;
    }

    public JSONObject getJsonParams() {
        return this.jsonParams;
    }

    public HashMap<String, String> getParams() {
        return this.params;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isUseGetMethod() {
        return this.useGetMethod;
    }

    public void send() {
        UGCHttpService.send(this);
    }

    public void setCallback(UGCCallback<T> r100) {
        this.callback = r100;
    }

    public void setCallbackWithHeader(UGCCallbackWithHeader<T> r100) {
        this.callbackWithHeader = r100;
    }

    public void addGetParam(String r100, Object r101) {
        if (r101 == null) goto L5;
        this.getParams.put(r100, String.valueOf(r101));
        return;
    }

    public void addParam(String r100, Object r101) {
        if (r101 == null) goto L5;
        this.params.put(r100, String.valueOf(r101));
        return;
    }
}
