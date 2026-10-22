package com.bytedance.kmp.ec.yata.event.ability.request;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/ec/yata/event/ability/request/RequestFailedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "statusCode", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "", "logId", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getLogId", "()Ljava/lang/String;", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusMsg", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public final class RequestFailedException extends RuntimeException {
    private final String logId;
    private final Integer statusCode;
    private final String statusMsg;

    public final String getLogId() {
        return this.logId;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public RequestFailedException(Integer r100, String r101, String r102) {
        super("request failed. statusCode is " + r100 + ", statusCode is " + r100);
        this.statusCode = r100;
        this.statusMsg = r101;
        this.logId = r102;
    }
}
