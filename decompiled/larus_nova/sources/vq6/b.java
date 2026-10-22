package vq6;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.bytedance.locallife.dito.utils.DitoStyleParser;
import com.bytedance.locallife.dito.utils.LinearOrientation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearOrientation f556777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f556778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f556779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f556780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f556781e;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getBounds().width() != 0) goto L5;
        return;
    L5:
        if (getBounds().height() == 0) goto L13;
        int r101 = DitoStyleParser.f258679a;
        LinearGradient r102 = DitoStyleParser.d(this.f556777a, getBounds(), this.f556778b, this.f556779c, this.f556780d);
        if (r102 == null) goto L10;
        this.f556781e.setShader(r102);
    L10:
        r100.drawRect(getBounds(), this.f556781e);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f556781e.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f556781e.setColorFilter(r100);
        invalidateSelf();
    }

    public b(LinearOrientation r100, int[] r101, float[] r102, float[] r103) {
        Intrinsics.checkNotNullParameter(r101, "mGradientColors");
        this.f556777a = r100;
        this.f556778b = r101;
        this.f556779c = r102;
        this.f556780d = r103;
        this.f556781e = new Paint(1);
    }
}
