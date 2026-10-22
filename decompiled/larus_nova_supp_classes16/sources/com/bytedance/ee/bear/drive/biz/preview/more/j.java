package com.bytedance.ee.bear.drive.biz.preview.more;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements com.bytedance.ee.bear.drive.biz.external.f.d {
    public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d a;
    public final /* synthetic */ b b;

    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ b b;

        public a(int r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (this.a != 3) goto L5;
            Toast.showText(this.b.a, 2131888391);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            Toast.showText(this.b.a, 2131888428);     // Catch: Throwable -> L7
            goto L12
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void c(w75.a r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final /* synthetic */ void f() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final /* synthetic */ void onDismiss() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void b() {
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r0 = this.a;
        w75.a r3 = this.b.b.b.getFileModel();
        if (r3 == null) goto L7;
        w75.b r4 = r3.c();
        if (r4 == null) goto L7;
        long r5 = r4.c;
    L8:
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(r0, null, null, r5, 7);
        return;
    L7:
        r5 = 0;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void d() {
        tt5.a.d("DriveAttachmentMoreMenuCreator", "onStoragePermissionDenied");
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void e() {
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r0 = this.a;
        w75.a r3 = this.b.b.b.getFileModel();
        if (r3 == null) goto L7;
        w75.b r4 = r3.c();
        if (r4 == null) goto L7;
        long r5 = r4.c;
    L8:
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(r0, null, null, r5, 7);
        return;
    L7:
        r5 = 0;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void a(int r9) {
        com.bytedance.ee.util.ui.m.a(new a(r9, this.b));
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r2 = this.a;
        w75.a r10 = this.b.b.b.getFileModel();
        if (r10 == null) goto L7;
        w75.b r11 = r10.c();
        if (r11 == null) goto L7;
        long r0 = r11.c;
    L8:
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(r2, null, null, r0, 7);
        return;
    L7:
        r0 = 0;
        goto L8
    }

    public j(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r1, b r2) {
        this.a = r1;
        this.b = r2;
    }
}
