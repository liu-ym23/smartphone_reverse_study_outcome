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
import androidx.core.view.KeyEventDispatcher;
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

/* JADX INFO: loaded from: classes18.dex */
public abstract class b extends ep5.a implements sa5.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f568128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f568129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f568130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ru5.j f568131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentActivity f568132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f568133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewOnAttachStateChangeListenerC8348b f568134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f568135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f568136i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public sk5.d.b f568137j;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f568138a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
        }

        public a(b r100) {
            this.f568138a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            b r101 = this.f568138a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    /* JADX INFO: renamed from: yk5.b$b, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC8348b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f568139a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
        }

        public ViewOnAttachStateChangeListenerC8348b(b r100) {
            this.f568139a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            b r101 = this.f568139a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public class c implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f568140a;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void dismissDialog() {
            tt5.a.b("BaseOnBoardingDialog", "Activity is destroying, should dismissDialog...");
            b r100 = this.f568140a;
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r102 == null) goto L16;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L7;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }

        public c(b r100) {
            this.f568140a = r100;
        }
    }

    public abstract void e(int r100, int r101, int r102);

    public final boolean c() {
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        Application r101 = this.f568132e.getApplication();
        r100.getClass();
        UserSession r102 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r101, com.ss.android.lark.passportc.convention.a.class)).b();
        return ((dn4.a) e0c.k.b(((v) e0c.k.a(r101, v.class)).c(r102), dn4.a.class)).a().isCurrentEnable("ccm.mobile.enable.onboarding_observe_forseti_dismiss");
    }

    @Override // ep5.a, android.app.Dialog
    public void show() {
        FragmentActivity r100 = this.f568132e;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == false) goto L7;
        return;
    L7:
        if (isShowing() == false) goto L10;
        return;
    L10:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L30;
        DialogLancet.handleBlockedDialogShow(this);
    L14:
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f568128a, "alpha", new float[]{0.0f, 1.0f});
        r101.setDuration(250);
        r101.start();
        sa5.p r102 = (sa5.p) sa5.m.a.a(this.f568132e, sa5.p.class);
        if (r102 == null) goto L17;
        r102.a(this);
    L17:
        this.f568133f = new c(this);
        this.f568132e.getLifecycle().addObserver(this.f568133f);
        ru5.j r103 = new ru5.j(getContext(), new yk5.a(this));
        this.f568131d = r103;
        if (r103.canDetectOrientation() == false) goto L20;
        this.f568131d.enable();
    L20:
        View r104 = this.f568135h;
        if (r104 == null) goto L24;
        r104.addOnAttachStateChangeListener(this.f568136i);
    L24:
        if (c() == false) goto L34;
        KeyEventDispatcher.Component r105 = this.f568132e;
        if ((r105 instanceof com.ss.android.lark.forsetiutils.a) == false) goto L35;
        ((com.ss.android.lark.forsetiutils.a) r105).a();
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
        if (this.f568132e.isFinishing() == false) goto L7;
        return;
    L7:
        if (this.f568132e.isDestroyed() == true) goto L53;
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(this);
    L24:
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f568128a, "alpha", new float[]{1.0f, 0.0f});
        r101.setDuration(250);
        r101.start();
        this.f568131d.disable();
        tt5.a.b("OnBoardingManager..", "Dialog dismiss, hasAction: " + this.f568129b);
        sk5.d.b r102 = this.f568137j;
        if (r102 == null) goto L27;
        ((vk5.b) r102).c(this.f568129b);
    L27:
        sa5.p r103 = (sa5.p) sa5.m.a.a(this.f568132e, sa5.p.class);
        if (r103 == null) goto L30;
        r103.f(this);
    L30:
        Window r104 = this.f568130c;
        if (r104 != null) goto L33;
    L35:
        View r105 = this.f568135h;
        if (r105 == null) goto L38;
        r105.removeOnAttachStateChangeListener(this.f568136i);
    L38:
        this.f568132e.getLifecycle().removeObserver(this.f568133f);
        if (c() == false) goto L50;
        KeyEventDispatcher.Component r106 = this.f568132e;
        if ((r106 instanceof com.ss.android.lark.forsetiutils.a) == false) goto L51;
        ((com.ss.android.lark.forsetiutils.a) r106).b();
        return;
    L51:
        return;
    L50:
        return;
    L33:
        if (this.f568134g == null) goto L35;
        a(r104).removeOnAttachStateChangeListener(this.f568134g);
        goto L35
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r107 == null) goto L23;
        com.bytedance.crash.d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        if (Looper.myLooper() == r100.getLooper()) goto L14;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L24
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

    public static void b(b r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final void d(OnBoardingColorStyle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        e(com.bytedance.ee.util.ui.n.h(getContext(), r100.getBgColorRes()), com.bytedance.ee.util.ui.n.h(getContext(), r100.getShadowColorRes()), com.bytedance.ee.util.ui.n.h(getContext(), r100.getMaskColorRes()));
    }

    @Override // android.app.Dialog, android.view.Window.Callback, sa5.q
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (r100.getKeyCode() == 4) goto L5;
        return false;
    L5:
        if (r100.getAction() != 1) goto L10;
        b(this);
        return false;
    L10:
        return false;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L15;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -1;
        r102.height = -1;
        r102.flags |= 8;
        r101.setAttributes(r102);
        if (this.f568130c != null) goto L13;
    L11:
        ((ViewGroup) a(r101)).addView(this.f568128a);
        WindowInsetsUtils.a(this);
        return;
    L13:
        a(r101).setSystemUiVisibility(a(this.f568130c).getSystemUiVisibility());     // Catch: Exception -> L8
    L10:
        this.f568134g = new ViewOnAttachStateChangeListenerC8348b(this);
        a(this.f568130c).addOnAttachStateChangeListener(this.f568134g);
    L8:
        e = move-exception;
        tt5.a.e("BaseOnBoardingDialog", "setSystemUiVisibility error", e, false);
        goto L10
    }

    public b(FragmentActivity r100, Window r101, int r102) {
        super(r100, r102);
        this.f568129b = false;
        this.f568136i = new a(this);
        this.f568130c = r101;
        this.f568132e = r100;
    }
}
