package com.larus.account.saas;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.account.saas.coreapi.IAccountManagementService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/larus/account/saas/coreapi/IAccountManagementService;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class FlowAccountSdk$getAccountManagementService$1 extends Lambda implements Function0<IAccountManagementService> {
    public static final FlowAccountSdk$getAccountManagementService$1 INSTANCE = null;

    static {
        INSTANCE = new FlowAccountSdk$getAccountManagementService$1();
    }

    public FlowAccountSdk$getAccountManagementService$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final IAccountManagementService invoke() {
        return (IAccountManagementService) ServiceManager.get().getService(IAccountManagementService.class);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ IAccountManagementService invoke() {
        return invoke();
    }
}
