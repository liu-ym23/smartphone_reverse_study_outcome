package com.ss.android.lark.coremdbiz.facade.plugins;

import android.text.style.ForegroundColorSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class w<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public w() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = ((Number) LarkThemeExtend.f419998m.b(new PhoneNumberPlugin$configureSpanFactory$1$colorRes$1(r100))).intValue();
        return new ForegroundColorSpan(UIUtils.getColor(r100.getContext(), r101));
    }
}
