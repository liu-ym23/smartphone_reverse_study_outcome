package com.ss.android.vesdk.lens;

/* JADX INFO: loaded from: classes40.dex */
public class VEModelDownload {
    public static final String MODELNAME_TAINT_SCENE_DETECT = "lens_taint_scene_detect";
    public static final String REQUIREMENT_TAINT_SCENE_DETECT_MODEL = "TaintSceneDetectModel";

    public interface IModelDownload {
        void downloadModel(String r100, String r101, VEModelDownloadCallback r102);
    }

    public interface VEModelDownloadCallback {
        void onError(String r100);

        void onSuccess(String r100);
    }

    public VEModelDownload() {
    }
}
