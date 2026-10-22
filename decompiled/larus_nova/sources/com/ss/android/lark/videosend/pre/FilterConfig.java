package com.ss.android.lark.videosend.pre;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/videosend/pre/FilterConfig;", "", "mediaCount", "", "videoCount", VideoThumbInfo.KEY_INTERVAL, "<init>", "(III)V", "getMediaCount", "()I", "setMediaCount", "(I)V", "getVideoCount", "setVideoCount", "getInterval", "setInterval", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterConfig {

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private int interval;

    @SerializedName("media_count")
    private int mediaCount;

    @SerializedName("video_count")
    private int videoCount;

    public FilterConfig() {
        this(0, 0, 0, 7, null);
    }

    public final int getInterval() {
        return this.interval;
    }

    public final int getMediaCount() {
        return this.mediaCount;
    }

    public final int getVideoCount() {
        return this.videoCount;
    }

    public final void setInterval(int r100) {
        this.interval = r100;
    }

    public final void setMediaCount(int r100) {
        this.mediaCount = r100;
    }

    public final void setVideoCount(int r100) {
        this.videoCount = r100;
    }

    public FilterConfig(int r100, int r101, int r102) {
        this.mediaCount = r100;
        this.videoCount = r101;
        this.interval = r102;
    }

    public /* synthetic */ FilterConfig(int r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 10;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 3;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 900;
    L11:
        this(r100, r101, r102);
    }
}
