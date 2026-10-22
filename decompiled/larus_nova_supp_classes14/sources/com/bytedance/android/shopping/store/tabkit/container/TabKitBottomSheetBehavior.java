package com.bytedance.android.shopping.store.tabkit.container;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004\u000b\f\r\u000eB\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitBottomSheetBehavior;", "Landroid/view/View;", "V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "Companion", "SavedState", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final /* synthetic */ int H = 0;
    public int A;
    public int B;
    public VelocityTracker C;
    public boolean D;
    public final Set<a> E;
    public boolean F;
    public final TabKitBottomSheetBehavior$dragCallback$1 G;
    public int a;
    public boolean b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public WeakReference<View> s;
    public ViewDragHelper t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitBottomSheetBehavior$Companion$State;", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface State {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitBottomSheetBehavior$SavedState;", "Landroid/view/AbsSavedState;", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public final int a;
        public final int b;

        public static final class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "source");
                return new SavedState(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r1) {
                return new SavedState[r1];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r2, ClassLoader r3) {
                Intrinsics.checkNotNullParameter(r2, "source");
                Intrinsics.checkNotNullParameter(r3, "loader");
                return new SavedState(r2);
            }
        }

        public static final class b {
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super(r2);
            this.a = r2.readInt();
            this.b = r2.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "dest");
            super.writeToParcel(r2, r3);
            r2.writeInt(this.a);
            r2.writeInt(this.b);
        }

        public SavedState(Parcelable r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "superState");
            super(r2);
            this.a = r3;
            this.b = r4;
        }
    }

    public interface a {
        void a(View r1, int r2);

        void b(View r1, float r2);

        void c(View r1, float r2, int r3, int r4, int r5);
    }

    public final class b implements Runnable {
        public final View a;
        public final int b;
        public final /* synthetic */ TabKitBottomSheetBehavior c;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (TabKitBottomSheetBehavior.a(this.c).continueSettling(true) == false) goto L5;
            this.a.postOnAnimation(this);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            this.c.setStateInternal(this.b);     // Catch: Throwable -> L7
            goto L12
        }

        public b(TabKitBottomSheetBehavior r2, View r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ TabKitBottomSheetBehavior b;
        public final /* synthetic */ int c;

        public c(View r1, TabKitBottomSheetBehavior r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TabKitBottomSheetBehavior r0 = this.b;     // Catch: Throwable -> L4
            View r1 = this.a;     // Catch: Throwable -> L4
            int r2 = this.c;     // Catch: Throwable -> L4
            int r3 = TabKitBottomSheetBehavior.H;     // Catch: Throwable -> L4
            r0.startSettlingAnimation(r1, r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior$onLayoutChild$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C01981 extends MutablePropertyReference0Impl {
        public C01981(TabKitBottomSheetBehavior r7) {
            super(r7, TabKitBottomSheetBehavior.class, "dragHelper", "getDragHelper()Landroidx/customview/widget/ViewDragHelper;", 0);
        }

        public Object get() {
            return TabKitBottomSheetBehavior.a((TabKitBottomSheetBehavior) ((CallableReference) this).receiver);
        }

        public void set(Object r2) {
            ViewDragHelper r3 = (ViewDragHelper) r2;
            ((TabKitBottomSheetBehavior) ((CallableReference) this).receiver).t = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior$onTouchEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C01991 extends MutablePropertyReference0Impl {
        public C01991(TabKitBottomSheetBehavior r7) {
            super(r7, TabKitBottomSheetBehavior.class, "dragHelper", "getDragHelper()Landroidx/customview/widget/ViewDragHelper;", 0);
        }

        public Object get() {
            return TabKitBottomSheetBehavior.a((TabKitBottomSheetBehavior) ((CallableReference) this).receiver);
        }

        public void set(Object r2) {
            ViewDragHelper r3 = (ViewDragHelper) r2;
            ((TabKitBottomSheetBehavior) ((CallableReference) this).receiver).t = r3;
        }
    }

    static {
    }

    public final int getExpandedOffset() {
        if (this.b == true) goto L7;
        return 0;
    L7:
        return this.p;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior$dragCallback$1] */
    public TabKitBottomSheetBehavior() {
        this.a = 4;
        this.b = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.y = -1;
        this.z = true;
        this.E = new LinkedHashSet();
        this.G = new TabKitBottomSheetBehavior$dragCallback$1(this);
    }

    public static final /* synthetic */ ViewDragHelper a(TabKitBottomSheetBehavior r1) {
        ViewDragHelper r2 = r1.t;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L5:
        return r2;
    }

    public final void setHideable(boolean r2) {
        if (this.d == r2) goto L10;
        this.d = r2;
        if (r2 == false) goto L7;
        return;
    L7:
        if (this.a != 5) goto L12;
        setState(4);
        return;
    L12:
        return;
    }

    public final void setPeekHeight(int r4) {
        boolean r1 = true;
        if (r4 != (-1)) goto L8;
        if (this.l == true) goto L12;
        this.l = true;
    L14:
        if (r1 == false) goto L25;
        int r5 = this.a;
        if (r5 != 4) goto L18;
    L19:
        WeakReference<View> r6 = this.s;
        if (r6 == null) goto L27;
        View r7 = r6.get();
        if (r7 == null) goto L28;
        r7.requestLayout();
        return;
    L28:
        return;
    L27:
        return;
    L18:
        if (r5 == 5) goto L19;
        return;
    L25:
        return;
    L12:
        r1 = false;
        goto L14
    L8:
        if (this.l == false) goto L10;
    L13:
        this.l = false;
        this.c = Math.max(0, r4);
        this.r = this.o - r4;
        goto L14
    L10:
        if (this.c == r4) goto L12;
        goto L12
    }

    public final void setState(int r4) {
        if (this.a != r4) goto L5;
        return;
    L5:
        WeakReference<View> r0 = this.s;
        if (r0 != null) goto L19;
        this.F = true;
        if (r4 != 4) goto L10;
    L17:
        this.a = r4;
        return;
    L10:
        if (r4 == 3) goto L17;
        if (r4 == 6) goto L17;
        if (this.d == true) goto L16;
        return;
    L16:
        if (r4 == 5) goto L17;
        return;
    L19:
        this.F = false;
        if (r0 == null) goto L34;
        View r1 = r0.get();
        if (r1 == null) goto L35;
        this.i = true;
        if (r1.getParent() != null) goto L26;
    L30:
        startSettlingAnimation(r1, r4);
        return;
    L26:
        if (r1.getParent().isLayoutRequested() == false) goto L30;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L30;
        r1.post(new c(r1, this, r4));
        return;
    L35:
        return;
    }

    public final void setStateInternal(int r4) {
        if (r4 != 4) goto L8;
        if (this.g == true) goto L8;
        r4 = 3;
    L8:
        if (this.a == r4) goto L17;
        this.a = r4;
        WeakReference<View> r0 = this.s;
        if (r0 == null) goto L19;
        View r1 = r0.get();
        if (r1 == null) goto L20;
        Iterator<T> r2 = this.E.iterator();
    L15:
        if (r2.hasNext() == false) goto L21;
        ((a) r2.next()).a(r1, r4);
        goto L15
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior$dragCallback$1] */
    public TabKitBottomSheetBehavior(final Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        this.a = 4;
        this.b = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.y = -1;
        this.z = true;
        this.E = new LinkedHashSet();
        this.G = new TabKitBottomSheetBehavior$dragCallback$1(this);
        TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{2130968990, 2130968991, 2130968993, 2130968994});
        TypedValue r3 = r7.peekValue(2);
        if (r3 == null) goto L7;
        int r4 = r3.data;
        if (r4 != (-1)) goto L7;
    L8:
        setPeekHeight(r4);
        setHideable(r7.getBoolean(1, false));
        boolean r1 = r7.getBoolean(0, true);
        if (this.b == r1) goto L23;
        this.b = r1;
        if (this.s == null) goto L17;
        if (r1 == false) goto L14;
        int r2 = Math.max(this.o - this.n, this.p);
    L15:
        this.r = r2;
        goto L17
    L14:
        r2 = this.o - this.n;
    L17:
        if (this.b == true) goto L19;
    L21:
        int r8 = this.a;
    L22:
        setStateInternal(r8);
        goto L23
    L19:
        if (this.a != 6) goto L21;
        r8 = 3;
    L23:
        this.j = r7.getBoolean(3, false);
        r7.recycle();
        Handler r9 = CommonUtils.a;
        CommonUtils.c(false, new AnonymousClass1(this, r5));
        return;
    L7:
        r4 = r7.getDimensionPixelSize(2, -1);
        goto L8
    }

    public final void b(int r10, int r11) {
        WeakReference<View> r0 = this.s;
        if (r0 == null) goto L17;
        View r1 = r0.get();
        if (r1 == null) goto L24;
        int r2 = this.r;
        if (r10 <= r2) goto L9;
        int r3 = this.o - r2;
    L10:
        int r7 = r3;
        Iterator<T> r8 = this.E.iterator();
    L12:
        if (r8.hasNext() == false) goto L25;
        a r4 = (a) r8.next();
        if (r7 == 0) goto L15;
        float r5 = r7;
        r4.b(r1, (this.r - r10) / r5);
        int r6 = this.r - r10;
        r4.c(r1, r6 / r5, r6, r11, this.a);
        goto L12
    L15:
        r4.b(r1, 0.0f);
        r4.c(r1, 0.0f, this.r - r10, r11, this.a);
        goto L12
    L25:
        return;
    L9:
        r3 = r2 - getExpandedOffset();
        goto L10
    L24:
        return;
    }

    public final Parcelable onSaveInstanceState(CoordinatorLayout r3, V r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "child");
        Parcelable r5 = super.onSaveInstanceState(r3, r4);
        if (r5 != null) goto L5;
        r5 = Bundle.EMPTY;
    L5:
        int r6 = this.a;
        if (this.l == false) goto L8;
        int r1 = -1;
    L10:
        return new SavedState(r5, r6, r1);
    L8:
        r1 = this.c;
        goto L10
    }

    public final void startSettlingAnimation(View r4, int r5) {
        if (r5 != 4) goto L6;
        int r0 = this.r;
    L21:
        ViewDragHelper r1 = this.t;
        if (r1 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L25:
        if (r1.smoothSlideViewTo(r4, r4.getLeft(), r0) == false) goto L27;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r4, new b(this, r4, r5));
        return;
    L27:
        setStateInternal(r5);
        return;
    L6:
        if (r5 != 3) goto L9;
        r0 = getExpandedOffset();
        goto L21
    L9:
        if (r5 != 6) goto L17;
        int r2 = this.q;
        if (this.b == false) goto L15;
        int r3 = this.p;
        if (r2 > r3) goto L15;
        r0 = r3;
        r5 = 3;
    L15:
        r0 = r2;
        goto L21
    L17:
        if (r5 != 5) goto L30;
        if (this.d == false) goto L30;
        r0 = this.o;
    L30:
        throw new IllegalArgumentException("Invalid state: " + r5);
    }

    public final void c(View r9, float r10, boolean r11) {
        boolean r2 = true;
        int r3 = 0;
        if (Math.abs(r10) <= this.A) goto L5;
        boolean r0 = true;
    L6:
        int r1 = r9.getTop();
        int r4 = 6;
        if (r0 == false) goto L23;
        if (r10 >= 0) goto L23;
        if (this.b == true) goto L13;
        int r12 = r9.getTop();
        int r5 = this.q;
        if (r12 > r5) goto L74;
    L66:
        r4 = 3;
        r5 = r3;
    L74:
        if (r11 == false) goto L79;
        ViewDragHelper r13 = this.t;
        if (r13 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L78:
        boolean r14 = r13.smoothSlideViewTo(r9, r9.getLeft(), r5);
    L83:
        if (r14 == false) goto L85;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r9, new b(this, r9, r4));
        return;
    L85:
        setStateInternal(r4);
        return;
    L79:
        ViewDragHelper r15 = this.t;
        if (r15 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L82:
        r14 = r15.settleCapturedViewAt(r9.getLeft(), r5);
        goto L83
    L13:
        if (this.e == false) goto L16;
        r3 = this.p;
        goto L66
    L16:
        if (this.j == false) goto L18;
        int r16 = this.o;
    L59:
        r5 = r16;
    L60:
        r4 = 5;
        goto L74
    L18:
        int r17 = this.r;
    L50:
        r5 = r17;
        r4 = 4;
    L23:
        if (this.d == false) goto L40;
        float r6 = 0.1f * r10;
        if (this.j == false) goto L30;
        if (r6 <= this.r) goto L30;
    L36:
        if (r2 == false) goto L40;
        if (this.k == true) goto L40;
        r16 = this.o;
    L30:
        if (r9.getTop() >= this.r) goto L33;
    L35:
        r2 = false;
        goto L36
    L33:
        if ((Math.abs((r9.getTop() + r6) - this.r) / this.c) <= 0.5f) goto L35;
    L40:
        if (r0 == false) goto L52;
        if (r10 <= 0) goto L52;
        if (this.j == false) goto L49;
        r3 = this.o;
        if (this.k == true) goto L66;
        r5 = r3;
        goto L60
    L49:
        r17 = this.r;
    L52:
        if (this.b == true) goto L54;
        int r18 = this.q;
        if (r1 >= r18) goto L69;
        if (r1 < Math.abs(r1 - this.r)) goto L66;
        r5 = this.q;
        goto L74
    L69:
        if (Math.abs(r1 - r18) >= Math.abs(r1 - this.r)) goto L71;
        r5 = this.q;
        goto L74
    L71:
        r17 = this.r;
        goto L50
    L54:
        if (Math.abs(r1 - this.p) >= Math.abs(r1 - this.r)) goto L57;
        r3 = this.p;
        goto L66
    L57:
        if (this.j == false) goto L61;
        r16 = this.o;
        goto L59
    L61:
        r17 = this.r;
        goto L50
    L5:
        r0 = false;
        goto L6
    }

    public final boolean onInterceptTouchEvent(CoordinatorLayout r6, V r7, MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "child");
        Intrinsics.checkNotNullParameter(r8, "event");
        if (this.f == true) goto L5;
    L43:
        this.z = false;
        return false;
    L5:
        if (r7.isShown() == false) goto L43;
        int r0 = r8.getActionMasked();
        this.u = (int) r8.getX();
        this.v = (int) r8.getY();
        if (r0 != 0) goto L14;
        this.y = -1;
        VelocityTracker r3 = this.C;
        if (r3 == null) goto L12;
        r3.recycle();
    L12:
        this.C = null;
    L14:
        if (this.C != null) goto L16;
        this.C = VelocityTracker.obtain();
    L16:
        VelocityTracker r4 = this.C;
        if (r4 == null) goto L20;
        r4.addMovement(r8);
    L20:
        if (r0 == 0) goto L29;
        if (r0 != 1) goto L23;
    L25:
        this.y = -1;
        if (this.z == true) goto L36;
        this.z = true;
        return false;
    L36:
        if (this.z == false) goto L45;
        ViewDragHelper r9 = this.t;
        if (r9 != null) goto L40;
        return false;
    L40:
        if (r9.shouldInterceptTouchEvent(r8) == false) goto L47;
        return true;
    L47:
        return false;
    L45:
        return false;
    L23:
        if (r0 == 3) goto L25;
    L29:
        this.y = r8.getPointerId(r8.getActionIndex());
        this.w = (int) r8.getY();
        this.x = (int) r8.getX();
        ViewDragHelper r1 = this.t;
        if (r1 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L32:
        r1.abort();
        this.D = false;
        if (r6.isPointInChildBounds(r7, this.u, this.w) == true) goto L36;
        dm.a.a("shop_bottom_sheet").a("Not touching the sheet. parent=" + r6 + "\nchild=" + r7 + "\n,lastTouchX=" + this.u + "\n,initialTouchY=" + this.w);
        this.z = false;
        goto L36
    }

    public final boolean onLayoutChild(CoordinatorLayout r6, V r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "child");
        if (r6.getFitsSystemWindows() == true) goto L5;
    L7:
        int r0 = r7.getTop();
        r6.onLayoutChild(r7, r8);
        this.o = r6.getHeight();
        if (this.l == true) goto L10;
        this.n = this.c;
    L14:
        int r9 = Math.max(0, this.o - r7.getHeight());
        this.p = r9;
        int r3 = this.o;
        this.q = r3 / 2;
        if (this.b == false) goto L17;
        int r10 = Math.max(r3 - this.n, r9);
    L18:
        this.r = r10;
        switch(this.a) {
            case 1: goto L25;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            default: goto L26;
        };
    L21:
        ViewCompat.offsetTopAndBottom(r7, this.q);
        goto L26
    L22:
        ViewCompat.offsetTopAndBottom(r7, this.o);
        goto L26
    L23:
        ViewCompat.offsetTopAndBottom(r7, r10);
        goto L26
    L24:
        ViewCompat.offsetTopAndBottom(r7, getExpandedOffset());
        goto L26
    L25:
        ViewCompat.offsetTopAndBottom(r7, r0 - r7.getTop());
    L26:
        this.s = new WeakReference(r7);
        if (this.t != null) goto L29;
        this.t = ViewDragHelper.create(r6, this.G);
    L29:
        r7.getTop();
        if (this.F == false) goto L39;
        this.F = false;
        WeakReference<View> r11 = this.s;
        if (r11 == null) goto L39;
        View r12 = r11.get();
        if (r12 == null) goto L39;
        Iterator<T> r13 = this.E.iterator();
    L37:
        if (r13.hasNext() == false) goto L39;
        ((a) r13.next()).a(r12, this.a);
    L39:
        return true;
    L17:
        r10 = r3 - this.n;
        goto L18
    L10:
        if (this.m != 0) goto L12;
        this.m = ExtensionsKt.a(64);
    L12:
        this.n = Math.max(this.m, this.o - ((r6.getWidth() * 9) / 16));
        goto L14
    L5:
        if (r7.getFitsSystemWindows() == true) goto L7;
        r7.setFitsSystemWindows(true);
        goto L7
    }

    public final void onRestoreInstanceState(CoordinatorLayout r2, V r3, Parcelable r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "state");
        SavedState r5 = (SavedState) r4;
        Parcelable r0 = r5.getSuperState();
        if (r0 != null) goto L5;
        r0 = Bundle.EMPTY;
    L5:
        super.onRestoreInstanceState(r2, r3, r0);
        setPeekHeight(r5.b);
        int r6 = r5.a;
        if (r6 != 1) goto L8;
    L9:
        r6 = 4;
    L10:
        this.a = r6;
        return;
    L8:
        if (r6 != 2) goto L10;
        goto L9
    }

    public final boolean onTouchEvent(CoordinatorLayout r5, V r6, MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "child");
        Intrinsics.checkNotNullParameter(r7, "event");
        if (this.f == true) goto L5;
    L48:
        return false;
    L5:
        if (r6.isShown() == false) goto L48;
        dm.a.a("shop_bottom_sheet").a("onTouchEvent lastTouchY=" + this.v + ", initialTouchY=" + this.w + ", currentY=" + r7.getY() + ",child.top=" + r6.getTop() + ",state=" + this.a + ",collapsedOffset=" + this.r);
        int r8 = r7.getActionMasked();
        boolean r1 = true;
        if (r8 == 0) goto L10;
    L12:
        this.u = (int) r7.getX();
        this.v = (int) r7.getY();
        if (r8 != 0) goto L19;
        this.y = -1;
        VelocityTracker r2 = this.C;
        if (r2 == null) goto L17;
        r2.recycle();
    L17:
        this.C = null;
    L19:
        if (this.C != null) goto L21;
        this.C = VelocityTracker.obtain();
    L21:
        VelocityTracker r3 = this.C;
        if (r3 == null) goto L24;
        r3.addMovement(r7);
    L24:
        ViewDragHelper r4 = this.t;
        if (r4 == null) goto L31;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L28
        r4.processTouchEvent(r7);     // Catch: Throwable -> L28
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L31:
        if (this.z == true) goto L33;
    L46:
        this.i = false;
        return this.z;
    L33:
        if (r8 != 2) goto L46;
        int r11 = Math.abs(this.w - this.v);
        ViewDragHelper r12 = this.t;
        if (r12 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L38:
        if (r11 >= r12.getTouchSlop()) goto L41;
        r1 = false;
    L41:
        if (r1 == false) goto L46;
        ViewDragHelper r13 = this.t;
        if (r13 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L45:
        r13.captureChildView(r6, r7.getPointerId(r7.getActionIndex()));
        goto L46
    L10:
        if (this.a != 1) goto L12;
        return true;
    }

    public final void onStopNestedScroll(CoordinatorLayout r2, V r3, View r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "target");
        if (r3.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if ((!Intrinsics.areEqual(r4, null)) == false) goto L9;
        return;
    L9:
        if (this.D == false) goto L18;
        VelocityTracker r6 = this.C;
        if (r6 == null) goto L14;
        r6.computeCurrentVelocity(ECDraweeView.SQUARE, this.B);
        float r7 = r6.getYVelocity(this.y);
    L15:
        c(r3, r7, true);
        this.D = false;
        return;
    L14:
        r7 = 0.0f;
        goto L15
    }

    public final boolean onNestedPreFling(CoordinatorLayout r3, V r4, View r5, float r6, float r7) {
        Intrinsics.checkNotNullParameter(r3, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r5, "target");
        if (this.f == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r5, null) == false) goto L11;
        if (this.a == 3) goto L9;
    L10:
        return true;
    L9:
        if (super.onNestedPreFling(r3, r4, r5, r6, r7) == false) goto L11;
        goto L10
    }

    public final boolean onStartNestedScroll(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "directTargetChild");
        Intrinsics.checkNotNullParameter(r4, "target");
        this.D = false;
        dm.a.a("shop_bottom_sheet").a("onStartNestedScroll ,child.top=" + r2.getTop() + ",state=" + this.a);
        return false;
    }

    public final void onNestedPreScroll(CoordinatorLayout r2, V r3, View r4, int r5, int r6, int[] r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "target");
        Intrinsics.checkNotNullParameter(r7, "consumed");
        if (r8 != 1) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(r4, null)) == false) goto L8;
        return;
    L8:
        dm.a.a("shop_bottom_sheet").a("onNestedPreScroll ,child.top=" + r3.getTop() + ",state=" + this.a + ", dy=" + r6);
        int r9 = r3.getTop();
        int r10 = r9 - r6;
        if (r6 > 0) goto L11;
        if (r6 < 0) goto L16;
    L24:
        b(r3.getTop(), r6);
        this.D = true;
        return;
    L16:
        if (r4.canScrollVertically(-1) == true) goto L24;
        int r11 = this.r;
        if (r10 > r11) goto L20;
    L23:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L24
    L20:
        if (this.d == true) goto L23;
        int r12 = r9 - r11;
        r7[1] = r12;
        ViewCompat.offsetTopAndBottom(r3, -r12);
        setStateInternal(4);
        goto L24
    L11:
        if (r10 >= getExpandedOffset()) goto L13;
        int r13 = r9 - getExpandedOffset();
        r7[1] = r13;
        ViewCompat.offsetTopAndBottom(r3, -r13);
        setStateInternal(3);
        goto L24
    L13:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L24
    }
}
