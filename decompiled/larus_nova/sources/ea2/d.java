package ea2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.jvm.internal.Intrinsics;
import wb2.j;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Paint f471565d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f471567c;

    public static final class a {
    }

    static {
        f471565d = new Paint();
    }

    public d(String r100, int r101, Drawable r102) {
        Intrinsics.checkNotNullParameter(r100, RXScreenCaptureService.KEY_CONTENT_TEXT);
        Intrinsics.checkNotNullParameter(r102, "drawable");
        super(r102);
        this.f471566b = r100;
        this.f471567c = r101;
        Paint r103 = f471565d;
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
        Paint r111 = f471565d;
        r111.setTextSize(s1.f(8.0f));
        r111.setColor(this.f471567c);
        float r112 = r111.measureText(this.f471566b);
        float r113 = r108;
        if (r112 <= r113) goto L5;
        r112 = r113;
    L5:
        float r114 = r104 + ((r113 - r112) * 0.5f);
        r100.drawText(this.f471566b, r114, ((((((r110.getFontMetricsInt().descent + r106) + r106) + r110.getFontMetricsInt().ascent) / 2) - (r109 / 2)) + (((r109 - r111.getFontMetricsInt().descent) + r111.getFontMetricsInt().ascent) * 0.5f)) - r111.getFontMetricsInt().ascent, r111);
    }
}
