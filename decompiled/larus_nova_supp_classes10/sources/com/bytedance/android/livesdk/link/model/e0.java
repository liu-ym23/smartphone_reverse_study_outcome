package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e0 {
    public static final long a(b0 r7) {
        if (r7 == null) goto L11;
        c0 r8 = r7.getConfig();
        if (r8 != null) goto L8;
        return 10;
    L8:
        if (r8.getInviteLimitSec() > 0) goto L10;
        return 10;
    L10:
        return r8.getInviteLimitSec();
    L11:
        return 10;
    }

    public static final String b(b0 r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toSimpleString");
        StringBuilder r0 = new StringBuilder("AutoMatchInfo{waitSec=");
        r0.append(r5.getWaitSec());
        r0.append(", accelerateLimit=");
        r0.append(r5.getAccelerateLimit());
        r0.append(", defaultWaitLimit=");
        r0.append(r5.getDefaultWaitLimit());
        r0.append(", inviteLimitSec=");
        c0 r1 = r5.getConfig();
        Long r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.getInviteLimitSec());
    L6:
        r0.append(r3);
        r0.append(", pkAutoMatchIndex=");
        c0 r4 = r5.getConfig();
        if (r4 == null) goto L9;
        r2 = Long.valueOf(r4.getPkAutoMatchIndex());
    L9:
        r0.append(r2);
        r0.append(", mainTitle=");
        r0.append(r5.getMainTitle());
        r0.append('}');
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }
}
