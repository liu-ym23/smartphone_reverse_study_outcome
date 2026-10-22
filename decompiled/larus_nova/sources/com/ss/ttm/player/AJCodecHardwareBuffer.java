package com.ss.ttm.player;

import android.hardware.HardwareBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class AJCodecHardwareBuffer {
    public int colorSpace;
    public HardwareBuffer hardwareBuffer;
    public int[] roi;
    public int rotation;

    public AJCodecHardwareBuffer(HardwareBuffer r100, int[] r101, int r102, int r103) {
        this.hardwareBuffer = r100;
        this.roi = r101;
        this.rotation = r102;
        this.colorSpace = r103;
    }
}
