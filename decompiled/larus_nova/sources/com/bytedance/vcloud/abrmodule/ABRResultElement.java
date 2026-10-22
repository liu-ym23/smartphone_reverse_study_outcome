package com.bytedance.vcloud.abrmodule;

/* JADX INFO: loaded from: classes22.dex */
public class ABRResultElement {
    public static final int FULL_SCREEN_NO_SR_ONCE_RESULT = 3;
    public static final int FULL_SCREEN_ONCE_RESULT = 2;
    public static final int NORMAL_ONCE_RESULT = 0;
    public static final int NO_SR_ONCE_RESULT = 1;
    private long bitrate;
    private int cacheTime;
    private int mediaType;
    private int onceSelectType;
    private int seconds;
    private int useSR;

    public long getBitrate() {
        return this.bitrate;
    }

    public int getCacheTime() {
        return this.cacheTime;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public int getOnceSelectType() {
        return this.onceSelectType;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public int getUseSR() {
        return this.useSR;
    }

    public ABRResultElement(long r100, int r101, int r102, int r103) {
        this.bitrate = r100;
        this.seconds = r101;
        this.mediaType = r102;
        this.cacheTime = r103;
        this.useSR = 0;
        this.onceSelectType = 0;
    }

    public ABRResultElement(long r100, int r101, int r102, int r103, int r104) {
        this.bitrate = r100;
        this.seconds = r101;
        this.mediaType = r102;
        this.cacheTime = r103;
        this.useSR = r104;
        this.onceSelectType = 0;
    }

    public ABRResultElement(long r100, int r101, int r102, int r103, int r104, int r105) {
        this.bitrate = r100;
        this.seconds = r101;
        this.mediaType = r102;
        this.cacheTime = r103;
        this.useSR = r104;
        this.onceSelectType = r105;
    }
}
