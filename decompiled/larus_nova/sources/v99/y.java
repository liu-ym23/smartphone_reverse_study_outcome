package v99;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class y extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f553874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f553875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f553876c;

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        Drawable r100 = this.f553875b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Drawable r101 = super.getDrawable();
        this.f553875b = r101;
        return r101;
    }

    public y(int r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, "spanContext");
        super(r101, r100);
        this.f553874a = r101;
        this.f553876c = 255;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Drawable r105 = getDrawable();
        if (r105 == null) goto L7;
        Rect r106 = r105.getBounds();
        if (r106 == null) goto L7;
        int r107 = r106.right;
    L8:
        Resources r108 = this.f553874a.getResources();
        return r107 + ((int) (WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()).density * 5.0f));
    L7:
        r107 = 0;
        goto L8
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Drawable r109 = getDrawable();
        if (r109 != null) goto L5;
        return;
    L5:
        Paint.FontMetricsInt r110 = r108.getFontMetricsInt();
        int r111 = ((((r110.descent + r106) + r106) + r110.ascent) / 2) - (r109.getBounds().bottom / 2);
        r100.save();
        Resources r112 = this.f553874a.getResources();
        r100.translate(r104 + ((int) (WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).density * 5.0f)), r111);
        r109.setAlpha(this.f553876c);
        r109.draw(r100);
        r100.restore();
    }
}
