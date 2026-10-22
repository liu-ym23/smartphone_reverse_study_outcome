package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.IMediaPlayerAudioFrameObserver;
import com.ss.bytertc.engine.IMediaPlayerEventHandler;
import com.ss.bytertc.engine.data.AudioMixingDualMonoMode;
import com.ss.bytertc.engine.data.AudioMixingType;
import com.ss.bytertc.engine.data.MediaPlayerConfig;
import com.ss.bytertc.engine.data.MediaPlayerCustomSource;
import com.ss.bytertc.engine.data.PlayerState;
import com.ss.bytertc.engine.utils.AudioFrame;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IMediaPlayer {
    public IMediaPlayer() {
    }

    public abstract int getAudioTrackCount();

    public abstract int getPlaybackDuration();

    public abstract int getPosition();

    public abstract PlayerState getState();

    public abstract int getTotalDuration();

    public abstract int getVolume(AudioMixingType r100);

    public abstract int open(String r100, MediaPlayerConfig r101);

    public abstract int openWithCustomSource(MediaPlayerCustomSource r100, MediaPlayerConfig r101);

    public abstract int pause();

    public abstract int pushExternalAudioFrame(AudioFrame r100);

    public abstract int registerAudioFrameObserver(IMediaPlayerAudioFrameObserver r100);

    public abstract int resume();

    public abstract int selectAudioTrack(int r100);

    public abstract int setAudioDualMonoMode(AudioMixingDualMonoMode r100);

    public abstract int setAudioPitch(int r100);

    public abstract int setEventHandler(IMediaPlayerEventHandler r100);

    public abstract int setLoudness(float r100);

    public abstract int setPlaybackSpeed(int r100);

    public abstract int setPosition(int r100);

    public abstract int setProgressInterval(long r100);

    public abstract int setVolume(int r100, AudioMixingType r101);

    public abstract int start();

    public abstract int stop();
}
