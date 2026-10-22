package rg5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends ImageSpan {
    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.drawable.icon_global_close_small);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r106.descent;
        int r108 = r106.ascent;
        int r109 = r108 + ((r107 - r108) / 2);
        int r110 = (r105.bottom - r105.top) / 2;
        int r111 = r109 - r110;
        r104.ascent = r111;
        r104.top = r111;
        int r112 = r109 + r110;
        r104.bottom = r112;
        r104.descent = r112;
    L6:
        return r105.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Drawable r109 = getDrawable();
        r100.save();
        Paint.FontMetricsInt r110 = r108.getFontMetricsInt();
        int r111 = r110.descent;
        r100.translate(r104, ((r106 + r111) - ((r111 - r110.ascent) / 2)) - ((r109.getBounds().bottom - r109.getBounds().top) / 2));
        r109.draw(r100);
        r100.restore();
    }
}
