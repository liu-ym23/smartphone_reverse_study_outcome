package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/ota/g2/G2OtaHomeCardAction;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE", "DOWNLOADING", "INSTALLING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum G2OtaHomeCardAction extends Enum<G2OtaHomeCardAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ G2OtaHomeCardAction[] $VALUES = null;
    public static final G2OtaHomeCardAction DOWNLOADING = null;
    public static final G2OtaHomeCardAction INSTALLING = null;
    public static final G2OtaHomeCardAction UPDATE = null;

    public static EnumEntries<G2OtaHomeCardAction> getEntries() {
        return $ENTRIES;
    }

    static {
        G2OtaHomeCardAction r100 = new G2OtaHomeCardAction("UPDATE", 0);
        UPDATE = r100;
        G2OtaHomeCardAction r101 = new G2OtaHomeCardAction("DOWNLOADING", 1);
        DOWNLOADING = r101;
        G2OtaHomeCardAction r102 = new G2OtaHomeCardAction("INSTALLING", 2);
        INSTALLING = r102;
        G2OtaHomeCardAction[] r103 = {r100, r101, r102};
        $VALUES = r103;
        $ENTRIES = EnumEntriesKt.enumEntries(r103);
    }

    public static G2OtaHomeCardAction[] values() {
        return (G2OtaHomeCardAction[]) $VALUES.clone();
    }

    public static G2OtaHomeCardAction valueOf(String r100) {
        return (G2OtaHomeCardAction) r27.a.a(G2OtaHomeCardAction.class, r100);
    }

    public G2OtaHomeCardAction(String r100, int r101) {
        super(r100, r101);
    }
}
