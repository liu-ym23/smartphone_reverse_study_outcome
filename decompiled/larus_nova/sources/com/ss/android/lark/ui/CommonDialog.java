package com.ss.android.lark.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larksuite.framework.ui.BaseDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes38.dex */
public class CommonDialog extends BaseDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f444518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f444519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f444520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f444521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f444522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f444523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f444524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f444525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f444526i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f444527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f444528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f444529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Context f444530m;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View.OnClickListener f444531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f444532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommonDialog f444533c;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f444532b == false) goto L21;
            CommonDialog r101 = this.f444533c;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r101);
            goto L21
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r103 == null) goto L18;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
            goto L18
        L7:
            if (Looper.myLooper() == r102.getLooper()) goto L9;
            r102.post(DialogLancet.createDismissRunnable(r101));
        L21:
            this.f444531a.onClick(r100);
        }

        public a(CommonDialog r100, c8c.b r101) {
            this.f444533c = r100;
            this.f444531a = r101;
            this.f444532b = true;
        }
    }

    @Override // com.larksuite.framework.ui.BaseDialog, android.app.Dialog
    public final void show() {
        WindowManager.LayoutParams r100 = getWindow().getAttributes();
        Resources r101 = getContext().getResources();
        int r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).widthPixels;
        r100.width = y9c.d.b(this.f444530m, 300.0f);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public CommonDialog(Context r100) {
        super(r100, R.style.CommonDialog);
        setContentView(R.layout.common_dialog_layout);
        this.f444530m = r100;
        this.f444523f = (TextView) findViewById(R.id.dialog_title);
        this.f444524g = (TextView) findViewById(R.id.dialog_message);
        this.f444518a = (FrameLayout) findViewById(R.id.dialog_title_container);
        this.f444519b = (FrameLayout) findViewById(R.id.dialog_content_container);
        this.f444520c = (FrameLayout) findViewById(R.id.dialog_content_divider_container);
        this.f444521d = (FrameLayout) findViewById(R.id.dialog_buttons_container);
        this.f444525h = findViewById(R.id.dialog_content_divider);
        this.f444526i = findViewById(R.id.dialog_vertical_divider);
        this.f444527j = (TextView) findViewById(R.id.dialog_btn_left);
        this.f444528k = (TextView) findViewById(R.id.dialog_btn_right);
        this.f444529l = (TextView) findViewById(R.id.dialog_single_btn);
        this.f444522e = (FrameLayout) findViewById(R.id.dialog_bottom_holder);
    }
}
