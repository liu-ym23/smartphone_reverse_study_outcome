package ncc;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.UIHelper;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends ReplacementSpan implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f518716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f518717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f518718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint.Style f518719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f518720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f518721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f518722g;

    public final int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.f518716a), Integer.valueOf(this.f518717b), Integer.valueOf(this.f518718c), this.f518719d, Integer.valueOf(this.f518720e), Integer.valueOf(this.f518721f), Boolean.valueOf(this.f518722g)});
    }

    public c(int r100) {
        Paint.Style r101 = Paint.Style.STROKE;
        this.f518722g = true;
        this.f518716a = false;
        this.f518717b = UIHelper.dp2px(1.0f);
        this.f518718c = UIHelper.dp2px(6.0f);
        this.f518720e = r100;
        this.f518721f = r100;
        this.f518719d = r101;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f518716a == r101.f518716a) goto L11;
    L23:
        return false;
    L11:
        if (this.f518717b != r101.f518717b) goto L23;
        if (this.f518718c != r101.f518718c) goto L23;
        if (this.f518720e != r101.f518720e) goto L23;
        if (this.f518721f != r101.f518721f) goto L23;
        if (this.f518722g != r101.f518722g) goto L23;
        if (this.f518719d != r101.f518719d) goto L23;
        return true;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        int r105 = (int) r100.measureText(r101, r102, r103);
        if (this.f518716a == false) goto L8;
        r105 = r105 + UIHelper.dp2px(2.0f);
        int r106 = UIHelper.dp2px(2.0f) * 2;
    L6:
        return r105 + r106;
    L8:
        if (this.f518722g == false) goto L10;
        r106 = UIHelper.dp2px(4.0f);
        goto L6
    L10:
        return r105;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        Spanned r106 = (Spanned) r100;
        int r107 = r106.getSpanStart(this);
        int r108 = r106.getSpanEnd(this);
        if (r101 > r107) goto L6;
        if (r108 > r102) goto L6;
        boolean r109 = true;
    L7:
        if (r109 == true) goto L10;
        return;
    L10:
        if (r105.top == 0) goto L12;
    L20:
        int r110 = r105.bottom;
        int r111 = r105.leading;
        int r112 = r110 - r111;
        int r113 = this.f518718c;
        if (r112 <= r113) goto L23;
        return;
    L23:
        int r114 = (r113 - (r110 - r111)) + UIHelper.dp2px(1.0f);
        r105.descent += r114;
        r105.bottom += r114;
        r105.top -= UIHelper.dp2px(1.0f);
        r105.ascent -= UIHelper.dp2px(1.0f);
        return;
    L12:
        if (r105.ascent != 0) goto L20;
        if (r105.leading != 0) goto L20;
        if (r105.descent != 0) goto L20;
        if (r105.bottom != 0) goto L20;
        Resources r115 = UIHelper.getContext().getResources();
        float r116 = -(WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).density * 16.0f);
        r105.top = (int) ((2500.0f * r116) / 2048.0f);
        r105.bottom = (int) (((-1000.0f) * r116) / 2048.0f);
        r105.ascent = (int) ((1900.0f * r116) / 2048.0f);
        r105.descent = (int) ((r116 * (-500.0f)) / 2048.0f);
        r105.leading = 0;
    L6:
        r109 = false;
        goto L7
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r210, Paint r211) {
        float r117 = r211.measureText(r111, r112, r113);
        r211.setColor(this.f518720e);
        r110.drawText(r111, r112, r113, r114, r116, r211);
        r211.setAntiAlias(true);
        r211.setColor(this.f518720e);
        r211.setStyle(Paint.Style.STROKE);
        r211.setStrokeWidth(this.f518717b);
        float r100 = UIHelper.dp2px(3.5f);
        float r101 = r114 + 2.0f;
    L3:
        float r102 = r114 + r117;
        if (r101 >= r102) goto L7;
        r110.drawPoint(r101, this.f518718c + r116, r211);
        r101 = r101 + r100;
        goto L3
    L7:
        if (this.f518716a == false) goto L16;
        Paint.Style r103 = this.f518719d;
        Paint.Style r104 = Paint.Style.STROKE;
        if (r103 != r104) goto L12;
        r211.setStyle(r104);
    L13:
        r211.setStrokeWidth(UIHelper.dp2px(1.0f));
        r211.setColor(this.f518721f);
        r110.drawCircle(r102 + UIHelper.dp2px(2.0f), r115 + UIHelper.dp2px(3.0f), UIHelper.dp2px(2.0f), r211);
        return;
    L12:
        r211.setStyle(Paint.Style.FILL_AND_STROKE);
        goto L13
    }
}
