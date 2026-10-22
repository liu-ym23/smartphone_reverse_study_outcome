package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/BattleNotifyMessageType;", "", "Unknown", "LargeMatchStart", "LargeMatchEnd", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BattleNotifyMessageType extends Enum<BattleNotifyMessageType> {
    public static final BattleNotifyMessageType LargeMatchEnd = null;
    public static final BattleNotifyMessageType LargeMatchStart = null;
    public static final BattleNotifyMessageType Unknown = null;
    public static final /* synthetic */ BattleNotifyMessageType[] a = null;

    static {
        BattleNotifyMessageType r1 = new BattleNotifyMessageType("Unknown", 0);
        Unknown = r1;
        BattleNotifyMessageType r2 = new BattleNotifyMessageType("LargeMatchStart", 1);
        LargeMatchStart = r2;
        BattleNotifyMessageType r3 = new BattleNotifyMessageType("LargeMatchEnd", 2);
        LargeMatchEnd = r3;
        a = new BattleNotifyMessageType[]{r1, r2, r3};
    }

    public static BattleNotifyMessageType valueOf(String r1) {
        return (BattleNotifyMessageType) r27.a.a(BattleNotifyMessageType.class, r1);
    }

    public static BattleNotifyMessageType[] values() {
        return (BattleNotifyMessageType[]) a.clone();
    }

    public BattleNotifyMessageType(String r1, int r2) {
        super(r1, r2);
    }
}
