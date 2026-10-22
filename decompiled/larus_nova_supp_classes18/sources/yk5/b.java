package yk5;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ee.bear.onboarding.export.OnBoardingColorStyle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b extends ep5.a implements sa5.q {
    public View a;
    public boolean b;
    public final Window c;
    public ru5.j d;
    public final FragmentActivity e;
    public c f;
    public ViewOnAttachStateChangeListenerC0340b g;
    public View h;
    public final a i;
    public sk5.d.b j;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ b a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r4) {
            b r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    /* JADX INFO: renamed from: yk5.b$b, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC0340b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ b a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public ViewOnAttachStateChangeListenerC0340b(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r4) {
            b r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public class c implements LifecycleObserver {
        public final /* synthetic */ b a;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void dismissDialog() {
            tt5.a.b("BaseOnBoardingDialog", "Activity is destroying, should dismissDialog...");
            b r0 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r0);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r2 == null) goto L16;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L5:
            if (Looper.myLooper() == r1.getLooper()) goto L7;
            r1.post(DialogLancet.createDismissRunnable(r0));
        }

        public c(b r1) {
            this.a = r1;
        }
    }

    public abstract void e(int r1, int r2, int r3);

    public final boolean c() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = this.e.getApplication();
        r0.getClass();
        UserSession r2 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b();
        return ((dn4.a) e0c.k.b(((v) e0c.k.a(r1, v.class)).c(r2), dn4.a.class)).a().isCurrentEnable("ccm.mobile.enable.onboarding_observe_forseti_dismiss");
    }

    @Override // ep5.a, android.app.Dialog
    public void show() {
        FragmentActivity r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == false) goto L7;
        return;
    L7:
        if (isShowing() == false) goto L10;
        return;
    L10:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L30;
        DialogLancet.handleBlockedDialogShow(this);
    L14:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{0.0f, 1.0f});
        r1.setDuration(250);
        r1.start();
        sa5.p r2 = (sa5.p) sa5.m.a.a(this.e, sa5.p.class);
        if (r2 == null) goto L17;
        r2.a(this);
    L17:
        this.f = new c(this);
        this.e.getLifecycle().addObserver(this.f);
        ru5.j r3 = new ru5.j(getContext(), new yk5.a(this));
        this.d = r3;
        if (r3.canDetectOrientation() == false) goto L20;
        this.d.enable();
    L20:
        View r4 = this.h;
        if (r4 == null) goto L24;
        r4.addOnAttachStateChangeListener(this.i);
    L24:
        if (c() == false) goto L34;
        com.ss.android.lark.forsetiutils.a r5 = this.e;
        if ((r5 instanceof com.ss.android.lark.forsetiutils.a) == false) goto L35;
        r5.a();
        return;
    L35:
        return;
    L34:
        return;
    L30:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L13:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L14
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        if (this.e.isFinishing() == false) goto L7;
        return;
    L7:
        if (this.e.isDestroyed() == true) goto L53;
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(this);
    L24:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{1.0f, 0.0f});
        r1.setDuration(250);
        r1.start();
        this.d.disable();
        tt5.a.b("OnBoardingManager..", "Dialog dismiss, hasAction: " + this.b);
        sk5.d.b r2 = this.j;
        if (r2 == null) goto L27;
        ((vk5.b) r2).c(this.b);
    L27:
        sa5.p r3 = (sa5.p) sa5.m.a.a(this.e, sa5.p.class);
        if (r3 == null) goto L30;
        r3.f(this);
    L30:
        Window r4 = this.c;
        if (r4 != null) goto L33;
    L35:
        View r5 = this.h;
        if (r5 == null) goto L38;
        r5.removeOnAttachStateChangeListener(this.i);
    L38:
        this.e.getLifecycle().removeObserver(this.f);
        if (c() == false) goto L50;
        com.ss.android.lark.forsetiutils.a r6 = this.e;
        if ((r6 instanceof com.ss.android.lark.forsetiutils.a) == false) goto L51;
        r6.b();
        return;
    L51:
        return;
    L50:
        return;
    L33:
        if (this.g == null) goto L35;
        a(r4).removeOnAttachStateChangeListener(this.g);
        goto L35
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r7 == null) goto L23;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        if (Looper.myLooper() == r0.getLooper()) goto L14;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L24
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

    public static void b(b r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void d(OnBoardingColorStyle r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        e(com.bytedance.ee.util.ui.n.h(getContext(), r4.getBgColorRes()), com.bytedance.ee.util.ui.n.h(getContext(), r4.getShadowColorRes()), com.bytedance.ee.util.ui.n.h(getContext(), r4.getMaskColorRes()));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r3) {
        if (r3.getKeyCode() == 4) goto L5;
        return false;
    L5:
        if (r3.getAction() != 1) goto L10;
        b(this);
        return false;
    L10:
        return false;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        Window r6 = getWindow();
        if (r6 == null) goto L15;
        WindowManager.LayoutParams r0 = r6.getAttributes();
        r0.width = -1;
        r0.height = -1;
        r0.flags |= 8;
        r6.setAttributes(r0);
        if (this.c != null) goto L13;
    L11:
        ((ViewGroup) a(r6)).addView(this.a);
        WindowInsetsUtils.a(this);
        return;
    L13:
        a(r6).setSystemUiVisibility(a(this.c).getSystemUiVisibility());     // Catch: Exception -> L8
    L10:
        this.g = new ViewOnAttachStateChangeListenerC0340b(this);
        a(this.c).addOnAttachStateChangeListener(this.g);
    L8:
        e = move-exception;
        tt5.a.e("BaseOnBoardingDialog", "setSystemUiVisibility error", e, false);
        goto L10
    }

    public b(FragmentActivity r1, Window r2, int r3) {
        super(r1, r3);
        this.b = false;
        this.i = new a(this);
        this.c = r2;
        this.e = r1;
    }
}
