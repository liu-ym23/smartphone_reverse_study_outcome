package com.ss.ugc.live.sdk.msg.uplink;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/live/sdk/msg/uplink/UplinkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "statusCode", "", "message", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "logId", "(ILjava/lang/String;Ljava/lang/Exception;Ljava/lang/String;)V", "getLogId", "()Ljava/lang/String;", "getStatusCode", "()I", "message_release"}, k = 1, mv = {1, 4, 0})
public final class UplinkException extends RuntimeException {
    private final String logId;
    private final int statusCode;

    public final String getLogId() {
        return this.logId;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public UplinkException(int r100, String r101, Exception r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "message");
        super(r101, r102);
        this.statusCode = r100;
        this.logId = r103;
    }

    public /* synthetic */ UplinkException(int r100, String r101, Exception r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
