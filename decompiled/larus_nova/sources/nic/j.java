package nic;

import com.bytedance.common.utility.NetworkUtils;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;

/* JADX INFO: loaded from: classes40.dex */
public interface j {
    boolean interceptPlay(NetworkUtils.NetworkType r100);

    boolean interceptPlayWhenVideoInfoReady(VideoRef r100);

    VideoInfo selectVideoInfoToPlay(VideoModel r100);

    VideoInfo selectVideoInfoToPlay(VideoRef r100);
}
