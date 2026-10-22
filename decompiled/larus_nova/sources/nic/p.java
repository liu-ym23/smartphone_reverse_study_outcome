package nic;

import android.content.Context;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.model.VideoInfo;

/* JADX INFO: loaded from: classes40.dex */
public interface p {
    PlaybackParams a();

    VideoInfo b();

    VideoEngineInfos c(String r100);

    long d();

    TTVideoEngine f();

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    Resolution getResolution();

    boolean isPlaying();
}
