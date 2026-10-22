package com.ss.android.lark.keyboard.edittext2.mdeditor.plugins;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes36.dex */
public final class d<T extends s> implements q {
    public d() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = ((Number) LarkThemeExtend.f419998m.b(new EditorAtUserGroupPlugin$configureSpanFactory$1$colorRes$1(r100))).intValue();
        return new c.a(UIUtils.getColor(r100.getContext(), r101));
    }
}
