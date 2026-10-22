package mh2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f513900a;

    public a(Context r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "b");
        super(r100, r101, -1);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        Rect r105 = getDrawable().getBounds();
        int r106 = r105.height();
        Paint.FontMetrics r107 = r100.getFontMetrics();
        if (r104 == null) goto L6;
        int r108 = (int) (((r107.descent + r107.ascent) / 2) - (r106 / 2));
        r104.ascent = r108;
        r104.top = r108;
        int r109 = r106 + r108;
        r104.descent = r109;
        r104.bottom = r109;
    L6:
        return r105.right + this.f513900a;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Drawable r109 = getDrawable();
        r100.save();
        int r110 = r107 - r109.getBounds().bottom;
        if (((ImageSpan) this).mVerticalAlignment != 1) goto L5;
        int r111 = r110 - r108.getFontMetricsInt().descent;
    L6:
        r100.translate(r104, r111);
        r109.draw(r100);
        r100.restore();
        return;
    L5:
        Paint.FontMetricsInt r112 = r108.getFontMetricsInt();
        r111 = ((((r112.descent + r106) + r106) + r112.ascent) / 2) - (r109.getBounds().bottom / 2);
        goto L6
    }
}
