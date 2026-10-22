package z6a;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.LineHeightSpan;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements LineHeightSpan.WithDensity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f570564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f570565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f570566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f570567d;

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
    }

    public final int hashCode() {
        return this.f570564a + 31;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof f) == true) goto L5;
        return false;
    L5:
        if (this.f570564a != ((f) r100).f570564a) goto L9;
        return true;
    L9:
        return false;
    }

    public f(float r100, boolean r101, int r102, boolean r103) {
        if (r100 != 1.0E21f) goto L5;
        this.f570564a = 0;
    L6:
        this.f570565b = r101;
        this.f570566c = r102;
        this.f570567d = r103;
        return;
    L5:
        this.f570564a = (int) Math.ceil(r100);
        goto L6
    }

    @Override // android.text.style.LineHeightSpan.WithDensity
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105, TextPaint r106) {
        int r107 = 0;
        if (this.f570565b == true) goto L5;
        int r108 = this.f570564a;
        if (r108 == 0) goto L69;
        int r109 = r105.descent;
        if (r109 <= r108) goto L50;
        int r110 = Math.min(r108, r109);
        r105.descent = r110;
        r105.bottom = r110;
        r105.ascent = 0;
        r105.top = 0;
        return;
    L50:
        int r111 = r105.ascent;
        if (((-r111) + r109) <= r108) goto L53;
        r105.bottom = r109;
        int r112 = (-r108) + r109;
        r105.ascent = r112;
        r105.top = r112;
        return;
    L53:
        int r113 = r105.bottom;
        if (((-r111) + r113) <= r108) goto L56;
        r105.top = r111;
        r105.bottom = r111 + r108;
        return;
    L56:
        int r114 = r105.top;
        if (((-r114) + r113) <= r108) goto L59;
        r105.top = r113 - r108;
        return;
    L59:
        int r115 = Math.round((r108 - ((-r114) + r113)) / 2.0f);
        int r116 = Math.round((this.f570564a - (r105.descent - r105.ascent)) / 2.0f);
        r105.top -= r115;
        r105.bottom += r115;
        r105.ascent -= r116;
        r105.descent += r116;
        return;
    L69:
        return;
    L5:
        if (this.f570566c != 0) goto L7;
    L14:
        Rect r117 = null;
    L15:
        int r118 = this.f570564a;
        if (r118 == 0) goto L33;
        if (r117 != null) goto L33;
        com.lynx.tasm.behavior.shadow.text.b.a(r118, r105, false);
        a[] r119 = (a[]) ((SpannableStringBuilder) r100).getSpans(r101, r102, a.class);
        int r120 = r119.length;
    L19:
        if (r107 >= r120) goto L74;
        a r121 = r119[r107];
        r121.getClass();
        int r122 = r105.ascent;
        int r123 = r121.f570554c;
        if (r122 <= r123) goto L24;
        r105.ascent = r123;
    L24:
        if (r105.top <= r123) goto L26;
        r105.top = r123;
    L26:
        int r124 = r123 + r121.a();
        if (r105.descent >= r124) goto L30;
        r105.descent = r124;
    L30:
        if (r105.bottom >= r124) goto L32;
        r105.bottom = r124;
    L32:
        r107 = r107 + 1;
        goto L19
    L74:
        return;
    L33:
        if (r117 == null) goto L64;
        if (r118 != 0) goto L36;
        r118 = r105.bottom - r105.top;
    L36:
        int r125 = this.f570566c;
        if (r125 != 4) goto L40;
        int r126 = r117.top;
        r105.ascent = r126;
        r105.top = r126;
        int r127 = r118 + r126;
        r105.descent = r127;
        r105.bottom = r127;
        return;
    L40:
        if (r125 != 7) goto L43;
        int r128 = r117.bottom;
        r105.descent = r128;
        r105.bottom = r128;
        int r129 = r128 - r118;
        r105.ascent = r129;
        r105.top = r129;
        return;
    L43:
        if (r125 != 11) goto L67;
        int r130 = r117.top - ((r118 - r117.height()) / 2);
        r105.top = r130;
        r105.ascent = r130;
        int r131 = r130 + r118;
        r105.bottom = r131;
        r105.descent = r131;
        return;
    L67:
        return;
    L64:
        return;
    L7:
        if (r100.length() != (r102 - r101)) goto L9;
    L10:
        r117 = new Rect();
        if (Build.VERSION.SDK_INT < 29) goto L13;
        r106.getTextBounds(r100, 0, r100.toString().length(), r117);
        goto L15
    L13:
        r106.getTextBounds(r100.toString(), 0, r100.toString().length(), r117);
        goto L15
    L9:
        if (this.f570567d == false) goto L14;
        goto L10
    }
}
