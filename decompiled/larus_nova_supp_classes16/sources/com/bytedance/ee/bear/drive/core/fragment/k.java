package com.bytedance.ee.bear.drive.core.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveFullScreenVM;
import com.bytedance.ee.bear.drive.core.ai.DriveAiInteractionVM;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k {
    public boolean A;
    public final View a;
    public final LifecycleOwner b;
    public final DriveAiInteractionVM c;
    public final Function0<Boolean> d;
    public final Function1<Integer, Unit> e;
    public final Function1<Boolean, Unit> f;
    public final Function0<Integer> g;
    public final Function2<Object, Boolean, Unit> h;
    public Integer i;
    public final Set<Integer> j;
    public final t75.h k;
    public final Set<Integer> l;
    public b m;
    public boolean n;
    public boolean o;
    public Integer p;
    public boolean q;
    public final Set<Object> r;
    public final IdentityHashMap<Object, Long> s;
    public final Set<Object> t;
    public long u;
    public boolean v;
    public boolean w;
    public boolean x;
    public l y;
    public n z;

    public static final class a {
    }

    public final class b implements ir5.d {
        public final String a;
        public final LifecycleOwner b;
        public final FrameLayout c;
        public final FrameLayout d;
        public boolean e;
        public final /* synthetic */ k f;

        @Override // ir5.d
        public final boolean b() {
            if (this.e == true) goto L7;
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection skipped: sessionId=" + this.a + ", valid=false");
            return false;
        L7:
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection skipped: sessionId=" + this.a + ", not main thread");
            return false;
        L10:
            long r4 = System.currentTimeMillis();
            Function0<Boolean> r10 = this.f.k.c;     // Catch: Throwable -> L16
            if (r10 == null) goto L18;
            boolean r11 = true;
            if (((Boolean) r10.invoke()).booleanValue() != true) goto L18;
        L19:
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection sessionId=" + this.a + ", accepted=" + r11);     // Catch: Throwable -> L16
            long r12 = System.currentTimeMillis() - r4;
            if (r12 <= 16) goto L38;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection sessionId=" + this.a + ", cost=" + r12 + "ms");
        L38:
            return r11;
        L18:
            r11 = false;
        L16:
            th = move-exception;
            tt5.a.e("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection failed: sessionId=" + this.a, th, false);     // Catch: Throwable -> L29
            long r13 = System.currentTimeMillis() - r4;
            if (r13 <= 16) goto L39;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection sessionId=" + this.a + ", cost=" + r13 + "ms");
            return false;
        L39:
            return false;
        L29:
            th = move-exception;
            long r14 = System.currentTimeMillis() - r4;
            if (r14 <= 16) goto L33;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection sessionId=" + this.a + ", cost=" + r14 + "ms");
        L33:
            throw th;
        }

        @Override // ir5.d
        public final void c() {
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.clearSideContainer sessionId=" + this.a + ", valid=" + this.e + ", childCount=" + this.d.getChildCount());
            this.d.removeAllViews();
        }

        @Override // ir5.d
        public final void d() {
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.clearBottomContainer sessionId=" + this.a + ", valid=" + this.e + ", childCount=" + this.c.getChildCount());
            this.c.removeAllViews();
        }

        @Override // ir5.d
        public final ir5.i g() {
            if (this.e == true) goto L7;
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext skipped: sessionId=" + this.a + ", valid=false");
            return null;
        L7:
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext skipped: sessionId=" + this.a + ", not main thread");
            return null;
        L10:
            long r4 = System.currentTimeMillis();
            Function0<ir5.i> r11 = this.f.k.b;     // Catch: Throwable -> L14
            if (r11 == null) goto L16;
            ir5.i r12 = (ir5.i) r11.invoke();     // Catch: Throwable -> L14
        L17:
            StringBuilder r13 = new StringBuilder("DrivePreviewAiHostImpl.getCurrentSelectionContext sessionId=");     // Catch: Throwable -> L14
            r13.append(this.a);     // Catch: Throwable -> L14
            r13.append(", hasContext=");     // Catch: Throwable -> L14
            if (r12 == null) goto L20;
            boolean r14 = true;
        L21:
            r13.append(r14);     // Catch: Throwable -> L14
            r13.append(", selectionCount=");     // Catch: Throwable -> L14
            if (r12 == null) goto L26;
            List<ir5.h> r16 = r12.e;     // Catch: Throwable -> L14
            if (r16 == null) goto L26;
            int r17 = r16.size();     // Catch: Throwable -> L14
        L27:
            r13.append(r17);     // Catch: Throwable -> L14
            tt5.a.h("DriveSdk", r13.toString());     // Catch: Throwable -> L14
            long r18 = System.currentTimeMillis() - r4;
            if (r18 <= 16) goto L46;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext sessionId=" + this.a + ", cost=" + r18 + "ms");
        L46:
            return r12;
        L26:
            r17 = 0;
            goto L27
        L20:
            r14 = false;
            goto L21
        L16:
            r12 = null;
        L14:
            th = move-exception;
            tt5.a.e("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext failed: sessionId=" + this.a, th, false);     // Catch: Throwable -> L37
            long r19 = System.currentTimeMillis() - r4;
            if (r19 <= 16) goto L47;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext sessionId=" + this.a + ", cost=" + r19 + "ms");
            return null;
        L47:
            return null;
        L37:
            th = move-exception;
            long r110 = System.currentTimeMillis() - r4;
            if (r110 <= 16) goto L41;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext sessionId=" + this.a + ", cost=" + r110 + "ms");
        L41:
            throw th;
        }

        @Override // ir5.d
        public final FrameLayout a() {
            return this.c;
        }

        @Override // ir5.d
        public final FrameLayout f() {
            return this.d;
        }

        @Override // ir5.d
        public final String getSessionId() {
            return this.a;
        }

        @Override // ir5.d
        public final boolean isValid() {
            return this.e;
        }

        @Override // ir5.d
        public final void e(boolean r3) {
            k r0 = this.f;
            r0.w = r3;
            k.a(r0);
            StringBuilder r1 = new StringBuilder("DrivePreviewAiHostImpl.setSideContainerVisible sessionId=");
            r1.append(this.a);
            r1.append(", valid=");
            r1.append(this.e);
            r1.append(", requestedVisible=");
            r1.append(r3);
            r1.append(", actualVisible=");
            if (this.d.getVisibility() != 0) goto L5;
            boolean r4 = true;
        L6:
            r1.append(r4);
            r1.append(", temporarilyHidden=");
            r1.append(this.f.q);
            tt5.a.h("DriveSdk", r1.toString());
            return;
        L5:
            r4 = false;
            goto L6
        }

        @Override // ir5.d
        public final void h(boolean r3) {
            k r0 = this.f;
            r0.v = r3;
            r0.c();
            StringBuilder r1 = new StringBuilder("DrivePreviewAiHostImpl.setBottomContainerVisible sessionId=");
            r1.append(this.a);
            r1.append(", valid=");
            r1.append(this.e);
            r1.append(", requestedVisible=");
            r1.append(r3);
            r1.append(", actualVisible=");
            if (this.c.getVisibility() != 0) goto L5;
            boolean r4 = true;
        L6:
            r1.append(r4);
            r1.append(", phoneLandscape=");
            r1.append(this.f.x);
            r1.append(", temporarilyHidden=");
            r1.append(this.f.q);
            r1.append(", suppressedOwnerCount=");
            r1.append(this.f.r.size());
            tt5.a.h("DriveSdk", r1.toString());
            return;
        L5:
            r4 = false;
            goto L6
        }

        @Override // ir5.d
        public final void i(boolean r4) {
            if (this.e == true) goto L6;
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.setAiInteractionActive skipped: sessionId=" + this.a + ", valid=false, active=" + r4);
            return;
        L6:
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.setAiInteractionActive sessionId=" + this.a + ", valid=true, active=" + r4);
            this.f.c.setActive(r4);
        }

        public b(k r2, String r3, LifecycleOwner r4, FrameLayout r5, FrameLayout r6) {
            Intrinsics.checkNotNullParameter(r3, "sessionId");
            Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r5, "bottomContainer");
            Intrinsics.checkNotNullParameter(r6, "sideContainer");
            this.f = r2;
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = true;
        }
    }

    static {
    }

    public final void c() {
        FrameLayout r0 = (FrameLayout) this.a.findViewById(2131370248);
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r3 = false;
        if (this.x == false) goto L8;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L17;
        int r5 = 0;
    L19:
        if (r0.getVisibility() != r5) goto L21;
        return;
    L21:
        r0.setVisibility(r5);
        if ((!this.r.isEmpty()) == false) goto L24;
    L25:
        r3 = true;
    L26:
        if (r2 == false) goto L28;
    L30:
        if (r2 == false) goto L32;
    L34:
        j();
        if (r2 == false) goto L50;
        FrameLayout r1 = (FrameLayout) this.a.findViewById(2131370248);
        if (r1 != null) goto L40;
    L46:
        View r4 = this.a.findViewById(2131370248);
        if (r4 == null) goto L51;
        r4.post(new o(this));
        return;
    L51:
        return;
    L40:
        if (this.p != null) goto L46;
        l r6 = this.y;
        if (r6 != null) goto L45;
        r6 = new l(this);
        this.y = r6;
    L45:
        r1.removeOnLayoutChangeListener(r6);
        r1.addOnLayoutChangeListener(r6);
        goto L46
    L50:
        return;
    L32:
        if (this.p == null) goto L34;
        tt5.a.h("DriveSdk", "preserveAiBottomBaseHeightForTemporaryHidden baseHeight=" + this.p + ", suppressedOwnerCount=" + this.r.size() + ", overlayTemporarilyHidden=" + this.q);
        goto L34
    L28:
        if ((!r3) == false) goto L30;
        this.p = null;
        e();
        goto L34
    L24:
        if (this.q == false) goto L26;
    L17:
        r5 = 8;
        goto L19
    L8:
        if (this.v == false) goto L14;
        if (this.q == true) goto L14;
        if (this.r.isEmpty() == false) goto L14;
        r2 = true;
        goto L15
    }

    public final void e() {
        l r0 = this.y;
        if (r0 != null) goto L5;
        return;
    L5:
        FrameLayout r1 = (FrameLayout) this.a.findViewById(2131370248);
        if (r1 == null) goto L8;
        r1.removeOnLayoutChangeListener(r0);
    L8:
        this.y = null;
    }

    public final void j() {
        View r0 = this.a.findViewById(2131379451);
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        CoordinatorLayout.LayoutParams r3 = null;
        if ((r1 instanceof CoordinatorLayout.LayoutParams) == false) goto L8;
        CoordinatorLayout.LayoutParams r2 = (CoordinatorLayout.LayoutParams) r1;
    L9:
        if (r2 != null) goto L12;
        return;
    L12:
        if (this.i != null) goto L14;
        this.i = Integer.valueOf(((ViewGroup.MarginLayoutParams) r2).bottomMargin);
    L14:
        Integer r4 = this.i;
        int r5 = 0;
        if (r4 == null) goto L17;
        int r6 = r4.intValue();
    L18:
        int r7 = RangesKt.coerceAtLeast(((Number) this.g.invoke()).intValue(), 0);
        FrameLayout r8 = (FrameLayout) this.a.findViewById(2131370248);
        if (r8 != null) goto L22;
    L23:
        int r9 = 0;
    L28:
        int r10 = r7 + r9;
        FrameLayout r11 = (FrameLayout) this.a.findViewById(2131370333);
        if (r11 == null) goto L45;
        CoordinatorLayout.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof CoordinatorLayout.LayoutParams) == false) goto L34;
        r3 = r12;
    L34:
        if (r3 == null) goto L45;
        if (r11.getVisibility() != 0) goto L39;
        int r13 = RangesKt.coerceAtLeast(r9, 0);
    L41:
        if (((ViewGroup.MarginLayoutParams) r3).bottomMargin == r13) goto L45;
        ((ViewGroup.MarginLayoutParams) r3).bottomMargin = r13;
        r11.setLayoutParams(r3);
        goto L45
    L39:
        r13 = 0;
    L45:
        if (((Boolean) this.d.invoke()).booleanValue() == true) goto L48;
        r5 = r10;
    L48:
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = r6 + r5;
        r0.setLayoutParams(r2);
        r0.requestLayout();
        this.e.invoke(Integer.valueOf(r10));
        return;
    L22:
        if (r8.getVisibility() != 0) goto L23;
        Integer r14 = this.p;
        if (r14 == null) goto L27;
        r9 = r14.intValue();
        goto L28
    L27:
        r9 = g(r8);
        goto L28
    L17:
        r6 = 0;
        goto L18
    L8:
        r2 = null;
        goto L9
    }

    public static final void a(k r3) {
        FrameLayout r0 = (FrameLayout) r3.a.findViewById(2131370249);
        if (r0 == null) goto L16;
        int r2 = 0;
        if (r3.w == true) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == true) goto L14;
        r2 = 8;
    L14:
        r0.setVisibility(r2);
        return;
    L8:
        if (r3.q == true) goto L10;
        r4 = true;
        goto L11
    }

    public static final void b(k r7) {
        FrameLayout r0 = (FrameLayout) r7.a.findViewById(2131370248);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getVisibility() == 0) goto L8;
        return;
    L8:
        if (r7.p != null) goto L47;
        int r1 = g(r0);
        if (r1 <= 0) goto L48;
        WindowInsetsCompat r2 = ViewCompat.getRootWindowInsets(r0);
        boolean r3 = true;
        if (r2 != null) goto L16;
    L18:
        boolean r4 = false;
    L20:
        if (r7.p != null) goto L24;
        if (r4 == true) goto L24;
        if (r1 <= 0) goto L24;
        boolean r5 = true;
    L26:
        if (r5 == false) goto L40;
        View r6 = r7.a.findViewById(2131379453);
        if (r6 == null) goto L30;
        int r8 = r6.getHeight();
    L31:
        if (r8 > 0) goto L34;
    L37:
        if (r3 == false) goto L40;
        r7.p = Integer.valueOf(r1);
        tt5.a.h("DriveSdk", "cacheAiBottomBaseHeight height=" + r1 + ", rootHeight=" + r7.a.getHeight());
        return;
    L34:
        if (r1 < (r8 / 2)) goto L37;
        r3 = false;
        goto L37
    L30:
        r8 = 0;
    L40:
        if (r4 == false) goto L45;
        tt5.a.h("DriveSdk", "skipAiBottomBaseHeightCacheForIme candidateHeight=" + r1);
        return;
    L45:
        return;
    L24:
        r5 = false;
        goto L26
    L16:
        if (r2.isVisible(WindowInsetsCompat.Type.ime()) != true) goto L18;
        r4 = true;
        goto L20
    L48:
        return;
    }

    public static int g(FrameLayout r6) {
        boolean r0 = true;
        int r1 = f(r6, true);
        if (r1 > 0) goto L5;
        return 0;
    L5:
        Integer r3 = Integer.valueOf(r6.getHeight());
        if (r3.intValue() <= 0) goto L8;
        boolean r4 = true;
    L9:
        Integer r5 = null;
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 != null) goto L23;
        r3 = Integer.valueOf(r6.getMeasuredHeight());
        if (r3.intValue() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L22;
        r3 = null;
    L22:
        if (r3 != null) goto L23;
        int r8 = 0;
    L25:
        if (r8 <= 0) goto L38;
        if (r1 <= r8) goto L38;
        Integer r9 = Integer.valueOf(f(r6, false));
        int r2 = r9.intValue();
        if (r2 <= 0) goto L32;
        if (r2 > r8) goto L32;
    L33:
        if (r0 == false) goto L35;
        r5 = r9;
    L35:
        if (r5 != null) goto L37;
        return 0;
    L37:
        return r5.intValue();
    L32:
        r0 = false;
    L38:
        return r1;
    L18:
        r7 = false;
    L23:
        r8 = r3.intValue();
        goto L25
    L8:
        r4 = false;
        goto L9
    }

    public final void d(boolean r3) {
        if (r3 == false) goto L4;
        this.j.clear();
    L4:
        t75.h r4 = this.k;
        r4.a = null;
        r4.b = null;
        r4.c = null;
        b r5 = this.m;
        if ((r5 instanceof b) == true) goto L9;
        r5 = null;
    L9:
        if (r5 == null) goto L11;
        r5.e = false;
        r5.f.c.clear();
    L11:
        b r6 = this.m;
        if (r6 == null) goto L14;
        r6.d();
    L14:
        b r7 = this.m;
        if (r7 == null) goto L17;
        r7.c();
    L17:
        b r8 = this.m;
        if (r8 == null) goto L20;
        r8.h(false);
    L20:
        b r9 = this.m;
        if (r9 == null) goto L23;
        r9.e(false);
    L23:
        this.m = null;
    }

    public final void i(Configuration r7) {
        if (this.n == false) goto L5;
        return;
    L5:
        boolean r0 = false;
        if (r7 == null) goto L8;
        int r1 = r7.orientation;
    L9:
        Activity r2 = q.a(this.a.getContext());
        if (r2 == null) goto L12;
        int r3 = r2.getRequestedOrientation();
    L13:
        boolean r4 = ku5.c.k(this.a.getContext());
        if (r1 == 2) goto L18;
        if (r3 == 0) goto L18;
        boolean r5 = false;
    L19:
        if (r5 == false) goto L23;
        if (r4 == true) goto L23;
        r0 = true;
    L23:
        if (this.x != r0) goto L25;
        return;
    L25:
        this.x = r0;
        c();
        StringBuilder r6 = new StringBuilder("updateAiBottomPhoneLandscapeState phoneLandscape=");
        r6.append(r0);
        r6.append(", orientation=");
        if (r7 == null) goto L28;
        Integer r8 = Integer.valueOf(r7.orientation);
    L29:
        r6.append(r8);
        tt5.a.h("DriveSdk", r6.toString());
        return;
    L28:
        r8 = null;
    L18:
        r5 = true;
        goto L19
    L12:
        r3 = -1;
        goto L13
    L8:
        r1 = 0;
        goto L9
    }

    public static int f(FrameLayout r5, boolean r6) {
        int r1 = 0;
        if (r5.getVisibility() == 0) goto L5;
        return 0;
    L5:
        int r0 = r5.getChildCount();
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r3 = Math.max(r3, h(r5.getChildAt(r2), r6));
        r2 = r2 + 1;
        goto L6
    L8:
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
    L12:
        if (r3 <= 0) goto L23;
        int r4 = (r5.getPaddingTop() + r3) + r5.getPaddingBottom();
        if (r8 == null) goto L16;
        int r9 = r8.topMargin;
    L17:
        int r10 = r4 + r9;
        if (r8 == null) goto L21;
        r1 = r8.bottomMargin;
    L21:
        return r1 + r10;
    L16:
        r9 = 0;
        goto L17
    L23:
        return 0;
    L11:
        r8 = null;
        goto L12
    }

    public static int h(View r8, boolean r9) {
        int r1 = 0;
        if (r8.getVisibility() == 0) goto L5;
        return 0;
    L5:
        ViewGroup.LayoutParams r0 = r8.getLayoutParams();
        Integer r3 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r0;
    L9:
        boolean r4 = true;
        if ((r8 instanceof ViewGroup) == false) goto L34;
        ViewGroup r5 = (ViewGroup) r8;
        if (r5.getChildCount() <= 0) goto L34;
        if (r5.getVisibility() != 0) goto L53;
        int r10 = r5.getPaddingTop() + r5.getPaddingBottom();
        if ((r5 instanceof LinearLayout) == false) goto L23;
        LinearLayout r6 = (LinearLayout) r5;
        if (r6.getOrientation() != 1) goto L23;
        int r7 = r6.getChildCount();
        int r11 = 0;
        int r12 = 0;
    L21:
        if (r11 >= r7) goto L31;
        r12 = r12 + h(r5.getChildAt(r11), r9);
        r11 = r11 + 1;
    L31:
        int r13 = r10 + r12;
        if (r13 <= (r5.getPaddingTop() + r5.getPaddingBottom())) goto L53;
    L54:
        if (r2 == null) goto L56;
        int r14 = r2.topMargin;
    L57:
        int r16 = r13 + r14;
        if (r2 == null) goto L61;
        r1 = r2.bottomMargin;
    L61:
        return r16 + r1;
    L56:
        r14 = 0;
    L23:
        int r17 = r5.getChildCount();
        int r18 = 0;
        r12 = 0;
    L24:
        if (r18 >= r17) goto L31;
        View r19 = r5.getChildAt(r18);
        Intrinsics.checkNotNull(r19);
        int r20 = h(r19, r9);
        if (r20 <= 0) goto L30;
        if (r9 == false) goto L29;
        r20 = r20 + r19.getTop();
    L29:
        r12 = Math.max(r12, r20);
    L30:
        r18 = r18 + 1;
    L53:
        r13 = 0;
    L34:
        ViewGroup.LayoutParams r21 = r8.getLayoutParams();
        if (r21 == null) goto L45;
        Integer r22 = Integer.valueOf(r21.height);
        if (r22.intValue() <= 0) goto L39;
        boolean r23 = true;
    L40:
        if (r23 == true) goto L43;
        r22 = null;
    L43:
        if (r22 == null) goto L45;
        r13 = r22.intValue();
        goto L54
    L39:
        r23 = false;
    L45:
        Integer r24 = Integer.valueOf(r8.getMeasuredHeight());
        if (r24.intValue() > 0) goto L49;
        r4 = false;
    L49:
        if (r4 == false) goto L51;
        r3 = r24;
    L51:
        if (r3 == null) goto L53;
        r13 = r3.intValue();
        goto L54
    L8:
        r2 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(View r2, LifecycleOwner r3, DriveFullScreenVM r4, DriveAiInteractionVM r5, Function0<Boolean> r6, Function1<? super Integer, Unit> r7, Function1<? super Boolean, Unit> r8, Function0<Integer> r9, Function2<Object, ? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "aiInteractionVM");
        Intrinsics.checkNotNullParameter(r6, "mediaImmersiveActiveProvider");
        Intrinsics.checkNotNullParameter(r7, "mediaBottomInsetConsumer");
        Intrinsics.checkNotNullParameter(r8, "mediaOverlayTemporaryStateConsumer");
        Intrinsics.checkNotNullParameter(r9, "thumbnailOccupiedHeightProvider");
        Intrinsics.checkNotNullParameter(r10, "thumbnailSuppressionConsumer");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.j = new LinkedHashSet();
        this.k = new t75.h();
        this.l = new LinkedHashSet();
        this.r = Collections.newSetFromMap(new IdentityHashMap());
        this.s = new IdentityHashMap();
        this.t = Collections.newSetFromMap(new IdentityHashMap());
        if (r4 == null) goto L7;
        MutableLiveData<com.bytedance.ee.bear.drive.biz.preview.screen.a> r11 = r4.getLiveFullScreen();
        if (r11 == null) goto L7;
        r11.observe(r3, new m(this));
    L7:
        n r12 = this.z;
        if (r12 != null) goto L11;
        r12 = new n(this);
        this.z = r12;
    L11:
        if (this.A == true) goto L13;
        r2.getContext().getApplicationContext().registerComponentCallbacks(r12);
        this.A = true;
    L13:
        i(r2.getResources().getConfiguration());
    }
}
