package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.PlayerError;
import com.ss.bytertc.engine.data.PlayerEvent;
import com.ss.bytertc.engine.data.PlayerState;

/* JADX INFO: loaded from: classes40.dex */
public interface IMediaPlayerEventHandler {
    void onMediaPlayerEvent(int r100, PlayerEvent r101, String r102);

    void onMediaPlayerPlayingProgress(int r100, long r101);

    void onMediaPlayerStateChanged(int r100, PlayerState r101, PlayerError r102);
}
