package com.mammon.speechaudiosdk.session.task;

import com.mammon.speechaudiosdk.jni.SpeechNativeCore;
import com.mammon.speechaudiosdk.jni.callback.SpeechNativeRecorderAudioConsumerCallback;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeProperty;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeRecorderAudioConsumerCallbackData;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeRecorderAudioConsumerContextParameter;
import com.mammon.speechaudiosdk.session.callback.SpeechRecorderAudioConsumerCallback;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerCallbackParam;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerTaskCreateParam;

/* JADX INFO: loaded from: classes32.dex */
public class SpeechRecorderAudioConsumerTaskImpl implements SpeechRecorderAudioConsumerTask {
    private static final String TAG = "mammon SpeechRecorderAudioConsumerTask";
    private SpeechNativeCore nativeCore;
    private final SpeechRecorderAudioConsumerTaskCreateParam taskParam;

    public static class NativeCallbackImpl implements SpeechNativeRecorderAudioConsumerCallback {
        private final SpeechRecorderAudioConsumerCallback userCallback;

        public NativeCallbackImpl(SpeechRecorderAudioConsumerCallback r100) {
            this.userCallback = r100;
        }

        @Override // com.mammon.speechaudiosdk.jni.callback.SpeechNativeRecorderAudioConsumerCallback
        public void onCallback(int r100, String r101, SpeechNativeRecorderAudioConsumerCallbackData r102) {
            SpeechRecorderAudioConsumerCallbackParam r103 = new SpeechRecorderAudioConsumerCallbackParam();
            r103.msgType = r100;
            r103.sessionId = r101;
            if (r100 != 5000) goto L6;
            if (r102 == null) goto L6;
            r103.audioFrameTimestampMs = r102.timestampMs;
            r103.audioData = r102.audioData;
        L6:
            this.userCallback.onCallback(r103);
        }
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask
    public int init() {
        SpeechRecorderAudioConsumerTaskCreateParam r100 = this.taskParam;
        if (r100 != null) goto L5;
        return 100001;
    L5:
        SpeechRecorderAudioConsumerCallback r101 = r100.userCallback;
        if (r101 != null) goto L8;
        return 100001;
    L8:
        NativeCallbackImpl r102 = new NativeCallbackImpl(r101);
        SpeechNativeCore r103 = new SpeechNativeCore();
        this.nativeCore = r103;
        r103.setEnableSyncInterface(true);
        this.nativeCore.setRecorderAudioConsumerCallback(r102);
        SpeechNativeRecorderAudioConsumerContextParameter r104 = new SpeechNativeRecorderAudioConsumerContextParameter();
        SpeechRecorderAudioConsumerTaskCreateParam r105 = this.taskParam;
        r104.vuiId = r105.vuiId;
        r104.sampleRate = r105.sampleRate;
        r104.channel = r105.channel;
        r104.format = r105.format;
        r104.packetDurationMs = r105.packetDurationMs;
        r104.debugPath = r105.debugPath;
        int r106 = this.nativeCore.createHandle(5, r104);
        if (r106 != 0) goto L11;
    L11:
        return r106;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask
    public void release() {
        SpeechNativeCore r100 = this.nativeCore;
        if (r100 == null) goto L6;
        r100.destroyHandle();
        this.nativeCore = null;
        return;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask
    public int start() {
        if (this.nativeCore != null) goto L6;
        return 100010;
    L6:
        SpeechNativeProperty r100 = new SpeechNativeProperty();
        r100.f384371id = 1;
        r100.dataType = 0;
        return this.nativeCore.setProperty(r100);
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask
    public int stop() {
        if (this.nativeCore != null) goto L6;
        return 100010;
    L6:
        SpeechNativeProperty r100 = new SpeechNativeProperty();
        r100.f384371id = 2;
        r100.dataType = 0;
        return this.nativeCore.setProperty(r100);
    }

    public SpeechRecorderAudioConsumerTaskImpl(SpeechRecorderAudioConsumerTaskCreateParam r100) {
        this.taskParam = r100;
    }
}
