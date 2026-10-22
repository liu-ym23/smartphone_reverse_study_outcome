package com.bytedance.ee.bear.office.export.space;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final OfficeSpaceAskDoubaoItem a(OfficeSpaceItem r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        return new OfficeSpaceAskDoubaoItem(r11.getToken(), r11.getObjType(), r11.getTitle(), r11.getUrl(), r11.getExtra().get("file_ext"), r11.isFolder(), new LinkedHashMap(r11.getExtra()), r11.getRealType(), r11.getBaseBizType());
    }

    public static final OfficeSpaceAskDoubaoRequest b(OfficeSpaceItem r3, OfficeSpaceEventSource r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "source");
        OfficeSpaceAskDoubaoItem r0 = a(r3);
        List<OfficeSpaceItem> r5 = r3.getFileList();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r1.add(a((OfficeSpaceItem) r6.next()));
        goto L4
    L7:
        return new OfficeSpaceAskDoubaoRequest(r0, r4, new ArrayList(r1));
    }
}
