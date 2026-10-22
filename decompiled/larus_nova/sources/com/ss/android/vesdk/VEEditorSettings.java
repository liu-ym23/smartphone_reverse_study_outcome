package com.ss.android.vesdk;

import android.graphics.Bitmap;
import com.ss.android.vesdk.filterparam.VECanvasFilterParam;
import com.ss.android.vesdk.filterparam.VETransitionFilterParam;

/* JADX INFO: loaded from: classes40.dex */
public class VEEditorSettings {
    private int[] aTrimIn;
    private int[] aTrimOut;
    private String[] audioFileInfos;
    private String[] audioFilePaths;
    private VECanvasFilterParam[] canvasFilterParams;
    private Bitmap[] images;
    private VESize[] sizes;
    private float[] speed;
    private VETransitionFilterParam[] vTransitionFilterParam;
    private int[] vTrimIn;
    private int[] vTrimOut;
    private String[] videoFileInfos;
    private String[] videoFilePaths;
    private VEEditor.VIDEO_GRAVITY videoGravity;
    private VEEditor.VIDEO_RATIO videoOutRes;
    private VEEditor.VIDEO_SCALETYPE videoScaletype;

    public static final class Builder {
        private final VEEditorSettings mVEEditorSettings;

        public Builder() {
            this.mVEEditorSettings = new VEEditorSettings(null);
        }

        public VEEditorSettings build() {
            return this.mVEEditorSettings;
        }

        public Builder setATrimIn(int[] r100) {
            VEEditorSettings.access$902(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setATrimOut(int[] r100) {
            VEEditorSettings.access$1002(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setAudioFileInfos(String[] r100) {
            VEEditorSettings.access$802(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setAudioFilePaths(String[] r100) {
            VEEditorSettings.access$702(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setCanvasFilterParams(VECanvasFilterParam[] r100) {
            VEEditorSettings.access$1202(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setImages(Bitmap[] r100) {
            VEEditorSettings.access$202(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setSizes(VESize[] r100) {
            VEEditorSettings.access$1602(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setSpeed(float[] r100) {
            VEEditorSettings.access$1102(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setVTransitionFilterParam(VETransitionFilterParam[] r100) {
            VEEditorSettings.access$602(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setVTrimIn(int[] r100) {
            VEEditorSettings.access$402(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setVTrimOut(int[] r100) {
            VEEditorSettings.access$502(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setVideoFileInfos(String[] r100) {
            VEEditorSettings.access$302(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setVideoFilePaths(String[] r100) {
            VEEditorSettings.access$102(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setVideoGravity(VEEditor.VIDEO_GRAVITY r100) {
            VEEditorSettings.access$1402(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setVideoOutRes(VEEditor.VIDEO_RATIO r100) {
            VEEditorSettings.access$1302(this.mVEEditorSettings, r100);
            return this;
        }

        public Builder setVideoScaletype(VEEditor.VIDEO_SCALETYPE r100) {
            VEEditorSettings.access$1502(this.mVEEditorSettings, r100);
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    private VEEditorSettings() {
    }

    public int[] getATrimIn() {
        return this.aTrimIn;
    }

    public int[] getATrimOut() {
        return this.aTrimOut;
    }

    public String[] getAudioFileInfos() {
        return this.audioFileInfos;
    }

    public String[] getAudioFilePaths() {
        return this.audioFilePaths;
    }

    public VECanvasFilterParam[] getCanvasFilterParams() {
        return this.canvasFilterParams;
    }

    public Bitmap[] getImages() {
        return this.images;
    }

    public VESize[] getSizes() {
        return this.sizes;
    }

    public float[] getSpeed() {
        return this.speed;
    }

    public VETransitionFilterParam[] getVTransitionFilterParam() {
        return this.vTransitionFilterParam;
    }

    public int[] getVTrimIn() {
        return this.vTrimIn;
    }

    public int[] getVTrimOut() {
        return this.vTrimOut;
    }

    public String[] getVideoFileInfos() {
        return this.videoFileInfos;
    }

    public String[] getVideoFilePaths() {
        return this.videoFilePaths;
    }

    public VEEditor.VIDEO_GRAVITY getVideoGravity() {
        return this.videoGravity;
    }

    public VEEditor.VIDEO_RATIO getVideoOutRes() {
        return this.videoOutRes;
    }

    public VEEditor.VIDEO_SCALETYPE getVideoScaletype() {
        return this.videoScaletype;
    }

    public /* synthetic */ VEEditorSettings(a r100) {
        this();
    }

    public static /* synthetic */ int[] access$1002(VEEditorSettings r100, int[] r101) {
        r100.aTrimOut = r101;
        return r101;
    }

    public static /* synthetic */ String[] access$102(VEEditorSettings r100, String[] r101) {
        r100.videoFilePaths = r101;
        return r101;
    }

    public static /* synthetic */ float[] access$1102(VEEditorSettings r100, float[] r101) {
        r100.speed = r101;
        return r101;
    }

    public static /* synthetic */ VECanvasFilterParam[] access$1202(VEEditorSettings r100, VECanvasFilterParam[] r101) {
        r100.canvasFilterParams = r101;
        return r101;
    }

    public static /* synthetic */ VEEditor.VIDEO_RATIO access$1302(VEEditorSettings r100, VEEditor.VIDEO_RATIO r101) {
        r100.videoOutRes = r101;
        return r101;
    }

    public static /* synthetic */ VEEditor.VIDEO_GRAVITY access$1402(VEEditorSettings r100, VEEditor.VIDEO_GRAVITY r101) {
        r100.videoGravity = r101;
        return r101;
    }

    public static /* synthetic */ VEEditor.VIDEO_SCALETYPE access$1502(VEEditorSettings r100, VEEditor.VIDEO_SCALETYPE r101) {
        r100.videoScaletype = r101;
        return r101;
    }

    public static /* synthetic */ VESize[] access$1602(VEEditorSettings r100, VESize[] r101) {
        r100.sizes = r101;
        return r101;
    }

    public static /* synthetic */ Bitmap[] access$202(VEEditorSettings r100, Bitmap[] r101) {
        r100.images = r101;
        return r101;
    }

    public static /* synthetic */ String[] access$302(VEEditorSettings r100, String[] r101) {
        r100.videoFileInfos = r101;
        return r101;
    }

    public static /* synthetic */ int[] access$402(VEEditorSettings r100, int[] r101) {
        r100.vTrimIn = r101;
        return r101;
    }

    public static /* synthetic */ int[] access$502(VEEditorSettings r100, int[] r101) {
        r100.vTrimOut = r101;
        return r101;
    }

    public static /* synthetic */ VETransitionFilterParam[] access$602(VEEditorSettings r100, VETransitionFilterParam[] r101) {
        r100.vTransitionFilterParam = r101;
        return r101;
    }

    public static /* synthetic */ String[] access$702(VEEditorSettings r100, String[] r101) {
        r100.audioFilePaths = r101;
        return r101;
    }

    public static /* synthetic */ String[] access$802(VEEditorSettings r100, String[] r101) {
        r100.audioFileInfos = r101;
        return r101;
    }

    public static /* synthetic */ int[] access$902(VEEditorSettings r100, int[] r101) {
        r100.aTrimIn = r101;
        return r101;
    }
}
