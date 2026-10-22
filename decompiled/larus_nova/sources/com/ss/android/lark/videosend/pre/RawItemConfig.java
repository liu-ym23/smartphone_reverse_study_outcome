package com.ss.android.lark.videosend.pre;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/videosend/pre/RawItemConfig;", "", "limitFileSize", "", "limitVideoBitrate", "", "limitVideoWidth", "limitVideoHeight", "<init>", "(JIII)V", "getLimitFileSize", "()J", "setLimitFileSize", "(J)V", "getLimitVideoBitrate", "()I", "setLimitVideoBitrate", "(I)V", "getLimitVideoWidth", "setLimitVideoWidth", "getLimitVideoHeight", "setLimitVideoHeight", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RawItemConfig {

    @SerializedName("file_size")
    private long limitFileSize;

    @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_VIDEO_BITRATE)
    private int limitVideoBitrate;

    @SerializedName("video_height")
    private int limitVideoHeight;

    @SerializedName("video_width")
    private int limitVideoWidth;

    public RawItemConfig() {
        this(0, 0, 0, 0, 15, null);
    }

    public final long getLimitFileSize() {
        return this.limitFileSize;
    }

    public final int getLimitVideoBitrate() {
        return this.limitVideoBitrate;
    }

    public final int getLimitVideoHeight() {
        return this.limitVideoHeight;
    }

    public final int getLimitVideoWidth() {
        return this.limitVideoWidth;
    }

    public final void setLimitFileSize(long r100) {
        this.limitFileSize = r100;
    }

    public final void setLimitVideoBitrate(int r100) {
        this.limitVideoBitrate = r100;
    }

    public final void setLimitVideoHeight(int r100) {
        this.limitVideoHeight = r100;
    }

    public final void setLimitVideoWidth(int r100) {
        this.limitVideoWidth = r100;
    }

    public RawItemConfig(long r100, int r101, int r102, int r103) {
        this.limitFileSize = r100;
        this.limitVideoBitrate = r101;
        this.limitVideoWidth = r102;
        this.limitVideoHeight = r103;
    }

    public /* synthetic */ RawItemConfig(long r100, int r101, int r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        r100 = 31457280;
    L5:
        long r102 = r100;
        if ((r112 & 2) == 0) goto L8;
        int r103 = 2421760;
    L10:
        if ((r112 & 4) == 0) goto L12;
        int r104 = 2160;
    L14:
        if ((r112 & 8) == 0) goto L16;
        int r105 = 3840;
    L17:
        this(r102, r103, r104, r105);
        return;
    L16:
        r105 = r111;
        goto L17
    L12:
        r104 = r110;
        goto L14
    L8:
        r103 = r101;
        goto L10
    }
}
