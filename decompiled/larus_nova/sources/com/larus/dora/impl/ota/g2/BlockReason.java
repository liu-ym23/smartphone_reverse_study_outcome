package com.larus.dora.impl.ota.g2;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b$\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006%"}, d2 = {"Lcom/larus/dora/impl/ota/g2/BlockReason;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "PRODUCT_UNSUPPORTED", "DEVICE_UNBOUND", "ABILITY_UNSUPPORTED", "ABILITY_UNRESOLVED", "FEATURE_DISABLED", "USER_INTENT_OFF", "DEVICE_DISCONNECTED", "DEVICE_INFO_UNAVAILABLE", "COMPANION_MODE", "QUERY_IN_PROGRESS", "NO_UPDATE_TTL", "WIFI_UNAVAILABLE", "PHONE_BATTERY_LOW", "STORAGE_INSUFFICIENT", "OUTSIDE_WINDOW", "MANUAL_ENTERED_TONIGHT", "MANUAL_ONLY", "NEARBY_PERMISSION_DENIED", "LOCATION_PERMISSION_DENIED", "GLASSES_WEARING", "GLASSES_NOT_CHARGING", "GLASSES_BATTERY_LOW", "WIFI_DISABLED", "WIFI_ENABLE_FAILED", "HOTSPOT_ENABLED", "VPN_CONFLICT", "GPS_DISABLED", "GLOBAL_SERIAL_BUSY", "FAILURE_COOLDOWN", "PACKAGE_MISSING", "PACKAGE_INVALID", "NETWORK_UNAVAILABLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlockReason extends Enum<BlockReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BlockReason[] $VALUES = null;
    public static final BlockReason ABILITY_UNRESOLVED = null;
    public static final BlockReason ABILITY_UNSUPPORTED = null;
    public static final BlockReason COMPANION_MODE = null;
    public static final BlockReason DEVICE_DISCONNECTED = null;
    public static final BlockReason DEVICE_INFO_UNAVAILABLE = null;
    public static final BlockReason DEVICE_UNBOUND = null;
    public static final BlockReason FAILURE_COOLDOWN = null;
    public static final BlockReason FEATURE_DISABLED = null;
    public static final BlockReason GLASSES_BATTERY_LOW = null;
    public static final BlockReason GLASSES_NOT_CHARGING = null;
    public static final BlockReason GLASSES_WEARING = null;
    public static final BlockReason GLOBAL_SERIAL_BUSY = null;
    public static final BlockReason GPS_DISABLED = null;
    public static final BlockReason HOTSPOT_ENABLED = null;
    public static final BlockReason LOCATION_PERMISSION_DENIED = null;
    public static final BlockReason MANUAL_ENTERED_TONIGHT = null;
    public static final BlockReason MANUAL_ONLY = null;
    public static final BlockReason NEARBY_PERMISSION_DENIED = null;
    public static final BlockReason NETWORK_UNAVAILABLE = null;
    public static final BlockReason NONE = null;
    public static final BlockReason NO_UPDATE_TTL = null;
    public static final BlockReason OUTSIDE_WINDOW = null;
    public static final BlockReason PACKAGE_INVALID = null;
    public static final BlockReason PACKAGE_MISSING = null;
    public static final BlockReason PHONE_BATTERY_LOW = null;
    public static final BlockReason PRODUCT_UNSUPPORTED = null;
    public static final BlockReason QUERY_IN_PROGRESS = null;
    public static final BlockReason STORAGE_INSUFFICIENT = null;
    public static final BlockReason USER_INTENT_OFF = null;
    public static final BlockReason VPN_CONFLICT = null;
    public static final BlockReason WIFI_DISABLED = null;
    public static final BlockReason WIFI_ENABLE_FAILED = null;
    public static final BlockReason WIFI_UNAVAILABLE = null;

    public static EnumEntries<BlockReason> getEntries() {
        return $ENTRIES;
    }

    static {
        BlockReason r100 = new BlockReason(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        BlockReason r101 = new BlockReason("PRODUCT_UNSUPPORTED", 1);
        PRODUCT_UNSUPPORTED = r101;
        BlockReason r102 = new BlockReason("DEVICE_UNBOUND", 2);
        DEVICE_UNBOUND = r102;
        BlockReason r103 = new BlockReason("ABILITY_UNSUPPORTED", 3);
        ABILITY_UNSUPPORTED = r103;
        BlockReason r104 = new BlockReason("ABILITY_UNRESOLVED", 4);
        ABILITY_UNRESOLVED = r104;
        BlockReason r105 = new BlockReason("FEATURE_DISABLED", 5);
        FEATURE_DISABLED = r105;
        BlockReason r110 = new BlockReason("USER_INTENT_OFF", 6);
        USER_INTENT_OFF = r110;
        BlockReason r111 = new BlockReason("DEVICE_DISCONNECTED", 7);
        DEVICE_DISCONNECTED = r111;
        BlockReason r112 = new BlockReason("DEVICE_INFO_UNAVAILABLE", 8);
        DEVICE_INFO_UNAVAILABLE = r112;
        BlockReason r113 = new BlockReason("COMPANION_MODE", 9);
        COMPANION_MODE = r113;
        BlockReason r114 = new BlockReason("QUERY_IN_PROGRESS", 10);
        QUERY_IN_PROGRESS = r114;
        BlockReason r115 = new BlockReason("NO_UPDATE_TTL", 11);
        NO_UPDATE_TTL = r115;
        BlockReason r106 = new BlockReason("WIFI_UNAVAILABLE", 12);
        WIFI_UNAVAILABLE = r106;
        BlockReason r107 = new BlockReason("PHONE_BATTERY_LOW", 13);
        PHONE_BATTERY_LOW = r107;
        BlockReason r108 = new BlockReason("STORAGE_INSUFFICIENT", 14);
        STORAGE_INSUFFICIENT = r108;
        BlockReason r109 = new BlockReason("OUTSIDE_WINDOW", 15);
        OUTSIDE_WINDOW = r109;
        BlockReason r116 = new BlockReason("MANUAL_ENTERED_TONIGHT", 16);
        MANUAL_ENTERED_TONIGHT = r116;
        BlockReason r117 = new BlockReason("MANUAL_ONLY", 17);
        MANUAL_ONLY = r117;
        BlockReason r118 = new BlockReason("NEARBY_PERMISSION_DENIED", 18);
        NEARBY_PERMISSION_DENIED = r118;
        BlockReason r119 = new BlockReason("LOCATION_PERMISSION_DENIED", 19);
        LOCATION_PERMISSION_DENIED = r119;
        BlockReason r120 = new BlockReason("GLASSES_WEARING", 20);
        GLASSES_WEARING = r120;
        BlockReason r121 = new BlockReason("GLASSES_NOT_CHARGING", 21);
        GLASSES_NOT_CHARGING = r121;
        BlockReason r122 = new BlockReason("GLASSES_BATTERY_LOW", 22);
        GLASSES_BATTERY_LOW = r122;
        BlockReason r123 = new BlockReason("WIFI_DISABLED", 23);
        WIFI_DISABLED = r123;
        BlockReason r124 = new BlockReason("WIFI_ENABLE_FAILED", 24);
        WIFI_ENABLE_FAILED = r124;
        BlockReason r125 = new BlockReason("HOTSPOT_ENABLED", 25);
        HOTSPOT_ENABLED = r125;
        BlockReason r126 = new BlockReason("VPN_CONFLICT", 26);
        VPN_CONFLICT = r126;
        BlockReason r127 = new BlockReason("GPS_DISABLED", 27);
        GPS_DISABLED = r127;
        BlockReason r128 = new BlockReason("GLOBAL_SERIAL_BUSY", 28);
        GLOBAL_SERIAL_BUSY = r128;
        BlockReason r129 = new BlockReason("FAILURE_COOLDOWN", 29);
        FAILURE_COOLDOWN = r129;
        BlockReason r130 = new BlockReason("PACKAGE_MISSING", 30);
        PACKAGE_MISSING = r130;
        BlockReason r131 = new BlockReason("PACKAGE_INVALID", 31);
        PACKAGE_INVALID = r131;
        BlockReason r132 = new BlockReason("NETWORK_UNAVAILABLE", 32);
        NETWORK_UNAVAILABLE = r132;
        BlockReason[] r133 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132};
        $VALUES = r133;
        $ENTRIES = EnumEntriesKt.enumEntries(r133);
    }

    public static BlockReason[] values() {
        return (BlockReason[]) $VALUES.clone();
    }

    public static BlockReason valueOf(String r100) {
        return (BlockReason) r27.a.a(BlockReason.class, r100);
    }

    public BlockReason(String r100, int r101) {
        super(r100, r101);
    }
}
