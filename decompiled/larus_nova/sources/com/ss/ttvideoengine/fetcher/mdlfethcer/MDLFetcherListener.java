package com.ss.ttvideoengine.fetcher.mdlfethcer;

import android.content.Context;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;

/* JADX INFO: loaded from: classes34.dex */
public interface MDLFetcherListener {
    Context getContext();

    String getFallbackApi();

    String getId();

    VideoModel getOldVideoModel();

    void onCompletion(VideoModel r100, boolean r101, String r102);

    void onError(Error r100, String r101);

    void onLog(String r100);

    void onRetry(Error r100);
}
