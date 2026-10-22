package com.bytedance.ee.bear.drive.preload;

import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o implements IPreLoaderItemCallBackListener {
    public final /* synthetic */ f85.a a;
    public final /* synthetic */ p b;

    public final void preloadItemInfo(PreLoaderItemCallBackInfo r3) {
        if (r3 == null) goto L7;
        tt5.a.h("DrivePreloadExecutor", "preloadItemInfo key=" + r3.getKey());
        if (r3.getKey() != 2) goto L8;
        n r4 = this.b.b;
        f85.a r0 = this.a;
        r4.e(r0, ((f85.a.C0229a) r0.a).a);
        return;
    L8:
        return;
    }

    public o(p r1, f85.a r2) {
        this.b = r1;
        this.a = r2;
    }
}
