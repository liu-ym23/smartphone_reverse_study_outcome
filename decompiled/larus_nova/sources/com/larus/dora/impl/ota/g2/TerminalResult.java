package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/ota/g2/TerminalResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TerminalResult extends Enum<TerminalResult> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TerminalResult[] $VALUES = null;
    public static final TerminalResult FAILURE = null;
    public static final TerminalResult SUCCESS = null;
    public static final TerminalResult UNKNOWN = null;

    public static EnumEntries<TerminalResult> getEntries() {
        return $ENTRIES;
    }

    static {
        TerminalResult r100 = new TerminalResult("SUCCESS", 0);
        SUCCESS = r100;
        TerminalResult r101 = new TerminalResult("FAILURE", 1);
        FAILURE = r101;
        TerminalResult r102 = new TerminalResult("UNKNOWN", 2);
        UNKNOWN = r102;
        TerminalResult[] r103 = {r100, r101, r102};
        $VALUES = r103;
        $ENTRIES = EnumEntriesKt.enumEntries(r103);
    }

    public static TerminalResult[] values() {
        return (TerminalResult[]) $VALUES.clone();
    }

    public static TerminalResult valueOf(String r100) {
        return (TerminalResult) r27.a.a(TerminalResult.class, r100);
    }

    public TerminalResult(String r100, int r101) {
        super(r100, r101);
    }
}
