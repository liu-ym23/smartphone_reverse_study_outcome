package com.larus.paging;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/paging/TerminalSeparatorType;", "", "FULLY_COMPLETE", "SOURCE_COMPLETE", "paging-common_release"}, k = 1, mv = {1, 7, 1})
public final enum TerminalSeparatorType extends Enum<TerminalSeparatorType> {
    public static final TerminalSeparatorType FULLY_COMPLETE = null;
    public static final TerminalSeparatorType SOURCE_COMPLETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TerminalSeparatorType[] f363745a = null;

    public static TerminalSeparatorType valueOf(String r100) {
        return (TerminalSeparatorType) r27.a.a(TerminalSeparatorType.class, r100);
    }

    public static TerminalSeparatorType[] values() {
        return (TerminalSeparatorType[]) f363745a.clone();
    }

    static {
        TerminalSeparatorType r100 = new TerminalSeparatorType("FULLY_COMPLETE", 0);
        FULLY_COMPLETE = r100;
        TerminalSeparatorType r101 = new TerminalSeparatorType("SOURCE_COMPLETE", 1);
        SOURCE_COMPLETE = r101;
        f363745a = new TerminalSeparatorType[]{r100, r101};
    }

    public TerminalSeparatorType(String r100, int r101) {
        super(r100, r101);
    }
}
