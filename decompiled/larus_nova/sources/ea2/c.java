package ea2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.jvm.internal.Intrinsics;
import wb2.j;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Paint f471562d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f471564c;

    public static final class a {
    }

    static {
        f471562d = new Paint();
    }

    public c(String r100, int r101, Drawable r102) {
        Intrinsics.checkNotNullParameter(r100, RXScreenCaptureService.KEY_CONTENT_TEXT);
        Intrinsics.checkNotNullParameter(r102, "drawable");
        super(r102);
        this.f471563b = r100;
        this.f471564c = r101;
        Paint r103 = f471562d;
        r103.setStyle(Paint.Style.FILL_AND_STROKE);
        r103.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
    }

    @Override // com.bytedance.android.livesdk.widget.a, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r110) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r110, "paint");
        super.draw(r100, r101, r102, r103, r104, r105, r106, r107, r110);
        int r108 = getDrawable().getBounds().width();
        int r109 = getDrawable().getBounds().height();
        Paint r111 = f471562d;
        float r112 = r109;
        r111.setTextSize(0.47f * r112);
        r111.setColor(this.f471564c);
        float r113 = r111.measureText(this.f471563b);
        float r114 = r108 - r109;
        if (r113 <= r114) goto L5;
        r113 = r114;
    L5:
        float r115 = (r104 + r112) + ((r114 - r113) * 0.4f);
        r100.drawText(this.f471563b, r115, ((((((r110.getFontMetricsInt().descent + r106) + r106) + r110.getFontMetricsInt().ascent) / 2) - (r109 / 2)) + (((r109 - r111.getFontMetricsInt().descent) + r111.getFontMetricsInt().ascent) * 0.65f)) - r111.getFontMetricsInt().ascent, r111);
    }
}
