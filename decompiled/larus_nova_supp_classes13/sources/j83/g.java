package j83;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends Drawable {
    public final Paint a;
    public LinearGradient b;
    public int c;
    public int d;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public g() {
        this.a = new Paint(1);
        this.c = -1;
        this.d = -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        int r0 = getBounds().width();
        int r1 = getBounds().height();
        if (r0 <= 0) goto L14;
        if (r1 <= 0) goto L14;
        if (r0 == this.c) goto L9;
    L13:
        LinearGradient r2 = new LinearGradient(0.0f, r1, 0.0f, 0.0f, new int[]{(int) 4279505940L, 437523476, 16777215}, new float[]{0.0f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
        this.b = r2;
        this.a.setShader(r2);
        this.c = r0;
        this.d = r1;
        goto L14
    L9:
        if (r1 != this.d) goto L13;
        if (this.b == null) goto L13;
    L14:
        r12.drawRect(getBounds(), this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        super.onBoundsChange(r2);
        this.c = -1;
        this.d = -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
        invalidateSelf();
    }
}
