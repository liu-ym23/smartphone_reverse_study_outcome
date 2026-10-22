package com.ss.android.lark.officesdk.integrator.im.impl;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.y0;
import dagger.hilt.android.internal.Contexts;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes37.dex */
public final class o implements pmb.i {
    @Inject
    public o() {
    }

    @Override // pmb.i
    public final String b() {
        return ((gpb.a) c(gpb.a.class)).getGeo();
    }

    @Override // pmb.i
    public final String getDeviceId() {
        return ((epb.a) c(epb.a.class)).getDeviceId();
    }

    @Override // pmb.i
    public final String getSession() {
        User r100 = ((yzb.b) c(yzb.b.class)).getForegroundUser();
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.getSession() != null) goto L8;
        return "";
    L8:
        return r100.getSession();
    }

    @Override // pmb.i
    public final String getSessionId() {
        User r100 = ((yzb.b) c(yzb.b.class)).getForegroundUser();
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.getSession() != null) goto L8;
        return "";
    L8:
        return r100.getSession();
    }

    @Override // pmb.i
    public final String getTenantBrand() {
        return ((gpb.a) c(gpb.a.class)).getTenantBrand();
    }

    @Override // pmb.i
    public final String getTenantId() {
        User r100 = ((yzb.b) c(yzb.b.class)).getForegroundUser();
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.getTenantId() != null) goto L8;
        return "";
    L8:
        return r100.getTenantId();
    }

    @Override // pmb.i
    public final String getUserId() {
        return ((yzb.b) c(yzb.b.class)).d();
    }

    @Override // pmb.i
    public final boolean isChinaMainlandGeo() {
        return ((gpb.a) c(gpb.a.class)).isChinaMainlandGeo();
    }

    @Override // pmb.i
    public final boolean isFeishuBrand() {
        return ((gpb.a) c(gpb.a.class)).isFeishuBrand();
    }

    @Override // pmb.i
    public final boolean isLogin() {
        return ((yzb.b) c(yzb.b.class)).isLogin();
    }

    public static Object c(Class r100) {
        return e0c.k.a(Contexts.getApplication(LarkContext.getApplication()), r100);
    }

    @Override // pmb.i
    public final boolean a(String r100) {
        return y0.a(((yzb.b) c(yzb.b.class)).d(), r100);
    }
}
