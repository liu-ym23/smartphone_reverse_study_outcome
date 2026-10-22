package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloadStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tt5.a;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PreviewFileStrategyPriorityAdjuster implements IPriorityAdjuster {
    private static final String TAG = "DrivePlatform_PreviewFileStrategyAdjuster";
    private IDownloadStrategy mDownloadStrategy;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "PreviewFileStrategyPriorityAdjuster";
    }

    public PreviewFileStrategyPriorityAdjuster(IDownloadStrategy r1) {
        this.mDownloadStrategy = r1;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r4, List<Integer> r5) {
        boolean r6 = this.mDownloadStrategy.enableStreaming();
        a.h(TAG, "before PreviewFileStrategyAdjuster isEnableStreaming=" + r6);
        if ((r5 instanceof ArrayList) == true) goto L5;
        r5 = new ArrayList(r5);
    L5:
        Iterator<Integer> r0 = r5.iterator();
    L7:
        if (r0.hasNext() == false) goto L17;
        int r1 = r0.next().intValue();
        if (r6 == true) goto L7;
        if (r1 == 3) goto L16;
        if (r1 == 11) goto L16;
        if (r1 != 12) goto L7;
    L16:
        r0.remove();
        goto L7
    L17:
        return r5;
    }
}
