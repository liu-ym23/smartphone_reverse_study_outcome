package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamVideoType extends Enum<MixedStreamVideoType> {
    private static final /* synthetic */ MixedStreamVideoType[] $VALUES = null;
    public static final MixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_3RD = null;
    public static final MixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_4TH = null;
    public static final MixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_5TH = null;
    public static final MixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_6TH = null;
    public static final MixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_7TH = null;
    public static final MixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_8TH = null;
    public static final MixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_MAIN = null;
    public static final MixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_SCREEN = null;
    private int videoType;

    static {
        MixedStreamVideoType r100 = new MixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_MAIN", 0, 0);
        MIXED_STREAM_VIDEO_TYPE_MAIN = r100;
        MixedStreamVideoType r101 = new MixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_SCREEN", 1, 1);
        MIXED_STREAM_VIDEO_TYPE_SCREEN = r101;
        MixedStreamVideoType r102 = new MixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_3RD", 2, 2);
        MIXED_STREAM_VIDEO_TYPE_3RD = r102;
        MixedStreamVideoType r103 = new MixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_4TH", 3, 3);
        MIXED_STREAM_VIDEO_TYPE_4TH = r103;
        MixedStreamVideoType r104 = new MixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_5TH", 4, 4);
        MIXED_STREAM_VIDEO_TYPE_5TH = r104;
        MixedStreamVideoType r105 = new MixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_6TH", 5, 5);
        MIXED_STREAM_VIDEO_TYPE_6TH = r105;
        MixedStreamVideoType r110 = new MixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_7TH", 6, 6);
        MIXED_STREAM_VIDEO_TYPE_7TH = r110;
        MixedStreamVideoType r111 = new MixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_8TH", 7, 7);
        MIXED_STREAM_VIDEO_TYPE_8TH = r111;
        $VALUES = new MixedStreamVideoType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static MixedStreamVideoType[] values() {
        return (MixedStreamVideoType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.videoType;
    }

    public static MixedStreamVideoType valueOf(String r100) {
        return (MixedStreamVideoType) a.a(MixedStreamVideoType.class, r100);
    }

    private MixedStreamVideoType(String r100, int r101, int r102) {
        super(r100, r101);
        this.videoType = r102;
    }
}
