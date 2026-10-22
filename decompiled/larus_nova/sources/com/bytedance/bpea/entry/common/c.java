package com.bytedance.bpea.entry.common;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<b> f202198a = null;

    static {
        f202198a = new CopyOnWriteArraySet();
    }

    public static void a(qc4.c r100, Function2 r101) {
        b.a r102 = new b.a("invokeEndSuccess");
        Iterator<b> r103 = f202198a.iterator();
        String r104 = "";
    L3:
        int r105 = 0;
        boolean r106 = false;
    L5:
        if (r103.hasNext() == false) goto L13;
        r102 = r103.next().b();
        if (r102.a() == false) goto L9;
        r104 = r104 + '_' + r102.f202197b;
    L9:
        if (r106 == true) goto L12;
        if (r102.a() == false) goto L3;
    L12:
        r106 = true;
        goto L5
    L13:
        if (r106 == true) goto L15;
        return;
    L15:
        if (r102.a() == true) goto L18;
        r105 = -1;
    L18:
        r101.invoke(Integer.valueOf(r105), r104);
    }
}
