package com.bytedance.ee.bear.middleground.comment.widget;

import android.text.SpannableStringBuilder;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends db5.l {
    public g() {
    }

    public final List<db5.j> d(SpannableStringBuilder r17, un5.h[] r18) {
        Intrinsics.checkNotNullParameter(r17, "content");
        Intrinsics.checkNotNullParameter(r18, "hyperLinkSpans");
        LinkedList r2 = new LinkedList();
        int r3 = r18.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L12;
        un5.h r5 = r18[r4];
        if ((r5 instanceof un5.k) == false) goto L11;
        int r6 = r17.getSpanStart(r5);
        int r7 = r17.getSpanEnd(r5);
        if (r6 == r7) goto L11;
        r2.add(new db5.j(r6, r7, r17.subSequence(r6, r7).toString(), StringsKt.replace$default(r5.d, " ", "", false, 4, null)));
    L11:
        r4 = r4 + 1;
        goto L3
    L12:
        return r2;
    }
}
