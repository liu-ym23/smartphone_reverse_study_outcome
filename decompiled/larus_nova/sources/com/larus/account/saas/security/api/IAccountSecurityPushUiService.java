package com.larus.account.saas.security.api;

import e48.f;
import f48.a;
import f48.c;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/security/api/IAccountSecurityPushUiService;", "Lf48/c;", "Companion", "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountSecurityPushUiService extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286486a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/security/api/IAccountSecurityPushUiService$Companion;", "Lcom/larus/account/saas/security/api/IAccountSecurityPushUiService;", "<init>", "()V", "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountSecurityPushUiService {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Companion f286487e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Lazy<Set<IAccountSecurityPushUiService>> f286488f = null;

        private Companion() {
        }

        @Override // f48.c
        public final void priority() {
        }

        static {
            f286487e = new Companion();
            f286488f = LazyKt.lazy(IAccountSecurityPushUiService$Companion$services$2.INSTANCE);
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityPushUiService
        public final boolean e(final f r100) {
            Intrinsics.checkNotNullParameter(r100, "pushPayload");
            int r101 = a.f475572a;
            return a.a(f286488f.getValue(), new IAccountSecurityPushUiService$Companion$showPushDialog$1(r100));
        }
    }

    static {
        f286486a = Companion.f286487e;
    }

    boolean e(f r100);
}
