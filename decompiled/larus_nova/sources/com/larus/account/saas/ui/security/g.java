package com.larus.account.saas.ui.security;

import androidx.fragment.app.FragmentActivity;
import com.larus.account.saas.security.api.IAccountSecurityService;

/* JADX INFO: loaded from: classes24.dex */
public final class g implements h48.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e48.f f286608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f286609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DefaultAccountSecurityPushUiService f286610c;

    @Override // h48.a
    public final void cancel() {
        c48.a.a().a();
        com.larus.init.task.accountsdk.a r100 = com.larus.init.task.accountsdk.a.f351133a;
        String r101 = this.f286608a.f471019g;
        r100.k(r101, IAccountSecurityService.f286489a.d(this.f286609b, r101));
        DefaultAccountSecurityPushUiService.f(this.f286610c, this.f286608a.f471016d, "manage_device");
    }

    public g(e48.f r100, FragmentActivity r101, DefaultAccountSecurityPushUiService r102) {
        this.f286608a = r100;
        this.f286609b = r101;
        this.f286610c = r102;
    }
}
