package com.ss.ttvideoengine;

import com.ss.ttvideoengine.utils.Error;

/* JADX INFO: loaded from: classes34.dex */
public interface ITTVideoEngineLogger {
    void initLogger();

    void logBeginToPlay();

    void logBufferingEnd(int r100);

    void logBufferingStart(int r100, int r101);

    void logCompletion();

    void logError(Error r100);

    void logLoopAgain();

    void logPrepareBeforePlay();

    void logPrepareEnd();

    void logPrepareStart();

    void logRetry(Error r100, int r101);

    void logSeek(int r100);

    void logSeekCompletion();

    void logSetDataSource();

    void logSetSurface(String r100);

    void logStop(int r100);

    void logVideoRenderStart();

    void logVideoSizeChanged(int r100, int r101);
}
