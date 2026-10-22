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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes16.dex */
public final class k {
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f224219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f224220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DriveAiInteractionVM f224221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f224222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Integer, Unit> f224223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Boolean, Unit> f224224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Integer> f224225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<Object, Boolean, Unit> f224226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f224227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<Integer> f224228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final t75.h f224229k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<Integer> f224230l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f224231m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f224232n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f224233o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f224234p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f224235q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Set<Object> f224236r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final IdentityHashMap<Object, Long> f224237s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Set<Object> f224238t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f224239u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f224240v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f224241w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f224242x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public l f224243y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public n f224244z;

    public static final class a {
    }

    public final class b implements ir5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f224245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LifecycleOwner f224246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FrameLayout f224247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final FrameLayout f224248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f224249e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ k f224250f;

        @Override // ir5.d
        public final boolean b() {
            if (this.f224249e == true) goto L7;
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection skipped: sessionId=" + this.f224245a + ", valid=false");
            return false;
        L7:
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection skipped: sessionId=" + this.f224245a + ", not main thread");
            return false;
        L10:
            long r100 = System.currentTimeMillis();
            Function0<Boolean> r110 = this.f224250f.f224229k.f544897c;     // Catch: Throwable -> L16
            if (r110 == null) goto L18;
            boolean r111 = true;
            if (r110.invoke().booleanValue() != true) goto L18;
        L19:
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection sessionId=" + this.f224245a + ", accepted=" + r111);     // Catch: Throwable -> L16
            long r112 = System.currentTimeMillis() - r100;
            if (r112 <= 16) goto L38;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection sessionId=" + this.f224245a + ", cost=" + r112 + "ms");
        L38:
            return r111;
        L18:
            r111 = false;
        L16:
            th = move-exception;
            tt5.a.e("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection failed: sessionId=" + this.f224245a, th, false);     // Catch: Throwable -> L29
            long r113 = System.currentTimeMillis() - r100;
            if (r113 <= 16) goto L39;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection sessionId=" + this.f224245a + ", cost=" + r113 + "ms");
            return false;
        L39:
            return false;
        L29:
            th = move-exception;
            long r114 = System.currentTimeMillis() - r100;
            if (r114 <= 16) goto L33;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.clearCurrentSelection sessionId=" + this.f224245a + ", cost=" + r114 + "ms");
        L33:
            throw th;
        }

        @Override // ir5.d
        public final void c() {
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.clearSideContainer sessionId=" + this.f224245a + ", valid=" + this.f224249e + ", childCount=" + this.f224248d.getChildCount());
            this.f224248d.removeAllViews();
        }

        @Override // ir5.d
        public final void d() {
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.clearBottomContainer sessionId=" + this.f224245a + ", valid=" + this.f224249e + ", childCount=" + this.f224247c.getChildCount());
            this.f224247c.removeAllViews();
        }

        @Override // ir5.d
        public final ir5.i g() {
            if (this.f224249e == true) goto L7;
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext skipped: sessionId=" + this.f224245a + ", valid=false");
            return null;
        L7:
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext skipped: sessionId=" + this.f224245a + ", not main thread");
            return null;
        L10:
            long r100 = System.currentTimeMillis();
            Function0<ir5.i> r110 = this.f224250f.f224229k.f544896b;     // Catch: Throwable -> L14
            if (r110 == null) goto L16;
            ir5.i r111 = r110.invoke();     // Catch: Throwable -> L14
        L17:
            StringBuilder r112 = new StringBuilder("DrivePreviewAiHostImpl.getCurrentSelectionContext sessionId=");     // Catch: Throwable -> L14
            r112.append(this.f224245a);     // Catch: Throwable -> L14
            r112.append(", hasContext=");     // Catch: Throwable -> L14
            if (r111 == null) goto L20;
            boolean r113 = true;
        L21:
            r112.append(r113);     // Catch: Throwable -> L14
            r112.append(", selectionCount=");     // Catch: Throwable -> L14
            if (r111 == null) goto L26;
            List<ir5.h> r114 = r111.f495486e;     // Catch: Throwable -> L14
            if (r114 == null) goto L26;
            int r115 = r114.size();     // Catch: Throwable -> L14
        L27:
            r112.append(r115);     // Catch: Throwable -> L14
            tt5.a.h("DriveSdk", r112.toString());     // Catch: Throwable -> L14
            long r116 = System.currentTimeMillis() - r100;
            if (r116 <= 16) goto L46;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext sessionId=" + this.f224245a + ", cost=" + r116 + "ms");
        L46:
            return r111;
        L26:
            r115 = 0;
            goto L27
        L20:
            r113 = false;
            goto L21
        L16:
            r111 = null;
        L14:
            th = move-exception;
            tt5.a.e("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext failed: sessionId=" + this.f224245a, th, false);     // Catch: Throwable -> L37
            long r117 = System.currentTimeMillis() - r100;
            if (r117 <= 16) goto L47;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext sessionId=" + this.f224245a + ", cost=" + r117 + "ms");
            return null;
        L47:
            return null;
        L37:
            th = move-exception;
            long r118 = System.currentTimeMillis() - r100;
            if (r118 <= 16) goto L41;
            tt5.a.k("DriveSdk", "DrivePreviewAiHostImpl.getCurrentSelectionContext sessionId=" + this.f224245a + ", cost=" + r118 + "ms");
        L41:
            throw th;
        }

