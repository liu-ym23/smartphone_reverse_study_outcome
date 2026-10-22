package com.obric.oui.dialog.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class q extends AbstractDialog {
    public final boolean G;
    public boolean H;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f400730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f400731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<OButton, Unit> f400732c;

        public a(String r100, Function0 r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f400730a = r100;
            this.f400731b = r101;
            this.f400732c = null;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.H == false) goto L6;
        wma.b.a("BaseDialog", "dismiss() called but dialog is already dismissing, ignore.");
        return;
    L6:
        this.H = true;
        int r100 = DialogAnimStyle.f400636a;
        com.obric.oui.animation.easy.b r101 = DialogAnimStyle.d(g(), getWindow(), !this.f400658l, this.G);
        com.obric.oui.animation.easy.b.d(r101, new OBaseDialog$performExitAnimation$1$1(this), new OBaseDialog$performExitAnimation$1$2(this), 1);
        r101.e();
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        this.H = false;
        g().post(new p(this));
    }

    public q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.G = true;
    }

    public static void k(AbstractDialog r100) {
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
}
