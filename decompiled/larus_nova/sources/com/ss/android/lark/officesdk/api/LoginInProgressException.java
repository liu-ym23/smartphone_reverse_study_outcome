package com.ss.android.lark.officesdk.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/api/LoginInProgressException;", "Lcom/ss/android/lark/officesdk/api/OfficeSDKException;", "message", "", "<init>", "(Ljava/lang/String;)V", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginInProgressException extends OfficeSDKException {
    /* JADX WARN: Multi-variable type inference failed */
    public LoginInProgressException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public LoginInProgressException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100, null, 2, null);
    }

    public /* synthetic */ LoginInProgressException(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "User login is in progress";
    L5:
        this(r100);
    }
}
