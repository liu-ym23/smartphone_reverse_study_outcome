package com.ss.android.lark.security.compliance.infra.network.service;

import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/network/service/NetworkErrorResultException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "networkErrorResult", "Lcom/ss/android/lark/security/compliance/infra/network/NetworkErrorResult;", "<init>", "(Lcom/ss/android/lark/security/compliance/infra/network/NetworkErrorResult;)V", "getNetworkErrorResult", "()Lcom/ss/android/lark/security/compliance/infra/network/NetworkErrorResult;", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkErrorResultException extends Exception {
    private final NetworkErrorResult networkErrorResult;

    public final NetworkErrorResult getNetworkErrorResult() {
        return this.networkErrorResult;
    }

    public NetworkErrorResultException(NetworkErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "networkErrorResult");
        super(r100.toString());
        this.networkErrorResult = r100;
    }
}
