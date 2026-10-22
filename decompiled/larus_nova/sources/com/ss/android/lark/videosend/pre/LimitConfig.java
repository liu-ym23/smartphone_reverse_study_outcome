package com.ss.android.lark.videosend.pre;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.share.QzonePublish;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/videosend/pre/LimitConfig;", "", "fileSize", "", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "", "cpu", "diskSpaceFreeCount", "diskSpaceFreeSize", "<init>", "(JIIIJ)V", "getFileSize", "()J", "setFileSize", "(J)V", "getVideoDuration", "()I", "setVideoDuration", "(I)V", "getCpu", "setCpu", "getDiskSpaceFreeCount", "setDiskSpaceFreeCount", "getDiskSpaceFreeSize", "setDiskSpaceFreeSize", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LimitConfig {

    @SerializedName("cpu_usage")
    private int cpu;

    @SerializedName("disk_space_free_count")
    private int diskSpaceFreeCount;

    @SerializedName("disk_space_free_size")
    private long diskSpaceFreeSize;

    @SerializedName("file_size")
    private long fileSize;

    @SerializedName("video_duration")
    private int videoDuration;

    public LimitConfig() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public final int getCpu() {
        return this.cpu;
    }

    public final int getDiskSpaceFreeCount() {
        return this.diskSpaceFreeCount;
    }

    public final long getDiskSpaceFreeSize() {
        return this.diskSpaceFreeSize;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final int getVideoDuration() {
        return this.videoDuration;
    }

    public final void setCpu(int r100) {
        this.cpu = r100;
    }

    public final void setDiskSpaceFreeCount(int r100) {
        this.diskSpaceFreeCount = r100;
    }

    public final void setDiskSpaceFreeSize(long r100) {
        this.diskSpaceFreeSize = r100;
    }

    public final void setFileSize(long r100) {
        this.fileSize = r100;
    }

    public final void setVideoDuration(int r100) {
        this.videoDuration = r100;
    }

    public LimitConfig(long r100, int r101, int r102, int r103, long r104) {
        this.fileSize = r100;
        this.videoDuration = r101;
        this.cpu = r102;
        this.diskSpaceFreeCount = r103;
        this.diskSpaceFreeSize = r104;
    }

    public /* synthetic */ LimitConfig(long r100, int r110, int r111, int r112, long r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        long r101 = 5368709120L;
    L7:
        if ((r114 & 2) == 0) goto L9;
        int r102 = 300;
    L11:
        if ((r114 & 4) == 0) goto L13;
        int r103 = 80;
    L15:
        if ((r114 & 8) == 0) goto L17;
        int r104 = 5;
    L19:
        if ((r114 & 16) == 0) goto L21;
        long r105 = 524288000;
    L22:
        this(r101, r102, r103, r104, r105);
        return;
    L21:
        r105 = r113;
        goto L22
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }
}
