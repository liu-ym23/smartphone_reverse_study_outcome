package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/BattleSeasonStatus;", "", "UnknownSeason", "RunningSeason", "OffSeason", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BattleSeasonStatus extends Enum<BattleSeasonStatus> {
    public static final BattleSeasonStatus OffSeason = null;
    public static final BattleSeasonStatus RunningSeason = null;
    public static final BattleSeasonStatus UnknownSeason = null;
    public static final /* synthetic */ BattleSeasonStatus[] a = null;

    static {
        BattleSeasonStatus r1 = new BattleSeasonStatus("UnknownSeason", 0);
        UnknownSeason = r1;
        BattleSeasonStatus r2 = new BattleSeasonStatus("RunningSeason", 1);
        RunningSeason = r2;
        BattleSeasonStatus r3 = new BattleSeasonStatus("OffSeason", 2);
        OffSeason = r3;
        a = new BattleSeasonStatus[]{r1, r2, r3};
    }

    public static BattleSeasonStatus valueOf(String r1) {
        return (BattleSeasonStatus) r27.a.a(BattleSeasonStatus.class, r1);
    }

    public static BattleSeasonStatus[] values() {
        return (BattleSeasonStatus[]) a.clone();
    }

    public BattleSeasonStatus(String r1, int r2) {
        super(r1, r2);
    }
}
