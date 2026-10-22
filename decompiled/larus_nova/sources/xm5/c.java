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

/* JADX INFO: loaded from: classes18.dex */
public final class c extends l {
    public c() {
    }

    @Override // db5.l
    public final List<j> d(SpannableStringBuilder r110, h[] r111) {
        Intrinsics.checkNotNullParameter(r110, "content");
        Intrinsics.checkNotNullParameter(r111, "hyperLinkSpans");
        LinkedList r100 = new LinkedList();
        int r101 = r111.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L16;
        h r103 = r111[r102];
        if ((r103 instanceof zm5.f) == false) goto L11;
        SegmentT r104 = ((zm5.f) r103).f572871g;
        if ((r104 instanceof HyperLinkSegment) == false) goto L11;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.sheet.inputbar.at.segment.HyperLinkSegment");
        if (((HyperLinkSegment) r104).getCellPosition() == null) goto L11;
    L15:
        r102 = r102 + 1;
    L11:
        int r105 = r110.getSpanStart(r103);
        int r106 = r110.getSpanEnd(r103);
        if (r105 == r106) goto L15;
        r100.add(new j(r105, r106, r110.subSequence(r105, r106).toString(), StringsKt.replace$default(r103.f550805d, " ", "", false, 4, null)));
        goto L15
    L16:
        return r100;
    }
}
