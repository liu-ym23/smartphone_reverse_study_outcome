package com.github.alexzhirkevich.customqrgenerator;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;", "", "Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;", "lvl", "Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;", "getLvl$custom_qr_generator_release", "()Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;", "Auto", "Low", "Medium", "MediumHigh", "High", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0})
public final enum QrErrorCorrectionLevel extends Enum<QrErrorCorrectionLevel> {
    public static final QrErrorCorrectionLevel Auto = null;
    public static final QrErrorCorrectionLevel High = null;
    public static final QrErrorCorrectionLevel Low = null;
    public static final QrErrorCorrectionLevel Medium = null;
    public static final QrErrorCorrectionLevel MediumHigh = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QrErrorCorrectionLevel[] f274239a = null;
    private final ErrorCorrectionLevel lvl;

    public static QrErrorCorrectionLevel valueOf(String r100) {
        return (QrErrorCorrectionLevel) r27.a.a(QrErrorCorrectionLevel.class, r100);
    }

    public static QrErrorCorrectionLevel[] values() {
        return (QrErrorCorrectionLevel[]) f274239a.clone();
    }

    static {
        ErrorCorrectionLevel r100 = ErrorCorrectionLevel.L;
        QrErrorCorrectionLevel r101 = new QrErrorCorrectionLevel("Auto", 0, r100);
        Auto = r101;
        QrErrorCorrectionLevel r102 = new QrErrorCorrectionLevel("Low", 1, r100);
        Low = r102;
        QrErrorCorrectionLevel r103 = new QrErrorCorrectionLevel("Medium", 2, ErrorCorrectionLevel.M);
        Medium = r103;
        QrErrorCorrectionLevel r104 = new QrErrorCorrectionLevel("MediumHigh", 3, ErrorCorrectionLevel.Q);
        MediumHigh = r104;
        QrErrorCorrectionLevel r105 = new QrErrorCorrectionLevel("High", 4, ErrorCorrectionLevel.H);
        High = r105;
        f274239a = new QrErrorCorrectionLevel[]{r101, r102, r103, r104, r105};
    }

    public final ErrorCorrectionLevel getLvl$custom_qr_generator_release() {
        return this.lvl;
    }

    public QrErrorCorrectionLevel(String r100, int r101, ErrorCorrectionLevel r102) {
        super(r100, r101);
        this.lvl = r102;
    }
}
