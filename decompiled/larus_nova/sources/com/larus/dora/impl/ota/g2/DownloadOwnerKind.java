package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/ota/g2/DownloadOwnerKind;", "", "<init>", "(Ljava/lang/String;I)V", "G2_SILENT", "G2_MANUAL", "G1_MANUAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DownloadOwnerKind extends Enum<DownloadOwnerKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DownloadOwnerKind[] $VALUES = null;
    public static final DownloadOwnerKind G1_MANUAL = null;
    public static final DownloadOwnerKind G2_MANUAL = null;
    public static final DownloadOwnerKind G2_SILENT = null;

    public static EnumEntries<DownloadOwnerKind> getEntries() {
        return $ENTRIES;
    }

    static {
        DownloadOwnerKind r100 = new DownloadOwnerKind("G2_SILENT", 0);
        G2_SILENT = r100;
        DownloadOwnerKind r101 = new DownloadOwnerKind("G2_MANUAL", 1);
        G2_MANUAL = r101;
        DownloadOwnerKind r102 = new DownloadOwnerKind("G1_MANUAL", 2);
        G1_MANUAL = r102;
        DownloadOwnerKind[] r103 = {r100, r101, r102};
        $VALUES = r103;
        $ENTRIES = EnumEntriesKt.enumEntries(r103);
    }

    public static DownloadOwnerKind[] values() {
        return (DownloadOwnerKind[]) $VALUES.clone();
    }

    public static DownloadOwnerKind valueOf(String r100) {
        return (DownloadOwnerKind) r27.a.a(DownloadOwnerKind.class, r100);
    }

    public DownloadOwnerKind(String r100, int r101) {
        super(r100, r101);
    }
}
