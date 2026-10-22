package com.larus.account.saas.security.api;

import e48.a;
import e48.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/security/api/IAccountRiskDialogUiService;", "", "Companion", "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountRiskDialogUiService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286483a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/security/api/IAccountRiskDialogUiService$Companion;", "Lcom/larus/account/saas/security/api/IAccountRiskDialogUiService;", "<init>", "()V", "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountRiskDialogUiService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f286484b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IAccountRiskDialogUiService> f286485c = null;

        private Companion() {
        }

        static {
            f286484b = new Companion();
            f286485c = LazyKt.lazy(IAccountRiskDialogUiService$Companion$impl$2.INSTANCE);
        }

        @Override // com.larus.account.saas.security.api.IAccountRiskDialogUiService
        public final boolean a(b r100, Function1<? super a, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "riskInfo");
            IAccountRiskDialogUiService r102 = f286485c.getValue();
            if (r102 != null) goto L7;
            return false;
        L7:
            return r102.a(r100, r101);
        }
    }

    static {
        f286483a = Companion.f286484b;
    }

    boolean a(b r100, Function1<? super a, Unit> r101);
}
