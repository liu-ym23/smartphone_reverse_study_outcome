package q7b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends ReplacementSpan implements com.ss.android.lark.widget.light.viewstub.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f531998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f531999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f532000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f532001d;

    public static final class a {
    }

    static {
    }

    public b(Drawable r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f531998a = r100;
        this.f531999b = r101;
        this.f532000c = 1;
        this.f532001d = -1;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        int r105 = this.f532001d;
        if (r105 != (-1)) goto L5;
        Drawable r106 = this.f531998a;
        r106.setBounds(0, 0, r106.getIntrinsicWidth(), this.f531998a.getIntrinsicHeight());
        this.f532001d = this.f531998a.getBounds().width();
        if (r104 == null) goto L17;
        Paint.FontMetricsInt r107 = r100.getFontMetricsInt();
        int r108 = r107.descent;
        int r109 = this.f531998a.getBounds().height();
        int r110 = this.f532000c;
        if (r110 != 0) goto L12;
        int r111 = r107.bottom - r109;
        r104.ascent = r107.ascent + r111;
        r104.descent = r107.descent + r111;
    L15:
        r104.top = r104.ascent;
        r104.bottom = r104.descent;
        goto L17
    L12:
        if (r110 != 1) goto L14;
        int r112 = -r109;
        int r113 = r107.descent;
        r104.ascent = r112 + r113;
        r104.top = r112 + r113;
        r104.bottom = r113;
        r104.descent = r113;
        goto L15
    L14:
        int r114 = r107.bottom - r109;
        r104.ascent = r107.ascent + r114;
        r104.descent = r107.descent + r114;
    L17:
        return this.f532001d + this.f531999b;
    L5:
        return r105 + this.f531999b;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        int r109 = this.f532000c;
        if (r109 != 0) goto L5;
        int r110 = r107 - this.f531998a.getBounds().height();
    L9:
        int r111 = r100.save();
        r100.translate(r104 + this.f531999b, r110);     // Catch: Throwable -> L13
        this.f531998a.draw(r100);     // Catch: Throwable -> L13
        r100.restoreToCount(r111);
        return;
    L13:
        th = move-exception;
        r100.restoreToCount(r111);
        throw th;
    L5:
        if (r109 == 1) goto L7;
        r110 = r105 + (((r107 - r105) - this.f531998a.getBounds().height()) / 2);
        goto L9
    L7:
        r110 = (r106 - this.f531998a.getBounds().height()) + ((int) (((double) r108.getFontMetricsInt().descent) / 1.5d));
        goto L9
    }
}
