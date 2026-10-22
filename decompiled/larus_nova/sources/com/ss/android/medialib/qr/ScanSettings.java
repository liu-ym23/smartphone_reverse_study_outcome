package com.ss.android.medialib.qr;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes38.dex */
public class ScanSettings {
    public int buildChainFlag;
    public String detectModelDir;
    public float detectRectHeight;
    public float detectRectLeft;
    public float detectRectTop;
    public float detectRectWidth;
    public long detectRequirement;
    public boolean enableDetectRect;
    public int height;
    public int width;

    public ScanSettings() {
        this.width = -1;
        this.height = -1;
        this.detectRectLeft = 0.0f;
        this.detectRectTop = 0.0f;
        this.detectRectWidth = 0.0f;
        this.detectRectHeight = 0.0f;
        this.enableDetectRect = false;
        this.detectRequirement = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        this.buildChainFlag = 1;
    }

    public int getBuildChainFlag() {
        return this.buildChainFlag;
    }

    public String getDetectModelDir() {
        return this.detectModelDir;
    }

    public long getDetectRequirement() {
        return this.detectRequirement;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
