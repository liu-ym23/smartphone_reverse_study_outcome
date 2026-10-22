package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SuggestionType extends Enum<SuggestionType> implements WireEnum {
    private static final /* synthetic */ SuggestionType[] $VALUES = null;
    public static final ProtoAdapter<SuggestionType> ADAPTER = null;
    public static final SuggestionType JUMP_TAB = null;
    public static final SuggestionType RECOMMENDED_FILTER = null;
    public static final SuggestionType RESOURCE_TAG = null;
    public static final SuggestionType SAVE_SEARCH_VIEW = null;
    public static final SuggestionType SERVICE_CARD = null;
    public static final SuggestionType SIDE_CARD = null;
    public static final SuggestionType UNKNOWN_SUGGESTION = null;
    private final int value;

    static {
        SuggestionType r100 = new SuggestionType("UNKNOWN_SUGGESTION", 0, 0);
        UNKNOWN_SUGGESTION = r100;
        SuggestionType r101 = new SuggestionType("SIDE_CARD", 1, 1);
        SIDE_CARD = r101;
        SuggestionType r102 = new SuggestionType("RESOURCE_TAG", 2, 2);
        RESOURCE_TAG = r102;
        SuggestionType r103 = new SuggestionType("JUMP_TAB", 3, 3);
        JUMP_TAB = r103;
        SuggestionType r104 = new SuggestionType("SERVICE_CARD", 4, 4);
        SERVICE_CARD = r104;
        SuggestionType r105 = new SuggestionType("RECOMMENDED_FILTER", 5, 5);
        RECOMMENDED_FILTER = r105;
        SuggestionType r110 = new SuggestionType("SAVE_SEARCH_VIEW", 6, 6);
        SAVE_SEARCH_VIEW = r110;
        $VALUES = new SuggestionType[]{r100, r101, r102, r103, r104, r105, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(SuggestionType.class);
    }

    public static SuggestionType[] values() {
        return (SuggestionType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SuggestionType fromValue(int r100) {
        switch(r100) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return SAVE_SEARCH_VIEW;
    L8:
        return RECOMMENDED_FILTER;
    L10:
        return SERVICE_CARD;
    L12:
        return JUMP_TAB;
    L14:
        return RESOURCE_TAG;
    L16:
        return SIDE_CARD;
    L18:
        return UNKNOWN_SUGGESTION;
    }

    public static SuggestionType valueOf(String r100) {
        return (SuggestionType) a.a(SuggestionType.class, r100);
    }

    private SuggestionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
