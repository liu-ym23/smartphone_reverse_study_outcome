package com.bytedance.ee.larkwebview.networkproxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static final List<com.bytedance.lark.inject_request_android.b> a(List<com.bytedance.lark.inject_request_android.b> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "lowercaseKey");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((com.bytedance.lark.inject_request_android.b) r104).f252944a.toLowerCase(Locale.ROOT), r101) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    public static final void b(List<com.bytedance.lark.inject_request_android.b> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "lowercaseKey");
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((com.bytedance.lark.inject_request_android.b) r104).f252944a.toLowerCase(Locale.ROOT), r101) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        r100.removeAll(r102);
    }
}
