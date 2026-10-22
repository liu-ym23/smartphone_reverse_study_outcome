package hk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.crash.d;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f485517a;

    @Override // android.app.Dialog
    public final void show() {
        Window r100 = getWindow();
        if (r100 == null) goto L5;
        r100.clearFlags(131072);
    L5:
        Window r101 = getWindow();
        if (r101 == null) goto L9;
        r101.setFlags(8, 8);
    L9:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(this);
    L13:
        Window r102 = getWindow();
        if (r102 == null) goto L20;
        r102.clearFlags(8);
        return;
    L20:
        return;
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L12:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L13
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ECPopupDialog);
        setCancelable(false);
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f485517a == false) goto L25;
        Activity r101 = ECHybridExtensionsKt.a(getContext());
        if (r101 == null) goto L7;
        MotionEvent r102 = MotionEvent.obtain(r100);
        r102.setLocation(r100.getRawX() - a(r101.getWindow()).getX(), r100.getRawY() - a(r101.getWindow()).getY());
        r101.dispatchTouchEvent(r102);
        goto L25
    L7:
        Handler r103 = DialogLancet.resolveDialogHandler(this);
        if (r103 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(this);
        goto L25
    L17:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r104 == null) goto L21;
        d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L10:
        if (Looper.myLooper() == r103.getLooper()) goto L12;
        r103.post(DialogLancet.createDismissRunnable(this));
    L25:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        r101.setLayout(-1, -1);
        r101.setFlags(32, 32);
        return;
    }
}
