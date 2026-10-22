package com.bytedance.dux.panel;

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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import em4.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public final ArrayList<d> A;
    public VelocityTracker B;
    public int C;
    public int D;
    public boolean E;
    public Map<View, Integer> F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f205251J;
    public final b K;
    public final c L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f205252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f205253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f205254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f205255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f205256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f205257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f205258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f205259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f205260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f205261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f205262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f205263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f205264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f205265n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f205266o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f205267p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.dux.panel.d f205268q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.bytedance.dux.panel.a f205269r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f205270s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f205271t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f205272u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f205273v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f205274w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f205275x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public WeakReference<V> f205276y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public WeakReference<View> f205277z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f205278a;

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
            this.f205278a = r100.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f205278a);
        }

        public SavedState(Parcelable r100, int r101) {
            super(r100);
            this.f205278a = r101;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f205279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f205280b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f205281c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f205281c.startSettlingAnimation(this.f205279a, this.f205280b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(BottomSheetBehavior r100, View r101, int r102) {
            this.f205281c = r100;
            this.f205279a = r101;
            this.f205280b = r102;
        }
    }

    public class b extends com.bytedance.dux.panel.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f205282a;

        public b(BottomSheetBehavior r100) {
            this.f205282a = r100;
        }

        @Override // com.bytedance.dux.panel.d.c
        public final int c(View r100) {
            BottomSheetBehavior r101 = this.f205282a;
            if (r101.f205263l == false) goto L7;
            return r101.f205273v;
        L7:
            return r101.f205262k;
        }

        @Override // com.bytedance.dux.panel.d.c
        public final void d(int r100) {
            if (r100 != 1) goto L8;
            BottomSheetBehavior r101 = this.f205282a;
            if (r101.f205264m == false) goto L9;
            r101.setStateInternal(1);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.dux.panel.d.c
        public final boolean g(View r100, int r101) {
            BottomSheetBehavior r102 = this.f205282a;
            int r103 = r102.f205266o;
            if (r103 != 1) goto L6;
            return false;
        L6:
            if (r102.E == false) goto L9;
            return false;
        L9:
            if (r103 == 3) goto L11;
        L17:
            WeakReference<V> r104 = this.f205282a.f205276y;
            if (r104 != null) goto L20;
            return false;
        L20:
            if (r104.get() != r100) goto L24;
            return true;
        L24:
            return false;
        L11:
            if (r102.C != r101) goto L17;
            View r105 = r102.f205277z.get();
            if (r105 == null) goto L17;
            if (r105.canScrollVertically(-1) == false) goto L17;
            return false;
        }

        @Override // com.bytedance.dux.panel.d.c
        public final int a(View r100, int r101, int r102) {
            return r100.getLeft();
        }

        @Override // com.bytedance.dux.panel.d.c
        public final int b(View r100, int r101, int r102) {
            int r103 = this.f205282a.getExpandedOffset();
            BottomSheetBehavior r104 = this.f205282a;
            if (r104.f205263l == false) goto L5;
            int r105 = r104.f205273v;
        L7:
            return MathUtils.clamp(r101, r103, r105);
        L5:
            r105 = r104.f205262k;
            goto L7
        }

        @Override // com.bytedance.dux.panel.d.c
        public final void f(View r100, float r101, float r102) {
            int[] r103 = BottomSheetBehavior.a(this.f205282a, r100, r101, r102);
            int r104 = r103[0];
            int r105 = r103[1];
            BottomSheetBehavior r106 = this.f205282a;
            r106.f205267p = r105;
            com.bytedance.dux.panel.d r107 = r106.f205268q;
            int r108 = r100.getLeft();
            if (r107.f205374s == false) goto L10;
            if (r107.h(r108, r104, (int) r107.f205367l.getXVelocity(r107.f205358c), (int) r107.f205367l.getYVelocity(r107.f205358c)) == false) goto L7;
            this.f205282a.setStateInternal(2);
            ViewCompat.postOnAnimation(r100, new f(this.f205282a, r100, r105));
            return;
        L7:
            this.f205282a.setStateInternal(r105);
            return;
        L10:
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }

        @Override // com.bytedance.dux.panel.d.c
        public final void e(View r100, int r101, int r102, int r103, int r104) {
            this.f205282a.dispatchOnSlide(r102);
        }
    }

    public class c extends com.bytedance.dux.panel.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f205283a;

        public c(BottomSheetBehavior r100) {
            this.f205283a = r100;
        }

        @Override // com.bytedance.dux.panel.d.c
        public final int c(View r100) {
            return this.f205283a.K.c(r100);
        }

        @Override // com.bytedance.dux.panel.d.c
        public final void d(int r100) {
            this.f205283a.K.d(r100);
        }

        @Override // com.bytedance.dux.panel.d.c
        public final boolean g(View r100, int r101) {
            return this.f205283a.K.g(r100, r101);
        }

        @Override // com.bytedance.dux.panel.d.c
        public final int a(View r100, int r101, int r102) {
            this.f205283a.K.getClass();
            return r100.getLeft();
        }

        @Override // com.bytedance.dux.panel.d.c
        public final int b(View r100, int r101, int r102) {
            return this.f205283a.K.b(r100, r101, r102);
        }

        @Override // com.bytedance.dux.panel.d.c
        public final void f(View r110, float r111, float r210) {
            int[] r100 = BottomSheetBehavior.a(this.f205283a, r110, r111, r210);
            boolean r101 = false;
            int r102 = r100[0];
            int r103 = r100[1];
            BottomSheetBehavior r104 = this.f205283a;
            r104.f205267p = r103;
            com.bytedance.dux.panel.a r105 = r104.f205269r;
            int r106 = r110.getLeft();
            int r107 = (int) r111;
            int r108 = (int) r210;
            r105.getClass();
            int r112 = r110.getLeft();
            int r113 = r110.getTop();
            int r114 = r106 - r112;
            int r115 = r102 - r113;
            if (r114 != 0) goto L6;
            if (r115 != 0) goto L6;
            r105.f205339a.abortAnimation();
        L29:
            if (r101 == false) goto L31;
            this.f205283a.setStateInternal(2);
            ViewCompat.postOnAnimation(r110, new e(this.f205283a, r110, r103));
            return;
        L31:
            this.f205283a.setStateInternal(r103);
            return;
        L6:
            int r109 = (int) r105.f205342d;
            int r116 = (int) r105.f205341c;
            int r117 = Math.abs(r107);
            if (r117 >= r109) goto L9;
            r107 = 0;
        L13:
            int r118 = (int) r105.f205342d;
            int r119 = (int) r105.f205341c;
            int r120 = Math.abs(r108);
            if (r120 >= r118) goto L16;
            r108 = 0;
        L20:
            int r121 = Math.abs(r114);
            int r122 = Math.abs(r115);
            int r123 = Math.abs(r107);
            int r124 = Math.abs(r108);
            int r125 = r123 + r124;
            int r126 = r121 + r122;
            if (r107 == 0) goto L23;
            float r127 = r123;
            float r128 = r125;
        L24:
            float r129 = r127 / r128;
            if (r108 == 0) goto L27;
            float r130 = r124;
            float r131 = r125;
        L28:
            r105.f205340b.getClass();
            int r132 = r105.a(r114, r107, 0);
            r105.f205339a.startScroll(r112, r113, r114, r115, (int) ((r132 * r129) + (r105.a(r115, r108, r105.f205340b.c(r110)) * (r130 / r131))));
            r105.f205350l = true;
            r101 = true;
            goto L29
        L27:
            r131 = r126;
            r130 = r122;
            goto L28
        L23:
            r127 = r121;
            r128 = r126;
            goto L24
        L16:
            if (r120 <= r119) goto L20;
            if (r108 <= 0) goto L19;
            r108 = r119;
            goto L20
        L19:
            r108 = -r119;
            goto L20
        L9:
            if (r117 <= r116) goto L13;
            if (r107 <= 0) goto L12;
            r107 = r116;
            goto L13
        L12:
            r107 = -r116;
            goto L13
        }

        @Override // com.bytedance.dux.panel.d.c
        public final void e(View r100, int r101, int r110, int r111, int r112) {
            this.f205283a.K.e(r100, r101, r110, r111, r112);
        }
    }

    public static abstract class d {
        public d() {
        }

        public abstract void a(View r100, float r101);

        public abstract void b(View r100, int r101);
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f205284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f205285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f205286c;

        public final void a() {
            com.bytedance.dux.panel.a r100 = this.f205286c.f205269r;
            if (r100 == null) goto L25;
            View r101 = this.f205284a;
            if (r100.f205350l == false) goto L23;
            boolean r102 = r100.f205339a.computeScrollOffset();
            int r103 = r100.f205339a.getCurrX();
            int r104 = r100.f205339a.getCurrY();
            int r105 = r103 - r101.getLeft();
            int r106 = r104 - r101.getTop();
            if (r105 == 0) goto L9;
            ViewCompat.offsetLeftAndRight(r101, r105);
        L9:
            if (r106 == 0) goto L11;
            ViewCompat.offsetTopAndBottom(r101, r106);
        L11:
            if (r105 != 0) goto L13;
            if (r106 != 0) goto L13;
        L14:
            if (r102 == true) goto L16;
        L20:
            if (r102 == true) goto L23;
            r100.f205344f.post(r100.f205351m);
            goto L23
        L16:
            if (r103 != r100.f205339a.getFinalX()) goto L20;
            if (r104 != r100.f205339a.getFinalY()) goto L20;
            r100.f205339a.abortAnimation();
            r102 = false;
        L13:
            r100.f205340b.e(r101, r103, r104, r105, r106);
        L23:
            if (r100.f205350l == false) goto L25;
            ViewCompat.postOnAnimation(this.f205284a, this);
            return;
        L25:
            this.f205286c.setStateInternal(this.f205285b);
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

        public e(BottomSheetBehavior r100, View r101, int r102) {
            this.f205286c = r100;
            this.f205284a = r101;
            this.f205285b = r102;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f205287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f205288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f205289c;

        public final void a() {
            com.bytedance.dux.panel.d r100 = this.f205289c.f205268q;
            if (r100 == null) goto L27;
            boolean r101 = false;
            if (r100.f205356a != 2) goto L23;
            boolean r102 = r100.f205371p.computeScrollOffset();
            int r103 = r100.f205371p.getCurrX();
            int r110 = r100.f205371p.getCurrY();
            int r104 = r103 - r100.f205373r.getLeft();
            int r111 = r110 - r100.f205373r.getTop();
            if (r104 == 0) goto L9;
            ViewCompat.offsetLeftAndRight(r100.f205373r, r104);
        L9:
            if (r111 == 0) goto L11;
            ViewCompat.offsetTopAndBottom(r100.f205373r, r111);
        L11:
            if (r104 != 0) goto L13;
            if (r111 != 0) goto L13;
        L14:
            if (r102 == true) goto L16;
        L20:
            if (r102 == true) goto L23;
            r100.f205375t.post(r100.f205377v);
            goto L23
        L16:
            if (r103 != r100.f205371p.getFinalX()) goto L20;
            if (r110 != r100.f205371p.getFinalY()) goto L20;
            r100.f205371p.abortAnimation();
            r102 = false;
        L13:
            r100.f205372q.e(r100.f205373r, r103, r110, r104, r111);
        L23:
            if (r100.f205356a != 2) goto L25;
            r101 = true;
        L25:
            if (r101 == false) goto L27;
            ViewCompat.postOnAnimation(this.f205287a, this);
            return;
        L27:
            this.f205289c.setStateInternal(this.f205288b);
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

        public f(BottomSheetBehavior r100, View r101, int r102) {
            this.f205289c = r100;
            this.f205287a = r101;
            this.f205288b = r102;
        }
    }

    public void calculateCollapsedOffset() {
        if (this.f205252a == false) goto L5;
        this.f205262k = Math.max(this.f205273v - this.f205259h, this.f205260i);
        return;
    L5:
        this.f205262k = this.f205273v - this.f205259h;
    }

    public final int getExpandedOffset() {
        if (this.f205252a == true) goto L7;
        return 0;
    L7:
        return this.f205260i;
    }

    public BottomSheetBehavior() {
        this.f205252a = true;
        this.f205253b = false;
        this.f205254c = -1;
        this.f205264m = true;
        this.f205265n = false;
        this.f205266o = 4;
        this.f205267p = 4;
        this.A = new ArrayList();
        this.G = true;
        this.H = false;
        this.I = true;
        this.f205251J = 600;
        this.K = new b(this);
        this.L = new c(this);
    }

    public final void dispatchOnSlide(int r100) {
        V r101 = this.f205276y.get();
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.A.isEmpty() == true) goto L17;
        int r102 = 0;
        if (r100 <= this.f205262k) goto L12;
    L9:
        if (r102 >= this.A.size()) goto L18;
        d r103 = (d) ListProtector.get(this.A, r102);
        int r104 = this.f205262k;
        r103.a(r101, (r104 - r100) / (this.f205273v - r104));
        r102 = r102 + 1;
        goto L9
    L18:
        return;
    L12:
        if (r102 >= this.A.size()) goto L19;
        d r105 = (d) ListProtector.get(this.A, r102);
        int r106 = this.f205262k;
        r105.a(r101, (r106 - r100) / (r106 - getExpandedOffset()));
        r102 = r102 + 1;
        goto L12
    L19:
        return;
    }

    public final View findScrollingChild(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L9;
        return r100;
    L9:
        if ((r100 instanceof ViewGroup) == false) goto L16;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L16;
        View r104 = findScrollingChild(r101.getChildAt(r103));
        if (r104 != null) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        return r104;
    L16:
        return null;
    }

    public final void setPeekHeight(int r100) {
        boolean r101 = true;
        if (r100 != (-1)) goto L8;
        if (this.f205257f == true) goto L12;
        this.f205257f = true;
    L14:
        if (r101 == true) goto L16;
        return;
    L16:
        if (this.f205266o != 4) goto L24;
        WeakReference<V> r102 = this.f205276y;
        if (r102 == null) goto L25;
        V r103 = r102.get();
        if (r103 == null) goto L26;
        r103.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r101 = false;
        goto L14
    L8:
        if (this.f205257f == false) goto L10;
    L13:
        this.f205257f = false;
        this.f205256e = Math.max(0, r100);
        this.f205262k = this.f205273v - r100;
        goto L14
    L10:
        if (this.f205256e == r100) goto L12;
        goto L12
    }

    public final void setState(int r100) {
        if (r100 != this.f205266o) goto L5;
        return;
    L5:
        WeakReference<V> r101 = this.f205276y;
        if (r101 == null) goto L8;
        V r102 = r101.get();
        if (r102 != null) goto L22;
        return;
    L22:
        ViewParent r103 = r102.getParent();
        if (r103 != null) goto L25;
    L29:
        startSettlingAnimation(r102, r100);
        return;
    L25:
        if (r103.isLayoutRequested() == false) goto L29;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L29;
        r102.post(new a(this, r102, r100));
        return;
    L8:
        if (r100 != 4) goto L10;
    L17:
        this.f205266o = r100;
        return;
    L10:
        if (r100 == 3) goto L17;
        if (r100 == 6) goto L17;
        if (this.f205263l == true) goto L16;
        return;
    L16:
        if (r100 == 5) goto L17;
    }

    public final void setStateInternal(int r100) {
        if (this.f205266o != r100) goto L5;
        return;
    L5:
        this.f205266o = r100;
        int r101 = 0;
        if (r100 != 6) goto L8;
    L15:
        updateImportantForAccessibility(true);
    L16:
        V r102 = this.f205276y.get();
    L18:
        if (r101 >= this.A.size()) goto L20;
        ((d) ListProtector.get(this.A, r101)).b(r102, r100);
        r101 = r101 + 1;
        goto L18
    L20:
        return;
    L8:
        if (r100 == 3) goto L15;
        if (r100 != 5) goto L13;
    L14:
        updateImportantForAccessibility(false);
        goto L16
    L13:
        if (r100 != 4) goto L16;
        goto L14
    }

    public final void updateImportantForAccessibility(boolean r100) {
        WeakReference<V> r101 = this.f205276y;
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
        if (r105 >= r104) goto L27;
        View r106 = r103.getChildAt(r105);
        if (r106 == this.f205276y.get()) goto L26;
        if (r100 == true) goto L25;
        Map<View, Integer> r107 = this.F;
        if (r107 == null) goto L26;
        if (r107.containsKey(r106) == false) goto L26;
        ViewCompat.setImportantForAccessibility(r106, this.F.get(r106).intValue());
        goto L26
    L25:
        this.F.put(r106, Integer.valueOf(r106.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r106, 4);
    L26:
        r105 = r105 + 1;
        goto L15
    L27:
        if (r100 == true) goto L36;
        this.F = null;
        return;
    L36:
        return;
    L11:
        if (this.F != null) goto L13;
        this.F = new HashMap(r104);
        goto L14
    }

    public BottomSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f205252a = true;
        this.f205253b = false;
        this.f205254c = -1;
        this.f205264m = true;
        this.f205265n = false;
        this.f205266o = 4;
        this.f205267p = 4;
        this.A = new ArrayList();
        this.G = true;
        this.H = false;
        this.I = true;
        this.f205251J = 600;
        this.K = new b(this);
        this.L = new c(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        TypedValue r103 = r102.peekValue(2);
        if (r103 == null) goto L7;
        int r104 = r103.data;
        if (r104 != (-1)) goto L7;
        setPeekHeight(r104);
    L8:
        this.f205263l = r102.getBoolean(1, false);
        boolean r105 = r102.getBoolean(0, true);
        if (this.f205252a == r105) goto L21;
        this.f205252a = r105;
        if (this.f205276y == null) goto L15;
        calculateCollapsedOffset();
    L15:
        if (this.f205252a == true) goto L17;
    L19:
        int r106 = this.f205266o;
    L20:
        setStateInternal(r106);
        goto L21
    L17:
        if (this.f205266o != 6) goto L19;
        r106 = 3;
    L21:
        this.f205265n = r102.getBoolean(3, false);
        r102.recycle();
        this.f205255d = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1));
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        return new SavedState(super.onSaveInstanceState(r100, r101), this.f205266o);
    }

    public final boolean shouldHide(View r100, float r101) {
        if (this.f205265n == false) goto L6;
        return true;
    L6:
        if (r101 != 0.0f) goto L18;
        if (this.f205253b == false) goto L14;
        if (r100.getTop() <= (this.f205262k + (this.f205259h / 2))) goto L12;
        return true;
    L12:
        return false;
    L14:
        if (r100.getTop() <= (((this.f205273v - getExpandedOffset()) / 2) + getExpandedOffset())) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (this.f205267p != 4) goto L27;
        if (this.f205256e <= (g.d(r100.getContext()) / 2)) goto L27;
        if (r101 > (this.f205255d * 0.08f)) goto L31;
        return false;
    L31:
        return true;
    L27:
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.f205262k) / this.f205256e) > 0.5f) goto L32;
        return false;
    L32:
        return true;
    }

    public final void startSettlingAnimation(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.f205262k;
    L19:
        com.bytedance.dux.panel.d r103 = this.f205268q;
        int r104 = r100.getLeft();
        r103.f205373r = r100;
        r103.f205358c = -1;
        boolean r105 = r103.h(r104, r102, 0, 0);
        if (r105 == false) goto L22;
    L26:
        if (r105 == false) goto L28;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new f(this, r100, r101));
        return;
    L28:
        setStateInternal(r101);
        return;
    L22:
        if (r103.f205356a != 0) goto L26;
        if (r103.f205373r == null) goto L26;
        r103.f205373r = null;
        goto L26
    L6:
        if (r101 != 6) goto L12;
        r102 = this.f205261j;
        if (this.f205252a == false) goto L19;
        int r106 = this.f205260i;
        if (r102 > r106) goto L19;
        r102 = r106;
        r101 = 3;
        goto L19
    L12:
        if (r101 != 3) goto L15;
        r102 = getExpandedOffset();
        goto L19
    L15:
        if (this.f205263l == false) goto L31;
        if (r101 != 5) goto L31;
        r102 = this.f205273v;
    L31:
        throw new IllegalArgumentException("Illegal state argument: " + r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r110, V r210, MotionEvent r211) {
        int r100 = 1;
        if (r210.isShown() == true) goto L5;
    L170:
        this.f205270s = true;
        return false;
    L5:
        if (this.f205264m == false) goto L170;
        int r101 = r211.getActionMasked();
        if (r101 != 0) goto L13;
        this.C = -1;
        VelocityTracker r102 = this.B;
        if (r102 == null) goto L13;
        r102.recycle();
        this.B = null;
    L13:
        if (this.B != null) goto L15;
        this.B = VelocityTracker.obtain();
    L15:
        this.B.addMovement(r211);
        if (r101 == 0) goto L24;
        if (r101 == 1) goto L20;
        if (r101 == 3) goto L20;
    L40:
        if (this.H == false) goto L69;
        if (this.f205270s == true) goto L69;
        com.bytedance.dux.panel.a r111 = this.f205269r;
        if (r111 == null) goto L69;
        r111.f205347i = (int) r211.getX();
        r111.f205348j = false;
        int r112 = r211.getActionMasked();
        if (r112 != 0) goto L48;
        r111.f205345g = (int) r211.getX();
        r111.f205346h = (int) r211.getY();
    L48:
        int r113 = ((int) r211.getX()) - r111.f205345g;
        int r114 = ((int) r211.getY()) - r111.f205346h;
        if (r112 != 2) goto L60;
        float r115 = r113;
        float r116 = r114;
        if (Math.abs(r115) > r111.f205343e) goto L53;
    L55:
        boolean r103 = false;
    L56:
        if (r103 == false) goto L60;
        if (r111.b(r210) != null) goto L60;
        boolean r104 = true;
    L61:
        if (r104 == false) goto L66;
        if (r113 <= 0) goto L64;
        int r105 = 1;
    L65:
        r111.f205349k = r105;
        r111.f205340b.d(1);
        r111.f205348j = true;
        goto L66
    L64:
        r105 = -1;
    L66:
        if (r104 == false) goto L69;
        return true;
    L53:
        if ((Math.abs(r115) * 0.5f) <= Math.abs(r116)) goto L55;
        r103 = true;
    L60:
        r104 = false;
    L69:
        if (this.f205270s == true) goto L150;
        com.bytedance.dux.panel.d r106 = this.f205268q;
        if (r106 == null) goto L150;
        int r107 = r211.getActionMasked();
        int r117 = r211.getActionIndex();
        if (r107 != 0) goto L76;
        r106.a();
    L76:
        if (r106.f205367l != null) goto L78;
        r106.f205367l = VelocityTracker.obtain();
    L78:
        r106.f205367l.addMovement(r211);
        if (r107 == 0) goto L136;
        if (r107 == 1) goto L135;
        if (r107 == 2) goto L99;
        if (r107 == 3) goto L135;
        if (r107 != 5) goto L86;
        int r108 = r211.getPointerId(r117);
        float r109 = r211.getX(r117);
        float r118 = r211.getY(r117);
        r106.k(r109, r118, r108);
        int r119 = r106.f205356a;
        if (r119 == 0) goto L92;
        if (r119 != 2) goto L145;
        View r120 = r106.g((int) r109, (int) r118);
        if (r120 != r106.f205373r) goto L145;
        r106.n(r120, r108);
    L145:
        if (r106.f205356a != 1) goto L147;
        boolean r121 = true;
    L148:
        if (r121 == false) goto L150;
        return true;
    L147:
        r121 = false;
        goto L148
    L92:
        if ((r106.f205363h[r108] & 0) == 0) goto L145;
        r106.f205372q.getClass();
        goto L145
    L86:
        if (r107 != 6) goto L145;
        r106.e(r211.getPointerId(r117));
        goto L145
    L99:
        if (r106.f205359d == null) goto L145;
        if (r106.f205360e == null) goto L145;
        int r122 = r211.getPointerCount();
        int r123 = 0;
    L104:
        if (r123 >= r122) goto L134;
        int r124 = r211.getPointerId(r123);
        if ((r106.f205366k & (r100 << r124)) == 0) goto L108;
        boolean r125 = true;
    L109:
        if (r125 == true) goto L111;
        boolean r126 = false;
    L112:
        if (r126 == false) goto L133;
        float r127 = r211.getX(r123);
        float r128 = r211.getY(r123);
        float r129 = r127 - r106.f205359d[r124];
        float r130 = r128 - r106.f205360e[r124];
        View r131 = r106.g((int) r127, (int) r128);
        if (r131 != null) goto L117;
    L119:
        boolean r132 = false;
    L120:
        if (r132 == false) goto L126;
        int r133 = (int) r129;
        r106.f205372q.a(r131, r131.getLeft() + r133, r133);
        int r134 = r131.getTop();
        int r135 = (int) r130;
        int r136 = r106.f205372q.b(r131, r134 + r135, r135);
        r106.f205372q.getClass();
        int r137 = r106.f205372q.c(r131);
        if (r137 == 0) goto L134;
        if (r137 <= 0) goto L126;
        if (r136 == r134) goto L134;
    L126:
        r106.j(r129, r130, r124);
        if (r106.f205356a == 1) goto L134;
        if (r132 == false) goto L133;
        if (r106.n(r131, r124) == false) goto L133;
    L117:
        if (r106.d(r131, r130) == false) goto L119;
        r132 = true;
    L133:
        r123 = r123 + 1;
        r100 = 1;
        goto L104
    L111:
        r126 = true;
        goto L112
    L108:
        r125 = false;
    L134:
        r106.l(r211);
    L135:
        r106.a();
        goto L145
    L136:
        float r138 = r211.getX();
        float r139 = r211.getY();
        int r140 = r211.getPointerId(0);
        r106.k(r138, r139, r140);
        View r141 = r106.g((int) r138, (int) r139);
        if (r141 != r106.f205373r) goto L142;
        if (r106.f205356a != 2) goto L142;
        r106.n(r141, r140);
    L142:
        if ((r106.f205363h[r140] & 0) == 0) goto L145;
        r106.f205372q.getClass();
    L150:
        WeakReference<View> r142 = this.f205277z;
        if (r142 == null) goto L153;
        View r143 = r142.get();
        int r144 = 2;
    L154:
        if (r101 != r144) goto L168;
        if (r143 == null) goto L168;
        if (this.f205270s == true) goto L168;
        if (this.f205266o == 1) goto L168;
        if (r110.isPointInChildBounds(r143, (int) r211.getX(), (int) r211.getY()) == true) goto L168;
        if (this.f205268q == null) goto L168;
        if (Math.abs(this.D - r211.getY()) <= this.f205268q.f205357b) goto L168;
        return true;
    L168:
        return false;
    L153:
        r144 = 2;
        r143 = null;
    L20:
        this.E = false;
        this.C = -1;
        if (this.f205270s == false) goto L40;
        this.f205270s = false;
        return false;
    L24:
        int r145 = (int) r211.getX();
        this.D = (int) r211.getY();
        WeakReference<View> r146 = this.f205277z;
        if (r146 == null) goto L27;
        View r147 = r146.get();
    L28:
        if (r147 == null) goto L33;
        if (r110.isPointInChildBounds(r147, r145, this.D) == false) goto L33;
        this.C = r211.getPointerId(r211.getActionIndex());
        this.E = true;
    L33:
        if (this.C == (-1)) goto L35;
    L37:
        boolean r148 = false;
    L38:
        this.f205270s = r148;
        goto L40
    L35:
        if (r110.isPointInChildBounds(r210, r145, this.D) == true) goto L37;
        r148 = true;
        goto L38
    L27:
        r147 = null;
        goto L28
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r100, V r110, int r111) {
        if (this.G == true) goto L5;
    L9:
        int r101 = r110.getTop();
        r100.onLayoutChild(r110, r111);
        this.f205273v = r100.getHeight();
        this.f205274w = r110.getHeight();
        this.f205275x = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r110.getLayoutParams())).bottomMargin;
        if (this.f205257f == true) goto L12;
        this.f205259h = this.f205256e;
    L25:
        if (this.f205254c <= 0) goto L29;
        int r112 = r110.getHeight();
        int r102 = this.f205254c;
        if (r112 <= r102) goto L29;
        this.f205260i = Math.max(0, this.f205273v - r102);
    L30:
        this.f205261j = this.f205273v / 2;
        calculateCollapsedOffset();
        int r113 = this.f205266o;
        if (r113 != 3) goto L34;
        ViewCompat.offsetTopAndBottom(r110, getExpandedOffset());
    L48:
        if (this.f205268q != null) goto L51;
        com.bytedance.dux.panel.d r103 = new com.bytedance.dux.panel.d(r100.getContext(), r100, this.K);
        this.f205268q = r103;
        r103.f205376u = this.f205251J;
    L51:
        if (this.H == true) goto L53;
    L55:
        this.f205276y = new WeakReference(r110);
        this.f205277z = new WeakReference(findScrollingChild(r110));
        return true;
    L53:
        if (this.f205269r != null) goto L55;
        this.f205269r = new com.bytedance.dux.panel.a(r100.getContext(), r100, this.L);
        goto L55
    L34:
        if (r113 != 6) goto L37;
        ViewCompat.offsetTopAndBottom(r110, this.f205261j);
        goto L48
    L37:
        if (this.f205263l == false) goto L42;
        if (r113 != 5) goto L42;
        ViewCompat.offsetTopAndBottom(r110, this.f205273v);
    L42:
        if (r113 != 4) goto L44;
        ViewCompat.offsetTopAndBottom(r110, this.f205262k);
        goto L48
    L44:
        if (r113 == 1) goto L46;
        if (r113 != 2) goto L48;
    L46:
        ViewCompat.offsetTopAndBottom(r110, r101 - r110.getTop());
    L29:
        this.f205260i = Math.max(0, this.f205273v - r110.getHeight());
        goto L30
    L12:
        if (this.f205258g != 0) goto L14;
        this.f205258g = r100.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L14:
        float r114 = r100.getContext().getResources().getConfiguration().fontScale;
        em4.e.a("check fontScale:" + r114);
        if (this.I == false) goto L17;
        double r104 = 0.6d;
    L18:
        double r105 = this.f205258g;
        int r106 = this.f205254c;
        if (r106 <= 0) goto L21;
        double r107 = r106;
    L22:
        this.f205259h = (int) Math.max(r105, r107);
        goto L25
    L21:
        r107 = ((double) r114) * (((double) this.f205273v) * r104);
        goto L22
    L17:
        r104 = 1.0d;
        goto L18
    L5:
        if (ViewCompat.getFitsSystemWindows(r100) == false) goto L9;
        if (ViewCompat.getFitsSystemWindows(r110) == true) goto L9;
        r110.setFitsSystemWindows(true);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        SavedState r103 = (SavedState) r102;
        super.onRestoreInstanceState(r100, r101, r103.getSuperState());
        int r104 = r103.f205278a;
        if (r104 != 1) goto L5;
    L8:
        this.f205266o = 4;
        return;
    L5:
        if (r104 == 2) goto L8;
        this.f205266o = r104;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r210, V r211, MotionEvent r212) {
        int r100 = 0;
        if (r211.isShown() == true) goto L5;
        return false;
    L5:
        int r110 = r212.getActionMasked();
        if (this.f205266o != 1) goto L10;
        if (r110 != 0) goto L10;
        return true;
    L10:
        if (r110 != 0) goto L15;
        this.C = -1;
        VelocityTracker r101 = this.B;
        if (r101 == null) goto L15;
        r101.recycle();
        this.B = null;
    L15:
        if (this.B != null) goto L17;
        this.B = VelocityTracker.obtain();
    L17:
        this.B.addMovement(r212);
        if (this.H == false) goto L51;
        com.bytedance.dux.panel.a r111 = this.f205269r;
        if (r111 == null) goto L51;
        if (r111.f205348j == false) goto L51;
        int r102 = this.f205266o;
        VelocityTracker r103 = this.B;
        int r104 = r212.getActionMasked();
        if (r104 != 2) goto L32;
        int r105 = (int) r212.getX();
        int r106 = r105 - r111.f205347i;
        r111.f205347i = r105;
        float r107 = (r106 * (r211.getHeight() / r211.getWidth())) * 1.2f;
        int r108 = r211.getLeft();
        int r109 = (int) r107;
        int r112 = r211.getTop() + r109;
        int r113 = r211.getLeft();
        int r114 = r211.getTop();
        if (r109 == 0) goto L28;
        r112 = r111.f205340b.b(r211, r112, r109);
        ViewCompat.offsetTopAndBottom(r211, r112 - r114);
    L28:
        int r115 = r112;
        if (r109 == 0) goto L32;
        r111.f205340b.e(r211, r108, r115, r108 - r113, r115 - r114);
    L32:
        if (r104 != 1) goto L46;
        if (r102 != 1) goto L46;
        r103.computeCurrentVelocity(1000, r111.f205341c);
        r103.computeCurrentVelocity(1000, r111.f205341c);
        float r116 = r103.getXVelocity(0);
        float r117 = r111.f205342d;
        float r118 = r111.f205341c;
        float r119 = Math.abs(r116);
        if (r119 >= r117) goto L38;
        float r120 = 0.0f;
        float r121 = 0.0f;
    L44:
        r118 = r121;
    L45:
        r111.f205340b.f(r211, r120, r118);
    L48:
        if (r104 != 3) goto L166;
        if (r102 != 1) goto L166;
        r111.f205340b.f(r211, r120, r120);
    L166:
        if (this.H == false) goto L175;
        com.bytedance.dux.panel.a r122 = this.f205269r;
        if (r122 == null) goto L175;
        if (r122.f205348j == false) goto L175;
        boolean r123 = this.f205270s;
    L173:
        return !r123;
    L175:
        if (r110 == 2) goto L177;
    L181:
        r123 = this.f205270s;
        goto L173
    L177:
        if (this.f205270s == true) goto L181;
        float r124 = Math.abs(this.D - r212.getY());
        com.bytedance.dux.panel.d r125 = this.f205268q;
        if (r124 <= r125.f205357b) goto L181;
        r125.b(r211, r212.getPointerId(r212.getActionIndex()));
        goto L181
    L38:
        if (r119 <= r118) goto L43;
        r120 = 0.0f;
        if (r116 > 0.0f) goto L45;
        r118 = -r118;
        goto L45
    L43:
        r120 = 0.0f;
        r121 = r116;
    L46:
        r120 = 0.0f;
    L51:
        com.bytedance.dux.panel.d r126 = this.f205268q;
        if (r126 == null) goto L166;
        int r127 = r212.getActionMasked();
        int r128 = r212.getActionIndex();
        if (r127 != 0) goto L57;
        r126.a();
    L57:
        if (r126.f205367l != null) goto L59;
        r126.f205367l = VelocityTracker.obtain();
    L59:
        r126.f205367l.addMovement(r212);
        if (r127 == 0) goto L162;
        if (r127 == 1) goto L159;
        if (r127 == 2) goto L116;
        if (r127 == 3) goto L110;
        if (r127 != 5) goto L69;
        int r129 = r212.getPointerId(r128);
        float r130 = r212.getX(r128);
        float r131 = r212.getY(r128);
        r126.k(r130, r131, r129);
        if (r126.f205356a != 0) goto L95;
        r126.n(r126.g((int) r130, (int) r131), r129);
        if ((r126.f205363h[r129] & 0) == 0) goto L166;
        r126.f205372q.getClass();
        goto L166
    L95:
        int r132 = (int) r130;
        int r133 = (int) r131;
        View r134 = r126.f205373r;
        if (r134 != null) goto L99;
    L107:
        if (r100 == 0) goto L166;
        r126.n(r126.f205373r, r129);
        goto L166
    L99:
        if (r132 < r134.getLeft()) goto L107;
        if (r132 >= r134.getRight()) goto L107;
        if (r133 < r134.getTop()) goto L107;
        if (r133 >= r134.getBottom()) goto L107;
        r100 = 1;
        goto L107
    L69:
        if (r127 != 6) goto L166;
        int r135 = r212.getPointerId(r128);
        if (r126.f205356a == 1) goto L74;
    L89:
        r126.e(r135);
        goto L166
    L74:
        if (r135 != r126.f205358c) goto L89;
        int r136 = r212.getPointerCount();
    L76:
        if (r100 >= r136) goto L86;
        int r137 = r212.getPointerId(r100);
        if (r137 == r126.f205358c) goto L85;
        View r138 = r126.g((int) r212.getX(r100), (int) r212.getY(r100));
        View r139 = r126.f205373r;
        if (r138 != r139) goto L85;
        if (r126.n(r139, r137) == false) goto L85;
        int r140 = r126.f205358c;
    L87:
        if (r140 != (-1)) goto L89;
        r126.i();
    L85:
        r100 = r100 + 1;
        goto L76
    L86:
        r140 = -1;
        goto L87
    L110:
        if (r126.f205356a != 1) goto L114;
        r126.f205374s = true;
        r126.f205372q.f(r126.f205373r, 0.0f, 0.0f);
        r126.f205374s = false;
        if (r126.f205356a != 1) goto L114;
        r126.m(0);
    L114:
        r126.a();
        goto L166
    L116:
        if (r126.f205356a != 1) goto L137;
        int r141 = r126.f205358c;
        if ((r126.f205366k & (1 << r141)) == 0) goto L120;
        boolean r142 = true;
    L121:
        if (r142 == false) goto L124;
        r100 = 1;
    L124:
        if (r100 == 0) goto L166;
        int r143 = r212.findPointerIndex(r141);
        float r144 = r212.getX(r143);
        float r145 = r212.getY(r143);
        float[] r146 = r126.f205361f;
        int r147 = r126.f205358c;
        int r148 = (int) (r144 - r146[r147]);
        int r149 = (int) (r145 - r126.f205362g[r147]);
        int r150 = r126.f205373r.getLeft() + r148;
        int r151 = r126.f205373r.getTop() + r149;
        int r152 = r126.f205373r.getLeft();
        int r153 = r126.f205373r.getTop();
        if (r148 == 0) goto L129;
        r150 = r126.f205372q.a(r126.f205373r, r150, r148);
        ViewCompat.offsetLeftAndRight(r126.f205373r, r150 - r152);
    L129:
        int r154 = r150;
        if (r149 == 0) goto L132;
        r151 = r126.f205372q.b(r126.f205373r, r151, r149);
        ViewCompat.offsetTopAndBottom(r126.f205373r, r151 - r153);
    L132:
        int r155 = r151;
        if (r148 != 0) goto L135;
        if (r149 != 0) goto L135;
    L136:
        r126.l(r212);
    L135:
        r126.f205372q.e(r126.f205373r, r154, r155, r154 - r152, r155 - r153);
        goto L136
    L120:
        r142 = false;
        goto L121
    L137:
        int r156 = r212.getPointerCount();
        int r157 = 0;
    L138:
        if (r157 >= r156) goto L157;
        int r158 = r212.getPointerId(r157);
        if ((r126.f205366k & (1 << r158)) == 0) goto L142;
        boolean r159 = true;
    L143:
        if (r159 == true) goto L145;
        boolean r160 = false;
    L146:
        if (r160 == false) goto L156;
        float r161 = r212.getX(r157);
        float r162 = r212.getY(r157);
        float r163 = r161 - r126.f205359d[r158];
        float r164 = r162 - r126.f205360e[r158];
        r126.j(r163, r164, r158);
        if (r126.f205356a == 1) goto L157;
        View r165 = r126.g((int) r161, (int) r162);
        if (r126.d(r165, r164) == false) goto L156;
        if (r126.n(r165, r158) == true) goto L157;
    L156:
        r157 = r157 + 1;
        goto L138
    L145:
        r160 = true;
        goto L146
    L142:
        r159 = false;
    L157:
        r126.l(r212);
        goto L166
    L159:
        if (r126.f205356a != 1) goto L161;
        r126.i();
    L161:
        r126.a();
        goto L166
    L162:
        float r166 = r212.getX();
        float r167 = r212.getY();
        int r168 = r212.getPointerId(0);
        View r169 = r126.g((int) r166, (int) r167);
        r126.k(r166, r167, r168);
        r126.n(r169, r168);
        if ((r126.f205363h[r168] & 0) == 0) goto L166;
        r126.f205372q.getClass();
        goto L166
    }

    public static int[] a(BottomSheetBehavior r100, View r101, float r102, float r103) {
        int r104 = 3;
        if (r103 >= 0.0f) goto L14;
        r100.getClass();
        if (Math.abs(r103) <= 1500.0f) goto L14;
        if (r100.f205252a == false) goto L9;
        int r105 = r100.f205260i;
    L46:
        return new int[]{r105, r104};
    L9:
        int r106 = r101.getTop();
        r105 = r100.f205261j;
        if (r106 <= r105) goto L12;
    L11:
        r104 = 6;
    L12:
        r105 = 0;
    L14:
        if (r100.f205263l == false) goto L23;
        if (r100.shouldHide(r101, r103) == false) goto L23;
        if (r101.getTop() <= r100.f205262k) goto L20;
    L21:
        r105 = r100.f205273v;
        r104 = 5;
        goto L46
    L20:
        if (Math.abs(r102) < Math.abs(r103)) goto L21;
    L23:
        if (r103 != 0.0f) goto L25;
    L29:
        int r107 = r101.getTop();
        if (r100.f205252a == true) goto L32;
        int r108 = r100.f205261j;
        if (r107 >= r108) goto L42;
        if (r107 < Math.abs(r107 - r100.f205262k)) goto L12;
        r105 = r100.f205261j;
        goto L11
    L42:
        if (Math.abs(r107 - r108) >= Math.abs(r107 - r100.f205262k)) goto L44;
        r105 = r100.f205261j;
        goto L11
    L44:
        r105 = r100.f205262k;
    L28:
        r104 = 4;
        goto L46
    L32:
        if (Math.abs(r107 - r100.f205260i) >= Math.abs(r107 - r100.f205262k)) goto L34;
        r105 = r100.f205260i;
        goto L46
    L34:
        r105 = r100.f205262k;
        goto L28
    L25:
        if (Math.abs(r102) > Math.abs(r103)) goto L29;
        r105 = r100.f205262k;
        goto L28
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        int r104 = 3;
        if (r101.getTop() != getExpandedOffset()) goto L9;
        if (this.f205266o == 2) goto L58;
        setStateInternal(3);
        return;
    L58:
        return;
    L9:
        if (r102 == this.f205277z.get()) goto L11;
        return;
    L11:
        if (this.f205272u == true) goto L14;
        return;
    L14:
        if (this.f205271t <= 0) goto L17;
        int r105 = getExpandedOffset();
    L46:
        this.f205267p = r104;
        com.bytedance.dux.panel.d r106 = this.f205268q;
        int r107 = r101.getLeft();
        r106.f205373r = r101;
        r106.f205358c = -1;
        boolean r108 = r106.h(r107, r105, 0, 0);
        if (r108 == false) goto L49;
    L53:
        if (r108 == false) goto L55;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r101, new f(this, r101, r104));
    L56:
        this.f205272u = false;
        return;
    L55:
        setStateInternal(r104);
        goto L56
    L49:
        if (r106.f205356a != 0) goto L53;
        if (r106.f205373r == null) goto L53;
        r106.f205373r = null;
        goto L53
    L17:
        if (this.f205263l == false) goto L26;
        VelocityTracker r109 = this.B;
        if (r109 != null) goto L21;
        float r110 = 0.0f;
    L23:
        if (shouldHide(r101, r110) == false) goto L26;
        r105 = this.f205273v;
        r104 = 5;
        goto L46
    L21:
        r109.computeCurrentVelocity(1000, this.f205255d);
        r110 = this.B.getYVelocity(this.C);
    L26:
        if (this.f205271t != 0) goto L44;
        int r111 = r101.getTop();
        if (this.f205252a == true) goto L30;
        int r112 = this.f205261j;
        if (r111 >= r112) goto L40;
        if (r111 >= Math.abs(r111 - this.f205262k)) goto L38;
        r105 = 0;
        goto L46
    L38:
        r105 = this.f205261j;
    L42:
        r104 = 6;
        goto L46
    L40:
        if (Math.abs(r111 - r112) >= Math.abs(r111 - this.f205262k)) goto L43;
        r105 = this.f205261j;
        goto L42
    L43:
        r105 = this.f205262k;
    L45:
        r104 = 4;
        goto L46
    L30:
        if (Math.abs(r111 - this.f205260i) >= Math.abs(r111 - this.f205262k)) goto L32;
        r105 = this.f205260i;
        goto L46
    L32:
        r105 = this.f205262k;
        goto L45
    L44:
        r105 = this.f205262k;
        goto L45
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        if (r102 == this.f205277z.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.f205266o == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        this.f205271t = 0;
        this.f205272u = false;
        if ((r104 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
        if (r106 != 1) goto L6;
        return;
    L6:
        if (r102 == this.f205277z.get()) goto L8;
        return;
    L8:
        int r107 = r101.getTop();
        int r108 = r107 - r104;
        if (r104 > 0) goto L11;
        if (r104 < 0) goto L19;
    L30:
        dispatchOnSlide(r101.getTop());
        this.f205271t = r104;
        this.f205272u = true;
        return;
    L19:
        if (r102.canScrollVertically(-1) == true) goto L30;
        int r109 = this.f205262k;
        if (r108 <= r109) goto L27;
        if (this.f205263l == true) goto L27;
        int r110 = r107 - r109;
        r105[1] = r110;
        ViewCompat.offsetTopAndBottom(r101, -r110);
        setStateInternal(4);
    L27:
        if (this.f205264m == true) goto L29;
        return;
    L29:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L30
    L11:
        if (r108 >= getExpandedOffset()) goto L14;
        int r111 = r107 - getExpandedOffset();
        r105[1] = r111;
        ViewCompat.offsetTopAndBottom(r101, -r111);
        setStateInternal(3);
        goto L30
    L14:
        if (this.f205264m == true) goto L16;
        return;
    L16:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L30
    }
}
