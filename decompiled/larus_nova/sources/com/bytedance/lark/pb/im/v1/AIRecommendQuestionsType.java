package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum AIRecommendQuestionsType extends Enum<AIRecommendQuestionsType> implements WireEnum {
    private static final /* synthetic */ AIRecommendQuestionsType[] $VALUES = null;
    public static final ProtoAdapter<AIRecommendQuestionsType> ADAPTER = null;
    public static final AIRecommendQuestionsType FirstJoin = null;
    public static final AIRecommendQuestionsType FollowUpType = null;
    public static final AIRecommendQuestionsType Preload_FirstJoin = null;
    public static final AIRecommendQuestionsType Preload_UnreadSammary = null;
    public static final AIRecommendQuestionsType UnreadSammary = null;
    private final int value;

    static {
        AIRecommendQuestionsType r100 = new AIRecommendQuestionsType("FirstJoin", 0, 1);
        FirstJoin = r100;
        AIRecommendQuestionsType r101 = new AIRecommendQuestionsType("UnreadSammary", 1, 2);
        UnreadSammary = r101;
        AIRecommendQuestionsType r102 = new AIRecommendQuestionsType("Preload_UnreadSammary", 2, 3);
        Preload_UnreadSammary = r102;
        AIRecommendQuestionsType r103 = new AIRecommendQuestionsType("Preload_FirstJoin", 3, 4);
        Preload_FirstJoin = r103;
        AIRecommendQuestionsType r104 = new AIRecommendQuestionsType("FollowUpType", 4, 5);
        FollowUpType = r104;
        $VALUES = new AIRecommendQuestionsType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(AIRecommendQuestionsType.class);
    }

    public static AIRecommendQuestionsType[] values() {
        return (AIRecommendQuestionsType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AIRecommendQuestionsType fromValue(int r100) {
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L19;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L15;
        return null;
    L15:
        return FollowUpType;
    L17:
        return Preload_FirstJoin;
    L19:
        return Preload_UnreadSammary;
    L21:
        return UnreadSammary;
    L23:
        return FirstJoin;
    }

    public static AIRecommendQuestionsType valueOf(String r100) {
        return (AIRecommendQuestionsType) a.a(AIRecommendQuestionsType.class, r100);
    }

    private AIRecommendQuestionsType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
