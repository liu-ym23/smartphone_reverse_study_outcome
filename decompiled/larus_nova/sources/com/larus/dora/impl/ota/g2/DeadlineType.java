package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/dora/impl/ota/g2/DeadlineType;", "", "<init>", "(Ljava/lang/String;I)V", "WINDOW_OPEN", "WINDOW_CLOSE", "DOWNLOAD_RETRY", "INSTALL_COOLDOWN", "PACKAGE_EXPIRY", "PACKAGE_CLEANUP", "MANUAL_REARM", "RECONNECT", "LEGACY_INSTALL", "TYPE_DECLARE", "TRANSFER", "DISCONNECT", "TERMINAL_RETRY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DeadlineType extends Enum<DeadlineType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DeadlineType[] $VALUES = null;
    public static final DeadlineType DISCONNECT = null;
    public static final DeadlineType DOWNLOAD_RETRY = null;
    public static final DeadlineType INSTALL_COOLDOWN = null;
    public static final DeadlineType LEGACY_INSTALL = null;
    public static final DeadlineType MANUAL_REARM = null;
    public static final DeadlineType PACKAGE_CLEANUP = null;
    public static final DeadlineType PACKAGE_EXPIRY = null;
    public static final DeadlineType RECONNECT = null;
    public static final DeadlineType TERMINAL_RETRY = null;
    public static final DeadlineType TRANSFER = null;
    public static final DeadlineType TYPE_DECLARE = null;
    public static final DeadlineType WINDOW_CLOSE = null;
    public static final DeadlineType WINDOW_OPEN = null;

    public static EnumEntries<DeadlineType> getEntries() {
        return $ENTRIES;
    }

    static {
        DeadlineType r100 = new DeadlineType("WINDOW_OPEN", 0);
        WINDOW_OPEN = r100;
        DeadlineType r101 = new DeadlineType("WINDOW_CLOSE", 1);
        WINDOW_CLOSE = r101;
        DeadlineType r102 = new DeadlineType("DOWNLOAD_RETRY", 2);
        DOWNLOAD_RETRY = r102;
        DeadlineType r103 = new DeadlineType("INSTALL_COOLDOWN", 3);
        INSTALL_COOLDOWN = r103;
        DeadlineType r104 = new DeadlineType("PACKAGE_EXPIRY", 4);
        PACKAGE_EXPIRY = r104;
        DeadlineType r105 = new DeadlineType("PACKAGE_CLEANUP", 5);
        PACKAGE_CLEANUP = r105;
        DeadlineType r110 = new DeadlineType("MANUAL_REARM", 6);
        MANUAL_REARM = r110;
        DeadlineType r111 = new DeadlineType("RECONNECT", 7);
        RECONNECT = r111;
        DeadlineType r112 = new DeadlineType("LEGACY_INSTALL", 8);
        LEGACY_INSTALL = r112;
        DeadlineType r113 = new DeadlineType("TYPE_DECLARE", 9);
        TYPE_DECLARE = r113;
        DeadlineType r114 = new DeadlineType("TRANSFER", 10);
        TRANSFER = r114;
        DeadlineType r115 = new DeadlineType("DISCONNECT", 11);
        DISCONNECT = r115;
        DeadlineType r106 = new DeadlineType("TERMINAL_RETRY", 12);
        TERMINAL_RETRY = r106;
        DeadlineType[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        $VALUES = r107;
        $ENTRIES = EnumEntriesKt.enumEntries(r107);
    }

    public static DeadlineType[] values() {
        return (DeadlineType[]) $VALUES.clone();
    }

    public static DeadlineType valueOf(String r100) {
        return (DeadlineType) r27.a.a(DeadlineType.class, r100);
    }

    public DeadlineType(String r100, int r101) {
        super(r100, r101);
    }
}
