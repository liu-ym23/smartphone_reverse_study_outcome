package com.bytedance.dpop;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/dpop/DPoPTicketHttpException;", "Lcom/bytedance/dpop/DPoPTicketException;", "statusCode", "", "responseBody", "", "(ILjava/lang/String;)V", "getResponseBody", "()Ljava/lang/String;", "getStatusCode", "()I", "dpopsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DPoPTicketHttpException extends DPoPTicketException {
    private final String responseBody;
    private final int statusCode;

    public final String getResponseBody() {
        return this.responseBody;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public DPoPTicketHttpException(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "responseBody");
        super("ticket request failed, http status: " + r100, null, 2, null);
        this.statusCode = r100;
        this.responseBody = r101;
    }
}
