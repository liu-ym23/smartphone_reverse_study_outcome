package com.bytedance.locallife.biz.collect.guide;

import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedList<p> f256577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile p f256578b;

    static {
        f256577a = new LinkedList();
    }

    public static void b(String r100) {
        Iterator<p> r101 = f256577a.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(r101.next().f256617a, r100) == false) goto L4;
        r101.remove();
        return;
    }

    public static void a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        if (r100 == false) goto L5;
        b(r101);
        p r102 = new p(r101);
        f256578b = r102;
        f256577a.add(r102);
        return;
    L5:
        b(r101);
        LinkedList<p> r103 = f256577a;
        if (r103.isEmpty() == false) goto L8;
        p r104 = null;
    L9:
        f256578b = r104;
        return;
    L8:
        r104 = r103.getLast();
        goto L9
    }
}
