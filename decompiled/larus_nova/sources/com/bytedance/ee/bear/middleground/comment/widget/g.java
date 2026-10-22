package com.bytedance.ee.bear.middleground.comment.widget;

import android.text.SpannableStringBuilder;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends db5.l {
    public g() {
    }

    @Override // db5.l
    public final List<db5.j> d(SpannableStringBuilder r110, un5.h[] r111) {
        Intrinsics.checkNotNullParameter(r110, "content");
        Intrinsics.checkNotNullParameter(r111, "hyperLinkSpans");
        LinkedList r100 = new LinkedList();
        int r101 = r111.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L12;
        un5.h r103 = r111[r102];
        if ((r103 instanceof un5.k) == false) goto L11;
        int r104 = r110.getSpanStart(r103);
        int r105 = r110.getSpanEnd(r103);
        if (r104 == r105) goto L11;
        r100.add(new db5.j(r104, r105, r110.subSequence(r104, r105).toString(), StringsKt.replace$default(r103.f550805d, " ", "", false, 4, null)));
    L11:
        r102 = r102 + 1;
        goto L3
    L12:
        return r100;
    }
}
