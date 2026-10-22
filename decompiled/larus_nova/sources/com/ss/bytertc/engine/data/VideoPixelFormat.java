package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoPixelFormat extends Enum<VideoPixelFormat> {
    private static final /* synthetic */ VideoPixelFormat[] $VALUES = null;
    public static final VideoPixelFormat I420 = null;
    public static final VideoPixelFormat NV12 = null;
    public static final VideoPixelFormat NV21 = null;
    public static final VideoPixelFormat RGBA = null;
    public static final VideoPixelFormat TEXTURE_2D = null;
    public static final VideoPixelFormat TEXTURE_OES = null;
    public static final VideoPixelFormat UNKNOWN = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.VideoPixelFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat = null;

        static {
            int[] r100 = new int[VideoPixelFormat.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat = r100;
            r100[VideoPixelFormat.I420.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat[VideoPixelFormat.NV12.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat[VideoPixelFormat.NV21.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat[VideoPixelFormat.RGBA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat[VideoPixelFormat.TEXTURE_2D.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat[VideoPixelFormat.TEXTURE_OES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
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
        VideoPixelFormat r104 = new VideoPixelFormat("RGBA", 4, 5);
        RGBA = r104;
        VideoPixelFormat r105 = new VideoPixelFormat("TEXTURE_2D", 5, 3553);
        TEXTURE_2D = r105;
        VideoPixelFormat r110 = new VideoPixelFormat("TEXTURE_OES", 6, 36197);
        TEXTURE_OES = r110;
        $VALUES = new VideoPixelFormat[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static VideoPixelFormat[] values() {
        return (VideoPixelFormat[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$VideoPixelFormat[ordinal()]) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return "kVideoPixelFormatUnknown";
    L6:
        return "kVideoPixelFormatTextureOES";
    L8:
        return "kVideoPixelFormatTexture2D";
    L10:
        return "kVideoPixelFormatRGBA";
    L12:
        return "kVideoPixelFormatNV21";
    L14:
        return "kVideoPixelFormatNV12";
    L16:
        return "kVideoPixelFormatI420";
    }

    public int value() {
        return this.value;
    }

    public static VideoPixelFormat fromId(int r100) {
        VideoPixelFormat[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoPixelFormat r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoPixelFormat valueOf(String r100) {
        return (VideoPixelFormat) a.a(VideoPixelFormat.class, r100);
    }

    private VideoPixelFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
