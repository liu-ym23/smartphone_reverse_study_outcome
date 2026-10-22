package com.ss.android.lark.passport.signinsdk_api.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/NetworkError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/ss/android/lark/passport/signinsdk_api/base/NetworkErrorResult;", "<init>", "(Lcom/ss/android/lark/passport/signinsdk_api/base/NetworkErrorResult;)V", "getError", "()Lcom/ss/android/lark/passport/signinsdk_api/base/NetworkErrorResult;", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkError extends Exception {
    private final NetworkErrorResult error;

    public final NetworkErrorResult getError() {
        return this.error;
    }

    public NetworkError(NetworkErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.error = r100;
    }
}
