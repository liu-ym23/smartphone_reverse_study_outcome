package com.obric.oui.popover.v2;

import android.R;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.obric.oui.common.style.q;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends PopupWindow implements OPopoverBase<c> {
    public static final /* synthetic */ int G = 0;
    public final float A;
    public boolean B;
    public boolean C;
    public final boolean D;
    public final Function1<Boolean, com.obric.oui.material.c[]> E;
    public final com.obric.oui.popover.v2.b F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f402365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f402366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f402367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f402368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f402369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f402370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OPopoverLayout f402371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f402372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f402373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AnimatorSet f402374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f402375k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Activity f402376l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f402377m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f402378n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final InterfaceC4677c f402379o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f402380p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f402381q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f402382r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f402383s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f402384t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f402385u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f402386v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f402387w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f402388x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f402389y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f402390z;

    public static final class a extends h<a> {
        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
        }
    }

    public static final class b {
        public static int a(int r100) {
            boolean r101 = false;
            if ((r100 & GravityCompat.START) != 8388611) goto L5;
            boolean r102 = true;
        L7:
            if ((r100 & GravityCompat.END) != 8388613) goto L9;
            r101 = true;
        L9:
            if (r102 == false) goto L11;
            r100 = (r100 & (-8388612)) | 3;
        L11:
            if (r101 == true) goto L13;
            return r100;
        L13:
            return (r100 & (-8388614)) | 5;
        L5:
            r102 = false;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.popover.v2.c$c, reason: collision with other inner class name */
    public interface InterfaceC4677c {
        void bubbleDismiss();
    }

    public interface d {
        void bubbleShow();
    }

    public interface e {
    }

    static {
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void c(int r100, View r101) {
        throw null;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void d() {
        setAnimationStyle(0);
        d r100 = this.f402378n;
        if (r100 == null) goto L7;
        r100.bubbleShow();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void f() {
        ViewGroup r100 = null;
        this.f402374j = null;
        InterfaceC4677c r101 = this.f402379o;
        if (r101 == null) goto L6;
        r101.bubbleDismiss();
    L6:
        OPopoverBase.b.a(this);
        Activity r102 = this.f402376l;
        if (r102 == null) goto L31;
        int r103 = vma.h.f556353a;
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNullParameter(r102, "activity");
        View r104 = r102.getWindow().getDecorView();     // Catch: Exception -> L17
        if (com.larus.home.impl.utils.c.f346345e == false) goto L15;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L17
        Thread r105 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L17
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L15;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");     // Catch: Exception -> L17
    L15:
        r100 = (ViewGroup) r104.findViewById(R.id.content);     // Catch: Exception -> L17
    L19:
        if (r100 == null) goto L31;
        Sequence<View> r106 = ViewGroupKt.getChildren(r100);
        if (r106 == null) goto L31;
        Sequence r107 = SequencesKt.filter(r106, OPopover$clearFakeAnchorViewIfNecessary$1.INSTANCE);
        if (r107 == null) goto L31;
        Iterator r108 = r107.iterator();
    L29:
        if (r108.hasNext() == false) goto L31;
        r100.removeView((View) r108.next());
        wma.b.a("OPopover", "remove fake anchor view");
    L17:
        e = move-exception;
        wma.b.c("ViewUtil", "getActivityContentView, error", e);
    L31:
        OPopoverBase.b.d(this);
        Activity r109 = zma.a.f572881a.getActivity(this.f402375k);
        if (r109 != null) goto L34;
    L41:
        PopupWindowLancet.handleDismissBeforeOrigin(this);     // Catch: Exception -> L40
        super.dismiss();     // Catch: Exception -> L40
        return;
    L48:
        return;
    L34:
        if (r109.isFinishing() == false) goto L36;
        return;
    L36:
        if (isShowing() == true) goto L41;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final int getPopoverBorderColor() {
        return 0;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final int getPopoverBorderWidth() {
        return 0;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final int getPopoverDisplayOrientation() {
        return 0;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final int getPopoverHeight() {
        return 0;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final int getPopoverWidth() {
        return 0;
    }

    public final void n() {
        setAnimationStyle(0);
        this.f402373i = true;
    }

    public final void o() {
        setAnimationStyle(0);
        Intrinsics.checkNotNullParameter(this, "this");
        OPopoverBase.b.a(this);
        Intrinsics.checkNotNullParameter(this, "this");
        this.f402374j = OPopoverBase.b.g(this, true, b.a(this.f402367c), null, new OPopoverBase$playPopoverEnterAnimationInternal$1(this), new OPopoverBase$playPopoverEnterAnimationInternal$2(this));
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void setPopoverXOffset(int r100) {
        throw null;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void setPopoverYOffset(int r100) {
        throw null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class h() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.widget.PopupWindow$PopupDecorView");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.widget.PopupWindow$PopupDecorView");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.widget.PopupWindow$PopupDecorView");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.widget.PopupWindow$PopupDecorView");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.widget.PopupWindow$PopupDecorView");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.widget.PopupWindow$PopupDecorView");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.widget.PopupWindow$PopupDecorView");
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        if (this.f402373i == false) goto L5;
        return;
    L5:
        if (q() == false) goto L7;
        setAnimationStyle(0);
        Intrinsics.checkNotNullParameter(this, "this");
        OPopoverBase.b.a(this);
        n();
        Intrinsics.checkNotNullParameter(this, "this");
        this.f402374j = OPopoverBase.b.g(this, false, b.a(this.f402367c), null, null, new OPopoverBase$playPopoverExitAnimationInternal$1(this));
    L8:
        getContentView().removeCallbacks(this.F);
        return;
    L7:
        f();
        goto L8
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final OPopoverLayout getPopoverBubbleLayout() {
        OPopoverLayout r100 = this.f402371g;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        return null;
    L6:
        return r100;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final ViewGroup getPopoverWindowFrame() {
        ViewGroup r100 = this.f402372h;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        return null;
    L6:
        return r100;
    }

    public final float m() {
        int r100 = this.f402382r;
        if (r100 == 0) goto L19;
        Intrinsics.checkNotNullParameter(this, "this");
        if (r100 != 0) goto L7;
        float r101 = 0.0f;
    L12:
        if (r101 > 0.0f) goto L18;
        wma.a r102 = wma.b.f560377a;
        if (wma.b.e(8) == true) goto L17;
        wma.b.f560377a.a("OPopover", Intrinsics.stringPlus("surfaceInsets elevation resolved to 0, fallback to default. shadowStyleRes=", Integer.valueOf(this.f402382r)));
    L17:
        return 0.0f;
    L18:
        return r101;
    L7:
        Iterator r103 = ((ArrayList) com.obric.oui.common.style.l.g(this.f402375k, r100)).iterator();
        r101 = 0.0f;
    L9:
        if (r103.hasNext() == false) goto L12;
        r101 = r101 + ((q) r103.next()).f399593b;
        goto L9
    L19:
        return 0.0f;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final boolean a() {
        return isShowing();
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final View getContentViewInternal() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getPopoverBubbleLayout();
    }

    public final void k() {
        Intrinsics.checkNotNullParameter(this, "this");
        if (getPopoverPushedToStack() == true) goto L15;
        setPopoverPushedToStack(true);
        OPopoverBase.StackController r100 = OPopoverBase.StackController.f402325a;
        monitor-enter(r100);
        Intrinsics.checkNotNullParameter(this, "current");     // Catch: Throwable -> L10
        r100.a();     // Catch: Throwable -> L10
        List<WeakReference<OPopoverBase<?>>> r101 = OPopoverBase.StackController.f402326b;     // Catch: Throwable -> L10
        CollectionsKt.removeAll(r101, new OPopoverBase$StackController$onShow$1(this));     // Catch: Throwable -> L10
        ArrayList r102 = (ArrayList) r101;     // Catch: Throwable -> L10
        r102.add(new WeakReference(this));     // Catch: Throwable -> L10
        monitor-exit(r100);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void l() {
        Intrinsics.checkNotNullParameter(this, "this");
        OPopoverBase.StackController r100 = OPopoverBase.StackController.f402325a;
        boolean r101 = this.f402389y;
        float r102 = this.f402390z;
        float r103 = this.A;
        monitor-enter(r100);
        Intrinsics.checkNotNullParameter(this, "current");     // Catch: Throwable -> L11
        OPopoverLayout r104 = getPopoverBubbleLayout();     // Catch: Throwable -> L11
        int r105 = OPopoverLayout.f402328p;     // Catch: Throwable -> L11
        ColorProtector.parseColor("#20000000");     // Catch: Throwable -> L11
        r104.f402330b = false;     // Catch: Throwable -> L11
        r104.invalidate();     // Catch: Throwable -> L11
        if (r101 == true) goto L8;
        monitor-exit(r100);
        return;
    L8:
        r100.b(this, r102, r103);     // Catch: Throwable -> L11
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean q() {
        Intrinsics.checkNotNullParameter(this, "this");
        if (getPopoverShowWithAnimation() == true) goto L5;
    L7:
        return false;
    L5:
        if (getPopoverAnimationDurationMillis() <= 0) goto L7;
        return true;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void b() {
        OPopoverBase.b.h(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final float getPopoverAnchorCenterX() {
        return this.f402384t;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final float getPopoverAnchorCenterY() {
        return this.f402385u;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final long getPopoverAnimationDurationMillis() {
        return this.f402366b;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final AnimatorSet getPopoverAnimator() {
        return this.f402374j;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final int getPopoverBgColor() {
        return this.f402368d;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final Context getPopoverContext() {
        return this.f402375k;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final boolean getPopoverEnableBubbleMaterial() {
        return this.D;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final Function1<Boolean, com.obric.oui.material.c[]> getPopoverMaterials() {
        return this.E;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final int getPopoverPopupOriginX() {
        return this.f402387w;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final int getPopoverPopupOriginY() {
        return this.f402388x;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final boolean getPopoverPushedToStack() {
        return this.B;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final boolean getPopoverRemovedFromStack() {
        return this.C;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final boolean getPopoverShowWithAnimation() {
        return this.f402365a;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final boolean getPopoverTransparentBg() {
        return this.f402380p;
    }

    /* JADX WARN: Type inference failed for: r10v13, types: [com.obric.oui.popover.v2.b] */
    public c(a r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        this.f402365a = r110.f402423k;
        this.f402366b = r110.f402417e;
        this.f402369e = true;
        this.f402381q = true;
        this.f402382r = com.larus.nova.R.style.OUIShadow_Oui_Shadow_Regular;
        this.f402383s = true;
        this.f402384t = Float.NaN;
        this.f402385u = Float.NaN;
        this.f402389y = true;
        ColorProtector.parseColor("#08000000");
        this.f402390z = 0.3f;
        this.A = 0.98f;
        this.D = r110.f402426n;
        this.E = r110.f402427o;
        Context r100 = r110.getContext();
        this.f402375k = r100;
        this.f402367c = 0;
        this.f402376l = zma.a.f572881a.getActivity(r100);
        int r101 = r110.f402415c;
        this.f402368d = r101;
        Boolean r102 = Boolean.valueOf(r110.f402416d);
        View r103 = r110.f402418f;
        this.f402377m = r103;
        this.f402379o = r110.f402419g;
        this.f402378n = r110.f402420h;
        boolean r104 = r110.f402421i;
        boolean r105 = r110.f402414b;
        this.f402370f = false;
        boolean r106 = r110.f402422j;
        this.f402380p = r106;
        this.f402381q = r110.f402424l;
        this.f402382r = r110.f402425m;
        this.f402389y = r110.f402428p;
        int r107 = r110.f402429q;
        this.f402390z = r110.f402430r;
        this.A = r110.f402431s;
        setWidth(-2);
        setHeight(-2);
        setFocusable(r105);
        setOutsideTouchable(r104);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        Intrinsics.checkNotNullParameter(this, "this");
        if (r103 == null) goto L40;
        OPopoverLayout r108 = OPopoverBase.b.b(this, r103, 3);
        Intrinsics.checkNotNullParameter(r108, "value");
        this.f402371g = r108;
        getPopoverBubbleLayout().setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        OPopoverLayout r111 = getPopoverBubbleLayout();
        Intrinsics.checkNotNullParameter(r111, "value");
        this.f402372h = r111;
        setContentView(getPopoverWindowFrame());
        OPopoverBase.b.c(this, getContentView(), Integer.MIN_VALUE, Integer.MIN_VALUE);
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == true) goto L7;
    L10:
        OPopoverLayout r112 = null;
        if (r101 == 0) goto L16;
        OPopoverLayout r109 = this.f402371g;
        if (r109 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r109 = null;
    L15:
        r109.setBgColor(r101);
    L16:
        OPopoverLayout r113 = this.f402371g;
        if (r113 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r113 = null;
    L20:
        if (r113.f402341m == true) goto L22;
    L24:
        boolean r114 = false;
    L25:
        if (r114 == true) goto L33;
        OPopoverLayout r115 = this.f402371g;
        if (r115 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r115 = null;
    L29:
        r115.setBorderColor(0);
        OPopoverLayout r116 = this.f402371g;
        if (r116 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r116 = null;
    L32:
        r116.setBorderWidth(0);
    L33:
        OPopoverLayout r117 = this.f402371g;
        if (r117 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L37:
        r112.setTransparentBg(r106);
        setFocusable(true);
        this.F = new com.obric.oui.popover.v2.b(this);
        return;
    L36:
        r112 = r117;
        goto L37
    L22:
        if (r113.f402340l == false) goto L24;
        r114 = true;
        goto L25
    L7:
        if (Intrinsics.areEqual(r102, Boolean.FALSE) == true) goto L10;
        getContentView().setSystemUiVisibility(4102);
        goto L10
    L40:
        throw new IllegalArgumentException("mView must be not null".toString());
    }

    public static View i(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final Pair j(int r110) {
        if (this.f402381q == false) goto L38;
        ViewGroup r100 = null;
        if (this.f402383s == true) goto L16;
        ViewGroup r101 = this.f402372h;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r101 = null;
    L10:
        if ((r101 instanceof SingleChildFrameLayout) == false) goto L16;
        ViewGroup r102 = this.f402372h;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L15:
        r100.setVisibility(4);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        setWidth(pla.d.j(getContentView().getContext()));
        return new Pair(Integer.valueOf(r110), 0);
    L14:
        r100 = r102;
    L16:
        View r103 = LayoutInflater.from(this.f402375k).inflate(com.larus.nova.R.layout.o_layout_popover_shadow_frame, null);
        if (r103 == null) goto L36;
        SingleChildFrameLayout r104 = (SingleChildFrameLayout) r103;
        OPopoverLayout r105 = this.f402371g;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r105 = null;
    L21:
        r104.addView(r105, new FrameLayout.LayoutParams(-2, -2));
        OPopoverLayout r106 = this.f402371g;
        if (r106 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r106 = null;
    L24:
        r104.setShadowCornerRadius(MathKt.roundToInt(r106.getCornerRadius()));
        OPopoverLayout r107 = this.f402371g;
        if (r107 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r107 = null;
    L27:
        int r108 = r107.getArrowHeight();
        OPopoverLayout r109 = this.f402371g;
        if (r109 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r109 = null;
    L30:
        int r111 = r109.getArrowHeight();
        com.obric.oui.common.style.l r112 = r104.f401297b;
        r112.W = r108;
        r112.X = r111;
        SingleChildFrameLayout r113 = new SingleChildFrameLayout(this.f402375k, null);
        r113.setLayoutParams(new ViewGroup.MarginLayoutParams(pla.d.j(getContentView().getContext()), -2));
        r113.addView(r104, new FrameLayout.LayoutParams(-2, -2));
        r113.setClipChildren(false);
        r113.setClipToPadding(false);
        r113.setPadding(0, 0, 0, 0);
        r104.setX(r110);
        r113.setOnTouchListener(new com.obric.oui.popover.v2.a(this));
        this.f402372h = r113;
        r113.setVisibility(4);
        ViewGroup r114 = this.f402372h;
        if (r114 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L34:
        setContentView(r100);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        setWidth(pla.d.j(getContentView().getContext()));
        return new Pair(Integer.valueOf(r110), 0);
    L33:
        r100 = r114;
        goto L34
    L36:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
    L38:
        return new Pair(0, 0);
    }

    public final void p(View r100) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setAlpha(1.0f);
        r100.setScaleX(1.0f);
        r100.setScaleY(1.0f);
        r100.setTranslationY(0.0f);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void setPopoverAnimator(AnimatorSet r100) {
        this.f402374j = r100;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void setPopoverGravity(int r100) {
        this.f402367c = r100;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void setPopoverPushedToStack(boolean r100) {
        this.B = true;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void setPopoverRemovedFromStack(boolean r100) {
        this.C = true;
    }

    public final void r(ViewGroup r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(r100, "view");
        p(r100);
        r100.setVisibility(0);
        if (r101 == null) goto L7;
        r101.invoke();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final void e(View r100, int r101, int r102) {
        OPopoverBase.b.c(this, r100, r101, r102);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public final float g(float r100, int r101, float r102) {
        Intrinsics.checkNotNullParameter(this, "this");
        if (Float.isNaN(r100) == false) goto L6;
        return r102;
    L6:
        return r100 - r101;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r100, int r110, int r111, int r112) {
        int r113 = b.a(r112);
        l();     // Catch: Exception -> L30
        Pair r101 = j(r110);     // Catch: Exception -> L30
        if (this.f402370f == true) goto L6;
        boolean r102 = false;
    L7:
        this.f402386v = r102;     // Catch: Exception -> L30
        if (r100 != null) goto L10;
        Unit r103 = null;
    L15:
        if (r103 != null) goto L17;
        this.f402384t = Float.NaN;     // Catch: Exception -> L30
        this.f402385u = Float.NaN;     // Catch: Exception -> L30
    L17:
        int r114 = r110 - ((Number) r101.getFirst()).intValue();     // Catch: Exception -> L30
        int r115 = r111 - ((Number) r101.getSecond()).intValue();     // Catch: Exception -> L30
        OverlaySource r104 = PopupWindowLancet.resolveSource(r100);     // Catch: Exception -> L30
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r100, r104) == true) goto L21;
        super.showAsDropDown(r100, r114, r115, r113);     // Catch: Exception -> L30
        PopupWindowLancet.trackAfterShow(this, r104, r100);     // Catch: Exception -> L30
    L21:
        k();     // Catch: Exception -> L30
        this.f402383s = false;     // Catch: Exception -> L30
        int[] r105 = new int[2];     // Catch: Exception -> L30
        if (this.f402386v == false) goto L24;
        getContentView().getLocationInWindow(r105);     // Catch: Exception -> L30
    L25:
        this.f402387w = r105[0];     // Catch: Exception -> L30
        this.f402388x = r105[1];     // Catch: Exception -> L30
        this.f402373i = false;     // Catch: Exception -> L30
        if (q() == false) goto L28;
        o();     // Catch: Exception -> L30
        return;
    L28:
        Intrinsics.checkNotNullParameter(this, "this");     // Catch: Exception -> L30
        r(getPopoverWindowFrame(), new OPopoverBase$showPopoverWithoutAnimationInternal$1(this));     // Catch: Exception -> L30
        return;
    L24:
        getContentView().getLocationOnScreen(r105);     // Catch: Exception -> L30
        goto L25
    L10:
        int[] r106 = new int[2];     // Catch: Exception -> L30
        if (r102 == false) goto L13;
        r100.getLocationInWindow(r106);     // Catch: Exception -> L30
    L14:
        this.f402384t = r106[0] + (r100.getWidth() / 2.0f);     // Catch: Exception -> L30
        this.f402385u = r106[1] + (r100.getHeight() / 2.0f);     // Catch: Exception -> L30
        r103 = Unit.INSTANCE;     // Catch: Exception -> L30
        goto L15
    L13:
        r100.getLocationOnScreen(r106);     // Catch: Exception -> L30
        goto L14
    L6:
        r102 = true;
    L30:
        e = move-exception;
        wma.b.c("OPopover", "showAsDropDown, error", e);
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r110, int r111, int r112, int r113) {
        View r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "anchor");
        View r101 = r110.getRootView();
        Activity r102 = zma.a.f572881a.getActivity(r110.getContext());
        if (r101 != null) goto L5;
        boolean r103 = false;
    L39:
        if (this.f402389y == true) goto L41;
        this.f402389y = r103;
    L41:
        int r104 = b.a(r111);
        l();     // Catch: Exception -> L75
        Pair r114 = j(r112);     // Catch: Exception -> L75
        if (this.f402370f == true) goto L45;
        boolean r115 = false;
    L46:
        this.f402386v = r115;     // Catch: Exception -> L75
        int[] r105 = new int[2];     // Catch: Exception -> L75
        if (r115 == false) goto L52;
        r100.getLocationInWindow(r105);     // Catch: Exception -> L75
        if (r103 == false) goto L53;
        if (r102 == null) goto L53;
        int r116 = r105[0];     // Catch: Exception -> L75
        int r117 = r105[1];     // Catch: Exception -> L75
        i(r102.getWindow()).getLocationOnScreen(r105);     // Catch: Exception -> L75
        int r118 = r105[0];     // Catch: Exception -> L75
        int r119 = r105[1];     // Catch: Exception -> L75
        r101.getLocationOnScreen(r105);     // Catch: Exception -> L75
        r105[0] = (r116 + r105[0]) - r118;     // Catch: Exception -> L75
        r105[1] = (r117 + r105[1]) - r119;     // Catch: Exception -> L75
    L53:
        this.f402384t = r105[0] + (r110.getWidth() / 2.0f);     // Catch: Exception -> L75
        this.f402385u = r105[1] + (r110.getHeight() / 2.0f);     // Catch: Exception -> L75
        int r120 = (r112 - ((Number) r114.getFirst()).intValue()) + 0;     // Catch: Exception -> L75
        int r121 = (r113 - ((Number) r114.getSecond()).intValue()) + 0;     // Catch: Exception -> L75
        this.f402387w = r120;     // Catch: Exception -> L75
        this.f402388x = r121;     // Catch: Exception -> L75
        setElevation(m());     // Catch: Exception -> L75
        if (r102 == null) goto L61;
        if (Intrinsics.areEqual(r110.getWindowToken(), i(r102.getWindow()).getWindowToken()) == true) goto L59;
        if (r103 == true) goto L59;
        r100 = r110.getRootView();     // Catch: Exception -> L75
    L59:
        r100 = i(r102.getWindow());     // Catch: Exception -> L75
    L61:
        if (PopupWindowLancet.hasSubWindowToken(r100) == false) goto L64;
    L70:
        k();     // Catch: Exception -> L75
        setElevation(0.0f);     // Catch: Exception -> L75
        getContentView().setElevation(0.0f);     // Catch: Exception -> L75
        this.f402383s = false;     // Catch: Exception -> L75
        this.f402373i = false;     // Catch: Exception -> L75
        if (q() == false) goto L73;
        o();     // Catch: Exception -> L75
        return;
    L73:
        Intrinsics.checkNotNullParameter(this, "this");     // Catch: Exception -> L75
        r(getPopoverWindowFrame(), new OPopoverBase$showPopoverWithoutAnimationInternal$1(this));     // Catch: Exception -> L75
        return;
    L64:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L66;
        super.showAtLocation(r100, r104, r120, r121);     // Catch: Exception -> L75
        goto L70
    L66:
        OverlaySource r122 = PopupWindowLancet.resolveSource(r100);     // Catch: Exception -> L75
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r100, r122, r104, r120, r121) == true) goto L70;
        super.showAtLocation(r100, r104, r120, r121);     // Catch: Exception -> L75
        PopupWindowLancet.trackAfterShow(this, r122, r100);     // Catch: Exception -> L75
        goto L70
    L52:
        r100.getLocationOnScreen(r105);     // Catch: Exception -> L75
        goto L53
    L45:
        r115 = true;
    L75:
        e = move-exception;
        wma.b.c("OPopover", "showAtLocation, error", e);
        return;
    L5:
        String r106 = r101.getClass().getName();
        if (Intrinsics.areEqual(r106, "android.widget.PopupWindow$PopupDecorView") == false) goto L81;
    L36:
        r103 = true;
        goto L39
    L81:
        boolean r107 = h().isInstance(r101);     // Catch: Throwable -> L10
    L11:
        if (r107 == true) goto L36;
        IBinder r108 = r101.getWindowToken();     // Catch: Throwable -> L19
        IBinder r123 = r101.getApplicationWindowToken();     // Catch: Throwable -> L19
        if (r108 == null) goto L20;
        if (r123 == null) goto L20;
        if (Intrinsics.areEqual(r108, r123) == true) goto L20;
        boolean r109 = true;
    L21:
        ViewGroup.LayoutParams r124 = r101.getLayoutParams();
        if ((r124 instanceof WindowManager.LayoutParams) == false) goto L24;
        WindowManager.LayoutParams r125 = (WindowManager.LayoutParams) r124;
    L25:
        if (r125 == null) goto L32;
        int r126 = r125.type;
        if (r126 != 1002) goto L30;
    L33:
        boolean r127 = true;
    L34:
        if (r109 == false) goto L37;
        if (r127 == true) goto L36;
    L37:
        r103 = StringsKt.contains$default(r106, "PopupDecorView", false, 2, null);
        goto L39
    L30:
        if (r126 == 1000) goto L33;
    L32:
        r127 = false;
        goto L34
    L24:
        r125 = null;
    L20:
        r109 = false;
    L10:
        r107 = false;
        goto L11
    }
}
