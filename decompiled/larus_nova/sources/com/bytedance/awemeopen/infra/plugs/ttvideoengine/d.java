package com.bytedance.awemeopen.infra.plugs.ttvideoengine;

import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements IPreLoaderItemCallBackListener {
    public d() {
    }

    @Override // com.ss.ttvideoengine.IPreLoaderItemCallBackListener
    public final void preloadItemInfo(PreLoaderItemCallBackInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.getKey();
    }
}
