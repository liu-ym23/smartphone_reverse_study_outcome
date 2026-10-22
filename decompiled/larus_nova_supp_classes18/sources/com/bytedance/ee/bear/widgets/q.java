package com.bytedance.ee.bear.widgets;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q {
    public LottieAnimationView a;
    public final Context b;
    public Dialog c;
    public boolean d;
    public View e;
    public final Runnable f;
    public final Handler g;

    public final void a() {
        this.g.removeCallbacks(this.f);
        Context r0 = this.b;
        if ((r0 instanceof Activity) == true) goto L5;
    L25:
        this.d = false;
        return;
    L5:
        if (((Activity) r0).isDestroyed() == true) goto L25;
        if (c() == false) goto L25;
        this.a.cancelAnimation();
        Dialog r1 = this.c;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r1);
        goto L25
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r3 == null) goto L22;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        goto L22
    L11:
        if (Looper.myLooper() == r2.getLooper()) goto L13;
        r2.post(DialogLancet.createDismissRunnable(r1));
        goto L25
    }

    public final boolean c() {
        if (this.d == false) goto L5;
    L8:
        return true;
    L5:
        if (this.c.isShowing() == true) goto L8;
        return false;
    }

    public final void d() {
        if (this.c.getWindow() == null) goto L5;
        bp5.c.f(this.c.getWindow(), this.b.getResources().getColor(2131100545), true);
    L5:
        Context r0 = this.b;
        if ((r0 instanceof Activity) == true) goto L8;
    L15:
        tt5.a.h("LoadingDialog", "show()... activity is finishing");
        return;
    L8:
        if (((Activity) r0).isDestroyed() == true) goto L15;
        Dialog r1 = this.c;
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(r1);
    L14:
        this.a.playAnimation();
        return;
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L13:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        goto L14
    }

    public final void e() {
        this.g.removeCallbacks(this.f);
        this.g.postDelayed(this.f, 300);
        this.d = true;
    }

    public q(Context r3) {
        this.f = new o(this);
        this.g = new Handler(Looper.getMainLooper());
        this.b = r3;
        b(r3, false);
    }

    public q(Context r2, int r3) {
        this.f = new o(this);
        this.g = new Handler(Looper.getMainLooper());
        this.b = r2;
        b(r2, true);
    }

    public final void b(Context r7, boolean r8) {
        this.e = LayoutInflater.from(r7).inflate(2131568224, null);
        Dialog r0 = new Dialog(r7, 2131954396);
        this.c = r0;
        r0.setCanceledOnTouchOutside(true);
        this.c.setContentView(this.e);
        this.a = this.e.findViewById(2131378977);
        Window r1 = this.c.getWindow();
        View r2 = r1.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L7:
        r2.setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams r4 = r1.getAttributes();
        r4.gravity = 48;
        if (r8 == true) goto L10;
        r4.y = com.bytedance.ee.util.ui.k.e(r7);
    L10:
        r4.width = -1;
        r4.height = -1;
        r1.setAttributes(r4);
        TypedValue r9 = new TypedValue();
        r7.getResources().getValue(2131168390, r9, true);
        r1.setDimAmount(r9.getFloat());
        this.c.setOnDismissListener(new p(this));
    }
}
