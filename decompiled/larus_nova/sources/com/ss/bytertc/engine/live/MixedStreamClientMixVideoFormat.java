package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamClientMixVideoFormat extends Enum<MixedStreamClientMixVideoFormat> {
    private static final /* synthetic */ MixedStreamClientMixVideoFormat[] $VALUES = null;
    public static final MixedStreamClientMixVideoFormat MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_CVPIXEL_BUFFER_BGRA = null;
    public static final MixedStreamClientMixVideoFormat MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_TEXTURE_2D = null;
    public static final MixedStreamClientMixVideoFormat MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_I420 = null;
    public static final MixedStreamClientMixVideoFormat MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_NV12 = null;
    private int videoFormat;

    static {
        MixedStreamClientMixVideoFormat r100 = new MixedStreamClientMixVideoFormat("MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_I420", 0, 0);
        MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_I420 = r100;
        MixedStreamClientMixVideoFormat r101 = new MixedStreamClientMixVideoFormat("MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_TEXTURE_2D", 1, 1);
        MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_TEXTURE_2D = r101;
        MixedStreamClientMixVideoFormat r102 = new MixedStreamClientMixVideoFormat("MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_CVPIXEL_BUFFER_BGRA", 2, 2);
        MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_CVPIXEL_BUFFER_BGRA = r102;
        MixedStreamClientMixVideoFormat r103 = new MixedStreamClientMixVideoFormat("MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_NV12", 3, 3);
        MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_NV12 = r103;
        $VALUES = new MixedStreamClientMixVideoFormat[]{r100, r101, r102, r103};
    }

    public static MixedStreamClientMixVideoFormat[] values() {
        return (MixedStreamClientMixVideoFormat[]) $VALUES.clone();
    }

    public int getValue() {
        return this.videoFormat;
    }

    public static MixedStreamClientMixVideoFormat valueOf(String r100) {
        return (MixedStreamClientMixVideoFormat) a.a(MixedStreamClientMixVideoFormat.class, r100);
    }

    private MixedStreamClientMixVideoFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.videoFormat = r102;
    }
}
