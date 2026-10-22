package com.ss.android.ttvecamera.cameraalgorithm;

/* JADX INFO: loaded from: classes38.dex */
public class TEOneKeyProcessParams extends TECameraAlgorithmParam {
    public String algParams;
    public int cvdetectFrames;
    public boolean enableAfs;
    public boolean enableAlgoConfig;
    public boolean enableAsyncProcess;
    public boolean enableDayScene;
    public boolean enableDenoise;
    public boolean enableHDR;
    public boolean enableHdrV2;
    public boolean enableNightScene;
    public boolean isFirstFrame;
    public int iso;
    public int maxIso;
    public int minIso;

    public TEOneKeyProcessParams() {
        this.enableHDR = false;
        this.enableDenoise = false;
        this.enableAfs = false;
        this.enableHdrV2 = true;
        this.enableAsyncProcess = false;
        this.enableDayScene = true;
        this.enableNightScene = true;
        this.isFirstFrame = false;
        this.cvdetectFrames = 3;
        this.iso = 0;
        this.maxIso = 0;
        this.minIso = 0;
        this.type = TECameraAlgorithmParam.TECameraAlgorithmType.TE_CAMERA_ALGORITHM_TYPE_ONE_KEY_PROCESS;
    }
}
