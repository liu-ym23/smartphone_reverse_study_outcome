package com.larus.common_ui.venus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w19.k;
import w19.l;
import w19.m;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJN\u0010I\u001a\u00020J2\b\b\u0003\u0010\u000b\u001a\u00020\u00072\b\b\u0003\u0010&\u001a\u00020\u00072\b\b\u0003\u0010(\u001a\u00020\u00072\b\b\u0003\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u0007H\u0007J\u0018\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0014J\u0006\u0010N\u001a\u00020OJ\u000e\u0010P\u001a\u00020J2\u0006\u0010Q\u001a\u00020OJ\u0010\u0010R\u001a\u00020J2\u0006\u0010S\u001a\u00020OH\u0002J\u0010\u0010T\u001a\u00020J2\u0006\u0010S\u001a\u00020OH\u0002J\u0012\u0010U\u001a\u00020J2\b\u0010V\u001a\u0004\u0018\u00010/H\u0002J\b\u0010W\u001a\u00020/H\u0002J\u0010\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u0007H\u0002J\u0018\u0010Z\u001a\u0002022\u0006\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010<R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010>\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010>\u001a\u0004\bF\u0010G¨\u0006]"}, d2 = {"Lcom/larus/common_ui/venus/ShapeRelativeLayout;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shapeMode", "fillColor", "getFillColor", "()I", "setFillColor", "(I)V", "strokeColor", "getStrokeColor", "setStrokeColor", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "cornerRadius", "getCornerRadius", "setCornerRadius", "topLeftRadius", "getTopLeftRadius", "setTopLeftRadius", "topRightRadius", "getTopRightRadius", "setTopRightRadius", "bottomLeftRadius", "getBottomLeftRadius", "setBottomLeftRadius", "bottomRightRadius", "getBottomRightRadius", "setBottomRightRadius", "cornerPosition", "startColor", "midColor", "endColor", "shadowOrientation", "withElevation", "shadowDx", "shadowDy", "shadowBlurRadius", "shadowRadii", "", "shadowColor", "excludeDx", "", "excludeLeft", "excludeTop", "excludeRight", "excludeBottom", "shadowPaint", "Landroid/graphics/Paint;", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable$delegate", "Lkotlin/Lazy;", "shadowRoundRectDrawable", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "getShadowRoundRectDrawable", "()Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "shadowRoundRectDrawable$delegate", "shadowLayerDrawable", "Landroid/graphics/drawable/LayerDrawable;", "getShadowLayerDrawable", "()Landroid/graphics/drawable/LayerDrawable;", "shadowLayerDrawable$delegate", "modifyAttribute", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "getShadowParam", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable$Params;", "applyShadowParam", "newParams", "copyShadowParamsToLocal", "params", "copyLocalParamsToShadow", "applyLocalParamsToShadow", "radii", "getCornerRadiusByPosition", "getPositionRadius", "position", "containsFlag", "flagSet", ForwardDependency$ForwardLocation.FLAG, "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShapeRelativeLayout extends RelativeLayout {
    public static final /* synthetic */ int C = 0;
    public final Lazy A;
    public final Lazy B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f327926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f327927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f327928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f327929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f327930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f327931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f327932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f327933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f327934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f327935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f327936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f327937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f327938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f327939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f327940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f327941p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f327942q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float[] f327943r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f327944s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f327945t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f327946u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f327947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f327948w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f327949x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Paint f327950y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f327951z;

    public ShapeRelativeLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShapeRelativeLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final float[] getCornerRadiusByPosition() {
        float[] r100 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        int r101 = this.f327935j;
        boolean r102 = true;
        if ((1 | r101) != r101) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        float r104 = c(1);
        r100[0] = r104;
        r100[1] = r104;
    L8:
        int r105 = this.f327935j;
        if ((2 | r105) != r105) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        float r107 = c(2);
        r100[2] = r107;
        r100[3] = r107;
    L14:
        int r108 = this.f327935j;
        if ((4 | r108) != r108) goto L17;
        boolean r109 = true;
    L18:
        if (r109 == false) goto L20;
        float r110 = c(4);
        r100[4] = r110;
        r100[5] = r110;
    L20:
        int r111 = this.f327935j;
        if ((8 | r111) == r111) goto L24;
        r102 = false;
    L24:
        if (r102 == false) goto L26;
        float r112 = c(8);
        r100[6] = r112;
        r100[7] = r112;
    L26:
        return r100;
    L17:
        r109 = false;
        goto L18
    L11:
        r106 = false;
        goto L12
    L5:
        r103 = false;
        goto L6
    }

    private final GradientDrawable getGradientDrawable() {
        return (GradientDrawable) this.f327951z.getValue();
    }

    private final LayerDrawable getShadowLayerDrawable() {
        return (LayerDrawable) this.B.getValue();
    }

    private final a getShadowRoundRectDrawable() {
        return (a) this.A.getValue();
    }

    public final a.C4189a getShadowParam() {
        return getShadowRoundRectDrawable().f327952a;
    }

    public final int getBottomLeftRadius() {
        return this.f327933h;
    }

    public final int getBottomRightRadius() {
        return this.f327934i;
    }

    public final int getCornerRadius() {
        return this.f327930e;
    }

    public final int getFillColor() {
        return this.f327927b;
    }

    public final int getStrokeColor() {
        return this.f327928c;
    }

    public final int getStrokeWidth() {
        return this.f327929d;
    }

    public final int getTopLeftRadius() {
        return this.f327931f;
    }

    public final int getTopRightRadius() {
        return this.f327932g;
    }

    public static LayerDrawable a(ShapeRelativeLayout r100) {
        return new LayerDrawable(new Drawable[]{r100.getShadowRoundRectDrawable(), r100.getGradientDrawable()});
    }

    public final void b(a.C4189a r100) {
        r100.f327962c = this.f327940o;
        r100.f327963d = this.f327941p;
        r100.f327966g = this.f327944s;
        r100.f327961b = this.f327927b;
        r100.f327964e = this.f327942q;
        r100.f327965f = this.f327945t;
        r100.f327967h = this.f327946u;
        r100.f327968i = this.f327947v;
        r100.f327969j = this.f327948w;
        r100.f327970k = this.f327949x;
    }

    public final int c(int r100) {
        int r101 = this.f327930e;
        if (r101 == 0) goto L6;
        return r101;
    L6:
        if (r100 != 1) goto L9;
        return this.f327931f;
    L9:
        if (r100 != 2) goto L12;
        return this.f327932g;
    L12:
        if (r100 != 8) goto L15;
        return this.f327933h;
    L15:
        if (r100 == 4) goto L22;
        return 0;
    L22:
        return this.f327934i;
    }

    public final void setBottomLeftRadius(int r100) {
        this.f327933h = r100;
    }

    public final void setBottomRightRadius(int r100) {
        this.f327934i = r100;
    }

    public final void setCornerRadius(int r100) {
        this.f327930e = r100;
    }

    public final void setFillColor(int r100) {
        this.f327927b = r100;
    }

    public final void setStrokeColor(int r100) {
        this.f327928c = r100;
    }

    public final void setStrokeWidth(int r100) {
        this.f327929d = r100;
    }

    public final void setTopLeftRadius(int r100) {
        this.f327931f = r100;
    }

    public final void setTopRightRadius(int r100) {
        this.f327932g = r100;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        super.onMeasure(r100, r110);
        float[] r101 = getCornerRadiusByPosition();
        GradientDrawable r111 = getGradientDrawable();
        int r102 = this.f327936k;
        if (r102 == (-1)) goto L5;
    L8:
        int r103 = this.f327937l;
        if (r103 == (-1)) goto L11;
        int[] r104 = {r102, r103, this.f327938m};
    L12:
        r111.setColors(r104);
        switch(this.f327939n) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            default: goto L23;
        };
    L15:
        r111.setOrientation(GradientDrawable.Orientation.TL_BR);
        goto L23
    L16:
        r111.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        goto L23
    L17:
        r111.setOrientation(GradientDrawable.Orientation.BL_TR);
        goto L23
    L18:
        r111.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        goto L23
    L19:
        r111.setOrientation(GradientDrawable.Orientation.BR_TL);
        goto L23
    L20:
        r111.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
        goto L23
    L21:
        r111.setOrientation(GradientDrawable.Orientation.TR_BL);
        goto L23
    L22:
        r111.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
    L23:
        int r105 = this.f327926a;
        if (r105 == 0) goto L32;
        if (r105 == 1) goto L31;
        if (r105 == 2) goto L30;
        if (r105 != 3) goto L34;
        r111.setShape(3);
    L34:
        if (this.f327935j != (-1)) goto L36;
        r111.setCornerRadius(this.f327930e);
    L37:
        int r106 = this.f327928c;
        if (r106 == 0) goto L41;
        r111.setStroke(this.f327929d, r106);
    L41:
        if (this.f327942q <= 0) goto L63;
        float[] r112 = this.f327943r;
        if (r112 != null) goto L45;
    L49:
        this.f327943r = r101;
    L50:
        float[] r113 = this.f327943r;
        if (r113 == null) goto L54;
        r101 = r113;
    L54:
        a.C4189a r114 = getShadowRoundRectDrawable().f327952a;
        b(r114);
        if (r101 != null) goto L57;
        r101 = getCornerRadiusByPosition();
    L57:
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r114.f327960a = r101;
        getShadowRoundRectDrawable().b(r114);
        getShadowRoundRectDrawable().a(0, getShadowLayerDrawable());
        getShadowRoundRectDrawable().a(1, getShadowLayerDrawable());
        if (Build.VERSION.SDK_INT < 28) goto L60;
    L62:
        setBackground(getShadowLayerDrawable());
        return;
    L60:
        if (getShadowRoundRectDrawable().getPaint() == null) goto L62;
        setLayerType(1, this.f327950y);
        goto L62
    L45:
        if (r112.length != 8) goto L47;
        boolean r115 = true;
    L48:
        if (r115 == true) goto L50;
    L47:
        r115 = false;
        goto L48
    L63:
        setBackground(getGradientDrawable());
        return;
    L36:
        r111.setCornerRadii(r101);
        goto L37
    L30:
        r111.setShape(2);
        goto L34
    L31:
        r111.setShape(1);
        goto L34
    L32:
        r111.setShape(0);
        goto L34
    L11:
        r104 = new int[]{r102, this.f327938m};
        goto L12
    L5:
        if (this.f327938m != (-1)) goto L8;
        r111.setColor(this.f327927b);
        goto L23
    }

    public ShapeRelativeLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f327935j = -1;
        this.f327950y = new Paint(1);
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.NONE;
        this.f327951z = LazyKt.lazy(r103, new k());
        this.A = LazyKt.lazy(r103, new l(this));
        this.B = LazyKt.lazy(r103, new m(this));
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_sc_bottomLeftRadius, R.attr.larus_sc_bottomRightRadius, R.attr.larus_sc_cornerPosition, R.attr.larus_sc_cornerRadius, R.attr.larus_sc_endColor, R.attr.larus_sc_exclude_bottom, R.attr.larus_sc_exclude_dx, R.attr.larus_sc_exclude_left, R.attr.larus_sc_exclude_right, R.attr.larus_sc_exclude_top, R.attr.larus_sc_fillColor, R.attr.larus_sc_midColor, R.attr.larus_sc_orientation, R.attr.larus_sc_pressedColor, R.attr.larus_sc_shadow_blur_radius, R.attr.larus_sc_shadow_color, R.attr.larus_sc_shadow_dx, R.attr.larus_sc_shadow_dy, R.attr.larus_sc_shadow_layout_mode, R.attr.larus_sc_shapeMode, R.attr.larus_sc_startColor, R.attr.larus_sc_strokeColor, R.attr.larus_sc_strokeWidth, R.attr.larus_sc_topLeftRadius, R.attr.larus_sc_topRightRadius, R.attr.larus_sc_withElevation});
        this.f327926a = r104.getInt(19, 0);
        this.f327927b = r104.getColor(10, -1);
        this.f327928c = r104.getColor(21, 0);
        this.f327929d = r104.getDimensionPixelSize(22, 0);
        this.f327930e = r104.getDimensionPixelSize(3, 0);
        this.f327931f = r104.getDimensionPixelSize(23, 0);
        this.f327932g = r104.getDimensionPixelSize(24, 0);
        this.f327934i = r104.getDimensionPixelSize(1, 0);
        this.f327933h = r104.getDimensionPixelSize(0, 0);
        this.f327935j = r104.getInt(2, -1);
        this.f327936k = r104.getColor(20, -1);
        this.f327937l = r104.getColor(11, -1);
        this.f327938m = r104.getColor(4, -1);
        this.f327939n = r104.getColor(12, 0);
        r104.getDimensionPixelSize(25, 0);
        this.f327944s = r104.getColor(15, 0);
        this.f327945t = r104.getBoolean(6, false);
        this.f327946u = r104.getBoolean(7, false);
        this.f327948w = r104.getBoolean(8, false);
        this.f327947v = r104.getBoolean(9, false);
        this.f327949x = r104.getBoolean(5, false);
        this.f327940o = r104.getDimensionPixelSize(16, 0);
        this.f327941p = r104.getDimensionPixelSize(17, 0);
        this.f327942q = r104.getDimensionPixelSize(14, 0);
        r104.recycle();
    }

    public /* synthetic */ ShapeRelativeLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
