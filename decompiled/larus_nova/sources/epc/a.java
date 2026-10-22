package epc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f473442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f473443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f473444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f473445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f473446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GradientDrawable f473447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f473448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f473449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f473450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f473451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f473452k;

    /* JADX INFO: renamed from: epc.a$a, reason: collision with other inner class name */
    public static final class C5802a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f473447f.setBounds(getBounds());
        this.f473447f.draw(r100);
        Drawable r101 = this.f473442a;
        if (r101 == null) goto L5;
        r101.setBounds(this.f473449h, this.f473450i, this.f473451j, this.f473452k);
        this.f473442a.draw(r100);
    L5:
        r100.drawText(this.f473443b, (this.f473445d / 2) + this.f473448g, getBounds().exactCenterY() + this.f473446e, this.f473444c);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f473444c.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f473444c.setColorFilter(r100);
        invalidateSelf();
    }

    public static float a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public a(Context r100, Drawable r101, String r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "text");
        this.f473442a = r101;
        this.f473443b = r102;
        Paint r105 = new Paint(1);
        r105.setColor(r104);
        r105.setTextSize(a(r100, 12.0f));
        r105.setTextAlign(Paint.Align.CENTER);
        this.f473444c = r105;
        float r106 = r105.measureText(r102);
        this.f473445d = r106;
        this.f473446e = ((r105.getFontMetrics().bottom - r105.getFontMetrics().top) / 2) - r105.getFontMetrics().bottom;
        GradientDrawable r107 = new GradientDrawable();
        r107.setColor(r103);
        r107.setCornerRadius(a(r100, 4.0f));
        this.f473447f = r107;
        if (r101 == null) goto L5;
        float r108 = a(r100, 18.0f);
    L6:
        this.f473448g = r108 + a(r100, 4.0f);
        this.f473449h = (int) a(r100, 8.0f);
        this.f473450i = (int) (a(r100, 3.0f) + 0.5f);
        this.f473451j = (int) a(r100, 20.0f);
        this.f473452k = (int) a(r100, 15.0f);
        if (r101 == null) goto L9;
        float r109 = a(r100, 22.0f);
    L10:
        setBounds(new Rect((int) a(r100, 4.0f), 0, ((int) (r109 + r106)) + ((int) a(r100, 4.0f)), (int) a(r100, 18.0f)));
        return;
    L9:
        r109 = a(r100, 8.0f);
        goto L10
    L5:
        r108 = a(r100, 4.0f);
        goto L6
    }
}
