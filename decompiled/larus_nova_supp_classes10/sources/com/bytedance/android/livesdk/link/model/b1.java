package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b1 {
    public static final String a(a1 r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$toSimpleString");
        StringBuilder r0 = new StringBuilder("BattleDataScore{userId=");
        r0.append(r7.getUserId());
        r0.append(", score=");
        r0.append(r7.getScore());
        if (r7.getScoreRelativeText().length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        String r2 = "";
        if (r1 == false) goto L9;
        String r3 = ", scoreRelative='" + r7.getScoreRelativeText() + '\'';
    L10:
        r0.append(r3);
        r0.append(", isHuge=");
        r0.append(r7.isHugeRewardPk());
        r0.append(", battleRank=");
        r0.append(r7.getBattleRank());
        if (r7.getMultiPkTeamScore() == 0) goto L13;
        String r4 = ", teamPkScore=" + r7.getMultiPkTeamScore();
    L14:
        r0.append(r4);
        if (r7.getMultiPkTeamRank() == 0) goto L17;
        r2 = ", teamPkRank=" + r7.getMultiPkTeamRank();
    L17:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L13:
        r4 = "";
        goto L14
    L9:
        r3 = "";
        goto L10
    L5:
        r1 = false;
        goto L6
    }
}
