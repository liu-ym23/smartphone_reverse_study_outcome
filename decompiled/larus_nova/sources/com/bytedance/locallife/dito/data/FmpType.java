package com.bytedance.locallife.dito.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/dito/data/FmpType;", "", "Normal", "Touch", "Timeout", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum FmpType extends Enum<FmpType> {
    public static final FmpType Normal = null;
    public static final FmpType Timeout = null;
    public static final FmpType Touch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FmpType[] f258191a = null;

    public static FmpType valueOf(String r100) {
        return (FmpType) r27.a.a(FmpType.class, r100);
    }

    public static FmpType[] values() {
        return (FmpType[]) f258191a.clone();
    }

    static {
        FmpType r100 = new FmpType("Normal", 0);
        Normal = r100;
        FmpType r101 = new FmpType("Touch", 1);
        Touch = r101;
        FmpType r102 = new FmpType("Timeout", 2);
        Timeout = r102;
        f258191a = new FmpType[]{r100, r101, r102};
    }

    public FmpType(String r100, int r101) {
        super(r100, r101);
    }
}
