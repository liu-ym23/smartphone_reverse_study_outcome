package com.ss.android.vesdk.camera;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.vesdk.VECameraSettings;
import com.ss.android.vesdk.VEListener;
import com.ss.android.vesdk.VESize;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public interface ICameraPreview {

    /* JADX INFO: renamed from: com.ss.android.vesdk.camera.ICameraPreview$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isMockCapture(ICameraPreview r100) {
            return false;
        }
    }

    TECameraSettings getCameraParams();

    VECameraSettings getCameraSettings();

    VESize getPreviewSize();

    boolean isMockCapture();

    boolean isTakenPicture();

    void setListenerFromRecorder(ArrayList<String> r100, VEListener.v r101);

    void setParamFromRecorder(Bundle r100);

    int start(com.ss.android.vesdk.b<com.ss.android.vesdk.frame.b> r100);

    void updateSurfaceTexture(SurfaceTexture r100);

    void updateTextureId(Object r100, int r101);
}
