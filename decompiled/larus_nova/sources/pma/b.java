package pma;

import android.animation.ValueAnimator;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float[] f529871q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f529872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PorterDuffXfermode f529873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f529874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f529875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f529876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f529877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f529878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f529879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f529880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f529881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearGradient f529882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearGradient f529883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f529884m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f529885n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f529886o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ValueAnimator f529887p;

    public static final class a {
    }

    static {
        f529871q = new float[]{0.0f, 1.0f};
    }

    public b() {
        this.f529872a = new Paint(1);
        this.f529873b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f529874c = new Matrix();
        this.f529875d = new Matrix();
        this.f529884m = -1.0f;
        this.f529885n = -1;
        this.f529886o = -1;
    }
}
