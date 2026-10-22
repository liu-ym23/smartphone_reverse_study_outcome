package com.ss.ugc.effectplatform.model;

import bytekn.foundation.io.file.IOException;
import com.ss.ugc.effectplatform.exception.CurrentEditingException;
import com.ss.ugc.effectplatform.exception.JsonException;
import com.ss.ugc.effectplatform.exception.MD5Exception;
import com.ss.ugc.effectplatform.exception.NetException;
import com.ss.ugc.effectplatform.exception.StatusCodeException;
import com.ss.ugc.effectplatform.exception.UnzipException;
import com.ss.ugc.effectplatform.exception.UrlNotExistException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\tB;\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001a\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006J\u0016\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006J$\u0010\u001d\u001a\u00020\u001c2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001e\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\bR\u0016\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/ugc/effectplatform/model/ExceptionResult;", "", "errorCode", "", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ILjava/lang/Exception;)V", "(I)V", "(Ljava/lang/Exception;)V", "requestUrl", "", "selectedHost", "remoteIp", "(Ljava/lang/Exception;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()I", "setErrorCode", "logId", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "msg", "getMsg", "setMsg", "getException", "setException", "", "setTrackParams", "toString", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class ExceptionResult {
    private int errorCode;
    private Exception exception;
    private String logId;
    private String msg;
    private String remoteIp;
    private String requestUrl;
    private String selectedHost;

    public String toString() {
        if (this.exception == null) goto L9;
        StringBuilder r100 = new StringBuilder("ExceptionResult{errorCode=");
        r100.append(this.errorCode);
        r100.append(", msg='");
        r100.append(this.msg);
        r100.append("', requestUrl='");
        r100.append(this.requestUrl);
        r100.append("', selectedHost='");
        r100.append(this.selectedHost);
        r100.append("', remoteIp='");
        r100.append(this.remoteIp);
        r100.append("', exception=");
        Exception r101 = this.exception;
        if (r101 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r100.append(r101.getMessage());
        r100.append('}');
        return r100.toString();
    L9:
        return "ExceptionResult{errorCode=" + this.errorCode + ", msg='" + this.msg + ", requestUrl='" + this.requestUrl + "', selectedHost='" + this.selectedHost + "', remoteIp='" + this.remoteIp + "'}";
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final Exception getException() {
        return this.exception;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMsg() {
        return this.msg;
    }

    public ExceptionResult(int r100) {
        this.errorCode = r100;
        this.msg = com.ss.ugc.effectplatform.i.a(r100);
        this.exception = null;
    }

    public final void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public final void setException(Exception r100) {
        this.exception = r100;
    }

    public final void setLogId(String r100) {
        this.logId = r100;
    }

    public final void setMsg(String r100) {
        this.msg = r100;
    }

    public ExceptionResult(Exception r100) {
        this(r100, null, null, null);
    }

    public ExceptionResult(int r100, Exception r101) {
        this.errorCode = r100;
        this.msg = com.ss.ugc.effectplatform.i.a(r100);
        this.exception = r101;
    }

    public final void setTrackParams(String r100, String r101, String r102) {
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
        if ((r100 instanceof JsonException) == false) goto L12;
        this.errorCode = 10008;
        this.msg = r100.getMessage();
        return;
    L12:
        if ((r100 instanceof UrlNotExistException) == false) goto L15;
        this.errorCode = 10015;
        this.msg = r100.getMessage();
        return;
    L15:
        if ((r100 instanceof UnzipException) == false) goto L18;
        this.errorCode = 10013;
        this.msg = r100.getMessage();
        return;
    L18:
        if ((r100 instanceof MD5Exception) == false) goto L21;
        this.errorCode = 10010;
        this.msg = r100.getMessage();
        return;
    L21:
        if ((r100 instanceof IOException) == false) goto L24;
        this.errorCode = 10012;
        this.msg = r100.getMessage();
        return;
    L24:
        if ((r100 instanceof CurrentEditingException) == false) goto L26;
        this.errorCode = 10021;
        this.msg = r100.getMessage();
        return;
    L26:
        boolean r104 = true;
        if (r100 != null) goto L29;
        this.errorCode = 1;
        this.msg = com.ss.ugc.effectplatform.i.a(1);
        return;
    L29:
        if (Intrinsics.areEqual("network unavailable", r100.getMessage()) == false) goto L31;
        int r105 = 10011;
    L32:
        this.errorCode = r105;
        String r106 = r100.getMessage();
        this.msg = r106;
        if (r106 != null) goto L35;
    L38:
        if (r104 == false) goto L50;
        this.msg = r100.toString();
        return;
    L50:
        return;
    L35:
        if (r106.length() == 0) goto L38;
        r104 = false;
        goto L38
    L31:
        r105 = 10005;
        goto L32
    }

    public /* synthetic */ ExceptionResult(Exception r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}
