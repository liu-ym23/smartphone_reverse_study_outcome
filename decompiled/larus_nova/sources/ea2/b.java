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
public final class b extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Paint f471558e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f471560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f471561d;

    public static final class a {
    }

    static {
        f471558e = new Paint();
    }

    public b(String r100, int r101, boolean r102, Drawable r103) {
        Intrinsics.checkNotNullParameter(r100, RXScreenCaptureService.KEY_CONTENT_TEXT);
        Intrinsics.checkNotNullParameter(r103, "drawable");
        super(r103);
        this.f471559b = r100;
        this.f471560c = r101;
        this.f471561d = r102;
        Paint r104 = f471558e;
        r104.setStyle(Paint.Style.FILL_AND_STROKE);
        r104.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
    }

    @Override // com.bytedance.android.livesdk.widget.a, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r110, Paint r111) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        super.draw(r100, r101, r102, r103, r104, r105, r106, r110, r111);
        int r107 = getDrawable().getBounds().width();
        int r108 = getDrawable().getBounds().height();
        Paint r109 = f471558e;
        float r112 = r108;
        if (this.f471561d == false) goto L5;
        float r113 = 0.54f;
    L6:
        r109.setTextSize(r113 * r112);
        r109.setColor(this.f471560c);
        float r114 = r109.measureText(this.f471559b);
        if (this.f471561d == false) goto L9;
        int r115 = (int) s1.e(30.0f);
    L10:
        float r116 = r115;
        if (r114 <= r116) goto L14;
        r114 = r116;
    L14:
        if (this.f471561d == false) goto L16;
        float r117 = (((r106 + r111.getFontMetricsInt().ascent) + ((r108 - (r109.getFontMetricsInt().descent - r109.getFontMetricsInt().ascent)) * 0.5f)) - r109.getFontMetricsInt().ascent) - 0.5f;
        float r118 = (r104 + s1.e(17.0f)) + ((r116 - r114) * 0.5f);
    L20:
        r100.drawText(this.f471559b, r118, r117, r109);
        return;
    L16:
        float r119 = ((((((r111.getFontMetricsInt().descent + r106) + r106) + r111.getFontMetricsInt().ascent) / 2) - (r108 / 2)) + (((r108 - r109.getFontMetricsInt().descent) + r109.getFontMetricsInt().ascent) * 0.5f)) - r109.getFontMetricsInt().ascent;
        r118 = (r104 + r112) + ((r116 - r114) * 0.5f);
        float r120 = r118 - r112;
        float r121 = 4;
        if (r120 < r121) goto L19;
        r118 = r118 - r121;
    L19:
        r117 = r119;
        goto L20
    L9:
        r115 = r107 - r108;
        goto L10
    L5:
        r113 = 0.57f;
        goto L6
    }
}
