package sb4;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes12.dex */
public final class g extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f541219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f541220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f541221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f541222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f541223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f541224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f541225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f541226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f541227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f541228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f541229k;

    @Override // android.app.Dialog
    public final void show() {
        if ((!this.f541219a.isFinishing()) == true) goto L6;
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
        setContentView(R.layout.bdturing_permission_dialog_layout);
        WindowManager.LayoutParams r101 = getWindow().getAttributes();
        r101.width = -1;
        r101.height = -1;
        this.f541226h = findViewById(R.id.v_divide_line_h);
        this.f541227i = findViewById(R.id.v_divide_line_v);
        this.f541221c = (TextView) findViewById(R.id.tv_dlg_title);
        this.f541222d = (TextView) findViewById(R.id.tv_dlg_content);
        this.f541223e = (TextView) findViewById(R.id.tv_alert_dlg_left);
        this.f541224f = (TextView) findViewById(R.id.tv_alert_dlg_right);
        this.f541225g = findViewById(R.id.root_view);
        setCancelable(this.f541229k);
        if (TextUtils.isEmpty(this.f541228j.f541211a) == true) goto L6;
        this.f541221c.setText(this.f541228j.f541211a);
    L6:
        if (TextUtils.isEmpty(this.f541228j.f541212b) == true) goto L9;
        this.f541222d.setText(this.f541228j.f541212b);
    L9:
        if (TextUtils.isEmpty(this.f541228j.f541213c) == true) goto L12;
        this.f541223e.setText(this.f541228j.f541213c);
    L12:
        if (TextUtils.isEmpty(this.f541228j.f541214d) == true) goto L14;
        this.f541224f.setText(this.f541228j.f541214d);
    L14:
        setOnCancelListener(new d(this));
        this.f541223e.setOnClickListener(new e(this));
        this.f541224f.setOnClickListener(new f(this));
    }

    public g(Activity r100, b r101, l r102) {
        super(r100, R.style.BdTuring_Alert_Dialog);
        this.f541219a = r100;
        this.f541220b = r102;
        this.f541228j = r101;
        this.f541229k = false;
    }
}
