package jd8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f498657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f498658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f498659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f498660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f498661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f498662f;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f498657a.setImageDrawable(null);
        super.onDetachedFromWindow();
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        ImageView r101 = new ImageView(r100);
        r101.setScaleType(ImageView.ScaleType.FIT_XY);
        r101.setImportantForAccessibility(2);
        this.f498657a = r101;
        Resources r102 = getResources();
        this.f498658b = TypedValue.applyDimension(1, 16.0f, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeWidth(r.a(r100));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r103.setColor(ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_transparent_2, r100, R.color.larus_neutral_transparent_2)));
        this.f498659c = r103;
        this.f498660d = Color.alpha(r103.getColor());
        this.f498661e = new Path();
        this.f498662f = new RectF();
        setImportantForAccessibility(2);
        addView(r101, new FrameLayout.LayoutParams(-1, -1));
        setWillNotDraw(false);
    }

    public final void a(Bitmap r100) {
        this.f498657a.setImageBitmap(r100);
        if (r100 == null) goto L8;
        int r101 = this.f498659c.getAlpha();
        int r102 = this.f498660d;
        if (r101 == r102) goto L9;
        this.f498659c.setAlpha(r102);
        invalidate();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L10;
        float r101 = this.f498659c.getStrokeWidth() / 2.0f;
        this.f498662f.set(r101, r101, getWidth() - r101, getHeight() - r101);
        this.f498661e.reset();
        Path r102 = this.f498661e;
        RectF r103 = this.f498662f;
        float r104 = this.f498658b;
        r102.addRoundRect(r103, new float[]{0.0f, 0.0f, 0.0f, 0.0f, r104, r104, r104, r104}, Path.Direction.CW);
        r100.drawPath(this.f498661e, this.f498659c);
        return;
    }

    public final void setBorderFadeFraction(float r100) {
        int r101 = RangesKt.coerceIn(MathKt.roundToInt(this.f498660d * RangesKt.coerceIn(r100, 0.0f, 1.0f)), 0, 255);
        if (this.f498659c.getAlpha() == r101) goto L6;
        this.f498659c.setAlpha(r101);
        invalidate();
        return;
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(0, 0, 0, 0);
    }
}
