package com.bytedance.realx.video;

/* JADX INFO: loaded from: classes21.dex */
public final enum VideoCodecStatus extends Enum<VideoCodecStatus> {
    private static final /* synthetic */ VideoCodecStatus[] $VALUES = null;
    public static final VideoCodecStatus DROP_DECODED_FRAME = null;
    public static final VideoCodecStatus ERROR = null;
    public static final VideoCodecStatus ERR_PARAMETER = null;
    public static final VideoCodecStatus ERR_SIZE = null;
    public static final VideoCodecStatus FALLBACK_SOFTWARE = null;
    public static final VideoCodecStatus LEVEL_EXCEEDED = null;
    public static final VideoCodecStatus MEDIACODEC_EXCEPTION = null;
    public static final VideoCodecStatus MEDIACODEC_OUT_OF_RESOLUTION = null;
    public static final VideoCodecStatus MEMORY = null;
    public static final VideoCodecStatus NO_OUTPUT = null;
    public static final VideoCodecStatus OK = null;
    public static final VideoCodecStatus OVERLOAD = null;
    public static final VideoCodecStatus TIMEOUT = null;
    public static final VideoCodecStatus UNINITIALIZED = null;
    public static final VideoCodecStatus USING_INTERNAL_SURFACE = null;
    private final int number;

    static {
        VideoCodecStatus r100 = new VideoCodecStatus("OK", 0, 0);
        OK = r100;
        VideoCodecStatus r101 = new VideoCodecStatus("ERR_PARAMETER", 1, 3001);
        ERR_PARAMETER = r101;
        VideoCodecStatus r102 = new VideoCodecStatus("ERR_SIZE", 2, 3001);
        ERR_SIZE = r102;
        VideoCodecStatus r103 = new VideoCodecStatus("LEVEL_EXCEEDED", 3, 3001);
        LEVEL_EXCEEDED = r103;
        VideoCodecStatus r104 = new VideoCodecStatus("UNINITIALIZED", 4, 4002);
        UNINITIALIZED = r104;
        VideoCodecStatus r105 = new VideoCodecStatus("MEMORY", 5, 4003);
        MEMORY = r105;
        VideoCodecStatus r110 = new VideoCodecStatus("ERROR", 6, 4003);
        ERROR = r110;
        VideoCodecStatus r111 = new VideoCodecStatus("TIMEOUT", 7, 4007);
        TIMEOUT = r111;
        VideoCodecStatus r112 = new VideoCodecStatus("NO_OUTPUT", 8, 2002);
        NO_OUTPUT = r112;
        VideoCodecStatus r113 = new VideoCodecStatus("FALLBACK_SOFTWARE", 9, 4009);
        FALLBACK_SOFTWARE = r113;
        VideoCodecStatus r106 = new VideoCodecStatus("MEDIACODEC_EXCEPTION", 10, 2006);
        MEDIACODEC_EXCEPTION = r106;
        VideoCodecStatus r107 = new VideoCodecStatus("USING_INTERNAL_SURFACE", 11, 2007);
        USING_INTERNAL_SURFACE = r107;
        VideoCodecStatus r108 = new VideoCodecStatus("OVERLOAD", 12, 4005);
        OVERLOAD = r108;
        VideoCodecStatus r109 = new VideoCodecStatus("MEDIACODEC_OUT_OF_RESOLUTION", 13, 2008);
        MEDIACODEC_OUT_OF_RESOLUTION = r109;
        VideoCodecStatus r114 = new VideoCodecStatus("DROP_DECODED_FRAME", 14, 2002);
        DROP_DECODED_FRAME = r114;
        $VALUES = new VideoCodecStatus[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109, r114};
    }

    public static VideoCodecStatus[] values() {
        return (VideoCodecStatus[]) $VALUES.clone();
    }

    public int getNumber() {
        return this.number;
    }

    public static VideoCodecStatus valueOf(String r100) {
        return (VideoCodecStatus) r27.a.a(VideoCodecStatus.class, r100);
    }

    private VideoCodecStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
