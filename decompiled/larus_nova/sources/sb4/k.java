package sb4;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes12.dex */
public final class k extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f541233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f541234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f541235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f541236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f541237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f541238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f541239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f541240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f541241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f541242j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f541243k;

    @Override // android.app.Dialog
    public final void show() {
        if ((!this.f541233a.isFinishing()) == true) goto L6;
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

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        a(this);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.bdturing_alert_dialog_layout);
        this.f541240h = findViewById(R.id.v_divide_line_h);
        this.f541241i = findViewById(R.id.v_divide_line_v);
        this.f541235c = (TextView) findViewById(R.id.tv_dlg_title);
        this.f541236d = (TextView) findViewById(R.id.tv_dlg_content);
        this.f541237e = (TextView) findViewById(R.id.tv_alert_dlg_left);
        this.f541238f = (TextView) findViewById(R.id.tv_alert_dlg_right);
        this.f541239g = findViewById(R.id.root_view);
        setCanceledOnTouchOutside(false);
        setCancelable(this.f541243k);
        if (TextUtils.isEmpty(this.f541242j.f541211a) == true) goto L6;
        this.f541235c.setText(this.f541242j.f541211a);
    L6:
        if (TextUtils.isEmpty(this.f541242j.f541212b) == true) goto L9;
        this.f541236d.setText(this.f541242j.f541212b);
    L9:
        if (TextUtils.isEmpty(this.f541242j.f541213c) == true) goto L12;
        this.f541237e.setText(this.f541242j.f541213c);
    L12:
        if (TextUtils.isEmpty(this.f541242j.f541214d) == true) goto L14;
        this.f541238f.setText(this.f541242j.f541214d);
    L14:
        setOnCancelListener(new h(this));
        this.f541237e.setOnClickListener(new i(this));
        this.f541238f.setOnClickListener(new j(this));
    }

    public k(Activity r100, b r101, boolean r102, l r103) {
        super(r100, R.style.BdTuring_Alert_Dialog);
        this.f541233a = r100;
        this.f541234b = r103;
        this.f541242j = r101;
        this.f541243k = r102;
    }
}
