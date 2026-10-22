package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum DisplayRule extends Enum<DisplayRule> implements WireEnum {
    private static final /* synthetic */ DisplayRule[] $VALUES = null;
    public static final ProtoAdapter<DisplayRule> ADAPTER = null;
    public static final DisplayRule NO_TRANSLATION = null;
    public static final DisplayRule ONLY_TRANSLATION = null;
    public static final DisplayRule UNKNOWN_RULE = null;
    public static final DisplayRule WITH_ORIGINAL = null;
    private final int value;

    static {
        DisplayRule r100 = new DisplayRule("UNKNOWN_RULE", 0, 0);
        UNKNOWN_RULE = r100;
        DisplayRule r101 = new DisplayRule("NO_TRANSLATION", 1, 1);
        NO_TRANSLATION = r101;
        DisplayRule r102 = new DisplayRule("ONLY_TRANSLATION", 2, 2);
        ONLY_TRANSLATION = r102;
        DisplayRule r103 = new DisplayRule("WITH_ORIGINAL", 3, 3);
        WITH_ORIGINAL = r103;
        $VALUES = new DisplayRule[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(DisplayRule.class);
    }

    public static DisplayRule[] values() {
        return (DisplayRule[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DisplayRule fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return WITH_ORIGINAL;
    L14:
        return ONLY_TRANSLATION;
    L16:
        return NO_TRANSLATION;
    L18:
        return UNKNOWN_RULE;
    }

    public static DisplayRule valueOf(String r100) {
        return (DisplayRule) a.a(DisplayRule.class, r100);
    }

    private DisplayRule(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
