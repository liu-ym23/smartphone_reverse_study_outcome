package com.larus.account.saas.coreapi;

import b48.b;
import com.larus.account.base.TTAccount;
import com.larus.account.saas.jsb.core.d;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/coreapi/IAccountSessionService;", "", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountSessionService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286325a = null;

    /* JADX INFO: loaded from: classes24.dex */
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f286326a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final IAccountSessionService$Companion$EMPTY$1 f286327b = null;

        public Companion() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.account.saas.coreapi.IAccountSessionService$Companion$EMPTY$1] */
        static {
            f286326a = new Companion();
            f286327b = new IAccountSessionService$Companion$EMPTY$1();
        }
    }

    static {
        f286325a = Companion.f286326a;
    }

    void a(String r100, d r101);

    void b(TTAccount.b r100);

    b getAccountInfo();

    Map<String, String> getCommonParams();
}
