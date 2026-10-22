package zbc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;
import android.view.animation.LinearInterpolator;
import androidx.exifinterface.media.ExifInterface;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ReplacementSpan implements LineHeightSpan, ybc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f571204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f571205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f571206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f571207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f571208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f571209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f571210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f571211j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f571212k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f571213l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint.FontMetrics f571214m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f571215n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f571216o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f571217p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f571218q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f571219r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f571220s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f571221t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Drawable f571222u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ValueAnimator f571223v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f571224w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ybc.b f571225x;

    /* JADX INFO: renamed from: zbc.a$a, reason: collision with other inner class name */
    public static final class C8439a {
    }

    static {
    }

    @Override // ybc.a
    public final void cancelAnimation() {
        ValueAnimator r100 = this.f571223v;
        if (r100 == null) goto L5;
        r100.removeAllListeners();
    L5:
        ValueAnimator r101 = this.f571223v;
        if (r101 == null) goto L8;
        r101.end();
    L8:
        this.f571223v = null;
        this.f571224w = 0.0f;
    }

    @Override // ybc.a
    public final void a(ybc.b r100) {
        this.f571225x = r100;
    }

    public final int b(Paint r100) {
        int r101 = this.f571218q;
        if (r101 <= 0) goto L5;
        return r101;
    L5:
        r100.setTextSize(this.f571208g);
        int r102 = this.f571202a;
        boolean r103 = true;
        if (36000000 <= r102) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L14;
        String r105 = "00:00:00";
    L21:
        int r106 = (int) r100.measureText(r105);
        this.f571218q = r106;
        return r106;
    L14:
        if (3600000 > r102) goto L17;
        if (r102 >= 36000000) goto L17;
    L18:
        if (r103 == false) goto L20;
        r105 = "0:00:00";
        goto L21
    L20:
        r105 = "00:00";
    L17:
        r103 = false;
        goto L18
    L8:
        if (r102 > Integer.MAX_VALUE) goto L10;
        r104 = true;
        goto L11
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        if (this.f571206e == false) goto L5;
        int r105 = b(r100);
        return (((((this.f571212k + this.f571213l) + this.f571210i) + this.f571211j) + this.f571207f) + this.f571209h) + r105;
    L5:
        int r106 = ((this.f571212k + this.f571213l) + this.f571210i) + this.f571211j;
        return this.f571207f + r106;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        Intrinsics.checkNotNullParameter(r105, "fm");
        if (this.f571215n <= (r105.bottom - r105.top)) goto L19;
        Paint.FontMetrics r106 = this.f571214m;
        Paint.FontMetrics r107 = null;
        if (r106 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("originalFontMetrics");
        r106 = null;
    L7:
        r105.top = (int) r106.top;
        Paint.FontMetrics r108 = this.f571214m;
        if (r108 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("originalFontMetrics");
        r108 = null;
    L10:
        r105.ascent = (int) r108.ascent;
        Paint.FontMetrics r109 = this.f571214m;
        if (r109 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("originalFontMetrics");
        r109 = null;
    L13:
        r105.bottom = (int) r109.bottom;
        Paint.FontMetrics r110 = this.f571214m;
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
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r210, int r211, int r212, Paint r213) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r213, "paint");
        ValueAnimator r100 = this.f571223v;
        if (r100 != null) goto L5;
    L10:
        float r101 = r114 + this.f571212k;
        float r102 = (r211 - this.f571217p) - (this.f571216o / 2.0f);
        int r103 = this.f571219r;
        int r104 = r212 - r210;
        if (r103 <= r104) goto L13;
        r103 = r104;
    L13:
        float r105 = r103;
        float r106 = r105 / 2.0f;
        float r107 = r102 - r106;
        float r108 = r102 + r106;
        float r109 = r210;
        if (r107 >= r109) goto L16;
        float r115 = r109 - r107;
    L20:
        float r116 = (r102 + r115) - r106;
        if (this.f571206e == false) goto L23;
        float r117 = (((this.f571210i + r101) + this.f571207f) + this.f571209h) + b(r213);
        int r118 = this.f571211j;
    L24:
        r213.setColor(this.f571204c);
        r110.drawRoundRect(r101, r116, r117 + r118, r105 + r116, r106, r106, r213);
        float r119 = ((r114 + this.f571212k) + this.f571210i) + this.f571221t;
        float r120 = (r211 - this.f571217p) - (this.f571216o / 2.0f);
        float r121 = this.f571220s;
        float r122 = r120 - (r121 / 2.0f);
        float r123 = r119 + r121;
        float r124 = r121 + r122;
        Drawable r125 = this.f571222u;
        if (r125 == null) goto L31;
        r125.setBounds((int) r119, (int) r122, (int) r123, (int) r124);
        if (this.f571203b == false) goto L29;
        r110.save();
        float r126 = this.f571224w;
        float r127 = this.f571220s / 2.0f;
        r110.rotate(r126, r119 + r127, r122 + r127);
        r125.draw(r110);
        r110.restore();
        goto L31
    L29:
        r125.draw(r110);
    L31:
        if (this.f571206e == false) goto L36;
        if (r111 == null) goto L37;
        float r128 = r211 - (this.f571217p * 1.0f);
        float r129 = (((this.f571212k + r114) + this.f571210i) + this.f571207f) + this.f571209h;
        r213.setTextSize(this.f571208g);
        r213.setColor(this.f571205d);
        r110.drawText(r111, r112, r113, r129, r128, r213);
        return;
    L37:
        return;
    L36:
        return;
    L23:
        r117 = (this.f571210i + r101) + this.f571211j;
        r118 = this.f571207f;
        goto L24
    L16:
        float r130 = r212;
        if (r108 <= r130) goto L19;
        r115 = r130 - r108;
        goto L20
    L19:
        r115 = 0.0f;
        goto L20
    L5:
        if ((!r100.isRunning()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.start();
        goto L10
    }

    public a(Context r110, int r111, boolean r112, int r113, int r114, boolean r115, int r116, int r117, int r118, int r119, int r210, int r211, int r212, int r213, int r214, int r215, int r216) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f571202a = r111;
        this.f571203b = r112;
        this.f571204c = r113;
        this.f571205d = r114;
        this.f571206e = r115;
        this.f571207f = r118;
        this.f571208g = r210;
        this.f571209h = r211;
        this.f571210i = r213;
        this.f571211j = r214;
        this.f571212k = r215;
        this.f571213l = r216;
        float r100 = r118;
        float r101 = 0.7f * r100;
        this.f571220s = r101;
        this.f571221t = (r100 - r101) / 2.0f;
        Paint r102 = new Paint();
        float r103 = r119;
        r102.setTextSize(r103);
        Paint.FontMetrics r104 = r102.getFontMetrics();
        this.f571214m = r104;
        Paint.FontMetrics r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("originalFontMetrics");
        r104 = null;
    L5:
        float r106 = r104.bottom;
        Paint.FontMetrics r107 = this.f571214m;
        if (r107 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("originalFontMetrics");
    L9:
        this.f571215n = (int) (r106 - r105.top);
        Paint r108 = new Paint();
        r108.setTextSize(r103);
        Rect r109 = new Rect();
        r108.getTextBounds(ExifInterface.GPS_DIRECTION_TRUE, 0, 1, r109);
        int r120 = r109.height();
        Paint r121 = new Paint();
        r121.setTextSize(r210);
        Rect r122 = new Rect();
        r121.getTextBounds(ExifInterface.GPS_DIRECTION_TRUE, 0, 1, r122);
        int r123 = r122.height();
        this.f571216o = r123;
        this.f571217p = (r120 - r123) / 2;
        this.f571219r = Math.min(r212, this.f571215n);
        this.f571222u = UDIconUtils.getIconDrawable(r110, r116, r117);
        if (r112 == false) goto L13;
        ValueAnimator r124 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        r124.setDuration(1000);
        r124.setRepeatMode(1);
        r124.setRepeatCount(-1);
        r124.setInterpolator(new LinearInterpolator());
        r124.addUpdateListener(new b(this));
        this.f571223v = r124;
        return;
    L13:
        return;
    L8:
        r105 = r107;
        goto L9
    }
}
