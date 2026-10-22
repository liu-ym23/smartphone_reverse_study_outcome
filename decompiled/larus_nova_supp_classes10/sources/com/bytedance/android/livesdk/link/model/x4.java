package com.bytedance.android.livesdk.link.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x4 {
    public static final List<h7> a(w4 r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$mvpListInfoList");
        ArrayList r0 = new ArrayList();
        if (r8.getUserArmiesList().isEmpty() == false) goto L6;
        return null;
    L6:
        Iterator<T> r9 = r8.getUserArmiesList().iterator();
    L8:
        if (r9.hasNext() == false) goto L14;
        w4.b r1 = (w4.b) r9.next();
        h7 r2 = (h7) vh7.f.c(h7.class);
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r1.getUserArmies().iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        w4.b.InterfaceC0057b r5 = (w4.b.InterfaceC0057b) r4.next();
        h7.b r6 = (h7.b) vh7.f.c(h7.b.class);
        r6.setUserId(r5.getUserId());
        r6.setScore(r5.getScore());
        r6.setNickname(r5.getNickname());
        r6.setAvatar(r5.getAvatar());
        r3.add(r6);
        goto L11
    L13:
        r2.setRankList(r3);
        r0.add(r2);
        goto L8
    L14:
        return r0;
    }
}
