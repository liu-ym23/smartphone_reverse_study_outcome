package com.ss.bytertc.ktv;

import com.ss.bytertc.ktv.data.KTVPlayerErrorCode;
import com.ss.bytertc.ktv.data.PlayState;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IKTVPlayerEventHandler {
    public IKTVPlayerEventHandler() {
    }

    public abstract void onPlayProgress(String r100, long r101);

    public abstract void onPlayStateChanged(String r100, PlayState r101, KTVPlayerErrorCode r102);
}
