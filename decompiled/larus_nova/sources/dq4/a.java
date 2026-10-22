package dq4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f469660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f469661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f469662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f469663d;

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        Drawable r100 = this.f469660a.getResources().getDrawable(this.f469661b).mutate();
        int r101 = this.f469662c;
        r100.setBounds(0, 0, r101, r101);
        return r100;
    }

    public a(Context r100, int r101) {
        super(r100, R.drawable.ud_icon_warning_colorful);
        this.f469660a = r100;
        this.f469661b = R.drawable.ud_icon_warning_colorful;
        this.f469662c = r100.getResources().getDimensionPixelSize(r101);
        this.f469663d = r100.getResources().getDimensionPixelSize(R.dimen.bitable_descrpition_icon_space) / 2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r106.bottom - r106.top;
        int r108 = (r105.bottom - r105.top) / 2;
        int r109 = r107 / 4;
        int r110 = r108 - r109;
        int r111 = -(r108 + r109);
        r104.ascent = r111;
        r104.top = r111;
        r104.bottom = r110;
        r104.descent = r110;
    L6:
        return r105.right + this.f469663d;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Drawable r109 = getDrawable();
        r100.save();
        int r110 = (r107 - r109.getBounds().bottom) - (((r107 - r105) / 2) - (r109.getBounds().height() / 2));
        int r111 = 0;
        if (r104 <= 0.0f) goto L5;
        r111 = Math.max(0, this.f469663d);
    L5:
        r100.translate(r104 + r111, r110);
        r109.draw(r100);
        r100.restore();
    }
}
