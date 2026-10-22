package com.larus.account.saas.coreapi;

import com.larus.home.impl.sdk.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/coreapi/IAccountMfaService;", "", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountMfaService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286319a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f286320a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final IAccountMfaService$Companion$EMPTY$1 f286321b = null;

        public Companion() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.account.saas.coreapi.IAccountMfaService$Companion$EMPTY$1] */
        static {
            f286320a = new Companion();
            f286321b = new IAccountMfaService$Companion$EMPTY$1();
        }
    }

    static {
        f286319a = Companion.f286320a;
    }

    void a(b r100);
}
