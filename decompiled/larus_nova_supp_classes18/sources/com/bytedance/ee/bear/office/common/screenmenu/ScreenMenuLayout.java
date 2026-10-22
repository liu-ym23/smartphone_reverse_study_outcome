package com.bytedance.ee.bear.office.common.screenmenu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 v2\u00020\u0001:\u0003tuvB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010(\u001a\u00020\"H\u0002J\u0012\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0017J&\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0!J<\u00101\u001a\u00020\u001f2\u0012\b\u0002\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010!2\u0012\b\u0002\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010!2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0!J4\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020/2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e0!2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0!J \u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020/J\u0016\u00106\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eJ\u0016\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u000eJ\u0006\u00108\u001a\u00020\"J\u0006\u00109\u001a\u00020\u001fJ&\u0010:\u001a\u00020\"2\b\u00107\u001a\u0004\u0018\u00010\u00192\b\u00105\u001a\u0004\u0018\u00010\u000e2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\b\u0010=\u001a\u00020\"H\u0002J\u0018\u0010>\u001a\u00020\"2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u000eH\u0002J\u0016\u0010@\u001a\u00020\"2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J$\u0010B\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D0C2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u000eH\u0002J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00020G0F2\u0006\u0010H\u001a\u00020\u000eH\u0002J\"\u0010I\u001a\u00020\"2\b\b\u0002\u0010J\u001a\u00020K2\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!J\u0016\u0010M\u001a\u00020\"2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!J\u0006\u0010O\u001a\u00020\"J\u0010\u0010P\u001a\u00020\"2\b\b\u0002\u0010J\u001a\u00020KJ\b\u0010Q\u001a\u00020\"H\u0002J\u0010\u0010R\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0002J\b\u0010S\u001a\u00020\u001fH\u0002J\b\u0010T\u001a\u00020\"H\u0002J\b\u0010U\u001a\u00020\"H\u0002J\u0010\u0010V\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000eH\u0002J\u0018\u0010W\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020\u000eH\u0002J\u0010\u0010Y\u001a\u00020\"2\u0006\u0010X\u001a\u00020\u000eH\u0002J\u0018\u0010Z\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eH\u0002J\u0018\u0010[\u001a\u00020\"2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<H\u0002J8\u0010\\\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020^2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020\n2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\u0002J\\\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0C2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\n2\u0006\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020\u001f2\u0006\u0010i\u001a\u00020\u001fH\u0002J0\u0010j\u001a\u00020\n2\u0006\u0010]\u001a\u00020^2\u0006\u0010k\u001a\u00020\n2\u0006\u0010l\u001a\u00020\n2\u0006\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020\nH\u0002J \u0010m\u001a\u00020\n2\u0006\u0010]\u001a\u00020^2\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\nH\u0002J\u0018\u0010n\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eH\u0002J\u0018\u0010n\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u000eH\u0002J \u0010o\u001a\u00020\n2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010p\u001a\u00020\n2\u0006\u0010q\u001a\u00020\nH\u0002J,\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0C2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010p\u001a\u00020\n2\u0006\u0010q\u001a\u00020\nH\u0002J\u001e\u0010s\u001a\u00020K2\b\u0010-\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000eH\u0002R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006w"}, d2 = {"Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenuLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuLocate", "Lkotlin/Function1;", "Landroid/view/View;", "Lcom/bytedance/ee/bear/office/common/screenmenu/MenuLocateResult;", "getMenuLocate$office_list_productionChinaRelease", "()Lkotlin/jvm/functions/Function1;", "setMenuLocate$office_list_productionChinaRelease", "(Lkotlin/jvm/functions/Function1;)V", "currentAnchorView", "currentMenuView", "rootAnchorView", "rootMenuView", "parentMenu", "Lcom/bytedance/ee/bear/office/common/screenmenu/CommonMenu;", "subMenuView", "enterAnimator", "Landroid/animation/Animator;", "exitAnimator", "isClearingMenuState", "", "dismissListener", "Lkotlin/Function0;", "", "hasDismissedForCurrentShow", "backgroundTouchStarted", "menuShownAt", "", "closeOnBackgroundTouch", "init", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "show", "anchor", "presentation", "Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenuPresentation;", "menuViewHolder", "updateCurrentMenu", "subMenuParentProvider", "subMenuViewHolder", "itemViewHolder", "menuView", "showSubMenu", "parent", "removeSubMenu", "hasSubMenu", "restoreSubMenuAfterCurrentMenuUpdate", "oldPosition", "Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenuLayout$StableMenuPosition;", "doEnterAnimation", "doSubMenuEnterAnimation", "anchorView", "doExitAnimation", "onAnimationEnd", "calculateScalePivot", "Lkotlin/Pair;", "", "getViewCornersOnScreen", "", "Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenuLayout$CornerPoint;", "targetView", "gone", "reason", "", "onClosed", "setOnDismissListener", "listener", "resetForInit", "closeAndClear", "markMenuShown", "applyPresentationBackground", "showBlurBackground", "notifyDismissedIfNeeded", "clearMenuState", "addFocusImg", "addFocusItem", "itemView", "applyFocusCorner", "locateMenu", "locateMenuAtStablePosition", "tryLocateSide", "anchorRect", "Landroid/graphics/Rect;", "menuWidth", "menuHeight", "rootWidth", "rootHeight", "resolveBestFullMenuPosition", "minMenuLeft", "maxMenuLeft", "minMenuTop", "maxMenuTop", "preferAnchorTop", "wideAnchor", "overlapArea", "menuLeft", "menuTop", "resolveWideAnchorMenuLeft", "locateSubMenu", "measureMenuHeight", "maxWidth", "maxHeight", "measureMenuSize", "buildLayoutLog", "CornerPoint", "StableMenuPosition", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenMenuLayout extends FrameLayout {
    public static final /* synthetic */ int p = 0;
    public Function1<? super View, g> a;
    public View b;
    public View c;
    public View d;
    public View e;
    public CommonMenu f;
    public View g;
    public Animator h;
    public Animator i;
    public boolean j;
    public Function0<Unit> k;
    public boolean l;
    public boolean m;
    public long n;
    public boolean o;

    public static final class a {
    }

    public static final class b {
        public final float a;
        public final float b;
        public final float c;
        public final float d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Float.compare(this.a, r6.a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
        }

        public final String toString() {
            return "CornerPoint(localX=" + this.a + ", localY=" + this.b + ", xOnScreen=" + this.c + ", yOnScreen=" + this.d + ')';
        }

        public b(float r1, float r2, float r3, float r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c {
        public final float a;
        public final float b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Float.compare(this.a, r6.a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
        }

        public final String toString() {
            return "StableMenuPosition(x=" + this.a + ", y=" + this.b + ')';
        }

        public c(float r1, float r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ScreenMenuBackgroundMode.values().length];
            r0[ScreenMenuBackgroundMode.DIM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ScreenMenuBackgroundMode.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ScreenMenuBackgroundMode.BLUR_DIM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final void i() {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        StringBuilder r1 = new StringBuilder("clear menu state. visible=");
        if (getVisibility() != 0) goto L8;
        boolean r2 = true;
    L9:
        r1.append(r2);
        r1.append(", childCount=");
        r1.append(getChildCount());
        r1.append(", hasSubMenu=");
        if (this.g == null) goto L12;
        boolean r3 = true;
    L13:
        r1.append(r3);
        tt5.a.h("ScreenMenuLayout", r1.toString());
        Animator r4 = this.h;
        if (r4 == null) goto L16;
        r4.cancel();
    L16:
        Animator r5 = this.i;
        if (r5 == null) goto L19;
        r5.cancel();
    L19:
        this.h = null;
        this.i = null;
        this.a = null;
        removeAllViews();
        setBackgroundColor(436207616);
        this.m = false;
        this.o = true;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        CommonMenu r0 = this.f;
        if (r0 == null) goto L22;
        r0.setMaskView(false);
    L22:
        CommonMenu r6 = this.f;
        if (r6 == null) goto L25;
        r6.g(null);
    L25:
        this.f = null;
        this.g = null;
        setAlpha(1.0f);
        setVisibility(8);
        this.j = false;
        return;
    L12:
        r3 = false;
        goto L13
    L8:
        r2 = false;
        goto L9
    }

    public final void q() {
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        tt5.a.h("ScreenMenuLayout", "notify screen menu dismissed.");
        Function0<Unit> r0 = this.k;
        if (r0 == null) goto L9;
        r0.invoke();
        return;
    }

    public final void r() {
        StringBuilder r0 = new StringBuilder("remove sub menu. hasSubMenu=");
        if (this.g == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(", parentChildCount=");
        LinearLayoutCompat r2 = this.f;
        if (r2 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.getChildCount());
    L10:
        r0.append(r3);
        tt5.a.h("ScreenMenuLayout", r0.toString());
        View r4 = this.g;
        if (r4 == null) goto L13;
        removeView(r4);
    L13:
        this.g = null;
        CommonMenu r5 = this.f;
        if (r5 == null) goto L16;
        r5.setMaskView(false);
    L16:
        CommonMenu r6 = this.f;
        if (r6 == null) goto L19;
        r6.g(null);
    L19:
        LinearLayoutCompat r7 = this.f;
        if (r7 == null) goto L22;
        Object r8 = r7.getParent();
    L24:
        if ((r8 instanceof View) == false) goto L26;
        View r9 = (View) r8;
    L27:
        this.c = r9;
        this.b = this.f;
        this.f = null;
        return;
    L26:
        r9 = null;
        goto L27
    L22:
        r8 = null;
        goto L24
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public final Function1<View, g> getMenuLocate$office_list_productionChinaRelease() {
        return this.a;
    }

    public ScreenMenuLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.l = true;
        this.o = true;
        setBackgroundColor(436207616);
        setVisibility(8);
        setClickable(true);
    }

    public static DisplayMetrics a(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final void b(ScreenMenuLayout r8) {
        Animator r0 = r8.i;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r1 = r8.h;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r8, "alpha", new float[]{0.0f, 1.0f});
        r2.setDuration(100);
        View r4 = r8.c;
        View r5 = r8.b;
        if (r4 == null) goto L17;
        if (r5 == null) goto L17;
        if (r4.getWidth() == 0) goto L17;
        if (r4.getHeight() == 0) goto L17;
        Pair r6 = h(r4, r5);
        r4.setPivotX(((Number) r6.getFirst()).floatValue());
        r4.setPivotY(((Number) r6.getSecond()).floatValue());
        r4.setScaleX(0.0f);
        r4.setScaleY(0.0f);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r4, View.SCALE_X, new float[]{0.0f, 1.0f});
        r7.setDuration(100);
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r4, View.SCALE_Y, new float[]{0.0f, 1.0f});
        r9.setDuration(100);
        AnimatorSet r3 = new AnimatorSet();
        r3.playTogether(new Animator[]{r2, r7, r9});
        r3.start();
        r8.h = r3;
        return;
    L17:
        tt5.a.h("ScreenMenuLayout", "enter animation fallback alpha only. " + r8.g(r5, r4));
        r8.h = r2;
        r2.start();
    }

    public static List k(View r10) {
        int[] r1 = new int[2];
        r10.getLocationOnScreen(r1);
        float r3 = r1[0];
        float r2 = r1[1];
        float r5 = r10.getWidth() + r3;
        float r6 = r10.getHeight() + r2;
        return CollectionsKt.listOf(new b[]{new b(0.0f, 0.0f, r3, r2), new b(r10.getWidth(), 0.0f, r5, r2), new b(0.0f, r10.getHeight(), r3, r6), new b(r10.getWidth(), r10.getHeight(), r5, r6)});
    }

    public final void d(View r7) {
        int r0 = r7.getWidth();
        int r1 = r7.getHeight();
        if (r0 <= 0) goto L15;
        if (r1 <= 0) goto L15;
        tt5.a.h("ScreenMenuLayout", "add focus image. " + g(r7, null));
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        Bitmap r2 = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L9
        r7.draw(new Canvas(r2));     // Catch: Throwable -> L9
        ImageView r3 = new ImageView(getContext());     // Catch: Throwable -> L9
        r3.setScaleType(ImageView.ScaleType.FIT_XY);     // Catch: Throwable -> L9
        r3.setImageBitmap(r2);     // Catch: Throwable -> L9
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L9
        e(r7, r3);     // Catch: Throwable -> L9
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.exceptionOrNull-impl(r6);
        if (r8 == null) goto L19;
        tt5.a.l("ScreenMenuLayout", "add focus image failed. " + g(r7, null), r8);
        return;
    L19:
        return;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        tt5.a.k("ScreenMenuLayout", "skip focus image: invalid size w=" + r0 + ", h=" + r1 + ". " + g(r7, null));
    }

    public final void f(u r8) {
        this.o = r8.c;
        int r9 = d.a[r8.a.ordinal()];
        if (r9 == 1) goto L40;
        boolean r2 = false;
        if (r9 != 2) goto L7;
        setBackgroundColor(0);
        return;
    L7:
        if (r9 != 3) goto L38;
        setBackgroundColor(0);
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 31) goto L11;
        tt5.a.h("ScreenMenuLayout", "skip blur background because sdk=" + r10);
    L35:
        if (r2 == true) goto L44;
        setBackgroundColor(436207616);
        return;
    L44:
        return;
    L11:
        Object r11 = getParent();
        if ((r11 instanceof View) == false) goto L14;
        View r12 = (View) r11;
    L15:
        if (r12 == null) goto L35;
        if (r12 != this) goto L19;
    L34:
        tt5.a.h("ScreenMenuLayout", "skip blur background because source invalid. sourceSize=" + r12.getWidth() + 'x' + r12.getHeight());
        goto L35
    L19:
        if (r12.getWidth() <= 0) goto L34;
        if (r12.getHeight() <= 0) goto L34;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L25
        Bitmap r1 = Bitmap.createBitmap(r12.getWidth(), r12.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L25
        r12.draw(new Canvas(r1));     // Catch: Throwable -> L25
        View r13 = new View(getContext());     // Catch: Throwable -> L25
        r13.setBackground(new BitmapDrawable(r13.getResources(), r1));     // Catch: Throwable -> L25
        r13.setForeground(new ColorDrawable(1711276032));     // Catch: Throwable -> L25
        r13.setRenderEffect(RenderEffect.createBlurEffect(48.0f, 48.0f, Shader.TileMode.CLAMP));     // Catch: Throwable -> L25
        addView(r13, 0, new FrameLayout.LayoutParams(-1, -1));     // Catch: Throwable -> L25
        Object r14 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L25
    L27:
        Throwable r3 = Result.exceptionOrNull-impl(r14);
        if (r3 == null) goto L30;
        tt5.a.l("ScreenMenuLayout", "show blur background failed. " + g(this.b, null), r3);
    L30:
        Boolean r4 = Boolean.FALSE;
        if (Result.isFailure-impl(r14) == false) goto L33;
        r14 = r4;
    L33:
        r2 = ((Boolean) r14).booleanValue();
    L25:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L14:
        r12 = null;
        goto L15
    L38:
        throw new NoWhenBranchMatchedException();
    L40:
        setBackgroundColor(436207616);
    }

    public final void j(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        boolean r1 = true;
        boolean r0 = !this.l;
        StringBuilder r2 = new StringBuilder("layout closeAndClear called. reason=");
        r2.append(r5);
        r2.append(", shouldNotify=");
        r2.append(r0);
        r2.append(", visible=");
        if (getVisibility() != 0) goto L5;
        boolean r6 = true;
    L6:
        r2.append(r6);
        r2.append(", childCount=");
        r2.append(getChildCount());
        r2.append(", hasSubMenu=");
        if (this.g != null) goto L10;
        r1 = false;
    L10:
        r2.append(r1);
        tt5.a.h("ScreenMenuLayout", r2.toString());
        i();
        if (r0 == false) goto L14;
        q();
        return;
    L14:
        return;
    L5:
        r6 = false;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if (r8 == null) goto L5;
        Integer r9 = Integer.valueOf(r8.getActionMasked());
    L7:
        if (r9 != null) goto L10;
    L13:
        boolean r2 = false;
        if (r9 != null) goto L17;
    L34:
        if (r9 != null) goto L37;
    L39:
        return true;
    L37:
        if (r9.intValue() != 3) goto L39;
        this.m = false;
        goto L39
    L17:
        if (r9.intValue() != 1) goto L34;
        if (this.m == true) goto L21;
    L23:
        boolean r10 = false;
    L24:
        this.m = false;
        if (r10 == true) goto L27;
    L29:
        StringBuilder r11 = new StringBuilder("ignore background up after menu show. visible=");
        if (getVisibility() != 0) goto L32;
        r2 = true;
    L32:
        r11.append(r2);
        r11.append(", childCount=");
        r11.append(getChildCount());
        r11.append(", closeOnBackgroundTouch=");
        r11.append(this.o);
        tt5.a.h("ScreenMenuLayout", r11.toString());
    L33:
        return true;
    L27:
        if (this.o == false) goto L29;
        l("background_touch", null);
        goto L33
    L21:
        if ((SystemClock.uptimeMillis() - this.n) < 120) goto L23;
        r10 = true;
        goto L24
    L10:
        if (r9.intValue() != 0) goto L13;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.m = true;
        return true;
    L5:
        r9 = null;
        goto L7
    }

    public final void setMenuLocate$office_list_productionChinaRelease(Function1<? super View, g> r1) {
        this.a = r1;
    }

    public final void setOnDismissListener(Function0<Unit> r1) {
        this.k = r1;
    }

    public ScreenMenuLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.l = true;
        this.o = true;
        setBackgroundColor(436207616);
        setVisibility(8);
        setClickable(true);
    }

    public static Pair h(View r7, View r8) {
        List r9 = k(r7);
        List r10 = k(r8);
        Object r0 = CollectionsKt.first(r9);
        Iterator r11 = r9.iterator();
        float r1 = Float.MAX_VALUE;
    L4:
        if (r11.hasNext() == false) goto L11;
        b r2 = (b) r11.next();
        Iterator r3 = r10.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        b r4 = (b) r3.next();
        float r5 = r2.c - r4.c;
        float r6 = r2.d - r4.d;
        float r12 = (r5 * r5) + (r6 * r6);
        if (r12 >= r1) goto L7;
        r0 = r2;
        r1 = r12;
        goto L7
    L11:
        b r13 = (b) r0;
        return TuplesKt.to(Float.valueOf(r13.a), Float.valueOf(r13.b));
    }

    public final void e(View r5, View r6) {
        addView(r6);
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        r1.width = r5.getWidth();
        r1.height = r5.getHeight();
        r6.setOutlineProvider(new l(getResources().getDimension(2131168383)));
        r6.setClipToOutline(true);
        int[] r2 = new int[2];
        int[] r3 = new int[2];
        r5.getLocationOnScreen(r2);
        getLocationOnScreen(r3);
        r6.setX(r2[0] - r3[0]);
        r6.setY(r2[1] - r3[1]);
    }

    public final String g(View r5, View r6) {
        StringBuilder r0 = new StringBuilder("layoutAttached=");
        r0.append(isAttachedToWindow());
        r0.append(", layoutSize=");
        r0.append(getWidth());
        r0.append('x');
        r0.append(getHeight());
        r0.append(", anchorAttached=");
        Integer r2 = null;
        if (r5 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r5.isAttachedToWindow());
    L6:
        r0.append(r3);
        r0.append(", anchorSize=");
        if (r5 == null) goto L9;
        Integer r4 = Integer.valueOf(r5.getWidth());
    L10:
        r0.append(r4);
        r0.append('x');
        if (r5 == null) goto L13;
        Integer r7 = Integer.valueOf(r5.getHeight());
    L14:
        r0.append(r7);
        r0.append(", menuAttached=");
        if (r6 == null) goto L17;
        Boolean r8 = Boolean.valueOf(r6.isAttachedToWindow());
    L18:
        r0.append(r8);
        r0.append(", menuSize=");
        if (r6 == null) goto L21;
        Integer r9 = Integer.valueOf(r6.getWidth());
    L22:
        r0.append(r9);
        r0.append('x');
        if (r6 == null) goto L25;
        r2 = Integer.valueOf(r6.getHeight());
    L25:
        r0.append(r2);
        r0.append(", visible=");
        if (getVisibility() != 0) goto L28;
        boolean r10 = true;
    L29:
        r0.append(r10);
        r0.append(", childCount=");
        r0.append(getChildCount());
        return r0.toString();
    L28:
        r10 = false;
        goto L29
    L21:
        r9 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void l(final String r12, final Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "reason");
        StringBuilder r0 = new StringBuilder("layout gone called. reason=");
        r0.append(r12);
        r0.append(", visible=");
        boolean r2 = true;
        if (getVisibility() != 0) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(", childCount=");
        r0.append(getChildCount());
        r0.append(", hasSubMenu=");
        if (this.g == null) goto L9;
        boolean r3 = true;
    L10:
        r0.append(r3);
        r0.append(", hasCallback=");
        if (r13 == null) goto L13;
        boolean r4 = true;
    L14:
        r0.append(r4);
        tt5.a.h("ScreenMenuLayout", r0.toString());
        if (getVisibility() != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L27;
        i();
        q();
        StringBuilder r6 = new StringBuilder("layout gone completed immediately. reason=");
        r6.append(r12);
        r6.append(", hasCallback=");
        if (r13 != null) goto L23;
        r2 = false;
    L23:
        r6.append(r2);
        tt5.a.h("ScreenMenuLayout", r6.toString());
        if (r13 == null) goto L44;
        r13.invoke();
        return;
    L44:
        return;
    L27:
        Function0<Unit> r7 = new ScreenMenuLayout$gone$1(this, r12, r13);
        Animator r14 = this.h;
        if (r14 == null) goto L30;
        r14.cancel();
    L30:
        Animator r15 = this.i;
        if (r15 == null) goto L33;
        r15.cancel();
    L33:
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 0.0f});
        r16.setDuration(100);
        View r8 = this.c;
        View r9 = this.b;
        if (r8 == null) goto L42;
        if (r9 == null) goto L42;
        if (r8.getWidth() == 0) goto L42;
        if (r8.getHeight() == 0) goto L42;
        Pair r10 = h(r8, r9);
        r8.setPivotX(((Number) r10.getFirst()).floatValue());
        r8.setPivotY(((Number) r10.getSecond()).floatValue());
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r8, View.SCALE_X, new float[]{r8.getScaleX(), 0.0f});
        r11.setDuration(100);
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r8, View.SCALE_Y, new float[]{r8.getScaleY(), 0.0f});
        r17.setDuration(100);
        AnimatorSet r18 = new AnimatorSet();
        r18.playTogether(new Animator[]{r16, r11, r17});
        r18.addListener(new n(r7));
        r18.start();
        this.i = r18;
        return;
    L42:
        tt5.a.h("ScreenMenuLayout", "exit animation fallback alpha only. " + g(r9, r8));
        r16.addListener(new m(r7));
        this.i = r16;
        r16.start();
        return;
    L17:
        r5 = false;
        goto L18
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public final void m(View r25, View r26) {
        addView(r26);
        ViewGroup.LayoutParams r2 = r26.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        r3.width = -2;
        r3.height = -2;
        r3.gravity = 0;
        Function1<? super View, g> r4 = this.a;
        if (r4 == null) goto L6;
        g r5 = (g) r4.invoke(r26);
        if (r5 == null) goto L6;
    L7:
        int[] r6 = new int[2];
        int[] r7 = new int[2];
        getLocationOnScreen(r6);
        r25.getLocationOnScreen(r7);
        Integer r8 = Integer.valueOf(getWidth());
        if (r8.intValue() <= 0) goto L10;
        boolean r9 = true;
    L11:
        if (r9 == true) goto L14;
        r8 = null;
    L14:
        if (r8 == null) goto L16;
        int r10 = r8.intValue();
    L17:
        Integer r11 = Integer.valueOf(getHeight());
        if (r11.intValue() <= 0) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == true) goto L24;
        r11 = null;
    L24:
        if (r11 == null) goto L26;
        int r13 = r11.intValue();
    L27:
        int r14 = k.a(getContext(), 20);
        int r15 = k.a(getContext(), 20);
        int r16 = k.a(getContext(), 8);
        int r17 = t.a;
        int r18 = r10 - (r15 * 2);
        Pair r19 = p(r26, RangesKt.coerceAtLeast(r18, 0), RangesKt.coerceAtLeast(r13 - (r14 * 2), 0));
        int r110 = ((Number) r19.component1()).intValue();
        int r111 = ((Number) r19.component2()).intValue();
        int r20 = r7[0] - r6[0];
        Rect r112 = new Rect(r20, r7[1] - r6[1], r20 + r25.getWidth(), (r7[1] - r6[1]) + r25.getHeight());
        int r0 = Math.max(r15, (r10 - r15) - r110);
        int r21 = r5.b + r14;
        int r22 = Math.max(r21, (r13 - r14) - r111);
        int r113 = r110 / 2;
        int r23 = r112.centerX() - r113;
        Integer r114 = r5.c;
        if (r114 == null) goto L30;
        Integer r115 = Integer.valueOf(RangesKt.coerceIn(r114.intValue() - r6[0], r15, r0));
    L31:
        if (r115 == null) goto L33;
        int r24 = r115.intValue();
    L34:
        int r27 = (r112.top - r16) - r111;
        int r116 = r112.bottom + r16;
        if (r27 < r21) goto L37;
        boolean r117 = true;
    L39:
        if (r116 > r22) goto L41;
        boolean r28 = true;
    L43:
        if (r25.getWidth() < r18) goto L45;
        boolean r29 = true;
    L46:
        if (r29 == false) goto L48;
    L51:
        if (r29 == false) goto L53;
    L56:
        if (r29 == false) goto L58;
    L61:
        if (r29 == false) goto L63;
    L67:
        if (r29 == true) goto L86;
        if (r115 != null) goto L86;
        int r30 = k.a(getContext(), 20);
        int r31 = k.a(getContext(), 20);
        int r32 = k.a(getContext(), 8);
        int r33 = RangesKt.coerceIn(r112.centerY() - (r111 / 2), r31, Math.max(r31, (r13 - r31) - r111));
        int r118 = r112.right + r32;
        int r119 = r13;
        if ((r118 + r110) > (r10 - r30)) goto L72;
        boolean r34 = true;
    L73:
        int r120 = (r112.left - r32) - r110;
        if (r120 < r30) goto L76;
        boolean r35 = true;
    L77:
        if (r34 == false) goto L79;
        r26.setX(r118);
        r26.setY(r33);
    L81:
        boolean r36 = true;
    L83:
        if (r36 == true) goto L102;
    L87:
        boolean r37 = r5.a;
        int r38 = k.a(getContext(), 8);
        int r39 = RangesKt.coerceIn(r112.centerX() - r113, r15, r0);
        int r1 = RangesKt.coerceIn(r112.left, r15, r0);
        if (r29 == false) goto L90;
        int r40 = r1;
    L91:
        int r41 = RangesKt.coerceIn((r112.top - r38) - r111, r21, r22);
        int r42 = RangesKt.coerceIn(r112.bottom + r38, r21, r22);
        int r43 = RangesKt.coerceIn(r112.centerY() - (r111 / 2), r21, r22);
        List r121 = CollectionsKt.createListBuilder();
        if (r37 == false) goto L94;
        r121.add(TuplesKt.to(Integer.valueOf(r40), Integer.valueOf(r41)));
        r121.add(TuplesKt.to(Integer.valueOf(r40), Integer.valueOf(r42)));
    L95:
        r121.add(TuplesKt.to(Integer.valueOf(r1), Integer.valueOf(r41)));
        r121.add(TuplesKt.to(Integer.valueOf(r1), Integer.valueOf(r42)));
        r121.add(TuplesKt.to(Integer.valueOf(r39), Integer.valueOf(r43)));
        Pair r44 = (Pair) CollectionsKt.minWithOrNull(CollectionsKt.build(r121), new p(new o(this, r112, r110, r111), r29, r1));
        if (r44 != null) goto L98;
        r44 = TuplesKt.to(Integer.valueOf(r40), Integer.valueOf(r42));
    L98:
        if (r115 == null) goto L100;
        int r45 = r115.intValue();
    L101:
        r26.setX(r45);
        r26.setY(((Number) r44.getSecond()).intValue());
        goto L102
    L100:
        r45 = ((Number) r44.getFirst()).intValue();
        goto L101
    L94:
        r121.add(TuplesKt.to(Integer.valueOf(r40), Integer.valueOf(r42)));
        r121.add(TuplesKt.to(Integer.valueOf(r40), Integer.valueOf(r41)));
        goto L95
    L90:
        r40 = r39;
    L102:
        StringBuilder r46 = new StringBuilder("located menu. rootSize=");
        r46.append(r10);
        r46.append('x');
        r46.append(r119);
        r46.append(", anchorRect=");
        r46.append(r112);
        r46.append(", menuMeasured=");
        r46.append(r110);
        r46.append('x');
        r46.append(r111);
        r46.append(", menuPos=");
        r46.append(r26.getX());
        r46.append(',');
        r46.append(r26.getY());
        r46.append(", wideAnchor=");
        r46.append(r29);
        r46.append(", customLeft=");
        if (r115 == null) goto L105;
        boolean r47 = true;
    L106:
        r46.append(r47);
        tt5.a.h("ScreenMenuLayout", r46.toString());
        return;
    L105:
        r47 = false;
        goto L106
    L79:
        if (r35 == false) goto L82;
        r26.setX(r120);
        r26.setY(r33);
        goto L81
    L82:
        r36 = false;
        goto L83
    L76:
        r35 = false;
        goto L77
    L72:
        r34 = false;
    L86:
        r119 = r13;
        goto L87
    L63:
        if (r5.a == true) goto L67;
        if (r117 == false) goto L67;
        r26.setX(r24);
        r26.setY(r27);
    L66:
        r119 = r13;
        goto L102
    L58:
        if (r5.a == true) goto L61;
        if (r28 == false) goto L61;
        r26.setX(r24);
        r26.setY(r116);
        goto L66
    L53:
        if (r5.a == false) goto L56;
        if (r28 == false) goto L56;
        r26.setX(r24);
        r26.setY(r116);
        goto L66
    L48:
        if (r5.a == false) goto L51;
        if (r117 == false) goto L51;
        r26.setX(r24);
        r26.setY(r27);
        goto L66
    L45:
        r29 = false;
        goto L46
    L41:
        r28 = false;
        goto L43
    L37:
        r117 = false;
        goto L39
    L33:
        r24 = RangesKt.coerceIn(r23, r15, r0);
        goto L34
    L30:
        r115 = null;
        goto L31
    L26:
        r13 = a(getResources()).heightPixels;
        goto L27
    L20:
        r12 = false;
        goto L21
    L16:
        r10 = a(getResources()).widthPixels;
        goto L17
    L10:
        r9 = false;
    L6:
        r5 = new g(null, 7);
        goto L7
    }

    public final void n(View r12, c r13) {
        addView(r12);
        ViewGroup.LayoutParams r0 = r12.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        r1.width = -2;
        r1.height = -2;
        r1.gravity = 0;
        Integer r2 = Integer.valueOf(getWidth());
        boolean r3 = true;
        if (r2.intValue() <= 0) goto L5;
        boolean r4 = true;
    L6:
        Integer r5 = null;
        if (r4 == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        int r6 = r2.intValue();
    L13:
        Integer r7 = Integer.valueOf(getHeight());
        if (r7.intValue() > 0) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        r5 = r7;
    L19:
        if (r5 == null) goto L21;
        int r8 = r5.intValue();
    L22:
        int r9 = k.a(getContext(), 20);
        int r10 = k.a(getContext(), 20);
        int r11 = t.a;
        Pair r14 = p(r12, RangesKt.coerceAtLeast(r6 - (r9 * 2), 0), RangesKt.coerceAtLeast(r8 - (r10 * 2), 0));
        int r15 = ((Number) r14.component1()).intValue();
        int r16 = ((Number) r14.component2()).intValue();
        int r17 = v.a;
        float r18 = r13.a;
        float r19 = r13.b;
        float r20 = r9;
        float r21 = Math.max(r9, (r6 - r9) - r15);
        float r22 = r10;
        float r23 = Math.max(r10, (r8 - r10) - r16);
        float r24 = RangesKt.coerceIn(r18, r20, r21);
        float r25 = RangesKt.coerceIn(r19, r22, r23);
        r12.setX(r24);
        r12.setY(r25);
        tt5.a.h("ScreenMenuLayout", "located menu at stable position. rootSize=" + r6 + 'x' + r8 + ", menuMeasured=" + r15 + 'x' + r16 + ", oldPos=" + r13.a + ',' + r13.b + ", menuPos=" + r12.getX() + ',' + r12.getY());
        return;
    L21:
        r8 = a(getResources()).heightPixels;
        goto L22
    L12:
        r6 = a(getResources()).widthPixels;
        goto L13
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(CommonMenu r13, View r14) {
        addView(r14);
        ViewGroup.LayoutParams r0 = r14.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        r1.width = -2;
        r1.height = -2;
        r1.gravity = 0;
        int[] r2 = new int[2];
        int[] r3 = new int[2];
        r13.getLocationOnScreen(r2);
        getLocationOnScreen(r3);
        int r4 = r2[1] + r13.getMeasuredHeight();
        int r15 = a(getResources()).heightPixels;
        int r5 = k.a(getContext(), 20);
        int r6 = k.a(getContext(), 20);
        Integer r7 = Integer.valueOf(getWidth());
        if (r7.intValue() <= 0) goto L5;
        boolean r8 = true;
    L6:
        Integer r9 = null;
        if (r8 == true) goto L10;
        r7 = null;
    L10:
        if (r7 == null) goto L12;
        int r10 = r7.intValue();
    L13:
        Integer r11 = Integer.valueOf(getHeight());
        if (r11.intValue() <= 0) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L19;
        r9 = r11;
    L19:
        if (r9 == null) goto L21;
        r15 = r9.intValue();
    L21:
        int r16 = t.a;
        Pair r17 = p(r14, RangesKt.coerceAtLeast(r10 - (r6 * 2), 0), RangesKt.coerceAtLeast(r15 - (r5 * 2), 0));
        int r18 = ((Number) r17.component1()).intValue();
        int r19 = ((Number) r17.component2()).intValue();
        int r20 = Math.max(r6, (r10 - r6) - r18);
        int r21 = Math.max(r5, (r15 - r5) - r19);
        int r22 = (r2[0] - r3[0]) - k.a(getContext(), 5);
        int r23 = ((r4 + RangesKt.coerceAtLeast(RangesKt.coerceAtMost((r3[1] + r15) - r4, r19 / 2), 0)) - r19) - r3[1];
        r14.setX(RangesKt.coerceIn(r22, r6, r20));
        r14.setY(RangesKt.coerceIn(r23, r5, r21));
        return;
    L16:
        r12 = false;
        goto L17
    L12:
        r10 = a(getResources()).widthPixels;
        goto L13
    L5:
        r8 = false;
        goto L6
    }

    public ScreenMenuLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.l = true;
        this.o = true;
        setBackgroundColor(436207616);
        setVisibility(8);
        setClickable(true);
    }

    public static Pair p(View r1, int r2, int r3) {
        if (r1.getWidth() > 0) goto L5;
    L8:
        r1.measure(View.MeasureSpec.makeMeasureSpec(r2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(r3, Integer.MIN_VALUE));
        return TuplesKt.to(Integer.valueOf(r1.getMeasuredWidth()), Integer.valueOf(r1.getMeasuredHeight()));
    L5:
        if (r1.getHeight() <= 0) goto L8;
        return TuplesKt.to(Integer.valueOf(r1.getWidth()), Integer.valueOf(r1.getHeight()));
    }

    public static final int c(ScreenMenuLayout r0, Rect r1, int r2, int r3, int r4, int r5) {
        r0.getClass();
        return RangesKt.coerceAtLeast(Math.min(r1.right, r4 + r2) - Math.max(r1.left, r2), 0) * RangesKt.coerceAtLeast(Math.min(r1.bottom, r5 + r3) - Math.max(r1.top, r3), 0);
    }
}
