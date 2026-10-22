package com.ss.android.ttvecamera.cameraalgorithm;

import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraFrame;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraAlgorithmInterface {

    public static class TECameraAlgoResult {
        public TECameraAlgoResult() {
        }
    }

    public interface TECameraAlgorithmErrorListener {
        void onError(int r100, String r101);
    }

    public interface TECameraAlgorithmProcessListener {
        void onProcess(float r100, boolean r101);
    }

    public interface TECameraLensCallback {
        void onError(int r100, int r101, String r102);

        void onInfo(int r100, int r101, int r102, String r103);

        void onSuccess(int r100, float r101, int r102);
    }

    public TECameraAlgorithmInterface(TECameraBase r100) {
    }

    public int addCameraAlgorithm(TECameraAlgorithmParam r100) {
        return 0;
    }

    public int destroy() {
        return 0;
    }

    public TECameraAlgorithmResult getResult() {
        return null;
    }

    public int init() {
        return 0;
    }

    public native int nativeAddCameraAlgorithm(long r100, Object r101);

    public native int nativeAlgorithmDestroy(long r100);

    public native Object nativeAlgorithmGetResult(long r100);

    public void nativeCallback_onError(int r100, String r101) {
    }

    public void nativeCallback_onProcess(float r100, boolean r101) {
    }

    public native long nativeInit();

    public native TECameraAlgoResult nativeProcessAlgorithm(long r100, Object r101);

    public native int nativeRemoveCameraAlgorithm(long r100, int r101);

    public native int nativeUpdateCameraAlgorithmParam(long r100, Object r101);

    public TECameraFrame processAlgorithm(TECameraFrame r100) {
        return null;
    }

    public int removeCameraAlgorithm(int r100) {
        return 0;
    }

    public void setErrorListener(TECameraAlgorithmErrorListener r100) {
    }

    public void setLensCallback(TECameraLensCallback r100) {
    }

    public void setProcessListener(TECameraAlgorithmProcessListener r100) {
    }

    public int updateCameraAlgorithmParam(TECameraAlgorithmParam r100) {
        return 0;
    }
}
