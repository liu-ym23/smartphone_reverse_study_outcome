package rv6;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a extends Drawable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f539490m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f539491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f539492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f539493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f539494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitmapShader f539495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f539496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f539497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f539498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f539499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f539500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f539501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f539502l;

    /* JADX INFO: renamed from: rv6.a$a, reason: collision with other inner class name */
    public static final class C7540a {
        public C7540a() {
        }
    }

    static {
        new C7540a();
    }

    public abstract void a(int r100, int r101, int r102, Rect r103, Rect r104);

    public final void b() {
        if (this.f539500j == false) goto L9;
        a(this.f539493c, this.f539501k, this.f539502l, getBounds(), this.f539498h);
        this.f539499i.set(this.f539498h);
        if (this.f539495e == null) goto L7;
        Matrix r100 = this.f539496f;
        RectF r101 = this.f539499i;
        r100.setTranslate(r101.left, r101.top);
        Matrix r102 = this.f539496f;
        float r103 = this.f539499i.width();
        Bitmap r104 = this.f539491a;
        Intrinsics.checkNotNull(r104);
        r102.preScale(r103 / r104.getWidth(), this.f539499i.height() / this.f539491a.getHeight());
        BitmapShader r105 = this.f539495e;
        Intrinsics.checkNotNull(r105);
        r105.setLocalMatrix(this.f539496f);
        this.f539494d.setShader(this.f539495e);
    L7:
        this.f539500j = false;
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f539494d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f539494d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (this.f539493c != 119) goto L17;
        Bitmap r100 = this.f539491a;
        if (r100 == null) goto L17;
        if (r100.hasAlpha() == true) goto L17;
        if (this.f539494d.getAlpha() < 255) goto L17;
        if (this.f539497g <= 0.05f) goto L13;
        boolean r101 = true;
    L14:
        if (r101 == true) goto L17;
        return -1;
    L13:
        r101 = false;
    L17:
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f539502l;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f539501k;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Bitmap r101 = this.f539491a;
        if (r101 != null) goto L5;
        return;
    L5:
        b();
        if (this.f539494d.getShader() != null) goto L8;
        r100.drawBitmap(r101, null, this.f539498h, this.f539494d);
        return;
    L8:
        RectF r102 = this.f539499i;
        float r103 = this.f539497g;
        r100.drawRoundRect(r102, r103, r103, this.f539494d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        this.f539500j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        if (r100 == this.f539494d.getAlpha()) goto L6;
        this.f539494d.setAlpha(r100);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f539494d.setColorFilter(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean r100) {
        this.f539494d.setDither(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean r100) {
        this.f539494d.setFilterBitmap(r100);
        invalidateSelf();
    }

    public a(Resources r100, Bitmap r101) {
        this.f539492b = 160;
        this.f539493c = 119;
        this.f539494d = new Paint(3);
        this.f539496f = new Matrix();
        this.f539498h = new Rect();
        this.f539499i = new RectF();
        this.f539500j = true;
        if (r100 == null) goto L5;
        this.f539492b = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).densityDpi;
    L5:
        this.f539491a = r101;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        this.f539501k = r101.getScaledWidth(this.f539492b);
        this.f539502l = r101.getScaledHeight(this.f539492b);
        Shader.TileMode r102 = Shader.TileMode.CLAMP;
        this.f539495e = new BitmapShader(r101, r102, r102);
        return;
    L8:
        this.f539502l = -1;
        this.f539501k = -1;
        this.f539495e = null;
    }
}
