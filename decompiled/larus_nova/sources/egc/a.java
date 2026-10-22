package egc;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f472620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f472621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f472622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f472623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f472624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f472625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f472626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BitmapShader f472627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f472628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Matrix f472629j;

    public abstract Bitmap a();

    public a() {
        this.f472622c = 0;
        this.f472623d = 1.0f;
        this.f472624e = false;
        this.f472629j = new Matrix();
        Paint r100 = new Paint();
        this.f472625f = r100;
        r100.setStyle(Paint.Style.STROKE);
        r100.setAntiAlias(true);
        Paint r101 = new Paint();
        this.f472626g = r101;
        r101.setAntiAlias(true);
    }

    public final void b(Drawable r100) {
        this.f472628i = r100;
        this.f472627h = null;
        this.f472626g.setShader(null);
    }
}
