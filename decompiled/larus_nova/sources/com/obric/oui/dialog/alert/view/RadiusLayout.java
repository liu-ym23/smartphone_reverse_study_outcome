package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;
import com.obric.oui.common.style.r;
import com.obric.oui.material.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Landroid/widget/FrameLayout;", "", "suppress", "", "setSuppressChildMeasureAndLayout", "", "color", "setBackgroundColor", "", "r", "setRadius", "h", "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxHeight", RXScreenCaptureService.KEY_INDEX, "Z", "getMeasureHeightUnspecified", "()Z", "setMeasureHeightUnspecified", "(Z)V", "measureHeightUnspecified", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class RadiusLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f400624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f400625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f400626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f400627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f400628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f400629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f400630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f400631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f400632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f400633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f400634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f400635l;

    public RadiusLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RadiusLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void d() {
        GradientDrawable r100 = new GradientDrawable();
        r100.setShape(0);
        float[] r101 = this.f400627d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
        r101 = null;
    L5:
        r100.setCornerRadii(r101);
        r100.setColor(ColorStateList.valueOf(this.f400630g));
        setBackground(r100);
    }

    public final int getMaxHeight() {
        return this.f400631h;
    }

    public final boolean getMeasureHeightUnspecified() {
        return this.f400632i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float[] r100 = null;
        if (this.f400634k == false) goto L8;
        this.f400628e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f400628e.inset(0.0f, this.f400635l);
        this.f400629f.reset();
        Path r101 = this.f400629f;
        RectF r102 = this.f400628e;
        float[] r103 = this.f400627d;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
        r103 = null;
    L7:
        r101.addRoundRect(r102, r103, Path.Direction.CW);
        r110.clipPath(this.f400629f);
    L8:
        super.dispatchDraw(r110);
        if (this.f400626c == true) goto L11;
        return;
    L11:
        if (this.f400624a == false) goto L43;
        Paint r104 = this.f400625b;
        if (r104 == null) goto L44;
        this.f400628e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f400629f.reset();
        SmoothCornerHelper r105 = r.f399599a;
        Path r106 = this.f400629f;
        RectF r107 = this.f400628e;
        float[] r108 = this.f400627d;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
    L19:
        Path.Direction r109 = Path.Direction.CW;
        Intrinsics.checkNotNullParameter(r106, "path");
        Intrinsics.checkNotNullParameter(r107, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r100, "radii");
        Intrinsics.checkNotNullParameter(r109, MapBundleKey.MapObjKey.OBJ_DIR);
        boolean r111 = true;
        if (r100.length != 0) goto L22;
        boolean r112 = true;
    L23:
        if (r112 == true) goto L35;
        float r113 = r100[0];
        int r114 = r100.length;
        int r115 = 0;
    L26:
        if (r115 >= r114) goto L35;
        if (r100[r115] != r113) goto L30;
        boolean r116 = true;
    L32:
        if ((!r116) == true) goto L33;
        r115 = r115 + 1;
        goto L26
    L33:
        r111 = false;
        goto L35
    L30:
        r116 = false;
    L35:
        if (r111 == false) goto L37;
        r106.addPath(r.a(r107, r100[0]));
    L38:
        r110.drawPath(this.f400629f, r104);
        return;
    L37:
        r106.addRoundRect(r107, r100, r109);
        goto L38
    L22:
        r112 = false;
        goto L23
    L18:
        r100 = r108;
        goto L19
    L44:
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.draw(r100);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        super.setBackgroundColor(r100);
        this.f400630g = r100;
        d();
    }

    public final void setMaxHeight(int r100) {
        this.f400631h = r100;
    }

    public final void setMeasureHeightUnspecified(boolean r100) {
        this.f400632i = r100;
    }

    public final void setRadius(float r100) {
        b(r100, r100, r100, r100);
    }

    public final void setSuppressChildMeasureAndLayout(boolean r100) {
        if (this.f400633j != r100) goto L5;
        return;
    L5:
        this.f400633j = r100;
        if (r100 == true) goto L9;
        requestLayout();
        invalidate();
        return;
    }

    public final void c(int r100, int r101) {
        Paint r102 = new Paint();
        boolean r103 = true;
        r102.setAntiAlias(true);
        r102.setColor(r100);
        r102.setStyle(Paint.Style.STROKE);
        r102.setStrokeWidth(r101);
        this.f400625b = r102;
        if ((r100 & (-16777216)) == 0) goto L6;
        if (r101 == 0) goto L6;
    L7:
        this.f400626c = r103;
        invalidate();
        return;
    L6:
        r103 = false;
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.f400633j == false) goto L14;
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = View.MeasureSpec.getMode(r101);
        int r105 = View.MeasureSpec.getSize(r101);
        if (r102 == Integer.MIN_VALUE) goto L8;
        if (r102 == 1073741824) goto L8;
        r103 = RangesKt.coerceAtLeast(getMeasuredWidth(), getSuggestedMinimumWidth());
    L8:
        if (r104 == Integer.MIN_VALUE) goto L11;
        if (r104 == 1073741824) goto L11;
        r105 = RangesKt.coerceAtLeast(getMeasuredHeight(), getSuggestedMinimumHeight());
    L11:
        setMeasuredDimension(r103, r105);
        return;
    L14:
        if (this.f400632i == false) goto L21;
        boolean r106 = false;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r107 = getMeasuredHeight();
        int r108 = this.f400631h;
        if (1 > r108) goto L19;
        if (r108 >= r107) goto L19;
        r106 = true;
    L19:
        if (r106 == false) goto L23;
        setMeasuredDimension(getMeasuredWidth(), this.f400631h);
        return;
    L23:
        return;
    L21:
        super.onMeasure(r100, r101);
    }

    public RadiusLayout(Context r110, AttributeSet r111, int r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r210);
        this.f400624a = true;
        this.f400628e = new RectF();
        this.f400629f = new Path();
        this.f400634k = p.b(this);
        this.f400635l = 3.0f;
        boolean r100 = false;
        if ((getBackground() instanceof ColorDrawable) == false) goto L9;
        Drawable r101 = getBackground();
        if (r101 == null) goto L8;
        int r102 = ((ColorDrawable) r101).getColor();
    L10:
        this.f400630g = r102;
        TypedArray r103 = r110.obtainStyledAttributes(r111, new int[]{R.attr.oui_cornerRadius, R.attr.oui_cornerRadiusLeftBottom, R.attr.oui_cornerRadiusLeftTop, R.attr.oui_cornerRadiusRightBottom, R.attr.oui_cornerRadiusRightTop, R.attr.oui_radiusStrokeColor, R.attr.oui_radiusStrokeDashGapWidth, R.attr.oui_radiusStrokeDashWidth, R.attr.oui_radiusStrokeWidth}, r210, 0);
        float r104 = r103.getDimension(0, 0.0f);
        float r105 = r103.getDimension(2, r104);
        float r106 = r103.getDimension(4, r104);
        float r107 = r103.getDimension(1, r104);
        float r112 = r103.getDimension(3, r104);
        int r113 = r103.getColor(5, -16777216);
        int r114 = r103.getDimensionPixelOffset(8, 0);
        int r115 = r103.getDimensionPixelOffset(7, 0);
        int r116 = r103.getDimensionPixelOffset(6, 0);
        if (r104 != 0.0f) goto L13;
        boolean r117 = true;
    L14:
        if (r117 == false) goto L16;
        b(r105, r106, r107, r112);
    L17:
        Paint r108 = new Paint();
        r108.setAntiAlias(true);
        r108.setColor(r113);
        r108.setStyle(Paint.Style.STROKE);
        if (r115 == 0) goto L21;
        if (r116 == 0) goto L21;
        r108.setPathEffect(new DashPathEffect(new float[]{r115, r116}, 0.0f));
    L21:
        r108.setStrokeWidth(r114);
        this.f400625b = r108;
        if ((r113 & (-16777216)) == 0) goto L25;
        if (r114 == 0) goto L25;
        r100 = true;
    L25:
        this.f400626c = r100;
        invalidate();
        r103.recycle();
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setClipToOutline(true);
        return;
    L16:
        setRadius(r104);
        goto L17
    L13:
        r117 = false;
        goto L14
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L9:
        r102 = 0;
        goto L10
    }

    public /* synthetic */ RadiusLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(float r100, float r101, float r102, float r103) {
        this.f400627d = new float[]{r100, r100, r101, r101, r103, r103, r102, r102};
        d();
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (this.f400633j == false) goto L5;
        return;
    L5:
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
