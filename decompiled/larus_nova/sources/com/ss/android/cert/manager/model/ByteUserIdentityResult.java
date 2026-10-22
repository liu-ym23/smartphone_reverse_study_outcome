package com.ss.android.cert.manager.model;

import com.ss.android.cert.manager.constants.ErrorConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class ByteUserIdentityResult {
    public int errorCode;
    public String errorMsg;
    public JSONObject extra;
    public String ticket;

    public ByteUserIdentityResult() {
        this.errorCode = ErrorConstant.Client.ERROR_UNKNOWN_EXCEPTION;
        this.errorMsg = "unknown exception";
    }

    public ByteUserIdentityResult(int r100, String r101) {
        this.errorCode = r100;
        this.errorMsg = r101;
    }
}
