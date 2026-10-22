package com.ss.android.lark.passport.flow.core.network;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/network/PassportHttpStatusException;", "Ljava/io/IOException;", "statusCode", "", "requestId", "", "logId", "responseBody", "serverCode", "bizCode", "serverMessage", "nextStep", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getStatusCode", "()I", "getRequestId", "()Ljava/lang/String;", "getLogId", "getResponseBody", "getServerCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBizCode", "getServerMessage", "getNextStep", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PassportHttpStatusException extends IOException {
    private final Integer bizCode;
    private final String logId;
    private final String nextStep;
    private final String requestId;
    private final String responseBody;
    private final Integer serverCode;
    private final String serverMessage;
    private final int statusCode;

    public final Integer getBizCode() {
        return this.bizCode;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getNextStep() {
        return this.nextStep;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getResponseBody() {
        return this.responseBody;
    }

    public final Integer getServerCode() {
        return this.serverCode;
    }

    public final String getServerMessage() {
        return this.serverMessage;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public PassportHttpStatusException(int r100, String r101, String r102, String r103, Integer r104, Integer r105, String r106, String r110) {
        Intrinsics.checkNotNullParameter(r101, "requestId");
        if (r106 != null) goto L5;
        String r107 = "Passport HTTP request failed, statusCode=" + r100 + ", requestId=" + r101;
    L6:
        super(r107);
        this.statusCode = r100;
        this.requestId = r101;
        this.logId = r102;
        this.responseBody = r103;
        this.serverCode = r104;
        this.bizCode = r105;
        this.serverMessage = r106;
        this.nextStep = r110;
        return;
    L5:
        r107 = r106;
        goto L6
    }

    public /* synthetic */ PassportHttpStatusException(int r110, String r111, String r112, String r113, Integer r114, Integer r115, String r116, String r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r211 & 16) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r211 & 32) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r211 & 64) == 0) goto L17;
        String r117 = null;
    L19:
        if ((r211 & 128) == 0) goto L21;
        String r118 = null;
    L22:
        this(r110, r111, r112, r100, r101, r102, r117, r118);
        return;
    L21:
        r118 = r210;
        goto L22
    L17:
        r117 = r116;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