        @Override // ir5.d
        public final FrameLayout a() {
            return this.f224247c;
        }

        @Override // ir5.d
        public final FrameLayout f() {
            return this.f224248d;
        }

        @Override // ir5.d
        public final String getSessionId() {
            return this.f224245a;
        }

        @Override // ir5.d
        public final boolean isValid() {
            return this.f224249e;
        }

        @Override // ir5.d
        public final void e(boolean r100) {
            k r101 = this.f224250f;
            r101.f224241w = r100;
            k.a(r101);
            StringBuilder r102 = new StringBuilder("DrivePreviewAiHostImpl.setSideContainerVisible sessionId=");
            r102.append(this.f224245a);
            r102.append(", valid=");
            r102.append(this.f224249e);
            r102.append(", requestedVisible=");
            r102.append(r100);
            r102.append(", actualVisible=");
            if (this.f224248d.getVisibility() != 0) goto L5;
            boolean r103 = true;
        L6:
            r102.append(r103);
            r102.append(", temporarilyHidden=");
            r102.append(this.f224250f.f224235q);
            tt5.a.h("DriveSdk", r102.toString());
            return;
        L5:
            r103 = false;
            goto L6
        }

        @Override // ir5.d
        public final void h(boolean r100) {
            k r101 = this.f224250f;
            r101.f224240v = r100;
            r101.c();
            StringBuilder r102 = new StringBuilder("DrivePreviewAiHostImpl.setBottomContainerVisible sessionId=");
            r102.append(this.f224245a);
            r102.append(", valid=");
            r102.append(this.f224249e);
            r102.append(", requestedVisible=");
            r102.append(r100);
            r102.append(", actualVisible=");
            if (this.f224247c.getVisibility() != 0) goto L5;
            boolean r103 = true;
        L6:
            r102.append(r103);
            r102.append(", phoneLandscape=");
            r102.append(this.f224250f.f224242x);
            r102.append(", temporarilyHidden=");
            r102.append(this.f224250f.f224235q);
            r102.append(", suppressedOwnerCount=");
            r102.append(this.f224250f.f224236r.size());
            tt5.a.h("DriveSdk", r102.toString());
            return;
        L5:
            r103 = false;
            goto L6
        }

        @Override // ir5.d
        public final void i(boolean r100) {
            if (this.f224249e == true) goto L6;
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.setAiInteractionActive skipped: sessionId=" + this.f224245a + ", valid=false, active=" + r100);
            return;
        L6:
            tt5.a.h("DriveSdk", "DrivePreviewAiHostImpl.setAiInteractionActive sessionId=" + this.f224245a + ", valid=true, active=" + r100);
            this.f224250f.f224221c.setActive(r100);
        }

