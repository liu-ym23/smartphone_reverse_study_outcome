package com.bytedance.common.jato.adrenalin;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum AdrenalinStatus extends Enum<AdrenalinStatus> {
    private static final /* synthetic */ AdrenalinStatus[] $VALUES = null;
    public static final AdrenalinStatus RUNNNING = null;
    public static final AdrenalinStatus STOPPED = null;

    static {
        AdrenalinStatus r100 = new AdrenalinStatus("RUNNNING", 0);
        RUNNNING = r100;
        AdrenalinStatus r101 = new AdrenalinStatus("STOPPED", 1);
        STOPPED = r101;
        $VALUES = new AdrenalinStatus[]{r100, r101};
    }

    public static AdrenalinStatus[] values() {
        return (AdrenalinStatus[]) $VALUES.clone();
    }

    public static AdrenalinStatus valueOf(String r100) {
        return (AdrenalinStatus) a.a(AdrenalinStatus.class, r100);
    }

    private AdrenalinStatus(String r100, int r101) {
        super(r100, r101);
    }
}
