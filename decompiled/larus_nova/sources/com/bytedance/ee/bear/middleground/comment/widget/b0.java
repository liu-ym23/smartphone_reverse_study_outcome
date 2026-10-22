package com.bytedance.ee.bear.middleground.comment.widget;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes18.dex */
public final class b0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public b0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        v7b.s r101 = r100.f419902d;
        String r102 = ((v7b.f) r101).f553551j;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        String r104 = ((v7b.f) r101).f553551j;
        if (r104 == null) goto L9;
        r103 = r104;
    L9:
        com.ss.android.lark.coremd.base.parse.s r105 = r100.f419905g;
        boolean r106 = false;
        if (r102.length() != 0) goto L12;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L16;
        String r108 = "*";
    L17:
        r105.d(r108);
        r100.f419904f.c(r100.f419902d);
        com.ss.android.lark.coremd.base.parse.s r109 = r100.f419905g;
        if (r103.length() != 0) goto L20;
        boolean r110 = true;
    L21:
        if (r110 == true) goto L23;
    L28:
        r109.d(r103);
        return;
    L23:
        if (r102.length() != 0) goto L25;
        r106 = true;
    L25:
        if (r106 == false) goto L27;
        r102 = "*";
    L27:
        r103 = r102;
        goto L28
    L20:
        r110 = false;
        goto L21
    L16:
        r108 = r102;
        goto L17
    L12:
        r107 = false;
        goto L14
    }
}
