package com.larksuite.framework.http.response;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes24.dex */
public class ErrorResult implements Serializable {
    public static final int ERROR_TYPE_BUSINESS = -3;
    public static final int ERROR_TYPE_JAVA = -1;
    public static final int ERROR_TYPE_NETWORK = -2;
    private String mErrorMessage;
    private int mErrorType;
    private int mHttpStatusCode;
    private BaseResponse mResponseModel;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorType {
    }

    public String toString() {
        return "ErrorResult{mErrorMessage='" + this.mErrorMessage + "', mErrorType=" + this.mErrorType + ", mHttpStatusCode=" + this.mHttpStatusCode + ", mResponseModel=" + this.mResponseModel + '}';
    }

    public ErrorResult() {
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public int getErrorType() {
        return this.mErrorType;
    }

    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    public BaseResponse getResponseModel() {
        return this.mResponseModel;
    }

    public void setErrorMessage(String r100) {
        this.mErrorMessage = r100;
    }

    public void setResponseModel(BaseResponse r100) {
        this.mResponseModel = r100;
    }

    public ErrorResult(int r100, int r101, String r102) {
        this.mErrorType = r100;
        this.mHttpStatusCode = r101;
        this.mErrorMessage = r102;
    }
}
