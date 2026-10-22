package com.bytedance.ee.bear.office.export.space;

import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {
    public static final OfficeSpaceAskDoubaoItem a(OfficeSpaceItem r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        return new OfficeSpaceAskDoubaoItem(r110.getToken(), r110.getObjType(), r110.getTitle(), r110.getUrl(), r110.getExtra().get(DrivePreviewOpenItem.EXTRA_FILE_EXT), r110.isFolder(), new LinkedHashMap(r110.getExtra()), r110.getRealType(), r110.getBaseBizType());
    }

    public static final OfficeSpaceAskDoubaoRequest b(OfficeSpaceItem r100, OfficeSpaceEventSource r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "source");
        OfficeSpaceAskDoubaoItem r102 = a(r100);
        List<OfficeSpaceItem> r103 = r100.getFileList();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L7;
        r104.add(a((OfficeSpaceItem) r105.next()));
        goto L4
    L7:
        return new OfficeSpaceAskDoubaoRequest(r102, r101, new ArrayList(r104));
    }
}
