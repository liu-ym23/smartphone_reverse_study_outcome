package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import g85.f;
import i75.h;
import java.util.List;
import q75.a;
import w55.n;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
public class OfficeSupportPriorityAdjuster implements IPriorityAdjuster {
    private static final String TAG = "DrivePlatform_OfficeSupportAdjuster";
    private a mDriveConfig;
    private f mMimeTypeManager;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "OfficeSupportPriorityAdjuster";
    }

    public OfficeSupportPriorityAdjuster(f r100, a r101) {
        this.mMimeTypeManager = r100;
        this.mDriveConfig = r101;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r100, List<Integer> r101) {
        boolean r102 = n.k(this.mDriveConfig);
        boolean r103 = n.h(this.mDriveConfig);
        boolean r104 = n.i(this.mDriveConfig);
        tt5.a.h(TAG, "enableTTWord: " + r102 + ", enableTTExcel: " + r103 + ", enableTTPPT: " + r104);
        if (h.h(r100.I()) == true) goto L22;
        if (h.f(r100.I()) == true) goto L22;
        if (h.g(r100.I()) == false) goto L15;
        if (r101.contains(-2) == false) goto L25;
        r101.remove(-2);
        if (r102 == false) goto L25;
        ListProtector.add(r101, 0, -2);
    L25:
        return r101;
    L15:
        if (h.j(r100.I()) == false) goto L25;
        if (r101.contains(-2) == false) goto L25;
        r101.remove(-2);
        if (r104 == false) goto L25;
        ListProtector.add(r101, 0, -2);
    L22:
        if (r101.contains(-2) == false) goto L25;
        if (r103 == true) goto L25;
        r101.remove(-2);
        goto L25
    }
}
