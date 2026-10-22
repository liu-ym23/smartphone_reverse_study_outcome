package com.lynx.tasm;

/* JADX INFO: loaded from: classes32.dex */
public final enum LynxMemoryCollectionStatus extends Enum<LynxMemoryCollectionStatus> {
    public static final LynxMemoryCollectionStatus COMPLETED = null;
    public static final LynxMemoryCollectionStatus TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxMemoryCollectionStatus[] f381669a = null;

    static {
        LynxMemoryCollectionStatus r100 = new LynxMemoryCollectionStatus("COMPLETED", 0);
        COMPLETED = r100;
        LynxMemoryCollectionStatus r101 = new LynxMemoryCollectionStatus("TIMEOUT", 1);
        TIMEOUT = r101;
        f381669a = new LynxMemoryCollectionStatus[]{r100, r101};
    }

    public static LynxMemoryCollectionStatus[] values() {
        return (LynxMemoryCollectionStatus[]) f381669a.clone();
    }

    public static LynxMemoryCollectionStatus valueOf(String r100) {
        return (LynxMemoryCollectionStatus) r27.a.a(LynxMemoryCollectionStatus.class, r100);
    }

    public LynxMemoryCollectionStatus(String r100, int r101) {
        super(r100, r101);
    }
}
