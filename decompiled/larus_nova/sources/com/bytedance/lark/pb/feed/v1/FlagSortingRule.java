package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum FlagSortingRule extends Enum<FlagSortingRule> implements WireEnum {
    private static final /* synthetic */ FlagSortingRule[] $VALUES = null;
    public static final ProtoAdapter<FlagSortingRule> ADAPTER = null;
    public static final FlagSortingRule DEFAULT = null;
    public static final FlagSortingRule MESSAGE = null;
    public static final FlagSortingRule UNKNOWN_RULE = null;
    private final int value;

    static {
        FlagSortingRule r100 = new FlagSortingRule("UNKNOWN_RULE", 0, 0);
        UNKNOWN_RULE = r100;
        FlagSortingRule r101 = new FlagSortingRule("DEFAULT", 1, 1);
        DEFAULT = r101;
        FlagSortingRule r102 = new FlagSortingRule("MESSAGE", 2, 2);
        MESSAGE = r102;
        $VALUES = new FlagSortingRule[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(FlagSortingRule.class);
    }

    public static FlagSortingRule[] values() {
        return (FlagSortingRule[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FlagSortingRule fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return MESSAGE;
    L12:
        return DEFAULT;
    L14:
        return UNKNOWN_RULE;
    }

    public static FlagSortingRule valueOf(String r100) {
        return (FlagSortingRule) a.a(FlagSortingRule.class, r100);
    }

    private FlagSortingRule(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
