package com.ss.android.ttve.lensAlgorithm.videoStable;

import com.ss.android.ttve.lensAlgorithm.VEBaseLensResults;

/* JADX INFO: loaded from: classes38.dex */
public class VELensVideoStabResults extends VEBaseLensResults {
    public int processHeight;
    public int processWidth;
    public String ptsList;
    public VideoStabResult[] videoStabResult;

    public static class VideoStabResult {
        public String matrixList;
        public float realCropRatio;
        public int realRadius;
        public float videoStabMaxCropRatio;
        public int videoStabMotionType;
        public int videoStabSmoothRadius;

        public VideoStabResult() {
        }

        public VideoStabResult(float r100, int r101, int r102, String r103, int r104, float r105) {
            this.videoStabMaxCropRatio = r100;
            this.videoStabSmoothRadius = r101;
            this.videoStabMotionType = r102;
            this.matrixList = r103;
            this.realRadius = r104;
            this.realCropRatio = r105;
        }
    }

    public VELensVideoStabResults() {
    }

    public VELensVideoStabResults(VideoStabResult[] r100, String r101, int r102, int r103) {
        this.videoStabResult = r100;
        this.ptsList = r101;
        this.processWidth = r102;
        this.processHeight = r103;
    }
}
