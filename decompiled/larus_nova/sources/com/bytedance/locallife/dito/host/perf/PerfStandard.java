package com.bytedance.locallife.dito.host.perf;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/host/perf/PerfStandard;", "", "MEDIUM", "UNKNOWN", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum PerfStandard extends Enum<PerfStandard> {
    public static final PerfStandard MEDIUM = null;
    public static final PerfStandard UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PerfStandard[] f258312a = null;

    public static PerfStandard valueOf(String r100) {
        return (PerfStandard) a.a(PerfStandard.class, r100);
    }

    public static PerfStandard[] values() {
        return (PerfStandard[]) f258312a.clone();
    }

    static {
        PerfStandard r100 = new PerfStandard("MEDIUM", 0);
        MEDIUM = r100;
        PerfStandard r101 = new PerfStandard("UNKNOWN", 1);
        UNKNOWN = r101;
        f258312a = new PerfStandard[]{r100, r101};
    }

    public PerfStandard(String r100, int r101) {
        super(r100, r101);
    }
}
