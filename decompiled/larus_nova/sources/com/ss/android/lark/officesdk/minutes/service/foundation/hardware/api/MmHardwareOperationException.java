package com.ss.android.lark.officesdk.minutes.service.foundation.hardware.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/hardware/api/MmHardwareOperationException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "code", "", "message", "", "debugMessage", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getDebugMessage", "()Ljava/lang/String;", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmHardwareOperationException extends IllegalStateException {
    private final int code;
    private final String debugMessage;

    public final int getCode() {
        return this.code;
    }

    public final String getDebugMessage() {
        return this.debugMessage;
    }

    public MmHardwareOperationException(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "debugMessage");
        super("code=" + r100 + ", message=" + r101 + ", debugMessage=" + r102);
        this.code = r100;
        this.debugMessage = r102;
    }

    public /* synthetic */ MmHardwareOperationException(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = r101;
    L5:
        this(r100, r101, r102);
    }
}
