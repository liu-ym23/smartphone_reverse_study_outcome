package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamLayoutRegionType extends Enum<MixedStreamLayoutRegionType> {
    private static final /* synthetic */ MixedStreamLayoutRegionType[] $VALUES = null;
    public static final MixedStreamLayoutRegionType MIXED_STREAM_LAYOUT_REGION_TYPE_IMAGE = null;
    public static final MixedStreamLayoutRegionType MIXED_STREAM_LAYOUT_REGION_TYPE_VIDEO_STREAM = null;
    private int regionType;

    static {
        MixedStreamLayoutRegionType r100 = new MixedStreamLayoutRegionType("MIXED_STREAM_LAYOUT_REGION_TYPE_VIDEO_STREAM", 0, 0);
        MIXED_STREAM_LAYOUT_REGION_TYPE_VIDEO_STREAM = r100;
        MixedStreamLayoutRegionType r101 = new MixedStreamLayoutRegionType("MIXED_STREAM_LAYOUT_REGION_TYPE_IMAGE", 1, 1);
        MIXED_STREAM_LAYOUT_REGION_TYPE_IMAGE = r101;
        $VALUES = new MixedStreamLayoutRegionType[]{r100, r101};
    }

    public static MixedStreamLayoutRegionType[] values() {
        return (MixedStreamLayoutRegionType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.regionType;
    }

    public static MixedStreamLayoutRegionType valueOf(String r100) {
        return (MixedStreamLayoutRegionType) a.a(MixedStreamLayoutRegionType.class, r100);
    }

    private MixedStreamLayoutRegionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.regionType = r102;
    }
}
