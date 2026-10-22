package com.ss.android.ttvecamera.cameraalgorithm;

import com.ss.android.ttvecamera.provider.TECameraProvider;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraAlgorithmParam {
    public TECameraProvider.CaptureListener processListener;
    public int type;

    public class TEAlgorithmFlag {
        public static final int VELensAlgorithm_ALG_AFTER_EFFECT = 7;
        public static final int VELensAlgorithm_ALG_AI_INSERT_FRAME = 14;
        public static final int VELensAlgorithm_ALG_ASF = 24;
        public static final int VELensAlgorithm_ALG_CAMERA_MOTION = 5;
        public static final int VELensAlgorithm_ALG_COREML_AGING = 8;
        public static final int VELensAlgorithm_ALG_COREML_POSTERSR = 9;
        public static final int VELensAlgorithm_ALG_DARK_LIGHT_ENHANCEMENT = 1;
        public static final int VELensAlgorithm_ALG_DEARTIFACT = 18;
        public static final int VELensAlgorithm_ALG_DIM_LIGHT_DETECTION = 15;
        public static final int VELensAlgorithm_ALG_DISTORTION_FREE = 6;
        public static final int VELensAlgorithm_ALG_FACE_DETECT = 25;
        public static final int VELensAlgorithm_ALG_HDRVIDEO = 19;
        public static final int VELensAlgorithm_ALG_HDR_DETECT = 3;
        public static final int VELensAlgorithm_ALG_HDR_RAW = 2;
        public static final int VELensAlgorithm_ALG_IMAGESR_ASR = 4;
        public static final int VELensAlgorithm_ALG_IMAGE_VRSR = 23;
        public static final int VELensAlgorithm_ALG_LUMA_DETECT = 27;
        public static final int VELensAlgorithm_ALG_METAL_GRAMMA_BLUR = 10;
        public static final int VELensAlgorithm_ALG_OLD_PHOTO_RESTORATION = 30;
        public static final int VELensAlgorithm_ALG_ONEKEY_PROCESS = 28;
        public static final int VELensAlgorithm_ALG_RHYTHMIC_MOTION = 29;
        public static final int VELensAlgorithm_ALG_ROI = 0;
        public static final int VELensAlgorithm_ALG_SHAKE_DETECTION = 34;
        public static final int VELensAlgorithm_ALG_TAINT_SCENE_DETECT = 21;
        public static final int VELensAlgorithm_ALG_VFI = 20;
        public static final int VELensAlgorithm_ALG_VIDA_MOBILE_MODEL = 33;
        public static final int VELensAlgorithm_ALG_VIDEO_ANTI_SHAKE = 26;
        public static final int VELensAlgorithm_ALG_VIDEO_BOKEH = 31;
        public static final int VELensAlgorithm_ALG_VIDEO_DEBLUR = 17;
        public static final int VELensAlgorithm_ALG_VIDEO_DENOISE = 16;
        public static final int VELensAlgorithm_ALG_VIDEO_MOTION_BLUR = 32;
        public static final int VELensAlgorithm_ALG_VIDEO_NNSR = 11;
        public static final int VELensAlgorithm_ALG_VIDEO_SR = 12;
        public static final int VELensAlgorithm_ALG_VIDEO_STAB = 22;
        public static final int VELensAlgorithm_ALG_VIDEO_VRSR = 13;
        final /* synthetic */ TECameraAlgorithmParam this$0;

        public TEAlgorithmFlag(TECameraAlgorithmParam r100) {
            this.this$0 = r100;
        }
    }

    public static class TECameraAlgorithmType {
        public static int TE_CAMERA_ALGORITHM_TYPE_FACE_DETECT = 2;
        public static int TE_CAMERA_ALGORITHM_TYPE_INVALID = 0;
        public static int TE_CAMERA_ALGORITHM_TYPE_LENS_SHARPEN = 4;
        public static int TE_CAMERA_ALGORITHM_TYPE_ONE_KEY_PROCESS = 256;
        public static int TE_CAMERA_ALGORITHM_TYPE_RHYTHMIC_MOTION = 8;
        public static int TE_CAMERA_ALGORITHM_TYPE_TAINT_SCENE_DETECT = 2048;

        public TECameraAlgorithmType() {
        }
    }

    public TECameraAlgorithmParam() {
        this.type = TECameraAlgorithmType.TE_CAMERA_ALGORITHM_TYPE_INVALID;
    }
}
