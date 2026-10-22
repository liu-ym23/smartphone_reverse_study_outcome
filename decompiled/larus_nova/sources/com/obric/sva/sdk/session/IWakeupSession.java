package com.obric.sva.sdk.session;

import com.obric.sva.sdk.session.legacy.IWakeupListener;

/* JADX INFO: loaded from: classes6.dex */
public interface IWakeupSession extends IWakeupSessionConstant {
    void addWakeupListener(IWakeupListener r100);

    int establishSvaSession(String r100);

    SessionType getSessionType();

    boolean isRecognitionActive(String r100);

    boolean isSupportConcurrency();

    int loadSM(String r100);

    void releaseAllSvaSessions();

    void releaseSvaSession(String r100);

    void removeWakeupListener(IWakeupListener r100);

    int restartRecognition(String r100);

    int startRecognition(String r100);

    int stopRecognition(String r100);

    int terminateSvaSession(String r100);

    int unloadSM(String r100);
}
