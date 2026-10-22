package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
public class ManualCacheFileStrategyPriorityAdjuster implements IPriorityAdjuster {
    public ManualCacheFileStrategyPriorityAdjuster() {
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "ManualCacheFileStrategyPriorityAdjuster";
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r100, List<Integer> r101) {
        if ((r101 instanceof ArrayList) == true) goto L5;
        r101 = new ArrayList(r101);
    L5:
        Iterator<Integer> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L20;
        int r103 = r102.next().intValue();
        if (r103 == (-1)) goto L18;
        if (r103 == (-3)) goto L18;
        if (r103 == 13) goto L18;
        if (r103 == 17) goto L18;
        if (r103 != 21) goto L7;
    L18:
        r102.remove();
        goto L7
    L20:
        if (r101.contains(-2) == true) goto L22;
        r101.add(-2);
    L22:
        return r101;
    }
}
