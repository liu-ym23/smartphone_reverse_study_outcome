package com.bytedance.ee.bear.drive.core.fragment;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.DrivePreviewViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final FragmentActivity a;
    public final View b;
    public final LifecycleOwner c;
    public final ViewPager d;
    public final DriveMediaImmersiveVM e;
    public final boolean f;
    public final Function1<Integer, Boolean> g;
    public final Function1<Integer, Boolean> h;
    public final Function0<Unit> i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public b o;
    public final Map<View, c> p;
    public f q;
    public boolean r;
    public boolean s;
    public boolean t;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final Boolean d;
        public final Drawable e;
        public final Drawable f;
        public final Drawable g;
        public final Drawable h;
        public final Drawable i;
        public final Drawable j;
        public final RelativeLayout.LayoutParams k;
        public final int l;
        public final int m;
        public final int n;
        public final int o;
        public final float p;
        public final List<C0161d> q;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L51;
            return false;
        L51:
            if (this.o == r6.o) goto L54;
            return false;
        L54:
            if (Float.compare(this.p, r6.p) == 0) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.q, r6.q) == true) goto L59;
            return false;
        L59:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
            Boolean r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Drawable r5 = this.e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Drawable r8 = this.f;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Drawable r11 = this.g;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Drawable r14 = this.h;
            if (r14 != null) goto L21;
            int r16 = 0;
        L22:
            int r17 = (r13 + r16) * 31;
            Drawable r18 = this.i;
            if (r18 != null) goto L25;
            int r19 = 0;
        L26:
            int r20 = (r17 + r19) * 31;
            Drawable r21 = this.j;
            if (r21 != null) goto L29;
            int r22 = 0;
        L30:
            int r23 = (r20 + r22) * 31;
            RelativeLayout.LayoutParams r24 = this.k;
            if (r24 == null) goto L35;
            r2 = r24.hashCode();
        L35:
            return ((((((((((((r23 + r2) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + Float.floatToIntBits(this.p)) * 31) + this.q.hashCode();
        L29:
            r22 = r21.hashCode();
            goto L30
        L25:
            r19 = r18.hashCode();
            goto L26
        L21:
            r16 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "MediaOriginalState(statusBarColor=" + this.a + ", navigationBarColor=" + this.b + ", systemUiVisibility=" + this.c + ", navigationBarContrastEnforced=" + this.d + ", decorViewBackground=" + this.e + ", mainRootBackground=" + this.f + ", holderContainerBackground=" + this.g + ", holderBackground=" + this.h + ", titleBarRootBackground=" + this.i + ", viewPagerBackground=" + this.j + ", viewPagerLayoutParams=" + this.k + ", viewPagerPaddingLeft=" + this.l + ", viewPagerPaddingTop=" + this.m + ", viewPagerPaddingRight=" + this.n + ", viewPagerPaddingBottom=" + this.o + ", viewPagerTranslationY=" + this.p + ", ancestorClipStates=" + this.q + ')';
        }

        public b(int r4, int r5, int r6, Boolean r7, Drawable r8, Drawable r9, Drawable r10, Drawable r11, Drawable r12, Drawable r13, RelativeLayout.LayoutParams r14, int r16, int r17, int r18, int r19, float r110, List<C0161d> r20) {
            Intrinsics.checkNotNullParameter(r20, "ancestorClipStates");
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r10;
            this.h = r11;
            this.i = r12;
            this.j = r13;
            this.k = r14;
            this.l = r16;
            this.m = r17;
            this.n = r18;
            this.o = r19;
            this.p = r110;
            this.q = r20;
        }
    }

    public static final class c {
        public final Drawable a;
        public final Integer b;
        public final ColorStateList c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Drawable r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            ColorStateList r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "TitleBarVisualState(background=" + this.a + ", textColor=" + this.b + ", imageTintList=" + this.c + ')';
        }

        public c(Drawable r1, Integer r2, ColorStateList r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.core.fragment.d$d, reason: collision with other inner class name */
    public static final class C0161d {
        public final ViewGroup a;
        public final boolean b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0161d) == true) goto L8;
            return false;
        L8:
            C0161d r6 = (C0161d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.c == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "ViewGroupClipState(viewGroup=" + this.a + ", clipChildren=" + this.b + ", clipToPadding=" + this.c + ')';
        }

        public C0161d(ViewGroup r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "viewGroup");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ d a;

        public e(d r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r0 = this.a;     // Catch: Throwable -> L4
            r0.r = false;     // Catch: Throwable -> L4
            d.b(r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void d() {
        ViewGroup.LayoutParams r0 = this.d.getLayoutParams();
        View r2 = null;
        if ((r0 instanceof RelativeLayout.LayoutParams) == false) goto L5;
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        b r3 = this.o;
        if (r3 == null) goto L16;
        List<C0161d> r4 = r3.q;
        if (r4 == null) goto L16;
        Iterator<T> r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        C0161d r6 = (C0161d) r5.next();
        r6.a.setClipChildren(false);
        r6.a.setClipToPadding(false);
    L16:
        int[] r7 = new int[2];
        this.d.getLocationInWindow(r7);
        ViewGroup.LayoutParams r8 = this.d.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
    L20:
        if (r9 == null) goto L22;
        int r10 = r9.topMargin;
    L23:
        int r11 = (r7[1] - ((int) this.d.getTranslationY())) - r10;
        int r12 = r1.getRule(3);
        if (r12 == 0) goto L29;
        View r13 = this.b.findViewById(r12);
        if (r13 == null) goto L29;
        int r14 = r13.getHeight();
    L30:
        int r16 = r11 - r14;
        View r17 = a(this.a.getWindow());
        ViewParent r18 = this.d.getParent();
        int r19 = 0;
    L32:
        if ((r18 instanceof View) == false) goto L37;
        View r110 = (View) r18;
        r19 = r19 + r110.getPaddingTop();
        if (r18 == r17) goto L37;
        r18 = r110.getParent();
    L37:
        int r20 = RangesKt.coerceAtLeast(r19, 0);
        if (r16 > 0) goto L41;
        r16 = r20;
    L41:
        if (r16 <= 0) goto L43;
        this.n = r16;
    L43:
        int r21 = this.n;
        Object r22 = this.d.getParent();
        if ((r22 instanceof View) == false) goto L46;
        r2 = (View) r22;
    L46:
        if (r2 == null) goto L48;
        int r23 = r2.getHeight();
    L49:
        if (r23 <= 0) goto L51;
        r1.height = r23 + r21;
    L51:
        r1.removeRule(3);
        r1.removeRule(2);
        r1.addRule(10);
        r1.topMargin = -r21;
        this.d.setLayoutParams(r1);
        if (this.d.getPaddingTop() == 0) goto L54;
        ViewPager r24 = this.d;
        r24.setPadding(r24.getPaddingLeft(), 0, this.d.getPaddingRight(), this.d.getPaddingBottom());
    L54:
        this.d.setTranslationY(0.0f);
        this.m = true;
        return;
    L48:
        r23 = 0;
    L29:
        r14 = 0;
        goto L30
    L22:
        r10 = 0;
        goto L23
    L19:
        r9 = null;
        goto L20
    L5:
        r1 = null;
        goto L6
    }

    public final boolean g() {
        if (this.l == true) goto L5;
    L7:
        return false;
    L5:
        if (j() == false) goto L7;
        return true;
    }

    public final void h() {
        b r0 = this.o;
        if (this.l == false) goto L67;
        if (r0 != null) goto L7;
        return;
    L7:
        if (this.m == true) goto L9;
    L11:
        Iterator<T> r1 = r0.q.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        C0161d r2 = (C0161d) r1.next();
        r2.a.setClipChildren(r2.b);
        r2.a.setClipToPadding(r2.c);
        goto L13
    L15:
        Window r3 = this.a.getWindow();
        WindowCompat.setDecorFitsSystemWindows(r3, false);
        r3.setStatusBarColor(r0.a);
        r3.setNavigationBarColor(r0.b);
        int r4 = Build.VERSION.SDK_INT;
        if (r4 < 29) goto L20;
        Boolean r5 = r0.d;
        if (r5 == null) goto L20;
        r3.setNavigationBarContrastEnforced(r5.booleanValue());
    L20:
        a(r3).setSystemUiVisibility(r0.c);
        int r6 = r0.c;
        WindowInsetsControllerCompat r7 = WindowCompat.getInsetsController(r3, a(r3));
        boolean r8 = true;
        if (r4 < 23) goto L28;
        if ((r6 & 8192) == 0) goto L25;
        boolean r9 = true;
    L26:
        r7.setAppearanceLightStatusBars(r9);
        goto L28
    L25:
        r9 = false;
    L28:
        if (r4 >= 26) goto L30;
    L34:
        a(this.a.getWindow()).setBackground(r0.e);
        View r10 = this.b.findViewById(2131379453);
        if (r10 == null) goto L37;
        r10.setBackground(r0.f);
    L37:
        View r11 = this.b.findViewById(2131379452);
        if (r11 == null) goto L40;
        r11.setBackground(r0.g);
    L40:
        View r12 = this.b.findViewById(2131379451);
        if (r12 == null) goto L43;
        r12.setBackground(r0.h);
    L43:
        View r13 = this.b.findViewById(2131370319);
        if (r13 == null) goto L46;
        r13.setBackground(r0.i);
    L46:
        this.d.setBackground(r0.j);
        Iterator r14 = ((LinkedHashMap) this.p).entrySet().iterator();
    L47:
        TextView r16 = null;
        if (r14.hasNext() == false) goto L59;
        Map.Entry r17 = (Map.Entry) r14.next();
        View r18 = (View) r17.getKey();
        c r19 = (c) r17.getValue();
        r18.setBackground(r19.a);
        Integer r20 = r19.b;
        if (r20 == null) goto L57;
        int r21 = r20.intValue();
        if ((r18 instanceof TextView) == false) goto L54;
        r16 = (TextView) r18;
    L54:
        if (r16 == null) goto L57;
        r16.setTextColor(r21);
    L57:
        if ((r18 instanceof ImageView) == false) goto L47;
        ImageViewCompat.setImageTintList((ImageView) r18, r19.c);
        goto L47
    L59:
        ((LinkedHashMap) this.p).clear();
        this.l = false;
        this.m = false;
        this.n = 0;
        this.o = null;
        return;
    L30:
        if ((r6 & 16) != 0) goto L33;
        r8 = false;
    L33:
        r7.setAppearanceLightNavigationBars(r8);
        goto L34
    L9:
        if (r0.k == null) goto L11;
        this.d.setLayoutParams(new RelativeLayout.LayoutParams(r0.k));
        this.d.setPadding(r0.l, r0.m, r0.n, r0.o);
        this.d.setTranslationY(r0.p);
        goto L11
    }

    public final boolean j() {
        return this.e.isMediaImmersiveActive(this.f, ((Boolean) this.g.invoke(Integer.valueOf(this.j))).booleanValue());
    }

    public final void l() {
        if (this.t == false) goto L5;
        return;
    L5:
        boolean r1 = g();
        if (j() == true) goto L12;
        h();
        if (r1 == g()) goto L57;
        this.i.invoke();
        return;
    L57:
        return;
    L12:
        if (this.o == null) goto L14;
        boolean r23 = r1;
        d r2 = this;
    L50:
        r2.l = true;
        r2.e(r2.a.getWindow());
        c();
        d();
        m();
        if (r23 == g()) goto L53;
        r2.i.invoke();
    L53:
        r2.d.post(new g(r2));
        r2.d.postDelayed(new h(r2), 64);
        return;
    L14:
        ViewGroup.LayoutParams r3 = this.d.getLayoutParams();
        RelativeLayout.LayoutParams r4 = null;
        if ((r3 instanceof RelativeLayout.LayoutParams) == false) goto L17;
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) r3;
    L18:
        int r6 = this.a.getWindow().getStatusBarColor();
        int r7 = this.a.getWindow().getNavigationBarColor();
        int r8 = a(this.a.getWindow()).getSystemUiVisibility();
        if (Build.VERSION.SDK_INT < 29) goto L21;
        Boolean r9 = Boolean.valueOf(this.a.getWindow().isNavigationBarContrastEnforced());
    L22:
        Drawable r10 = a(this.a.getWindow()).getBackground();
        View r11 = this.b.findViewById(2131379453);
        if (r11 == null) goto L25;
        Drawable r12 = r11.getBackground();
    L26:
        View r13 = this.b.findViewById(2131379452);
        if (r13 == null) goto L29;
        Drawable r14 = r13.getBackground();
    L30:
        View r16 = this.b.findViewById(2131379451);
        if (r16 == null) goto L33;
        Drawable r17 = r16.getBackground();
    L34:
        View r18 = this.b.findViewById(2131370319);
        if (r18 == null) goto L37;
        Drawable r19 = r18.getBackground();
    L38:
        Drawable r110 = this.d.getBackground();
        if (r5 == null) goto L41;
        r4 = new RelativeLayout.LayoutParams(r5);
    L41:
        RelativeLayout.LayoutParams r111 = r4;
        int r112 = this.d.getPaddingLeft();
        int r113 = this.d.getPaddingTop();
        int r114 = this.d.getPaddingRight();
        int r20 = this.d.getPaddingBottom();
        float r21 = this.d.getTranslationY();
        ArrayList r22 = new ArrayList();
        View r24 = a(this.a.getWindow());
        ViewParent r26 = this.d.getParent();
    L43:
        if ((r26 instanceof ViewGroup) == false) goto L48;
        r23 = r1;
        ViewGroup r27 = (ViewGroup) r26;
        Drawable r28 = r110;
        r22.add(new C0161d(r27, r27.getClipChildren(), r27.getClipToPadding()));
        if (r26 == r24) goto L49;
        r26 = r27.getParent();
        r110 = r28;
        r1 = r23;
    L49:
        r2 = this;
        r2.o = new b(r6, r7, r8, r9, r10, r12, r14, r17, r19, r28, r111, r112, r113, r114, r20, r21, r22);
        goto L50
    L48:
        r23 = r1;
        r28 = r110;
        goto L49
    L37:
        r19 = null;
        goto L38
    L33:
        r17 = null;
        goto L34
    L29:
        r14 = null;
        goto L30
    L25:
        r12 = null;
        goto L26
    L21:
        r9 = null;
        goto L22
    L17:
        r5 = null;
        goto L18
    }

    public final void m() {
        b r0 = this.o;
        if (r0 != null) goto L6;
        return;
    L6:
        if (g() == false) goto L8;
        int r1 = this.k;
    L10:
        if (this.d.getPaddingBottom() != r1) goto L12;
        return;
    L12:
        ViewPager r2 = this.d;
        r2.setPadding(r2.getPaddingLeft(), this.d.getPaddingTop(), this.d.getPaddingRight(), r1);
        this.d.requestLayout();
        return;
    L8:
        r1 = r0.o;
        goto L10
    }

    public final void c() {
        if (k() == false) goto L5;
        int r0 = -16777216;
    L6:
        a(this.a.getWindow()).setBackgroundColor(-16777216);
        View r2 = this.b.findViewById(2131379453);
        if (r2 == null) goto L9;
        r2.setBackgroundColor(-16777216);
    L9:
        View r3 = this.b.findViewById(2131379452);
        if (r3 == null) goto L12;
        r3.setBackgroundColor(-16777216);
    L12:
        View r4 = this.b.findViewById(2131379451);
        if (r4 == null) goto L15;
        r4.setBackgroundColor(-16777216);
    L15:
        this.d.setBackgroundColor(-16777216);
        ViewGroup r1 = (ViewGroup) this.b.findViewById(2131370319);
        if (r1 == null) goto L18;
        r1.setBackgroundColor(0);
    L18:
        if (r1 == null) goto L21;
        f(r1, r0);
        return;
    L21:
        return;
    L5:
        r0 = -1;
        goto L6
    }

    public final void i() {
        if (g() == true) goto L5;
        return;
    L5:
        if (this.r == true) goto L10;
        this.r = true;
        this.d.post(new e(this));
        return;
    }

    public final boolean k() {
        if (j() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) this.h.invoke(Integer.valueOf(this.j))).booleanValue() == false) goto L7;
        return true;
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

    public static final void b(d r1) {
        if (r1.g() == false) goto L7;
        r1.e(r1.a.getWindow());
        r1.c();
        r1.d();
        r1.m();
        return;
    }

    public final void e(Window r7) {
        boolean r0 = k();
        WindowCompat.setDecorFitsSystemWindows(r7, false);
        r7.setStatusBarColor(0);
        if (r0 == false) goto L5;
        int r2 = -1;
    L6:
        r7.setNavigationBarColor(r2);
        int r3 = Build.VERSION.SDK_INT;
        if (r3 < 29) goto L9;
        r7.setNavigationBarContrastEnforced(false);
    L9:
        int r1 = ((a(r7).getSystemUiVisibility() | 1024) | 512) | 256;
        if (r3 < 23) goto L15;
        if (r0 == false) goto L13;
        r1 = r1 | 8192;
        goto L15
    L13:
        r1 = r1 & (-8193);
    L15:
        if (r3 < 26) goto L19;
        if (r0 == false) goto L18;
        r1 = r1 | 16;
        goto L19
    L18:
        r1 = r1 & (-17);
    L19:
        a(r7).setSystemUiVisibility(r1);
        WindowInsetsControllerCompat r8 = WindowCompat.getInsetsController(r7, a(r7));
        if (r3 < 23) goto L22;
        r8.setAppearanceLightStatusBars(r0);
    L22:
        if (r3 < 26) goto L25;
        r8.setAppearanceLightNavigationBars(r0);
        return;
    L25:
        return;
    L5:
        r2 = -16777216;
        goto L6
    }

    public final void f(View r7, int r8) {
        if (this.p.containsKey(r7) == true) goto L19;
        Map<View, c> r0 = this.p;
        Drawable r2 = r7.getBackground();
        ColorStateList r4 = null;
        if ((r7 instanceof TextView) == false) goto L8;
        TextView r3 = (TextView) r7;
    L9:
        if (r3 == null) goto L11;
        Integer r5 = Integer.valueOf(r3.getCurrentTextColor());
    L13:
        if ((r7 instanceof ImageView) == false) goto L15;
        ImageView r6 = (ImageView) r7;
    L16:
        if (r6 == null) goto L18;
        r4 = r6.getImageTintList();
    L18:
        r0.put(r7, new c(r2, r5, r4));
        goto L19
    L15:
        r6 = null;
        goto L16
    L11:
        r5 = null;
        goto L13
    L8:
        r3 = null;
    L19:
        int r1 = 0;
        r7.setBackgroundColor(0);
        if ((r7 instanceof TextView) == false) goto L23;
        ((TextView) r7).setTextColor(r8);
    L23:
        if ((r7 instanceof ImageView) == false) goto L26;
        ImageViewCompat.setImageTintList((ImageView) r7, ColorStateList.valueOf(r8));
    L26:
        if ((r7 instanceof ViewGroup) == false) goto L30;
        ViewGroup r9 = (ViewGroup) r7;
        int r10 = r9.getChildCount();
    L28:
        if (r1 >= r10) goto L32;
        f(r9.getChildAt(r1), r8);
        r1 = r1 + 1;
        goto L28
    L32:
        return;
    }

    public d(FragmentActivity r2, View r3, LifecycleOwner r4, DrivePreviewViewPager r5, DriveMediaImmersiveVM r6, boolean r7, Function1 r8, Function1 r9, Function0 r10) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "viewPager");
        Intrinsics.checkNotNullParameter(r6, "mediaImmersiveVM");
        Intrinsics.checkNotNullParameter(r8, "isVcProvider");
        Intrinsics.checkNotNullParameter(r9, "darkMediaChromeProvider");
        Intrinsics.checkNotNullParameter(r10, "onActiveStateChanged");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r5.getCurrentItem();
        this.p = new LinkedHashMap();
    }
}
