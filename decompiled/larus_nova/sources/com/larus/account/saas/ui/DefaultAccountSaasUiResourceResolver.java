package com.larus.account.saas.ui;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/DefaultAccountSaasUiResourceResolver;", "Lcom/larus/account/saas/ui/IAccountSaasUiResourceResolver;", "<init>", "()V", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class DefaultAccountSaasUiResourceResolver implements IAccountSaasUiResourceResolver {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f286549a = null;

        static {
            int[] r100 = new int[AccountSaasUiColorToken.values().length];
            r100[AccountSaasUiColorToken.STATUS_BAR_BACKGROUND.ordinal()] = 1;
            f286549a = r100;
        }
    }

    @Override // f48.c
    public final void priority() {
    }

    public DefaultAccountSaasUiResourceResolver() {
    }

    @Override // com.larus.account.saas.ui.IAccountSaasUiResourceResolver
    public final Integer c(Context r100, AccountSaasUiColorToken r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "token");
        if (a.f286549a[r101.ordinal()] != 1) goto L7;
        return Integer.valueOf(ContextCompat.getColor(r100, R.color.account_saas_base_1_overlay));
    L7:
        throw new NoWhenBranchMatchedException();
    }
}
