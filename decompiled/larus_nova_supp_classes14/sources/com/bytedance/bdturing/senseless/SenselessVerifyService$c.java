package com.bytedance.bdturing.senseless;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdturing.EventReport;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import qb4.f;
import sb4.k;
import sb4.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class SenselessVerifyService$c implements l {
    public final /* synthetic */ f a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ SenselessVerifyService f;

    public final void a() {
        EventReport.D(1, SenselessVerifyService.access$000(this.f));
        c(SenselessVerifyService.access$400(this.f));
        SenselessVerifyService.access$402(this.f, null);
        SenselessVerifyService.access$302(this.f, false);
        f r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFail(1, null);
        return;
    }

    public final void b() {
        c(SenselessVerifyService.access$400(this.f));
        SenselessVerifyService.access$402(this.f, null);
        EventReport.D(0, SenselessVerifyService.access$000(this.f));
        SenselessVerifyService.access$500(this.f, this.b, this.c, this.d, this.e, this.a);
    }

    public final void onCancel() {
        EventReport.D(1, SenselessVerifyService.access$000(this.f));
        c(SenselessVerifyService.access$400(this.f));
        SenselessVerifyService.access$402(this.f, null);
        SenselessVerifyService.access$302(this.f, false);
        f r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFail(1, null);
        return;
    }

    public static void c(k r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public SenselessVerifyService$c(SenselessVerifyService r1, f r2, boolean r3, String r4, String r5, String r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
