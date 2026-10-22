package com.bytedance.ee.bear.drive.preload;

import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;

/* JADX INFO: loaded from: classes16.dex */
public final class o implements IPreLoaderItemCallBackListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f85.a f224553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f224554b;

    @Override // com.ss.ttvideoengine.IPreLoaderItemCallBackListener
    public final void preloadItemInfo(PreLoaderItemCallBackInfo r100) {
        if (r100 == null) goto L7;
        tt5.a.h("DrivePreloadExecutor", "preloadItemInfo key=" + r100.getKey());
        if (r100.getKey() != 2) goto L8;
        n r101 = this.f224554b.f224556b;
        f85.a r102 = this.f224553a;
        r101.e(r102, ((f85.a.C5868a) r102.f558532a).f558557a);
        return;
    L8:
        return;
    }

    public o(p r100, f85.a r101) {
        this.f224554b = r100;
        this.f224553a = r101;
    }
}
