package com.bytedance.ee.bear.middleground.permission.audit;

import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.integrator.ccm.dependency.di.g;
import com.ss.android.lark.integrator.ccm.dependency.di.h;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f233099a;

    public interface a {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.audit.e
    public final void b() {
        tt5.a.h("AuditManagerWrapper", "checkInit " + AuditManager.isInit());
        if (AuditManager.isInit() == true) goto L6;
        ((h) this.f233099a).getClass();
        com.ss.android.lark.audit_provider.b.a(LarkContext.getApplication(), new g());
        return;
    }

    public c(h r100) {
        this.f233099a = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.audit.e
    public final int c(int r100) {
        if (AuditManager.isInit() == true) goto L6;
        tt5.a.h("AuditManagerWrapper", "checkAuthority: AuditManager is not init");
        fo5.d.c().scheduleDirect(new b(this));
        return 3;
    L6:
        ((h) this.f233099a).getClass();
        return AuditManager.getInstance().checkAuthority(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.audit.e
    public final void d(final Event r100) {
        fo5.d.c().scheduleDirect(new com.bytedance.ee.bear.middleground.permission.audit.a(this, r100));
    }
}
