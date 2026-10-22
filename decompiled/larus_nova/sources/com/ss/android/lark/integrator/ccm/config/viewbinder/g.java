package com.ss.android.lark.integrator.ccm.config.viewbinder;

import pn4.n;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements n {
    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void a() {
    }

    public g() {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void b(Throwable r100) {
        tt5.a.e("DocCardViewBinder", "removePermission fail", r100, false);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void c(int r100) {
        tt5.a.h("DocCardViewBinder", "removePermission onRequestSuccess permission = " + r100);
    }
}
