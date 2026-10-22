package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import g85.b;
import g85.f;
import java.util.List;
import q75.a;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SpecificCasePriorityAdjuster implements IPriorityAdjuster {
    private a mDriveConfig;
    private f mMimeTypeManager;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "SpecificCasePriorityAdjuster";
    }

    public SpecificCasePriorityAdjuster(f r1, a r2) {
        this.mMimeTypeManager = r1;
        this.mDriveConfig = r2;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r2, List<Integer> r3) {
        f r0 = this.mMimeTypeManager;
        b r1 = (b) r0;
        if (r1.m(r2.I()) == true) goto L5;
    L7:
        return r3;
    L5:
        if (r3.contains(0) == false) goto L7;
        r3.remove(0);
        goto L7
    }
}
