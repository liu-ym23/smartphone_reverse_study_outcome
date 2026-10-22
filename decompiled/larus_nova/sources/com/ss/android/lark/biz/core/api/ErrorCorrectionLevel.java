package com.ss.android.lark.biz.core.api;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum ErrorCorrectionLevel extends Enum<ErrorCorrectionLevel> {
    public static final ErrorCorrectionLevel H = null;
    public static final ErrorCorrectionLevel L = null;
    public static final ErrorCorrectionLevel M = null;
    public static final ErrorCorrectionLevel Q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorCorrectionLevel[] f409793a = null;

    static {
        ErrorCorrectionLevel r100 = new ErrorCorrectionLevel("L", 0);
        L = r100;
        ErrorCorrectionLevel r101 = new ErrorCorrectionLevel("M", 1);
        M = r101;
        ErrorCorrectionLevel r102 = new ErrorCorrectionLevel("Q", 2);
        Q = r102;
        ErrorCorrectionLevel r103 = new ErrorCorrectionLevel(FaceService.neutralLabel, 3);
        H = r103;
        f409793a = new ErrorCorrectionLevel[]{r100, r101, r102, r103};
    }

    public static ErrorCorrectionLevel[] values() {
        return (ErrorCorrectionLevel[]) f409793a.clone();
    }

    public static ErrorCorrectionLevel valueOf(String r100) {
        return (ErrorCorrectionLevel) a.a(ErrorCorrectionLevel.class, r100);
    }

    public ErrorCorrectionLevel(String r100, int r101) {
        super(r100, r101);
    }
}
