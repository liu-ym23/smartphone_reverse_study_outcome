package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IMediaPlayerEventHandler;
import com.ss.bytertc.engine.data.PlayerError;
import com.ss.bytertc.engine.data.PlayerEvent;
import com.ss.bytertc.engine.data.PlayerState;

/* JADX INFO: loaded from: classes40.dex */
public class RTCMediaPlayerEventHandler {
    private IMediaPlayerEventHandler mMediaPlayerHandler;

    public RTCMediaPlayerEventHandler() {
    }

    public synchronized void setMediaPlayerEventHandler(IMediaPlayerEventHandler r100) {
        monitor-enter(this);
        this.mMediaPlayerHandler = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onMediaPlayerPlayingProgress(int r100, long r101) {
        monitor-enter(this);
        IMediaPlayerEventHandler r102 = this.mMediaPlayerHandler;     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r102.onMediaPlayerPlayingProgress(r100, r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void onMediaPlayerEvent(int r100, PlayerEvent r101, String r102) {
        monitor-enter(this);
        IMediaPlayerEventHandler r103 = this.mMediaPlayerHandler;     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        r103.onMediaPlayerEvent(r100, r101, r102);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void onMediaPlayerStateChanged(int r100, PlayerState r101, PlayerError r102) {
        monitor-enter(this);
        IMediaPlayerEventHandler r103 = this.mMediaPlayerHandler;     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        r103.onMediaPlayerStateChanged(r100, r101, r102);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
