package com.ss.android.ttvecamera.cameraalgorithm;

/* JADX INFO: loaded from: classes38.dex */
public class TETaintSceneDetectParams extends TECameraAlgorithmParam {
    public int backendType;
    public int detectFrequency;
    public int detectRepeatNum;
    public String kernelBinPath;
    public String modelPath;
    public int numThread;

    public class VEAlgorithmFlagBackendType {
        public static final int VELensAlgorithm_ALG_BACKEND_DSP = 2;
        public static final int VELensAlgorithm_ALG_BACKEND_DYNAMIC_TUNING = 4;
        public static final int VELensAlgorithm_ALG_BACKEND_GPU = 1;
        public static final int VELensAlgorithm_ALG_BACKEND_HETEROGENE = 3;
        public static final int VELensAlgorithm_BACKEND_CPU = 0;
        final /* synthetic */ TETaintSceneDetectParams this$0;

        public VEAlgorithmFlagBackendType(TETaintSceneDetectParams r100) {
            this.this$0 = r100;
        }
    }

    public TETaintSceneDetectParams() {
        this.detectFrequency = 3;
        this.backendType = 0;
        this.numThread = 2;
        this.detectRepeatNum = 1;
        this.type = TECameraAlgorithmParam.TECameraAlgorithmType.TE_CAMERA_ALGORITHM_TYPE_TAINT_SCENE_DETECT;
    }
}
