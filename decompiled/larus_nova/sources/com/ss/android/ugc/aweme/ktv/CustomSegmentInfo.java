package com.ss.android.ugc.aweme.ktv;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/ktv/CustomSegmentInfo;", "Ljava/io/Serializable;", "()V", "lyricStartTime", "", "getLyricStartTime", "()I", "setLyricStartTime", "(I)V", "shootDuration", "getShootDuration", "setShootDuration", "startTimeOffset", "getStartTimeOffset", "setStartTimeOffset", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class CustomSegmentInfo implements Serializable {

    @SerializedName("lyric_start_time")
    private int lyricStartTime;

    @SerializedName("shoot_duration")
    private int shootDuration;

    @SerializedName("start_time_offset")
    private int startTimeOffset;

    public CustomSegmentInfo() {
    }

    public final int getLyricStartTime() {
        return this.lyricStartTime;
    }

    public final int getShootDuration() {
        return this.shootDuration;
    }

    public final int getStartTimeOffset() {
        return this.startTimeOffset;
    }

    public final void setLyricStartTime(int r100) {
        this.lyricStartTime = r100;
    }

    public final void setShootDuration(int r100) {
        this.shootDuration = r100;
    }

    public final void setStartTimeOffset(int r100) {
        this.startTimeOffset = r100;
    }
}
