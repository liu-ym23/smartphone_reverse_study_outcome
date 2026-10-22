package com.bytedance.ee.bear.drive.biz.preview.cache;

import com.bytedance.ee.bear.drive.preload.n;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements IPreLoaderItemCallBackListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrivePreloadVideoCachePlugin f223287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w75.a f223288b;

    public a(DrivePreloadVideoCachePlugin r100, w75.a r101) {
        this.f223287a = r100;
        this.f223288b = r101;
    }

    @Override // com.ss.ttvideoengine.IPreLoaderItemCallBackListener
    public final void preloadItemInfo(PreLoaderItemCallBackInfo r100) {
        if (r100 == null) goto L9;
        tt5.a.h("DrivePreloadVideoCachePlugin", "preloadItemInfo key=" + r100.getKey());
        if (r100.getKey() != 2) goto L10;
        n r101 = DrivePreloadVideoCachePlugin.access$getMDriveVideoCacheManager$p(this.f223287a);
        if (r101 == null) goto L11;
        w75.a r102 = this.f223288b;
        r101.e((f85.a) r102, ((f85.a.C5868a) ((f85.a) r102).f558532a).f558557a);
        return;
    L11:
        return;
    L10:
        return;
    }
}
