package com.bytedance.ee.bear.basesdk.apiimpl;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class b2 implements pn4.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pn4.n f206503a;

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void a() {
        this.f206503a.a();
    }

    public b2(com.ss.android.lark.integrator.ccm.config.viewbinder.g r100) {
        this.f206503a = r100;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void b(Throwable r100) {
        this.f206503a.b(r100);
        if (ax4.d.b(r100, 10040) == false) goto L6;
        Toast.showFailureText(eu5.b.f474075a, R.string.CreationMobile_DataUpgrade_Locked_toast);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
    public final void c(int r100) {
        this.f206503a.c(r100);
    }
}
