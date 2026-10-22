package com.bytedance.ee.bear.document.export;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.m;
import com.bytedance.ee.bear.document.export.viewmodel.DocExportViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import g15.h;
import io.reactivex.disposables.Disposable;
import rw4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements DocExportViewModel.a {
    public final /* synthetic */ DocExportViewModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ e c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.export.a$a, reason: collision with other inner class name */
    public class C0072a implements m.b {
        public final /* synthetic */ a a;

        public C0072a(a r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.DocExportViewModel.a
    public final boolean e() {
        e r0 = this.c;
        if (r0.h != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b.k == true) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void g() {
        e r0 = this.c;
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
        return this.c.b.d;
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void b(String r2) {
        e.d(this.c, r2);
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.DocExportViewModel.a
    public final void c(String r9) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        com.bytedance.ee.bear.more.b r1 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        e.a r0 = this.c.b;
        String r2 = r0.c;
        int r3 = r0.getType();
        e.a r4 = this.c.b;
        PermissionResponse r5 = r1.M(r2, r3, r4.g, r4.h, BizDomain.FileBizDomainCCM, "EXPORT");
        r5.getCallback().a(this.c.a, r5);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r5) == false) goto L11;
        return;
    L11:
        e.h(this.c.b);
        e.g(this.c.b);
        this.c.o("jpg_long");
        this.a.startDocShot(r9, new C0072a(this));
        this.c.c.f("image");
        return;
    L7:
        com.bytedance.ee.bear.middleground_permission_export.model.d r6 = (com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.d.class);
        e.a r7 = this.c.b;
        String r8 = r7.d;
        int r10 = r7.getType();
        e.a r11 = this.c.b;
        String r12 = r6.a(r8, r10, "CCM_EXPORT", r11.f, r11.g);
        if (TextUtils.isEmpty(r12) == true) goto L11;
        Toast.showFailureText(eu5.b.a, r12);
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void d(String r2) {
        e.b(this.c, r2);
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void j(String r2) {
        this.c.s(r2);
    }

    public a(e r1, DocExportViewModel r2, String r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void a(final n r12, final String r13, final rw4.a r14) {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.j("ccm.docx.mob.export_support_comment");
        boolean r2 = false;
        if (r12 != n.c) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (this.c.b.b != 22) goto L12;
        boolean r4 = true;
    L14:
        if ("vc_summary_tab".equals(this.b) == false) goto L16;
    L18:
        if (r13 != null) goto L21;
        r13 = this.b;
    L21:
        if (r0 == false) goto L33;
        if (r4 == false) goto L33;
        if (r1 == false) goto L33;
        if (r2 == false) goto L33;
        final e r3 = this.c;
        Disposable r5 = r3.e;
        if (r5 == null) goto L35;
        r5.dispose();
        r3.e = null;
    L35:
        r3.e = r3.q().observeOn(fo5.d.d()).subscribe(new g15.b(r3, r12, r14, r13), new h(r3, r12, r14, r13));     // Catch: RuntimeException -> L31
        return;
    L31:
        e = move-exception;
        r3.e = null;
        tt5.a.l("DocumentExportAction", "start comment state query failed, show comment selection", e);
        r3.f(true, r12, r14, r13);
        return;
    L33:
        e r6 = this.c;
        String r7 = r6.j();
        e r8 = this.c;
        r6.w(r12, r7, r8.b.d, r8.n(r12, r13), r14);
        this.c.c.f(r12.a);
        return;
    L16:
        if ("vc_transcript_tab".equals(this.b) == true) goto L18;
        r2 = true;
        goto L18
    L12:
        r4 = false;
        goto L14
    L5:
        if (r12 == n.d) goto L8;
        r1 = false;
        goto L10
    }
}
