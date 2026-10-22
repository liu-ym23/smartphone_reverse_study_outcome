package com.ss.android.vesdk.audio;

import com.ss.android.ttve.model.VEAudioDeviceType;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioDevice {
    private VEAudioDeviceType type;

    public VEAudioDevice() {
        this.type = VEAudioDeviceType.DEFAULT;
    }

    public VEAudioDeviceType getType() {
        return this.type;
    }

    public VEAudioDevice(VEAudioDeviceType r100) {
        VEAudioDeviceType r101 = VEAudioDeviceType.DEFAULT;
        this.type = r100;
    }
}
