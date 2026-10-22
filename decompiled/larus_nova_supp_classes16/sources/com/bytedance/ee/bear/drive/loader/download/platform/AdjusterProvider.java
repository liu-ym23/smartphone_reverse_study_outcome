package com.bytedance.ee.bear.drive.loader.download.platform;

import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.FeatureGatingPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.ImageThumbPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.ManualCacheFileStrategyPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.OfficeSupportPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.PreviewFileStrategyPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.ServerSupportPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.SpecificCasePriorityAdjuster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class AdjusterProvider {
    private List<IPriorityAdjuster> mCustomizationAdjuster;
    private IResourceHolder mResourceHolder;

    public AdjusterProvider(IResourceHolder r2) {
        this.mCustomizationAdjuster = new ArrayList();
        this.mResourceHolder = r2;
    }

    public void addCustomizationAdjuster(IPriorityAdjuster r2) {
        this.mCustomizationAdjuster.add(r2);
    }

    public List<IPriorityAdjuster> provideManualCacheAdjusters(c r2) {
        ArrayList r0 = new ArrayList();
        r0.addAll(providePreviewAdjusters(r2));
        r0.add(new ManualCacheFileStrategyPriorityAdjuster());
        r0.addAll(this.mCustomizationAdjuster);
        return r0;
    }

    public List<IPriorityAdjuster> providePreloadAdjusters(c r1) {
        return providePreviewAdjusters(r1);
    }

    public List<IPriorityAdjuster> providePreviewAdjusters(c r5) {
        ArrayList r0 = new ArrayList(Arrays.asList(new IPriorityAdjuster[]{new ServerSupportPriorityAdjuster(r5.E()), new FeatureGatingPriorityAdjuster(this.mResourceHolder.getDriveConfig()), new PreviewFileStrategyPriorityAdjuster(this.mResourceHolder.getDownloadStrategy()), new SpecificCasePriorityAdjuster(this.mResourceHolder.getMimeTypeManager(), this.mResourceHolder.getDriveConfig()), new ImageThumbPriorityAdjuster(this.mResourceHolder.getMimeTypeManager(), this.mResourceHolder.getDriveConfig()), new OfficeSupportPriorityAdjuster(this.mResourceHolder.getMimeTypeManager(), this.mResourceHolder.getDriveConfig())}));
        r0.addAll(this.mCustomizationAdjuster);
        return r0;
    }
}
