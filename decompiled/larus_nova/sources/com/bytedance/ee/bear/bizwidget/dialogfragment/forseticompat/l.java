package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f216473a = 0;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f216474a;

        public a(Dialog r100) {
            this.f216474a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            Intrinsics.checkNotNullParameter(r100, "<unused var>");
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r101.getAction() != 4) goto L25;
            Dialog r102 = this.f216474a;
            if (r102 == null) goto L23;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r102);
            return true;
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L16:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r104 == null) goto L20;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
            goto L20
        L9:
            if (Looper.myLooper() == r103.getLooper()) goto L11;
            r103.post(DialogLancet.createDismissRunnable(r102));
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

    public static void b(Activity r100, Dialog r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setDimAmount(0.0f);
        a(r102).setPadding(0, 0, 0, 0);
        r102.setBackgroundDrawable(AppCompatResources.getDrawable(r100, R.drawable.pop_window_circle_float_bg));
        r102.setElevation(8.0f);
        r102.clearFlags(2);
        return;
    }

    public static k c(Activity r100, Dialog r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        Ref.IntRef r102 = new Ref.IntRef();
        r102.element = r100.getResources().getConfiguration().orientation;
        Ref.IntRef r103 = new Ref.IntRef();
        r103.element = r100.getResources().getConfiguration().screenLayout;
        return new k(r102, r103, r101);
    }

    public static void d(Dialog r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        tt5.a.h("ForsetiPopHelper", "initBottomDialog() called with: dialog = " + r100 + ", width = " + r101);
        Window r102 = r100.getWindow();
        if (r102 == null) goto L5;
        r102.addFlags(8);
    L5:
        Window r103 = r100.getWindow();
        if (r103 == null) goto L8;
        r103.addFlags(131072);
    L8:
        Window r104 = r100.getWindow();
        if (r104 == null) goto L11;
        r104.addFlags(262144);
    L11:
        r100.setCancelable(true);
        r100.setCanceledOnTouchOutside(true);
        Window r105 = r100.getWindow();
        if (r105 == null) goto L16;
        View r106 = a(r105);
        if (r106 == null) goto L16;
        r106.setOnTouchListener(new a(r100));
    L16:
        Window r107 = r100.getWindow();
        if (r107 == null) goto L20;
        a(r107).setPadding(0, 0, 0, 0);
        r107.setBackgroundDrawable(null);
        r107.setLayout(r101, -2);
        r107.setGravity(VideoPlayDataContext.PLAYING_GRAVITY);
        r107.setDimAmount(0.0f);
        return;
    }
}
