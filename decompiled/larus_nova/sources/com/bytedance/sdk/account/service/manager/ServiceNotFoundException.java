package com.bytedance.sdk.account.service.manager;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/account/service/manager/ServiceNotFoundException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "serviceClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "account-sdk-service-manager_release"}, k = 1, mv = {1, 1, 15})
public final class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException(Class<?> r100) {
        super("Cannot find implementation for service ".concat(r100.getName()));
    }
}
