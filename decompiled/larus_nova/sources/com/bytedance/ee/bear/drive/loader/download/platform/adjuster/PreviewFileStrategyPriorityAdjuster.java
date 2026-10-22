package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloadStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tt5.a;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
public class PreviewFileStrategyPriorityAdjuster implements IPriorityAdjuster {
    private static final String TAG = "DrivePlatform_PreviewFileStrategyAdjuster";
    private IDownloadStrategy mDownloadStrategy;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "PreviewFileStrategyPriorityAdjuster";
    }

    public PreviewFileStrategyPriorityAdjuster(IDownloadStrategy r100) {
        this.mDownloadStrategy = r100;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r100, List<Integer> r101) {
        boolean r102 = this.mDownloadStrategy.enableStreaming();
        a.h(TAG, "before PreviewFileStrategyAdjuster isEnableStreaming=" + r102);
        if ((r101 instanceof ArrayList) == true) goto L5;
        r101 = new ArrayList(r101);
    L5:
        Iterator<Integer> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L17;
        int r104 = r103.next().intValue();
        if (r102 == true) goto L7;
        if (r104 == 3) goto L16;
        if (r104 == 11) goto L16;
        if (r104 != 12) goto L7;
    L16:
        r103.remove();
        goto L7
    L17:
        return r101;
    }
}
