package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import g85.b;
import g85.f;
import java.util.List;
import q75.a;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
public class SpecificCasePriorityAdjuster implements IPriorityAdjuster {
    private a mDriveConfig;
    private f mMimeTypeManager;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "SpecificCasePriorityAdjuster";
    }

    public SpecificCasePriorityAdjuster(f r100, a r101) {
        this.mMimeTypeManager = r100;
        this.mDriveConfig = r101;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r100, List<Integer> r101) {
        f r102 = this.mMimeTypeManager;
        b r103 = (b) r102;
        if (r103.m(r100.I()) == true) goto L5;
    L7:
        return r101;
    L5:
        if (r101.contains(0) == false) goto L7;
        r101.remove(0);
        goto L7
    }
}
