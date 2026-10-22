package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/relax/relaxframework/VideoAttributeKey;", "", "", "value", "I", "getValue", "()I", "Src", "Autoplay", "InitTime", "Loop", "Muted", "Speed", "Volume", "Rate", "Poster", "ObjectFit", "VideoWidth", "VideoHeight", "IntrinsicWidth", "IntrinsicHeight", "Controls", "Cache", "PreloadKey", "ReuseEngine", "RenderMode", "Control", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum VideoAttributeKey extends Enum<VideoAttributeKey> {
    public static final VideoAttributeKey Autoplay = null;
    public static final VideoAttributeKey Cache = null;
    public static final VideoAttributeKey Control = null;
    public static final VideoAttributeKey Controls = null;
    public static final VideoAttributeKey InitTime = null;
    public static final VideoAttributeKey IntrinsicHeight = null;
    public static final VideoAttributeKey IntrinsicWidth = null;
    public static final VideoAttributeKey Loop = null;
    public static final VideoAttributeKey Muted = null;
    public static final VideoAttributeKey ObjectFit = null;
    public static final VideoAttributeKey Poster = null;
    public static final VideoAttributeKey PreloadKey = null;
    public static final VideoAttributeKey Rate = null;
    public static final VideoAttributeKey RenderMode = null;
    public static final VideoAttributeKey ReuseEngine = null;
    public static final VideoAttributeKey Speed = null;
    public static final VideoAttributeKey Src = null;
    public static final VideoAttributeKey VideoHeight = null;
    public static final VideoAttributeKey VideoWidth = null;
    public static final VideoAttributeKey Volume = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoAttributeKey[] f404983a = null;
    private final int value;

    public static VideoAttributeKey valueOf(String r100) {
        return (VideoAttributeKey) r27.a.a(VideoAttributeKey.class, r100);
    }

    public static VideoAttributeKey[] values() {
        return (VideoAttributeKey[]) f404983a.clone();
    }

    static {
        VideoAttributeKey r100 = new VideoAttributeKey("Src", 0, 20002);
        Src = r100;
        VideoAttributeKey r101 = new VideoAttributeKey("Autoplay", 1, 20043);
        Autoplay = r101;
        VideoAttributeKey r102 = new VideoAttributeKey("InitTime", 2, 20156);
        InitTime = r102;
        VideoAttributeKey r103 = new VideoAttributeKey("Loop", 3, 20157);
        Loop = r103;
        VideoAttributeKey r104 = new VideoAttributeKey("Muted", 4, 20159);
        Muted = r104;
        VideoAttributeKey r105 = new VideoAttributeKey("Speed", 5, 20160);
        Speed = r105;
        VideoAttributeKey r110 = new VideoAttributeKey("Volume", 6, 20161);
        Volume = r110;
        VideoAttributeKey r111 = new VideoAttributeKey("Rate", 7, 20162);
        Rate = r111;
        VideoAttributeKey r112 = new VideoAttributeKey("Poster", 8, 20164);
        Poster = r112;
        VideoAttributeKey r113 = new VideoAttributeKey("ObjectFit", 9, 20165);
        ObjectFit = r113;
        VideoAttributeKey r114 = new VideoAttributeKey("VideoWidth", 10, 20167);
        VideoWidth = r114;
        VideoAttributeKey r106 = new VideoAttributeKey("VideoHeight", 11, 20168);
        VideoHeight = r106;
        VideoAttributeKey r107 = new VideoAttributeKey("IntrinsicWidth", 12, 20169);
        IntrinsicWidth = r107;
        VideoAttributeKey r108 = new VideoAttributeKey("IntrinsicHeight", 13, 20170);
        IntrinsicHeight = r108;
        VideoAttributeKey r109 = new VideoAttributeKey("Controls", 14, 20174);
        Controls = r109;
        VideoAttributeKey r115 = new VideoAttributeKey("Cache", 15, 20171);
        Cache = r115;
        VideoAttributeKey r116 = new VideoAttributeKey("PreloadKey", 16, 20172);
        PreloadKey = r116;
        VideoAttributeKey r117 = new VideoAttributeKey("ReuseEngine", 17, 20177);
        ReuseEngine = r117;
        VideoAttributeKey r118 = new VideoAttributeKey("RenderMode", 18, 20178);
        RenderMode = r118;
        VideoAttributeKey r119 = new VideoAttributeKey("Control", 19, 20173);
        Control = r119;
        f404983a = new VideoAttributeKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119};
    }

    public final int getValue() {
        return this.value;
    }

    public VideoAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
