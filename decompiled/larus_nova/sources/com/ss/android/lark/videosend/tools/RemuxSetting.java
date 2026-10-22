package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/videosend/tools/RemuxSetting;", "", "bigSideMax", "", "smallSideMax", "fpsMax", "bitrateMax", "<init>", "(IIII)V", "getBigSideMax", "()I", "setBigSideMax", "(I)V", "getSmallSideMax", "setSmallSideMax", "getFpsMax", "setFpsMax", "getBitrateMax", "setBitrateMax", "toString", "", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemuxSetting {

    @SerializedName("big_side_max")
    private int bigSideMax;

    @SerializedName("bitrate_max")
    private int bitrateMax;

    @SerializedName("fps_max")
    private int fpsMax;

    @SerializedName("small_side_max")
    private int smallSideMax;

    public RemuxSetting() {
        this(0, 0, 0, 0, 15, null);
    }

    public String toString() {
        return "bigSideMax=" + this.bigSideMax + ",smallSideMax=" + this.smallSideMax + ",fpsMax=" + this.fpsMax + ",bitrateMax=" + this.bitrateMax;
    }

    public final int getBigSideMax() {
        return this.bigSideMax;
    }

    public final int getBitrateMax() {
        return this.bitrateMax;
    }

    public final int getFpsMax() {
        return this.fpsMax;
    }

    public final int getSmallSideMax() {
        return this.smallSideMax;
    }

    public final void setBigSideMax(int r100) {
        this.bigSideMax = r100;
    }

    public final void setBitrateMax(int r100) {
        this.bitrateMax = r100;
    }

    public final void setFpsMax(int r100) {
        this.fpsMax = r100;
    }

    public final void setSmallSideMax(int r100) {
        this.smallSideMax = r100;
    }

    public RemuxSetting(int r100, int r101, int r102, int r103) {
        this.bigSideMax = r100;
        this.smallSideMax = r101;
        this.fpsMax = r102;
        this.bitrateMax = r103;
    }

    public /* synthetic */ RemuxSetting(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 960;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 540;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 60;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 2365;
    L14:
        this(r100, r101, r102, r103);
    }
}
