package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/BattleValueType;", "", "GiftValue", "Like", "Ticket", "Subscription", "ContributionUV", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BattleValueType extends Enum<BattleValueType> {
    public static final BattleValueType ContributionUV = null;
    public static final BattleValueType GiftValue = null;
    public static final BattleValueType Like = null;
    public static final BattleValueType Subscription = null;
    public static final BattleValueType Ticket = null;
    public static final /* synthetic */ BattleValueType[] a = null;

    static {
        BattleValueType r1 = new BattleValueType("GiftValue", 0);
        GiftValue = r1;
        BattleValueType r2 = new BattleValueType("Like", 1);
        Like = r2;
        BattleValueType r3 = new BattleValueType("Ticket", 2);
        Ticket = r3;
        BattleValueType r4 = new BattleValueType("Subscription", 3);
        Subscription = r4;
        BattleValueType r5 = new BattleValueType("ContributionUV", 4);
        ContributionUV = r5;
        a = new BattleValueType[]{r1, r2, r3, r4, r5};
    }

    public static BattleValueType valueOf(String r1) {
        return (BattleValueType) r27.a.a(BattleValueType.class, r1);
    }

    public static BattleValueType[] values() {
        return (BattleValueType[]) a.clone();
    }

    public BattleValueType(String r1, int r2) {
        super(r1, r2);
    }
}
