package com.larus.voicecall.impl.component.vlm.camera.camera_state;

import android.view.TextureView;
import com.larus.voicecall.impl.component.vlm.h1;
import com.larus.voicecall.impl.component.vlm.i1;
import com.ss.android.vesdk.VEDisplaySettings;

/* JADX INFO: loaded from: classes32.dex */
public interface f {
    void b(boolean r100);

    boolean c(boolean r100);

    void closeCamera();

    void d(float r100);

    void e(int r100, int r101, VEDisplaySettings.VEDisplayFitMode r102);

    void f(float r100, float r101);

    r3a.l getCurrentState();

    boolean isCameraTorchSupported();

    void j(h1 r100);

    void m(TextureView r100);

    void onDestroy();

    void openCamera();

    void q(i1 r100);
}
