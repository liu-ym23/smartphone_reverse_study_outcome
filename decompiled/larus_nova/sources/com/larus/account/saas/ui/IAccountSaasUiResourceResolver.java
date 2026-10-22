package com.larus.account.saas.ui;

import android.content.Context;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.ss.android.lark.utils.statistics.PerfLog;
import f48.a;
import f48.b;
import f48.c;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/ui/IAccountSaasUiResourceResolver;", "Lf48/c;", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountSaasUiResourceResolver extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f286556d = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/IAccountSaasUiResourceResolver$Companion;", "Lcom/larus/account/saas/ui/IAccountSaasUiResourceResolver;", "<init>", "()V", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountSaasUiResourceResolver {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Companion f286557e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Lazy<Set<IAccountSaasUiResourceResolver>> f286558f = null;

        private Companion() {
        }

        @Override // f48.c
        public final void priority() {
        }

        static {
            f286557e = new Companion();
            f286558f = LazyKt.lazy(IAccountSaasUiResourceResolver$Companion$resolvers$2.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.larus.account.saas.ui.IAccountSaasUiResourceResolver
        public final Integer c(final Context r100, final AccountSaasUiColorToken r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "token");
            int r102 = a.f475572a;
            Set<IAccountSaasUiResourceResolver> r103 = f286558f.getValue();
            Function1<IAccountSaasUiResourceResolver, Integer> r104 = new IAccountSaasUiResourceResolver$Companion$resolveColor$1(r100, r101);
            Intrinsics.checkNotNullParameter(r103, PromotionProductPrivilegesStruct.SERVICES);
            Intrinsics.checkNotNullParameter(r104, "block");
            Iterator r105 = CollectionsKt.sortedWith(r103, new b()).iterator();
        L4:
            if (r105.hasNext() == false) goto L8;
            Object r106 = r104.invoke(r105.next());
            if (r106 == null) goto L4;
        L10:
            return (Integer) r106;
        L8:
            r106 = null;
            goto L10
        }
    }

    static {
        f286556d = Companion.f286557e;
    }

    Integer c(Context r100, AccountSaasUiColorToken r101);
}
