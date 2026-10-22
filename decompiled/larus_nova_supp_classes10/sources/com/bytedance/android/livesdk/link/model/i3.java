package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i3 {
    public static final String a(IBattleUserInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$toSimpleString");
        StringBuilder r0 = new StringBuilder("BattleUser{pkResult=");
        r0.append(r6.getPkResult());
        if (r6.getMultiPkTeamId() == 0) goto L5;
        String r7 = ", multiPkTeamId=" + r6.getMultiPkTeamId();
    L6:
        r0.append(r7);
        r0.append('}');
        return r0.toString();
    L5:
        r7 = "";
        goto L6
    }
}
