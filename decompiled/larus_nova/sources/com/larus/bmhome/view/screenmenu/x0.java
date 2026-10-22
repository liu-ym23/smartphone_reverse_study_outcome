package com.larus.bmhome.view.screenmenu;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScreenMenuLayout f317401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<Fragment> f317402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<FragmentActivity> f317403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<FrameLayout> f317404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f317405e;

    public x0() {
    }

    public final void c() {
        ScreenMenuLayout r100 = this.f317401a;
        if (r100 == null) goto L6;
        r100.f(new y0());
        Unit r101 = Unit.INSTANCE;
        return;
    }

    public final FragmentActivity e() {
        WeakReference<Fragment> r100 = this.f317402b;
        ViewParent r101 = null;
        if (r100 == null) goto L46;
        Fragment r102 = r100.get();
        if (r102 == null) goto L46;
        if (r102.isAdded() == false) goto L46;
        if (r102.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L46;
        FragmentActivity r103 = r102.getActivity();
        if (r103 != null) goto L15;
        return null;
    L15:
        FrameLayout r104 = f(r102);
        if (r104 != null) goto L23;
        View r105 = a(r103.getWindow());
        if ((r105 instanceof FrameLayout) == false) goto L20;
        FrameLayout r106 = (FrameLayout) r105;
    L21:
        if (r106 != null) goto L24;
        r106 = (FrameLayout) r103.findViewById(R.id.content);
    L24:
        WeakReference<FragmentActivity> r107 = this.f317403c;
        if (r107 == null) goto L27;
        FragmentActivity r108 = r107.get();
    L28:
        boolean r109 = true;
        if (r108 != r103) goto L43;
        WeakReference<FrameLayout> r110 = this.f317404d;
        if (r110 == null) goto L33;
        FrameLayout r111 = r110.get();
    L34:
        if (r111 != r106) goto L43;
        ScreenMenuLayout r112 = this.f317401a;
        if (r112 == null) goto L38;
        r101 = r112.getParent();
    L38:
        if (r101 != r106) goto L43;
        if (r106.indexOfChild(this.f317401a) != (r106.getChildCount() - 1)) goto L43;
        r109 = false;
        goto L43
    L33:
        r111 = null;
    L43:
        if (r109 == false) goto L45;
        g(r102, r104);
    L45:
        return r103;
    L27:
        r108 = null;
        goto L28
    L20:
        r106 = null;
        goto L21
    L23:
        r106 = r104;
    L46:
        return null;
    }

    public final boolean h() {
        ScreenMenuLayout r100 = this.f317401a;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
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

    public static FrameLayout f(Fragment r100) {
        if ((r100 instanceof DialogFragment) == false) goto L5;
        DialogFragment r101 = (DialogFragment) r100;
    L6:
        if (r101 == null) goto L18;
        Dialog r102 = r101.getDialog();
        if (r102 == null) goto L20;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L13;
        View r104 = a(r103);
    L15:
        if ((r104 instanceof FrameLayout) == true) goto L17;
        return null;
    L17:
        return (FrameLayout) r104;
    L13:
        r104 = null;
        goto L15
    L20:
        return null;
    L18:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    public final void d(final Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f317402b = new WeakReference(r100);
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L5;
        g(r100, f(r100));
    L5:
        r100.getLifecycle().addObserver(new ScreenMenu$create$1$1(this, r100));
    }

    public final void i(Function1<? super View, r0> r100) {
        Intrinsics.checkNotNullParameter(r100, "locateAction");
        ScreenMenuLayout r101 = this.f317401a;
        if (r101 == null) goto L6;
        r101.setMenuLocate$common_ui_mainlandRelease(r100);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.bmhome.view.screenmenu.v0] */
    public final void g(Fragment r100, FrameLayout r101) {
        final FragmentActivity r102 = r100.requireActivity();
        if (this.f317405e == true) goto L5;
        final ?? r103 = new v0(this);
        OnBackPressedCallback r104 = new ScreenMenu$addOnBackPressed$callback$1(r103, r102);
        r102.getOnBackPressedDispatcher().addCallback(r100, r104);
        this.f317405e = true;
    L5:
        this.f317403c = new WeakReference(r102);
        View r105 = r101;
        if (r101 != null) goto L9;
        r105 = a(r102.getWindow());
    L9:
        Intrinsics.checkNotNull(r105);
        if ((r105 instanceof FrameLayout) == true) goto L12;
        View r106 = r102.findViewById(R.id.content);
        Intrinsics.checkNotNull(r106);
        FrameLayout r107 = (FrameLayout) r106;
    L13:
        this.f317404d = new WeakReference(r107);
        ScreenMenuLayout r108 = (ScreenMenuLayout) r107.findViewWithTag(r100);
        if (r108 != null) goto L16;
        ScreenMenuLayout r109 = new ScreenMenuLayout(r102);
        this.f317401a = r109;
        Intrinsics.checkNotNull(r109);
        r109.setTag(r100);
        r107.addView(this.f317401a);
    L17:
        ScreenMenuLayout r110 = this.f317401a;
        Intrinsics.checkNotNull(r110);
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r112 = (FrameLayout.LayoutParams) r111;
        r112.width = -1;
        r112.height = -1;
        ScreenMenuLayout r113 = this.f317401a;
        Intrinsics.checkNotNull(r113);
        r113.getClass();
        r113.f(new y0());
        return;
    L16:
        r107.removeView(r108);
        this.f317401a = r108;
        r107.addView(r108);
        goto L17
    L12:
        r107 = (FrameLayout) r105;
        goto L13
    }

    public static final void b(x0 r100, FragmentActivity r101, Fragment r102) {
        WeakReference<FrameLayout> r103 = r100.f317404d;
        if (r103 == null) goto L6;
        FrameLayout r104 = r103.get();
        if (r104 == null) goto L6;
    L11:
        ScreenMenuLayout r105 = (ScreenMenuLayout) r104.findViewWithTag(r102);
        if (r105 == null) goto L14;
        r105.f(new y0());
    L14:
        if (r105 == null) goto L16;
        r105.setTag(null);
    L16:
        r104.removeView(r105);
        r100.f317404d = null;
        return;
    L6:
        if (r101 == null) goto L8;
        r104 = (FrameLayout) r101.findViewById(R.id.content);
    L9:
        if (r104 != null) goto L11;
        return;
    L8:
        r104 = null;
        goto L9
    }

    public final void j(final View r100, boolean r101, final Bitmap r102, Function0<? extends View> r103) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Intrinsics.checkNotNullParameter(r102, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r103, "menuViewHolder");
        k(r100, r101, new w0(r100, r102), r103);
    }

    public final void k(View r110, boolean r111, Function0<? extends View> r112, Function0<? extends View> r113) {
        Intrinsics.checkNotNullParameter(r110, "anchor");
        Intrinsics.checkNotNullParameter(r112, "itemViewHolder");
        Intrinsics.checkNotNullParameter(r113, "menuViewHolder");
        FragmentActivity r100 = e();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        ScreenMenuLayout r101 = this.f317401a;
        if (r101 == null) goto L75;
        Intrinsics.checkNotNullParameter(r110, "anchor");
        Intrinsics.checkNotNullParameter(r112, "itemViewHolder");
        Intrinsics.checkNotNullParameter(r113, "menuViewHolder");
        r101.removeAllViews();
        if (r111 == true) goto L10;
    L18:
        View r102 = r112.invoke();
        r101.addView(r102);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        r104.width = r110.getWidth();
        r104.height = r110.getHeight();
        int[] r105 = new int[2];
        r110.getLocationOnScreen(r105);
        int[] r114 = new int[2];
        r101.getLocationOnScreen(r114);
        ViewParent r115 = r101.getParent();
        ViewGroup r116 = null;
        if ((r115 instanceof ViewGroup) == false) goto L21;
        ViewGroup r117 = (ViewGroup) r115;
    L22:
        if (r117 == null) goto L24;
        int r118 = r117.getPaddingTop();
    L25:
        r104.gravity = 51;
        r104.leftMargin = r105[0] - r114[0];
        boolean r106 = true;
        r102.setY(r105[1] - r118);
        int r119 = com.larus.utils.m0.f375450a;
        int r120 = com.larus.utils.m0.a(r101.getContext());
        int r121 = r105[1] + r110.getHeight();
        int r122 = ScreenMenuLayout.f317245h;
        if ((r121 + r122) <= r120) goto L28;
        r102.setY(((r120 - r122) - r110.getHeight()) - r118);
    L29:
        View r107 = r113.invoke();
        r101.f317248b = r110;
        r101.f317249c = r107;
        r101.addView(r107);
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r109 = (FrameLayout.LayoutParams) r108;
        r109.width = -2;
        r109.height = -2;
        r109.gravity = 1;
        Function1<? super View, r0> r123 = r101.f317247a;
        if (r123 == null) goto L33;
        r0 r124 = r123.invoke(r107);
        if (r124 == null) goto L33;
    L34:
        int[] r125 = new int[2];
        r110.getLocationOnScreen(r125);
        int r126 = com.larus.utils.m0.a(r101.getContext());
        if (((r125[1] + r110.getHeight()) + r122) <= r126) goto L38;
        r125[1] = (r126 - r122) - r110.getHeight();
    L38:
        if (r107.getHeight() <= 0) goto L40;
        int r127 = r107.getHeight();
    L41:
        ViewParent r128 = r101.getParent();
        if ((r128 instanceof ViewGroup) == false) goto L44;
        r116 = (ViewGroup) r128;
    L44:
        if (r116 == null) goto L46;
        int r129 = r116.getPaddingTop();
    L47:
        int r130 = r125[1];
        int r131 = ScreenMenuLayout.f317246i;
        int r132 = ((r130 - r131) - r127) - r129;
        int r133 = ((r130 + r110.getHeight()) + r131) - r129;
        int r134 = r122 - r129;
        int r135 = Math.max(r134, ((r126 - r122) - r127) - r129);
        if (r132 < (r124.f317380b + r134)) goto L50;
        boolean r136 = true;
    L51:
        if (r133 <= r135) goto L54;
        r106 = false;
    L54:
        boolean r137 = r124.f317379a;
        if (r137 == false) goto L58;
        if (r136 == false) goto L58;
    L66:
        float r138 = r132;
    L71:
        r107.setY(r138);
        r101.setVisibility(0);
        OneShotPreDrawListener.add(r101, new d1(r101, r101));
        return;
    L58:
        if (r137 == false) goto L61;
        if (r106 == false) goto L61;
    L63:
        r138 = r133;
    L61:
        if (r137 == true) goto L64;
        if (r106 == true) goto L63;
    L64:
        if (r137 == true) goto L67;
        if (r136 == true) goto L66;
    L67:
        if (r137 == false) goto L69;
        int r139 = RangesKt.coerceIn(r132, r134, r135);
    L70:
        r138 = r139;
        goto L71
    L69:
        r139 = RangesKt.coerceIn(r133, r134, r135);
        goto L70
    L50:
        r136 = false;
        goto L51
    L46:
        r129 = 0;
        goto L47
    L40:
        r107.measure(View.MeasureSpec.makeMeasureSpec(-2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(-2, Integer.MIN_VALUE));
        r127 = r107.getMeasuredHeight();
    L33:
        r124 = new r0(false, 0);
        goto L34
    L28:
        r102.setY(r105[1] - r118);
        goto L29
    L24:
        r118 = 0;
        goto L25
    L21:
        r117 = null;
        goto L22
    L10:
        if (Build.VERSION.SDK_INT < 31) goto L18;
        View r140 = new View(r101.getContext());     // Catch: Exception -> L16
        Activity r141 = AppHost.f326268a.a().getCurrentActivity();     // Catch: Exception -> L16
        if (r141 == null) goto L14;
        r140.setBackground(new BitmapDrawable(r141.getResources(), ScreenMenuLayout.c(r141)));     // Catch: Exception -> L16
        r140.setForeground(new ColorDrawable(ContextCompat.getColor(r101.getContext(), com.larus.nova.R.color.larus_screen_menu_blur_color)));     // Catch: Exception -> L16
    L14:
        r101.addView(r140, 0, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L16
        r140.setRenderEffect(RenderEffect.createBlurEffect(48.0f, 48.0f, Shader.TileMode.CLAMP));     // Catch: Exception -> L16
    L16:
        e = move-exception;
        FLogger.f375446a.e("FullScreenMenuLayout", "showBlurView exception e=" + e.getMessage());
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        goto L18
    }
}
