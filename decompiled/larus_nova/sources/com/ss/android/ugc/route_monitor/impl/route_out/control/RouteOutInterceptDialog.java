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
import com.ss.android.ugc.route_monitor.view.CountDownTextView;

/* JADX INFO: loaded from: classes40.dex */
public final class RouteOutInterceptDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f454599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f454600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f454601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CountDownTextView f454602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f454603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f454604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f454605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f454606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f454607i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f454608j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f454609k;

    public static final class a {
    }

    public interface b {
        void a(RouteOutInterceptDialog r100);

        void b(RouteOutInterceptDialog r100);
    }

    static {
    }

    public final boolean a() {
        Context r100 = this.f454609k;
        if ((r100 instanceof Activity) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        Context r102 = this.f454609k;
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
        Context r100 = this.f454609k;
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
        if (this.f454607i <= 0) goto L16;
        CountDownTextView r100 = this.f454602d;
        if (r100 == null) goto L19;
        String r101 = this.f454606h;
        long r102 = this.f454607i;
        nhc.a r103 = new nhc.a(r101, r102, new AnonymousClass1(this));
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (r100.f454786a != null) goto L11;
        r100.f454786a = r103;     // Catch: Throwable -> L13
        r100.f454787b = r102;     // Catch: Throwable -> L13
        r100.a(r103);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);
        return;
    L19:
        return;
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
        if (isShowing() == false) goto L41;
        CountDownTextView r100 = this.f454602d;
        if (r100 == null) goto L18;
        nhc.a r101 = r100.f454786a;
        if (r101 == null) goto L18;
        monitor-enter(r100);
        r100.f454786a = null;     // Catch: Throwable -> L15
        r100.f454787b = 0;     // Catch: Throwable -> L15
        r101.f519203b.invoke(r101);     // Catch: Throwable -> L15
        monitor-exit(r100);
    L15:
        th = move-exception;
        throw th;
    L18:
        Handler r102 = DialogLancet.resolveDialogHandler(this);
        if (r102 != null) goto L21;
    L23:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L26 Exception -> L28
    L32:
        DialogLancet.afterDialogDismiss(this);
        return;
    L26:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L28:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L26
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L26
        if (r103 == null) goto L32;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L26
        goto L32
    L21:
        if (Looper.myLooper() == r102.getLooper()) goto L23;
        r102.post(DialogLancet.createDismissRunnable(this));
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

    public RouteOutInterceptDialog(Context r100) {
        super(r100);
        this.f454609k = r100;
        this.f454606h = "返回(%ds)";
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        Logger.f454747c.b();
        super.onCreate(r100);
        View r101 = getLayoutInflater().inflate(R.layout.dialog_route_out_intercept, null);
        TextView r102 = (TextView) r101.findViewById(R.id.route_out_intercept_title_tv);
        CharSequence r103 = this.f454603e;
        if (TextUtils.isEmpty(r103) == true) goto L5;
        r102.setText(r103);
        this.f454603e = null;
    L5:
        r102.setTextSize(0, r102.getTextSize() * 1.2f);
        this.f454599a = r102;
        TextView r104 = (TextView) r101.findViewById(R.id.route_out_intercept_content_tv);
        CharSequence r105 = this.f454604f;
        if (TextUtils.isEmpty(r105) == true) goto L8;
        r104.setText(r105);
        this.f454604f = null;
    L8:
        this.f454600b = r104;
        TextView r106 = (TextView) r101.findViewById(R.id.route_out_intercept_negative_btn);
        r106.setOnClickListener(new p(this));
        CharSequence r107 = this.f454605g;
        if (TextUtils.isEmpty(r107) == true) goto L11;
        r106.setText(r107);
        this.f454605g = null;
    L11:
        r106.setTextSize(0, r106.getTextSize() * 1.1f);
        this.f454601c = r106;
        CountDownTextView r108 = (CountDownTextView) r101.findViewById(R.id.route_out_intercept_positive_btn);
        r108.setOnClickListener(new q(this));
        String r109 = this.f454606h;
        if (TextUtils.isEmpty(r109) == true) goto L14;
        r108.setText(r109);
    L14:
        r108.setTextSize(0, r108.getTextSize() * 1.1f);
        this.f454602d = r108;
        setContentView(r101);
        Window r110 = getWindow();
        if (r110 == null) goto L17;
        r110.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.route_out_alert_dialog_bg));
    L17:
        ViewGroup r111 = (ViewGroup) r101;
    }
}
