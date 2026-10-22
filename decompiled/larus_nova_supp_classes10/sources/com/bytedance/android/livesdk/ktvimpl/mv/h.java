package com.bytedance.android.livesdk.ktvimpl.mv;

import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.cache.CopyCacheListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements CopyCacheListener {
    public final /* synthetic */ Function1 a;

    public h(Function1 r1) {
        this.a = r1;
    }

    public final void onFileInfo(DataLoaderHelper.DataLoaderCacheInfo r1) {
        com.bytedance.android.live.ktv.common.util.g.d("onFileInfo");
    }

    public final void onCopyComplete(boolean r3, int r4, String r5) {
        this.a.invoke(Boolean.valueOf(r3));
        com.bytedance.android.live.ktv.common.util.g.d("exportVideo result：" + r3 + '-' + r4 + "---" + r5);
    }
}
