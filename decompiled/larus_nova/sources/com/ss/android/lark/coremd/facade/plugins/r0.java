package com.ss.android.lark.coremd.facade.plugins;

import android.content.Context;
import android.text.style.ForegroundColorSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class r0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public r0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        z9b.a r101 = (z9b.a) LarkThemeExtend.f419998m.b(new IMLinkPlugin$configureSpanFactory$1$linkStyleConfig$1(r100));
        if (r101.f571074a == false) goto L10;
        boolean r102 = ((Boolean) IMContextExtend.A.b(new IMLinkPlugin$configureSpanFactory$1$applyStyleFromMe$1(r100))).booleanValue();
        Context r103 = r100.getContext();
        if (r102 == false) goto L7;
        int r104 = r101.f571075b;
    L11:
        return new ForegroundColorSpan(UIUtils.getColor(r103, r104));
    L7:
        r104 = r101.f571076c;
        goto L11
    L10:
        return new ForegroundColorSpan(UIUtils.getColor(r100.getContext(), com.ss.android.lark.coremd.base.parse.k.f419543b.g(r100.getTheme()).h()));
    }
}
