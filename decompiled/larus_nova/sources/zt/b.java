package zt;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f573553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f573554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f573555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f573556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f573557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f573558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f573559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f573560h;

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        if (r101 == null) goto L8;
        CharSequence r105 = r101.subSequence(r102, r103);
        if (r105 == null) goto L8;
        String r106 = r105.toString();
        if (r106 == null) goto L8;
    L9:
        float r107 = this.f573554b.getTextSize();
        this.f573554b.setTextSize(this.f573558f);
        float r108 = (this.f573554b.measureText(r106, 0, r106.length()) + (this.f573555c * 2)) + (this.f573556d * 2);
        this.f573554b.setTextSize(r107);
        return MathKt.roundToInt(r108);
    L8:
        r106 = "";
        goto L9
    }

    public b(TextPaint r100, int r101, int r102, int r103, float r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "textPaint");
        Intrinsics.checkNotNullParameter(":", "normalText");
        this.f573554b = r100;
        this.f573555c = r101;
        this.f573556d = r102;
        this.f573557e = r103;
        this.f573558f = r104;
        this.f573559g = r105;
        this.f573560h = ":";
        this.f573553a = new Rect();
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r210, int r211, int r212, int r213, Paint r214) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r214, "paint");
        String r100 = this.f573560h;
        this.f573554b.getTextBounds(r100, 0, r100.length(), this.f573553a);
        float r101 = this.f573553a.height();
        String r102 = this.f573560h;
        this.f573554b.getTextBounds(r102, 0, r102.length(), this.f573553a);
        float r103 = this.f573553a.bottom;
        float r104 = this.f573554b.getTextSize();
        this.f573554b.setTextSize(this.f573558f);
        String r105 = "";
        if (r111 == null) goto L8;
        CharSequence r106 = r111.subSequence(r112, r113);
        if (r106 == null) goto L8;
        String r107 = r106.toString();
        if (r107 == null) goto L8;
    L9:
        this.f573554b.getTextBounds(r107, 0, r107.length(), this.f573553a);
        float r108 = this.f573553a.height();
        this.f573554b.getTextBounds(r107, 0, r107.length(), this.f573553a);
        float r114 = this.f573553a.bottom;
        float r115 = (this.f573557e * 2) + r108;
        float r109 = this.f573554b.measureText(r107, 0, r107.length());
        float r116 = (this.f573555c * 2) + r109;
        this.f573554b.setTextSize(r104);
        float r117 = r212 - (((r101 / 2.0f) - (r108 / 2.0f)) - (r103 - r114));
        float r118 = r117 - ((r108 - r114) + this.f573557e);
        float r119 = r210 + this.f573556d;
        RectF r120 = new RectF(r119, r118, r119 + r116, r115 + r118);
        r214.setColor(y0.c(R.color.gamecp_game_FE2C55));
        float r121 = this.f573559g;
        r110.drawRoundRect(r120, r121, r121, r214);
        if (r111 == null) goto L17;
        CharSequence r122 = r111.subSequence(r112, r113);
        if (r122 == null) goto L17;
        String r123 = r122.toString();
        if (r123 == null) goto L17;
        r105 = r123;
    L17:
        r214.setTextSize(this.f573558f);
        r214.setTypeface(Typeface.create(this.f573554b.getTypeface(), 0));
        r214.setColor(y0.c(R.color.gamecp_game_FFFFFF));
        r110.drawText(r105, (r210 + ((r116 / 2.0f) - (r109 / 2.0f))) + this.f573556d, r117, r214);
        return;
    L8:
        r107 = "";
        goto L9
    }
}
