package com.ss.android.lark.widget.span;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public class InlineCodeCenterSpan extends MetricAffectingSpan implements LineBackgroundSpan {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<TextPaint> f448573e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<Paint.FontMetricsInt> f448574f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InlineCodeInfo f448575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f448576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f448577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f448578d;

    public static final class a {
        public static TextPaint c() {
            return InlineCodeCenterSpan.f448573e.getValue();
        }

        @JvmStatic
        public static Paint e(Paint r100, InlineCodeInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            Intrinsics.checkNotNullParameter(r101, "spanInfo");
            TextPaint r102 = c();
            r102.set(r100);
            int r103 = r101.textSize;
            if (r103 <= (-1)) goto L6;
            r102.setTextSize(r103);
        L6:
            if (r101.isBold == false) goto L8;
            r102.setFakeBoldText(true);
        L8:
            return r102;
        }

        public static float d(int r100, int r101, Paint r110, Spanned r111) {
            float r102 = 0.0f;
        L3:
            int r103 = r100;
            if (r103 >= r101) goto L17;
            c().set(r110);
            r100 = r111.nextSpanTransition(r103, r101, MetricAffectingSpan.class);
            MetricAffectingSpan[] r104 = (MetricAffectingSpan[]) r111.getSpans(r103, r100, MetricAffectingSpan.class);
            int r105 = r104.length;
            MetricAffectingSpan r106 = null;
            int r107 = 0;
        L6:
            if (r107 >= r105) goto L12;
            MetricAffectingSpan r108 = r104[r107];
            if ((r108 instanceof ReplacementSpan) == false) goto L10;
            r106 = r108;
        L11:
            r107 = r107 + 1;
            goto L6
        L10:
            Lazy<TextPaint> r109 = InlineCodeCenterSpan.f448573e;
            r108.updateMeasureState(c());
            goto L11
        L12:
            ReplacementSpan r112 = (ReplacementSpan) r106;
            if (r112 == null) goto L15;
            TextPaint r113 = c();
            Lazy<Paint.FontMetricsInt> r114 = InlineCodeCenterSpan.f448574f;
            r113.getFontMetricsInt(r114.getValue());
            float r115 = r112.getSize(c(), r111, r103, r100, r114.getValue());
        L16:
            r102 = r102 + r115;
            goto L3
        L15:
            r115 = c().measureText(r111, r103, r100);
            goto L16
        L17:
            c().reset();
            return r102;
        }

        @JvmStatic
        public static float a(Spanned r100, int r101, int r102, int r110, Paint r111) {
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r111, "paint");
            float r103 = 0.0f;
            if (r101 >= r110) goto L18;
            LeadingMarginSpan[] r104 = (LeadingMarginSpan[]) r100.getSpans(r102, r110, LeadingMarginSpan.class);
            if (r104 == null) goto L9;
            int r105 = r104.length;
            int r106 = 0;
        L7:
            if (r106 >= r105) goto L9;
            LeadingMarginSpan r107 = r104[r106];
            Log.d("InlineCodeCenterSpan", "replacementSpan is " + r107.getClass());
            r103 = r103 + ((float) r107.getLeadingMargin(false));
            r106 = r106 + 1;
        L9:
            int r108 = r110 - 1;
            Character r109 = StringsKt.getOrNull(r100, r108);
            if (r109 == null) goto L16;
            if (r109.charValue() != '\n') goto L16;
            r110 = r108;
        L16:
            return r103 + d(r102, r110, r111, r100);
        L18:
            return 0.0f;
        }

        @JvmStatic
        public static float b(Spanned r110, int r111, int r112, int r113, Paint r114) {
            Intrinsics.checkNotNullParameter(r110, "text");
            Intrinsics.checkNotNullParameter(r114, "paint");
            long r100 = System.currentTimeMillis();
            LeadingMarginSpan[] r115 = (LeadingMarginSpan[]) r110.getSpans(r112, r113, LeadingMarginSpan.class);
            float r101 = 0.0f;
            if (r115 == null) goto L7;
            int r102 = r115.length;
            int r103 = 0;
        L5:
            if (r103 >= r102) goto L7;
            LeadingMarginSpan r104 = r115[r103];
            r101 = r101 + r104.getLeadingMargin(false);
            Log.d("InlineCodeCenterSpan", "replacementSpan is " + r104.getClass() + ", lead margin is " + r101);
            r103 = r103 + 1;
        L7:
            float r105 = r101 + d(r112, r111, r114, r110);
            Log.d("InlineCodeCenterSpan", "findStartOffsetPosition: cost " + (System.currentTimeMillis() - r100) + " millis seconds");
            return r105;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f448579a = null;

        static {
            int[] r100 = new int[Layout.Alignment.values().length];
            r100[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f448579a = r100;
        }
    }

    static {
        f448573e = LazyKt.lazy(InlineCodeCenterSpan$Companion$reusableTextPaint$2.INSTANCE);
        f448574f = LazyKt.lazy(InlineCodeCenterSpan$Companion$reusableFM$2.INSTANCE);
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        if (r100 == null) goto L10;
        int r101 = this.f448575a.textSize;
        if (r101 <= 0) goto L6;
        r100.setTextSize(r101);
    L6:
        int r102 = this.f448575a.textColor;
        if (r102 == 0) goto L11;
        r100.setColor(r102);
        return;
    L11:
        return;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "textPaint");
        int r101 = this.f448575a.textSize;
        if (r101 <= 0) goto L5;
        r100.setTextSize(r101);
    L5:
        int r102 = this.f448575a.textColor;
        if (r102 == 0) goto L9;
        r100.setColor(r102);
        return;
    }

    public InlineCodeCenterSpan(Context r100, InlineCodeInfo r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanInfo");
        this.f448575a = r101;
        this.f448576b = UIUtils.dp2px(r100, 0.91f);
        this.f448577c = UDColorUtils.getColor(r100, R.color.line_divider_default);
        if (r101.getBackgroundColorValue() == (-1)) goto L5;
        int r102 = r101.getBackgroundColorValue();
    L6:
        this.f448578d = r102;
        return;
    L5:
        r102 = UIUtils.getColor(r100, r101.getBackgroundColor());
        goto L6
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r110, Paint r111, int r112, int r113, int r114, int r210, int r211, CharSequence r212, int r213, int r214, int r215) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        Intrinsics.checkNotNullParameter(r212, "text");
        Spanned r100 = (Spanned) r212;
        int r101 = r100.getSpanStart(this);
        int r102 = r100.getSpanEnd(this);
        int r103 = Math.max(r101, r213);
        int r104 = Math.min(r102, r214);
        if (r103 < r104) goto L5;
        return;
    L5:
        float r105 = a.e(r111, this.f448575a).measureText(r212.toString().substring(r103, r104));
        Spanned r106 = (Spanned) r212;
        float r115 = a.b(r106, r103, r213, r214, r111);
        int r116 = b.f448579a[this.f448575a.getAlignment().ordinal()];
        if (r116 == 1) goto L10;
        if (r116 == 2) goto L9;
        float r107 = r112;
    L11:
        float r108 = r107 + r115;
    L12:
        float r109 = r108 + r105;
        int r117 = r111.getColor();
        r111.setColor(this.f448578d);
        float r118 = r114;
        float r119 = this.f448576b;
        float r120 = r211;
        float r121 = r108;
        r110.drawRect(r121, r119 + r118, r109, r120 - r119, r111);
        r111.setColor(this.f448577c);
        float r122 = this.f448576b;
        float r123 = r118 + r122;
        r110.drawRect(r121, r123, r109, r122 + r123, r111);
        r111.setColor(this.f448577c);
        float r124 = this.f448576b;
        float r125 = r120 - r124;
        r110.drawRect(r121, r125 - r124, r109, r125, r111);
        r111.setColor(r117);
        return;
    L9:
        r108 = r113 - a.a(r106, r103, r213, r214, r111);
        goto L12
    L10:
        r107 = r112 + (((r113 - r112) - (a.a(r106, r103, r213, r214, r111) + r115)) / 2);
        goto L11
    }
}
