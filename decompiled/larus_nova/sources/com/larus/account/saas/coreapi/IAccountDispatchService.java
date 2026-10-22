package com.larus.account.saas.coreapi;

import android.net.Uri;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/coreapi/IAccountDispatchService;", "", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountDispatchService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286306a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f286307a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final IAccountDispatchService$Companion$EMPTY$1 f286308b = null;

        public Companion() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.account.saas.coreapi.IAccountDispatchService$Companion$EMPTY$1] */
        static {
            f286307a = new Companion();
            f286308b = new IAccountDispatchService$Companion$EMPTY$1();
        }
    }

    static {
        f286306a = Companion.f286307a;
    }

    boolean c(int r100, int r101, String r102);

    boolean e(Uri r100);
}
