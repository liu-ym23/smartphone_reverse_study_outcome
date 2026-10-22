package com.relax.relaxframework;

import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b#\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006%"}, d2 = {"Lcom/relax/relaxframework/VideoEventKey;", "", "", "value", "I", "getValue", "()I", VideoPlayDataContext.TAG, "VideoPause", "VideoEnded", "VideoError", "VideoTimeUpdate", "VideoBufferingChange", "VideoSeek", "VideoCanPlay", "VideoLoadedMetadata", "VideoPlaying", "VideoWaiting", "VideoAbort", "VideoCanplayThrough", "VideoDurationChange", "VideoEmptied", "VideoLoadeddata", "VideoLoadStart", "VideoProgress", "VideoRateChange", "VideoSeeked", "VideoSeeking", "VideoStalled", "VideoSuspend", "VideoVolumeChange", "VideoFirstFrame", "VideoVideoInfos", "VideoStart", "VideoReady", "VideoCompletion", "VideoUpdate", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum VideoEventKey extends Enum<VideoEventKey> {
    public static final VideoEventKey VideoAbort = null;
    public static final VideoEventKey VideoBufferingChange = null;
    public static final VideoEventKey VideoCanPlay = null;
    public static final VideoEventKey VideoCanplayThrough = null;
    public static final VideoEventKey VideoCompletion = null;
    public static final VideoEventKey VideoDurationChange = null;
    public static final VideoEventKey VideoEmptied = null;
    public static final VideoEventKey VideoEnded = null;
    public static final VideoEventKey VideoError = null;
    public static final VideoEventKey VideoFirstFrame = null;
    public static final VideoEventKey VideoLoadStart = null;
    public static final VideoEventKey VideoLoadedMetadata = null;
    public static final VideoEventKey VideoLoadeddata = null;
    public static final VideoEventKey VideoPause = null;
    public static final VideoEventKey VideoPlay = null;
    public static final VideoEventKey VideoPlaying = null;
    public static final VideoEventKey VideoProgress = null;
    public static final VideoEventKey VideoRateChange = null;
    public static final VideoEventKey VideoReady = null;
    public static final VideoEventKey VideoSeek = null;
    public static final VideoEventKey VideoSeeked = null;
    public static final VideoEventKey VideoSeeking = null;
    public static final VideoEventKey VideoStalled = null;
    public static final VideoEventKey VideoStart = null;
    public static final VideoEventKey VideoSuspend = null;
    public static final VideoEventKey VideoTimeUpdate = null;
    public static final VideoEventKey VideoUpdate = null;
    public static final VideoEventKey VideoVideoInfos = null;
    public static final VideoEventKey VideoVolumeChange = null;
    public static final VideoEventKey VideoWaiting = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoEventKey[] f404984a = null;
    private final int value;

    public static VideoEventKey valueOf(String r100) {
        return (VideoEventKey) r27.a.a(VideoEventKey.class, r100);
    }

    public static VideoEventKey[] values() {
        return (VideoEventKey[]) f404984a.clone();
    }

    static {
        VideoEventKey r100 = new VideoEventKey(VideoPlayDataContext.TAG, 0, 30030);
        VideoPlay = r100;
        VideoEventKey r101 = new VideoEventKey("VideoPause", 1, 30031);
        VideoPause = r101;
        VideoEventKey r102 = new VideoEventKey("VideoEnded", 2, 30032);
        VideoEnded = r102;
        VideoEventKey r103 = new VideoEventKey("VideoError", 3, 30033);
        VideoError = r103;
        VideoEventKey r104 = new VideoEventKey("VideoTimeUpdate", 4, 30034);
        VideoTimeUpdate = r104;
        VideoEventKey r105 = new VideoEventKey("VideoBufferingChange", 5, 30035);
        VideoBufferingChange = r105;
        VideoEventKey r110 = new VideoEventKey("VideoSeek", 6, 30036);
        VideoSeek = r110;
        VideoEventKey r111 = new VideoEventKey("VideoCanPlay", 7, 30037);
        VideoCanPlay = r111;
        VideoEventKey r112 = new VideoEventKey("VideoLoadedMetadata", 8, 30038);
        VideoLoadedMetadata = r112;
        VideoEventKey r113 = new VideoEventKey("VideoPlaying", 9, 30039);
        VideoPlaying = r113;
        VideoEventKey r114 = new VideoEventKey("VideoWaiting", 10, 30040);
        VideoWaiting = r114;
        VideoEventKey r106 = new VideoEventKey("VideoAbort", 11, 30041);
        VideoAbort = r106;
        VideoEventKey r107 = new VideoEventKey("VideoCanplayThrough", 12, 30042);
        VideoCanplayThrough = r107;
        VideoEventKey r108 = new VideoEventKey("VideoDurationChange", 13, 30043);
        VideoDurationChange = r108;
        VideoEventKey r109 = new VideoEventKey("VideoEmptied", 14, 30044);
        VideoEmptied = r109;
        VideoEventKey r115 = new VideoEventKey("VideoLoadeddata", 15, 30045);
        VideoLoadeddata = r115;
        VideoEventKey r116 = new VideoEventKey("VideoLoadStart", 16, 30046);
        VideoLoadStart = r116;
        VideoEventKey r117 = new VideoEventKey("VideoProgress", 17, 30047);
        VideoProgress = r117;
        VideoEventKey r118 = new VideoEventKey("VideoRateChange", 18, 30048);
        VideoRateChange = r118;
        VideoEventKey r119 = new VideoEventKey("VideoSeeked", 19, 30049);
        VideoSeeked = r119;
        VideoEventKey r120 = new VideoEventKey("VideoSeeking", 20, 30050);
        VideoSeeking = r120;
        VideoEventKey r121 = new VideoEventKey("VideoStalled", 21, 30051);
        VideoStalled = r121;
        VideoEventKey r122 = new VideoEventKey("VideoSuspend", 22, 30052);
        VideoSuspend = r122;
        VideoEventKey r123 = new VideoEventKey("VideoVolumeChange", 23, 30053);
        VideoVolumeChange = r123;
        VideoEventKey r124 = new VideoEventKey("VideoFirstFrame", 24, 30054);
        VideoFirstFrame = r124;
        VideoEventKey r125 = new VideoEventKey("VideoVideoInfos", 25, 30055);
        VideoVideoInfos = r125;
        VideoEventKey r126 = new VideoEventKey("VideoStart", 26, 30056);
        VideoStart = r126;
        VideoEventKey r127 = new VideoEventKey("VideoReady", 27, 30057);
        VideoReady = r127;
        VideoEventKey r128 = new VideoEventKey("VideoCompletion", 28, 30058);
        VideoCompletion = r128;
        VideoEventKey r129 = new VideoEventKey("VideoUpdate", 29, 30059);
        VideoUpdate = r129;
        f404984a = new VideoEventKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129};
    }

    public final int getValue() {
        return this.value;
    }

    public VideoEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
