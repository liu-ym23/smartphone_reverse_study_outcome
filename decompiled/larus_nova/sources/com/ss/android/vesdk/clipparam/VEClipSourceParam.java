package com.ss.android.vesdk.clipparam;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
public class VEClipSourceParam {
    public static final int TEClipSourceType_AVFILE = 0;
    public static final int TEClipSourceType_ClipRef = 2;
    public static final int TEClipSourceType_Color = 1;
    public static final int TEClipSourceType_Unknown = -1;
    public int clipColorValue;
    public String clipFilePath;
    public int clipHeight;
    public int clipRefIndex;
    public String clipSegmentId;
    public int clipWidth;
    public int sourceType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TEClipSourceType {
    }

    public String toString() {
        return "VEClipSourceParam{sourceType=" + this.sourceType + ", clipFilePath='" + this.clipFilePath + "', clipSegmentId='" + this.clipSegmentId + "', clipRefIndex=" + this.clipRefIndex + ", clipColorValue=" + this.clipColorValue + ", clipWidth=" + this.clipWidth + ", clipHeight=" + this.clipHeight + '}';
    }

    public VEClipSourceParam() {
        this.clipFilePath = "";
        this.clipSegmentId = "";
    }
}
