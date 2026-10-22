package com.bytedance.ies.bullet.container.popup.ui.draggable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.bytedance.ies.bullet.service.popup.ui.AnimController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public int A;
    public com.bytedance.ies.bullet.container.popup.ui.draggable.b B;
    public boolean C;
    public int D;
    public boolean E;
    public int F;
    public int G;
    public WeakReference<V> H;
    public WeakReference<View> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ArrayList<b> f246350J;
    public VelocityTracker K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public Map<View, Integer> Q;
    public final a R;
    public AnimController S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f246351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f246352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f246353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f246354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f246355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f246356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f246357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BottomSheetBehavior<V>.c f246358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f246359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f246360j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f246361k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f246362l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f246363m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f246364n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f246365o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f246366p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f246367q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f246368r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f246369s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f246370t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f246371u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f246372v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f246373w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f246374x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f246375y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f246376z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f246377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f246378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f246379c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f246380d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f246381e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f246382f;

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

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            this.f246377a = r100.readInt();
            this.f246378b = r100.readInt();
            this.f246379c = r100.readInt();
            boolean r102 = false;
            if (r100.readInt() != 1) goto L5;
            boolean r103 = true;
        L6:
            this.f246380d = r103;
            if (r100.readInt() != 1) goto L9;
            boolean r104 = true;
        L10:
            this.f246381e = r104;
            if (r100.readInt() != 1) goto L13;
            r102 = true;
        L13:
            this.f246382f = r102;
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
            r100.writeInt(this.f246377a);
            r100.writeInt(this.f246378b);
            r100.writeInt(this.f246379c);
            r100.writeInt(this.f246380d ? 1 : 0);
            r100.writeInt(this.f246381e ? 1 : 0);
            r100.writeInt(this.f246382f ? 1 : 0);
        }

        public SavedState(Parcelable r100, BottomSheetBehavior<?> r101) {
            super(r100);
            this.f246377a = r101.A;
            this.f246378b = r101.f246354d;
            this.f246379c = r101.f246369s;
            this.f246380d = r101.f246352b;
            this.f246381e = r101.f246365o;
            this.f246382f = r101.f246366p;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public class a extends com.bytedance.ies.bullet.container.popup.ui.draggable.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f246383a;

        public a(BottomSheetBehavior r100) {
            this.f246383a = r100;
        }

        @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.b.c
        public final void a(View r100, int r101) {
            BottomSheetBehavior r102 = this.f246383a;
            if (r102.f246375y <= 0) goto L11;
            if (r100 != null) goto L6;
            return;
        L6:
            if (r102.f246350J.isEmpty() == true) goto L14;
            int r103 = 0;
        L9:
            if (r103 >= this.f246383a.f246350J.size()) goto L15;
            ((b) ListProtector.get(this.f246383a.f246350J, r103)).a(r100, r101);
            r103 = r103 + 1;
            goto L9
        L15:
            return;
        L14:
            return;
        }

        @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.b.c
        public final boolean b(View r100, int r101) {
            BottomSheetBehavior r102 = this.f246383a;
            if (r102.f246375y > 0) goto L6;
            return false;
        L6:
            if (r101 < 0) goto L8;
            if (r101 < 0) goto L17;
            int r103 = r100.getHeight() - r101;
            BottomSheetBehavior r104 = this.f246383a;
            if (r103 < (r104.f246369s - r104.f246375y)) goto L18;
            return true;
        L18:
            return false;
        L17:
            return false;
        L8:
            if ((r102.f246369s - (r100.getHeight() - r101)) > this.f246383a.f246375y) goto L16;
            return true;
        L16:
            return false;
        }

        @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.b.c
        public final void c(View r100, int r101, int r102) {
            BottomSheetBehavior r103 = this.f246383a;
            if (r103.f246375y > 0) goto L5;
        L8:
            this.f246383a.dispatchOnSlide(r101);
            BottomSheetBehavior r104 = this.f246383a;
            if (r104.f246374x == false) goto L17;
            if (r100 != null) goto L12;
            return;
        L12:
            if (r104.f246350J.isEmpty() == true) goto L20;
            int r105 = 0;
        L15:
            if (r105 >= r104.f246350J.size()) goto L21;
            ((b) ListProtector.get(r104.f246350J, r105)).b(r100);
            r105 = r105 + 1;
            goto L15
        L21:
            return;
        L20:
            return;
        L17:
            return;
        L5:
            if (r103.A != 3) goto L8;
            if (r102 <= 0) goto L8;
            r103.setStateInternal(1);
            goto L8
        }
    }

    public static abstract class b {
        public b() {
        }

        public void a(View r100, int r101) {
        }

        public void b(View r100) {
        }

        public abstract void c(View r100);

        public abstract void d(View r100, int r101);
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f246384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f246385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f246386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f246387d;

        public final void a() {
            com.bytedance.ies.bullet.container.popup.ui.draggable.b r100 = this.f246387d.B;
            if (r100 != null) goto L5;
        L28:
            this.f246387d.setStateInternal(this.f246386c);
        L29:
            this.f246385b = false;
            return;
        L5:
            if (r100.f246404a != 2) goto L23;
            boolean r101 = r100.f246419p.computeScrollOffset();
            int r102 = r100.f246419p.getCurrX();
            int r103 = r100.f246419p.getCurrY();
            int r104 = r102 - r100.f246421r.getLeft();
            int r105 = r103 - r100.f246421r.getTop();
            if (r104 == 0) goto L9;
            ViewCompat.offsetLeftAndRight(r100.f246421r, r104);
        L9:
            if (r105 == 0) goto L11;
            r100.f246420q.a(r100.f246421r, r105);
            ViewCompat.offsetTopAndBottom(r100.f246421r, r105);
        L11:
            if (r104 != 0) goto L13;
            if (r105 != 0) goto L13;
        L14:
            if (r101 == true) goto L16;
        L20:
            if (r101 == true) goto L23;
            r100.f246423t.post(r100.f246425v);
            goto L23
        L16:
            if (r102 != r100.f246419p.getFinalX()) goto L20;
            if (r103 != r100.f246419p.getFinalY()) goto L20;
            r100.f246419p.abortAnimation();
            r101 = false;
        L13:
            r100.f246420q.c(r100.f246421r, r103, r105);
        L23:
            if (r100.f246404a != 2) goto L25;
            boolean r106 = true;
        L26:
            if (r106 == false) goto L28;
            ViewCompat.postOnAnimation(this.f246384a, this);
            goto L29
        L25:
            r106 = false;
            goto L26
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(BottomSheetBehavior r100, View r101, int r102) {
            this.f246387d = r100;
            this.f246384a = r101;
            this.f246386c = r102;
        }
    }

    public final void calculateCollapsedOffset() {
        if (this.f246355e == false) goto L5;
        int r100 = Math.max(this.f246356f, this.G - ((this.F * 9) / 16));
    L7:
        if (this.f246352b == false) goto L9;
        this.f246364n = Math.max(this.G - r100, this.f246361k);
        return;
    L9:
        this.f246364n = this.G - r100;
        return;
    L5:
        r100 = this.f246354d + 0;
        goto L7
    }

    public final int getExpandedOffset() {
        if (this.f246352b == false) goto L6;
        return this.f246361k;
    L6:
        return this.f246360j;
    }

    public BottomSheetBehavior() {
        this.f246351a = 0;
        this.f246352b = true;
        this.f246358h = null;
        this.f246363m = 0.5f;
        this.f246367q = true;
        this.f246375y = 0;
        this.f246376z = 5;
        this.A = 4;
        this.f246350J = new ArrayList();
        this.R = new a(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.H = null;
        this.B = null;
    }

    public static <V extends View> BottomSheetBehavior<V> b(V r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r102 = ((CoordinatorLayout.LayoutParams) r101).getBehavior();
        if ((r102 instanceof BottomSheetBehavior) == false) goto L9;
        return (BottomSheetBehavior) r102;
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public final void a(b r100) {
        if (this.f246350J.contains(r100) == true) goto L6;
        this.f246350J.add(r100);
        return;
    }

    public final void dispatchOnSlide(int r100) {
        V r101 = this.H.get();
        AnimController r102 = this.S;
        if (r102 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f246350J.isEmpty() == false) goto L11;
        return;
    L11:
        if (r100 > this.f246364n) goto L13;
        getExpandedOffset();
    L13:
        int r103 = 0;
    L15:
        if (r103 >= this.f246350J.size()) goto L20;
        ((b) ListProtector.get(this.f246350J, r103)).c(r101);
        r103 = r103 + 1;
        goto L15
    L20:
        return;
    L5:
        if (r102.f248013a != AnimController.AnimProcessType.DONE) goto L7;
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        r104.height = this.G - r100;
        r101.requestLayout();
        goto L7
    }

    public final View findScrollingChild(View r100) {
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof CoordinatorLayout) == false) goto L11;
        if (this.P != true) goto L11;
        return r100;
    L11:
        if ((r100 instanceof ViewGroup) == false) goto L18;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L13:
        if (r103 >= r102) goto L22;
        View r104 = findScrollingChild(r101.getChildAt(r103));
        if (r104 != null) goto L16;
        r103 = r103 + 1;
        goto L13
    L16:
        return r104;
    L22:
        return null;
    L18:
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r100) {
        super.onAttachedToLayoutParams(r100);
        this.H = null;
        this.B = null;
    }

    public final void setFitToContents(boolean r100) {
        if (this.f246352b != r100) goto L5;
        return;
    L5:
        this.f246352b = r100;
        if (this.H == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.f246352b == true) goto L11;
    L13:
        int r101 = this.A;
    L14:
        setStateInternal(r101);
        return;
    L11:
        if (this.A != 6) goto L13;
        r101 = 3;
        goto L14
    }

    public final void setHideable(boolean r100) {
        if (this.f246365o == r100) goto L10;
        this.f246365o = r100;
        if (r100 == false) goto L7;
        return;
    L7:
        if (this.A != 5) goto L12;
        setState(4);
        return;
    L12:
        return;
    }

    public final void setPeekHeight(int r100) {
        boolean r101 = false;
        if (r100 != (-1)) goto L8;
        if (this.f246355e == true) goto L13;
        this.f246355e = true;
    L12:
        r101 = true;
    L13:
        if (r101 == true) goto L15;
        return;
    L15:
        if (this.H == null) goto L23;
        calculateCollapsedOffset();
        if (this.A != 4) goto L24;
        V r102 = this.H.get();
        if (r102 == null) goto L25;
        r102.requestLayout();
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L8:
        if (this.f246355e == false) goto L10;
    L11:
        this.f246355e = false;
        this.f246354d = Math.max(0, r100);
        goto L12
    L10:
        if (this.f246354d == r100) goto L13;
        goto L11
    }

    public final void setState(int r100) {
        if (4 != this.A) goto L5;
        return;
    L5:
        WeakReference<V> r101 = this.H;
        if (r101 != null) goto L9;
        this.A = 4;
        return;
    L9:
        V r102 = r101.get();
        if (r102 == null) goto L22;
        ViewParent r103 = r102.getParent();
        if (r103 != null) goto L15;
    L19:
        settleToState(r102, 4);
        return;
    L15:
        if (r103.isLayoutRequested() == false) goto L19;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L19;
        r102.post(new d16.a(this, r102, 4));
        return;
    }

    public final void setStateInternal(int r100) {
        int r101 = 0;
        if (this.H == null) goto L8;
        int r102 = 0;
    L6:
        if (r102 >= this.f246350J.size()) goto L8;
        b r103 = (b) ListProtector.get(this.f246350J, r102);
        V r104 = this.H.get();
        r103.getClass();
        r102 = r102 + 1;
    L8:
        int r105 = this.A;
        if (r105 != r100) goto L11;
        return;
    L11:
        this.f246376z = r105;
        this.A = r100;
        WeakReference<V> r106 = this.H;
        if (r106 != null) goto L14;
        return;
    L14:
        V r107 = r106.get();
        if (r107 != null) goto L17;
        return;
    L17:
        boolean r108 = true;
        if (r100 != 3) goto L21;
        updateImportantForAccessibility(true);
    L28:
        if (r100 == 2) goto L37;
        if (r100 == 3) goto L34;
        r108 = false;
    L34:
        if (this.f246357g == r108) goto L37;
        this.f246357g = r108;
    L37:
        if (r101 >= this.f246350J.size()) goto L39;
        ((b) ListProtector.get(this.f246350J, r101)).d(r107, r100);
        r101 = r101 + 1;
        goto L37
    L39:
        return;
    L21:
        if (r100 != 6) goto L23;
    L26:
        updateImportantForAccessibility(false);
        goto L28
    L23:
        if (r100 == 5) goto L26;
        if (r100 != 4) goto L28;
        goto L26
    }

    public final void updateImportantForAccessibility(boolean r100) {
        WeakReference<V> r101 = this.H;
        if (r101 != null) goto L5;
        return;
    L5:
        ViewParent r102 = r101.get().getParent();
        if ((r102 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r103 = (CoordinatorLayout) r102;
        int r104 = r103.getChildCount();
        if (r100 == true) goto L11;
    L14:
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L22;
        View r106 = r103.getChildAt(r105);
        if (r106 == this.H.get()) goto L21;
        if (r100 == false) goto L21;
        Map<View, Integer> r107 = this.Q;
        HashMap r108 = (HashMap) r107;
        r108.put(r106, Integer.valueOf(r106.getImportantForAccessibility()));
    L21:
        r105 = r105 + 1;
        goto L15
    L22:
        if (r100 == true) goto L29;
        this.Q = null;
        return;
    L29:
        return;
    L11:
        if (this.Q != null) goto L13;
        this.Q = new HashMap(r104);
        goto L14
    }

    public BottomSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f246351a = 0;
        this.f246352b = true;
        this.f246358h = null;
        this.f246363m = 0.5f;
        this.f246367q = true;
        this.f246375y = 0;
        this.f246376z = 5;
        this.A = 4;
        this.f246350J = new ArrayList();
        this.R = new a(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f246359i = r103;
        r103.setDuration(500);
        this.f246359i.addUpdateListener(new d16.b(this));
        TypedValue r104 = r102.peekValue(2);
        if (r104 == null) goto L7;
        int r105 = r104.data;
        if (r105 != (-1)) goto L7;
        setPeekHeight(r105);
    L8:
        setHideable(r102.getBoolean(1, false));
        setFitToContents(true);
        this.f246366p = false;
        this.f246367q = true;
        this.f246351a = 0;
        this.f246363m = 0.5f;
        if (this.H == null) goto L11;
        this.f246362l = (int) (this.G * (1.0f - 0.5f));
    L11:
        this.f246360j = 0;
        r102.recycle();
        this.f246353c = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1));
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        return new SavedState(super.onSaveInstanceState(r100, r101), this);
    }

    public final void settleToState(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.f246364n;
    L19:
        startSettlingAnimation(r100, r101, r102, false);
        return;
    L6:
        if (r101 != 6) goto L12;
        r102 = this.f246362l;
        if (this.f246352b == false) goto L19;
        int r103 = this.f246361k;
        if (r102 > r103) goto L19;
        r102 = r103;
        r101 = 3;
        goto L19
    L12:
        if (r101 != 3) goto L15;
        r102 = getExpandedOffset();
        goto L19
    L15:
        if (this.f246365o == false) goto L22;
        if (r101 != 5) goto L22;
        r102 = this.G;
    L22:
        throw new IllegalArgumentException("Illegal state argument: " + r101);
    }

    public final boolean shouldHide(View r100, float r101) {
        if (this.f246366p == false) goto L6;
        return true;
    L6:
        if (this.f246376z != 3) goto L10;
        if ((r100.getTop() - this.f246360j) < this.f246373w) goto L10;
    L13:
        return true;
    L10:
        if (this.f246376z != 4) goto L15;
        if ((r100.getTop() - this.f246364n) >= this.f246372v) goto L13;
    L15:
        if (r100.getTop() >= this.f246364n) goto L18;
        return false;
    L18:
        if (this.f246355e == false) goto L20;
        int r102 = Math.max(this.f246356f, this.G - ((this.F * 9) / 16));
    L22:
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.f246364n) / r102) > 0.5f) goto L26;
        return false;
    L26:
        return true;
    L20:
        r102 = this.f246354d + 0;
        goto L22
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r110, V r210, MotionEvent r211) {
        int r100 = 1;
        if (r210.isShown() == true) goto L5;
    L180:
        this.C = true;
        return false;
    L5:
        if (this.f246367q == false) goto L180;
        int r101 = r211.getActionMasked();
        if (r101 != 0) goto L13;
        this.L = -1;
        VelocityTracker r102 = this.K;
        if (r102 == null) goto L13;
        r102.recycle();
        this.K = null;
    L13:
        if (this.K != null) goto L15;
        this.K = VelocityTracker.obtain();
    L15:
        this.K.addMovement(r211);
        if (r101 == 0) goto L41;
        if (r101 == 1) goto L37;
        if (r101 == 2) goto L22;
        if (r101 == 3) goto L37;
    L59:
        if (this.C == true) goto L160;
        com.bytedance.ies.bullet.container.popup.ui.draggable.b r103 = this.B;
        if (r103 == null) goto L160;
        int r104 = r211.getActionMasked();
        int r111 = r211.getActionIndex();
        if (r104 != 0) goto L66;
        r103.b();
    L66:
        if (r103.f246415l != null) goto L68;
        r103.f246415l = VelocityTracker.obtain();
    L68:
        r103.f246415l.addMovement(r211);
        if (r104 == 0) goto L146;
        if (r104 == 1) goto L145;
        if (r104 == 2) goto L89;
        if (r104 == 3) goto L145;
        if (r104 != 5) goto L76;
        int r105 = r211.getPointerId(r111);
        float r112 = r211.getX(r111);
        float r113 = r211.getY(r111);
        r103.m(r112, r113, r105);
        int r114 = r103.f246404a;
        if (r114 == 0) goto L82;
        if (r114 != 2) goto L144;
        View r115 = r103.i((int) r112, (int) r113);
        if (r115 != r103.f246421r) goto L144;
        r103.p(r115, r105);
    L144:
        int r116 = r101;
    L155:
        if (r103.f246404a != 1) goto L157;
        boolean r117 = true;
    L158:
        if (r117 == false) goto L161;
        return true;
    L161:
        WeakReference<View> r106 = this.I;
        if (r106 == null) goto L164;
        View r107 = r106.get();
        int r108 = 2;
    L165:
        if (r116 != r108) goto L178;
        if (r107 == null) goto L178;
        if (this.C == true) goto L178;
        if (this.A == 1) goto L178;
        if (r110.isPointInChildBounds(r107, (int) r211.getX(), (int) r211.getY()) == true) goto L178;
        if (this.B == null) goto L178;
        if (Math.abs(this.N - r211.getY()) <= this.B.f246405b) goto L178;
        return true;
    L178:
        return false;
    L164:
        r108 = 2;
        r107 = null;
        goto L165
    L157:
        r117 = false;
        goto L158
    L82:
        if ((r103.f246411h[r105] & 0) == 0) goto L144;
        r103.f246420q.getClass();
        goto L144
    L76:
        if (r104 != 6) goto L144;
        r103.f(r211.getPointerId(r111));
        goto L144
    L89:
        if (r103.f246407d == null) goto L144;
        if (r103.f246408e == null) goto L144;
        int r109 = r211.getPointerCount();
        int r118 = 0;
    L94:
        if (r118 >= r109) goto L142;
        int r119 = r211.getPointerId(r118);
        if ((r103.f246414k & (r100 << r119)) == 0) goto L98;
        boolean r120 = true;
    L99:
        if (r120 == true) goto L101;
        boolean r121 = false;
    L102:
        if (r121 == true) goto L104;
        r116 = r101;
        int r212 = r109;
    L141:
        r118 = r118 + 1;
        r109 = r212;
        r101 = r116;
        r100 = 1;
        goto L94
    L104:
        float r122 = r211.getX(r118);
        float r123 = r211.getY(r118);
        float r124 = r122 - r103.f246407d[r119];
        float r125 = r123 - r103.f246408e[r119];
        View r126 = r103.i((int) r122, (int) r123);
        if (r126 != null) goto L107;
    L109:
        boolean r127 = false;
    L110:
        if (r127 == false) goto L133;
        r126.getLeft();
        ((a) r103.f246420q).getClass();
        r126.getLeft();
        int r128 = r126.getTop();
        int r129 = ((int) r125) + r128;
        a r130 = (a) r103.f246420q;
        int r131 = r130.f246383a.getExpandedOffset();
        BottomSheetBehavior r132 = r130.f246383a;
        r212 = r109;
        if (r132.f246365o == false) goto L114;
        int r133 = r132.G;
    L115:
        int r134 = MathUtils.clamp(r129, r131, r133);
        r103.f246420q.getClass();
        com.bytedance.ies.bullet.container.popup.ui.draggable.b.c r135 = r103.f246420q;
        BottomSheetBehavior r136 = ((a) r135).f246383a;
        if (r136.f246365o == false) goto L118;
        int r137 = r136.G;
    L119:
        a r138 = (a) r135;
        r138.getClass();
        int r139 = r126.getHeight();
        BottomSheetBehavior r140 = r138.f246383a;
        r116 = r101;
        if (r139 <= r140.f246354d) goto L123;
        boolean r141 = false;
    L127:
        if (r141 == false) goto L143;
        if (r137 == 0) goto L143;
        if (r137 <= 0) goto L134;
        if (r134 == r128) goto L143;
    L134:
        r103.l(r124, r125, r119);
        if (r103.f246404a == 1) goto L143;
        if (r127 == false) goto L141;
        if (r103.p(r126, r119) == false) goto L141;
    L143:
        r103.n(r211);
        goto L155
    L123:
        if (r140.B == null) goto L125;
        int r142 = (int) r211.getX();
        int r143 = (int) r211.getY();
        BottomSheetBehavior r144 = r138.f246383a;
        boolean r145 = com.bytedance.ies.bullet.container.popup.ui.draggable.b.a(r126, 1, r142, r143 - (r144.G - r144.f246368r));
    L126:
        r141 = !r145;
        goto L127
    L125:
        r145 = true;
        goto L126
    L118:
        r137 = r136.f246364n;
        goto L119
    L114:
        r133 = r132.f246364n;
        goto L115
    L133:
        r116 = r101;
        r212 = r109;
        goto L134
    L107:
        if (r103.e(r126, r125) == false) goto L109;
        r127 = true;
        goto L110
    L101:
        r121 = true;
        goto L102
    L98:
        r120 = false;
        goto L99
    L142:
        r116 = r101;
    L145:
        r116 = r101;
        r103.b();
        goto L155
    L146:
        r116 = r101;
        float r146 = r211.getX();
        float r147 = r211.getY();
        int r148 = r211.getPointerId(0);
        r103.m(r146, r147, r148);
        View r149 = r103.i((int) r146, (int) r147);
        if (r149 != r103.f246421r) goto L152;
        if (r103.f246404a != 2) goto L152;
        r103.p(r149, r148);
    L152:
        if ((r103.f246411h[r148] & 0) == 0) goto L155;
        r103.f246420q.getClass();
    L160:
        r116 = r101;
        goto L161
    L22:
        if (this.f246367q == false) goto L59;
        if (this.A != 4) goto L33;
        if (this.B == null) goto L33;
        if (Math.abs(this.f246368r - this.f246354d) >= this.B.f246405b) goto L33;
        if (Math.abs(r211.getY() - this.N) <= this.B.f246405b) goto L33;
        return true;
    L33:
        if ((((int) r211.getY()) - this.N) <= this.B.f246405b) goto L59;
        if (com.bytedance.ies.bullet.container.popup.ui.draggable.b.a(r210, 0, (int) r211.getX(), ((int) r211.getY()) - (this.G - this.f246368r)) == true) goto L59;
        return true;
    L37:
        this.O = false;
        this.L = -1;
        if (this.C == false) goto L59;
        this.C = false;
        return false;
    L41:
        this.M = (int) r211.getX();
        this.N = (int) r211.getY();
        this.f246368r = r210.getHeight();
        if (this.A == 2) goto L52;
        WeakReference<View> r150 = this.I;
        if (r150 == null) goto L46;
        View r151 = r150.get();
    L47:
        if (r151 == null) goto L52;
        if (r110.isPointInChildBounds(r151, this.M, this.N) == false) goto L52;
        this.L = r211.getPointerId(r211.getActionIndex());
        this.O = true;
        goto L52
    L46:
        r151 = null;
    L52:
        if (this.L == (-1)) goto L54;
    L56:
        boolean r152 = false;
    L57:
        this.C = r152;
        goto L59
    L54:
        if (r110.isPointInChildBounds(r210, this.M, this.N) == true) goto L56;
        r152 = true;
        goto L57
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        if (ViewCompat.getFitsSystemWindows(r100) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L8;
        r101.setFitsSystemWindows(true);
    L8:
        if (this.H != null) goto L13;
        this.f246356f = r100.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
        this.H = new WeakReference(r101);
        if (ViewCompat.getImportantForAccessibility(r101) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(r101, 1);
    L13:
        if (this.B != null) goto L15;
        this.B = new com.bytedance.ies.bullet.container.popup.ui.draggable.b(r100.getContext(), r100, this.R);
    L15:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);
        this.F = r100.getWidth();
        int r104 = r100.getHeight();
        this.G = r104;
        int r105 = this.f246369s;
        if (r105 <= 0) goto L18;
        this.f246360j = r104 - r105;
    L19:
        this.f246361k = Math.max(0, r104 - r101.getHeight());
        this.f246362l = (int) (this.G * (1.0f - this.f246363m));
        calculateCollapsedOffset();
        int r106 = this.A;
        if (r106 != 3) goto L23;
        ViewCompat.offsetTopAndBottom(r101, getExpandedOffset());
    L37:
        this.I = new WeakReference(findScrollingChild(r101));
        return true;
    L23:
        if (r106 != 6) goto L26;
        ViewCompat.offsetTopAndBottom(r101, this.f246362l);
        goto L37
    L26:
        if (this.f246365o == false) goto L31;
        if (r106 != 5) goto L31;
        ViewCompat.offsetTopAndBottom(r101, this.G);
    L31:
        if (r106 != 4) goto L33;
        ViewCompat.offsetTopAndBottom(r101, this.f246364n);
        goto L37
    L33:
        if (r106 != 1) goto L35;
    L36:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L37
    L35:
        if (r106 != 2) goto L37;
    L18:
        this.f246360j = 0;
        goto L19
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        SavedState r103 = (SavedState) r102;
        super.onRestoreInstanceState(r100, r101, r103.getSuperState());
        int r104 = this.f246351a;
        if (r104 != 0) goto L6;
    L22:
        int r105 = r103.f246377a;
        if (r105 == 1) goto L27;
        if (r105 == 2) goto L27;
        this.A = r105;
        return;
    L27:
        this.A = 4;
        return;
    L6:
        if (r104 != (-1)) goto L8;
    L9:
        this.f246354d = r103.f246378b;
    L10:
        if (r104 != (-1)) goto L12;
    L13:
        this.f246352b = r103.f246380d;
    L14:
        if (r104 != (-1)) goto L16;
    L17:
        this.f246365o = r103.f246381e;
    L18:
        if (r104 != (-1)) goto L20;
    L21:
        this.f246366p = r103.f246382f;
        goto L22
    L20:
        if ((r104 & 8) != 8) goto L22;
    L16:
        if ((r104 & 4) != 4) goto L18;
    L12:
        if ((r104 & 2) != 2) goto L14;
    L8:
        if ((r104 & 1) != 1) goto L10;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r110, V r111, MotionEvent r112) {
        int r100 = 0;
        if (r111.isShown() == true) goto L5;
        return false;
    L5:
        int r113 = r112.getActionMasked();
        if (this.A != 1) goto L9;
        if (r113 != 0) goto L9;
        return true;
    L9:
        com.bytedance.ies.bullet.container.popup.ui.draggable.b r101 = this.B;
        if (r101 == null) goto L148;
        int r102 = r112.getActionMasked();
        int r103 = r112.getActionIndex();
        if (r102 != 0) goto L15;
        r101.b();
    L15:
        if (r101.f246415l != null) goto L17;
        r101.f246415l = VelocityTracker.obtain();
    L17:
        r101.f246415l.addMovement(r112);
        if (r102 == 0) goto L145;
        if (r102 == 1) goto L136;
        if (r102 == 2) goto L78;
        if (r102 == 3) goto L67;
        if (r102 != 5) goto L26;
        int r104 = r112.getPointerId(r103);
        float r105 = r112.getX(r103);
        float r106 = r112.getY(r103);
        r101.m(r105, r106, r104);
        if (r101.f246404a != 0) goto L52;
        r101.p(r101.i((int) r105, (int) r106), r104);
        if ((0 & r101.f246411h[r104]) == 0) goto L148;
        r101.f246420q.getClass();
        goto L148
    L52:
        int r107 = (int) r105;
        int r108 = (int) r106;
        View r109 = r101.f246421r;
        if (r109 != null) goto L56;
    L64:
        if (r100 == 0) goto L148;
        r101.p(r101.f246421r, r104);
        goto L148
    L56:
        if (r107 < r109.getLeft()) goto L64;
        if (r107 >= r109.getRight()) goto L64;
        if (r108 < r109.getTop()) goto L64;
        if (r108 >= r109.getBottom()) goto L64;
        r100 = 1;
        goto L64
    L26:
        if (r102 != 6) goto L148;
        int r114 = r112.getPointerId(r103);
        if (r101.f246404a == 1) goto L31;
    L46:
        r101.f(r114);
        goto L148
    L31:
        if (r114 != r101.f246406c) goto L46;
        int r115 = r112.getPointerCount();
    L33:
        if (r100 >= r115) goto L43;
        int r116 = r112.getPointerId(r100);
        if (r116 == r101.f246406c) goto L42;
        View r117 = r101.i((int) r112.getX(r100), (int) r112.getY(r100));
        View r118 = r101.f246421r;
        if (r117 != r118) goto L42;
        if (r101.p(r118, r116) == false) goto L42;
        int r119 = r101.f246406c;
    L44:
        if (r119 != (-1)) goto L46;
        r101.k();
    L42:
        r100 = r100 + 1;
        goto L33
    L43:
        r119 = -1;
        goto L44
    L67:
        if (r101.f246404a == 1) goto L69;
    L71:
        r101.b();
        if (r101.f246424u == true) goto L74;
    L76:
        r101.f246424u = false;
        goto L148
    L74:
        if (r101.f246404a != 1) goto L76;
        r101.o(0);
        goto L76
    L69:
        if (r101.f246424u == true) goto L71;
        r101.h(0.0f, 0.0f);
        goto L71
    L78:
        if (r101.f246404a != 1) goto L114;
        int r120 = r101.f246406c;
        if ((r101.f246414k & (1 << r120)) == 0) goto L82;
        boolean r121 = true;
    L83:
        if (r121 == true) goto L85;
        boolean r122 = false;
    L86:
        if (r122 == false) goto L148;
        int r123 = r112.findPointerIndex(r120);
        float r124 = r112.getX(r123);
        float r125 = r112.getY(r123);
        float[] r126 = r101.f246409f;
        int r127 = r101.f246406c;
        int r128 = (int) (r124 - r126[r127]);
        int r129 = (int) (r125 - r101.f246410g[r127]);
        if (r129 < 0) goto L91;
    L95:
        if (r129 > 0) goto L97;
    L101:
        r101.f246421r.getLeft();
        int r130 = r101.f246421r.getTop() + r129;
        int r131 = r101.f246421r.getLeft();
        int r132 = r101.f246421r.getTop();
        if (r128 == 0) goto L104;
        com.bytedance.ies.bullet.container.popup.ui.draggable.b.c r133 = r101.f246420q;
        View r134 = r101.f246421r;
        ((a) r133).getClass();
        ViewCompat.offsetLeftAndRight(r101.f246421r, r134.getLeft() - r131);
    L104:
        if (r129 == 0) goto L110;
        a r135 = (a) r101.f246420q;
        int r136 = r135.f246383a.getExpandedOffset();
        BottomSheetBehavior r137 = r135.f246383a;
        if (r137.f246365o == false) goto L108;
        int r138 = r137.G;
    L109:
        r130 = MathUtils.clamp(r130, r136, r138);
        r101.f246420q.a(r101.f246421r, r129);
        ViewCompat.offsetTopAndBottom(r101.f246421r, r130 - r132);
        goto L110
    L108:
        r138 = r137.f246364n;
    L110:
        if (r128 != 0) goto L112;
        if (r129 != 0) goto L112;
    L113:
        r101.n(r112);
    L112:
        r101.f246420q.c(r101.f246421r, r130, r130 - r132);
        goto L113
    L97:
        if (r101.f246420q.b(r101.f246421r, r129) == false) goto L101;
        r101.f246424u = false;
        com.bytedance.ies.bullet.container.popup.ui.draggable.b.c r139 = r101.f246420q;
        View r140 = r101.f246421r;
        a r141 = (a) r139;
        r141.a(r140, r129);
        BottomSheetBehavior r142 = r141.f246383a;
        ViewCompat.offsetTopAndBottom(r140, ((r142.f246375y - r142.f246369s) + r142.G) - r140.getTop());
        r140.getLeft();
        BottomSheetBehavior r143 = r141.f246383a;
        r141.c(r140, (r143.f246375y - r143.f246369s) + r143.G, r129);
        BottomSheetBehavior r144 = r141.f246383a;
        if (r144.A == 1) goto L113;
        r144.setStateInternal(1);
        goto L113
    L91:
        if (r101.f246420q.b(r101.f246421r, r129) == false) goto L95;
        r101.f246424u = true;
        com.bytedance.ies.bullet.container.popup.ui.draggable.b.c r145 = r101.f246420q;
        View r146 = r101.f246421r;
        a r147 = (a) r145;
        r147.getClass();
        r147.a(r146, r146.getHeight() - r147.f246383a.f246369s);
        BottomSheetBehavior r148 = r147.f246383a;
        ViewCompat.offsetTopAndBottom(r146, (r148.G - r148.f246369s) - r146.getTop());
        r146.getLeft();
        BottomSheetBehavior r149 = r147.f246383a;
        r147.c(r146, r149.G - r149.f246369s, 0);
        BottomSheetBehavior r150 = r147.f246383a;
        if (r150.A == 3) goto L113;
        r150.setStateInternal(3);
        goto L113
    L85:
        r122 = true;
        goto L86
    L82:
        r121 = false;
        goto L83
    L114:
        int r151 = r112.getPointerCount();
        int r152 = 0;
    L115:
        if (r152 >= r151) goto L134;
        int r153 = r112.getPointerId(r152);
        if ((r101.f246414k & (1 << r153)) == 0) goto L119;
        boolean r154 = true;
    L120:
        if (r154 == true) goto L122;
        boolean r155 = false;
    L123:
        if (r155 == false) goto L133;
        float r156 = r112.getX(r152);
        float r157 = r112.getY(r152);
        float r158 = r156 - r101.f246407d[r153];
        float r159 = r157 - r101.f246408e[r153];
        r101.l(r158, r159, r153);
        if (r101.f246404a == 1) goto L134;
        View r160 = r101.i((int) r156, (int) r157);
        if (r101.e(r160, r159) == false) goto L133;
        if (r101.p(r160, r153) == true) goto L134;
    L133:
        r152 = r152 + 1;
        goto L115
    L122:
        r155 = true;
        goto L123
    L119:
        r154 = false;
    L134:
        r101.n(r112);
        goto L148
    L136:
        if (r101.f246404a == 1) goto L138;
    L140:
        r101.b();
        if (r101.f246424u != true) goto L148;
        if (r101.f246404a != 1) goto L148;
        r101.o(0);
        goto L148
    L138:
        if (r101.f246424u == true) goto L140;
        r101.k();
        goto L140
    L145:
        float r161 = r112.getX();
        float r162 = r112.getY();
        int r163 = r112.getPointerId(0);
        View r164 = r101.i((int) r161, (int) r162);
        r101.m(r161, r162, r163);
        r101.p(r164, r163);
        if ((0 & r101.f246411h[r163]) == 0) goto L148;
        r101.f246420q.getClass();
    L148:
        if (r113 != 0) goto L153;
        this.L = -1;
        VelocityTracker r165 = this.K;
        if (r165 == null) goto L153;
        r165.recycle();
        this.K = null;
    L153:
        if (this.K != null) goto L155;
        this.K = VelocityTracker.obtain();
    L155:
        this.K.addMovement(r112);
        if (r113 != 2) goto L163;
        if (this.C == true) goto L163;
        float r166 = Math.abs(this.N - r112.getY());
        com.bytedance.ies.bullet.container.popup.ui.draggable.b r167 = this.B;
        if (r166 <= r167.f246405b) goto L163;
        r167.c(r111, r112.getPointerId(r112.getActionIndex()));
    L163:
        return !this.C;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        int r104 = 3;
        if (r101.getTop() != getExpandedOffset()) goto L6;
        setStateInternal(3);
        return;
    L6:
        WeakReference<View> r105 = this.I;
        if (r105 != null) goto L9;
        return;
    L9:
        if (r102 == r105.get()) goto L11;
        return;
    L11:
        if (this.E == true) goto L14;
        return;
    L14:
        if (this.D <= 0) goto L20;
        if (this.f246352b == false) goto L18;
        int r106 = this.f246361k;
    L45:
        startSettlingAnimation(r101, r104, r106, false);
        this.E = false;
        return;
    L18:
        r106 = this.f246360j;
        goto L45
    L20:
        if (this.f246365o == false) goto L29;
        VelocityTracker r107 = this.K;
        if (r107 != null) goto L24;
        float r108 = 0.0f;
    L26:
        if (shouldHide(r101, r108) == false) goto L29;
        r106 = this.G;
        r104 = 5;
        goto L45
    L24:
        r107.computeCurrentVelocity(1000, this.f246353c);
        r108 = this.K.getYVelocity(this.L);
    L29:
        if (this.D != 0) goto L41;
        int r109 = r101.getTop();
        if (this.f246352b == false) goto L37;
        if (Math.abs(r109 - this.f246361k) >= Math.abs(r109 - this.f246364n)) goto L35;
        r106 = this.f246361k;
        goto L45
    L35:
        r106 = this.f246364n;
    L44:
        r104 = 4;
        goto L45
    L37:
        if (Math.abs(r109 - this.f246360j) >= Math.abs(r109 - this.f246364n)) goto L39;
        r106 = this.f246360j;
        goto L45
    L39:
        r106 = this.f246364n;
        goto L44
    L41:
        if (this.f246352b == false) goto L43;
        r106 = this.f246364n;
        goto L44
    L43:
        r106 = this.f246364n;
        goto L44
    }

    public final void startSettlingAnimation(View r100, int r101, int r102, boolean r103) {
        boolean r104 = false;
        if (r103 == false) goto L9;
        com.bytedance.ies.bullet.container.popup.ui.draggable.b r105 = this.B;
        int r106 = r100.getLeft();
        if (r105.f246422s == false) goto L8;
        boolean r107 = r105.j(r106, r102, (int) r105.f246415l.getXVelocity(r105.f246406c), (int) r105.f246415l.getYVelocity(r105.f246406c));
    L16:
        if (r107 == false) goto L33;
        setStateInternal(2);
        if (r101 == 2) goto L27;
        if (r101 != 3) goto L24;
        r104 = true;
    L24:
        if (this.f246357g == r104) goto L27;
        this.f246357g = r104;
    L27:
        if (this.f246358h != null) goto L29;
        this.f246358h = new c(this, r100, r101);
    L29:
        BottomSheetBehavior<V>.c r108 = this.f246358h;
        if (r108.f246385b == true) goto L32;
        r108.f246386c = r101;
        ViewCompat.postOnAnimation(r100, r108);
        this.f246358h.f246385b = true;
        return;
    L32:
        r108.f246386c = r101;
        return;
    L33:
        setStateInternal(r101);
        return;
    L8:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    L9:
        com.bytedance.ies.bullet.container.popup.ui.draggable.b r109 = this.B;
        int r110 = r100.getLeft();
        r109.f246421r = r100;
        r109.f246406c = -1;
        r107 = r109.j(r110, r102, 0, 0);
        if (r107 == true) goto L16;
        if (r109.f246404a != 0) goto L16;
        if (r109.f246421r == null) goto L16;
        r109.f246421r = null;
        goto L16
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        WeakReference<View> r105 = this.I;
        if (r105 != null) goto L5;
        return false;
    L5:
        if (r102 == r105.get()) goto L7;
        return false;
    L7:
        if (this.A == 3) goto L9;
    L10:
        return true;
    L9:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == true) goto L10;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        this.I = new WeakReference(r103);
        this.D = 0;
        this.E = false;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
        if (r106 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r107 = this.I;
        if (r107 == null) goto L8;
        View r108 = r107.get();
    L9:
        if (r102 == r108) goto L11;
        return;
    L11:
        int r109 = r101.getTop();
        int r110 = r109 - r104;
        if (r104 > 0) goto L14;
        if (r104 < 0) goto L22;
    L33:
        dispatchOnSlide(r101.getTop());
        this.D = r104;
        this.E = true;
        return;
    L22:
        if (r102.canScrollVertically(-1) == true) goto L33;
        int r111 = this.f246364n;
        if (r110 <= r111) goto L30;
        if (this.f246365o == true) goto L30;
        int r112 = r109 - r111;
        r105[1] = r112;
        ViewCompat.offsetTopAndBottom(r101, -r112);
        setStateInternal(4);
    L30:
        if (this.f246367q == true) goto L32;
        return;
    L32:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L33
    L14:
        if (r110 >= getExpandedOffset()) goto L17;
        int r113 = r109 - getExpandedOffset();
        r105[1] = r113;
        ViewCompat.offsetTopAndBottom(r101, -r113);
        setStateInternal(3);
        goto L33
    L17:
        if (this.f246367q == true) goto L19;
        return;
    L19:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L33
    L8:
        r108 = null;
        goto L9
    }
}
