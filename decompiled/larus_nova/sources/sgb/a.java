package sgb;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f541892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f541893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f541894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f541895d;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public a() {
        this.f541892a = 145.36f;
        this.f541893b = 0.6018f;
        this.f541894c = 1.2244f;
        this.f541895d = new Paint(1);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.drawRect(getBounds(), this.f541895d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r210) {
        Intrinsics.checkNotNullParameter(r210, "bounds");
        Paint r100 = this.f541895d;
        int r101 = r210.width();
        int r102 = r210.height();
        float r103 = this.f541892a;
        float r104 = this.f541893b;
        float r105 = this.f541894c;
        float r106 = r101;
        float r107 = r102;
        double r108 = Math.toRadians(r103);
        float r109 = (float) Math.sin(r108);
        float r110 = (float) (-Math.cos(r108));
        float r111 = RangesKt.coerceAtLeast((float) Math.hypot(r109, r110), 1.0E-6f);
        float r112 = r109 / r111;
        float r113 = r110 / r111;
        int r114 = 4;
        Float r115 = Float.valueOf(0.0f);
        Pair[] r116 = {TuplesKt.to(r115, r115), TuplesKt.to(Float.valueOf(r106), r115), TuplesKt.to(r115, Float.valueOf(r107)), TuplesKt.to(Float.valueOf(r106), Float.valueOf(r107))};
        float r117 = Float.POSITIVE_INFINITY;
        float r118 = Float.NEGATIVE_INFINITY;
        int r119 = 0;
    L3:
        if (r119 >= r114) goto L5;
        Pair r120 = r116[r119];
        float r121 = (((Number) r120.component1()).floatValue() * r112) + (((Number) r120.component2()).floatValue() * r113);
        r117 = Math.min(r117, r121);
        r118 = Math.max(r118, r121);
        r119 = r119 + 1;
        r114 = 4;
        goto L3
    L5:
        float r122 = r112 * r117;
        float r123 = r113 * r117;
        r100.setShader(new LinearGradient(r122, r123, r122 + (((r112 * r118) - r122) * r105), r123 + (((r113 * r118) - r123) * r105), new int[]{0, 0, Color.argb(MathKt.roundToInt(38.25f), 0, 0, 0)}, new float[]{0.0f, RangesKt.coerceIn(r104 / r105, 0.0f, 1.0f), 1.0f}, Shader.TileMode.CLAMP));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f541895d.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f541895d.setColorFilter(r100);
    }
}
