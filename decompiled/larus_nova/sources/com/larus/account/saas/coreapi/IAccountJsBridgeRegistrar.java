package com.larus.account.saas.coreapi;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/coreapi/IAccountJsBridgeRegistrar;", "", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountJsBridgeRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286313a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/coreapi/IAccountJsBridgeRegistrar$Companion;", "Lcom/larus/account/saas/coreapi/IAccountJsBridgeRegistrar;", "<init>", "()V", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountJsBridgeRegistrar {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f286314b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IAccountJsBridgeRegistrar> f286315c = null;

        private Companion() {
        }

        static {
            f286314b = new Companion();
            f286315c = LazyKt.lazy(IAccountJsBridgeRegistrar$Companion$impl$2.INSTANCE);
        }

        @Override // com.larus.account.saas.coreapi.IAccountJsBridgeRegistrar
        public final void register() {
            IAccountJsBridgeRegistrar r100 = f286315c.getValue();
            if (r100 == null) goto L6;
            r100.register();
            return;
        }
    }

    static {
        f286313a = Companion.f286314b;
    }

    void register();
}
