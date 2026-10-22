package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/ota/g2/OtaMode;", "", "<init>", "(Ljava/lang/String;I)V", "SILENT_G2", "MANUAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OtaMode extends Enum<OtaMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OtaMode[] $VALUES = null;
    public static final OtaMode MANUAL = null;
    public static final OtaMode SILENT_G2 = null;

    public static EnumEntries<OtaMode> getEntries() {
        return $ENTRIES;
    }

    static {
        OtaMode r100 = new OtaMode("SILENT_G2", 0);
        SILENT_G2 = r100;
        OtaMode r101 = new OtaMode("MANUAL", 1);
        MANUAL = r101;
        OtaMode[] r102 = {r100, r101};
        $VALUES = r102;
        $ENTRIES = EnumEntriesKt.enumEntries(r102);
    }

    public static OtaMode[] values() {
        return (OtaMode[]) $VALUES.clone();
    }

    public static OtaMode valueOf(String r100) {
        return (OtaMode) r27.a.a(OtaMode.class, r100);
    }

    public OtaMode(String r100, int r101) {
        super(r100, r101);
    }
}
