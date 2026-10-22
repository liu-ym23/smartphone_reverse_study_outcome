package com.bytedance.realx;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class RTCCapabilities {
    private List<String> supportedVideoCodecs;

    private static native String[] nativeGetSupportedVideoCodecs(long r100);

    public List<String> getSupportedVideoCodecs() {
        return this.supportedVideoCodecs;
    }

    public RTCCapabilities(long r100) {
        this.supportedVideoCodecs = Arrays.asList(nativeGetSupportedVideoCodecs(r100));
    }

    public RTCCapabilities(List<String> r100) {
        this.supportedVideoCodecs = r100;
    }
}
