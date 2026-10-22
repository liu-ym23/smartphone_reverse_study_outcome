package com.bytedance.cloudplay.xplay2.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/VideoPixelFormat;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "I420", "NV12", "NV21", "RGB24", "RGBA", "ARGB", "BGRA", "TEXTURE_2D", "TEXTURE_OES", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum VideoPixelFormat extends Enum<VideoPixelFormat> {
    public static final VideoPixelFormat ARGB = null;
    public static final VideoPixelFormat BGRA = null;
    public static final VideoPixelFormat I420 = null;
    public static final VideoPixelFormat NV12 = null;
    public static final VideoPixelFormat NV21 = null;
    public static final VideoPixelFormat RGB24 = null;
    public static final VideoPixelFormat RGBA = null;
    public static final VideoPixelFormat TEXTURE_2D = null;
    public static final VideoPixelFormat TEXTURE_OES = null;
    public static final VideoPixelFormat UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoPixelFormat[] f202792a = null;
    private final int value;

    public static VideoPixelFormat valueOf(String r100) {
        return (VideoPixelFormat) a.a(VideoPixelFormat.class, r100);
    }

    public static VideoPixelFormat[] values() {
        return (VideoPixelFormat[]) f202792a.clone();
    }

    static {
        VideoPixelFormat r100 = new VideoPixelFormat("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        VideoPixelFormat r101 = new VideoPixelFormat("I420", 1, 1);
        I420 = r101;
        VideoPixelFormat r102 = new VideoPixelFormat("NV12", 2, 2);
        NV12 = r102;
        VideoPixelFormat r103 = new VideoPixelFormat("NV21", 3, 3);
        NV21 = r103;
        VideoPixelFormat r104 = new VideoPixelFormat("RGB24", 4, 4);
        RGB24 = r104;
        VideoPixelFormat r105 = new VideoPixelFormat("RGBA", 5, 5);
        RGBA = r105;
        VideoPixelFormat r110 = new VideoPixelFormat("ARGB", 6, 6);
        ARGB = r110;
        VideoPixelFormat r111 = new VideoPixelFormat("BGRA", 7, 7);
        BGRA = r111;
        VideoPixelFormat r112 = new VideoPixelFormat("TEXTURE_2D", 8, 8);
        TEXTURE_2D = r112;
        VideoPixelFormat r113 = new VideoPixelFormat("TEXTURE_OES", 9, 9);
        TEXTURE_OES = r113;
        f202792a = new VideoPixelFormat[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public final int getValue() {
        return this.value;
    }

    public VideoPixelFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
