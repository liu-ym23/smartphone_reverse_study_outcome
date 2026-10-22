package fma;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f477878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f477879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f477880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f477881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f477882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f477883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f477884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f477885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f477886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f477887j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Interpolator f477888k;

    /* JADX INFO: renamed from: fma.a$a, reason: collision with other inner class name */
    public static final class C5929a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.f477878a.getIntrinsicHeight(), this.f477879b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.f477878a.getIntrinsicWidth(), this.f477879b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = this.f477880c;
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L11;
        long r102 = SystemClock.uptimeMillis() - this.f477881d;
        int r103 = this.f477882e;
        if (r102 < r103) goto L9;
        this.f477885h = this.f477884g;
        this.f477880c = 0;
        goto L11
    L9:
        float r104 = ((AccelerateInterpolator) this.f477888k).getInterpolation(r102 / r103);
        int r105 = this.f477883f;
        this.f477885h = r105 + ((int) ((this.f477884g - r105) * r104));
    L11:
        int r106 = this.f477885h;
        if (this.f477880c != 0) goto L20;
        if (r106 != 0) goto L15;
        this.f477878a.setBounds(getBounds());
        this.f477878a.draw(r100);
        return;
    L15:
        if (r106 == 255) goto L17;
        a(r100, r106);
        return;
    L17:
        this.f477879b.setBounds(getBounds());
        this.f477879b.draw(r100);
        return;
    L20:
        a(r100, r106);
        if (this.f477880c != 2) goto L26;
        invalidateSelf();
        return;
    L26:
        return;
    L10:
        this.f477881d = SystemClock.uptimeMillis();
        this.f477880c = 2;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f477878a.setAlpha(r100);
        this.f477879b.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f477878a.setColorFilter(r100);
        this.f477879b.setColorFilter(r100);
    }

    public a(Drawable r100, Drawable r101) {
        Intrinsics.checkNotNullParameter(r100, "startDrawable");
        Intrinsics.checkNotNullParameter(r101, "endDrawable");
        this.f477878a = r100;
        this.f477879b = r101;
        this.f477887j = true;
        this.f477888k = new AccelerateInterpolator();
    }

    public final void a(Canvas r100, int r101) {
        this.f477878a.setBounds(getBounds());
        this.f477879b.setBounds(getBounds());
        if (this.f477887j == false) goto L5;
        this.f477878a.setAlpha(255 - r101);
    L5:
        this.f477878a.draw(r100);
        if (this.f477887j == false) goto L8;
        this.f477878a.setAlpha(255);
    L8:
        if (r101 <= 0) goto L11;
        this.f477879b.setAlpha(r101);
        this.f477879b.draw(r100);
        this.f477879b.setAlpha(255);
        return;
    }
}
