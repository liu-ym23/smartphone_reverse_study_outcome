package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(jz3.a r3, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r4) {
        String r5 = r4.c.getPageConfig().getEnterAid();
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        if (r5.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
    L13:
        return true;
    L11:
        if (Intrinsics.areEqual(r5, r3.a.c()) == false) goto L13;
        return false;
    L8:
        r0 = false;
        goto L9
    }
}
