package xm5;

import android.net.Uri;
import android.text.SpannableStringBuilder;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.HyperLinkSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextLikeSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextSegment;
import com.bytedance.ee.bear.utils.LinkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import db5.g;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import un5.h;
import zm5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements Function<g, List<BaseSegment>> {

    public static class a implements Comparator<zm5.d> {
        public final SpannableStringBuilder a;

        public a(SpannableStringBuilder r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(zm5.d r3, zm5.d r4) {
            zm5.d r5 = r3;
            int r0 = this.a.getSpanStart(r5);
            SpannableStringBuilder r1 = this.a;
            int r6 = r1.getSpanStart(r4);
            if (r0 != r6) goto L9;
            if ((r5 instanceof h) == false) goto L7;
            return -1;
        L7:
            return 1;
        L9:
            return r0 - r6;
        }
    }

    public f() {
    }

    public final Object apply(Object r13) throws Exception {
        SpannableStringBuilder r0 = new SpannableStringBuilder(((g) r13).a);
        un5.d[] r14 = (un5.d[]) r0.getSpans(0, r0.length(), un5.d.class);
        int r1 = r14.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        un5.d r4 = r14[r3];
        r0.delete(r0.getSpanStart(r4), r0.getSpanEnd(r4));
        r3 = r3 + 1;
        goto L3
    L5:
        ArrayList r15 = new ArrayList();
        List r2 = Arrays.asList((zm5.d[]) r0.getSpans(0, r0.length(), zm5.d.class));
        Collections.sort(r2, new a(r0));
        ListIterator r5 = r2.listIterator();
    L7:
        if (r5.hasNext() == false) goto L33;
        zm5.d r6 = (zm5.d) r5.next();
        BaseSegment r7 = r6.getSegment();
        r7.setText(r0.subSequence(r0.getSpanStart(r6), r0.getSpanEnd(r6)).toString());
        if ((r7 instanceof TextLikeSegment) == false) goto L32;
        TextLikeSegment r8 = (TextLikeSegment) r7;
        ArrayList r9 = new ArrayList();
    L12:
        if (r5.hasNext() == false) goto L23;
        zm5.d r10 = (zm5.d) r5.next();
        if ((r10 instanceof j) == false) goto L22;
        int r11 = r0.getSpanStart(r10);
        int r12 = r0.getSpanEnd(r10);
        int r16 = r0.getSpanStart(r6);
        int r17 = r0.getSpanEnd(r6);
        if (r11 < r16) goto L19;
        if (r12 > r17) goto L19;
        boolean r18 = true;
    L20:
        if (r18 == false) goto L22;
        j r19 = (j) r10;
        TextSegment r20 = r19.c;
        r20.setText(r0.subSequence(r0.getSpanStart(r19), r0.getSpanEnd(r19)).toString());
        r9.add(r20);
    L19:
        r18 = false;
    L22:
        r5.previous();
    L23:
        r8.setTexts(r9);
        if ((r8 instanceof HyperLinkSegment) == false) goto L32;
        HyperLinkSegment r21 = (HyperLinkSegment) r8;
        String r22 = r21.getText();
        Lazy r23 = LinkUtils.a;
        Intrinsics.checkNotNullParameter(r22, "str");
        if (((Pattern) LinkUtils.c.getValue()).matcher(StringsKt.trim(r22).toString()).matches() == false) goto L31;
        Uri r24 = UriProtector.parse(r21.getLink());
        if (UriProtector.parse(r22).getScheme() == null) goto L30;
        r21.setLink(r22);
        goto L31
    L30:
        r21.setLink(r24.getScheme() + "://" + r22);
    L31:
        tt5.a.b("SheetUnFormatFun", "handleHyperLinkSegment: link = " + r21.getLink());
    L32:
        r15.add(r7);
        goto L7
    L33:
        return r15;
    }
}
