package com.ss.android.ugc.effectmanager.common.task;

import android.accounts.NetworkErrorException;
import com.ss.android.ugc.effectmanager.common.ErrorConstants;
import com.ss.android.ugc.effectmanager.common.exception.MD5Exception;
import com.ss.android.ugc.effectmanager.common.exception.NetException;
import com.ss.android.ugc.effectmanager.common.exception.StatusCodeException;
import com.ss.android.ugc.effectmanager.common.exception.UnzipException;
import com.ss.android.ugc.effectmanager.common.exception.UrlNotExistException;
import java.io.IOException;
import org.json.JSONException;

/* JADX INFO: loaded from: classes40.dex */
public class ExceptionResult {
    private int errorCode;
    private Exception exception;
    private String logId;
    private String msg;
    private String remoteIp;
    private String requestUrl;
    private String selectedHost;

    public String toString() {
        if (this.exception == null) goto L7;
        return "ExceptionResult{errorCode=" + this.errorCode + ", msg='" + this.msg + "', requestUrl='" + this.requestUrl + "', selectedHost='" + this.selectedHost + "', remoteIp='" + this.remoteIp + "', logId='" + this.logId + "', exception=" + this.exception.getMessage() + '}';
    L7:
        return "ExceptionResult{errorCode=" + this.errorCode + ", msg='" + this.msg + ", requestUrl='" + this.requestUrl + "', selectedHost='" + this.selectedHost + "', logId='" + this.logId + "', remoteIp='" + this.remoteIp + "'}";
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getLogId() {
        return this.logId;
    }

    public String getMsg() {
        return this.msg;
    }

    public ExceptionResult(int r100) {
        this.errorCode = r100;
        this.msg = ErrorConstants.APIErrorHandle(r100);
        this.exception = null;
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public void setException(Exception r100) {
        this.exception = r100;
    }

    public void setLogId(String r100) {
        this.logId = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }

    public ExceptionResult(Exception r100) {
        this(r100, null, null, null);
    }

    public ExceptionResult(int r100, Exception r101) {
        this.errorCode = r100;
        this.msg = ErrorConstants.APIErrorHandle(r100);
        this.exception = r101;
    }

    public void setTrackParams(String r100, String r101, String r102) {
        this.requestUrl = r100;
        this.selectedHost = r101;
        this.remoteIp = r102;
    }

    public ExceptionResult(Exception r100, String r101, String r102, String r103) {
        this.errorCode = -1;
        this.requestUrl = r101;
        this.selectedHost = r102;
        this.remoteIp = r103;
        this.exception = r100;
        if ((r100 instanceof NetException) == false) goto L6;
        this.errorCode = ((NetException) r100).getStatus_code();
        this.msg = r100.getMessage();
        return;
    L6:
        if ((r100 instanceof StatusCodeException) == false) goto L9;
        this.errorCode = ((StatusCodeException) r100).getStatusCode();
        this.msg = r100.getMessage();
        return;
    L9:
        if ((r100 instanceof JSONException) == false) goto L12;
        this.errorCode = 10008;
        this.msg = r100.getMessage();
        return;
    L12:
        if ((r100 instanceof NetworkErrorException) == false) goto L15;
        this.errorCode = 10002;
        this.msg = r100.getMessage();
        return;
    L15:
        if ((r100 instanceof UrlNotExistException) == false) goto L18;
        this.errorCode = 10015;
        this.msg = r100.getMessage();
        return;
    L18:
        if ((r100 instanceof UnzipException) == false) goto L21;
        this.errorCode = 10013;
        this.msg = r100.getMessage();
        return;
    L21:
        if ((r100 instanceof MD5Exception) == false) goto L24;
        this.errorCode = 10010;
        this.msg = r100.getMessage();
        return;
    L24:
        if ((r100 instanceof IOException) == false) goto L26;
        this.errorCode = 10012;
        this.msg = r100.getMessage();
        return;
    L26:
        if (r100 != null) goto L28;
        this.errorCode = 1;
        this.msg = ErrorConstants.APIErrorHandle(1);
        return;
    L28:
        if ("network unavailable".equals(r100.getMessage()) == false) goto L30;
        this.errorCode = 10011;
    L31:
        this.msg = r100.getMessage();
        return;
    L30:
        this.errorCode = 10005;
        goto L31
    }
}
