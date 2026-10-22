package com.ss.android.lark.coremd.base.parse;

import com.ss.android.lark.coremd.impl.parse.MarkdownThemeImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l {
    public static j b() {
        MarkdownThemeKt$markdownTheme$1 r100 = MarkdownThemeKt$markdownTheme$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "action");
        return a(k.f419543b, r100);
    }

    public static final <T extends com.ss.android.lark.coremd.ext.f> j a(com.ss.android.lark.coremd.ext.h<T> r100, Function2<? super T, ? super j, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "themeProvider");
        Intrinsics.checkNotNullParameter(r101, "action");
        MarkdownThemeImpl r102 = new MarkdownThemeImpl();
        com.ss.android.lark.coremd.ext.g.a(r102, r100, r101);
        return r102;
    }
}
