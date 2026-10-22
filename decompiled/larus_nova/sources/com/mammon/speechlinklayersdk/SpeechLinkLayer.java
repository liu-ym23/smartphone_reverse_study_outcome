package com.mammon.speechlinklayersdk;

import com.mammon.speechaudiosdk.jni.structures.SpeechNativeProperty;
import com.mammon.speechlinklayersdk.jni.SpeechNativeLinkLayer;
import com.mammon.speechlinklayersdk.jni.callback.SpeechNativeLinkLayerCallback;
import com.mammon.speechlinklayersdk.param.SpeechHostInjectionDownlinkParam;
import com.mammon.speechlinklayersdk.param.SpeechLinkLayerCreateParam;
import com.mammon.speechlinklayersdk.param.SpeechLinkLayerUplinkCallbackParam;

/* JADX INFO: loaded from: classes32.dex */
public class SpeechLinkLayer {
    public static final String TAG = " mammon SpeechLinkLayer";
    private final SpeechLinkLayerCreateParam linkLayerParam;
    private SpeechNativeLinkLayer nativeLinkLayer;

    public static class SpeechNativeLinkLayerCallbackImpl implements SpeechNativeLinkLayerCallback {
        private final SpeechLinkLayerCallback userCallback;

        public SpeechNativeLinkLayerCallbackImpl(SpeechLinkLayerCallback r100) {
            this.userCallback = r100;
        }

        @Override // com.mammon.speechlinklayersdk.jni.callback.SpeechNativeLinkLayerCallback
        public void onUplinkCallback(SpeechLinkLayerUplinkCallbackParam r100) {
            this.userCallback.onUplinkCallback(r100);
        }
    }

    public long getNativeHandle() {
        return this.nativeLinkLayer.getNativeHandle();
    }

    public int init() {
        SpeechNativeLinkLayerCallbackImpl r100 = new SpeechNativeLinkLayerCallbackImpl(this.linkLayerParam.linkLayerCallback);
        SpeechNativeLinkLayer r101 = new SpeechNativeLinkLayer();
        this.nativeLinkLayer = r101;
        r101.setEnableSyncInterface(true);
        this.nativeLinkLayer.setNativeLinkLayerCallback(r100);
        return this.nativeLinkLayer.createHandle(2, null);
    }

    public void release() {
        this.nativeLinkLayer.destroyHandle();
    }

    public SpeechLinkLayer(SpeechLinkLayerCreateParam r100) {
        this.linkLayerParam = r100;
    }

    public int processDownlinkData(SpeechHostInjectionDownlinkParam r100) {
        SpeechNativeProperty r101 = new SpeechNativeProperty();
        r101.f384371id = 1002;
        r101.dataType = 101;
        r101.data = r100;
        return this.nativeLinkLayer.setProperty(r101);
    }
}
