package com.obric.sva.sdk.session.legacy;

import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.sdk.session.SessionType;

/* JADX INFO: loaded from: classes6.dex */
public interface IWakeupListener {
    void onRecognition(SessionType r100, SoundTriggerWrapper.RecognitionEventWrapper r101);

    void onResourcesAvailable(SessionType r100);

    void onServiceDied(SessionType r100);
}
