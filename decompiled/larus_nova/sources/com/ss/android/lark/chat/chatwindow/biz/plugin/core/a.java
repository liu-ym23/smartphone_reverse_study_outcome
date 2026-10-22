package com.ss.android.lark.chat.chatwindow.biz.plugin.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class a extends BaseChatPlugin {
    public a() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final boolean y(i7b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initData");
        return !r100.f488506f.isSecret();
    }
}
