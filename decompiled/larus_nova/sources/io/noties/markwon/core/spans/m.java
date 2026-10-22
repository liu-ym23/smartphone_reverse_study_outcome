package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class m extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f492348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f492350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Integer, Float> f492351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Integer, Integer> f492352i;

    @Override // io.noties.markwon.core.spans.n, android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
    }

    public final void b(TextPaint r100) {
        Map<Integer, Float> r101 = this.f492351h;
        if (r101 == null) goto L6;
        Object r102 = (Float) r101.get(Integer.valueOf(this.f492348e));
        if (r102 == null) goto L6;
    L7:
        if (r102 == null) goto L9;
        r100.setFakeBoldText(true);
        r100.setTextSize(((Number) r102).floatValue() + com.larus.business.markdown.impl.common.utils.d.b(Integer.valueOf(this.f492349f)));
    L9:
        Integer r103 = this.f492350g;
        if (r103 == null) goto L13;
        r100.setColor(r103.intValue());
        return;
    L13:
        return;
    L6:
        Map<Integer, Integer> r104 = this.f492352i;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        r102 = r105.get(Integer.valueOf(this.f492348e));
        goto L7
    }

    @Override // io.noties.markwon.core.spans.n, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "tp");
        b(r100);
    }

    @Override // io.noties.markwon.core.spans.n, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        b(r100);
    }

    public m(msc.s r100, int r101, int r102, Integer r103, Map<Integer, Float> r104) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        super(r100, r101);
        this.f492348e = r101;
        this.f492349f = r102;
        this.f492350g = r103;
        this.f492351h = r104;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put(1, Integer.valueOf(((Number) MarkdownDimensExtKt.f320540q.getValue()).intValue()));
        r105.put(2, Integer.valueOf(((Number) MarkdownDimensExtKt.f320539p.getValue()).intValue()));
        r105.put(3, Integer.valueOf(MarkdownDimensExtKt.d()));
        r105.put(4, Integer.valueOf(MarkdownDimensExtKt.d()));
        r105.put(5, Integer.valueOf(MarkdownDimensExtKt.d()));
        r105.put(6, Integer.valueOf(MarkdownDimensExtKt.d()));
        this.f492352i = r105;
    }
}
