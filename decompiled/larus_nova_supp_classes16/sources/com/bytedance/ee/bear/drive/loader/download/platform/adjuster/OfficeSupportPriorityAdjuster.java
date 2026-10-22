package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import g85.f;
import i75.h;
import java.util.List;
import q75.a;
import w55.n;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeSupportPriorityAdjuster implements IPriorityAdjuster {
    private static final String TAG = "DrivePlatform_OfficeSupportAdjuster";
    private a mDriveConfig;
    private f mMimeTypeManager;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "OfficeSupportPriorityAdjuster";
    }

    public OfficeSupportPriorityAdjuster(f r1, a r2) {
        this.mMimeTypeManager = r1;
        this.mDriveConfig = r2;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r6, List<Integer> r7) {
        boolean r0 = n.k(this.mDriveConfig);
        boolean r1 = n.h(this.mDriveConfig);
        boolean r2 = n.i(this.mDriveConfig);
        tt5.a.h(TAG, "enableTTWord: " + r0 + ", enableTTExcel: " + r1 + ", enableTTPPT: " + r2);
        if (h.h(r6.I()) == true) goto L22;
        if (h.f(r6.I()) == true) goto L22;
        if (h.g(r6.I()) == false) goto L15;
        if (r7.contains(-2) == false) goto L25;
        r7.remove(-2);
        if (r0 == false) goto L25;
        ListProtector.add(r7, 0, -2);
    L25:
        return r7;
    L15:
        if (h.j(r6.I()) == false) goto L25;
        if (r7.contains(-2) == false) goto L25;
        r7.remove(-2);
        if (r2 == false) goto L25;
        ListProtector.add(r7, 0, -2);
    L22:
        if (r7.contains(-2) == false) goto L25;
        if (r1 == true) goto L25;
        r7.remove(-2);
        goto L25
    }
}
