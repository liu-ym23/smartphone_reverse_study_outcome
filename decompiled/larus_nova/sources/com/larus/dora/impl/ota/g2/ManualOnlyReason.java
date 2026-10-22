package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/ota/g2/ManualOnlyReason;", "", "<init>", "(Ljava/lang/String;I)V", "DEBUG", "ABANDONED_RETRY", "MANUAL_INSTALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ManualOnlyReason extends Enum<ManualOnlyReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ManualOnlyReason[] $VALUES = null;
    public static final ManualOnlyReason ABANDONED_RETRY = null;
    public static final ManualOnlyReason DEBUG = null;
    public static final ManualOnlyReason MANUAL_INSTALL = null;

    public static EnumEntries<ManualOnlyReason> getEntries() {
        return $ENTRIES;
    }

    static {
        ManualOnlyReason r100 = new ManualOnlyReason("DEBUG", 0);
        DEBUG = r100;
        ManualOnlyReason r101 = new ManualOnlyReason("ABANDONED_RETRY", 1);
        ABANDONED_RETRY = r101;
        ManualOnlyReason r102 = new ManualOnlyReason("MANUAL_INSTALL", 2);
        MANUAL_INSTALL = r102;
        ManualOnlyReason[] r103 = {r100, r101, r102};
        $VALUES = r103;
        $ENTRIES = EnumEntriesKt.enumEntries(r103);
    }

    public static ManualOnlyReason[] values() {
        return (ManualOnlyReason[]) $VALUES.clone();
    }

    public static ManualOnlyReason valueOf(String r100) {
        return (ManualOnlyReason) r27.a.a(ManualOnlyReason.class, r100);
    }

    public ManualOnlyReason(String r100, int r101) {
        super(r100, r101);
    }
}
