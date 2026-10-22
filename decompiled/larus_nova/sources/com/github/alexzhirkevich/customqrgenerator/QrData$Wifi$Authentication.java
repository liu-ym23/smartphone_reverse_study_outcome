package com.github.alexzhirkevich.customqrgenerator;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/github/alexzhirkevich/customqrgenerator/QrData$Wifi$Authentication", "", "Lcom/github/alexzhirkevich/customqrgenerator/QrData$Wifi$Authentication;", "WEP", "WPA", "OPEN", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0})
public enum QrData$Wifi$Authentication extends Enum<QrData$Wifi$Authentication> {
    public static final QrData$Wifi$Authentication OPEN = null;
    public static final QrData$Wifi$Authentication WEP = null;
    public static final QrData$Wifi$Authentication WPA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QrData$Wifi$Authentication[] f274238a = null;

    public static QrData$Wifi$Authentication valueOf(String r100) {
        return (QrData$Wifi$Authentication) r27.a.a(QrData$Wifi$Authentication.class, r100);
    }

    public static QrData$Wifi$Authentication[] values() {
        return (QrData$Wifi$Authentication[]) f274238a.clone();
    }

    static {
        QrData$Wifi$Authentication r100 = new QrData$Wifi$Authentication("WEP", 0);
        WEP = r100;
        QrData$Wifi$Authentication r101 = new QrData$Wifi$Authentication("WPA", 1);
        WPA = r101;
        final String r102 = "OPEN";
        final int r103 = 2;
        QrData$Wifi$Authentication r104 = new OPEN(r102, r103);
        OPEN = r104;
        f274238a = new QrData$Wifi$Authentication[]{r100, r101, r104};
    }

    public QrData$Wifi$Authentication(String r100, int r101) {
        super(r100, r101);
    }

    public QrData$Wifi$Authentication(String r100, int r101, DefaultConstructorMarker r102) {
        super(r100, r101);
    }
}
