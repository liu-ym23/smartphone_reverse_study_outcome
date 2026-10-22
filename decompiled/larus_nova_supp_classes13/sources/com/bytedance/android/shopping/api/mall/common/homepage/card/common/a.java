package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r12) {
        List r13 = StringsKt.split$default(r12, new String[]{","}, false, 0, 6, null);
        ArrayList r0 = new ArrayList();
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        Object r1 = r14.next();
        if ((!Intrinsics.areEqual("1031", (String) r1)) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        List r15 = CollectionsKt.toMutableList(r0);
        ArrayList r3 = new ArrayList();
        r3.addAll(r15);
        r3.add("1031");
        return CollectionsKt.joinToString$default(r3, ",", null, null, 0, null, null, 62, null);
    }
}
