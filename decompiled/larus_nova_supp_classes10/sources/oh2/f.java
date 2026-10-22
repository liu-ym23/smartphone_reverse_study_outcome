package oh2;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends Drawable {
    public final Paint a;
    public final RectF b;
    public final int[] c;
    public final float[] d;
    public final float e;
    public final float f;
    public final int[] g;
    public final float[] h;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        RectF r0 = this.b;
        float r1 = this.e;
        r4.drawRoundRect(r0, r1, r1, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r11) {
        Intrinsics.checkNotNullParameter(r11, "bounds");
        super.onBoundsChange(r11);
        float r0 = (this.f / 2) - UtilityKotlinExtentionsKt.c(Double.valueOf(0.01d));
        this.b.set(r11.left + r0, r11.top + r0, r11.right - r0, r11.bottom - r0);
        int[] r1 = this.g;
        int r2 = r1.length;
        float[] r3 = this.h;
        if (r2 == r3.length) goto L5;
    L11:
        Pair r4 = TuplesKt.to(this.c, this.d);
    L12:
        this.a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r11.height(), (int[]) r4.component1(), (float[]) r4.component2(), Shader.TileMode.CLAMP));
        return;
    L5:
        if (r1.length != 0) goto L7;
        boolean r5 = true;
    L9:
        if ((!r5) == false) goto L11;
        r4 = TuplesKt.to(r1, r3);
        goto L12
    L7:
        r5 = false;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
    }

    public f(float r2, float r3, int[] r4, float[] r5) {
        Intrinsics.checkNotNullParameter(r4, "borderColors");
        Intrinsics.checkNotNullParameter(r5, "borderPositions");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        Paint r6 = new Paint(1);
        r6.setStyle(Paint.Style.STROKE);
        r6.setStrokeWidth(r3);
        Unit r7 = Unit.INSTANCE;
        this.a = r6;
        this.b = new RectF();
        this.c = new int[]{ColorProtector.parseColor("#33FFFFFF"), ColorProtector.parseColor("#1AAD7E8B"), ColorProtector.parseColor("#4DF42D51")};
        this.d = new float[]{0.0f, 0.52f, 1.0f};
    }
}
