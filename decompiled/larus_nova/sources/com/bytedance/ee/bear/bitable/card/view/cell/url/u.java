package com.bytedance.ee.bear.bitable.card.view.cell.url;

import android.text.SpannableStringBuilder;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class u extends db5.l {
    public u() {
    }

    @Override // db5.l
    public final List<db5.j> d(SpannableStringBuilder r100, un5.h[] r110) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r110, "hyperLinkSpans");
        LinkedList r101 = new LinkedList();
        int r102 = r110.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L13;
        un5.h r104 = r110[r103];
        int r105 = r100.getSpanStart(r104);
        int r106 = r100.getSpanEnd(r104);
        if (r105 == r106) goto L12;
        String r107 = r100.subSequence(r105, r106).toString();
        if ((r104 instanceof s) == false) goto L10;
        Cloneable r108 = new r(r105, r106, r107, ((s) r104).f208349e);
    L11:
        r101.add(r108);
        goto L12
    L10:
        r108 = new db5.j(r105, r106, r107, r104.f550805d);
    L12:
        r103 = r103 + 1;
        goto L3
    L13:
        return r101;
    }
}
