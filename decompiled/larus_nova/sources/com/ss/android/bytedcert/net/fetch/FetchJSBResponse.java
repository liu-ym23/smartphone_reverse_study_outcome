package com.ss.android.bytedcert.net.fetch;

import com.lynx.tasm.LynxError;
import com.ss.android.cert.manager.utils.net.CertResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tB\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\b8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/bytedcert/net/fetch/FetchJSBResponse;", "Lcom/ss/android/bytedcert/net/fetch/BaseResponse;", "response", "Lcom/ss/android/cert/manager/utils/net/CertResponse;", "message", "", "(Lcom/ss/android/cert/manager/utils/net/CertResponse;Ljava/lang/String;)V", LynxError.LYNX_THROWABLE, "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "mMessage", "getMessage", "()Ljava/lang/String;", "setMMessage", "mResponse", "getMResponse", "()Lcom/ss/android/cert/manager/utils/net/CertResponse;", "setMResponse", "(Lcom/ss/android/cert/manager/utils/net/CertResponse;)V", "mThrowable", "getThrowable", "()Ljava/lang/Throwable;", "setMThrowable", "(Ljava/lang/Throwable;)V", "byted_cert_core_release"}, k = 1, mv = {1, 1, 16})
public final class FetchJSBResponse extends BaseResponse {
    private String mMessage;
    private CertResponse mResponse;
    private Throwable mThrowable;

    public final CertResponse getMResponse() {
        return this.mResponse;
    }

    public final String getMessage() {
        return this.mMessage;
    }

    public final Throwable getThrowable() {
        return this.mThrowable;
    }

    public FetchJSBResponse(String r100) {
        this.mMessage = r100;
        this.mSuccess = false;
    }

    public final void setMMessage(String r100) {
        this.mMessage = r100;
    }

    public final void setMResponse(CertResponse r100) {
        this.mResponse = r100;
    }

    public final void setMThrowable(Throwable r100) {
        this.mThrowable = r100;
    }

    public FetchJSBResponse(CertResponse r100, String r101) {
        this.mResponse = r100;
        this.mBody = r100.bcResponse.getBody();
        this.mStatusCode = r100.bcResponse.getStatus();
        this.mMessage = r101;
        this.mSuccess = true;
    }

    public FetchJSBResponse(Throwable r100, String r101) {
        this.mThrowable = r100;
        this.mMessage = r101;
        this.mSuccess = false;
    }
}
