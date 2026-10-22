package com.larus.im.internal.protocol;

import com.bytedance.android.ec.core.event.a;
import com.larus.im.internal.protocol.bean.UplinkMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002BI\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0006\u0010\u001a\u001a\u00020\u001bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/larus/im/internal/protocol/FlowIllegalNetworkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "url", "", "httpCode", "", "msg", a.KEY_EXCEPTION, "", "status", "uplinkBody", "Lcom/larus/im/internal/protocol/bean/UplinkMessage;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;ILcom/larus/im/internal/protocol/bean/UplinkMessage;)V", "getUrl", "()Ljava/lang/String;", "getHttpCode", "()I", "getMsg", "getException", "()Ljava/lang/Throwable;", "getStatus", "getUplinkBody", "()Lcom/larus/im/internal/protocol/bean/UplinkMessage;", "toString", "isHttpSuccess", "", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowIllegalNetworkException extends RuntimeException {
    private final Throwable exception;
    private final int httpCode;
    private final String msg;
    private final int status;
    private final UplinkMessage uplinkBody;
    private final String url;

    public final boolean isHttpSuccess() {
        if (this.httpCode != 200) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "url = " + this.url + " code = " + this.httpCode + " msg = " + this.msg;
    }

    public final Throwable getException() {
        return this.exception;
    }

    public final int getHttpCode() {
        return this.httpCode;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getStatus() {
        return this.status;
    }

    public final UplinkMessage getUplinkBody() {
        return this.uplinkBody;
    }

    public final String getUrl() {
        return this.url;
    }

    public FlowIllegalNetworkException(String r100, int r101, String r102, Throwable r103, int r104, UplinkMessage r105) {
        super(r102 + " trigger url = " + r100 + "  code = " + r101, r103);
        this.url = r100;
        this.httpCode = r101;
        this.msg = r102;
        this.exception = r103;
        this.status = r104;
        this.uplinkBody = r105;
    }

    public /* synthetic */ FlowIllegalNetworkException(String r110, int r111, String r112, Throwable r113, int r114, UplinkMessage r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r116 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r116 & 8) == 0) goto L13;
        Throwable r102 = null;
    L15:
        if ((r116 & 16) == 0) goto L17;
        int r103 = -1;
    L19:
        if ((r116 & 32) == 0) goto L21;
        UplinkMessage r104 = null;
    L22:
        this(r100, r111, r101, r102, r103, r104);
        return;
    L21:
        r104 = r115;
        goto L22
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
