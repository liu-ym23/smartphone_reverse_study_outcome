package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import android.content.Context;
import com.ss.android.lark.chat.core.api.ChatCoreModule;

/* JADX INFO: loaded from: classes35.dex */
public final class Image2StickerHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f412558a;

    public Image2StickerHandler(Context r100) {
        this.f412558a = r100;
    }

    public final void a(String r100, String r101) {
        ChatCoreModule.a().getStickerDependency().saveImage2Stickers(r100, r101, new AnonymousClass1(this));
    }
}
