package wb2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.NinePatchDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Paint f558924g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f558925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NinePatchDrawable f558926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f558927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f558928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f558929f;

    public static final class a {
    }

    static {
        Paint r100 = new Paint();
        r100.setTextAlign(Paint.Align.LEFT);
        r100.setAntiAlias(true);
        r100.setStyle(Paint.Style.FILL_AND_STROKE);
        r100.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        f558924g = r100;
    }

    public f(NinePatchDrawable r100, String r101, int r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Intrinsics.checkNotNullParameter(r101, "content");
        super(r100);
        this.f558926c = r100;
        this.f558927d = r101;
        this.f558928e = r102;
        this.f558929f = r103;
        Rect r104 = new Rect();
        this.f558925b = r104;
        r100.getPadding(r104);
        Rect r105 = new Rect();
        Paint r106 = f558924g;
        r106.setTextSize(r103);
        r106.getTextBounds(r101, 0, r101.length(), r105);
        r100.getBounds().right += Math.max(0, r105.width() - ((r100.getBounds().width() - r104.left) - r104.right));
    }

    @Override // com.bytedance.android.livesdk.widget.a, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r110) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r110, "paint");
        super.draw(r100, r101, r102, r103, r104, r105, r106, r107, r110);
        r100.save();
        r100.translate(r104, b(r110, r106));
        Paint r108 = f558924g;
        r108.setTextSize(this.f558929f);
        r108.setColor(this.f558928e);
        r100.drawText(this.f558927d, this.f558925b.left, ((this.f558926c.getIntrinsicHeight() / 2) + ((r108.getFontMetrics().descent - r108.getFontMetrics().ascent) / 2)) - r108.getFontMetrics().descent, r108);
        r100.restore();
    }
}
