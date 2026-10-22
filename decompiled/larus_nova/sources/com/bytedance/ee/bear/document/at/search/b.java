package com.bytedance.ee.bear.document.at.search;

import com.bytedance.lark.pb.search.v2.ExtraInfoBlock;
import com.bytedance.lark.pb.search.v2.ExtraInfoBlockSegment;
import com.ss.android.lark.search.dto.info.ExtraInfoSummary;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static final String a(SearchBaseInfo r100) {
        ExtraInfoSummary r101 = r100.getExtraInfoSummary();
        if (r101 == null) goto L18;
        ArrayList<ExtraInfoBlock> r102 = r101.getExtraInfoList();
        if (r102 == null) goto L18;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        List<ExtraInfoBlockSegment> r104 = ((ExtraInfoBlock) r103.next()).block_segments;
        if (r104 == null) goto L8;
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L8;
        ExtraInfoBlockSegment r106 = (ExtraInfoBlockSegment) r105.next();
        if (r106.type != ExtraInfoBlockSegment.SegmentTextType.TIMESTAMP) goto L13;
        String r107 = r106.text_highlighted;
        if (r107 == null) goto L18;
        return r107;
    L18:
        return "";
    }
}
