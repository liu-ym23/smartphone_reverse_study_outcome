package com.ss.android.lark.coremdbiz.facade;

import com.ss.android.lark.coremd.base.parse.t;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.q;
import v7b.s;
import v7b.u;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T extends s> implements t {
    public c() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        s r101 = r100.f419902d;
        v7b.a r102 = (v7b.a) ((q) r101).f553568d;
        if ((r102 instanceof u) == false) goto L5;
    L7:
        int r103 = com.ss.android.lark.coremd.utils.d.a(r102);
        v7b.p r104 = (v7b.p) r102;
        if ((r104 instanceof u) == false) goto L11;
        String r105 = com.ss.android.lark.coremd.utils.d.c(com.ss.android.lark.coremd.utils.d.b((u) r102, r100.f419902d), r103) + ' ';
    L14:
        String r106 = StringsKt.repeat(LineContent.FOUR_SPACE, r103);
        r100.f419905g.a();
        r100.f419905g.d(r106 + r105);
        r100.f419904f.c(r100.f419902d);
        return;
    L11:
        if ((r104 instanceof v7b.c) == false) goto L13;
        r105 = "- ";
        goto L14
    L13:
        r105 = "";
        goto L14
    L5:
        if ((r102 instanceof v7b.c) == true) goto L7;
        r100.f419904f.c(r101);
    }
}
