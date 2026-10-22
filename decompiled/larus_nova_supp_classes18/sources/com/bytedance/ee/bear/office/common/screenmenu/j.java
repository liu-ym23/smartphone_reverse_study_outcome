package com.bytedance.ee.bear.office.common.screenmenu;

import android.R;
import android.animation.Animator;
import android.app.Dialog;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public static final /* synthetic */ int h = 0;
    public ScreenMenuLayout a;
    public WeakReference<FragmentActivity> b;
    public WeakReference<FrameLayout> c;
    public WeakReference<LifecycleOwner> d;
    public DefaultLifecycleObserver e;
    public ScreenMenu$addOnBackPressed$1 f;
    public Function0<Unit> g;

    public static final class a {
    }

    static {
    }

    public j() {
    }

    public final void c() {
        WeakReference<LifecycleOwner> r0 = this.d;
        if (r0 == null) goto L11;
        LifecycleOwner r1 = r0.get();
        if (r1 == null) goto L11;
        Lifecycle r2 = r1.getLifecycle();
        if (r2 == null) goto L11;
        DefaultLifecycleObserver r3 = this.e;
        if (r3 == null) goto L11;
        r2.removeObserver(r3);
    L11:
        this.e = null;
        ScreenMenu$addOnBackPressed$1 r4 = this.f;
        if (r4 == null) goto L14;
        r4.remove();
    L14:
        this.f = null;
        this.d = null;
    }

    public final void i() {
        WeakReference<FragmentActivity> r0 = this.b;
        if (r0 == null) goto L9;
        FragmentActivity r1 = r0.get();
        if (r1 == null) goto L10;
        r1.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        return;
    L10:
        return;
    }

    public final boolean m() {
        ScreenMenuLayout r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    }

    public final void o() {
        WeakReference<FragmentActivity> r0 = this.b;
        if (r0 == null) goto L7;
        FragmentActivity r1 = r0.get();
        if (r1 == null) goto L7;
        p(r1);
    L7:
        c();
        this.b = null;
    }

    public final void q() {
        ScreenMenuLayout r0 = this.a;
        if (r0 == null) goto L6;
        r0.r();
        return;
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

    public static FrameLayout k(Fragment r2) {
        if ((r2 instanceof DialogFragment) == false) goto L5;
        DialogFragment r3 = (DialogFragment) r2;
    L6:
        if (r3 == null) goto L18;
        Dialog r4 = r3.getDialog();
        if (r4 == null) goto L20;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L13;
        View r6 = a(r5);
    L15:
        if ((r6 instanceof FrameLayout) == true) goto L17;
        return null;
    L17:
        return (FrameLayout) r6;
    L13:
        r6 = null;
        goto L15
    L20:
        return null;
    L18:
        return null;
    L5:
        r3 = null;
        goto L6
    }

    public final String b(View r4) {
        StringBuilder r0 = new StringBuilder("anchorAttached=");
        r0.append(r4.isAttachedToWindow());
        r0.append(", anchorSize=");
        r0.append(r4.getWidth());
        r0.append('x');
        r0.append(r4.getHeight());
        r0.append(", layoutReady=");
        boolean r1 = true;
        if (this.a == null) goto L5;
        boolean r5 = true;
    L6:
        r0.append(r5);
        r0.append(", menuVisible=");
        ScreenMenuLayout r6 = this.a;
        if (r6 != null) goto L9;
        Boolean r7 = null;
    L14:
        r0.append(r7);
        return r0.toString();
    L9:
        if (r6.getVisibility() == 0) goto L12;
        r1 = false;
    L12:
        r7 = Boolean.valueOf(r1);
        goto L14
    L5:
        r5 = false;
        goto L6
    }

    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        StringBuilder r0 = new StringBuilder("close and clear screen menu. reason=");
        r0.append(r3);
        r0.append(", visible=");
        r0.append(m());
        r0.append(", layoutReady=");
        if (this.a == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        tt5.a.h("ScreenMenu", r0.toString());
        ScreenMenuLayout r2 = this.a;
        if (r2 == null) goto L10;
        r2.j(r3);
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void g(final Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        WeakReference<LifecycleOwner> r0 = this.d;
        if (r0 == null) goto L5;
        LifecycleOwner r1 = r0.get();
    L7:
        if (r1 == r4) goto L9;
        c();
        this.d = new WeakReference(r4);
        tt5.a.h("ScreenMenu", "create screen menu with fragment. fragmentState=" + r4.getLifecycle().getCurrentState() + ", isAdded=" + r4.isAdded());
        if (r4.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L23;
        l(r4.requireActivity(), k(r4));
    L23:
        DefaultLifecycleObserver r2 = new ScreenMenu$create$1(this, r4);
        r4.getLifecycle().addObserver(r2);
        this.e = r2;
        return;
    L9:
        if (r4.isAdded() == true) goto L12;
        tt5.a.h("ScreenMenu", "reuse screen menu fragment owner skipped because fragment not added. fragmentState=" + r4.getLifecycle().getCurrentState());
        return;
    L12:
        StringBuilder r3 = new StringBuilder("reuse screen menu fragment owner. fragmentState=");
        r3.append(r4.getLifecycle().getCurrentState());
        r3.append(", layoutReady=");
        if (this.a == null) goto L15;
        boolean r5 = true;
    L16:
        r3.append(r5);
        tt5.a.h("ScreenMenu", r3.toString());
        if (r4.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L25;
        j(r4.requireActivity(), k(r4));
        return;
    L25:
        return;
    L15:
        r5 = false;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    public final void h(final FragmentActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        WeakReference<LifecycleOwner> r0 = this.d;
        if (r0 == null) goto L5;
        LifecycleOwner r1 = r0.get();
    L7:
        if (r1 != r5) goto L16;
        StringBuilder r2 = new StringBuilder("reuse screen menu activity owner. state=");
        r2.append(r5.getLifecycle().getCurrentState());
        r2.append(", layoutReady=");
        if (this.a == null) goto L11;
        boolean r3 = true;
    L12:
        r2.append(r3);
        tt5.a.h("ScreenMenu", r2.toString());
        if (r5.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L21;
        j(r5, null);
        return;
    L21:
        return;
    L11:
        r3 = false;
        goto L12
    L16:
        c();
        this.d = new WeakReference(r5);
        tt5.a.h("ScreenMenu", "create screen menu with activity. state=" + r5.getLifecycle().getCurrentState() + ", finishing=" + r5.isFinishing() + ", destroyed=" + r5.isDestroyed());
        if (r5.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L19;
        l(r5, null);
    L19:
        DefaultLifecycleObserver r4 = new ScreenMenu$create$3(this, r5);
        r5.getLifecycle().addObserver(r4);
        this.e = r4;
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void n(Function1<? super View, g> r2) {
        Intrinsics.checkNotNullParameter(r2, "locateAction");
        ScreenMenuLayout r0 = this.a;
        if (r0 == null) goto L6;
        r0.setMenuLocate$office_list_productionChinaRelease(r2);
        return;
    }

    public final void p(FragmentActivity r4) {
        WeakReference<FrameLayout> r0 = this.c;
        if (r0 == null) goto L6;
        FrameLayout r1 = r0.get();
        if (r1 == null) goto L6;
    L7:
        ScreenMenuLayout r5 = (ScreenMenuLayout) r1.findViewWithTag("office_screen_menu_layout_tag");
        StringBuilder r2 = new StringBuilder("release screen menu layout. hasLayout=");
        if (r5 == null) goto L10;
        boolean r3 = true;
    L11:
        r2.append(r3);
        r2.append(", rootAttached=");
        r2.append(r1.isAttachedToWindow());
        r2.append(", rootSize=");
        r2.append(r1.getWidth());
        r2.append('x');
        r2.append(r1.getHeight());
        tt5.a.h("ScreenMenu", r2.toString());
        if (r5 == null) goto L14;
        int r6 = ScreenMenuLayout.p;
        r5.j("unknown");
    L14:
        if (r5 == null) goto L16;
        r1.removeView(r5);
    L16:
        this.c = null;
        this.a = null;
        return;
    L10:
        r3 = false;
    L6:
        r1 = (FrameLayout) r4.findViewById(R.id.content);
        goto L7
    }

    public static FrameLayout r(FragmentActivity r1, FrameLayout r2) {
        if (r2 != null) goto L5;
        View r3 = a(r1.getWindow());
    L5:
        Intrinsics.checkNotNull(r3);
        if ((r3 instanceof FrameLayout) == false) goto L9;
        return (FrameLayout) r3;
    L9:
        return (FrameLayout) r1.findViewById(R.id.content);
    }

    public final void d(String r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        StringBuilder r0 = new StringBuilder("close screen menu. reason=");
        r0.append(r3);
        r0.append(", visible=");
        r0.append(m());
        r0.append(", hasCallback=");
        if (r4 == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        tt5.a.h("ScreenMenu", r0.toString());
        ScreenMenuLayout r2 = this.a;
        if (r2 != null) goto L11;
        if (r4 == null) goto L13;
        r4.invoke();
        return;
    L13:
        return;
    L11:
        r2.l(r3, r4);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void j(FragmentActivity r4, FrameLayout r5) {
        FrameLayout r0 = r(r4, r5);
        ScreenMenuLayout r1 = (ScreenMenuLayout) r0.findViewWithTag("office_screen_menu_layout_tag");
        ScreenMenuLayout r2 = this.a;
        if (r2 == null) goto L10;
        if (r2 != r1) goto L10;
        if (r2.isAttachedToWindow() == false) goto L10;
        if (r2.getParent() != r0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L16;
        if (r2 == null) goto L14;
        r2.setOnDismissListener(this.g);
    L14:
        this.c = new WeakReference(r0);
        this.b = new WeakReference(r4);
        return;
    L16:
        l(r4, r5);
        return;
    L10:
        r3 = false;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.activity.OnBackPressedCallback, com.bytedance.ee.bear.office.common.screenmenu.ScreenMenu$addOnBackPressed$1] */
    public final void l(final FragmentActivity r7, FrameLayout r8) {
        ScreenMenu$addOnBackPressed$1 r0 = this.f;
        if (r0 == null) goto L5;
        r0.remove();
    L5:
        ?? r1 = new ScreenMenu$addOnBackPressed$1(this, r7);
        r7.getOnBackPressedDispatcher().addCallback(r7, r1);
        this.f = r1;
        this.b = new WeakReference(r7);
        FrameLayout r2 = r(r7, r8);
        this.c = new WeakReference(r2);
        ScreenMenuLayout r3 = (ScreenMenuLayout) r2.findViewWithTag("office_screen_menu_layout_tag");
        StringBuilder r4 = new StringBuilder("init screen menu layout. hasRootOverride=");
        boolean r5 = false;
        if (r8 == null) goto L8;
        boolean r9 = true;
    L9:
        r4.append(r9);
        r4.append(", rootAttached=");
        r4.append(r2.isAttachedToWindow());
        r4.append(", rootSize=");
        r4.append(r2.getWidth());
        r4.append('x');
        r4.append(r2.getHeight());
        r4.append(", existedLayout=");
        if (r3 == null) goto L12;
        boolean r10 = true;
    L13:
        r4.append(r10);
        tt5.a.h("ScreenMenu", r4.toString());
        if (r3 != null) goto L16;
        r3 = new ScreenMenuLayout(r7);
        r3.setTag("office_screen_menu_layout_tag");
        r2.addView(r3);
    L17:
        this.a = r3;
        ViewGroup.LayoutParams r11 = r3.getLayoutParams();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11;
        r12.width = -1;
        r12.height = -1;
        r3.setOnDismissListener(this.g);
        StringBuilder r13 = new StringBuilder("layout reset for init. visible=");
        if (r3.getVisibility() != 0) goto L20;
        boolean r14 = true;
    L21:
        r13.append(r14);
        r13.append(", childCount=");
        r13.append(r3.getChildCount());
        r13.append(", hasSubMenu=");
        if (r3.g == null) goto L24;
        r5 = true;
    L24:
        r13.append(r5);
        tt5.a.h("ScreenMenuLayout", r13.toString());
        r3.i();
        r3.l = true;
        return;
    L20:
        r14 = false;
        goto L21
    L16:
        r2.removeView(r3);
        r2.addView(r3);
        goto L17
    L12:
        r10 = false;
        goto L13
    L8:
        r9 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(CommonMenu r7, View r8) {
        Intrinsics.checkNotNullParameter(r7, "parentMenu");
        Intrinsics.checkNotNullParameter(r8, "menuView");
        StringBuilder r1 = new StringBuilder("show screen sub menu with parent. layoutReady=");
        if (this.a == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r1.append(", parentChildCount=");
        r1.append(r7.getChildCount());
        tt5.a.h("ScreenMenu", r1.toString());
        final ScreenMenuLayout r3 = this.a;
        if (r3 == null) goto L23;
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "menuView");
        StringBuilder r0 = new StringBuilder("layout show sub menu with parent start. hasSubMenu=");
        if (r3.g == null) goto L11;
        boolean r5 = true;
    L12:
        r0.append(r5);
        r0.append(", parentChildCount=");
        r0.append(r7.getChildCount());
        tt5.a.h("ScreenMenuLayout", r0.toString());
        r3.bringToFront();
        Animator r4 = r3.h;
        if (r4 == null) goto L15;
        r4.cancel();
    L15:
        Animator r6 = r3.i;
        if (r6 == null) goto L19;
        r6.cancel();
    L19:
        if (r3.g == null) goto L21;
        r3.r();
        return;
    L21:
        r3.f = r7;
        r7.g(new ScreenMenuLayout$showSubMenu$2(r3));
        r7.setMaskView(true);
        r3.b = r7;
        r3.c = r8;
        r3.g = r8;
        r3.o(r7, r8);
        r3.setVisibility(0);
        tt5.a.h("ScreenMenuLayout", "layout show sub menu with parent visible. menuChildCount=" + r3.getChildCount() + ", parentChildCount=" + r7.getChildCount());
        OneShotPreDrawListener.add(r3, new s(r3, r3, r8, r7));
        return;
    L11:
        r5 = false;
        goto L12
    L23:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static /* synthetic */ void e(j r0, String r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "unknown";
    L5:
        r0.d(r1, null);
    }

    public final void s(View r10, View r11, u r12) {
        Intrinsics.checkNotNullParameter(r10, "anchor");
        Intrinsics.checkNotNullParameter(r11, "menuView");
        Intrinsics.checkNotNullParameter(r12, "presentation");
        ScreenMenu$addOnBackPressed$1 r3 = this.f;
        boolean r4 = true;
        if (r3 == null) goto L5;
        r3.setEnabled(true);
    L5:
        i();
        StringBuilder r5 = new StringBuilder("show screen menu with view. presentation=");
        r5.append(r12);
        r5.append(", layoutReady=");
        if (this.a != null) goto L9;
        r4 = false;
    L9:
        r5.append(r4);
        r5.append(", ");
        r5.append(b(r10));
        tt5.a.h("ScreenMenu", r5.toString());
        ScreenMenuLayout r6 = this.a;
        if (r6 == null) goto L16;
        Intrinsics.checkNotNullParameter(r10, "anchor");
        Intrinsics.checkNotNullParameter(r11, "menuView");
        Intrinsics.checkNotNullParameter(r12, "presentation");
        tt5.a.h("ScreenMenuLayout", "layout show with view start. presentation=" + r12 + ", " + r6.g(r10, r11));
        r6.l = false;
        r6.m = false;
        r6.n = SystemClock.uptimeMillis();
        r6.bringToFront();
        r6.removeAllViews();
        r6.f(r12);
        if (r12.b == false) goto L14;
        r6.d(r10);
    L14:
        r6.b = r10;
        r6.c = r11;
        r6.d = r10;
        r6.e = r11;
        r6.m(r10, r11);
        r6.setVisibility(0);
        tt5.a.h("ScreenMenuLayout", "layout show with view visible. menuChildCount=" + r6.getChildCount() + ", " + r6.g(r10, r11));
        OneShotPreDrawListener.add(r6, new r(r6, r6));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.view.View, android.view.ViewGroup, com.bytedance.ee.bear.office.common.screenmenu.CommonMenu] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void u(Function0 r16, Function0 r17, Function0 r18) {
        Intrinsics.checkNotNullParameter(r18, "menuViewHolder");
        final ScreenMenuLayout r3 = this.a;
        if (r3 == 0) goto L86;
        Intrinsics.checkNotNullParameter(r18, "menuViewHolder");
        boolean r4 = true;
        if (r3.getVisibility() != 0) goto L7;
        boolean r1 = true;
    L8:
        ViewParent r7 = null;
        if (r1 == true) goto L14;
        StringBuilder r0 = new StringBuilder("skip update current menu because layout invisible. ");
        View r2 = r3.d;
        if (r2 != null) goto L13;
        r2 = r3.b;
    L13:
        r0.append(r3.g(r2, null));
        tt5.a.h("ScreenMenuLayout", r0.toString());
        return;
    L14:
        View r5 = r3.d;
        if (r5 != null) goto L17;
        r5 = r3.b;
    L17:
        if (r5 != null) goto L19;
        tt5.a.h("ScreenMenuLayout", "skip update current menu because anchor missing.");
        return;
    L19:
        View r8 = r3.e;
        if (r8 != null) goto L22;
        r8 = r3.c;
    L22:
        if (r8 != null) goto L24;
        tt5.a.h("ScreenMenuLayout", "skip update current menu because menu view missing. " + r3.g(r5, null));
        return;
    L24:
        if (r16 == null) goto L27;
        if (r17 == null) goto L27;
        boolean r9 = true;
    L28:
        StringBuilder r10 = new StringBuilder("update current menu start. hasSubMenu=");
        if (r3.g == null) goto L31;
        boolean r11 = true;
    L32:
        r10.append(r11);
        r10.append(", restoreSubMenu=");
        r10.append(r9);
        r10.append(", ");
        r10.append(r3.g(r5, r8));
        tt5.a.h("ScreenMenuLayout", r10.toString());
        ScreenMenuLayout.c r12 = new ScreenMenuLayout.c(r8.getX(), r8.getY());
        View r13 = r3.g;
        if (r13 == null) goto L35;
        ScreenMenuLayout.c r14 = new ScreenMenuLayout.c(r13.getX(), r13.getY());
    L36:
        Animator r15 = r3.h;
        if (r15 == null) goto L39;
        r15.cancel();
    L39:
        Animator r19 = r3.i;
        if (r19 == null) goto L42;
        r19.cancel();
    L42:
        View r110 = r3.g;
        if (r110 == null) goto L45;
        r3.removeView(r110);
    L45:
        CommonMenu r111 = r3.f;
        if (r111 == null) goto L48;
        r111.setMaskView(false);
    L48:
        CommonMenu r112 = r3.f;
        if (r112 == null) goto L51;
        r112.g(null);
    L51:
        r3.f = null;
        r3.g = null;
        r3.removeView(r8);
        View r6 = (View) r18.invoke();
        r3.c = r6;
        r3.b = r5;
        r3.e = r6;
        r3.d = r5;
        r3.n(r6, r12);
        r3.setAlpha(1.0f);
        r6.setAlpha(1.0f);
        r3.setAlpha(1.0f);
        r6.setAlpha(1.0f);
        r6.setScaleX(1.0f);
        r6.setScaleY(1.0f);
        if (r9 == false) goto L80;
        if (r16 == null) goto L55;
        ?? r20 = (CommonMenu) r16.invoke();
    L56:
        if (r17 == null) goto L58;
        View r113 = (View) r17.invoke();
    L59:
        if (r20 == 0) goto L69;
        if (r113 == null) goto L69;
        if (r20.getParent() == null) goto L69;
        r3.f = r20;
        r20.g(new ScreenMenuLayout$restoreSubMenuAfterCurrentMenuUpdate$1(r3));
        r20.setMaskView(true);
        r3.b = r20;
        r3.c = r113;
        r3.g = r113;
        if (r14 == null) goto L67;
        r3.n(r113, r14);
    L68:
        r113.setAlpha(1.0f);
        r113.setScaleX(1.0f);
        r113.setScaleY(1.0f);
        tt5.a.h("ScreenMenuLayout", "restore sub menu after current menu update. menuChildCount=" + r3.getChildCount() + ", parentChildCount=" + r20.getChildCount());
        goto L80
    L67:
        r3.o(r20, r113);
    L69:
        StringBuilder r21 = new StringBuilder("skip restore sub menu after current menu update. parentReady=");
        if (r20 == 0) goto L72;
        r7 = r20.getParent();
    L72:
        if (r7 == null) goto L74;
        boolean r22 = true;
    L75:
        r21.append(r22);
        r21.append(", menuViewReady=");
        if (r113 == null) goto L78;
        boolean r23 = true;
    L79:
        r21.append(r23);
        tt5.a.h("ScreenMenuLayout", r21.toString());
        goto L80
    L78:
        r23 = false;
        goto L79
    L74:
        r22 = false;
        goto L75
    L58:
        r113 = null;
        goto L59
    L55:
        r20 = 0;
    L80:
        StringBuilder r24 = new StringBuilder("update current menu end. menuChildCount=");
        r24.append(r3.getChildCount());
        r24.append(", hasSubMenu=");
        if (r3.g != null) goto L84;
        r4 = false;
    L84:
        r24.append(r4);
        r24.append(", ");
        r24.append(r3.g(r5, r6));
        tt5.a.h("ScreenMenuLayout", r24.toString());
        return;
    L35:
        r14 = null;
        goto L36
    L31:
        r11 = false;
    L27:
        r9 = false;
        goto L28
    L7:
        r1 = false;
        goto L8
    }
}
