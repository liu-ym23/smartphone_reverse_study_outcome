package com.ss.android.lark.integrator.security.compliance;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class k implements o3c.a {
    @Inject
    public k() {
    }

    @Override // o3c.a
    public final void Y() {
    }

    @Override // o3c.a
    public final void a(com.ss.android.lark.scs.policy.engine.manage.f r100) {
        Intrinsics.checkNotNullParameter(r100, "switchUserSwitchListener");
    }

    @Override // o3c.a
    public final void b() {
        Intrinsics.checkNotNullParameter(com.ss.android.lark.scs.policy.engine.manage.e.f439855a, "loginStatusListener");
        xzb.a r100 = (xzb.a) ApiUtils.getApi(xzb.a.class);
        r100.registerLoginListener(new i());
        r100.registerLogoutListener(new j());
    }

    @Override // o3c.a
    public final User getForegroundUser() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
    }

    @Override // o3c.a
    public final boolean isDoubaoEnterpriseUser() {
        c.f428061a.getClass();
        return c.a();
    }
}
