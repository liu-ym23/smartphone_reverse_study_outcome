package com.ss.android.ttve.model;

/* JADX INFO: loaded from: classes38.dex */
public class MVResourceBean {
    public static final int ETEMVTimeModeEmptyEnd = 0;
    public static final int ETEMVTimeModeEmptyStart = 1;
    public static final int ETEMVTimeModeFillEnd = 2;
    public static final int ETEMVTimeModeFillStart = 3;
    public static final int ETEMVTimeModeRepeat = 4;
    public static final int ETEMVTimeModeStretch = 5;
    public int clipIndex;
    public String content;
    public int isLoop;
    public boolean isMute;
    public double musicFadeIn;
    public double musicFadeOut;
    public int rid;
    public double seqIn;
    public double seqOut;
    public int timeMode;
    public int trackIndex;
    public double trimIn;
    public double trimOut;
    public String type;

    public MVResourceBean() {
        this.trackIndex = -1;
        this.clipIndex = -1;
        this.isLoop = 0;
        this.isMute = false;
        this.timeMode = 0;
    }
}
