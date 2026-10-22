package com.bytedance.ee.bear.middleground.permission.apply;

import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z implements Runnable {
    public final /* synthetic */ AuditControlApplyFragment a;
    public final /* synthetic */ boolean b;

    public z(AuditControlApplyFragment r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        final AuditControlApplyFragment r0 = this.a;
        boolean r1 = this.b;
        int r2 = AuditControlApplyFragment.p;
        if (r0.Y90() == null) goto L10;
        if (r1 == false) goto L7;
        com.larksuite.component.universe_design.button.e.h(r0.Y90(), new AuditControlApplyFragment$handleLoadingInner$1(r0));
        r0.Y90().setTextColor(UDColorUtils.getColor(r0.requireContext(), 2131109013));
        r0.Y90().setBackgroundColor(UDColorUtils.getColor(r0.requireContext(), 2131105550));
        return;
    L7:
        com.larksuite.component.universe_design.button.e.c(r0.Y90(), 2131887714);
        r0.Y90().setTextColor(UDColorUtils.getColor(r0.requireContext(), 2131106521));
        r0.Y90().setBackgroundColor(UDColorUtils.getColor(r0.requireContext(), 2131105548));
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
