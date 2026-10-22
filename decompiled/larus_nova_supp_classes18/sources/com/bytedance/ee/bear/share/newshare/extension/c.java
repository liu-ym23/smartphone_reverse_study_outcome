package com.bytedance.ee.bear.share.newshare.extension;

import com.bytedance.ee.bear.share.newshare.ShareItemList;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.f0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final ShareItemList b(c0 r1, Function1<? super ShareItems, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "initializer");
        ShareItems r0 = new ShareItems();
        f0 r3 = r1.b;
        if (r3 == null) goto L5;
        mm5.b r4 = r3.buildHeader();
    L6:
        if (r4 == null) goto L8;
        r0.add(r4);
    L8:
        r2.invoke(r0);
        return new ShareItemList(r0);
    L5:
        r4 = null;
        goto L6
    }

    public static void a(ShareItems r4, boolean r5, Function1 r6, int r7) {
        boolean r2 = true;
        if ((r7 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r7 & 2) != 0) goto L11;
        r2 = false;
    L11:
        if ((r7 & 4) == 0) goto L13;
        r5 = false;
    L13:
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "initializer");
        b r8 = new b(r0, r2, r5);
        r6.invoke(r8);
        r4.add(r8);
        return;
    L5:
        r0 = false;
        goto L7
    }
}
