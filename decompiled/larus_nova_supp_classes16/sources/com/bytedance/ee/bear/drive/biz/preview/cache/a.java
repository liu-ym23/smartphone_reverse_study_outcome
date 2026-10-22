package com.bytedance.ee.bear.drive.biz.preview.cache;

import com.bytedance.ee.bear.drive.preload.n;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements IPreLoaderItemCallBackListener {
    public final /* synthetic */ DrivePreloadVideoCachePlugin a;
    public final /* synthetic */ w75.a b;

    public a(DrivePreloadVideoCachePlugin r1, w75.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void preloadItemInfo(PreLoaderItemCallBackInfo r3) {
        if (r3 == null) goto L9;
        tt5.a.h("DrivePreloadVideoCachePlugin", "preloadItemInfo key=" + r3.getKey());
        if (r3.getKey() != 2) goto L10;
        n r4 = DrivePreloadVideoCachePlugin.access$getMDriveVideoCacheManager$p(this.a);
        if (r4 == null) goto L11;
        w75.a r0 = this.b;
        r4.e((f85.a) r0, ((f85.a.C0229a) ((f85.a) r0).a).a);
        return;
    L11:
        return;
    L10:
        return;
    }
}
