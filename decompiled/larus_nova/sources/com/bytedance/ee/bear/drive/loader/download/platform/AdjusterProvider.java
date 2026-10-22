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

/* JADX INFO: loaded from: classes16.dex */
class AdjusterProvider {
    private List<IPriorityAdjuster> mCustomizationAdjuster;
    private IResourceHolder mResourceHolder;

    public AdjusterProvider(IResourceHolder r100) {
        this.mCustomizationAdjuster = new ArrayList();
        this.mResourceHolder = r100;
    }

    public void addCustomizationAdjuster(IPriorityAdjuster r100) {
        this.mCustomizationAdjuster.add(r100);
    }

    public List<IPriorityAdjuster> provideManualCacheAdjusters(c r100) {
        ArrayList r101 = new ArrayList();
        r101.addAll(providePreviewAdjusters(r100));
        r101.add(new ManualCacheFileStrategyPriorityAdjuster());
        r101.addAll(this.mCustomizationAdjuster);
        return r101;
    }

    public List<IPriorityAdjuster> providePreloadAdjusters(c r100) {
        return providePreviewAdjusters(r100);
    }

    public List<IPriorityAdjuster> providePreviewAdjusters(c r100) {
        ArrayList r101 = new ArrayList(Arrays.asList(new IPriorityAdjuster[]{new ServerSupportPriorityAdjuster(r100.E()), new FeatureGatingPriorityAdjuster(this.mResourceHolder.getDriveConfig()), new PreviewFileStrategyPriorityAdjuster(this.mResourceHolder.getDownloadStrategy()), new SpecificCasePriorityAdjuster(this.mResourceHolder.getMimeTypeManager(), this.mResourceHolder.getDriveConfig()), new ImageThumbPriorityAdjuster(this.mResourceHolder.getMimeTypeManager(), this.mResourceHolder.getDriveConfig()), new OfficeSupportPriorityAdjuster(this.mResourceHolder.getMimeTypeManager(), this.mResourceHolder.getDriveConfig())}));
        r101.addAll(this.mCustomizationAdjuster);
        return r101;
    }
}
