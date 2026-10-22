package com.bytedance.ee.bear.drive.loader.download.platform;

import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster;
import g85.b;
import g85.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
class AdjusterExecutor {
    private static final String TAG = "DrivePlatform_AdjustExecutor";
    private AdjusterProvider mAdjusterProvider;
    private IResourceHolder mResourceHolder;

    private void log(e r100) {
    }

    public AdjusterExecutor(IResourceHolder r100) {
        this.mResourceHolder = r100;
        this.mAdjusterProvider = new AdjusterProvider(r100);
    }

    public void addCustomizationAdjuster(IPriorityAdjuster r100) {
        AdjusterProvider r101 = this.mAdjusterProvider;
        if (r101 == null) goto L6;
        r101.addCustomizationAdjuster(r100);
        return;
    }

    public void execManualCacheAdjust(c r100) {
        execAdjustInternal(r100, this.mAdjusterProvider.provideManualCacheAdjusters(r100));
    }

    public void execPreloadAdjust(c r100) {
        execAdjustInternal(r100, this.mAdjusterProvider.providePreloadAdjusters(r100));
    }

    public void execPreviewAdjust(c r100) {
        execAdjustInternal(r100, this.mAdjusterProvider.providePreviewAdjusters(r100));
    }

    private void execAdjustInternal(c r100, List<IPriorityAdjuster> r101) {
        e r102 = ((b) this.mResourceHolder.getMimeTypeManager()).b(r100.I(), r100.r());
        log(r102);
        List<Integer> r103 = new ArrayList(r102.f480399e);
        Iterator<IPriorityAdjuster> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        IPriorityAdjuster r105 = r104.next();
        tt5.a.h(TAG, r105.getName() + " start adjust priority, now the priority: " + Arrays.toString(r103.toArray(new Integer[0])));
        r103 = r105.adjust(r100, r103);
        tt5.a.h(TAG, r105.getName() + " finish adjust priority, now the priority: " + Arrays.toString(r103.toArray(new Integer[0])));
        goto L4
    L6:
        tt5.a.h(TAG, "===> all adjuster execute completed,  final priority: " + Arrays.toString(r103.toArray(new Integer[0])));
        r100.D(r103);
    }
}
