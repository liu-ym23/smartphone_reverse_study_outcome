package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.ReplacementSpan;
import android.text.style.UpdateAppearance;
import android.text.style.UpdateLayout;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import msc.s;

/* JADX INFO: loaded from: classes26.dex */
public final class CodeBlockWithLineNumberScrollableSpan extends ReplacementSpan implements LeadingMarginSpan, SpanWatcher, lw8.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f320600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f320601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f320602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f320603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GradientDrawable f320604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextPaint f320605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextPaint f320606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f320607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TreeMap<Point, Layout> f320608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f320609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f320610k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f320611l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f320612m;

    public final int b() {
        return ((Number) this.f320610k.getValue()).intValue();
    }

    public final boolean c() {
        return ((Boolean) this.f320611l.getValue()).booleanValue();
    }

    public final int d() {
        return ((Number) this.f320609j.getValue()).intValue();
    }

    @Override // lw8.e
    public final int a() {
        return this.f320612m;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        return ((Number) MarkdownDimensExtKt.f320527d.getValue()).intValue();
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        this.f320600a.a(r100);
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        this.f320600a.a(r100);
    }

    public CodeBlockWithLineNumberScrollableSpan(s r100, c r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        Intrinsics.checkNotNullParameter(r101, "info");
        this.f320600a = r100;
        this.f320601b = r101;
        this.f320602c = r102;
        GradientDrawable r103 = new GradientDrawable();
        b r104 = r101.f320627h;
        Integer r105 = null;
        if (r104 == null) goto L5;
        ctc.e r106 = r104.f320618c;
    L7:
        if (r106 == null) goto L9;
        r103.setColor(r106.f465406d);
        r103.setBounds(0, 0, r106.f465403a, r106.f465404b);
        r103.setCornerRadius(r106.f465404b * 0.5f);
    L9:
        this.f320604e = r103;
        TextPaint r107 = new TextPaint(1);
        r107.setTypeface(Typeface.MONOSPACE);
        Lazy r108 = MarkdownDimensExtKt.f320535l;
        r107.setTextSize(((Number) r108.getValue()).intValue());
        b r109 = r101.f320627h;
        if (r109 == null) goto L12;
        r107.setColor(r109.f320619d);
    L12:
        this.f320605f = r107;
        TextPaint r110 = new TextPaint(1);
        a r111 = r101.f320628i;
        if (r111 == null) goto L15;
        r110.setTextSize(((Number) r108.getValue()).intValue());
        r110.setColor(r111.f320615c);
        r110.setTypeface(Typeface.MONOSPACE);
        r110.setTextAlign(Paint.Align.RIGHT);
    L15:
        this.f320606g = r110;
        a r112 = r101.f320628i;
        if (r112 == null) goto L18;
        r105 = Integer.valueOf(r112.f320614b);
    L18:
        this.f320607h = (int) r110.measureText(String.valueOf(r105));
        final CodeBlockWithLineNumberScrollableSpan$layouts$1 r113 = CodeBlockWithLineNumberScrollableSpan$layouts$1.INSTANCE;
        this.f320608i = new TreeMap(new e(r113));
        this.f320609j = LazyKt.lazy(new CodeBlockWithLineNumberScrollableSpan$marginStart$2(this));
        this.f320610k = LazyKt.lazy(new CodeBlockWithLineNumberScrollableSpan$codeBlockWidth$2(this));
        this.f320611l = LazyKt.lazy(new CodeBlockWithLineNumberScrollableSpan$enableScroll$2(this));
        this.f320612m = d() - getLeadingMargin(false);
        return;
    L5:
        r106 = null;
        goto L7
    }

    public final Layout e(CharSequence r100, int r101, int r102) {
        SpannableStringBuilder r103 = new SpannableStringBuilder(r100, r101, r102);
        r103.removeSpan(this);
        CharSequence r104 = StringsKt.removeSuffix(r103, "\n");
        if (c() == false) goto L11;
        b r105 = this.f320601b.f320627h;
        if (r105 == null) goto L7;
        ctc.a r106 = r105.f320617b;
    L8:
        if (r106 == null) goto L11;
        return f(r104, Integer.MAX_VALUE, 1);
    L7:
        r106 = null;
    L11:
        return f(r104, b(), Integer.MAX_VALUE);
    }

    public final Layout f(CharSequence r100, int r110, int r111) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return StaticLayout.Builder.obtain(r100, 0, r100.length(), this.f320605f, r110).setIncludePad(false).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setMaxLines(r111).build();
    L7:
        return new StaticLayout(r100, this.f320605f, r110, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable r100, Object r101, int r102, int r103) {
        if ((r101 instanceof UpdateAppearance) == true) goto L5;
        return;
    L5:
        if ((r101 instanceof UpdateLayout) == true) goto L9;
        this.f320603d = true;
        return;
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable r100, Object r101, int r102, int r103) {
        if ((r101 instanceof UpdateAppearance) == true) goto L5;
        return;
    L5:
        if ((r101 instanceof UpdateLayout) == true) goto L9;
        this.f320603d = true;
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r110) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        if (r101 != null) goto L5;
        return 0;
    L5:
        Layout r104 = e(r101, r102, r103);
        this.f320608i.put(new Point(r102, r103), r104);
        b r105 = this.f320601b.f320627h;
        ctc.e r106 = null;
        if (r105 == null) goto L8;
        ctc.a r107 = r105.f320617b;
    L9:
        float r108 = 0.0f;
        if (r107 != null) goto L12;
    L14:
        if (r110 == null) goto L34;
        Integer r109 = this.f320601b.f320621b;
        if (r109 != null) goto L19;
    L21:
        boolean r111 = false;
    L22:
        b r112 = this.f320601b.f320627h;
        if (r112 == null) goto L25;
        r106 = r112.f320618c;
    L25:
        if (r111 == false) goto L30;
        if (r106 == null) goto L30;
        if (c() == false) goto L30;
        r108 = r106.f465404b + r106.f465405c;
    L30:
        int r113 = -r104.getHeight();
        r110.ascent = r113;
        if (r111 == false) goto L33;
        r110.ascent = r113 - MathKt.roundToInt(r108);
    L33:
        r110.descent = 0;
        r110.top = r110.ascent;
        r110.bottom = 0;
        this.f320603d = false;
        goto L34
    L19:
        if (r103 != r109.intValue()) goto L21;
        r111 = true;
    L34:
        if (r107 == null) goto L39;
        if (c() == false) goto L39;
        return Math.min(b(), MathKt.roundToInt(r104.getLineWidth(0)));
    L39:
        return b();
    L12:
        if (c() == false) goto L14;
        r107.f465381b = Math.max(0.0f, Math.max(r107.f465381b, r104.getLineWidth(0) - b()));
        goto L14
    L8:
        r107 = null;
        goto L9
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable r100, Object r101, int r102, int r103, int r104, int r105) {
        if ((r101 instanceof UpdateAppearance) == true) goto L5;
        return;
    L5:
        if ((r101 instanceof UpdateLayout) == true) goto L9;
        this.f320603d = true;
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r110, Paint r111) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f320603d == false) goto L8;
        Layout r107 = e(r101, r102, r103);
        this.f320608i.put(new Point(r102, r103), r107);
    L26:
        int r108 = r100.save();
    L41:
        th = move-exception;
        r100.restoreToCount(r108);
        throw th;
    L28:
        if (c() == false) goto L30;
        r100.clipRect((int) (r104 + this.f320607h), r105, this.f320602c, r110);     // Catch: Throwable -> L41
    L30:
        b r109 = this.f320601b.f320627h;     // Catch: Throwable -> L41
        if (r109 == null) goto L35;
        ctc.a r112 = r109.f320617b;     // Catch: Throwable -> L41
        if (r112 == null) goto L35;
        float r113 = r112.f465380a + d();     // Catch: Throwable -> L41
    L36:
        r100.translate(r113, r105);     // Catch: Throwable -> L41
        if (r107 == null) goto L39;
        r107.draw(r100);     // Catch: Throwable -> L41
    L39:
        r100.restoreToCount(r108);
        return;
    L35:
        r113 = d();     // Catch: Throwable -> L41
        goto L36
    L8:
        r107 = this.f320608i.get(new Point(r102, r103));
        if (r107 != null) goto L26;
        Iterator<T> r114 = this.f320608i.entrySet().iterator();
    L12:
        if (r114.hasNext() == false) goto L21;
        Object r115 = r114.next();
        Map.Entry r116 = (Map.Entry) r115;
        if (((Point) r116.getKey()).x == r102) goto L16;
    L18:
        boolean r117 = false;
    L19:
        if (r117 == false) goto L12;
    L22:
        Map.Entry r118 = (Map.Entry) r115;
        if (r118 == null) goto L25;
        r107 = (Layout) r118.getValue();
        goto L26
    L25:
        r107 = null;
        goto L26
    L16:
        if (((Point) r116.getKey()).y < r103) goto L18;
        r117 = true;
        goto L19
    L21:
        r115 = null;
        goto L22
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "p");
        Intrinsics.checkNotNullParameter(r107, "text");
        Intrinsics.checkNotNullParameter(r112, "layout");
        a r109 = this.f320601b.f320628i;
        ctc.e r113 = null;
        if (r109 == null) goto L7;
        Map<Integer, Integer> r114 = r109.f320613a;
        if (r114 == null) goto L7;
        Integer r115 = r114.get(Integer.valueOf(r108));
    L8:
        if (r115 == null) goto L10;
        r100.drawText(r115.toString(), (r102 + this.f320607h) + getLeadingMargin(false), r104 + (this.f320606g.descent() - this.f320606g.ascent()), this.f320606g);
    L10:
        Integer r116 = this.f320601b.f320621b;
        if (r116 != null) goto L14;
        return;
    L14:
        if (r110 != r116.intValue()) goto L31;
        b r117 = this.f320601b.f320627h;
        if (r117 == null) goto L18;
        ctc.a r118 = r117.f320617b;
    L19:
        if (r117 == null) goto L21;
        r113 = r117.f320618c;
    L21:
        if (r118 != null) goto L23;
        return;
    L23:
        if (c() == false) goto L35;
        if (r113 == null) goto L36;
        int r119 = r100.save();
        r100.translate((((-r118.f465380a) / r118.f465381b) * (b() - r113.f465403a)) + d(), (r106 - r113.f465404b) - r113.f465405c);     // Catch: Throwable -> L28
        this.f320604e.draw(r100);     // Catch: Throwable -> L28
        r100.restoreToCount(r119);
        return;
    L28:
        th = move-exception;
        r100.restoreToCount(r119);
        throw th;
    L36:
        return;
    L35:
        return;
    L18:
        r118 = null;
        goto L19
    L31:
        return;
    L7:
        r115 = null;
        goto L8
    }
}
