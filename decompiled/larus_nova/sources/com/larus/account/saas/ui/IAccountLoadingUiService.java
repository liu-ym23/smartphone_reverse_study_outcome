package com.larus.account.saas.ui;

import android.app.Activity;
import f48.a;
import f48.c;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/ui/IAccountLoadingUiService;", "Lf48/c;", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountLoadingUiService extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f286553c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/IAccountLoadingUiService$Companion;", "Lcom/larus/account/saas/ui/IAccountLoadingUiService;", "<init>", "()V", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountLoadingUiService {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Companion f286554e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Lazy<Set<IAccountLoadingUiService>> f286555f = null;

        private Companion() {
        }

        @Override // f48.c
        public final void priority() {
        }

        static {
            f286554e = new Companion();
            f286555f = LazyKt.lazy(IAccountLoadingUiService$Companion$services$2.INSTANCE);
        }

        @Override // com.larus.account.saas.ui.IAccountLoadingUiService
        public final boolean d(final Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            int r101 = a.f475572a;
            return a.a(f286555f.getValue(), new IAccountLoadingUiService$Companion$dismissLoading$1(r100));
        }

        @Override // com.larus.account.saas.ui.IAccountLoadingUiService
        public final boolean showLoading(final Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            int r101 = a.f475572a;
            return a.a(f286555f.getValue(), new IAccountLoadingUiService$Companion$showLoading$1(r100));
        }
    }

    static {
        f286553c = Companion.f286554e;
    }

    boolean d(Activity r100);

    boolean showLoading(Activity r100);
}
