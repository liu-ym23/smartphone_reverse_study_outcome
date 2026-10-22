package com.mammon.speechaudiosdk.session;

import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionTaskCreateParam;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerTaskCreateParam;
import com.mammon.speechaudiosdk.session.task.SpeechHostInjectionRealtimeCallTask;
import com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask;
import com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask;
import com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTaskImpl;

/* JADX INFO: loaded from: classes32.dex */
public class SpeechSessionManager {
    private static final String TAG = "mammon SpeechSessionManager";

    public SpeechSessionManager() {
    }

    public SpeechRealtimeCallTask createHostInjectionRealtimeCallTask(SpeechHostInjectionTaskCreateParam r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new SpeechHostInjectionRealtimeCallTask(r100);
    }

    public SpeechRecorderAudioConsumerTask createRecorderAudioConsumerTask(SpeechRecorderAudioConsumerTaskCreateParam r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new SpeechRecorderAudioConsumerTaskImpl(r100);
    }

    public void releaseRealtimeCallTask(SpeechRealtimeCallTask r100) {
        r100.release();
    }

    public void releaseRecorderAudioConsumerTask(SpeechRecorderAudioConsumerTask r100) {
        if (r100 == null) goto L5;
        r100.release();
        return;
    }
}
