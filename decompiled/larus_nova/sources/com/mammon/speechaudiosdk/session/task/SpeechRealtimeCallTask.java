package com.mammon.speechaudiosdk.session.task;

import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionUplinkParam;
import com.mammon.speechlinklayersdk.SpeechLinkLayer;

/* JADX INFO: loaded from: classes32.dex */
public interface SpeechRealtimeCallTask {
    int init();

    void release();

    int sendHostInjectionUplinkData(SpeechHostInjectionUplinkParam r100);

    int setCloudWakeupIntentResult(boolean r100);

    int setLocalParam(int r100, Object r101);

    int setSpeechLinkLayer(SpeechLinkLayer r100);

    int start();

    int stop();
}
