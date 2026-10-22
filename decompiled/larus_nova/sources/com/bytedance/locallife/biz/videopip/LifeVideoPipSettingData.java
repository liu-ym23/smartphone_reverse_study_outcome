package com.bytedance.locallife.biz.videopip;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/biz/videopip/LifeVideoPipSettingData;", "", "()V", "adaptScreen", "", "getAdaptScreen", "()I", "defaultPositionX", "getDefaultPositionX", "defaultPositionYRatio", "", "getDefaultPositionYRatio", "()F", "dislikeActionCount", "getDislikeActionCount", "dislikeDuration", "getDislikeDuration", "enablePipWindowOpt", "getEnablePipWindowOpt", "smallWindowRecord", "getSmallWindowRecord", "videoPipSize", "getVideoPipSize", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LifeVideoPipSettingData {

    @SerializedName("adapt_screen")
    private final int adaptScreen;

    @SerializedName("default_position_x")
    private final int defaultPositionX;

    @SerializedName("default_position_y_ratio")
    private final float defaultPositionYRatio;

    @SerializedName("dislike_action_count")
    private final int dislikeActionCount;

    @SerializedName("dislike_duration")
    private final int dislikeDuration;

    @SerializedName("enable_pip_window_opt")
    private final int enablePipWindowOpt;

    @SerializedName("small_window_record")
    private final int smallWindowRecord;

    @SerializedName("video_pip_size")
    private final int videoPipSize;

    public LifeVideoPipSettingData() {
        this.dislikeDuration = 7;
        this.dislikeActionCount = 2;
        this.videoPipSize = 80;
    }

    public final int getAdaptScreen() {
        return this.adaptScreen;
    }

    public final int getDefaultPositionX() {
        return this.defaultPositionX;
    }

    public final float getDefaultPositionYRatio() {
        return this.defaultPositionYRatio;
    }

    public final int getDislikeActionCount() {
        return this.dislikeActionCount;
    }

    public final int getDislikeDuration() {
        return this.dislikeDuration;
    }

    public final int getEnablePipWindowOpt() {
        return this.enablePipWindowOpt;
    }

    public final int getSmallWindowRecord() {
        return this.smallWindowRecord;
    }

    public final int getVideoPipSize() {
        return this.videoPipSize;
    }
}
