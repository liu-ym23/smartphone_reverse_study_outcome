package com.larus.livetutor.impl.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import androidx.appcompat.app.AppCompatDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.home.impl.utils.c;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.livetutor.impl.utils.WindowInsetsAnimationCallbackOptions$toWindowInsetsAnimationCallback$1;
import com.larus.livetutor.impl.utils.n;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ej9.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\"\b\u0016\u0018\u0000 F2\u00020\u0001:\u0001FB*\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0019\b\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u001dH\u0016J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u001aH\u0016J\u001a\u0010'\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u001dH\u0002J\b\u00101\u001a\u00020\u0007H\u0014J\u0010\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0016H\u0016J\b\u00104\u001a\u00020\u0007H\u0016J\b\u00105\u001a\u00020\u0007H\u0014J\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0016H\u0016J\b\u00108\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u00020\u0007H\u0002J\b\u0010:\u001a\u00020\u0007H\u0002J\b\u0010;\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020\u0007H\u0016J\u0012\u0010<\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010>\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010?\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010@\u001a\u00020\u00072\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BJ\u0012\u0010C\u001a\u00020\u00072\n\b\u0002\u0010=\u001a\u0004\u0018\u00010DJ\u001a\u0010E\u001a\u00020\u00072\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#¨\u0006G"}, d2 = {"Lcom/larus/livetutor/impl/base/BaseBottomDialog;", "Landroidx/appcompat/app/AppCompatDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "config", "Lkotlin/Function1;", "Lcom/larus/livetutor/impl/base/BottomDialogConfig;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "dialogConfig", "showListeners", "", "Landroid/content/DialogInterface$OnShowListener;", "dismissListeners", "Landroid/content/DialogInterface$OnDismissListener;", "cancelListeners", "Landroid/content/DialogInterface$OnCancelListener;", "configurationChangedListener", "Landroid/content/res/Configuration;", "showingAnimDone", "", "dismissAnim", "Landroid/animation/AnimatorSet;", "navigationBarSpace", "Landroid/view/View;", "softInputAnimating", "finalIMEHeight", "", "navigationBarHeight", "getNavigationBarHeight", "()I", "componentCallbacks", "com/larus/livetutor/impl/base/BaseBottomDialog$componentCallbacks$1", "Lcom/larus/livetutor/impl/base/BaseBottomDialog$componentCallbacks$1;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "layoutResID", "params", "Landroid/view/ViewGroup$LayoutParams;", "view", "wrapContentView", "contentView", "adjustSoftInput", "updateNavigationSpaceHeight", "imeHeight", "clickOutsideMask", "setCanceledOnTouchOutside", "cancel", "show", WidgetCostModule.TYPE_ON_START, "onWindowFocusChanged", "hasFocus", "showWithAnimation", "dismissSuper", "dismissWithAnimation", "dismiss", "setOnShowListener", "listener", "setOnDismissListener", "setOnCancelListener", "setWindowInsetsAnimationCompatCallback", "callback", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "setOnApplyWindowInsetsListener", "Landroidx/core/view/OnApplyWindowInsetsListener;", "setOnConfigurationChangedListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseBottomDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f355878m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f355879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BottomDialogConfig f355880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<DialogInterface.OnShowListener> f355881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<DialogInterface.OnDismissListener> f355882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<DialogInterface.OnCancelListener> f355883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Function1<Configuration, Unit>> f355884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f355885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f355886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f355887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f355888j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f355889k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f355890l;

    public static final class a {
    }

    public static final class b implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseBottomDialog f355891a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r100) {
        }

        public b(BaseBottomDialog r100) {
            this.f355891a = r100;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
            Intrinsics.checkNotNullParameter(r100, "newConfig");
            Iterator<T> r101 = this.f355891a.f355884f.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((Function1) r101.next()).invoke(r100);
            goto L4
        }
    }

    static {
    }

    public final int M0() {
        Context r100 = this.f355879a;
        boolean r101 = UtilsKt.f356659a;
        int r102 = 20;
    L3:
        r102 = r102 - 1;
        if (r102 <= 0) goto L9;
        if ((r100 instanceof FragmentActivity) == true) goto L9;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.content.ContextWrapper");
        r100 = ((ContextWrapper) r100).getBaseContext();
    L9:
        if ((r100 instanceof FragmentActivity) == false) goto L11;
        FragmentActivity r103 = (FragmentActivity) r100;
    L12:
        if (r103 != null) goto L18;
        return 0;
    L18:
        return u.b(r103);
    L11:
        r103 = null;
        goto L12
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f355880b.getDismissWithAnimation() == false) goto L27;
        AnimatorSet r100 = this.f355886h;
        boolean r101 = true;
        if (r100 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L30;
        View r103 = findViewById(R.id.dialog_container);
        Property r104 = View.TRANSLATION_Y;
        float[] r105 = new float[2];
        float r106 = 0.0f;
        r105[0] = 0.0f;
        if (r103 == null) goto L15;
        r106 = r103.getHeight();
    L15:
        r105[1] = r106;
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r103, r104, r105);
        ObjectAnimator r108 = ObjectAnimator.ofFloat(findViewById(R.id.touch_outside_mask), View.ALPHA, new float[]{1.0f, 0.0f});
        AnimatorSet r109 = new AnimatorSet();
        r109.playTogether(new Animator[]{r107, r108});
        Long r110 = Long.valueOf(this.f355880b.getDismissDuration());
        if (r110.longValue() > 0) goto L20;
        r101 = false;
    L20:
        if (Boolean.valueOf(r101).booleanValue() == true) goto L23;
        r110 = null;
    L23:
        if (r110 == null) goto L25;
        long r111 = r110.longValue();
    L26:
        r109.setDuration(r111);
        r109.setInterpolator(this.f355880b.getInterpolator());
        r109.addListener(new i(this));
        r109.start();
        this.f355886h = r109;
        return;
    L25:
        r111 = 240;
        goto L26
    L30:
        return;
    L7:
        if (r100.isRunning() != true) goto L9;
        r102 = true;
        goto L10
    L27:
        L0();
    }

    public final void L0() {
        if (isShowing() == true) goto L31;
        return;
    L31:
        Window r100 = getWindow();     // Catch: Throwable -> L23 IllegalArgumentException -> L25
        if (r100 == null) goto L10;
        View r101 = J0(r100);     // Catch: Throwable -> L23 IllegalArgumentException -> L25
        if (r101 == null) goto L10;
        IBinder r102 = r101.getWindowToken();     // Catch: Throwable -> L23 IllegalArgumentException -> L25
    L11:
        if (r102 == null) goto L22;
        I0(this);     // Catch: Throwable -> L23 IllegalArgumentException -> L25
        Iterator<T> r103 = this.f355882d.iterator();     // Catch: Throwable -> L23 IllegalArgumentException -> L25
    L14:
        if (r103.hasNext() == false) goto L18;
        DialogInterface.OnDismissListener r104 = (DialogInterface.OnDismissListener) r103.next();     // Catch: Throwable -> L23 IllegalArgumentException -> L25
        if (r104 == null) goto L14;
        r104.onDismiss(this);     // Catch: Throwable -> L23 IllegalArgumentException -> L25
        goto L14
    L18:
        AnimatorSet r105 = this.f355886h;     // Catch: Throwable -> L23 IllegalArgumentException -> L25
        if (r105 == null) goto L21;
        r105.cancel();     // Catch: Throwable -> L23 IllegalArgumentException -> L25
    L21:
        this.f355886h = null;     // Catch: Throwable -> L23 IllegalArgumentException -> L25
        this.f355885g = false;     // Catch: Throwable -> L23 IllegalArgumentException -> L25
    L22:
        this.f355879a.getApplicationContext().unregisterComponentCallbacks(this.f355890l);
        return;
    L10:
        r102 = null;
    L25:
        e = move-exception;
        FLogger.f375446a.e("BaseBottomDialog", "Dismiss dialog failed: view not attached to window manager", e);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        this.f355879a.getApplicationContext().unregisterComponentCallbacks(this.f355890l);
        throw th;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        Iterator<T> r100 = this.f355883e.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        DialogInterface.OnCancelListener r101 = (DialogInterface.OnCancelListener) r100.next();
        if (r101 == null) goto L4;
        r101.onCancel(this);
        goto L4
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        if (this.f355880b.getShowWithAnimation() == true) goto L5;
        return;
    L5:
        if (this.f355885g == true) goto L36;
        boolean r110 = true;
        TranslateAnimation r100 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 2, 1.0f, 2, 0.0f);
        Long r101 = Long.valueOf(this.f355880b.getShowDuration());
        if (r101.longValue() <= 0) goto L9;
        boolean r102 = true;
    L10:
        Long r103 = null;
        if (Boolean.valueOf(r102).booleanValue() == true) goto L14;
        r101 = null;
    L14:
        long r104 = 450;
        if (r101 == null) goto L17;
        long r105 = r101.longValue();
    L18:
        r100.setDuration(r105);
        r100.setInterpolator(this.f355880b.getInterpolator());
        AlphaAnimation r106 = new AlphaAnimation(0.0f, 1.0f);
        Long r107 = Long.valueOf(this.f355880b.getShowDuration());
        if (r107.longValue() > 0) goto L23;
        r110 = false;
    L23:
        if (Boolean.valueOf(r110).booleanValue() == false) goto L25;
        r103 = r107;
    L25:
        if (r103 == null) goto L27;
        r104 = r103.longValue();
    L27:
        r106.setDuration(r104);
        r106.setInterpolator(this.f355880b.getInterpolator());
        View r108 = findViewById(R.id.dialog_container);
        if (r108 == null) goto L30;
        r108.startAnimation(r100);
    L30:
        View r109 = findViewById(R.id.touch_outside_mask);
        if (r109 == null) goto L33;
        r109.startAnimation(r106);
    L33:
        this.f355885g = true;
        return;
    L17:
        r105 = 450;
        goto L18
    L9:
        r102 = false;
        goto L10
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Iterator<T> r100 = this.f355881c.iterator();
    L9:
        if (r100.hasNext() == false) goto L13;
        DialogInterface.OnShowListener r101 = (DialogInterface.OnShowListener) r100.next();
        if (r101 == null) goto L9;
        r101.onShow(this);
        goto L9
    L13:
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static void I0(AppCompatDialog r100) {
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static View J0(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void N0(int r100) {
        int r101 = RangesKt.coerceAtLeast(Math.max(M0(), r100), 1);
        View r102 = this.f355887i;
        if (r102 == null) goto L6;
        UtilsKt.q(r102, r101);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -1;
        r102.height = -1;
        r102.softInputMode = this.f355880b.getSoftInputMode();
        r101.setAttributes(r102);
        r101.clearFlags(67108864);
        r101.addFlags(Integer.MIN_VALUE);
        r101.setStatusBarColor(0);
        r101.setNavigationBarColor(this.f355880b.getNavigationBarColor());
        r101.setDimAmount(0.0f);
        WindowCompat.setDecorFitsSystemWindows(r101, false);
    L6:
        if (this.f355880b.getCustomHandleSoftInput() == true) goto L12;
        Window r103 = getWindow();
        if (r103 == null) goto L12;
        View r104 = J0(r103);
        if (r104 == null) goto L12;
        Function1 r105 = new ej9.a(this);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Intrinsics.checkNotNullParameter(r105, "config");
        final n r106 = new n();
        r105.invoke(r106);
        ViewCompat.setWindowInsetsAnimationCallback(r104, new WindowInsetsAnimationCallbackOptions$toWindowInsetsAnimationCallback$1(r106));
    L12:
        this.f355879a.getApplicationContext().registerComponentCallbacks(this.f355890l);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        View r101 = this.f355887i;
        if (r101 == null) goto L6;
        int r102 = M0();
        FLogger.f375446a.d("BaseBottomDialog", "onWindowFocusChanged: navigationBarHeight = " + r102);
        UtilsKt.q(r101, r102);
        return;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        this.f355880b.setCancelableOnTouchOutside(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r100) {
        ConstraintLayout.LayoutParams r101 = new ConstraintLayout.LayoutParams(-1, -2);
        View r102 = LayoutInflater.from(this.f355879a).inflate(r100, null);
        Intrinsics.checkNotNull(r102);
        setContentView(r102, r101);
    }

    @Override // android.app.Dialog
    public final void setOnCancelListener(DialogInterface.OnCancelListener r100) {
        ((ArrayList) this.f355883e).add(r100);
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener r100) {
        ((ArrayList) this.f355882d).add(r100);
    }

    @Override // android.app.Dialog
    public final void setOnShowListener(DialogInterface.OnShowListener r100) {
        ((ArrayList) this.f355881c).add(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        setContentView(r100, new ConstraintLayout.LayoutParams(-1, -2));
    }

    public BaseBottomDialog(Context r210, Function1<? super BottomDialogConfig, Unit> r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "config");
        super(r210, R.style.liveTutorBaseBottomDialogStyle);
        this.f355879a = r210;
        BottomDialogConfig r100 = new BottomDialogConfig(false, false, false, 0, 0, 0, 0, null, 0, null, null, false, false, 8191, null);
        r211.invoke(r100);
        this.f355880b = r100;
        this.f355881c = new ArrayList();
        this.f355882d = new ArrayList();
        this.f355883e = new ArrayList();
        this.f355884f = new ArrayList();
        this.f355890l = new b(this);
        supportRequestWindowFeature(1);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        View r102 = null;
        View r103 = LayoutInflater.from(this.f355879a).inflate(R.layout.base_bottom_dialog_fragment_layout, null);
        ViewGroup r104 = (ViewGroup) r103.findViewById(R.id.dialog_container);
        if (r104 == null) goto L18;
        UtilsKt.r(r104);
        UtilsKt.h(r104, new ej9.b(this));
        Iterator<View> r105 = ViewGroupKt.getChildren(r104).iterator();
    L6:
        if (r105.hasNext() == false) goto L11;
        View r106 = r105.next();
        if (Intrinsics.areEqual(r106.getTag(), "dialog_content") == false) goto L6;
        r104.removeView(r106);
        goto L6
    L11:
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L13;
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r101;
    L15:
        if (r107 == null) goto L17;
        r107.topToTop = 0;
        r107.bottomToBottom = 0;
        r107.verticalBias = 1.0f;
        r107.constrainedHeight = true;
        r104.setTag("dialog_content");
    L17:
        r100.setClickable(true);
        r104.addView(r100, r101);
        goto L18
    L13:
        r107 = null;
    L18:
        View r108 = r103.findViewById(R.id.touch_outside_mask);
        if (r108 == null) goto L21;
        r108.setBackgroundColor(this.f355880b.getDimColor());
        UtilsKt.h(r108, new ej9.c(this));
    L21:
        View r109 = r103.findViewById(R.id.navigation_bar_space);
        if (r109 == null) goto L24;
        r109.setBackgroundColor(this.f355880b.getNavigationBarColor());
        UtilsKt.q(r109, M0());
        r102 = r109;
    L24:
        this.f355887i = r102;
        if (this.f355880b.getCustomHandleSoftInput() == true) goto L28;
        ViewCompat.setOnApplyWindowInsetsListener(r103, new ej9.d(this));
    L28:
        if (this.f355880b.getNeedShowNavigationBar() == true) goto L32;
        View r110 = this.f355887i;
        if (r110 == null) goto L32;
        e1.o(r110);
    L32:
        Intrinsics.checkNotNull(r103);
        super.setContentView(r103, new ViewGroup.LayoutParams(-1, -1));
    }
}
