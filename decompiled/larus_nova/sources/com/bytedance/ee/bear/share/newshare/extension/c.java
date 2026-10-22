package com.bytedance.ee.bear.share.newshare.extension;

import com.bytedance.ee.bear.share.newshare.ShareItemList;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.f0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {
    public static final ShareItemList b(c0 r100, Function1<? super ShareItems, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "initializer");
        ShareItems r102 = new ShareItems();
        f0 r103 = r100.f237197b;
        if (r103 == null) goto L5;
        mm5.b r104 = r103.buildHeader();
    L6:
        if (r104 == null) goto L8;
        r102.add(r104);
    L8:
        r101.invoke(r102);
        return new ShareItemList(r102);
    L5:
        r104 = null;
        goto L6
    }

    public static void a(ShareItems r100, boolean r101, Function1 r102, int r103) {
        boolean r104 = true;
        if ((r103 & 1) == 0) goto L5;
        boolean r105 = true;
    L7:
        if ((r103 & 2) != 0) goto L11;
        r104 = false;
    L11:
        if ((r103 & 4) == 0) goto L13;
        r101 = false;
    L13:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "initializer");
        b r106 = new b(r105, r104, r101);
        r102.invoke(r106);
        r100.add(r106);
        return;
    L5:
        r105 = false;
        goto L7
    }
}
