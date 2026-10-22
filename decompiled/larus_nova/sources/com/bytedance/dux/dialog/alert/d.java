package com.bytedance.dux.dialog.alert;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.dux.button.DuxButton;
import com.bytedance.dux.dialog.base.AbstractDialog;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import em4.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends AbstractDialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f204928s = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final FrameLayout f204929l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f204930m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f204931n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final FrameLayout f204932o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public h f204933p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FrameLayout f204934q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f204935r;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Window r100 = getWindow();
        if (r100 == null) goto L9;
        View r101 = d(r100);
        if (r101 == null) goto L10;
        AnimatorSet r102 = new AnimatorSet();
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.9f});
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.9f});
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{1.0f, 0.0f});
        r102.setDuration(160);
        r102.setInterpolator(PathInterpolatorCompat.create(0.4f, 0.0f, 0.9f, 0.6f));
        r102.playTogether(new Animator[]{r103, r104, r105});
        r102.addListener(new e(this));
        r102.start();
        return;
    L10:
        return;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        Window r100 = getWindow();
        if (r100 == null) goto L8;
        View r101 = d(r100);
        if (r101 == null) goto L8;
        AnimatorSet r102 = new AnimatorSet();
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.9f, 1.0f});
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.9f, 1.0f});
        r102.setDuration(300);
        r102.setInterpolator(new vl4.b(0.81f));
        r102.playTogether(new Animator[]{r103, r104});
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{0.0f, 1.0f});
        r105.setDuration(90);
        r105.setInterpolator(new LinearInterpolator());
        AnimatorSet r106 = new AnimatorSet();
        r106.play(r102).with(r105);
        r106.start();
    L8:
        h r107 = this.f204933p;
        if ((r107 instanceof ButtonStyleController) == false) goto L14;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.bytedance.dux.dialog.alert.ButtonStyleController");
        DuxButton r108 = ((ButtonStyleController) r107).f204912b;
        if (r108 == null) goto L15;
        n.d(r108);
        return;
    L15:
        return;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f204935r = true;
        this.f204929l = (FrameLayout) findViewById(R.id.iconPanel);
        TextView r101 = (TextView) findViewById(R.id.textTitle);
        this.f204930m = r101;
        TextView r102 = (TextView) findViewById(R.id.textSubTitle);
        this.f204931n = r102;
        this.f204932o = (FrameLayout) findViewById(R.id.button_container);
        this.f204934q = (FrameLayout) findViewById(R.id.body_container);
        if (this.f204963b == false) goto L11;
        if (r101 == null) goto L7;
        com.bytedance.dux.largefont.a.c(r101, 17.0f);
    L7:
        if (r102 == null) goto L10;
        com.bytedance.dux.largefont.a.c(r102, 14.0f);
        return;
    L10:
        return;
    }

    public static void c(d r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static View d(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        h r101 = this.f204933p;
        if (r101 == null) goto L6;
        r101.a(this);
        return;
    }
}
