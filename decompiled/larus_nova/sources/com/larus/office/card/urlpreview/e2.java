package com.larus.office.card.urlpreview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class e2 {
    static {
    }

    public static d2 a(List r100, g1 r101) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        Intrinsics.checkNotNullParameter(r101, "isCached");
        List r102 = SequencesKt.toList(SequencesKt.distinct(SequencesKt.filter(CollectionsKt.asSequence(r100), OfficeUrlPreviewRequestPlanner$create$normalizedUrls$1.INSTANCE)));
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        Object r105 = r104.next();
        if (((Boolean) r101.invoke(r105)).booleanValue() == true) goto L4;
        r103.add(r105);
        goto L4
    L9:
        return new d2(r102, CollectionsKt.chunked(r103, 25));
    }
}
