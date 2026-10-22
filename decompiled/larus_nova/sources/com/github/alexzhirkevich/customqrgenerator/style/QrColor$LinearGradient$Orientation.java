package com.github.alexzhirkevich.customqrgenerator.style;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/github/alexzhirkevich/customqrgenerator/style/QrColor$LinearGradient$Orientation", "", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor$LinearGradient$Orientation;", "Vertical", "Horizontal", "LeftDiagonal", "RightDiagonal", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0})
public final enum QrColor$LinearGradient$Orientation extends Enum<QrColor$LinearGradient$Orientation> {
    public static final QrColor$LinearGradient$Orientation Horizontal = null;
    public static final QrColor$LinearGradient$Orientation LeftDiagonal = null;
    public static final QrColor$LinearGradient$Orientation RightDiagonal = null;
    public static final QrColor$LinearGradient$Orientation Vertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QrColor$LinearGradient$Orientation[] f274254a = null;

    public static QrColor$LinearGradient$Orientation valueOf(String r100) {
        return (QrColor$LinearGradient$Orientation) r27.a.a(QrColor$LinearGradient$Orientation.class, r100);
    }

    public static QrColor$LinearGradient$Orientation[] values() {
        return (QrColor$LinearGradient$Orientation[]) f274254a.clone();
    }

    static {
        QrColor$LinearGradient$Orientation r100 = new QrColor$LinearGradient$Orientation("Vertical", 0);
        Vertical = r100;
        QrColor$LinearGradient$Orientation r101 = new QrColor$LinearGradient$Orientation("Horizontal", 1);
        Horizontal = r101;
        QrColor$LinearGradient$Orientation r102 = new QrColor$LinearGradient$Orientation("LeftDiagonal", 2);
        LeftDiagonal = r102;
        QrColor$LinearGradient$Orientation r103 = new QrColor$LinearGradient$Orientation("RightDiagonal", 3);
        RightDiagonal = r103;
        f274254a = new QrColor$LinearGradient$Orientation[]{r100, r101, r102, r103};
    }

    public QrColor$LinearGradient$Orientation(String r100, int r101) {
        super(r100, r101);
    }
}
