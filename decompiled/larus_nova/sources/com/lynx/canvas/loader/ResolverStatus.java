package com.lynx.canvas.loader;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum ResolverStatus extends Enum<ResolverStatus> {
    private static final /* synthetic */ ResolverStatus[] $VALUES = null;
    public static final ResolverStatus PENDING = null;
    public static final ResolverStatus REJECTED = null;
    public static final ResolverStatus RESOLVED = null;
    private final String status;

    static {
        ResolverStatus r100 = new ResolverStatus("PENDING", 0, "Pending");
        PENDING = r100;
        ResolverStatus r101 = new ResolverStatus("RESOLVED", 1, "Resolved");
        RESOLVED = r101;
        ResolverStatus r102 = new ResolverStatus("REJECTED", 2, "Rejected");
        REJECTED = r102;
        $VALUES = new ResolverStatus[]{r100, r101, r102};
    }

    public static ResolverStatus[] values() {
        return (ResolverStatus[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.status;
    }

    public static ResolverStatus valueOf(String r100) {
        return (ResolverStatus) a.a(ResolverStatus.class, r100);
    }

    private ResolverStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
