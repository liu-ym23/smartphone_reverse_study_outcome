package j83;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f497698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearGradient f497699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f497700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f497701d;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public g() {
        this.f497698a = new Paint(1);
        this.f497700c = -1;
        this.f497701d = -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = getBounds().width();
        int r101 = getBounds().height();
        if (r100 <= 0) goto L14;
        if (r101 <= 0) goto L14;
        if (r100 == this.f497700c) goto L9;
    L13:
        LinearGradient r102 = new LinearGradient(0.0f, r101, 0.0f, 0.0f, new int[]{(int) 4279505940L, 437523476, 16777215}, new float[]{0.0f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
        this.f497699b = r102;
        this.f497698a.setShader(r102);
        this.f497700c = r100;
        this.f497701d = r101;
        goto L14
    L9:
        if (r101 != this.f497701d) goto L13;
        if (this.f497699b == null) goto L13;
    L14:
        r110.drawRect(getBounds(), this.f497698a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        this.f497700c = -1;
        this.f497701d = -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f497698a.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f497698a.setColorFilter(r100);
        invalidateSelf();
    }
}
