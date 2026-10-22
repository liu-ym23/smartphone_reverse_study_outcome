package com.bytedance.ee.bear.drive.loader.download.platform;

import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster;
import g85.b;
import g85.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class AdjusterExecutor {
    private static final String TAG = "DrivePlatform_AdjustExecutor";
    private AdjusterProvider mAdjusterProvider;
    private IResourceHolder mResourceHolder;

    private void log(e r1) {
    }

    public AdjusterExecutor(IResourceHolder r2) {
        this.mResourceHolder = r2;
        this.mAdjusterProvider = new AdjusterProvider(r2);
    }

    public void addCustomizationAdjuster(IPriorityAdjuster r2) {
        AdjusterProvider r0 = this.mAdjusterProvider;
        if (r0 == null) goto L6;
        r0.addCustomizationAdjuster(r2);
        return;
    }

    public void execManualCacheAdjust(c r2) {
        execAdjustInternal(r2, this.mAdjusterProvider.provideManualCacheAdjusters(r2));
    }

    public void execPreloadAdjust(c r2) {
        execAdjustInternal(r2, this.mAdjusterProvider.providePreloadAdjusters(r2));
    }

    public void execPreviewAdjust(c r2) {
        execAdjustInternal(r2, this.mAdjusterProvider.providePreviewAdjusters(r2));
    }

    private void execAdjustInternal(c r7, List<IPriorityAdjuster> r8) {
        e r0 = ((b) this.mResourceHolder.getMimeTypeManager()).b(r7.I(), r7.r());
        log(r0);
        List<Integer> r1 = new ArrayList(r0.e);
        Iterator<IPriorityAdjuster> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        IPriorityAdjuster r2 = r9.next();
        tt5.a.h(TAG, r2.getName() + " start adjust priority, now the priority: " + Arrays.toString(r1.toArray(new Integer[0])));
        r1 = r2.adjust(r7, r1);
        tt5.a.h(TAG, r2.getName() + " finish adjust priority, now the priority: " + Arrays.toString(r1.toArray(new Integer[0])));
        goto L4
    L6:
        tt5.a.h(TAG, "===> all adjuster execute completed,  final priority: " + Arrays.toString(r1.toArray(new Integer[0])));
        r7.D(r1);
    }
}
