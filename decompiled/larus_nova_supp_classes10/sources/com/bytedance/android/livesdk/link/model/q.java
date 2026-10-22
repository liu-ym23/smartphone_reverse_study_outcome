package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q {
    public static final int a(p r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$anchorAuthRole");
        com.bytedance.android.livesdk.link.model.bridge.k1 r2 = r1.getContent();
        if (r2 == null) goto L10;
        com.bytedance.android.livesdk.link.model.bridge.m1 r3 = r2.getLinkMicContent();
        if (r3 == null) goto L10;
        IListUserLinkmicContent r4 = (IListUserLinkmicContent) r3.castTo(IListUserLinkmicContent.class);
        if (r4 == null) goto L10;
        return r4.getAnchorAuthRole();
    L10:
        return IListUserLinkmicContent.IAnchorAuthRole.AnchorAuthRoleGeneral.ordinal();
    }

    public static final com.bytedance.android.livesdk.link.model.bridge.j b(p r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$anchorLinkMicIdInfo");
        com.bytedance.android.livesdk.link.model.bridge.k1 r2 = r1.getContent();
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.link.model.bridge.m1 r3 = r2.getLinkMicContent();
        if (r3 == null) goto L7;
        return r3.getAnchorLinkMicIdInfo();
    L7:
        return null;
    }

    public static final v6 c(p r1) {
        if (r1 == null) goto L6;
        com.bytedance.android.livesdk.link.model.bridge.k1 r2 = r1.getContent();
        if (r2 == null) goto L6;
        return (v6) r2.castTo(v6.class);
    L6:
        return null;
    }

    public static final int d(p r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pkRole");
        com.bytedance.android.livesdk.link.model.bridge.k1 r2 = r1.getContent();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.link.model.bridge.m1 r3 = r2.getLinkMicContent();
        if (r3 == null) goto L9;
        IListUserLinkmicContent r4 = (IListUserLinkmicContent) r3.castTo(IListUserLinkmicContent.class);
        if (r4 == null) goto L9;
        return r4.getRole();
    L9:
        return 0;
    }
}