        public b(k r100, String r101, LifecycleOwner r102, FrameLayout r103, FrameLayout r104) {
            Intrinsics.checkNotNullParameter(r101, "sessionId");
            Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r103, "bottomContainer");
            Intrinsics.checkNotNullParameter(r104, "sideContainer");
            this.f224250f = r100;
            this.f224245a = r101;
            this.f224246b = r102;
            this.f224247c = r103;
            this.f224248d = r104;
            this.f224249e = true;
        }
    }

    static {
    }

    public final void c() {
        FrameLayout r100 = (FrameLayout) this.f224219a.findViewById(R.id.drive_ai_bottom_container);
        if (r100 != null) goto L5;
        return;
    L5:
        boolean r101 = false;
        if (this.f224242x == false) goto L8;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L17;
        int r103 = 0;
    L19:
        if (r100.getVisibility() != r103) goto L21;
        return;
    L21:
        r100.setVisibility(r103);
        if ((!this.f224236r.isEmpty()) == false) goto L24;
    L25:
        r101 = true;
    L26:
        if (r102 == false) goto L28;
    L30:
        if (r102 == false) goto L32;
    L34:
        j();
        if (r102 == false) goto L50;
        FrameLayout r104 = (FrameLayout) this.f224219a.findViewById(R.id.drive_ai_bottom_container);
        if (r104 != null) goto L40;
    L46:
        View r105 = this.f224219a.findViewById(R.id.drive_ai_bottom_container);
        if (r105 == null) goto L51;
        r105.post(new o(this));
        return;
    L51:
        return;
    L40:
        if (this.f224234p != null) goto L46;
        l r106 = this.f224243y;
        if (r106 != null) goto L45;
        r106 = new l(this);
        this.f224243y = r106;
    L45:
        r104.removeOnLayoutChangeListener(r106);
        r104.addOnLayoutChangeListener(r106);
        goto L46
    L50:
        return;
    L32:
        if (this.f224234p == null) goto L34;
        tt5.a.h("DriveSdk", "preserveAiBottomBaseHeightForTemporaryHidden baseHeight=" + this.f224234p + ", suppressedOwnerCount=" + this.f224236r.size() + ", overlayTemporarilyHidden=" + this.f224235q);
        goto L34
    L28:
        if ((!r101) == false) goto L30;
        this.f224234p = null;
        e();
        goto L34
    L24:
        if (this.f224235q == false) goto L26;
    L17:
        r103 = 8;
        goto L19
    L8:
        if (this.f224240v == false) goto L14;
        if (this.f224235q == true) goto L14;
        if (this.f224236r.isEmpty() == false) goto L14;
        r102 = true;
        goto L15
    }

    public final void e() {
        l r100 = this.f224243y;
        if (r100 != null) goto L5;
        return;
    L5:
        FrameLayout r101 = (FrameLayout) this.f224219a.findViewById(R.id.drive_ai_bottom_container);
        if (r101 == null) goto L8;
        r101.removeOnLayoutChangeListener(r100);
    L8:
        this.f224243y = null;
    }

    public final void j() {
        View r100 = this.f224219a.findViewById(R.id.main_page_holder_view);
        if (r100 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        CoordinatorLayout.LayoutParams r102 = null;
        if ((r101 instanceof CoordinatorLayout.LayoutParams) == false) goto L8;
        CoordinatorLayout.LayoutParams r103 = (CoordinatorLayout.LayoutParams) r101;
    L9:
        if (r103 != null) goto L12;
        return;
    L12:
        if (this.f224227i != null) goto L14;
        this.f224227i = Integer.valueOf(((ViewGroup.MarginLayoutParams) r103).bottomMargin);
    L14:
        Integer r104 = this.f224227i;
        int r105 = 0;
        if (r104 == null) goto L17;
        int r106 = r104.intValue();
    L18:
        int r107 = RangesKt.coerceAtLeast(this.f224225g.invoke().intValue(), 0);
        FrameLayout r108 = (FrameLayout) this.f224219a.findViewById(R.id.drive_ai_bottom_container);
        if (r108 != null) goto L22;
    L23:
        int r109 = 0;
    L28:
        int r110 = r107 + r109;
        FrameLayout r111 = (FrameLayout) this.f224219a.findViewById(R.id.drive_thumbnail_bar_slot);
        if (r111 == null) goto L45;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if ((r112 instanceof CoordinatorLayout.LayoutParams) == false) goto L34;
        r102 = (CoordinatorLayout.LayoutParams) r112;
    L34:
        if (r102 == null) goto L45;
        if (r111.getVisibility() != 0) goto L39;
        int r113 = RangesKt.coerceAtLeast(r109, 0);
    L41:
        if (((ViewGroup.MarginLayoutParams) r102).bottomMargin == r113) goto L45;
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = r113;
        r111.setLayoutParams(r102);
        goto L45
    L39:
        r113 = 0;
    L45:
        if (this.f224222d.invoke().booleanValue() == true) goto L48;
        r105 = r110;
    L48:
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = r106 + r105;
        r100.setLayoutParams(r103);
        r100.requestLayout();
        this.f224223e.invoke(Integer.valueOf(r110));
        return;
    L22:
        if (r108.getVisibility() != 0) goto L23;
        Integer r114 = this.f224234p;
        if (r114 == null) goto L27;
        r109 = r114.intValue();
        goto L28
    L27:
        r109 = g(r108);
        goto L28
    L17:
        r106 = 0;
        goto L18
    L8:
        r103 = null;
        goto L9
    }

    public static final void a(k r100) {
        FrameLayout r101 = (FrameLayout) r100.f224219a.findViewById(R.id.drive_ai_side_container);
        if (r101 == null) goto L16;
        int r102 = 0;
        if (r100.f224241w == true) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L14;
        r102 = 8;
    L14:
        r101.setVisibility(r102);
        return;
    L8:
        if (r100.f224235q == true) goto L10;
        r103 = true;
        goto L11
    }

    public static final void b(k r100) {
        FrameLayout r101 = (FrameLayout) r100.f224219a.findViewById(R.id.drive_ai_bottom_container);
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getVisibility() == 0) goto L8;
        return;
    L8:
        if (r100.f224234p != null) goto L47;
        int r102 = g(r101);
        if (r102 <= 0) goto L48;
        WindowInsetsCompat r103 = ViewCompat.getRootWindowInsets(r101);
        boolean r104 = true;
        if (r103 != null) goto L16;
    L18:
        boolean r105 = false;
    L20:
        if (r100.f224234p != null) goto L24;
        if (r105 == true) goto L24;
        if (r102 <= 0) goto L24;
        boolean r106 = true;
    L26:
        if (r106 == false) goto L40;
        View r107 = r100.f224219a.findViewById(R.id.main_page_root);
        if (r107 == null) goto L30;
        int r108 = r107.getHeight();
    L31:
        if (r108 > 0) goto L34;
    L37:
        if (r104 == false) goto L40;
        r100.f224234p = Integer.valueOf(r102);
        tt5.a.h("DriveSdk", "cacheAiBottomBaseHeight height=" + r102 + ", rootHeight=" + r100.f224219a.getHeight());
        return;
    L34:
        if (r102 < (r108 / 2)) goto L37;
        r104 = false;
        goto L37
    L30:
        r108 = 0;
    L40:
        if (r105 == false) goto L45;
        tt5.a.h("DriveSdk", "skipAiBottomBaseHeightCacheForIme candidateHeight=" + r102);
        return;
    L45:
        return;
    L24:
        r106 = false;
        goto L26
    L16:
        if (r103.isVisible(WindowInsetsCompat.Type.ime()) != true) goto L18;
        r105 = true;
        goto L20
    L48:
        return;
    }

    public static int g(FrameLayout r100) {
        boolean r101 = true;
        int r102 = f(r100, true);
        if (r102 > 0) goto L5;
        return 0;
    L5:
        Integer r103 = Integer.valueOf(r100.getHeight());
        if (r103.intValue() <= 0) goto L8;
        boolean r104 = true;
    L9:
        Integer r105 = null;
        if (r104 == true) goto L13;
        r103 = null;
    L13:
        if (r103 != null) goto L23;
        r103 = Integer.valueOf(r100.getMeasuredHeight());
        if (r103.intValue() <= 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == true) goto L22;
        r103 = null;
    L22:
        if (r103 != null) goto L23;
        int r107 = 0;
    L25:
        if (r107 <= 0) goto L38;
        if (r102 <= r107) goto L38;
        Integer r108 = Integer.valueOf(f(r100, false));
        int r109 = r108.intValue();
        if (r109 <= 0) goto L32;
        if (r109 > r107) goto L32;
    L33:
        if (r101 == false) goto L35;
        r105 = r108;
    L35:
        if (r105 != null) goto L37;
        return 0;
    L37:
        return r105.intValue();
    L32:
        r101 = false;
    L38:
        return r102;
    L18:
        r106 = false;
    L23:
        r107 = r103.intValue();
        goto L25
    L8:
        r104 = false;
        goto L9
    }

    public final void d(boolean r100) {
        if (r100 == false) goto L4;
        this.f224228j.clear();
    L4:
        t75.h r101 = this.f224229k;
        r101.f544895a = null;
        r101.f544896b = null;
        r101.f544897c = null;
        b r102 = this.f224231m;
        if ((r102 instanceof b) == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L11;
        r102.f224249e = false;
        r102.f224250f.f224221c.clear();
    L11:
        b r103 = this.f224231m;
        if (r103 == null) goto L14;
        r103.d();
    L14:
        b r104 = this.f224231m;
        if (r104 == null) goto L17;
        r104.c();
    L17:
        b r105 = this.f224231m;
        if (r105 == null) goto L20;
        r105.h(false);
    L20:
        b r106 = this.f224231m;
        if (r106 == null) goto L23;
        r106.e(false);
    L23:
        this.f224231m = null;
    }

    public final void i(Configuration r100) {
        if (this.f224232n == false) goto L5;
        return;
    L5:
        boolean r101 = false;
        if (r100 == null) goto L8;
        int r102 = r100.orientation;
    L9:
        Activity r103 = q.a(this.f224219a.getContext());
        if (r103 == null) goto L12;
        int r104 = r103.getRequestedOrientation();
    L13:
        boolean r105 = ku5.c.k(this.f224219a.getContext());
        if (r102 == 2) goto L18;
        if (r104 == 0) goto L18;
        boolean r106 = false;
    L19:
        if (r106 == false) goto L23;
        if (r105 == true) goto L23;
        r101 = true;
    L23:
        if (this.f224242x != r101) goto L25;
        return;
    L25:
        this.f224242x = r101;
        c();
        StringBuilder r107 = new StringBuilder("updateAiBottomPhoneLandscapeState phoneLandscape=");
        r107.append(r101);
        r107.append(", orientation=");
        if (r100 == null) goto L28;
        Integer r108 = Integer.valueOf(r100.orientation);
    L29:
        r107.append(r108);
        tt5.a.h("DriveSdk", r107.toString());
        return;
    L28:
        r108 = null;
    L18:
        r106 = true;
        goto L19
    L12:
        r104 = -1;
        goto L13
    L8:
        r102 = 0;
        goto L9
    }

    public static int f(FrameLayout r100, boolean r101) {
        int r102 = 0;
        if (r100.getVisibility() == 0) goto L5;
        return 0;
    L5:
        int r103 = r100.getChildCount();
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r104 >= r103) goto L8;
        r105 = Math.max(r105, h(r100.getChildAt(r104), r101));
        r104 = r104 + 1;
        goto L6
    L8:
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
    L12:
        if (r105 <= 0) goto L23;
        int r108 = (r100.getPaddingTop() + r105) + r100.getPaddingBottom();
        if (r107 == null) goto L16;
        int r109 = r107.topMargin;
    L17:
        int r110 = r108 + r109;
        if (r107 == null) goto L21;
        r102 = r107.bottomMargin;
    L21:
        return r102 + r110;
    L16:
        r109 = 0;
        goto L17
    L23:
        return 0;
    L11:
        r107 = null;
        goto L12
    }

    public static int h(View r100, boolean r101) {
        int r102 = 0;
        if (r100.getVisibility() == 0) goto L5;
        return 0;
    L5:
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        Integer r104 = null;
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r103;
    L9:
        boolean r106 = true;
        if ((r100 instanceof ViewGroup) == false) goto L34;
        ViewGroup r107 = (ViewGroup) r100;
        if (r107.getChildCount() <= 0) goto L34;
        if (r107.getVisibility() != 0) goto L53;
        int r108 = r107.getPaddingTop() + r107.getPaddingBottom();
        if ((r107 instanceof LinearLayout) == false) goto L23;
        LinearLayout r109 = (LinearLayout) r107;
        if (r109.getOrientation() != 1) goto L23;
        int r110 = r109.getChildCount();
        int r111 = 0;
        int r112 = 0;
    L21:
        if (r111 >= r110) goto L31;
        r112 = r112 + h(r107.getChildAt(r111), r101);
        r111 = r111 + 1;
    L31:
        int r113 = r108 + r112;
        if (r113 <= (r107.getPaddingTop() + r107.getPaddingBottom())) goto L53;
    L54:
        if (r105 == null) goto L56;
        int r114 = r105.topMargin;
    L57:
        int r115 = r113 + r114;
        if (r105 == null) goto L61;
        r102 = r105.bottomMargin;
    L61:
        return r115 + r102;
    L56:
        r114 = 0;
    L23:
        int r116 = r107.getChildCount();
        int r117 = 0;
        r112 = 0;
    L24:
        if (r117 >= r116) goto L31;
        View r118 = r107.getChildAt(r117);
        Intrinsics.checkNotNull(r118);
        int r119 = h(r118, r101);
        if (r119 <= 0) goto L30;
        if (r101 == false) goto L29;
        r119 = r119 + r118.getTop();
    L29:
        r112 = Math.max(r112, r119);
    L30:
        r117 = r117 + 1;
    L53:
        r113 = 0;
    L34:
        ViewGroup.LayoutParams r120 = r100.getLayoutParams();
        if (r120 == null) goto L45;
        Integer r121 = Integer.valueOf(r120.height);
        if (r121.intValue() <= 0) goto L39;
        boolean r122 = true;
    L40:
        if (r122 == true) goto L43;
        r121 = null;
    L43:
        if (r121 == null) goto L45;
        r113 = r121.intValue();
        goto L54
    L39:
        r122 = false;
    L45:
        Integer r123 = Integer.valueOf(r100.getMeasuredHeight());
        if (r123.intValue() > 0) goto L49;
        r106 = false;
    L49:
        if (r106 == false) goto L51;
        r104 = r123;
    L51:
        if (r104 == null) goto L53;
        r113 = r104.intValue();
        goto L54
    L8:
        r105 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(View r100, LifecycleOwner r101, DriveFullScreenVM r102, DriveAiInteractionVM r103, Function0<Boolean> r104, Function1<? super Integer, Unit> r105, Function1<? super Boolean, Unit> r106, Function0<Integer> r107, Function2<Object, ? super Boolean, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "aiInteractionVM");
        Intrinsics.checkNotNullParameter(r104, "mediaImmersiveActiveProvider");
        Intrinsics.checkNotNullParameter(r105, "mediaBottomInsetConsumer");
        Intrinsics.checkNotNullParameter(r106, "mediaOverlayTemporaryStateConsumer");
        Intrinsics.checkNotNullParameter(r107, "thumbnailOccupiedHeightProvider");
        Intrinsics.checkNotNullParameter(r110, "thumbnailSuppressionConsumer");
        this.f224219a = r100;
        this.f224220b = r101;
        this.f224221c = r103;
        this.f224222d = r104;
        this.f224223e = r105;
        this.f224224f = r106;
        this.f224225g = r107;
        this.f224226h = r110;
        this.f224228j = new LinkedHashSet();
        this.f224229k = new t75.h();
        this.f224230l = new LinkedHashSet();
        this.f224236r = Collections.newSetFromMap(new IdentityHashMap());
        this.f224237s = new IdentityHashMap();
        this.f224238t = Collections.newSetFromMap(new IdentityHashMap());
        if (r102 == null) goto L7;
        MutableLiveData<com.bytedance.ee.bear.drive.biz.preview.screen.a> r108 = r102.getLiveFullScreen();
        if (r108 == null) goto L7;
        r108.observe(r101, new m(this));
    L7:
        n r109 = this.f224244z;
        if (r109 != null) goto L11;
        r109 = new n(this);
        this.f224244z = r109;
    L11:
        if (this.A == true) goto L13;
        r100.getContext().getApplicationContext().registerComponentCallbacks(r109);
        this.A = true;
    L13:
        i(r100.getResources().getConfiguration());
    }
}
