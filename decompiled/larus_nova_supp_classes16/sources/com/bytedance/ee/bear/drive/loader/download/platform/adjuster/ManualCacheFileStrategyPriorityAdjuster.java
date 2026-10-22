package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ManualCacheFileStrategyPriorityAdjuster implements IPriorityAdjuster {
    public ManualCacheFileStrategyPriorityAdjuster() {
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "ManualCacheFileStrategyPriorityAdjuster";
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r3, List<Integer> r4) {
        if ((r4 instanceof ArrayList) == true) goto L5;
        r4 = new ArrayList(r4);
    L5:
        Iterator<Integer> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L20;
        int r0 = r5.next().intValue();
        if (r0 == (-1)) goto L18;
        if (r0 == (-3)) goto L18;
        if (r0 == 13) goto L18;
        if (r0 == 17) goto L18;
        if (r0 != 21) goto L7;
    L18:
        r5.remove();
        goto L7
    L20:
        if (r4.contains(-2) == true) goto L22;
        r4.add(-2);
    L22:
        return r4;
    }
}
