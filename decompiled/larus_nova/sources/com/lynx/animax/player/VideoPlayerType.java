package com.lynx.animax.player;

/* JADX INFO: loaded from: classes32.dex */
public final enum VideoPlayerType extends Enum<VideoPlayerType> {
    public static final VideoPlayerType CUSTOM = null;
    public static final VideoPlayerType DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoPlayerType[] f380342a = null;

    static {
        VideoPlayerType r100 = new VideoPlayerType("DEFAULT", 0);
        DEFAULT = r100;
        VideoPlayerType r101 = new VideoPlayerType("CUSTOM", 1);
        CUSTOM = r101;
        f380342a = new VideoPlayerType[]{r100, r101};
    }

    public static VideoPlayerType[] values() {
        return (VideoPlayerType[]) f380342a.clone();
    }

    public static VideoPlayerType valueOf(String r100) {
        return (VideoPlayerType) r27.a.a(VideoPlayerType.class, r100);
    }

    public VideoPlayerType(String r100, int r101) {
        super(r100, r101);
    }
}
