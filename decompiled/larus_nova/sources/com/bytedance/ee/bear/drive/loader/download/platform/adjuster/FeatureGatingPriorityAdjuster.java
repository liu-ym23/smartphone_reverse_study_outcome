package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import java.util.List;
import q75.a;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
public class FeatureGatingPriorityAdjuster implements IPriorityAdjuster {
    private static final String TAG = "DrivePlatform_FeatureGatingAdjuster";
    private a mDriveConfig;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r100, List<Integer> r101) {
        return r101;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "FeatureGatingPriorityAdjuster";
    }

    public FeatureGatingPriorityAdjuster(a r100) {
        this.mDriveConfig = r100;
    }
}
