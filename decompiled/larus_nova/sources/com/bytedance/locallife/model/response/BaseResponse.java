package com.bytedance.locallife.model.response;

import com.bytedance.locallife.model.response.exceptions.ApiServerException;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import xv6.a;

/* JADX INFO: loaded from: classes21.dex */
public class BaseResponse extends a {
    public int error_code;
    public ServerTimeExtra extra;
    private volatile Map<String, Object> mLocalExtra;
    public String message;
    public String prompts;
    public int status_code;
    public String status_msg;

    @SerializedName("verify_captcha_data")
    public VerifyCaptchaData verify_data;

    public static class ServerTimeExtra {
        public String logid;
        public long now;

        public ServerTimeExtra() {
        }

        public String toString() {
            return "{now=" + this.now + ", logid='" + this.logid + "'}";
        }
    }

    private void checkStatusCode() throws ApiServerException {
        if (this.status_code != 0) goto L6;
        return;
    L6:
        throw new ApiServerException(this.status_code).setErrorMsg(this.status_msg).setPrompt(this.prompts).setResponse(this);
    }

    public Map<String, Object> getLocalExtra() {
        if (this.mLocalExtra != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.mLocalExtra != null) goto L10;
        this.mLocalExtra = new ConcurrentHashMap(4);     // Catch: Throwable -> L13
    L10:
        monitor-exit(this);     // Catch: Throwable -> L13
        return this.mLocalExtra;
    L5:
        return this.mLocalExtra;
    }

    public String toString() {
        return "BaseResponse{status_code=" + this.status_code + ", message='" + this.message + "', status_msg='" + this.status_msg + "', prompts='" + this.prompts + "', extra=" + this.extra + '}';
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xv6.a
    public <T> T checkValid() throws Throwable {
        checkStatusCode();
        super.checkValid();
        return this;
    }

    public BaseResponse() {
    }
}
