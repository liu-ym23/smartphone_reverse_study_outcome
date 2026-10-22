package qcc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;
import androidx.exifinterface.media.ExifInterface;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.linked_emojicon.roundspan.RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ReplacementSpan implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint.FontMetrics f532535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f532536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum f532537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f532538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f532539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f532540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Typeface f532541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f532542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f532543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f532544j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f532545k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f532546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f532547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f532548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f532549o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f532550p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f532551q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f532552r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f532553s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f532554t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f532555u;

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f532538d), Integer.valueOf(this.f532539e), Integer.valueOf(this.f532540f), this.f532541g, Integer.valueOf(this.f532542h), Integer.valueOf(this.f532543i), Integer.valueOf(this.f532544j), Integer.valueOf(this.f532545k), Integer.valueOf(this.f532546l), Integer.valueOf(this.f532547m), Integer.valueOf(this.f532548n), Integer.valueOf(this.f532549o), Integer.valueOf(this.f532550p), Integer.valueOf(this.f532551q), Integer.valueOf(this.f532552r)});
    }

    public final int a(int r100) {
        Paint r101 = new Paint();
        r101.setTypeface(this.f532541g);
        r101.setTextSize(r100);
        Rect r102 = new Rect();
        r101.getTextBounds(ExifInterface.GPS_DIRECTION_TRUE, 0, 1, r102);
        return r102.height();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof occ.a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f532538d == r101.f532538d) goto L11;
    L39:
        return false;
    L11:
        if (this.f532539e != r101.f532539e) goto L39;
        if (this.f532540f != r101.f532540f) goto L39;
        if (this.f532542h != r101.f532542h) goto L39;
        if (this.f532543i != r101.f532543i) goto L39;
        if (this.f532544j != r101.f532544j) goto L39;
        if (this.f532545k != r101.f532545k) goto L39;
        if (this.f532546l != r101.f532546l) goto L39;
        if (this.f532547m != r101.f532547m) goto L39;
        if (this.f532548n != r101.f532548n) goto L39;
        if (this.f532549o != r101.f532549o) goto L39;
        if (this.f532550p != r101.f532550p) goto L39;
        if (this.f532551q != r101.f532551q) goto L39;
        if (this.f532552r != r101.f532552r) goto L39;
        if (Objects.equals(this.f532541g, r101.f532541g) == false) goto L39;
        return true;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        r100.setTypeface(this.f532541g);
        r100.setTextSize(this.f532542h);
        float r105 = r100.measureText(r101, r102, r103);
        int r106 = this.f532544j;
        int r107 = Math.round((r105 + (r106 + r106)) + (this.f532545k + this.f532546l));
        float r108 = this.f532553s;
        if (r108 != 0.0f) goto L5;
        return r107;
    L5:
        if (r107 <= r108) goto L9;
        this.f532555u = true;
        return Math.round(r108);
    L9:
        return r107;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        float r106 = r105.bottom - r105.top;
        Paint.FontMetrics r107 = this.f532535a;
        float r108 = r107.bottom;
        float r109 = r107.top;
        if ((r108 - r109) <= r106) goto L6;
        int r110 = (int) r109;
        int r111 = this.f532551q;
        r105.top = r110 - r111;
        r105.ascent = ((int) r107.ascent) - r111;
        int r112 = (int) r108;
        int r113 = this.f532552r;
        r105.bottom = r112 + r113;
        r105.descent = ((int) r107.descent) + r113;
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r210, int r211, int r212, Paint r213) {
        r213.setTextSize(this.f532542h);
        float r100 = Math.min(r212, (r211 + this.f532543i) - this.f532550p);
        float r101 = Math.max(r210, ((r211 - this.f532543i) - this.f532549o) - this.f532550p);
        int r102 = 0;
        if (r114 == 0.0f) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        float r104 = r114;
    L12:
        if (this.f532555u == false) goto L14;
        float r115 = this.f532553s + this.f532554t;
    L15:
        float r116 = r211 - this.f532550p;
        float r117 = r114 + this.f532544j;
        if (r103 == true) goto L19;
        r102 = this.f532545k;
    L19:
        float r118 = r117 + r102;
    L24:
        e = move-exception;
        Log.w("RoundedBackgroundSpan", "background not found", e);
    L26:
        RectF r105 = new RectF(r104, r101, r115, r100);
        int r106 = this.f532538d;
        if (r106 == 0) goto L29;
        float r107 = r106;
    L31:
        if (this.f532539e == 0) goto L45;
        r110.drawRoundRect(r105, r107, r107, r213);
    L45:
    L38:
        e = move-exception;
        Log.w("RoundedBackgroundSpan", "textColor not found", e);
    L41:
        if (this.f532555u == false) goto L43;
        TextPaint r108 = new TextPaint();
        r108.setTextSize(this.f532542h);
        CharSequence r109 = TextUtils.ellipsize(r111.subSequence(r112, r113).toString(), r108, ((this.f532553s - (this.f532544j * 2)) - this.f532545k) - this.f532546l, TextUtils.TruncateAt.END);
        r110.drawText(r109, 0, r109.length(), r118, r116, r213);
        return;
    L43:
        r110.drawText(r111, r112, r113, r118, r116, r213);
        return;
    L35:
        if (this.f532540f == 0) goto L41;
        r213.setColor(this.f532536b.getResources().getColor(this.f532540f));     // Catch: Resources.NotFoundException -> L38
        goto L41
    L29:
        r107 = Math.min(Math.abs(r100 - r101), Math.abs(r115 - r104)) / 2.0f;
        goto L31
    L21:
        if (this.f532539e == 0) goto L26;
        r213.setColor(this.f532536b.getResources().getColor(this.f532539e));     // Catch: Resources.NotFoundException -> L24
        goto L26
    L14:
        r213.setTypeface(this.f532541g);
        r213.setTextSize(this.f532542h);
        float r119 = r213.measureText(r111, r112, r113) + r104;
        int r120 = this.f532544j;
        r115 = r119 + (r120 + r120);
        goto L15
    L10:
        r104 = r114 + this.f532545k;
        goto L12
    L5:
        if (this.f532537c == RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum.LARGE) goto L7;
        r103 = true;
        goto L8
    }

    public a(Context r100, int r101, int r102, int r103, Typeface r104, int r105, int r106, int r107, int r110, int r111, RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum r112, int r113) {
        int r108 = 0;
        this.f532555u = false;
        this.f532536b = r100;
        this.f532537c = r112;
        this.f532554t = r113;
        this.f532538d = UIUtils.dp2px(r100, r101);
        this.f532539e = r102;
        this.f532540f = r103;
        if (TextUtils.isEmpty("") == true) goto L5;
        this.f532541g = Typeface.createFromAsset(r100.getAssets(), "");
    L7:
        this.f532542h = r105;
        this.f532543i = r100.getResources().getDimensionPixelSize(R.dimen.tag_background_vertical_padding);
        if (r106 != 0) goto L10;
        int r109 = 0;
    L11:
        this.f532544j = r109;
        if (r107 != 0) goto L14;
        int r114 = 0;
    L15:
        this.f532545k = r114;
        if (r110 == 0) goto L19;
        r108 = r100.getResources().getDimensionPixelSize(r110);
    L19:
        this.f532546l = r108;
        this.f532547m = r111;
        int r115 = a(r111);
        this.f532548n = r115;
        int r116 = a(r105);
        this.f532549o = r116;
        int r117 = ((r115 - r116) / 2) + UIUtils.dp2px(r100, 0.5f);
        this.f532550p = r117;
        Paint r118 = new Paint();
        r118.setTextSize(this.f532547m);
        r118.setTypeface(this.f532541g);
        Paint r119 = new Paint();
        r119.setTextSize(this.f532542h);
        r119.setTypeface(this.f532541g);
        this.f532535a = r118.getFontMetrics();
        Paint.FontMetrics r120 = r119.getFontMetrics();
        Paint.FontMetrics r121 = this.f532535a;
        this.f532551q = (8 - ((int) (-(r121.top - r120.top)))) - r117;
        this.f532552r = 8 - (((int) (r121.bottom - r120.bottom)) - r117);
        return;
    L14:
        r114 = r100.getResources().getDimensionPixelSize(r107);
        goto L15
    L10:
        r109 = r100.getResources().getDimensionPixelSize(r106);
        goto L11
    L5:
        if (r104 == null) goto L7;
        this.f532541g = r104;
        goto L7
    }
}
