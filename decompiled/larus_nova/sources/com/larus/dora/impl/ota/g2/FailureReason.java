package com.larus.dora.impl.ota.g2;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0017\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/impl/ota/g2/FailureReason;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "VERSION_CHECK_FAILED", "DOWNLOAD_FAILED", "DOWNLOAD_NETWORK_UNAVAILABLE", "DOWNLOAD_MD5_FAILED", "STORAGE_INSUFFICIENT", "TYPE_DECLARE_FAILED", "WIFI_ENABLE_FAILED", "P2P_CONNECT_FAILED", "TRANSFER_FAILED", "PERIPHERAL_LOW_BATTERY", "APP_ABORT_WEARING", "APP_ABORT_NOT_CHARGING", "APP_ABORT_GLASSES_BATTERY", "APP_ABORT_SWITCH_OFF", "DEVICE_INSTALL_FAILED", "TARGET_VERSION_MISMATCH", "APP_PROCESS_RESTARTED", "DEVICE_UNBOUND", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FailureReason extends Enum<FailureReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FailureReason[] $VALUES = null;
    public static final FailureReason APP_ABORT_GLASSES_BATTERY = null;
    public static final FailureReason APP_ABORT_NOT_CHARGING = null;
    public static final FailureReason APP_ABORT_SWITCH_OFF = null;
    public static final FailureReason APP_ABORT_WEARING = null;
    public static final FailureReason APP_PROCESS_RESTARTED = null;
    public static final FailureReason DEVICE_INSTALL_FAILED = null;
    public static final FailureReason DEVICE_UNBOUND = null;
    public static final FailureReason DOWNLOAD_FAILED = null;
    public static final FailureReason DOWNLOAD_MD5_FAILED = null;
    public static final FailureReason DOWNLOAD_NETWORK_UNAVAILABLE = null;
    public static final FailureReason NONE = null;
    public static final FailureReason P2P_CONNECT_FAILED = null;
    public static final FailureReason PERIPHERAL_LOW_BATTERY = null;
    public static final FailureReason STORAGE_INSUFFICIENT = null;
    public static final FailureReason TARGET_VERSION_MISMATCH = null;
    public static final FailureReason TRANSFER_FAILED = null;
    public static final FailureReason TYPE_DECLARE_FAILED = null;
    public static final FailureReason UNKNOWN = null;
    public static final FailureReason VERSION_CHECK_FAILED = null;
    public static final FailureReason WIFI_ENABLE_FAILED = null;

    public static EnumEntries<FailureReason> getEntries() {
        return $ENTRIES;
    }

    static {
        FailureReason r100 = new FailureReason(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        FailureReason r101 = new FailureReason("VERSION_CHECK_FAILED", 1);
        VERSION_CHECK_FAILED = r101;
        FailureReason r102 = new FailureReason("DOWNLOAD_FAILED", 2);
        DOWNLOAD_FAILED = r102;
        FailureReason r103 = new FailureReason("DOWNLOAD_NETWORK_UNAVAILABLE", 3);
        DOWNLOAD_NETWORK_UNAVAILABLE = r103;
        FailureReason r104 = new FailureReason("DOWNLOAD_MD5_FAILED", 4);
        DOWNLOAD_MD5_FAILED = r104;
        FailureReason r105 = new FailureReason("STORAGE_INSUFFICIENT", 5);
        STORAGE_INSUFFICIENT = r105;
        FailureReason r110 = new FailureReason("TYPE_DECLARE_FAILED", 6);
        TYPE_DECLARE_FAILED = r110;
        FailureReason r111 = new FailureReason("WIFI_ENABLE_FAILED", 7);
        WIFI_ENABLE_FAILED = r111;
        FailureReason r112 = new FailureReason("P2P_CONNECT_FAILED", 8);
        P2P_CONNECT_FAILED = r112;
        FailureReason r113 = new FailureReason("TRANSFER_FAILED", 9);
        TRANSFER_FAILED = r113;
        FailureReason r114 = new FailureReason("PERIPHERAL_LOW_BATTERY", 10);
        PERIPHERAL_LOW_BATTERY = r114;
        FailureReason r115 = new FailureReason("APP_ABORT_WEARING", 11);
        APP_ABORT_WEARING = r115;
        FailureReason r106 = new FailureReason("APP_ABORT_NOT_CHARGING", 12);
        APP_ABORT_NOT_CHARGING = r106;
        FailureReason r107 = new FailureReason("APP_ABORT_GLASSES_BATTERY", 13);
        APP_ABORT_GLASSES_BATTERY = r107;
        FailureReason r108 = new FailureReason("APP_ABORT_SWITCH_OFF", 14);
        APP_ABORT_SWITCH_OFF = r108;
        FailureReason r109 = new FailureReason("DEVICE_INSTALL_FAILED", 15);
        DEVICE_INSTALL_FAILED = r109;
        FailureReason r116 = new FailureReason("TARGET_VERSION_MISMATCH", 16);
        TARGET_VERSION_MISMATCH = r116;
        FailureReason r117 = new FailureReason("APP_PROCESS_RESTARTED", 17);
        APP_PROCESS_RESTARTED = r117;
        FailureReason r118 = new FailureReason("DEVICE_UNBOUND", 18);
        DEVICE_UNBOUND = r118;
        FailureReason r119 = new FailureReason("UNKNOWN", 19);
        UNKNOWN = r119;
        FailureReason[] r120 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
        $VALUES = r120;
        $ENTRIES = EnumEntriesKt.enumEntries(r120);
    }

    public static FailureReason[] values() {
        return (FailureReason[]) $VALUES.clone();
    }

    public static FailureReason valueOf(String r100) {
        return (FailureReason) r27.a.a(FailureReason.class, r100);
    }

    public FailureReason(String r100, int r101) {
        super(r100, r101);
    }
}
