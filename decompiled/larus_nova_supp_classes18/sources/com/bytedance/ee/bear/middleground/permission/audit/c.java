package com.bytedance.ee.bear.middleground.permission.audit;

import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.integrator.ccm.dependency.di.g;
import com.ss.android.lark.integrator.ccm.dependency.di.h;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements e {
    public final a a;

    public interface a {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.audit.e
    public final void b() {
        tt5.a.h("AuditManagerWrapper", "checkInit " + AuditManager.isInit());
        if (AuditManager.isInit() == true) goto L6;
        this.a.getClass();
        com.ss.android.lark.audit_provider.b.a(LarkContext.getApplication(), new g());
        return;
    }

    public c(h r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.audit.e
    public final int c(int r2) {
        if (AuditManager.isInit() == true) goto L6;
        tt5.a.h("AuditManagerWrapper", "checkAuthority: AuditManager is not init");
        fo5.d.c().scheduleDirect(new b(this));
        return 3;
    L6:
        this.a.getClass();
        return AuditManager.getInstance().checkAuthority(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.audit.e
    public final void d(final Event r3) {
        fo5.d.c().scheduleDirect(new com.bytedance.ee.bear.middleground.permission.audit.a(this, r3));
    }
}
