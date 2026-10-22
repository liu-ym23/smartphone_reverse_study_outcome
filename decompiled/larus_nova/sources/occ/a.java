package occ;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ReplacementSpan implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint.FontMetrics f522790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f522791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f522792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f522793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f522794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Typeface f522795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f522796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f522797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f522798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f522799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f522800k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f522801l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f522802m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WeakReference<Drawable> f522803n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WeakReference<Bitmap> f522804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f522805p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f522806q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f522807r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f522808s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f522809t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f522810u;

    public final Bitmap a() {
        WeakReference<Bitmap> r100 = this.f522804o;
        Bitmap r101 = null;
        if (r100 == null) goto L5;
        Bitmap r102 = r100.get();
    L6:
        if (r102 != null) goto L34;
        WeakReference<Drawable> r103 = this.f522803n;
        if (r103 == null) goto L10;
        Drawable r104 = r103.get();
    L11:
        if (r104 == null) goto L32;
    L14:
        if (r104 != null) goto L17;
    L29:
        this.f522804o = new WeakReference(r101);
        return r101;
    L17:
        if ((r104 instanceof BitmapDrawable) == false) goto L22;
        BitmapDrawable r105 = (BitmapDrawable) r104;
        if (r105.getBitmap() == null) goto L22;
        r101 = r105.getBitmap();
    L22:
        if (r104.getIntrinsicWidth() > 0) goto L24;
    L27:
        r101 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    L28:
        Canvas r106 = new Canvas(r101);
        r104.setBounds(0, 0, r106.getWidth(), r106.getHeight());
        r104.draw(r106);
        goto L29
    L24:
        if (r104.getIntrinsicHeight() <= 0) goto L27;
        r101 = Bitmap.createBitmap(r104.getIntrinsicWidth(), r104.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        goto L28
    L32:
        r104 = ResourcesCompat.getDrawable(this.f522791b.getResources(), this.f522805p, null);     // Catch: Resources.NotFoundException -> L31
    L13:
        this.f522803n = new WeakReference(r104);
        goto L14
    L10:
        r104 = null;
        goto L11
    L34:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f522792c), Integer.valueOf(this.f522793d), Integer.valueOf(this.f522794e), this.f522795f, Integer.valueOf(this.f522796g), Integer.valueOf(this.f522797h), Integer.valueOf(this.f522798i), Integer.valueOf(this.f522799j), Integer.valueOf(this.f522800k), Integer.valueOf(this.f522801l), Integer.valueOf(this.f522802m), Integer.valueOf(this.f522806q), Integer.valueOf(this.f522807r), Integer.valueOf(this.f522808s), Integer.valueOf(this.f522809t), Integer.valueOf(this.f522810u)});
    }

    public final int b(int r100) {
        Paint r101 = new Paint();
        r101.setTypeface(this.f522795f);
        r101.setTextSize(r100);
        Rect r102 = new Rect();
        r101.getTextBounds(ExifInterface.GPS_DIRECTION_TRUE, 0, 1, r102);
        return r102.height();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f522792c == r101.f522792c) goto L11;
    L41:
        return false;
    L11:
        if (this.f522793d != r101.f522793d) goto L41;
        if (this.f522794e != r101.f522794e) goto L41;
        if (this.f522796g != r101.f522796g) goto L41;
        if (this.f522797h != r101.f522797h) goto L41;
        if (this.f522798i != r101.f522798i) goto L41;
        if (this.f522799j != r101.f522799j) goto L41;
        if (this.f522800k != r101.f522800k) goto L41;
        if (this.f522801l != r101.f522801l) goto L41;
        if (this.f522802m != r101.f522802m) goto L41;
        if (this.f522806q != r101.f522806q) goto L41;
        if (this.f522807r != r101.f522807r) goto L41;
        if (this.f522808s != r101.f522808s) goto L41;
        if (this.f522809t != r101.f522809t) goto L41;
        if (this.f522810u != r101.f522810u) goto L41;
        if (Objects.equals(this.f522795f, r101.f522795f) == false) goto L41;
        return true;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        r100.setTypeface(this.f522795f);
        r100.setTextSize(this.f522796g);
        if (a() != null) goto L5;
        int r105 = 0;
    L6:
        float r106 = r100.measureText(r101, r102, r103) + r105;
        int r107 = this.f522798i;
        return Math.round((r106 + (r107 + r107)) + (this.f522800k + this.f522801l));
    L5:
        r105 = a().getWidth() + this.f522799j;
        goto L6
    }

    public a(Context r100, int r101, int r102, Typeface r103, int r104, int r105) {
        this.f522791b = r100;
        this.f522792c = r100.getResources().getDimensionPixelSize(R.dimen.rounded_tag_span_corner_radius);
        this.f522793d = r101;
        this.f522794e = r102;
        if (TextUtils.isEmpty("") == true) goto L5;
        this.f522795f = Typeface.createFromAsset(r100.getAssets(), "");
    L7:
        this.f522796g = r104;
        this.f522797h = r100.getResources().getDimensionPixelSize(R.dimen.tag_vertical_padding);
        this.f522798i = r100.getResources().getDimensionPixelSize(R.dimen.tag_horizontal_padding);
        this.f522799j = r100.getResources().getDimensionPixelSize(R.dimen.icon_space_padding);
        this.f522800k = r100.getResources().getDimensionPixelSize(R.dimen.tag_white_padding_start);
        this.f522801l = r100.getResources().getDimensionPixelSize(R.dimen.tag_white_padding_end);
        this.f522802m = r105;
        this.f522805p = R.drawable.bg_at_me_holder;
        int r106 = b(r105);
        this.f522806q = r106;
        int r107 = b(r104);
        this.f522807r = r107;
        int r108 = (r106 - r107) / 2;
        this.f522808s = r108;
        Paint r109 = new Paint();
        r109.setTextSize(this.f522802m);
        r109.setTypeface(this.f522795f);
        Paint r110 = new Paint();
        r110.setTextSize(this.f522796g);
        r110.setTypeface(this.f522795f);
        this.f522790a = r109.getFontMetrics();
        Paint.FontMetrics r111 = r110.getFontMetrics();
        Paint.FontMetrics r112 = this.f522790a;
        this.f522809t = (8 - ((int) (-(r112.top - r111.top)))) - r108;
        this.f522810u = 8 - (((int) (r112.bottom - r111.bottom)) - r108);
        return;
    L5:
        if (r103 == null) goto L7;
        this.f522795f = r103;
        goto L7
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        float r106 = r105.bottom - r105.top;
        Paint.FontMetrics r107 = this.f522790a;
        float r108 = r107.bottom;
        float r109 = r107.top;
        if ((r108 - r109) <= r106) goto L6;
        int r110 = (int) r109;
        int r111 = this.f522809t;
        r105.top = r110 - r111;
        r105.ascent = ((int) r107.ascent) - r111;
        int r112 = (int) r108;
        int r113 = this.f522810u;
        r105.bottom = r112 + r113;
        r105.descent = ((int) r107.descent) + r113;
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r210, float r211, int r212, int r213, int r214, Paint r215) {
        Bitmap r100 = a();
        if (a() == null) goto L5;
        r100.getWidth();
        float r101 = (r213 - (a().getHeight() / 2)) - (this.f522806q / 2);
        float r102 = (r211 + this.f522798i) + this.f522800k;
    L6:
        float r103 = Math.min(r214, (r213 + this.f522797h) - this.f522808s);
        float r104 = ((r213 - this.f522797h) - this.f522807r) - this.f522808s;
        float r105 = r211 + this.f522800k;
        r215.setTypeface(this.f522795f);
        r215.setTextSize(this.f522796g);
        float r113 = r211 + r215.measureText(r111, r112, r210);
        int r114 = this.f522798i;
        float r115 = (r113 + (r114 + r114)) + this.f522801l;
        float r116 = r213 - this.f522808s;
        float r117 = (r211 + r114) + this.f522800k;
        r215.setTextSize(this.f522796g);
        r215.setColor(this.f522793d);
        RectF r118 = new RectF(r105, r104, r115, r103);
        float r106 = Math.min(Math.abs(r103 - r104), Math.abs(r115 - r105)) / 2.0f;
        r110.drawRoundRect(r118, r106, r106, r215);
        if (r100 == null) goto L9;
        r110.drawBitmap(r100, r102, r101, r215);
    L9:
        r215.setColor(this.f522794e);
        r110.drawText(r111, r112, r210, r117, r116, r215);
        return;
    L5:
        r101 = 0.0f;
        r102 = 0.0f;
        goto L6
    }
}
