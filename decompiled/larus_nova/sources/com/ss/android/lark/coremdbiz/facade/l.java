package com.ss.android.lark.coremdbiz.facade;

import com.ss.android.lark.coremd.base.parse.t;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkCodeBlockExtend;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class l<T extends s> implements t {
    public l() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        String r101 = com.ss.android.lark.widget.codeblock.entity.a.a((List) LarkCodeBlockExtend.f420011f.b(new PureTextMarkdownParsePlugin$configureVisitor$1$7$content$1(r100)));
        if (StringsKt.isBlank(r101) == false) goto L5;
        r101 = com.ss.android.lark.widget.codeblock.entity.a.b();
    L5:
        com.ss.android.lark.coremd.impl.parse.n r102 = r100.f419905g.a();
        r102.d(r101);
        r102.a();
    }
}
