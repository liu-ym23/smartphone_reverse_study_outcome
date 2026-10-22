package com.bytedance.ee.bear.document.at.search;

import com.bytedance.lark.pb.search.v2.ExtraInfoBlock;
import com.bytedance.lark.pb.search.v2.ExtraInfoBlockSegment;
import com.ss.android.lark.search.dto.info.ExtraInfoSummary;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final String a(SearchBaseInfo r4) {
        ExtraInfoSummary r5 = r4.getExtraInfoSummary();
        if (r5 == null) goto L18;
        ArrayList r6 = r5.getExtraInfoList();
        if (r6 == null) goto L18;
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L18;
        List r0 = ((ExtraInfoBlock) r7.next()).block_segments;
        if (r0 == null) goto L8;
        Iterator r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L8;
        ExtraInfoBlockSegment r2 = (ExtraInfoBlockSegment) r1.next();
        if (r2.type != ExtraInfoBlockSegment.SegmentTextType.TIMESTAMP) goto L13;
        String r8 = r2.text_highlighted;
        if (r8 == null) goto L18;
        return r8;
    L18:
        return "";
    }
}
