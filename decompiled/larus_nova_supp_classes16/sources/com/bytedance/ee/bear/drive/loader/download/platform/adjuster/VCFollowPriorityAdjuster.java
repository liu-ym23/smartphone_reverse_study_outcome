package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import i75.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VCFollowPriorityAdjuster implements IPriorityAdjuster {
    private static final String TAG = "DrivePlatform_FeatureGatingAdjuster";

    public VCFollowPriorityAdjuster() {
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "VCFollowPriorityAdjuster";
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r3, List<Integer> r4) {
        if ((r4 instanceof ArrayList) == true) goto L6;
        r4 = new ArrayList(r4);
    L6:
        if (h.i(r3.I()) == false) goto L8;
        r4.remove(-2);
    L8:
        Iterator<Integer> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        if (r5.next().intValue() != 8) goto L10;
        r5.remove();
        goto L10
    L14:
        return r4;
    }
}
