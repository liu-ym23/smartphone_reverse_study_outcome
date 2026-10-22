package com.larus.common_ui.venus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w19.h;
import w19.i;
import w19.j;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0016\u0018\u0000 x2\u00020\u0001:\u0002xyB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJN\u0010S\u001a\u00020T2\b\b\u0003\u0010\u000b\u001a\u00020\u00072\b\b\u0003\u0010&\u001a\u00020\u00072\b\b\u0003\u0010(\u001a\u00020\u00072\b\b\u0003\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u0007H\u0007J\u0018\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0014J\u0010\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020/H\u0002J\u0018\u0010Z\u001a\u00020T2\u0006\u0010Y\u001a\u00020/2\u0006\u0010[\u001a\u000202H\u0002J\u0006\u0010\\\u001a\u00020]J\u000e\u0010^\u001a\u00020T2\u0006\u0010_\u001a\u00020]J(\u0010`\u001a\u00020T2\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u0007H\u0016J(\u0010e\u001a\u00020T2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u0007H\u0016J\u0010\u0010h\u001a\u00020T2\u0006\u0010i\u001a\u00020\u0007H\u0016J\u0010\u0010j\u001a\u00020T2\u0006\u0010k\u001a\u00020]H\u0002J\u0010\u0010l\u001a\u00020T2\u0006\u0010k\u001a\u00020]H\u0002J\u0012\u0010m\u001a\u00020T2\b\u0010Y\u001a\u0004\u0018\u00010/H\u0002J\b\u0010n\u001a\u000202H\u0002J\b\u0010o\u001a\u00020TH\u0002J\b\u0010p\u001a\u00020\u0007H\u0002J\b\u0010q\u001a\u00020\u0007H\u0002J\b\u0010r\u001a\u00020/H\u0002J\u0010\u0010s\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u0007H\u0002J\u0018\u0010u\u001a\u0002022\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bE\u0010FR\u001b\u0010I\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010H\u001a\u0004\bK\u0010LR\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010H\u001a\u0004\bP\u0010Q¨\u0006z"}, d2 = {"Lcom/larus/common_ui/venus/ShapeLinearLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shapeMode", "fillColor", "getFillColor", "()I", "setFillColor", "(I)V", "strokeColor", "getStrokeColor", "setStrokeColor", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "cornerRadius", "getCornerRadius", "setCornerRadius", "topLeftRadius", "getTopLeftRadius", "setTopLeftRadius", "topRightRadius", "getTopRightRadius", "setTopRightRadius", "bottomLeftRadius", "getBottomLeftRadius", "setBottomLeftRadius", "bottomRightRadius", "getBottomRightRadius", "setBottomRightRadius", "cornerPosition", "startColor", "midColor", "endColor", "shadowOrientation", "withElevation", "shadowDx", "shadowDy", "shadowBlurRadius", "shadowRadii", "", "shadowLayoutMode", "applyingShadowPadding", "", "applyingShadowBackground", "contentPaddingLeft", "contentPaddingTop", "contentPaddingRight", "contentPaddingBottom", "contentPaddingStart", "contentPaddingEnd", "contentPaddingIsRelative", "shadowColor", "excludeDx", "excludeLeft", "excludeTop", "excludeRight", "excludeBottom", "shadowPaint", "Landroid/graphics/Paint;", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable$delegate", "Lkotlin/Lazy;", "shadowRoundRectDrawable", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "getShadowRoundRectDrawable", "()Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "shadowRoundRectDrawable$delegate", "shadowLayerDrawable", "Landroid/graphics/drawable/LayerDrawable;", "getShadowLayerDrawable", "()Landroid/graphics/drawable/LayerDrawable;", "shadowLayerDrawable$delegate", "modifyAttribute", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "configureShapeDrawable", "radii", "applyShadowOrShapeBackground", "updateContentBoxPadding", "getShadowParam", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable$Params;", "applyShadowParam", "newParams", "setPadding", "left", "top", "right", "bottom", "setPaddingRelative", "start", "end", "onRtlPropertiesChanged", "layoutDirection", "copyShadowParamsToLocal", "params", "copyLocalParamsToShadow", "applyLocalParamsToShadow", "applyContentBoxPaddingIfNeed", "updateAbsoluteContentHorizontalPadding", "resolvedContentPaddingLeft", "resolvedContentPaddingRight", "getCornerRadiusByPosition", "getPositionRadius", "position", "containsFlag", "flagSet", ForwardDependency$ForwardLocation.FLAG, "Companion", "NoPaddingLayerDrawable", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShapeLinearLayout extends LinearLayout {
    public static final /* synthetic */ int M = 0;
    public int A;
    public boolean B;
    public final int C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final boolean H;
    public final Paint I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f327899J;
    public final Lazy K;
    public final Lazy L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f327900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f327901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f327902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f327903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f327904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f327905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f327906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f327907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f327908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f327909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f327910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f327911l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f327912m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f327913n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f327914o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f327915p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f327916q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float[] f327917r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f327918s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f327919t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f327920u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f327921v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f327922w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f327923x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f327924y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f327925z;

    public static final class a {
    }

    public static final class b extends LayerDrawable {
        public b(Drawable[] r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYERS);
            super(r100);
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public final boolean getPadding(Rect r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.FLEXBOX_PADDING);
            r100.setEmpty();
            return false;
        }
    }

    static {
    }

    public ShapeLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShapeLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final float[] getCornerRadiusByPosition() {
        float[] r100 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        int r101 = this.f327909j;
        boolean r102 = true;
        if ((1 | r101) != r101) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        float r104 = g(1);
        r100[0] = r104;
        r100[1] = r104;
    L8:
        int r105 = this.f327909j;
        if ((2 | r105) != r105) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        float r107 = g(2);
        r100[2] = r107;
        r100[3] = r107;
    L14:
        int r108 = this.f327909j;
        if ((4 | r108) != r108) goto L17;
        boolean r109 = true;
    L18:
        if (r109 == false) goto L20;
        float r110 = g(4);
        r100[4] = r110;
        r100[5] = r110;
    L20:
        int r111 = this.f327909j;
        if ((8 | r111) == r111) goto L24;
        r102 = false;
    L24:
        if (r102 == false) goto L26;
        float r112 = g(8);
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
        return (GradientDrawable) this.f327899J.getValue();
    }

    private final LayerDrawable getShadowLayerDrawable() {
        return (LayerDrawable) this.L.getValue();
    }

    private final com.larus.common_ui.venus.a getShadowRoundRectDrawable() {
        return (com.larus.common_ui.venus.a) this.K.getValue();
    }

    public final boolean b() {
        if (this.f327918s == 1) goto L5;
    L26:
        return false;
    L5:
        if (this.f327916q <= 0) goto L26;
        this.f327919t = true;
    L23:
        th = move-exception;
        this.f327919t = false;
        throw th;
    L9:
        if (this.B == true) goto L11;
    L13:
        int r100 = this.f327921v;     // Catch: Throwable -> L23
    L14:
        int r101 = r100 + ((int) getShadowRoundRectDrawable().f327953b);     // Catch: Throwable -> L23
        int r102 = this.f327922w + ((int) getShadowRoundRectDrawable().f327955d);     // Catch: Throwable -> L23
        if (this.B == true) goto L17;
    L19:
        int r103 = this.f327923x;     // Catch: Throwable -> L23
    L20:
        super.setPadding(r101, r102, r103 + ((int) getShadowRoundRectDrawable().f327954c), this.f327924y + ((int) getShadowRoundRectDrawable().f327956e));     // Catch: Throwable -> L23
        this.f327919t = false;
        return true;
    L17:
        if (getLayoutDirection() != 1) goto L19;
        r103 = this.f327925z;     // Catch: Throwable -> L23
        goto L20
    L11:
        if (getLayoutDirection() != 1) goto L13;
        r100 = this.A;     // Catch: Throwable -> L23
        goto L14
    }

    public final com.larus.common_ui.venus.a.C4189a getShadowParam() {
        return getShadowRoundRectDrawable().f327952a;
    }

    public final int getBottomLeftRadius() {
        return this.f327907h;
    }

    public final int getBottomRightRadius() {
        return this.f327908i;
    }

    public final int getCornerRadius() {
        return this.f327904e;
    }

    public final int getFillColor() {
        return this.f327901b;
    }

    public final int getStrokeColor() {
        return this.f327902c;
    }

    public final int getStrokeWidth() {
        return this.f327903d;
    }

    public final int getTopLeftRadius() {
        return this.f327905f;
    }

    public final int getTopRightRadius() {
        return this.f327906g;
    }

    public static LayerDrawable a(ShapeLinearLayout r100) {
        if (r100.f327918s != 1) goto L6;
        return new b(new Drawable[]{r100.getShadowRoundRectDrawable(), r100.getGradientDrawable()});
    L6:
        return new LayerDrawable(new Drawable[]{r100.getShadowRoundRectDrawable(), r100.getGradientDrawable()});
    }

    public final void c(float[] r100) {
        com.larus.common_ui.venus.a.C4189a r101 = getShadowRoundRectDrawable().f327952a;
        f(r101);
        if (r100 != null) goto L5;
        r100 = getCornerRadiusByPosition();
    L5:
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f327960a = r100;
        getShadowRoundRectDrawable().b(r101);
        getShadowRoundRectDrawable().a(0, getShadowLayerDrawable());
        getShadowRoundRectDrawable().a(1, getShadowLayerDrawable());
        if (Build.VERSION.SDK_INT >= 28) goto L11;
        if (getShadowRoundRectDrawable().getPaint() == null) goto L11;
        setLayerType(1, this.I);
    L11:
        if (this.f327918s == 1) goto L19;
        setBackground(getShadowLayerDrawable());
        return;
    L19:
        this.f327920u = true;     // Catch: Throwable -> L14
        setBackground(getShadowLayerDrawable());     // Catch: Throwable -> L14
        this.f327920u = false;
        b();
        return;
    L14:
        th = move-exception;
        this.f327920u = false;
        throw th;
    }

    public final void e(float[] r110) {
        GradientDrawable r100 = getGradientDrawable();
        int r101 = this.f327910k;
        if (r101 == (-1)) goto L5;
    L8:
        int r102 = this.f327911l;
        if (r102 == (-1)) goto L11;
        int[] r103 = {r101, r102, this.f327912m};
    L12:
        r100.setColors(r103);
        switch(this.f327913n) {
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
        r100.setOrientation(GradientDrawable.Orientation.TL_BR);
        goto L23
    L16:
        r100.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        goto L23
    L17:
        r100.setOrientation(GradientDrawable.Orientation.BL_TR);
        goto L23
    L18:
        r100.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        goto L23
    L19:
        r100.setOrientation(GradientDrawable.Orientation.BR_TL);
        goto L23
    L20:
        r100.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
        goto L23
    L21:
        r100.setOrientation(GradientDrawable.Orientation.TR_BL);
        goto L23
    L22:
        r100.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
    L23:
        int r104 = this.f327900a;
        if (r104 == 0) goto L32;
        if (r104 == 1) goto L31;
        if (r104 == 2) goto L30;
        if (r104 != 3) goto L34;
        r100.setShape(3);
    L34:
        if (this.f327909j != (-1)) goto L36;
        r100.setCornerRadius(this.f327904e);
    L37:
        int r111 = this.f327902c;
        if (r111 == 0) goto L41;
        r100.setStroke(this.f327903d, r111);
        return;
    L41:
        return;
    L36:
        r100.setCornerRadii(r110);
        goto L37
    L30:
        r100.setShape(2);
        goto L34
    L31:
        r100.setShape(1);
        goto L34
    L32:
        r100.setShape(0);
        goto L34
    L11:
        r103 = new int[]{r101, this.f327912m};
        goto L12
    L5:
        if (this.f327912m != (-1)) goto L8;
        r100.setColor(this.f327901b);
        goto L23
    }

    public final void f(com.larus.common_ui.venus.a.C4189a r100) {
        r100.f327962c = this.f327914o;
        r100.f327963d = this.f327915p;
        r100.f327966g = this.C;
        r100.f327961b = this.f327901b;
        r100.f327964e = this.f327916q;
        r100.f327965f = this.D;
        r100.f327967h = this.E;
        r100.f327968i = this.F;
        r100.f327969j = this.G;
        r100.f327970k = this.H;
    }

    public final int g(int r100) {
        int r101 = this.f327904e;
        if (r101 == 0) goto L6;
        return r101;
    L6:
        if (r100 != 1) goto L9;
        return this.f327905f;
    L9:
        if (r100 != 2) goto L12;
        return this.f327906g;
    L12:
        if (r100 != 8) goto L15;
        return this.f327907h;
    L15:
        if (r100 == 4) goto L22;
        return 0;
    L22:
        return this.f327908i;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int r100) {
        super.onRtlPropertiesChanged(r100);
        if (this.B == true) goto L5;
    L8:
        b();
        return;
    L5:
        if (getLayoutDirection() != 1) goto L7;
        this.f327921v = this.A;
        this.f327923x = this.f327925z;
        goto L8
    L7:
        this.f327921v = this.f327925z;
        this.f327923x = this.A;
        goto L8
    }

    public final void setBottomLeftRadius(int r100) {
        this.f327907h = r100;
    }

    public final void setBottomRightRadius(int r100) {
        this.f327908i = r100;
    }

    public final void setCornerRadius(int r100) {
        this.f327904e = r100;
    }

    public final void setFillColor(int r100) {
        this.f327901b = r100;
    }

    public final void setStrokeColor(int r100) {
        this.f327902c = r100;
    }

    public final void setStrokeWidth(int r100) {
        this.f327903d = r100;
    }

    public final void setTopLeftRadius(int r100) {
        this.f327905f = r100;
    }

    public final void setTopRightRadius(int r100) {
        this.f327906g = r100;
    }

    public final void d(float[] r100, boolean r101) {
        if (this.f327916q <= 0) goto L21;
        float[] r102 = this.f327917r;
        if (r102 == null) goto L12;
        boolean r103 = false;
        if (r102 != null) goto L9;
    L11:
        if (r103 == false) goto L12;
    L13:
        if (r101 == false) goto L15;
        b();
        return;
    L15:
        float[] r104 = this.f327917r;
        if (r104 == null) goto L19;
        r100 = r104;
    L19:
        c(r100);
        return;
    L9:
        if (r102.length != 8) goto L11;
        r103 = true;
    L12:
        this.f327917r = r100;
        goto L13
    L21:
        setBackground(getGradientDrawable());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        boolean r102 = false;
        if (this.f327918s == 1) goto L6;
        super.onMeasure(r100, r101);
        float[] r103 = getCornerRadiusByPosition();
        e(r103);
        d(r103, false);
        return;
    L6:
        float[] r104 = getCornerRadiusByPosition();
        e(r104);
        if (this.f327916q <= 0) goto L20;
        float[] r105 = this.f327917r;
        if (r105 == null) goto L15;
        if (r105 != null) goto L12;
    L14:
        if (r102 == false) goto L15;
    L16:
        float[] r106 = this.f327917r;
        if (r106 != null) goto L19;
        r106 = r104;
    L19:
        c(r106);
        goto L20
    L12:
        if (r105.length != 8) goto L14;
        r102 = true;
    L15:
        this.f327917r = r104;
    L20:
        super.onMeasure(r100, r101);
        d(r104, true);
    }

    public ShapeLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f327909j = -1;
        this.I = new Paint(1);
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.NONE;
        this.f327899J = LazyKt.lazy(r103, new h());
        this.K = LazyKt.lazy(r103, new i(this));
        this.L = LazyKt.lazy(r103, new j(this));
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_sc_bottomLeftRadius, R.attr.larus_sc_bottomRightRadius, R.attr.larus_sc_cornerPosition, R.attr.larus_sc_cornerRadius, R.attr.larus_sc_endColor, R.attr.larus_sc_exclude_bottom, R.attr.larus_sc_exclude_dx, R.attr.larus_sc_exclude_left, R.attr.larus_sc_exclude_right, R.attr.larus_sc_exclude_top, R.attr.larus_sc_fillColor, R.attr.larus_sc_midColor, R.attr.larus_sc_orientation, R.attr.larus_sc_pressedColor, R.attr.larus_sc_shadow_blur_radius, R.attr.larus_sc_shadow_color, R.attr.larus_sc_shadow_dx, R.attr.larus_sc_shadow_dy, R.attr.larus_sc_shadow_layout_mode, R.attr.larus_sc_shapeMode, R.attr.larus_sc_startColor, R.attr.larus_sc_strokeColor, R.attr.larus_sc_strokeWidth, R.attr.larus_sc_topLeftRadius, R.attr.larus_sc_topRightRadius, R.attr.larus_sc_withElevation});
        this.f327900a = r104.getInt(19, 0);
        this.f327901b = r104.getColor(10, -1);
        this.f327902c = r104.getColor(21, 0);
        this.f327903d = r104.getDimensionPixelSize(22, 0);
        this.f327904e = r104.getDimensionPixelSize(3, 0);
        this.f327905f = r104.getDimensionPixelSize(23, 0);
        this.f327906g = r104.getDimensionPixelSize(24, 0);
        this.f327908i = r104.getDimensionPixelSize(1, 0);
        this.f327907h = r104.getDimensionPixelSize(0, 0);
        this.f327909j = r104.getInt(2, -1);
        this.f327910k = r104.getColor(20, -1);
        this.f327911l = r104.getColor(11, -1);
        this.f327912m = r104.getColor(4, -1);
        this.f327913n = r104.getColor(12, 0);
        r104.getDimensionPixelSize(25, 0);
        this.C = r104.getColor(15, 0);
        this.D = r104.getBoolean(6, false);
        this.E = r104.getBoolean(7, false);
        this.G = r104.getBoolean(8, false);
        this.F = r104.getBoolean(9, false);
        this.H = r104.getBoolean(5, false);
        this.f327914o = r104.getDimensionPixelSize(16, 0);
        this.f327915p = r104.getDimensionPixelSize(17, 0);
        this.f327916q = r104.getDimensionPixelSize(14, 0);
        this.f327918s = r104.getInt(18, 0);
        r104.recycle();
        this.f327921v = getPaddingLeft();
        this.f327922w = getPaddingTop();
        this.f327923x = getPaddingRight();
        this.f327924y = getPaddingBottom();
        this.f327925z = getPaddingStart();
        this.A = getPaddingEnd();
        this.B = isPaddingRelative();
    }

    public /* synthetic */ ShapeLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        if (this.f327919t == false) goto L5;
    L19:
        super.setPadding(r100, r101, r102, r103);
        return;
    L5:
        if (this.f327920u == true) goto L19;
        this.f327921v = r100;
        this.f327922w = r101;
        this.f327923x = r102;
        this.f327924y = r103;
        if (getLayoutDirection() != 1) goto L10;
        int r104 = r102;
    L11:
        this.f327925z = r104;
        if (getLayoutDirection() != 1) goto L14;
        int r105 = r100;
    L15:
        this.A = r105;
        this.B = false;
        if (b() == true) goto L21;
        super.setPadding(r100, r101, r102, r103);
        return;
    L21:
        return;
    L14:
        r105 = r102;
        goto L15
    L10:
        r104 = r100;
        goto L11
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r100, int r101, int r102, int r103) {
        if (this.f327919t == false) goto L5;
    L15:
        super.setPaddingRelative(r100, r101, r102, r103);
        return;
    L5:
        if (this.f327920u == true) goto L15;
        this.f327925z = r100;
        this.f327922w = r101;
        this.A = r102;
        this.f327924y = r103;
        this.B = true;
        if (getLayoutDirection() != 1) goto L10;
        this.f327921v = this.A;
        this.f327923x = this.f327925z;
    L12:
        if (b() == true) goto L17;
        super.setPaddingRelative(r100, r101, r102, r103);
        return;
    L17:
        return;
    L10:
        this.f327921v = this.f327925z;
        this.f327923x = this.A;
        goto L12
    }
}
