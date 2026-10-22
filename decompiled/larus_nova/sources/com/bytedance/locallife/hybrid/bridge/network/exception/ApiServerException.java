package com.bytedance.locallife.hybrid.bridge.network.exception;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes21.dex */
public class ApiServerException extends ApiException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f259043a;
    private int blockCode;
    protected String mErrorMsg;
    protected String mPrompt;
    private Object mResponse;
    protected String mUrl;

    public String convertResponseToString() {
        Object r100 = this.mResponse;
        if ((r100 instanceof String) == false) goto L7;
        return (String) r100;
    L7:
        if (f259043a != null) goto L9;
        f259043a = new Gson();
    L9:
        String r101 = GsonProtectorUtils.toJson(f259043a, this.mResponse);
        this.mResponse = r101;
        return r101;
    }

    public String getResponse() {
        return convertResponseToString();
    }

    public int getBlockCode() {
        return this.blockCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public String getPrompt() {
        return this.mPrompt;
    }

    public Object getRawResponse() {
        return this.mResponse;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ApiServerException(int r100) {
        super(r100);
    }

    public static String getErrorCode(Throwable r100) {
    L2:
        if (r100 == null) goto L7;
        if ((r100 instanceof ApiServerException) == true) goto L7;
        r100 = r100.getCause();
    L7:
        if (r100 != null) goto L11;
        return "";
    L11:
        return String.valueOf(((ApiServerException) r100).getErrorCode());
    }

    public void setBlockCode(int r100) {
        this.blockCode = r100;
    }

    public ApiServerException setErrorMsg(String r100) {
        this.mErrorMsg = r100;
        return this;
    }

    public ApiServerException setPrompt(String r100) {
        this.mPrompt = r100;
        return this;
    }

    public ApiServerException setResponse(Object r100) {
        this.mResponse = r100;
        return this;
    }

    public ApiServerException setUrl(String r100) {
        this.mUrl = r100;
        return this;
    }

    public ApiServerException setResponse(String r100) {
        this.mResponse = r100;
        return this;
    }
}
