package com.bytedance.android.livesdk.live.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class Camera2AB {

    @SerializedName("camera_hw_level")
    private int cameraHWLevel;

    @SerializedName("camera_type")
    private int cameraType;

    public Camera2AB() {
        this.cameraType = 1;
        this.cameraHWLevel = 0;
    }

    public int getCameraHWLevel() {
        return this.cameraHWLevel;
    }

    public int getCameraType() {
        return this.cameraType;
    }

    public void setCameraHWLevel(int r1) {
        this.cameraHWLevel = r1;
    }

    public void setCameraType(int r1) {
        this.cameraType = r1;
    }

    public Camera2AB(int r1, int r2) {
        this.cameraType = r1;
        this.cameraHWLevel = r2;
    }
}
