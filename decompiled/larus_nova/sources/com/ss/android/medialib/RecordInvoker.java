package com.ss.android.medialib;

import android.opengl.EGLContext;
import com.ss.android.vesdk.faceinfo.FaceAttributeInfo;
import com.ss.android.vesdk.faceinfo.FaceDetectInfo;
import com.ss.android.vesdk.faceinfo.SkeletonInfo;
import com.ss.android.vesdk.model.BefTextLayout;
import com.ss.android.vesdk.model.BefTextLayoutResult;
import com.ss.android.vesdk.model.SceneDetectInfo;
import com.ss.android.vesdk.model.a;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public class RecordInvoker {

    public interface EffectAlgorithmCallback {
        void onResult(int[] r100, long[] r101, float r102);
    }

    public interface FaceResultCallback {
        void onResult(FaceAttributeInfo r100, FaceDetectInfo r101);
    }

    public interface OnARTextBitmapCallback {
        BefTextLayoutResult onResult(String r100, BefTextLayout r101);
    }

    public interface OnARTextContentCallback {
        void onResult(String[] r100);
    }

    public interface OnARTextCountCallback {
        void onResult(int r100);
    }

    public interface OnCherEffectParmaCallback {
        void onCherEffect(String[] r100, double[] r101, boolean[] r102);
    }

    public interface OnFrameCallback {
        void onFrame(int r100, double r101);

        void onFrame(ByteBuffer r100, int r101, int r102, int r103, double r104);

        void onInit(EGLContext r100, int r101, int r102, int r103, long r104);
    }

    public interface OnHandDetectCallback {
        void onResult(int[] r100);
    }

    public interface OnLensResultCallback {
        void onError(int r100, int r101, String r102);

        void onInfo(int r100, int r101, int r102, String r103);

        void onSuccess(int r100, float r101, int r102);
    }

    public interface OnPictureCallback {
        void onResult(int[] r100, int r101, int r102);
    }

    public interface OnPictureCallbackV2 {
        void onImage(int[] r100, int r101, int r102);

        void onResult(int r100, int r101);
    }

    public interface OnPreviewRadioListener {
        void onInfo(int r100, int r101);
    }

    public interface OnRunningErrorCallback {
        public static final int EXT_SHOT_SCREEN_FRAME_CAPTURED = 110;
        public static final int FRAG_HW_ENCODER_ERR = -601;
        public static final int INIT_FRAG_OUTPUT_ERR = -602;
        public static final int TYPE_SHOT_SCREEN = 1030;

        void onAccurateInfo(int r100, double r101);

        void onError(int r100);

        void onInfo(int r100, int r101);
    }

    public interface OnSceneDetectCallback {
        void onResult(SceneDetectInfo r100);
    }

    public interface OnSkeletonDetectCallback {
        void onResult(SkeletonInfo r100);
    }

    public interface OnSmartBeautyCallback {
        void onResult(a r100);
    }

    public RecordInvoker() {
    }
}
