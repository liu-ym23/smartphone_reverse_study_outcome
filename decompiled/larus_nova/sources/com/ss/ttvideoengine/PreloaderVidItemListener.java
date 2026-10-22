package com.ss.ttvideoengine;

import com.ss.ttvideoengine.model.VideoInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface PreloaderVidItemListener {
    String apiString(Map<String, String> r100, String r101, int r102);

    String authString(String r100, int r101);

    void onUsingUrlInfos(List<VideoInfo> r100);
}
