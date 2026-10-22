package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/bouncelayout/ONestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "", "getScrollRangeY", "", "getBounceTranslation", "Lcom/obric/oui/bouncelayout/e;", "listener", "", "setOnBounceTranslationListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class ONestedScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f398973t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f398974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Field f398975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Field f398976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Field f398977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BounceEdgeEffect f398978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BounceEdgeEffect f398979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f398980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f398981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f398982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f398983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f398984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f398985l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f398986m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f398987n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public EdgeEffect f398988o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public EdgeEffect f398989p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f398990q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final BounceTranslationDelegate f398991r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f398992s;

    public static final class a {
    }

    static {
    }

    public ONestedScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ONestedScrollView(Context r100, AttributeSet r101) {
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

    public float getBounceTranslation() {
        BounceEdgeEffect r100 = this.f398978e;
        float r101 = 0.0f;
        if (r100 != null) goto L5;
        float r102 = 0.0f;
    L6:
        BounceEdgeEffect r103 = this.f398979f;
        if (r103 == null) goto L11;
        r101 = r103.f398883f;
    L11:
        return r102 + r101;
    L5:
        r102 = r100.f398883f;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        BounceEdgeEffect r100 = this.f398978e;
        if (r100 == null) goto L6;
        r100.c();
    L6:
        BounceEdgeEffect r101 = this.f398979f;
        if (r101 == null) goto L21;
        r101.c();
    L21:
        Field r102 = this.f398975b;     // Catch: Throwable -> L20
        if (r102 == null) goto L14;
        r102.set(this, this.f398988o);     // Catch: Throwable -> L20
    L14:
        Field r103 = this.f398976c;     // Catch: Throwable -> L20
        if (r103 == null) goto L18;
        r103.set(this, this.f398989p);     // Catch: Throwable -> L20
    L18:
        super.onDetachedFromWindow();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f398980g == true) goto L5;
        return;
    L5:
        OverScroller r100 = null;
        Field r101 = this.f398977d;     // Catch: Throwable -> L14
        if (r101 != null) goto L9;
        Object r102 = null;
    L11:
        if ((r102 instanceof OverScroller) == false) goto L15;
        r100 = (OverScroller) r102;     // Catch: Throwable -> L14
        goto L15
    L9:
        r102 = r101.get(this);     // Catch: Throwable -> L14
    L15:
        if (r100 != null) goto L17;
        return;
    L17:
        int r103 = getScrollRangeY();
        if (r103 > 0) goto L20;
        return;
    L20:
        int r104 = getScrollY();
        boolean r105 = false;
        if (r100.isFinished() == true) goto L63;
        int r106 = this.f398982i;
        float r107 = r100.getCurrVelocity();
        this.f398981h = r107;
        int r108 = c.f399049a;
        if (this.f398983j == false) goto L25;
    L59:
        if (r105 == false) goto L61;
        return;
    L61:
        this.f398982i = r104;
        return;
    L25:
        if (r107 <= 0.0f) goto L59;
        if (r104 != 0) goto L42;
        if (r106 <= 0) goto L42;
        BounceEdgeEffect r109 = this.f398978e;
        if (r109 != null) goto L34;
    L36:
        boolean r110 = false;
    L37:
        if (r110 == false) goto L42;
        BounceEdgeEffect r111 = this.f398978e;
        if (r111 == null) goto L56;
        r111.onAbsorb((int) r107);
    L56:
        r105 = true;
    L57:
        if (r105 == false) goto L59;
        this.f398983j = true;
        r100.abortAnimation();
        this.f398981h = 0.0f;
        invalidate();
        goto L59
    L34:
        if (r109.isFinished() != true) goto L36;
        r110 = true;
    L42:
        if (r104 != r103) goto L57;
        if (r106 >= r103) goto L57;
        BounceEdgeEffect r112 = this.f398979f;
        if (r112 != null) goto L48;
    L50:
        boolean r113 = false;
    L51:
        if (r113 == false) goto L57;
        BounceEdgeEffect r114 = this.f398979f;
        if (r114 == null) goto L56;
        r114.onAbsorb(-((int) r107));
        goto L56
    L48:
        if (r112.isFinished() != true) goto L50;
        r113 = true;
        goto L51
    L63:
        float r115 = this.f398981h;
        if (r115 <= 0.0f) goto L79;
        if (r104 == 0) goto L67;
    L72:
        if (r104 != r103) goto L79;
        if (this.f398982i >= r103) goto L79;
        int r116 = c.f399049a;
        BounceEdgeEffect r117 = this.f398979f;
        if (r117 == null) goto L79;
        r117.onAbsorb(-((int) r115));
        goto L79
    L67:
        if (this.f398982i <= 0) goto L72;
        int r118 = c.f399049a;
        BounceEdgeEffect r119 = this.f398978e;
        if (r119 == null) goto L79;
        r119.onAbsorb((int) r115);
    L79:
        this.f398981h = 0.0f;
        this.f398983j = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        BounceEdgeEffect r101 = this.f398978e;
        if (r101 != null) goto L7;
        float r102 = 0.0f;
    L8:
        BounceEdgeEffect r103 = this.f398979f;
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
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f398992s.c(r100);
        b r101 = this.f398992s;
        Boolean r102 = r101.b(r100, 0.0f, -r101.f399043e, new ONestedScrollView$dispatchTouchEvent$handled$1(this, r100));
        if (r102 != null) goto L6;
        return e(r100);
    L6:
        return r102.booleanValue();
    }

    public final boolean e(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L19;
        boolean r102 = true;
        if (r101 != 1) goto L7;
        this.f398987n = null;
    L21:
        return super.dispatchTouchEvent(r100);
    L7:
        if (r101 != 2) goto L21;
        if (this.f398987n != null) goto L21;
        float r103 = Math.abs(r100.getX() - this.f398985l);
        float r104 = Math.abs(r100.getY() - this.f398986m);
        if (Math.max(r103, r104) <= this.f398984k) goto L21;
        if (r103 > r104) goto L17;
        r102 = false;
    L17:
        this.f398987n = Boolean.valueOf(r102);
        goto L21
    L19:
        this.f398985l = r100.getX();
        this.f398986m = r100.getY();
        this.f398987n = null;
        goto L21
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getActionMasked() != 0) goto L9;
        boolean r101 = super.onInterceptTouchEvent(r100);
        if (this.f398992s.d(r100) == false) goto L7;
        return false;
    L7:
        return r101;
    L9:
        if (Intrinsics.areEqual(this.f398987n, Boolean.TRUE) == false) goto L12;
        return false;
    L12:
        if (this.f398992s.d(r100) == false) goto L14;
        return false;
    L14:
        boolean r102 = super.onInterceptTouchEvent(r100);
        if (r102 == false) goto L17;
        this.f398987n = Boolean.FALSE;
    L17:
        return r102;
    }

    public void setOnBounceTranslationListener(e r100) {
        BounceTranslationDelegate r101 = this.f398991r;
        r101.f398910c = r100;
        r101.a();
    }

    public static Field f(Class r100, String r101) {
        Field r102 = r100.getDeclaredField(r101);     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        return r102;
    L4:
        return null;
    }

    public ONestedScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f398984k = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f398990q = new d(new ONestedScrollView$overscrollDelegate$1(this), new ONestedScrollView$overscrollDelegate$2(this));
        this.f398991r = new BounceTranslationDelegate(new ONestedScrollView$translationDelegate$1(this), new ONestedScrollView$translationDelegate$2(this));
        this.f398992s = new b(this, new ONestedScrollView$clickDuringOverScrollDelegate$1(this), new ONestedScrollView$clickDuringOverScrollDelegate$2(this));
        setOverScrollMode(0);
        WeakHashMap<View, BounceEdgeEffect.a.C4666a> r103 = BounceEdgeEffect.f398877u;
        BounceEdgeEffect.a.a("Landroidx/core/widget/NestedScrollView;");
        if (this.f398974a == true) goto L16;
        this.f398974a = true;
        Field r104 = f(NestedScrollView.class, "mEdgeGlowTop");     // Catch: Throwable -> L14
        if (r104 != null) goto L9;
        r104 = f(NestedScrollView.class, "mTopGlow");     // Catch: Throwable -> L14
    L9:
        this.f398975b = r104;     // Catch: Throwable -> L14
        Field r105 = f(NestedScrollView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L14
        if (r105 != null) goto L12;
        r105 = f(NestedScrollView.class, "mBottomGlow");     // Catch: Throwable -> L14
    L12:
        this.f398976c = r105;     // Catch: Throwable -> L14
        this.f398977d = f(NestedScrollView.class, "mScroller");     // Catch: Throwable -> L14
    L14:
        this.f398975b = null;
        this.f398976c = null;
        this.f398977d = null;
    L16:
        if (this.f398978e == null) goto L18;
        return;
    L18:
        if (this.f398979f != null) goto L58;
        Field r106 = this.f398975b;
        if (r106 == null) goto L59;
        Field r107 = this.f398976c;
        if (r107 == null) goto L60;
        Object r108 = r106.get(this);     // Catch: Throwable -> L41
        if ((r108 instanceof EdgeEffect) == false) goto L29;
        EdgeEffect r109 = (EdgeEffect) r108;     // Catch: Throwable -> L41
    L30:
        Object r110 = r107.get(this);     // Catch: Throwable -> L41
        if ((r110 instanceof EdgeEffect) == false) goto L33;
        EdgeEffect r111 = (EdgeEffect) r110;     // Catch: Throwable -> L41
    L34:
        this.f398988o = r109;     // Catch: Throwable -> L41
        this.f398989p = r111;     // Catch: Throwable -> L41
        BounceEdgeEffect r112 = new BounceEdgeEffect(getContext(), this, 0, this.f398990q.f399052c);     // Catch: Throwable -> L41
        BounceEdgeEffect r113 = new BounceEdgeEffect(getContext(), this, 1, this.f398990q.f399052c);     // Catch: Throwable -> L41
        if (getWidth() > 0) goto L37;
    L39:
        r106.set(this, r112);     // Catch: Throwable -> L41
        r107.set(this, r113);     // Catch: Throwable -> L41
        this.f398978e = r112;     // Catch: Throwable -> L41
        this.f398979f = r113;     // Catch: Throwable -> L41
        this.f398990q.a();     // Catch: Throwable -> L41
        this.f398991r.a();     // Catch: Throwable -> L41
        this.f398980g = true;     // Catch: Throwable -> L41
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
        Field r114 = this.f398975b;     // Catch: Throwable -> L51
        if (r114 == null) goto L45;
        r114.set(this, this.f398988o);     // Catch: Throwable -> L51
    L45:
        Field r115 = this.f398976c;     // Catch: Throwable -> L51
        if (r115 == null) goto L49;
        r115.set(this, this.f398989p);     // Catch: Throwable -> L51
    L49:
        this.f398978e = null;
        this.f398979f = null;
        this.f398980g = false;
        return;
    L60:
        return;
    L59:
        return;
    }

    public /* synthetic */ ONestedScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f398990q.b();
        BounceEdgeEffect r104 = this.f398978e;
        if (r104 == null) goto L6;
        r104.setSize(r100, r101);
    L6:
        BounceEdgeEffect r105 = this.f398979f;
        if (r105 == null) goto L11;
        r105.setSize(r100, r101);
        return;
    }
}
