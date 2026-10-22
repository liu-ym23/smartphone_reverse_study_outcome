package com.ss.android.cert.manager.utils.net;

import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.cert.manager.constants.ErrorConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class CertResponse {
    public BCResponse bcResponse;
    public int detailErrorCode;
    public String detailErrorMsg;
    public int errorCode;
    public String errorMsg;
    public JSONObject jsonBody;
    public JSONObject jsonData;
    public String logId;
    public boolean success;

    public String toString() {
        return "CertResponse{bcResponse=" + this.bcResponse + ", success=" + this.success + ", errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "', detailErrorCode=" + this.detailErrorCode + ", detailErrorMsg='" + this.detailErrorMsg + "', logId='" + this.logId + "', jsonBody=" + this.jsonBody + ", jsonData=" + this.jsonData + '}';
    }

    public CertResponse(BCResponse r100) {
        this.errorMsg = "";
        this.bcResponse = r100;
        if (r100 == null) goto L13;
        String r101 = r100.getBody();
    L11:
        e = move-exception;
        e.printStackTrace();
        this.errorCode = ((Integer) ErrorConstant.Client.ERROR_JSON_PARSING.first).intValue();
        this.errorMsg = (String) ErrorConstant.Client.ERROR_JSON_PARSING.second;
    L14:
        this.detailErrorCode = this.errorCode;
        this.detailErrorMsg = this.errorMsg;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L11
        this.jsonBody = r102;     // Catch: Exception -> L11
        this.errorCode = r102.optInt("status_code");     // Catch: Exception -> L11
        this.errorMsg = this.jsonBody.optString("description");     // Catch: Exception -> L11
        this.jsonData = this.jsonBody.optJSONObject("data");     // Catch: Exception -> L11
        this.logId = this.jsonBody.optString("log_id");     // Catch: Exception -> L11
        if (this.errorCode != 0) goto L14;
        this.success = true;     // Catch: Exception -> L11
        goto L14
    L13:
        this.errorCode = ((Integer) ErrorConstant.Client.ERROR_UNKNOWN.first).intValue();
        this.errorMsg = (String) ErrorConstant.Client.ERROR_UNKNOWN.second;
        goto L14
    }

    public CertResponse(Pair<Integer, String> r100) {
        this.errorMsg = "";
        if (r100 != null) goto L5;
        this.errorCode = ((Integer) ErrorConstant.Client.ERROR_UNKNOWN.first).intValue();
        this.errorMsg = (String) ErrorConstant.Client.ERROR_UNKNOWN.second;
    L6:
        this.detailErrorCode = this.errorCode;
        this.detailErrorMsg = this.errorMsg;
        return;
    L5:
        this.errorCode = ((Integer) r100.first).intValue();
        this.errorMsg = (String) r100.second;
        goto L6
    }

    public CertResponse(CertResponse r100) {
        this.errorMsg = "";
        this.bcResponse = r100.bcResponse;
        this.success = r100.success;
        this.errorCode = r100.errorCode;
        this.errorMsg = r100.errorMsg;
        this.detailErrorCode = r100.detailErrorCode;
        this.detailErrorMsg = r100.detailErrorMsg;
        this.logId = r100.logId;
        this.jsonBody = r100.jsonBody;
        this.jsonData = r100.jsonData;
    }

    public CertResponse(boolean r100) {
        this.errorMsg = "";
        this.success = r100;
    }

    public CertResponse(int r100, String r101) {
        this.errorMsg = "";
        this.errorCode = ((Integer) ErrorConstant.Client.ERROR_NETWORK_ERROR.first).intValue();
        this.errorMsg = (String) ErrorConstant.Client.ERROR_NETWORK_ERROR.second;
        this.detailErrorCode = r100;
        this.detailErrorMsg = r101;
    }

    public CertResponse(boolean r100, JSONObject r101) {
        this.errorMsg = "";
        this.success = r100;
        this.jsonData = r101;
    }
}
