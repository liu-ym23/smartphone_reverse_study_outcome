package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.ktv.IKTVPlayerEventHandler;
import com.ss.bytertc.ktv.data.KTVPlayerErrorCode;
import com.ss.bytertc.ktv.data.PlayState;

/* JADX INFO: loaded from: classes40.dex */
public class KTVPlayEventHandler extends IKTVPlayerEventHandler {
    private static final String TAG = "KTVPlayEventHandler";
    private final IKTVPlayerEventHandler mHandler;

    public KTVPlayEventHandler(IKTVPlayerEventHandler r100) {
        this.mHandler = r100;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayerEventHandler
    public void onPlayProgress(String r100, long r101) {
        LogUtil.d(TAG, "onPlayProgress...musicId: " + r100 + ",progress:" + r101);
        IKTVPlayerEventHandler r102 = this.mHandler;     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.onPlayProgress(r100, r101);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.e(TAG, "onPlayProgress callback catch exception.\n" + e.getMessage());
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayerEventHandler
    public void onPlayStateChanged(String r100, PlayState r101, KTVPlayerErrorCode r102) {
        LogUtil.d(TAG, "onPlayStateChanged...musicId: " + r100 + ",playState:" + r101.toString());
        IKTVPlayerEventHandler r103 = this.mHandler;     // Catch: Exception -> L7
        if (r103 == null) goto L12;
        r103.onPlayStateChanged(r100, r101, r102);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.e(TAG, "onPlayStateChanged callback catch exception.\n" + e.getMessage());
    }
}
