package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmServerVendorType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_VENDOR_TYPE", "ZOOM", "RTC", "LARK_RTC", "LARK_PRE_RTC", "LARK_RTC_TEST_PRE", "LARK_RTC_TEST_GAUSS", "LARK_RTC_TEST", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmServerVendorType extends Enum<MmServerVendorType> {
    public static final a Companion = null;
    public static final MmServerVendorType LARK_PRE_RTC = null;
    public static final MmServerVendorType LARK_RTC = null;
    public static final MmServerVendorType LARK_RTC_TEST = null;
    public static final MmServerVendorType LARK_RTC_TEST_GAUSS = null;
    public static final MmServerVendorType LARK_RTC_TEST_PRE = null;
    public static final MmServerVendorType RTC = null;
    public static final MmServerVendorType UNKNOWN_VENDOR_TYPE = null;
    public static final MmServerVendorType ZOOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmServerVendorType[] f434388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434389b = null;
    private final int value;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmServerVendorType$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C5169a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f434390a = null;

            static {
                int[] r100 = new int[MmServerVendorType.values().length];
                r100[MmServerVendorType.LARK_RTC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[MmServerVendorType.LARK_PRE_RTC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[MmServerVendorType.LARK_RTC_TEST_PRE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[MmServerVendorType.LARK_RTC_TEST_GAUSS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[MmServerVendorType.LARK_RTC_TEST.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f434390a = r100;
            }
        }

        public a() {
        }
    }

    public static EnumEntries<MmServerVendorType> getEntries() {
        return f434389b;
    }

    static {
        MmServerVendorType r100 = new MmServerVendorType("UNKNOWN_VENDOR_TYPE", 0, 0);
        UNKNOWN_VENDOR_TYPE = r100;
        MmServerVendorType r101 = new MmServerVendorType("ZOOM", 1, 1);
        ZOOM = r101;
        MmServerVendorType r102 = new MmServerVendorType("RTC", 2, 2);
        RTC = r102;
        MmServerVendorType r103 = new MmServerVendorType("LARK_RTC", 3, 3);
        LARK_RTC = r103;
        MmServerVendorType r104 = new MmServerVendorType("LARK_PRE_RTC", 4, 4);
        LARK_PRE_RTC = r104;
        MmServerVendorType r105 = new MmServerVendorType("LARK_RTC_TEST_PRE", 5, 240);
        LARK_RTC_TEST_PRE = r105;
        MmServerVendorType r110 = new MmServerVendorType("LARK_RTC_TEST_GAUSS", 6, 241);
        LARK_RTC_TEST_GAUSS = r110;
        MmServerVendorType r111 = new MmServerVendorType("LARK_RTC_TEST", 7, 255);
        LARK_RTC_TEST = r111;
        MmServerVendorType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f434388a = r112;
        f434389b = EnumEntriesKt.enumEntries(r112);
        Companion = new a();
    }

    public static MmServerVendorType[] values() {
        return (MmServerVendorType[]) f434388a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmServerVendorType valueOf(String r100) {
        return (MmServerVendorType) r27.a.a(MmServerVendorType.class, r100);
    }

    public MmServerVendorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
