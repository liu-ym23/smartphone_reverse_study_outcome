package com.mammon.audiosdk.session;

import com.mammon.audiosdk.session.callback.ISpeechCallback;
import com.mammon.audiosdk.session.data.RealtimeCallTaskParam;
import com.mammon.audiosdk.session.data.SpeechSessionManagerParam;
import com.mammon.audiosdk.session.task.RealtimeCallTask;

/* JADX INFO: loaded from: classes32.dex */
public class SpeechSessionManager {
    private static final String TAG = "mammon SpeechSessionManager";
    private final SpeechSessionManagerParam mParam;

    public SpeechSessionManagerParam getSessionManagerParam() {
        return this.mParam;
    }

    public SpeechSessionManager(SpeechSessionManagerParam r100) {
        this.mParam = r100;
    }

    public void releaseRealtimeCallTask(RealtimeCallTask r100) {
        r100.release();
    }

    public RealtimeCallTask createRealtimeCallTask(RealtimeCallTaskParam r100, ISpeechCallback r101) {
        return new RealtimeCallTask(r100, r101, this);
    }
}
