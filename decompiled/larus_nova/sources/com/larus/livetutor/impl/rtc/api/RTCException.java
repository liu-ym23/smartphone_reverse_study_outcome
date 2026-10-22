package com.larus.livetutor.impl.rtc.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/livetutor/impl/rtc/api/RTCException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "Lcom/larus/livetutor/impl/rtc/api/RTCErrorCode;", "errorMsg", "", "<init>", "(Lcom/larus/livetutor/impl/rtc/api/RTCErrorCode;Ljava/lang/String;)V", "getErrorCode", "()Lcom/larus/livetutor/impl/rtc/api/RTCErrorCode;", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RTCException extends Exception {
    private final RTCErrorCode errorCode;
    private final String errorMsg;

    public static /* synthetic */ RTCException copy$default(RTCException r100, RTCErrorCode r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.errorCode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.errorMsg;
    L9:
        return r100.copy(r101, r102);
    }

    public final RTCErrorCode component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final RTCException copy(RTCErrorCode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        return new RTCException(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RTCException) == true) goto L8;
        return false;
    L8:
        RTCException r101 = (RTCException) r100;
        if (this.errorCode == r101.errorCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.errorCode.hashCode() * 31) + this.errorMsg.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "RTCException(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
    }

    public final RTCErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public RTCException(RTCErrorCode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        super(r101);
        this.errorCode = r100;
        this.errorMsg = r101;
    }
}
