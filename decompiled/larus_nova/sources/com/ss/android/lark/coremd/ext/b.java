package com.ss.android.lark.coremd.ext;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static final Object a(Object r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r101, "second");
        int r102 = 0;
        if (r101.length != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return r100;
    L9:
        if ((r100 instanceof a) == false) goto L12;
        ((a) r100).f419618a.addAll(ArraysKt.filterNotNull(r101));
        return r100;
    L12:
        a r104 = new a(r100);
        int r105 = r101.length;
    L13:
        if (r102 >= r105) goto L20;
        Object r106 = r101[r102];
        if ((r106 instanceof a) == false) goto L17;
        r104.f419618a.addAll(((a) r106).f419618a);
    L19:
        r102 = r102 + 1;
        goto L13
    L17:
        if (r106 == null) goto L19;
        r104.f419618a.add(r106);
        goto L19
    L20:
        return r104;
    L5:
        r103 = false;
        goto L6
    }
}
