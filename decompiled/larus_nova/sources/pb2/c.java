package pb2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.NinePatchDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends pb2.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Paint f528418s = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f528419n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final NinePatchDrawable f528420o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f528421p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f528422q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f528423r;

    public static final class a {
    }

    @Override // lk6.c, lk6.a
    public final void setWidthAndHeight(int r100, int r101) {
    }

    static {
        Paint r100 = new Paint();
        r100.setTextAlign(Paint.Align.LEFT);
        r100.setAntiAlias(true);
        r100.setStyle(Paint.Style.FILL_AND_STROKE);
        r100.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        f528418s = r100;
    }

    public c(NinePatchDrawable r100, String r101, int r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Intrinsics.checkNotNullParameter(r101, "content");
        super(r100);
        this.f528420o = r100;
        this.f528421p = r101;
        this.f528422q = r102;
        this.f528423r = r103;
        Rect r104 = new Rect();
        this.f528419n = r104;
        r100.getPadding(r104);
        Rect r105 = new Rect();
        Paint r106 = f528418s;
        r106.setTextSize(r103);
        r106.getTextBounds(r101, 0, r101.length(), r105);
        r100.getBounds().right += Math.max(0, r105.width() - ((r100.getBounds().width() - r104.left) - r104.right));
        int r107 = r100.getBounds().width();
        int r108 = r100.getBounds().height();
        this.f509582a = r107;
        this.f509583b = r108;
    }

    @Override // lk6.c
    public final void a(Canvas r100, CharSequence r101, int r102, int r103, Paint r104) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r104, "paint");
        super.a(r100, r101, r102, r103, r104);
        Paint r105 = f528418s;
        r105.setTextSize(this.f528423r);
        r105.setColor(this.f528422q);
        r100.drawText(this.f528421p, this.f528419n.left, ((this.f528420o.getIntrinsicHeight() / 2) + ((r105.getFontMetrics().descent - r105.getFontMetrics().ascent) / 2)) - r105.getFontMetrics().descent, r105);
    }

    @Override // pb2.a, lk6.c, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return super.getSize(r100, r101, r102, r103, r104);
    }
}
