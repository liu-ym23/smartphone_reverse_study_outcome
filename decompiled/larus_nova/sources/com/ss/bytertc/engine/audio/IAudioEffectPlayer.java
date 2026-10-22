package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.IAudioEffectPlayerEventHandler;
import com.ss.bytertc.engine.data.AudioEffectPlayerConfig;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IAudioEffectPlayer {
    public IAudioEffectPlayer() {
    }

    public abstract int getDuration(int r100);

    public abstract int getPosition(int r100);

    public abstract int getVolume(int r100);

    public abstract int pause(int r100);

    public abstract int pauseAll();

    public abstract int preload(int r100, String r101);

    public abstract int resume(int r100);

    public abstract int resumeAll();

    public abstract int setEventHandler(IAudioEffectPlayerEventHandler r100);

    public abstract int setPosition(int r100, int r101);

    public abstract int setVolume(int r100, int r101);

    public abstract int setVolumeAll(int r100);

    public abstract int start(int r100, String r101, AudioEffectPlayerConfig r102);

    public abstract int stop(int r100);

    public abstract int stopAll();

    public abstract int unload(int r100);

    public abstract int unloadAll();
}
