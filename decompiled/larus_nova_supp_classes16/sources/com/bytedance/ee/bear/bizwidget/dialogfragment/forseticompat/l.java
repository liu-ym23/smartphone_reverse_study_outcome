package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ Dialog a;

        public a(Dialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r3, MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r3, "<unused var>");
            Intrinsics.checkNotNullParameter(r4, "event");
            if (r4.getAction() != 4) goto L25;
            Dialog r5 = this.a;
            if (r5 == null) goto L23;
            Handler r6 = DialogLancet.resolveDialogHandler(r5);
            if (r6 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r5);
            return true;
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L16:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r7 == null) goto L20;
            com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
            goto L20
        L9:
            if (Looper.myLooper() == r6.getLooper()) goto L11;
            r6.post(DialogLancet.createDismissRunnable(r5));
            return true;
        L23:
            return true;
        L25:
            return false;
        }
    }

    static {
    }

    public l() {
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void b(Activity r2, Dialog r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        Window r4 = r3.getWindow();
        if (r4 == null) goto L7;
        r4.setDimAmount(0.0f);
        a(r4).setPadding(0, 0, 0, 0);
        r4.setBackgroundDrawable(AppCompatResources.getDrawable(r2, 2131247393));
        r4.setElevation(8.0f);
        r4.clearFlags(2);
        return;
    }

    public static k c(Activity r2, Dialog r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        Ref.IntRef r0 = new Ref.IntRef();
        r0.element = r2.getResources().getConfiguration().orientation;
        Ref.IntRef r1 = new Ref.IntRef();
        r1.element = r2.getResources().getConfiguration().screenLayout;
        return new k(r0, r1, r3);
    }

    public static void d(Dialog r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        tt5.a.h("ForsetiPopHelper", "initBottomDialog() called with: dialog = " + r2 + ", width = " + r3);
        Window r0 = r2.getWindow();
        if (r0 == null) goto L5;
        r0.addFlags(8);
    L5:
        Window r1 = r2.getWindow();
        if (r1 == null) goto L8;
        r1.addFlags(131072);
    L8:
        Window r4 = r2.getWindow();
        if (r4 == null) goto L11;
        r4.addFlags(262144);
    L11:
        r2.setCancelable(true);
        r2.setCanceledOnTouchOutside(true);
        Window r5 = r2.getWindow();
        if (r5 == null) goto L16;
        View r6 = a(r5);
        if (r6 == null) goto L16;
        r6.setOnTouchListener(new a(r2));
    L16:
        Window r7 = r2.getWindow();
        if (r7 == null) goto L20;
        a(r7).setPadding(0, 0, 0, 0);
        r7.setBackgroundDrawable(null);
        r7.setLayout(r3, -2);
        r7.setGravity(8388693);
        r7.setDimAmount(0.0f);
        return;
    }
}
