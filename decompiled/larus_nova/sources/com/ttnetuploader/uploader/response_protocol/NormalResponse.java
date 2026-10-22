package com.ttnetuploader.uploader.response_protocol;

import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.api.ULLog;
import com.ttnetuploader.uploader.net.INetResponse;
import com.ttnetuploader.uploader.utils.CommonTools;

/* JADX INFO: loaded from: classes41.dex */
public class NormalResponse extends ServerResponseBase {
    private static final String TAG = "NormalResponse";

    public NormalResponse(INetResponse r100, Parameters r101) {
        super(r100, r101);
        this.mIsSuccess = CommonTools.isSuccess(r100.getCode());     // Catch: Exception -> L7
        this.mMessage = CommonTools.getNonnullStringValue(r100.getBodyJson().toString());     // Catch: Exception -> L7
        if (this.mIsSuccess == true) goto L12;
        this.mErrorLog = "Normal response failed,httpCode:" + r100.getCode() + ",msg:" + this.mMessage;     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ULLog.d(TAG, "parse error: " + e);
    }
}
