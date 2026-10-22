package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/bouncelayout/OScrollView;", "Landroid/widget/ScrollView;", "", "", "getManualBounceContentVelocityY", "getScrollRangeY", "", "getCurrentFlingVelocity", "Landroid/widget/OverScroller;", "getScrollerOrNull", "getBounceTranslation", "Lcom/obric/oui/bouncelayout/e;", "listener", "", "setOnBounceTranslationListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OScrollView extends ScrollView {
    public final b A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f398993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Field f398994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Field f398995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BounceEdgeEffect f398996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BounceEdgeEffect f398997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EdgeEffect f398998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EdgeEffect f398999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f399000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Field f399001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f399002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f399003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f399004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f399005m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f399006n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f399007o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f399008p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f399009q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f399010r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f399011s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f399012t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f399013u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f399014v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public VelocityTracker f399015w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f399016x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d f399017y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final BounceTranslationDelegate f399018z;

    public static final class a {
    }

    static {
    }

    public OScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OScrollView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getScrollRangeY() {
        View r100 = getChildAt(0);
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return Math.max(0, r100.getHeight() - r101);
    }

    private final OverScroller getScrollerOrNull() {
        Field r100 = this.f399001i;     // Catch: Throwable -> L12
        if (r100 != null) goto L6;
        Object r101 = null;
    L8:
        if ((r101 instanceof OverScroller) == false) goto L15;
        return (OverScroller) r101;
    L15:
        return null;
    L6:
        r101 = r100.get(this);     // Catch: Throwable -> L12
    L16:
        return null;
    }

    public final void g() {
        this.f399008p = false;
        this.f399009q = false;
        int r100 = getManualBounceContentVelocityY();
        int r101 = i();
        this.f399013u = -1;
        this.f399014v = -1;
        this.f399016x = false;
        int r102 = c.f399049a;
        if (r100 == 0) goto L36;
        if (r101 != 1) goto L10;
        if (r100 >= 0) goto L10;
        BounceEdgeEffect r103 = this.f398996d;
        if (r103 == null) goto L47;
        r103.onAbsorb(r100);
    L47:
        this.f399012t = 0;
        VelocityTracker r104 = this.f399015w;
        if (r104 == null) goto L51;
        r104.recycle();
    L51:
        this.f399015w = null;
        invalidate();
        return;
    L10:
        if (r101 != 2) goto L16;
        if (r100 <= 0) goto L16;
        BounceEdgeEffect r105 = this.f398997e;
        if (r105 == null) goto L47;
        r105.onAbsorb(r100);
    L16:
        if (r100 > 0) goto L18;
    L20:
        if (r100 < 0) goto L22;
    L24:
        if (r101 != 0) goto L30;
        if (r100 <= 0) goto L30;
        BounceEdgeEffect r106 = this.f398997e;
        if (r106 == null) goto L47;
        r106.onAbsorb(r100);
    L30:
        if (r101 != 0) goto L36;
        if (r100 >= 0) goto L36;
        BounceEdgeEffect r107 = this.f398996d;
        if (r107 == null) goto L47;
        r107.onAbsorb(r100);
        goto L47
    L22:
        if (canScrollVertically(-1) == false) goto L24;
        this.f399003k = getScrollY();
        this.f399002j = Math.abs(r100);
        this.f399004l = false;
        fling(r100);
        postInvalidateOnAnimation();
        goto L47
    L18:
        if (canScrollVertically(1) == false) goto L20;
        this.f399003k = getScrollY();
        this.f399002j = Math.abs(r100);
        this.f399004l = false;
        fling(r100);
        postInvalidateOnAnimation();
    L36:
        if (r101 == 1) goto L43;
        if (r101 != 2) goto L47;
        BounceEdgeEffect r108 = this.f398997e;
        if (r108 == null) goto L47;
        r108.onRelease();
        goto L47
    L43:
        BounceEdgeEffect r109 = this.f398996d;
        if (r109 == null) goto L47;
        r109.onRelease();
        goto L47
    }

    private final float getCurrentFlingVelocity() {
        OverScroller r100 = getScrollerOrNull();     // Catch: Throwable -> L8
        if (r100 != null) goto L6;
        return 1000.0f;
    L6:
        return r100.getCurrVelocity();
    L11:
        return 1000.0f;
    }

    private final int getManualBounceContentVelocityY() {
        int r100 = this.f399013u;
        VelocityTracker r101 = this.f399015w;
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r100 != (-1)) goto L8;
        return 0;
    L8:
        r101.computeCurrentVelocity(1000, this.f399007o);
        float r102 = r101.getYVelocity(r100);
        if (Math.abs(r102) >= this.f399006n) goto L12;
        return 0;
    L12:
        return MathKt.roundToInt(-r102);
    }

    public float getBounceTranslation() {
        BounceEdgeEffect r100 = this.f398996d;
        float r101 = 0.0f;
        if (r100 != null) goto L5;
        float r102 = 0.0f;
    L6:
        BounceEdgeEffect r103 = this.f398997e;
        if (r103 == null) goto L11;
        r101 = r103.f398883f;
    L11:
        return r102 + r101;
    L5:
        r102 = r100.f398883f;
        goto L6
    }

    public final void h() {
        if (this.f399016x == true) goto L5;
        return;
    L5:
        int r100 = i();
        if (r100 != 1) goto L8;
        BounceEdgeEffect r101 = this.f398996d;
        if (r101 == null) goto L18;
        r101.onRelease();
    L18:
        this.f399016x = false;
        invalidate();
        return;
    L8:
        if (r100 != 2) goto L18;
        BounceEdgeEffect r102 = this.f398997e;
        if (r102 == null) goto L18;
        r102.onRelease();
        goto L18
    }

    public final int i() {
        int r100 = this.f399012t;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        boolean r101 = d(this.f398996d);
        boolean r102 = d(this.f398997e);
        if (r101 == false) goto L9;
        if (r102 == true) goto L9;
    L18:
        return 1;
    L9:
        if (r102 == false) goto L12;
        if (r101 == true) goto L12;
    L25:
        return 2;
    L12:
        BounceEdgeEffect r103 = this.f398996d;
        if (r103 != null) goto L15;
        float r104 = 0.0f;
    L17:
        if (r104 > 0.0f) goto L18;
        BounceEdgeEffect r105 = this.f398997e;
        if (r105 != null) goto L22;
        float r106 = 0.0f;
    L24:
        if (r106 < 0.0f) goto L25;
        return 0;
    L22:
        r106 = r105.f398883f;
        goto L24
    L15:
        r104 = r103.f398883f;
        goto L17
    }

    public final boolean j() {
        if (this.f399000h == true) goto L5;
        return false;
    L5:
        BounceEdgeEffect r100 = this.f398996d;
        if (r100 != null) goto L8;
        float r101 = 0.0f;
    L10:
        if (r101 != 0.0f) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L25;
        BounceEdgeEffect r103 = this.f398997e;
        if (r103 != null) goto L17;
        float r104 = 0.0f;
    L19:
        if (r104 != 0.0f) goto L21;
        boolean r105 = true;
    L22:
        if (r105 == false) goto L25;
        boolean r106 = false;
    L26:
        if (r100 != null) goto L29;
    L31:
        boolean r107 = false;
    L32:
        if (r107 == true) goto L43;
        BounceEdgeEffect r108 = this.f398997e;
        if (r108 != null) goto L37;
    L39:
        boolean r109 = false;
    L40:
        if (r109 == true) goto L43;
        boolean r110 = false;
    L44:
        if (r106 == true) goto L63;
        if (r110 == true) goto L63;
        return false;
    L63:
        OverScroller r111 = getScrollerOrNull();     // Catch: Throwable -> L62
        if (r111 == null) goto L52;
        r111.abortAnimation();     // Catch: Throwable -> L62
    L52:
        BounceEdgeEffect r112 = this.f398996d;
        if (r112 == null) goto L56;
        r112.q();
    L56:
        BounceEdgeEffect r113 = this.f398997e;
        if (r113 == null) goto L60;
        r113.q();
    L60:
        invalidate();
        this.f399002j = 0.0f;
        this.f399003k = getScrollY();
        this.f399004l = false;
        return true;
    L37:
        if (r108.isFinished() == true) goto L39;
        r109 = true;
    L43:
        r110 = true;
        goto L44
    L29:
        if (r100.isFinished() == true) goto L31;
        r107 = true;
        goto L32
    L21:
        r105 = false;
        goto L22
    L17:
        r104 = r103.f398883f;
    L25:
        r106 = true;
        goto L26
    L12:
        r102 = false;
        goto L13
    L8:
        r101 = r100.f398883f;
        goto L10
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f399000h == true) goto L5;
        return;
    L5:
        OverScroller r100 = getScrollerOrNull();
        if (r100 != null) goto L8;
        return;
    L8:
        int r101 = getScrollRangeY();
        if (r101 > 0) goto L11;
        return;
    L11:
        int r102 = getScrollY();
        boolean r103 = true;
        boolean r104 = false;
        if (r100.isFinished() == true) goto L53;
        int r105 = this.f399003k;
        float r106 = r100.getCurrVelocity();
        this.f399002j = r106;
        int r107 = c.f399049a;
        if (this.f399004l == false) goto L16;
    L49:
        if (r104 == false) goto L51;
        return;
    L51:
        this.f399003k = r102;
        return;
    L16:
        if (r106 <= 0.0f) goto L49;
        if (r102 != 0) goto L32;
        if (r105 <= 0) goto L32;
        BounceEdgeEffect r108 = this.f398996d;
        if (r108 != null) goto L24;
    L26:
        boolean r109 = false;
    L27:
        if (r109 == false) goto L32;
        BounceEdgeEffect r110 = this.f398996d;
        if (r110 == null) goto L46;
        r110.onAbsorb((int) r106);
    L46:
        r104 = true;
    L47:
        if (r104 == false) goto L49;
        this.f399004l = true;
        r100.abortAnimation();
        this.f399002j = 0.0f;
        invalidate();
        goto L49
    L24:
        if (r108.isFinished() != true) goto L26;
        r109 = true;
    L32:
        if (r102 != r101) goto L47;
        if (r105 >= r101) goto L47;
        BounceEdgeEffect r111 = this.f398997e;
        if (r111 != null) goto L38;
    L40:
        boolean r112 = false;
    L41:
        if (r112 == false) goto L47;
        BounceEdgeEffect r113 = this.f398997e;
        if (r113 == null) goto L46;
        r113.onAbsorb(-((int) r106));
        goto L46
    L38:
        if (r111.isFinished() != true) goto L40;
        r112 = true;
        goto L41
    L53:
        float r114 = this.f399002j;
        if (r114 <= 0.0f) goto L82;
        if (r102 == 0) goto L57;
    L69:
        if (r102 != r101) goto L82;
        if (this.f399003k >= r101) goto L82;
        BounceEdgeEffect r115 = this.f398997e;
        if (r115 != null) goto L76;
    L74:
        r103 = false;
    L77:
        if (r103 == false) goto L82;
        int r116 = c.f399049a;
        BounceEdgeEffect r117 = this.f398997e;
        if (r117 == null) goto L82;
        r117.onAbsorb(-((int) r114));
        goto L82
    L76:
        if (r115.isFinished() != true) goto L74;
    L57:
        if (this.f399003k <= 0) goto L69;
        BounceEdgeEffect r118 = this.f398996d;
        if (r118 != null) goto L62;
    L60:
        boolean r119 = false;
    L64:
        if (r119 == false) goto L69;
        int r120 = c.f399049a;
        BounceEdgeEffect r121 = this.f398996d;
        if (r121 == null) goto L82;
        r121.onAbsorb((int) r114);
        goto L82
    L62:
        if (r118.isFinished() != true) goto L60;
        r119 = true;
    L82:
        this.f399002j = 0.0f;
        this.f399003k = r102;
        this.f399004l = false;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r100 = this.f398996d;
        if (r100 == null) goto L6;
        r100.c();
    L6:
        BounceEdgeEffect r101 = this.f398997e;
        if (r101 == null) goto L20;
        r101.c();
    L20:
        Field r102 = this.f398994b;     // Catch: Throwable -> L19
        if (r102 == null) goto L14;
        r102.set(this, this.f398998f);     // Catch: Throwable -> L19
    L14:
        Field r103 = this.f398995c;     // Catch: Throwable -> L19
        if (r103 == null) goto L22;
        r103.set(this, this.f398999g);     // Catch: Throwable -> L19
        return;
    L22:
        return;
    }

    public static boolean d(BounceEdgeEffect r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getDistance() != 0.0f) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
    L16:
        return true;
    L10:
        if (r100.f398883f != 0.0f) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L16;
        if (r100.isFinished() == false) goto L16;
        return false;
    L12:
        r102 = false;
        goto L13
    L7:
        r101 = false;
        goto L8
    }

    public final int b(int r100) {
        if (r100 != 0) goto L4;
        return r100;
    L4:
        if (getScrollRangeY() <= 0) goto L9;
        int r101 = getScrollY();
        scrollBy(0, r100);
        return r100 - (getScrollY() - r101);
    L9:
        return r100;
    }

    public final void c(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r101 >= 0) goto L5;
        return;
    L5:
        if (r101 < r100.getPointerCount()) goto L8;
        return;
    L8:
        if (r100.getPointerId(r101) == this.f399013u) goto L10;
        return;
    L10:
        if (r101 != 0) goto L12;
        int r102 = 1;
    L14:
        if (r102 >= r100.getPointerCount()) goto L16;
        m(r102, r100);
        return;
    L16:
        this.f399013u = -1;
        return;
    L12:
        r102 = 0;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        BounceEdgeEffect r101 = this.f398996d;
        if (r101 != null) goto L7;
        float r102 = 0.0f;
    L8:
        BounceEdgeEffect r103 = this.f398997e;
        if (r103 != null) goto L11;
        float r104 = 0.0f;
    L12:
        float r105 = r102 + r104;
        if (r105 != 0.0f) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == true) goto L18;
        int r107 = r100.save();
        r100.translate(0.0f, r105);
        super.dispatchDraw(r100);
        r100.restoreToCount(r107);
        return;
    L18:
        super.dispatchDraw(r100);
        return;
    L15:
        r106 = false;
        goto L16
    L11:
        r104 = r103.f398883f;
        goto L12
    L7:
        r102 = r101.f398883f;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        this.A.c(r100);
        b r101 = this.A;
        Boolean r102 = r101.b(r100, 0.0f, -r101.f399043e, new OScrollView$dispatchTouchEvent$handled$1(this, r100));
        if (r102 != null) goto L5;
        boolean r103 = super.dispatchTouchEvent(r100);
    L7:
        if (r100.getActionMasked() != 1) goto L9;
    L10:
        h();
    L11:
        return r103;
    L9:
        if (r100.getActionMasked() != 3) goto L11;
    L5:
        r103 = r102.booleanValue();
        goto L7
    }

    public final void e(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (getHeight() <= 0) goto L26;
        int r101 = b(r100);
        int r102 = c.f399049a;
        if (r101 < 0) goto L9;
    L14:
        if (r101 > 0) goto L16;
    L21:
        this.f399012t = 0;
        return;
    L16:
        if (getHeight() <= 0) goto L21;
        this.f399012t = 2;
        BounceEdgeEffect r103 = this.f398997e;
        if (r103 == null) goto L28;
        r103.j(r101 / getHeight(), true);
        return;
    L28:
        return;
    L9:
        if (getHeight() <= 0) goto L14;
        this.f399012t = 1;
        BounceEdgeEffect r104 = this.f398996d;
        if (r104 == null) goto L27;
        r104.j((-r101) / getHeight(), true);
        return;
    L27:
        return;
    }

    public final void f(float r100) {
        if (getHeight() > 0) goto L5;
        return;
    L5:
        float r101 = r100 / getHeight();
        boolean r102 = d(this.f398996d);
        boolean r103 = d(this.f398997e);
        if (r102 == false) goto L27;
        this.f399012t = 1;
        BounceEdgeEffect r104 = this.f398996d;
        if (r104 != null) goto L10;
        float r105 = 0.0f;
    L11:
        float r106 = r101 - r105;
        if (r106 >= 0.0f) goto L25;
        int r107 = b(MathKt.roundToInt((-r106) * getHeight()));
        int r108 = c.f399049a;
        if (r107 <= 0) goto L22;
        if (getHeight() <= 0) goto L22;
        this.f399012t = 2;
        BounceEdgeEffect r109 = this.f398997e;
        if (r109 == null) goto L54;
        r109.j(r107 / getHeight(), true);
    L54:
        invalidate();
        return;
    L22:
        if (d(this.f398996d) == true) goto L54;
        this.f399012t = 0;
        goto L54
    L25:
        if (d(this.f398996d) == true) goto L54;
        this.f399012t = 0;
        goto L54
    L10:
        r105 = r104.j(r101, false);
        goto L11
    L27:
        if (r103 == false) goto L49;
        this.f399012t = 2;
        float r110 = -r101;
        BounceEdgeEffect r111 = this.f398997e;
        if (r111 != null) goto L31;
        float r112 = 0.0f;
    L32:
        float r113 = r110 - r112;
        if (r113 >= 0.0f) goto L46;
        int r114 = b(MathKt.roundToInt(r113 * getHeight()));
        int r115 = c.f399049a;
        if (r114 >= 0) goto L43;
        if (getHeight() <= 0) goto L43;
        this.f399012t = 1;
        BounceEdgeEffect r116 = this.f398996d;
        if (r116 == null) goto L54;
        r116.j((-r114) / getHeight(), true);
    L43:
        if (d(this.f398997e) == true) goto L54;
        this.f399012t = 0;
        goto L54
    L46:
        if (d(this.f398997e) == true) goto L54;
        this.f399012t = 0;
        goto L54
    L31:
        r112 = r111.j(r110, false);
        goto L32
    L49:
        if (r100 <= 0.0f) goto L52;
        e(MathKt.roundToInt(-r100));
        goto L54
    L52:
        if (r100 >= 0.0f) goto L54;
        e(MathKt.roundToInt(-r100));
        goto L54
    }

    public final boolean l(MotionEvent r100) {
        if (this.f399000h == true) goto L5;
    L15:
        boolean r101 = false;
    L16:
        if (r101 == true) goto L18;
        return false;
    L18:
        int r102 = r100.findPointerIndex(this.f399013u);
        if (r102 >= 0) goto L21;
        return false;
    L21:
        VelocityTracker r103 = this.f399015w;
        if (r103 == null) goto L25;
        r103.addMovement(r100);
    L25:
        float r104 = r100.getY(r102);
        float r105 = r104 - this.f399010r;
        if (Math.abs(r105) > this.f399005m) goto L29;
    L41:
        boolean r106 = false;
    L43:
        if (r106 == true) goto L45;
        return false;
    L45:
        j();
        int r107 = c.f399049a;
        this.f399008p = true;
        this.f399009q = true;
        this.f399016x = false;
        float r108 = this.f399010r;
        this.f399011s = r108;
        f(r104 - r108);
        this.f399011s = r104;
        this.f399014v = r100.getEventTime();
        ViewParent r109 = getParent();
        if (r109 == null) goto L49;
        r109.requestDisallowInterceptTouchEvent(true);
    L49:
        return true;
    L29:
        if (d(this.f398996d) == false) goto L31;
    L42:
        r106 = true;
        goto L43
    L31:
        if (d(this.f398997e) == true) goto L42;
        if (r105 <= 0.0f) goto L39;
        if (canScrollVertically(-1) == true) goto L41;
    L39:
        if (canScrollVertically(1) == true) goto L41;
    L5:
        if (getHeight() <= 0) goto L15;
        if (getScrollRangeY() > 0) goto L11;
    L14:
        r101 = true;
        goto L16
    L11:
        if (d(this.f398996d) == true) goto L14;
        if (d(this.f398997e) == false) goto L15;
        goto L14
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        boolean r102 = true;
        if (r101 == 0) goto L40;
        if (r101 != 1) goto L6;
    L29:
        this.f399008p = false;
        this.f399009q = false;
        this.f399012t = 0;
        this.f399013u = -1;
        this.f399014v = -1;
        VelocityTracker r103 = this.f399015w;
        if (r103 == null) goto L33;
        r103.recycle();
    L33:
        this.f399015w = null;
        h();
    L35:
        if (this.A.d(r100) == false) goto L38;
        return false;
    L38:
        return super.onInterceptTouchEvent(r100);
    L6:
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L29;
        if (r101 == 5) goto L19;
        if (r101 != 6) goto L35;
        if (this.f399008p == false) goto L35;
        c(r100);
        return true;
    L19:
        if (this.f399008p == false) goto L35;
        m(r100.getActionIndex(), r100);
        return true;
    L23:
        if (this.A.d(r100) == false) goto L26;
        return false;
    L26:
        if (l(r100) == false) goto L35;
        this.f399016x = false;
        return true;
    L40:
        if (j() == false) goto L42;
    L45:
        this.f399016x = r102;
        this.f399008p = false;
        this.f399009q = false;
        this.f399012t = 0;
        this.f399013u = r100.getPointerId(0);
        float r104 = r100.getY(0);
        this.f399010r = r104;
        this.f399011s = r104;
        this.f399014v = -1;
        VelocityTracker r105 = this.f399015w;
        if (r105 != null) goto L48;
        this.f399015w = VelocityTracker.obtain();
    L49:
        VelocityTracker r106 = this.f399015w;
        if (r106 == null) goto L53;
        r106.addMovement(r100);
    L53:
        boolean r107 = super.onInterceptTouchEvent(r100);
        if (this.A.d(r100) == false) goto L56;
        return false;
    L56:
        return r107;
    L48:
        r105.clear();
        goto L49
    L42:
        if (this.f399016x == true) goto L45;
        r102 = false;
        goto L45
    }

    @Override // android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        boolean r102 = false;
        boolean r103 = true;
        if (r101 == 0) goto L62;
        if (r101 == 1) goto L49;
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L49;
        if (r101 == 5) goto L19;
        if (r101 != 6) goto L76;
        if (this.f399008p == false) goto L76;
        c(r100);
        return true;
    L76:
        return super.onTouchEvent(r100);
    L19:
        if (this.f399008p == false) goto L76;
        m(r100.getActionIndex(), r100);
        return true;
    L23:
        if (this.f399008p == false) goto L45;
        if (r100.getEventTime() != this.f399014v) goto L27;
        return true;
    L27:
        int r104 = r100.findPointerIndex(this.f399013u);
        if (r104 >= 0) goto L31;
        g();
        return true;
    L31:
        float r105 = r100.getY(r104);
        float r106 = r105 - this.f399011s;
        if (this.f399009q == true) goto L34;
    L42:
        this.f399011s = r105;
        return true;
    L34:
        if (r106 != 0.0f) goto L36;
        r102 = true;
    L36:
        if (r102 == true) goto L42;
        VelocityTracker r107 = this.f399015w;
        if (r107 == null) goto L41;
        r107.addMovement(r100);
    L41:
        f(r106);
        goto L42
    L45:
        if (l(r100) == false) goto L76;
        this.f399016x = false;
        return true;
    L49:
        if (this.f399008p == false) goto L56;
        VelocityTracker r108 = this.f399015w;
        if (r108 == null) goto L54;
        r108.addMovement(r100);
    L54:
        g();
        return true;
    L56:
        h();
        VelocityTracker r109 = this.f399015w;
        if (r109 == null) goto L60;
        r109.recycle();
    L60:
        this.f399015w = null;
        goto L76
    L62:
        if (j() == false) goto L64;
    L67:
        this.f399016x = r103;
        this.f399008p = false;
        this.f399009q = false;
        this.f399012t = 0;
        this.f399013u = r100.getPointerId(0);
        float r110 = r100.getY(0);
        this.f399010r = r110;
        this.f399011s = r110;
        this.f399014v = -1;
        VelocityTracker r111 = this.f399015w;
        if (r111 != null) goto L70;
        this.f399015w = VelocityTracker.obtain();
    L71:
        VelocityTracker r112 = this.f399015w;
        if (r112 == null) goto L76;
        r112.addMovement(r100);
        goto L76
    L70:
        r111.clear();
        goto L71
    L64:
        if (this.f399016x == true) goto L67;
        r103 = false;
        goto L67
    }

    public void setOnBounceTranslationListener(e r100) {
        BounceTranslationDelegate r101 = this.f399018z;
        r101.f398910c = r100;
        r101.a();
    }

    public static final /* synthetic */ boolean a(OScrollView r100, MotionEvent r101) {
        return super.dispatchTouchEvent(r101);
    }

    public static Field k(Class r100, String r101) {
        Field r102 = r100.getDeclaredField(r101);     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        return r102;
    L4:
        return null;
    }

    public final void m(int r100, MotionEvent r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= r101.getPointerCount()) goto L9;
        this.f399013u = r101.getPointerId(r100);
        this.f399011s = r101.getY(r100);
        return;
    }

    public OScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f399005m = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f399006n = ViewConfiguration.get(r100).getScaledMinimumFlingVelocity();
        this.f399007o = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        this.f399013u = -1;
        this.f399014v = -1;
        this.f399017y = new d(new OScrollView$overscrollDelegate$1(this), new OScrollView$overscrollDelegate$2(this));
        this.f399018z = new BounceTranslationDelegate(new OScrollView$translationDelegate$1(this), new OScrollView$translationDelegate$2(this));
        this.A = new b(this, new OScrollView$clickDuringOverScrollDelegate$1(this), new OScrollView$clickDuringOverScrollDelegate$2(this));
        setOverScrollMode(0);
        WeakHashMap<View, BounceEdgeEffect.a.C4666a> r103 = BounceEdgeEffect.f398877u;
        BounceEdgeEffect.a.a("Landroid/widget/ScrollView;");
        if (this.f398993a == true) goto L16;
        this.f398993a = true;
        Field r104 = k(ScrollView.class, "mEdgeGlowTop");     // Catch: Throwable -> L14
        if (r104 != null) goto L9;
        r104 = k(ScrollView.class, "mTopGlow");     // Catch: Throwable -> L14
    L9:
        this.f398994b = r104;     // Catch: Throwable -> L14
        Field r105 = k(ScrollView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L14
        if (r105 != null) goto L12;
        r105 = k(ScrollView.class, "mBottomGlow");     // Catch: Throwable -> L14
    L12:
        this.f398995c = r105;     // Catch: Throwable -> L14
        this.f399001i = k(ScrollView.class, "mScroller");     // Catch: Throwable -> L14
    L14:
        this.f398994b = null;
        this.f398995c = null;
        this.f399001i = null;
    L16:
        if (this.f398996d == null) goto L18;
        return;
    L18:
        if (this.f398997e != null) goto L58;
        this.f399017y.b();
        Field r106 = this.f398994b;
        if (r106 == null) goto L59;
        Field r107 = this.f398995c;
        if (r107 == null) goto L60;
        Object r108 = r106.get(this);     // Catch: Throwable -> L41
        if ((r108 instanceof EdgeEffect) == false) goto L29;
        EdgeEffect r109 = (EdgeEffect) r108;     // Catch: Throwable -> L41
    L30:
        this.f398998f = r109;     // Catch: Throwable -> L41
        Object r110 = r107.get(this);     // Catch: Throwable -> L41
        if ((r110 instanceof EdgeEffect) == false) goto L33;
        EdgeEffect r111 = (EdgeEffect) r110;     // Catch: Throwable -> L41
    L34:
        this.f398999g = r111;     // Catch: Throwable -> L41
        BounceEdgeEffect r112 = new BounceEdgeEffect(getContext(), this, 0, this.f399017y.f399052c);     // Catch: Throwable -> L41
        BounceEdgeEffect r113 = new BounceEdgeEffect(getContext(), this, 1, this.f399017y.f399052c);     // Catch: Throwable -> L41
        if (getWidth() > 0) goto L37;
    L39:
        r106.set(this, r112);     // Catch: Throwable -> L41
        r107.set(this, r113);     // Catch: Throwable -> L41
        this.f398996d = r112;     // Catch: Throwable -> L41
        this.f398997e = r113;     // Catch: Throwable -> L41
        this.f399000h = true;     // Catch: Throwable -> L41
        this.f399017y.a();     // Catch: Throwable -> L41
        this.f399018z.a();     // Catch: Throwable -> L41
        return;
    L37:
        if (getHeight() <= 0) goto L39;
        r112.setSize(getWidth(), getHeight());     // Catch: Throwable -> L41
        r113.setSize(getWidth(), getHeight());     // Catch: Throwable -> L41
        goto L39
    L33:
        r111 = null;
        goto L34
    L29:
        r109 = null;
    L41:
        Field r114 = this.f398994b;     // Catch: Throwable -> L51
        if (r114 == null) goto L45;
        r114.set(this, this.f398998f);     // Catch: Throwable -> L51
    L45:
        Field r115 = this.f398995c;     // Catch: Throwable -> L51
        if (r115 == null) goto L49;
        r115.set(this, this.f398999g);     // Catch: Throwable -> L51
    L49:
        this.f398996d = null;
        this.f398997e = null;
        this.f399000h = false;
        return;
    L60:
        return;
    L59:
        return;
    }

    public /* synthetic */ OScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f399017y.b();
        BounceEdgeEffect r104 = this.f398996d;
        if (r104 == null) goto L6;
        r104.setSize(r100, r101);
    L6:
        BounceEdgeEffect r105 = this.f398997e;
        if (r105 == null) goto L11;
        r105.setSize(r100, r101);
        return;
    }

    @Override // android.view.View
    public final boolean overScrollBy(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r110, boolean r111) {
        boolean r107 = super.overScrollBy(r100, r101, r102, r103, r104, r105, r106, r110, r111);
        if (r111 == false) goto L5;
    L57:
        return r107;
    L5:
        if (this.f399000h == false) goto L57;
        if (r105 <= 0) goto L57;
        int r108 = r103 + r101;
        int r109 = c.f399049a;
        boolean r112 = false;
        if (r108 > 0) goto L34;
        if (r101 >= 0) goto L34;
        BounceEdgeEffect r113 = this.f398996d;
        if (r113 != null) goto L14;
    L16:
        boolean r114 = false;
    L17:
        if (r114 == false) goto L34;
        float r115 = getCurrentFlingVelocity();
        int r116 = Math.abs(r108);
        if (getHeight() <= 0) goto L24;
        BounceEdgeEffect r117 = this.f398996d;
        if (r117 == null) goto L24;
        r117.onPull(r116 / getHeight(), 0.5f);
    L24:
        BounceEdgeEffect r118 = this.f398996d;
        if (r118 == null) goto L59;
        r118.onAbsorb((int) r115);
    L59:
        OverScroller r119 = getScrollerOrNull();     // Catch: Throwable -> L33
        if (r119 == null) goto L34;
        r119.abortAnimation();     // Catch: Throwable -> L33
        goto L34
    L14:
        if (r113.isFinished() != true) goto L16;
        r114 = true;
    L34:
        if (r108 < r105) goto L57;
        if (r101 <= 0) goto L57;
        BounceEdgeEffect r120 = this.f398997e;
        if (r120 != null) goto L40;
    L42:
        if (r112 == false) goto L57;
        float r121 = getCurrentFlingVelocity();
        int r122 = r108 - r105;
        if (getHeight() <= 0) goto L49;
        BounceEdgeEffect r123 = this.f398997e;
        if (r123 == null) goto L49;
        r123.onPull(r122 / getHeight(), 0.5f);
    L49:
        BounceEdgeEffect r124 = this.f398997e;
        if (r124 == null) goto L61;
        r124.onAbsorb(-((int) r121));
    L61:
        OverScroller r125 = getScrollerOrNull();     // Catch: Throwable -> L58
        if (r125 == null) goto L57;
        r125.abortAnimation();     // Catch: Throwable -> L58
        goto L57
    L40:
        if (r120.isFinished() != true) goto L42;
        r112 = true;
        goto L42
    }
}
