package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/ota/g2/InstallPhase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CHECKING", "QUEUED", "ENABLING_WIFI", "DECLARING_TYPE", "CONNECTING", "TRANSFERRING", "CANCELLING", "DEVICE_OWNED", "AWAITING_RECONNECT", "TERMINAL_PENDING_ACK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InstallPhase extends Enum<InstallPhase> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ InstallPhase[] $VALUES = null;
    public static final InstallPhase AWAITING_RECONNECT = null;
    public static final InstallPhase CANCELLING = null;
    public static final InstallPhase CHECKING = null;
    public static final InstallPhase CONNECTING = null;
    public static final InstallPhase DECLARING_TYPE = null;
    public static final InstallPhase DEVICE_OWNED = null;
    public static final InstallPhase ENABLING_WIFI = null;
    public static final InstallPhase IDLE = null;
    public static final InstallPhase QUEUED = null;
    public static final InstallPhase TERMINAL_PENDING_ACK = null;
    public static final InstallPhase TRANSFERRING = null;

    public static EnumEntries<InstallPhase> getEntries() {
        return $ENTRIES;
    }

    static {
        InstallPhase r100 = new InstallPhase("IDLE", 0);
        IDLE = r100;
        InstallPhase r101 = new InstallPhase("CHECKING", 1);
        CHECKING = r101;
        InstallPhase r102 = new InstallPhase("QUEUED", 2);
        QUEUED = r102;
        InstallPhase r103 = new InstallPhase("ENABLING_WIFI", 3);
        ENABLING_WIFI = r103;
        InstallPhase r104 = new InstallPhase("DECLARING_TYPE", 4);
        DECLARING_TYPE = r104;
        InstallPhase r105 = new InstallPhase("CONNECTING", 5);
        CONNECTING = r105;
        InstallPhase r110 = new InstallPhase("TRANSFERRING", 6);
        TRANSFERRING = r110;
        InstallPhase r111 = new InstallPhase("CANCELLING", 7);
        CANCELLING = r111;
        InstallPhase r112 = new InstallPhase("DEVICE_OWNED", 8);
        DEVICE_OWNED = r112;
        InstallPhase r113 = new InstallPhase("AWAITING_RECONNECT", 9);
        AWAITING_RECONNECT = r113;
        InstallPhase r114 = new InstallPhase("TERMINAL_PENDING_ACK", 10);
        TERMINAL_PENDING_ACK = r114;
        InstallPhase[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        $VALUES = r115;
        $ENTRIES = EnumEntriesKt.enumEntries(r115);
    }

    public static InstallPhase[] values() {
        return (InstallPhase[]) $VALUES.clone();
    }

    public static InstallPhase valueOf(String r100) {
        return (InstallPhase) r27.a.a(InstallPhase.class, r100);
    }

    public InstallPhase(String r100, int r101) {
        super(r100, r101);
    }
}
