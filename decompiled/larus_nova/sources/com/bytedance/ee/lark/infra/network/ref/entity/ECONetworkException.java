package com.bytedance.ee.lark.infra.network.ref.entity;

import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;

/* JADX INFO: loaded from: classes19.dex */
public class ECONetworkException extends Exception {
    private int mErrorCode;
    private String mErrorMsg;
    private Exception mException;

    public String getErrDigest() {
        return "「errCode=" + this.mErrorCode + ", errMsg=" + this.mErrorMsg + ", mException =" + this.mException.getMessage();
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public Exception getException() {
        return this.mException;
    }

    public ECONetworkException(int r100) {
        super("errorCode  = " + r100);
        this.mErrorCode = -1;
        this.mErrorMsg = "";
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.mErrorCode = r100;
        this.mException = new Exception("errorCode  = " + r100);
    }

    public ECONetworkException appendPrefixMsg(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.mErrorMsg = r100 + this.mErrorMsg;
    L5:
        return this;
    }

    public ECONetworkException(String r100) {
        super(r100);
        this.mErrorCode = -1;
        this.mErrorMsg = "";
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.mErrorMsg = r100;
        this.mException = new Exception(r100);
    }

    public ECONetworkException(Exception r100) {
        super(r100);
        this.mErrorCode = -1;
        this.mErrorMsg = "";
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.mErrorMsg = r100.getLocalizedMessage();
        this.mException = r100;
    }

    public ECONetworkException(int r100, String r101) {
        super(r101);
        this.mErrorCode = -1;
        this.mErrorMsg = "";
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.mErrorCode = r100;
        this.mErrorMsg = r101;
        this.mException = new Exception(r101);
    }

    public ECONetworkException(String r100, Exception r101) {
        super(r100, r101);
        this.mErrorCode = -1;
        this.mErrorMsg = "";
        new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.mErrorMsg = r100;
        this.mException = r101;
    }
}
