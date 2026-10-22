package com.bytedance.lark.open_app_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/lark/open_app_android/OpenAppFfiError;", "Lcom/bytedance/lark/open_app_android/UnhandledException;", "errorMsg", "", "errorCode", "", "(Ljava/lang/String;I)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "into", "Lopen_app/proto/OpenAppFfiError;", "toString", "open_app_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OpenAppFfiError extends UnhandledException {
    private int errorCode;
    private String errorMsg;

    public static /* synthetic */ OpenAppFfiError copy$default(OpenAppFfiError r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.errorMsg;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.errorCode;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.errorMsg;
    }

    public final int component2() {
        return this.errorCode;
    }

    public final OpenAppFfiError copy(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        return new OpenAppFfiError(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenAppFfiError) == true) goto L8;
        return false;
    L8:
        OpenAppFfiError r101 = (OpenAppFfiError) r100;
        if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L12;
        return false;
    L12:
        if (this.errorCode == r101.errorCode) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.errorMsg.hashCode() * 31) + this.errorCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "OpenAppFfiError(errorMsg=" + this.errorMsg + ", errorCode=" + this.errorCode + ')';
    }

    public final open_app.proto.OpenAppFfiError into() {
        return new open_app.proto.OpenAppFfiError(this.errorMsg, Integer.valueOf(this.errorCode));
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public final void setErrorMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorMsg = r100;
    }

    public OpenAppFfiError(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        super(null, 1, null);
        this.errorMsg = r100;
        this.errorCode = r101;
    }
}
