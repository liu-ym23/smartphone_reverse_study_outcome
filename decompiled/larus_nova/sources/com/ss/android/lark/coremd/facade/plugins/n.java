package com.ss.android.lark.coremd.facade.plugins;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.theme.BlockQuoteThemeData;
import com.ss.android.lark.coremd.span.BlockQuoteSpan;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class n<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public n() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(com.ss.android.lark.coremd.impl.parse.i r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Context r101 = r100.getContext();
        BlockQuoteThemeData r102 = com.ss.android.lark.coremd.base.parse.k.f419543b.b(r100.getTheme());
        return new BlockQuoteSpan(r100.getTheme(), r100.getContext(), UIUtils.dp2px(r101, ((Number) r102.f419550f.getValue(r102, BlockQuoteThemeData.f419547j[2])).intValue()));
    }
}
