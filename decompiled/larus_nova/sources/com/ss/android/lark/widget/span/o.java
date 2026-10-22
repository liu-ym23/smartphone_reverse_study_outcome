package com.ss.android.lark.widget.span;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LineBackgroundSpan;
import android.text.style.MetricAffectingSpan;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public final class o extends MetricAffectingSpan implements LineBackgroundSpan, x9b.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InlineCodeInfo f448757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f448758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f448759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f448760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f448761e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f448762a = null;

        static {
            int[] r100 = new int[Layout.Alignment.values().length];
            r100[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f448762a = r100;
        }
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        if (r100 == null) goto L8;
        int r101 = this.f448757a.textSize;
        if (r101 <= 0) goto L6;
        r100.setTextSize(r101);
    L6:
        r100.setColor(0);
        return;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "textPaint");
        int r101 = this.f448757a.textSize;
        if (r101 <= 0) goto L5;
        r100.setTextSize(r101);
    L5:
        r100.setColor(0);
    }

    public o(Context r100, InlineCodeInfo r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanInfo");
        this.f448757a = r101;
        float r102 = UIUtils.dp2px(r100, 0.91f);
        this.f448758b = r102;
        int r103 = UDColorUtils.getColor(r100, R.color.line_divider_default);
        if (r101.getBackgroundColorValue() == (-1)) goto L5;
        int r104 = r101.getBackgroundColorValue();
    L6:
        Paint r105 = new Paint();
        r105.setStyle(Paint.Style.FILL);
        r105.setColor(r104);
        r105.setAntiAlias(true);
        this.f448759c = r105;
        Paint r106 = new Paint();
        r106.setStyle(Paint.Style.STROKE);
        r106.setColor(r103);
        r106.setStrokeWidth(r102);
        r106.setAntiAlias(true);
        this.f448760d = r106;
        this.f448761e = new Path();
        return;
    L5:
        r104 = UIUtils.getColor(r100, r101.getBackgroundColor());
        goto L6
    }

    public final void a(Canvas r110, Paint r210, int r211, int r212, int r213, int r214, Spanned r215, int r216, int r217, int r218) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r210, "paint");
        Intrinsics.checkNotNullParameter(r215, "text");
        Lazy<TextPaint> r100 = InlineCodeCenterSpan.f448573e;
        float r101 = InlineCodeCenterSpan.a.e(r210, this.f448757a).measureText(InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER);
        float r111 = MathKt.roundToInt(this.f448758b / 2.0f);
        float r112 = r101 - r111;
        float r113 = InlineCodeCenterSpan.a.b(r215, r218, r216, r217, r210);
        float r114 = this.f448758b;
        float r115 = r213 + r114;
        float r116 = r214 - r114;
        int r117 = a.f448762a[this.f448757a.getAlignment().ordinal()];
        if (r117 == 1) goto L7;
        if (r117 == 2) goto L6;
        float r102 = r211;
    L8:
        float r103 = r102 + r113;
    L9:
        float r104 = r103 + r101;
        Path r105 = this.f448761e;
        r105.reset();
        r105.moveTo(r103, r115);
        float r106 = r103 - r101;
        float r107 = 2 * r101;
        r105.arcTo(r106, r115, r104, r115 + r107, -90.0f, 90.0f, false);
        float r108 = r116 - r101;
        r105.lineTo(r104, r108);
        r105.arcTo(r106, r116 - r107, r104, r116, 0.0f, 90.0f, false);
        r105.lineTo(r103, r115);
        r105.close();
        r110.drawPath(this.f448761e, this.f448759c);
        Path r109 = this.f448761e;
        r109.reset();
        float r118 = r115 + r111;
        r109.moveTo(r103, r118);
        float r119 = r103 - r112;
        float r120 = r104 - r111;
        r109.arcTo(r119, r118, r120, (r115 + r101) + r112, -90.0f, 90.0f, false);
        r109.lineTo(r120, r108);
        r109.arcTo(r119, r108 - r112, r120, r116 - r111, 0.0f, 90.0f, false);
        r110.drawPath(this.f448761e, this.f448760d);
        return;
    L6:
        r103 = r212 - InlineCodeCenterSpan.a.a(r215, r218, r216, r217, r210);
        goto L9
    L7:
        r102 = r211 + (((r212 - r211) - (InlineCodeCenterSpan.a.a(r215, r218, r216, r217, r210) + r113)) / 2);
        goto L8
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r110, Paint r111, int r112, int r113, int r114, int r115, int r116, CharSequence r210, int r211, int r212, int r213) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        Intrinsics.checkNotNullParameter(r210, "text");
        Spanned r100 = (Spanned) r210;
        int r101 = r100.getSpanStart(this);
        int r102 = r100.getSpanEnd(this);
        int r117 = Math.max(r101, r211);
        if (r117 < Math.min(r102, r212)) goto L5;
        return;
    L5:
        a(r110, r111, r112, r113, r114, r116, r100, r211, r212, r117);
    }
}
