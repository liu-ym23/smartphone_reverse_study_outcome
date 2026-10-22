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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements InputFilter, SpanWatcher {
    public final Context a;
    public SegmentStyle b;

    public static class a {
        public final List<zm5.d> a;

        public a(List<zm5.d> r1) {
            this.a = r1;
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable r1, Object r2, int r3, int r4, int r5, int r6) {
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable r1, Object r2, int r3, int r4) {
    }

    public e(Context r1, SegmentStyle r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Spannable a(String r6, SegmentStyle r7) {
        TextSegment r0 = new TextSegment(r6);
        if (r7 != null) goto L10;
    L8:
        r0.setStyle(r7);
        zm5.j r8 = new zm5.j(this.a, r0);
        SpannableStringBuilder r1 = new SpannableStringBuilder(r6);
        r1.setSpan(r8, 0, r6.length(), 33);
        return r1;
    L10:
        r7 = r7.clone();     // Catch: CloneNotSupportedException -> L6
    L6:
        e = move-exception;
        tt5.a.e("SegmentInputFilter", "appendTextSpan, clone fail", e, false);
        goto L8
    }

    public final Spannable b(String r9, zm5.d[] r10, b r11, Predicate r12) {
        ArrayList r0 = new ArrayList();
        int r1 = r10.length;
        boolean r2 = true;
        SegmentStyle r3 = null;
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L18;
        zm5.d r6 = r10[r5];
        if (r11 == null) goto L9;
        if (r11.test(r6) == true) goto L9;
    L17:
        r5 = r5 + 1;
    L9:
        if (r12.test(r6) == false) goto L11;
        r0.add(r6);
    L13:
        if ((r6 instanceof zm5.h) == false) goto L17;
        zm5.h r7 = (zm5.h) r6;
        if (r7.getStyle() == null) goto L17;
        r3 = r7.getStyle();
        goto L17
    L11:
        r2 = false;
        goto L13
    L18:
        if (r2 == false) goto L21;
        a r13 = new a(r0);
        SpannableStringBuilder r14 = new SpannableStringBuilder(r9);
        r14.setSpan(r13, 0, r9.length(), 33);
        return r14;
    L21:
        return a(r9, r3);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable r17, Object r18, int r19, int r20) {
        if ((r18 instanceof a) == false) goto L22;
        a r2 = (a) r18;
        List r6 = r2.a;
        if (r6 != null) goto L7;
        r6 = new ArrayList();
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L20;
        zm5.d r8 = (zm5.d) r7.next();
        int r9 = r17.getSpanStart(r8);
        int r10 = r17.getSpanEnd(r8);
        int r11 = r17.getSpanStart(r2);
        int r12 = r17.getSpanEnd(r2);
        if (r9 > r11) goto L14;
        if (r10 < r12) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == true) goto L9;
        r17.removeSpan(r8);
        if (r9 >= 0) goto L19;
        r9 = r11;
    L19:
        int[] r14 = {r9, r10};
        r17.setSpan(r8, Math.min(r14[0], r11), Math.max(r14[1], new int[]{r11, r12}[1]), r8.F());
    L14:
        r13 = false;
        goto L15
    L20:
        r17.removeSpan(r2);
    L22:
        if ((r18 instanceof zm5.d) == false) goto L79;
        zm5.d r3 = (zm5.d) r18;
        zm5.d[] r15 = (zm5.d[]) r17.getSpans(r19, r20, zm5.d.class);
        int r16 = r15.length;
        int r21 = 0;
    L24:
        if (r21 >= r16) goto L92;
        zm5.d r22 = r15[r21];
        if (r3 == r22) goto L45;
        BaseSegment r0 = r3.getSegment();
        BaseSegment r110 = r22.getSegment();
        if ((r0 instanceof TextLikeSegment) == false) goto L38;
        if ((r110 instanceof TextSegment) == false) goto L38;
        List<TextSegment> r1 = ((TextLikeSegment) r0).getTexts();
        if (r1 != null) goto L35;
    L46:
        boolean r4 = true;
    L47:
        if (r4 == false) goto L78;
        int[] r5 = {r17.getSpanStart(r22), r17.getSpanEnd(r22)};
        int r111 = r17.getSpanEnd(r3);
        int[] r112 = {r17.getSpanStart(r3), r111};
        int r113 = r5[1];
        int r114 = r112[0];
        if (r113 < r114) goto L69;
        int r115 = r5[0];
        if (r115 > r111) goto L69;
        if (r115 < r114) goto L56;
        if (r113 > r111) goto L56;
        int[][] r23 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{0, 2});
    L68:
        int[][] r116 = r23;
    L70:
        r17.removeSpan(r22);
        int r117 = r116.length;
        int r118 = 0;
    L71:
        if (r118 >= r117) goto L78;
        int[] r119 = r116[r118];
        Object r24 = r22.mo752clone();     // Catch: CloneNotSupportedException -> L75
    L77:
        r17.setSpan(r24, r119[0], r119[1], r22.F());
        r118 = r118 + 1;
    L75:
        e = move-exception;
        tt5.a.e("SegmentInputFilter", "handleOverlappingSpan, clone fail", e, false);
        r24 = r22;
    L56:
        if (r115 > r114) goto L63;
        if (r113 < r111) goto L63;
        if (r115 != r114) goto L60;
        r23 = new int[][]{new int[]{r111, r113}};
        goto L68
    L60:
        if (r113 != r111) goto L62;
        r23 = new int[][]{new int[]{r115, r112[0]}};
        goto L68
    L62:
        r116 = new int[][]{new int[]{r115, r112[0]}, new int[]{r112[1], r5[1]}};
    L63:
        if (r115 >= r114) goto L65;
        r23 = new int[][]{new int[]{r115, r112[0]}};
        goto L68
    L65:
        if (r113 <= r111) goto L67;
        r23 = new int[][]{new int[]{r111, r113}};
        goto L68
    L67:
        r23 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{0, 2});
    L69:
        r116 = new int[][]{r5};
    L78:
        r21 = r21 + 1;
        goto L24
    L35:
        if (r1.contains(r110) == true) goto L45;
    L38:
        if ((r110 instanceof TextLikeSegment) == false) goto L46;
        if ((r0 instanceof TextSegment) == false) goto L46;
        TextLikeSegment r25 = ((TextSegment) r0).getTextLikeSegment();
        if (r25 == null) goto L46;
        if (r25 != r110) goto L46;
    L45:
        r4 = false;
        goto L47
    L92:
        return;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r9, int r10, int r11, final Spanned r12, final int r13, int r14) {
        boolean r15 = !TextUtils.isEmpty(r9);
        if ((r9 instanceof SpannableStringBuilder) == true) goto L5;
    L7:
        Spannable r16 = null;
        if (r15 == false) goto L28;
        String r17 = r9.toString();
        zm5.d[] r18 = (zm5.d[]) r12.getSpans(r13, r13, zm5.d.class);
        if (r13 <= 0) goto L15;
        if (r12.charAt(r13 - 1) == '\n') goto L15;
        r16 = b(r17, r18, new b(r12, r13), new c(r12, r13));
    L21:
        if ((r9 instanceof Spanned) == false) goto L28;
        Spanned r2 = (Spanned) r9;
        if (r2.length() != r16.length()) goto L25;
        TextUtils.copySpansFrom(r2, 0, r2.length(), null, r16, 0);
        goto L28
    L25:
        Object[] r19 = r2.getSpans(0, r2.length(), Object.class);
        int r110 = r19.length;
        int r111 = 0;
    L26:
        if (r111 >= r110) goto L28;
        Object r112 = r19[r111];
        r16.setSpan(r112, 0, r16.length(), r2.getSpanFlags(r112));
        r111 = r111 + 1;
    L15:
        if (r12.length() > r13) goto L17;
    L19:
        r16 = a(r17, this.b);
        goto L21
    L17:
        if (r12.charAt(r13) == '\n') goto L19;
        r16 = b(r17, r18, null, new d());
    L28:
        return r16;
    L5:
        if (((zm5.d[]) ((SpannableStringBuilder) r9).getSpans(r10, r11, zm5.d.class)).length == 0) goto L7;
        r15 = false;
        goto L7
    }
}
