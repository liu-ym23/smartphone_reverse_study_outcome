package pcc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;
import androidx.exifinterface.media.ExifInterface;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ReplacementSpan implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f528628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f528629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f528630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f528631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f528632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint.FontMetrics f528633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f528634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f528635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Typeface f528636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f528637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f528638k;

    /* JADX INFO: renamed from: pcc.a$a, reason: collision with other inner class name */
    public static final class C7183a {
    }

    static {
    }

    public final int a(int r100) {
        Paint r101 = new Paint();
        r101.setTypeface(this.f528636i);
        r101.setTextSize(r100);
        Rect r102 = new Rect();
        r101.getTextBounds(ExifInterface.GPS_DIRECTION_TRUE, 0, 1, r102);
        return r102.height();
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return (this.f528635h + this.f528631d) + this.f528632e;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        Intrinsics.checkNotNullParameter(r105, "fm");
        if (this.f528634g <= (r105.bottom - r105.top)) goto L19;
        Paint.FontMetrics r106 = this.f528633f;
        Paint.FontMetrics r107 = null;
        if (r106 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("originalFontMetrics");
        r106 = null;
    L7:
        r105.top = (int) r106.top;
        Paint.FontMetrics r108 = this.f528633f;
        if (r108 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("originalFontMetrics");
        r108 = null;
    L10:
        r105.ascent = (int) r108.ascent;
        Paint.FontMetrics r109 = this.f528633f;
        if (r109 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("originalFontMetrics");
        r109 = null;
    L13:
        r105.bottom = (int) r109.bottom;
        Paint.FontMetrics r110 = this.f528633f;
        if (r110 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("originalFontMetrics");
    L17:
        r105.descent = (int) r107.descent;
        return;
    L16:
        r107 = r110;
        goto L17
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r210, int r211, Paint r212) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "text");
        Intrinsics.checkNotNullParameter(r212, "paint");
        float r100 = r114 + this.f528631d;
        float r101 = 2;
        float r102 = (this.f528635h * 1.0f) / r101;
        float r103 = r211;
        float r116 = r115;
        float r104 = ((r103 * 1.0f) - r116) / r101;
        if (r102 <= r104) goto L5;
        r102 = r104;
    L5:
        float r105 = (r210 - this.f528638k) - ((this.f528637j * 1.0f) / r101);
        float r106 = r105 - r102;
        float r117 = r105 + r102;
        if (r106 >= r116) goto L9;
        float r118 = r116 - r106;
    L12:
        r212.setColor(this.f528628a);
        r110.drawCircle(r100 + r102, r105 + r118, r102, r212);
        r212.setTypeface(this.f528636i);
        r212.setTextSize(this.f528630c);
        float r107 = r100 + (((r102 * r101) - r212.measureText(r111, r112, r113)) / r101);
        float r108 = (r210 - this.f528638k) + r118;
        r212.setColor(this.f528629b);
        r110.drawText(r111, r112, r113, r107, r108, r212);
        return;
    L9:
        if (r117 <= r103) goto L11;
        r118 = r103 - r117;
        goto L12
    L11:
        r118 = 0.0f;
        goto L12
    }

    public a(Context r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, String r110, Typeface r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f528628a = r101;
        this.f528629b = r102;
        this.f528630c = r104;
        this.f528631d = r106;
        this.f528632e = r107;
        Paint r108 = new Paint();
        r108.setTextSize(r105);
        r108.setTypeface(this.f528636i);
        Paint.FontMetrics r109 = r108.getFontMetrics();
        this.f528633f = r109;
        Paint.FontMetrics r112 = null;
        if (r109 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("originalFontMetrics");
        r109 = null;
    L5:
        float r113 = r109.bottom;
        Paint.FontMetrics r114 = this.f528633f;
        if (r114 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("originalFontMetrics");
    L9:
        this.f528634g = (int) (r113 - r112.top);
        if (r110 != null) goto L12;
    L15:
        boolean r115 = true;
    L16:
        if (r115 == false) goto L18;
        this.f528636i = r111;
    L19:
        this.f528635h = Math.min(r103, this.f528634g);
        int r116 = a(r105);
        int r117 = a(r104);
        this.f528637j = r117;
        this.f528638k = ((r116 - r117) / 2) + UIUtils.dp2px(r100, r117 * 0.01f);
        return;
    L18:
        Typeface.createFromAsset(r100.getAssets(), r110);
        goto L19
    L12:
        if (r110.length() == 0) goto L15;
        r115 = false;
        goto L16
    L8:
        r112 = r114;
        goto L9
    }
}
