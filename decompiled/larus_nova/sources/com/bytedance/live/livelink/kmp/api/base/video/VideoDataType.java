package com.bytedance.live.livelink.kmp.api.base.video;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/video/VideoDataType;", "", "Null", "Nv12", "Nv21", "I420", "Texture", "RGBA", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VideoDataType extends Enum<VideoDataType> {
    public static final VideoDataType I420 = null;
    public static final VideoDataType Null = null;
    public static final VideoDataType Nv12 = null;
    public static final VideoDataType Nv21 = null;
    public static final VideoDataType RGBA = null;
    public static final VideoDataType Texture = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoDataType[] f255228a = null;

    static {
        VideoDataType r100 = new VideoDataType("Null", 0);
        Null = r100;
        VideoDataType r101 = new VideoDataType("Nv12", 1);
        Nv12 = r101;
        VideoDataType r102 = new VideoDataType("Nv21", 2);
        Nv21 = r102;
        VideoDataType r103 = new VideoDataType("I420", 3);
        I420 = r103;
        VideoDataType r104 = new VideoDataType("Texture", 4);
        Texture = r104;
        VideoDataType r105 = new VideoDataType("RGBA", 5);
        RGBA = r105;
        f255228a = new VideoDataType[]{r100, r101, r102, r103, r104, r105};
    }

    public static VideoDataType valueOf(String r100) {
        return (VideoDataType) a.a(VideoDataType.class, r100);
    }

    public static VideoDataType[] values() {
        return (VideoDataType[]) f255228a.clone();
    }

    public VideoDataType(String r100, int r101) {
        super(r100, r101);
    }
}
