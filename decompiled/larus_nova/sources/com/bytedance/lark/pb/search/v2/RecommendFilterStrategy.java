package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum RecommendFilterStrategy extends Enum<RecommendFilterStrategy> implements WireEnum {
    private static final /* synthetic */ RecommendFilterStrategy[] $VALUES = null;
    public static final ProtoAdapter<RecommendFilterStrategy> ADAPTER = null;
    public static final RecommendFilterStrategy BasedOnQuery = null;
    public static final RecommendFilterStrategy BasedOnSearchResults = null;
    public static final RecommendFilterStrategy UnknownStrategy = null;
    private final int value;

    static {
        RecommendFilterStrategy r100 = new RecommendFilterStrategy("UnknownStrategy", 0, 0);
        UnknownStrategy = r100;
        RecommendFilterStrategy r101 = new RecommendFilterStrategy("BasedOnQuery", 1, 1);
        BasedOnQuery = r101;
        RecommendFilterStrategy r102 = new RecommendFilterStrategy("BasedOnSearchResults", 2, 2);
        BasedOnSearchResults = r102;
        $VALUES = new RecommendFilterStrategy[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(RecommendFilterStrategy.class);
    }

    public static RecommendFilterStrategy[] values() {
        return (RecommendFilterStrategy[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static RecommendFilterStrategy fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return BasedOnSearchResults;
    L12:
        return BasedOnQuery;
    L14:
        return UnknownStrategy;
    }

    public static RecommendFilterStrategy valueOf(String r100) {
        return (RecommendFilterStrategy) a.a(RecommendFilterStrategy.class, r100);
    }

    private RecommendFilterStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
