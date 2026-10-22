package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q0 {
    public static final String a(ILinkMicBattleInviteMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$inviteUid");
        Long r3 = r2.get_inviteUid();
        if (r3 != null) goto L7;
        return null;
    L7:
        return String.valueOf(r3.longValue());
    }
}
