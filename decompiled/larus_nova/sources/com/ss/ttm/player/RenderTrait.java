package com.ss.ttm.player;

import android.hardware.HardwareBuffer;

/* JADX INFO: loaded from: classes40.dex */
public abstract class RenderTrait extends TraitObject {
    public static final int Version0 = 0;

    public abstract void onClose();

    public abstract int onDrawFrame(HardwareBuffer r100, int[] r101, int r102);

    public int onDrawFrame(AJCodecHardwareBuffer r100) {
        return 0;
    }

    public abstract int onOpen();

    public int onOpen(int r100) {
        return -1;
    }

    public RenderTrait(int r100) {
        super(6, r100, 0);
    }
}
