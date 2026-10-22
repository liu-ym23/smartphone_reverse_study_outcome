package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/argus/api/params/PrefetchType;", "", "Latch", "PrefetchV2", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PrefetchType extends Enum<PrefetchType> {
    public static final PrefetchType Latch = null;
    public static final PrefetchType PrefetchV2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrefetchType[] f245694a = null;

    public static PrefetchType valueOf(String r100) {
        return (PrefetchType) r27.a.a(PrefetchType.class, r100);
    }

    public static PrefetchType[] values() {
        return (PrefetchType[]) f245694a.clone();
    }

    static {
        PrefetchType r100 = new PrefetchType("Latch", 0);
        Latch = r100;
        PrefetchType r101 = new PrefetchType("PrefetchV2", 1);
        PrefetchV2 = r101;
        f245694a = new PrefetchType[]{r100, r101};
    }

    public PrefetchType(String r100, int r101) {
        super(r100, r101);
    }
}
