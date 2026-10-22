package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j6 {
    public static final IBattleLinkerInviteMessageExtra a(i6 r1) {
        if (r1 == null) goto L8;
        String r2 = r1.getExtraStr();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (IBattleLinkerInviteMessageExtra) ((vh7.c) vh7.f.b(com.bytedance.revenue.platform.api.core.a.a(r2), IBattleLinkerInviteMessageExtra.class));
    L8:
        return null;
    }

    public static final a6 b(i6 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$enterEx");
        com.bytedance.android.livesdk.link.model.bridge.f1 r2 = r1.getEnter();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (a6) r2.castTo(a6.class);
    }

    public static final g6 c(i6 r1) {
        if (r1 == null) goto L6;
        ILinkerLeaveContentBridge r2 = r1.getLeave();
        if (r2 == null) goto L6;
        return (g6) r2.castTo(g6.class);
    L6:
        return null;
    }
}
