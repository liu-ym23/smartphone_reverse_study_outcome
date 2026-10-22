package com.bytedance.awemeopen.infra.plugs.ttvideoengine;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;
import com.ss.ttvideoengine.model.VideoInfo;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements IPreLoaderItemCallBackListener {
    public e() {
    }

    @Override // com.ss.ttvideoengine.IPreLoaderItemCallBackListener
    public final void preloadItemInfo(PreLoaderItemCallBackInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.getKey();
        if (r100.getKey() != 1) goto L12;
        List<VideoInfo> r101 = r100.usingUrlInfos;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.size() <= 0) goto L14;
        VideoInfo r102 = (VideoInfo) ListProtector.get(r101, 0);
        r102.getValueStr(15);
        r102.getResolution();
        return;
    L14:
        return;
    }
}
