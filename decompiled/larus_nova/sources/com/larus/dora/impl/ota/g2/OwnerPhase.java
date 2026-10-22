package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/ota/g2/OwnerPhase;", "", "<init>", "(Ljava/lang/String;I)V", "APP_OWNED", "DEVICE_OWNED", "AWAITING_RECONNECT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OwnerPhase extends Enum<OwnerPhase> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OwnerPhase[] $VALUES = null;
    public static final OwnerPhase APP_OWNED = null;
    public static final OwnerPhase AWAITING_RECONNECT = null;
    public static final OwnerPhase DEVICE_OWNED = null;

    public static EnumEntries<OwnerPhase> getEntries() {
        return $ENTRIES;
    }

    static {
        OwnerPhase r100 = new OwnerPhase("APP_OWNED", 0);
        APP_OWNED = r100;
        OwnerPhase r101 = new OwnerPhase("DEVICE_OWNED", 1);
        DEVICE_OWNED = r101;
        OwnerPhase r102 = new OwnerPhase("AWAITING_RECONNECT", 2);
        AWAITING_RECONNECT = r102;
        OwnerPhase[] r103 = {r100, r101, r102};
        $VALUES = r103;
        $ENTRIES = EnumEntriesKt.enumEntries(r103);
    }

    public static OwnerPhase[] values() {
        return (OwnerPhase[]) $VALUES.clone();
    }

    public static OwnerPhase valueOf(String r100) {
        return (OwnerPhase) r27.a.a(OwnerPhase.class, r100);
    }

    public OwnerPhase(String r100, int r101) {
        super(r100, r101);
    }
}
