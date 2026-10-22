package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SearchQABizType extends Enum<SearchQABizType> implements WireEnum {
    private static final /* synthetic */ SearchQABizType[] $VALUES = null;
    public static final ProtoAdapter<SearchQABizType> ADAPTER = null;
    public static final SearchQABizType ConsumedQA = null;
    public static final SearchQABizType UnConsumedQA = null;
    public static final SearchQABizType Unknown = null;
    private final int value;

    static {
        SearchQABizType r100 = new SearchQABizType("Unknown", 0, 0);
        Unknown = r100;
        SearchQABizType r101 = new SearchQABizType("ConsumedQA", 1, 1);
        ConsumedQA = r101;
        SearchQABizType r102 = new SearchQABizType("UnConsumedQA", 2, 2);
        UnConsumedQA = r102;
        $VALUES = new SearchQABizType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(SearchQABizType.class);
    }

    public static SearchQABizType[] values() {
        return (SearchQABizType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SearchQABizType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return UnConsumedQA;
    L12:
        return ConsumedQA;
    L14:
        return Unknown;
    }

    public static SearchQABizType valueOf(String r100) {
        return (SearchQABizType) a.a(SearchQABizType.class, r100);
    }

    private SearchQABizType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
