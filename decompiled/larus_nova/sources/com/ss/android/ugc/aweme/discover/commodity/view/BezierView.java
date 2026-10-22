package com.ss.android.ugc.aweme.discover.commodity.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010E\u001a\u00020\u0002¢\u0006\u0004\bF\u0010GJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R*\u0010,\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u00100\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u0017\u00103\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b1\u0010\u001d\u001a\u0004\b2\u0010\u001fR\u0017\u00106\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b5\u0010\u0012R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010?\u001a\u00020\u000e8\u0006X\u0086D¢\u0006\f\n\u0004\b?\u0010\u0010\u001a\u0004\b@\u0010\u0012¨\u0006H"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/view/BezierView;", "Landroid/view/View;", "", "value", "", "setn", "radius", "setCornerRadius", "seta", "height", "setDescendHeight", "", "setStart", "setEnd", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getDensity", "()F", "density", "Landroid/graphics/Path;", "e", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "path", "f", "I", "getN", "()I", "setN", "(I)V", OfficeSDKRequestTag.KEY_NEW_USER, ce.f26391f, "getA", "setA", "h", "Ljava/lang/String;", "getStartColor", "()Ljava/lang/String;", "setStartColor", "(Ljava/lang/String;)V", "startColor", RXScreenCaptureService.KEY_INDEX, "getEndColor", "setEndColor", "endColor", ce.f26395j, "getGradientHeightPx", "gradientHeightPx", ce.f26396k, "getEndY", "endY", "Landroid/graphics/LinearGradient;", "l", "Landroid/graphics/LinearGradient;", "getShader", "()Landroid/graphics/LinearGradient;", "setShader", "(Landroid/graphics/LinearGradient;)V", "shader", "startY", "getStartY", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BezierView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f450394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f450395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f450396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f450397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f450398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f450399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f450400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f450401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f450402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f450403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f450404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearGradient f450405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f450406m;

    public BezierView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BezierView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final float getStartY() {
        return 0.0f;
    }

    public final int getA() {
        return this.f450400g;
    }

    public final float getDensity() {
        return this.f450394a;
    }

    public final String getEndColor() {
        return this.f450402i;
    }

    public final float getEndY() {
        return this.f450404k;
    }

    public final int getGradientHeightPx() {
        return this.f450403j;
    }

    public final int getN() {
        return this.f450399f;
    }

    public final Path getPath() {
        return this.f450398e;
    }

    public final LinearGradient getShader() {
        return this.f450405l;
    }

    public final String getStartColor() {
        return this.f450401h;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r410) {
        Intrinsics.checkNotNullParameter(r410, "canvas");
        super.onDraw(r410);
        this.f450398e.reset();
        this.f450395b.setShader(this.f450405l);
        float r100 = getWidth() - (this.f450394a * 0.5f);
        float r101 = getHeight();
        float r102 = this.f450394a;
        float r103 = r101 - (r102 * 0.5f);
        int r104 = this.f450399f;
        int r105 = this.f450400g;
        float r106 = (r100 / r104) * r105;
        float r107 = (r100 / r104) * (r105 - 1);
        float r110 = this.f450406m * r102;
        float r111 = (this.f450397d + 34.0f) * r102;
        float r112 = r102 * 50.0f;
        float r113 = 48.0f * r102;
        float r114 = 14.0f * r102;
        if (r105 != 1) goto L6;
        Path r108 = this.f450398e;
        double r109 = r106;
        double r115 = r100;
        double r210 = 0.051d * r115;
        float r116 = (float) (r109 - r210);
        r108.moveTo(r116, (r102 * 0.5f) + 0.0f);
        float r117 = this.f450406m;
        float r118 = this.f450394a;
        r108.lineTo(r117 * r118, (r118 * 0.5f) + 0.0f);
        float r119 = this.f450394a;
        r108.quadTo((r119 * 0.5f) + 0.0f, (r119 * 0.5f) + 0.0f, (r119 * 0.5f) + 0.0f, this.f450406m * r119);
        float r120 = this.f450394a;
        r108.lineTo((r120 * 0.5f) + 0.0f, r103 - (this.f450406m * r120));
        float r121 = this.f450394a;
        r108.quadTo((r121 * 0.5f) + 0.0f, r103, this.f450406m * r121, r103);
        r108.lineTo(r100 - (this.f450406m * this.f450394a), r103);
        r108.quadTo(r100, r103, r100, r103 - (this.f450406m * this.f450394a));
        r108.lineTo(r100, this.f450394a * 50.0f);
        r108.quadTo(r100, r111, r100 - r114, r111);
        r108.lineTo((float) (r109 + r210), r111);
        double r122 = r115 * 0.034d;
        double r211 = 0.018d * r115;
        int r123 = this.f450397d;
        float r124 = this.f450394a;
        double r125 = r115 * 0.011d;
        r108.cubicTo((float) (r109 + r122), r111, (float) (r211 + r109), (r123 + 30.576f) * r124, (float) (r125 + r109), (r123 + 25.1554f) * r124);
        r108.lineTo((float) (r109 - r125), this.f450394a * 8.84458f);
        float r126 = this.f450394a;
        r108.cubicTo((float) (r109 - r211), r126 * 3.42404f, (float) (r109 - r122), (r126 * 0.5f) + 0.0f, r116, (r126 * 0.5f) + 0.0f);
        r108.close();
        r410.drawPath(this.f450398e, this.f450395b);
        r410.drawPath(this.f450398e, this.f450396c);
        return;
    L6:
        if (r105 != r104) goto L8;
        Path r127 = this.f450398e;
        double r128 = r107;
        double r129 = r100;
        double r212 = 0.051d * r129;
        float r130 = (float) (r128 + r212);
        r127.moveTo(r130, (r102 * 0.5f) + 0.0f);
        float r131 = this.f450406m;
        float r132 = this.f450394a;
        r127.lineTo(r100 - (r131 * r132), (r132 * 0.5f) + 0.0f);
        float r133 = this.f450394a;
        r127.quadTo(r100, (r133 * 0.5f) + 0.0f, r100, this.f450406m * r133);
        r127.lineTo(r100, r103 - (this.f450406m * this.f450394a));
        r127.quadTo(r100, r103, r100 - (this.f450406m * this.f450394a), r103);
        r127.lineTo(this.f450406m * this.f450394a, r103);
        float r134 = this.f450394a;
        r127.quadTo((r134 * 0.5f) + 0.0f, r103, (r134 * 0.5f) + 0.0f, r103 - (this.f450406m * r134));
        float r135 = this.f450394a;
        r127.lineTo((r135 * 0.5f) + 0.0f, r135 * 50.0f);
        r127.quadTo((this.f450394a * 0.5f) + 0.0f, r111, r114, r111);
        r127.lineTo((float) (r128 - r212), r111);
        double r136 = r129 * 0.034d;
        int r137 = this.f450397d;
        float r138 = this.f450394a;
        r127.cubicTo((float) (r128 - r136), r111, (float) (((-0.018d) * r129) + r128), (r137 + 30.576f) * r138, (float) (((-0.011d) * r129) + r128), (r137 + 25.1554f) * r138);
        r127.lineTo((float) (r128 + (0.011d * r129)), this.f450394a * 8.84458f);
        float r139 = this.f450394a;
        r127.cubicTo((float) ((r129 * 0.018d) + r128), r139 * 3.42404f, (float) (r128 + r136), (r139 * 0.5f) + 0.0f, r130, (r139 * 0.5f) + 0.0f);
        r127.close();
        r410.drawPath(this.f450398e, this.f450395b);
        r410.drawPath(this.f450398e, this.f450396c);
        return;
    L8:
        Path r140 = this.f450398e;
        double r141 = r106;
        double r142 = r100;
        double r213 = 0.051d * r142;
        float r143 = (float) (r141 + r213);
        r140.moveTo(r143, r111);
        float r144 = r100 - r110;
        r140.lineTo(r144, r111);
        r140.quadTo(r100, r111, r100, r113);
        float r145 = r103 - r110;
        r140.lineTo(r100, r145);
        r140.quadTo(r100, r103, r144, r103);
        r140.lineTo(r110, r103);
        float r146 = this.f450394a;
        r140.quadTo((r146 * 0.5f) + 0.0f, r103, (r146 * 0.5f) + 0.0f, r145);
        r140.lineTo((this.f450394a * 0.5f) + 0.0f, r112);
        r140.quadTo((this.f450394a * 0.5f) + 0.0f, r111, r114, r111);
        double r147 = r107;
        r140.lineTo((float) (r147 - r213), r111);
        double r148 = r142 * 0.034d;
        double r310 = (-0.018d) * r142;
        int r149 = this.f450397d;
        float r150 = this.f450394a;
        double r311 = (-0.011d) * r142;
        r140.cubicTo((float) (r147 - r148), r111, (float) (r310 + r147), (r149 + 30.576f) * r150, (float) (r311 + r147), (r149 + 25.1554f) * r150);
        double r151 = r142 * 0.011d;
        r140.lineTo((float) (r147 + r151), this.f450394a * 8.84458f);
        double r152 = r142 * 0.018d;
        float r153 = this.f450394a;
        r140.cubicTo((float) (r147 + r152), r153 * 3.42404f, (float) (r147 + r148), (r153 * 0.5f) + 0.0f, (float) (r147 + r213), (r153 * 0.5f) + 0.0f);
        r140.lineTo((float) (r141 - r213), (this.f450394a * 0.5f) + 0.0f);
        float r154 = this.f450394a;
        r140.cubicTo((float) (r141 - r148), (r154 * 0.5f) + 0.0f, (float) (r310 + r141), r154 * 3.42404f, (float) (r311 + r141), r154 * 8.84458f);
        r140.lineTo((float) (r141 + r151), (this.f450397d + 25.1554f) * this.f450394a);
        r140.cubicTo((float) (r141 + r152), (this.f450397d + 30.576f) * this.f450394a, (float) (r141 + r148), r111, r143, r111);
        r140.close();
        r410.drawPath(this.f450398e, this.f450395b);
        r410.drawPath(this.f450398e, this.f450396c);
    }

    public final void setA(int r100) {
        this.f450400g = r100;
    }

    public final void setCornerRadius(int r100) {
        this.f450406m = r100;
    }

    public final void setDescendHeight(int r100) {
        this.f450397d = r100 - 34;
        invalidate();
    }

    public final void setEnd(String r110) {
        Intrinsics.checkNotNullParameter(r110, "value");
        setEndColor(r110);
        this.f450405l = new LinearGradient(0.0f, 0.0f, 0.0f, this.f450404k, new int[]{ColorProtector.parseColor(this.f450401h), ColorProtector.parseColor(this.f450402i)}, null, Shader.TileMode.CLAMP);
    }

    public final void setEndColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f450402i = r100;
    }

    public final void setN(int r100) {
        this.f450399f = r100;
    }

    public final void setPath(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f450398e = r100;
    }

    public final void setShader(LinearGradient r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f450405l = r100;
    }

    public final void setStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        setStartColor(r100);
    }

    public final void setStartColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f450401h = r100;
    }

    public final void seta(int r100) {
        this.f450400g = r100;
        invalidate();
    }

    public final void setn(int r100) {
        this.f450399f = r100;
        invalidate();
    }

    public BezierView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        Resources r100 = r110.getResources();
        float r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
        this.f450394a = r101;
        Paint r102 = new Paint(1);
        this.f450395b = r102;
        Paint r103 = new Paint(1);
        r103.setColor(ContextCompat.getColor(r110, R.color.Bezier_border_color));
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeWidth(r101 * 1.0f);
        Unit r104 = Unit.INSTANCE;
        this.f450396c = r103;
        this.f450398e = new Path();
        this.f450399f = 1;
        this.f450400g = 1;
        this.f450401h = "#FFDADA";
        this.f450402i = CustomHeaderConfig.COLOR_LIGHT;
        Resources r105 = getResources();
        int r106 = (int) TypedValue.applyDimension(1, 30.0f, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()));
        this.f450403j = r106;
        float r107 = r106;
        this.f450404k = r107;
        this.f450405l = new LinearGradient(0.0f, 0.0f, 0.0f, r107, new int[]{ColorProtector.parseColor(this.f450401h), ColorProtector.parseColor(this.f450402i)}, null, Shader.TileMode.CLAMP);
        r102.setColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        r102.setStyle(Paint.Style.FILL);
        TypedArray r108 = getContext().obtainStyledAttributes(r111, new int[]{R.attr.curPosition, R.attr.tabNumber}, r112, 0);
        this.f450399f = r108.getInt(1, 0);     // Catch: Throwable -> L6
        this.f450400g = r108.getInt(0, 0);     // Catch: Throwable -> L6
        r108.recycle();
        this.f450406m = 16;
        return;
    L6:
        th = move-exception;
        r108.recycle();
        throw th;
    }

    public /* synthetic */ BezierView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
