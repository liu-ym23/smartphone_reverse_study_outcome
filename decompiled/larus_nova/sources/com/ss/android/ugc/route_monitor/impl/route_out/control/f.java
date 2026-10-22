package com.ss.android.ugc.route_monitor.impl.route_out.control;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.route_monitor.utils.Logger;

/* JADX INFO: loaded from: classes40.dex */
public final class f extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f454622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f454623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f454624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f454625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f454626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f454627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f454628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f454629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f454630i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f454631j;

    public static final class a {
    }

    public interface b {
        void a(f r100);

        void b(f r100);
    }

    static {
    }

    public final boolean a() {
        Context r100 = this.f454631j;
        if ((r100 instanceof Activity) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        Context r102 = this.f454631j;
        if ((r102 instanceof Activity) == true) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r101 == true) goto L17;
        if (r103 == true) goto L17;
        return true;
    L17:
        return false;
    L11:
        if (((Activity) r102).isDestroyed() == false) goto L13;
        r103 = true;
        goto L14
    L5:
        if (((Activity) r100).isFinishing() == false) goto L7;
        r101 = true;
        goto L8
    }

    public final Activity getActivity() {
        Context r100 = this.f454631j;
        if ((r100 instanceof Activity) == true) goto L5;
        Context r101 = getContext();
        if ((r101 instanceof Activity) == true) goto L11;
        return null;
    L11:
        return (Activity) r101;
    L5:
        return (Activity) r100;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        Logger.f454747c.b();
        super.onStart();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        Logger.f454747c.b();
        super.onStop();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (a() == true) goto L5;
        return;
    L5:
        if (isShowing() == false) goto L27;
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(this);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r101 == null) goto L20;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L9:
        if (Looper.myLooper() == r100.getLooper()) goto L11;
        r100.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (a() == true) goto L5;
        return;
    L5:
        if (isShowing() == true) goto L23;
    L12:
        th = move-exception;
        Logger.f454747c.d(th);
        return;
    L7:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(this);     // Catch: Throwable -> L12
        return;
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Throwable -> L12 Exception -> L18
    L14:
        DialogLancet.beforeDialogShow(this);     // Catch: Throwable -> L12
        super.show();     // Catch: Throwable -> L12
        DialogLancet.afterDialogShow(this);     // Catch: Throwable -> L12
        return;
    }

    public f(Context r100) {
        super(r100);
        this.f454631j = r100;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        Logger.f454747c.b();
        super.onCreate(r100);
        View r101 = getLayoutInflater().inflate(R.layout.dialog_route_out_alert, null);
        TextView r102 = (TextView) r101.findViewById(R.id.route_out_alert_title_tv);
        CharSequence r103 = this.f454626e;
        if (TextUtils.isEmpty(r103) == true) goto L5;
        r102.setText(r103);
        this.f454626e = null;
    L5:
        r102.setTextSize(0, r102.getTextSize() * 1.2f);
        this.f454622a = r102;
        TextView r104 = (TextView) r101.findViewById(R.id.route_out_alert_content_tv);
        CharSequence r105 = this.f454627f;
        if (TextUtils.isEmpty(r105) == true) goto L8;
        r104.setText(r105);
        this.f454627f = null;
    L8:
        this.f454623b = r104;
        TextView r106 = (TextView) r101.findViewById(R.id.route_out_alert_negative_btn);
        r106.setOnClickListener(new g(this));
        CharSequence r107 = this.f454628g;
        if (TextUtils.isEmpty(r107) == true) goto L11;
        r106.setText(r107);
        this.f454628g = null;
    L11:
        r106.setTextSize(0, r106.getTextSize() * 1.1f);
        this.f454624c = r106;
        TextView r108 = (TextView) r101.findViewById(R.id.route_out_alert_positive_btn);
        r108.setOnClickListener(new h(this));
        CharSequence r109 = this.f454629h;
        if (TextUtils.isEmpty(r109) == true) goto L14;
        r108.setText(r109);
        this.f454629h = null;
    L14:
        r108.setTextSize(0, r108.getTextSize() * 1.1f);
        this.f454625d = r108;
        setContentView(r101);
        Window r110 = getWindow();
        if (r110 == null) goto L17;
        r110.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.route_out_alert_dialog_bg));
    L17:
        ViewGroup r111 = (ViewGroup) r101;
    }
}
