package lk6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class c extends ImageSpan implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f509582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f509583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f509584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f509585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f509586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f509587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f509588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f509589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f509590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f509591j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f509592k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f509593l;

    public c(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super(r100);
        this.f509582a = r100.getBounds().width();
        this.f509583b = r100.getBounds().height();
        this.f509584c = 1;
        Paint r101 = new Paint();
        r101.setColor(this.f509591j);
        r101.setStrokeWidth(this.f509590i);
        r101.setStyle(Paint.Style.STROKE);
        r101.setAntiAlias(true);
        Unit r102 = Unit.INSTANCE;
        this.f509593l = r101;
    }

    public final int b(Paint.FontMetricsInt r100) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        switch(this.f509584c) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        int r101 = (r100.bottom + r100.top) / 2;
        int r102 = this.f509583b / 2;
    L11:
        int r103 = r101 - r102;
    L13:
        return r103 + this.f509585d;
    L5:
        r103 = r100.ascent;
        goto L13
    L6:
        r103 = r100.top;
        goto L13
    L7:
        r103 = r100.descent - this.f509583b;
        goto L13
    L8:
        r103 = -this.f509583b;
        goto L13
    L9:
        r101 = (r100.descent + r100.ascent) / 2;
        r102 = this.f509583b / 2;
        goto L11
    L10:
        r101 = (r100.bottom + r100.top) / 2;
        r102 = this.f509583b / 2;
        goto L11
    }

    public final void c(int r100) {
        if (getDrawable() != null) goto L5;
        return;
    L5:
        if (r100 == DrawableCompat.getAlpha(getDrawable())) goto L9;
        getDrawable().setAlpha(r100);
        return;
    }

    public final void d(int r100) {
        this.f509591j = r100;
        this.f509593l.setColor(r100);
    }

    public final void e(float r100) {
        this.f509590i = r100;
        this.f509593l.setStrokeWidth(r100);
    }

    public final void f(int r100) {
        this.f509592k = r100;
        if (r100 != 0) goto L5;
        return;
    L5:
        if (getDrawable() == null) goto L9;
        DrawableCompat.setTint(getDrawable(), this.f509592k);
        return;
    }

    @Override // lk6.a
    public void setWidthAndHeight(int r100, int r101) {
        this.f509582a = r100;
        this.f509583b = r101;
    }

    public void a(Canvas r100, CharSequence r101, int r102, int r103, Paint r104) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r104, "paint");
        Drawable r105 = getDrawable();
        if (r105 == null) goto L5;
        r105.setBounds(0, 0, r102, r103);
    L5:
        Drawable r106 = getDrawable();
        if (r106 == null) goto L9;
        r106.draw(r100);
        return;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        int r105 = (this.f509582a + this.f509586e) + this.f509587f;
        if (r104 == null) goto L5;
        int r106 = b(r104);
        r104.top = r106;
        r104.ascent = r106;
        int r107 = this.f509583b;
        r104.bottom = r107 + r106;
        r104.descent = r107 + r106;
    L5:
        return r105;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r210, int r211, int r212, Paint r213) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r213, "paint");
        r110.save();
        r110.translate(r114 + this.f509586e, r211 + b(r213.getFontMetricsInt()));
        int r100 = this.f509583b;
        if (r100 <= 0) goto L14;
        int r101 = this.f509582a;
        if (r101 <= 0) goto L14;
        if (this.f509588g == false) goto L11;
        int r102 = Math.min(r100, r101) / 2;
    L10:
        float r115 = r102;
    L16:
        if (this.f509591j != 0) goto L18;
    L20:
        boolean r103 = false;
    L21:
        float r104 = 0;
        if (r115 > r104) goto L26;
        if (r103 == true) goto L26;
        Path r105 = null;
    L27:
        if (r115 <= r104) goto L30;
        if (r105 == null) goto L30;
        r110.clipPath(r105);
    L30:
        a(r110, r111, this.f509582a, this.f509583b, r213);
        if (r103 == false) goto L34;
        if (r105 == null) goto L34;
        r110.drawPath(r105, this.f509593l);
    L34:
        r110.restore();
        return;
    L26:
        r105 = new Path();
        r105.addRoundRect(0.0f, 0.0f, this.f509582a, this.f509583b, r115, r115, Path.Direction.CW);
        goto L27
    L18:
        if (this.f509590i <= 0) goto L20;
        r103 = true;
        goto L21
    L11:
        r102 = this.f509589h;
        if (r102 > 0) goto L10;
    L14:
        r115 = 0.0f;
        goto L16
    }
}
