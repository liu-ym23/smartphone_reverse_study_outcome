package com.obric.oui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes34.dex */
public class VerticalFadeFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float[] f403726s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f403727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PorterDuffXfermode f403728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f403729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f403730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f403731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearGradient f403732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearGradient f403733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f403734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f403735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f403736j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f403737k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f403738l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f403739m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f403740n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ValueAnimator f403741o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f403742p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f403743q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewTreeObserver f403744r;

    public class a implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerticalFadeFrameLayout f403745a;

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            this.f403745a.c(true);
        }

        public a(VerticalFadeFrameLayout r100) {
            this.f403745a = r100;
        }
    }

    static {
        f403726s = new float[]{0.0f, 1.0f};
    }

    public final void a() {
        this.f403732f = null;
        this.f403733g = null;
        this.f403734h = -1;
        this.f403735i = -1;
        this.f403736j = -1.0f;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r100 = this.f403743q;
        if (r100 == null) goto L6;
        b(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View r100 = this.f403743q;
        if (r100 == null) goto L16;
        ViewTreeObserver r101 = this.f403744r;
        if (r101 != null) goto L8;
        r101 = r100.getViewTreeObserver();
    L8:
        if (r101 == null) goto L13;
        if (r101.isAlive() == false) goto L13;
        r101.removeOnScrollChangedListener(this.f403731e);
    L13:
        if (this.f403744r != r101) goto L17;
        this.f403744r = null;
        return;
    L17:
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r100 = getChildAt(0);
        this.f403743q = r100;
        if (r100 == null) goto L5;
        b(r100);
    L5:
        c(false);
    }

    public float getFadeLength() {
        return this.f403742p;
    }

    public VerticalFadeFrameLayout(Context r100) {
        this(r100, null);
    }

    public final void b(View r100) {
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        ViewTreeObserver r102 = this.f403744r;
        if (r102 != r101) goto L5;
        return;
    L5:
        if (r102 != null) goto L7;
    L9:
        r101.addOnScrollChangedListener(this.f403731e);
        this.f403744r = r101;
        return;
    L7:
        if (r102.isAlive() == false) goto L9;
        this.f403744r.removeOnScrollChangedListener(this.f403731e);
        goto L9
    }

    public final void c(boolean r110) {
        View r100 = this.f403743q;
        if (r100 != null) goto L5;
    L7:
        float r101 = 0.0f;
    L8:
        if (r100 != null) goto L10;
    L12:
        float r102 = 0.0f;
    L13:
        if (r110 == true) goto L15;
        ValueAnimator r111 = this.f403741o;
        if (r111 == null) goto L32;
        r111.cancel();
    L32:
        this.f403739m = r101;
        this.f403740n = r102;
        this.f403737k = r101;
        this.f403738l = r102;
        a();
        return;
    L15:
        if (this.f403739m == r101) goto L17;
    L19:
        this.f403739m = r101;
        this.f403740n = r102;
        float r103 = this.f403737k;
        float r104 = this.f403738l;
        if (r103 == r101) goto L22;
    L24:
        ValueAnimator r112 = this.f403741o;
        if (r112 == null) goto L27;
        r112.cancel();
    L27:
        ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f403741o = r113;
        r113.setDuration(120);
        this.f403741o.addUpdateListener(new yma.a(this, r103, r101, r104, r102));
        this.f403741o.start();
        return;
    L22:
        if (r104 != r102) goto L24;
        return;
    L17:
        if (this.f403740n != r102) goto L19;
        return;
    L10:
        if (r100.canScrollVertically(1) == false) goto L12;
        r102 = 1.0f;
        goto L13
    L5:
        if (r100.canScrollVertically(-1) == false) goto L7;
        r101 = 1.0f;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r210) {
        View r100 = this.f403743q;
        int r101 = 0;
        if (r100 != null) goto L6;
    L17:
        boolean r102 = false;
    L18:
        if (r102 == true) goto L21;
        super.dispatchDraw(r210);
        return;
    L21:
        View r103 = this.f403743q;
        if (r103 != null) goto L25;
        super.dispatchDraw(r210);
        return;
    L25:
        float r104 = r103.getLeft();
        float r105 = r103.getTop();
        float r106 = r103.getRight();
        float r107 = r103.getBottom();
        if (r106 > r104) goto L28;
    L31:
        RectF r108 = null;
    L32:
        if (r108 != null) goto L35;
        super.dispatchDraw(r210);
        return;
    L35:
        float r109 = this.f403737k;
        if (r109 <= 0.0f) goto L38;
    L41:
        float r110 = this.f403738l;
        int r111 = (int) r108.width();
        int r112 = (int) r108.height();
        if (this.f403734h == r111) goto L44;
    L48:
        this.f403734h = r111;
        this.f403735i = r112;
        this.f403736j = this.f403742p;
        float r113 = Math.min(this.f403742p, new RectF(0.0f, 0.0f, r111, r112).height());
        if (r111 <= 0) goto L62;
        if (r112 <= 0) goto L62;
        if (r113 <= 0.0f) goto L62;
        int r114 = Math.max(0, Math.min(255, (int) ((1.0f - Math.max(0.0f, Math.min(1.0f, r109))) * 255.0f)));
        int r115 = Math.max(0, Math.min(255, (int) ((1.0f - Math.max(0.0f, Math.min(1.0f, r110))) * 255.0f)));
        float[] r116 = f403726s;
        if (r109 <= 0.0f) goto L57;
        int r117 = 2;
        this.f403732f = new LinearGradient(0.0f, 0.0f, 0.0f, r113, new int[]{Color.argb(r114, 0, 0, 0), -16777216}, r116, Shader.TileMode.CLAMP);
    L59:
        if (r110 <= 0.0f) goto L61;
        int[] r118 = new int[r117];
        r118[0] = Color.argb(r115, 0, 0, 0);
        r118[1] = -16777216;
        this.f403733g = new LinearGradient(0.0f, r113, 0.0f, 0.0f, r118, r116, Shader.TileMode.CLAMP);
    L63:
        int r119 = r210.saveLayer(r108.left, r108.top, r108.right, r108.bottom, null);
        super.dispatchDraw(r210);
        this.f403727a.setXfermode(this.f403728b);
        if (this.f403737k <= 0.0f) goto L80;
        float r120 = Math.min(this.f403742p, r108.height());
        if (r120 <= 0.0f) goto L80;
        LinearGradient r121 = this.f403732f;
        if (r121 == null) goto L80;
        this.f403729c.reset();
        this.f403729c.setTranslate(r108.left, r108.top);
        r121.setLocalMatrix(this.f403729c);
        this.f403727a.setShader(r121);
        View r122 = this.f403743q;
        if (r122 == null) goto L74;
        int r123 = r122.getPaddingLeft();
    L75:
        if (r122 == null) goto L77;
        int r124 = r122.getPaddingRight();
    L78:
        float r125 = r108.left + r123;
        float r126 = r108.top;
        r210.drawRect(r125, r126, r108.right - r124, r126 + r120, this.f403727a);
        goto L80
    L77:
        r124 = 0;
        goto L78
    L74:
        r123 = 0;
    L80:
        if (this.f403738l <= 0.0f) goto L94;
        float r127 = Math.min(this.f403742p, r108.height());
        if (r127 <= 0.0f) goto L94;
        LinearGradient r128 = this.f403733g;
        if (r128 == null) goto L94;
        float r129 = Math.max(r108.bottom - r127, r108.top);
        this.f403730d.reset();
        this.f403730d.setTranslate(r108.left, r129);
        r128.setLocalMatrix(this.f403730d);
        this.f403727a.setShader(r128);
        View r130 = this.f403743q;
        if (r130 == null) goto L90;
        int r131 = r130.getPaddingLeft();
    L91:
        if (r130 == null) goto L93;
        r101 = r130.getPaddingRight();
    L93:
        r210.drawRect(r108.left + r131, r129, r108.right - r101, r108.bottom, this.f403727a);
        goto L94
    L90:
        r131 = 0;
    L94:
        this.f403727a.setXfermode(null);
        this.f403727a.setShader(null);
        r210.restoreToCount(r119);
        return;
    L61:
        this.f403733g = null;
        goto L63
    L57:
        r117 = 2;
        this.f403732f = null;
    L62:
        this.f403732f = null;
        this.f403733g = null;
        goto L63
    L44:
        if (this.f403735i != r112) goto L48;
        if (this.f403736j != this.f403742p) goto L48;
    L38:
        if (this.f403738l > 0.0f) goto L41;
        super.dispatchDraw(r210);
        return;
    L28:
        if (r107 <= r105) goto L31;
        r108 = new RectF(r104, r105, r106, r107);
        goto L32
    L6:
        if (this.f403742p <= 0.0f) goto L17;
        if (r100.getWidth() <= 0) goto L17;
        if (r100.getHeight() <= 0) goto L17;
        if (this.f403737k <= 0.0f) goto L15;
    L16:
        r102 = true;
        goto L18
    L15:
        if (this.f403738l <= 0.0f) goto L17;
        goto L16
    }

    public void setFadeLength(float r100) {
        float r101 = Math.max(0.0f, r100);
        if (this.f403742p != r101) goto L5;
        return;
    L5:
        this.f403742p = r101;
        a();
    }

    public VerticalFadeFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public VerticalFadeFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f403727a = new Paint(1);
        this.f403728b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f403729c = new Matrix();
        this.f403730d = new Matrix();
        this.f403731e = new a(this);
        this.f403734h = -1;
        this.f403735i = -1;
        this.f403736j = -1.0f;
        this.f403737k = 0.0f;
        this.f403738l = 0.0f;
        this.f403739m = 0.0f;
        this.f403740n = 0.0f;
        Resources r103 = getResources();
        this.f403742p = TypedValue.applyDimension(1, 24.0f, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()));
        if (r101 == null) goto L8;
        TypedArray r104 = getContext().getTheme().obtainStyledAttributes(r101, new int[]{R.attr.fadeLength}, r102, 0);
        setFadeLength(r104.getDimension(0, this.f403742p));     // Catch: Throwable -> L10
        r104.recycle();
    L10:
        th = move-exception;
        r104.recycle();
        throw th;
    L8:
        setWillNotDraw(false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L6;
        c(false);
        return;
    }
}
