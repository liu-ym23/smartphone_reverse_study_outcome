package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmRtcVendorType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VENDOR_TYPE_RTC", "VENDOR_TYPE_LARKRTC", "VENDOR_TYPE_LARKPRERTC", "VENDOR_TYPE_TEST_PRE", "VENDOR_TYPE_TEST_GAUSS", "VENDOR_TYPE_TEST", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRtcVendorType extends Enum<MmRtcVendorType> {
    public static final MmRtcVendorType VENDOR_TYPE_LARKPRERTC = null;
    public static final MmRtcVendorType VENDOR_TYPE_LARKRTC = null;
    public static final MmRtcVendorType VENDOR_TYPE_RTC = null;
    public static final MmRtcVendorType VENDOR_TYPE_TEST = null;
    public static final MmRtcVendorType VENDOR_TYPE_TEST_GAUSS = null;
    public static final MmRtcVendorType VENDOR_TYPE_TEST_PRE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRtcVendorType[] f434372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434373b = null;
    private final int value;

    public static EnumEntries<MmRtcVendorType> getEntries() {
        return f434373b;
    }

    static {
        MmRtcVendorType r100 = new MmRtcVendorType("VENDOR_TYPE_RTC", 0, 0);
        VENDOR_TYPE_RTC = r100;
        MmRtcVendorType r101 = new MmRtcVendorType("VENDOR_TYPE_LARKRTC", 1, 1);
        VENDOR_TYPE_LARKRTC = r101;
        MmRtcVendorType r102 = new MmRtcVendorType("VENDOR_TYPE_LARKPRERTC", 2, 2);
        VENDOR_TYPE_LARKPRERTC = r102;
        MmRtcVendorType r103 = new MmRtcVendorType("VENDOR_TYPE_TEST_PRE", 3, 240);
        VENDOR_TYPE_TEST_PRE = r103;
        MmRtcVendorType r104 = new MmRtcVendorType("VENDOR_TYPE_TEST_GAUSS", 4, 241);
        VENDOR_TYPE_TEST_GAUSS = r104;
        MmRtcVendorType r105 = new MmRtcVendorType("VENDOR_TYPE_TEST", 5, 255);
        VENDOR_TYPE_TEST = r105;
        MmRtcVendorType[] r110 = {r100, r101, r102, r103, r104, r105};
        f434372a = r110;
        f434373b = EnumEntriesKt.enumEntries(r110);
    }

    public static MmRtcVendorType[] values() {
        return (MmRtcVendorType[]) f434372a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmRtcVendorType valueOf(String r100) {
        return (MmRtcVendorType) r27.a.a(MmRtcVendorType.class, r100);
    }

    public MmRtcVendorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
