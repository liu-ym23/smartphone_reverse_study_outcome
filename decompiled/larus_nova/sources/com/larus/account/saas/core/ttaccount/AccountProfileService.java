package com.larus.account.saas.core.ttaccount;

import com.larus.account.saas.core.internal.TTAccountExecutors;
import com.larus.account.saas.coreapi.IAccountProfileService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import x38.g;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/core/ttaccount/AccountProfileService;", "Lcom/larus/account/saas/coreapi/IAccountProfileService;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class AccountProfileService implements IAccountProfileService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f286282c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f286283b;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.account.saas.coreapi.IAccountProfileService
    public final void a() {
        final String r100 = "postLoginEvent_jsb";
        final g r101 = null;
        final long r102 = this.f286283b.incrementAndGet();
        Lazy r103 = TTAccountExecutors.f286234a;
        final Function0<Unit> r104 = new AccountProfileService$refreshUserInfo$1(r102, this, r101, r100);
        Intrinsics.checkNotNullParameter(r104, "block");
        ((ExecutorService) TTAccountExecutors.f286234a.getValue()).execute(new com.larus.account.saas.core.internal.d(r104));
    }

    public AccountProfileService() {
        this.f286283b = new AtomicLong();
    }

    public static final void b(AccountProfileService r100, final g r101, final x38.a r102) {
        r100.getClass();
        if (r101 == null) goto L7;
        com.larus.account.saas.runtime.internal.util.b.f286474a.post(new d(r101, r102));
        return;
    }
}
