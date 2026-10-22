package com.ss.android.lark.keyboard.edittext2.mdeditor.plugins;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremd.base.theme.LinkThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes36.dex */
public final class h<T extends s> implements q {
    public h() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(com.ss.android.lark.coremd.impl.parse.i r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        LinkThemeData r101 = k.f419543b.g(r100.getTheme());
        return new g.a(UIUtils.getColor(r100.getContext(), r101.h()));
    }
}
