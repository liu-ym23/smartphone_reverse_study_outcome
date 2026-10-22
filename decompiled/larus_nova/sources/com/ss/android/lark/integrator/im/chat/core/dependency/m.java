package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.ss.android.lark.MessageTenantConfTask;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class m implements w4b.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Object, qzb.a> f427926a;

    @Override // w4b.u
    public final void b() {
        MessageTenantConfTask.a r100 = MessageTenantConfTask.a.f408534a;
        qzb.a r101 = new l();
        this.f427926a.put(r100, r101);
    }

    public m() {
        this.f427926a = new ConcurrentHashMap();
    }

    @Override // w4b.u
    public final String getSession() {
        return nmb.a.a().getPassportDependency().getSession();
    }

    @Override // w4b.u
    public final String getTenantId() {
        return nmb.a.a().getPassportDependency().getTenantId();
    }

    @Override // w4b.u
    public final String getUserId() {
        String r100 = nmb.a.a().getPassportDependency().getUserId();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // w4b.u
    public final boolean isLogin() {
        return nmb.a.a().getPassportDependency().isLogin();
    }

    @Override // w4b.u
    public final boolean a(String r100) {
        return nmb.a.a().getPassportDependency().a(r100);
    }
}
