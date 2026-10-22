package u7a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes32.dex */
public final class j extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m.b f549114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f549115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f549116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Matrix f549117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f549118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f549119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f549120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f549121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f549122i;

    public final void a() {
        a r100 = this.f549119f;
        Rect r101 = getBounds();
        int r102 = r101.width();
        int r103 = r101.height();
        if (r100.f549071d == false) goto L5;
        int r104 = r100.f549068a.getWidth();
    L6:
        this.f549115b = r104;
        if (r100.f549071d == false) goto L9;
        int r105 = r100.f549068a.getHeight();
    L10:
        this.f549116c = r105;
        if (r104 <= 0) goto L24;
        if (r105 <= 0) goto L24;
        if (r104 != r102) goto L19;
        if (r105 != r103) goto L19;
        r100.b(r101.left, r101.top, r101.right, r101.bottom);
        this.f549117d = null;
        return;
    L19:
        if (this.f549114a != m.b.f549123a) goto L22;
        r100.b(r101.left, r101.top, r101.right, r101.bottom);
        this.f549117d = null;
        return;
    L22:
        r100.b(0, 0, r104, r105);
        this.f549114a.a(this.f549118e, r101, r104, r105);
        this.f549117d = this.f549118e;
        return;
    L24:
        r100.b(r101.left, r101.top, r101.right, r101.bottom);
        this.f549117d = null;
        return;
    L9:
        r105 = r100.f549070c.getIntrinsicHeight();
        goto L10
    L5:
        r104 = r100.f549070c.getIntrinsicWidth();
        goto L6
    }

    public final void b() {
        a r100 = this.f549119f;
        if (r100 == null) goto L10;
        l r101 = r100.f549069b;
        if (r101 == null) goto L11;
        CloseableReference<CloseableImage> r102 = ((u07.a) r101).f548155a;
        if (r102 == null) goto L12;
        CloseableReference.closeSafely(r102);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        a r100 = this.f549119f;
        if (r100 != null) goto L7;
        return 0;
    L7:
        if (r100.f549071d == false) goto L18;
        Bitmap r101 = r100.f549068a;
        if (r101 != null) goto L11;
    L16:
        return -3;
    L11:
        if (r101.hasAlpha() == true) goto L16;
        if (r100.f549077j.getAlpha() < 255) goto L16;
        return -1;
    L18:
        return r100.f549070c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        a r100 = this.f549119f;
        if (r100 == null) goto L37;
        int r101 = this.f549115b;
        if (r100.f549071d == false) goto L7;
        int r102 = r100.f549068a.getWidth();
    L8:
        if (r101 != r102) goto L16;
        int r103 = this.f549116c;
        a r104 = this.f549119f;
        if (r104.f549071d == false) goto L12;
        int r105 = r104.f549068a.getHeight();
    L13:
        if (r103 != r105) goto L16;
        boolean r106 = false;
    L17:
        if (r106 == false) goto L20;
        a();
    L20:
        if (TextUtils.isEmpty(this.f549121h) == true) goto L26;
        Bitmap r107 = this.f549119f.a();
        if (r107 == null) goto L26;
        k.a(getBounds().width(), getBounds().height(), r107.getWidth(), r107.getHeight(), this.f549114a, this.f549121h, this.f549122i, r110, this.f549119f.a(), this.f549120g);
        return;
    L26:
        if (this.f549117d == null) goto L32;
        int r108 = r110.save();
        r110.clipRect(getBounds());
        r110.concat(this.f549117d);
        a r109 = this.f549119f;
        if (r109.f549071d == false) goto L30;
        r110.drawBitmap(r109.f549068a, r109.f549078k, r109.f549079l, r109.f549077j);
    L31:
        r110.restoreToCount(r108);
        return;
    L30:
        r109.f549070c.draw(r110);
        goto L31
    L32:
        a r111 = this.f549119f;
        if (r111.f549071d == false) goto L35;
        r110.drawBitmap(r111.f549068a, r111.f549078k, r111.f549079l, r111.f549077j);
        return;
    L35:
        r111.f549070c.draw(r110);
        return;
    L12:
        r105 = r104.f549070c.getIntrinsicHeight();
    L16:
        r106 = true;
        goto L17
    L7:
        r102 = r100.f549070c.getIntrinsicWidth();
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        if (this.f549119f == null) goto L6;
        a();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f549120g = r100;
        a r101 = this.f549119f;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f549071d == false) goto L9;
        float r102 = r100;
        if (r101.f549072e == r102) goto L12;
        r101.f549072e = r102;
        r101.f549077j.setAlpha(r100);
        return;
    L12:
        return;
    L9:
        r101.f549070c.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        a r101 = this.f549119f;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f549071d == false) goto L7;
        r101.f549077j.setColorFilter(r100);
        return;
    L7:
        r101.f549070c.setColorFilter(r100);
    }

    public j(a r100, m.b r101) {
        this.f549115b = 0;
        this.f549116c = 0;
        this.f549118e = new Matrix();
        this.f549120g = 255;
        this.f549119f = r100;
        this.f549114a = r101;
    }
}
