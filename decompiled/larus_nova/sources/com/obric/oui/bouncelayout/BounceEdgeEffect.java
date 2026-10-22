package com.obric.oui.bouncelayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.lsposed.hiddenapibypass.HiddenApiBypass;

/* JADX INFO: loaded from: classes27.dex */
public final class BounceEdgeEffect extends EdgeEffect {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final WeakHashMap<View, a.C4666a> f398877u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f398878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f398880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f398881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f398882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f398883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super Float, Unit> f398884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f398885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f398886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f398887j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f398888k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f398889l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.obric.oui.orecyclerview.base.d f398890m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f398891n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DisplayMetrics f398892o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f398893p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f398894q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f398895r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f398896s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f398897t;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Orientation;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Orientation {
    }

    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.bouncelayout.BounceEdgeEffect$a$a, reason: collision with other inner class name */
        public static final class C4666a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f398898a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f398899b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f398900c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f398901d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public long f398902e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f398903f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public long f398904g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public int f398905h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public long f398906i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f398907j;

            public C4666a() {
                this.f398898a = -1;
                this.f398899b = -1;
                this.f398900c = -1;
                this.f398901d = -1;
                this.f398902e = -1;
                this.f398903f = -1;
                this.f398904g = -1;
                this.f398906i = -1;
            }
        }

        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "signature");
            HiddenApiBypass.addHiddenApiExemptions(new String[]{r100});     // Catch: Throwable -> L5
            return;
        L5:
            Intrinsics.stringPlus("Failed to bypass hidden API restrictions for ", r100);
        }
    }

    public static boolean h(int r100) {
        if (r100 == 0) goto L8;
        if (r100 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    static {
        f398877u = new WeakHashMap();
    }

    public final boolean g() {
        int r100 = this.f398879b;
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L12;
        if (this.f398878a.canScrollHorizontally(-1) == false) goto L9;
        return false;
    L9:
        if (this.f398878a.canScrollHorizontally(1) == true) goto L18;
    L15:
        return true;
    L18:
        return false;
    L12:
        if (this.f398878a.canScrollVertically(-1) == false) goto L14;
        return false;
    L14:
        if (this.f398878a.canScrollVertically(1) == false) goto L15;
        return false;
    }

    @Override // android.widget.EdgeEffect
    public final float getDistance() {
        if (this.f398881d > 0) goto L6;
        return 0.0f;
    L6:
        r();
        return this.f398885h / this.f398881d;
    }

    @Override // android.widget.EdgeEffect
    public final boolean isFinished() {
        if (this.f398891n == (-1)) goto L5;
        return false;
    L5:
        if (this.f398883f != 0.0f) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r100 = false;
        goto L8
    }

    public final void l() {
        int r100 = c.f399049a;
        this.f398891n = -1;
        this.f398885h = 0.0f;
        n(0.0f, false);
        this.f398886i = 1.0f;
        this.f398887j = false;
        this.f398889l = true;
        m();
        this.f398878a.invalidate();
    }

    public final void m() {
        this.f398893p = this.f398883f;
        this.f398894q = -1;
        this.f398895r = 0.0f;
        this.f398896s = -1;
    }

    @Override // android.widget.EdgeEffect
    public final void onRelease() {
        this.f398897t = -1;
        long r100 = AnimationUtils.currentAnimationTimeMillis();
        a.C4666a r101 = s();
        int r102 = d(r101);
        if (r102 != (-1)) goto L5;
    L8:
        boolean r103 = false;
        if (h(this.f398879b) == false) goto L16;
        if (r101.f398900c == r100) goto L13;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == false) goto L24;
        l();
        return;
    L24:
        float r105 = this.f398883f;
        float r106 = 0.0f;
        if (r105 != 0.0f) goto L27;
        r103 = true;
    L27:
        if (r103 == false) goto L30;
        this.f398885h = 0.0f;
        this.f398891n = -1;
        this.f398889l = true;
        m();
        a();
        return;
    L30:
        float r107 = r105 / this.f398892o.density;
        long r108 = AnimationUtils.currentAnimationTimeMillis();
        long r109 = this.f398896s;
        if (r109 != (-1)) goto L33;
    L35:
        float r110 = r106 / this.f398892o.density;
        int r111 = c.f399049a;
        if (h(this.f398879b) == false) goto L38;
        r101.f398900c = r100;
        r101.f398901d = this.f398879b;
    L39:
        i();
        this.f398891n = r100;
        if (this.f398890m != null) goto L42;
        this.f398890m = new com.obric.oui.orecyclerview.base.d();
    L42:
        com.obric.oui.orecyclerview.base.d r112 = this.f398890m;
        if (r112 == null) goto L46;
        r112.a(r110, r107);
    L46:
        m();
        this.f398878a.invalidate();
        return;
    L38:
        r101.f398902e = r100;
        r101.f398903f = this.f398879b;
        goto L39
    L33:
        if ((r108 - r109) > 120) goto L35;
        r106 = this.f398895r;
        goto L35
    L13:
        if (r101.f398901d == this.f398879b) goto L20;
    L19:
        r104 = true;
        goto L21
    L16:
        if (r101.f398902e != r100) goto L20;
        if (r101.f398903f == this.f398879b) goto L20;
    L5:
        if (r102 == this.f398879b) goto L8;
        Intrinsics.stringPlus("inactiveEdge activeOrientation=", Integer.valueOf(r102));
        l();
    }

    public final void q() {
        if (this.f398891n == (-1)) goto L5;
    L11:
        int r100 = com.obric.oui.orecyclerview.base.b.f401540a;
        this.f398885h = com.obric.oui.orecyclerview.base.b.a.a(Math.abs(this.f398883f), this.f398880c);
        this.f398891n = -1;
        this.f398889l = true;
        m();
        this.f398897t = AnimationUtils.currentAnimationTimeMillis() + 120;
        this.f398878a.invalidate();
        return;
    L5:
        if (this.f398883f != 0.0f) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        if (this.f398885h > 0.0f) goto L11;
        return;
    L7:
        r101 = false;
        goto L8
    }

    public final void r() {
        if (this.f398880c <= 0.0f) goto L18;
        float r100 = this.f398883f;
        boolean r101 = false;
        if (r100 != 0.0f) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L20;
        int r103 = com.obric.oui.orecyclerview.base.b.f401540a;
        float r104 = com.obric.oui.orecyclerview.base.b.a.a(Math.abs(r100), this.f398880c);
        if (this.f398891n == (-1)) goto L13;
    L16:
        this.f398885h = r104;
        return;
    L13:
        if (this.f398885h != 0.0f) goto L15;
        r101 = true;
    L15:
        if (r101 == true) goto L16;
        return;
    L20:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final a.C4666a s() {
        WeakHashMap<View, a.C4666a> r100 = f398877u;
        monitor-enter(r100);
        View r101 = this.f398878a;     // Catch: Throwable -> L10
        a.C4666a r102 = r100.get(r101);     // Catch: Throwable -> L10
        if (r102 != null) goto L7;
        r102 = new a.C4666a();     // Catch: Throwable -> L10
        r100.put(r101, r102);     // Catch: Throwable -> L10
    L7:
        a.C4666a r103 = r102;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return r103;
    L10:
        th = move-exception;
        throw th;
    }

    public final void a() {
        a.C4666a r100 = s();
        int r101 = d(r100);
        int r102 = this.f398879b;
        if (r101 == r102) goto L5;
        return;
    L5:
        if (h(r102) == false) goto L7;
        r100.f398898a = -1;
    L8:
        int r103 = c.f399049a;
        return;
    L7:
        r100.f398899b = -1;
        goto L8
    }

    public final void c() {
        super.finish();
        this.f398891n = -1;
        this.f398885h = 0.0f;
        n(0.0f, false);
        this.f398886i = 1.0f;
        this.f398887j = false;
        this.f398889l = true;
        m();
        this.f398897t = -1;
        a();
        this.f398878a.invalidate();
    }

    @Override // android.widget.EdgeEffect
    public final void finish() {
        long r100 = AnimationUtils.currentAnimationTimeMillis();
        if (this.f398897t < r100) goto L20;
        boolean r101 = false;
        if (this.f398883f != 0.0f) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
    L11:
        super.finish();
        this.f398891n = -1;
        r();
        this.f398889l = true;
        m();
        this.f398897t = -1;
        if (this.f398883f != 0.0f) goto L14;
        r101 = true;
    L14:
        if (r101 == true) goto L16;
    L17:
        i();
    L18:
        this.f398878a.invalidate();
        int r103 = c.f399049a;
        return;
    L16:
        if (this.f398885h <= 0.0f) goto L18;
    L10:
        if (this.f398885h <= 0.0f) goto L20;
    L7:
        r102 = false;
    L20:
        c();
    }

    public final void i() {
        a.C4666a r100 = s();
        int r101 = d(r100);
        int r102 = this.f398879b;
        if (r101 != r102) goto L5;
        return;
    L5:
        if (h(r102) == false) goto L7;
        r100.f398898a = r102;
    L8:
        int r103 = c.f399049a;
        return;
    L7:
        r100.f398899b = r102;
        goto L8
    }

    public final void b(float r100) {
        if (this.f398887j == false) goto L6;
        return;
    L6:
        if (r100 != 0.0f) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        View r102 = this.f398878a;
        float r103 = -1.0f;
        if ((r102 instanceof NestedScrollView) == false) goto L18;
        if (this.f398879b != 0) goto L18;
        if (r100 < 0.0f) goto L27;
    L26:
        r103 = 1.0f;
    L27:
        this.f398886i = r103;
        this.f398887j = true;
        return;
    L18:
        if ((r102 instanceof HorizontalScrollView) == false) goto L24;
        if (this.f398879b != 2) goto L24;
        if (r100 >= 0.0f) goto L26;
    L24:
        if ((r102 instanceof HorizontalScrollView) == false) goto L26;
        int r104 = this.f398879b;
        goto L26
    L8:
        r101 = false;
        goto L9
    }

    public final int d(a.C4666a r100) {
        if (h(this.f398879b) == false) goto L6;
        return r100.f398898a;
    L6:
        return r100.f398899b;
    }

    @Override // android.widget.EdgeEffect
    public final boolean draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        com.obric.oui.orecyclerview.base.d r101 = this.f398890m;
        if (this.f398891n == (-1)) goto L10;
        if (r101 == null) goto L10;
        com.obric.oui.orecyclerview.base.d.a r102 = r101.b(AnimationUtils.currentAnimationTimeMillis() - this.f398891n);
        n(TypedValue.applyDimension(1, r102.f401549a, this.f398892o), false);
        int r103 = c.f399049a;
        if (r102.f401550b == true) goto L9;
        this.f398878a.invalidate();
        return true;
    L9:
        n(0.0f, false);
        this.f398891n = -1;
        this.f398885h = 0.0f;
        this.f398886i = 1.0f;
        this.f398887j = false;
        this.f398889l = true;
        m();
        a();
    L10:
        return false;
    }

    public final float e(float r100) {
        if ((this.f398878a instanceof HorizontalScrollView) == false) goto L22;
        int r101 = this.f398879b;
        if (r101 == 2) goto L7;
        if (r101 != 3) goto L22;
    L7:
        float r102 = Math.abs(r100) * this.f398881d;
        int r103 = this.f398879b;
        boolean r104 = false;
        if (r103 == 2) goto L15;
        if (r103 == 3) goto L12;
    L10:
        r104 = true;
    L17:
        if (r104 == false) goto L20;
        return r102;
    L20:
        return -r102;
    L12:
        if (this.f398888k <= 0.0f) goto L17;
    L15:
        if (this.f398888k >= 0.0f) goto L17;
    L22:
        return (r100 * this.f398886i) * this.f398881d;
    }

    public final boolean f(float r100) {
        if (r100 != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return false;
    L9:
        if (this.f398885h <= 0.0f) goto L11;
        return true;
    L11:
        b(r100);
        if (e(r100) > 0.0f) goto L14;
        return false;
    L14:
        int r102 = this.f398879b;
        if (r102 == 0) goto L32;
        if (r102 == 1) goto L29;
        if (r102 == 2) goto L26;
        if (r102 == 3) goto L23;
        return false;
    L23:
        if (this.f398878a.canScrollHorizontally(1) == true) goto L35;
    L33:
        return true;
    L35:
        return false;
    L26:
        if (this.f398878a.canScrollHorizontally(-1) == false) goto L33;
        return false;
    L29:
        if (this.f398878a.canScrollVertically(1) == false) goto L33;
        return false;
    L32:
        if (this.f398878a.canScrollVertically(-1) == false) goto L33;
        return false;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.widget.EdgeEffect
    public final void onAbsorb(int r110) {
        this.f398897t = -1;
        if (this.f398880c > 0.0f) goto L6;
        return;
    L6:
        if (this.f398891n == (-1)) goto L9;
        int r111 = c.f399049a;
        return;
    L9:
        int r100 = c.f399049a;
        m();
        i();
        int r101 = this.f398879b;
        if (r101 != 1) goto L12;
    L15:
        int r112 = -Math.abs(r110);
    L16:
        float r113 = (r112 / 1000.0f) / this.f398892o.density;
        long r102 = AnimationUtils.currentAnimationTimeMillis();
        this.f398891n = r102;
        if (this.f398890m != null) goto L19;
        this.f398890m = new com.obric.oui.orecyclerview.base.d();
    L19:
        float r103 = this.f398883f / this.f398892o.density;
        com.obric.oui.orecyclerview.base.d r104 = this.f398890m;
        if (r104 == null) goto L23;
        r104.a(r113, r103);
    L23:
        if (r104 == null) goto L48;
        Display r114 = this.f398878a.getDisplay();
        WindowManager r105 = null;
        if (r114 != null) goto L27;
        Float r115 = null;
    L28:
        if (r115 != null) goto L38;
        Object r116 = this.f398878a.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r116 instanceof WindowManager) == false) goto L32;
        r105 = (WindowManager) r116;
    L32:
        if (r105 == null) goto L36;
        Display r117 = r105.getDefaultDisplay();
        if (r117 == null) goto L36;
        float r118 = r117.getRefreshRate();
    L40:
        if (r118 <= 0.0f) goto L42;
        float r106 = 1000.0f / r118;
    L44:
        if (r106 <= 0.0f) goto L48;
        this.f398891n = r102 - MathKt.roundToLong(r106);
        com.obric.oui.orecyclerview.base.d.a r119 = r104.b(r106);
        n(TypedValue.applyDimension(1, r119.f401549a, this.f398892o), false);
        if (r119.f401550b == false) goto L48;
        n(0.0f, false);
        this.f398891n = -1;
        this.f398885h = 0.0f;
        this.f398886i = 1.0f;
        this.f398887j = false;
        this.f398889l = true;
        a();
        goto L48
    L42:
        r106 = 16.67f;
    L36:
        r118 = 0.0f;
        goto L40
    L38:
        r118 = r115.floatValue();
        goto L40
    L27:
        r115 = Float.valueOf(r114.getRefreshRate());
    L48:
        this.f398878a.invalidate();
        return;
    L12:
        if (r101 == 3) goto L15;
        r112 = Math.abs(r110);
        goto L16
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float r100) {
        onPull(r100, 0.5f);
    }

    public final float j(float r100, boolean r110) {
        if (this.f398881d > 0) goto L5;
    L81:
        return 0.0f;
    L5:
        if (this.f398880c <= 0.0f) goto L81;
        boolean r101 = false;
        if (r100 != 0.0f) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        return 0.0f;
    L13:
        this.f398897t = -1;
        int r103 = c.f399049a;
        b(r100);
        if (this.f398891n == (-1)) goto L16;
        int r104 = com.obric.oui.orecyclerview.base.b.f401540a;
        this.f398885h = com.obric.oui.orecyclerview.base.b.a.a(Math.abs(this.f398883f), this.f398880c);
        this.f398891n = -1;
        this.f398889l = true;
        m();
    L16:
        ViewParent r105 = this.f398878a.getParent();
        if (r105 == null) goto L20;
        r105.requestDisallowInterceptTouchEvent(true);
    L20:
        r();
        float r106 = e(r100);
        if (this.f398885h != 0.0f) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == true) goto L26;
    L32:
        long r108 = AnimationUtils.currentAnimationTimeMillis();
        if (p(r106, r108) == false) goto L36;
        this.f398878a.invalidate();
        return r100;
    L36:
        float r111 = this.f398885h + r106;
        if (o(r106, r111, r108) == false) goto L40;
        i();
        this.f398878a.invalidate();
        return r100;
    L40:
        float r109 = Math.abs(this.f398883f);
        if (r106 >= 0.0f) goto L49;
        if (r109 <= 0.0f) goto L49;
        float r112 = r109 + r106;
        if (r112 <= 0.0f) goto L47;
        int r113 = com.obric.oui.orecyclerview.base.b.f401540a;
        this.f398885h = com.obric.oui.orecyclerview.base.b.a.a(r112, this.f398880c);
    L54:
        k(s(), r108, r106);
        int r114 = this.f398879b;
        if (r114 == 0) goto L69;
        if (r114 != 1) goto L58;
    L68:
        float r115 = -1.0f;
    L70:
        int r116 = com.obric.oui.orecyclerview.base.b.f401540a;
        float r117 = r115 * Math.abs(com.obric.oui.orecyclerview.base.b.a.b(this.f398885h, this.f398880c));
        n(r117, true);
        if (this.f398885h <= 0.0f) goto L73;
    L78:
        i();
    L79:
        this.f398878a.invalidate();
        return r100;
    L73:
        if (r117 != 0.0f) goto L75;
        r101 = true;
    L75:
        if (r101 == false) goto L78;
        a();
        goto L79
    L58:
        if (r114 == 2) goto L69;
        if (r114 == 3) goto L68;
        float r118 = this.f398883f;
        if (r118 != 0.0f) goto L64;
        boolean r119 = true;
    L65:
        if (r119 == true) goto L69;
        r115 = Math.signum(r118);
        goto L70
    L64:
        r119 = false;
    L69:
        r115 = 1.0f;
        goto L70
    L47:
        r100 = ((-r109) / this.f398881d) / this.f398886i;
        this.f398885h = 0.0f;
        a();
    L49:
        if (r111 <= 0.0f) goto L53;
        this.f398885h = r111;
        if (r106 <= 0.0f) goto L54;
        this.f398889l = true;
        goto L54
    L53:
        r100 = ((-this.f398885h) / this.f398881d) * this.f398886i;
        this.f398885h = 0.0f;
        a();
        goto L54
    L26:
        if (f(r100) == true) goto L32;
        if (r110 == true) goto L29;
    L30:
        n(0.0f, false);
        m();
        return 0.0f;
    L29:
        if (r106 > 0.0f) goto L32;
    L23:
        r107 = false;
        goto L24
    L10:
        r102 = false;
        goto L11
    }

    public final void n(float r100, boolean r101) {
        if (r101 == false) goto L10;
        long r102 = AnimationUtils.currentAnimationTimeMillis();
        long r103 = this.f398894q;
        if (r103 != (-1)) goto L6;
    L8:
        this.f398893p = r100;
        this.f398894q = r102;
        int r104 = c.f399049a;
        goto L10
    L6:
        if (r102 <= r103) goto L8;
        this.f398895r = RangesKt.coerceIn((r100 - this.f398893p) / (r102 - r103), -20.0f, 20.0f);
        this.f398896s = r102;
    L10:
        if (this.f398883f != r100) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L18;
        this.f398883f = r100;
        Function1<? super Float, Unit> r106 = this.f398884g;
        if (r106 == null) goto L18;
        r106.invoke(Float.valueOf(r100));
    L18:
        int r107 = c.f399049a;
        return;
    L12:
        r105 = false;
        goto L13
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float r100, float r101) {
        if (this.f398881d > 0) goto L5;
        return;
    L5:
        if (this.f398880c <= 0.0f) goto L64;
        boolean r102 = false;
        if (r100 != 0.0f) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return;
    L13:
        this.f398897t = -1;
        int r104 = c.f399049a;
        b(r100);
        if (this.f398891n == (-1)) goto L16;
        int r105 = com.obric.oui.orecyclerview.base.b.f401540a;
        this.f398885h = com.obric.oui.orecyclerview.base.b.a.a(Math.abs(this.f398883f), this.f398880c);
        this.f398891n = -1;
        this.f398889l = true;
        m();
    L16:
        ViewParent r106 = this.f398878a.getParent();
        if (r106 == null) goto L20;
        r106.requestDisallowInterceptTouchEvent(true);
    L20:
        r();
        if (this.f398885h != 0.0f) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == true) goto L26;
    L29:
        float r108 = e(r100);
        long r109 = AnimationUtils.currentAnimationTimeMillis();
        if (p(r108, r109) == false) goto L33;
        this.f398878a.invalidate();
        return;
    L33:
        float r110 = this.f398885h + r108;
        if (o(r108, r110, r109) == false) goto L37;
        i();
        this.f398878a.invalidate();
        return;
    L37:
        float r111 = RangesKt.coerceAtLeast(r110, 0.0f);
        this.f398885h = r111;
        if (r108 > 0.0f) goto L40;
    L42:
        k(s(), r109, r108);
        int r112 = com.obric.oui.orecyclerview.base.b.f401540a;
        float r113 = com.obric.oui.orecyclerview.base.b.a.b(this.f398885h, this.f398880c);
        int r114 = this.f398879b;
        if (r114 == 0) goto L51;
        if (r114 != 1) goto L46;
    L50:
        r113 = -Math.abs(r113);
    L52:
        n(r113, true);
        if (this.f398885h <= 0.0f) goto L55;
    L60:
        i();
    L61:
        this.f398878a.invalidate();
        return;
    L55:
        if (r113 != 0.0f) goto L57;
        r102 = true;
    L57:
        if (r102 == false) goto L60;
        a();
        goto L61
    L46:
        if (r114 == 2) goto L51;
        if (r114 == 3) goto L50;
    L51:
        r113 = Math.abs(r113);
        goto L52
    L40:
        if (r111 <= 0.0f) goto L42;
        this.f398889l = true;
        goto L42
    L26:
        if (f(r100) == true) goto L29;
        n(0.0f, false);
        m();
        return;
    L23:
        r107 = false;
        goto L24
    L10:
        r103 = false;
        goto L11
    }

    @Override // android.widget.EdgeEffect
    public final float onPullDistance(float r100, float r101) {
        return j(r100, false);
    }

    public final boolean p(float r100, long r101) {
        if (r100 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return false;
    L8:
        a.C4666a r103 = s();
        int r104 = d(r103);
        if (r104 == (-1)) goto L15;
        if (r104 == this.f398879b) goto L15;
        int r105 = c.f399049a;
        return true;
    L15:
        if (g() == false) goto L30;
        if (r100 >= 0.0f) goto L30;
        if (h(this.f398879b) == false) goto L20;
        long r106 = r103.f398904g;
    L22:
        if (r106 != r101) goto L30;
        if (h(this.f398879b) == false) goto L26;
        int r107 = r103.f398905h;
    L27:
        if (r107 <= 0) goto L30;
        int r108 = c.f399049a;
        return true;
    L26:
        r107 = r103.f398907j;
        goto L27
    L20:
        r106 = r103.f398906i;
    L30:
        return false;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.widget.EdgeEffect
    public final void setSize(int r100, int r101) {
        super.setSize(r100, r101);
        int r102 = this.f398879b;
        if (r102 == 2) goto L7;
        if (r102 == 3) goto L7;
    L8:
        r100 = r101;
    L9:
        this.f398881d = r100;
        return;
    L7:
        if (this.f398882e == false) goto L9;
        goto L8
    }

    public final void k(a.C4666a r100, long r101, float r102) {
        int r103 = (int) Math.signum(r102);
        if (r103 != 0) goto L6;
        return;
    L6:
        if (h(this.f398879b) == false) goto L8;
        r100.f398904g = r101;
        r100.f398905h = r103;
        return;
    L8:
        r100.f398906i = r101;
        r100.f398907j = r103;
    }

    public final boolean o(float r100, float r101, long r102) {
        if (this.f398885h > 0.0f) goto L5;
    L28:
        return false;
    L5:
        if (r100 >= 0.0f) goto L28;
        if (r101 > 0.0f) goto L28;
        if (this.f398889l == false) goto L28;
        if (g() == false) goto L28;
        a.C4666a r103 = s();
        if (h(this.f398879b) == false) goto L17;
        long r104 = r103.f398904g;
    L19:
        if (r104 != r102) goto L28;
        if (h(this.f398879b) == false) goto L23;
        int r105 = r103.f398905h;
    L24:
        if (r105 <= 0) goto L28;
        this.f398889l = false;
        int r106 = c.f399049a;
        return true;
    L23:
        r105 = r103.f398907j;
        goto L24
    L17:
        r104 = r103.f398906i;
        goto L19
    }

    public BounceEdgeEffect(Context r100, View r101, int r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        super(r100);
        this.f398878a = r101;
        this.f398879b = r102;
        this.f398880c = r103;
        this.f398886i = 1.0f;
        this.f398889l = true;
        this.f398891n = -1;
        Resources r104 = r100.getResources();
        this.f398892o = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        this.f398894q = -1;
        this.f398896s = -1;
        this.f398897t = -1;
    }
}
