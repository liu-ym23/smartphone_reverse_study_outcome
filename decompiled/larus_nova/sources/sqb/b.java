package sqb;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.LynxView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f543149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f543150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f543151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f543152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f543153f;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in the Android SDK")
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Paint.FontMetricsInt r100 = this.f543153f.getFontMetricsInt();
        return (r100.bottom - r100.top) + (this.f543150c * 2);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return MathKt.roundToInt(this.f543153f.measureText(this.f543148a)) + (this.f543149b * 2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.drawRect(getBounds(), this.f543152e);
        r100.drawText(this.f543148a, getBounds().left + this.f543149b, (getBounds().top + this.f543150c) - this.f543153f.getFontMetricsInt().top, this.f543153f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f543153f.setAlpha(r100);
        this.f543152e.setAlpha((Color.alpha(1157508181) * r100) / 255);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f543153f.setColorFilter(r100);
        this.f543152e.setColorFilter(r100);
        invalidateSelf();
    }

    public b(LynxView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f543148a = r101;
        Resources r102 = r100.getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        this.f543149b = MathKt.roundToInt(3.0f * r103);
        this.f543150c = MathKt.roundToInt(1.0f * r103);
        this.f543151d = MathKt.roundToInt(10.0f * r103);
        Paint r104 = new Paint();
        r104.setColor(1157508181);
        r104.setStyle(Paint.Style.FILL);
        this.f543152e = r104;
        Paint r105 = new Paint(1);
        r105.setColor(-1);
        r105.setTextSize(r103 * 12.0f);
        this.f543153f = r105;
    }
}
