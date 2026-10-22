package yz3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import com.bytedance.awemeopen.infra.util.e;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f569518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f569519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f569520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f569521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f569522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f569523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f569524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f569525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f569526i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f569527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f569528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f569529l;

    public a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r110);
        Paint r100 = new Paint();
        r100.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, ColorProtector.parseColor("#FF1764"), ColorProtector.parseColor("#ED3495"), Shader.TileMode.MIRROR));
        r100.setAntiAlias(true);
        r100.setDither(true);
        r100.setStyle(Paint.Style.STROKE);
        r100.setStrokeWidth(e.a(getContext(), 1.5f));
        this.f569518a = r100;
        this.f569519b = new Paint(r100);
        this.f569520c = e.a(r110, 1.2f);
        this.f569526i = 255;
        this.f569528k = 1.08f;
        this.f569529l = 1.2f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.drawCircle(this.f569521d, this.f569522e, this.f569523f, this.f569518a);
        r100.drawCircle(this.f569521d, this.f569522e, this.f569524g, this.f569519b);
    }

    public final void setFractionWithAlpha(float r110) {
        float r100 = (this.f569523f + (this.f569527j * r110)) * this.f569528k;
        float r101 = 1;
        float r102 = (this.f569520c * (r101 - r110)) * this.f569529l;
        if (Math.abs(r100 - this.f569524g) >= 0.5f) goto L8;
        if (Math.abs(this.f569525h - r102) >= 0.5f) goto L8;
        return;
    L8:
        if (r110 < 0.5d) goto L11;
        r110 = Math.abs(r110 - r101);
    L11:
        this.f569524g = r100;
        this.f569518a.setAlpha((int) (((double) this.f569526i) * (((double) r110) + 0.5d)));
        this.f569525h = r102;
        this.f569519b.setAlpha((int) (this.f569526i * r110));
        this.f569519b.setStrokeWidth(r102);
        postInvalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f569521d = getMeasuredWidth() / 2;
        this.f569522e = getMeasuredHeight() / 2;
        float r102 = (getMeasuredHeight() / 2) - getPaddingBottom();
        this.f569523f = r102;
        this.f569524g = r102;
        this.f569527j = getPaddingBottom();
    }
}
