package com.ss.android.lark.officesdk.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/ServiceTimeoutException;", "Lcom/ss/android/lark/officesdk/api/OfficeSDKException;", "serviceName", "", "timeoutMs", "", "<init>", "(Ljava/lang/String;J)V", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ServiceTimeoutException extends OfficeSDKException {
    public ServiceTimeoutException(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        super("Service acquisition timed out after " + r101 + "ms: " + r100, null, 2, null);
    }
}
