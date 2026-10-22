package com.ss.android.lark.security.compliance.infra.network;

import com.lynx.tasm.LynxError;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0017¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\nJ\b\u0010#\u001a\u00020\u0007H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e¨\u0006$"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/network/NetworkErrorResult;", "Ljava/io/Serializable;", "<init>", "()V", "errorCode", "", "errorMessage", "", "logId", "bizCode", "(ILjava/lang/String;Ljava/lang/String;I)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "getLogId", "setLogId", "originalErrorCode", "getOriginalErrorCode", "setOriginalErrorCode", "errorType", "getErrorType", "setErrorType", LynxError.LYNX_THROWABLE, "", "getThrowable", "()Ljava/lang/Throwable;", "setThrowable", "(Ljava/lang/Throwable;)V", "getBizCode", "setBizCode", "toString", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkErrorResult implements Serializable {
    private int bizCode;
    private int errorCode;
    private String errorMessage;
    private int errorType;
    private String logId;
    private int originalErrorCode;
    private Throwable throwable;

    public NetworkErrorResult(int r100, String r101) {
        this(r100, r101, null, 0, 12, null);
    }

    public NetworkErrorResult(int r100, String r101, String r110) {
        this(r100, r101, r110, 0, 8, null);
    }

    public String toString() {
        return "mErrorCode=" + this.errorCode + ", mErrorMessage='" + this.errorMessage + ", mErrorType= " + this.errorType + ",logId=" + this.logId;
    }

    @Deprecated(message = "")
    public NetworkErrorResult() {
        this.bizCode = -1;
    }

    public final int getBizCode() {
        return this.bizCode;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final int getErrorType() {
        return this.errorType;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final int getOriginalErrorCode() {
        return this.originalErrorCode;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final void setBizCode(int r100) {
        this.bizCode = r100;
    }

    public final void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public final void setErrorMessage(String r100) {
        this.errorMessage = r100;
    }

    public final void setErrorType(int r100) {
        this.errorType = r100;
    }

    public final void setLogId(String r100) {
        this.logId = r100;
    }

    public final void setOriginalErrorCode(int r100) {
        this.originalErrorCode = r100;
    }

    public final void setThrowable(Throwable r100) {
        this.throwable = r100;
    }

    public NetworkErrorResult(int r100, String r101, String r102, int r103) {
        this.bizCode = -1;
        this.errorCode = r100;
        this.originalErrorCode = r100;
        this.errorMessage = r101;
        if (r100 <= 0) goto L5;
        this.errorType = -7;
    L5:
        this.bizCode = r103;
        this.logId = r102;
    }

    public /* synthetic */ NetworkErrorResult(int r100, String r101, String r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = -1;
    L8:
        this(r100, r101, r102, r103);
    }
}
