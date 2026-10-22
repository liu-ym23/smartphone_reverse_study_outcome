package com.ss.android.lark.widget.linked_emojicon.widget;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.ReplacementSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements LineBackgroundSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f446440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f446441b;

    public b(int r100, DashPathEffect r101) {
        Intrinsics.checkNotNullParameter(r101, "dashPathEffect");
        Paint r102 = new Paint();
        this.f446440a = r102;
        new Paint().setColor(0);
        this.f446441b = UIHelper.dp2px(3.0f);
        r102.setStyle(Paint.Style.STROKE);
        r102.setStrokeWidth(UIUtils.dp2px(LarkContext.getApplication(), 1));
        r102.setColor(r100);
        r102.setPathEffect(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r210, Paint r211, int r212, int r213, int r214, int r215, int r216, CharSequence r217, int r218, int r310, int r311) {
        int r100 = r218;
        Intrinsics.checkNotNullParameter(r210, "canvas");
        Intrinsics.checkNotNullParameter(r211, "paint");
        Intrinsics.checkNotNullParameter(r217, "text");
        Spanned r101 = (Spanned) r217;
        int r102 = r101.getSpanStart(this);
        int r103 = r101.getSpanEnd(this);
        int r104 = Math.max(r102, r100);
        int r105 = Math.min(r103, r310);
        if (r104 >= r105) goto L25;
        String r110 = r217.subSequence(r104, r105).toString();
        int r106 = r.f448769a;
        Spanned r111 = (Spanned) r217;
        Intrinsics.checkNotNullParameter(r111, "text");
        Intrinsics.checkNotNullParameter(r211, "paint");
        LeadingMarginSpan[] r107 = (LeadingMarginSpan[]) r111.getSpans(r100, r102, LeadingMarginSpan.class);
        float r108 = 0.0f;
        if (r107 == null) goto L9;
        int r109 = r107.length;
        int r112 = 0;
    L7:
        if (r112 >= r109) goto L9;
        LeadingMarginSpan r113 = r107[r112];
        Log.d("LineBackgroundSpanUtils", "replacementSpan is " + r113.getClass());
        r108 = r108 + ((float) r113.getLeadingMargin(false));
        r112 = r112 + 1;
    L9:
        ReplacementSpan[] r114 = (ReplacementSpan[]) r111.getSpans(r100, r102, ReplacementSpan.class);
        if (r114 == null) goto L17;
        int r115 = r114.length;
        int r116 = 0;
    L12:
        if (r116 >= r115) goto L17;
        ReplacementSpan r117 = r114[r116];
        Log.d("LineBackgroundSpanUtils", "replacementSpan is " + r117.getClass());
        int r118 = r111.getSpanStart(r117);
        int r119 = r111.getSpanEnd(r117);
        if (r100 >= r118) goto L16;
        r108 = r108 + r211.measureText(r111, r100, r118);
    L16:
        r108 = r108 + r117.getSize(r211, r111, r118, r119, null);
        r116 = r116 + 1;
        r100 = r119;
    L17:
        if (r100 >= r102) goto L19;
        r108 = r108 + r211.measureText(r111, r100, r102);
    L19:
        float r120 = r212 + r108;
        float r121 = r211.measureText(r110) + r120;
        int r122 = r215 + this.f446441b;
        Path r123 = new Path();
        float r124 = r122;
        r123.moveTo(r120, r124);
        r123.lineTo(r121, r124);
        r210.drawPath(r123, this.f446440a);
        return;
    }
}
