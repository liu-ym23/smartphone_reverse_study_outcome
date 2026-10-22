package com.bytedance.ee.bear.middleground.comment.widget;

import com.ss.android.lark.widget.span.InlineCodeInfo;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes18.dex */
public final class y<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public y() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        com.ss.android.lark.coremd.base.parse.s r101 = r100.f419905g;
        StringBuilder r102 = new StringBuilder(InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER);
        String r103 = ((v7b.d) r100.f419902d).f553550j;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.append(r103);
        r102.append('`');
        r101.d(r102.toString());
    }
}
