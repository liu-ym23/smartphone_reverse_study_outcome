package com.bytedance.ruler.strategy.store;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ruler/strategy/store/StrategyParseModel;", "", "PARSE_AT_STORE", "PARSE_AT_QUERY", "ruler_release"}, k = 1, mv = {1, 4, 0})
public final enum StrategyParseModel extends Enum<StrategyParseModel> {
    public static final StrategyParseModel PARSE_AT_QUERY = null;
    public static final StrategyParseModel PARSE_AT_STORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StrategyParseModel[] f267719a = null;

    static {
        StrategyParseModel r100 = new StrategyParseModel("PARSE_AT_STORE", 0);
        PARSE_AT_STORE = r100;
        StrategyParseModel r101 = new StrategyParseModel("PARSE_AT_QUERY", 1);
        PARSE_AT_QUERY = r101;
        f267719a = new StrategyParseModel[]{r100, r101};
    }

    public static StrategyParseModel valueOf(String r100) {
        return (StrategyParseModel) r27.a.a(StrategyParseModel.class, r100);
    }

    public static StrategyParseModel[] values() {
        return (StrategyParseModel[]) f267719a.clone();
    }

    public StrategyParseModel(String r100, int r101) {
        super(r100, r101);
    }
}
