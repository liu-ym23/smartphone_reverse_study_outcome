package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/ota/g2/Trigger;", "", "<init>", "(Ljava/lang/String;I)V", "APP_FOREGROUND", "DEVICE_RECONNECTED", "VERSION_CHANGED", "MANUAL_PAGE", "MANUAL_ACTION", "CONDITION_CHANGED", "DEADLINE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Trigger extends Enum<Trigger> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Trigger[] $VALUES = null;
    public static final Trigger APP_FOREGROUND = null;
    public static final Trigger CONDITION_CHANGED = null;
    public static final Trigger DEADLINE = null;
    public static final Trigger DEVICE_RECONNECTED = null;
    public static final Trigger MANUAL_ACTION = null;
    public static final Trigger MANUAL_PAGE = null;
    public static final Trigger VERSION_CHANGED = null;

    public static EnumEntries<Trigger> getEntries() {
        return $ENTRIES;
    }

    static {
        Trigger r100 = new Trigger("APP_FOREGROUND", 0);
        APP_FOREGROUND = r100;
        Trigger r101 = new Trigger("DEVICE_RECONNECTED", 1);
        DEVICE_RECONNECTED = r101;
        Trigger r102 = new Trigger("VERSION_CHANGED", 2);
        VERSION_CHANGED = r102;
        Trigger r103 = new Trigger("MANUAL_PAGE", 3);
        MANUAL_PAGE = r103;
        Trigger r104 = new Trigger("MANUAL_ACTION", 4);
        MANUAL_ACTION = r104;
        Trigger r105 = new Trigger("CONDITION_CHANGED", 5);
        CONDITION_CHANGED = r105;
        Trigger r110 = new Trigger("DEADLINE", 6);
        DEADLINE = r110;
        Trigger[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        $VALUES = r111;
        $ENTRIES = EnumEntriesKt.enumEntries(r111);
    }

    public static Trigger[] values() {
        return (Trigger[]) $VALUES.clone();
    }

    public static Trigger valueOf(String r100) {
        return (Trigger) r27.a.a(Trigger.class, r100);
    }

    public Trigger(String r100, int r101) {
        super(r100, r101);
    }
}
