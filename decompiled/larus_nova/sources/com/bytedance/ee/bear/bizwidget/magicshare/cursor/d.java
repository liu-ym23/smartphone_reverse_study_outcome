package com.bytedance.ee.bear.bizwidget.magicshare.cursor;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {
    public static final b a(Activity r100, a r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.magic_share_web_follow_cursor") == false) goto L6;
        return new WebFollowCursorManagerImplV2(r100, r101, r102);
    L6:
        return new c(r100, r101, r102);
    }
}
