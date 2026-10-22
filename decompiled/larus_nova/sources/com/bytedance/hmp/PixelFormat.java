package com.bytedance.hmp;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum PixelFormat extends Enum<PixelFormat> {
    private static final /* synthetic */ PixelFormat[] $VALUES = null;
    public static final PixelFormat PF_GRAY16 = null;
    public static final PixelFormat PF_GRAY8 = null;
    public static final PixelFormat PF_NONE = null;
    public static final PixelFormat PF_NV12 = null;
    public static final PixelFormat PF_NV21 = null;
    public static final PixelFormat PF_RGB24 = null;
    public static final PixelFormat PF_RGB48 = null;
    public static final PixelFormat PF_RGBA32 = null;
    public static final PixelFormat PF_RGBA64 = null;
    public static final PixelFormat PF_YUV420P = null;
    public static final PixelFormat PF_YUV422P = null;
    public static final PixelFormat PF_YUV444P = null;
    public static final PixelFormat PF_YUVA420P = null;
    private final int value;

    static {
        PixelFormat r100 = new PixelFormat("PF_NONE", 0, -1);
        PF_NONE = r100;
        PixelFormat r101 = new PixelFormat("PF_YUV420P", 1, 0);
        PF_YUV420P = r101;
        PixelFormat r102 = new PixelFormat("PF_YUV422P", 2, 4);
        PF_YUV422P = r102;
        PixelFormat r103 = new PixelFormat("PF_YUV444P", 3, 5);
        PF_YUV444P = r103;
        PixelFormat r104 = new PixelFormat("PF_NV12", 4, 23);
        PF_NV12 = r104;
        PixelFormat r110 = new PixelFormat("PF_NV21", 5, 24);
        PF_NV21 = r110;
        PixelFormat r111 = new PixelFormat("PF_GRAY8", 6, 8);
        PF_GRAY8 = r111;
        PixelFormat r112 = new PixelFormat("PF_RGB24", 7, 2);
        PF_RGB24 = r112;
        PixelFormat r113 = new PixelFormat("PF_RGBA32", 8, 26);
        PF_RGBA32 = r113;
        PixelFormat r105 = new PixelFormat("PF_GRAY16", 9, 30);
        PF_GRAY16 = r105;
        PixelFormat r114 = new PixelFormat("PF_YUVA420P", 10, 33);
        PF_YUVA420P = r114;
        PixelFormat r106 = new PixelFormat("PF_RGB48", 11, 35);
        PF_RGB48 = r106;
        PixelFormat r107 = new PixelFormat("PF_RGBA64", 12, 107);
        PF_RGBA64 = r107;
        $VALUES = new PixelFormat[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r105, r114, r106, r107};
    }

    public static PixelFormat[] values() {
        return (PixelFormat[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static PixelFormat valueOf(String r100) {
        return (PixelFormat) a.a(PixelFormat.class, r100);
    }

    private PixelFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
