package ub4;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.identityverify.IdentityVerifyService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f549357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f549358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f549359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f549360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f549361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f549362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f549363g;

    @Override // android.app.Dialog
    public final void show() {
        if ((!this.f549357a.isFinishing()) == true) goto L6;
        return;
    L6:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public static void a(i r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.bdturing_identity_verify_dialog_layout);
        this.f549362f = findViewById(R.id.v_divide_line_h);
        this.f549363g = findViewById(R.id.v_divide_line_v);
        TextView r101 = (TextView) findViewById(R.id.tv_dlg_title);
        TextView r102 = (TextView) findViewById(R.id.tv_dlg_content);
        this.f549359c = (TextView) findViewById(R.id.tv_dlg_cancel);
        this.f549360d = (TextView) findViewById(R.id.tv_dlg_confirm);
        this.f549361e = findViewById(R.id.root_view);
        BdTuringConfig r103 = qb4.b.c.f532315a.f532302a;
        if (r103 == null) goto L5;
        r103.getThemeConfig();
    L5:
        setOnCancelListener(new f(this));
        this.f549359c.setOnClickListener(new g(this));
        this.f549360d.setOnClickListener(new h(this));
    }

    public i(Activity r100, IdentityVerifyService.b r101) {
        super(r100, R.style.BdTuring_Identify_Dialog);
        this.f549357a = r100;
        this.f549358b = r101;
    }
}
