package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/bouncelayout/OHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "", "", "getCurrentFlingVelocity", "getBounceTranslation", "Lcom/obric/oui/bouncelayout/e;", "listener", "", "setOnBounceTranslationListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OHorizontalScrollView extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f398933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Field f398934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Field f398935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BounceEdgeEffect f398936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BounceEdgeEffect f398937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EdgeEffect f398938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EdgeEffect f398939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f398940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Field f398941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f398942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f398943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BounceTranslationDelegate f398944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f398945m;

    public static final class a {
    }

    static {
    }

    public OHorizontalScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OHorizontalScrollView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final void d() {
        if (this.f398942j == true) goto L5;
        return;
    L5:
        boolean r100 = c(this.f398936d);
        boolean r101 = c(this.f398937e);
        if (r100 == false) goto L9;
        if (r101 == true) goto L9;
    L18:
        byte r102 = 2;
    L27:
        if (r102 == 2) goto L34;
        if (r102 != 3) goto L38;
        BounceEdgeEffect r103 = this.f398937e;
        if (r103 == null) goto L38;
        r103.onRelease();
    L38:
        this.f398942j = false;
        invalidate();
        return;
    L34:
        BounceEdgeEffect r104 = this.f398936d;
        if (r104 == null) goto L38;
        r104.onRelease();
    L9:
        if (r101 == false) goto L12;
        if (r100 == true) goto L12;
    L25:
        r102 = 3;
    L12:
        BounceEdgeEffect r105 = this.f398936d;
        if (r105 != null) goto L15;
        float r106 = 0.0f;
    L17:
        if (r106 > 0.0f) goto L18;
        BounceEdgeEffect r107 = this.f398937e;
        if (r107 != null) goto L22;
        float r108 = 0.0f;
    L24:
        if (r108 < 0.0f) goto L25;
        r102 = -1;
        goto L27
    L22:
        r108 = r107.f398883f;
        goto L24
    L15:
        r106 = r105.f398883f;
        goto L17
    }

    private final boolean e() {
        if (this.f398940h == true) goto L5;
        return false;
    L5:
        BounceEdgeEffect r100 = this.f398936d;
        if (r100 != null) goto L8;
        float r101 = 0.0f;
    L10:
        if (r101 != 0.0f) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L25;
        BounceEdgeEffect r103 = this.f398937e;
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
    L27:
        boolean r107 = false;
    L31:
        if (r107 == true) goto L41;
        BounceEdgeEffect r108 = this.f398937e;
        if (r108 != null) goto L36;
    L34:
        boolean r109 = false;
    L38:
        if (r109 == true) goto L41;
        boolean r110 = false;
    L42:
        if (r106 == true) goto L46;
        if (r110 == true) goto L46;
        return false;
    L46:
        Field r111 = this.f398941i;
        OverScroller r112 = null;
        if (r111 != null) goto L49;
        Object r113 = null;
    L51:
        if ((r113 instanceof OverScroller) == false) goto L53;
        r112 = (OverScroller) r113;
    L53:
        if (r112 == null) goto L56;
        r112.abortAnimation();
    L56:
        BounceEdgeEffect r114 = this.f398936d;
        if (r114 == null) goto L60;
        r114.q();
    L60:
        BounceEdgeEffect r115 = this.f398937e;
        if (r115 == null) goto L64;
        r115.q();
    L64:
        invalidate();
        return true;
    L49:
        r113 = r111.get(this);
        goto L51
    L36:
        if (r108.isFinished() == true) goto L34;
        r109 = true;
    L41:
        r110 = true;
        goto L42
    L29:
        if (r100.isFinished() == true) goto L27;
        r107 = true;
        goto L31
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

    private final float getCurrentFlingVelocity() {
        Field r100 = this.f398941i;     // Catch: Throwable -> L14
        OverScroller r101 = null;
        if (r100 != null) goto L6;
        Object r102 = null;
    L8:
        if ((r102 instanceof OverScroller) == false) goto L10;
        r101 = (OverScroller) r102;     // Catch: Throwable -> L14
    L10:
        if (r101 != null) goto L12;
        return 1000.0f;
    L12:
        return r101.getCurrVelocity();
    L6:
        r102 = r100.get(this);     // Catch: Throwable -> L14
    L17:
        return 1000.0f;
    }

    public float getBounceTranslation() {
        BounceEdgeEffect r100 = this.f398936d;
        float r101 = 0.0f;
        if (r100 != null) goto L5;
        float r102 = 0.0f;
    L6:
        BounceEdgeEffect r103 = this.f398937e;
        if (r103 == null) goto L11;
        r101 = r103.f398883f;
    L11:
        return r102 + r101;
    L5:
        r102 = r100.f398883f;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r100 = this.f398936d;
        if (r100 == null) goto L6;
        r100.c();
    L6:
        BounceEdgeEffect r101 = this.f398937e;
        if (r101 == null) goto L20;
        r101.c();
    L20:
        Field r102 = this.f398934b;     // Catch: Throwable -> L19
        if (r102 == null) goto L14;
        r102.set(this, this.f398938f);     // Catch: Throwable -> L19
    L14:
        Field r103 = this.f398935c;     // Catch: Throwable -> L19
        if (r103 == null) goto L22;
        r103.set(this, this.f398939g);     // Catch: Throwable -> L19
        return;
    L22:
        return;
    }

    private static boolean c(BounceEdgeEffect r100) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f398940h == true) goto L8;
        super.dispatchDraw(r100);
        return;
    L8:
        BounceEdgeEffect r101 = this.f398936d;
        if (r101 != null) goto L11;
        float r102 = 0.0f;
    L12:
        BounceEdgeEffect r103 = this.f398937e;
        if (r103 != null) goto L15;
        float r104 = 0.0f;
    L16:
        float r105 = r102 + r104;
        if (r105 != 0.0f) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == true) goto L22;
        int r107 = r100.save();
        r100.translate(r105, 0.0f);
        super.dispatchDraw(r100);
        r100.restoreToCount(r107);
        return;
    L22:
        super.dispatchDraw(r100);
        return;
    L19:
        r106 = false;
        goto L20
    L15:
        r104 = r103.f398883f;
        goto L16
    L11:
        r102 = r101.f398883f;
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        this.f398945m.c(r100);
        b r101 = this.f398945m;
        Boolean r102 = r101.b(r100, -r101.f399043e, 0.0f, new OHorizontalScrollView$dispatchTouchEvent$handled$1(this, r100));
        if (r102 != null) goto L5;
        boolean r103 = super.dispatchTouchEvent(r100);
    L7:
        if (r100.getActionMasked() != 1) goto L9;
    L10:
        d();
    L11:
        return r103;
    L9:
        if (r100.getActionMasked() != 3) goto L11;
    L5:
        r103 = r102.booleanValue();
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getActionMasked() != 0) goto L16;
        if (e() == false) goto L7;
    L10:
        boolean r101 = true;
    L11:
        this.f398942j = r101;
        boolean r102 = super.onInterceptTouchEvent(r100);
        if (this.f398945m.d(r100) == false) goto L14;
        return false;
    L14:
        return r102;
    L7:
        if (this.f398942j == true) goto L10;
        r101 = false;
        goto L11
    L16:
        if (this.f398945m.d(r100) == false) goto L19;
        return false;
    L19:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        boolean r102 = true;
        if (r101 == 0) goto L18;
        if (r101 != 1) goto L6;
    L8:
        BounceEdgeEffect r103 = this.f398936d;
        if (r103 == null) goto L12;
        r103.f398888k = 0.0f;
    L12:
        BounceEdgeEffect r104 = this.f398937e;
        if (r104 == null) goto L16;
        r104.f398888k = 0.0f;
    L16:
        d();
    L25:
        return super.onTouchEvent(r100);
    L6:
        if (r101 == 3) goto L8;
    L18:
        if (e() == false) goto L20;
    L23:
        this.f398942j = r102;
        goto L25
    L20:
        if (this.f398942j == true) goto L23;
        r102 = false;
        goto L23
    }

    public void setOnBounceTranslationListener(e r100) {
        BounceTranslationDelegate r101 = this.f398944l;
        r101.f398910c = r100;
        r101.a();
    }

    public static final /* synthetic */ boolean b(OHorizontalScrollView r100, MotionEvent r101) {
        return super.dispatchTouchEvent(r101);
    }

    private static Field f(Class r100, String r101) {
        Field r102 = r100.getDeclaredField(r101);     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        return r102;
    L4:
        return null;
    }

    public OHorizontalScrollView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f398943k = new d(new OHorizontalScrollView$overscrollDelegate$1(this), new OHorizontalScrollView$overscrollDelegate$2(this));
        this.f398944l = new BounceTranslationDelegate(new OHorizontalScrollView$translationDelegate$1(this), new OHorizontalScrollView$translationDelegate$2(this));
        this.f398945m = new b(this, new OHorizontalScrollView$clickDuringOverScrollDelegate$1(this), new OHorizontalScrollView$clickDuringOverScrollDelegate$2(this));
        setOverScrollMode(0);
        WeakHashMap<View, BounceEdgeEffect.a.C4666a> r102 = BounceEdgeEffect.f398877u;
        BounceEdgeEffect.a.a("Landroid/widget/HorizontalScrollView;");
        if (this.f398933a == true) goto L20;
        this.f398933a = true;
        Field r103 = f(HorizontalScrollView.class, "mEdgeGlowLeft");     // Catch: Throwable -> L18
        if (r103 != null) goto L11;
        r103 = f(HorizontalScrollView.class, "mLeftGlow");     // Catch: Throwable -> L18
        if (r103 != null) goto L11;
        r103 = f(HorizontalScrollView.class, "mEdgeEffectLeft");     // Catch: Throwable -> L18
    L11:
        this.f398934b = r103;     // Catch: Throwable -> L18
        Field r104 = f(HorizontalScrollView.class, "mEdgeGlowRight");     // Catch: Throwable -> L18
        if (r104 != null) goto L16;
        r104 = f(HorizontalScrollView.class, "mRightGlow");     // Catch: Throwable -> L18
        if (r104 != null) goto L16;
        r104 = f(HorizontalScrollView.class, "mEdgeEffectRight");     // Catch: Throwable -> L18
    L16:
        this.f398935c = r104;     // Catch: Throwable -> L18
        this.f398941i = f(HorizontalScrollView.class, "mScroller");     // Catch: Throwable -> L18
    L18:
        this.f398934b = null;
        this.f398935c = null;
        this.f398941i = null;
    L20:
        if (this.f398936d == null) goto L22;
        return;
    L22:
        if (this.f398937e != null) goto L62;
        this.f398943k.b();
        Field r105 = this.f398934b;
        if (r105 == null) goto L63;
        Field r106 = this.f398935c;
        if (r106 == null) goto L64;
        Object r107 = r105.get(this);     // Catch: Throwable -> L45
        if ((r107 instanceof EdgeEffect) == false) goto L33;
        EdgeEffect r108 = (EdgeEffect) r107;     // Catch: Throwable -> L45
    L34:
        this.f398938f = r108;     // Catch: Throwable -> L45
        Object r109 = r106.get(this);     // Catch: Throwable -> L45
        if ((r109 instanceof EdgeEffect) == false) goto L37;
        EdgeEffect r111 = (EdgeEffect) r109;     // Catch: Throwable -> L45
    L38:
        this.f398939g = r111;     // Catch: Throwable -> L45
        BounceEdgeEffect r112 = new BounceEdgeEffect(getContext(), this, 2, this.f398943k.f399052c);     // Catch: Throwable -> L45
        r112.f398882e = true;     // Catch: Throwable -> L45
        BounceEdgeEffect r113 = new BounceEdgeEffect(getContext(), this, 3, this.f398943k.f399052c);     // Catch: Throwable -> L45
        r113.f398882e = true;     // Catch: Throwable -> L45
        if (getWidth() > 0) goto L41;
    L43:
        r105.set(this, r112);     // Catch: Throwable -> L45
        r106.set(this, r113);     // Catch: Throwable -> L45
        this.f398936d = r112;     // Catch: Throwable -> L45
        this.f398937e = r113;     // Catch: Throwable -> L45
        this.f398940h = true;     // Catch: Throwable -> L45
        this.f398943k.a();     // Catch: Throwable -> L45
        this.f398944l.a();     // Catch: Throwable -> L45
        return;
    L41:
        if (getHeight() <= 0) goto L43;
        r112.setSize(getWidth(), getHeight());     // Catch: Throwable -> L45
        r113.setSize(getWidth(), getHeight());     // Catch: Throwable -> L45
        goto L43
    L37:
        r111 = null;
        goto L38
    L33:
        r108 = null;
    L45:
        Field r114 = this.f398934b;     // Catch: Throwable -> L55
        if (r114 == null) goto L49;
        r114.set(this, this.f398938f);     // Catch: Throwable -> L55
    L49:
        Field r115 = this.f398935c;     // Catch: Throwable -> L55
        if (r115 == null) goto L53;
        r115.set(this, this.f398939g);     // Catch: Throwable -> L55
    L53:
        this.f398936d = null;
        this.f398937e = null;
        this.f398940h = false;
        return;
    L64:
        return;
    L63:
        return;
    }

    public /* synthetic */ OHorizontalScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f398943k.b();
        BounceEdgeEffect r104 = this.f398936d;
        if (r104 == null) goto L6;
        r104.setSize(r100, r101);
    L6:
        BounceEdgeEffect r105 = this.f398937e;
        if (r105 == null) goto L11;
        r105.setSize(r100, r101);
        return;
    }

    @Override // android.view.View
    public final boolean overScrollBy(int r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111, boolean r112) {
        if (r112 == true) goto L4;
    L13:
        boolean r106 = super.overScrollBy(r100, r101, r102, r103, r104, r105, r110, r111, r112);
        if (r112 == false) goto L16;
    L77:
        return r106;
    L16:
        if (this.f398940h == false) goto L77;
        if (r104 <= 0) goto L77;
        int r107 = r102 + r100;
        int r108 = c.f399049a;
        OverScroller r109 = null;
        boolean r113 = false;
        if (r107 > 0) goto L50;
        if (r100 >= 0) goto L50;
        BounceEdgeEffect r114 = this.f398936d;
        if (r114 != null) goto L25;
    L27:
        boolean r115 = false;
    L28:
        if (r115 == false) goto L50;
        float r116 = getCurrentFlingVelocity();
        int r117 = Math.abs(r107);
        BounceEdgeEffect r118 = this.f398936d;
        if (r118 == null) goto L33;
        r118.onPull(r117 / getWidth(), 0.5f);
    L33:
        BounceEdgeEffect r119 = this.f398936d;
        if (r119 == null) goto L79;
        r119.onAbsorb((int) r116);
    L79:
        Field r120 = this.f398941i;     // Catch: Throwable -> L49
        if (r120 != null) goto L40;
        Object r121 = null;
    L42:
        if ((r121 instanceof OverScroller) == false) goto L44;
        OverScroller r122 = (OverScroller) r121;     // Catch: Throwable -> L49
    L45:
        if (r122 == null) goto L50;
        r122.abortAnimation();     // Catch: Throwable -> L49
        goto L50
    L44:
        r122 = null;
        goto L45
    L40:
        r121 = r120.get(this);     // Catch: Throwable -> L49
        goto L42
    L25:
        if (r114.isFinished() != true) goto L27;
        r115 = true;
    L50:
        if (r107 < r104) goto L77;
        if (r100 <= 0) goto L77;
        BounceEdgeEffect r123 = this.f398937e;
        if (r123 != null) goto L56;
    L58:
        if (r113 == false) goto L77;
        float r124 = getCurrentFlingVelocity();
        int r125 = r107 - r104;
        BounceEdgeEffect r126 = this.f398937e;
        if (r126 == null) goto L63;
        r126.onPull(r125 / getWidth(), 0.5f);
    L63:
        BounceEdgeEffect r127 = this.f398937e;
        if (r127 == null) goto L81;
        r127.onAbsorb(-((int) r124));
    L81:
        Field r128 = this.f398941i;     // Catch: Throwable -> L78
        if (r128 != null) goto L70;
        Object r129 = null;
    L72:
        if ((r129 instanceof OverScroller) == false) goto L74;
        r109 = (OverScroller) r129;     // Catch: Throwable -> L78
    L74:
        if (r109 == null) goto L77;
        r109.abortAnimation();     // Catch: Throwable -> L78
        goto L77
    L70:
        r129 = r128.get(this);     // Catch: Throwable -> L78
        goto L72
    L56:
        if (r123.isFinished() != true) goto L58;
        r113 = true;
        goto L58
    L4:
        if (this.f398940h == false) goto L13;
        float r130 = r100;
        BounceEdgeEffect r131 = this.f398936d;
        if (r131 == null) goto L9;
        r131.f398888k = r130;
    L9:
        BounceEdgeEffect r132 = this.f398937e;
        if (r132 == null) goto L13;
        r132.f398888k = r130;
        goto L13
    }
}
