package com.ss.android.lark.coremdbiz.facade.plugins;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class h<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public h() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        LarkThemeExtend.a r100 = LarkThemeExtend.f419998m;
        int r101 = ((Number) r100.b(new EmojiPlugin$configureSpanFactory$1$emojiSize$1(r110))).intValue();
        int r102 = ((Number) r100.b(new EmojiPlugin$configureSpanFactory$1$alignment$1(r110))).intValue();
        Drawable r103 = EmojiHandler.c(((eab.c) r110.f419898d).f471739k, null, null);
        return new com.ss.android.lark.widget.linked_emojicon.base.a(r110.getContext(), r103, ((eab.c) r110.f419898d).f471739k, r101, r102, r101);
    }
}
