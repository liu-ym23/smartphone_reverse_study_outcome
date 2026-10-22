package pn5;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.core.util.Predicate;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextLikeSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextSegment;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements InputFilter, SpanWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f529964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SegmentStyle f529965b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<zm5.d> f529966a;

        public a(List<zm5.d> r100) {
            this.f529966a = r100;
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable r100, Object r101, int r102, int r103, int r104, int r105) {
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable r100, Object r101, int r102, int r103) {
    }

    public e(Context r100, SegmentStyle r101) {
        this.f529964a = r100;
        this.f529965b = r101;
    }

    public final Spannable a(String r100, SegmentStyle r101) {
        TextSegment r102 = new TextSegment(r100);
        if (r101 != null) goto L10;
    L8:
        r102.setStyle(r101);
        zm5.j r103 = new zm5.j(this.f529964a, r102);
        SpannableStringBuilder r104 = new SpannableStringBuilder(r100);
        r104.setSpan(r103, 0, r100.length(), 33);
        return r104;
    L10:
        r101 = r101.clone();     // Catch: CloneNotSupportedException -> L6
    L6:
        e = move-exception;
        tt5.a.e("SegmentInputFilter", "appendTextSpan, clone fail", e, false);
        goto L8
    }

    public final Spannable b(String r100, zm5.d[] r110, b r111, Predicate r112) {
        ArrayList r101 = new ArrayList();
        int r102 = r110.length;
        boolean r103 = true;
        SegmentStyle r104 = null;
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L18;
        zm5.d r106 = r110[r105];
        if (r111 == null) goto L9;
        if (r111.test(r106) == true) goto L9;
    L17:
        r105 = r105 + 1;
    L9:
        if (r112.test(r106) == false) goto L11;
        r101.add(r106);
    L13:
        if ((r106 instanceof zm5.h) == false) goto L17;
        zm5.h r107 = (zm5.h) r106;
        if (r107.getStyle() == null) goto L17;
        r104 = r107.getStyle();
        goto L17
    L11:
        r103 = false;
        goto L13
    L18:
        if (r103 == false) goto L21;
        a r113 = new a(r101);
        SpannableStringBuilder r114 = new SpannableStringBuilder(r100);
        r114.setSpan(r113, 0, r100.length(), 33);
        return r114;
    L21:
        return a(r100, r104);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable r110, Object r111, int r112, int r210) {
        if ((r111 instanceof a) == false) goto L22;
        a r100 = (a) r111;
        List r101 = r100.f529966a;
        if (r101 != null) goto L7;
        r101 = new ArrayList();
    L7:
        Iterator r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L20;
        zm5.d r103 = (zm5.d) r102.next();
        int r104 = r110.getSpanStart(r103);
        int r105 = r110.getSpanEnd(r103);
        int r113 = r110.getSpanStart(r100);
        int r114 = r110.getSpanEnd(r100);
        if (r104 > r113) goto L14;
        if (r105 < r114) goto L14;
        boolean r115 = true;
    L15:
        if (r115 == true) goto L9;
        r110.removeSpan(r103);
        if (r104 >= 0) goto L19;
        r104 = r113;
    L19:
        int[] r116 = {r104, r105};
        r110.setSpan(r103, Math.min(r116[0], r113), Math.max(r116[1], new int[]{r113, r114}[1]), r103.F());
    L14:
        r115 = false;
        goto L15
    L20:
        r110.removeSpan(r100);
    L22:
        if ((r111 instanceof zm5.d) == false) goto L79;
        zm5.d r106 = (zm5.d) r111;
        zm5.d[] r107 = (zm5.d[]) r110.getSpans(r112, r210, zm5.d.class);
        int r108 = r107.length;
        int r109 = 0;
    L24:
        if (r109 >= r108) goto L92;
        zm5.d r117 = r107[r109];
        if (r106 == r117) goto L45;
        BaseSegment r118 = r106.getSegment();
        BaseSegment r119 = r117.getSegment();
        if ((r118 instanceof TextLikeSegment) == false) goto L38;
        if ((r119 instanceof TextSegment) == false) goto L38;
        List<TextSegment> r120 = ((TextLikeSegment) r118).getTexts();
        if (r120 != null) goto L35;
    L46:
        boolean r121 = true;
    L47:
        if (r121 == false) goto L78;
        int[] r122 = {r110.getSpanStart(r117), r110.getSpanEnd(r117)};
        int r123 = r110.getSpanEnd(r106);
        int[] r124 = {r110.getSpanStart(r106), r123};
        int r125 = r122[1];
        int r126 = r124[0];
        if (r125 < r126) goto L69;
        int r127 = r122[0];
        if (r127 > r123) goto L69;
        if (r127 < r126) goto L56;
        if (r125 > r123) goto L56;
        int[][] r128 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{0, 2});
    L68:
        int[][] r129 = r128;
    L70:
        r110.removeSpan(r117);
        int r130 = r129.length;
        int r131 = 0;
    L71:
        if (r131 >= r130) goto L78;
        int[] r132 = r129[r131];
        Object r133 = r117.mo11005clone();     // Catch: CloneNotSupportedException -> L75
    L77:
        r110.setSpan(r133, r132[0], r132[1], r117.F());
        r131 = r131 + 1;
    L75:
        e = move-exception;
        tt5.a.e("SegmentInputFilter", "handleOverlappingSpan, clone fail", e, false);
        r133 = r117;
    L56:
        if (r127 > r126) goto L63;
        if (r125 < r123) goto L63;
        if (r127 != r126) goto L60;
        r128 = new int[][]{new int[]{r123, r125}};
        goto L68
    L60:
        if (r125 != r123) goto L62;
        r128 = new int[][]{new int[]{r127, r124[0]}};
        goto L68
    L62:
        r129 = new int[][]{new int[]{r127, r124[0]}, new int[]{r124[1], r122[1]}};
    L63:
        if (r127 >= r126) goto L65;
        r128 = new int[][]{new int[]{r127, r124[0]}};
        goto L68
    L65:
        if (r125 <= r123) goto L67;
        r128 = new int[][]{new int[]{r123, r125}};
        goto L68
    L67:
        r128 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{0, 2});
    L69:
        r129 = new int[][]{r122};
    L78:
        r109 = r109 + 1;
        goto L24
    L35:
        if (r120.contains(r119) == true) goto L45;
    L38:
        if ((r119 instanceof TextLikeSegment) == false) goto L46;
        if ((r118 instanceof TextSegment) == false) goto L46;
        TextLikeSegment r134 = ((TextSegment) r118).getTextLikeSegment();
        if (r134 == null) goto L46;
        if (r134 != r119) goto L46;
    L45:
        r121 = false;
        goto L47
    L92:
        return;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r110, int r111, final Spanned r112, final int r113, int r114) {
        boolean r115 = !TextUtils.isEmpty(r100);
        if ((r100 instanceof SpannableStringBuilder) == true) goto L5;
    L7:
        Spannable r116 = null;
        if (r115 == false) goto L28;
        String r117 = r100.toString();
        zm5.d[] r118 = (zm5.d[]) r112.getSpans(r113, r113, zm5.d.class);
        if (r113 <= 0) goto L15;
        if (r112.charAt(r113 - 1) == '\n') goto L15;
        r116 = b(r117, r118, new b(r112, r113), new c(r112, r113));
    L21:
        if ((r100 instanceof Spanned) == false) goto L28;
        Spanned r101 = (Spanned) r100;
        if (r101.length() != r116.length()) goto L25;
        TextUtils.copySpansFrom(r101, 0, r101.length(), null, r116, 0);
        goto L28
    L25:
        Object[] r102 = r101.getSpans(0, r101.length(), Object.class);
        int r119 = r102.length;
        int r120 = 0;
    L26:
        if (r120 >= r119) goto L28;
        Object r121 = r102[r120];
        r116.setSpan(r121, 0, r116.length(), r101.getSpanFlags(r121));
        r120 = r120 + 1;
    L15:
        if (r112.length() > r113) goto L17;
    L19:
        r116 = a(r117, this.f529965b);
        goto L21
    L17:
        if (r112.charAt(r113) == '\n') goto L19;
        r116 = b(r117, r118, null, new d());
    L28:
        return r116;
    L5:
        if (((zm5.d[]) ((SpannableStringBuilder) r100).getSpans(r110, r111, zm5.d.class)).length == 0) goto L7;
        r115 = false;
        goto L7
    }
}
