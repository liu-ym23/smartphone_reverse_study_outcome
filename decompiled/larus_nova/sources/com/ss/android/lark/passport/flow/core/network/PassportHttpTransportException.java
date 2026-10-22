package com.ss.android.lark.passport.flow.core.network;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/network/PassportHttpTransportException;", "Ljava/io/IOException;", "requestId", "", "rustCode", "", "rustStatus", "logId", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)V", "getRequestId", "()Ljava/lang/String;", "getRustCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRustStatus", "getLogId", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PassportHttpTransportException extends IOException {
    private final String logId;
    private final String requestId;
    private final Integer rustCode;
    private final Integer rustStatus;

    public final String getLogId() {
        return this.logId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Integer getRustCode() {
        return this.rustCode;
    }

    public final Integer getRustStatus() {
        return this.rustStatus;
    }

    public PassportHttpTransportException(String r100, Integer r101, Integer r102, String r103, Throwable r104) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        Intrinsics.checkNotNullParameter(r104, "cause");
        super("Rust HTTP transport failed, requestId=" + r100, r104);
        this.requestId = r100;
        this.rustCode = r101;
        this.rustStatus = r102;
        this.logId = r103;
    }
}
