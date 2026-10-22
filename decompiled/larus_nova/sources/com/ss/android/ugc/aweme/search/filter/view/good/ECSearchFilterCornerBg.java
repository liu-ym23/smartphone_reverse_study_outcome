package com.ss.android.ugc.aweme.search.filter.view.good;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.mob.CommodityMobHelper;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import j46.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\"\u0010\u0019\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\fR*\u0010%\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\b\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\f¨\u0006,"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/ECSearchFilterCornerBg;", "Landroid/view/View;", "", "color", "", "setPaintColor", "", "f", FaceService.girlLabel, "getTopRadius", "()F", "setTopRadius", "(F)V", "topRadius", ce.f26391f, "getBottomRadius", "setBottomRadius", "bottomRadius", "h", "getLineBottomRadius", "setLineBottomRadius", "lineBottomRadius", "", RXScreenCaptureService.KEY_INDEX, "Z", "isFromCommodity", "()Z", "setFromCommodity", "(Z)V", "value", "l", "getExpandHeight", "setExpandHeight", "expandHeight", "m", "getBorderWidth", "setBorderWidth", "borderWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECSearchFilterCornerBg extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f453177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f453178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f453179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f453180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f453181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f453182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f453183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f453184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f453185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CornerType f453186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f453187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f453188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f453189m;

    public final float getBorderWidth() {
        return this.f453189m;
    }

    public final float getBottomRadius() {
        return this.f453183g;
    }

    public final float getExpandHeight() {
        return this.f453188l;
    }

    public final float getLineBottomRadius() {
        return this.f453184h;
    }

    public final float getTopRadius() {
        return this.f453182f;
    }

    public ECSearchFilterCornerBg(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Object r100 = getParent();
        Object r101 = null;
        if ((r100 instanceof View) == true) goto L5;
        r100 = null;
    L5:
        View r102 = (View) r100;
        if (r102 == null) goto L8;
        int r103 = r102.getWidth();
    L9:
        ViewParent r104 = getParent();
        if ((r104 instanceof View) == false) goto L13;
        r101 = r104;
    L13:
        View r105 = (View) r101;
        if (r105 == null) goto L16;
        int r106 = r105.getHeight();
    L18:
        if (this.f453186j != CornerType.CUSTOM_CORNER) goto L21;
        RectF r107 = this.f453181e;
        r107.left = 0.0f;
        r107.top = 0.0f;
        r107.right = r103;
        r107.bottom = r106;
        this.f453180d.reset();
        this.f453180d.addRoundRect(this.f453181e, new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        r110.drawPath(this.f453180d, this.f453177a);
        return;
    L21:
        float r108 = this.f453188l;
        if (r108 != 0.0f) goto L28;
        if (this.f453189m != 0.0f) goto L28;
        RectF r109 = this.f453181e;
        r109.left = 0.0f;
        r109.top = 0.0f;
        r109.right = r103;
        r109.bottom = r106;
        float r111 = this.f453182f;
        r110.drawRoundRect(r109, r111, r111, this.f453177a);
        return;
    L28:
        if (r108 == 0.0f) goto L39;
        if (this.f453185i == false) goto L32;
    L35:
        float r112 = 2;
        float r113 = this.f453187k * r112;
        this.f453180d.reset();
        float r114 = r106;
        this.f453180d.moveTo(-r113, this.f453188l + r114);
        this.f453180d.lineTo(-this.f453184h, this.f453188l + r114);
        RectF r115 = this.f453181e;
        float r116 = this.f453184h * r112;
        r115.left = 0 - r116;
        r115.right = 0.0f;
        float r117 = this.f453188l + r114;
        r115.bottom = r117;
        r115.top = r117 - r116;
        this.f453180d.arcTo(r115, -270.0f, -90.0f);
        this.f453180d.lineTo(0.0f, this.f453182f);
        RectF r118 = this.f453181e;
        r118.left = 0.0f;
        r118.top = 0.0f;
        float r119 = this.f453182f * r112;
        r118.right = r119;
        r118.bottom = r119;
        this.f453180d.arcTo(r118, -180.0f, 90.0f);
        float r120 = r103;
        this.f453180d.lineTo(r120 - this.f453182f, 0.0f);
        RectF r121 = this.f453181e;
        float r122 = this.f453182f * r112;
        r121.left = r120 - r122;
        r121.right = r120;
        r121.top = 0.0f;
        r121.bottom = r122;
        this.f453180d.arcTo(r121, -90.0f, 90.0f);
        this.f453180d.lineTo(r120, (this.f453188l + r114) - this.f453184h);
        this.f453180d.lineTo(r120, (this.f453188l + r114) - this.f453184h);
        RectF r123 = this.f453181e;
        r123.left = r120;
        float r124 = this.f453184h * r112;
        r123.right = r120 + r124;
        float r125 = this.f453188l + r114;
        r123.bottom = r125;
        r123.top = r125 - r124;
        this.f453180d.arcTo(r123, -180.0f, -90.0f);
        this.f453180d.lineTo(r113, r114 + this.f453188l);
        Path r126 = this.f453180d;
    L36:
        r110.drawPath(r126, this.f453178b);
        return;
    L32:
        if (CommodityMobHelper.a(getContext()) == true) goto L35;
        float r127 = 2;
        float r128 = this.f453187k * r127;
        this.f453180d.reset();
        float r129 = r106;
        this.f453180d.moveTo(-r128, this.f453188l + r129);
        this.f453180d.lineTo(0.0f, this.f453188l + r129);
        this.f453180d.lineTo(0.0f, this.f453182f);
        RectF r130 = this.f453181e;
        r130.left = 0.0f;
        r130.top = 0.0f;
        float r131 = this.f453182f * r127;
        r130.right = r131;
        r130.bottom = r131;
        this.f453180d.arcTo(r130, -180.0f, 90.0f);
        float r132 = r103;
        this.f453180d.lineTo(r132 - this.f453182f, 0.0f);
        RectF r133 = this.f453181e;
        float r134 = this.f453182f * r127;
        r133.left = r132 - r134;
        r133.right = r132;
        r133.top = 0.0f;
        r133.bottom = r134;
        this.f453180d.arcTo(r133, -90.0f, 90.0f);
        this.f453180d.lineTo(r132, this.f453188l + r129);
        this.f453180d.lineTo(r128, r129 + this.f453188l);
        r126 = this.f453180d;
        goto L36
    L39:
        if (this.f453189m == 0.0f) goto L42;
        RectF r135 = this.f453181e;
        r135.left = 0.0f;
        r135.top = 0.0f;
        r135.right = r103;
        r135.bottom = r106;
        float r136 = this.f453182f;
        r110.drawRoundRect(r135, r136, r136, this.f453179c);
        RectF r137 = this.f453181e;
        float r138 = this.f453182f;
        r110.drawRoundRect(r137, r138, r138, this.f453177a);
        return;
    L42:
        return;
    L16:
        r106 = getHeight();
        goto L18
    L8:
        r103 = getWidth();
        goto L9
    }

    public final void setBorderWidth(float r100) {
        this.f453189m = r100;
        invalidate();
    }

    public final void setBottomRadius(float r100) {
        this.f453183g = r100;
    }

    public final void setExpandHeight(float r100) {
        this.f453188l = r100;
        invalidate();
    }

    public final void setFromCommodity(boolean r100) {
        this.f453185i = r100;
    }

    public final void setLineBottomRadius(float r100) {
        this.f453184h = r100;
    }

    public final void setPaintColor(int r100) {
        this.f453177a.setColor(r100);
        invalidate();
    }

    public final void setTopRadius(float r100) {
        this.f453182f = r100;
    }

    public ECSearchFilterCornerBg(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint r102 = new Paint();
        this.f453177a = r102;
        Paint r103 = new Paint();
        this.f453178b = r103;
        Paint r104 = new Paint();
        this.f453179c = r104;
        this.f453180d = new Path();
        this.f453181e = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        float r105 = 6;
        Resources r106 = Resources.getSystem();
        this.f453182f = TypedValue.applyDimension(1, r105, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()));
        Resources r107 = Resources.getSystem();
        this.f453183g = TypedValue.applyDimension(1, r105, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()));
        Resources r108 = Resources.getSystem();
        this.f453184h = TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()));
        this.f453186j = CornerType.DEFAULT_CORNER;
        this.f453187k = a.b(r100);
        r102.setAntiAlias(true);
        r103.setAntiAlias(true);
        r104.setAntiAlias(true);
    }

    public static void b(ECSearchFilterCornerBg r100, int r101) {
        Paint.Style r102 = Paint.Style.STROKE;
        Resources r103 = Resources.getSystem();
        float r104 = TypedValue.applyDimension(1, (float) 0.5d, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()));
        Intrinsics.checkNotNullParameter(r102, "style");
        r100.f453178b.setColor(r101);
        r100.f453178b.setStyle(r102);
        r100.f453178b.setStrokeWidth(r104);
        r100.invalidate();
    }

    public static void a(ECSearchFilterCornerBg r100, int r101, int r102) {
        Paint.Style r103 = Paint.Style.STROKE;
        Intrinsics.checkNotNullParameter(r103, "style");
        r100.f453179c.setColor(r101);
        r100.f453179c.setStyle(r103);
        r100.f453179c.setStrokeWidth(1.0f);
        r100.f453177a.setColor(r102);
        r100.f453177a.setStyle(Paint.Style.FILL);
        r100.invalidate();
    }
}
