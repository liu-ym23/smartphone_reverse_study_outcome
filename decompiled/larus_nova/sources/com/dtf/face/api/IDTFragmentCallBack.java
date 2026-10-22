package com.dtf.face.api;

import android.os.Bundle;

/* JADX INFO: loaded from: classes22.dex */
public interface IDTFragmentCallBack extends IDTUICallBack {
    void onCameraPreviewBegin(int r100);

    void onCameraPreviewEnd();

    void onCameraSizeChanged(double r100, double r101);

    void onFaceTipsUpdateFace(String r100, String r101, Bundle r102);

    void onPhotinusBegin();

    void onPhotinusColorUpdate(int r100);

    void onPhotinusEnd();

    void onPhotinusInterrupt();
}
