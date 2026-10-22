package com.ss.android.lark.chameleon.api;

import com.ss.android.lark.chameleon.bridge.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleon/api/LarkAPIError;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "errorCode", "", "errorMsg", "", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LarkAPIError implements NonProguard {
    private final int errorCode;
    private final String errorMsg;

    public static /* synthetic */ LarkAPIError copy$default(LarkAPIError r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.errorCode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.errorMsg;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final LarkAPIError copy(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        return new LarkAPIError(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkAPIError) == true) goto L8;
        return false;
    L8:
        LarkAPIError r101 = (LarkAPIError) r100;
        if (this.errorCode == r101.errorCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.errorCode * 31) + this.errorMsg.hashCode();
    }

    public String toString() {
        return "LarkAPIError(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public LarkAPIError(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        this.errorCode = r100;
        this.errorMsg = r101;
    }
}
