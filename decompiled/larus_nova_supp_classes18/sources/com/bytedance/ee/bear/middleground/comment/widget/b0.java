package com.bytedance.ee.bear.middleground.comment.widget;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public b0() {
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.k r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        v7b.f r0 = r8.d;
        String r1 = r0.j;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r3 = r0.j;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        com.ss.android.lark.coremd.base.parse.s r4 = r8.g;
        boolean r5 = false;
        if (r1.length() != 0) goto L12;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L16;
        String r7 = "*";
    L17:
        r4.d(r7);
        r8.f.c(r8.d);
        com.ss.android.lark.coremd.base.parse.s r9 = r8.g;
        if (r2.length() != 0) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == true) goto L23;
    L28:
        r9.d(r2);
        return;
    L23:
        if (r1.length() != 0) goto L25;
        r5 = true;
    L25:
        if (r5 == false) goto L27;
        r1 = "*";
    L27:
        r2 = r1;
        goto L28
    L20:
        r10 = false;
        goto L21
    L16:
        r7 = r1;
        goto L17
    L12:
        r6 = false;
        goto L14
    }
}
