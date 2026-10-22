package com.ss.ttvideoengine.cache;

import com.ss.ttvideoengine.DataLoaderHelper;

/* JADX INFO: loaded from: classes34.dex */
public interface CopyCacheListener {

    /* JADX INFO: renamed from: com.ss.ttvideoengine.cache.CopyCacheListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFileInfo(CopyCacheListener r100, DataLoaderHelper.DataLoaderCacheInfo r101) {
        }
    }

    void onCopyComplete(boolean r100, int r101, String r102);

    void onFileInfo(DataLoaderHelper.DataLoaderCacheInfo r100);
}
