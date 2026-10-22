package io.noties.markwon.ext.onetex;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.bytedance.crash.dumper.Scraps;
import com.edu.onetex.latex.graphic.Graphics2D;
import com.edu.onetex.latex.icon.LaTeXIcon;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public final class g extends Drawable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ImageCache f492429l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f492430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f492431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Graphics2D f492432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f492433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f492434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f492435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f492436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f492437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f492438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LaTeXIcon f492439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f492440k;

    public static final class a {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    static {
        f492429l = new ImageCache();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f492434e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f492433d;
    }

    public final void a(Canvas r110) {
        Rect r100 = getBounds();
        int r101 = r110.save();
        Drawable r102 = this.f492437h;     // Catch: Throwable -> L42
        if (r102 == null) goto L6;
        r102.draw(r110);     // Catch: Throwable -> L42
    L6:
        int r103 = r100.width();     // Catch: Throwable -> L42
        int r104 = r100.height();     // Catch: Throwable -> L42
        float r105 = this.f492436g;     // Catch: Throwable -> L42
        if (r105 <= 0.0f) goto L11;
        float r106 = r103;
        if (r106 <= r105) goto L11;
        r104 = (int) ((r104 * r105) / r106);     // Catch: Throwable -> L42
        r103 = (int) r105;     // Catch: Throwable -> L42
    L11:
        int r107 = this.f492433d;     // Catch: Throwable -> L42
        if (r107 <= 0) goto L18;
        int r108 = this.f492434e;     // Catch: Throwable -> L42
        if (r108 <= 0) goto L18;
        if (r107 > r103) goto L17;
        if (r108 <= r104) goto L18;
    L17:
        float r109 = RangesKt.coerceAtMost(r103 / r107, r104 / r108);     // Catch: Throwable -> L42
    L19:
        int r111 = (int) ((this.f492433d * r109) + 0.5f);     // Catch: Throwable -> L42
        int r112 = (r104 - ((int) ((this.f492434e * r109) + 0.5f))) / 2;     // Catch: Throwable -> L42
        int r113 = this.f492438i;     // Catch: Throwable -> L42
        if (r113 != 17) goto L22;
        int r114 = (r103 - r111) / 2;     // Catch: Throwable -> L42
    L26:
        if (r112 != 0) goto L28;
        if (r114 != 0) goto L28;
    L30:
        if (Float.compare(r109, 1.0f) == 0) goto L32;
        r110.scale(r109, r109);     // Catch: Throwable -> L42
    L32:
        this.f492432c.setCanvas(r110);     // Catch: Throwable -> L42
        if (this.f492440k == false) goto L51;
        LaTeXIcon r115 = this.f492439j;     // Catch: Throwable -> L42
        r115.setForeground(r115.getLatexParam().getForegroundColor());     // Catch: Throwable -> L42
    L40:
        this.f492439j.paintIcon(this.f492432c, 0, 0);     // Catch: Throwable -> L42
        LaTexHelper.f492379d.c(this.f492439j.getLatexParam().getContent());     // Catch: Throwable -> L42
    L44:
        r110.restoreToCount(r101);
        return;
    L51:
        int r116 = this.f492439j.getLatexParam().getForegroundColor();     // Catch: Exception -> L38 Throwable -> L42
        this.f492439j.setForeground((r116 & 255) | (((RangesKt.coerceIn((int) ((((r116 >>> 24) / 255.0f) * (this.f492435f / 255.0f)) * 255), 0, 255) << 24) | (((r116 >> 16) & 255) << 16)) | (((r116 >> 8) & 255) << 8)));     // Catch: Exception -> L38 Throwable -> L42
    L38:
        e = move-exception;
        LaTeXIcon r117 = this.f492439j;     // Catch: Throwable -> L42
        r117.setForeground(r117.getLatexParam().getForegroundColor());     // Catch: Throwable -> L42
        e.printStackTrace();     // Catch: Throwable -> L42
    L28:
        r110.translate(r114, r112);     // Catch: Throwable -> L42
        goto L30
    L22:
        if (r113 == 8388613) goto L24;
        r114 = 0;
        goto L26
    L24:
        r114 = r103 - r111;     // Catch: Throwable -> L42
    L18:
        r109 = 1.0f;
    L42:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        r110.restoreToCount(r101);
        throw th;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        if (this.f492440k == true) goto L7;
        a(r100);
        return;
    L7:
        if (getBounds().width() > 0) goto L9;
        return;
    L9:
        if (getBounds().height() <= 0) goto L20;
        ImageCache r101 = f492429l;
        Bitmap r102 = r101.get(this.f492430a);
        if (r102 != null) goto L14;
    L17:
        SystemClock.elapsedRealtime();
        Bitmap r103 = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
        a(new Canvas(r103));
        Paint r104 = this.f492431b;
        r104.setAlpha(this.f492435f);
        r100.drawBitmap(r103, 0.0f, 0.0f, r104);
        r101.put(this.f492430a, r103);
        return;
    L14:
        if (r102.isRecycled() == true) goto L17;
        Paint r105 = this.f492431b;
        r105.setAlpha(this.f492435f);
        r100.drawBitmap(r102, 0.0f, 0.0f, r105);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        Drawable r101 = this.f492437h;
        if (r101 == null) goto L6;
        r101.setBounds(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f492435f = r100;
    }

    public g(Context r100, int r101, int r102, LaTeXIcon r103, int r104, boolean r105, int r106) {
        this.f492437h = null;
        this.f492438i = r102;
        this.f492439j = r103;
        this.f492440k = r105;
        this.f492430a = "$ texKey——>content:" + r103.getLatexParam().getContent() + "-color:" + r103.getLatexParam().getForegroundColor() + "-texSize:" + r103.getLatexParam().getTextSizeSize().f573488b + Scraps.INNER_UNIT + r103.getLatexParam().getTextSizeSize().f573489c + "-texIndex:" + r101 + " $";
        Paint r107 = new Paint();
        r107.setAntiAlias(true);
        this.f492431b = r107;
        this.f492432c = new Graphics2D(r100, null, 2, null);
        this.f492435f = 255;
        this.f492433d = r103.getWidth();
        this.f492434e = r103.getHeight();
        int r108 = r103.getWidth();
        if (1 > r104) goto L7;
        if (r108 <= r104) goto L7;
        float r109 = r104 / r103.getWidth();
        Pair r110 = TuplesKt.to(Float.valueOf(r103.getWidth() * r109), Float.valueOf(r103.getHeight() * r109));
    L8:
        setBounds(0, 0, (int) ((Number) r110.component1()).floatValue(), (int) ((Number) r110.component2()).floatValue());
        if (r105 == false) goto L15;
        if (r106 <= 0) goto L16;
        ImageCache r111 = f492429l;
        if (r111.maxSize() == r106) goto L17;
        r111.resize(r106);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r110 = TuplesKt.to(Float.valueOf(r103.getWidth()), Float.valueOf(r103.getHeight()));
        goto L8
    }
}
