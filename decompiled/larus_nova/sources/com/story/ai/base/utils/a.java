package com.story.ai.base.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ImageSpan {
    public a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Drawable r109 = getDrawable();
        Paint.FontMetrics r110 = r108.getFontMetrics();
        float r111 = r106;
        float r112 = ((((r110.descent + r111) + r111) + r110.ascent) / 2) - (r109.getBounds().bottom / 2);
        r100.save();
        r100.translate(r104, r112);
        r109.draw(r100);
        r100.restore();
    }
}
