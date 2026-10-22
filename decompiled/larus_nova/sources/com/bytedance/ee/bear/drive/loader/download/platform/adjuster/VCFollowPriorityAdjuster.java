package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import i75.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
public class VCFollowPriorityAdjuster implements IPriorityAdjuster {
    private static final String TAG = "DrivePlatform_FeatureGatingAdjuster";

    public VCFollowPriorityAdjuster() {
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "VCFollowPriorityAdjuster";
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r100, List<Integer> r101) {
        if ((r101 instanceof ArrayList) == true) goto L6;
        r101 = new ArrayList(r101);
    L6:
        if (h.i(r100.I()) == false) goto L8;
        r101.remove(-2);
    L8:
        Iterator<Integer> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        if (r102.next().intValue() != 8) goto L10;
        r102.remove();
        goto L10
    L14:
        return r101;
    }
}
