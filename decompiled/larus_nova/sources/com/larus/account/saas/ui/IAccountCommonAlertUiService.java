package com.larus.account.saas.ui;

import android.app.Activity;
import f48.a;
import f48.c;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/ui/IAccountCommonAlertUiService;", "Lf48/c;", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountCommonAlertUiService extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f286550b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/IAccountCommonAlertUiService$Companion;", "Lcom/larus/account/saas/ui/IAccountCommonAlertUiService;", "<init>", "()V", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountCommonAlertUiService {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Companion f286551e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Lazy<Set<IAccountCommonAlertUiService>> f286552f = null;

        private Companion() {
        }

        @Override // f48.c
        public final void priority() {
        }

        static {
            f286551e = new Companion();
            f286552f = LazyKt.lazy(IAccountCommonAlertUiService$Companion$services$2.INSTANCE);
        }

        @Override // com.larus.account.saas.ui.IAccountCommonAlertUiService
        public final boolean b(final Activity r100, final AccountCommonAlertData r101, final Function1<? super AccountCommonAlertAction, Unit> r102, final Function0<Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r102, "onAction");
            Intrinsics.checkNotNullParameter(r103, "onCancel");
            int r104 = a.f475572a;
            return a.a(f286552f.getValue(), new IAccountCommonAlertUiService$Companion$showCommonAlert$1(r100, r101, r102, r103));
        }
    }

    static {
        f286550b = Companion.f286551e;
    }

    boolean b(Activity r100, AccountCommonAlertData r101, Function1<? super AccountCommonAlertAction, Unit> r102, Function0<Unit> r103);
}
