package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/ota/g2/CheckPurpose;", "", "<init>", "(Ljava/lang/String;I)V", "PREDOWNLOAD", "RESUME", "MANUAL_CHECK", "MANUAL_DOWNLOAD", "MANUAL_HANDOFF", "INSTALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CheckPurpose extends Enum<CheckPurpose> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CheckPurpose[] $VALUES = null;
    public static final CheckPurpose INSTALL = null;
    public static final CheckPurpose MANUAL_CHECK = null;
    public static final CheckPurpose MANUAL_DOWNLOAD = null;
    public static final CheckPurpose MANUAL_HANDOFF = null;
    public static final CheckPurpose PREDOWNLOAD = null;
    public static final CheckPurpose RESUME = null;

    public static EnumEntries<CheckPurpose> getEntries() {
        return $ENTRIES;
    }

    static {
        CheckPurpose r100 = new CheckPurpose("PREDOWNLOAD", 0);
        PREDOWNLOAD = r100;
        CheckPurpose r101 = new CheckPurpose("RESUME", 1);
        RESUME = r101;
        CheckPurpose r102 = new CheckPurpose("MANUAL_CHECK", 2);
        MANUAL_CHECK = r102;
        CheckPurpose r103 = new CheckPurpose("MANUAL_DOWNLOAD", 3);
        MANUAL_DOWNLOAD = r103;
        CheckPurpose r104 = new CheckPurpose("MANUAL_HANDOFF", 4);
        MANUAL_HANDOFF = r104;
        CheckPurpose r105 = new CheckPurpose("INSTALL", 5);
        INSTALL = r105;
        CheckPurpose[] r110 = {r100, r101, r102, r103, r104, r105};
        $VALUES = r110;
        $ENTRIES = EnumEntriesKt.enumEntries(r110);
    }

    public static CheckPurpose[] values() {
        return (CheckPurpose[]) $VALUES.clone();
    }

    public static CheckPurpose valueOf(String r100) {
        return (CheckPurpose) r27.a.a(CheckPurpose.class, r100);
    }

    public CheckPurpose(String r100, int r101) {
        super(r100, r101);
    }
}
