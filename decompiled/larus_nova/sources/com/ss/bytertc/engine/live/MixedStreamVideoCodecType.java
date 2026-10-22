package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamVideoCodecType extends Enum<MixedStreamVideoCodecType> {
    private static final /* synthetic */ MixedStreamVideoCodecType[] $VALUES = null;
    public static final MixedStreamVideoCodecType MIXED_STREAM_VIDEO_CODEC_TYPE_BYTEVC1 = null;
    public static final MixedStreamVideoCodecType MIXED_STREAM_VIDEO_CODEC_TYPE_H264 = null;
    private String videoCodecType;

    static {
        MixedStreamVideoCodecType r100 = new MixedStreamVideoCodecType("MIXED_STREAM_VIDEO_CODEC_TYPE_H264", 0, "H264");
        MIXED_STREAM_VIDEO_CODEC_TYPE_H264 = r100;
        MixedStreamVideoCodecType r101 = new MixedStreamVideoCodecType("MIXED_STREAM_VIDEO_CODEC_TYPE_BYTEVC1", 1, "ByteVC1");
        MIXED_STREAM_VIDEO_CODEC_TYPE_BYTEVC1 = r101;
        $VALUES = new MixedStreamVideoCodecType[]{r100, r101};
    }

    public static MixedStreamVideoCodecType[] values() {
        return (MixedStreamVideoCodecType[]) $VALUES.clone();
    }

    public String getValue() {
        return this.videoCodecType;
    }

    public static MixedStreamVideoCodecType valueOf(String r100) {
        return (MixedStreamVideoCodecType) a.a(MixedStreamVideoCodecType.class, r100);
    }

    private MixedStreamVideoCodecType(String r100, int r101, String r102) {
        super(r100, r101);
        this.videoCodecType = r102;
    }
}
