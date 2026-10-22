package com.ss.bytertc.ktv;

import com.ss.bytertc.ktv.data.AudioPlayType;
import com.ss.bytertc.ktv.data.AudioTrackType;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IKTVPlayer {
    public IKTVPlayer() {
    }

    public abstract void pauseMusic(String r100);

    public abstract void playMusic(String r100, AudioTrackType r101, AudioPlayType r102);

    public abstract void resumeMusic(String r100);

    public abstract void seekMusic(String r100, int r101);

    public abstract void setMusicPitch(String r100, int r101);

    public abstract void setMusicVolume(String r100, int r101);

    public abstract void setPlayerEventHandler(IKTVPlayerEventHandler r100);

    public abstract void stopMusic(String r100);

    public abstract void switchAudioTrackType(String r100);
}
