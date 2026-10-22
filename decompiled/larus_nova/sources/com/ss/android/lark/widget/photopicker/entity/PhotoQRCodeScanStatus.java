package com.ss.android.lark.widget.photopicker.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/widget/photopicker/entity/PhotoQRCodeScanStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_SCAN", "SCANNING", "NO_QRCODE", "HAS_QRCODE", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PhotoQRCodeScanStatus extends Enum<PhotoQRCodeScanStatus> {
    public static final PhotoQRCodeScanStatus HAS_QRCODE = null;
    public static final PhotoQRCodeScanStatus NOT_SCAN = null;
    public static final PhotoQRCodeScanStatus NO_QRCODE = null;
    public static final PhotoQRCodeScanStatus SCANNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PhotoQRCodeScanStatus[] f447496a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f447497b = null;

    public static EnumEntries<PhotoQRCodeScanStatus> getEntries() {
        return f447497b;
    }

    static {
        PhotoQRCodeScanStatus r100 = new PhotoQRCodeScanStatus("NOT_SCAN", 0);
        NOT_SCAN = r100;
        PhotoQRCodeScanStatus r101 = new PhotoQRCodeScanStatus("SCANNING", 1);
        SCANNING = r101;
        PhotoQRCodeScanStatus r102 = new PhotoQRCodeScanStatus("NO_QRCODE", 2);
        NO_QRCODE = r102;
        PhotoQRCodeScanStatus r103 = new PhotoQRCodeScanStatus("HAS_QRCODE", 3);
        HAS_QRCODE = r103;
        PhotoQRCodeScanStatus[] r104 = {r100, r101, r102, r103};
        f447496a = r104;
        f447497b = EnumEntriesKt.enumEntries(r104);
    }

    public static PhotoQRCodeScanStatus[] values() {
        return (PhotoQRCodeScanStatus[]) f447496a.clone();
    }

    public static PhotoQRCodeScanStatus valueOf(String r100) {
        return (PhotoQRCodeScanStatus) r27.a.a(PhotoQRCodeScanStatus.class, r100);
    }

    public PhotoQRCodeScanStatus(String r100, int r101) {
        super(r100, r101);
    }
}
