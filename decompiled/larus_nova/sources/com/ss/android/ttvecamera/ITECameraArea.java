package com.ss.android.ttvecamera;

import android.hardware.Camera;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface ITECameraArea {

    public interface ITECameraFocusArea {
        List<Camera.Area> calculateArea(int r100, int r101, int r102, int r103, int r104, boolean r105);
    }

    public interface ITECameraMeteringArea {
        List<Camera.Area> calculateArea(int r100, int r101, int r102, int r103, int r104, boolean r105);
    }
}
