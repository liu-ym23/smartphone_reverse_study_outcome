package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/videosend/tools/VideoCoverLimit;", "", "limitEnable", "", "limitQuality", "limitBigSideMax", "limitSmallSideMax", "<init>", "(IIII)V", "getLimitEnable", "()I", "setLimitEnable", "(I)V", "getLimitQuality", "setLimitQuality", "getLimitBigSideMax", "setLimitBigSideMax", "getLimitSmallSideMax", "setLimitSmallSideMax", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoCoverLimit {

    @SerializedName("limit_big_side_max")
    private int limitBigSideMax;

    @SerializedName("limit_enable")
    private int limitEnable;

    @SerializedName("limit_quality")
    private int limitQuality;

    @SerializedName("limit_small_side_max")
    private int limitSmallSideMax;

    public VideoCoverLimit() {
        this(0, 0, 0, 0, 15, null);
    }

    public final int getLimitBigSideMax() {
        return this.limitBigSideMax;
    }

    public final int getLimitEnable() {
        return this.limitEnable;
    }

    public final int getLimitQuality() {
        return this.limitQuality;
    }

    public final int getLimitSmallSideMax() {
        return this.limitSmallSideMax;
    }

    public final void setLimitBigSideMax(int r100) {
        this.limitBigSideMax = r100;
    }

    public final void setLimitEnable(int r100) {
        this.limitEnable = r100;
    }

    public final void setLimitQuality(int r100) {
        this.limitQuality = r100;
    }

    public final void setLimitSmallSideMax(int r100) {
        this.limitSmallSideMax = r100;
    }

    public VideoCoverLimit(int r100, int r101, int r102, int r103) {
        this.limitEnable = r100;
        this.limitQuality = r101;
        this.limitBigSideMax = r102;
        this.limitSmallSideMax = r103;
    }

    public /* synthetic */ VideoCoverLimit(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 75;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 640;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 360;
    L14:
        this(r100, r101, r102, r103);
    }
}
