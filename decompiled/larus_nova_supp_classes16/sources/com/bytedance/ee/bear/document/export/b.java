package com.bytedance.ee.bear.document.export;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.export.viewmodel.SheetExportViewModel;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import g15.q;
import g15.r;
import g15.s;
import io.reactivex.disposables.Disposable;
import rw4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements SheetExportViewModel.a {
    public final /* synthetic */ e a;

    @Override // com.bytedance.ee.bear.document.export.viewmodel.SheetExportViewModel.a
    public final void f() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        com.bytedance.ee.bear.more.b r1 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        e.a r0 = this.a.b;
        String r2 = r0.c;
        int r3 = r0.getType();
        e.a r4 = this.a.b;
        PermissionResponse r5 = r1.M(r2, r3, r4.g, r4.h, BizDomain.FileBizDomainCCM, "EXPORT");
        r5.getCallback().a(this.a.a, r5);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r5) == false) goto L11;
        return;
    L11:
        e.h(this.a.b);
        PluginHost r6 = this.a.h;
        if (r6 == null) goto L14;
        r6.findPluginToDo(ExportPlugin.class, new q());
        this.a.o("image");
        b("image");
    L14:
        this.a.c.f("image");
        return;
    L7:
        com.bytedance.ee.bear.middleground_permission_export.model.d r7 = (com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.d.class);
        e.a r8 = this.a.b;
        String r9 = r8.c;
        int r10 = r8.getType();
        e.a r11 = this.a.b;
        String r12 = r7.a(r9, r10, "CCM_EXPORT", r11.f, r11.g);
        if (TextUtils.isEmpty(r12) == true) goto L11;
        Toast.showFailureText(eu5.b.a, r12);
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void g() {
        e r0 = this.a;
        Disposable r1 = r0.e;
        if (r1 == null) goto L6;
        r1.dispose();
        r0.e = null;
    L6:
        com.bytedance.ee.bear.document.export.net.exportV2.a r2 = r0.d;
        if (r2 == null) goto L10;
        r2.cancel();
        return;
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final String getToken() {
        return this.a.b.c;
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.SheetExportViewModel.a
    public final boolean h() {
        if (this.a.h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public b(e r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void b(String r2) {
        e.d(this.a, r2);
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void d(String r2) {
        e.b(this.a, r2);
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void j(String r2) {
        this.a.s(r2);
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.SheetExportViewModel.a
    public final void onOrientationSupportPanelDismiss(final p r4) {
        PluginHost r0 = this.a.h;
        if (r0 == null) goto L6;
        r0.findPluginToDo(BaseUnspecifiedOrientationPlugin.class, new r(r4));
        return;
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.SheetExportViewModel.a
    public final void onOrientationSupportPanelShowing(final p r4) {
        PluginHost r0 = this.a.h;
        if (r0 == null) goto L6;
        r0.findPluginToDo(BaseUnspecifiedOrientationPlugin.class, new s(r4));
        return;
    }

    public final void k(n r7, rw4.a r8) {
        e r0 = this.a;
        r0.w(r7, sbb.e.d(r0.b.getType()).getType(), this.a.b.c, null, r8);
        this.a.c.f(r7.a);
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void a(n r1, String r2, rw4.a r3) {
        k(r1, r3);
    }
}
