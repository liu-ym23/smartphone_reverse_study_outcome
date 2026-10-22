package com.bytedance.bmmt.video;

import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;

/* JADX INFO: loaded from: classes8.dex */
final enum BmmtVideoCodecStandard extends Enum<BmmtVideoCodecStandard> {
    private static final /* synthetic */ BmmtVideoCodecStandard[] $VALUES = null;
    public static final BmmtVideoCodecStandard AV1 = null;
    public static final BmmtVideoCodecStandard ByteVC1 = null;
    public static final BmmtVideoCodecStandard H264 = null;
    public static final BmmtVideoCodecStandard Unknown = null;
    public static final BmmtVideoCodecStandard VP8 = null;
    public static final BmmtVideoCodecStandard VP9 = null;
    private final int value;

    private static /* synthetic */ BmmtVideoCodecStandard[] $values() {
        return new BmmtVideoCodecStandard[]{H264, ByteVC1, Unknown, VP8, VP9, AV1};
    }

    static {
        H264 = new BmmtVideoCodecStandard("H264", 0, 0);
        ByteVC1 = new BmmtVideoCodecStandard("ByteVC1", 1, 1);
        Unknown = new BmmtVideoCodecStandard("Unknown", 2, 2);
        VP8 = new BmmtVideoCodecStandard("VP8", 3, 8);
        VP9 = new BmmtVideoCodecStandard("VP9", 4, 9);
        AV1 = new BmmtVideoCodecStandard("AV1", 5, 10);
        $VALUES = $values();
    }

    public static BmmtVideoCodecStandard[] values() {
        return (BmmtVideoCodecStandard[]) $VALUES.clone();
    }

    public String mimeType() {
        int r100 = this.value;
        if (r100 != 1) goto L5;
        return "video/hevc";
    L5:
        if (r100 != 8) goto L7;
        return "video/x-vnd.on2.vp8";
    L7:
        if (r100 == 10) goto L10;
        return KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE;
    L10:
        return "video/av01";
    }

    public int toInt() {
        return this.value;
    }

    public static BmmtVideoCodecStandard fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 8) goto L14;
        if (r100 == 10) goto L12;
        return H264;
    L12:
        return AV1;
    L14:
        return VP8;
    L16:
        return ByteVC1;
    L18:
        return H264;
    }

    public static BmmtVideoCodecStandard valueOf(String r100) {
        return (BmmtVideoCodecStandard) r27.a.a(BmmtVideoCodecStandard.class, r100);
    }

    private BmmtVideoCodecStandard(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
