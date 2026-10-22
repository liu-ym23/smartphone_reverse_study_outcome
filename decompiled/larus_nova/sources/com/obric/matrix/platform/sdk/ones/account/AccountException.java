package com.obric.matrix.platform.sdk.ones.account;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/AccountException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "msg", "", "cause", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "toString", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AccountException extends Exception {
    private final int code;
    private final String msg;

    public AccountException(int r100) {
        this(r100, null, null, 6, null);
    }

    public AccountException(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        this(r100, r101, null, 4, null);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "code: " + this.code + ", msg: " + this.msg + ", cause: " + getCause();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public AccountException(int r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        super(r102);
        this.code = r100;
        this.msg = r101;
    }

    public /* synthetic */ AccountException(int r100, String r101, Throwable r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
