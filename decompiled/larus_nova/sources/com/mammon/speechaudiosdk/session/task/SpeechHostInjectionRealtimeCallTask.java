package com.mammon.speechaudiosdk.session.task;

import com.mammon.speechaudiosdk.jni.SpeechNativeCore;
import com.mammon.speechaudiosdk.jni.callback.SpeechNativeCallback;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeProperty;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeVoiceAssistantContextParameter;
import com.mammon.speechaudiosdk.session.callback.SpeechHostInjectionCallback;
import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionDownlinkCallbackParam;
import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionTaskCreateParam;
import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionUplinkParam;
import com.mammon.speechaudiosdk.session.param.SpeechVoiceAssistantWakeupIntentResult;
import com.mammon.speechlinklayersdk.SpeechLinkLayer;

/* JADX INFO: loaded from: classes32.dex */
public class SpeechHostInjectionRealtimeCallTask implements SpeechRealtimeCallTask {
    private static final String TAG = "mammon SpeechInjectionRealtimeCallTask";
    private SpeechNativeCore nativeCore;
    private SpeechLinkLayer speechLinkLayer;
    private final SpeechHostInjectionTaskCreateParam taskParam;

    public static class SpeechNativeCallbackImpl implements SpeechNativeCallback {
        private final SpeechHostInjectionCallback userCallback;

        public SpeechNativeCallbackImpl(SpeechHostInjectionCallback r100) {
            this.userCallback = r100;
        }

        @Override // com.mammon.speechaudiosdk.jni.callback.SpeechNativeCallback
        public void onDownlinkCallback(SpeechHostInjectionDownlinkCallbackParam r100) {
            this.userCallback.onDownlinkCallback(r100);
        }
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int start() {
        return 0;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int stop() {
        return 0;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int init() {
        SpeechHostInjectionTaskCreateParam r100 = this.taskParam;
        if (r100 != null) goto L5;
        return 100001;
    L5:
        SpeechHostInjectionCallback r101 = r100.userCallback;
        if (r101 != null) goto L8;
        return 100001;
    L8:
        SpeechNativeCallbackImpl r102 = new SpeechNativeCallbackImpl(r101);
        SpeechNativeCore r103 = new SpeechNativeCore();
        this.nativeCore = r103;
        r103.setEnableSyncInterface(true);
        this.nativeCore.setSpeechNativeCallback(r102);
        this.nativeCore.setSessionEventCallback(this.taskParam.sessionEventCallback);
        SpeechNativeVoiceAssistantContextParameter r104 = new SpeechNativeVoiceAssistantContextParameter();
        r104.transportType = 2;
        SpeechHostInjectionTaskCreateParam r105 = this.taskParam;
        r104.businessInfo = r105.businessInfo;
        r104.dumpPath = r105.dumpPath;
        int r106 = this.nativeCore.createHandle(1, r104);
        if (r106 != 0) goto L11;
    L11:
        return r106;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public void release() {
        SpeechNativeCore r100 = this.nativeCore;
        if (r100 == null) goto L6;
        r100.destroyHandle();
        return;
    }

    public SpeechHostInjectionRealtimeCallTask(SpeechHostInjectionTaskCreateParam r100) {
        this.taskParam = r100;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int sendHostInjectionUplinkData(SpeechHostInjectionUplinkParam r100) {
        SpeechNativeProperty r101 = new SpeechNativeProperty();
        r101.f384371id = 1001;
        r101.data = r100;
        r101.dataType = 100;
        return this.nativeCore.setProperty(r101);
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int setCloudWakeupIntentResult(boolean r100) {
        SpeechVoiceAssistantWakeupIntentResult r101 = new SpeechVoiceAssistantWakeupIntentResult();
        r101.result = r100;
        SpeechNativeProperty r102 = new SpeechNativeProperty();
        r102.f384371id = 1010;
        r102.dataType = 105;
        r102.data = r101;
        return this.nativeCore.setProperty(r102);
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int setSpeechLinkLayer(SpeechLinkLayer r100) {
        this.speechLinkLayer = r100;
        SpeechNativeProperty r101 = new SpeechNativeProperty();
        r101.f384371id = 1003;
        r101.dataType = 4;
        r101.data = Long.valueOf(r100.getNativeHandle());
        int r102 = this.nativeCore.setProperty(r101);
        if (r102 != 0) goto L5;
    L5:
        return r102;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int setLocalParam(int r100, Object r101) {
        SpeechNativeProperty r102 = new SpeechNativeProperty();
        r102.data = r101;
        switch(r100) {
            case 301: goto L10;
            case 302: goto L9;
            case 303: goto L8;
            case 304: goto L7;
            case 305: goto L4;
            case 306: goto L6;
            default: goto L4;
        };
    L4:
        return 100002;
    L6:
        r102.f384371id = 1009;
        r102.dataType = 5;
    L12:
        return this.nativeCore.setProperty(r102);
    L7:
        r102.f384371id = 1007;
        r102.dataType = 104;
        goto L12
    L8:
        r102.f384371id = 1006;
        r102.dataType = 1;
        goto L12
    L9:
        r102.f384371id = 1005;
        r102.dataType = 103;
        goto L12
    L10:
        r102.f384371id = 1004;
        r102.dataType = 102;
        goto L12
    }
}
