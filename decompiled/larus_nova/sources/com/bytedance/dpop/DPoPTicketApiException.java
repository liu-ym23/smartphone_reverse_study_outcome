package com.bytedance.dpop;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/dpop/DPoPTicketApiException;", "Lcom/bytedance/dpop/DPoPTicketException;", "code", "", "msg", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMsg", "()Ljava/lang/String;", "dpopsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DPoPTicketApiException extends DPoPTicketException {
    private final Integer code;
    private final String msg;

    public final Integer getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public DPoPTicketApiException(Integer r100, String r101) {
        StringBuilder r102 = new StringBuilder("ticket request failed, code: ");
        r102.append(r100);
        r102.append(", msg: ");
        if (r101 != null) goto L5;
        String r103 = "";
    L6:
        r102.append(r103);
        super(r102.toString(), null, 2, null);
        this.code = r100;
        this.msg = r101;
        return;
    L5:
        r103 = r101;
        goto L6
    }
}
