package com.bytedance.kmp.network;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0011\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b.\u0010/R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000f\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\"\u0010)\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000f\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R\u0014\u0010-\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0011¨\u00060"}, d2 = {"Lcom/bytedance/kmp/network/NetError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "cronetInternalError", "I", "getCronetInternalError", "()I", "setCronetInternalError", "(I)V", "ttnetStatusCode", "getTtnetStatusCode", "setTtnetStatusCode", "", "cronetRequestLog", "Ljava/lang/String;", "getCronetRequestLog", "()Ljava/lang/String;", "setCronetRequestLog", "(Ljava/lang/String;)V", "errorMessage", "getErrorMessage", "setErrorMessage", "", "Lcom/bytedance/kmp/network/b;", "errorRespHeader", "Ljava/util/List;", "getErrorRespHeader", "()Ljava/util/List;", "setErrorRespHeader", "(Ljava/util/List;)V", "", "errorRespBody", "[B", "getErrorRespBody", "()[B", "setErrorRespBody", "([B)V", "ttnetErrorOriginalCause", "getTtnetErrorOriginalCause", "setTtnetErrorOriginalCause", "exceptionStackTrackStr", "getExceptionStackTrackStr", "setExceptionStackTrackStr", "getMessage", "message", "<init>", "()V", "network_service_release"}, k = 1, mv = {1, 7, 0})
public final class NetError extends RuntimeException {
    private int cronetInternalError;
    private String cronetRequestLog;
    private String errorMessage;
    private byte[] errorRespBody;
    private List<b> errorRespHeader;
    private String exceptionStackTrackStr;
    private String ttnetErrorOriginalCause;
    private int ttnetStatusCode;

    public NetError() {
        this.cronetRequestLog = "";
        this.errorMessage = "";
        this.errorRespHeader = CollectionsKt.emptyList();
        this.ttnetErrorOriginalCause = "";
        this.exceptionStackTrackStr = "";
    }

    public final int getCronetInternalError() {
        return this.cronetInternalError;
    }

    public final String getCronetRequestLog() {
        return this.cronetRequestLog;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final byte[] getErrorRespBody() {
        return this.errorRespBody;
    }

    public final List<b> getErrorRespHeader() {
        return this.errorRespHeader;
    }

    public final String getExceptionStackTrackStr() {
        return this.exceptionStackTrackStr;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.errorMessage;
    }

    public final String getTtnetErrorOriginalCause() {
        return this.ttnetErrorOriginalCause;
    }

    public final int getTtnetStatusCode() {
        return this.ttnetStatusCode;
    }

    public final void setCronetInternalError(int r100) {
        this.cronetInternalError = r100;
    }

    public final void setCronetRequestLog(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cronetRequestLog = r100;
    }

    public final void setErrorMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorMessage = r100;
    }

    public final void setErrorRespBody(byte[] r100) {
        this.errorRespBody = r100;
    }

    public final void setErrorRespHeader(List<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorRespHeader = r100;
    }

    public final void setExceptionStackTrackStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.exceptionStackTrackStr = r100;
    }

    public final void setTtnetErrorOriginalCause(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ttnetErrorOriginalCause = r100;
    }

    public final void setTtnetStatusCode(int r100) {
        this.ttnetStatusCode = r100;
    }
}
