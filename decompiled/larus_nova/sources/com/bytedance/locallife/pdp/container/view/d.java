package com.bytedance.locallife.pdp.container.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.dux.text.DuxTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f261257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProgressBar f261258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DuxTextView f261259c;

    public class a extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
        }

        public a() {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        LinearLayout r101 = this.f261257a;
        ObjectAnimator.ofFloat(r101, "alpha", new float[]{r101.getAlpha(), 0.0f}).setDuration(300).addListener(new a());
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        ObjectAnimator.ofFloat(this.f261257a, "alpha", new float[]{0.0f, 1.0f}).setDuration(300).start();
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public d(Context r100) {
        super(r100, R.style.DialogProgressTheme);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.saas_dialog_auth_loading);
        this.f261257a = (LinearLayout) findViewById(R.id.main_layout);
        this.f261258b = (ProgressBar) findViewById(R.id.progress_bar);
        this.f261259c = (DuxTextView) findViewById(R.id.loading_text);
        this.f261258b.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(), R.color.white), PorterDuff.Mode.MULTIPLY);
        setCanceledOnTouchOutside(false);
        if (TextUtils.isEmpty(null) == true) goto L6;
        UIUtils.setText(this.f261259c, null);
        return;
    }
}
