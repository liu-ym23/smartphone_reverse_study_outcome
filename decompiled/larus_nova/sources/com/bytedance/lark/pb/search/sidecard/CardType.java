package com.bytedance.lark.pb.search.sidecard;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum CardType extends Enum<CardType> implements WireEnum {
    private static final /* synthetic */ CardType[] $VALUES = null;
    public static final ProtoAdapter<CardType> ADAPTER = null;
    public static final CardType FULL_MATCH = null;
    public static final CardType FUZZY_CLICK = null;
    public static final CardType FUZZY_COLLAPSE = null;
    public static final CardType FUZZY_SPREAD = null;
    public static final CardType UNKNOWN = null;
    private final int value;

    static {
        CardType r100 = new CardType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        CardType r101 = new CardType("FUZZY_CLICK", 1, 1);
        FUZZY_CLICK = r101;
        CardType r102 = new CardType("FULL_MATCH", 2, 2);
        FULL_MATCH = r102;
        CardType r103 = new CardType("FUZZY_SPREAD", 3, 3);
        FUZZY_SPREAD = r103;
        CardType r104 = new CardType("FUZZY_COLLAPSE", 4, 4);
        FUZZY_COLLAPSE = r104;
        $VALUES = new CardType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(CardType.class);
    }

    public static CardType[] values() {
        return (CardType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CardType fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return FUZZY_COLLAPSE;
    L16:
        return FUZZY_SPREAD;
    L18:
        return FULL_MATCH;
    L20:
        return FUZZY_CLICK;
    L22:
        return UNKNOWN;
    }

    public static CardType valueOf(String r100) {
        return (CardType) a.a(CardType.class, r100);
    }

    private CardType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
