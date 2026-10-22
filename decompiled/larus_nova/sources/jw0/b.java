package jw0;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ToggleButton;
import com.bytedance.android.live.recharge.exchange.saas.CashExchangeDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import j40.f4;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CashExchangeDialog f500650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f500651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f500652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zv0.e f500653d;

    public b(CashExchangeDialog r100, long r101, long r102, zv0.e r103) {
        this.f500650a = r100;
        this.f500651b = r101;
        this.f500652c = r102;
        this.f500653d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        int r111 = h.f500665a;
        long r100 = this.f500651b;
        long r101 = this.f500652c;
        long r102 = r100 + r101;
        CashExchangeDialog r112 = this.f500650a;
        int r103 = r112.f89886k;
        ToggleButton r113 = r112.f89882g;
        if (r113 == null) goto L5;
        Boolean r114 = Boolean.valueOf(r113.isChecked());
    L6:
        h.c(r102, r101, r103, 2, r114);
        zv0.e r115 = this.f500653d;
        if (r115 == null) goto L9;
        r115.b();
    L9:
        ToggleButton r116 = this.f500650a.f89882g;
        if (r116 != null) goto L12;
    L14:
        CashExchangeDialog r117 = this.f500650a;
        Handler r104 = DialogLancet.resolveDialogHandler(r117);
        if (r104 != null) goto L17;
    L19:
        DialogLancet.beforeDialogDismiss(r117);
        r117.dismiss();     // Catch: Throwable -> L22 Exception -> L24
    L28:
        DialogLancet.afterDialogDismiss(r117);
        return;
    L24:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L22
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L22
        if (r105 == null) goto L28;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r117);
        throw th;
    L17:
        if (Looper.myLooper() == r104.getLooper()) goto L19;
        r104.post(DialogLancet.createDismissRunnable(r117));
        return;
    L12:
        if (r116.isChecked() != true) goto L14;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r118 = f4.f497214q;
        Boolean r106 = Boolean.TRUE;
        r118.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r118, r106);
        goto L14
    L5:
        r114 = null;
        goto L6
    }
}
