package xm5;

import android.text.SpannableStringBuilder;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.HyperLinkSegment;
import db5.j;
import db5.l;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import un5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends l {
    public c() {
    }

    public final List<j> d(SpannableStringBuilder r17, h[] r18) {
        Intrinsics.checkNotNullParameter(r17, "content");
        Intrinsics.checkNotNullParameter(r18, "hyperLinkSpans");
        LinkedList r2 = new LinkedList();
        int r3 = r18.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L16;
        h r5 = r18[r4];
        if ((r5 instanceof zm5.f) == false) goto L11;
        SegmentT r6 = ((zm5.f) r5).g;
        if ((r6 instanceof HyperLinkSegment) == false) goto L11;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.bytedance.ee.bear.sheet.inputbar.at.segment.HyperLinkSegment");
        if (((HyperLinkSegment) r6).getCellPosition() == null) goto L11;
    L15:
        r4 = r4 + 1;
    L11:
        int r7 = r17.getSpanStart(r5);
        int r8 = r17.getSpanEnd(r5);
        if (r7 == r8) goto L15;
        r2.add(new j(r7, r8, r17.subSequence(r7, r8).toString(), StringsKt.replace$default(r5.d, " ", "", false, 4, null)));
        goto L15
    L16:
        return r2;
    }
}
