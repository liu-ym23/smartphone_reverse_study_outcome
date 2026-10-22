package com.bytedance.android.livesdk.link.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d3 {
    public static final String a(c3 r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$toSimpleString");
        StringBuilder r1 = new StringBuilder("BattleStatsMeta{channelId=");
        r1.append(r7.getChannelId());
        r1.append(", battleSetting=");
        c1 r2 = r7.getBattleSetting();
        ArrayList r4 = null;
        if (r2 == null) goto L5;
        Intrinsics.checkNotNullParameter(r2, "$this$toSimpleString");
        String r0 = "BattleSettings{battleId=" + r2.getBattleId() + ", battleType=" + r2.getBattleType() + ", mode=" + r2.getMode() + ", finished=" + r2.getFinished() + ", duration=" + r2.getDuration() + ", startTimeMs=" + r2.getStartTimeMs() + ", punishDuration=" + r2.getPunishDuration() + ", punishStartTimeMs=" + r2.getPunishStartTimeMs() + '}';
    L6:
        r1.append(r0);
        r1.append(", battleScores=");
        List<a1> r3 = r7.getBattleScorePairList();
        if (r3 == null) goto L12;
        List<a1> r5 = r3;
        r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r4.add(b1.a((a1) r6.next()));
    L12:
        r1.append(r4);
        r1.append(", multiPkTeam=");
        r1.append(r7.getMultiPkTeam());
        r1.append('}');
        return r1.toString();
    L5:
        r0 = null;
        goto L6
    }
}
