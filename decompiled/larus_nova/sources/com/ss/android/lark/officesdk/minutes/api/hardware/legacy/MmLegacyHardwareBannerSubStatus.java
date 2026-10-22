package com.ss.android.lark.officesdk.minutes.api.hardware.legacy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/legacy/MmLegacyHardwareBannerSubStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "BLUETOOTH_SYNCING", "WIFI_FILE_CONNECTING", "WIFI_FILE_SYNCING", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmLegacyHardwareBannerSubStatus extends Enum<MmLegacyHardwareBannerSubStatus> {
    public static final MmLegacyHardwareBannerSubStatus BLUETOOTH_SYNCING = null;
    public static final MmLegacyHardwareBannerSubStatus UNKNOWN = null;
    public static final MmLegacyHardwareBannerSubStatus WIFI_FILE_CONNECTING = null;
    public static final MmLegacyHardwareBannerSubStatus WIFI_FILE_SYNCING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmLegacyHardwareBannerSubStatus[] f433502a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433503b = null;

    public static EnumEntries<MmLegacyHardwareBannerSubStatus> getEntries() {
        return f433503b;
    }

    static {
        MmLegacyHardwareBannerSubStatus r100 = new MmLegacyHardwareBannerSubStatus("UNKNOWN", 0);
        UNKNOWN = r100;
        MmLegacyHardwareBannerSubStatus r101 = new MmLegacyHardwareBannerSubStatus("BLUETOOTH_SYNCING", 1);
        BLUETOOTH_SYNCING = r101;
        MmLegacyHardwareBannerSubStatus r102 = new MmLegacyHardwareBannerSubStatus("WIFI_FILE_CONNECTING", 2);
        WIFI_FILE_CONNECTING = r102;
        MmLegacyHardwareBannerSubStatus r103 = new MmLegacyHardwareBannerSubStatus("WIFI_FILE_SYNCING", 3);
        WIFI_FILE_SYNCING = r103;
        MmLegacyHardwareBannerSubStatus[] r104 = {r100, r101, r102, r103};
        f433502a = r104;
        f433503b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmLegacyHardwareBannerSubStatus[] values() {
        return (MmLegacyHardwareBannerSubStatus[]) f433502a.clone();
    }

    public static MmLegacyHardwareBannerSubStatus valueOf(String r100) {
        return (MmLegacyHardwareBannerSubStatus) a.a(MmLegacyHardwareBannerSubStatus.class, r100);
    }

    public MmLegacyHardwareBannerSubStatus(String r100, int r101) {
        super(r100, r101);
    }
}
