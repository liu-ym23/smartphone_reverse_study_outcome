package com.ss.bytertc.audio.device.hwearback;

/* JADX INFO: loaded from: classes40.dex */
public interface IHardWareEarback {
    int close();

    int getLatency();

    int init();

    boolean isSupport();

    void notifyEarbackRecordStateChanged(boolean r100);

    int open();

    int release();

    int setEffect(int r100);

    int setEqualizer(int r100);

    int setVolume(int r100);
}
