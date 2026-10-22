package com.larus.account.saas.ui.security;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import com.larus.account.saas.security.api.IAccountSecurityPushUiService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/ui/security/DefaultAccountSecurityPushUiService;", "Lcom/larus/account/saas/security/api/IAccountSecurityPushUiService;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class DefaultAccountSecurityPushUiService implements IAccountSecurityPushUiService {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f286592e = 0;

    public static final class a {
    }

    static {
    }

    @Override // f48.c
    public final void priority() {
    }

    public DefaultAccountSecurityPushUiService() {
    }

    @Override // com.larus.account.saas.security.api.IAccountSecurityPushUiService
    public final boolean e(final e48.f r100) {
        Intrinsics.checkNotNullParameter(r100, "pushPayload");
        c48.a.a().a();
        Activity r101 = com.larus.init.task.accountsdk.a.f351133a.currentActivity();
        if ((r101 instanceof FragmentActivity) == false) goto L5;
        final FragmentActivity r102 = (FragmentActivity) r101;
    L6:
        if (r102 != null) goto L9;
        return false;
    L9:
        com.larus.account.saas.runtime.internal.util.b.f286474a.post(new c(this, r102, r100));
        return true;
    L5:
        r102 = null;
        goto L6
    }

    public static final void f(DefaultAccountSecurityPushUiService r100, String r101, String r102) {
        r100.getClass();
        SaasTracking r103 = SaasTracking.f286464a;
        JSONObject r104 = new JSONObject();
        r104.put("popup_type", "account_risk_alert");
        r104.put("risk_reason", r101);
        r104.put("click_from", r102);
        Unit r105 = Unit.INSTANCE;
        r103.reportEvent("popup_click", r104);
    }
}
