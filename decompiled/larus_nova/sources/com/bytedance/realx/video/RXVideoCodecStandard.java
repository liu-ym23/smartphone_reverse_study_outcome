package com.bytedance.realx.video;

import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;

/* JADX INFO: loaded from: classes21.dex */
final enum RXVideoCodecStandard extends Enum<RXVideoCodecStandard> {
    private static final /* synthetic */ RXVideoCodecStandard[] $VALUES = null;
    public static final RXVideoCodecStandard ByteVC1 = null;
    public static final RXVideoCodecStandard H264 = null;
    public static final RXVideoCodecStandard Unknown = null;
    public static final RXVideoCodecStandard VP8 = null;
    public static final RXVideoCodecStandard VP9 = null;
    private final int value;

    static {
        RXVideoCodecStandard r100 = new RXVideoCodecStandard("H264", 0, 0);
        H264 = r100;
        RXVideoCodecStandard r101 = new RXVideoCodecStandard("ByteVC1", 1, 1);
        ByteVC1 = r101;
        RXVideoCodecStandard r102 = new RXVideoCodecStandard("Unknown", 2, 2);
        Unknown = r102;
        RXVideoCodecStandard r103 = new RXVideoCodecStandard("VP8", 3, 8);
        VP8 = r103;
        RXVideoCodecStandard r104 = new RXVideoCodecStandard("VP9", 4, 9);
        VP9 = r104;
        $VALUES = new RXVideoCodecStandard[]{r100, r101, r102, r103, r104};
    }

    public static RXVideoCodecStandard[] values() {
        return (RXVideoCodecStandard[]) $VALUES.clone();
    }

    public String mimeType() {
        int r100 = this.value;
        if (r100 != 1) goto L5;
        return "video/hevc";
    L5:
        if (r100 == 8) goto L8;
        return KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE;
    L8:
        return "video/x-vnd.on2.vp8";
    }

    public int toInt() {
        return this.value;
    }

    public static RXVideoCodecStandard fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 8) goto L10;
        return H264;
    L10:
        return VP8;
    L12:
        return ByteVC1;
    L14:
        return H264;
    }

    public static RXVideoCodecStandard valueOf(String r100) {
        return (RXVideoCodecStandard) r27.a.a(RXVideoCodecStandard.class, r100);
    }

    private RXVideoCodecStandard(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
