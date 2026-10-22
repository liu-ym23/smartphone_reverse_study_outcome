package com.larus.account.saas.coreapi;

import b48.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/coreapi/IAccountInitManager;", "", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountInitManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286310a = null;

    /* JADX INFO: loaded from: classes24.dex */
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f286311a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final IAccountInitManager$Companion$EMPTY$1 f286312b = null;

        public Companion() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.account.saas.coreapi.IAccountInitManager$Companion$EMPTY$1] */
        static {
            f286311a = new Companion();
            f286312b = new IAccountInitManager$Companion$EMPTY$1();
        }
    }

    static {
        f286310a = Companion.f286311a;
    }

    void a(d r100);

    d getConfig();
}
