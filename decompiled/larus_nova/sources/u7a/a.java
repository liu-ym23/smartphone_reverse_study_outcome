package u7a;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f549068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f549069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f549070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f549071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f549072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f549073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f549074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f549075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f549076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f549077j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f549078k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Rect f549079l;

    public final Bitmap a() {
        if (this.f549071d == true) goto L5;
        Drawable r100 = this.f549070c;
        if ((r100 instanceof BitmapDrawable) == true) goto L9;
        return null;
    L9:
        return ((BitmapDrawable) r100).getBitmap();
    L5:
        return this.f549068a;
    }

    public a(u07.a r100) {
        this.f549072e = 1.0f;
        this.f549069b = r100;
        Bitmap r101 = r100.f548156b;
        if (r101 == null) goto L5;
        this.f549068a = r101;
        this.f549071d = true;
        Paint r102 = new Paint();
        this.f549077j = r102;
        r102.setAntiAlias(true);
        this.f549078k = new Rect(0, 0, r101.getWidth(), r101.getHeight());
        return;
    L5:
        Drawable r103 = r100.f548157c;
        if (r103 == null) goto L10;
        this.f549070c = r103;
        return;
    }

    public a(Drawable r100) {
        this.f549072e = 1.0f;
        this.f549070c = r100;
    }

    public final void b(int r100, int r101, int r102, int r103) {
        if (this.f549071d == true) goto L5;
        this.f549070c.setBounds(r100, r101, r102, r103);
        return;
    L5:
        if (this.f549079l != null) goto L8;
        this.f549079l = new Rect();
    L8:
        if (this.f549073f == r100) goto L10;
    L15:
        this.f549079l.set(r100, r101, r102, r103);
    L16:
        this.f549073f = r100;
        this.f549074g = r101;
        this.f549076i = r102;
        this.f549075h = r103;
        return;
    L10:
        if (this.f549076i != r102) goto L15;
        if (this.f549074g != r101) goto L15;
        if (this.f549075h == r103) goto L16;
        goto L15
    }
}
