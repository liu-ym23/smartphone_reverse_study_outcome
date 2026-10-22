package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusRouteRiskType;", "", "Lcom/bytedance/ies/argus/bean/q;", "", "stringValue", "Ljava/lang/String;", "getStringValue", "()Ljava/lang/String;", "", "riskType", "I", "getRiskType", "()I", "HIGH", "MIDDLE", "LOW", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusRouteRiskType extends Enum<ArgusRouteRiskType> implements q {
    public static final ArgusRouteRiskType HIGH = null;
    public static final ArgusRouteRiskType LOW = null;
    public static final ArgusRouteRiskType MIDDLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusRouteRiskType[] f245968a = null;
    private final int riskType;
    private final String stringValue;

    public static ArgusRouteRiskType valueOf(String r100) {
        return (ArgusRouteRiskType) r27.a.a(ArgusRouteRiskType.class, r100);
    }

    public static ArgusRouteRiskType[] values() {
        return (ArgusRouteRiskType[]) f245968a.clone();
    }

    static {
        ArgusRouteRiskType r100 = new ArgusRouteRiskType("HIGH", 0, "high", 2);
        HIGH = r100;
        ArgusRouteRiskType r101 = new ArgusRouteRiskType("MIDDLE", 1, "middle", 1);
        MIDDLE = r101;
        ArgusRouteRiskType r102 = new ArgusRouteRiskType("LOW", 2, "low", 0);
        LOW = r102;
        f245968a = new ArgusRouteRiskType[]{r100, r101, r102};
    }

    public final int getRiskType() {
        return this.riskType;
    }

    @Override // com.bytedance.ies.argus.bean.q
    public String getStringValue() {
        return this.stringValue;
    }

    public ArgusRouteRiskType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.stringValue = r102;
        this.riskType = r103;
    }
}
