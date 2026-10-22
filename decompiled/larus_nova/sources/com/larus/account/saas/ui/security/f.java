package com.larus.account.saas.ui.security;

import com.larus.account.saas.security.api.IAccountSecurityService;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements h48.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e48.f f286606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultAccountSecurityPushUiService f286607b;

    @Override // h48.d
    public final void confirm() {
        IAccountSecurityService.Companion r100 = IAccountSecurityService.f286489a;
        e48.f r101 = this.f286606a;
        r100.a(new e48.c(r101.f471015c, r101.f471016d, r101.f471014b));
        DefaultAccountSecurityPushUiService.f(this.f286607b, this.f286606a.f471016d, "confirm_myself");
    }

    public f(e48.f r100, DefaultAccountSecurityPushUiService r101) {
        this.f286606a = r100;
        this.f286607b = r101;
    }
}
