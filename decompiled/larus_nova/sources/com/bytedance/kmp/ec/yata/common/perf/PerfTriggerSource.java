package com.bytedance.kmp.ec.yata.common.perf;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/perf/PerfTriggerSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "REFRESH", "ADJUST", "UPLINK", "UNKNOWN", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final enum PerfTriggerSource extends Enum<PerfTriggerSource> {
    public static final PerfTriggerSource ADJUST = null;
    public static final PerfTriggerSource REFRESH = null;
    public static final PerfTriggerSource UNKNOWN = null;
    public static final PerfTriggerSource UPLINK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PerfTriggerSource[] f251468a = null;
    private final String value;

    public static PerfTriggerSource valueOf(String r100) {
        return (PerfTriggerSource) r27.a.a(PerfTriggerSource.class, r100);
    }

    public static PerfTriggerSource[] values() {
        return (PerfTriggerSource[]) f251468a.clone();
    }

    static {
        PerfTriggerSource r100 = new PerfTriggerSource("REFRESH", 0, "refresh");
        REFRESH = r100;
        PerfTriggerSource r101 = new PerfTriggerSource("ADJUST", 1, "adjust");
        ADJUST = r101;
        PerfTriggerSource r102 = new PerfTriggerSource("UPLINK", 2, "uplink");
        UPLINK = r102;
        PerfTriggerSource r103 = new PerfTriggerSource("UNKNOWN", 3, "unknown");
        UNKNOWN = r103;
        f251468a = new PerfTriggerSource[]{r100, r101, r102, r103};
    }

    public final String getValue() {
        return this.value;
    }

    public PerfTriggerSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
