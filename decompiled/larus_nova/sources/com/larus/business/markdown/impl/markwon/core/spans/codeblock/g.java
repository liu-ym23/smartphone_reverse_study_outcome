package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f320637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f320638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f320639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f320640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f320641e;

    public g(Context r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f320637a = r100;
        this.f320638b = r101;
        this.f320639c = r103;
        Resources r104 = r100.getResources();
        this.f320640d = TypedValue.applyDimension(0, r102, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()));
        this.f320641e = com.larus.business.markdown.impl.common.utils.d.a(7);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        if (r104 == null) goto L7;
        int r105 = r104.descent;
        int r106 = r104.ascent;
        float r107 = this.f320640d;
        int r108 = r106 + ((r105 - r106) - ((int) r107));
        r104.ascent = r108;
        r104.top = r108;
        int r109 = r108 + ((int) (r107 + this.f320641e));
        r104.descent = r109;
        r104.bottom = r109;
        return 0;
    L7:
        return 0;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r110, float r111, int r112, int r113, int r114, Paint r115) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r115, "paint");
        int r103 = r115.getColor();
        r115.setColor(this.f320639c);
        r115.setStrokeWidth(this.f320640d);
        boolean r116 = true;
        if (this.f320637a.getResources().getConfiguration().getLayoutDirection() == 1) goto L6;
        r116 = false;
    L6:
        if (r116 == false) goto L8;
        float r104 = r100.getWidth();
        int r117 = this.f320638b;
    L9:
        float r105 = r112;
        r100.drawLine(r104, r105, r117, r105, r115);
        r115.setColor(r103);
        return;
    L8:
        r104 = r111 - this.f320638b;
        r117 = r100.getWidth();
        goto L9
    }
}
