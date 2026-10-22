package com.google.zxing.qrcode.decoder;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;

/* JADX INFO: loaded from: classes23.dex */
public final enum ErrorCorrectionLevel extends Enum<ErrorCorrectionLevel> {
    public static final ErrorCorrectionLevel H = null;
    public static final ErrorCorrectionLevel L = null;
    public static final ErrorCorrectionLevel M = null;
    public static final ErrorCorrectionLevel Q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ErrorCorrectionLevel[] f275961a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ErrorCorrectionLevel[] f275962b = null;
    private final int bits;

    static {
        ErrorCorrectionLevel r100 = new ErrorCorrectionLevel("L", 0, 1);
        L = r100;
        ErrorCorrectionLevel r101 = new ErrorCorrectionLevel("M", 1, 0);
        M = r101;
        ErrorCorrectionLevel r102 = new ErrorCorrectionLevel("Q", 2, 3);
        Q = r102;
        ErrorCorrectionLevel r103 = new ErrorCorrectionLevel(FaceService.neutralLabel, 3, 2);
        H = r103;
        f275962b = new ErrorCorrectionLevel[]{r100, r101, r102, r103};
        f275961a = new ErrorCorrectionLevel[]{r101, r100, r103, r102};
    }

    public static ErrorCorrectionLevel[] values() {
        return (ErrorCorrectionLevel[]) f275962b.clone();
    }

    public int getBits() {
        return this.bits;
    }

    public static ErrorCorrectionLevel forBits(int r100) {
        if (r100 < 0) goto L8;
        if (r100 >= 4) goto L8;
        return f275961a[r100];
    L8:
        throw new IllegalArgumentException();
    }

    public static ErrorCorrectionLevel valueOf(String r100) {
        return (ErrorCorrectionLevel) r27.a.a(ErrorCorrectionLevel.class, r100);
    }

    public ErrorCorrectionLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.bits = r102;
    }
}
