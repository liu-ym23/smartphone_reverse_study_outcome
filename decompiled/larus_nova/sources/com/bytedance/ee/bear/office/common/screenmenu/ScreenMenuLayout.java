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
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 v2\u00020\u0001:\u0003tuvB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010(\u001a\u00020\"H\u0002J\u0012\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0017J&\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0!J<\u00101\u001a\u00020\u001f2\u0012\b\u0002\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010!2\u0012\b\u0002\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010!2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0!J4\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020/2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e0!2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0!J \u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020/J\u0016\u00106\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eJ\u0016\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u000eJ\u0006\u00108\u001a\u00020\"J\u0006\u00109\u001a\u00020\u001fJ&\u0010:\u001a\u00020\"2\b\u00107\u001a\u0004\u0018\u00010\u00192\b\u00105\u001a\u0004\u0018\u00010\u000e2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\b\u0010=\u001a\u00020\"H\u0002J\u0018\u0010>\u001a\u00020\"2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u000eH\u0002J\u0016\u0010@\u001a\u00020\"2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J$\u0010B\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D0C2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u000eH\u0002J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00020G0F2\u0006\u0010H\u001a\u00020\u000eH\u0002J\"\u0010I\u001a\u00020\"2\b\b\u0002\u0010J\u001a\u00020K2\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!J\u0016\u0010M\u001a\u00020\"2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!J\u0006\u0010O\u001a\u00020\"J\u0010\u0010P\u001a\u00020\"2\b\b\u0002\u0010J\u001a\u00020KJ\b\u0010Q\u001a\u00020\"H\u0002J\u0010\u0010R\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0002J\b\u0010S\u001a\u00020\u001fH\u0002J\b\u0010T\u001a\u00020\"H\u0002J\b\u0010U\u001a\u00020\"H\u0002J\u0010\u0010V\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000eH\u0002J\u0018\u0010W\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020\u000eH\u0002J\u0010\u0010Y\u001a\u00020\"2\u0006\u0010X\u001a\u00020\u000eH\u0002J\u0018\u0010Z\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eH\u0002J\u0018\u0010[\u001a\u00020\"2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<H\u0002J8\u0010\\\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020^2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020\n2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\u0002J\\\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0C2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\n2\u0006\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020\u001f2\u0006\u0010i\u001a\u00020\u001fH\u0002J0\u0010j\u001a\u00020\n2\u0006\u0010]\u001a\u00020^2\u0006\u0010k\u001a\u00020\n2\u0006\u0010l\u001a\u00020\n2\u0006\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020\nH\u0002J \u0010m\u001a\u00020\n2\u0006\u0010]\u001a\u00020^2\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\nH\u0002J\u0018\u0010n\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eH\u0002J\u0018\u0010n\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u000eH\u0002J \u0010o\u001a\u00020\n2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010p\u001a\u00020\n2\u0006\u0010q\u001a\u00020\nH\u0002J,\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0C2\u0006\u00105\u001a\u00020\u000e2\u0006\u0010p\u001a\u00020\n2\u0006\u0010q\u001a\u00020\nH\u0002J\u001e\u0010s\u001a\u00020K2\b\u0010-\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000eH\u0002R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006w"}, d2 = {"Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenuLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuLocate", "Lkotlin/Function1;", "Landroid/view/View;", "Lcom/bytedance/ee/bear/office/common/screenmenu/MenuLocateResult;", "getMenuLocate$office_list_productionChinaRelease", "()Lkotlin/jvm/functions/Function1;", "setMenuLocate$office_list_productionChinaRelease", "(Lkotlin/jvm/functions/Function1;)V", "currentAnchorView", "currentMenuView", "rootAnchorView", "rootMenuView", "parentMenu", "Lcom/bytedance/ee/bear/office/common/screenmenu/CommonMenu;", "subMenuView", "enterAnimator", "Landroid/animation/Animator;", "exitAnimator", "isClearingMenuState", "", "dismissListener", "Lkotlin/Function0;", "", "hasDismissedForCurrentShow", "backgroundTouchStarted", "menuShownAt", "", "closeOnBackgroundTouch", "init", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "show", "anchor", "presentation", "Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenuPresentation;", "menuViewHolder", "updateCurrentMenu", "subMenuParentProvider", "subMenuViewHolder", "itemViewHolder", "menuView", "showSubMenu", "parent", "removeSubMenu", "hasSubMenu", "restoreSubMenuAfterCurrentMenuUpdate", "oldPosition", "Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenuLayout$StableMenuPosition;", "doEnterAnimation", "doSubMenuEnterAnimation", "anchorView", "doExitAnimation", "onAnimationEnd", "calculateScalePivot", "Lkotlin/Pair;", "", "getViewCornersOnScreen", "", "Lcom/bytedance/ee/bear/office/common/screenmenu/ScreenMenuLayout$CornerPoint;", "targetView", "gone", "reason", "", "onClosed", "setOnDismissListener", "listener", "resetForInit", "closeAndClear", "markMenuShown", "applyPresentationBackground", "showBlurBackground", "notifyDismissedIfNeeded", "clearMenuState", "addFocusImg", "addFocusItem", "itemView", "applyFocusCorner", "locateMenu", "locateMenuAtStablePosition", "tryLocateSide", "anchorRect", "Landroid/graphics/Rect;", "menuWidth", "menuHeight", "rootWidth", "rootHeight", "resolveBestFullMenuPosition", "minMenuLeft", "maxMenuLeft", "minMenuTop", "maxMenuTop", "preferAnchorTop", "wideAnchor", "overlapArea", "menuLeft", "menuTop", "resolveWideAnchorMenuLeft", "locateSubMenu", "measureMenuHeight", "maxWidth", "maxHeight", "measureMenuSize", "buildLayoutLog", "CornerPoint", "StableMenuPosition", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenMenuLayout extends FrameLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f235173p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super View, g> f235174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f235175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f235176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f235177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f235178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonMenu f235179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f235180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Animator f235181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animator f235182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f235183j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f235184k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f235185l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f235186m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f235187n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f235188o;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f235189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f235190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f235191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f235192d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Float.compare(this.f235189a, r101.f235189a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f235190b, r101.f235190b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f235191c, r101.f235191c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f235192d, r101.f235192d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f235189a) * 31) + Float.floatToIntBits(this.f235190b)) * 31) + Float.floatToIntBits(this.f235191c)) * 31) + Float.floatToIntBits(this.f235192d);
        }

        public final String toString() {
            return "CornerPoint(localX=" + this.f235189a + ", localY=" + this.f235190b + ", xOnScreen=" + this.f235191c + ", yOnScreen=" + this.f235192d + ')';
        }

        public b(float r100, float r101, float r102, float r103) {
            this.f235189a = r100;
            this.f235190b = r101;
            this.f235191c = r102;
            this.f235192d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f235193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f235194b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Float.compare(this.f235193a, r101.f235193a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f235194b, r101.f235194b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.f235193a) * 31) + Float.floatToIntBits(this.f235194b);
        }

        public final String toString() {
            return "StableMenuPosition(x=" + this.f235193a + ", y=" + this.f235194b + ')';
        }

        public c(float r100, float r101) {
            this.f235193a = r100;
            this.f235194b = r101;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235195a = null;

        static {
            int[] r100 = new int[ScreenMenuBackgroundMode.values().length];
            r100[ScreenMenuBackgroundMode.DIM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ScreenMenuBackgroundMode.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ScreenMenuBackgroundMode.BLUR_DIM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f235195a = r100;
        }
    }

    static {
    }

    public final void i() {
        if (this.f235183j == false) goto L5;
        return;
    L5:
        this.f235183j = true;
        StringBuilder r100 = new StringBuilder("clear menu state. visible=");
        if (getVisibility() != 0) goto L8;
        boolean r101 = true;
    L9:
        r100.append(r101);
        r100.append(", childCount=");
        r100.append(getChildCount());
        r100.append(", hasSubMenu=");
        if (this.f235180g == null) goto L12;
        boolean r102 = true;
    L13:
        r100.append(r102);
        tt5.a.h("ScreenMenuLayout", r100.toString());
        Animator r103 = this.f235181h;
        if (r103 == null) goto L16;
        r103.cancel();
    L16:
        Animator r104 = this.f235182i;
        if (r104 == null) goto L19;
        r104.cancel();
    L19:
        this.f235181h = null;
        this.f235182i = null;
        this.f235174a = null;
        removeAllViews();
        setBackgroundColor(436207616);
        this.f235186m = false;
        this.f235188o = true;
        this.f235175b = null;
        this.f235176c = null;
        this.f235177d = null;
        this.f235178e = null;
        CommonMenu r105 = this.f235179f;
        if (r105 == null) goto L22;
        r105.setMaskView(false);
    L22:
        CommonMenu r106 = this.f235179f;
        if (r106 == null) goto L25;
        r106.g(null);
    L25:
        this.f235179f = null;
        this.f235180g = null;
        setAlpha(1.0f);
        setVisibility(8);
        this.f235183j = false;
        return;
    L12:
        r102 = false;
        goto L13
    L8:
        r101 = false;
        goto L9
    }

    public final void q() {
        if (this.f235185l == false) goto L5;
        return;
    L5:
        this.f235185l = true;
        tt5.a.h("ScreenMenuLayout", "notify screen menu dismissed.");
        Function0<Unit> r100 = this.f235184k;
        if (r100 == null) goto L9;
        r100.invoke();
        return;
    }

    public final void r() {
        StringBuilder r100 = new StringBuilder("remove sub menu. hasSubMenu=");
        if (this.f235180g == null) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        r100.append(", parentChildCount=");
        CommonMenu r102 = this.f235179f;
        if (r102 == null) goto L9;
        Integer r103 = Integer.valueOf(r102.getChildCount());
    L10:
        r100.append(r103);
        tt5.a.h("ScreenMenuLayout", r100.toString());
        View r104 = this.f235180g;
        if (r104 == null) goto L13;
        removeView(r104);
    L13:
        this.f235180g = null;
        CommonMenu r105 = this.f235179f;
        if (r105 == null) goto L16;
        r105.setMaskView(false);
    L16:
        CommonMenu r106 = this.f235179f;
        if (r106 == null) goto L19;
        r106.g(null);
    L19:
        CommonMenu r107 = this.f235179f;
        if (r107 == null) goto L22;
        Object r108 = r107.getParent();
    L24:
        if ((r108 instanceof View) == false) goto L26;
        View r109 = (View) r108;
    L27:
        this.f235176c = r109;
        this.f235175b = this.f235179f;
        this.f235179f = null;
        return;
    L26:
        r109 = null;
        goto L27
    L22:
        r108 = null;
        goto L24
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public final Function1<View, g> getMenuLocate$office_list_productionChinaRelease() {
        return this.f235174a;
    }

    public ScreenMenuLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f235185l = true;
        this.f235188o = true;
        setBackgroundColor(436207616);
        setVisibility(8);
        setClickable(true);
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final void b(ScreenMenuLayout r100) {
        Animator r101 = r100.f235182i;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        Animator r102 = r100.f235181h;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f});
        r103.setDuration(100);
        View r104 = r100.f235176c;
        View r105 = r100.f235175b;
        if (r104 == null) goto L17;
        if (r105 == null) goto L17;
        if (r104.getWidth() == 0) goto L17;
        if (r104.getHeight() == 0) goto L17;
        Pair r106 = h(r104, r105);
        r104.setPivotX(((Number) r106.getFirst()).floatValue());
        r104.setPivotY(((Number) r106.getSecond()).floatValue());
        r104.setScaleX(0.0f);
        r104.setScaleY(0.0f);
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r104, View.SCALE_X, new float[]{0.0f, 1.0f});
        r107.setDuration(100);
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r104, View.SCALE_Y, new float[]{0.0f, 1.0f});
        r108.setDuration(100);
        AnimatorSet r109 = new AnimatorSet();
        r109.playTogether(new Animator[]{r103, r107, r108});
        r109.start();
        r100.f235181h = r109;
        return;
    L17:
        tt5.a.h("ScreenMenuLayout", "enter animation fallback alpha only. " + r100.g(r105, r104));
        r100.f235181h = r103;
        r103.start();
    }

    public static List k(View r110) {
        int[] r100 = new int[2];
        r110.getLocationOnScreen(r100);
        float r101 = r100[0];
        float r102 = r100[1];
        float r103 = r110.getWidth() + r101;
        float r104 = r110.getHeight() + r102;
        return CollectionsKt.listOf(new b[]{new b(0.0f, 0.0f, r101, r102), new b(r110.getWidth(), 0.0f, r103, r102), new b(0.0f, r110.getHeight(), r101, r104), new b(r110.getWidth(), r110.getHeight(), r103, r104)});
    }

    public final void d(View r100) {
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        if (r101 <= 0) goto L15;
        if (r102 <= 0) goto L15;
        tt5.a.h("ScreenMenuLayout", "add focus image. " + g(r100, null));
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        Bitmap r104 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L9
        r100.draw(new Canvas(r104));     // Catch: Throwable -> L9
        ImageView r105 = new ImageView(getContext());     // Catch: Throwable -> L9
        r105.setScaleType(ImageView.ScaleType.FIT_XY);     // Catch: Throwable -> L9
        r105.setImageBitmap(r104);     // Catch: Throwable -> L9
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L9
        e(r100, r105);     // Catch: Throwable -> L9
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L19;
        tt5.a.l("ScreenMenuLayout", "add focus image failed. " + g(r100, null), r108);
        return;
    L19:
        return;
    L9:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L15:
        tt5.a.k("ScreenMenuLayout", "skip focus image: invalid size w=" + r101 + ", h=" + r102 + ". " + g(r100, null));
    }

    public final void f(u r100) {
        this.f235188o = r100.f235259c;
        int r101 = d.f235195a[r100.f235257a.ordinal()];
        if (r101 == 1) goto L40;
        boolean r102 = false;
        if (r101 != 2) goto L7;
        setBackgroundColor(0);
        return;
    L7:
        if (r101 != 3) goto L38;
        setBackgroundColor(0);
        int r103 = Build.VERSION.SDK_INT;
        if (r103 >= 31) goto L11;
        tt5.a.h("ScreenMenuLayout", "skip blur background because sdk=" + r103);
    L35:
        if (r102 == true) goto L44;
        setBackgroundColor(436207616);
        return;
    L44:
        return;
    L11:
        Object r104 = getParent();
        if ((r104 instanceof View) == false) goto L14;
        View r105 = (View) r104;
    L15:
        if (r105 == null) goto L35;
        if (r105 != this) goto L19;
    L34:
        tt5.a.h("ScreenMenuLayout", "skip blur background because source invalid. sourceSize=" + r105.getWidth() + Permission.EXECUTE + r105.getHeight());
        goto L35
    L19:
        if (r105.getWidth() <= 0) goto L34;
        if (r105.getHeight() <= 0) goto L34;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L25
        Bitmap r107 = Bitmap.createBitmap(r105.getWidth(), r105.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L25
        r105.draw(new Canvas(r107));     // Catch: Throwable -> L25
        View r108 = new View(getContext());     // Catch: Throwable -> L25
        r108.setBackground(new BitmapDrawable(r108.getResources(), r107));     // Catch: Throwable -> L25
        r108.setForeground(new ColorDrawable(1711276032));     // Catch: Throwable -> L25
        r108.setRenderEffect(RenderEffect.createBlurEffect(48.0f, 48.0f, Shader.TileMode.CLAMP));     // Catch: Throwable -> L25
        addView(r108, 0, new FrameLayout.LayoutParams(-1, -1));     // Catch: Throwable -> L25
        Object r109 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L25
    L27:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L30;
        tt5.a.l("ScreenMenuLayout", "show blur background failed. " + g(this.f235175b, null), r110);
    L30:
        Boolean r111 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r109) == false) goto L33;
        r109 = r111;
    L33:
        r102 = ((Boolean) r109).booleanValue();
    L25:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L14:
        r105 = null;
        goto L15
    L38:
        throw new NoWhenBranchMatchedException();
    L40:
        setBackgroundColor(436207616);
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        boolean r101 = true;
        boolean r102 = !this.f235185l;
        StringBuilder r103 = new StringBuilder("layout closeAndClear called. reason=");
        r103.append(r100);
        r103.append(", shouldNotify=");
        r103.append(r102);
        r103.append(", visible=");
        if (getVisibility() != 0) goto L5;
        boolean r104 = true;
    L6:
        r103.append(r104);
        r103.append(", childCount=");
        r103.append(getChildCount());
        r103.append(", hasSubMenu=");
        if (this.f235180g != null) goto L10;
        r101 = false;
    L10:
        r103.append(r101);
        tt5.a.h("ScreenMenuLayout", r103.toString());
        i();
        if (r102 == false) goto L14;
        q();
        return;
    L14:
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L7:
        if (r101 != null) goto L10;
    L13:
        boolean r102 = false;
        if (r101 != null) goto L17;
    L34:
        if (r101 != null) goto L37;
    L39:
        return true;
    L37:
        if (r101.intValue() != 3) goto L39;
        this.f235186m = false;
        goto L39
    L17:
        if (r101.intValue() != 1) goto L34;
        if (this.f235186m == true) goto L21;
    L23:
        boolean r103 = false;
    L24:
        this.f235186m = false;
        if (r103 == true) goto L27;
    L29:
        StringBuilder r104 = new StringBuilder("ignore background up after menu show. visible=");
        if (getVisibility() != 0) goto L32;
        r102 = true;
    L32:
        r104.append(r102);
        r104.append(", childCount=");
        r104.append(getChildCount());
        r104.append(", closeOnBackgroundTouch=");
        r104.append(this.f235188o);
        tt5.a.h("ScreenMenuLayout", r104.toString());
    L33:
        return true;
    L27:
        if (this.f235188o == false) goto L29;
        l("background_touch", null);
        goto L33
    L21:
        if ((SystemClock.uptimeMillis() - this.f235187n) < 120) goto L23;
        r103 = true;
        goto L24
    L10:
        if (r101.intValue() != 0) goto L13;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f235186m = true;
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public final void setMenuLocate$office_list_productionChinaRelease(Function1<? super View, g> r100) {
        this.f235174a = r100;
    }

    public final void setOnDismissListener(Function0<Unit> r100) {
        this.f235184k = r100;
    }

    public ScreenMenuLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f235185l = true;
        this.f235188o = true;
        setBackgroundColor(436207616);
        setVisibility(8);
        setClickable(true);
    }

    public static Pair h(View r100, View r101) {
        List r102 = k(r100);
        List r103 = k(r101);
        Object r104 = CollectionsKt.first(r102);
        Iterator r105 = r102.iterator();
        float r106 = Float.MAX_VALUE;
    L4:
        if (r105.hasNext() == false) goto L11;
        b r107 = (b) r105.next();
        Iterator r108 = r103.iterator();
    L7:
        if (r108.hasNext() == false) goto L4;
        b r109 = (b) r108.next();
        float r110 = r107.f235191c - r109.f235191c;
        float r111 = r107.f235192d - r109.f235192d;
        float r112 = (r110 * r110) + (r111 * r111);
        if (r112 >= r106) goto L7;
        r104 = r107;
        r106 = r112;
        goto L7
    L11:
        b r113 = (b) r104;
        return TuplesKt.to(Float.valueOf(r113.f235189a), Float.valueOf(r113.f235190b));
    }

    public final void e(View r100, View r101) {
        addView(r101);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        r103.width = r100.getWidth();
        r103.height = r100.getHeight();
        r101.setOutlineProvider(new l(getResources().getDimension(R.dimen.space_radius_m)));
        r101.setClipToOutline(true);
        int[] r104 = new int[2];
        int[] r105 = new int[2];
        r100.getLocationOnScreen(r104);
        getLocationOnScreen(r105);
        r101.setX(r104[0] - r105[0]);
        r101.setY(r104[1] - r105[1]);
    }

    public final String g(View r100, View r101) {
        StringBuilder r102 = new StringBuilder("layoutAttached=");
        r102.append(isAttachedToWindow());
        r102.append(", layoutSize=");
        r102.append(getWidth());
        r102.append(Permission.EXECUTE);
        r102.append(getHeight());
        r102.append(", anchorAttached=");
        Integer r103 = null;
        if (r100 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r100.isAttachedToWindow());
    L6:
        r102.append(r104);
        r102.append(", anchorSize=");
        if (r100 == null) goto L9;
        Integer r105 = Integer.valueOf(r100.getWidth());
    L10:
        r102.append(r105);
        r102.append(Permission.EXECUTE);
        if (r100 == null) goto L13;
        Integer r106 = Integer.valueOf(r100.getHeight());
    L14:
        r102.append(r106);
        r102.append(", menuAttached=");
        if (r101 == null) goto L17;
        Boolean r107 = Boolean.valueOf(r101.isAttachedToWindow());
    L18:
        r102.append(r107);
        r102.append(", menuSize=");
        if (r101 == null) goto L21;
        Integer r108 = Integer.valueOf(r101.getWidth());
    L22:
        r102.append(r108);
        r102.append(Permission.EXECUTE);
        if (r101 == null) goto L25;
        r103 = Integer.valueOf(r101.getHeight());
    L25:
        r102.append(r103);
        r102.append(", visible=");
        if (getVisibility() != 0) goto L28;
        boolean r109 = true;
    L29:
        r102.append(r109);
        r102.append(", childCount=");
        r102.append(getChildCount());
        return r102.toString();
    L28:
        r109 = false;
        goto L29
    L21:
        r108 = null;
        goto L22
    L17:
        r107 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public final void l(final String r110, final Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        StringBuilder r100 = new StringBuilder("layout gone called. reason=");
        r100.append(r110);
        r100.append(", visible=");
        boolean r101 = true;
        if (getVisibility() != 0) goto L5;
        boolean r102 = true;
    L6:
        r100.append(r102);
        r100.append(", childCount=");
        r100.append(getChildCount());
        r100.append(", hasSubMenu=");
        if (this.f235180g == null) goto L9;
        boolean r103 = true;
    L10:
        r100.append(r103);
        r100.append(", hasCallback=");
        if (r111 == null) goto L13;
        boolean r104 = true;
    L14:
        r100.append(r104);
        tt5.a.h("ScreenMenuLayout", r100.toString());
        if (getVisibility() != 0) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == true) goto L27;
        i();
        q();
        StringBuilder r106 = new StringBuilder("layout gone completed immediately. reason=");
        r106.append(r110);
        r106.append(", hasCallback=");
        if (r111 != null) goto L23;
        r101 = false;
    L23:
        r106.append(r101);
        tt5.a.h("ScreenMenuLayout", r106.toString());
        if (r111 == null) goto L44;
        r111.invoke();
        return;
    L44:
        return;
    L27:
        Function0<Unit> r107 = new ScreenMenuLayout$gone$1(this, r110, r111);
        Animator r112 = this.f235181h;
        if (r112 == null) goto L30;
        r112.cancel();
    L30:
        Animator r113 = this.f235182i;
        if (r113 == null) goto L33;
        r113.cancel();
    L33:
        ObjectAnimator r114 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 0.0f});
        r114.setDuration(100);
        View r108 = this.f235176c;
        View r109 = this.f235175b;
        if (r108 == null) goto L42;
        if (r109 == null) goto L42;
        if (r108.getWidth() == 0) goto L42;
        if (r108.getHeight() == 0) goto L42;
        Pair r115 = h(r108, r109);
        r108.setPivotX(((Number) r115.getFirst()).floatValue());
        r108.setPivotY(((Number) r115.getSecond()).floatValue());
        ObjectAnimator r116 = ObjectAnimator.ofFloat(r108, View.SCALE_X, new float[]{r108.getScaleX(), 0.0f});
        r116.setDuration(100);
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r108, View.SCALE_Y, new float[]{r108.getScaleY(), 0.0f});
        r117.setDuration(100);
        AnimatorSet r118 = new AnimatorSet();
        r118.playTogether(new Animator[]{r114, r116, r117});
        r118.addListener(new n(r107));
        r118.start();
        this.f235182i = r118;
        return;
    L42:
        tt5.a.h("ScreenMenuLayout", "exit animation fallback alpha only. " + g(r109, r108));
        r114.addListener(new m(r107));
        this.f235182i = r114;
        r114.start();
        return;
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public final void m(View r210, View r211) {
        addView(r211);
        ViewGroup.LayoutParams r100 = r211.getLayoutParams();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100;
        r101.width = -2;
        r101.height = -2;
        r101.gravity = 0;
        Function1<? super View, g> r102 = this.f235174a;
        if (r102 == null) goto L6;
        g r103 = r102.invoke(r211);
        if (r103 == null) goto L6;
    L7:
        int[] r104 = new int[2];
        int[] r105 = new int[2];
        getLocationOnScreen(r104);
        r210.getLocationOnScreen(r105);
        Integer r106 = Integer.valueOf(getWidth());
        if (r106.intValue() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == true) goto L14;
        r106 = null;
    L14:
        if (r106 == null) goto L16;
        int r108 = r106.intValue();
    L17:
        Integer r109 = Integer.valueOf(getHeight());
        if (r109.intValue() <= 0) goto L20;
        boolean r110 = true;
    L21:
        if (r110 == true) goto L24;
        r109 = null;
    L24:
        if (r109 == null) goto L26;
        int r111 = r109.intValue();
    L27:
        int r112 = k.a(getContext(), 20);
        int r113 = k.a(getContext(), 20);
        int r114 = k.a(getContext(), 8);
        int r115 = t.f235253a;
        int r116 = r108 - (r113 * 2);
        Pair r117 = p(r211, RangesKt.coerceAtLeast(r116, 0), RangesKt.coerceAtLeast(r111 - (r112 * 2), 0));
        int r118 = ((Number) r117.component1()).intValue();
        int r119 = ((Number) r117.component2()).intValue();
        int r120 = r105[0] - r104[0];
        Rect r121 = new Rect(r120, r105[1] - r104[1], r120 + r210.getWidth(), (r105[1] - r104[1]) + r210.getHeight());
        int r122 = Math.max(r113, (r108 - r113) - r118);
        int r123 = r103.f235223b + r112;
        int r124 = Math.max(r123, (r111 - r112) - r119);
        int r125 = r118 / 2;
        int r126 = r121.centerX() - r125;
        Integer r127 = r103.f235224c;
        if (r127 == null) goto L30;
        Integer r128 = Integer.valueOf(RangesKt.coerceIn(r127.intValue() - r104[0], r113, r122));
    L31:
        if (r128 == null) goto L33;
        int r129 = r128.intValue();
    L34:
        int r130 = (r121.top - r114) - r119;
        int r131 = r121.bottom + r114;
        if (r130 < r123) goto L37;
        boolean r132 = true;
    L39:
        if (r131 > r124) goto L41;
        boolean r212 = true;
    L43:
        if (r210.getWidth() < r116) goto L45;
        boolean r133 = true;
    L46:
        if (r133 == false) goto L48;
    L51:
        if (r133 == false) goto L53;
    L56:
        if (r133 == false) goto L58;
    L61:
        if (r133 == false) goto L63;
    L67:
        if (r133 == true) goto L86;
        if (r128 != null) goto L86;
        int r134 = k.a(getContext(), 20);
        int r135 = k.a(getContext(), 20);
        int r136 = k.a(getContext(), 8);
        int r137 = RangesKt.coerceIn(r121.centerY() - (r119 / 2), r135, Math.max(r135, (r111 - r135) - r119));
        int r138 = r121.right + r136;
        int r139 = r111;
        if ((r138 + r118) > (r108 - r134)) goto L72;
        boolean r140 = true;
    L73:
        int r141 = (r121.left - r136) - r118;
        if (r141 < r134) goto L76;
        boolean r142 = true;
    L77:
        if (r140 == false) goto L79;
        r211.setX(r138);
        r211.setY(r137);
    L81:
        boolean r143 = true;
    L83:
        if (r143 == true) goto L102;
    L87:
        boolean r144 = r103.f235222a;
        int r145 = k.a(getContext(), 8);
        int r146 = RangesKt.coerceIn(r121.centerX() - r125, r113, r122);
        int r147 = RangesKt.coerceIn(r121.left, r113, r122);
        if (r133 == false) goto L90;
        int r148 = r147;
    L91:
        int r149 = RangesKt.coerceIn((r121.top - r145) - r119, r123, r124);
        int r150 = RangesKt.coerceIn(r121.bottom + r145, r123, r124);
        int r151 = RangesKt.coerceIn(r121.centerY() - (r119 / 2), r123, r124);
        List r152 = CollectionsKt.createListBuilder();
        if (r144 == false) goto L94;
        r152.add(TuplesKt.to(Integer.valueOf(r148), Integer.valueOf(r149)));
        r152.add(TuplesKt.to(Integer.valueOf(r148), Integer.valueOf(r150)));
    L95:
        r152.add(TuplesKt.to(Integer.valueOf(r147), Integer.valueOf(r149)));
        r152.add(TuplesKt.to(Integer.valueOf(r147), Integer.valueOf(r150)));
        r152.add(TuplesKt.to(Integer.valueOf(r146), Integer.valueOf(r151)));
        Pair r153 = (Pair) CollectionsKt.minWithOrNull(CollectionsKt.build(r152), new p(new o(this, r121, r118, r119), r133, r147));
        if (r153 != null) goto L98;
        r153 = TuplesKt.to(Integer.valueOf(r148), Integer.valueOf(r150));
    L98:
        if (r128 == null) goto L100;
        int r154 = r128.intValue();
    L101:
        r211.setX(r154);
        r211.setY(((Number) r153.getSecond()).intValue());
        goto L102
    L100:
        r154 = ((Number) r153.getFirst()).intValue();
        goto L101
    L94:
        r152.add(TuplesKt.to(Integer.valueOf(r148), Integer.valueOf(r150)));
        r152.add(TuplesKt.to(Integer.valueOf(r148), Integer.valueOf(r149)));
        goto L95
    L90:
        r148 = r146;
    L102:
        StringBuilder r155 = new StringBuilder("located menu. rootSize=");
        r155.append(r108);
        r155.append(Permission.EXECUTE);
        r155.append(r139);
        r155.append(", anchorRect=");
        r155.append(r121);
        r155.append(", menuMeasured=");
        r155.append(r118);
        r155.append(Permission.EXECUTE);
        r155.append(r119);
        r155.append(", menuPos=");
        r155.append(r211.getX());
        r155.append(',');
        r155.append(r211.getY());
        r155.append(", wideAnchor=");
        r155.append(r133);
        r155.append(", customLeft=");
        if (r128 == null) goto L105;
        boolean r156 = true;
    L106:
        r155.append(r156);
        tt5.a.h("ScreenMenuLayout", r155.toString());
        return;
    L105:
        r156 = false;
        goto L106
    L79:
        if (r142 == false) goto L82;
        r211.setX(r141);
        r211.setY(r137);
        goto L81
    L82:
        r143 = false;
        goto L83
    L76:
        r142 = false;
        goto L77
    L72:
        r140 = false;
    L86:
        r139 = r111;
        goto L87
    L63:
        if (r103.f235222a == true) goto L67;
        if (r132 == false) goto L67;
        r211.setX(r129);
        r211.setY(r130);
    L66:
        r139 = r111;
        goto L102
    L58:
        if (r103.f235222a == true) goto L61;
        if (r212 == false) goto L61;
        r211.setX(r129);
        r211.setY(r131);
        goto L66
    L53:
        if (r103.f235222a == false) goto L56;
        if (r212 == false) goto L56;
        r211.setX(r129);
        r211.setY(r131);
        goto L66
    L48:
        if (r103.f235222a == false) goto L51;
        if (r132 == false) goto L51;
        r211.setX(r129);
        r211.setY(r130);
        goto L66
    L45:
        r133 = false;
        goto L46
    L41:
        r212 = false;
        goto L43
    L37:
        r132 = false;
        goto L39
    L33:
        r129 = RangesKt.coerceIn(r126, r113, r122);
        goto L34
    L30:
        r128 = null;
        goto L31
    L26:
        r111 = a(getResources()).heightPixels;
        goto L27
    L20:
        r110 = false;
        goto L21
    L16:
        r108 = a(getResources()).widthPixels;
        goto L17
    L10:
        r107 = false;
    L6:
        r103 = new g(null, 7);
        goto L7
    }

    public final void n(View r110, c r111) {
        addView(r110);
        ViewGroup.LayoutParams r100 = r110.getLayoutParams();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100;
        r101.width = -2;
        r101.height = -2;
        r101.gravity = 0;
        Integer r102 = Integer.valueOf(getWidth());
        boolean r103 = true;
        if (r102.intValue() <= 0) goto L5;
        boolean r104 = true;
    L6:
        Integer r105 = null;
        if (r104 == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        int r106 = r102.intValue();
    L13:
        Integer r107 = Integer.valueOf(getHeight());
        if (r107.intValue() > 0) goto L17;
        r103 = false;
    L17:
        if (r103 == false) goto L19;
        r105 = r107;
    L19:
        if (r105 == null) goto L21;
        int r108 = r105.intValue();
    L22:
        int r109 = k.a(getContext(), 20);
        int r112 = k.a(getContext(), 20);
        int r113 = t.f235253a;
        Pair r114 = p(r110, RangesKt.coerceAtLeast(r106 - (r109 * 2), 0), RangesKt.coerceAtLeast(r108 - (r112 * 2), 0));
        int r115 = ((Number) r114.component1()).intValue();
        int r116 = ((Number) r114.component2()).intValue();
        int r117 = v.f235260a;
        float r118 = r111.f235193a;
        float r119 = r111.f235194b;
        float r120 = r109;
        float r121 = Math.max(r109, (r106 - r109) - r115);
        float r122 = r112;
        float r123 = Math.max(r112, (r108 - r112) - r116);
        float r124 = RangesKt.coerceIn(r118, r120, r121);
        float r125 = RangesKt.coerceIn(r119, r122, r123);
        r110.setX(r124);
        r110.setY(r125);
        tt5.a.h("ScreenMenuLayout", "located menu at stable position. rootSize=" + r106 + Permission.EXECUTE + r108 + ", menuMeasured=" + r115 + Permission.EXECUTE + r116 + ", oldPos=" + r111.f235193a + ',' + r111.f235194b + ", menuPos=" + r110.getX() + ',' + r110.getY());
        return;
    L21:
        r108 = a(getResources()).heightPixels;
        goto L22
    L12:
        r106 = a(getResources()).widthPixels;
        goto L13
    L5:
        r104 = false;
        goto L6
    }

    public final void o(CommonMenu r110, View r111) {
        addView(r111);
        ViewGroup.LayoutParams r100 = r111.getLayoutParams();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100;
        r101.width = -2;
        r101.height = -2;
        r101.gravity = 0;
        int[] r102 = new int[2];
        int[] r103 = new int[2];
        r110.getLocationOnScreen(r102);
        getLocationOnScreen(r103);
        int r104 = r102[1] + r110.getMeasuredHeight();
        int r112 = a(getResources()).heightPixels;
        int r105 = k.a(getContext(), 20);
        int r106 = k.a(getContext(), 20);
        Integer r107 = Integer.valueOf(getWidth());
        if (r107.intValue() <= 0) goto L5;
        boolean r108 = true;
    L6:
        Integer r109 = null;
        if (r108 == true) goto L10;
        r107 = null;
    L10:
        if (r107 == null) goto L12;
        int r113 = r107.intValue();
    L13:
        Integer r114 = Integer.valueOf(getHeight());
        if (r114.intValue() <= 0) goto L16;
        boolean r115 = true;
    L17:
        if (r115 == false) goto L19;
        r109 = r114;
    L19:
        if (r109 == null) goto L21;
        r112 = r109.intValue();
    L21:
        int r116 = t.f235253a;
        Pair r117 = p(r111, RangesKt.coerceAtLeast(r113 - (r106 * 2), 0), RangesKt.coerceAtLeast(r112 - (r105 * 2), 0));
        int r118 = ((Number) r117.component1()).intValue();
        int r119 = ((Number) r117.component2()).intValue();
        int r120 = Math.max(r106, (r113 - r106) - r118);
        int r121 = Math.max(r105, (r112 - r105) - r119);
        int r122 = (r102[0] - r103[0]) - k.a(getContext(), 5);
        int r123 = ((r104 + RangesKt.coerceAtLeast(RangesKt.coerceAtMost((r103[1] + r112) - r104, r119 / 2), 0)) - r119) - r103[1];
        r111.setX(RangesKt.coerceIn(r122, r106, r120));
        r111.setY(RangesKt.coerceIn(r123, r105, r121));
        return;
    L16:
        r115 = false;
        goto L17
    L12:
        r113 = a(getResources()).widthPixels;
        goto L13
    L5:
        r108 = false;
        goto L6
    }

    public ScreenMenuLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f235185l = true;
        this.f235188o = true;
        setBackgroundColor(436207616);
        setVisibility(8);
        setClickable(true);
    }

    public static Pair p(View r100, int r101, int r102) {
        if (r100.getWidth() > 0) goto L5;
    L8:
        r100.measure(View.MeasureSpec.makeMeasureSpec(r101, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(r102, Integer.MIN_VALUE));
        return TuplesKt.to(Integer.valueOf(r100.getMeasuredWidth()), Integer.valueOf(r100.getMeasuredHeight()));
    L5:
        if (r100.getHeight() <= 0) goto L8;
        return TuplesKt.to(Integer.valueOf(r100.getWidth()), Integer.valueOf(r100.getHeight()));
    }

    public static final int c(ScreenMenuLayout r100, Rect r101, int r102, int r103, int r104, int r105) {
        r100.getClass();
        return RangesKt.coerceAtLeast(Math.min(r101.right, r104 + r102) - Math.max(r101.left, r102), 0) * RangesKt.coerceAtLeast(Math.min(r101.bottom, r105 + r103) - Math.max(r101.top, r103), 0);
    }
}
