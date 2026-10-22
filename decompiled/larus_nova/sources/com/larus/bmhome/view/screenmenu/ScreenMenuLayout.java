package com.larus.bmhome.view.screenmenu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 @2\u00020\u0001:\u0002@AB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0017J&\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%J4\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u001b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0%2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%J \u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u000eJ\b\u0010(\u001a\u00020\u001dH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\u0016\u0010.\u001a\u00020\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0%H\u0002J$\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000202012\u0006\u0010'\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000eH\u0002J\u000e\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u001bJ\u0016\u00106\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u00020\u000eH\u0002J\u0006\u0010:\u001a\u00020\u001dJ\u0014\u0010:\u001a\u00020\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0%J\b\u0010;\u001a\u00020\u001dH\u0002J\u0010\u0010<\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u0018\u0010=\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u000eH\u0003J\u0018\u0010?\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000eH\u0002R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/bmhome/view/screenmenu/ScreenMenuLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuLocate", "Lkotlin/Function1;", "Landroid/view/View;", "Lcom/larus/bmhome/view/screenmenu/MenuLocateResult;", "getMenuLocate$common_ui_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setMenuLocate$common_ui_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "currentAnchorView", "currentMenuView", "menuMaskView", "enterAnimator", "Landroid/animation/Animator;", "exitAnimator", "isClearingMenuState", "", "init", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "show", "anchor", "isBgBlur", "menuViewHolder", "Lkotlin/Function0;", "itemViewHolder", "menuView", "showBlurView", "captureActivity", "Landroid/graphics/Bitmap;", "activity", "Landroid/app/Activity;", "doEnterAnimation", "doExitAnimation", "onAnimationEnd", "calculateScalePivot", "Lkotlin/Pair;", "", "anchorView", "setMenuMask", "visible", "getViewCornersOnScreen", "", "Lcom/larus/bmhome/view/screenmenu/ScreenMenuLayout$CornerPoint;", "targetView", "gone", "clearMenuState", "addFocusImg", "addFocusItem", "itemView", "locateMenu", "Companion", "CornerPoint", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenMenuLayout extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f317245h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f317246i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super View, r0> f317247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f317248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f317249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f317250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animator f317251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f317252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f317253g;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f317254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f317255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f317256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f317257d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Float.compare(this.f317254a, r101.f317254a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f317255b, r101.f317255b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f317256c, r101.f317256c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f317257d, r101.f317257d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f317254a) * 31) + Float.floatToIntBits(this.f317255b)) * 31) + Float.floatToIntBits(this.f317256c)) * 31) + Float.floatToIntBits(this.f317257d);
        }

        public final String toString() {
            return "CornerPoint(localX=" + this.f317254a + ", localY=" + this.f317255b + ", xOnScreen=" + this.f317256c + ", yOnScreen=" + this.f317257d + ')';
        }

        public b(float r100, float r101, float r102, float r103) {
            this.f317254a = r100;
            this.f317255b = r101;
            this.f317256c = r102;
            this.f317257d = r103;
        }
    }

    static {
        f317245h = i5.A();
        f317246i = i5.r0();
    }

    public final void d() {
        if (this.f317253g == false) goto L5;
        return;
    L5:
        this.f317253g = true;
        Animator r100 = this.f317251e;
        Animator r101 = this.f317252f;
        this.f317251e = null;
        this.f317252f = null;
        if (r100 == null) goto L8;
        r100.removeAllListeners();
    L8:
        if (r101 == null) goto L10;
        r101.removeAllListeners();
    L10:
        if (r100 == null) goto L12;
        r100.cancel();
    L12:
        if (r101 == null) goto L14;
        r101.cancel();
    L14:
        removeAllViews();
        this.f317250d = null;
        this.f317248b = null;
        this.f317249c = null;
        setAlpha(1.0f);
        setVisibility(8);
        this.f317253g = false;
    }

    public final Function1<View, r0> getMenuLocate$common_ui_mainlandRelease() {
        return this.f317247a;
    }

    public ScreenMenuLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        g(r100);
    }

    public static final void a(ScreenMenuLayout r100) {
        Animator r101 = r100.f317252f;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        Animator r102 = r100.f317251e;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f});
        r103.setDuration(100);
        View r104 = r100.f317249c;
        View r105 = r100.f317248b;
        if (r104 == null) goto L17;
        if (r105 == null) goto L17;
        if (r104.getWidth() == 0) goto L17;
        if (r104.getHeight() == 0) goto L17;
        Pair r106 = b(r104, r105);
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
        r100.f317251e = r109;
        return;
    L17:
        r103.start();
    }

    public static Bitmap c(Activity r100) {
        View r101 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        View r103 = r101.getRootView();
        r103.setDrawingCacheEnabled(true);
        Bitmap r104 = Bitmap.createBitmap(r103.getDrawingCache());
        r103.setDrawingCacheEnabled(false);
        return r104;
    }

    public static List e(View r110) {
        int[] r100 = new int[2];
        r110.getLocationOnScreen(r100);
        float r101 = r100[0];
        float r102 = r100[1];
        float r103 = r110.getWidth() + r101;
        float r104 = r110.getHeight() + r102;
        return CollectionsKt.listOf(new b[]{new b(0.0f, 0.0f, r101, r102), new b(r110.getWidth(), 0.0f, r103, r102), new b(0.0f, r110.getHeight(), r101, r104), new b(r110.getWidth(), r110.getHeight(), r103, r104)});
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.bmhome.view.screenmenu.a1] */
    public final void f(final Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "onAnimationEnd");
        if (getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L9;
        d();
        r110.invoke();
        return;
    L9:
        ?? r101 = new a1(this, r110);
        Animator r111 = this.f317251e;
        if (r111 == null) goto L12;
        r111.cancel();
    L12:
        Animator r112 = this.f317252f;
        if (r112 == null) goto L15;
        r112.cancel();
    L15:
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 0.0f});
        r102.setDuration(100);
        View r103 = this.f317249c;
        View r104 = this.f317248b;
        if (r103 == null) goto L24;
        if (r104 == null) goto L24;
        if (r103.getWidth() == 0) goto L24;
        if (r103.getHeight() == 0) goto L24;
        Pair r105 = b(r103, r104);
        r103.setPivotX(((Number) r105.getFirst()).floatValue());
        r103.setPivotY(((Number) r105.getSecond()).floatValue());
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r103, View.SCALE_X, new float[]{r103.getScaleX(), 0.0f});
        r106.setDuration(100);
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r103, View.SCALE_Y, new float[]{r103.getScaleY(), 0.0f});
        r107.setDuration(100);
        AnimatorSet r108 = new AnimatorSet();
        r108.playTogether(new Animator[]{r102, r106, r107});
        r108.addListener(new c1(r101));
        r108.start();
        this.f317252f = r108;
        return;
    L24:
        r102.addListener(new b1(r101));
        this.f317252f = r102;
        r102.start();
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void g(Context r100) {
        setBackgroundColor(ContextCompat.getColor(r100, R.color.larus_static_black_transparent_1));
        setVisibility(8);
        setOnClickListener(new z0(this));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L5:
        if (r101 == null) goto L11;
        if (r101.intValue() != 0) goto L11;
        getParent().requestDisallowInterceptTouchEvent(true);
    L11:
        return super.onTouchEvent(r100);
    L4:
        r101 = null;
        goto L5
    }

    public final void setMenuLocate$common_ui_mainlandRelease(Function1<? super View, r0> r100) {
        this.f317247a = r100;
    }

    public final void setMenuMask(boolean r100) {
        View r101 = this.f317249c;
        if (r100 == false) goto L18;
        if (r101 == null) goto L18;
        if (r101.getWidth() <= 0) goto L18;
        if (r101.getHeight() <= 0) goto L18;
        View r102 = this.f317250d;
        if (r102 != null) goto L13;
        r102 = new View(getContext());
        r102.setBackgroundResource(v19.c.b(R.attr.larus_fg_common_menu_mask, r102.getContext(), R.drawable.larus_fg_common_menu_mask));
        r102.setAlpha(0.5f);
        r102.setClickable(true);
        this.f317250d = r102;
    L13:
        int[] r103 = new int[2];
        r101.getLocationOnScreen(r103);
        int[] r104 = new int[2];
        getLocationOnScreen(r104);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(r101.getWidth(), r101.getHeight());
        r105.gravity = 51;
        r105.leftMargin = r103[0] - r104[0];
        r105.topMargin = r103[1] - r104[1];
        r102.setLayoutParams(r105);
        if (r102.getParent() != null) goto L16;
        addView(r102);
    L16:
        r102.bringToFront();
        r102.setVisibility(0);
        return;
    L18:
        View r106 = this.f317250d;
        if (r106 == null) goto L21;
        removeView(r106);
    L21:
        this.f317250d = null;
    }

    public ScreenMenuLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        g(r100);
    }

    public static Pair b(View r100, View r101) {
        List r102 = e(r100);
        List r103 = e(r101);
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
        float r110 = r107.f317256c - r109.f317256c;
        float r111 = r107.f317257d - r109.f317257d;
        float r112 = (r110 * r110) + (r111 * r111);
        if (r112 >= r106) goto L7;
        r104 = r107;
        r106 = r112;
        goto L7
    L11:
        b r113 = (b) r104;
        return TuplesKt.to(Float.valueOf(r113.f317254a), Float.valueOf(r113.f317255b));
    }

    public ScreenMenuLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        g(r100);
    }
}
