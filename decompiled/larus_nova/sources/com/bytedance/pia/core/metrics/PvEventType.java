package com.bytedance.pia.core.metrics;

import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum PvEventType extends Enum<PvEventType> {
    public static final PvEventType LOADING_ENABLED = null;
    public static final PvEventType NSR_ENABLED = null;
    public static final PvEventType NSR_HIT = null;
    public static final PvEventType PREFETCH_ENABLED = null;
    public static final PvEventType SNAPSHOT_ENABLED = null;
    public static final PvEventType SNAPSHOT_HIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PvEventType[] f266234a = null;
    private final String value;

    static {
        PvEventType r100 = new PvEventType("PREFETCH_ENABLED", 0, "prefetch_enabled");
        PREFETCH_ENABLED = r100;
        PvEventType r101 = new PvEventType("LOADING_ENABLED", 1, "native_loading_enabled");
        LOADING_ENABLED = r101;
        PvEventType r102 = new PvEventType("NSR_ENABLED", 2, "nsr_enabled");
        NSR_ENABLED = r102;
        PvEventType r103 = new PvEventType("NSR_HIT", 3, "nsr_hit");
        NSR_HIT = r103;
        PvEventType r104 = new PvEventType("SNAPSHOT_ENABLED", 4, "snapshot_enabled");
        SNAPSHOT_ENABLED = r104;
        PvEventType r105 = new PvEventType("SNAPSHOT_HIT", 5, "snapshot_hit");
        SNAPSHOT_HIT = r105;
        f266234a = new PvEventType[]{r100, r101, r102, r103, r104, r105};
    }

    public static PvEventType[] values() {
        return (PvEventType[]) f266234a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static PvEventType valueOf(String r100) {
        return (PvEventType) a.a(PvEventType.class, r100);
    }

    public PvEventType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
