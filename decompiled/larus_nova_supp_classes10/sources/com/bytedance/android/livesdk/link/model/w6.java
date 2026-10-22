package com.bytedance.android.livesdk.link.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w6 {
    public static final IListUserLinkmicContent a(v6 r1) {
        if (r1 == null) goto L6;
        com.bytedance.android.livesdk.link.model.bridge.m1 r2 = r1.getLinkMicContent();
        if (r2 == null) goto L6;
        return (IListUserLinkmicContent) r2.castTo(IListUserLinkmicContent.class);
    L6:
        return null;
    }
}
