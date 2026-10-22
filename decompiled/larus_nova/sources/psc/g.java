package psc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.text.style.ReplacementSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public final class g extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f530610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f530611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<Integer, Integer>> f530612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f530613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f530614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f530615f;

    public g(CharSequence r100, int r101, List<Pair<Integer, Integer>> r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "titleStr");
        Intrinsics.checkNotNullParameter(r102, "toDeleteSpaceList");
        this.f530610a = r100;
        this.f530611b = r101;
        this.f530612c = r102;
        this.f530613d = r103;
        this.f530614e = r104;
        this.f530615f = com.larus.business.markdown.impl.common.utils.d.a(2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        if (r104 == null) goto L5;
        int r105 = r104.ascent;
        int r106 = this.f530614e;
        int r107 = this.f530615f;
        r104.ascent = r105 - (r106 + r107);
        r104.top -= r106 + r107;
        r104.descent += r106 - r107;
        r104.bottom += r106 - r107;
    L5:
        float r108 = this.f530613d;
        Iterator<T> r109 = this.f530612c.iterator();
    L7:
        if (r109.hasNext() == false) goto L10;
        Pair r110 = (Pair) r109.next();
        r108 = r108 + r100.measureText(this.f530610a, ((Number) r110.getFirst()).intValue(), ((Number) r110.getSecond()).intValue());
        goto L7
    L10:
        if ((r101 instanceof SpannableString) == false) goto L12;
        SpannableString r111 = (SpannableString) r101;
    L13:
        if (r111 == null) goto L33;
        Object[] r112 = r111.getSpans(r102, r103, LeadingMarginSpan.class);
        ArrayList r113 = new ArrayList();
        int r114 = r112.length;
        int r115 = 0;
    L15:
        if (r115 >= r114) goto L27;
        Object r116 = r112[r115];
        LeadingMarginSpan r117 = (LeadingMarginSpan) r116;
        if ((r117 instanceof io.noties.markwon.core.spans.e) == false) goto L19;
    L23:
        boolean r118 = false;
    L24:
        if (r118 == false) goto L26;
        r113.add(r116);
    L26:
        r115 = r115 + 1;
        goto L15
    L19:
        if ((r117 instanceof a) == true) goto L23;
        if ((r117 instanceof com.larus.business.markdown.impl.markwon.custom.title.d) == true) goto L23;
        r118 = true;
        goto L24
    L27:
        Iterator r119 = r113.iterator();
        int r120 = 0;
    L29:
        if (r119.hasNext() == false) goto L31;
        r120 = r120 + ((LeadingMarginSpan) r119.next()).getLeadingMargin(false);
        goto L29
    L31:
        r108 = r108 + r120;
    L33:
        return (int) RangesKt.coerceAtLeast(this.f530611b - r108, 0.0f);
    L12:
        r111 = null;
        goto L13
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r110, int r111, int r112, float r113, int r114, int r115, int r116, Paint r117) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r110, "text");
        Intrinsics.checkNotNullParameter(r117, "paint");
        r100.drawText(r110, r111, r112, r113, r115, r117);
    }
}
