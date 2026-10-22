package com.bytedance.ee.bear.bizwidget.magicshare.cursor;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final b a(Activity r2, a r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.magic_share_web_follow_cursor") == false) goto L6;
        return new WebFollowCursorManagerImplV2(r2, r3, r4);
    L6:
        return new c(r2, r3, r4);
    }
}
