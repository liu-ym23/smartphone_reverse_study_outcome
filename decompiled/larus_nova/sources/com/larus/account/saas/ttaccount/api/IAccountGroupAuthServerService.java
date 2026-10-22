package com.larus.account.saas.ttaccount.api;

import android.app.Activity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/ttaccount/api/IAccountGroupAuthServerService;", "", "Companion", "account-saas-ttaccount-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountGroupAuthServerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286544a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f286545a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final IAccountGroupAuthServerService$Companion$EMPTY$1 f286546b = null;

        public Companion() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.account.saas.ttaccount.api.IAccountGroupAuthServerService$Companion$EMPTY$1] */
        static {
            f286545a = new Companion();
            f286546b = new IAccountGroupAuthServerService$Companion$EMPTY$1();
        }
    }

    static {
        f286544a = Companion.f286545a;
    }

    void a(Activity r100, boolean r101, Integer r102, String r103);

    void b(Activity r100, a r101);

    void c(Activity r100);

    void onDestroy(Activity r100);
}
