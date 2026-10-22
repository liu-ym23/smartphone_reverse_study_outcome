package com.larus.account.saas.coreapi;

import com.larus.account.saas.jsb.core.e;
import com.larus.account.saas.jsb.core.f;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/coreapi/IAccountLoginService;", "", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountLoginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286316a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f286317a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final IAccountLoginService$Companion$EMPTY$1 f286318b = null;

        public Companion() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.account.saas.coreapi.IAccountLoginService$Companion$EMPTY$1] */
        static {
            f286317a = new Companion();
            f286318b = new IAccountLoginService$Companion$EMPTY$1();
        }
    }

    static {
        f286316a = Companion.f286317a;
    }

    void a(String r100, String r101, String r102, f r103);

    void b(String r100, e r101, boolean r102, boolean r103, boolean r104);
}
