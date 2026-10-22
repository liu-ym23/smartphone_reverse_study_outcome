package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000e\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\rj\b\u0012\u0004\u0012\u00020\u0010`\u000e¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R.\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R.\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\rj\b\u0012\u0004\u0012\u00020\u0010`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*¨\u0006-"}, d2 = {"Lcom/ss/android/lark/videosend/tools/VideoSendConfig;", "", "limitFileSize", "", "limitVideoDuration", "", "limitVideoResolution", "Lcom/ss/android/lark/videosend/tools/ResolutionConfig;", "limitVideoFrameRate", "limitVideoBitrate", "limitDisk", "Lcom/ss/android/lark/videosend/tools/LimitDisk;", "limitTranscodeWhiteList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "limitTranscodeBlackList", "", "<init>", "(JILcom/ss/android/lark/videosend/tools/ResolutionConfig;IILcom/ss/android/lark/videosend/tools/LimitDisk;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getLimitFileSize", "()J", "setLimitFileSize", "(J)V", "getLimitVideoDuration", "()I", "setLimitVideoDuration", "(I)V", "getLimitVideoResolution", "()Lcom/ss/android/lark/videosend/tools/ResolutionConfig;", "setLimitVideoResolution", "(Lcom/ss/android/lark/videosend/tools/ResolutionConfig;)V", "getLimitVideoFrameRate", "setLimitVideoFrameRate", "getLimitVideoBitrate", "setLimitVideoBitrate", "getLimitDisk", "()Lcom/ss/android/lark/videosend/tools/LimitDisk;", "setLimitDisk", "(Lcom/ss/android/lark/videosend/tools/LimitDisk;)V", "getLimitTranscodeWhiteList", "()Ljava/util/ArrayList;", "setLimitTranscodeWhiteList", "(Ljava/util/ArrayList;)V", "getLimitTranscodeBlackList", "setLimitTranscodeBlackList", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoSendConfig {

    @SerializedName("limit_disk")
    private LimitDisk limitDisk;

    @SerializedName("limit_file_size")
    private long limitFileSize;

    @SerializedName("limit_transcode_blackList")
    private ArrayList<String> limitTranscodeBlackList;

    @SerializedName("limit_transcode_whiteList")
    private ArrayList<Integer> limitTranscodeWhiteList;

    @SerializedName("limit_video_bitrate")
    private int limitVideoBitrate;

    @SerializedName("limit_video_duration")
    private int limitVideoDuration;

    @SerializedName("limit_video_frame_rate")
    private int limitVideoFrameRate;

    @SerializedName("limit_video_resolution")
    private ResolutionConfig limitVideoResolution;

    public VideoSendConfig() {
        this(0, 0, null, 0, 0, null, null, null, 255, null);
    }

    public final LimitDisk getLimitDisk() {
        return this.limitDisk;
    }

    public final long getLimitFileSize() {
        return this.limitFileSize;
    }

    public final ArrayList<String> getLimitTranscodeBlackList() {
        return this.limitTranscodeBlackList;
    }

    public final ArrayList<Integer> getLimitTranscodeWhiteList() {
        return this.limitTranscodeWhiteList;
    }

    public final int getLimitVideoBitrate() {
        return this.limitVideoBitrate;
    }

    public final int getLimitVideoDuration() {
        return this.limitVideoDuration;
    }

    public final int getLimitVideoFrameRate() {
        return this.limitVideoFrameRate;
    }

    public final ResolutionConfig getLimitVideoResolution() {
        return this.limitVideoResolution;
    }

    public final void setLimitDisk(LimitDisk r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.limitDisk = r100;
    }

    public final void setLimitFileSize(long r100) {
        this.limitFileSize = r100;
    }

    public final void setLimitTranscodeBlackList(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.limitTranscodeBlackList = r100;
    }

    public final void setLimitTranscodeWhiteList(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.limitTranscodeWhiteList = r100;
    }

    public final void setLimitVideoBitrate(int r100) {
        this.limitVideoBitrate = r100;
    }

    public final void setLimitVideoDuration(int r100) {
        this.limitVideoDuration = r100;
    }

    public final void setLimitVideoFrameRate(int r100) {
        this.limitVideoFrameRate = r100;
    }

    public final void setLimitVideoResolution(ResolutionConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.limitVideoResolution = r100;
    }

    public VideoSendConfig(long r100, int r101, ResolutionConfig r102, int r103, int r104, LimitDisk r105, ArrayList<Integer> r106, ArrayList<String> r110) {
        Intrinsics.checkNotNullParameter(r102, "limitVideoResolution");
        Intrinsics.checkNotNullParameter(r105, "limitDisk");
        Intrinsics.checkNotNullParameter(r106, "limitTranscodeWhiteList");
        Intrinsics.checkNotNullParameter(r110, "limitTranscodeBlackList");
        this.limitFileSize = r100;
        this.limitVideoDuration = r101;
        this.limitVideoResolution = r102;
        this.limitVideoFrameRate = r103;
        this.limitVideoBitrate = r104;
        this.limitDisk = r105;
        this.limitTranscodeWhiteList = r106;
        this.limitTranscodeBlackList = r110;
    }

    public /* synthetic */ VideoSendConfig(long r110, int r111, ResolutionConfig r112, int r210, int r211, LimitDisk r212, ArrayList r213, ArrayList r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 1) == 0) goto L5;
        long r100 = 5368709120L;
    L7:
        if ((r215 & 2) == 0) goto L9;
        int r101 = 300;
    L11:
        if ((r215 & 4) == 0) goto L13;
        ResolutionConfig r102 = new ResolutionConfig(0, 0, 3, null);
    L15:
        if ((r215 & 8) == 0) goto L17;
        int r103 = 1200;
    L19:
        if ((r215 & 16) == 0) goto L21;
        int r104 = AVMDLDataLoaderConfigure.DEFAULT_MAX_CACHE_SIZE;
    L23:
        if ((r215 & 32) == 0) goto L25;
        LimitDisk r105 = new LimitDisk(0, 0, 0, 7, null);
    L27:
        if ((r215 & 64) == 0) goto L29;
        ArrayList r106 = CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(NetError.ERR_CERT_NON_UNIQUE_NAME), Integer.valueOf(NetError.ERR_CERT_KNOWN_INTERCEPTION_BLOCKED)});
    L31:
        if ((r215 & 128) == 0) goto L33;
        ArrayList r107 = CollectionsKt.arrayListOf(new String[]{".mkv"});
    L34:
        this(r100, r101, r102, r103, r104, r105, r106, r107);
        return;
    L33:
        r107 = r214;
        goto L34
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
