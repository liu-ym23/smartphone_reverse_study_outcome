package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.base.AbstractDialog;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends AbstractDialog implements zla.f {
    public static final /* synthetic */ int Q = 0;
    public final FrameLayout G;
    public final FrameLayout H;
    public zla.h I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final TextView f400739J;
    public final TextView K;
    public final FrameLayout L;
    public zla.h M;
    public final FrameLayout N;
    public final ViewGroup O;
    public zla.h P;

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public final int f() {
        return R.layout.o_alert_dialog_v2;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        int r100 = DialogAnimStyle.f400636a;
        com.obric.oui.animation.easy.b r101 = DialogAnimStyle.d(g(), getWindow(), !this.f400658l, true);
        com.obric.oui.animation.easy.b.d(r101, new OAlertDialog$performExitAnimation$1$1(this), new OAlertDialog$performExitAnimation$1$2(this), 1);
        r101.e();
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        g().post(new b(this));
        TextView r100 = this.K;
        if (r100 == null) goto L7;
        r100.postDelayed(new a(this), 1000);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public final void show() {
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

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public final View e() {
        return this.O;
    }

    @Override // zla.f
    public final FrameLayout getBannerSlot() {
        return this.G;
    }

    @Override // zla.f
    public final FrameLayout getBodySlot() {
        return this.N;
    }

    @Override // zla.f
    public final FrameLayout getButtonSlot() {
        return this.L;
    }

    @Override // zla.f
    public final FrameLayout getIconSlot() {
        return this.H;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.G = (FrameLayout) findViewById(R.id.bannerPanel);
        this.H = (FrameLayout) findViewById(R.id.iconPanel);
        this.O = (ViewGroup) findViewById(R.id.header_container);
        TextView r101 = (TextView) findViewById(R.id.textTitle);
        this.f400739J = r101;
        if (r101 == null) goto L6;
        r101.setIncludeFontPadding(true);
    L6:
        TextView r102 = (TextView) findViewById(R.id.textSubTitle);
        this.K = r102;
        if (r102 == null) goto L10;
        r102.setIncludeFontPadding(true);
    L10:
        this.L = (FrameLayout) findViewById(R.id.button_container);
        this.N = (FrameLayout) findViewById(R.id.body_container);
    }

    public static void k(c r100) {
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

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        if (this.f400657k == false) goto L5;
        g().setAlpha(0.0f);
    L5:
        super.onCreate(r100);
        zla.h r101 = this.I;
        if (r101 == null) goto L9;
        r101.c(this);
    L9:
        zla.h r102 = this.M;
        if (r102 == null) goto L13;
        r102.c(this);
    L13:
        zla.h r103 = this.P;
        if (r103 == null) goto L18;
        r103.c(this);
        return;
    }
}
