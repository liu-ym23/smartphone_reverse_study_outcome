package com.ss.android.lark.coremd.facade.plugins;

import android.text.style.ForegroundColorSpan;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class y0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public y0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(com.ss.android.lark.coremd.impl.parse.i r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return new ForegroundColorSpan(UIUtils.getColor(r100.getContext(), com.ss.android.lark.coremd.base.parse.k.f419543b.g(r100.getTheme()).h()));
    }
}
