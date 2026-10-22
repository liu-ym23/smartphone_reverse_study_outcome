package ukb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f550578a;

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Bitmap r101 = getBitmap();
        if (r101 != null) goto L5;
    L35:
        ImageLoader.getDependency().reportError("CustomBitmapDrawable", "Draw after bitmap recycled");
        return;
    L5:
        if (r101.isRecycled() == true) goto L35;
        int r102 = r101.getWidth();
        int r103 = r101.getHeight();
        if (r102 <= 0) goto L33;
        if (r103 <= 0) goto L33;
        if (r101.getByteCount() > 104857600) goto L15;
        super.draw(r100);
        return;
    L15:
        ImageLoader.getDependency().reportError("CustomBitmapDrawable", "Try too draw too large bitmap(" + r101.getByteCount() + "), avoid crash");
        Resources r104 = this.f550578a;
        int r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).widthPixels;
        Resources r106 = this.f550578a;
        float r107 = (r102 * 1.0f) / r105;
        float r108 = (r103 * 1.0f) / WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).heightPixels;
        if (r107 <= r108) goto L18;
        Bitmap r109 = a(r101, 1.0f / r107);
    L19:
        if (r109 != null) goto L22;
        ImageLoader.getDependency().reportError("CustomBitmapDrawable", "Failed to scale bitmap");
        return;
    L22:
        boolean r110 = false;
        Log.i("CustomBitmapDrawable", String.format("originWidth is %s, originHeight is %s, newWidth is %s, newHeight is %s", new Object[]{Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(r109.getWidth()), Integer.valueOf(r109.getHeight())}));
        Object r111 = com.ss.android.lark.image.utils.e.a(this, "mBitmapState");
        if (r111 == null) goto L26;
        r110 = com.ss.android.lark.image.utils.e.b(r111, "mBitmap", r109);
    L26:
        if (r110 == true) goto L28;
        ImageLoader.getDependency().reportError("CustomBitmapDrawable", "Failed to replace bitmap");
        return;
    L28:
        if (r101.isRecycled() == true) goto L30;
        r101.recycle();
    L30:
        super.draw(r100);
        return;
    L18:
        r109 = a(r101, 1.0f / r108);
    L33:
        Log.e("CustomBitmapDrawable", "currentWidth:" + r102 + ", currentWidth:" + r102);
        ImageLoader.getDependency().reportError("CustomBitmapDrawable", "resolution is invalid, Failed to scale bitmap");
    }

    public a(Resources r100, Bitmap r101) {
        super(r100, r101);
        this.f550578a = r100;
    }

    public static Bitmap a(Bitmap r100, float r101) {
        Matrix r102 = new Matrix();
        r102.postScale(r101, r101);
        return Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r102, false);
    }
}
