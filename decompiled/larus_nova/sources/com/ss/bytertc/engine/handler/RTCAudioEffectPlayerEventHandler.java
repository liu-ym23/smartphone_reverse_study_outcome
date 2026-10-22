package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IAudioEffectPlayerEventHandler;
import com.ss.bytertc.engine.data.PlayerError;
import com.ss.bytertc.engine.data.PlayerState;

/* JADX INFO: loaded from: classes40.dex */
public class RTCAudioEffectPlayerEventHandler {
    private IAudioEffectPlayerEventHandler mAudioEffectHandler;

    public RTCAudioEffectPlayerEventHandler() {
    }

    public synchronized void setAudioEffectPlayerEventHandler(IAudioEffectPlayerEventHandler r100) {
        monitor-enter(this);
        this.mAudioEffectHandler = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onAudioEffectPlayerStateChanged(int r100, PlayerState r101, PlayerError r102) {
        monitor-enter(this);
        IAudioEffectPlayerEventHandler r103 = this.mAudioEffectHandler;     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        r103.onAudioEffectPlayerStateChanged(r100, r101, r102);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
