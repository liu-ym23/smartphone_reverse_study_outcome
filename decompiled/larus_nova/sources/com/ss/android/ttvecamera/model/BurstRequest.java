package com.ss.android.ttvecamera.model;

import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class BurstRequest {
    public static final int BURST_TYPE_BURST = 1;
    public static final int BURST_TYPE_NORMAL = 0;
    public List<Integer> aeExposureValues;
    public int burstType;
    public boolean canStopRepeating;
    public int frameInterval;
    public int imageHeight;
    public int imageWidth;

    public BurstRequest() {
        this.burstType = 0;
        this.aeExposureValues = null;
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.frameInterval = 0;
        this.canStopRepeating = false;
    }
}
