package com.obric.oui.popover.v2;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.oui.color.h0;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001/B\u001b\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,B#\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010-\u001a\u00020\u0003¢\u0006\u0004\b+\u0010.J\u0010\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003R\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010&\u001a\u00020\u00038F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00060"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverLayout;", "Landroid/widget/LinearLayout;", "", "", "color", "", "setBgColor", "", "cornerRadiusDp", "setCornerRadiusDp", "cornerRadius", "setCornerRadius", "getCornerRadius", "setBorderColor", "width", "setBorderWidth", "", ECPromotion.TRANSPARENT_BOTTON_ICON, "setTransparentBg", "getPadding", "getArrowHeight", "f", FaceService.girlLabel, "getMWidth", "()F", "setMWidth", "(F)V", "mWidth", ce.f26391f, "getMHeight", "setMHeight", "mHeight", "h", "I", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBgColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OPopoverLayout extends LinearLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f402328p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f402329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f402330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f402331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f402332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f402333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f402334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f402335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f402336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f402337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f402338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f402339k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f402340l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f402341m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function1<? super Boolean, com.obric.oui.material.c[]> f402342n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f402343o;

    public static final class a {
    }

    static {
    }

    public OPopoverLayout() {
        throw null;
    }

    public final int getArrowHeight() {
        return 0;
    }

    public final int getPadding() {
        return 0;
    }

    public final void b() {
        if (this.f402340l == true) goto L6;
        return;
    L6:
        if (this.f402341m == true) goto L8;
        return;
    L8:
        Function1<? super Boolean, com.obric.oui.material.c[]> r100 = this.f402342n;
        if (getMBgColor() != 0) goto L11;
        boolean r101 = vma.i.a(this);
    L12:
        com.obric.oui.material.c[] r102 = r100.invoke(Boolean.valueOf(!r101));
        if (r102 == null) goto L17;
        p.d(this, r102, false, this.f402343o, 10);
        return;
    L17:
        return;
    L11:
        r101 = h0.b(getMBgColor());
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        OMaterialHelper.q(this, this.f402343o);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OMaterialHelper.q(this, 0);
    }

    public final float getCornerRadius() {
        return this.f402329a;
    }

    public final int getMBgColor() {
        return this.f402336h;
    }

    public final float getMHeight() {
        return this.f402335g;
    }

    public final float getMWidth() {
        return this.f402334f;
    }

    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f402331c = new Paint();
        new Path();
        Paint r101 = this.f402331c;
        Paint r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r101 = null;
    L5:
        r101.setStyle(Paint.Style.FILL);
        Paint r103 = this.f402331c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r103 = null;
    L8:
        r103.setStrokeCap(Paint.Cap.BUTT);
        Paint r104 = this.f402331c;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r104 = null;
    L11:
        boolean r105 = true;
        r104.setAntiAlias(true);
        Paint r106 = this.f402331c;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r106 = null;
    L14:
        r106.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f402336h = ContextCompat.getColor(r100, R.color.oui_bg_base_3);
    L17:
        Paint r107 = this.f402331c;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L21:
        r102.setColor(getMBgColor());
        setClipChildren(false);
        setOutlineProvider(new k(this));
        setClipToOutline(true);
        setBackgroundColor(0);
        if (p.b(this) == true) goto L24;
    L26:
        r105 = false;
    L27:
        this.f402341m = r105;
        b();
        return;
    L24:
        if (OMaterialHelper.l() == false) goto L26;
    L20:
        r102 = r107;
        goto L21
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        if (this.f402330b == true) goto L5;
        return;
    L5:
        RectF r101 = this.f402333e;
        Paint r102 = new Paint(1);
        r102.setColor(0);
        float r103 = this.f402329a;
        r100.drawRoundRect(r101, r103, r103, r102);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Paint r101 = null;
        if (this.f402341m == true) goto L12;
        Paint r102 = this.f402331c;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r102 = null;
    L7:
        r102.setColor(getMBgColor());
        RectF r103 = this.f402333e;
        float r104 = this.f402329a;
        Paint r105 = this.f402331c;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r100.drawRoundRect(r103, r104, r104, r101);
    L17:
        Paint r106 = this.f402339k;
        if (r106 != null) goto L21;
        return;
    L21:
        if (this.f402337i <= 0) goto L24;
        RectF r107 = this.f402333e;
        float r108 = this.f402329a;
        r100.drawRoundRect(r107, r108, r108, r106);
        return;
    L24:
        return;
    L10:
        r101 = r105;
        goto L11
    L12:
        Paint r109 = this.f402331c;
        if (r109 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L16:
        r101.getAlpha();
        goto L17
    L15:
        r101 = r109;
        goto L16
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f402330b == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r100) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f402330b == false) goto L6;
        return true;
    L6:
        return super.onTouchEvent(r100);
    }

    public final void setBgColor(int r100) {
        if (getMBgColor() != r100) goto L5;
        return;
    L5:
        this.f402336h = r100;
        Paint r101 = this.f402331c;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r101 = null;
    L8:
        r101.setColor(getMBgColor());
        b();
    }

    public final void setBorderColor(int r100) {
        this.f402338j = r100;
        if (this.f402339k != null) goto L5;
        this.f402339k = new Paint(1);
    L5:
        Paint r101 = this.f402339k;
        if (r101 == null) goto L10;
        r101.setColor(this.f402338j);
        return;
    }

    public final void setBorderWidth(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f402337i = r100;
        if (this.f402339k != null) goto L7;
        this.f402339k = new Paint(1);
    L7:
        Paint r101 = this.f402339k;
        if (r101 == null) goto L12;
        r101.setStyle(Paint.Style.STROKE);
        r101.setStrokeWidth(this.f402337i);
        r101.setStrokeCap(Paint.Cap.BUTT);
        r101.setStrokeJoin(Paint.Join.MITER);
        r101.setAntiAlias(true);
        r101.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        r101.setColor(this.f402338j);
        return;
    }

    public final void setCornerRadius(float r100) {
        this.f402329a = r100;
    }

    public final void setCornerRadiusDp(float r100) {
        this.f402329a = pla.d.p(this, r100);
    }

    public final void setMBgColor(int r100) {
        this.f402336h = r100;
    }

    public final void setMHeight(float r100) {
        this.f402335g = r100;
    }

    public final void setMWidth(float r100) {
        this.f402334f = r100;
    }

    public final void setTransparentBg(boolean r100) {
        setClipToOutline(!r100);
        if (r100 == false) goto L5;
        this.f402336h = 0;
    L5:
        invalidateOutline();
        invalidate();
    }

    public OPopoverLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, true, MaterialToken.OUI_Bg_Popup, 3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f402334f = getMeasuredWidth();
        this.f402335g = getMeasuredHeight();
    }

    public OPopoverLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402329a = pla.d.p(this, 28.0f);
        ColorProtector.parseColor("#20000000");
        new ArgbEvaluator();
        this.f402332d = new Rect();
        this.f402333e = new RectF();
        this.f402340l = true;
        this.f402342n = MaterialToken.OUI_Bg_Popup;
        this.f402343o = 3;
        a(r100);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
    }

    public OPopoverLayout(Context r100, AttributeSet r101, boolean r102, Function1 r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "materials");
        super(r100, r101, 0);
        this.f402329a = pla.d.p(this, 28.0f);
        ColorProtector.parseColor("#20000000");
        new ArgbEvaluator();
        this.f402332d = new Rect();
        this.f402333e = new RectF();
        this.f402340l = true;
        this.f402342n = MaterialToken.OUI_Bg_Popup;
        this.f402343o = 3;
        this.f402340l = r102;
        this.f402342n = r103;
        this.f402343o = r104;
        a(r100);
    }
}
