package com.bytedance.sdk.account.platform.base;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class OnekeyLoginErrorResponse extends AuthorizeErrorResponse {
    public int error;
    public String errorMsg;
    public int errorType;
    public long mCancelApplyTime;
    public String mCancelAvatarUrl;
    public String mCancelNickName;
    public long mCancelTime;
    public String mCancelToken;
    public String mConfirmSwitchBindTips;
    public String mConfirmSwitchBindUrl;
    public int mDetailErrorCode;
    public String mDetailErrorMsg;
    public int netStatus;
    public String netType;
    public JSONObject rawResult;
    public String resultCode;
    public String smsCodeKey;

    public OnekeyLoginErrorResponse() {
        this.netType = "";
        this.netStatus = -1;
    }
}
