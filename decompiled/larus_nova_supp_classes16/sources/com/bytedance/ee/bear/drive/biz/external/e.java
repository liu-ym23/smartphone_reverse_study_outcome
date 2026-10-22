package com.bytedance.ee.bear.drive.biz.external;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.bear.widgets.m;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public String a;
    public String b;
    public f c;
    public m d;

    public static class a implements f.d {
        public final WeakReference<e> a;

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void c(w75.a r1) {
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final /* synthetic */ void f() {
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void d() {
            tt5.a.d("DRIVE_OpenExternalHandler", "onStoragePermissionDenied");
        }

        public final void g() {
            if (this.a.get() == null) goto L6;
            this.a.get().a();
            return;
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void b() {
            g();
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void e() {
            g();
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void onDismiss() {
            g();
        }

        public a(e r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.d
        public final void a(int r1) {
            if (this.a.get() == null) goto L6;
            this.a.get().a();
            return;
        }
    }

    public final void a() {
        m r0 = this.d;
        if (r0 == null) goto L25;
        UDDialog r1 = r0.f;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isShowing() == false) goto L30;
        UDDialog r2 = this.d.f;
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r2);
        return;
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r4 == null) goto L22;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        goto L22
    L11:
        if (Looper.myLooper() == r3.getLooper()) goto L13;
        r3.post(DialogLancet.createDismissRunnable(r2));
        return;
    L30:
        return;
    }

    public e(Bundle r3, Activity r4, a95.a r5) {
        this.a = r3.getString("url");
        int r6 = a95.a.d;
        String r7 = ((t45.c) a95.a.b.a(null).a(t45.c.class)).Z(this.a).b;
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        this.b = r7;
        f r8 = new f(r4, new a(this), new g(), r5);
        this.c = r8;
        r8.a = new d55.e(this);
    }
}
