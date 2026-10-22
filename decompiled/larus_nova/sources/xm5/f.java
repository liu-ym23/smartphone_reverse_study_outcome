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

/* JADX INFO: loaded from: classes18.dex */
public final class f implements Function<g, List<BaseSegment>> {

    public static class a implements Comparator<zm5.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SpannableStringBuilder f564546a;

        public a(SpannableStringBuilder r100) {
            this.f564546a = r100;
        }

        @Override // java.util.Comparator
        public final int compare(zm5.d r100, zm5.d r101) {
            zm5.d r102 = r100;
            int r103 = this.f564546a.getSpanStart(r102);
            SpannableStringBuilder r104 = this.f564546a;
            int r105 = r104.getSpanStart(r101);
            if (r103 != r105) goto L9;
            if ((r102 instanceof h) == false) goto L7;
            return -1;
        L7:
            return 1;
        L9:
            return r103 - r105;
        }
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final List<BaseSegment> apply(g r110) throws Exception {
        SpannableStringBuilder r100 = new SpannableStringBuilder(r110.f467817a);
        un5.d[] r111 = (un5.d[]) r100.getSpans(0, r100.length(), un5.d.class);
        int r101 = r111.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        un5.d r103 = r111[r102];
        r100.delete(r100.getSpanStart(r103), r100.getSpanEnd(r103));
        r102 = r102 + 1;
        goto L3
    L5:
        ArrayList r112 = new ArrayList();
        List r104 = Arrays.asList((zm5.d[]) r100.getSpans(0, r100.length(), zm5.d.class));
        Collections.sort(r104, new a(r100));
        ListIterator r105 = r104.listIterator();
    L7:
        if (r105.hasNext() == false) goto L33;
        zm5.d r106 = (zm5.d) r105.next();
        BaseSegment r107 = r106.getSegment();
        r107.setText(r100.subSequence(r100.getSpanStart(r106), r100.getSpanEnd(r106)).toString());
        if ((r107 instanceof TextLikeSegment) == false) goto L32;
        TextLikeSegment r108 = (TextLikeSegment) r107;
        ArrayList r109 = new ArrayList();
    L12:
        if (r105.hasNext() == false) goto L23;
        zm5.d r113 = (zm5.d) r105.next();
        if ((r113 instanceof j) == false) goto L22;
        int r114 = r100.getSpanStart(r113);
        int r115 = r100.getSpanEnd(r113);
        int r116 = r100.getSpanStart(r106);
        int r117 = r100.getSpanEnd(r106);
        if (r114 < r116) goto L19;
        if (r115 > r117) goto L19;
        boolean r118 = true;
    L20:
        if (r118 == false) goto L22;
        j r119 = (j) r113;
        TextSegment r120 = r119.f572875c;
        r120.setText(r100.subSequence(r100.getSpanStart(r119), r100.getSpanEnd(r119)).toString());
        r109.add(r120);
    L19:
        r118 = false;
    L22:
        r105.previous();
    L23:
        r108.setTexts(r109);
        if ((r108 instanceof HyperLinkSegment) == false) goto L32;
        HyperLinkSegment r121 = (HyperLinkSegment) r108;
        String r122 = r121.getText();
        Lazy r123 = LinkUtils.f239809a;
        Intrinsics.checkNotNullParameter(r122, "str");
        if (((Pattern) LinkUtils.f239811c.getValue()).matcher(StringsKt.trim(r122).toString()).matches() == false) goto L31;
        Uri r124 = UriProtector.parse(r121.getLink());
        if (UriProtector.parse(r122).getScheme() == null) goto L30;
        r121.setLink(r122);
        goto L31
    L30:
        r121.setLink(r124.getScheme() + "://" + r122);
    L31:
        tt5.a.b("SheetUnFormatFun", "handleHyperLinkSegment: link = " + r121.getLink());
    L32:
        r112.add(r107);
        goto L7
    L33:
        return r112;
    }
}
