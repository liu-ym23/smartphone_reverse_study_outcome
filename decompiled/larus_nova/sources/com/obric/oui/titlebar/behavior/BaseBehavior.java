package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.larus.nova.R;
import com.obric.oui.titlebar.OUnitedTitleBar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes34.dex */
public class BaseBehavior<T extends OUnitedTitleBar> extends HeaderBehavior<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f403490j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f403491k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f403492l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SavedState f403493m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WeakReference<View> f403494n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f403495o;

    public static class Behavior extends BaseBehavior<OUnitedTitleBar> {
        public Behavior() {
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final /* bridge */ /* synthetic */ boolean canDragView(View r100) {
            OUnitedTitleBar r101 = (OUnitedTitleBar) r100;
            return b();
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getMaxDragOffset(View r100) {
            OUnitedTitleBar r101 = (OUnitedTitleBar) r100;
            return (-r101.getDownNestedScrollRange()) + r101.getTopInset();
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getScrollRangeForDragFling(View r100) {
            return ((OUnitedTitleBar) r100).getTotalScrollRange();
        }

        public Behavior(Context r100, AttributeSet r101) {
            super(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final void onFlingFinished(CoordinatorLayout r100, View r101) {
            j(r100, (OUnitedTitleBar) r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r100, View r101) {
            return g(r100, (OUnitedTitleBar) r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r100, View r101, int r102) {
            c(r100, (OUnitedTitleBar) r101, r102);
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r100, View r101, Parcelable r102) {
            f(r100, (OUnitedTitleBar) r101, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onStopNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103) {
            OUnitedTitleBar r104 = (OUnitedTitleBar) r101;
            if (this.f403491k != 0) goto L5;
        L6:
            j(r100, r104);
        L7:
            this.f403494n = new WeakReference(r102);
            return;
        L5:
            if (r103 != 1) goto L7;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r100, View r101, int r102, int r103, int r104) {
            return i(r100, (OUnitedTitleBar) r101, r102, r103, r104);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r100, View r101, int r102, int r103, int r104, int r105) {
            return d(r100, (OUnitedTitleBar) r101, r102, r103, r104, r105);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r110, int r111, int r112) {
            return h(r100, (OUnitedTitleBar) r101, r102, r111, r112);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
            e(r100, (OUnitedTitleBar) r101, r104, r105);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedScroll(CoordinatorLayout r100, View r101, View r102, int r110, int r111, int r112, int r113, int r114) {
            OUnitedTitleBar r103 = (OUnitedTitleBar) r101;
            if (r113 >= 0) goto L5;
            scroll(r100, r103, r113, -r103.getDownNestedScrollRange(), 0);
        L5:
            if (r113 != 0) goto L8;
            k(r100, r103);
            return;
        }
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f403496a;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollEffect {
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f403496a = 1;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f403496a = 1;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_scrollFlags, R.attr.layout_scrollInterpolator});
            this.f403496a = r102.getInt(0, 0);
            if (r102.hasValue(1) == false) goto L5;
            AnimationUtils.loadInterpolator(r100, r102.getResourceId(1, 0));
        L5:
            r102.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f403497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f403498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f403499c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f403500d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f403501e;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r100) {
                return new SavedState(r100, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                return new SavedState(r100, r101);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            boolean r102 = true;
            if (r100.readByte() == 0) goto L5;
            boolean r103 = true;
        L6:
            this.f403497a = r103;
            if (r100.readByte() == 0) goto L9;
            boolean r104 = true;
        L10:
            this.f403498b = r104;
            this.f403499c = r100.readInt();
            this.f403500d = r100.readFloat();
            if (r100.readByte() != 0) goto L14;
            r102 = false;
        L14:
            this.f403501e = r102;
            return;
        L9:
            r104 = false;
            goto L10
        L5:
            r103 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeByte(this.f403497a ? 1 : 0);
            r100.writeByte(this.f403498b ? 1 : 0);
            r100.writeInt(this.f403499c);
            r100.writeFloat(this.f403500d);
            r100.writeByte(this.f403501e ? 1 : 0);
        }
    }

    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseBehavior f403502a;

        public a(BaseBehavior r100) {
            this.f403502a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            r101.setScrollable(this.f403502a.f403495o);
            r101.setClassName(ScrollView.class.getName());
        }
    }

    public final boolean b() {
        WeakReference<View> r100 = this.f403494n;
        if (r100 == null) goto L12;
        View r101 = r100.get();
        if (r101 != null) goto L7;
    L11:
        return false;
    L7:
        if (r101.isShown() == false) goto L11;
        if (r101.canScrollVertically(-1) == true) goto L11;
    L12:
        return true;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public final int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset() + this.f403490j;
    }

    public BaseBehavior() {
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ boolean canDragView(View r100) {
        OUnitedTitleBar r101 = (OUnitedTitleBar) r100;
        return b();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int getMaxDragOffset(View r100) {
        OUnitedTitleBar r101 = (OUnitedTitleBar) r100;
        return (-r101.getDownNestedScrollRange()) + r101.getTopInset();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int getScrollRangeForDragFling(View r100) {
        return ((OUnitedTitleBar) r100).getTotalScrollRange();
    }

    public BaseBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public final Parcelable g(CoordinatorLayout r100, T r110) {
        Parcelable r101 = super.onSaveInstanceState(r100, r110);
        int r102 = getTopAndBottomOffset();
        int r103 = r110.getChildCount();
        boolean r104 = false;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L26;
        View r106 = r110.getChildAt(r105);
        int r107 = r106.getBottom() + r102;
        if ((r106.getTop() + r102) > 0) goto L25;
        if (r107 < 0) goto L25;
        if (r101 != null) goto L10;
        Parcelable r108 = AbsSavedState.EMPTY_STATE;
    L11:
        SavedState r109 = new SavedState(r108);
        if (r102 != 0) goto L14;
        boolean r111 = true;
    L15:
        r109.f403498b = r111;
        if (r111 == false) goto L18;
    L20:
        boolean r112 = false;
    L21:
        r109.f403497a = r112;
        r109.f403499c = r105;
        if (r107 != (ViewCompat.getMinimumHeight(r106) + r110.getTopInset())) goto L24;
        r104 = true;
    L24:
        r109.f403501e = r104;
        r109.f403500d = r107 / r106.getHeight();
    L27:
        if (r109 != null) goto L30;
        return r101;
    L30:
        return r109;
    L18:
        if ((-r102) < r110.getTotalScrollRange()) goto L20;
        r112 = true;
        goto L21
    L14:
        r111 = false;
        goto L15
    L10:
        r108 = r101;
    L25:
        r105 = r105 + 1;
        goto L3
    L26:
        r109 = null;
        goto L27
    }

    public final void j(CoordinatorLayout r110, T r111) {
        int r100 = r111.getTopInset() + r111.getPaddingTop();
        int r101 = getTopBottomOffsetForScrollingSibling() - r100;
        int r102 = r111.getChildCount();
        int r103 = 0;
    L3:
        boolean r104 = true;
        if (r103 >= r102) goto L16;
        View r105 = r111.getChildAt(r103);
        int r106 = r105.getTop();
        int r107 = r105.getBottom();
        LayoutParams r108 = (LayoutParams) r105.getLayoutParams();
        if ((r108.f403496a & 32) != 32) goto L8;
        boolean r112 = true;
    L9:
        if (r112 == false) goto L11;
        r106 = r106 - ((FrameLayout.LayoutParams) r108).topMargin;
        r107 = r107 + ((FrameLayout.LayoutParams) r108).bottomMargin;
    L11:
        int r109 = -r101;
        if (r106 > r109) goto L15;
        if (r107 < r109) goto L15;
    L17:
        if (r103 < 0) goto L57;
        View r113 = r111.getChildAt(r103);
        LayoutParams r114 = (LayoutParams) r113.getLayoutParams();
        int r115 = r114.f403496a;
        if ((r115 & 17) != 17) goto L58;
        int r116 = -r113.getTop();
        int r117 = -r113.getBottom();
        if (r103 != 0) goto L28;
        if (ViewCompat.getFitsSystemWindows(r111) == false) goto L28;
        if (ViewCompat.getFitsSystemWindows(r113) == false) goto L28;
        r116 = r116 - r111.getTopInset();
    L28:
        if ((r115 & 2) != 2) goto L30;
        boolean r118 = true;
    L31:
        if (r118 == false) goto L34;
        r117 = r117 + ViewCompat.getMinimumHeight(r113);
    L43:
        if ((r115 & 32) == 32) goto L46;
        r104 = false;
    L46:
        if (r104 == false) goto L49;
        r116 = r116 + ((FrameLayout.LayoutParams) r114).topMargin;
        r117 = r117 - ((FrameLayout.LayoutParams) r114).bottomMargin;
    L49:
        if (r101 >= ((r117 + r116) / 2)) goto L51;
        r116 = r117;
    L51:
        a(r110, r111, MathUtils.clamp(r116 + r100, -r111.getTotalScrollRange(), 0));
        return;
    L34:
        if ((r115 & 5) != 5) goto L36;
        boolean r119 = true;
    L37:
        if (r119 == false) goto L43;
        int r120 = ViewCompat.getMinimumHeight(r113) + r117;
        if (r101 >= r120) goto L41;
        r116 = r120;
        goto L43
    L41:
        r117 = r120;
        goto L43
    L36:
        r119 = false;
        goto L37
    L30:
        r118 = false;
        goto L31
    L58:
        return;
    L57:
        return;
    L15:
        r103 = r103 + 1;
        goto L3
    L8:
        r112 = false;
        goto L9
    L16:
        r103 = -1;
        goto L17
    }

    public final void k(CoordinatorLayout r110, T r111) {
        ViewCompat.removeAccessibilityAction(r110, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(r110, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        if (r111.getTotalScrollRange() != 0) goto L5;
        return;
    L5:
        int r100 = r110.getChildCount();
        boolean r101 = false;
        int r102 = 0;
    L7:
        if (r102 >= r100) goto L12;
        View r103 = r110.getChildAt(r102);
        if ((((CoordinatorLayout.LayoutParams) r103.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) == true) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        View r104 = r103;
    L13:
        if (r104 != null) goto L15;
        return;
    L15:
        int r105 = r111.getChildCount();
        int r106 = 0;
    L16:
        boolean r112 = true;
        if (r106 >= r105) goto L22;
        if (((LayoutParams) r111.getChildAt(r106).getLayoutParams()).f403496a != 0) goto L20;
        r106 = r106 + 1;
        goto L16
    L20:
        boolean r107 = true;
    L23:
        if (r107 == true) goto L26;
        return;
    L26:
        if (ViewCompat.hasAccessibilityDelegate(r110) == true) goto L29;
        ViewCompat.setAccessibilityDelegate(r110, new a(this));
    L29:
        if (getTopBottomOffsetForScrollingSibling() == (-r111.getTotalScrollRange())) goto L32;
        ViewCompat.replaceAccessibilityAction(r110, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, null, new c(r111, false));
        r101 = true;
    L32:
        if (getTopBottomOffsetForScrollingSibling() != 0) goto L34;
    L39:
        r112 = r101;
    L40:
        this.f403495o = r112;
        return;
    L34:
        if (r104.canScrollVertically(-1) == false) goto L38;
        int r108 = -r111.getDownNestedPreScrollRange();
        if (r108 == 0) goto L39;
        ViewCompat.replaceAccessibilityAction(r110, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new b(this, r110, r111, r104, r108));
        goto L40
    L38:
        ViewCompat.replaceAccessibilityAction(r110, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new c(r111, true));
        goto L40
    L22:
        r107 = false;
        goto L23
    L12:
        r104 = null;
        goto L13
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public void onFlingFinished(CoordinatorLayout r100, View r101) {
        j(r100, (OUnitedTitleBar) r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r100, View r101) {
        return g(r100, (OUnitedTitleBar) r101);
    }

    public final void a(CoordinatorLayout r100, OUnitedTitleBar r101, int r102) {
        int r103 = Math.abs(getTopBottomOffsetForScrollingSibling() - r102);
        float r104 = Math.abs(0.0f);
        if (r104 <= 0.0f) goto L5;
        int r105 = Math.round((r103 / r104) * 1000.0f) * 3;
    L6:
        int r106 = getTopBottomOffsetForScrollingSibling();
        if (r106 != r102) goto L13;
        ValueAnimator r107 = this.f403492l;
        if (r107 != null) goto L11;
        return;
    L11:
        if (r107.isRunning() == false) goto L20;
        this.f403492l.cancel();
        return;
    L20:
        return;
    L13:
        ValueAnimator r108 = this.f403492l;
        if (r108 != null) goto L16;
        ValueAnimator r109 = new ValueAnimator();
        this.f403492l = r109;
        r109.setInterpolator(com.google.android.material.animation.AnimationUtils.DECELERATE_INTERPOLATOR);
        this.f403492l.addUpdateListener(new com.obric.oui.titlebar.behavior.a(this, r100, r101));
    L17:
        this.f403492l.setDuration(Math.min(r105, 600));
        this.f403492l.setIntValues(new int[]{r106, r102});
        this.f403492l.start();
        return;
    L16:
        r108.cancel();
        goto L17
    L5:
        r105 = (int) (((r103 / r101.getHeight()) + 1.0f) * 150.0f);
        goto L6
    }

    public final boolean c(CoordinatorLayout r100, T r101, int r102) {
        super.onLayoutChild(r100, r101, r102);
        int r103 = r101.getPendingAction();
        SavedState r104 = this.f403493m;
        if (r104 != null) goto L5;
    L17:
        if (r103 != 0) goto L19;
    L33:
        r101.f403474k = 0;
        this.f403493m = null;
        int r105 = MathUtils.clamp(getTopAndBottomOffset(), -r101.getTotalScrollRange(), 0);
        d r106 = this.f403517a;
        if (r106 != null) goto L36;
        this.f403518b = r105;
    L39:
        l(r101, getTopAndBottomOffset(), 0, true);
        r101.c(getTopAndBottomOffset());
        k(r100, r101);
        return true;
    L36:
        if (r106.f403532d == r105) goto L39;
        r106.f403532d = r105;
        r106.a();
        goto L39
    L19:
        if ((r103 & 4) == 0) goto L21;
        boolean r107 = true;
    L23:
        if ((r103 & 1) == 0) goto L29;
        int r108 = -r101.getUpNestedPreScrollRange();
        if (r107 == false) goto L27;
        a(r100, r101, r108);
        goto L33
    L27:
        setHeaderTopBottomOffset(r100, r101, r108);
        goto L33
    L29:
        if ((r103 & 16) == 0) goto L33;
        if (r107 == false) goto L32;
        a(r100, r101, 0);
        goto L33
    L32:
        setHeaderTopBottomOffset(r100, r101, 0);
        goto L33
    L21:
        r107 = false;
        goto L23
    L5:
        if ((r103 & 8) != 0) goto L17;
        if (r104.f403497a == false) goto L10;
        setHeaderTopBottomOffset(r100, r101, -r101.getTotalScrollRange());
        goto L33
    L10:
        if (r104.f403498b == false) goto L12;
        setHeaderTopBottomOffset(r100, r101, 0);
        goto L33
    L12:
        View r109 = r101.getChildAt(r104.f403499c);
        int r110 = -r109.getBottom();
        if (this.f403493m.f403501e == false) goto L15;
        int r111 = ViewCompat.getMinimumHeight(r109) + r101.getTopInset();
    L16:
        setHeaderTopBottomOffset(r100, r101, r110 + r111);
        goto L33
    L15:
        r111 = Math.round(r109.getHeight() * this.f403493m.f403500d);
        goto L16
    }

    public final void f(CoordinatorLayout r100, T r101, Parcelable r102) {
        if ((r102 instanceof SavedState) == false) goto L5;
        SavedState r103 = (SavedState) r102;
        SavedState r104 = this.f403493m;
        this.f403493m = r103;
        super.onRestoreInstanceState(r100, r101, r103.getSuperState());
        return;
    L5:
        super.onRestoreInstanceState(r100, r101, r102);
        this.f403493m = null;
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r100, View r101, int r102) {
        c(r100, (OUnitedTitleBar) r101, r102);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r100, View r101, Parcelable r102) {
        f(r100, (OUnitedTitleBar) r101, r102);
    }

    public static void l(OUnitedTitleBar r100, int r101, int r102, boolean r103) {
        int r104 = Math.abs(r101);
        int r105 = r100.getChildCount();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L10;
        View r107 = r100.getChildAt(r106);
        if (r104 < r107.getTop()) goto L9;
        if (r104 > r107.getBottom()) goto L9;
    L11:
        if (r107 == null) goto L22;
        int r108 = ((LayoutParams) r107.getLayoutParams()).f403496a;
        if ((r108 & 1) == 0) goto L22;
        ViewCompat.getMinimumHeight(r107);
        if (r102 <= 0) goto L20;
        if ((r108 & 12) == 0) goto L20;
        r107.getBottom();
        r100.getTopInset();
    L20:
        if ((r108 & 2) == 0) goto L22;
        r107.getBottom();
        r100.getTopInset();
    L22:
        if (r103 == true) goto L25;
        return;
    L25:
        if (r100.getBackground() == null) goto L28;
        r100.getBackground().jumpToCurrentState();
    L28:
        if (Build.VERSION.SDK_INT < 23) goto L33;
        if (r100.getForeground() == null) goto L33;
        r100.getForeground().jumpToCurrentState();
    L33:
        if (r100.getStateListAnimator() == null) goto L40;
        r100.getStateListAnimator().jumpToCurrentState();
        return;
    L40:
        return;
    L9:
        r106 = r106 + 1;
        goto L3
    L10:
        r107 = null;
        goto L11
    }

    public final void e(CoordinatorLayout r100, OUnitedTitleBar r110, int r111, int[] r112) {
        if (r111 == 0) goto L8;
        if (r111 >= 0) goto L5;
        int r101 = -r110.getTotalScrollRange();
        int r102 = r101;
        int r103 = r110.getDownNestedPreScrollRange() + r101;
    L6:
        if (r102 == r103) goto L8;
        r112[1] = scroll(r100, r110, r111, r102, r103);
        goto L8
    L5:
        r102 = -r110.getUpNestedPreScrollRange();
        r103 = 0;
    L8:
        r110.getClass();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103) {
        OUnitedTitleBar r104 = (OUnitedTitleBar) r101;
        if (this.f403491k != 0) goto L5;
    L6:
        j(r100, r104);
    L7:
        this.f403494n = new WeakReference(r102);
        return;
    L5:
        if (r103 != 1) goto L7;
        goto L6
    }

    public final boolean h(CoordinatorLayout r100, OUnitedTitleBar r101, View r102, int r103, int r104) {
        boolean r105 = false;
        if ((r103 & 2) == 0) goto L15;
        r101.getClass();
        if (r101.getTotalScrollRange() == 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L10;
    L12:
        boolean r107 = false;
    L13:
        if (r107 == false) goto L15;
        r105 = true;
        goto L15
    L10:
        if ((r100.getHeight() - r102.getHeight()) > r101.getHeight()) goto L12;
        r107 = true;
        goto L13
    L7:
        r106 = false;
    L15:
        if (r105 == false) goto L19;
        ValueAnimator r108 = this.f403492l;
        if (r108 == null) goto L19;
        r108.cancel();
    L19:
        this.f403494n = null;
        this.f403491k = r104;
        return r105;
    }

    public final int i(CoordinatorLayout r100, T r101, int r102, int r103, int r104) {
        int r105 = getTopBottomOffsetForScrollingSibling();
        int r106 = 0;
        if (r103 == 0) goto L25;
        if (r105 < r103) goto L25;
        if (r105 > r104) goto L25;
        int r107 = MathUtils.clamp(r102, r103, r104);
        if (r105 == r107) goto L26;
        r101.getClass();
        d r108 = this.f403517a;
        int r109 = 1;
        if (r108 != null) goto L11;
        this.f403518b = r107;
    L14:
        boolean r110 = false;
    L15:
        int r111 = r105 - r107;
        this.f403490j = r107 - r107;
        if (r110 == false) goto L21;
        int r112 = 0;
    L19:
        if (r112 >= r101.getChildCount()) goto L21;
        ((LayoutParams) r101.getChildAt(r112).getLayoutParams()).getClass();
        r112 = r112 + 1;
    L21:
        r101.c(getTopAndBottomOffset());
        if (r107 >= r105) goto L24;
        r109 = -1;
    L24:
        l(r101, r107, r109, false);
        r106 = r111;
        goto L26
    L11:
        if (r108.f403532d == r107) goto L14;
        r108.f403532d = r107;
        r108.a();
        r110 = true;
    L26:
        k(r100, r101);
        return r106;
    L25:
        this.f403490j = 0;
        goto L26
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r100, View r101, int r102, int r103, int r104) {
        return i(r100, (OUnitedTitleBar) r101, r102, r103, r104);
    }

    public final boolean d(CoordinatorLayout r100, T r101, int r102, int r110, int r111, int r112) {
        if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r101.getLayoutParams())).height != (-2)) goto L7;
        r100.onMeasureChild(r101, r102, r110, View.MeasureSpec.makeMeasureSpec(0, 0), r112);
        return true;
    L7:
        return super.onMeasureChild(r100, r101, r102, r110, r111, r112);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r100, View r101, int r102, int r103, int r104, int r105) {
        return d(r100, (OUnitedTitleBar) r101, r102, r103, r104, r105);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r110, int r111, int r112) {
        return h(r100, (OUnitedTitleBar) r101, r102, r111, r112);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
        e(r100, (OUnitedTitleBar) r101, r104, r105);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout r100, View r101, View r102, int r110, int r111, int r112, int r113, int r114) {
        OUnitedTitleBar r103 = (OUnitedTitleBar) r101;
        if (r113 >= 0) goto L5;
        scroll(r100, r103, r113, -r103.getDownNestedScrollRange(), 0);
    L5:
        if (r113 != 0) goto L8;
        k(r100, r103);
        return;
    }
}
