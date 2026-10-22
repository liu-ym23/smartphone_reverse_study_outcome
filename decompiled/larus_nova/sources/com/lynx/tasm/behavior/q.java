package com.lynx.tasm.behavior;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.base.LLog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes32.dex */
public final class q extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f382168a = null;

    static {
        f382168a = q.class.getSimpleName();
    }

    public final int e() {
        DisplayMetrics r100 = new DisplayMetrics();
        Display r101 = getWindow().getWindowManager().getDefaultDisplay();
        Point r102 = new Point();
        Point r103 = new Point();
        r101.getCurrentSizeRange(r102, r103);
        r101.getMetrics(r100);
        int r104 = r100.heightPixels;
        int r105 = r101.getRotation();
        if (r105 != 0) goto L5;
    L8:
        int r106 = r103.y;
        if (r106 >= r104) goto L11;
        r104 = r106;
    L11:
        int r107 = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r107 <= 0) goto L14;
        int r108 = getContext().getResources().getDimensionPixelSize(r107);
    L16:
        return r104 + r108;
    L14:
        r108 = 0;
        goto L16
    L5:
        if (r105 == 2) goto L8;
        return r104;
    }

    public final void f() {
        String r100 = f382168a;
        if (isShowing() == true) goto L15;
    L10:
        e = move-exception;
        LLog.w(r100, e.toString());
        return;
    L8:
        e = move-exception;
        LLog.w(r100, e.toString());
        return;
    L5:
        if (getActivity(getContext()).isFinishing() == true) goto L16;
        c(this);     // Catch: RuntimeException -> L8 WindowManager.BadTokenException -> L10
    L18:
        return;
    L16:
        return;
    }

    public final View d() {
        return a(getWindow());
    }

    public q(Context r100) {
        super(r100);
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void b(q r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
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

    public static void c(q r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    private static Activity getActivity(Context r100) {
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        return getActivity(((ContextWrapper) r100).getBaseContext());
    L11:
        throw new IllegalArgumentException();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        getWindow().setGravity(3);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(2, -1);
        getWindow().setSoftInputMode(16);
        getWindow().addFlags(32);
        getWindow().addFlags(8);
        getWindow().addFlags(131072);
        getWindow().clearFlags(2);
        getWindow().clearFlags(1024);
        getWindow().clearFlags(67108864);
        getWindow().clearFlags(256);
        getWindow().clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        d().setSystemUiVisibility(0);
        d().setOutlineProvider(null);
        d().setElevation(0.0f);
        d().setTranslationZ(0.0f);
    }
}
