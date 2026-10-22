package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkEmojiThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class i<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public i() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        LarkEmojiThemeData r101 = (LarkEmojiThemeData) LarkThemeExtend.f419998m.b(new EmojiPlugin$configureVisitor$1$showEmoji$1(r100));
        boolean r102 = ((Boolean) r101.f420046d.getValue(r101, LarkEmojiThemeData.f420045g[0])).booleanValue();
        int r103 = r100.f419905g.length();
        String r104 = ((eab.c) r100.f419902d).f471738j;
        r100.f419905g.d(r104);
        if (r102 == false) goto L7;
        com.ss.android.lark.coremd.base.parse.s.a.c(r100.f419905g, r103, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.b(r100.f419905g, r103);
        return;
    }
}
