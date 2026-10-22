package com.ss.android.ttvecamera.systemresmanager;

import android.content.Context;

/* JADX INFO: loaded from: classes38.dex */
public interface ITESystemResourceStrategy {
    void boostCpuFreq(int r100);

    void init(Context r100);

    void restoreCpuFreq();
}
