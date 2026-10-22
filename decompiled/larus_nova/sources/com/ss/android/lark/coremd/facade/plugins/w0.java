package com.ss.android.lark.coremd.facade.plugins;

import android.text.style.ForegroundColorSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class w0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public w0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        LarkThemeExtend.a r101 = LarkThemeExtend.f419998m;
        z9b.b r102 = (z9b.b) r101.b(new IMPhoneNumberPlugin$configureSpanFactory$1$phoneStyleConfig$1(r100));
        if (r102.f571077a == true) goto L5;
        int r103 = ((Number) r101.b(new IMPhoneNumberPlugin$configureSpanFactory$1$colorRes$1(r100))).intValue();
    L10:
        return new ForegroundColorSpan(UIUtils.getColor(r100.getContext(), r103));
    L5:
        if (((Boolean) IMContextExtend.A.b(new IMPhoneNumberPlugin$configureSpanFactory$1$colorRes$applyStyleFromMe$1(r100))).booleanValue() == false) goto L7;
        r103 = r102.f571078b;
        goto L10
    L7:
        r103 = r102.f571079c;
        goto L10
    }
}
