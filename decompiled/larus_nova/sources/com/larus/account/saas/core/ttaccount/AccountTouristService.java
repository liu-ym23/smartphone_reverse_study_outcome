package com.larus.account.saas.core.ttaccount;

import com.larus.account.saas.coreapi.IAccountTouristService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/core/ttaccount/AccountTouristService;", "Lcom/larus/account/saas/coreapi/IAccountTouristService;", "<init>", "()V", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class AccountTouristService implements IAccountTouristService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f286285a;

    public AccountTouristService() {
        this.f286285a = LazyKt.lazy(AccountTouristService$visitorManager$2.INSTANCE);
    }
}
